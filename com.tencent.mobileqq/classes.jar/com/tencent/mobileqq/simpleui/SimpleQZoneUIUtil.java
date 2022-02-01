package com.tencent.mobileqq.simpleui;

import android.app.Activity;
import android.view.Window;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;

public class SimpleQZoneUIUtil
{
  public static SystemBarCompact a(SystemBarCompact paramSystemBarCompact, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramActivity == null) {
      return null;
    }
    if (ImmersiveUtils.isSupporImmersive() == 0) {
      return null;
    }
    if (!a()) {
      return null;
    }
    int i = SimpleUIUtil.f();
    if (ImmersiveUtils.couldSetStatusTextColor())
    {
      paramActivity.getWindow().addFlags(ImmersiveUtils.FLAG_TRANSLUCENT_STATUS);
      ImmersiveUtils.clearCoverForStatus(paramActivity.getWindow(), true);
      if (paramSystemBarCompact == null)
      {
        paramSystemBarCompact = new SystemBarCompact(paramActivity, paramBoolean1 ^ true, i);
        paramSystemBarCompact.init();
      }
      else
      {
        paramSystemBarCompact.setStatusBarColor(i);
      }
      ImmersiveUtils.setStatusTextColor(paramBoolean2, paramActivity.getWindow());
      return paramSystemBarCompact;
    }
    int j = 0;
    i = 0;
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
    return (SimpleUIUtil.e()) && (!QQTheme.isNowThemeIsNightForQzone()) && (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzonesimpleui", true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleQZoneUIUtil
 * JD-Core Version:    0.7.0.1
 */