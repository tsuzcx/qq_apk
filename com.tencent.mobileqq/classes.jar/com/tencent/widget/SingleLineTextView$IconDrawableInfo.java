package com.tencent.widget;

import android.text.TextUtils;

public class SingleLineTextView$IconDrawableInfo
{
  public boolean can_not_be_hide;
  public String iconDynamicUrl;
  public int iconResId;
  public String icon_static_url;
  public float icon_status_alpha = 1.0F;
  
  public boolean equals(IconDrawableInfo paramIconDrawableInfo)
  {
    return (paramIconDrawableInfo != null) && (this.iconResId == paramIconDrawableInfo.iconResId) && (TextUtils.equals(this.icon_static_url, paramIconDrawableInfo.icon_static_url)) && (Math.abs(this.icon_status_alpha - paramIconDrawableInfo.icon_status_alpha) < 0.001F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.SingleLineTextView.IconDrawableInfo
 * JD-Core Version:    0.7.0.1
 */