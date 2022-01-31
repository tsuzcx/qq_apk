package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import apdc;
import apdh;
import apwe;
import apwg;
import apwj;
import apwm;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$9
  implements Runnable
{
  public UniformDownloadMgr$9(apdc paramapdc, Bundle paramBundle, String paramString, apwm paramapwm) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("_filename_from_dlg");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l))
    {
      localObject = apwe.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", ((apwg)localObject).jdField_a_of_type_Long);
      if (TextUtils.isEmpty(((apwg)localObject).jdField_a_of_type_JavaLangString)) {
        ((apwg)localObject).jdField_a_of_type_JavaLangString = "nofilename.x";
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("_filename_from_dlg", ((apwg)localObject).jdField_a_of_type_JavaLangString);
    }
    localObject = apdc.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((apdh)localObject).a != null))
    {
      int i = ((apdh)localObject).a.f();
      if ((i == 1) || (i == 2))
      {
        if (this.jdField_a_of_type_Apwm != null) {
          ((apdh)localObject).a.a(this.jdField_a_of_type_Apwm);
        }
        apwm localapwm = apdc.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        if (localapwm != null) {
          ((apdh)localObject).a.a(localapwm, false);
        }
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] startDownload. URL:" + this.jdField_a_of_type_JavaLangString + " update OuterListenner");
      }
    }
    apdc.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    apdc.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */