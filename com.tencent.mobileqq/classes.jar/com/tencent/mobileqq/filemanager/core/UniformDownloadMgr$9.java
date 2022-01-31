package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import aome;
import aomj;
import apei;
import apek;
import apen;
import apeq;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$9
  implements Runnable
{
  public UniformDownloadMgr$9(aome paramaome, Bundle paramBundle, String paramString, apeq paramapeq) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("_filename_from_dlg");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l))
    {
      localObject = apei.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", ((apek)localObject).jdField_a_of_type_Long);
      if (TextUtils.isEmpty(((apek)localObject).jdField_a_of_type_JavaLangString)) {
        ((apek)localObject).jdField_a_of_type_JavaLangString = "nofilename.x";
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("_filename_from_dlg", ((apek)localObject).jdField_a_of_type_JavaLangString);
    }
    localObject = aome.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((aomj)localObject).a != null))
    {
      int i = ((aomj)localObject).a.f();
      if ((i == 1) || (i == 2))
      {
        if (this.jdField_a_of_type_Apeq != null) {
          ((aomj)localObject).a.a(this.jdField_a_of_type_Apeq);
        }
        apeq localapeq = aome.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        if (localapeq != null) {
          ((aomj)localObject).a.a(localapeq, false);
        }
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] startDownload. URL:" + this.jdField_a_of_type_JavaLangString + " update OuterListenner");
      }
    }
    aome.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    aome.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */