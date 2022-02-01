package com.tencent.mobileqq.settings.message;

import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.qassistant.wake.WakeServiceCallBack;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$4
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$4(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject;
    if (!NetworkUtil.d(this.a.getActivity()))
    {
      AssistantSettingFragment.a(this.a, 2131694510, 1);
      localObject = this.a;
      if (!paramBoolean) {}
      for (;;)
      {
        AssistantSettingFragment.b((AssistantSettingFragment)localObject, bool, this);
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool = false;
      }
    }
    int i;
    if (paramBoolean)
    {
      AssistantSwitchImpl.a(AssistantSettingFragment.a(this.a), true);
      WakeManager.a().a(true);
      AssistantUtils.a("HelloQQWake", "qVoiceAssistantCkb change isChecked:" + paramBoolean);
      if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0))
      {
        i = 1;
        label126:
        bool = FloatingScreenPermission.checkPermission(BaseApplicationImpl.getContext());
        localObject = new AssistantSettingFragment.4.1(this);
        if ((i == 0) || (!bool)) {
          break label198;
        }
        WakeManager.a().a(this.a.getActivity(), "AssistantSettingFragment", (WakeServiceCallBack)localObject);
      }
    }
    for (;;)
    {
      AssistantSettingFragment.a(this.a);
      ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B885", paramBoolean);
      break;
      i = 0;
      break label126;
      label198:
      if (i == 0) {
        this.a.getActivity().requestPermissions(new AssistantSettingFragment.4.2(this, (WakeServiceCallBack)localObject), 1, new String[] { "android.permission.RECORD_AUDIO" });
      }
      if (!bool)
      {
        FloatingScreenPermission.requestPermission(this.a.getActivity());
        continue;
        AssistantSwitchImpl.a(AssistantSettingFragment.a(this.a), false);
        WakeManager.a().a(false);
        WakeManager.a().b("AssistantSettingFragment");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */