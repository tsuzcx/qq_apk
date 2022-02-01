package com.tencent.mobileqq.filemanager.activity;

import asrm;
import com.tencent.qphone.base.util.QLog;

public class FilePreviewActivity$16$2
  implements Runnable
{
  public FilePreviewActivity$16$2(asrm paramasrm, int paramInt1, boolean paramBoolean, int paramInt2, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Asrm.a.a(this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFinish  process Over");
      return;
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Asrm.a.b(this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.2
 * JD-Core Version:    0.7.0.1
 */