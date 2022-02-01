package com.tencent.mobileqq.settings.message;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class NotifyPushSettingFragment$21$1
  implements Runnable
{
  NotifyPushSettingFragment$21$1(NotifyPushSettingFragment.21 param21, String paramString) {}
  
  public void run()
  {
    QQToast.makeText(this.b.a.getBaseActivity(), 1, HardCodeUtil.a(2131905474), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
    NotifyPushSettingFragment.b(this.b.a).getRightTextView().setText(this.a);
    NotifyPushSettingFragment.a(this.b.a, NotifyPushSettingFragment.e(this.b.a).a() ^ true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.21.1
 * JD-Core Version:    0.7.0.1
 */