package com.tencent.mobileqq.winkpublish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class FSCheckBox
  extends CheckBox
{
  public boolean a = true;
  View.OnClickListener b;
  View.OnClickListener c;
  
  public FSCheckBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131953496);
  }
  
  public FSCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean performClick()
  {
    View.OnClickListener localOnClickListener = this.b;
    boolean bool = false;
    if (localOnClickListener != null)
    {
      playSoundEffect(0);
      this.b.onClick(this);
      bool = true;
    }
    sendAccessibilityEvent(1);
    return bool;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.a)
    {
      super.setChecked(paramBoolean);
      return;
    }
    View.OnClickListener localOnClickListener = this.c;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this);
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public void setSyncChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
  }
  
  public void setmShareClickListener(View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.view.FSCheckBox
 * JD-Core Version:    0.7.0.1
 */