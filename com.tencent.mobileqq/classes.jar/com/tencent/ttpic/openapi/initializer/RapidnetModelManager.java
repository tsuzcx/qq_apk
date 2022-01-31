package com.tencent.ttpic.openapi.initializer;

import java.util.HashMap;
import java.util.Map;

public class RapidnetModelManager
{
  public static final int MODEL_ID_GENDER_SWITCH = 0;
  public static final int MODEL_ID_HAIR_SEG = 1;
  public static final int MODEL_ID_HAND_DETECT = 3;
  public static final int MODEL_ID_SKY_SEG = 2;
  public static final int MODEL_TYPE_GENDER_SWITCH = 1;
  public static final int MODEL_TYPE_HAND_DETECT = 2;
  public static final int MODEL_TYPE_SEG = 0;
  private Map<Integer, Boolean> rapidnetModelMap = new HashMap();
  
  public void clear()
  {
    this.rapidnetModelMap.clear();
  }
  
  public boolean isModelLoaded(int paramInt)
  {
    if (this.rapidnetModelMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Boolean)this.rapidnetModelMap.get(Integer.valueOf(paramInt))).booleanValue();
    }
    return false;
  }
  
  public void toggleRapidModel(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 0))
    {
      this.rapidnetModelMap.put(Integer.valueOf(0), Boolean.valueOf(false));
      this.rapidnetModelMap.put(Integer.valueOf(1), Boolean.valueOf(false));
      this.rapidnetModelMap.put(Integer.valueOf(2), Boolean.valueOf(false));
    }
    this.rapidnetModelMap.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidnetModelManager
 * JD-Core Version:    0.7.0.1
 */