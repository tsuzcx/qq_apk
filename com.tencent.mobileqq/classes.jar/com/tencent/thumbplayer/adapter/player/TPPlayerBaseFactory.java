package com.tencent.thumbplayer.adapter.player;

import android.content.Context;
import com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemClipPlayer;
import com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer;
import com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer;

public final class TPPlayerBaseFactory
{
  public static ITPPlayerBase createSystemMediaPlayer(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new TPSystemClipPlayer(paramContext);
    }
    return new TPSystemMediaPlayer(paramContext);
  }
  
  public static ITPPlayerBase createThumbPlayer(Context paramContext)
  {
    return new TPThumbPlayer(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.TPPlayerBaseFactory
 * JD-Core Version:    0.7.0.1
 */