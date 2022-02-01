package com.tencent.mobileqq.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class QQCustomDialog$BrandColorManager
{
  static final int INVALID_COLOR = 0;
  private static final String TAG = "BrandColorManager";
  private int color = 0;
  private View dialogBrandColorView;
  
  private void setBrandBorderColor()
  {
    if ((this.dialogBrandColorView != null) && (this.color != 0))
    {
      Drawable localDrawable = this.dialogBrandColorView.getBackground().mutate();
      if ((localDrawable instanceof GradientDrawable)) {
        ((GradientDrawable)localDrawable).setColor(this.color);
      }
    }
    else
    {
      return;
    }
    QLog.w("BrandColorManager", 4, "set band border-color fail");
  }
  
  void setColor(int paramInt)
  {
    this.color = paramInt;
    setBrandBorderColor();
  }
  
  void setDialogBrandColorView(View paramView)
  {
    this.dialogBrandColorView = paramView;
    setBrandBorderColor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.BrandColorManager
 * JD-Core Version:    0.7.0.1
 */