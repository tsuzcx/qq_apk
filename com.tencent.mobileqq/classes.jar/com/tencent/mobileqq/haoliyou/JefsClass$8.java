package com.tencent.mobileqq.haoliyou;

import anvx;
import avij;
import avik;
import bhdj;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class JefsClass$8
  implements Runnable
{
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      bhdj.a(localBaseActivity, 0, null, anvx.a(2131705349), localBaseActivity.getString(2131690697), localBaseActivity.getString(2131694399), new avij(this), new avik(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.8
 * JD-Core Version:    0.7.0.1
 */