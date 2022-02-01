package com.tencent.mobileqq.qqlive.trtc.audio;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import java.util.concurrent.atomic.AtomicBoolean;

public class TRTCAudioSource
  implements ITRTCAudioSource
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  private TRTCCloud b;
  
  private int b(int paramInt)
  {
    int i = 1;
    if (paramInt != 1)
    {
      i = 3;
      if (paramInt != 3) {
        return 2;
      }
    }
    return i;
  }
  
  private void f()
  {
    if (this.b != null) {
      return;
    }
    throw new IllegalStateException("audio source is not set to audio source ctrl");
  }
  
  public void a()
  {
    if (!e())
    {
      QLog.e("TRTCAudioSource", 1, "return, source is not inited");
      return;
    }
    TRTCCloud localTRTCCloud = this.b;
    if (localTRTCCloud != null)
    {
      localTRTCCloud.stopLocalAudio();
      this.b.setAudioFrameListener(null);
      this.b = null;
    }
    this.a.set(false);
  }
  
  public void a(int paramInt)
  {
    f();
    if (this.a.compareAndSet(false, true)) {
      this.b.startLocalAudio(b(paramInt));
    }
  }
  
  public void a(@NonNull Handler paramHandler) {}
  
  public boolean a(@NonNull TRTCEngineContext paramTRTCEngineContext)
  {
    this.b = paramTRTCEngineContext.a;
    return true;
  }
  
  public void b()
  {
    TRTCCloud localTRTCCloud = this.b;
    if (localTRTCCloud != null) {
      localTRTCCloud.muteLocalAudio(true);
    }
  }
  
  public void c()
  {
    TRTCCloud localTRTCCloud = this.b;
    if (localTRTCCloud != null) {
      localTRTCCloud.muteLocalAudio(false);
    }
  }
  
  public void d()
  {
    f();
    if (this.a.compareAndSet(true, false)) {
      this.b.stopLocalAudio();
    }
  }
  
  public boolean e()
  {
    return this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.audio.TRTCAudioSource
 * JD-Core Version:    0.7.0.1
 */