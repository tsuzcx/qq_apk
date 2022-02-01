package com.tencent.mobileqq.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

public abstract interface IPullRefreshHeader
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(long paramLong);
  
  public abstract void b(long paramLong);
  
  public abstract void c(long paramLong);
  
  public abstract void f();
  
  public abstract long g();
  
  public abstract View getHeaderView();
  
  public abstract void setHeaderBgColor(int paramInt);
  
  public abstract void setHeaderBgDrawable(Drawable paramDrawable);
  
  public abstract void setHeaderBgRes(int paramInt);
  
  public abstract void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IPullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */