package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class OCRResultActivity$10$2
  implements Runnable
{
  OCRResultActivity$10$2(OCRResultActivity.10 param10, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultActivity$10.a).dismiss();
      OCRResultActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultActivity$10.a).a(0);
      OCRResultActivity.d(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultActivity$10.a, false);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultActivity$10.a, 2, HardCodeUtil.a(2131707801), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultActivity$10.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultActivity$10.a, 1, HardCodeUtil.a(2131707795), 0).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.10.2
 * JD-Core Version:    0.7.0.1
 */