package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ObservableScrollView
  extends ScrollView
{
  private ScrollViewListener a = null;
  
  public ObservableScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ObservableScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ObservableScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ScrollViewListener localScrollViewListener = this.a;
    if (localScrollViewListener != null) {
      localScrollViewListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setScrollViewListener(ScrollViewListener paramScrollViewListener)
  {
    this.a = paramScrollViewListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ObservableScrollView
 * JD-Core Version:    0.7.0.1
 */