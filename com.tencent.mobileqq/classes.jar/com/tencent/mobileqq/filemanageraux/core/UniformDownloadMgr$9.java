package com.tencent.mobileqq.filemanageraux.core;

import android.os.Bundle;
import android.text.TextUtils;
import auht;
import auhy;
import auku;
import aukw;
import aukz;
import aulc;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadMgr$9
  implements Runnable
{
  public UniformDownloadMgr$9(auht paramauht, Bundle paramBundle, String paramString, aulc paramaulc) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("_filename_from_dlg");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (0L == l))
    {
      localObject = auku.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", ((aukw)localObject).jdField_a_of_type_Long);
      if (TextUtils.isEmpty(((aukw)localObject).jdField_a_of_type_JavaLangString)) {
        ((aukw)localObject).jdField_a_of_type_JavaLangString = "nofilename.x";
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("_filename_from_dlg", ((aukw)localObject).jdField_a_of_type_JavaLangString);
    }
    localObject = auht.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((auhy)localObject).a != null))
    {
      int i = ((auhy)localObject).a.f();
      if ((i == 1) || (i == 2))
      {
        if (this.jdField_a_of_type_Aulc != null) {
          ((auhy)localObject).a.a(this.jdField_a_of_type_Aulc);
        }
        aulc localaulc = auht.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        if (localaulc != null) {
          ((auhy)localObject).a.a(localaulc, false);
        }
        QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] startDownload. URL:" + this.jdField_a_of_type_JavaLangString + " update OuterListenner");
      }
    }
    auht.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    auht.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.9
 * JD-Core Version:    0.7.0.1
 */