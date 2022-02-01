package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.Utils;
import com.tencent.superplayer.vinfo.VInfoGetter.VInfoGetterListener;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

class SuperPlayerWrapper$TPPlayerListenerAdapter
  implements VInfoGetter.VInfoGetterListener, ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoSizeChangedListener, TPCaptureCallBack
{
  private SuperPlayerWrapper.WrapperIdCaptureListener mCaptureListener;
  
  private SuperPlayerWrapper$TPPlayerListenerAdapter(SuperPlayerWrapper paramSuperPlayerWrapper) {}
  
  public void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    SuperPlayerWrapper.access$700(this.this$0).onAudioFrameOutput(paramTPAudioFrameBuffer);
  }
  
  public void onCaptureVideoFailed(int paramInt)
  {
    if (this.mCaptureListener != null) {
      this.mCaptureListener.onCaptureVideoFailed(paramInt);
    }
  }
  
  public void onCaptureVideoSuccess(Bitmap paramBitmap)
  {
    if (this.mCaptureListener != null) {
      this.mCaptureListener.onCaptureVideoSuccess(paramBitmap);
    }
  }
  
  public void onCompletion(ITPPlayer paramITPPlayer)
  {
    LogUtil.i(SuperPlayerWrapper.access$200(this.this$0), "inner listener called : onCompletion");
    SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(7);
    SuperPlayerWrapper.access$700(this.this$0).onCompletion(this.this$0);
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    LogUtil.e(SuperPlayerWrapper.access$200(this.this$0), "inner listener called : onError, errorType:" + paramInt1 + ", errorCode:" + paramInt2 + ", arg1:" + paramLong1 + ", arg2:" + paramLong2);
    SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
    SuperPlayerWrapper.access$700(this.this$0).onError(this.this$0, 1, paramInt1, paramInt2, paramLong1 + ":" + paramLong2);
  }
  
  public void onGetVInfoFailed(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt1, int paramInt2, String paramString)
  {
    LogUtil.e(SuperPlayerWrapper.access$200(this.this$0), "inner listener called : onGetVInfoFailed:" + paramInt2 + "+" + paramString);
    if (SuperPlayerWrapper.access$700(this.this$0) != null) {
      SuperPlayerWrapper.access$700(this.this$0).onError(this.this$0, 2, paramInt1, paramInt2, paramString);
    }
    SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
  }
  
  public void onGetVInfoSuccess(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    LogUtil.i(SuperPlayerWrapper.access$200(this.this$0), "inner listener called : onGetVInfoSuccess:" + paramSuperPlayerVideoInfo);
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = SuperPlayerWrapper.access$300(this.this$0);
    if (localSuperPlayerVideoInfo == null) {}
    for (;;)
    {
      return;
      if ((TextUtils.equals(paramSuperPlayerVideoInfo.getVid(), localSuperPlayerVideoInfo.getVid())) && (TextUtils.equals(paramSuperPlayerVideoInfo.getRequestDefinition(), localSuperPlayerVideoInfo.getRequestDefinition())))
      {
        if (TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) {
          break label163;
        }
        SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(2);
        SuperPlayerWrapper.access$600(this.this$0, paramSuperPlayerVideoInfo, SuperPlayerWrapper.access$500(this.this$0));
      }
      while (SuperPlayerWrapper.access$700(this.this$0) != null)
      {
        SuperPlayerWrapper.access$700(this.this$0).onDefinitionInfoUpdate(this.this$0, paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinitionStr(), paramSuperPlayerVideoInfo.getTVideoNetInfo().getDefinitionStrList());
        SuperPlayerWrapper.access$700(this.this$0).onTVideoNetInfoUpdate(this.this$0, paramSuperPlayerVideoInfo.getTVideoNetInfo());
        return;
        label163:
        if (SuperPlayerWrapper.access$700(this.this$0) != null) {
          SuperPlayerWrapper.access$700(this.this$0).onError(this.this$0, 2, 5000, 32000001, null);
        }
        SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
      }
    }
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (SuperPlayerWrapper.access$800(this.this$0, paramInt, paramLong1, paramLong2, paramObject)) {
      return;
    }
    paramInt = Utils.convertPlayerMsg(paramInt);
    LogUtil.i(SuperPlayerWrapper.access$200(this.this$0), "inner listener called : onInfo, what:" + paramInt + ", arg1:" + paramLong1 + ", arg2:" + paramLong2 + ", extraObject:" + paramObject);
    SuperPlayerWrapper.access$700(this.this$0).onInfo(this.this$0, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    LogUtil.i(SuperPlayerWrapper.access$200(this.this$0), "inner listener called : onPrepared");
    SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(4);
    SuperPlayerWrapper.access$700(this.this$0).onVideoPrepared(this.this$0);
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    LogUtil.i(SuperPlayerWrapper.access$200(this.this$0), "inner listener called : onSeekComplete");
    SuperPlayerWrapper.access$700(this.this$0).onSeekComplete(this.this$0);
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    SuperPlayerWrapper.access$700(this.this$0).onVideoFrameOutput(paramTPVideoFrameBuffer);
  }
  
  public void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    LogUtil.i(SuperPlayerWrapper.access$200(this.this$0), "inner listener called : onVideoSizeChanged, width:" + paramLong1 + ", height:" + paramLong2);
    SuperPlayerWrapper.access$700(this.this$0).onVideoSizeChanged(this.this$0, (int)paramLong1, (int)paramLong2);
  }
  
  public void setCaptureListener(SuperPlayerWrapper.WrapperIdCaptureListener paramWrapperIdCaptureListener)
  {
    this.mCaptureListener = paramWrapperIdCaptureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper.TPPlayerListenerAdapter
 * JD-Core Version:    0.7.0.1
 */