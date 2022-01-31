package com.tencent.thumbplayer.tplayer;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.datatransport.ITPPlayManager;
import com.tencent.thumbplayer.utils.TPLogUtil;

@SuppressLint({"HandlerLeak"})
class TPPlayer$EventHandler
  extends Handler
{
  private TPPlayer mPlayer;
  
  TPPlayer$EventHandler(TPPlayer paramTPPlayer1, TPPlayer paramTPPlayer2)
  {
    this.mPlayer = paramTPPlayer2;
  }
  
  TPPlayer$EventHandler(TPPlayer paramTPPlayer1, TPPlayer paramTPPlayer2, Looper paramLooper)
  {
    super(paramLooper);
    this.mPlayer = paramTPPlayer2;
  }
  
  public void handleMessage(Message paramMessage)
  {
    TPLogUtil.d(TPPlayer.access$700(this.this$0), "mTransformHandler msg : " + paramMessage.what);
    TPPlayerListeners localTPPlayerListeners = TPPlayer.access$1000(this.this$0);
    if (localTPPlayerListeners == null) {}
    do
    {
      TPThreadSwitchCommons.TPSwitchCommonParams localTPSwitchCommonParams;
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          case 258: 
          case 259: 
          default: 
            return;
          case 257: 
            TPLogUtil.i(TPPlayer.access$700(this.this$0), "onPrepared");
            localTPPlayerListeners.onPrepared(this.mPlayer);
            return;
          case 260: 
            localTPPlayerListeners.onCompletion(this.mPlayer);
            return;
          case 261: 
            localTPSwitchCommonParams = (TPThreadSwitchCommons.TPSwitchCommonParams)paramMessage.obj;
            if ((localTPSwitchCommonParams != null) && (!TPPlayer.access$000(this.this$0).hasWaitDefTask()))
            {
              localTPPlayerListeners.onInfo(this.mPlayer, paramMessage.arg1, localTPSwitchCommonParams.arg1, localTPSwitchCommonParams.arg2, localTPSwitchCommonParams.extraObject);
              return;
            }
            break;
          }
        } while (localTPSwitchCommonParams == null);
        localTPPlayerListeners.onInfo(this.mPlayer, paramMessage.arg1, localTPSwitchCommonParams.arg1, localTPSwitchCommonParams.arg2, localTPSwitchCommonParams.extraObject);
        return;
        localTPSwitchCommonParams = (TPThreadSwitchCommons.TPSwitchCommonParams)paramMessage.obj;
      } while (localTPSwitchCommonParams == null);
      localTPPlayerListeners.onError(this.mPlayer, paramMessage.arg1, paramMessage.arg2, localTPSwitchCommonParams.arg1, localTPSwitchCommonParams.arg2);
      return;
      localTPPlayerListeners.onSeekComplete(this.mPlayer);
      return;
      paramMessage = (TPThreadSwitchCommons.TPSwitchCommonParams)paramMessage.obj;
    } while (paramMessage == null);
    localTPPlayerListeners.onVideoSizeChanged(this.mPlayer, paramMessage.arg1, paramMessage.arg2);
    return;
    localTPPlayerListeners.onSubtitleData(this.mPlayer, (TPSubtitleData)paramMessage.obj);
    return;
    localTPPlayerListeners.onVideoFrameOut(this.mPlayer, (TPVideoFrameBuffer)paramMessage.obj);
    return;
    localTPPlayerListeners.onAudioFrameOut(this.mPlayer, (TPAudioFrameBuffer)paramMessage.obj);
    return;
    localTPPlayerListeners.onError(this.mPlayer, paramMessage.arg1, paramMessage.arg2, 0L, 0L);
    return;
    localTPPlayerListeners.onInfo(this.mPlayer, 1002, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    return;
    localTPPlayerListeners.onInfo(this.mPlayer, 1003, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    return;
    localTPPlayerListeners.onInfo(this.mPlayer, 1001, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    return;
    localTPPlayerListeners.onInfo(this.mPlayer, 1004, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    return;
    localTPPlayerListeners.onInfo(this.mPlayer, 1005, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    return;
    localTPPlayerListeners.onInfo(this.mPlayer, 1006, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    return;
    localTPPlayerListeners.onInfo(this.mPlayer, 1007, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    return;
    localTPPlayerListeners.onInfo(this.mPlayer, 1008, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    return;
    localTPPlayerListeners.onInfo(this.mPlayer, 1010, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    return;
    localTPPlayerListeners.onStateChange(paramMessage.arg1, paramMessage.arg2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayer.EventHandler
 * JD-Core Version:    0.7.0.1
 */