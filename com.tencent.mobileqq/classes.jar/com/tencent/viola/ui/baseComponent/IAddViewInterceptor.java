package com.tencent.viola.ui.baseComponent;

import android.view.ViewGroup;

public abstract interface IAddViewInterceptor
{
  public abstract void addSubViewOnIntercept(ViewGroup paramViewGroup, int paramInt);
  
  public abstract boolean isInterceptAddView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.IAddViewInterceptor
 * JD-Core Version:    0.7.0.1
 */