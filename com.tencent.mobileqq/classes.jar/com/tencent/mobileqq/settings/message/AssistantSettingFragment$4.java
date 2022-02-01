package com.tencent.mobileqq.settings.message;

import android.os.Build.VERSION;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qassistant.wake.WakeServiceCallBack;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$4
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$4(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(this.a.getBaseActivity()))
    {
      AssistantSettingFragment.a(this.a, 2131694475, 1);
      AssistantSettingFragment.b(this.a, paramBoolean ^ true, this);
    }
    else
    {
      if (paramBoolean)
      {
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).setAssistantImplSwitch(AssistantSettingFragment.a(this.a), true);
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).setCanOpenInSp(true);
        if (QLog.isColorLevel())
        {
          localObject = ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getWakeManagerTag();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("qVoiceAssistantCkb change isChecked:");
          localStringBuilder.append(paramBoolean);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        int i;
        if ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
          i = 0;
        } else {
          i = 1;
        }
        boolean bool = ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplicationImpl.getContext());
        Object localObject = new AssistantSettingFragment.4.1(this);
        if ((i != 0) && (bool))
        {
          ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).startRecord(this.a.getBaseActivity(), "AssistantSettingFragment", (WakeServiceCallBack)localObject);
        }
        else
        {
          if (i == 0) {
            this.a.getBaseActivity().requestPermissions(new AssistantSettingFragment.4.2(this, (WakeServiceCallBack)localObject), 1, new String[] { "android.permission.RECORD_AUDIO" });
          }
          if (!bool) {
            ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).requestPermission(this.a.getBaseActivity());
          }
        }
      }
      else
      {
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).setAssistantImplSwitch(AssistantSettingFragment.a(this.a), false);
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).setCanOpenInSp(false);
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).stopRecord("AssistantSettingFragment");
      }
      AssistantSettingFragment.a(this.a);
      ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B885", paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */