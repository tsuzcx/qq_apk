package com.tencent.mobileqq.ocr.activity;

import com.tencent.mobileqq.ocr.OcrControl.OcrCallback;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;

class ScanOcrActivity$8
  implements OcrControl.OcrCallback
{
  ScanOcrActivity$8(ScanOcrActivity paramScanOcrActivity) {}
  
  public void a() {}
  
  public void a(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    this.a.runOnUiThread(new ScanOcrActivity.8.1(this, paramString, paramInt, paramOcrRecogResult, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.8
 * JD-Core Version:    0.7.0.1
 */