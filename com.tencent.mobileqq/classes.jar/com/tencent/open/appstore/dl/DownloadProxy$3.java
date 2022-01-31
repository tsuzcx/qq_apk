package com.tencent.open.appstore.dl;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import bexd;
import bfgi;
import bfgm;
import bfhb;
import bfhg;
import bfjt;
import bfjy;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadProxy$3
  implements Runnable
{
  public DownloadProxy$3(bfgm parambfgm, Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject = new StringBuilder().append("[doDownloadAction] pParams=").append(this.jdField_a_of_type_AndroidOsBundle).append(" source=").append(this.jdField_a_of_type_JavaLangString).append(" myAppConfig=").append(this.jdField_a_of_type_Int).append(" ac==null is");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bfhg.b("DownloadResolver", bool1);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        break;
      }
      bfhg.b("DownloadResolver", "[doDownloadAction] pParams == null return");
      return;
    }
    bfgi.a().a();
    this.jdField_a_of_type_AndroidOsBundle.getString(bfjy.b);
    this.jdField_a_of_type_AndroidOsBundle.putString(bfjy.s, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("big_brother_source_key", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putInt(bfjy.E, 1);
    localObject = this.jdField_a_of_type_AndroidOsBundle.getString(bfjy.B);
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString(bfjy.i);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals("0"))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(bfjy.B, "");
    }
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString(bfjy.j);
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
            this.jdField_a_of_type_AndroidOsBundle.putString(bfjy.j, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
            localObject = this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url;
          }
        }
      }
    }
    localObject = bfgi.a().b((String)localObject);
    if ((localObject == null) && ("biz_src_yyb".equals(this.jdField_a_of_type_JavaLangString)) && (bfjt.e()))
    {
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt(bfjy.k);
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString(bfjy.f);
      if ((i == 5) && ("com.tencent.android.qqdownloader".equals(str1))) {
        bfgm.a(this.jdField_a_of_type_AndroidOsBundle);
      }
    }
    else if ((localObject != null) && (!TextUtils.isEmpty(str2)))
    {
      ((DownloadInfo)localObject).h = str2;
    }
    if (bfgm.a(this.jdField_a_of_type_AndroidOsBundle))
    {
      bfhg.a("DownloadResolver", "[doDownloadAction] installApp");
      return;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getInt(bfjy.k) == 5) {
      this.jdField_a_of_type_AndroidOsBundle.putInt(bfjy.k, 2);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if ((localObject != null) && (((DownloadInfo)localObject).c == 1))
      {
        bfgm.a(this.this$0, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
      }
      boolean bool3 = bfhb.d(bexd.a().a());
      boolean bool4 = bfhb.c(bexd.a().a());
      if ((localObject == null) || (((DownloadInfo)localObject).a() == 1))
      {
        bool1 = true;
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          break label640;
        }
      }
      for (;;)
      {
        bfhg.a("DownloadResolver", "check wifi dialog isWifiActive=" + bool4 + " isFirstDownload=" + bool1 + " acIsNull=" + bool2);
        if ((!bool3) || (bool2) || (bool4) || (!bool1) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean(bfjy.r))) {
          break label645;
        }
        bfgi.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
        bool1 = false;
        break;
        label640:
        bool2 = false;
      }
      label645:
      bfgm.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
      return;
    }
    if ((localObject == null) || (((DownloadInfo)localObject).c == 1))
    {
      bfgm.a(this.this$0, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
      return;
    }
    bfgm.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.3
 * JD-Core Version:    0.7.0.1
 */