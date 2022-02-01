package com.tencent.richmediabrowser.core;

import android.content.Intent;

public abstract interface IBasePresenterBuilder
{
  public abstract void buildComplete();
  
  public abstract void buildParams(Intent paramIntent);
  
  public abstract void buildPresenter();
  
  public abstract void setBrowserModel(IBaseModelBuilder paramIBaseModelBuilder);
  
  public abstract void setBrowserView(IBaseViewBuilder paramIBaseViewBuilder);
  
  public abstract void setRelyPresenter(IBasePresenterBuilder paramIBasePresenterBuilder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.IBasePresenterBuilder
 * JD-Core Version:    0.7.0.1
 */