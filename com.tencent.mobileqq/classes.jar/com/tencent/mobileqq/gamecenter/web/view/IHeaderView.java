package com.tencent.mobileqq.gamecenter.web.view;

public abstract interface IHeaderView
  extends IBaseView
{
  public abstract int getViewHeight();
  
  public abstract boolean isPined();
  
  public abstract boolean isShow(String paramString);
  
  public abstract void onScrollTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.IHeaderView
 * JD-Core Version:    0.7.0.1
 */