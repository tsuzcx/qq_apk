package com.tencent.thumbplayer.adapter.player;

import android.content.Context;
import com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemClipPlayer;
import com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer;
import com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer;
import com.tencent.thumbplayer.log.TPLoggerContext;

public final class TPPlayerBaseFactory
{
  public static ITPPlayerBase createSystemMediaPlayer(Context paramContext, boolean paramBoolean, TPLoggerContext paramTPLoggerContext)
  {
    if (paramBoolean) {
      return new TPSystemClipPlayer(paramContext, paramTPLoggerContext);
    }
    return new TPSystemMediaPlayer(paramContext, paramTPLoggerContext);
  }
  
  public static ITPPlayerBase createThumbPlayer(Context paramContext, TPLoggerContext paramTPLoggerContext)
  {
    return new TPThumbPlayer(paramContext, paramTPLoggerContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.TPPlayerBaseFactory
 * JD-Core Version:    0.7.0.1
 */