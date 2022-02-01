package com.tencent.mtt.supportui.views;

import android.view.View;
import android.view.ViewGroup;

public class ScrollChecker
{
  public static boolean canScroll(View paramView, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = (int)(paramView.getScrollX() + paramView.getTranslationX() + 0.5F);
      int k = (int)(paramView.getScrollY() + paramView.getTranslationX() + 0.5F);
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          int m = paramInt2 + j;
          if ((m >= localView.getLeft()) && (m < localView.getRight()))
          {
            int n = paramInt3 + k;
            if ((n >= localView.getTop()) && (n < localView.getBottom()) && (canScroll(localView, true, paramBoolean2, paramInt1, m - localView.getLeft(), n - localView.getTop()))) {
              return true;
            }
          }
        }
        i -= 1;
      }
    }
    boolean bool3 = paramView instanceof ScrollChecker.IScrollCheck;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramView = (ScrollChecker.IScrollCheck)paramView;
      bool1 = bool2;
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          bool1 = bool2;
          if (!paramView.verticalCanScroll(-paramInt1)) {
            break label239;
          }
        }
        else
        {
          bool1 = bool2;
          if (!paramView.horizontalCanScroll(-paramInt1)) {
            break label239;
          }
        }
        bool1 = true;
      }
    }
    label239:
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.ScrollChecker
 * JD-Core Version:    0.7.0.1
 */