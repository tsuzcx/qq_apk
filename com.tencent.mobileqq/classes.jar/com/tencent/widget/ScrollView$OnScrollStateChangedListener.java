package com.tencent.widget;

public abstract interface ScrollView$OnScrollStateChangedListener
{
  public static final int SCROLL_STATE_FLING = 2;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
  
  public abstract void onScrollStateChanged(ScrollView paramScrollView, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ScrollView.OnScrollStateChangedListener
 * JD-Core Version:    0.7.0.1
 */