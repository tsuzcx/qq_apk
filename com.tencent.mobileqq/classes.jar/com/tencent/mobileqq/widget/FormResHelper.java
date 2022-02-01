package com.tencent.mobileqq.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class FormResHelper
  implements FormItemConstants
{
  private static boolean a;
  
  public static ColorStateList a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131167033);
    case 0: 
      return paramResources.getColorStateList(2131167033);
    case 2: 
      return paramResources.getColorStateList(2131167113);
    case 1: 
      return paramResources.getColorStateList(2131167041);
    case 3: 
      return paramResources.getColorStateList(2131167127);
    }
    return paramResources.getColorStateList(2131167165);
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (a) {
        return paramResources.getDrawable(2130839575);
      }
      return paramResources.getDrawable(2130850777);
    }
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130839575);
    case 0: 
      if (a) {
        return paramResources.getDrawable(2130839575);
      }
      return paramResources.getDrawable(2130850777);
    case 1: 
      if (a) {
        return paramResources.getDrawable(2130839585);
      }
      return paramResources.getDrawable(2130850791);
    case 2: 
      if (a) {
        return paramResources.getDrawable(2130839585);
      }
      return paramResources.getDrawable(2130850791);
    }
    if (a) {
      return paramResources.getDrawable(2130839582);
    }
    return paramResources.getDrawable(2130850782);
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormResHelper
 * JD-Core Version:    0.7.0.1
 */