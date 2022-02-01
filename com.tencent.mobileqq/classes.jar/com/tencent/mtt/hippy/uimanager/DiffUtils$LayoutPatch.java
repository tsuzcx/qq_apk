package com.tencent.mtt.hippy.uimanager;

public class DiffUtils$LayoutPatch
  extends DiffUtils.Patch
{
  String mClassName;
  int mHeight;
  int mId;
  int mParentId;
  int mWidth;
  int mX;
  int mY;
  
  public DiffUtils$LayoutPatch(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString)
  {
    this.mX = paramInt1;
    this.mY = paramInt2;
    this.mHeight = paramInt3;
    this.mWidth = paramInt4;
    this.mId = paramInt5;
    this.mParentId = paramInt6;
    this.mClassName = paramString;
  }
  
  public String toString()
  {
    return "LayoutPatch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.DiffUtils.LayoutPatch
 * JD-Core Version:    0.7.0.1
 */