package com.tencent.mobileqq.qqlive.prepare;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

class QQLivePrepareFragment$ClosePreparePageBrocastReceiver
  extends BroadcastReceiver
{
  private QQLivePrepareFragment a;
  
  public QQLivePrepareFragment$ClosePreparePageBrocastReceiver(QQLivePrepareFragment paramQQLivePrepareFragment)
  {
    this.a = paramQQLivePrepareFragment;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = paramIntent.getAction();
      long l = paramIntent.getLongExtra("broadcast_send_time", 0L);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("close receiver, action:");
        localStringBuilder.append(paramContext);
        QLog.d("QQLivePrepareFragment", 1, localStringBuilder.toString());
      }
      if ((TextUtils.equals("qqlive_anchor_prepare_fragment", paramIntent.getAction())) && (System.currentTimeMillis() - l <= 1000L))
      {
        this.a.getQBaseActivity().finish();
        return;
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQLivePrepareFragment", 1, paramContext, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.ClosePreparePageBrocastReceiver
 * JD-Core Version:    0.7.0.1
 */