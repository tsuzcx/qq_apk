package com.tencent.mobileqq.magicface.service;

import android.media.SoundPool;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class SoundPoolUtil$2
  extends TimerTask
{
  SoundPoolUtil$2(SoundPoolUtil paramSoundPoolUtil, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.play(this.a, 1.0F, 1.0F, 0, 0, 1.0F) == 0) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play failure filepath=");
      localStringBuilder.append(this.b);
      QLog.d("SoundPoolUtil", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.SoundPoolUtil.2
 * JD-Core Version:    0.7.0.1
 */