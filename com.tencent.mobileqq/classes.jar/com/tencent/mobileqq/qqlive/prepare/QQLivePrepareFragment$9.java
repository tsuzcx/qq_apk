package com.tencent.mobileqq.qqlive.prepare;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

class QQLivePrepareFragment$9
  implements Runnable
{
  QQLivePrepareFragment$9(QQLivePrepareFragment paramQQLivePrepareFragment) {}
  
  public void run()
  {
    QBaseActivity localQBaseActivity = this.this$0.getQBaseActivity();
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()))
    {
      QLog.i("QQLivePrepareFragment", 1, "the activity should finish now");
      localQBaseActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.9
 * JD-Core Version:    0.7.0.1
 */