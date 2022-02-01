package com.tencent.mobileqq.settings.message;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class NotifyPushSettingFragment$21
  extends CardObserver
{
  NotifyPushSettingFragment$21(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onGetPCActiveState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      Message localMessage = NotifyPushSettingFragment.a(this.a).obtainMessage();
      localMessage.what = 10000;
      localMessage.obj = Boolean.valueOf(paramBoolean2);
      NotifyPushSettingFragment.a(this.a).sendMessage(localMessage);
      QLog.i("CardObserver_onGetPCActiveState", 1, "Succeeded to Get PC Active State with Msg");
      return;
    }
    QLog.i("CardObserver_onGetPCActiveState", 1, "Failed to Get PC Active State with Msg");
  }
  
  public void onSetNotDisturb(boolean paramBoolean, String paramString1, String paramString2)
  {
    super.onSetNotDisturb(paramBoolean, paramString1, paramString2);
    if (!"not_disturb_from_notify_push_setting_activity".equals(paramString2)) {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 4, "onSetNotDisturb NOT FROM THIS" + paramString2);
      }
    }
    do
    {
      return;
      NotifyPushSettingFragment.a(this.a).set(false);
      if (!paramBoolean)
      {
        ThreadManagerV2.getUIHandlerV2().post(new NotifyPushSettingFragment.21.1(this, paramString1));
        return;
      }
      paramString1 = NotifyPushSettingFragment.a(this.a).getHandler(Conversation.class);
    } while (paramString1 == null);
    Conversation.a(paramString1, this.a.getActivity());
  }
  
  public void onSetPCActiveState(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.a.getActivity(), this.a.a, null, "qqsetting_pcactive_key", paramBoolean2);
      QLog.i("CardObserver_onSetPCActiveState", 1, "Set the PC Active State " + paramBoolean1);
      return;
    }
    Message localMessage = NotifyPushSettingFragment.a(this.a).obtainMessage();
    localMessage.what = 10001;
    localMessage.obj = paramString2;
    NotifyPushSettingFragment.a(this.a).sendMessage(localMessage);
    QQToast.a(this.a.getActivity(), paramString1, 0).b(5);
    QLog.i("SetPCActiveState_Failure", 1, "Failed to set PC Active State " + paramString1);
  }
  
  public void onSetShowPushNotice(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.a.getActivity(), this.a.a, null, "qqsetting_show_push_message", paramBoolean2);
      QLog.i("CardObserver_onSetShowPushNotice", 1, "Set show push notice");
      if (paramBoolean2) {}
      for (localObject = "0X8009520";; localObject = "0X800951F")
      {
        ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 1, "", "", "", "");
        return;
      }
    }
    Object localObject = NotifyPushSettingFragment.a(this.a).obtainMessage();
    ((Message)localObject).what = 10004;
    ((Message)localObject).obj = Boolean.valueOf(paramBoolean2);
    NotifyPushSettingFragment.a(this.a).sendMessage((Message)localObject);
    QQToast.a(NotifyPushSettingFragment.a(this.a).getApp(), 1, this.a.getString(2131719116), 0).b(5);
    QLog.i("onSetShowPushNotice_Failure", 1, "Failed to set push notice");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.21
 * JD-Core Version:    0.7.0.1
 */