package com.tencent.mobileqq.mini.activity;

import amtj;
import android.widget.ListView;
import android.widget.TextView;

class SubMsgPermissionSettingFragment$5
  implements Runnable
{
  SubMsgPermissionSettingFragment$5(SubMsgPermissionSettingFragment paramSubMsgPermissionSettingFragment) {}
  
  public void run()
  {
    this.this$0.onceSubMsgTips.setVisibility(0);
    this.this$0.onceSubMsgTips.setText(amtj.a(2131693797));
    SubMsgPermissionSettingFragment.access$500(this.this$0).setVisibility(0);
    SubMsgPermissionSettingFragment.access$500(this.this$0).setAdapter(SubMsgPermissionSettingFragment.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubMsgPermissionSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */