package com.tencent.superplayer.bandwidth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExoPredictor
  extends AbstractPredictor
{
  public static final int DEFAULT_MAX_WEIGHT = 500;
  private int currentWeight;
  private final MoveAvgPredictor mAvgPredictor;
  private int maxWeight;
  private final ArrayList<Long> samples;
  private final float weightFactor;
  
  public ExoPredictor(float paramFloat)
  {
    this.weightFactor = paramFloat;
    this.samples = new ArrayList();
    this.maxWeight = 500;
    this.mAvgPredictor = new MoveAvgPredictor((int)paramFloat);
    addChildPredictor(this.mAvgPredictor);
  }
  
  private void resetMaxWeight()
  {
    double d1 = Math.sqrt(this.mAvgPredictor.prediction);
    double d2 = this.weightFactor;
    Double.isNaN(d2);
    int i = (int)(d1 * d2);
    if (i > 0) {
      this.maxWeight = i;
    }
  }
  
  public void onIdle()
  {
    resetMaxWeight();
    super.onIdle();
  }
  
  public long onSample(long paramLong)
  {
    double d1 = Math.sqrt(paramLong);
    long l1;
    for (;;)
    {
      d2 = this.currentWeight;
      Double.isNaN(d2);
      if ((d2 + d1 <= this.maxWeight) || (this.samples.size() <= 0)) {
        break;
      }
      l1 = ((Long)this.samples.remove(0)).longValue();
      d2 = this.currentWeight;
      double d3 = Math.sqrt(l1);
      Double.isNaN(d2);
      this.currentWeight = ((int)(d2 - d3));
    }
    this.samples.add(Long.valueOf(paramLong));
    double d2 = this.currentWeight;
    Double.isNaN(d2);
    this.currentWeight = ((int)(d2 + d1));
    int i = this.maxWeight / 2;
    Object localObject = (List)this.samples.clone();
    Collections.sort((List)localObject);
    if (this.currentWeight > i)
    {
      localObject = ((List)localObject).iterator();
      long l2 = 0L;
      l1 = 0L;
      Long localLong;
      do
      {
        paramLong = l2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localLong = (Long)((Iterator)localObject).next();
        d1 = l1;
        d2 = Math.sqrt(localLong.longValue());
        Double.isNaN(d1);
        paramLong = (d1 + d2);
        l1 = paramLong;
      } while (paramLong <= i);
      paramLong = localLong.longValue();
    }
    else
    {
      paramLong = ((Long)((List)localObject).get(((List)localObject).size() - 1)).longValue();
    }
    if (this.samples.size() >= this.weightFactor) {
      resetMaxWeight();
    }
    return paramLong;
  }
  
  public void reset()
  {
    super.reset();
    this.samples.clear();
    this.currentWeight = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExoPredictor(");
    localStringBuilder.append(this.maxWeight);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.ExoPredictor
 * JD-Core Version:    0.7.0.1
 */