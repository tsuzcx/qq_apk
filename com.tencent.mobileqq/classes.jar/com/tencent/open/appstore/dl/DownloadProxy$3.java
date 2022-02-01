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
    boolean bool2 = true;
    Object localObject = new StringBuilder().append("[doDownloadAction] pParams=").append(this.jdField_a_of_type_AndroidOsBundle).append(" source=").append(this.jdField_a_of_type_JavaLangString).append(" myAppConfig=").append(this.jdField_a_of_type_Int).append(" ac==null is");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      LogUtility.b("DownloadResolver", bool1);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        break;
      }
      LogUtility.b("DownloadResolver", "[doDownloadAction] pParams == null return");
      return;
    }
    DownloadManagerV2.a().a();
    this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.b);
    this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.s, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("big_brother_source_key", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putInt(DownloadConstants.F, 1);
    localObject = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.C);
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.i);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals("0"))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.C, "");
    }
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.j);
    localObject = str1;
    if (this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      localObject = str1;
      if (this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 2)
      {
        localObject = str1;
        if (TextUtils.isEmpty(str1))
        {
          localObject = str1;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url))
          {
            this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.j, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
            localObject = this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url;
          }
        }
      }
    }
    localObject = DownloadManagerV2.a().b((String)localObject);
    if ((localObject == null) && ("biz_src_yyb".equals(this.jdField_a_of_type_JavaLangString)) && (ControlPolicyUtil.e()))
    {
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt(DownloadConstants.k);
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.f);
      if ((i == 5) && ("com.tencent.android.qqdownloader".equals(str1))) {
        DownloadProxy.a(this.jdField_a_of_type_AndroidOsBundle);
      }
    }
    else if ((localObject != null) && (!TextUtils.isEmpty(str2)))
    {
      ((DownloadInfo)localObject).h = str2;
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
      if ((localObject != null) && (((DownloadInfo)localObject).c == 1))
      {
        DownloadProxy.a(this.this$0, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
      }
      boolean bool3 = APNUtil.d(CommonDataAdapter.a().a());
      boolean bool4 = APNUtil.c(CommonDataAdapter.a().a());
      if ((localObject == null) || (((DownloadInfo)localObject).a() == 1))
      {
        bool1 = true;
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          break label640;
        }
      }
      for (;;)
      {
        LogUtility.a("DownloadResolver", "check wifi dialog isWifiActive=" + bool4 + " isFirstDownload=" + bool1 + " acIsNull=" + bool2);
        if ((!bool3) || (bool2) || (bool4) || (!bool1) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean(DownloadConstants.r))) {
          break label645;
        }
        DownloadManagerV2.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
        bool1 = false;
        break;
        label640:
        bool2 = false;
      }
      label645:
      DownloadProxy.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
      return;
    }
    if ((localObject == null) || (((DownloadInfo)localObject).c == 1))
    {
      DownloadProxy.a(this.this$0, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
      return;
    }
    DownloadProxy.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.3
 * JD-Core Version:    0.7.0.1
 */