package com.tencent.oskplayer.datasource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SlidingPercentile
{
  private static final Comparator<SlidingPercentile.Sample> INDEX_COMPARATOR = new SlidingPercentile.1();
  private static final int MAX_RECYCLED_SAMPLES = 5;
  private static final int SORT_ORDER_BY_INDEX = 1;
  private static final int SORT_ORDER_BY_VALUE = 0;
  private static final int SORT_ORDER_NONE = -1;
  private static final Comparator<SlidingPercentile.Sample> VALUE_COMPARATOR = new SlidingPercentile.2();
  private int currentSortOrder;
  private final int maxWeight;
  private int nextSampleIndex;
  private int recycledSampleCount;
  private final SlidingPercentile.Sample[] recycledSamples;
  private final ArrayList<SlidingPercentile.Sample> samples;
  private int totalWeight;
  
  public SlidingPercentile(int paramInt)
  {
    this.maxWeight = paramInt;
    this.recycledSamples = new SlidingPercentile.Sample[5];
    this.samples = new ArrayList();
    this.currentSortOrder = -1;
  }
  
  private void ensureSortedByIndex()
  {
    if (this.currentSortOrder != 1)
    {
      Collections.sort(this.samples, INDEX_COMPARATOR);
      this.currentSortOrder = 1;
    }
  }
  
  private void ensureSortedByValue()
  {
    if (this.currentSortOrder != 0)
    {
      Collections.sort(this.samples, VALUE_COMPARATOR);
      this.currentSortOrder = 0;
    }
  }
  
  public void addSample(int paramInt, float paramFloat)
  {
    ensureSortedByIndex();
    Object localObject;
    if (this.recycledSampleCount > 0)
    {
      localObject = this.recycledSamples;
      int i = this.recycledSampleCount - 1;
      this.recycledSampleCount = i;
      localObject = localObject[i];
      i = this.nextSampleIndex;
      this.nextSampleIndex = (i + 1);
      ((SlidingPercentile.Sample)localObject).index = i;
      ((SlidingPercentile.Sample)localObject).weight = paramInt;
      ((SlidingPercentile.Sample)localObject).value = paramFloat;
      this.samples.add(localObject);
      this.totalWeight += paramInt;
    }
    for (;;)
    {
      if (this.totalWeight <= this.maxWeight) {
        return;
      }
      paramInt = this.totalWeight - this.maxWeight;
      localObject = (SlidingPercentile.Sample)this.samples.get(0);
      if (((SlidingPercentile.Sample)localObject).weight <= paramInt)
      {
        this.totalWeight -= ((SlidingPercentile.Sample)localObject).weight;
        this.samples.remove(0);
        if (this.recycledSampleCount >= 5) {
          continue;
        }
        SlidingPercentile.Sample[] arrayOfSample = this.recycledSamples;
        paramInt = this.recycledSampleCount;
        this.recycledSampleCount = (paramInt + 1);
        arrayOfSample[paramInt] = localObject;
        continue;
        localObject = new SlidingPercentile.Sample(null);
        break;
      }
      ((SlidingPercentile.Sample)localObject).weight -= paramInt;
      this.totalWeight -= paramInt;
    }
  }
  
  public float getPercentile(float paramFloat)
  {
    ensureSortedByValue();
    float f = this.totalWeight;
    int i = 0;
    int j = 0;
    while (i < this.samples.size())
    {
      SlidingPercentile.Sample localSample = (SlidingPercentile.Sample)this.samples.get(i);
      j += localSample.weight;
      if (j >= paramFloat * f) {
        return localSample.value;
      }
      i += 1;
    }
    if (this.samples.isEmpty()) {
      return (0.0F / 0.0F);
    }
    return ((SlidingPercentile.Sample)this.samples.get(this.samples.size() - 1)).value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.SlidingPercentile
 * JD-Core Version:    0.7.0.1
 */