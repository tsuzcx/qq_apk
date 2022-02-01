package com.tencent.shadow.dynamic.host;

import android.view.View;

public abstract interface EnterCallback
{
  public abstract void onCloseLoadingView();
  
  public abstract void onEnterComplete();
  
  public abstract void onShowLoadingView(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.EnterCallback
 * JD-Core Version:    0.7.0.1
 */