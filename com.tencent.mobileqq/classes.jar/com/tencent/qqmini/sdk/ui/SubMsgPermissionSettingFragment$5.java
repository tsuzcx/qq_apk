package com.tencent.qqmini.sdk.ui;

import android.widget.ListView;
import android.widget.TextView;

class SubMsgPermissionSettingFragment$5
  implements Runnable
{
  SubMsgPermissionSettingFragment$5(SubMsgPermissionSettingFragment paramSubMsgPermissionSettingFragment) {}
  
  public void run()
  {
    this.this$0.onceSubMsgTips.setVisibility(0);
    this.this$0.onceSubMsgTips.setText("允许发送一次以下消息");
    SubMsgPermissionSettingFragment.access$500(this.this$0).setVisibility(0);
    SubMsgPermissionSettingFragment.access$500(this.this$0).setAdapter(SubMsgPermissionSettingFragment.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */