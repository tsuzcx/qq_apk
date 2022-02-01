package com.tencent.open.appcommon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bjwo;
import bjwq;
import bjxd;
import com.tencent.open.downloadnew.DownloadInfo;

public final class AppClient$1
  implements Runnable
{
  public AppClient$1(String paramString1, Bundle paramBundle1, String paramString2, Activity paramActivity, Intent paramIntent, Bundle paramBundle2) {}
  
  public void run()
  {
    if (bjxd.a().c())
    {
      DownloadInfo localDownloadInfo = bjwq.a().a(this.jdField_a_of_type_JavaLangString);
      if (localDownloadInfo != null)
      {
        if (localDownloadInfo.jdField_c_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidOsBundle.putString(bjwo.jdField_b_of_type_JavaLangString, localDownloadInfo.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidOsBundle.putString(bjwo.jdField_c_of_type_JavaLangString, localDownloadInfo.j);
          this.jdField_a_of_type_AndroidOsBundle.putString(bjwo.d, localDownloadInfo.k);
          this.jdField_a_of_type_AndroidOsBundle.putString(bjwo.i, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidOsBundle.putString(bjwo.f, localDownloadInfo.e);
          this.jdField_a_of_type_AndroidOsBundle.putInt(bjwo.e, localDownloadInfo.b);
          bjxd.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, false, false);
          return;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 200);
        return;
      }
      if ((this.jdField_b_of_type_AndroidOsBundle != null) && (this.jdField_b_of_type_AndroidOsBundle.containsKey(bjwo.f)))
      {
        this.jdField_a_of_type_AndroidOsBundle.putAll(this.jdField_b_of_type_AndroidOsBundle);
        bjxd.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, false, false);
        return;
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 200);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient.1
 * JD-Core Version:    0.7.0.1
 */