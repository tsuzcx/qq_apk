package com.tencent.mobileqq.ocr;

import android.text.TextUtils;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OnOptionSelectedListener;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;

class TranslateFragment$2
  implements TranslateLanguageOptionsView.OnOptionSelectedListener
{
  TranslateFragment$2(TranslateFragment paramTranslateFragment, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void a(int paramInt, TranslateLanguageOptionsView.OptionItem paramOptionItem)
  {
    if ((paramOptionItem != null) && (!TextUtils.isEmpty(paramOptionItem.b)))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.b.equalsIgnoreCase(paramOptionItem.b)) {
        TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment, paramOptionItem.b, this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.b(paramOptionItem.b));
      }
      OCRPerformUtil.a("0X800AD30", OCRPerformUtil.a(paramOptionItem.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.2
 * JD-Core Version:    0.7.0.1
 */