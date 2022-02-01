package com.tencent.taveffect.core;

import java.util.Collection;

public abstract interface TAVTextureTarget
{
  public abstract void addProcessor(TAVTextureProcessor paramTAVTextureProcessor);
  
  public abstract Collection<TAVTextureProcessor> getAllProcessors();
  
  public abstract void removeAllProcessors();
  
  public abstract void removeProcessor(TAVTextureProcessor paramTAVTextureProcessor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVTextureTarget
 * JD-Core Version:    0.7.0.1
 */