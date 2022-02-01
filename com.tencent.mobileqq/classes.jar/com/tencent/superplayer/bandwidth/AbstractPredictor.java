package com.tencent.superplayer.bandwidth;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractPredictor
{
  private ArrayList<AbstractPredictor> childPredictors = new ArrayList();
  protected long currentPredition;
  protected long prediction;
  
  protected void addChildPredictor(AbstractPredictor paramAbstractPredictor)
  {
    if (this.childPredictors.indexOf(paramAbstractPredictor) < 0) {
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
    if ((float)Math.abs(this.currentPredition - this.prediction) / (float)this.prediction < 0.2F)
    {
      this.prediction = Math.max(this.currentPredition, this.prediction);
      return;
    }
    this.prediction = this.currentPredition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.AbstractPredictor
 * JD-Core Version:    0.7.0.1
 */