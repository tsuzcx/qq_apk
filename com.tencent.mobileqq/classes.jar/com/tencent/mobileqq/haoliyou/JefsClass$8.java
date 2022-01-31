package com.tencent.mobileqq.haoliyou;

import alud;
import asqi;
import asqj;
import bdgm;
import bdjz;
import com.tencent.mobileqq.app.BaseActivity;

public class JefsClass$8
  implements Runnable
{
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      bdgm.a(localBaseActivity, 0, null, alud.a(2131706260), localBaseActivity.getString(2131690648), localBaseActivity.getString(2131694953), new asqi(this), new asqj(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.8
 * JD-Core Version:    0.7.0.1
 */