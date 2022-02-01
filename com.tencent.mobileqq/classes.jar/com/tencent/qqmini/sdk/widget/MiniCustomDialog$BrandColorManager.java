package com.tencent.qqmini.sdk.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniCustomDialog$BrandColorManager
{
  static final int INVALID_COLOR = 0;
  private static final String TAG = "BrandColorManager";
  private int color = 0;
  private View dialogBrandColorView;
  
  private void setBrandBorderColor()
  {
    Object localObject = this.dialogBrandColorView;
    if ((localObject != null) && (this.color != 0))
    {
      localObject = ((View)localObject).getBackground().mutate();
      if ((localObject instanceof GradientDrawable))
      {
        ((GradientDrawable)localObject).setColor(this.color);
        return;
      }
      QMLog.w("BrandColorManager", "set band border-color fail");
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniCustomDialog.BrandColorManager
 * JD-Core Version:    0.7.0.1
 */