package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;

public abstract interface IVideoDecoder
  extends IDecoder
{
  public abstract TextureInfo getTextureInfo();
  
  public abstract boolean isLastFrameValid();
  
  public abstract Surface outputSurface();
  
  public abstract void release(boolean paramBoolean);
  
  public abstract void seekTo(CMTime paramCMTime, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.IVideoDecoder
 * JD-Core Version:    0.7.0.1
 */