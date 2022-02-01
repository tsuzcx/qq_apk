package com.tencent.viola.ui.component;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.tencent.viola.ui.adapter.VLoopAbleSliderAdapter;

public class VSlider$ScaleTransformer
  implements ViewPager.PageTransformer
{
  private final float minScale;
  
  public VSlider$ScaleTransformer(VSlider paramVSlider, float paramFloat)
  {
    this.minScale = paramFloat;
  }
  
  public void transformPage(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    float f;
    do
    {
      do
      {
        return;
      } while ((VSlider.access$200(this.this$0)) || ((VSlider.access$300(this.this$0) != null) && (VSlider.access$300(this.this$0).getCount() == 1)));
      if (paramFloat < 0.0F) {}
      for (f = (1.0F - this.minScale) * paramFloat + 1.0F; paramFloat <= 0.0F; f = (this.minScale - 1.0F) * paramFloat + 1.0F)
      {
        paramView.setPivotX(paramView.getWidth());
        paramView.setPivotY(paramView.getHeight() / 2);
        paramView.setScaleX(f);
        paramView.setScaleY(f);
        return;
      }
    } while ((paramFloat <= 1.0F) && (paramFloat > 1.0F));
    paramView.setPivotX(0.0F);
    paramView.setPivotY(paramView.getHeight() / 2);
    paramView.setScaleX(f);
    paramView.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.VSlider.ScaleTransformer
 * JD-Core Version:    0.7.0.1
 */