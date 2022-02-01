package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.content.res.Resources;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.qphone.base.util.QLog;

public class CameraPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  SurfaceHolder a;
  public SurfacePreviewContext b;
  
  public CameraPreview(Context paramContext)
  {
    super(paramContext);
    super.getResources().getDisplayMetrics();
    this.a = getHolder();
    this.a.addCallback(this);
    this.a.setType(3);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreview", 2, "[@] surfaceChanged end");
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.b.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.b.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview
 * JD-Core Version:    0.7.0.1
 */