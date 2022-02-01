package com.tencent.mobileqq.leba.business.mainbiz;

import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.qphone.base.util.QLog;

class LebaQzoneAndPluginPart$3
  implements LebaQzoneAndPluginPart.CheckEnterAppListener
{
  LebaQzoneAndPluginPart$3(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, View paramView, LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity) {}
  
  public void a()
  {
    try
    {
      this.e.a(this.a, false, this.b, this.c, this.d);
      return;
    }
    catch (Exception localException)
    {
      QLog.i("LebaBusinessPartImpl", 1, "clickAction", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.3
 * JD-Core Version:    0.7.0.1
 */