package com.tencent.mobileqq.ocr;

import apnx;
import ayzm;
import ayzo;
import ayzp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$1
  implements Runnable
{
  public OcrControl$1(ayzm paramayzm, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (ayzp.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = ayzp.a(new File(this.jdField_a_of_type_JavaLangString).getName(), false);
      if ((this.jdField_a_of_type_Boolean) && (ayzp.a(this.jdField_a_of_type_JavaLangString, (String)localObject)))
      {
        localapnx = new apnx();
        localapnx.jdField_a_of_type_JavaLangString = ((String)localObject);
        localapnx.jdField_a_of_type_Int = 0;
        localapnx.b = this.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "upload pic size:" + new File((String)localObject).length() / 1024L + "KB");
        }
        this.this$0.a(localapnx, this.b);
      }
    }
    while (ayzm.a(this.this$0) == null)
    {
      apnx localapnx;
      return;
      Object localObject = new apnx();
      ((apnx)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((apnx)localObject).jdField_a_of_type_Int = 0;
      ((apnx)localObject).b = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "upload pic size:" + new File(this.jdField_a_of_type_JavaLangString).length() / 1024L + "KB");
      }
      this.this$0.a((apnx)localObject, this.b);
      return;
    }
    ayzm.a(this.this$0).a(1, null, this.jdField_a_of_type_JavaLangString, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */