package com.tencent.mobileqq.settings.message;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class AssistantSettingFragment$1$1
  implements Runnable
{
  AssistantSettingFragment$1$1(AssistantSettingFragment.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    this.b.a.h.notifyDataSetChanged();
    BaseApplication localBaseApplication = AssistantSettingFragment.c(this.b.a).getApp();
    int i;
    if (this.a) {
      i = 2131899018;
    } else {
      i = 2131899014;
    }
    QQToast.makeText(localBaseApplication, HardCodeUtil.a(i), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.1.1
 * JD-Core Version:    0.7.0.1
 */