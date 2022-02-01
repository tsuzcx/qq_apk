package com.tencent.open.appcommon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

final class AppClient$1
  implements Runnable
{
  AppClient$1(String paramString1, Bundle paramBundle1, String paramString2, Activity paramActivity, Intent paramIntent, Bundle paramBundle2) {}
  
  public void run()
  {
    if (MyAppApi.a().c())
    {
      Object localObject = DownloadManager.a().a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        if (((DownloadInfo)localObject).jdField_c_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.jdField_c_of_type_JavaLangString, ((DownloadInfo)localObject).j);
          this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.d, ((DownloadInfo)localObject).k);
          this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.i, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidOsBundle.putString(DownloadConstants.f, ((DownloadInfo)localObject).e);
          this.jdField_a_of_type_AndroidOsBundle.putInt(DownloadConstants.e, ((DownloadInfo)localObject).b);
          MyAppApi.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, false, false);
          return;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 200);
        return;
      }
      localObject = this.jdField_b_of_type_AndroidOsBundle;
      if ((localObject != null) && (((Bundle)localObject).containsKey(DownloadConstants.f)))
      {
        this.jdField_a_of_type_AndroidOsBundle.putAll(this.jdField_b_of_type_AndroidOsBundle);
        MyAppApi.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, false, false);
        return;
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 200);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient.1
 * JD-Core Version:    0.7.0.1
 */