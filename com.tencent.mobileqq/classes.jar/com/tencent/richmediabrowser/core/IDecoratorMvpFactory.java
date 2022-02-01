package com.tencent.richmediabrowser.core;

import android.content.Context;
import com.tencent.richmediabrowser.api.decorator.IDecoratorModel;
import com.tencent.richmediabrowser.api.decorator.IDecoratorPresenter;
import com.tencent.richmediabrowser.api.decorator.IDecoratorView;

public abstract interface IDecoratorMvpFactory
{
  public abstract IDecoratorModel a(int paramInt, IDecoratorPresenter paramIDecoratorPresenter);
  
  public abstract IDecoratorPresenter a(int paramInt);
  
  public abstract IDecoratorView a(Context paramContext, int paramInt, IDecoratorPresenter paramIDecoratorPresenter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.IDecoratorMvpFactory
 * JD-Core Version:    0.7.0.1
 */