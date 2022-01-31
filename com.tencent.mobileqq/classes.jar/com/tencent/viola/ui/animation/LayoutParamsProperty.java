package com.tencent.viola.ui.animation;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.view.IVView;

abstract class LayoutParamsProperty
  extends Property<View, Integer>
{
  LayoutParamsProperty()
  {
    super(Integer.class, "layoutParams");
  }
  
  public Integer get(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getLayoutParams();
      if (paramView != null) {
        return getProperty(paramView);
      }
    }
    return Integer.valueOf(0);
  }
  
  protected abstract Integer getProperty(ViewGroup.LayoutParams paramLayoutParams);
  
  public void set(View paramView, Integer paramInteger)
  {
    if (paramView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams != null)
      {
        setProperty(localLayoutParams, paramInteger);
        if ((paramView instanceof IVView))
        {
          paramInteger = ((IVView)paramView).getComponent();
          if (paramInteger != null) {
            paramInteger.notifyNativeSizeChanged(localLayoutParams.width, localLayoutParams.height);
          }
        }
        paramView.requestLayout();
      }
    }
  }
  
  protected abstract void setProperty(ViewGroup.LayoutParams paramLayoutParams, Integer paramInteger);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.animation.LayoutParamsProperty
 * JD-Core Version:    0.7.0.1
 */