package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import avha;

public abstract class BaseNestHeaderLayout
  extends BaseLayout
  implements avha
{
  public BaseNestHeaderLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseNestHeaderLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void attachToRootView()
  {
    addView(this.view, new FrameLayout.LayoutParams(-1, -2));
  }
  
  public int getViewHeight()
  {
    if (this.view == null) {
      return 0;
    }
    return this.view.getMeasuredHeight();
  }
  
  public void hide()
  {
    if (this.view != null) {
      this.view.setVisibility(8);
    }
  }
  
  public void onScrollTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.view != null) {
      this.view.scrollTo(0, paramInt2);
    }
  }
  
  public void show()
  {
    if (this.view != null) {
      this.view.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.BaseNestHeaderLayout
 * JD-Core Version:    0.7.0.1
 */