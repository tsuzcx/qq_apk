package com.tencent.mobileqq.settings.message;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ChatHistorySettingFragment$6
  extends RoamSettingObserver
{
  ChatHistorySettingFragment$6(ChatHistorySettingFragment paramChatHistorySettingFragment) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("sync.c2c_message")) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onSetGeneralSettingsC2CRoaming issuc =");
        paramString.append(paramBoolean);
        QLog.d("SecuritySettingActivity", 2, paramString.toString());
      }
      this.a.a();
      paramString = this.a.getBaseActivity();
      boolean bool = true;
      if (paramString == null)
      {
        QLog.e("ChatHistorySettingFragment", 1, "onSetGeneralSettingsC2CRoaming: activity is null");
        return;
      }
      if (paramBoolean)
      {
        QQToast.makeText(paramString.getApplicationContext(), 2, 2131892731, 0).show(this.a.getBaseActivity().getTitleBarHeight());
        return;
      }
      if (ChatHistorySettingFragment.c(this.a) != null)
      {
        ChatHistorySettingFragment.c(this.a).setOnCheckedChangeListener(null);
        paramMap = ChatHistorySettingFragment.c(this.a);
        if (ChatHistorySettingFragment.a(this.a).getC2CRoamingSetting() == 1) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
        paramMap.setChecked(paramBoolean);
        ChatHistorySettingFragment.c(this.a).setOnCheckedChangeListener(this.a);
      }
      QQToast.makeText(paramString.getApplicationContext(), 2131892730, 0).show(paramString.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.ChatHistorySettingFragment.6
 * JD-Core Version:    0.7.0.1
 */