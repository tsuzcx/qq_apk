package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;

class OCRPerformFragment$11$1
  implements Runnable
{
  OCRPerformFragment$11$1(OCRPerformFragment.11 param11, boolean paramBoolean, TranslateResult paramTranslateResult) {}
  
  public void run()
  {
    OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$11.a, true);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.b()) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()))
    {
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
      OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$11.a, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$11.a.getResources().getString(2131699010);
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.e)) {
        break label140;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.e;
    }
    for (;;)
    {
      QQToast.a(OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$11.a), 1, str1, 0).a();
      OCRPerformUtil.a("0X800B558", 0);
      return;
      label140:
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$11.a.getResources().getString(2131698997);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.11.1
 * JD-Core Version:    0.7.0.1
 */