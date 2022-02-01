package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUnRead;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingFragment$4
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingFragment$4(NotifyPushSettingFragment paramNotifyPushSettingFragment, BubbleManager paramBubbleManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.m.a(paramBoolean);
    String str2 = NotifyPushSettingFragment.c(this.b).getCurrentAccountUin();
    String str1;
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    VasWebviewUtil.a(str2, "bubble_new", "change", "0", 0, 0, 0, "", "", str1, "", "", "", "", 0, 0, 0, 0);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */