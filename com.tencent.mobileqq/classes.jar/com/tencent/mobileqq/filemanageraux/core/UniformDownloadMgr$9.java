package com.tencent.mobileqq.filemanageraux.core;

import android.os.Bundle;
import android.text.TextUtils;
import atdm;
import atdr;
import atgn;
import atgp;
import atgs;
import atgv;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$9
  implements Runnable
{
  public UniformDownloadMgr$9(atdm paramatdm, Bundle paramBundle, String paramString, atgv paramatgv) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("_filename_from_dlg");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l))
    {
      localObject = atgn.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", ((atgp)localObject).jdField_a_of_type_Long);
      if (TextUtils.isEmpty(((atgp)localObject).jdField_a_of_type_JavaLangString)) {
        ((atgp)localObject).jdField_a_of_type_JavaLangString = "nofilename.x";
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("_filename_from_dlg", ((atgp)localObject).jdField_a_of_type_JavaLangString);
    }
    localObject = atdm.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((atdr)localObject).a != null))
    {
      int i = ((atdr)localObject).a.f();
      if ((i == 1) || (i == 2))
      {
        if (this.jdField_a_of_type_Atgv != null) {
          ((atdr)localObject).a.a(this.jdField_a_of_type_Atgv);
        }
        atgv localatgv = atdm.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        if (localatgv != null) {
          ((atdr)localObject).a.a(localatgv, false);
        }
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] startDownload. URL:" + this.jdField_a_of_type_JavaLangString + " update OuterListenner");
      }
    }
    atdm.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    atdm.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */