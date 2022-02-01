package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.Utils;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

class SuperPlayerWrapper$TPPlayerListenerAdapter
  implements ListenerCombine.ITPPlayerCombine
{
  private SuperPlayerWrapper.WrapperIdCaptureListener mCaptureListener;
  private SuperPlayerListenerCallBack mWrapperCallback;
  
  SuperPlayerWrapper$TPPlayerListenerAdapter(SuperPlayerWrapper paramSuperPlayerWrapper, SuperPlayerListenerCallBack paramSuperPlayerListenerCallBack)
  {
    this.mWrapperCallback = paramSuperPlayerListenerCallBack;
  }
  
  public void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    this.mWrapperCallback.onAudioFrameOutput(paramTPAudioFrameBuffer);
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
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onCompletion");
    SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(7);
    this.mWrapperCallback.onCompletion(this.this$0);
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    LogUtil.e(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onError, errorType:" + paramInt1 + ", errorCode:" + paramInt2 + ", arg1:" + paramLong1 + ", arg2:" + paramLong2);
    SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
    this.mWrapperCallback.onError(this.this$0, 1, paramInt1, paramInt2, paramLong1 + ":" + paramLong2);
  }
  
  public void onGetVInfoFailed(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt1, int paramInt2, String paramString)
  {
    LogUtil.e(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onGetVInfoFailed:" + paramInt2 + "+" + paramString);
    if (this.mWrapperCallback != null) {
      this.mWrapperCallback.onError(this.this$0, 2, paramInt1, paramInt2, paramString);
    }
    SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
  }
  
  public void onGetVInfoSuccess(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onGetVInfoSuccess:" + paramSuperPlayerVideoInfo);
    SuperPlayerVideoInfo localSuperPlayerVideoInfo = SuperPlayerWrapper.access$300(this.this$0);
    if ((localSuperPlayerVideoInfo == null) || (paramSuperPlayerVideoInfo == null)) {}
    for (;;)
    {
      return;
      if ((TextUtils.equals(paramSuperPlayerVideoInfo.getVid(), localSuperPlayerVideoInfo.getVid())) && (TextUtils.equals(paramSuperPlayerVideoInfo.getRequestDefinition(), localSuperPlayerVideoInfo.getRequestDefinition())))
      {
        if ((TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) && (paramSuperPlayerVideoInfo.getTVideoSectionList() == null)) {
          break label172;
        }
        SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(2);
        SuperPlayerWrapper.access$600(this.this$0, paramSuperPlayerVideoInfo, SuperPlayerWrapper.access$500(this.this$0));
      }
      while ((this.mWrapperCallback != null) && (paramSuperPlayerVideoInfo.getTVideoNetInfo() != null))
      {
        this.mWrapperCallback.onDefinitionInfoUpdate(this.this$0, paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinitionStr(), paramSuperPlayerVideoInfo.getTVideoNetInfo().getDefinitionStrList());
        this.mWrapperCallback.onTVideoNetInfoUpdate(this.this$0, paramSuperPlayerVideoInfo.getTVideoNetInfo());
        return;
        label172:
        if (this.mWrapperCallback != null) {
          this.mWrapperCallback.onError(this.this$0, 2, 5000, 32000001, null);
        }
        SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
      }
    }
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (SuperPlayerWrapper.access$700(this.this$0, paramInt, paramLong1, paramLong2, paramObject)) {
      return;
    }
    paramInt = Utils.convertPlayerMsg(paramInt);
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onInfo, what:" + paramInt + ", arg1:" + paramLong1 + ", arg2:" + paramLong2 + ", extraObject:" + paramObject);
    this.mWrapperCallback.onInfo(this.this$0, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onPrepared");
    SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(4);
    this.mWrapperCallback.onVideoPrepared(this.this$0);
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onSeekComplete");
    this.mWrapperCallback.onSeekComplete(this.this$0);
  }
  
  public void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
  {
    this.mWrapperCallback.onSubtitleData(this.this$0, paramTPSubtitleData);
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    this.mWrapperCallback.onVideoFrameOutput(paramTPVideoFrameBuffer);
  }
  
  public void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onVideoSizeChanged, width:" + paramLong1 + ", height:" + paramLong2);
    this.mWrapperCallback.onVideoSizeChanged(this.this$0, (int)paramLong1, (int)paramLong2);
  }
  
  void setCaptureListener(SuperPlayerWrapper.WrapperIdCaptureListener paramWrapperIdCaptureListener)
  {
    this.mCaptureListener = paramWrapperIdCaptureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper.TPPlayerListenerAdapter
 * JD-Core Version:    0.7.0.1
 */