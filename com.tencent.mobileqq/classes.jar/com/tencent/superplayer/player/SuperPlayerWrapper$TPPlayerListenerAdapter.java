package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerMsg;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.utils.LogUtil;
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
    SuperPlayerWrapper.WrapperIdCaptureListener localWrapperIdCaptureListener = this.mCaptureListener;
    if (localWrapperIdCaptureListener != null) {
      localWrapperIdCaptureListener.onCaptureVideoFailed(paramInt);
    }
  }
  
  public void onCaptureVideoSuccess(Bitmap paramBitmap)
  {
    SuperPlayerWrapper.WrapperIdCaptureListener localWrapperIdCaptureListener = this.mCaptureListener;
    if (localWrapperIdCaptureListener != null) {
      localWrapperIdCaptureListener.onCaptureVideoSuccess(paramBitmap);
    }
  }
  
  public void onCompletion(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onCompletion(paramITPPlayer);
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onCompletion");
    SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(7);
    this.mWrapperCallback.onCompletion(this.this$0);
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    ReportThumbPlayer.getInstance().onError(paramITPPlayer, paramInt1, paramInt2);
    paramITPPlayer = SuperPlayerWrapper.access$100(this.this$0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("inner listener called : onError, errorType:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", errorCode:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", arg1:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(", arg2:");
    ((StringBuilder)localObject).append(paramLong2);
    LogUtil.e(paramITPPlayer, ((StringBuilder)localObject).toString());
    SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
    paramITPPlayer = this.mWrapperCallback;
    localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramLong2);
    paramITPPlayer.onError((ISuperPlayer)localObject, 1, paramInt1, paramInt2, localStringBuilder.toString());
  }
  
  public void onGetVInfoFailed(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt1, int paramInt2, String paramString)
  {
    paramSuperPlayerVideoInfo = SuperPlayerWrapper.access$100(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inner listener called : onGetVInfoFailed:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("+");
    localStringBuilder.append(paramString);
    LogUtil.e(paramSuperPlayerVideoInfo, localStringBuilder.toString());
    paramSuperPlayerVideoInfo = this.mWrapperCallback;
    if (paramSuperPlayerVideoInfo != null) {
      paramSuperPlayerVideoInfo.onError(this.this$0, 2, paramInt1, paramInt2, paramString);
    }
    SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
  }
  
  public void onGetVInfoSuccess(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    Object localObject = SuperPlayerWrapper.access$100(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inner listener called : onGetVInfoSuccess:");
    localStringBuilder.append(paramSuperPlayerVideoInfo);
    LogUtil.i((String)localObject, localStringBuilder.toString());
    localObject = SuperPlayerWrapper.access$300(this.this$0);
    if (localObject != null)
    {
      if (paramSuperPlayerVideoInfo == null) {
        return;
      }
      if ((TextUtils.equals(paramSuperPlayerVideoInfo.getVid(), ((SuperPlayerVideoInfo)localObject).getVid())) && (TextUtils.equals(paramSuperPlayerVideoInfo.getRequestDefinition(), ((SuperPlayerVideoInfo)localObject).getRequestDefinition()))) {
        if ((TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) && (paramSuperPlayerVideoInfo.getTVideoSectionList() == null))
        {
          localObject = this.mWrapperCallback;
          if (localObject != null) {
            ((SuperPlayerListenerCallBack)localObject).onError(this.this$0, 2, 5000, 32000001, null);
          }
          SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
        }
        else
        {
          SuperPlayerWrapper.access$400(this.this$0).changeStateAndNotify(2);
          localObject = this.this$0;
          SuperPlayerWrapper.access$600((SuperPlayerWrapper)localObject, paramSuperPlayerVideoInfo, SuperPlayerWrapper.access$500((SuperPlayerWrapper)localObject));
        }
      }
      if ((this.mWrapperCallback != null) && (paramSuperPlayerVideoInfo.getTVideoNetInfo() != null))
      {
        this.mWrapperCallback.onDefinitionInfoUpdate(this.this$0, paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinitionStr(), paramSuperPlayerVideoInfo.getTVideoNetInfo().getDefinitionStrList());
        this.mWrapperCallback.onTVideoNetInfoUpdate(this.this$0, paramSuperPlayerVideoInfo.getTVideoNetInfo());
      }
    }
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    ReportThumbPlayer.getInstance().onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2);
    if (SuperPlayerWrapper.access$700(this.this$0, paramInt, paramLong1, paramLong2, paramObject)) {
      return;
    }
    paramInt = SuperPlayerMsg.convert(paramInt);
    paramITPPlayer = SuperPlayerWrapper.access$100(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inner listener called : onInfo, what:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", arg1:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", arg2:");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", extraObject:");
    localStringBuilder.append(paramObject);
    LogUtil.i(paramITPPlayer, localStringBuilder.toString());
    this.mWrapperCallback.onInfo(this.this$0, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    ReportThumbPlayer.getInstance().onPrepared(paramITPPlayer);
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
    paramITPPlayer = SuperPlayerWrapper.access$100(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inner listener called : onVideoSizeChanged, width:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", height:");
    localStringBuilder.append(paramLong2);
    LogUtil.i(paramITPPlayer, localStringBuilder.toString());
    this.mWrapperCallback.onVideoSizeChanged(this.this$0, (int)paramLong1, (int)paramLong2);
  }
  
  void setCaptureListener(SuperPlayerWrapper.WrapperIdCaptureListener paramWrapperIdCaptureListener)
  {
    this.mCaptureListener = paramWrapperIdCaptureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper.TPPlayerListenerAdapter
 * JD-Core Version:    0.7.0.1
 */