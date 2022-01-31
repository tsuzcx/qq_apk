package com.tencent.pts.utils;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class PTSViewDecorationUtil$RoundedCorner$1
  extends ViewOutlineProvider
{
  PTSViewDecorationUtil$RoundedCorner$1(PTSViewDecorationUtil.RoundedCorner paramRoundedCorner) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), PTSViewDecorationUtil.RoundedCorner.access$000(this.this$0)[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner.1
 * JD-Core Version:    0.7.0.1
 */