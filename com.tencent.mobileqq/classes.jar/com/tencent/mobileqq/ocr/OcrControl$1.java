package com.tencent.mobileqq.ocr;

import aohk;
import axmu;
import axmw;
import axmx;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class OcrControl$1
  implements Runnable
{
  public OcrControl$1(axmu paramaxmu, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (axmx.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = axmx.a(new File(this.jdField_a_of_type_JavaLangString).getName(), false);
      if ((this.jdField_a_of_type_Boolean) && (axmx.a(this.jdField_a_of_type_JavaLangString, (String)localObject)))
      {
        localaohk = new aohk();
        localaohk.jdField_a_of_type_JavaLangString = ((String)localObject);
        localaohk.jdField_a_of_type_Int = 0;
        localaohk.b = this.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "upload pic size:" + new File((String)localObject).length() / 1024L + "KB");
        }
        this.this$0.a(localaohk, this.b);
      }
    }
    while (axmu.a(this.this$0) == null)
    {
      aohk localaohk;
      return;
      Object localObject = new aohk();
      ((aohk)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((aohk)localObject).jdField_a_of_type_Int = 0;
      ((aohk)localObject).b = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "upload pic size:" + new File(this.jdField_a_of_type_JavaLangString).length() / 1024L + "KB");
      }
      this.this$0.a((aohk)localObject, this.b);
      return;
    }
    axmu.a(this.this$0).a(1, null, this.jdField_a_of_type_JavaLangString, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */