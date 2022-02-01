package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import java.util.ArrayList;
import java.util.List;

public abstract class UploadEditItemInfo
  extends EditItemInfoBase
{
  public int o = 0;
  public List<Integer> p = new ArrayList();
  
  public UploadEditItemInfo()
  {
    this.p.add(Integer.valueOf(0));
    this.p.add(Integer.valueOf(3));
    this.p.add(Integer.valueOf(1));
    this.p.add(Integer.valueOf(2));
  }
  
  public int i()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.UploadEditItemInfo
 * JD-Core Version:    0.7.0.1
 */