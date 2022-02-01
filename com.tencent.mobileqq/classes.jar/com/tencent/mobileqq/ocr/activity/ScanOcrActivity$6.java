package com.tencent.mobileqq.ocr.activity;

import com.tencent.mobileqq.ocr.OcrCamera.CameraCallback;

class ScanOcrActivity$6
  implements OcrCamera.CameraCallback
{
  ScanOcrActivity$6(ScanOcrActivity paramScanOcrActivity) {}
  
  public void a()
  {
    this.a.runOnUiThread(new ScanOcrActivity.6.3(this));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.runOnUiThread(new ScanOcrActivity.6.1(this, paramInt1));
  }
  
  public void a(String paramString)
  {
    this.a.runOnUiThread(new ScanOcrActivity.6.4(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.runOnUiThread(new ScanOcrActivity.6.2(this));
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6
 * JD-Core Version:    0.7.0.1
 */