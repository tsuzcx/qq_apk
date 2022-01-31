package com.tencent.mobileqq.dinifly;

import android.support.v4.util.ArraySet;
import android.util.Log;
import android.util.Pair;
import com.tencent.mobileqq.dinifly.utils.MeanCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PerformanceTracker
{
  private boolean enabled = false;
  private final Comparator<Pair<String, Float>> floatComparator = new PerformanceTracker.1(this);
  private final Set<PerformanceTracker.FrameListener> frameListeners = new ArraySet();
  private final Map<String, MeanCalculator> layerRenderTimes = new HashMap();
  
  public void addFrameListener(PerformanceTracker.FrameListener paramFrameListener)
  {
    this.frameListeners.add(paramFrameListener);
  }
  
  public void clearRenderTimes()
  {
    this.layerRenderTimes.clear();
  }
  
  public List<Pair<String, Float>> getSortedRenderTimes()
  {
    if (!this.enabled) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(this.layerRenderTimes.size());
    Iterator localIterator = this.layerRenderTimes.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(new Pair(localEntry.getKey(), Float.valueOf(((MeanCalculator)localEntry.getValue()).getMean())));
    }
    Collections.sort(localArrayList, this.floatComparator);
    return localArrayList;
  }
  
  public void logRenderTimes()
  {
    if (!this.enabled) {}
    for (;;)
    {
      return;
      List localList = getSortedRenderTimes();
      Log.d("LOTTIE", "Render times:");
      int i = 0;
      while (i < localList.size())
      {
        Pair localPair = (Pair)localList.get(i);
        Log.d("LOTTIE", String.format("\t\t%30s:%.2f", new Object[] { localPair.first, localPair.second }));
        i += 1;
      }
    }
  }
  
  public void recordRenderTime(String paramString, float paramFloat)
  {
    if (!this.enabled) {}
    for (;;)
    {
      return;
      MeanCalculator localMeanCalculator2 = (MeanCalculator)this.layerRenderTimes.get(paramString);
      MeanCalculator localMeanCalculator1 = localMeanCalculator2;
      if (localMeanCalculator2 == null)
      {
        localMeanCalculator1 = new MeanCalculator();
        this.layerRenderTimes.put(paramString, localMeanCalculator1);
      }
      localMeanCalculator1.add(paramFloat);
      if (paramString.equals("__container"))
      {
        paramString = this.frameListeners.iterator();
        while (paramString.hasNext()) {
          ((PerformanceTracker.FrameListener)paramString.next()).onFrameRendered(paramFloat);
        }
      }
    }
  }
  
  public void removeFrameListener(PerformanceTracker.FrameListener paramFrameListener)
  {
    this.frameListeners.add(paramFrameListener);
  }
  
  void setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.PerformanceTracker
 * JD-Core Version:    0.7.0.1
 */