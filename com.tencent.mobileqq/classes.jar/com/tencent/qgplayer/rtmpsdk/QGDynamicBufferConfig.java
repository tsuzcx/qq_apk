package com.tencent.qgplayer.rtmpsdk;

public class QGDynamicBufferConfig
{
  private float a = 4.0F;
  private boolean b = true;
  private float c = 4.0F;
  private float d = 1.0F;
  private float e = 0.5F;
  private float f = 8.0F;
  private float g = 1.0F;
  private float h = 1200.0F;
  
  public float getAdjustInterval()
  {
    return this.h;
  }
  
  public float getDownAdjustUnit()
  {
    return this.e;
  }
  
  public float getFixBufferSize()
  {
    return this.a;
  }
  
  public float getInitDynamicBufferSize()
  {
    return this.c;
  }
  
  public float getMaxDynamicBufferSize()
  {
    return this.f;
  }
  
  public float getMinDynamicBufferSize()
  {
    return this.g;
  }
  
  public float getUpAdjustUnit()
  {
    return this.d;
  }
  
  public boolean isUseDynamicBuffer()
  {
    return this.b;
  }
  
  public void setAdjustInterval(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void setDownAdjustUnit(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void setFixBufferSize(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void setInitDynamicBufferSize(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void setIsUseDynamicBuffer(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setMaxDynamicBufferSize(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void setMinDynamicBufferSize(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void setUpAdjustUnit(float paramFloat)
  {
    this.d = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.QGDynamicBufferConfig
 * JD-Core Version:    0.7.0.1
 */