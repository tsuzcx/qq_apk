package com.tencent.mobileqq.settings.message;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.atomic.AtomicBoolean;

class NotifyPushSettingFragment$27
  implements DialogInterface.OnClickListener
{
  NotifyPushSettingFragment$27(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = HttpUtil.getNetWorkType();
    paramInt = i;
    if (i == -1) {
      paramInt = 2;
    }
    if (paramInt == 0)
    {
      QQToast.a(this.a.getBaseActivity(), 1, 2131696114, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
      return;
    }
    if (NotifyPushSettingFragment.a(this.a).compareAndSet(true, true))
    {
      QQToast.a(this.a.getBaseActivity(), 1, 2131698376, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
      return;
    }
    NotifyPushSettingFragment.a(this.a, false, true);
    paramDialogInterface = NotifyPushSettingFragment.a(this.a).a().getText().toString();
    NotifyPushSettingFragment.a(this.a).a().setText("");
    NotifyPushSettingFragment.a(this.a).set(true);
    ((CardHandler)NotifyPushSettingFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(0, paramDialogInterface, "not_disturb_from_notify_push_setting_activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.27
 * JD-Core Version:    0.7.0.1
 */