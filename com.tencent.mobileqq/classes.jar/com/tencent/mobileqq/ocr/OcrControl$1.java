package com.tencent.mobileqq.ocr;

import aksg;
import ateq;
import ates;
import atet;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$1
  implements Runnable
{
  public OcrControl$1(ateq paramateq, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (atet.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = atet.a(new File(this.jdField_a_of_type_JavaLangString).getName(), false);
      if ((this.jdField_a_of_type_Boolean) && (atet.a(this.jdField_a_of_type_JavaLangString, (String)localObject)))
      {
        localaksg = new aksg();
        localaksg.jdField_a_of_type_JavaLangString = ((String)localObject);
        localaksg.jdField_a_of_type_Int = 0;
        localaksg.b = this.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "upload pic size:" + new File((String)localObject).length() / 1024L + "KB");
        }
        this.this$0.a(localaksg, this.b);
      }
    }
    while (ateq.a(this.this$0) == null)
    {
      aksg localaksg;
      return;
      Object localObject = new aksg();
      ((aksg)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((aksg)localObject).jdField_a_of_type_Int = 0;
      ((aksg)localObject).b = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "upload pic size:" + new File(this.jdField_a_of_type_JavaLangString).length() / 1024L + "KB");
      }
      this.this$0.a((aksg)localObject, this.b);
      return;
    }
    ateq.a(this.this$0).a(1, null, this.jdField_a_of_type_JavaLangString, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */