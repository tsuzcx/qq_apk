package com.tencent.mobileqq.qqpermission.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PermissionRequestDialog$1
  implements View.OnClickListener
{
  PermissionRequestDialog$1(PermissionRequestDialog paramPermissionRequestDialog) {}
  
  public void onClick(View paramView)
  {
    if (PermissionRequestDialog.a(this.a) != null) {
      PermissionRequestDialog.a(this.a).onClick(paramView);
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog.1
 * JD-Core Version:    0.7.0.1
 */