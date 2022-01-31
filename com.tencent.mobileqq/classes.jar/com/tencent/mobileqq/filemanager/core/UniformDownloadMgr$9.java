package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import araj;
import arao;
import artp;
import artr;
import artu;
import artx;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$9
  implements Runnable
{
  public UniformDownloadMgr$9(araj paramaraj, Bundle paramBundle, String paramString, artx paramartx) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("_filename_from_dlg");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l))
    {
      localObject = artp.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", ((artr)localObject).jdField_a_of_type_Long);
      if (TextUtils.isEmpty(((artr)localObject).jdField_a_of_type_JavaLangString)) {
        ((artr)localObject).jdField_a_of_type_JavaLangString = "nofilename.x";
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("_filename_from_dlg", ((artr)localObject).jdField_a_of_type_JavaLangString);
    }
    localObject = araj.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((arao)localObject).a != null))
    {
      int i = ((arao)localObject).a.f();
      if ((i == 1) || (i == 2))
      {
        if (this.jdField_a_of_type_Artx != null) {
          ((arao)localObject).a.a(this.jdField_a_of_type_Artx);
        }
        artx localartx = araj.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        if (localartx != null) {
          ((arao)localObject).a.a(localartx, false);
        }
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] startDownload. URL:" + this.jdField_a_of_type_JavaLangString + " update OuterListenner");
      }
    }
    araj.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    araj.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */