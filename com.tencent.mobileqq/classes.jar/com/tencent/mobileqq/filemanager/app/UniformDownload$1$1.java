package com.tencent.mobileqq.filemanager.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import aoyd;
import aoye;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;

public class UniformDownload$1$1
  implements Runnable
{
  public UniformDownload$1$1(aoye paramaoye, String paramString, long paramLong) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Aoye.jdField_a_of_type_Aoyd.a, UniformDownloadActivity.class);
    String str1 = this.jdField_a_of_type_Aoye.jdField_a_of_type_AndroidOsBundle.getString("param_content_memo");
    String str2 = this.jdField_a_of_type_Aoye.jdField_a_of_type_AndroidOsBundle.getString("param_icon_path");
    String str3 = this.jdField_a_of_type_Aoye.jdField_a_of_type_AndroidOsBundle.getString("param_mime_type");
    if (str1 != null) {
      localIntent.putExtra(UniformDownloadActivity.h, str1);
    }
    if (str2 != null) {
      localIntent.putExtra(UniformDownloadActivity.g, str2);
    }
    boolean bool = this.jdField_a_of_type_Aoye.jdField_a_of_type_AndroidOsBundle.getBoolean("param_isqbdownload", false);
    localIntent.putExtra(UniformDownloadActivity.i, bool);
    localIntent.putExtra(UniformDownloadActivity.b, this.jdField_a_of_type_Aoye.jdField_a_of_type_JavaLangString);
    localIntent.putExtra(UniformDownloadActivity.d, this.jdField_a_of_type_JavaLangString);
    localIntent.setFlags(536870912);
    if (this.jdField_a_of_type_Aoye.jdField_a_of_type_Long != 0L) {}
    for (long l = this.jdField_a_of_type_Aoye.jdField_a_of_type_Long;; l = this.jdField_a_of_type_Long)
    {
      localIntent.putExtra(UniformDownloadActivity.e, l);
      localIntent.putExtra(UniformDownloadActivity.j, str3);
      if (this.jdField_a_of_type_Aoye.b == 1L) {
        localIntent.putExtra(UniformDownloadActivity.c, this.jdField_a_of_type_Aoye.b);
      }
      localIntent.putExtra("fromArkAppDownload", this.jdField_a_of_type_Aoye.jdField_a_of_type_AndroidOsBundle.getBoolean("fromArkAppDownload", false));
      localIntent.putExtra(UniformDownloadActivity.k, this.jdField_a_of_type_Aoye.jdField_a_of_type_AndroidOsBundle.getString("param_refer_url", ""));
      this.jdField_a_of_type_Aoye.jdField_a_of_type_Aoyd.a.startActivity(localIntent);
      this.jdField_a_of_type_Aoye.jdField_a_of_type_Aoyd.a.overridePendingTransition(0, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.UniformDownload.1.1
 * JD-Core Version:    0.7.0.1
 */