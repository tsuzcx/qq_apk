package com.tencent.mobileqq.qqexpand.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class ProfileGuideDialogUtils$2
  implements View.OnClickListener
{
  ProfileGuideDialogUtils$2(Context paramContext, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("url", "https://ti.qq.com/extend-friend/?_wv=536870912");
    RouteUtils.a(this.a, (Intent)localObject, "/base/browser");
    ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DE", 0, 0, "", "", "", "");
    localObject = this.b;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.b.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils.2
 * JD-Core Version:    0.7.0.1
 */