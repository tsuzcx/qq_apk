package com.tencent.qqmini.sdk.ui;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.auth.AuthState;
import java.util.ArrayList;
import java.util.List;

class SubMsgPermissionSettingFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  SubMsgPermissionSettingFragment$2(SubMsgPermissionSettingFragment paramSubMsgPermissionSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (SubMsgPermissionSettingFragment.access$000(this.this$0))
    {
      SubMsgPermissionSettingFragment.access$002(this.this$0, false);
    }
    else if ((paramCompoundButton.getTag() instanceof INTERFACE.StSubscribeMessage))
    {
      INTERFACE.StSubscribeMessage localStSubscribeMessage = (INTERFACE.StSubscribeMessage)paramCompoundButton.getTag();
      Object localObject = localStSubscribeMessage.authState;
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      ((PBInt32Field)localObject).set(i);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(localStSubscribeMessage);
      this.this$0.authState.updateOnceSubMsgSetting(null, paramBoolean, (List)localObject, new SubMsgPermissionSettingFragment.2.1(this, localStSubscribeMessage, paramBoolean, paramCompoundButton));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */