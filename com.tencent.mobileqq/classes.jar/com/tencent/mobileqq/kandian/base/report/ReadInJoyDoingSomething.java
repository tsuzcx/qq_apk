package com.tencent.mobileqq.kandian.base.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import org.w3c.dom.Node;

@Deprecated
public class ReadInJoyDoingSomething
{
  private static String READINJOY_REPORT_MANY_APPS_KEY = "read_in_joy_report_many_apps_key";
  private static String READINJOY_REPORT_MANY_APPS_LAST_SCAN_DATE_KEY = "read_in_joy_report_many_apps_last_scan_date_key";
  private static String REPORT_TAG_NAME_FOR_INSTALLED = "actKandianReportInstalledApps";
  private static String REPORT_TAG_NAME_FOR_USED = "actKandianReportUsedApps";
  private static final long SCAN_PATH_MAX_TIME = 10000L;
  private static List<AppConfigInfo> appConfigInfoList;
  private static ConcurrentHashMap<String, String> appVersionList;
  private static String dateNow;
  private static String lastScanDate;
  private static long scanBeginTime;
  private static String[] usedPaths = { "cache", "databases", "files", "lib", "shared_prefs" };
  
  private static boolean checkIsReportDataIsEnough(List<AppReportData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (TextUtils.isEmpty(lastScanDate)) {
        return false;
      }
      try
      {
        Object localObject = new SimpleDateFormat("yyyy.MM.dd");
        Date localDate = new Date();
        localObject = ((DateFormat)localObject).parse(lastScanDate);
        long l1 = localDate.getTime();
        long l2 = ((Date)localObject).getTime();
        l1 = TimeUnit.DAYS.convert(l1 - l2, TimeUnit.MILLISECONDS);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "list size = ", Integer.valueOf(paramList.size()), ", day = ", Long.valueOf(l1 + 1L) });
        }
        int i = paramList.size();
        if (i >= l1 + 1L) {
          return true;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        QLog.d("ReadInJoyDoingSomething", 1, "checkIsReportDataIsEnough throw a throwable.");
      }
    }
    return false;
  }
  
  public static void clear()
  {
    Object localObject = appConfigInfoList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = appVersionList;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).clear();
    }
  }
  
  private static String getAppVersion(String paramString)
  {
    try
    {
      paramString = PackageUtil.a(BaseApplicationImpl.getContext(), paramString);
      if (paramString != null)
      {
        paramString = paramString.versionName;
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getAppVersion], e = ");
      localStringBuilder.append(paramString);
      QLog.i("ReadInJoyDoingSomething", 1, localStringBuilder.toString());
    }
    return "null";
  }
  
  public static AppConfigInfoList getConfig(AppRuntime paramAppRuntime)
  {
    if (RIJSPUtils.a(paramAppRuntime, true, true) == null)
    {
      QLog.d("ReadInJoyDoingSomething", 1, "getReadInJoySP failed, can not get config.");
      return null;
    }
    Object localObject = RIJSPUtils.a(paramAppRuntime, READINJOY_REPORT_MANY_APPS_KEY, true);
    if (QLog.isColorLevel())
    {
      if (localObject != null) {
        paramAppRuntime = localObject.toString();
      } else {
        paramAppRuntime = "null";
      }
      QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "config: \n", paramAppRuntime });
    }
    return (AppConfigInfoList)localObject;
  }
  
  private static String getLastScanDate()
  {
    Object localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, true);
    if (localObject == null)
    {
      QLog.d("ReadInJoyDoingSomething", 1, "getLastScanDate failed, can not get config.");
      return "";
    }
    localObject = ((SharedPreferences)localObject).getString(READINJOY_REPORT_MANY_APPS_LAST_SCAN_DATE_KEY, "");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "lastScanDate = ", localObject });
    }
    return localObject;
  }
  
  private static String getPathFromAppConfigInfo(AppConfigInfo paramAppConfigInfo)
  {
    if (paramAppConfigInfo == null)
    {
      QLog.d("ReadInJoyDoingSomething", 1, "configInfo is null.");
      return "";
    }
    if (paramAppConfigInfo.isAbsolutePath)
    {
      paramAppConfigInfo = paramAppConfigInfo.appPath;
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append("/Android");
      localStringBuilder.append(Environment.getDataDirectory());
      localStringBuilder.append("/");
      localStringBuilder.append(paramAppConfigInfo.appPackageName);
      localStringBuilder.append(paramAppConfigInfo.appPath);
      paramAppConfigInfo = localStringBuilder.toString();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "path = ", paramAppConfigInfo });
    }
    return paramAppConfigInfo;
  }
  
  private static AppReportData getReportData(AppConfigInfo paramAppConfigInfo)
  {
    AppReportData localAppReportData = new AppReportData();
    if (paramAppConfigInfo == null)
    {
      QLog.d("ReadInJoyDoingSomething", 1, "getReportData configInfo is null.");
      return localAppReportData;
    }
    localAppReportData.appCode = paramAppConfigInfo.appCode;
    localAppReportData.appVersion = getAppVersion(paramAppConfigInfo.appPackageName);
    return localAppReportData;
  }
  
  private static List<AppReportData> getReportDataList(AppConfigInfo paramAppConfigInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramAppConfigInfo == null)
    {
      QLog.d("ReadInJoyDoingSomething", 2, "getReportDataList configInfo is null.");
      return localArrayList;
    }
    String str = getPathFromAppConfigInfo(paramAppConfigInfo);
    if (!TextUtils.isEmpty(str))
    {
      scanBeginTime = System.currentTimeMillis();
      scanPath(str, localArrayList, paramAppConfigInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "getReportDataList, totalScanTime = ", Long.valueOf(System.currentTimeMillis() - scanBeginTime), " ms." });
      }
    }
    return localArrayList;
  }
  
  private static boolean isContainSameDate(String paramString, List<AppReportData> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      if (paramList.size() <= 0) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (paramString.equals(((AppReportData)paramList.next()).appUsedDate)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void parseConfigToSP(Node paramNode)
  {
    if (paramNode == null)
    {
      QLog.d("ReadInJoyDoingSomething", 1, "config node is null or empty, no need to parse.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDoingSomething", 2, "parseConfigToSP.");
    }
    try
    {
      AppConfigInfoList localAppConfigInfoList = new AppConfigInfoList();
      for (paramNode = paramNode.getFirstChild(); paramNode != null; paramNode = paramNode.getNextSibling()) {
        if (paramNode.getNodeName().equals("appLists")) {
          for (Node localNode1 = paramNode.getFirstChild(); localNode1 != null; localNode1 = localNode1.getNextSibling())
          {
            AppConfigInfo localAppConfigInfo = new AppConfigInfo();
            for (Node localNode2 = localNode1.getFirstChild(); localNode2 != null; localNode2 = localNode2.getNextSibling()) {
              if (localNode2.getNodeType() == 1)
              {
                String str1 = localNode2.getNodeName();
                String str2 = localNode2.getFirstChild().getNodeValue();
                if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
                  if (str1.equals("appCode")) {
                    localAppConfigInfo.appCode = str2;
                  } else if (str1.equals("appName")) {
                    localAppConfigInfo.appName = str2;
                  } else if (str1.equals("appPackageName")) {
                    localAppConfigInfo.appPackageName = str2;
                  } else if (str1.equals("appPath")) {
                    localAppConfigInfo.appPath = str2;
                  } else if (str1.equals("isAbsolutePath")) {
                    localAppConfigInfo.isAbsolutePath = str2.equals("1");
                  }
                }
              }
            }
            if (!TextUtils.isEmpty(localAppConfigInfo.appCode))
            {
              localAppConfigInfoList.list.add(localAppConfigInfo);
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "appConfigInfo = ", localAppConfigInfo.toString() });
              }
            }
          }
        }
      }
      updateConfig(RIJQQAppInterfaceUtil.a(), localAppConfigInfoList);
      return;
    }
    catch (Throwable paramNode)
    {
      paramNode.printStackTrace();
      QLog.d("ReadInJoyDoingSomething", 1, "parseConfigToSP failed, throw a throwable.");
    }
  }
  
  private static void reportData(List<AppReportData> paramList, String paramString)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < paramList.size())
      {
        AppReportData localAppReportData = (AppReportData)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "tagName = ", paramString, ", reportDataList [ ", Integer.valueOf(i), " ] : \n", localAppReportData.toString(), "uin = ", RIJQQAppInterfaceUtil.a(), "\n" });
        }
        localHashMap.clear();
        localHashMap.put("appCode", localAppReportData.appCode);
        localHashMap.put("appVersion", localAppReportData.appVersion);
        localHashMap.put("appUsedDate", localAppReportData.appUsedDate);
        localHashMap.put("uin", RIJQQAppInterfaceUtil.a());
        StatisticCollector.getInstance(RIJQQAppInterfaceUtil.a().getApplication()).collectPerformance(RIJQQAppInterfaceUtil.a(), paramString, true, 1L, 0L, localHashMap, null, false);
        i += 1;
      }
      return;
    }
    QLog.d("ReadInJoyDoingSomething", 1, "reportData but list is null or empty.");
  }
  
  private static void reportInstalledApps(AppConfigInfo paramAppConfigInfo)
  {
    AppReportData localAppReportData = getReportData(paramAppConfigInfo);
    if ((paramAppConfigInfo != null) && (!TextUtils.isEmpty(paramAppConfigInfo.appPackageName)) && (PackageUtil.a(BaseApplicationImpl.getContext(), paramAppConfigInfo.appPackageName)))
    {
      if (TextUtils.isEmpty(dateNow))
      {
        paramAppConfigInfo = new Date();
        dateNow = new SimpleDateFormat("yyyy.MM.dd").format(paramAppConfigInfo);
      }
      paramAppConfigInfo = new HashMap();
      paramAppConfigInfo.put("appCode", localAppReportData.appCode);
      paramAppConfigInfo.put("appVersion", localAppReportData.appVersion);
      paramAppConfigInfo.put("appScanDate", dateNow);
      paramAppConfigInfo.put("uin", RIJQQAppInterfaceUtil.a());
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "tagName = ", REPORT_TAG_NAME_FOR_INSTALLED, "\n", "reportData = \n", localAppReportData.toString(), "uin = ", RIJQQAppInterfaceUtil.a(), "\n", "appScanDate = ", dateNow, "\n" });
      }
      StatisticCollector.getInstance(RIJQQAppInterfaceUtil.a().getApplication()).collectPerformance(RIJQQAppInterfaceUtil.a(), REPORT_TAG_NAME_FOR_INSTALLED, true, 1L, 0L, paramAppConfigInfo, null, false);
      return;
    }
    if (QLog.isColorLevel())
    {
      if (localAppReportData != null) {
        paramAppConfigInfo = localAppReportData.toString();
      } else {
        paramAppConfigInfo = "null";
      }
      QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "user do not install this app or reportData is null, reportData = ", paramAppConfigInfo });
    }
  }
  
  public static void reportManyAppsData()
  {
    try
    {
      Object localObject = getConfig(RIJQQAppInterfaceUtil.a());
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDoingSomething", 2, "config is null, no need to report.");
        }
      }
      else
      {
        lastScanDate = getLastScanDate();
        appConfigInfoList = ((AppConfigInfoList)localObject).list;
        localObject = appConfigInfoList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AppConfigInfo localAppConfigInfo = (AppConfigInfo)((Iterator)localObject).next();
          reportInstalledApps(localAppConfigInfo);
          reportData(getReportDataList(localAppConfigInfo), "actKandianReportManyApps");
          reportUsedApps(localAppConfigInfo);
        }
        setLastScanDate();
        clear();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.d("ReadInJoyDoingSomething", 1, "reportManyAppsData throwable, so sad.");
      return;
    }
  }
  
  private static void reportUsedApps(AppConfigInfo paramAppConfigInfo)
  {
    Object localObject1 = getReportData(paramAppConfigInfo);
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppReportData)localObject1).appVersion)))
    {
      localObject1 = new ArrayList();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
      int i = 0;
      while (i < usedPaths.length)
      {
        Object localObject2 = new StringBuilder("/data/data/");
        ((StringBuilder)localObject2).append(paramAppConfigInfo.appPackageName);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(usedPaths[i]);
        try
        {
          Object localObject3 = new File(((StringBuilder)localObject2).toString());
          if (((File)localObject3).exists())
          {
            localObject3 = localSimpleDateFormat.format(new Date(((File)localObject3).lastModified()));
            QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "reportUsedApps path = ", localObject2, ", app = ", paramAppConfigInfo.appPackageName, ", lastModifiedDate = ", localObject3, ", lastScan = ", lastScanDate });
            if (((TextUtils.isEmpty(lastScanDate)) || (((String)localObject3).compareTo(lastScanDate) >= 0)) && (!isContainSameDate((String)localObject3, (List)localObject1)))
            {
              localObject2 = getReportData(paramAppConfigInfo);
              ((AppReportData)localObject2).appUsedDate = ((String)localObject3);
              ((List)localObject1).add(localObject2);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          QLog.d("ReadInJoyDoingSomething", 1, "reportUsedApps throw Throwable.");
        }
        i += 1;
      }
      reportData((List)localObject1, REPORT_TAG_NAME_FOR_USED);
      return;
    }
    if (QLog.isColorLevel())
    {
      if (localObject1 != null) {
        paramAppConfigInfo = ((AppReportData)localObject1).toString();
      } else {
        paramAppConfigInfo = "null";
      }
      QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "user do not install this app or reportData is null, reportData = ", paramAppConfigInfo });
    }
  }
  
  private static void scanPath(String paramString, List<AppReportData> paramList, AppConfigInfo paramAppConfigInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      if (System.currentTimeMillis() - scanBeginTime > 10000L)
      {
        QLog.d("ReadInJoyDoingSomething", 1, "scan one path more than one minute, it is time to stop");
        return;
      }
      if (checkIsReportDataIsEnough(paramList))
      {
        QLog.d("ReadInJoyDoingSomething", 1, "report data is enough, no need to scan any more.");
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new File(paramString).listFiles();
        boolean bool = QLog.isColorLevel();
        int j = 0;
        if (bool)
        {
          if (paramString == null) {
            break label307;
          }
          i = paramString.length;
          QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "files number = ", Integer.valueOf(i) });
        }
        if (paramString != null)
        {
          int k = paramString.length;
          i = j;
          if (i < k)
          {
            Object localObject1 = paramString[i];
            if (System.currentTimeMillis() - scanBeginTime > 10000L)
            {
              QLog.d("ReadInJoyDoingSomething", 1, "scan one path more than one minute, it is time to stop");
              return;
            }
            Object localObject2 = new Date(localObject1.lastModified());
            localObject2 = new SimpleDateFormat("yyyy.MM.dd").format((Date)localObject2);
            if (((TextUtils.isEmpty(lastScanDate)) || (((String)localObject2).compareTo(lastScanDate) >= 0)) && (!isContainSameDate((String)localObject2, paramList)))
            {
              AppReportData localAppReportData = getReportData(paramAppConfigInfo);
              localAppReportData.appUsedDate = ((String)localObject2);
              paramList.add(localAppReportData);
              if (checkIsReportDataIsEnough(paramList))
              {
                QLog.d("ReadInJoyDoingSomething", 1, "report data is enough, no need to scan any more.");
                return;
              }
            }
            if (localObject1.isDirectory()) {
              scanPath(localObject1.getPath(), paramList, paramAppConfigInfo);
            }
            i += 1;
            continue;
          }
        }
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        QLog.d("ReadInJoyDoingSomething", 1, "scanPath throw Throwable.");
      }
      QLog.d("ReadInJoyDoingSomething", 1, "path or list is null, no need to scan.");
      return;
      label307:
      int i = 0;
    }
  }
  
  private static void setLastScanDate()
  {
    Object localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, true);
    if (localObject == null)
    {
      QLog.d("ReadInJoyDoingSomething", 1, "setLastScanDate failed, can not get config.");
      return;
    }
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(READINJOY_REPORT_MANY_APPS_LAST_SCAN_DATE_KEY, localSimpleDateFormat.format(localDate));
    RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void updateConfig(AppRuntime paramAppRuntime, AppConfigInfoList paramAppConfigInfoList)
  {
    if (RIJSPUtils.a(paramAppRuntime, true, true) == null)
    {
      QLog.d("ReadInJoyDoingSomething", 1, "getReadInJoySP failed, can not update config.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDoingSomething", 2, new Object[] { "updateConfig, appConfigInfoList = ", paramAppConfigInfoList.toString() });
    }
    RIJSPUtils.a(READINJOY_REPORT_MANY_APPS_KEY, paramAppConfigInfoList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.ReadInJoyDoingSomething
 * JD-Core Version:    0.7.0.1
 */