package com.tencent.richmediabrowser.api.event;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

public abstract interface IDecoratorViewEvent
{
  public abstract View a(View paramView, ViewGroup paramViewGroup);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, View paramView);
  
  public abstract void a(Intent paramIntent);
  
  public abstract void b(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.api.event.IDecoratorViewEvent
 * JD-Core Version:    0.7.0.1
 */