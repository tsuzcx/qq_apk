package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.Utils;
import com.tencent.superplayer.vinfo.VInfoGetter.VInfoGetterListener;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

class SuperPlayerWrapper$TPPlayerListenerAdapter
  implements VInfoGetter.VInfoGetterListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoSizeChangedListener, TPCaptureCallBack
{
  private SuperPlayerWrapper.WrapperIdCaptureListener mCaptureListener;
  
  private SuperPlayerWrapper$TPPlayerListenerAdapter(SuperPlayerWrapper paramSuperPlayerWrapper) {}
  
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
    SuperPlayerWrapper.access$300(this.this$0).changeStateAndNotify(7);
    SuperPlayerWrapper.access$500(this.this$0).onCompletion(this.this$0);
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onError, errorType:" + paramInt1 + ", errorCode:" + paramInt2 + ", arg1:" + paramLong1 + ", arg2:" + paramLong2);
    SuperPlayerWrapper.access$300(this.this$0).changeStateAndNotify(9);
    SuperPlayerWrapper.access$500(this.this$0).onError(this.this$0, 1, paramInt1, paramInt2, paramLong1 + ":" + paramLong2);
  }
  
  public void onGetVInfoFailed(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt, String paramString)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onGetVInfoFailed:" + paramInt + "+" + paramString);
    if (SuperPlayerWrapper.access$500(this.this$0) != null) {
      SuperPlayerWrapper.access$500(this.this$0).onError(this.this$0, 3, 0, paramInt, paramString);
    }
    SuperPlayerWrapper.access$300(this.this$0).changeStateAndNotify(9);
  }
  
  public void onGetVInfoSuccess(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onGetVInfoSuccess:" + paramSuperPlayerVideoInfo);
    if (paramSuperPlayerVideoInfo == SuperPlayerWrapper.access$200(this.this$0))
    {
      if (TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) {
        break label126;
      }
      SuperPlayerWrapper.access$300(this.this$0).changeStateAndNotify(2);
      SuperPlayerWrapper.access$400(this.this$0, paramSuperPlayerVideoInfo);
    }
    for (;;)
    {
      if (SuperPlayerWrapper.access$500(this.this$0) != null)
      {
        SuperPlayerWrapper.access$500(this.this$0).onDefinitionInfoUpdate(this.this$0, paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinitionStr(), paramSuperPlayerVideoInfo.getTVideoNetInfo().getDefinitionStrList());
        SuperPlayerWrapper.access$500(this.this$0).onTVideoNetInfoUpdate(this.this$0, paramSuperPlayerVideoInfo.getTVideoNetInfo());
      }
      return;
      label126:
      if (SuperPlayerWrapper.access$500(this.this$0) != null) {
        SuperPlayerWrapper.access$500(this.this$0).onError(this.this$0, 3, 0, 101, null);
      }
      SuperPlayerWrapper.access$300(this.this$0).changeStateAndNotify(9);
    }
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onInfo, what:" + paramInt + ", arg1:" + paramLong1 + ", arg2:" + paramLong2);
    paramInt = Utils.convertPlayerMsg(paramInt);
    SuperPlayerWrapper.access$500(this.this$0).onInfo(this.this$0, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onPrepared");
    SuperPlayerWrapper.access$300(this.this$0).changeStateAndNotify(4);
    SuperPlayerWrapper.access$500(this.this$0).onVideoPrepared(this.this$0);
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onSeekComplete");
    SuperPlayerWrapper.access$500(this.this$0).onSeekComplete(this.this$0);
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onVideoFrameOut");
  }
  
  public void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onVideoSizeChanged, width:" + paramLong1 + ", height:" + paramLong2);
    SuperPlayerWrapper.access$500(this.this$0).onVideoSizeChanged(this.this$0, (int)paramLong1, (int)paramLong2);
  }
  
  public void setCaptureListener(SuperPlayerWrapper.WrapperIdCaptureListener paramWrapperIdCaptureListener)
  {
    this.mCaptureListener = paramWrapperIdCaptureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper.TPPlayerListenerAdapter
 * JD-Core Version:    0.7.0.1
 */