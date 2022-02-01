package com.tencent.mobileqq.qbosssplash.common;

import BOSSStrategyCenter.tAdvDesc;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.qboss.QbossReportManager;
import cooperation.qzone.qboss.QzoneQbossHelper;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QbossPreDownloadManager
{
  private static volatile QbossPreDownloadManager a;
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + "qbdownres";
    jdField_a_of_type_ComTencentMobileqqQbosssplashCommonQbossPreDownloadManager = null;
  }
  
  public static SharedPreferences a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qboss_pre_download_pref_" + paramString, 0);
  }
  
  public static QbossPreDownloadManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQbosssplashCommonQbossPreDownloadManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqQbosssplashCommonQbossPreDownloadManager == null) {
        jdField_a_of_type_ComTencentMobileqqQbosssplashCommonQbossPreDownloadManager = new QbossPreDownloadManager();
      }
      return jdField_a_of_type_ComTencentMobileqqQbosssplashCommonQbossPreDownloadManager;
    }
    finally {}
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return jdField_a_of_type_JavaLangString + File.separator + b(paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = a(paramString1);
      paramString1 = ((SharedPreferences)localObject).edit();
      paramString1.remove("download_url" + paramString2);
      paramString1.remove("end_time" + paramString2);
      paramString1.remove("trace_info" + paramString2);
      localObject = new HashSet(((SharedPreferences)localObject).getStringSet("packagenames", new HashSet()));
      if (((Set)localObject).remove(paramString2)) {
        paramString1.putStringSet("packagenames", (Set)localObject);
      }
      paramString1.apply();
      QLog.i("QbossPreDownloadManager", 1, "cleanConfig2Sp packageName:" + paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("QbossPreDownloadManager", 1, "cleanConfig2Sp exception", paramString1);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      SharedPreferences localSharedPreferences = a(paramString1);
      paramString1 = localSharedPreferences.edit();
      paramString1.putString("download_url" + paramString2, paramString4);
      paramString1.putString("end_time" + paramString2, paramString3);
      paramString1.putString("trace_info" + paramString2, paramString3);
      paramString3 = new HashSet(localSharedPreferences.getStringSet("packagenames", new HashSet()));
      if (paramString3.add(paramString2)) {
        paramString1.putStringSet("packagenames", paramString3);
      }
      paramString1.apply();
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("QbossPreDownloadManager", 1, "saveConfig2Sp exception", paramString1);
    }
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null) && (!TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())))
      {
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramString, true, 0L, 0L, paramHashMap, null, false);
        if (QLog.isColorLevel()) {
          QLog.i("QbossPreDownloadManager", 2, "reportQbossPreDownloadBeacon, tagName  " + paramString);
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QbossPreDownloadManager", 1, paramString, new Object[0]);
    }
  }
  
  public static boolean a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if ((paramContext == null) || (paramHashMap == null) || (paramHashMap.isEmpty())) {
      return false;
    }
    try
    {
      Object localObject = a((String)paramHashMap.get("downloadurl"));
      if ((QzoneConfig.getInstance().getConfig("Schema", "jump_installapp_scheme_enable", 0) == 0) && (FileUtil.b((String)localObject)))
      {
        QLog.i("QbossPreDownloadManager", 1, "loadPreDownloadRes installApkFile faifilePath:" + (String)localObject);
        FileProvider7Helper.installApkFile(paramContext, (String)localObject);
      }
      else
      {
        localObject = (String)paramHashMap.get("jumpurl");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e("QbossPreDownloadManager", 1, "loadPreDownloadRes jumpurl is empty");
          return false;
        }
        paramHashMap = (HashMap<String, String>)localObject;
        if (!((String)localObject).contains("http://"))
        {
          paramHashMap = (HashMap<String, String>)localObject;
          if (!((String)localObject).contains("https://")) {
            paramHashMap = "https://" + (String)localObject;
          }
        }
        localObject = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramHashMap);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_vip");
        paramContext.startActivity((Intent)localObject);
        QLog.i("QbossPreDownloadManager", 1, "loadPreDownloadRes jump browser url:" + paramHashMap);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("QbossPreDownloadManager", 1, paramContext, new Object[0]);
    }
    return true;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if (QzoneQbossHelper.findPkgInstalled(paramString1).booleanValue())
    {
      QLog.e("QbossPreDownloadManager", 1, "handleQbossPreDownloadConfig package:" + paramString1 + " is installed");
      QbossReportManager.getInstance().reportIntercept(paramString4, null);
      a(paramQQAppInterface.getAccount(), paramString1);
      paramQQAppInterface = new HashMap();
      paramQQAppInterface.put("Qboss_PreDownload_PackageName", paramString1);
      a("Qboss_PreDownload_App_Installed", paramQQAppInterface);
      return false;
    }
    String str = a(paramString3);
    if (a(str, paramString2))
    {
      a(paramQQAppInterface, paramString1, paramString3, str, paramString4);
      return true;
    }
    QLog.e("QbossPreDownloadManager", 1, "handleQbossPreDownloadConfig shouldDownloadRes return false");
    if (QbossSplashUtil.a(paramString2))
    {
      a(paramQQAppInterface.getAccount(), paramString1);
      FileUtil.c(str);
      return false;
    }
    QbossReportManager.getInstance().reportExpose(paramString4, null);
    return false;
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = Uri.parse(paramString);
    return Utils.Crc64String(paramString.getHost() + paramString.getPath());
  }
  
  private static void b(String paramString1, SoftReference<QQAppInterface> paramSoftReference, String paramString2, String paramString3)
  {
    if (paramSoftReference != null) {}
    try
    {
      paramSoftReference = (QQAppInterface)paramSoftReference.get();
      if (paramSoftReference != null)
      {
        paramSoftReference = (PreDownloadController)paramSoftReference.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
        if (paramSoftReference.isEnable()) {
          paramSoftReference.preDownloadSuccess(paramString1, -1L);
        }
      }
      paramString1 = new HashMap();
      paramString1.put("Qboss_PreDownload_PackageName", paramString2);
      paramString1.put("Qboss_PreDownload_FailCode", paramString3);
      a("Qboss_PreDownload_Fail", paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("QbossPreDownloadManager", 1, paramString1, new Object[0]);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      SharedPreferences localSharedPreferences = a(paramQQAppInterface.getAccount());
      Object localObject = localSharedPreferences.getStringSet("packagenames", null);
      if ((localObject != null) && (((Set)localObject).size() > 0))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str1))
          {
            String str2 = localSharedPreferences.getString("download_url" + str1, "");
            a(paramQQAppInterface, str1, localSharedPreferences.getString("end_time" + str1, ""), str2, localSharedPreferences.getString("trace_info" + str1, ""));
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      PreDownloadController localPreDownloadController = (PreDownloadController)paramQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
      if (localPreDownloadController.isEnable())
      {
        QLog.i("QbossPreDownloadManager", 1, "downloadRes request packagename:" + paramString1);
        paramString3 = paramString3 + ".qbtemp";
        localPreDownloadController.requestPreDownload(10088, "vas", paramString2, 0, paramString2, paramString3, 1, 2, true, new QbossPreDownloadManager.1(this, paramQQAppInterface, "qboss_pre_download_res", paramString1, paramString3, paramString2, paramString4));
        return;
      }
      QLog.i("QbossPreDownloadManager", 1, "ctrl.isEnable() = false");
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("QbossPreDownloadManager", 1, paramQQAppInterface, new Object[0]);
    }
  }
  
  public void a(ArrayList<tAdvDesc> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    Object localObject1;
    String str1;
    if ((paramQQAppInterface != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject1 = (tAdvDesc)paramArrayList.get(0);
      if ((localObject1 != null) && (!TextUtils.isEmpty(((tAdvDesc)localObject1).res_data)))
      {
        QLog.i("QbossPreDownloadManager", 4, "handleQbossPreDownloadConfig data = " + ((tAdvDesc)localObject1).res_data);
        paramArrayList = paramQQAppInterface.getAccount();
        str1 = ((tAdvDesc)localObject1).res_traceinfo;
        localObject1 = ((tAdvDesc)localObject1).res_data;
      }
    }
    else
    {
      try
      {
        Object localObject2 = new JSONObject((String)localObject1);
        localObject1 = ((JSONObject)localObject2).getString("packagename");
        String str2 = ((JSONObject)localObject2).getString("endtime");
        localObject2 = ((JSONObject)localObject2).getString("apkurl");
        if (a(paramQQAppInterface, (String)localObject1, str2, (String)localObject2, str1)) {
          a(paramArrayList, (String)localObject1, str2, (String)localObject2);
        }
        return;
      }
      catch (Exception paramArrayList)
      {
        QLog.e("QbossPreDownloadManager", 1, paramArrayList, new Object[0]);
        return;
      }
    }
    QLog.e("QbossPreDownloadManager", 1, "handleQbossPreDownloadConfig data = null");
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!FileUtil.b(paramString1))
    {
      bool1 = bool2;
      if (!QbossSplashUtil.a(paramString2)) {
        bool1 = true;
      }
    }
    QLog.i("QbossPreDownloadManager", 1, "filePath [" + paramString1 + "] shouldRequestRes result = " + bool1);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qbosssplash.common.QbossPreDownloadManager
 * JD-Core Version:    0.7.0.1
 */