package com.tencent.mobileqq.wink.view.scrollingheader;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments;

class ScrollingHeaderLayout$BaseBehavior$1
  implements AccessibilityViewCommand
{
  ScrollingHeaderLayout$BaseBehavior$1(ScrollingHeaderLayout.BaseBehavior paramBaseBehavior, CoordinatorLayout paramCoordinatorLayout, ScrollingHeaderLayout paramScrollingHeaderLayout, View paramView, int paramInt) {}
  
  public boolean perform(@NonNull View paramView, @Nullable AccessibilityViewCommand.CommandArguments paramCommandArguments)
  {
    this.e.a(this.a, this.b, this.c, 0, this.d, new int[] { 0, 0 }, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.scrollingheader.ScrollingHeaderLayout.BaseBehavior.1
 * JD-Core Version:    0.7.0.1
 */