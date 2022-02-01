package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class DownloadApi
{
  protected static ITMAssistantExchangeURLListenner a;
  public static Object a;
  protected static final String a;
  protected static ConcurrentHashMap<String, Integer> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloadApi.class.getName();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner = new DownloadApi.15();
  }
  
  public static int a()
  {
    return 3;
  }
  
  public static int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      StaticAnalyz.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.J));
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "doDownloadActionBySDK pParmas =" + paramBundle);
    String str4 = paramBundle.getString(DownloadConstants.b);
    String str5 = paramBundle.getString(DownloadConstants.j);
    String str6 = paramBundle.getString(DownloadConstants.f);
    int i = paramBundle.getInt(DownloadConstants.k);
    String str7 = paramBundle.getString(DownloadConstants.i);
    String str8 = paramBundle.getString(DownloadConstants.l);
    paramBundle.getString(DownloadConstants.m);
    String str3 = paramBundle.getString(DownloadConstants.E);
    int j = paramBundle.getInt(DownloadConstants.I);
    String str2 = paramBundle.getString(DownloadConstants.J);
    boolean bool1 = paramBundle.getBoolean(DownloadConstants.o);
    boolean bool3 = paramBundle.getBoolean(DownloadConstants.y, true);
    boolean bool4 = paramBundle.getBoolean(DownloadConstants.jdField_h_of_type_JavaLangString, true);
    boolean bool5 = paramBundle.getBoolean(DownloadConstants.x);
    int k = paramBundle.getInt(DownloadConstants.D, 0);
    boolean bool6 = paramBundle.getBoolean(DownloadConstants.K, false);
    String str1 = paramBundle.getString("big_brother_source_key");
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.z, false);
    if (TextUtils.isEmpty(paramString)) {
      paramString = str1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[UniteDownload] jsapi doDownloadActionBySDK: invoked. ", " sourceFromJsApi: ", str1, " source: ", paramString, " isUniteDownload: ", Boolean.valueOf(bool2) });
      }
      str1 = paramBundle.getString("big_brother_ref_source_key", "");
      String str9 = paramBundle.getInt("hideInstallSuccessPage", 0) + "";
      switch (i)
      {
      }
      for (;;)
      {
        return 0;
        paramString = new DownloadInfo(str4, str5.trim(), str6, str8, str7, null, paramString, bool3);
        paramString.jdField_g_of_type_Int = i;
        if (bool3)
        {
          paramString.jdField_a_of_type_Boolean = bool4;
          paramString.jdField_b_of_type_Boolean = bool5;
          label425:
          paramString.jdField_h_of_type_Int = k;
          paramString.n = str3;
          paramString.i = j;
          paramString.o = str2;
          paramString.jdField_d_of_type_Boolean = bool6;
          paramString.jdField_d_of_type_Int = 0;
          paramString.jdField_g_of_type_Boolean = bool2;
        }
        try
        {
          paramString.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.e);
          paramString.jdField_d_of_type_Long = paramBundle.getLong(DownloadConstants.H);
          label488:
          LogUtility.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
          paramString.a("big_brother_ref_source_key", str1);
          paramString.a("hideInstallSuccessPage", str9);
          a(paramString, bool2);
          continue;
          paramString.jdField_a_of_type_Boolean = false;
          paramString.jdField_b_of_type_Boolean = true;
          paramString.jdField_a_of_type_Int = 2;
          break label425;
          paramString = new DownloadInfo(str4, str5.trim(), str6, str8, str7, null, paramString, bool3);
          paramString.jdField_g_of_type_Int = i;
          paramString.jdField_a_of_type_Boolean = bool4;
          paramString.jdField_b_of_type_Boolean = bool5;
          paramString.jdField_d_of_type_Int = 0;
          paramString.jdField_g_of_type_Boolean = bool2;
          paramString.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.e);
          paramString.o = str2;
          if ((paramApkUpdateDetail != null) && (paramString.jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
            paramString.jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
          }
          paramString.a("big_brother_ref_source_key", str1);
          paramString.a("hideInstallSuccessPage", str9);
          bool3 = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_QQ_Patch_Switch");
          if (!bool1) {
            a(paramString, bool2);
          }
          for (;;)
          {
            LogUtility.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
            break;
            if (bool3) {
              DownloadManager.a().a(paramString, paramApkUpdateDetail);
            } else {
              a(paramString, bool2);
            }
          }
          return DownloadManager.a().a(str4);
          if (bool3)
          {
            StaticAnalyz.a("305", str7, str4, str2);
            paramApkUpdateDetail = DownloadManager.a().a(str4);
            paramString = paramApkUpdateDetail;
            if (paramApkUpdateDetail == null)
            {
              paramString = new DownloadInfo();
              paramString.jdField_c_of_type_JavaLangString = str4;
              paramString.jdField_d_of_type_JavaLangString = str5.trim();
              paramString.e = str6;
              paramString.f = str8;
              paramString.jdField_h_of_type_JavaLangString = str7;
              paramString.j = paramBundle.getString(DownloadConstants.jdField_c_of_type_JavaLangString);
              paramString.k = paramBundle.getString(DownloadConstants.jdField_d_of_type_JavaLangString);
              paramString.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.e);
              paramString.jdField_c_of_type_Boolean = paramBundle.getBoolean(DownloadConstants.y, true);
              paramString.jdField_h_of_type_Int = k;
              paramString.n = str3;
              paramString.jdField_d_of_type_Int = 0;
              paramString.o = str2;
            }
            paramString.a("big_brother_ref_source_key", str1);
            paramString.a("hideInstallSuccessPage", str9);
            DownloadManager.a().c(paramString);
            continue;
            DownloadManager.a().a(str4, null, true);
          }
        }
        catch (NumberFormatException paramBundle)
        {
          break label488;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramActivity == null)) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.2(paramActivity, paramBundle));
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().a()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if (paramString == "biz_src_jc_update") {
      StaticAnalyz.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.J));
    }
    Object localObject = new Throwable().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    while (i < localObject.length)
    {
      localStringBuilder.append(localObject[i].toString());
      i += 1;
    }
    localObject = paramBundle.getString(DownloadConstants.b);
    String str = paramBundle.getString(DownloadConstants.j);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      DownloadInfoReport.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localStringBuilder.toString());
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new DownloadApi.1(paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
      return;
      if (!TextUtils.isEmpty(str)) {
        DownloadInfoReport.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localStringBuilder.toString());
      }
    }
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.3(paramBundle));
  }
  
  private static void a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      DownloadManagerV2.a().b(paramDownloadInfo);
      return;
    }
    DownloadManager.a().a(paramDownloadInfo);
  }
  
  public static void a(DownloadListener paramDownloadListener)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.11(paramDownloadListener));
  }
  
  public static void a(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.10(paramString));
  }
  
  public static void a(String paramString, DownloadQueryListener paramDownloadQueryListener)
  {
    if (paramString == null)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia via == null");
      return;
    }
    if (paramDownloadQueryListener == null) {
      LogUtility.a(jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.6(paramString, paramDownloadQueryListener));
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.7(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static void a(List<DownloadInfo> paramList, DownloadQueryListener paramDownloadQueryListener)
  {
    if (paramList == null)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction infos == null");
      return;
    }
    if (paramDownloadQueryListener == null) {
      LogUtility.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.5(paramList, paramDownloadQueryListener));
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle.getInt(DownloadConstants.k) == 5)
    {
      String str1 = paramBundle.getString(DownloadConstants.b);
      String str2 = paramBundle.getString(DownloadConstants.j);
      String str3 = paramBundle.getString(DownloadConstants.f);
      String str4 = paramBundle.getString(DownloadConstants.i);
      String str5 = paramBundle.getString(DownloadConstants.l);
      StaticAnalyz.a("305", str4, str1, paramBundle.getString(DownloadConstants.J));
      DownloadInfo localDownloadInfo = DownloadManager.a().a(str1);
      if (localDownloadInfo == null)
      {
        localDownloadInfo = new DownloadInfo();
        localDownloadInfo.jdField_c_of_type_JavaLangString = str1;
        localDownloadInfo.jdField_d_of_type_JavaLangString = str2.trim();
        localDownloadInfo.e = str3;
        localDownloadInfo.f = str5;
        localDownloadInfo.jdField_h_of_type_JavaLangString = str4;
        localDownloadInfo.j = paramBundle.getString(DownloadConstants.jdField_c_of_type_JavaLangString);
        localDownloadInfo.k = paramBundle.getString(DownloadConstants.jdField_d_of_type_JavaLangString);
        localDownloadInfo.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.e);
        localDownloadInfo.o = paramBundle.getString(DownloadConstants.J);
        localDownloadInfo.a("hideInstallSuccessPage", paramBundle.getInt("hideInstallSuccessPage", 0) + "");
      }
      for (paramBundle = localDownloadInfo;; paramBundle = localDownloadInfo)
      {
        DownloadManager.a().c(paramBundle);
        return true;
        if (!TextUtils.isEmpty(str4)) {
          localDownloadInfo.jdField_h_of_type_JavaLangString = str4;
        }
        localDownloadInfo.a("hideInstallSuccessPage", paramBundle.getInt("hideInstallSuccessPage", 0) + "");
      }
    }
    return false;
  }
  
  public static boolean a(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    DownloadManagerV2.a().a(paramApkWriteCodeListener);
    return DownloadManager.a().a(paramApkWriteCodeListener);
  }
  
  public static boolean a(String paramString)
  {
    paramString = DownloadManager.a().a(paramString);
    return (paramString != null) && (paramString.jdField_c_of_type_Int == 1);
  }
  
  protected static void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    LogUtility.a(jdField_a_of_type_JavaLangString, "doDownloadActionByMyApp pParmas =" + paramBundle + " myAppConfig = " + paramInt);
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      StaticAnalyz.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.J));
    }
    Object localObject1;
    if (paramBundle.getInt(DownloadConstants.e, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner, CommonDataAdapter.a().a());
      localObject1 = paramBundle.getString(DownloadConstants.f);
      Object localObject3 = paramBundle.getString(DownloadConstants.C);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localStringBuilder.append(";");
          localStringBuilder.append((String)localObject3);
        }
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localStringBuilder.toString());
        ((TMAssistantGetAppDetailTool)???).exchangeUrlsFromPackageNames((ArrayList)localObject3);
      }
    }
    label288:
    do
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        try
        {
          jdField_a_of_type_JavaLangObject.wait(5000L);
          if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            break label288;
          }
          localObject1 = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
          if (localObject1 == null)
          {
            DownloadManager.a().b(CommonDataAdapter.a().a().getString(2131694653));
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      paramBundle.putInt(DownloadConstants.e, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(DownloadConstants.t, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(DownloadConstants.u, paramApkUpdateDetail.newapksize);
      }
      if (paramInt == 1)
      {
        paramBundle.putString("source", paramString);
        MyAppApi.a().a(paramActivity, paramBundle, new DownloadApi.13(paramBundle, paramString, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt != 2) && (paramInt != 0));
    MyAppApi.a().b(paramActivity, paramBundle, new DownloadApi.14(paramBundle, paramString, paramApkUpdateDetail));
  }
  
  public static void b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.4(paramBundle));
  }
  
  public static void b(DownloadListener paramDownloadListener)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.12(paramDownloadListener));
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.8(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static boolean b(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    DownloadManagerV2.a().b(paramApkWriteCodeListener);
    return DownloadManager.a().b(paramApkWriteCodeListener);
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi
 * JD-Core Version:    0.7.0.1
 */