package cooperation.qzone.report.lp;

import amyt;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.MTAReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import common.config.service.QzoneAlphaConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleConfigManager;
import cooperation.qzone.networkedmodule.QzoneModuleConfigManager.QzoneModuleRecord;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.NetworkState;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class MachineLearingSmartReport
{
  public static final String ARGS = "args";
  public static final String BATCH_ID = "batchid";
  public static final String CHANNEL = "channel";
  public static final int CHANNEL_BEACON = 2;
  public static final int CHANNEL_LP = 0;
  public static final int CHANNEL_MTA = 1;
  public static final String CMD_REPORT = "cmd";
  public static final long DEFAULT_FREQUENCY = 3600000L;
  public static final int ERROR_BATCHID = 6;
  public static final int ERROR_CHANNEL = 5;
  public static final int ERROR_DECODE = 7;
  public static final int ERROR_MODULE_DOWNLOAD = 10;
  public static final int ERROR_MODULE_MAINCLASS_NULL = 11;
  public static final int ERROR_MODULE_METHOD_NULL = 12;
  public static final int ERROR_MODULE_REFLECT = 13;
  public static final int ERROR_MOUDLEID_NULL = 8;
  public static final int ERROR_MOUDLERECORD_NULL = 9;
  public static final int ERROR_NETWORKTYPE = 3;
  public static final int ERROR_PARSECONFIG = 14;
  public static final int ERROR_QUA = 1;
  public static final int ERROR_QUERYTIMRS_NULL = 15;
  public static final int ERROR_SQL = 4;
  public static final int ERROR_TIMEEXPIRED = 2;
  public static final String FAIL_CODE = "param_FailCode";
  public static final String FREQUENCY = "frequency";
  public static final String ID_HOLDER = "[lastqueryid]";
  public static final String MODULEMETHOD = "modulemethod";
  public static final String MOUDLEID = "moduleid";
  public static final String NETMASK = "networkmask";
  public static final String NUM = "batchnum";
  public static final String PARAM_SEPARATOR = ":";
  public static final String QUA = "versioncode";
  public static final String QUERYTIMES = "querytimes";
  public static final int REPORT_SWITCH_OPEN = 0;
  public static final String SELECTION = "selection";
  public static final String SP_FIRST_QUERY_TIMES = "smartreport_firstreport_time";
  public static final String SP_LAST_QUERY_ID = "smartreport_lastreport_id";
  public static final String SP_LAST_QUERY_TIME = "smartreport_lastreport_time";
  public static final String SP_QUERY_TIIMES = "smartreport_times";
  public static final String TAG = "MachineLearingSmartReport";
  public static final String UIN_HOLDER = "[uin]";
  public static final String VALID_RALATIVE_TIME = "expiredrelativetime";
  public static final String VALID_TIME = "expiredAbsolutetime";
  private static MachineLearingSmartReport lpReportManager;
  private String[] argArray;
  private int batch_id;
  private int nums = 50;
  private int report_channel;
  private String report_cmd;
  private String selection;
  private LpReportInfos storedClicks = new LpReportInfos();
  
  private boolean BeaconReport(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HashMap localHashMap = (HashMap)paramArrayList.next();
      if (localHashMap != null) {
        StatisticCollector.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.report_cmd, true, 0L, 0L, localHashMap, null, true);
      }
    }
    return true;
  }
  
  private void LPReport()
  {
    if (this.storedClicks.isEmpty()) {
      return;
    }
    synchronized (this.storedClicks)
    {
      ArrayList localArrayList = this.storedClicks.getInfos();
      this.storedClicks.clear();
      ??? = new LpReportNewIntent(BaseApplicationImpl.getContext(), LpReportServlet.class);
      ((LpReportNewIntent)???).type = 33L;
      ((LpReportNewIntent)???).info = null;
      ((LpReportNewIntent)???).extra_info = null;
      ((LpReportNewIntent)???).multi_info = localArrayList;
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)???);
      return;
    }
  }
  
  private boolean LPReport(ArrayList paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      Object localObject = (HashMap)paramArrayList.get(i);
      if (localObject != null)
      {
        localObject = new LpReport_Smart_dc02363(this.batch_id, ((HashMap)localObject).toString());
        this.storedClicks.addInfo(26, (LpReportInfo)localObject);
        if ((i + 1) % this.nums == 0) {
          LPReport();
        }
      }
      i += 1;
    }
    if (!this.storedClicks.isEmpty()) {
      LPReport();
    }
    return true;
  }
  
  private boolean MTAReport(ArrayList paramArrayList)
  {
    Properties localProperties = new Properties();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HashMap localHashMap = (HashMap)paramArrayList.next();
      if (localHashMap != null)
      {
        localProperties.clear();
        localProperties.putAll(localHashMap);
        MTAReportController.a(BaseApplicationImpl.getContext()).reportKVEvent(this.report_cmd, localProperties);
      }
    }
    return true;
  }
  
  private boolean checkAbsoluteTime(Map paramMap)
  {
    paramMap = (String)paramMap.get("expiredAbsolutetime");
    if (!TextUtils.isEmpty(paramMap)) {
      try
      {
        long l1 = Long.parseLong(paramMap);
        long l2 = System.currentTimeMillis();
        return l2 < l1;
      }
      catch (Exception paramMap)
      {
        QLog.e("MachineLearingSmartReport", 1, paramMap, new Object[0]);
        exceptionReport(2, "this config expiredtime parse error");
        return false;
      }
    }
    exceptionReport(2, "this config expiredtime null error");
    return false;
  }
  
  private boolean checkBatchId(Map paramMap)
  {
    if (paramMap.containsKey("batchid")) {
      try
      {
        this.batch_id = Integer.parseInt((String)paramMap.get("batchid"));
        return true;
      }
      catch (Exception paramMap)
      {
        QLog.e("MachineLearingSmartReport", 1, paramMap, new Object[0]);
        return false;
      }
    }
    QLog.e("MachineLearingSmartReport", 1, "batchid null error");
    return false;
  }
  
  private boolean checkChannel(Map paramMap)
  {
    if (paramMap.containsKey("channel")) {}
    label89:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            this.report_channel = Integer.parseInt((String)paramMap.get("channel"));
            if (this.report_channel != 0) {
              break;
            }
            if (!paramMap.containsKey("batchnum")) {
              break label89;
            }
            this.nums = Integer.parseInt((String)paramMap.get("batchnum"));
            return true;
          }
          catch (Exception paramMap)
          {
            QLog.e("MachineLearingSmartReport", 1, paramMap, new Object[0]);
            return false;
          }
          this.report_channel = 0;
          continue;
          this.nums = 50;
        }
        if (this.report_channel != 1) {
          break;
        }
        this.report_cmd = ((String)paramMap.get("cmd"));
      } while (!TextUtils.isEmpty(this.report_cmd));
      QLog.e("MachineLearingSmartReport", 1, "cmd_mta null error");
      return false;
      if (this.report_channel != 2) {
        break;
      }
      this.report_cmd = ((String)paramMap.get("cmd"));
    } while (!TextUtils.isEmpty(this.report_cmd));
    QLog.e("MachineLearingSmartReport", 1, "cmd_beacon null error");
    return false;
    QLog.e("MachineLearingSmartReport", 1, "report_channel error");
    return false;
  }
  
  private boolean checkFrequency(Map paramMap)
  {
    if (paramMap.containsKey("frequency")) {}
    long l1;
    for (;;)
    {
      try
      {
        l1 = Long.parseLong((String)paramMap.get("frequency"));
        if (l1 != 0L) {
          break;
        }
        return true;
      }
      catch (Exception paramMap)
      {
        QLog.e("MachineLearingSmartReport", 1, paramMap, new Object[0]);
        return false;
      }
      l1 = 3600000L;
    }
    if (l1 > 0L)
    {
      long l2 = getInstance().getLastQueryTime();
      if (System.currentTimeMillis() - l2 > l1)
      {
        updateLastQueryTime();
        return true;
      }
      return false;
    }
    QLog.e("MachineLearingSmartReport", 1, "Frequency error");
    return false;
  }
  
  private boolean checkNetworkEnabled(Map paramMap)
  {
    if (paramMap.containsKey("networkmask"))
    {
      try
      {
        int i = Integer.parseInt((String)paramMap.get("networkmask"));
        if ((i & 1 << NetworkState.getNetworkType()) != 0) {
          return true;
        }
      }
      catch (Exception paramMap)
      {
        QLog.e("MachineLearingSmartReport", 1, paramMap, new Object[0]);
        return false;
      }
      return false;
    }
    return true;
  }
  
  private boolean checkQUA(Map paramMap)
  {
    int m;
    int i;
    int k;
    do
    {
      int j;
      try
      {
        paramMap = (String)paramMap.get("versioncode");
        if (TextUtils.isEmpty(paramMap)) {
          return false;
        }
        m = getVersionCode(BaseApplicationImpl.getContext());
        if (m == 0)
        {
          QLog.w("MachineLearingSmartReport", 2, "get localVersionCode error");
          return false;
        }
        paramMap = paramMap.split(":");
        if (paramMap.length == 1)
        {
          i = Integer.parseInt(paramMap[0]);
          if (m == i) {
            return true;
          }
          QLog.w("MachineLearingSmartReport", 2, "localVersionCode:" + m + " remoteVersionCode:" + i);
          return false;
        }
        if (paramMap.length == 2)
        {
          j = Integer.parseInt(paramMap[0]);
          i = Integer.parseInt(paramMap[1]);
          if (j > i)
          {
            k = j;
            continue;
            QLog.w("MachineLearingSmartReport", 2, "localVersionCode:" + m);
            return false;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Exception paramMap)
      {
        QLog.e("MachineLearingSmartReport", 1, paramMap, new Object[0]);
        return false;
      }
      k = i;
      i = j;
    } while ((i > m) || (m > k));
    return true;
  }
  
  private boolean checkQueryTimes(Map paramMap)
  {
    if (paramMap.containsKey("querytimes")) {
      try
      {
        int i = Integer.parseInt((String)paramMap.get("querytimes"));
        int j = getQueryTimes();
        if (i > j) {
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.i("MachineLearingSmartReport", 2, "queryTimes:" + i + " currnetQueryTimes:" + j);
        }
        return false;
      }
      catch (Exception paramMap)
      {
        QLog.e("MachineLearingSmartReport", 1, paramMap, new Object[0]);
        exceptionReport(15, "querytimes decode error");
        return false;
      }
    }
    exceptionReport(15, "querytimes null error");
    return false;
  }
  
  private boolean checkRelativeTime(Map paramMap)
  {
    paramMap = (String)paramMap.get("expiredrelativetime");
    if (!TextUtils.isEmpty(paramMap))
    {
      long l1 = getFirstQueryTime();
      if (l1 == 0L)
      {
        updateFirstQueryTime();
        return true;
      }
      try
      {
        long l2 = Long.parseLong(paramMap);
        if (System.currentTimeMillis() - l1 < l2) {
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.w("MachineLearingSmartReport", 2, "System.currentTimeMillis() - firstQueryTime < deadLine");
        }
        return false;
      }
      catch (Exception paramMap)
      {
        QLog.e("MachineLearingSmartReport", 1, paramMap, new Object[0]);
        exceptionReport(2, "this config expiredtime parse error");
        return false;
      }
    }
    return true;
  }
  
  private boolean checkSQLValid(Map paramMap)
  {
    if (paramMap.containsKey("selection"))
    {
      this.selection = ((String)paramMap.get("selection"));
      if (TextUtils.isEmpty(this.selection))
      {
        QLog.e("MachineLearingSmartReport", 1, "cmd selection null");
        return false;
      }
      try
      {
        this.selection = new String(Base64.decode(this.selection, 0), "utf-8");
        if ((this.selection.trim().toLowerCase().startsWith("select")) || (this.selection.trim().toLowerCase().startsWith("delete"))) {
          break label141;
        }
        QLog.e("MachineLearingSmartReport", 1, "selection error");
        return false;
      }
      catch (Exception paramMap)
      {
        QLog.e("MachineLearingSmartReport", 1, "selection decode error");
        return false;
      }
    }
    else
    {
      QLog.e("MachineLearingSmartReport", 1, "selection null error");
      return false;
    }
    label141:
    if (!TextUtils.isEmpty((String)paramMap.get("args"))) {}
    for (;;)
    {
      try
      {
        paramMap = new String(Base64.decode((String)paramMap.get("args"), 0), "utf-8");
        if (paramMap.contains("[lastqueryid]")) {
          paramMap.replaceAll("[lastqueryid]", String.valueOf(getLastQueryId()));
        }
        if (paramMap.contains("[uin]"))
        {
          if ((BaseApplicationImpl.getApplication() == null) || (BaseApplicationImpl.getApplication().getRuntime() == null)) {
            break label291;
          }
          String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          if (!TextUtils.isEmpty(str)) {
            paramMap.replaceAll("[uin]", str);
          }
        }
        else
        {
          this.argArray = paramMap.split(":");
          return true;
        }
      }
      catch (Exception paramMap)
      {
        QLog.e("MachineLearingSmartReport", 1, "args decode error");
        return false;
      }
      QLog.e("MachineLearingSmartReport", 1, "get uin error");
      return false;
      label291:
      QLog.e("MachineLearingSmartReport", 1, "get uin error");
      return false;
      this.argArray = null;
    }
  }
  
  private void exceptionReport(int paramInt, String paramString)
  {
    if (paramInt > 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      localHashMap.put("param_FailMsg", paramString);
      StatisticCollector.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "qzonesmartreport", true, 0L, 0L, localHashMap, null, true);
      if ((!TextUtils.isEmpty(paramString)) && (QLog.isColorLevel())) {
        QLog.w("MachineLearingSmartReport", 2, paramString);
      }
    }
  }
  
  private Map getArguments(String paramString)
  {
    localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, paramString.getString(str));
        }
        return localHashMap;
      }
      catch (Exception paramString)
      {
        exceptionReport(14, "parse config error");
      }
    }
  }
  
  private long getFirstQueryTime()
  {
    long l2 = 0L;
    long l1 = l2;
    if (BaseApplicationImpl.getApplication() != null)
    {
      l1 = l2;
      if (BaseApplicationImpl.getApplication().getRuntime() != null) {
        l1 = LocalMultiProcConfig.getLong4Uin("smartreport_firstreport_time" + this.batch_id, 0L, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      }
    }
    return l1;
  }
  
  public static MachineLearingSmartReport getInstance()
  {
    if (lpReportManager == null) {}
    try
    {
      if (lpReportManager == null) {
        lpReportManager = new MachineLearingSmartReport();
      }
      return lpReportManager;
    }
    finally {}
  }
  
  private long getLastQueryId()
  {
    long l2 = 0L;
    long l1 = l2;
    if (BaseApplicationImpl.getApplication() != null)
    {
      l1 = l2;
      if (BaseApplicationImpl.getApplication().getRuntime() != null) {
        l1 = LocalMultiProcConfig.getLong4Uin("smartreport_lastreport_id" + this.batch_id, 0L, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      }
    }
    return l1;
  }
  
  private long getLastQueryTime()
  {
    long l2 = 0L;
    long l1 = l2;
    if (BaseApplicationImpl.getApplication() != null)
    {
      l1 = l2;
      if (BaseApplicationImpl.getApplication().getRuntime() != null) {
        l1 = LocalMultiProcConfig.getLong4Uin("smartreport_lastreport_time" + this.batch_id, 0L, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      }
    }
    return l1;
  }
  
  private int getQueryTimes()
  {
    int j = 0;
    int i = j;
    if (BaseApplicationImpl.getApplication() != null)
    {
      i = j;
      if (BaseApplicationImpl.getApplication().getRuntime() != null) {
        i = LocalMultiProcConfig.getInt4Uin("smartreport_times" + this.batch_id, 0, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      }
    }
    return i;
  }
  
  public static int getVersionCode(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      QLog.e("MachineLearingSmartReport", 1, paramContext, new Object[0]);
    }
    return 0;
  }
  
  private void loadModule(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MachineLearingSmartReport", 2, "loadModule");
    }
    String str = QzoneModuleManager.getInstance().getModuleFilePath(paramString1);
    if (QLog.isColorLevel()) {
      QLog.i("MachineLearingSmartReport", 2, "ModulePath=" + str);
    }
    if (QzoneModuleManager.getInstance().loadModule(paramString1, getClass().getClassLoader(), false, false))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MachineLearingSmartReport", 2, "loadModule success");
      }
      startDataAcquisition(paramString3, paramString2);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("MachineLearingSmartReport", 2, "loadModule fail");
  }
  
  private void startDataAcquisition(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Class.forName(paramString1);
      paramString1.getMethod(paramString2, new Class[0]).invoke(paramString1.newInstance(), new Object[0]);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("MachineLearingSmartReport", 1, paramString1, new Object[0]);
      exceptionReport(13, paramString1.getMessage());
    }
  }
  
  private void updateFirstQueryTime()
  {
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      LocalMultiProcConfig.putLong4Uin("smartreport_firstreport_time" + this.batch_id, System.currentTimeMillis(), BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    }
  }
  
  private void updateLastQueryTime()
  {
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      LocalMultiProcConfig.putLong4Uin("smartreport_lastreport_time" + this.batch_id, System.currentTimeMillis(), BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    }
  }
  
  public void downloadDataAcquisitionModule()
  {
    String str1 = QzoneAlphaConfig.a().a("ClientReport", "SmartReportDataAcquisitionConfig", "");
    Object localObject1;
    String str2;
    Object localObject2;
    if (!TextUtils.isEmpty(str1))
    {
      try
      {
        localObject1 = URLUtil.b(str1);
        if (!checkAbsoluteTime((Map)localObject1))
        {
          exceptionReport(2, "downloadDataAcquisitionModule is out of date");
          return;
        }
        if (!checkQUA((Map)localObject1))
        {
          exceptionReport(1, "downloadDataAcquisitionModule qua is error");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MachineLearingSmartReport", 1, localException, new Object[0]);
        exceptionReport(7, "ModuleConfig decode error");
        return;
      }
      if (!checkNetworkEnabled((Map)localObject1))
      {
        exceptionReport(3, "downloadDataAcquisitionModule network error");
        return;
      }
      str2 = (String)((Map)localObject1).get("moduleid");
      if (TextUtils.isEmpty(str2))
      {
        exceptionReport(8, "downloadDataAcquisitionModule moudleid is error");
        return;
      }
      localObject1 = (String)((Map)localObject1).get("modulemethod");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        exceptionReport(12, "downloadDataAcquisitionModule moudlemethod is null");
        return;
      }
      localObject2 = QzoneModuleConfigManager.a().a(str2);
      if (localObject2 == null)
      {
        exceptionReport(9, "downloadDataAcquisitionModule modulerecord is null");
        return;
      }
      localObject2 = ((QzoneModuleConfigManager.QzoneModuleRecord)localObject2).f;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        exceptionReport(11, (String)localObject2 + " not set");
        return;
      }
    }
    try
    {
      Class.forName((String)localObject2);
      i = 1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        boolean bool;
        int i = 0;
      }
    }
    if (i == 0)
    {
      bool = QzoneModuleManager.getInstance().isModuleDownloaded(str2);
      if ((!QzoneModuleManager.getInstance().checkIfNeedUpdate(str2)) && (bool))
      {
        loadModule(str2, (String)localObject2, (String)localObject1);
        return;
      }
      if (BaseApplicationImpl.sProcessId == 2)
      {
        QzoneModuleManager.getInstance().downloadModule(str2, new amyt(this, str2, (String)localObject2, (String)localObject1));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MachineLearingSmartReport", 2, "Module download skip, not qzone process");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("MachineLearingSmartReport", 2, "Modulealready exists, skip download");
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MachineLearingSmartReport", 2, "ModuleConfig is null");
      }
    }
  }
  
  public String[] getArgs()
  {
    return this.argArray;
  }
  
  public int getBatchId()
  {
    return this.batch_id;
  }
  
  public String getSelection()
  {
    return this.selection;
  }
  
  public boolean isNeedReport()
  {
    boolean bool2 = false;
    Object localObject = QzoneAlphaConfig.a().a("ClientReport", "MachinelearningSmartReportConfig", "");
    if (QLog.isColorLevel()) {
      QLog.i("MachineLearingSmartReport", 2, "reportconfig:" + (String)localObject);
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      try
      {
        localObject = getArguments((String)localObject);
        if (!checkAbsoluteTime((Map)localObject))
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            return bool1;
          }
          QLog.i("MachineLearingSmartReport", 2, "time not meet condition");
          return false;
        }
        if (!checkRelativeTime((Map)localObject))
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            return bool1;
          }
          QLog.i("MachineLearingSmartReport", 2, "time not meet condition");
          return false;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MachineLearingSmartReport", 1, localException, new Object[0]);
        exceptionReport(7, "reportCmd decode error");
        return false;
      }
      if (!checkQUA(localException))
      {
        exceptionReport(1, "qua not meet condition");
        return false;
      }
      if (!checkNetworkEnabled(localException))
      {
        exceptionReport(3, "network not meet condition");
        return false;
      }
      if (!checkFrequency(localException))
      {
        QLog.w("MachineLearingSmartReport", 2, "frequency not meet condition");
        return false;
      }
      if (!checkSQLValid(localException))
      {
        exceptionReport(4, "selection or args error");
        return false;
      }
      if (!checkChannel(localException))
      {
        exceptionReport(5, "report channel error");
        return false;
      }
      if (!checkBatchId(localException))
      {
        exceptionReport(6, "batchid error");
        return false;
      }
      boolean bool3 = checkQueryTimes(localException);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isSmartReportEnable()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("ClientReport", "MachinelearningSmartReportSwitch", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean smartReport(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    if (this.report_channel == 1) {
      return MTAReport(paramArrayList);
    }
    if (this.report_channel == 2) {
      return BeaconReport(paramArrayList);
    }
    return LPReport(paramArrayList);
  }
  
  public void updateLastQueryId(long paramLong)
  {
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      LocalMultiProcConfig.putLong4Uin("smartreport_lastreport_id" + this.batch_id, paramLong, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    }
  }
  
  public void updateQueryTimes()
  {
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null))
    {
      int i = getQueryTimes();
      LocalMultiProcConfig.putInt4Uin("smartreport_times" + this.batch_id, i + 1, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.MachineLearingSmartReport
 * JD-Core Version:    0.7.0.1
 */