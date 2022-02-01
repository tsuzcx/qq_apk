package com.tencent.mobileqq.qassistant.wake;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.widget.QQToast;

public class WakeServiceCallBack$WakeServiceCallBackWithTips
  extends WakeServiceCallBack
{
  public static WakeServiceCallBack b()
  {
    return WakeServiceCallBack.WakeServiceCallBackWithTips.WakeServiceCallBackWithTipsHolder.a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (QQAssistantGuider.b))
    {
      if (BaseActivity.sTopActivity == null) {
        break label42;
      }
      new WakeDialog(BaseActivity.sTopActivity, true).show();
    }
    for (;;)
    {
      AssistantUtils.a("HelloQQWake", "WakeServiceCallBackWithTips show tips");
      QQAssistantGuider.b = false;
      return;
      label42:
      QQToast.a(BaseApplicationImpl.getApplication(), 2, BaseApplicationImpl.getApplication().getString(2131695315), 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeServiceCallBack.WakeServiceCallBackWithTips
 * JD-Core Version:    0.7.0.1
 */