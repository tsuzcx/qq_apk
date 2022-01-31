package com.tencent.mobileqq.ocr;

import anbq;
import avxb;
import avxd;
import avxe;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$1
  implements Runnable
{
  public OcrControl$1(avxb paramavxb, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (avxe.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = avxe.a(new File(this.jdField_a_of_type_JavaLangString).getName(), false);
      if ((this.jdField_a_of_type_Boolean) && (avxe.a(this.jdField_a_of_type_JavaLangString, (String)localObject)))
      {
        localanbq = new anbq();
        localanbq.jdField_a_of_type_JavaLangString = ((String)localObject);
        localanbq.jdField_a_of_type_Int = 0;
        localanbq.b = this.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "upload pic size:" + new File((String)localObject).length() / 1024L + "KB");
        }
        this.this$0.a(localanbq, this.b);
      }
    }
    while (avxb.a(this.this$0) == null)
    {
      anbq localanbq;
      return;
      Object localObject = new anbq();
      ((anbq)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((anbq)localObject).jdField_a_of_type_Int = 0;
      ((anbq)localObject).b = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "upload pic size:" + new File(this.jdField_a_of_type_JavaLangString).length() / 1024L + "KB");
      }
      this.this$0.a((anbq)localObject, this.b);
      return;
    }
    avxb.a(this.this$0).a(1, null, this.jdField_a_of_type_JavaLangString, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */