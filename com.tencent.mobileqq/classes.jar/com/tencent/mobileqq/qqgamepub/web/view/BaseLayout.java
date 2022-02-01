package com.tencent.mobileqq.qqgamepub.web.view;

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
  public View view = initView(paramContext);
  
  public BaseLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private View initView(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(getLayoutId(), null, true);
  }
  
  protected abstract int getLayoutId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.view.BaseLayout
 * JD-Core Version:    0.7.0.1
 */