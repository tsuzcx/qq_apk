package com.tencent.mobileqq.filemanager.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import aqrb;
import aqrc;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;

public class UniformDownload$1$1
  implements Runnable
{
  public UniformDownload$1$1(aqrc paramaqrc, String paramString, long paramLong) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Aqrc.jdField_a_of_type_Aqrb.a, UniformDownloadActivity.class);
    Object localObject = this.jdField_a_of_type_Aqrc.jdField_a_of_type_AndroidOsBundle.getString("param_content_memo");
    String str1 = this.jdField_a_of_type_Aqrc.jdField_a_of_type_AndroidOsBundle.getString("param_icon_path");
    String str2 = this.jdField_a_of_type_Aqrc.jdField_a_of_type_AndroidOsBundle.getString("param_mime_type");
    if (localObject != null) {
      localIntent.putExtra(UniformDownloadActivity.h, (String)localObject);
    }
    if (str1 != null) {
      localIntent.putExtra(UniformDownloadActivity.g, str1);
    }
    boolean bool = this.jdField_a_of_type_Aqrc.jdField_a_of_type_AndroidOsBundle.getBoolean("param_isqbdownload", false);
    localIntent.putExtra(UniformDownloadActivity.i, bool);
    localIntent.putExtra(UniformDownloadActivity.b, this.jdField_a_of_type_Aqrc.jdField_a_of_type_JavaLangString);
    localIntent.putExtra(UniformDownloadActivity.d, this.jdField_a_of_type_JavaLangString);
    localIntent.setFlags(536870912);
    if (this.jdField_a_of_type_Aqrc.jdField_a_of_type_Long != 0L) {}
    for (long l = this.jdField_a_of_type_Aqrc.jdField_a_of_type_Long;; l = this.jdField_a_of_type_Long)
    {
      localIntent.putExtra(UniformDownloadActivity.e, l);
      localIntent.putExtra(UniformDownloadActivity.j, str2);
      if (this.jdField_a_of_type_Aqrc.b == 1L) {
        localIntent.putExtra(UniformDownloadActivity.c, this.jdField_a_of_type_Aqrc.b);
      }
      localIntent.putExtra("fromArkAppDownload", this.jdField_a_of_type_Aqrc.jdField_a_of_type_AndroidOsBundle.getBoolean("fromArkAppDownload", false));
      localIntent.putExtra(UniformDownloadActivity.k, this.jdField_a_of_type_Aqrc.jdField_a_of_type_AndroidOsBundle.getString("param_refer_url", ""));
      localObject = this.jdField_a_of_type_Aqrc.jdField_a_of_type_Aqrb.a.getIntent();
      if (localObject != null)
      {
        localIntent.putExtra("big_brother_source_key", ((Intent)localObject).getStringExtra("big_brother_source_key"));
        localIntent.putExtra("big_brother_ref_source_key", ((Intent)localObject).getStringExtra("big_brother_ref_source_key"));
      }
      this.jdField_a_of_type_Aqrc.jdField_a_of_type_Aqrb.a.startActivity(localIntent);
      this.jdField_a_of_type_Aqrc.jdField_a_of_type_Aqrb.a.overridePendingTransition(0, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.UniformDownload.1.1
 * JD-Core Version:    0.7.0.1
 */