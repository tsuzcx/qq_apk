package com.tencent.mobileqq.theme;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import aymj;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThemeSwitchManager$1
  implements Runnable
{
  public ThemeSwitchManager$1(aymj paramaymj) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.this$0.jdField_a_of_type_AndroidWidgetImageView.getParent();
    if (localViewGroup != null)
    {
      localViewGroup.removeView(this.this$0.jdField_a_of_type_AndroidWidgetImageView);
      localViewGroup.clearDisappearingChildren();
    }
    this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    this.this$0.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.this$0.jdField_a_of_type_AndroidWidgetImageView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.1
 * JD-Core Version:    0.7.0.1
 */