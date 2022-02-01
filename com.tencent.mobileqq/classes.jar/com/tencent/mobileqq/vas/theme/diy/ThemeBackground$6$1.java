package com.tencent.mobileqq.vas.theme.diy;

import android.view.View;
import android.widget.ImageView;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;

class ThemeBackground$6$1
  implements Runnable
{
  ThemeBackground$6$1(ThemeBackground.6 param6, ThemeBackground paramThemeBackground) {}
  
  public void run()
  {
    if ((!"null".equals(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ThemeBackground.a(this.this$0.jdField_a_of_type_AndroidViewView, this.a, this.this$0.b, this.this$0.jdField_a_of_type_Int);
      return;
    }
    Object localObject = this.this$0.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof ThemeBackground))
    {
      localObject = (ThemeBackground)localObject;
      if ((((ThemeBackground)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof IGLDrawable)) {
        ((IGLDrawable)((ThemeBackground)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable).recycle();
      }
    }
    this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.this$0.jdField_a_of_type_AndroidViewView.setTag(null);
    if ((this.this$0.jdField_a_of_type_AndroidViewView instanceof ImageView))
    {
      ((ImageView)this.this$0.jdField_a_of_type_AndroidViewView).setImageResource(this.this$0.b);
      if (this.a.jdField_a_of_type_AndroidWidgetImageView$ScaleType != null) {
        ((ImageView)this.this$0.jdField_a_of_type_AndroidViewView).setScaleType(this.a.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
      }
    }
    else
    {
      if (((IVasDepTemp)QRoute.api(IVasDepTemp.class)).setContentBackground(this.this$0.jdField_a_of_type_AndroidViewView, this.this$0.b)) {
        return;
      }
      if ((this.this$0.jdField_a_of_type_AndroidViewView instanceof FPSSwipListView))
      {
        ((FPSSwipListView)this.this$0.jdField_a_of_type_AndroidViewView).setContentBackground(this.this$0.b);
        return;
      }
      this.this$0.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.this$0.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground.6.1
 * JD-Core Version:    0.7.0.1
 */