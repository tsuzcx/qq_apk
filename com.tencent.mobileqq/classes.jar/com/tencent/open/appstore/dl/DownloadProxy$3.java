package com.tencent.open.appstore.dl;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import bcyb;
import bdhk;
import bdho;
import bdid;
import bdii;
import bdkw;
import bdlb;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadProxy$3
  implements Runnable
{
  public DownloadProxy$3(bdho parambdho, Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject = new StringBuilder().append("[doDownloadAction] pParams=").append(this.jdField_a_of_type_AndroidOsBundle).append(" source=").append(this.jdField_a_of_type_JavaLangString).append(" myAppConfig=").append(this.jdField_a_of_type_Int).append(" ac==null is");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bdii.b("DownloadResolver", bool1);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        break;
      }
      bdii.b("DownloadResolver", "[doDownloadAction] pParams == null return");
      return;
    }
    bdhk.a().a();
    this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.b);
    this.jdField_a_of_type_AndroidOsBundle.putString(bdlb.s, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("big_brother_source_key", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putInt(bdlb.E, 1);
    localObject = this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.B);
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.i);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals("0"))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(bdlb.B, "");
    }
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.j);
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
            this.jdField_a_of_type_AndroidOsBundle.putString(bdlb.j, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
            localObject = this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url;
          }
        }
      }
    }
    localObject = bdhk.a().b((String)localObject);
    if ((localObject == null) && ("biz_src_yyb".equals(this.jdField_a_of_type_JavaLangString)) && (bdkw.e()))
    {
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt(bdlb.k);
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.f);
      if ((i == 5) && ("com.tencent.android.qqdownloader".equals(str1))) {
        bdho.a(this.jdField_a_of_type_AndroidOsBundle);
      }
    }
    else if ((localObject != null) && (!TextUtils.isEmpty(str2)))
    {
      ((DownloadInfo)localObject).h = str2;
    }
    if (bdho.a(this.jdField_a_of_type_AndroidOsBundle))
    {
      bdii.a("DownloadResolver", "[doDownloadAction] installApp");
      return;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getInt(bdlb.k) == 5) {
      this.jdField_a_of_type_AndroidOsBundle.putInt(bdlb.k, 2);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if ((localObject != null) && (((DownloadInfo)localObject).c == 1))
      {
        bdho.a(this.this$0, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
      }
      boolean bool3 = bdid.d(bcyb.a().a());
      boolean bool4 = bdid.c(bcyb.a().a());
      if ((localObject == null) || (((DownloadInfo)localObject).a() == 1))
      {
        bool1 = true;
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          break label640;
        }
      }
      for (;;)
      {
        bdii.a("DownloadResolver", "check wifi dialog isWifiActive=" + bool4 + " isFirstDownload=" + bool1 + " acIsNull=" + bool2);
        if ((!bool3) || (bool2) || (bool4) || (!bool1) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean(bdlb.r))) {
          break label645;
        }
        bdhk.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
        bool1 = false;
        break;
        label640:
        bool2 = false;
      }
      label645:
      bdho.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
      return;
    }
    if ((localObject == null) || (((DownloadInfo)localObject).c == 1))
    {
      bdho.a(this.this$0, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
      return;
    }
    bdho.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.3
 * JD-Core Version:    0.7.0.1
 */