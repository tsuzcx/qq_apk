package com.tencent.mobileqq.video;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

class VipVideoPlayActivity$VideoPlayerErrorListener
  implements TVK_IMediaPlayer.OnErrorListener
{
  VipVideoPlayActivity$VideoPlayerErrorListener(VipVideoPlayActivity paramVipVideoPlayActivity) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramObject = new StringBuilder();
      paramObject.append("video player error model=");
      paramObject.append(paramInt1);
      paramTVK_IMediaPlayer.append(paramObject.toString());
      paramObject = new StringBuilder();
      paramObject.append(",what=");
      paramObject.append(paramInt2);
      paramTVK_IMediaPlayer.append(paramObject.toString());
      paramObject = new StringBuilder();
      paramObject.append(",extra=");
      paramObject.append(paramInt3);
      paramTVK_IMediaPlayer.append(paramObject.toString());
      paramObject = new StringBuilder();
      paramObject.append(",detailInfo=");
      paramObject.append(paramString);
      paramTVK_IMediaPlayer.append(paramObject.toString());
      QLog.d("VipVideoPlayActivity", 2, paramTVK_IMediaPlayer.toString());
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = VipVideoPlayActivity.b(this.a);
    this.a.a("play_error", paramInt1, paramInt2, l1 - l2, paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.video.VipVideoPlayActivity.VideoPlayerErrorListener
 * JD-Core Version:    0.7.0.1
 */