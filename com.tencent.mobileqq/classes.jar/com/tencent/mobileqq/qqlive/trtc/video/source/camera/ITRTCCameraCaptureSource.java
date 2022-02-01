package com.tencent.mobileqq.qqlive.trtc.video.source.camera;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.trtc.render.ILocalRender;
import com.tencent.mobileqq.qqlive.trtc.video.source.ITRTCVideoBaseSource;

public abstract interface ITRTCCameraCaptureSource
  extends ITRTCVideoBaseSource
{
  public abstract void a();
  
  public abstract void a(@NonNull ILocalRender paramILocalRender);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void f();
  
  public abstract boolean g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.video.source.camera.ITRTCCameraCaptureSource
 * JD-Core Version:    0.7.0.1
 */