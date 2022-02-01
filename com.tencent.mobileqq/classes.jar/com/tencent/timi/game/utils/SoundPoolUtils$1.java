package com.tencent.timi.game.utils;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import java.util.ArrayList;

final class SoundPoolUtils$1
  implements SoundPool.OnLoadCompleteListener
{
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    SoundPoolUtils.a(paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F));
    paramSoundPool = SoundPoolUtils.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("soundPoolQueue play:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", status:");
    ((StringBuilder)localObject).append(paramInt2);
    Logger.b(paramSoundPool, ((StringBuilder)localObject).toString());
    if (SoundPoolUtils.b().size() == 0)
    {
      SoundPoolUtils.a(false);
      return;
    }
    paramSoundPool = (SoundPoolUtils.SoundPlayTask)SoundPoolUtils.b().remove(0);
    localObject = SoundPoolUtils.a(SoundPoolUtils.c(), paramSoundPool.a);
    ((SoundPoolUtils.SoundCache)localObject).a = paramInt1;
    if (((SoundPoolUtils.SoundCache)localObject).b == 0L) {
      ((SoundPoolUtils.SoundCache)localObject).b = SoundPoolUtils.a(this.a, paramSoundPool.a);
    }
    long l1 = ((SoundPoolUtils.SoundCache)localObject).b;
    long l2 = paramSoundPool.b;
    ThreadPool.a(new SoundPoolUtils.1.1(this), l1 + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.SoundPoolUtils.1
 * JD-Core Version:    0.7.0.1
 */