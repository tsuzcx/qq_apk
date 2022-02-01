package com.tencent.mobileqq.qassistant.wake;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class WakeServiceCallBackWithTips
  extends WakeServiceCallBack
{
  public static WakeServiceCallBack c()
  {
    return WakeServiceCallBackWithTips.WakeServiceCallBackWithTipsHolder.a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (QQAssistantGuider.b))
    {
      if (QBaseActivity.sTopActivity != null) {
        new WakeDialog(QBaseActivity.sTopActivity, true).show();
      } else {
        QQToast.makeText(MobileQQ.sMobileQQ, 2, MobileQQ.sMobileQQ.getString(2131893059), 1).show();
      }
      AssistantUtils.a("HelloQQWake", "WakeServiceCallBackWithTips show tips");
      QQAssistantGuider.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeServiceCallBackWithTips
 * JD-Core Version:    0.7.0.1
 */