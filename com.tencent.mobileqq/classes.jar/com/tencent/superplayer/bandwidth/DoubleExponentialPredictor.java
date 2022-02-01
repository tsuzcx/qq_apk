package com.tencent.superplayer.bandwidth;

public class DoubleExponentialPredictor
  extends AbstractPredictor
{
  private final ExponentialPredictor firstExponential;
  private final ExponentialPredictor secondExponential;
  private final float weight;
  
  public DoubleExponentialPredictor(float paramFloat)
  {
    this.weight = paramFloat;
    this.firstExponential = new ExponentialPredictor(this.weight);
    this.secondExponential = new ExponentialPredictor(this.weight);
  }
  
  public void onIdle()
  {
    super.onIdle();
    this.firstExponential.onIdle();
    this.secondExponential.onIdle();
  }
  
  public long onSample(long paramLong)
  {
    this.firstExponential.sample(paramLong);
    paramLong = this.firstExponential.currentPredition;
    this.secondExponential.sample(paramLong);
    long l = this.secondExponential.currentPredition;
    float f = this.weight / (1.0F - this.weight);
    return ((float)(paramLong - l) * f + (float)(2L * paramLong - l));
  }
  
  public void reset()
  {
    super.reset();
    this.firstExponential.reset();
    this.secondExponential.reset();
  }
  
  public String toString()
  {
    return "DoubleExponentialPredictor(" + this.weight + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.DoubleExponentialPredictor
 * JD-Core Version:    0.7.0.1
 */