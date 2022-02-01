package com.tencent.mobileqq.ocr;

import apah;
import aygt;
import aygv;
import aygw;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$1
  implements Runnable
{
  public OcrControl$1(aygt paramaygt, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (aygw.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = aygw.a(new File(this.jdField_a_of_type_JavaLangString).getName(), false);
      if ((this.jdField_a_of_type_Boolean) && (aygw.a(this.jdField_a_of_type_JavaLangString, (String)localObject)))
      {
        localapah = new apah();
        localapah.jdField_a_of_type_JavaLangString = ((String)localObject);
        localapah.jdField_a_of_type_Int = 0;
        localapah.b = this.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "upload pic size:" + new File((String)localObject).length() / 1024L + "KB");
        }
        this.this$0.a(localapah, this.b);
      }
    }
    while (aygt.a(this.this$0) == null)
    {
      apah localapah;
      return;
      Object localObject = new apah();
      ((apah)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((apah)localObject).jdField_a_of_type_Int = 0;
      ((apah)localObject).b = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "upload pic size:" + new File(this.jdField_a_of_type_JavaLangString).length() / 1024L + "KB");
      }
      this.this$0.a((apah)localObject, this.b);
      return;
    }
    aygt.a(this.this$0).a(1, null, this.jdField_a_of_type_JavaLangString, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */