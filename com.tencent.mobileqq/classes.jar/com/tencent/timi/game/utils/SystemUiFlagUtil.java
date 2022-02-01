package com.tencent.timi.game.utils;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;

public class SystemUiFlagUtil
{
  public static void a(View paramView)
  {
    int j = paramView.getSystemUiVisibility();
    int i;
    if (Build.VERSION.SDK_INT >= 19) {
      i = j | 0x100 | 0x4 | 0x400 | 0x2 | 0x200 | 0x1000;
    } else {
      i = 0;
    }
    if (i != j) {
      paramView.setSystemUiVisibility(i);
    }
  }
  
  public static boolean a(Resources paramResources)
  {
    return paramResources.getConfiguration().orientation == 2;
  }
  
  public static void b(View paramView)
  {
    int j = paramView.getSystemUiVisibility();
    int i;
    if (Build.VERSION.SDK_INT >= 19) {
      i = j & 0xFFFFFEFF & 0xFFFFFFFB & 0xFFFFFFFD & 0xFFFFFDFF & 0xFFFFEFFF;
    } else {
      i = j;
    }
    if (i != j) {
      paramView.setSystemUiVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.SystemUiFlagUtil
 * JD-Core Version:    0.7.0.1
 */