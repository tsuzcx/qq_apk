package com.tencent.mobileqq.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class QQCustomDialog$BrandColorManager
{
  private View a;
  private int b = 0;
  
  private void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (this.b != 0))
    {
      localObject = ((View)localObject).getBackground().mutate();
      if ((localObject instanceof GradientDrawable))
      {
        ((GradientDrawable)localObject).setColor(this.b);
        return;
      }
      QLog.w("BrandColorManager", 4, "set band border-color fail");
    }
  }
  
  void a(View paramView)
  {
    this.a = paramView;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.BrandColorManager
 * JD-Core Version:    0.7.0.1
 */