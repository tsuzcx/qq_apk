package com.tencent.mobileqq.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class QQCustomDialog$BrandColorManager
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && (this.jdField_a_of_type_Int != 0))
    {
      localObject = ((View)localObject).getBackground().mutate();
      if ((localObject instanceof GradientDrawable))
      {
        ((GradientDrawable)localObject).setColor(this.jdField_a_of_type_Int);
        return;
      }
      QLog.w("BrandColorManager", 4, "set band border-color fail");
    }
  }
  
  void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.BrandColorManager
 * JD-Core Version:    0.7.0.1
 */