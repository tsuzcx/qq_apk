package com.tencent.ttpic.filter.aifilter;

import java.util.HashMap;

public class AIImageFilterResult
{
  public HashMap<String, String> adjustParam;
  public String fid;
  public float glowStrength;
  public String lutPath;
  public float lutStrengt;
  public String sceneLabel;
  public float smoothLevel;
  
  public HashMap<String, String> getAdjustParam()
  {
    return this.adjustParam;
  }
  
  public float getGlowStrength()
  {
    return this.glowStrength;
  }
  
  public String getLutPath()
  {
    return this.lutPath;
  }
  
  public float getLutStrengt()
  {
    return this.lutStrengt;
  }
  
  public String getSceneLabel()
  {
    return this.sceneLabel;
  }
  
  public float getSmoothLevel()
  {
    return this.smoothLevel;
  }
  
  public void setAdjustParam(HashMap<String, String> paramHashMap)
  {
    this.adjustParam = paramHashMap;
  }
  
  public void setGlowStrength(float paramFloat)
  {
    this.glowStrength = paramFloat;
  }
  
  public void setLutPath(String paramString)
  {
    this.lutPath = paramString;
  }
  
  public void setLutStrengt(float paramFloat)
  {
    this.lutStrengt = paramFloat;
  }
  
  public void setSceneLabel(String paramString)
  {
    this.sceneLabel = paramString;
  }
  
  public void setSmoothLevel(float paramFloat)
  {
    this.smoothLevel = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.AIImageFilterResult
 * JD-Core Version:    0.7.0.1
 */