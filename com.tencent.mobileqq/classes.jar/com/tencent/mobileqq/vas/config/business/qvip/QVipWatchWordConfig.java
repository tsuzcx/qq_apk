package com.tencent.mobileqq.vas.config.business.qvip;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;

@Keep
public class QVipWatchWordConfig
  implements Serializable
{
  private boolean enable = true;
  private ArrayList<String> pattern = new ArrayList();
  private ArrayList<String> watchUrl = new ArrayList();
  
  public ArrayList<String> getPattern()
  {
    return this.pattern;
  }
  
  public ArrayList<String> getWatchUrl()
  {
    return this.watchUrl;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setPattern(ArrayList<String> paramArrayList)
  {
    this.pattern = paramArrayList;
  }
  
  public void setWatchUrl(ArrayList<String> paramArrayList)
  {
    this.watchUrl = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipWatchWordConfig
 * JD-Core Version:    0.7.0.1
 */