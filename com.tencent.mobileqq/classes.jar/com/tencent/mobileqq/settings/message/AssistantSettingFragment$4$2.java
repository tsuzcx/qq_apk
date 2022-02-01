package com.tencent.mobileqq.settings.message;

import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qassistant.wake.WakeServiceCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.QQPermissionCallback;

class AssistantSettingFragment$4$2
  implements QQPermissionCallback
{
  AssistantSettingFragment$4$2(AssistantSettingFragment.4 param4, WakeServiceCallBack paramWakeServiceCallBack) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QQToast.makeText(this.b.a.getBaseActivity(), 2131893058, 1).show();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).startRecord(this.b.a.getBaseActivity(), "AssistantSettingFragment", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.4.2
 * JD-Core Version:    0.7.0.1
 */