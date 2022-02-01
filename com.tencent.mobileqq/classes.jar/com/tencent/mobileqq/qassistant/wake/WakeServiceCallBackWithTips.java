package com.tencent.mobileqq.qassistant.wake;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class WakeServiceCallBackWithTips
  extends WakeServiceCallBack
{
  public static WakeServiceCallBack b()
  {
    return WakeServiceCallBackWithTips.WakeServiceCallBackWithTipsHolder.a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (QQAssistantGuider.a))
    {
      if (QBaseActivity.sTopActivity != null) {
        new WakeDialog(QBaseActivity.sTopActivity, true).show();
      } else {
        QQToast.a(MobileQQ.sMobileQQ, 2, MobileQQ.sMobileQQ.getString(2131695324), 1).a();
      }
      AssistantUtils.a("HelloQQWake", "WakeServiceCallBackWithTips show tips");
      QQAssistantGuider.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeServiceCallBackWithTips
 * JD-Core Version:    0.7.0.1
 */