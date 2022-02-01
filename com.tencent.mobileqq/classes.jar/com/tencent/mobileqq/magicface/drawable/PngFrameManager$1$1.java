package com.tencent.mobileqq.magicface.drawable;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PngFrameManager$1$1
  implements View.OnClickListener
{
  PngFrameManager$1$1(PngFrameManager.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() == 0) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.a.this$0.e(this.a.a);
        if (this.a.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$IMagicCallback != null) {
          this.a.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$IMagicCallback.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.1.1
 * JD-Core Version:    0.7.0.1
 */