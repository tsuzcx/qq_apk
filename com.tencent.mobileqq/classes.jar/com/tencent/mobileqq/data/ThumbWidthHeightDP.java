package com.tencent.mobileqq.data;

import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class ThumbWidthHeightDP
{
  public boolean mLimitSizeByGuild;
  public boolean mLimitSizeByServer;
  public int mMaxHeight;
  public int mMaxWidth;
  public int mMinHeight;
  public int mMinWidth;
  
  public ThumbWidthHeightDP(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, false);
  }
  
  public ThumbWidthHeightDP(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.mMinWidth = paramInt1;
    this.mMinHeight = paramInt2;
    this.mMaxWidth = paramInt3;
    this.mMaxHeight = paramInt4;
    this.mLimitSizeByServer = paramBoolean;
  }
  
  public int maxPx()
  {
    return Utils.a((this.mMaxWidth + this.mMaxHeight) / 2, MobileQQ.getContext().getResources());
  }
  
  public int minPx()
  {
    return Utils.a((this.mMinWidth + this.mMinHeight) / 2, MobileQQ.getContext().getResources());
  }
  
  public void setmLimitSizeByGuild(boolean paramBoolean)
  {
    this.mLimitSizeByGuild = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mMinWidth);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mMinHeight);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mMaxWidth);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mMaxHeight);
    return localStringBuilder.toString();
  }
  
  public boolean useCustomSize()
  {
    return (this.mMinWidth != 0) && (this.mMinHeight != 0) && (this.mMaxWidth != 0) && (this.mMaxHeight != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ThumbWidthHeightDP
 * JD-Core Version:    0.7.0.1
 */