package com.tencent.weseevideo.composition.interfaces;

import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;

public abstract interface ICompositionUpdateInterface
{
  public abstract void durationUpdate(CMTime paramCMTime);
  
  public abstract void renderSizeUpdate(CGSize paramCGSize);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.composition.interfaces.ICompositionUpdateInterface
 * JD-Core Version:    0.7.0.1
 */