package com.tencent.timi.game.ui.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import com.tencent.qphone.base.util.BaseApplication;

public class ResUtils
{
  public static Drawable a(int paramInt)
  {
    return BaseApplication.getContext().getResources().getDrawable(paramInt);
  }
  
  public static int b(@ColorRes int paramInt)
  {
    return BaseApplication.getContext().getResources().getColor(paramInt);
  }
  
  public static String c(@StringRes int paramInt)
  {
    return BaseApplication.getContext().getResources().getString(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.utils.ResUtils
 * JD-Core Version:    0.7.0.1
 */