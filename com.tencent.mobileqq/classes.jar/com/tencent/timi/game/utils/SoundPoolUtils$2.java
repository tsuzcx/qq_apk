package com.tencent.timi.game.utils;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import java.util.HashMap;

final class SoundPoolUtils$2
  implements SoundPool.OnLoadCompleteListener
{
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (this.a) {
      paramInt2 = -1;
    } else {
      paramInt2 = 0;
    }
    SoundPoolUtils.b(paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, paramInt2, 1.0F));
    paramSoundPool = (String)SoundPoolUtils.d().get(Integer.valueOf(paramInt1));
    SoundPoolUtils.SoundCache localSoundCache = SoundPoolUtils.a(SoundPoolUtils.e(), paramSoundPool);
    localSoundCache.a = paramInt1;
    if (localSoundCache.b == 0L) {
      localSoundCache.b = SoundPoolUtils.a(this.b, paramSoundPool);
    }
    ThreadPool.a(new SoundPoolUtils.2.1(this), localSoundCache.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.SoundPoolUtils.2
 * JD-Core Version:    0.7.0.1
 */