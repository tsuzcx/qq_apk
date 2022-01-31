package com.tencent.mobileqq.ocr;

import amxh;
import avss;
import avsu;
import avsv;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$1
  implements Runnable
{
  public OcrControl$1(avss paramavss, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (avsv.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = avsv.a(new File(this.jdField_a_of_type_JavaLangString).getName(), false);
      if ((this.jdField_a_of_type_Boolean) && (avsv.a(this.jdField_a_of_type_JavaLangString, (String)localObject)))
      {
        localamxh = new amxh();
        localamxh.jdField_a_of_type_JavaLangString = ((String)localObject);
        localamxh.jdField_a_of_type_Int = 0;
        localamxh.b = this.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "upload pic size:" + new File((String)localObject).length() / 1024L + "KB");
        }
        this.this$0.a(localamxh, this.b);
      }
    }
    while (avss.a(this.this$0) == null)
    {
      amxh localamxh;
      return;
      Object localObject = new amxh();
      ((amxh)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((amxh)localObject).jdField_a_of_type_Int = 0;
      ((amxh)localObject).b = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "upload pic size:" + new File(this.jdField_a_of_type_JavaLangString).length() / 1024L + "KB");
      }
      this.this$0.a((amxh)localObject, this.b);
      return;
    }
    avss.a(this.this$0).a(1, null, this.jdField_a_of_type_JavaLangString, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */