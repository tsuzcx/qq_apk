package com.tencent.oscarcamera.particlesystem;

public class Attribute
{
  public String mName;
  public Value mValue;
  public int mVarIndex;
  
  public long expression()
  {
    if (this.mValue != null) {
      return this.mValue.expression();
    }
    return -1L;
  }
  
  public double value()
  {
    if (this.mValue != null) {
      return this.mValue.value();
    }
    return 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.Attribute
 * JD-Core Version:    0.7.0.1
 */