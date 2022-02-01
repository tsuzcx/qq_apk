package com.tencent.mobileqq.settings.message;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ChatHistorySettingFragment$6
  extends FriendListObserver
{
  ChatHistorySettingFragment$6(ChatHistorySettingFragment paramChatHistorySettingFragment) {}
  
  public void onSetGeneralSettingsC2CRoaming(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SecuritySettingActivity", 2, "onSetGeneralSettingsC2CRoaming issuc =" + paramBoolean);
    }
    this.a.a();
    paramMap = this.a.getActivity();
    if (paramMap == null)
    {
      QLog.e("ChatHistorySettingFragment", 1, "onSetGeneralSettingsC2CRoaming: activity is null");
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(paramMap.getApplicationContext(), 2, 2131695013, 0).b(this.a.getActivity().getTitleBarHeight());
      return;
    }
    FormSwitchItem localFormSwitchItem;
    if (ChatHistorySettingFragment.a(this.a) != null)
    {
      ChatHistorySettingFragment.a(this.a).setOnCheckedChangeListener(null);
      localFormSwitchItem = ChatHistorySettingFragment.a(this.a);
      if (ChatHistorySettingFragment.a(this.a).getC2CRoamingSetting() != 1) {
        break label176;
      }
    }
    label176:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localFormSwitchItem.setChecked(paramBoolean);
      ChatHistorySettingFragment.a(this.a).setOnCheckedChangeListener(this.a);
      QQToast.a(paramMap.getApplicationContext(), 2131695012, 0).b(paramMap.getTitleBarHeight());
      return;
    }
  }
  
  public void onSetMessageRaoam(boolean paramBoolean)
  {
    if (paramBoolean) {
      ChatHistorySettingFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.6
 * JD-Core Version:    0.7.0.1
 */