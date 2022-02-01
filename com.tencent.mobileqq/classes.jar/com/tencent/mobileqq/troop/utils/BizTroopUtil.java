package com.tencent.mobileqq.troop.utils;

import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;

public class BizTroopUtil
{
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, paramResources.getDrawable(2130851807));
  }
  
  public static Drawable a(Resources paramResources, int paramInt, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT <= 10) {
      paramResources = paramDrawable.getConstantState().newDrawable(paramResources);
    } else {
      paramResources = paramDrawable.getConstantState().newDrawable(paramResources).mutate();
    }
    paramResources.setColorFilter(new LightingColorFilter(-16777216, paramInt));
    paramResources.setAlpha(paramInt >>> 24);
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.BizTroopUtil
 * JD-Core Version:    0.7.0.1
 */