package com.tencent.qq.effect.alphavideo.videoplayer.view;

import android.media.MediaFormat;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener;
import com.tencent.qq.effect.utils.LogUtil;

class PlayTextureView$1
  implements IVideoFileDecodeListener
{
  PlayTextureView$1(PlayTextureView paramPlayTextureView) {}
  
  public void onVideoDecodeEnd()
  {
    LogUtil.e(PlayTextureView.access$000(this.this$0), " onVideoDecodeEnd");
    PlayTextureView.access$102(this.this$0, 0);
    PlayTextureView.access$302(this.this$0, 0);
    PlayTextureView.access$202(this.this$0, 0);
    PlayTextureView.access$1202(this.this$0, null);
    this.this$0.onPause();
    PlayTextureView.access$1300(this.this$0);
  }
  
  public void onVideoDecodeError(int paramInt)
  {
    String str = PlayTextureView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("========= onVideoDecodeError errorCode = ");
    localStringBuilder.append(paramInt);
    LogUtil.e(str, localStringBuilder.toString());
    if (paramInt != -101)
    {
      if (paramInt != -5)
      {
        if ((paramInt != -3) && (paramInt != -2) && (paramInt != -1)) {
          return;
        }
        PlayTextureView.access$102(this.this$0, 0);
        PlayTextureView.access$302(this.this$0, 0);
        PlayTextureView.access$202(this.this$0, 0);
        PlayTextureView.access$1202(this.this$0, null);
        this.this$0.onPause();
        PlayTextureView.access$1400(this.this$0, -1);
        return;
      }
      PlayTextureView.access$102(this.this$0, 0);
      PlayTextureView.access$302(this.this$0, 0);
      PlayTextureView.access$202(this.this$0, 0);
      this.this$0.onPause();
      PlayTextureView.access$1400(this.this$0, -2);
      return;
    }
    PlayTextureView.access$102(this.this$0, 0);
    PlayTextureView.access$302(this.this$0, 0);
    PlayTextureView.access$202(this.this$0, 0);
    PlayTextureView.access$1202(this.this$0, null);
    this.this$0.onPause();
    PlayTextureView.access$1400(this.this$0, -11);
  }
  
  public void onVideoDecodeFrame(long paramLong, byte[] paramArrayOfByte) {}
  
  public void onVideoDecodeStart()
  {
    LogUtil.e(PlayTextureView.access$000(this.this$0), " onVideoDecodeStart");
    PlayTextureView.access$1002(this.this$0, 0L);
    PlayTextureView.access$1102(this.this$0, 0);
    PlayTextureView.access$500(this.this$0).post(new PlayTextureView.1.2(this));
  }
  
  public void onVideoDecoderCreated(boolean paramBoolean)
  {
    LogUtil.e(PlayTextureView.access$000(this.this$0), " onVideoDecoderCreated");
  }
  
  @RequiresApi(api=16)
  public void onVideoFormat(MediaFormat paramMediaFormat)
  {
    int i;
    if ((paramMediaFormat != null) && (paramMediaFormat.containsKey("frame-rate"))) {
      i = paramMediaFormat.getInteger("frame-rate");
    } else {
      i = 0;
    }
    int j = i;
    if (i <= 0) {
      j = 25;
    }
    PlayTextureView.access$902(this.this$0, 1000000 / j);
    paramMediaFormat = PlayTextureView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mFrame Time  = ");
    localStringBuilder.append(PlayTextureView.access$900(this.this$0));
    LogUtil.v(paramMediaFormat, localStringBuilder.toString());
  }
  
  public void onVideoSize(int paramInt1, int paramInt2)
  {
    String str = PlayTextureView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoSize() called with: width = [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], height = [");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    LogUtil.e(str, localStringBuilder.toString());
    PlayTextureView.access$102(this.this$0, paramInt1);
    PlayTextureView.access$202(this.this$0, paramInt1 / 2);
    PlayTextureView.access$302(this.this$0, paramInt2);
    PlayTextureView.access$500(this.this$0).post(new PlayTextureView.1.1(this));
    if ((PlayTextureView.access$100(this.this$0) > 0) && (PlayTextureView.access$300(this.this$0) > 0) && (PlayTextureView.access$600(this.this$0) > 0) && (PlayTextureView.access$700(this.this$0) > 0)) {
      PlayTextureView.access$802(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.1
 * JD-Core Version:    0.7.0.1
 */