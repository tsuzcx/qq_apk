package com.tencent.superplayer.bandwidth;

public class DoubleMoveAvgPredictor
  extends AbstractPredictor
{
  private final MoveAvgPredictor firstMoveAvg;
  private final int maxSize;
  private final MoveAvgPredictor secondMoveAvg;
  
  public DoubleMoveAvgPredictor(int paramInt)
  {
    this.maxSize = paramInt;
    this.firstMoveAvg = new MoveAvgPredictor(this.maxSize);
    this.secondMoveAvg = new MoveAvgPredictor(this.maxSize);
  }
  
  public void onIdle()
  {
    super.onIdle();
    this.firstMoveAvg.onIdle();
    this.secondMoveAvg.onIdle();
  }
  
  public long onSample(long paramLong)
  {
    this.firstMoveAvg.sample(paramLong);
    paramLong = this.firstMoveAvg.currentPredition;
    this.secondMoveAvg.sample(paramLong);
    long l = this.secondMoveAvg.currentPredition;
    float f = 2.0F / (Math.max(this.firstMoveAvg.getSampleSize(), 2) - 1);
    return ((float)(paramLong - l) * f + (float)(2L * paramLong - l));
  }
  
  public void reset()
  {
    super.reset();
    this.firstMoveAvg.reset();
    this.secondMoveAvg.reset();
  }
  
  public String toString()
  {
    return "DoubleMoveAvgPredictor(" + this.maxSize + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.DoubleMoveAvgPredictor
 * JD-Core Version:    0.7.0.1
 */