package com.tencent.mobileqq.haoliyou;

import amtj;
import aucp;
import aucq;
import bfur;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class JefsClass$8
  implements Runnable
{
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      bfur.a(localBaseActivity, 0, null, amtj.a(2131704998), localBaseActivity.getString(2131690620), localBaseActivity.getString(2131694201), new aucp(this), new aucq(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.8
 * JD-Core Version:    0.7.0.1
 */