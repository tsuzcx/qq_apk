package com.tencent.mobileqq.haoliyou;

import anni;
import auxm;
import auxn;
import bglp;
import bgpa;
import com.tencent.mobileqq.app.BaseActivity;

public class JefsClass$8
  implements Runnable
{
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      bglp.a(localBaseActivity, 0, null, anni.a(2131704661), localBaseActivity.getString(2131690582), localBaseActivity.getString(2131694081), new auxm(this), new auxn(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.8
 * JD-Core Version:    0.7.0.1
 */