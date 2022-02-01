package com.tencent.mobileqq.forward;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

class ForwardPhotoOption$ContentViewHolder
{
  public TextView a;
  public TextView b;
  public TextView c;
  public ImageView d;
  public View e;
  public ProgressBar f;
  
  public void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramDrawable == null) {
      return;
    }
    if (paramBoolean1)
    {
      this.e.setVisibility(0);
      this.a.setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      this.d.setLayoutParams(localLayoutParams);
      if (!paramBoolean2)
      {
        this.d.setAdjustViewBounds(true);
        this.d.setMaxHeight(ViewUtils.dip2px(140.0F));
        this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      else
      {
        this.d.setAdjustViewBounds(true);
        this.d.setMaxWidth(ViewUtils.dip2px(120.0F));
        this.d.setMaxHeight(ViewUtils.dip2px(120.0F));
        this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      this.d.setImageDrawable(paramDrawable);
      if (paramInt < 2)
      {
        this.e.setBackgroundDrawable(null);
        return;
      }
      if (paramInt == 2)
      {
        this.e.setBackgroundResource(2130840455);
        return;
      }
      this.e.setBackgroundResource(2130840456);
      return;
    }
    this.e.setVisibility(8);
    this.a.setVisibility(0);
    this.a.setCompoundDrawablePadding(0);
    this.a.setCompoundDrawables(paramDrawable, null, null, null);
    if (paramDrawable != null)
    {
      this.a.setVisibility(0);
      return;
    }
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPhotoOption.ContentViewHolder
 * JD-Core Version:    0.7.0.1
 */