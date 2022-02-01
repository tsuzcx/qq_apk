package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import mqq.os.MqqHandler;

public class DownloadJSApi
{
  public static int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    LogUtility.a("DownloadJSApi", "doDownloadActionBySDK pParmas =" + paramBundle);
    String str3 = paramBundle.getString(DownloadConstants.b);
    String str4 = paramBundle.getString(DownloadConstants.j);
    String str5 = paramBundle.getString(DownloadConstants.f);
    int i = paramBundle.getInt(DownloadConstants.k);
    String str6 = paramBundle.getString(DownloadConstants.i);
    String str7 = paramBundle.getString(DownloadConstants.l);
    paramBundle.getString(DownloadConstants.m);
    String str2 = paramBundle.getString(DownloadConstants.E);
    int j = paramBundle.getInt(DownloadConstants.I);
    String str1 = paramBundle.getString(DownloadConstants.J);
    boolean bool1 = paramBundle.getBoolean(DownloadConstants.o);
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.y, true);
    boolean bool3 = paramBundle.getBoolean(DownloadConstants.h, true);
    boolean bool4 = paramBundle.getBoolean(DownloadConstants.x);
    int k = paramBundle.getInt(DownloadConstants.D, 0);
    boolean bool5 = paramBundle.getBoolean(DownloadConstants.K, false);
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool2);
      paramString.g = i;
      if (bool2)
      {
        paramString.jdField_a_of_type_Boolean = bool3;
        paramString.jdField_b_of_type_Boolean = bool4;
      }
      for (;;)
      {
        paramString.h = k;
        paramString.n = str2;
        paramString.i = j;
        paramString.o = str1;
        paramString.jdField_d_of_type_Boolean = bool5;
        paramString.jdField_d_of_type_Int = 0;
        paramString.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.e);
        LogUtility.c("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        DownloadCenterImpl.a().a(paramString);
        break;
        paramString.jdField_a_of_type_Boolean = false;
        paramString.jdField_b_of_type_Boolean = true;
        paramString.jdField_a_of_type_Int = 2;
      }
      paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool2);
      paramString.g = i;
      paramString.jdField_a_of_type_Boolean = bool3;
      paramString.jdField_b_of_type_Boolean = bool4;
      paramString.jdField_d_of_type_Int = 0;
      paramString.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.e);
      paramString.o = str1;
      if ((paramApkUpdateDetail != null) && (paramString.jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
        paramString.jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
      }
      bool2 = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_QQ_Patch_Switch");
      if (!bool1) {
        DownloadCenterImpl.a().a(paramString);
      }
      for (;;)
      {
        LogUtility.c("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
        break;
        if (bool2) {
          DownloadCenterImpl.a().a(paramString, paramApkUpdateDetail);
        } else {
          DownloadCenterImpl.a().a(paramString);
        }
      }
      DownloadCenterImpl.a().a(str3);
      continue;
      if (bool2)
      {
        StaticAnalyz.a("305", str6, str3, str1);
        DownloadCenterImpl.a().a(str3, str5);
        continue;
        DownloadCenterImpl.a().b(str3);
        continue;
        paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool2);
        paramString.g = i;
        paramString.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.e);
        paramString.jdField_b_of_type_Boolean = bool4;
        DownloadCenterImpl.a().a(paramString);
      }
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadJSApi.1(paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
  }
  
  private static void c(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadJSApi.2(paramBundle, paramActivity, paramString, paramApkUpdateDetail, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadJSApi
 * JD-Core Version:    0.7.0.1
 */