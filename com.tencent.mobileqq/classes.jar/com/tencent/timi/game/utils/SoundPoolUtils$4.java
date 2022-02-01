package com.tencent.timi.game.utils;

import android.media.SoundPool;

final class SoundPoolUtils$4
  implements Runnable
{
  public void run()
  {
    if (SoundPoolUtils.h() != null)
    {
      SoundPoolUtils.h().release();
      SoundPoolUtils.a(null);
      SoundPoolUtils.a(null);
    }
    if (SoundPoolUtils.i() != null)
    {
      SoundPoolUtils.i().release();
      SoundPoolUtils.b(null);
      SoundPoolUtils.b(null);
    }
    if (SoundPoolUtils.j() != null)
    {
      SoundPoolUtils.j().release();
      SoundPoolUtils.c(null);
      SoundPoolUtils.c(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.SoundPoolUtils.4
 * JD-Core Version:    0.7.0.1
 */