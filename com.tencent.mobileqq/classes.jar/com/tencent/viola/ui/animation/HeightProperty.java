package com.tencent.viola.ui.animation;

import android.view.ViewGroup.LayoutParams;

public class HeightProperty
  extends LayoutParamsProperty
{
  protected Integer getProperty(ViewGroup.LayoutParams paramLayoutParams)
  {
    return Integer.valueOf(paramLayoutParams.height);
  }
  
  protected void setProperty(ViewGroup.LayoutParams paramLayoutParams, Integer paramInteger)
  {
    paramLayoutParams.height = paramInteger.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.animation.HeightProperty
 * JD-Core Version:    0.7.0.1
 */