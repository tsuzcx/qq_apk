package com.tencent.ttpic.model;

import android.util.Pair;
import com.tencent.ttpic.fabby.FabbyUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ShakaEffectItem
{
  private static final List<Pair<Float, Double>> EMPTY_LIST = new ArrayList();
  private int filterType;
  private Map<String, List<Pair<Float, Double>>> valueMap;
  
  public int getFilterType()
  {
    return this.filterType;
  }
  
  public Map<String, List<Pair<Float, Double>>> getValueMap()
  {
    return this.valueMap;
  }
  
  public Map<String, Float> getValueMap(int paramInt, float paramFloat)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.valueMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(localEntry.getKey(), Float.valueOf((float)FabbyUtil.getRangeValue(paramInt, paramFloat, (List)localEntry.getValue(), 0.0D)));
    }
    return localHashMap;
  }
  
  public List<Pair<Float, Double>> getValues(String paramString)
  {
    if (!this.valueMap.containsKey(paramString)) {
      return EMPTY_LIST;
    }
    return (List)this.valueMap.get(paramString);
  }
  
  public void setFilterType(int paramInt)
  {
    this.filterType = paramInt;
  }
  
  public void setValueMap(Map<String, List<Pair<Float, Double>>> paramMap)
  {
    this.valueMap = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.ShakaEffectItem
 * JD-Core Version:    0.7.0.1
 */