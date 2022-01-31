package com.tencent.open.downloadnew;

import alns;
import alnt;
import alnu;
import alnv;
import alnw;
import alnx;
import alny;
import alnz;
import aloa;
import alob;
import aloc;
import alod;
import aloe;
import alof;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.base.StaticAnalyz;
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
  public static final String a;
  public static ConcurrentHashMap a;
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloadApi.class.getName();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner = new alny();
  }
  
  public static int a()
  {
    return 3;
  }
  
  public static int a(Bundle paramBundle, int paramInt, ApkUpdateDetail paramApkUpdateDetail)
  {
    if (paramInt == 1) {
      StaticAnalyz.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.H));
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "doDownloadActionBySDK pParmas =" + paramBundle);
    String str3 = paramBundle.getString(DownloadConstants.jdField_a_of_type_JavaLangString);
    String str4 = paramBundle.getString(DownloadConstants.jdField_i_of_type_JavaLangString);
    String str5 = paramBundle.getString(DownloadConstants.e);
    int i = paramBundle.getInt(DownloadConstants.jdField_j_of_type_JavaLangString);
    String str6 = paramBundle.getString(DownloadConstants.h);
    String str7 = paramBundle.getString(DownloadConstants.k);
    paramBundle.getString(DownloadConstants.l);
    String str2 = paramBundle.getString(DownloadConstants.C);
    int j = paramBundle.getInt(DownloadConstants.G);
    String str1 = paramBundle.getString(DownloadConstants.H);
    boolean bool1 = paramBundle.getBoolean(DownloadConstants.n);
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.x, true);
    boolean bool3 = paramBundle.getBoolean(DownloadConstants.g, true);
    boolean bool4 = paramBundle.getBoolean(DownloadConstants.w);
    int k = paramBundle.getInt(DownloadConstants.B, 0);
    boolean bool5 = paramBundle.getBoolean(DownloadConstants.I, false);
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      paramApkUpdateDetail = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramInt, bool2);
      paramApkUpdateDetail.h = i;
      if (bool2)
      {
        paramApkUpdateDetail.jdField_a_of_type_Boolean = bool3;
        paramApkUpdateDetail.jdField_b_of_type_Boolean = bool4;
      }
      for (;;)
      {
        paramApkUpdateDetail.jdField_i_of_type_Int = k;
        paramApkUpdateDetail.l = str2;
        paramApkUpdateDetail.jdField_j_of_type_Int = j;
        paramApkUpdateDetail.m = str1;
        paramApkUpdateDetail.jdField_d_of_type_Boolean = bool5;
        paramApkUpdateDetail.jdField_d_of_type_Int = 0;
        paramApkUpdateDetail.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.jdField_d_of_type_JavaLangString);
        paramApkUpdateDetail.jdField_d_of_type_Long = paramBundle.getLong(DownloadConstants.F);
        LogUtility.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        DownloadManager.a().a(paramApkUpdateDetail);
        break;
        paramApkUpdateDetail.jdField_a_of_type_Boolean = false;
        paramApkUpdateDetail.jdField_b_of_type_Boolean = true;
        paramApkUpdateDetail.jdField_a_of_type_Int = 2;
      }
      DownloadInfo localDownloadInfo = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramInt, bool2);
      localDownloadInfo.h = i;
      localDownloadInfo.jdField_a_of_type_Boolean = bool3;
      localDownloadInfo.jdField_b_of_type_Boolean = bool4;
      localDownloadInfo.jdField_d_of_type_Int = 0;
      localDownloadInfo.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.jdField_d_of_type_JavaLangString);
      localDownloadInfo.m = str1;
      if ((paramApkUpdateDetail != null) && (localDownloadInfo.jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
        localDownloadInfo.jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
      }
      bool2 = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_QQ_Patch_Switch");
      if (!bool1) {
        DownloadManager.a().a(localDownloadInfo);
      }
      for (;;)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
        break;
        if (bool2) {
          DownloadManager.a().a(localDownloadInfo, paramApkUpdateDetail);
        } else {
          DownloadManager.a().a(localDownloadInfo);
        }
      }
      return DownloadManager.a().a(str3);
      if (bool2)
      {
        StaticAnalyz.a("305", str6, str3, str1);
        localDownloadInfo = DownloadManager.a().a(str3);
        paramApkUpdateDetail = localDownloadInfo;
        if (localDownloadInfo == null)
        {
          paramApkUpdateDetail = new DownloadInfo();
          paramApkUpdateDetail.jdField_b_of_type_JavaLangString = str3;
          paramApkUpdateDetail.jdField_c_of_type_JavaLangString = str4.trim();
          paramApkUpdateDetail.jdField_d_of_type_JavaLangString = str5;
          paramApkUpdateDetail.e = str7;
          paramApkUpdateDetail.g = str6;
          paramApkUpdateDetail.jdField_i_of_type_JavaLangString = paramBundle.getString(DownloadConstants.jdField_b_of_type_JavaLangString);
          paramApkUpdateDetail.jdField_j_of_type_JavaLangString = paramBundle.getString(DownloadConstants.jdField_c_of_type_JavaLangString);
          paramApkUpdateDetail.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.jdField_d_of_type_JavaLangString);
          paramApkUpdateDetail.jdField_c_of_type_Boolean = paramBundle.getBoolean(DownloadConstants.x, true);
          paramApkUpdateDetail.jdField_i_of_type_Int = k;
          paramApkUpdateDetail.l = str2;
          paramApkUpdateDetail.jdField_d_of_type_Int = 0;
          paramApkUpdateDetail.m = str1;
        }
        DownloadManager.a().c(paramApkUpdateDetail);
        continue;
        DownloadManager.a().a(str3, null, true);
      }
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramActivity == null)) {
      return;
    }
    ThreadManager.executeOnSubThread(new alnz(paramActivity, paramBundle));
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().a()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if (paramInt1 == 1) {
      StaticAnalyz.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.H));
    }
    ThreadManager.getSubThreadHandler().post(new alns(paramBundle, paramInt1, paramInt2, paramActivity, paramApkUpdateDetail));
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new aloa(paramBundle));
  }
  
  public static void a(DownloadListener paramDownloadListener)
  {
    ThreadManager.getSubThreadHandler().post(new alnu(paramDownloadListener));
  }
  
  public static void a(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new alnt(paramString));
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
    ThreadManager.getSubThreadHandler().post(new alod(paramString, paramDownloadQueryListener));
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new aloe(paramString1, paramString2, paramBoolean));
  }
  
  public static void a(List paramList, DownloadQueryListener paramDownloadQueryListener)
  {
    if (paramList == null)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction infos == null");
      return;
    }
    if (paramDownloadQueryListener == null) {
      LogUtility.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new aloc(paramList, paramDownloadQueryListener));
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle.getInt(DownloadConstants.jdField_j_of_type_JavaLangString) == 5)
    {
      String str2 = paramBundle.getString(DownloadConstants.jdField_a_of_type_JavaLangString);
      String str3 = paramBundle.getString(DownloadConstants.jdField_i_of_type_JavaLangString);
      String str4 = paramBundle.getString(DownloadConstants.e);
      String str1 = paramBundle.getString(DownloadConstants.h);
      String str5 = paramBundle.getString(DownloadConstants.k);
      StaticAnalyz.a("305", str1, str2, paramBundle.getString(DownloadConstants.H));
      DownloadInfo localDownloadInfo = DownloadManager.a().a(str2);
      if (localDownloadInfo == null)
      {
        localDownloadInfo = new DownloadInfo();
        localDownloadInfo.jdField_b_of_type_JavaLangString = str2;
        localDownloadInfo.jdField_c_of_type_JavaLangString = str3.trim();
        localDownloadInfo.jdField_d_of_type_JavaLangString = str4;
        localDownloadInfo.e = str5;
        localDownloadInfo.g = str1;
        localDownloadInfo.jdField_i_of_type_JavaLangString = paramBundle.getString(DownloadConstants.jdField_b_of_type_JavaLangString);
        localDownloadInfo.jdField_j_of_type_JavaLangString = paramBundle.getString(DownloadConstants.jdField_c_of_type_JavaLangString);
        localDownloadInfo.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.jdField_d_of_type_JavaLangString);
        localDownloadInfo.m = paramBundle.getString(DownloadConstants.H);
        paramBundle = localDownloadInfo;
      }
      for (;;)
      {
        DownloadManager.a().c(paramBundle);
        return true;
        paramBundle = localDownloadInfo;
        if (!TextUtils.isEmpty(str1))
        {
          localDownloadInfo.g = str1;
          paramBundle = localDownloadInfo;
        }
      }
    }
    return false;
  }
  
  public static boolean a(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    return DownloadManager.a().a(paramApkWriteCodeListener);
  }
  
  public static boolean a(String paramString)
  {
    paramString = DownloadManager.a().a(paramString);
    return (paramString != null) && (paramString.jdField_c_of_type_Int == 1);
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2)
  {
    LogUtility.a(jdField_a_of_type_JavaLangString, "doDownloadActionByMyApp pParmas =" + paramBundle + " myAppConfig = " + paramInt2);
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if (paramInt1 == 1) {
      StaticAnalyz.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.H));
    }
    Object localObject1;
    if (paramBundle.getInt(DownloadConstants.jdField_d_of_type_JavaLangString, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner, CommonDataAdapter.a().a());
      localObject1 = paramBundle.getString(DownloadConstants.e);
      Object localObject3 = paramBundle.getString(DownloadConstants.A);
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
    label284:
    do
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        try
        {
          jdField_a_of_type_JavaLangObject.wait(5000L);
          if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            break label284;
          }
          localObject1 = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
          if (localObject1 == null)
          {
            DownloadManager.a().b(CommonDataAdapter.a().a().getString(2131428521));
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
      paramBundle.putInt(DownloadConstants.jdField_d_of_type_JavaLangString, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(DownloadConstants.s, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(DownloadConstants.t, paramApkUpdateDetail.newapksize);
      }
      if (paramInt2 == 1)
      {
        paramBundle.putInt("source", paramInt1);
        MyAppApi.a().a(paramActivity, paramBundle, new alnw(paramBundle, paramInt1, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt2 != 2) && (paramInt2 != 0));
    MyAppApi.a().b(paramActivity, paramBundle, new alnx(paramBundle, paramInt1, paramApkUpdateDetail));
  }
  
  public static void b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new alob(paramBundle));
  }
  
  public static void b(DownloadListener paramDownloadListener)
  {
    ThreadManager.getSubThreadHandler().post(new alnv(paramDownloadListener));
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new alof(paramString1, paramString2, paramBoolean));
  }
  
  public static boolean b(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    return DownloadManager.a().b(paramApkWriteCodeListener);
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi
 * JD-Core Version:    0.7.0.1
 */