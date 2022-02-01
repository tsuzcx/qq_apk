package com.tencent.superplayer.bandwidth;

public class ExponentialPredictor
  extends AbstractPredictor
{
  private final float weight;
  
  public ExponentialPredictor(float paramFloat)
  {
    this.weight = paramFloat;
  }
  
  public long onSample(long paramLong)
  {
    long l = paramLong;
    if (this.currentPredition > 0L)
    {
      float f = this.weight;
      l = ((float)paramLong * f + (1.0F - f) * (float)this.currentPredition);
    }
    return l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExponentialPredictor(");
    localStringBuilder.append(this.weight);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.ExponentialPredictor
 * JD-Core Version:    0.7.0.1
 */