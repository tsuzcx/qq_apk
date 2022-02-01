package com.tencent.mobileqq.profilecard.template;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;

public abstract interface ITemplateUtils
{
  public abstract Drawable getTemplateDrawable(ProfileCardTemplate paramProfileCardTemplate, boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public abstract boolean initTemplateConfig(ProfileCardTemplate paramProfileCardTemplate, long paramLong1, long paramLong2);
  
  @SuppressLint({"NewApi"})
  public abstract void updateViewAttr(View paramView, String paramString1, ProfileCardTemplate paramProfileCardTemplate, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.template.ITemplateUtils
 * JD-Core Version:    0.7.0.1
 */