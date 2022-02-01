package com.tencent.taveffect.core;

public abstract interface TAVTextureProcessor
{
  public abstract TAVTextureInfo applyNewTexture(TAVTextureInfo paramTAVTextureInfo);
  
  public abstract void onProcess(TAVTextureInfo paramTAVTextureInfo);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVTextureProcessor
 * JD-Core Version:    0.7.0.1
 */