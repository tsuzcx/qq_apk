package com.tencent.viola.ui.view;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

class VPageSliderView$VerticalPageTransformer
  implements ViewPager.PageTransformer
{
  private VPageSliderView$VerticalPageTransformer(VPageSliderView paramVPageSliderView) {}
  
  public void transformPage(View paramView, float paramFloat)
  {
    if (paramFloat < -1.0F)
    {
      paramView.setAlpha(0.0F);
      return;
    }
    if (paramFloat <= 1.0F)
    {
      paramView.setAlpha(1.0F);
      paramView.setTranslationX(paramView.getWidth() * -paramFloat);
      paramView.setTranslationY(paramFloat * paramView.getHeight());
      return;
    }
    paramView.setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.VPageSliderView.VerticalPageTransformer
 * JD-Core Version:    0.7.0.1
 */