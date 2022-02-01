package com.tencent.sharp.jni.api.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.callback.OnCompletionListener;
import java.util.TimerTask;

class TraeMediaPlayerApiImpl$2
  extends TimerTask
{
  TraeMediaPlayerApiImpl$2(TraeMediaPlayerApiImpl paramTraeMediaPlayerApiImpl, long paramLong) {}
  
  public void run()
  {
    if (TraeMediaPlayerApiImpl.access$100(this.this$0) != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playRing, onCompletion, seq[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("]");
        QLog.w("TraeMediaPlayerImpl", 1, localStringBuilder.toString());
      }
      if (TraeMediaPlayerApiImpl.access$000(this.this$0) != null) {
        TraeMediaPlayerApiImpl.access$000(this.this$0).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.api.impl.TraeMediaPlayerApiImpl.2
 * JD-Core Version:    0.7.0.1
 */