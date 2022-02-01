package com.tencent.mobileqq.matchchat;

import com.tencent.mobileqq.extendfriend.bean.TagInfo;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MatchChatSettingFragment$1
  extends ExtendFriendObserver
{
  MatchChatSettingFragment$1(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  public void onGetUnLimitBaseInfo(boolean paramBoolean1, ArrayList<TagInfo> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MatchChatSettingFragment", 2, "onGetUnLimitBaseInfo suc:" + paramBoolean1 + " chatSwitchOpen:" + paramBoolean2);
    }
    if (paramBoolean1) {
      MatchChatSettingFragment.a(this.a, paramBoolean2);
    }
  }
  
  public void onSetUnLimitSwitch(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MatchChatSettingFragment", 2, "onGetUnLimitBaseInfo suc:" + paramBoolean);
    }
    MatchChatSettingFragment localMatchChatSettingFragment;
    if (!paramBoolean)
    {
      localMatchChatSettingFragment = this.a;
      if (MatchChatSettingFragment.a(this.a).a()) {
        break label61;
      }
    }
    label61:
    for (paramBoolean = true;; paramBoolean = false)
    {
      MatchChatSettingFragment.a(localMatchChatSettingFragment, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */