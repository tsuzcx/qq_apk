package com.tencent.superplayer.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioPcmDataListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoOutputFrameListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.utils.SPlayerLogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;

class SPlayerManagerInternal$EventHandler
  extends Handler
{
  private SPlayerManagerInternal$EventHandler(SPlayerManagerInternal paramSPlayerManagerInternal, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (SPlayerManagerInternal.access$100(this.this$0) == null)
    {
      SPlayerLogUtil.e(SPlayerManagerInternal.access$200(this.this$0), "handle listener is null, return");
      return;
    }
    switch (paramMessage.what)
    {
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    case 10: 
    case 11: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 22: 
    case 25: 
    case 26: 
    case 32: 
    case 34: 
    case 35: 
    case 36: 
    case 39: 
    case 40: 
    case 41: 
    case 46: 
    case 47: 
    case 48: 
    case 51: 
    case 52: 
    case 53: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 66: 
    case 68: 
    case 69: 
    case 74: 
    case 75: 
    case 77: 
    case 78: 
    case 81: 
    case 82: 
    case 83: 
    case 84: 
    default: 
      return;
    case 1: 
      paramMessage = (SPlayerManagerCommons.OpenMediaParams)paramMessage.obj;
      SPlayerManagerInternal.access$100(this.this$0).handleOpenMediaPlayer(paramMessage.context, paramMessage.videoInfo, paramMessage.startPositionMilsec);
      return;
    case 2: 
      paramMessage = (SPlayerManagerCommons.OpenMediaParams)paramMessage.obj;
      SPlayerManagerInternal.access$100(this.this$0).handleOpenMediaPlayerByUrl(paramMessage.context, paramMessage.urls, paramMessage.startPositionMilsec, paramMessage.fileId, paramMessage.localSaveUrl);
      return;
    case 5: 
      SPlayerManagerInternal.access$100(this.this$0).handleUpdatePlayerVideoView((ISPlayerVideoView)paramMessage.obj);
      return;
    case 8: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetXYaxis(paramMessage.arg1);
      return;
    case 9: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetPlaySpeedRatio(((Float)paramMessage.obj).floatValue());
      return;
    case 12: 
      SPlayerManagerInternal.access$100(this.this$0).handleStart();
      return;
    case 13: 
      SPlayerManagerInternal.access$100(this.this$0).handlePause();
      return;
    case 14: 
      SPlayerManagerInternal.access$100(this.this$0).handleStop();
      return;
    case 15: 
      SPlayerManagerInternal.access$100(this.this$0).handleReset();
      return;
    case 21: 
      SPlayerManagerInternal.access$100(this.this$0).handleRelease();
      return;
    case 23: 
      SPlayerManagerInternal.access$100(this.this$0).handleSeekTo(paramMessage.arg1);
      return;
    case 24: 
      SPlayerManagerInternal.access$100(this.this$0).handleSeekTo(paramMessage.arg1, paramMessage.arg2);
      return;
    case 27: 
      SPlayerManagerInternal.access$302(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleSetOutputMute(((Boolean)paramMessage.obj).booleanValue()));
      return;
    case 28: 
      SPlayerManagerInternal.access$402(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleGetOutputMute());
      return;
    case 29: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetLoopback(((Boolean)paramMessage.obj).booleanValue());
      return;
    case 85: 
      paramMessage = (SPlayerManagerCommons.LoopbackParams)paramMessage.obj;
      SPlayerManagerInternal.access$100(this.this$0).handleSetLoopback(paramMessage.isLoopback, paramMessage.loopStartPositionMs, paramMessage.loopEndPositionMs);
      return;
    case 30: 
      SPlayerManagerInternal.access$502(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleIsLoopback());
      return;
    case 31: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetAudioGainRatio(((Float)paramMessage.obj).floatValue());
      return;
    case 33: 
      SPlayerManagerInternal.access$602(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleCaptureImageInTime(((Long)paramMessage.obj).longValue(), paramMessage.arg1, paramMessage.arg2));
      return;
    case 37: 
      SPlayerManagerInternal.access$702(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleGetDuration());
      return;
    case 38: 
      SPlayerManagerInternal.access$802(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleGetDownloadSpeed(paramMessage.arg1));
      return;
    case 42: 
      SPlayerManagerInternal.access$902(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleGetVideoWidth());
      return;
    case 43: 
      SPlayerManagerInternal.access$1002(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleGetVideoHeight());
      return;
    case 44: 
      SPlayerManagerInternal.access$1102(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleGetVideoRotation());
      return;
    case 45: 
      SPlayerManagerInternal.access$1202(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleGetPlayedTime());
      return;
    case 49: 
      SPlayerManagerInternal.access$1302(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleIsPlaying());
      return;
    case 50: 
      SPlayerManagerInternal.access$1402(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleIsPausing());
      return;
    case 54: 
      SPlayerManagerInternal.access$1502(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleGetStreamDumpInfo());
      return;
    case 65: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetOnVideoPreparedListener((ISuperPlayer.OnVideoPreparedListener)paramMessage.obj);
      return;
    case 67: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetOnCompletionListener((ISuperPlayer.OnCompletionListener)paramMessage.obj);
      return;
    case 70: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetOnSeekCompleteListener((ISuperPlayer.OnSeekCompleteListener)paramMessage.obj);
      return;
    case 71: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetOnCaptureImageListener((ISuperPlayer.OnCaptureImageListener)paramMessage.obj);
      return;
    case 72: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetOnErrorListener((ISuperPlayer.OnErrorListener)paramMessage.obj);
      return;
    case 73: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetOnInfoListener((ISuperPlayer.OnInfoListener)paramMessage.obj);
      return;
    case 76: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetOnVideoSizeChangedListener((ISuperPlayer.OnVideoSizeChangedListener)paramMessage.obj);
      return;
    case 79: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetOnVideoOutputFrameListener((ISuperPlayer.OnVideoOutputFrameListener)paramMessage.obj);
      return;
    case 80: 
      SPlayerManagerInternal.access$100(this.this$0).handleSetOnAudioPcmDataListener((ISuperPlayer.OnAudioPcmDataListener)paramMessage.obj);
      return;
    }
    SPlayerManagerInternal.access$1602(this.this$0, SPlayerManagerInternal.access$100(this.this$0).handleGetMediaInfo());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SPlayerManagerInternal.EventHandler
 * JD-Core Version:    0.7.0.1
 */