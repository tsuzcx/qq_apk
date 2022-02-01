package com.tencent.widget.api.impl;

import android.view.View;
import com.tencent.mobileqq.activity.fling.ChatFragmentTopGestureLayout;
import com.tencent.widget.api.IFitSystemWindowsUtil;

public class FitSystemWindowsUtilImpl
  implements IFitSystemWindowsUtil
{
  public int getTopInset(View paramView)
  {
    if ((paramView instanceof ChatFragmentTopGestureLayout)) {
      return ((ChatFragmentTopGestureLayout)paramView).getTopInst();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.api.impl.FitSystemWindowsUtilImpl
 * JD-Core Version:    0.7.0.1
 */