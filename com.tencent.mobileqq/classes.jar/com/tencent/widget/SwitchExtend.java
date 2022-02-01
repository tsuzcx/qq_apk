package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;

public class SwitchExtend
  extends Switch
{
  private SwitchExtend.OnSwitchListener a;
  
  public SwitchExtend(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchExtend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 2131035264);
  }
  
  public SwitchExtend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean performClick()
  {
    SwitchExtend.OnSwitchListener localOnSwitchListener = this.a;
    if ((localOnSwitchListener != null) && (!localOnSwitchListener.a(this))) {
      return false;
    }
    return super.performClick();
  }
  
  public void setOnSwitchListener(SwitchExtend.OnSwitchListener paramOnSwitchListener)
  {
    this.a = paramOnSwitchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.SwitchExtend
 * JD-Core Version:    0.7.0.1
 */