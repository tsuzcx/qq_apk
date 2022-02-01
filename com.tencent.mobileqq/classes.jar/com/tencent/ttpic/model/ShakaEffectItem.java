package com.tencent.ttpic.model;

import android.util.Pair;
import com.tencent.ttpic.fabby.FabbyUtil;
import com.tencent.ttpic.factory.ShakaFilterFactory.FILTER_TYPE;
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
  private String customEffectFragmentShader;
  private String customEffectVertexShader;
  private Map<String, List<Pair<Float, Double>>> customParams;
  private int filterType;
  private List<String> uniformList;
  private Map<String, List<Pair<Float, Double>>> valueMap;
  
  public String getCustomEffectFragmentShader()
  {
    return this.customEffectFragmentShader;
  }
  
  public String getCustomEffectVertexShader()
  {
    return this.customEffectVertexShader;
  }
  
  public Map<String, List<Pair<Float, Double>>> getCustomParams()
  {
    return this.customParams;
  }
  
  public int getFilterType()
  {
    return this.filterType;
  }
  
  public List<String> getUniformList()
  {
    return this.uniformList;
  }
  
  public Map<String, List<Pair<Float, Double>>> getValueMap()
  {
    return this.valueMap;
  }
  
  public Map<String, Float> getValueMap(int paramInt, float paramFloat)
  {
    HashMap localHashMap = new HashMap();
    if (this.filterType == ShakaFilterFactory.FILTER_TYPE.CUSTOM.value) {}
    for (Object localObject = this.customParams;; localObject = this.valueMap)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localHashMap.put(localEntry.getKey(), Float.valueOf((float)FabbyUtil.getRangeValue(paramInt, paramFloat, (List)localEntry.getValue(), 0.0D)));
      }
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
  
  public void setCustomEffectFragmentShader(String paramString)
  {
    this.customEffectFragmentShader = paramString;
  }
  
  public void setCustomEffectVertexShader(String paramString)
  {
    this.customEffectVertexShader = paramString;
  }
  
  public void setCustomParams(Map<String, List<Pair<Float, Double>>> paramMap)
  {
    this.customParams = paramMap;
  }
  
  public void setFilterType(int paramInt)
  {
    this.filterType = paramInt;
  }
  
  public void setUniformList(List<String> paramList)
  {
    this.uniformList = paramList;
  }
  
  public void setValueMap(Map<String, List<Pair<Float, Double>>> paramMap)
  {
    this.valueMap = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.ShakaEffectItem
 * JD-Core Version:    0.7.0.1
 */