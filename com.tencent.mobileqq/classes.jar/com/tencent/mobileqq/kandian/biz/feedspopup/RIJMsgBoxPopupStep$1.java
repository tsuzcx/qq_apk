package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.app.Activity;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;

class RIJMsgBoxPopupStep$1
  implements Runnable
{
  RIJMsgBoxPopupStep$1(RIJMsgBoxPopupStep paramRIJMsgBoxPopupStep, Activity paramActivity, int paramInt, String paramString) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      RIJMsgBoxUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, true, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJMsgBoxPopupStep.1
 * JD-Core Version:    0.7.0.1
 */