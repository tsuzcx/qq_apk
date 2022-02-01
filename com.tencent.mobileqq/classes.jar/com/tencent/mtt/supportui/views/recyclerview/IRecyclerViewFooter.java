package com.tencent.mtt.supportui.views.recyclerview;

public abstract interface IRecyclerViewFooter
{
  public static final int LOADING_STATUS_BLANK = 7;
  public static final int LOADING_STATUS_CUSTOM = 100;
  public static final int LOADING_STATUS_ERROR = 3;
  public static final int LOADING_STATUS_ERROR_NETWORK_DISCONNECTED = 9;
  public static final int LOADING_STATUS_ERROR_NETWORK_ERROR = 10;
  public static final int LOADING_STATUS_ERROR_PULL_UP = 5;
  public static final int LOADING_STATUS_ERROR_RETRY = 4;
  public static final int LOADING_STATUS_FINISH = 2;
  public static final int LOADING_STATUS_FINISH_WITH_NUM = 8;
  public static final int LOADING_STATUS_LOADING = 1;
  public static final int LOADING_STATUS_NOMORE_CLICKBACKWARDS = 6;
  public static final int LOADING_STATUS_NONE = 0;
  
  public abstract int getLoadingStatus();
  
  public abstract void setLoadingStatus(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.IRecyclerViewFooter
 * JD-Core Version:    0.7.0.1
 */