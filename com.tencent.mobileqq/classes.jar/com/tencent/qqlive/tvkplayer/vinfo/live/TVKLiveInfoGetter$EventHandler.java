package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;

@SuppressLint({"HandlerLeak"})
class TVKLiveInfoGetter$EventHandler
  extends Handler
{
  public TVKLiveInfoGetter$EventHandler(TVKLiveInfoGetter paramTVKLiveInfoGetter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      TVKLogUtil.i(TVKLiveInfoGetter.access$400(), "eventHandler unknow msg");
      return;
    }
    TVKLiveInfoGetter.access$600(this.this$0, paramMessage.arg1, (TVKLiveVideoInfo)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter.EventHandler
 * JD-Core Version:    0.7.0.1
 */