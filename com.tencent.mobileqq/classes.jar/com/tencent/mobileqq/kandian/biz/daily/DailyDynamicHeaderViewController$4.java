package com.tencent.mobileqq.kandian.biz.daily;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class DailyDynamicHeaderViewController$4
  implements View.OnClickListener
{
  DailyDynamicHeaderViewController$4(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController) {}
  
  public void onClick(View paramView)
  {
    QLog.i("DailyHeaderViewController", 1, "[onClick] clickToGrantPermission");
    paramView = (BaseActivity)paramView.getContext();
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramView.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION"))
      {
        DailyDynamicHeaderViewController.a(this.a, true);
        return;
      }
      paramView.requestPermissions(new DailyDynamicHeaderViewController.4.1(this, paramView), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    DailyDynamicHeaderViewController.a(this.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderViewController.4
 * JD-Core Version:    0.7.0.1
 */