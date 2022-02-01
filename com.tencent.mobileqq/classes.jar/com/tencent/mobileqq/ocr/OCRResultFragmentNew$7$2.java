package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class OCRResultFragmentNew$7$2
  implements Runnable
{
  OCRResultFragmentNew$7$2(OCRResultFragmentNew.7 param7, String paramString) {}
  
  public void run()
  {
    try
    {
      OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew$7.a).dismiss();
      OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew$7.a).a(0);
      OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew$7.a, true);
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew$7.a), 2, HardCodeUtil.a(2131707825), 1).a();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew$7.a.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew$7.a), 1, HardCodeUtil.a(2131707819), 0).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.7.2
 * JD-Core Version:    0.7.0.1
 */