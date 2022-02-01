package com.tencent.mtt.hippy.uimanager;

public class DiffUtils$DeletePatch
  extends DiffUtils.Patch
{
  int mId;
  String mPClassName;
  int mPid;
  
  public DiffUtils$DeletePatch(int paramInt1, int paramInt2, String paramString)
  {
    this.mId = paramInt1;
    this.mPid = paramInt2;
    this.mPClassName = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeletePatch  Id ");
    localStringBuilder.append(this.mId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.DiffUtils.DeletePatch
 * JD-Core Version:    0.7.0.1
 */