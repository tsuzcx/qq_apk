package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

class VideoExtractFrameTask$4
  implements TVK_IMediaPlayer.OnInfoListener
{
  VideoExtractFrameTask$4(VideoExtractFrameTask paramVideoExtractFrameTask) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = VideoExtractFrameTask.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("播放器状态回调 onInfo what = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", extra = ");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d(paramTVK_IMediaPlayer, 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    paramTVK_IMediaPlayer = null;
    if (paramInt != 39)
    {
      if ((paramInt == 43) && (VideoExtractFrameTask.a(this.a) != null))
      {
        localObject = VideoExtractFrameTask.a(this.a);
        if ((paramObject instanceof String)) {
          paramTVK_IMediaPlayer = (String)paramObject;
        }
        ((VideoExtractFrameTask.Callback)localObject).a(5, paramTVK_IMediaPlayer, null, 0L);
      }
    }
    else if (VideoExtractFrameTask.a(this.a) != null)
    {
      VideoExtractFrameTask.Callback localCallback = VideoExtractFrameTask.a(this.a);
      paramTVK_IMediaPlayer = (TVK_IMediaPlayer)localObject;
      if ((paramObject instanceof String)) {
        paramTVK_IMediaPlayer = (String)paramObject;
      }
      localCallback.a(2, paramTVK_IMediaPlayer, null, 0L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoExtractFrameTask.4
 * JD-Core Version:    0.7.0.1
 */