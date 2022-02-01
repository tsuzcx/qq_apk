package com.tencent.mobileqq.ocr;

import android.text.TextUtils;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OnOptionSelectedListener;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;

class OCRPerformFragment$9
  implements TranslateLanguageOptionsView.OnOptionSelectedListener
{
  OCRPerformFragment$9(OCRPerformFragment paramOCRPerformFragment, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void a(int paramInt, TranslateLanguageOptionsView.OptionItem paramOptionItem)
  {
    if ((paramOptionItem != null) && (!TextUtils.isEmpty(paramOptionItem.b)))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.c.equalsIgnoreCase(paramOptionItem.b)) {
        OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment, this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.b, paramOptionItem.b, false);
      }
      OCRPerformUtil.a("0X800B55A", OCRPerformUtil.a(paramOptionItem.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.9
 * JD-Core Version:    0.7.0.1
 */