package com.tencent.mobileqq.vpng.glrenderer;

public abstract interface Renderable
{
  public abstract int getRenderHeight();
  
  public abstract int getRenderWidth();
  
  public abstract void onDrawBegin();
  
  public abstract void onSetRenderer(VPNGRenderer paramVPNGRenderer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.Renderable
 * JD-Core Version:    0.7.0.1
 */