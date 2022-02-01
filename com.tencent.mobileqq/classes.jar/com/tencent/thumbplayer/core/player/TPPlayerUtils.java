package com.tencent.thumbplayer.core.player;

import android.view.Surface;
import com.tencent.thumbplayer.core.common.TPMethodCalledByNative;

public class TPPlayerUtils
{
  @TPMethodCalledByNative
  static boolean isTpSurface(Surface paramSurface)
  {
    return paramSurface instanceof TPSurface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPPlayerUtils
 * JD-Core Version:    0.7.0.1
 */