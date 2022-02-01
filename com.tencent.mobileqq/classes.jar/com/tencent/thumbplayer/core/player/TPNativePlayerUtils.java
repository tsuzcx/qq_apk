package com.tencent.thumbplayer.core.player;

import android.view.Surface;
import com.tencent.thumbplayer.core.common.TPMethodCalledByNative;

public class TPNativePlayerUtils
{
  @TPMethodCalledByNative
  static boolean isTPNativePlayerSurface(Surface paramSurface)
  {
    return paramSurface instanceof TPNativePlayerSurface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPNativePlayerUtils
 * JD-Core Version:    0.7.0.1
 */