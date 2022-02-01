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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 9)
      {
        if (i != 21)
        {
          if (i != 27)
          {
            if (i != 29)
            {
              if (i != 85)
              {
                if (i != 5)
                {
                  if (i != 6)
                  {
                    if (i != 23)
                    {
                      if (i != 24)
                      {
                        if (i != 92)
                        {
                          if (i != 93)
                          {
                            switch (i)
                            {
                            default: 
                              switch (i)
                              {
                              default: 
                                return;
                              case 90: 
                                SuperPlayerMgrInternal.access$100(this.this$0).handleResumeDownload();
                                return;
                              case 89: 
                                SuperPlayerMgrInternal.access$100(this.this$0).handlePauseDownload();
                                return;
                              }
                              paramMessage = (SuperPlayerMgrCommons.SwitchDefnParams)paramMessage.obj;
                              SuperPlayerMgrInternal.access$100(this.this$0).handleSwitchDefinition(paramMessage.a, paramMessage.b);
                              return;
                            case 15: 
                              SuperPlayerMgrInternal.access$100(this.this$0).handleReset();
                              return;
                            case 14: 
                              SuperPlayerMgrInternal.access$100(this.this$0).handleStop();
                              return;
                            case 13: 
                              SuperPlayerMgrInternal.access$100(this.this$0).handlePause();
                              return;
                            }
                            SuperPlayerMgrInternal.access$100(this.this$0).handleStart();
                            return;
                          }
                          paramMessage = (SuperPlayerMgrCommons.SwitchDefnForUrlParams)paramMessage.obj;
                          SuperPlayerMgrInternal.access$100(this.this$0).handleSwitchDefinitionForUrl(paramMessage.a, paramMessage.b);
                          return;
                        }
                        paramMessage = (int[])paramMessage.obj;
                        SuperPlayerMgrInternal.access$100(this.this$0).handleSetBusinessDownloadStrategy(paramMessage[0], paramMessage[1], paramMessage[2], paramMessage[3]);
                        return;
                      }
                      SuperPlayerMgrInternal.access$100(this.this$0).handleSeekTo(paramMessage.arg1, paramMessage.arg2);
                      return;
                    }
                    SuperPlayerMgrInternal.access$100(this.this$0).handleSeekTo(paramMessage.arg1);
                    return;
                  }
                  SuperPlayerMgrInternal.access$100(this.this$0).handleSetSurface((Surface)paramMessage.obj);
                  return;
                }
                SuperPlayerMgrInternal.access$100(this.this$0).handleUpdatePlayerVideoView((ISPlayerVideoView)paramMessage.obj);
                return;
              }
              paramMessage = (SuperPlayerMgrCommons.LoopbackParams)paramMessage.obj;
              SuperPlayerMgrInternal.access$100(this.this$0).handleSetLoopback(paramMessage.isLoopback, paramMessage.loopStartPositionMs, paramMessage.loopEndPositionMs);
              return;
            }
            SuperPlayerMgrInternal.access$100(this.this$0).handleSetLoopback(((Boolean)paramMessage.obj).booleanValue());
            return;
          }
          SuperPlayerMgrInternal.access$100(this.this$0).handleSetOutputMute(((Boolean)paramMessage.obj).booleanValue());
          return;
        }
        SuperPlayerMgrInternal.access$100(this.this$0).handleRelease();
        return;
      }
      SuperPlayerMgrInternal.access$100(this.this$0).handleSetPlaySpeedRatio(((Float)paramMessage.obj).floatValue());
      return;
    }
    paramMessage = (SuperPlayerMgrCommons.OpenMediaParams)paramMessage.obj;
    SuperPlayerMgrInternal.access$100(this.this$0).handleOpenMediaPlayer(paramMessage.context, paramMessage.videoInfo, paramMessage.startPositionMilsec, paramMessage.playerOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgrInternal.EventHandler
 * JD-Core Version:    0.7.0.1
 */