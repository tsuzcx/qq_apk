package com.tencent.richmediabrowser.core;

import android.content.Intent;
import android.view.ViewGroup;

public abstract interface IViewBuilder
{
  public abstract void buildComplete();
  
  public abstract void buildInit();
  
  public abstract void buildParams(Intent paramIntent);
  
  public abstract void buildView(ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.IViewBuilder
 * JD-Core Version:    0.7.0.1
 */