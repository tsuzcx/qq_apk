package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.widget.MiniProgressDialog;

class SubscribePermissionSettingFragment$5
  implements Runnable
{
  SubscribePermissionSettingFragment$5(SubscribePermissionSettingFragment paramSubscribePermissionSettingFragment) {}
  
  public void run()
  {
    if (SubscribePermissionSettingFragment.access$700(this.this$0) == null) {
      SubscribePermissionSettingFragment.access$702(this.this$0, new MiniProgressDialog(this.this$0.getActivity()));
    }
    if (!SubscribePermissionSettingFragment.access$700(this.this$0).isShowing())
    {
      SubscribePermissionSettingFragment.access$700(this.this$0).setMessage("正在获取权限信息，请稍候...");
      SubscribePermissionSettingFragment.access$700(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */