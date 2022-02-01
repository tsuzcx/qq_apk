package com.tencent.open.appcommon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bjmy;
import bjna;
import bjnn;
import com.tencent.open.downloadnew.DownloadInfo;

public final class AppClient$1
  implements Runnable
{
  public AppClient$1(String paramString1, Bundle paramBundle1, String paramString2, Activity paramActivity, Intent paramIntent, Bundle paramBundle2) {}
  
  public void run()
  {
    if (bjnn.a().c())
    {
      DownloadInfo localDownloadInfo = bjna.a().a(this.jdField_a_of_type_JavaLangString);
      if (localDownloadInfo != null)
      {
        if (localDownloadInfo.jdField_c_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidOsBundle.putString(bjmy.jdField_b_of_type_JavaLangString, localDownloadInfo.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidOsBundle.putString(bjmy.jdField_c_of_type_JavaLangString, localDownloadInfo.j);
          this.jdField_a_of_type_AndroidOsBundle.putString(bjmy.d, localDownloadInfo.k);
          this.jdField_a_of_type_AndroidOsBundle.putString(bjmy.i, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidOsBundle.putString(bjmy.f, localDownloadInfo.e);
          this.jdField_a_of_type_AndroidOsBundle.putInt(bjmy.e, localDownloadInfo.b);
          bjnn.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, false, false);
          return;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 200);
        return;
      }
      if ((this.jdField_b_of_type_AndroidOsBundle != null) && (this.jdField_b_of_type_AndroidOsBundle.containsKey(bjmy.f)))
      {
        this.jdField_a_of_type_AndroidOsBundle.putAll(this.jdField_b_of_type_AndroidOsBundle);
        bjnn.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, false, false);
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