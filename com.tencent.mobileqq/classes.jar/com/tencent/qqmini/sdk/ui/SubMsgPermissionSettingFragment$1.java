package com.tencent.qqmini.sdk.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.auth.AuthState;

class SubMsgPermissionSettingFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  SubMsgPermissionSettingFragment$1(SubMsgPermissionSettingFragment paramSubMsgPermissionSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (SubMsgPermissionSettingFragment.access$000(this.this$0))
    {
      SubMsgPermissionSettingFragment.access$002(this.this$0, false);
    }
    else
    {
      String str = (String)paramCompoundButton.getTag();
      this.this$0.authState.setAuthState(str, paramBoolean, new SubMsgPermissionSettingFragment.1.1(this, str, paramCompoundButton, paramBoolean));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */