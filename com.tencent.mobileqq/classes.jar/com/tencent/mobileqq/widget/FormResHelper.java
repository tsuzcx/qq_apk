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
              return paramResources.getColorStateList(2131167993);
            }
            return paramResources.getColorStateList(2131168175);
          }
          return paramResources.getColorStateList(2131168133);
        }
        return paramResources.getColorStateList(2131168118);
      }
      return paramResources.getColorStateList(2131168002);
    }
    return paramResources.getColorStateList(2131167993);
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (a) {
        return paramResources.getDrawable(2130839622);
      }
      return paramResources.getDrawable(2130852507);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return paramResources.getDrawable(2130839622);
          }
          if (a) {
            return paramResources.getDrawable(2130839629);
          }
          return paramResources.getDrawable(2130852512);
        }
        if (a) {
          return paramResources.getDrawable(2130839632);
        }
        return paramResources.getDrawable(2130852521);
      }
      if (a) {
        return paramResources.getDrawable(2130839632);
      }
      return paramResources.getDrawable(2130852521);
    }
    if (a) {
      return paramResources.getDrawable(2130839622);
    }
    return paramResources.getDrawable(2130852507);
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormResHelper
 * JD-Core Version:    0.7.0.1
 */