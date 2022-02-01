package com.tencent.timi.game.utils;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import java.util.HashMap;

final class SoundPoolUtils$3
  implements SoundPool.OnLoadCompleteListener
{
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    SoundPoolUtils.c(paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F));
    paramSoundPool = (String)SoundPoolUtils.f().get(Integer.valueOf(paramInt1));
    SoundPoolUtils.SoundCache localSoundCache = SoundPoolUtils.a(SoundPoolUtils.g(), paramSoundPool);
    localSoundCache.a = paramInt1;
    if (localSoundCache.b == 0L) {
      localSoundCache.b = SoundPoolUtils.a(this.a, paramSoundPool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.SoundPoolUtils.3
 * JD-Core Version:    0.7.0.1
 */