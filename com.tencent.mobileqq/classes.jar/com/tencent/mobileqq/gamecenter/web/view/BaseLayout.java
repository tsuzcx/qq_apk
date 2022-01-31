package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public abstract class BaseLayout
  extends FrameLayout
{
  public View a = a(paramContext);
  
  public BaseLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(a(), null, false);
  }
  
  protected abstract int a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.BaseLayout
 * JD-Core Version:    0.7.0.1
 */