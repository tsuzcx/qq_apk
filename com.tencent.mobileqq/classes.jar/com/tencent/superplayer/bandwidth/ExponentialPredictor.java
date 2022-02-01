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
    if (this.currentPredition > 0L) {
      l = (this.weight * (float)paramLong + (1.0F - this.weight) * (float)this.currentPredition);
    }
    return l;
  }
  
  public String toString()
  {
    return "ExponentialPredictor(" + this.weight + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.ExponentialPredictor
 * JD-Core Version:    0.7.0.1
 */