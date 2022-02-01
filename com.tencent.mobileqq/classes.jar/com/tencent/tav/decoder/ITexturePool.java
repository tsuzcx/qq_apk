package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.TextureInfo;

public abstract interface ITexturePool
{
  public abstract TextureInfo popTexture(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void pushTexture(TextureInfo paramTextureInfo);
  
  public abstract void release();
  
  public abstract void setMaxCacheLength(int paramInt);
  
  public abstract void setMaxCacheSize(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.ITexturePool
 * JD-Core Version:    0.7.0.1
 */