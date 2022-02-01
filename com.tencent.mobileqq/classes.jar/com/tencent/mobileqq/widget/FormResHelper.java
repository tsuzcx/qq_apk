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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return paramResources.getColorStateList(2131167056);
            }
            return paramResources.getColorStateList(2131167190);
          }
          return paramResources.getColorStateList(2131167152);
        }
        return paramResources.getColorStateList(2131167138);
      }
      return paramResources.getColorStateList(2131167064);
    }
    return paramResources.getColorStateList(2131167056);
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (a) {
        return paramResources.getDrawable(2130839433);
      }
      return paramResources.getDrawable(2130850703);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return paramResources.getDrawable(2130839433);
          }
          if (a) {
            return paramResources.getDrawable(2130839440);
          }
          return paramResources.getDrawable(2130850708);
        }
        if (a) {
          return paramResources.getDrawable(2130839443);
        }
        return paramResources.getDrawable(2130850717);
      }
      if (a) {
        return paramResources.getDrawable(2130839443);
      }
      return paramResources.getDrawable(2130850717);
    }
    if (a) {
      return paramResources.getDrawable(2130839433);
    }
    return paramResources.getDrawable(2130850703);
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormResHelper
 * JD-Core Version:    0.7.0.1
 */