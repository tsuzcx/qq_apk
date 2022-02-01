package com.tencent.oscarcamera.particlesystem;

public class Value
{
  private static final String TAG = "Value";
  private static final int TYPE_CONST = 0;
  private static final int TYPE_EXPRESSION = 1;
  private double mConstVal = 0.0D;
  private long mNativeExpression = -1L;
  private int mType = 0;
  
  public Value(Object paramObject)
  {
    if ((paramObject instanceof Number))
    {
      this.mType = 0;
      this.mConstVal = ((Number)paramObject).doubleValue();
      this.mNativeExpression = -1L;
      return;
    }
    if ((paramObject instanceof String))
    {
      this.mType = 1;
      this.mNativeExpression = ParticleSystem.compile((String)paramObject);
    }
  }
  
  public long expression()
  {
    return this.mNativeExpression;
  }
  
  public double value()
  {
    int i = this.mType;
    if (i == 0) {
      return this.mConstVal;
    }
    if (i == 1) {}
    return 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.Value
 * JD-Core Version:    0.7.0.1
 */