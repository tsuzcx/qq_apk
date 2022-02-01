package com.tencent.richmediabrowser.core;

import android.content.Intent;
import android.view.ViewGroup;

public abstract interface IBrowserBuilder
{
  public abstract void buildComplete();
  
  public abstract void buildModel();
  
  public abstract void buildParams(Intent paramIntent);
  
  public abstract void buildPresenter();
  
  public abstract void buildView(ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.IBrowserBuilder
 * JD-Core Version:    0.7.0.1
 */