package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import aqac;

public abstract class BaseNestHeaderLayout
  extends BaseLayout
  implements aqac
{
  public BaseNestHeaderLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseNestHeaderLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    addView(this.a, new FrameLayout.LayoutParams(-1, -2));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a != null) {
      this.a.scrollTo(0, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.BaseNestHeaderLayout
 * JD-Core Version:    0.7.0.1
 */