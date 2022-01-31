package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import java.util.ArrayList;
import java.util.List;

public abstract class UploadEditItemInfo
  extends EditItemInfoBase
{
  public List b = new ArrayList();
  public int g = 0;
  
  public UploadEditItemInfo()
  {
    this.b.add(Integer.valueOf(0));
    this.b.add(Integer.valueOf(3));
    this.b.add(Integer.valueOf(1));
    this.b.add(Integer.valueOf(2));
  }
  
  public int e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.UploadEditItemInfo
 * JD-Core Version:    0.7.0.1
 */