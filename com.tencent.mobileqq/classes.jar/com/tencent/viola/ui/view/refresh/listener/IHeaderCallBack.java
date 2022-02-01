package com.tencent.viola.ui.view.refresh.listener;

public abstract interface IHeaderCallBack
{
  public static final int COMPONENT_TYPE_HEADER_VIEW = 2;
  public static final int COMPONENT_TYPE_KD_REFRESH = 3;
  public static final int COMPONENT_TYPE_VREFRESH = 1;
  
  public abstract int getComponentType();
  
  public abstract int getHeaderHeight();
  
  public abstract int getHeaderWidth();
  
  public abstract boolean getRefreshStick();
  
  public abstract void notifyVisiableChangeOnScreen(boolean paramBoolean);
  
  public abstract void onFingerRelease();
  
  public abstract void onStateFinish(boolean paramBoolean);
  
  public abstract void onStateNormal();
  
  public abstract void onStateReady();
  
  public abstract void onStateRefreshing();
  
  public abstract void onStickRefreshing();
  
  public abstract void show();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.refresh.listener.IHeaderCallBack
 * JD-Core Version:    0.7.0.1
 */