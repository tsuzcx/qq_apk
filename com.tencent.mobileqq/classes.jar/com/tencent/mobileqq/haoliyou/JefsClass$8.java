package com.tencent.mobileqq.haoliyou;

import anzj;
import avpn;
import avpo;
import bhlq;
import bhpc;
import com.tencent.mobileqq.app.BaseActivity;

public class JefsClass$8
  implements Runnable
{
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      bhlq.a(localBaseActivity, 0, null, anzj.a(2131704768), localBaseActivity.getString(2131690580), localBaseActivity.getString(2131694098), new avpn(this), new avpo(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.8
 * JD-Core Version:    0.7.0.1
 */