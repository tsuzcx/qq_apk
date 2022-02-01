package com.tencent.tav.player;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.SeekTimeStore;
import com.tencent.tav.decoder.logger.Logger;
import java.util.HashMap;

class PlayerThread
{
  static final int ACTION_FINISH = -1;
  static final int ACTION_GET_TAV_EXTRA_INFO = 25;
  static final int ACTION_PAUSE = 3;
  static final int ACTION_PLAY = 2;
  static final int ACTION_POST = 101;
  static final int ACTION_PREPARE = 1;
  static final int ACTION_QUIT = 850;
  static final int ACTION_READ_CURRENT_SAMPLE = 231;
  static final int ACTION_READ_SAMPLE = 12;
  static final int ACTION_READ_SNAP_SHOOT_BITMAP = 24;
  static final int ACTION_RELEASE = 6;
  static final int ACTION_SEEK = 5;
  static final int ACTION_SEEK_PRE_SAMPLE = 9;
  static final int ACTION_SET_VOLUME = 7;
  static final int ACTION_STOP = 4;
  static final int ACTION_UPDATE_ALLPROPERTIES = 20;
  static final int ACTION_UPDATE_AUDIOCLIP_PROPERTIES = 22;
  static final int ACTION_UPDATE_AUDIOVOLUME_PROPERTIES = 23;
  static final int ACTION_UPDATE_COMPOSITION = 11;
  static final int ACTION_UPDATE_PROPERTIES = 10;
  static final int ACTION_UPDATE_SIZE = 21;
  static final int STATUS_FINISH = 3;
  static final int STATUS_INIT_CODEC = 2;
  static final int STATUS_NONE = 1;
  private static final String TAG = "PlayerThreadMain";
  static HashMap<Integer, String> msgMap = new HashMap(20);
  final Handler mPlayHandler;
  @Nullable
  HandlerThread mThread = new HandlerThread("PlayerVideoThread");
  private final PlayerMessageHandler messageHandler;
  
  static
  {
    msgMap.put(Integer.valueOf(-1), "ACTION_FINISH");
    msgMap.put(Integer.valueOf(1), "初始化");
    msgMap.put(Integer.valueOf(2), "播放");
    msgMap.put(Integer.valueOf(3), "暂停");
    msgMap.put(Integer.valueOf(4), "停止");
    msgMap.put(Integer.valueOf(5), "拖动");
    msgMap.put(Integer.valueOf(6), "结束线程");
    msgMap.put(Integer.valueOf(7), "ACTION_SET_VOLUME");
    msgMap.put(Integer.valueOf(9), "ACTION_SEEK_PRE_SAMPLE");
    msgMap.put(Integer.valueOf(10), "ACTION_UPDATE_PROPERTIES");
    msgMap.put(Integer.valueOf(11), "ACTION_UPDATE_COMPOSITION");
    msgMap.put(Integer.valueOf(20), "ACTION_UPDATE_ALLPROPERTIES");
    msgMap.put(Integer.valueOf(21), "ACTION_UPDATE_SIZE");
    msgMap.put(Integer.valueOf(22), "ACTION_UPDATE_AUDIOCLIP_PROPERTIES");
    msgMap.put(Integer.valueOf(23), "ACTION_UPDATE_AUDIOVOLUME_PROPERTIES");
    msgMap.put(Integer.valueOf(24), "ACTION_READ_SNAP_SHOOT_BITMAP");
    msgMap.put(Integer.valueOf(25), "ACTION_GET_TAV_EXTRA_INFO");
    msgMap.put(Integer.valueOf(850), "ACTION_QUIT");
    msgMap.put(Integer.valueOf(101), "ACTION_POST");
    msgMap.put(Integer.valueOf(12), "读取下一帧");
    msgMap.put(Integer.valueOf(231), "read当前帧");
  }
  
  PlayerThread(@Nullable IDecoderTrack paramIDecoderTrack1, @Nullable IDecoderTrack paramIDecoderTrack2, @NonNull Player paramPlayer)
  {
    this.mThread.start();
    this.messageHandler = new PlayerMessageHandler(this, paramIDecoderTrack1, paramIDecoderTrack2, paramPlayer);
    this.mPlayHandler = new Handler(this.mThread.getLooper(), this.messageHandler);
    this.messageHandler.setAudioThread(new PlayerThreadAudio(paramIDecoderTrack2, this.mPlayHandler));
  }
  
  static String catLog(int paramInt)
  {
    String str = (String)msgMap.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(str))
    {
      Logger.e("PlayerThreadMain", "catLog: 未加入集合的消息定义！！！");
      return String.valueOf(paramInt);
    }
    return str;
  }
  
  void bindSurface(IDecoderTrack paramIDecoderTrack, PlayerLayer paramPlayerLayer)
  {
    this.messageHandler.bindSurface(paramIDecoderTrack, paramPlayerLayer);
    sendMessage(1, "bind surface");
  }
  
  @Nullable
  CGRect getGlViewportRect()
  {
    return this.messageHandler.getGlViewportRect();
  }
  
  CMTime getPosition()
  {
    return this.messageHandler.mPosition;
  }
  
  RenderContextParams getRenderContextParams()
  {
    return this.messageHandler.getRenderContextParams();
  }
  
  boolean hasMessage(int paramInt)
  {
    Handler localHandler = this.mPlayHandler;
    if ((localHandler != null) && (this.mThread != null)) {
      return localHandler.hasMessages(paramInt);
    }
    return false;
  }
  
  boolean post(Runnable paramRunnable)
  {
    if (this.mPlayHandler == null) {
      return false;
    }
    sendMessage(101, paramRunnable, "main");
    return true;
  }
  
  boolean refresh()
  {
    if (this.mPlayHandler == null) {
      return false;
    }
    sendMessage(231, "main");
    return true;
  }
  
  void sendMessage(int paramInt, Object paramObject1, Object paramObject2, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessage() called with: what = [");
    ((StringBuilder)localObject).append(catLog(paramInt));
    ((StringBuilder)localObject).append("], obj = [");
    ((StringBuilder)localObject).append(paramObject1);
    ((StringBuilder)localObject).append("], obj2 = [");
    ((StringBuilder)localObject).append(paramObject2);
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    Logger.i("PlayerThreadMain", ((StringBuilder)localObject).toString());
    if (paramInt == 5) {
      SeekTimeStore.updateSeekTime(((CMTime)paramObject1).getTimeUs());
    }
    localObject = this.mPlayHandler;
    if ((localObject != null) && (this.mThread != null)) {
      ((Handler)localObject).obtainMessage(paramInt, new PlayerMessage(paramObject1, paramObject2, paramString, System.currentTimeMillis())).sendToTarget();
    }
  }
  
  void sendMessage(int paramInt, Object paramObject, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessage() called with: what = [");
    ((StringBuilder)localObject).append(catLog(paramInt));
    ((StringBuilder)localObject).append("], obj = [");
    ((StringBuilder)localObject).append(paramObject);
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    Logger.v("PlayerThreadMain", ((StringBuilder)localObject).toString());
    localObject = this.mPlayHandler;
    if ((localObject != null) && (this.mThread != null)) {
      ((Handler)localObject).obtainMessage(paramInt, new PlayerMessage(paramObject, paramString, System.currentTimeMillis())).sendToTarget();
    }
  }
  
  void sendMessage(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessage() called with: what = [");
    ((StringBuilder)localObject).append(catLog(paramInt));
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    Logger.v("PlayerThreadMain", ((StringBuilder)localObject).toString());
    localObject = this.mPlayHandler;
    if ((localObject != null) && (this.mThread != null)) {
      ((Handler)localObject).obtainMessage(paramInt, new PlayerMessage(null, paramString, System.currentTimeMillis())).sendToTarget();
    }
  }
  
  void sendMessageDelay(int paramInt, long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessageDelay() called with: what = [");
    ((StringBuilder)localObject).append(catLog(paramInt));
    ((StringBuilder)localObject).append("], delay = [");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], from = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    Logger.v("PlayerThreadMain", ((StringBuilder)localObject).toString());
    if (this.mPlayHandler != null)
    {
      localObject = new Message();
      ((Message)localObject).what = paramInt;
      ((Message)localObject).obj = new PlayerMessage(null, paramString, System.currentTimeMillis());
      this.mPlayHandler.sendMessageDelayed((Message)localObject, paramLong);
    }
  }
  
  void setFrameDuration(CMTime paramCMTime)
  {
    this.messageHandler.frameDuration = paramCMTime;
  }
  
  void setRate(float paramFloat)
  {
    this.messageHandler.setRate(paramFloat);
  }
  
  void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.messageHandler.setRenderContextParams(paramRenderContextParams);
  }
  
  void updatePositionRightAway(CMTime paramCMTime)
  {
    this.messageHandler.mPosition = paramCMTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.player.PlayerThread
 * JD-Core Version:    0.7.0.1
 */