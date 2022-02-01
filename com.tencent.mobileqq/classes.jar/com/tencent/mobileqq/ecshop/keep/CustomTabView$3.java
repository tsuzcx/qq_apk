package com.tencent.mobileqq.ecshop.keep;

import android.os.Bundle;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

class CustomTabView$3
  implements MiniAppLaunchListener
{
  CustomTabView$3(CustomTabView paramCustomTabView) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onLaunchResult");
    paramBundle.append(paramBoolean);
    QLog.i("EcshopCustomTabView", 2, paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.CustomTabView.3
 * JD-Core Version:    0.7.0.1
 */