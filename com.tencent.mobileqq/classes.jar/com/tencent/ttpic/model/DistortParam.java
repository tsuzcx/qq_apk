package com.tencent.ttpic.model;

import java.util.ArrayList;
import java.util.List;

public class DistortParam
{
  private List<DistortionItem> items;
  private int level;
  
  public DistortParam()
  {
    this.level = 0;
    this.items = new ArrayList();
  }
  
  public DistortParam(int paramInt, List<DistortionItem> paramList)
  {
    this.level = paramInt;
    this.items = paramList;
  }
  
  public List<DistortionItem> getItems()
  {
    return this.items;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public void setItems(List<DistortionItem> paramList)
  {
    this.items = paramList;
  }
  
  public void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.DistortParam
 * JD-Core Version:    0.7.0.1
 */