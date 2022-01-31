package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qphone.base.util.QLog;

class AppBrandFragment$1
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  AppBrandFragment$1(AppBrandFragment paramAppBrandFragment) {}
  
  public void onSoftKeyboardClosed()
  {
    MiniAppStateManager.getInstance().notifyChange("hideInput");
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    try
    {
      Object localObject = this.this$0.getActivity();
      int i = paramInt;
      if (DisplayUtil.hasNavBar((Context)localObject))
      {
        i = paramInt;
        if (DisplayUtil.isNavigationBarExist((Activity)localObject)) {
          i = paramInt - DisplayUtil.getNavigationBarHeight((Context)localObject);
        }
      }
      localObject = this.this$0.getResources().getDisplayMetrics();
      paramInt = (int)(i / ((DisplayMetrics)localObject).density);
      MiniAppStateManager.getInstance().notifyChange(Integer.valueOf(paramInt));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AppBrandFragment", 1, "onSoftKeyboardOpened exception!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandFragment.1
 * JD-Core Version:    0.7.0.1
 */