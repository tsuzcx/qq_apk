package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import blqa;

public class SwitchExtend
  extends Switch
{
  private blqa a;
  
  public SwitchExtend(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchExtend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 2131035065);
  }
  
  public SwitchExtend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean performClick()
  {
    if ((this.a == null) || (this.a.a(this))) {
      return super.performClick();
    }
    return false;
  }
  
  public void setOnSwitchListener(blqa paramblqa)
  {
    this.a = paramblqa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.SwitchExtend
 * JD-Core Version:    0.7.0.1
 */