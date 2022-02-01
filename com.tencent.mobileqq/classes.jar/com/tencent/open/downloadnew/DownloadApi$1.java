package com.tencent.open.downloadnew;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;

final class DownloadApi$1
  implements Runnable
{
  DownloadApi$1(Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    Object localObject1 = DownloadApi.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doDownloadAction pParams=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidOsBundle);
    ((StringBuilder)localObject2).append(" source=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(" myAppConfig=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject2).append(" ac==null is");
    Object localObject3 = this.jdField_a_of_type_AndroidAppActivity;
    boolean bool2 = false;
    boolean bool1;
    if (localObject3 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject2).append(bool1);
    LogUtility.a((String)localObject1, ((StringBuilder)localObject2).toString());
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      LogUtility.e(DownloadApi.jdField_a_of_type_JavaLangString, "doDownloadAction pParams == null return");
      return;
    }
    DownloadManager.a().a();
    localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.b);
    this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.t, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putInt(DownloadConstants.G, 1);
    localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.D);
    localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.i);
    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (((String)localObject3).equals("0"))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.D, "");
    }
    localObject2 = DownloadManager.a().a((String)localObject2);
    if ((localObject2 == null) && ("biz_src_yyb".equals(this.jdField_a_of_type_JavaLangString)) && (ControlPolicyUtil.e()))
    {
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt(DownloadConstants.k);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.f);
      if ((i == 5) && (((String)localObject1).equals("com.tencent.android.qqdownloader"))) {
        DownloadApi.a(this.jdField_a_of_type_AndroidOsBundle);
      }
    }
    else if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      ((DownloadInfo)localObject2).h = ((String)localObject1);
    }
    if (DownloadApi.a(this.jdField_a_of_type_AndroidOsBundle))
    {
      LogUtility.a(DownloadApi.jdField_a_of_type_JavaLangString, "doDownloadAction installApp");
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail;
    if ((localObject1 != null) && (((ApkUpdateDetail)localObject1).updatemethod == 2) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.j))) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.j, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if ((localObject2 != null) && (((DownloadInfo)localObject2).c == 1))
      {
        DownloadApi.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
      }
      boolean bool3 = APNUtil.d(CommonDataAdapter.a().a());
      boolean bool4 = APNUtil.c(CommonDataAdapter.a().a());
      if ((localObject2 != null) && (((DownloadInfo)localObject2).a() != 1)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        bool2 = true;
      }
      localObject1 = DownloadApi.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("check wifi dialog isWifiActive=");
      ((StringBuilder)localObject2).append(bool4);
      ((StringBuilder)localObject2).append(" isFirstDownload=");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(" acIsNull=");
      ((StringBuilder)localObject2).append(bool2);
      LogUtility.a((String)localObject1, ((StringBuilder)localObject2).toString());
      if ((bool3) && (!bool2) && (!bool4) && (bool1) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean(DownloadConstants.s)))
      {
        DownloadManager.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
      }
      DownloadApi.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
      return;
    }
    if ((localObject2 != null) && (((DownloadInfo)localObject2).c != 1))
    {
      DownloadApi.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
      return;
    }
    DownloadApi.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.1
 * JD-Core Version:    0.7.0.1
 */