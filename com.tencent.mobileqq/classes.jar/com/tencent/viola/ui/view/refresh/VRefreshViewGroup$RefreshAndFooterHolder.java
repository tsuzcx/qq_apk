package com.tencent.viola.ui.view.refresh;

public class VRefreshViewGroup$RefreshAndFooterHolder
{
  public int mOffsetY;
  
  public VRefreshViewGroup$RefreshAndFooterHolder(VRefreshViewGroup paramVRefreshViewGroup) {}
  
  public boolean hasFooterPullUp()
  {
    return this.mOffsetY < 0;
  }
  
  public boolean hasHeaderPullDown()
  {
    return this.mOffsetY > 0;
  }
  
  public boolean isOverHeader(int paramInt)
  {
    return this.mOffsetY < -paramInt;
  }
  
  public void move(int paramInt)
  {
    this.mOffsetY += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.refresh.VRefreshViewGroup.RefreshAndFooterHolder
 * JD-Core Version:    0.7.0.1
 */