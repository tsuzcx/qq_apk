package com.tencent.mtt.hippy.uimanager;

public class DiffUtils$ReplacePatch
  extends DiffUtils.Patch
{
  int newId;
  int oldId;
  
  public DiffUtils$ReplacePatch(int paramInt1, int paramInt2)
  {
    this.oldId = paramInt1;
    this.newId = paramInt2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReplacePatch oldId:");
    localStringBuilder.append(this.oldId);
    localStringBuilder.append(" newId:");
    localStringBuilder.append(this.newId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.DiffUtils.ReplacePatch
 * JD-Core Version:    0.7.0.1
 */