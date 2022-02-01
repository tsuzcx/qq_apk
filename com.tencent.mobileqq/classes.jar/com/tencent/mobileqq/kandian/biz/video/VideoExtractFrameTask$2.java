package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

class VideoExtractFrameTask$2
  implements TVK_IMediaPlayer.OnErrorListener
{
  VideoExtractFrameTask$2(VideoExtractFrameTask paramVideoExtractFrameTask) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = VideoExtractFrameTask.a();
      paramObject = new StringBuilder();
      paramObject.append("播放器状态回调 onError model = ");
      paramObject.append(paramInt1);
      paramObject.append(", what = ");
      paramObject.append(paramInt2);
      paramObject.append(", detailInfo = ");
      paramObject.append(paramString);
      QLog.d(paramTVK_IMediaPlayer, 2, paramObject.toString());
    }
    if (VideoExtractFrameTask.a(this.a) != null)
    {
      paramTVK_IMediaPlayer = VideoExtractFrameTask.a(this.a);
      paramString = new StringBuilder();
      paramString.append(paramInt1);
      paramString.append("-");
      paramString.append(paramInt2);
      paramTVK_IMediaPlayer.a(3, paramString.toString(), null, 0L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoExtractFrameTask.2
 * JD-Core Version:    0.7.0.1
 */