package com.tencent.mobileqq.ocr;

import android.text.TextUtils;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OnOptionSelectedListener;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;

class TranslateFragment$4
  implements TranslateLanguageOptionsView.OnOptionSelectedListener
{
  TranslateFragment$4(TranslateFragment paramTranslateFragment, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void a(int paramInt, TranslateLanguageOptionsView.OptionItem paramOptionItem)
  {
    if ((paramOptionItem != null) && (!TextUtils.isEmpty(paramOptionItem.b)))
    {
      if (!this.a.e.equalsIgnoreCase(paramOptionItem.b)) {
        TranslateFragment.a(this.b, this.a.d, paramOptionItem.b);
      }
      OCRPerformUtil.a("0X800AD31", OCRPerformUtil.c(paramOptionItem.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.4
 * JD-Core Version:    0.7.0.1
 */