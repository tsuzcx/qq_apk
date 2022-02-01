package com.tencent.mobileqq.haoliyou;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class JefsClass$8
  implements Runnable
{
  public void run()
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing())) {
      DialogUtil.a(localQBaseActivity, 0, null, HardCodeUtil.a(2131705944), localQBaseActivity.getString(2131690728), localQBaseActivity.getString(2131694583), new JefsClass.8.1(this), new JefsClass.8.2(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.8
 * JD-Core Version:    0.7.0.1
 */