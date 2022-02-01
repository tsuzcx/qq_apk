package com.tencent.mobileqq.ocr;

import apkm;
import aytd;
import aytf;
import aytg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$1
  implements Runnable
{
  public OcrControl$1(aytd paramaytd, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (aytg.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = aytg.a(new File(this.jdField_a_of_type_JavaLangString).getName(), false);
      if ((this.jdField_a_of_type_Boolean) && (aytg.a(this.jdField_a_of_type_JavaLangString, (String)localObject)))
      {
        localapkm = new apkm();
        localapkm.jdField_a_of_type_JavaLangString = ((String)localObject);
        localapkm.jdField_a_of_type_Int = 0;
        localapkm.b = this.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "upload pic size:" + new File((String)localObject).length() / 1024L + "KB");
        }
        this.this$0.a(localapkm, this.b);
      }
    }
    while (aytd.a(this.this$0) == null)
    {
      apkm localapkm;
      return;
      Object localObject = new apkm();
      ((apkm)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((apkm)localObject).jdField_a_of_type_Int = 0;
      ((apkm)localObject).b = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "upload pic size:" + new File(this.jdField_a_of_type_JavaLangString).length() / 1024L + "KB");
      }
      this.this$0.a((apkm)localObject, this.b);
      return;
    }
    aytd.a(this.this$0).a(1, null, this.jdField_a_of_type_JavaLangString, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */