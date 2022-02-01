package com.tencent.mobileqq.qqlive.trtc.video.source;

import android.graphics.Bitmap;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext;

public abstract interface ITRTCVideoBaseSource
{
  public abstract void a(Bitmap paramBitmap, int paramInt);
  
  public abstract void a(@NonNull Handler paramHandler);
  
  public abstract void a(@NonNull TRTCVideoQualityParams paramTRTCVideoQualityParams);
  
  public abstract void a(@NonNull TRTCEngineContext paramTRTCEngineContext);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract TRTCVideoQualityParams b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.video.source.ITRTCVideoBaseSource
 * JD-Core Version:    0.7.0.1
 */