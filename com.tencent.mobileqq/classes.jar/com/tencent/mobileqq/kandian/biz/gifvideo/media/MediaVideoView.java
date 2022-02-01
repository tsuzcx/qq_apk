package com.tencent.mobileqq.kandian.biz.gifvideo.media;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;

public class MediaVideoView
  extends VideoView
  implements IMediaView
{
  public MediaVideoView(Context paramContext)
  {
    super(paramContext);
    setScaleType(2);
  }
  
  public MediaVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MediaVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    startPlay();
  }
  
  public void b()
  {
    stop();
  }
  
  public void c()
  {
    pause();
  }
  
  public void d()
  {
    destroy();
  }
  
  public int getMediaType()
  {
    return 1;
  }
  
  public boolean isPlaying()
  {
    return getCurrentState() == 7;
  }
  
  public void setMediaCoverUrl(String paramString)
  {
    setCoverUrl(paramString);
  }
  
  public void setMediaPlayUrl(String paramString)
  {
    setVideoUrl(paramString);
  }
  
  public void setMediaPlayVid(String paramString)
  {
    setVideoVid(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.media.MediaVideoView
 * JD-Core Version:    0.7.0.1
 */