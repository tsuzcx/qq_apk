package com.tencent.mobileqq.ocr;

import android.text.TextUtils;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;

class OCRResultActivity$11
  implements OcrControl.OcrCallback
{
  OCRResultActivity$11(OCRResultActivity paramOCRResultActivity) {}
  
  public void a() {}
  
  public void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(OCRResultActivity.a(this.a)))) {
      return;
    }
    this.a.runOnUiThread(new OCRResultActivity.11.1(this, paramInt, paramOcrRecogResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.11
 * JD-Core Version:    0.7.0.1
 */