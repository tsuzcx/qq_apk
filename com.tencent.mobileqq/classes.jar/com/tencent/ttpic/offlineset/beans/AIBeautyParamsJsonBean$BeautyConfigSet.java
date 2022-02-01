package com.tencent.ttpic.offlineset.beans;

import java.util.Map;

public class AIBeautyParamsJsonBean$BeautyConfigSet
{
  public int endAge;
  public boolean faceCosmetic;
  public int gender;
  public Map<String, AIBeautyParamsJsonBean.Param> params;
  public int startAge;
  public String tag;
  
  public boolean isCurrent(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= this.startAge) && (paramInt1 <= this.endAge) && (this.gender == paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean.BeautyConfigSet
 * JD-Core Version:    0.7.0.1
 */