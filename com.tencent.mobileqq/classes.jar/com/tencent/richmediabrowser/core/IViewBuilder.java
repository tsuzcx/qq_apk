package com.tencent.richmediabrowser.core;

import android.content.Intent;

public abstract interface IViewBuilder
{
  public abstract void buildComplete();
  
  public abstract void buildInit();
  
  public abstract void buildParams(Intent paramIntent);
  
  public abstract void buildView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.IViewBuilder
 * JD-Core Version:    0.7.0.1
 */