package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class SlideBottomPanel$1
  implements View.OnLayoutChangeListener
{
  SlideBottomPanel$1(SlideBottomPanel paramSlideBottomPanel) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView.setTop(paramInt6);
    paramView.setBottom(paramInt8);
    paramView.setLeft(paramInt5);
    paramView.setRight(paramInt7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideBottomPanel.1
 * JD-Core Version:    0.7.0.1
 */