package com.tencent.mobileqq.ocr;

import algr;
import aubo;
import aubq;
import aubr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$1
  implements Runnable
{
  public OcrControl$1(aubo paramaubo, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (aubr.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = aubr.a(new File(this.jdField_a_of_type_JavaLangString).getName(), false);
      if ((this.jdField_a_of_type_Boolean) && (aubr.a(this.jdField_a_of_type_JavaLangString, (String)localObject)))
      {
        localalgr = new algr();
        localalgr.jdField_a_of_type_JavaLangString = ((String)localObject);
        localalgr.jdField_a_of_type_Int = 0;
        localalgr.b = this.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "upload pic size:" + new File((String)localObject).length() / 1024L + "KB");
        }
        this.this$0.a(localalgr, this.b);
      }
    }
    while (aubo.a(this.this$0) == null)
    {
      algr localalgr;
      return;
      Object localObject = new algr();
      ((algr)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((algr)localObject).jdField_a_of_type_Int = 0;
      ((algr)localObject).b = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "upload pic size:" + new File(this.jdField_a_of_type_JavaLangString).length() / 1024L + "KB");
      }
      this.this$0.a((algr)localObject, this.b);
      return;
    }
    aubo.a(this.this$0).a(1, null, this.jdField_a_of_type_JavaLangString, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */