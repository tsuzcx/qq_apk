package com.tencent.mobileqq.newnearby.util;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.now.utils.StatusBarUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class NearbyStatusBarHelper
{
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (ImmersiveTitleBar2)paramView.findViewById(2131447582);
    if (paramView != null) {
      paramView.setVisibility(4);
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity)
  {
    if (paramQBaseActivity.mSystemBarComp == null) {
      paramQBaseActivity.mSystemBarComp = new SystemBarCompact(paramQBaseActivity, true, 0);
    }
    ImmersiveUtils.clearCoverForStatus(paramQBaseActivity.getWindow(), paramQBaseActivity.isClearCoverLayer);
    StatusBarUtil.a(paramQBaseActivity, 0);
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (ImmersiveTitleBar2)paramView.findViewById(2131447582);
    if (paramView != null) {
      paramView.setVisibility(0);
    }
  }
  
  public static void b(QBaseActivity paramQBaseActivity)
  {
    Window localWindow = paramQBaseActivity.getWindow();
    if (Build.VERSION.SDK_INT >= 21)
    {
      localWindow.clearFlags(67108864);
      localWindow.getDecorView().setSystemUiVisibility(1280);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(0);
    }
    else if (Build.VERSION.SDK_INT >= 19)
    {
      localWindow.addFlags(67108864);
    }
    StatusBarUtil.b(paramQBaseActivity, false);
  }
  
  public static void c(QBaseActivity paramQBaseActivity)
  {
    Window localWindow = paramQBaseActivity.getWindow();
    if (Build.VERSION.SDK_INT >= 21) {
      localWindow.setStatusBarColor(-1);
    }
    StatusBarUtil.b(paramQBaseActivity, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.NearbyStatusBarHelper
 * JD-Core Version:    0.7.0.1
 */