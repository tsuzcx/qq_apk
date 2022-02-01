package com.tencent.widget.immersive;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.Window;

public class SystemBarTintManager$SystemBarConfig
{
  private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
  private final boolean mInPortrait;
  private final int mStatusBarHeight;
  private final boolean mTranslucentStatusBar;
  
  private SystemBarTintManager$SystemBarConfig(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow.getContext().getResources().getConfiguration().orientation == 1) {}
    for (;;)
    {
      this.mInPortrait = bool;
      this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(paramWindow.getContext());
      this.mTranslucentStatusBar = paramBoolean;
      return;
      bool = false;
    }
  }
  
  @TargetApi(14)
  private int getActionBarHeight(Context paramContext)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 14)
    {
      TypedValue localTypedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(16843499, localTypedValue, true);
      i = TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
    }
    return i;
  }
  
  public int getStatusBarHeight()
  {
    return this.mStatusBarHeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.immersive.SystemBarTintManager.SystemBarConfig
 * JD-Core Version:    0.7.0.1
 */