package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import araj;
import artp;
import artr;

public class UniformDownloadMgr$8
  implements Runnable
{
  public UniformDownloadMgr$8(araj paramaraj, Bundle paramBundle, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("_filename_from_dlg");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l) || (-1L == l))
    {
      localObject = artp.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", ((artr)localObject).jdField_a_of_type_Long);
      if (TextUtils.isEmpty(((artr)localObject).jdField_a_of_type_JavaLangString)) {
        ((artr)localObject).jdField_a_of_type_JavaLangString = "nofilename.x";
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("_filename_from_dlg", ((artr)localObject).jdField_a_of_type_JavaLangString);
    }
    araj.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    araj.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.8
 * JD-Core Version:    0.7.0.1
 */