package com.tencent.mobileqq.ocr;

import android.text.TextUtils;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OnOptionSelectedListener;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;

class OCRPerformFragment$7
  implements TranslateLanguageOptionsView.OnOptionSelectedListener
{
  OCRPerformFragment$7(OCRPerformFragment paramOCRPerformFragment, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void a(int paramInt, TranslateLanguageOptionsView.OptionItem paramOptionItem)
  {
    if ((paramOptionItem != null) && (!TextUtils.isEmpty(paramOptionItem.b)))
    {
      if (!this.a.d.equalsIgnoreCase(paramOptionItem.b)) {
        OCRPerformFragment.a(this.b, paramOptionItem.b, this.a.f(paramOptionItem.b), false);
      }
      OCRPerformUtil.a("0X800B559", OCRPerformUtil.c(paramOptionItem.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.7
 * JD-Core Version:    0.7.0.1
 */