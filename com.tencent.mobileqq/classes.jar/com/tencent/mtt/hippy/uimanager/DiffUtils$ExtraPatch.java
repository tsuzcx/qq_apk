package com.tencent.mtt.hippy.uimanager;

public class DiffUtils$ExtraPatch
  extends DiffUtils.Patch
{
  final String mClassName;
  final int mID;
  final Object mText;
  
  public DiffUtils$ExtraPatch(int paramInt, Object paramObject, String paramString)
  {
    this.mID = paramInt;
    this.mText = paramObject;
    this.mClassName = paramString;
  }
  
  public String toString()
  {
    return "ExtraPatch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.DiffUtils.ExtraPatch
 * JD-Core Version:    0.7.0.1
 */