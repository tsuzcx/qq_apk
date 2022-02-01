package com.tencent.weseevideo.model.effect;

import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.weseevideo.composition.effectnode.VideoEffectType;
import java.io.Serializable;
import java.util.HashMap;

public class BeautyModel
  extends BaseEffectModel
  implements Serializable
{
  public static final int IS_NOT_FILTER = -1;
  public static final String ORGIN_FILTER = "edit_orgin_filter";
  private HashMap<BeautyRealConfig.TYPE, Integer> beautyLevels = new HashMap();
  private int darkCornerLevel = -1;
  private int effectType = VideoEffectType.TYPE_BEAUTY.value;
  private boolean enableComparison = false;
  private float filterAjustValue = -1.0F;
  private String filterDescJson;
  private String filterFlagID;
  private int filterID = -1;
  private int filterIndex = -1;
  
  public void clearFilter()
  {
    this.filterID = -1;
    this.filterFlagID = "edit_orgin_filter";
    this.filterAjustValue = -1.0F;
  }
  
  public HashMap getBeautyLevel()
  {
    return this.beautyLevels;
  }
  
  public int getDarkCornerLevel()
  {
    return this.darkCornerLevel;
  }
  
  public int getEffectType()
  {
    return this.effectType;
  }
  
  public String getFilterDescJson()
  {
    return this.filterDescJson;
  }
  
  public String getFilterFlagID()
  {
    return this.filterFlagID;
  }
  
  public int getFilterID()
  {
    return this.filterID;
  }
  
  public int getFilterIndex()
  {
    return this.filterIndex;
  }
  
  public float getFilterValue()
  {
    return this.filterAjustValue;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isEnableComparison()
  {
    return this.enableComparison;
  }
  
  public boolean isNoFilter()
  {
    return this.filterID == -1;
  }
  
  public void setBeautyLevel(BeautyRealConfig.TYPE paramTYPE, Integer paramInteger)
  {
    if (this.beautyLevels == null) {
      this.beautyLevels = new HashMap();
    }
    this.beautyLevels.put(paramTYPE, paramInteger);
  }
  
  public void setBeautyLevel(HashMap<BeautyRealConfig.TYPE, Integer> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() != 0))
    {
      this.beautyLevels = paramHashMap;
      return;
    }
    this.beautyLevels = new HashMap();
  }
  
  public void setDarkCornerLevel(int paramInt)
  {
    this.darkCornerLevel = paramInt;
  }
  
  public void setEffectType(int paramInt)
  {
    this.effectType = paramInt;
  }
  
  public void setEnableComparison(boolean paramBoolean)
  {
    this.enableComparison = paramBoolean;
  }
  
  public void setFilter(int paramInt1, String paramString, int paramInt2)
  {
    this.filterID = paramInt1;
    this.filterFlagID = paramString;
    this.filterIndex = paramInt2;
  }
  
  public void setFilterDescJson(String paramString)
  {
    this.filterDescJson = paramString;
  }
  
  public void setFilterValue(float paramFloat)
  {
    this.filterAjustValue = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.BeautyModel
 * JD-Core Version:    0.7.0.1
 */