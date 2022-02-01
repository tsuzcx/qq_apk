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
    HashMap localHashMap = null;
    label110:
    for (;;)
    {
      synchronized (this.map)
      {
        Iterator localIterator = this.map.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((Integer)localEntry.getValue()).intValue() < this.maxAppearCount) {
            break label110;
          }
          if (localHashMap == null)
          {
            localHashMap = new HashMap();
            localHashMap.put(localEntry.getKey(), localEntry.getValue());
            break label110;
          }
        }
        else
        {
          return localHashMap;
        }
      }
    }
  }
  
  public void putString(String paramString)
  {
    for (;;)
    {
      synchronized (this.map)
      {
        if (this.map.containsKey(paramString))
        {
          this.map.put(paramString, Integer.valueOf(((Integer)this.map.get(paramString)).intValue() + 1));
          if (this.map.size() <= this.maintainCount) {
            break;
          }
          paramString = (Map.Entry)this.map.entrySet().iterator().next();
          this.map.remove(paramString.getKey());
        }
      }
      this.map.put(paramString, Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.HighFrequencyStringDetector
 * JD-Core Version:    0.7.0.1
 */