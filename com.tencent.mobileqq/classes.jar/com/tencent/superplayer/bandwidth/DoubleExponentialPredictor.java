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
    float f1 = this.weight;
    f1 /= (1.0F - f1);
    float f2 = (float)(paramLong - l);
    return ((float)(2L * paramLong - l) + f1 * f2);
  }
  
  public void reset()
  {
    super.reset();
    this.firstExponential.reset();
    this.secondExponential.reset();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoubleExponentialPredictor(");
    localStringBuilder.append(this.weight);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.DoubleExponentialPredictor
 * JD-Core Version:    0.7.0.1
 */