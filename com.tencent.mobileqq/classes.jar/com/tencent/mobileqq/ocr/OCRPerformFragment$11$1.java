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
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
      if ((localObject != null) && (((TranslateResult)localObject).b()) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()))
      {
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
        OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$11.a, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
        return;
      }
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$11.a.getResources().getString(2131699088);
    TranslateResult localTranslateResult = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
    Object localObject = str;
    if (localTranslateResult != null) {
      if (!TextUtils.isEmpty(localTranslateResult.e))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.e;
      }
      else
      {
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$11.a.getResources().getString(2131699075);
        }
      }
    }
    QQToast.a(OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$11.a), 1, (CharSequence)localObject, 0).a();
    OCRPerformUtil.a("0X800B558", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.11.1
 * JD-Core Version:    0.7.0.1
 */