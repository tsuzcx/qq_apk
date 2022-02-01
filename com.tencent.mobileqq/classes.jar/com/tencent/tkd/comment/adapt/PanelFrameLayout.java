package com.tencent.tkd.comment.adapt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class PanelFrameLayout
  extends FrameLayout
{
  private boolean isShowing;
  private int panelHeight;
  
  public PanelFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public PanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.isShowing)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.panelHeight, 1073741824));
      return;
    }
    setMeasuredDimension(getWidth(), 0);
  }
  
  public void setPanelHeight(int paramInt)
  {
    this.panelHeight = paramInt;
  }
  
  public void setShowing(boolean paramBoolean)
  {
    this.isShowing = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.PanelFrameLayout
 * JD-Core Version:    0.7.0.1
 */