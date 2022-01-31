package com.tencent.superplayer.api;

import android.content.Context;
import com.tencent.superplayer.datatransport.SPlayerPreloadMgr;
import com.tencent.superplayer.player.SPlayerManager;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.SPlayerVideoView;

public class SuperPlayerFactory
{
  public static ISuperPlayer createMediaPlayer(Context paramContext, int paramInt, ISPlayerVideoView paramISPlayerVideoView)
  {
    return new SPlayerManager(paramContext, paramInt, paramISPlayerVideoView);
  }
  
  public static ISPlayerVideoView createPlayerVideoView(Context paramContext)
  {
    return new SPlayerVideoView(paramContext, true);
  }
  
  public static SPlayerPreloadMgr createPreloadMgr(Context paramContext)
  {
    return SPlayerPreloadMgr.getInstance(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerFactory
 * JD-Core Version:    0.7.0.1
 */