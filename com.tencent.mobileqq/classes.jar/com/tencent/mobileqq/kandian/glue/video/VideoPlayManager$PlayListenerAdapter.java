package com.tencent.mobileqq.kandian.glue.video;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.player.MediaPlayListenerAdapter;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;

public class VideoPlayManager$PlayListenerAdapter
  extends MediaPlayListenerAdapter
{
  public VideoPlayManager$PlayListenerAdapter(VideoPlayManager paramVideoPlayManager) {}
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    if ((paramIVideoPlayerWrapper instanceof VideoPlayerWrapper)) {
      VideoPlayManager.a(this.a, (VideoPlayerWrapper)paramIVideoPlayerWrapper);
    }
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, Object paramObject)
  {
    if ((paramIVideoPlayerWrapper instanceof VideoPlayerWrapper)) {
      VideoPlayManager.a(this.a, (VideoPlayerWrapper)paramIVideoPlayerWrapper, paramObject);
    }
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, String paramString)
  {
    paramIVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
    if ((VideoPlayManager.a(this.a) != null) && (VideoPlayManager.a(this.a).a != null)) {
      VideoPlayManager.a(this.a).a.h = paramString;
    }
    if (VideoPlayManager.a(this.a) != null) {
      VideoBufferRangeController.a().a(paramIVideoPlayerWrapper, VideoPlayManager.a(this.a).b, paramIVideoPlayerWrapper.d());
    }
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      paramIVideoPlayerWrapper = new StringBuilder();
      paramIVideoPlayerWrapper.append("onCaptureImage , id : ");
      paramIVideoPlayerWrapper.append(paramInt2);
      paramIVideoPlayerWrapper.append(" succ : ");
      paramIVideoPlayerWrapper.append(paramBoolean);
      paramIVideoPlayerWrapper.append(" errCode : ");
      paramIVideoPlayerWrapper.append(paramInt1);
      QLog.d("Q.readinjoy.video", 2, paramIVideoPlayerWrapper.toString());
    }
    if (VideoPlayManager.a(this.a).size() >= 10)
    {
      paramIVideoPlayerWrapper = (Pair)VideoPlayManager.a(this.a).remove(0);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Capture Image Pool full ! remove first image, id : ");
        localStringBuilder.append(paramIVideoPlayerWrapper.first);
        QLog.d("Q.readinjoy.video", 2, localStringBuilder.toString());
      }
    }
    if (paramBoolean) {
      VideoPlayManager.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((VideoPlayerWrapper)VideoPlayManager.a(this.a).get(Integer.valueOf(paramInt2))).l();
  }
  
  public boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if ((paramIVideoPlayerWrapper instanceof VideoPlayerWrapper)) {
      return VideoPlayManager.a(this.a, (VideoPlayerWrapper)paramIVideoPlayerWrapper, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    }
    return false;
  }
  
  public boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    if ((paramIVideoPlayerWrapper instanceof VideoPlayerWrapper)) {
      return VideoPlayManager.a(this.a, (VideoPlayerWrapper)paramIVideoPlayerWrapper, paramInt, paramObject);
    }
    return false;
  }
  
  public void c(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    if (QLog.isColorLevel())
    {
      String str = VideoPlayManager.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSeekComplete(): video seek complete ! curPlayState:");
      localStringBuilder.append(VideoPlayUtils.a(this.a.a()));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((paramIVideoPlayerWrapper == VideoPlayManager.a(this.a)) && (this.a.a() != 5)) {
      VideoPlayManager.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.PlayListenerAdapter
 * JD-Core Version:    0.7.0.1
 */