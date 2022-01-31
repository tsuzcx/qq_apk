package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import aqwa;
import aqwf;
import arpg;
import arpi;
import arpl;
import arpo;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$9
  implements Runnable
{
  public UniformDownloadMgr$9(aqwa paramaqwa, Bundle paramBundle, String paramString, arpo paramarpo) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("_filename_from_dlg");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l))
    {
      localObject = arpg.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", ((arpi)localObject).jdField_a_of_type_Long);
      if (TextUtils.isEmpty(((arpi)localObject).jdField_a_of_type_JavaLangString)) {
        ((arpi)localObject).jdField_a_of_type_JavaLangString = "nofilename.x";
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("_filename_from_dlg", ((arpi)localObject).jdField_a_of_type_JavaLangString);
    }
    localObject = aqwa.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((aqwf)localObject).a != null))
    {
      int i = ((aqwf)localObject).a.f();
      if ((i == 1) || (i == 2))
      {
        if (this.jdField_a_of_type_Arpo != null) {
          ((aqwf)localObject).a.a(this.jdField_a_of_type_Arpo);
        }
        arpo localarpo = aqwa.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        if (localarpo != null) {
          ((aqwf)localObject).a.a(localarpo, false);
        }
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] startDownload. URL:" + this.jdField_a_of_type_JavaLangString + " update OuterListenner");
      }
    }
    aqwa.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    aqwa.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */