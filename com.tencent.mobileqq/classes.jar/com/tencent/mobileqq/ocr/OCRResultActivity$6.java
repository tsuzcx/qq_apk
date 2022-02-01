package com.tencent.mobileqq.ocr;

import android.text.TextUtils;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OnOptionSelectedListener;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;

class OCRResultActivity$6
  implements TranslateLanguageOptionsView.OnOptionSelectedListener
{
  OCRResultActivity$6(OCRResultActivity paramOCRResultActivity) {}
  
  public void a(int paramInt, TranslateLanguageOptionsView.OptionItem paramOptionItem)
  {
    if ((paramOptionItem != null) && (!TextUtils.isEmpty(OCRResultActivity.c(this.a))) && (!OCRResultActivity.c(this.a).equals(paramOptionItem.b)))
    {
      OCRResultActivity.c(this.a, paramOptionItem.b);
      OCRResultActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.6
 * JD-Core Version:    0.7.0.1
 */