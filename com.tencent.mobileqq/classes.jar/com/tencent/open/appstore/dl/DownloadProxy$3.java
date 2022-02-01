package com.tencent.open.appstore.dl;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;

class DownloadProxy$3
  implements Runnable
{
  DownloadProxy$3(DownloadProxy paramDownloadProxy, Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[doDownloadAction] pParams=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidOsBundle);
    ((StringBuilder)localObject1).append(" source=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(" myAppConfig=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject1).append(" ac==null is");
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity;
    boolean bool2 = false;
    boolean bool1;
    if (localObject2 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject1).append(bool1);
    LogUtility.b("DownloadResolver", ((StringBuilder)localObject1).toString());
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      LogUtility.b("DownloadResolver", "[doDownloadAction] pParams == null return");
      return;
    }
    DownloadManagerV2.a().a();
    this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.b);
    this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.t, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("big_brother_source_key", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putInt(DownloadConstants.G, 1);
    localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.D);
    String str = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.i);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals("0"))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.D, "");
    }
    localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.j);
    ApkUpdateDetail localApkUpdateDetail = this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail;
    localObject1 = localObject2;
    if (localApkUpdateDetail != null)
    {
      localObject1 = localObject2;
      if (localApkUpdateDetail.updatemethod == 2)
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url))
          {
            this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.j, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
            localObject1 = this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url;
          }
        }
      }
    }
    localObject1 = DownloadManagerV2.a().b((String)localObject1);
    if ((localObject1 == null) && ("biz_src_yyb".equals(this.jdField_a_of_type_JavaLangString)) && (ControlPolicyUtil.e()))
    {
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt(DownloadConstants.k);
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.f);
      if ((i == 5) && ("com.tencent.android.qqdownloader".equals(localObject2))) {
        DownloadProxy.a(this.jdField_a_of_type_AndroidOsBundle);
      }
    }
    else if ((localObject1 != null) && (!TextUtils.isEmpty(str)))
    {
      ((DownloadInfo)localObject1).h = str;
    }
    if (DownloadProxy.a(this.jdField_a_of_type_AndroidOsBundle))
    {
      LogUtility.a("DownloadResolver", "[doDownloadAction] installApp");
      return;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getInt(DownloadConstants.k) == 5) {
      this.jdField_a_of_type_AndroidOsBundle.putInt(DownloadConstants.k, 2);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if ((localObject1 != null) && (((DownloadInfo)localObject1).c == 1))
      {
        DownloadProxy.a(this.this$0, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
      }
      boolean bool3 = APNUtil.d(CommonDataAdapter.a().a());
      boolean bool4 = APNUtil.c(CommonDataAdapter.a().a());
      if ((localObject1 != null) && (((DownloadInfo)localObject1).a() != 1)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        bool2 = true;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("check wifi dialog isWifiActive=");
      ((StringBuilder)localObject1).append(bool4);
      ((StringBuilder)localObject1).append(" isFirstDownload=");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(" acIsNull=");
      ((StringBuilder)localObject1).append(bool2);
      LogUtility.a("DownloadResolver", ((StringBuilder)localObject1).toString());
      if ((bool3) && (!bool2) && (!bool4) && (bool1) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean(DownloadConstants.s)))
      {
        DownloadManagerV2.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
      }
      DownloadProxy.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
      return;
    }
    if ((localObject1 != null) && (((DownloadInfo)localObject1).c != 1))
    {
      DownloadProxy.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
      return;
    }
    DownloadProxy.a(this.this$0, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.3
 * JD-Core Version:    0.7.0.1
 */