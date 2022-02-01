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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doDownloadActionBySDK pParmas =");
    ((StringBuilder)localObject).append(paramBundle);
    LogUtility.a("DownloadJSApi", ((StringBuilder)localObject).toString());
    String str2 = paramBundle.getString(DownloadConstants.b);
    String str3 = paramBundle.getString(DownloadConstants.j);
    String str4 = paramBundle.getString(DownloadConstants.f);
    int i = paramBundle.getInt(DownloadConstants.k);
    String str5 = paramBundle.getString(DownloadConstants.i);
    String str6 = paramBundle.getString(DownloadConstants.l);
    paramBundle.getString(DownloadConstants.m);
    String str1 = paramBundle.getString(DownloadConstants.F);
    int j = paramBundle.getInt(DownloadConstants.J);
    localObject = paramBundle.getString(DownloadConstants.K);
    boolean bool1 = paramBundle.getBoolean(DownloadConstants.o);
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.z, true);
    boolean bool3 = paramBundle.getBoolean(DownloadConstants.h, true);
    boolean bool4 = paramBundle.getBoolean(DownloadConstants.y);
    int k = paramBundle.getInt(DownloadConstants.E, 0);
    boolean bool5 = paramBundle.getBoolean(DownloadConstants.L, false);
    if (i != 2)
    {
      if (i != 3) {
        if (i != 5) {
          if (i != 10) {
            if (i != 12) {
              if (i == 13) {}
            }
          }
        }
      }
      for (;;)
      {
        return 0;
        paramString = new DownloadInfo(str2, str3.trim(), str4, str6, str5, null, paramString, bool2);
        paramString.g = i;
        paramString.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.e);
        paramString.jdField_b_of_type_Boolean = bool4;
        DownloadCenterImpl.a().a(paramString);
        continue;
        paramString = new DownloadInfo(str2, str3.trim(), str4, str6, str5, null, paramString, bool2);
        paramString.g = i;
        paramString.jdField_a_of_type_Boolean = bool3;
        paramString.jdField_b_of_type_Boolean = bool4;
        paramString.jdField_d_of_type_Int = 0;
        paramString.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.e);
        paramString.o = ((String)localObject);
        if ((paramApkUpdateDetail != null) && (paramString.jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
          paramString.jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
        }
        bool2 = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_QQ_Patch_Switch");
        if (!bool1) {
          DownloadCenterImpl.a().a(paramString);
        } else if (bool2) {
          DownloadCenterImpl.a().a(paramString, paramApkUpdateDetail);
        } else {
          DownloadCenterImpl.a().a(paramString);
        }
        paramBundle = new StringBuilder();
        paramBundle.append("doDownloadAction action == Downloader.ACTION_UPDATE ");
        paramBundle.append(bool1);
        LogUtility.c("DownloadJSApi", paramBundle.toString());
        continue;
        DownloadCenterImpl.a().b(str2);
        continue;
        if (bool2)
        {
          StaticAnalyz.a("305", str5, str2, (String)localObject);
          DownloadCenterImpl.a().a(str2, str4);
          continue;
          DownloadCenterImpl.a().a(str2);
        }
      }
    }
    paramString = new DownloadInfo(str2, str3.trim(), str4, str6, str5, null, paramString, bool2);
    paramString.g = i;
    if (bool2)
    {
      paramString.jdField_a_of_type_Boolean = bool3;
      paramString.jdField_b_of_type_Boolean = bool4;
    }
    else
    {
      paramString.jdField_a_of_type_Boolean = false;
      paramString.jdField_b_of_type_Boolean = true;
      paramString.jdField_a_of_type_Int = 2;
    }
    paramString.h = k;
    paramString.n = str1;
    paramString.i = j;
    paramString.o = ((String)localObject);
    paramString.jdField_d_of_type_Boolean = bool5;
    paramString.jdField_d_of_type_Int = 0;
    paramString.jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.e);
    LogUtility.c("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
    DownloadCenterImpl.a().a(paramString);
    return 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadJSApi
 * JD-Core Version:    0.7.0.1
 */