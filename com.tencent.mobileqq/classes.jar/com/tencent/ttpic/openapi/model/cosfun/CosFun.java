package com.tencent.ttpic.openapi.model.cosfun;

import java.util.List;

public class CosFun
{
  private List<CosFun.CosFunGroupItem> cosFunGroupItem;
  private boolean enableGAN;
  private int startInterval;
  private String tipsAnim;
  private int tipsAnimFrameDuration;
  private int tipsAnimFrames;
  
  public List<CosFun.CosFunGroupItem> getCosFunGroupItem()
  {
    return this.cosFunGroupItem;
  }
  
  public int getStartInterval()
  {
    return this.startInterval;
  }
  
  public String getTipsAnim()
  {
    return this.tipsAnim;
  }
  
  public int getTipsAnimFrameDuration()
  {
    return this.tipsAnimFrameDuration;
  }
  
  public int getTipsAnimFrames()
  {
    return this.tipsAnimFrames;
  }
  
  public boolean isEnableGAN()
  {
    return this.enableGAN;
  }
  
  public void setCosFunGroupItem(List<CosFun.CosFunGroupItem> paramList)
  {
    this.cosFunGroupItem = paramList;
  }
  
  public void setEnableGAN(boolean paramBoolean)
  {
    this.enableGAN = paramBoolean;
  }
  
  public void setStartInterval(int paramInt)
  {
    this.startInterval = paramInt;
  }
  
  public void setTipsAnim(String paramString)
  {
    this.tipsAnim = paramString;
  }
  
  public void setTipsAnimFrameDuration(int paramInt)
  {
    this.tipsAnimFrameDuration = paramInt;
  }
  
  public void setTipsAnimFrames(int paramInt)
  {
    this.tipsAnimFrames = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.cosfun.CosFun
 * JD-Core Version:    0.7.0.1
 */