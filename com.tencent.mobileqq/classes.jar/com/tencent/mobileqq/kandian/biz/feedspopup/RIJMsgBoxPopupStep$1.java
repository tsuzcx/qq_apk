package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.app.Activity;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;

class RIJMsgBoxPopupStep$1
  implements Runnable
{
  RIJMsgBoxPopupStep$1(RIJMsgBoxPopupStep paramRIJMsgBoxPopupStep, Activity paramActivity, int paramInt, String paramString) {}
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      RIJMsgBoxUtils.a(this.a, this.b, true, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJMsgBoxPopupStep.1
 * JD-Core Version:    0.7.0.1
 */