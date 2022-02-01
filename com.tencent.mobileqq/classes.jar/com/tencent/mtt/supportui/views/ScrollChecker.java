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
        if ((localView.getVisibility() == 0) && (paramInt2 + j >= localView.getLeft()) && (paramInt2 + j < localView.getRight()) && (paramInt3 + k >= localView.getTop()) && (paramInt3 + k < localView.getBottom()) && (canScroll(localView, true, paramBoolean2, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {
          return true;
        }
        i -= 1;
      }
    }
    if ((paramView instanceof ScrollChecker.IScrollCheck))
    {
      paramView = (ScrollChecker.IScrollCheck)paramView;
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          if (!paramView.verticalCanScroll(-paramInt1)) {}
        }
        else {
          while (paramView.horizontalCanScroll(-paramInt1)) {
            return true;
          }
        }
      }
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.ScrollChecker
 * JD-Core Version:    0.7.0.1
 */