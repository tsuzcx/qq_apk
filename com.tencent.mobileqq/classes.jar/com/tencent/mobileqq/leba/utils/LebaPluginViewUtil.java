package com.tencent.mobileqq.leba.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ThemeImageView;

public class LebaPluginViewUtil
{
  public static final int a = 2130846957;
  public static final int b = 2130846952;
  public static final int c = Color.parseColor("#8e8e8e");
  private static Drawable d;
  private static Drawable e;
  
  public static void a(ImageView paramImageView, TextView paramTextView)
  {
    Resources localResources = paramImageView.getContext().getResources();
    boolean bool1 = QQTheme.isNowSimpleUI();
    boolean bool2 = QQTheme.isNowThemeIsNight();
    boolean bool3 = paramImageView instanceof ThemeImageView;
    int i = 0;
    if (bool3) {
      ((ThemeImageView)paramImageView).setSupportMaskView(false);
    }
    if (bool1)
    {
      if (bool2)
      {
        paramImageView.setColorFilter(c);
        paramTextView.setTextColor(-1);
        return;
      }
      paramImageView.setColorFilter(0);
      paramTextView.setTextColor(localResources.getColor(2131165778));
      return;
    }
    if (bool2) {
      i = QQTheme.NIGHTMODE_MASKCOLOR;
    }
    paramImageView.setColorFilter(i);
    paramTextView.setTextColor(localResources.getColor(2131168001));
  }
  
  public static void a(ImageView paramImageView, TextView paramTextView, View paramView, LebaViewItem paramLebaViewItem)
  {
    Context localContext = paramImageView.getContext();
    boolean bool = QQTheme.isNowSimpleUI();
    if (paramLebaViewItem.h == 2)
    {
      paramTextView.setText(2131891151);
      int i;
      if (bool) {
        i = 2130846955;
      } else {
        i = 2130846954;
      }
      paramImageView.setImageResource(i);
    }
    else
    {
      if (d == null)
      {
        d = localContext.getResources().getDrawable(a);
        e = localContext.getResources().getDrawable(b);
      }
      Drawable localDrawable;
      if (bool) {
        localDrawable = e;
      } else {
        localDrawable = d;
      }
      paramTextView.setText(paramLebaViewItem.b.strResName);
      paramImageView.setImageDrawable(localDrawable);
      if (bool) {
        paramLebaViewItem = paramLebaViewItem.d();
      } else {
        paramLebaViewItem = paramLebaViewItem.b.strResURL;
      }
      if (!TextUtils.isEmpty(paramLebaViewItem))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = ViewUtils.dip2px(26.0F);
        localURLDrawableOptions.mRequestHeight = localURLDrawableOptions.mRequestWidth;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        paramLebaViewItem = URLDrawable.getDrawable(paramLebaViewItem, localURLDrawableOptions);
        paramLebaViewItem.setTargetDensity(localContext.getResources().getDisplayMetrics().densityDpi);
        if (paramLebaViewItem.getStatus() == 2) {
          paramLebaViewItem.restartDownload();
        }
        paramImageView.setImageDrawable(paramLebaViewItem);
      }
    }
    a(paramImageView, paramTextView);
    if (AppSetting.e) {
      AccessibilityUtil.a(paramView, paramTextView.getText(), Button.class.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.utils.LebaPluginViewUtil
 * JD-Core Version:    0.7.0.1
 */