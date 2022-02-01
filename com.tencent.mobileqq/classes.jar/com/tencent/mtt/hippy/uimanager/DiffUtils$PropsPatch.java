package com.tencent.mtt.hippy.uimanager;

import com.tencent.mtt.hippy.common.HippyMap;

public class DiffUtils$PropsPatch
  extends DiffUtils.Patch
{
  final String mClassName;
  final int mId;
  final HippyMap mPropsToUpdate;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.DiffUtils.PropsPatch
 * JD-Core Version:    0.7.0.1
 */