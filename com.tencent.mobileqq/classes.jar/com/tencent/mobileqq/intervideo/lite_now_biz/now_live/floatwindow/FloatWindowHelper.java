package com.tencent.mobileqq.intervideo.lite_now_biz.now_live.floatwindow;

import android.app.Activity;
import android.content.Context;
import com.tencent.falco.base.floatwindow.permission.FWPermission;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class FloatWindowHelper
{
  private void a(Activity paramActivity, FloatWindowHelper.IPermissionCallback paramIPermissionCallback)
  {
    FWPermission.requestPermission(paramActivity, new FloatWindowHelper.3(this, paramIPermissionCallback));
  }
  
  public void a(Context paramContext, FloatWindowHelper.IPermissionCallback paramIPermissionCallback)
  {
    boolean bool = FWPermission.hasPermission(paramContext);
    if ((!bool) && (FloatWindowUtil.a()))
    {
      DialogUtil.a(paramContext, 230, HardCodeUtil.a(2131892223), HardCodeUtil.a(2131892222), HardCodeUtil.a(2131888564), HardCodeUtil.a(2131888565), new FloatWindowHelper.1(this, paramContext, paramIPermissionCallback), new FloatWindowHelper.2(this, paramIPermissionCallback)).show();
      FloatWindowUtil.b();
      return;
    }
    paramIPermissionCallback.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.floatwindow.FloatWindowHelper
 * JD-Core Version:    0.7.0.1
 */