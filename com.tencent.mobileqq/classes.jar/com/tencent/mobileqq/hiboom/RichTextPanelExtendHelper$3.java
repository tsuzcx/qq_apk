package com.tencent.mobileqq.hiboom;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.image.AbstractGifImage;

class RichTextPanelExtendHelper$3
  implements ValueAnimator.AnimatorUpdateListener
{
  RichTextPanelExtendHelper$3(RichTextPanelExtendHelper paramRichTextPanelExtendHelper, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i == this.jdField_a_of_type_Int) {
      AbstractGifImage.resumeAll();
    }
    com.tencent.widget.XPanelContainer.jdField_a_of_type_Int = i;
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper.a.getParent() != null) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper.a.getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanelExtendHelper.3
 * JD-Core Version:    0.7.0.1
 */