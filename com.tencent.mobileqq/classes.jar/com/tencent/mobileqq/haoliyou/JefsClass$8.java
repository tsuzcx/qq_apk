package com.tencent.mobileqq.haoliyou;

import ajya;
import aqvl;
import aqvm;
import bbdj;
import bbgu;
import com.tencent.mobileqq.app.BaseActivity;

public class JefsClass$8
  implements Runnable
{
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      bbdj.a(localBaseActivity, 0, null, ajya.a(2131705876), localBaseActivity.getString(2131690596), localBaseActivity.getString(2131694794), new aqvl(this), new aqvm(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.8
 * JD-Core Version:    0.7.0.1
 */