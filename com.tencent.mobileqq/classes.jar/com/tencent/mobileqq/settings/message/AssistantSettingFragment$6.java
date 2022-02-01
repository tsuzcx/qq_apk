package com.tencent.mobileqq.settings.message;

import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$6
  implements View.OnClickListener
{
  AssistantSettingFragment$6(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0)) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = FloatingScreenPermission.checkPermission(BaseApplicationImpl.getContext());
      if (i == 0) {
        this.a.getActivity().requestPermissions(new AssistantSettingFragment.6.1(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
      }
      if (!bool) {
        FloatingScreenPermission.requestPermission(this.a.getActivity());
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */