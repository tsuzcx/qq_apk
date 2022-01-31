package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import bfbm;
import bfjw;
import bflk;
import bflp;
import bfoh;
import bfok;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.downloadnew.DownloadInfo;

public final class DownloadJSApi$1
  implements Runnable
{
  public DownloadJSApi$1(Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject1 = new StringBuilder().append("doDownloadAction pParams=").append(this.jdField_a_of_type_AndroidOsBundle).append(" source=").append(this.jdField_a_of_type_JavaLangString).append(" myAppConfig=").append(this.jdField_a_of_type_Int).append(" ac==null is");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bflp.a("DownloadJSApi", bool1);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        break;
      }
      bflp.e("DownloadJSApi", "doDownloadAction pParams == null return");
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString(bfoh.b);
    this.jdField_a_of_type_AndroidOsBundle.putString(bfoh.s, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putInt(bfoh.E, 1);
    String str = this.jdField_a_of_type_AndroidOsBundle.getString(bfoh.B);
    localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString(bfoh.i);
    if ((TextUtils.isEmpty(str)) || (str.equals("0"))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(bfoh.B, "");
    }
    localObject2 = bfok.a().a((String)localObject2);
    if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      ((DownloadInfo)localObject2).h = ((String)localObject1);
    }
    if ((this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null) && (this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 2) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString(bfoh.j))) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(bfoh.j, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
    }
    boolean bool3 = bflk.d(bfbm.a().a());
    boolean bool4 = bflk.c(bfbm.a().a());
    if ((localObject2 == null) || (((DownloadInfo)localObject2).a() == 1))
    {
      bool1 = true;
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        break label426;
      }
    }
    for (;;)
    {
      bflp.a("DownloadJSApi", "check wifi dialog isWifiActive=" + bool4 + " isFirstDownload=" + bool1 + " acIsNull=" + bool2);
      if ((!bool3) || (bool2) || (bool4) || (!bool1) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean(bfoh.r))) {
        break label431;
      }
      bfjw.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
      return;
      bool1 = false;
      break;
      label426:
      bool2 = false;
    }
    label431:
    bfjw.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadJSApi.1
 * JD-Core Version:    0.7.0.1
 */