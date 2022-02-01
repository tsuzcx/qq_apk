package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BasePermissionHandler$1
  implements View.OnClickListener
{
  BasePermissionHandler$1(BasePermissionHandler paramBasePermissionHandler) {}
  
  public void onClick(View paramView)
  {
    PermissionUtil.a(this.a.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler.1
 * JD-Core Version:    0.7.0.1
 */