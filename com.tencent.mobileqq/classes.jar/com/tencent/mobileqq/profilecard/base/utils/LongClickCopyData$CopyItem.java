package com.tencent.mobileqq.profilecard.base.utils;

class LongClickCopyData$CopyItem
{
  final String mCopyContent;
  final String mMenuTitle;
  
  LongClickCopyData$CopyItem(String paramString1, String paramString2)
  {
    this.mMenuTitle = paramString1;
    this.mCopyContent = paramString2;
  }
  
  public String toString()
  {
    return String.format("CopyItem{mMenuTitle=%s mCopyContent=%s}", new Object[] { this.mMenuTitle, this.mCopyContent });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.utils.LongClickCopyData.CopyItem
 * JD-Core Version:    0.7.0.1
 */