package com.tencent.mobileqq.forward;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

class ForwardShortVideoOption$ContentViewHolder
{
  public ImageView a;
  public ForwardShortVideoOption.PressDarkImageView b;
  
  public void a(Drawable paramDrawable)
  {
    this.b.setVisibility(0);
    this.a.setVisibility(0);
    if (paramDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "setPreviewImage null");
      }
      this.a.setImageResource(2130838067);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.a.setLayoutParams(localLayoutParams);
    this.a.setAdjustViewBounds(true);
    this.a.setMaxHeight(ViewUtils.dip2px(140.0F));
    this.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.a.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption.ContentViewHolder
 * JD-Core Version:    0.7.0.1
 */