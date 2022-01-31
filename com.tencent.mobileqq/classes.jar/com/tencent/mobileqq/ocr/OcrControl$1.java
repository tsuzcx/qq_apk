package com.tencent.mobileqq.ocr;

import algs;
import aubm;
import aubo;
import aubp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$1
  implements Runnable
{
  public OcrControl$1(aubm paramaubm, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (aubp.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = aubp.a(new File(this.jdField_a_of_type_JavaLangString).getName(), false);
      if ((this.jdField_a_of_type_Boolean) && (aubp.a(this.jdField_a_of_type_JavaLangString, (String)localObject)))
      {
        localalgs = new algs();
        localalgs.jdField_a_of_type_JavaLangString = ((String)localObject);
        localalgs.jdField_a_of_type_Int = 0;
        localalgs.b = this.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "upload pic size:" + new File((String)localObject).length() / 1024L + "KB");
        }
        this.this$0.a(localalgs, this.b);
      }
    }
    while (aubm.a(this.this$0) == null)
    {
      algs localalgs;
      return;
      Object localObject = new algs();
      ((algs)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((algs)localObject).jdField_a_of_type_Int = 0;
      ((algs)localObject).b = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "upload pic size:" + new File(this.jdField_a_of_type_JavaLangString).length() / 1024L + "KB");
      }
      this.this$0.a((algs)localObject, this.b);
      return;
    }
    aubm.a(this.this$0).a(1, null, this.jdField_a_of_type_JavaLangString, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */