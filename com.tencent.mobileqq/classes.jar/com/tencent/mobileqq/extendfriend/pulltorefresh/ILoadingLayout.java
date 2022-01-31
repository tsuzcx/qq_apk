package com.tencent.mobileqq.extendfriend.pulltorefresh;

import android.graphics.drawable.Drawable;

public abstract interface ILoadingLayout
{
  public abstract void setLastUpdatedLabel(CharSequence paramCharSequence);
  
  public abstract void setLoadingDrawable(Drawable paramDrawable);
  
  public abstract void setPullLabel(CharSequence paramCharSequence);
  
  public abstract void setRefreshResultLabel(CharSequence paramCharSequence);
  
  public abstract void setRefreshingLabel(CharSequence paramCharSequence);
  
  public abstract void setReleaseLabel(CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.ILoadingLayout
 * JD-Core Version:    0.7.0.1
 */