package com.tencent.richmediabrowser.core;

import android.content.Context;

public abstract interface IMvpFactory
{
  public abstract IBaseModelBuilder createModel(int paramInt, IBasePresenterBuilder paramIBasePresenterBuilder);
  
  public abstract IBasePresenterBuilder createPresenter(int paramInt);
  
  public abstract IBaseViewBuilder createView(Context paramContext, int paramInt, IBasePresenterBuilder paramIBasePresenterBuilder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.IMvpFactory
 * JD-Core Version:    0.7.0.1
 */