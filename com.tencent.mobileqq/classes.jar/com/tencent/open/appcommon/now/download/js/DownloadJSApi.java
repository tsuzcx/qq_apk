package com.tencent.open.appcommon.now.download.js;

import aleu;
import alev;
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
  public static int a(Bundle paramBundle, int paramInt, ApkUpdateDetail paramApkUpdateDetail)
  {
    LogUtility.a("DownloadJSApi", "doDownloadActionBySDK pParmas =" + paramBundle);
    String str2 = paramBundle.getString(DownloadConstants.a);
    String str3 = paramBundle.getString(DownloadConstants.i);
    String str4 = paramBundle.getString(DownloadConstants.e);
    int i = paramBundle.getInt(DownloadConstants.j);
    String str5 = paramBundle.getString(DownloadConstants.h);
    String str6 = paramBundle.getString(DownloadConstants.k);
    paramBundle.getString(DownloadConstants.l);
    Object localObject = paramBundle.getString(DownloadConstants.C);
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
      paramApkUpdateDetail = new DownloadInfo(str2, str3.trim(), str4, str6, str5, null, paramInt, bool2);
      paramApkUpdateDetail.h = i;
      if (bool2)
      {
        paramApkUpdateDetail.jdField_a_of_type_Boolean = bool3;
        paramApkUpdateDetail.jdField_b_of_type_Boolean = bool4;
      }
      for (;;)
      {
        paramApkUpdateDetail.i = k;
        paramApkUpdateDetail.l = ((String)localObject);
        paramApkUpdateDetail.j = j;
        paramApkUpdateDetail.m = str1;
        paramApkUpdateDetail.jdField_d_of_type_Boolean = bool5;
        paramApkUpdateDetail.jdField_d_of_type_Int = 0;
        paramApkUpdateDetail.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.d);
        LogUtility.c("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        DownloadCenterImpl.a().a(paramApkUpdateDetail);
        break;
        paramApkUpdateDetail.jdField_a_of_type_Boolean = false;
        paramApkUpdateDetail.jdField_b_of_type_Boolean = true;
        paramApkUpdateDetail.jdField_a_of_type_Int = 2;
      }
      localObject = new DownloadInfo(str2, str3.trim(), str4, str6, str5, null, paramInt, bool2);
      ((DownloadInfo)localObject).h = i;
      ((DownloadInfo)localObject).jdField_a_of_type_Boolean = bool3;
      ((DownloadInfo)localObject).jdField_b_of_type_Boolean = bool4;
      ((DownloadInfo)localObject).jdField_d_of_type_Int = 0;
      ((DownloadInfo)localObject).jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.d);
      ((DownloadInfo)localObject).m = str1;
      if ((paramApkUpdateDetail != null) && (((DownloadInfo)localObject).jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
        ((DownloadInfo)localObject).jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
      }
      bool2 = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_QQ_Patch_Switch");
      if (!bool1) {
        DownloadCenterImpl.a().a((DownloadInfo)localObject);
      }
      for (;;)
      {
        LogUtility.c("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
        break;
        if (bool2) {
          DownloadCenterImpl.a().a((DownloadInfo)localObject, paramApkUpdateDetail);
        } else {
          DownloadCenterImpl.a().a((DownloadInfo)localObject);
        }
      }
      DownloadCenterImpl.a().a(str2);
      continue;
      if (bool2)
      {
        StaticAnalyz.a("305", str5, str2, str1);
        DownloadCenterImpl.a().a(str2, str4);
        continue;
        DownloadCenterImpl.a().b(str2);
        continue;
        paramApkUpdateDetail = new DownloadInfo(str2, str3.trim(), str4, str6, str5, null, paramInt, bool2);
        paramApkUpdateDetail.h = i;
        paramApkUpdateDetail.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.d);
        paramApkUpdateDetail.jdField_b_of_type_Boolean = bool4;
        DownloadCenterImpl.a().a(paramApkUpdateDetail);
      }
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2)
  {
    ThreadManager.getSubThreadHandler().post(new aleu(paramBundle, paramInt1, paramInt2, paramActivity, paramApkUpdateDetail));
  }
  
  private static void c(Activity paramActivity, Bundle paramBundle, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2)
  {
    new Handler(Looper.getMainLooper()).post(new alev(paramBundle, paramActivity, paramInt1, paramApkUpdateDetail, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadJSApi
 * JD-Core Version:    0.7.0.1
 */