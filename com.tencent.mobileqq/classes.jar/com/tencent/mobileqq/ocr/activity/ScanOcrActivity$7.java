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
    if (ScanOcrActivity.a(this.a) == null)
    {
      paramSurfaceHolder = this.a;
      ScanOcrActivity.a(paramSurfaceHolder, new OcrCamera(paramSurfaceHolder, paramSurfaceHolder.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback, ScanOcrActivity.a(this.a)));
      ScanOcrActivity.a(this.a).a(this.a.jdField_a_of_type_Int);
      ScanOcrActivity.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.a());
      if (ScanOcrActivity.a(this.a)) {
        ScanOcrActivity.a(this.a).a();
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.7
 * JD-Core Version:    0.7.0.1
 */