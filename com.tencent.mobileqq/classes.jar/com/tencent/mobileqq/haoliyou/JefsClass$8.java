package com.tencent.mobileqq.haoliyou;

import alpo;
import aslz;
import asma;
import bdcd;
import bdfq;
import com.tencent.mobileqq.app.BaseActivity;

public class JefsClass$8
  implements Runnable
{
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      bdcd.a(localBaseActivity, 0, null, alpo.a(2131706248), localBaseActivity.getString(2131690648), localBaseActivity.getString(2131694951), new aslz(this), new asma(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.8
 * JD-Core Version:    0.7.0.1
 */