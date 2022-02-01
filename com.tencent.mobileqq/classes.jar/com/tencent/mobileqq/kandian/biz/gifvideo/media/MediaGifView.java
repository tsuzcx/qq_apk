package com.tencent.mobileqq.kandian.biz.gifvideo.media;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.gif.GifView;

public class MediaGifView
  extends GifView
  implements IMediaView
{
  public MediaGifView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MediaGifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MediaGifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    displayGif();
  }
  
  public void b()
  {
    displayCover();
  }
  
  public void c() {}
  
  public void d() {}
  
  public int getMediaType()
  {
    return 0;
  }
  
  public boolean isPlaying()
  {
    return false;
  }
  
  public void setMediaCoverUrl(String paramString)
  {
    setCoverUrl(paramString);
  }
  
  public void setMediaPlayUrl(String paramString)
  {
    setNeedGifUrl(false);
    setGifUrl(paramString);
  }
  
  public void setMediaPlayVid(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.media.MediaGifView
 * JD-Core Version:    0.7.0.1
 */