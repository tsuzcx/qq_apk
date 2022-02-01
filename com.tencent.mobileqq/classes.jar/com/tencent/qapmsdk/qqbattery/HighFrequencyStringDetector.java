package com.tencent.qapmsdk.qqbattery;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HighFrequencyStringDetector
{
  private int maintainCount;
  private final LinkedHashMap<String, Integer> map;
  private int maxAppearCount;
  
  public HighFrequencyStringDetector(int paramInt1, int paramInt2)
  {
    this.maintainCount = paramInt1;
    this.maxAppearCount = paramInt2;
    this.map = new LinkedHashMap(paramInt1, 0.5F, true);
  }
  
  public void clear()
  {
    synchronized (this.map)
    {
      this.map.clear();
      return;
    }
  }
  
  @Nullable
  public Map<String, Integer> getHighFrequencyString()
  {
    synchronized (this.map)
    {
      Iterator localIterator = this.map.entrySet().iterator();
      Object localObject1 = null;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((Integer)localEntry.getValue()).intValue() >= this.maxAppearCount)
        {
          Object localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new HashMap();
          }
          ((Map)localObject3).put(localEntry.getKey(), localEntry.getValue());
          localObject1 = localObject3;
        }
      }
      return localObject1;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void putString(String paramString)
  {
    synchronized (this.map)
    {
      if (this.map.containsKey(paramString)) {
        this.map.put(paramString, Integer.valueOf(((Integer)this.map.get(paramString)).intValue() + 1));
      } else {
        this.map.put(paramString, Integer.valueOf(1));
      }
      while (this.map.size() > this.maintainCount)
      {
        paramString = (Map.Entry)this.map.entrySet().iterator().next();
        this.map.remove(paramString.getKey());
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.HighFrequencyStringDetector
 * JD-Core Version:    0.7.0.1
 */