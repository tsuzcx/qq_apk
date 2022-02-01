package com.tencent.mobileqq.simpleui;

import android.app.Activity;
import android.view.Window;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;

public class SimpleQZoneUIUtil
{
  public static SystemBarCompact a(SystemBarCompact paramSystemBarCompact, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    int i = 0;
    boolean bool = true;
    if (paramActivity == null) {
      return null;
    }
    if (ImmersiveUtils.isSupporImmersive() == 0) {
      return null;
    }
    if (!a()) {
      return null;
    }
    int k = SimpleUIUtil.d();
    if (ImmersiveUtils.couldSetStatusTextColor())
    {
      paramActivity.getWindow().addFlags(ImmersiveUtils.FLAG_TRANSLUCENT_STATUS);
      ImmersiveUtils.clearCoverForStatus(paramActivity.getWindow(), true);
      if (paramSystemBarCompact == null) {
        if (!paramBoolean1)
        {
          paramBoolean1 = bool;
          paramSystemBarCompact = new SystemBarCompact(paramActivity, paramBoolean1, k);
          paramSystemBarCompact.init();
        }
      }
      for (;;)
      {
        ImmersiveUtils.setStatusTextColor(paramBoolean2, paramActivity.getWindow());
        return paramSystemBarCompact;
        paramBoolean1 = false;
        break;
        paramSystemBarCompact.setStatusBarColor(k);
      }
    }
    if (paramSystemBarCompact == null)
    {
      paramActivity.getWindow().addFlags(ImmersiveUtils.FLAG_TRANSLUCENT_STATUS);
      ImmersiveUtils.clearCoverForStatus(paramActivity.getWindow(), true);
      if (paramBoolean2) {
        i = SimpleUIUtil.a;
      }
      paramSystemBarCompact = new SystemBarCompact(paramActivity, true, i);
      paramSystemBarCompact.init();
      return paramSystemBarCompact;
    }
    i = j;
    if (paramBoolean2) {
      i = SimpleUIUtil.a;
    }
    paramSystemBarCompact.setStatusBarColor(i);
    return paramSystemBarCompact;
  }
  
  public static final boolean a()
  {
    return (SimpleUIUtil.a()) && (!ThemeUtil.isNowThemeIsNightForQzone()) && (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzonesimpleui", true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleQZoneUIUtil
 * JD-Core Version:    0.7.0.1
 */