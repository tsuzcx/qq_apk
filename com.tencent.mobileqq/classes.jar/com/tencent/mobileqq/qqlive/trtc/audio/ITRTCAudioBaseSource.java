package com.tencent.mobileqq.qqlive.trtc.audio;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext;

public abstract interface ITRTCAudioBaseSource
{
  public abstract void a();
  
  public abstract void a(@NonNull Handler paramHandler);
  
  public abstract boolean a(@NonNull TRTCEngineContext paramTRTCEngineContext);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.audio.ITRTCAudioBaseSource
 * JD-Core Version:    0.7.0.1
 */