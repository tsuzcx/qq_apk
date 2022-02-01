package com.tencent.mobileqq.ocr.activity;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.ocr.OcrCamera;
import com.tencent.mobileqq.ocr.view.MaskView;

class ScanOcrActivity$7
  implements SurfaceHolder.Callback
{
  ScanOcrActivity$7(ScanOcrActivity paramScanOcrActivity) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    ScanOcrActivity.a(this.a, paramSurfaceHolder);
    if (ScanOcrActivity.m(this.a) == null)
    {
      paramSurfaceHolder = this.a;
      ScanOcrActivity.a(paramSurfaceHolder, new OcrCamera(paramSurfaceHolder, paramSurfaceHolder.l, ScanOcrActivity.n(this.a)));
      ScanOcrActivity.m(this.a).a(this.a.k);
      ScanOcrActivity.m(this.a).a(this.a.j.getPreviewRectF());
      if (ScanOcrActivity.o(this.a)) {
        ScanOcrActivity.m(this.a).a();
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.7
 * JD-Core Version:    0.7.0.1
 */