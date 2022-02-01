package com.tencent.mobileqq.qqpermission.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PermissionRequestView$1
  implements View.OnClickListener
{
  PermissionRequestView$1(PermissionRequestView paramPermissionRequestView) {}
  
  public void onClick(View paramView)
  {
    if (PermissionRequestView.a(this.a) != null) {
      PermissionRequestView.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.view.PermissionRequestView.1
 * JD-Core Version:    0.7.0.1
 */