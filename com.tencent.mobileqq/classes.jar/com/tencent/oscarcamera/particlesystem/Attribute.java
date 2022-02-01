package com.tencent.oscarcamera.particlesystem;

public class Attribute
{
  public String mName;
  public Value mValue;
  public int mVarIndex;
  
  public long expression()
  {
    Value localValue = this.mValue;
    if (localValue != null) {
      return localValue.expression();
    }
    return -1L;
  }
  
  public double value()
  {
    Value localValue = this.mValue;
    if (localValue != null) {
      return localValue.value();
    }
    return 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.Attribute
 * JD-Core Version:    0.7.0.1
 */