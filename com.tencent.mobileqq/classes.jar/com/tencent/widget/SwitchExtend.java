package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;

public class SwitchExtend
  extends Switch
{
  private SwitchExtend.OnSwitchListener mOnSwitchListener;
  
  public SwitchExtend(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchExtend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 2131035075);
  }
  
  public SwitchExtend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean performClick()
  {
    if ((this.mOnSwitchListener == null) || (this.mOnSwitchListener.prePerformClick(this))) {
      return super.performClick();
    }
    return false;
  }
  
  public void setOnSwitchListener(SwitchExtend.OnSwitchListener paramOnSwitchListener)
  {
    this.mOnSwitchListener = paramOnSwitchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.SwitchExtend
 * JD-Core Version:    0.7.0.1
 */