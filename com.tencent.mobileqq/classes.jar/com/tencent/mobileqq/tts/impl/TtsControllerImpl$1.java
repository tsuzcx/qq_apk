package com.tencent.mobileqq.tts.impl;

import android.os.Handler;
import com.tencent.mobileqq.tts.TtsListener;
import com.tencent.mobileqq.tts.silk.IPlayerCallback;

class TtsControllerImpl$1
  implements IPlayerCallback
{
  TtsControllerImpl$1(TtsControllerImpl paramTtsControllerImpl) {}
  
  public void a()
  {
    if (TtsControllerImpl.access$000(this.a) != null) {
      TtsControllerImpl.access$000(this.a).b(TtsControllerImpl.access$100(this.a));
    }
  }
  
  public void b()
  {
    if (TtsControllerImpl.access$000(this.a) != null) {
      TtsControllerImpl.access$000(this.a).d();
    }
  }
  
  public void c()
  {
    TtsControllerImpl.access$200(this.a).removeMessages(0);
    TtsControllerImpl.access$200(this.a).sendEmptyMessageDelayed(0, 1000L);
  }
  
  public void d()
  {
    TtsControllerImpl.access$200(this.a).removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.impl.TtsControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */