package com.tencent.mobileqq.filemanageraux.core;

import android.os.Bundle;
import android.text.TextUtils;
import aure;
import aurj;
import auuf;
import auuh;
import auuk;
import auun;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$9
  implements Runnable
{
  public UniformDownloadMgr$9(aure paramaure, Bundle paramBundle, String paramString, auun paramauun) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("_filename_from_dlg");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l))
    {
      localObject = auuf.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", ((auuh)localObject).jdField_a_of_type_Long);
      if (TextUtils.isEmpty(((auuh)localObject).jdField_a_of_type_JavaLangString)) {
        ((auuh)localObject).jdField_a_of_type_JavaLangString = "nofilename.x";
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("_filename_from_dlg", ((auuh)localObject).jdField_a_of_type_JavaLangString);
    }
    localObject = aure.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((aurj)localObject).a != null))
    {
      int i = ((aurj)localObject).a.f();
      if ((i == 1) || (i == 2))
      {
        if (this.jdField_a_of_type_Auun != null) {
          ((aurj)localObject).a.a(this.jdField_a_of_type_Auun);
        }
        auun localauun = aure.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        if (localauun != null) {
          ((aurj)localObject).a.a(localauun, false);
        }
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] startDownload. URL:" + this.jdField_a_of_type_JavaLangString + " update OuterListenner");
      }
    }
    aure.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    aure.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */