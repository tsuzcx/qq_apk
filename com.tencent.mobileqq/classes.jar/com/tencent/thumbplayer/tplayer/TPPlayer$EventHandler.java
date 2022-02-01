package com.tencent.thumbplayer.tplayer;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.adapter.ITPPlayerAdapter;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.datatransport.ITPPlayManager;
import com.tencent.thumbplayer.log.TPBaseLogger;

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
    Object localObject1 = TPPlayer.access$700(this.this$0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mTransformHandler msg : ");
    ((StringBuilder)localObject2).append(paramMessage.what);
    ((TPBaseLogger)localObject1).debug(((StringBuilder)localObject2).toString());
    localObject1 = TPPlayer.access$1000(this.this$0);
    if (localObject1 == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 257)
    {
      switch (i)
      {
      default: 
        return;
      case 282: 
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, 2101, 0L, 0L, paramMessage.obj);
        return;
      case 281: 
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, 2100, 0L, 0L, paramMessage.obj);
        return;
      case 280: 
        ((TPPlayerListeners)localObject1).onStopAsyncComplete(this.mPlayer);
        return;
      case 279: 
        ((TPPlayerListeners)localObject1).onSubtitleFrameOut(this.mPlayer, (TPSubtitleFrameBuffer)paramMessage.obj);
        return;
      case 278: 
        if (TPPlayer.access$100(this.this$0) != null) {
          TPPlayer.access$100(this.this$0).setPlayerOptionalParam(new TPOptionalParam().buildLong(8000, paramMessage.arg1));
        }
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, 1010, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
        return;
      case 277: 
        ((TPPlayerListeners)localObject1).onStateChange(paramMessage.arg1, paramMessage.arg2);
        return;
      case 276: 
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, 1008, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
        return;
      case 275: 
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, 1007, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
        return;
      case 274: 
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, 1006, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
        return;
      case 273: 
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, 1005, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
        return;
      case 272: 
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, 1004, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
        return;
      case 271: 
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, 1001, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
        return;
      case 270: 
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, 1003, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
        return;
      case 269: 
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, 1002, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
        return;
      case 268: 
        ((TPPlayerListeners)localObject1).onError(this.mPlayer, paramMessage.arg1, paramMessage.arg2, 0L, 0L);
        return;
      case 267: 
        ((TPPlayerListeners)localObject1).onAudioFrameOut(this.mPlayer, (TPAudioFrameBuffer)paramMessage.obj);
        return;
      case 266: 
        ((TPPlayerListeners)localObject1).onVideoFrameOut(this.mPlayer, (TPVideoFrameBuffer)paramMessage.obj);
        return;
      case 265: 
        ((TPPlayerListeners)localObject1).onSubtitleData(this.mPlayer, (TPSubtitleData)paramMessage.obj);
        return;
      case 264: 
        paramMessage = (TPThreadSwitchCommons.TPSwitchCommonParams)paramMessage.obj;
        if (paramMessage == null) {
          break;
        }
        ((TPPlayerListeners)localObject1).onVideoSizeChanged(this.mPlayer, paramMessage.arg1, paramMessage.arg2);
        return;
      case 263: 
        ((TPPlayerListeners)localObject1).onSeekComplete(this.mPlayer);
        return;
      case 262: 
        localObject2 = (TPThreadSwitchCommons.TPSwitchCommonParams)paramMessage.obj;
        if (localObject2 == null) {
          break;
        }
        ((TPPlayerListeners)localObject1).onError(this.mPlayer, paramMessage.arg1, paramMessage.arg2, ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject2).arg1, ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject2).arg2);
        return;
      case 261: 
        localObject2 = (TPThreadSwitchCommons.TPSwitchCommonParams)paramMessage.obj;
        if ((localObject2 != null) && (!TPPlayer.access$000(this.this$0).hasWaitDefTask()))
        {
          ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, paramMessage.arg1, ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject2).arg1, ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject2).arg2, ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject2).extraObject);
          return;
        }
        if (localObject2 == null) {
          break;
        }
        ((TPPlayerListeners)localObject1).onInfo(this.mPlayer, paramMessage.arg1, ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject2).arg1, ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject2).arg2, ((TPThreadSwitchCommons.TPSwitchCommonParams)localObject2).extraObject);
        return;
      case 260: 
        ((TPPlayerListeners)localObject1).onCompletion(this.mPlayer);
        return;
      }
    }
    else
    {
      TPPlayer.access$700(this.this$0).info("onPrepared");
      ((TPPlayerListeners)localObject1).onPrepared(this.mPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayer.EventHandler
 * JD-Core Version:    0.7.0.1
 */