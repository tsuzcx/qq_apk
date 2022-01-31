package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import apcy;
import apdd;
import apwc;
import apwe;
import apwh;
import apwk;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$9
  implements Runnable
{
  public UniformDownloadMgr$9(apcy paramapcy, Bundle paramBundle, String paramString, apwk paramapwk) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("_filename_from_dlg");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l))
    {
      localObject = apwc.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", ((apwe)localObject).jdField_a_of_type_Long);
      if (TextUtils.isEmpty(((apwe)localObject).jdField_a_of_type_JavaLangString)) {
        ((apwe)localObject).jdField_a_of_type_JavaLangString = "nofilename.x";
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("_filename_from_dlg", ((apwe)localObject).jdField_a_of_type_JavaLangString);
    }
    localObject = apcy.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((apdd)localObject).a != null))
    {
      int i = ((apdd)localObject).a.f();
      if ((i == 1) || (i == 2))
      {
        if (this.jdField_a_of_type_Apwk != null) {
          ((apdd)localObject).a.a(this.jdField_a_of_type_Apwk);
        }
        apwk localapwk = apcy.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        if (localapwk != null) {
          ((apdd)localObject).a.a(localapwk, false);
        }
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] startDownload. URL:" + this.jdField_a_of_type_JavaLangString + " update OuterListenner");
      }
    }
    apcy.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    apcy.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */