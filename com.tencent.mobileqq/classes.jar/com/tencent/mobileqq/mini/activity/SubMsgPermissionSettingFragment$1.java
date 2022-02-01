package com.tencent.mobileqq.mini.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubMsgPermissionSettingFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  SubMsgPermissionSettingFragment$1(SubMsgPermissionSettingFragment paramSubMsgPermissionSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (SubMsgPermissionSettingFragment.access$000(this.this$0)) {
      SubMsgPermissionSettingFragment.access$002(this.this$0, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      String str = (String)paramCompoundButton.getTag();
      this.this$0.authorizeCenter.setAuthorize(str, paramBoolean, new SubMsgPermissionSettingFragment.1.1(this, str, paramCompoundButton, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubMsgPermissionSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */