package com.tencent.mobileqq.magicface.service;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;

class SoundPoolUtil$1
  implements SoundPool.OnLoadCompleteListener
{
  SoundPoolUtil$1(SoundPoolUtil paramSoundPoolUtil, int paramInt, String paramString) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if ((this.c.a.play(paramInt1, 1.0F, 1.0F, 0, this.a, 1.0F) == 0) && (QLog.isColorLevel()))
    {
      paramSoundPool = new StringBuilder();
      paramSoundPool.append("play failure filepath=");
      paramSoundPool.append(this.b);
      QLog.d("SoundPoolUtil", 2, paramSoundPool.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.SoundPoolUtil.1
 * JD-Core Version:    0.7.0.1
 */