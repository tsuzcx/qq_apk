package com.tencent.tavkit.ciimage;

import com.tencent.tav.coremedia.TextureInfo;

public abstract interface TAVTextureProcessor
{
  public abstract TextureInfo applyNewTexture(TextureInfo paramTextureInfo);
  
  public abstract void onProcess(TextureInfo paramTextureInfo);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.TAVTextureProcessor
 * JD-Core Version:    0.7.0.1
 */