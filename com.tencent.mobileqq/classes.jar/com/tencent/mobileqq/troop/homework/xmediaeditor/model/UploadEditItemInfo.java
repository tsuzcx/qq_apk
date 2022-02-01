package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import java.util.ArrayList;
import java.util.List;

public abstract class UploadEditItemInfo
  extends EditItemInfoBase
{
  public List<Integer> a = new ArrayList();
  public int f = 0;
  
  public UploadEditItemInfo()
  {
    this.a.add(Integer.valueOf(0));
    this.a.add(Integer.valueOf(3));
    this.a.add(Integer.valueOf(1));
    this.a.add(Integer.valueOf(2));
  }
  
  public int c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.UploadEditItemInfo
 * JD-Core Version:    0.7.0.1
 */