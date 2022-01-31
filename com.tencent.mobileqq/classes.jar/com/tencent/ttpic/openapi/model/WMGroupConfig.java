package com.tencent.ttpic.openapi.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WMGroupConfig
{
  public int height;
  public int id;
  public int width;
  public List<WMElementConfig> wmElementConfigs = new ArrayList();
  
  public void setItemId(String paramString)
  {
    Iterator localIterator = this.wmElementConfigs.iterator();
    while (localIterator.hasNext()) {
      ((WMElementConfig)localIterator.next()).itemId = paramString;
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void setWM260AllElement()
  {
    Iterator localIterator = this.wmElementConfigs.iterator();
    while (localIterator.hasNext()) {
      ((WMElementConfig)localIterator.next()).isWM260 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.WMGroupConfig
 * JD-Core Version:    0.7.0.1
 */