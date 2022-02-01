package com.tencent.mobileqq.qqconnectface.api;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.richmedia.capture.view.CaptureListener;
import com.tencent.mobileqq.richmedia.capture.view.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.OutPreviewCallback;
import com.tencent.mobileqq.richmedia.capture.view.SizeListener;

public abstract interface ICamera
{
  public abstract Bitmap a(Bitmap paramBitmap);
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, OutPreviewCallback paramOutPreviewCallback, boolean paramBoolean);
  
  public abstract void a(CaptureListener paramCaptureListener);
  
  public abstract void a(CaptureParam paramCaptureParam);
  
  public abstract void a(SizeListener paramSizeListener);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public abstract boolean c();
  
  public abstract Camera d();
  
  public abstract int e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqconnectface.api.ICamera
 * JD-Core Version:    0.7.0.1
 */