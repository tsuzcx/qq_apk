package com.tencent.mtt.hippy.uimanager;

import com.tencent.mtt.hippy.common.HippyMap;

public class DiffUtils$PropsPatch
  extends DiffUtils.Patch
{
  String mClassName;
  int mId;
  HippyMap mPropsToUpdate;
  
  public DiffUtils$PropsPatch(HippyMap paramHippyMap, int paramInt, String paramString)
  {
    this.mPropsToUpdate = paramHippyMap;
    this.mId = paramInt;
    this.mClassName = paramString;
  }
  
  public String toString()
  {
    return "PropsPatch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.DiffUtils.PropsPatch
 * JD-Core Version:    0.7.0.1
 */