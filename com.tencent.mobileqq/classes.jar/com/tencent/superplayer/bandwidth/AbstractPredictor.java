package com.tencent.superplayer.bandwidth;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractPredictor
{
  private static final float DEFAULT_PREDICTION_SHAKE = 0.2F;
  private final ArrayList<AbstractPredictor> childPredictors = new ArrayList();
  protected long currentPredition;
  protected long prediction;
  
  protected void addChildPredictor(AbstractPredictor paramAbstractPredictor)
  {
    if (!this.childPredictors.contains(paramAbstractPredictor)) {
      this.childPredictors.add(paramAbstractPredictor);
    }
  }
  
  public void onIdle()
  {
    Iterator localIterator = this.childPredictors.iterator();
    while (localIterator.hasNext()) {
      ((AbstractPredictor)localIterator.next()).onIdle();
    }
    this.currentPredition = 0L;
  }
  
  abstract long onSample(long paramLong);
  
  public void reset()
  {
    Iterator localIterator = this.childPredictors.iterator();
    while (localIterator.hasNext()) {
      ((AbstractPredictor)localIterator.next()).reset();
    }
    this.prediction = 0L;
  }
  
  public void sample(long paramLong)
  {
    Iterator localIterator = this.childPredictors.iterator();
    while (localIterator.hasNext()) {
      ((AbstractPredictor)localIterator.next()).sample(paramLong);
    }
    this.currentPredition = onSample(paramLong);
    if (this.currentPredition < 0L) {
      this.currentPredition = 0L;
    }
    float f = (float)Math.abs(this.currentPredition - this.prediction);
    paramLong = this.prediction;
    if (f / (float)paramLong < 0.2F)
    {
      this.prediction = Math.max(this.currentPredition, paramLong);
      return;
    }
    this.prediction = this.currentPredition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.AbstractPredictor
 * JD-Core Version:    0.7.0.1
 */