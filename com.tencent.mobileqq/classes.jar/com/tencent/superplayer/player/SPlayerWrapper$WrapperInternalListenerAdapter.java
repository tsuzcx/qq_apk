package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.SPlayerLogUtil;
import com.tencent.superplayer.utils.SPlayerUtils;
import com.tencent.superplayer.vinfo.VInfoGetter.VInfoGetterListener;
import com.tencent.thumbplayer.api.TPPropertyID;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

class SPlayerWrapper$WrapperInternalListenerAdapter
  implements SPTPPlayerListeners.Combine, VInfoGetter.VInfoGetterListener
{
  private SPlayerWrapper$WrapperInternalListenerAdapter(SPlayerWrapper paramSPlayerWrapper) {}
  
  public void onCaptureVideoFailed(int paramInt)
  {
    SPlayerLogUtil.i(SPlayerWrapper.access$300(this.this$0), "inner listener called : onCaptureVideoFailed, errorCode:" + paramInt);
    SPlayerWrapper.access$500(this.this$0).onCaptureImageFailed(this.this$0, 0, paramInt);
  }
  
  public void onCaptureVideoSuccess(Bitmap paramBitmap)
  {
    SPlayerLogUtil.i(SPlayerWrapper.access$300(this.this$0), "inner listener called : onCaptureVideoSuccess");
    SPlayerWrapper.access$500(this.this$0).onCaptureImageSucceed(this.this$0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap);
  }
  
  public void onCompletion(ISPTPPlayer paramISPTPPlayer)
  {
    SPlayerLogUtil.i(SPlayerWrapper.access$300(this.this$0), "inner listener called : onCompletion");
    SPlayerWrapper.access$400(this.this$0).changeStateAndNotify(7);
    SPlayerWrapper.access$500(this.this$0).onCompletion(this.this$0);
  }
  
  public void onError(ISPTPPlayer paramISPTPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    SPlayerLogUtil.i(SPlayerWrapper.access$300(this.this$0), "inner listener called : onError, errorType:" + paramInt1 + ", errorCode:" + paramInt2 + ", arg1:" + paramLong1 + ", arg2:" + paramLong2);
    SPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
    SPlayerWrapper.access$500(this.this$0).onError(this.this$0, 1, paramInt1, paramInt2, paramLong1 + ":" + paramLong2);
  }
  
  public void onGetVInfoFailed(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt, String paramString)
  {
    SPlayerLogUtil.i(SPlayerWrapper.access$300(this.this$0), "inner listener called : onGetVInfoFailed:" + paramInt + "+" + paramString);
    if (SPlayerWrapper.access$500(this.this$0) != null) {
      SPlayerWrapper.access$500(this.this$0).onError(this.this$0, 3, 0, paramInt, paramString);
    }
    SPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
  }
  
  public void onGetVInfoSuccess(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    SPlayerLogUtil.i(SPlayerWrapper.access$300(this.this$0), "inner listener called : onGetVInfoSuccess:" + paramSuperPlayerVideoInfo);
    if (paramSuperPlayerVideoInfo == SPlayerWrapper.access$600(this.this$0))
    {
      if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl()))
      {
        SPlayerWrapper.access$400(this.this$0).changeStateAndNotify(2);
        SPlayerWrapper.access$700(this.this$0, paramSuperPlayerVideoInfo);
      }
    }
    else {
      return;
    }
    if (SPlayerWrapper.access$500(this.this$0) != null) {
      SPlayerWrapper.access$500(this.this$0).onError(this.this$0, 3, 0, 101, null);
    }
    SPlayerWrapper.access$400(this.this$0).changeStateAndNotify(9);
  }
  
  public void onInfo(ISPTPPlayer paramISPTPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    SPlayerLogUtil.i(SPlayerWrapper.access$300(this.this$0), "inner listener called : onInfo, what:" + paramInt + ", arg1:" + paramLong1 + ", arg2:" + paramLong2);
    paramInt = SPlayerUtils.convertPlayerMsg(paramInt);
    SPlayerWrapper.access$500(this.this$0).onInfo(this.this$0, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared(ISPTPPlayer paramISPTPPlayer)
  {
    String str = paramISPTPPlayer.getPropertyString(TPPropertyID.STRING_MEDIA_INFO);
    long l = paramISPTPPlayer.getPropertyLong(TPPropertyID.LONG_VIDEO_ROTATION);
    MediaInfo localMediaInfo = MediaInfo.obtainMediaInfoFromString(SPlayerWrapper.access$100(this.this$0), str);
    localMediaInfo.setDurationMs(paramISPTPPlayer.getDurationMs());
    localMediaInfo.setVideoRotation((int)l);
    SPlayerWrapper.access$202(this.this$0, localMediaInfo);
    SPlayerLogUtil.i(SPlayerWrapper.access$300(this.this$0), "inner listener called : onPrepared print mediaInfoStr:\n" + str + "  \nrotation:" + l);
    SPlayerWrapper.access$400(this.this$0).changeStateAndNotify(4);
    SPlayerWrapper.access$500(this.this$0).onVideoPrepared(this.this$0);
  }
  
  public void onSeekComplete(ISPTPPlayer paramISPTPPlayer)
  {
    SPlayerLogUtil.i(SPlayerWrapper.access$300(this.this$0), "inner listener called : onSeekComplete");
    SPlayerWrapper.access$500(this.this$0).onSeekComplete(this.this$0);
  }
  
  public void onVideoFrameOut(ISPTPPlayer paramISPTPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    SPlayerLogUtil.i(SPlayerWrapper.access$300(this.this$0), "inner listener called : onVideoFrameOut");
  }
  
  public void onVideoSizeChanged(ISPTPPlayer paramISPTPPlayer, long paramLong1, long paramLong2)
  {
    SPlayerLogUtil.i(SPlayerWrapper.access$300(this.this$0), "inner listener called : onVideoSizeChanged, width:" + paramLong1 + ", height:" + paramLong2);
    SPlayerWrapper.access$500(this.this$0).onVideoSizeChanged(this.this$0, (int)paramLong1, (int)paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SPlayerWrapper.WrapperInternalListenerAdapter
 * JD-Core Version:    0.7.0.1
 */