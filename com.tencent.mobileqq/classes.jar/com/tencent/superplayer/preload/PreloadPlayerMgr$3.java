package com.tencent.superplayer.preload;

import com.tencent.superplayer.player.SuperPlayerWrapper;

class PreloadPlayerMgr$3
  implements Runnable
{
  PreloadPlayerMgr$3(PreloadPlayerMgr paramPreloadPlayerMgr, PreloadPlayerInfo paramPreloadPlayerInfo) {}
  
  public void run()
  {
    if (this.val$playerInfo.player != null) {
      this.val$playerInfo.player.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.preload.PreloadPlayerMgr.3
 * JD-Core Version:    0.7.0.1
 */