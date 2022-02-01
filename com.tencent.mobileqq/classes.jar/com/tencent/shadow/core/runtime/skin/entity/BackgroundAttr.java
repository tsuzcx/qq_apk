package com.tencent.shadow.core.runtime.skin.entity;

import android.os.Build.VERSION;
import android.view.View;

public class BackgroundAttr
  extends SkinAttr
{
  private static final String TAG;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SKIN");
    localStringBuilder.append(BackgroundAttr.class.getSimpleName());
    TAG = localStringBuilder.toString();
  }
  
  public boolean applyInner(View paramView)
  {
    if (isColorAttr())
    {
      paramView.setBackgroundColor(getColor());
      return true;
    }
    if (isDrawableAttr())
    {
      int i = paramView.getPaddingLeft();
      int j = paramView.getPaddingTop();
      int k = paramView.getPaddingRight();
      int m = paramView.getPaddingBottom();
      if (Build.VERSION.SDK_INT < 16) {
        paramView.setBackgroundDrawable(getDrawable());
      } else {
        paramView.setBackground(getDrawable());
      }
      paramView.setPadding(i, j, k, m);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.skin.entity.BackgroundAttr
 * JD-Core Version:    0.7.0.1
 */