package com.tencent.widget;

class ListView$ArrowScrollFocusResult
{
  private int mAmountToScroll;
  private int mSelectedPosition;
  
  public int getAmountToScroll()
  {
    return this.mAmountToScroll;
  }
  
  public int getSelectedPosition()
  {
    return this.mSelectedPosition;
  }
  
  void populate(int paramInt1, int paramInt2)
  {
    this.mSelectedPosition = paramInt1;
    this.mAmountToScroll = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ListView.ArrowScrollFocusResult
 * JD-Core Version:    0.7.0.1
 */