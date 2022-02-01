package com.tencent.superplayer.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;

class SuperPlayerMgrInternal$EventHandler
  extends Handler
{
  private SuperPlayerMgrInternal$EventHandler(SuperPlayerMgrInternal paramSuperPlayerMgrInternal, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (SuperPlayerMgrInternal.access$100(this.this$0) == null)
    {
      LogUtil.e(SuperPlayerMgrInternal.access$200(this.this$0), "handle listener is null, return");
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (SuperPlayerMgrCommons.OpenMediaParams)paramMessage.obj;
      SuperPlayerMgrInternal.access$100(this.this$0).handleOpenMediaPlayer(paramMessage.context, paramMessage.videoInfo, paramMessage.startPositionMilsec, paramMessage.playerOption);
      return;
    case 5: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleUpdatePlayerVideoView((ISPlayerVideoView)paramMessage.obj);
      return;
    case 6: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleSetSurface((Surface)paramMessage.obj);
      return;
    case 9: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleSetPlaySpeedRatio(((Float)paramMessage.obj).floatValue());
      return;
    case 12: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleStart();
      return;
    case 13: 
      SuperPlayerMgrInternal.access$100(this.this$0).handlePause();
      return;
    case 14: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleStop();
      return;
    case 15: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleReset();
      return;
    case 21: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleRelease();
      return;
    case 23: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleSeekTo(paramMessage.arg1);
      return;
    case 24: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleSeekTo(paramMessage.arg1, paramMessage.arg2);
      return;
    case 27: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleSetOutputMute(((Boolean)paramMessage.obj).booleanValue());
      return;
    case 29: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleSetLoopback(((Boolean)paramMessage.obj).booleanValue());
      return;
    case 85: 
      paramMessage = (SuperPlayerMgrCommons.LoopbackParams)paramMessage.obj;
      SuperPlayerMgrInternal.access$100(this.this$0).handleSetLoopback(paramMessage.isLoopback, paramMessage.loopStartPositionMs, paramMessage.loopEndPositionMs);
      return;
    case 88: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleSwitchDefinition((String)paramMessage.obj);
      return;
    case 89: 
      SuperPlayerMgrInternal.access$100(this.this$0).handlePauseDownload();
      return;
    case 90: 
      SuperPlayerMgrInternal.access$100(this.this$0).handleResumeDownload();
      return;
    }
    paramMessage = (int[])paramMessage.obj;
    SuperPlayerMgrInternal.access$100(this.this$0).handleSetBusinessDownloadStrategy(paramMessage[0], paramMessage[1], paramMessage[2], paramMessage[3]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgrInternal.EventHandler
 * JD-Core Version:    0.7.0.1
 */