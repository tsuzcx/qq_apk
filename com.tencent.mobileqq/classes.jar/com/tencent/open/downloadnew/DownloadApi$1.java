package com.tencent.open.downloadnew;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import bizw;
import bjkj;
import bjko;
import bjmt;
import bjmu;
import bjmy;
import bjna;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

public final class DownloadApi$1
  implements Runnable
{
  public DownloadApi$1(Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    boolean bool2 = true;
    String str1 = bjmu.jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder().append("doDownloadAction pParams=").append(this.jdField_a_of_type_AndroidOsBundle).append(" source=").append(this.jdField_a_of_type_JavaLangString).append(" myAppConfig=").append(this.jdField_a_of_type_Int).append(" ac==null is");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bjko.a(str1, bool1);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        break;
      }
      bjko.e(bjmu.jdField_a_of_type_JavaLangString, "doDownloadAction pParams == null return");
      return;
    }
    bjna.a().a();
    localObject = this.jdField_a_of_type_AndroidOsBundle.getString(bjmy.b);
    this.jdField_a_of_type_AndroidOsBundle.putString(bjmy.s, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putInt(bjmy.F, 1);
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString(bjmy.C);
    str1 = this.jdField_a_of_type_AndroidOsBundle.getString(bjmy.i);
    if ((TextUtils.isEmpty(str2)) || (str2.equals("0"))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(bjmy.C, "");
    }
    localObject = bjna.a().a((String)localObject);
    if ((localObject == null) && ("biz_src_yyb".equals(this.jdField_a_of_type_JavaLangString)) && (bjmt.e()))
    {
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt(bjmy.k);
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString(bjmy.f);
      if ((i == 5) && (str1.equals("com.tencent.android.qqdownloader"))) {
        bjmu.a(this.jdField_a_of_type_AndroidOsBundle);
      }
    }
    else if ((localObject != null) && (!TextUtils.isEmpty(str1)))
    {
      ((DownloadInfo)localObject).h = str1;
    }
    if (bjmu.a(this.jdField_a_of_type_AndroidOsBundle))
    {
      bjko.a(bjmu.jdField_a_of_type_JavaLangString, "doDownloadAction installApp");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null) && (this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 2) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString(bjmy.j))) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url))) {
      this.jdField_a_of_type_AndroidOsBundle.putString(bjmy.j, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.url);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if ((localObject != null) && (((DownloadInfo)localObject).c == 1))
      {
        bjmu.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
      }
      boolean bool3 = bjkj.d(bizw.a().a());
      boolean bool4 = bjkj.c(bizw.a().a());
      if ((localObject == null) || (((DownloadInfo)localObject).a() == 1))
      {
        bool1 = true;
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          break label578;
        }
      }
      for (;;)
      {
        bjko.a(bjmu.jdField_a_of_type_JavaLangString, "check wifi dialog isWifiActive=" + bool4 + " isFirstDownload=" + bool1 + " acIsNull=" + bool2);
        if ((!bool3) || (bool2) || (bool4) || (!bool1) || (!this.jdField_a_of_type_AndroidOsBundle.getBoolean(bjmy.r))) {
          break label583;
        }
        bjna.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
        return;
        bool1 = false;
        break;
        label578:
        bool2 = false;
      }
      label583:
      bjmu.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
      return;
    }
    if ((localObject == null) || (((DownloadInfo)localObject).c == 1))
    {
      bjmu.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.jdField_a_of_type_Int);
      return;
    }
    bjmu.a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.1
 * JD-Core Version:    0.7.0.1
 */