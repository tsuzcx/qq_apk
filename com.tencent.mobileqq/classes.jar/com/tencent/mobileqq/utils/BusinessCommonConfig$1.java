package com.tencent.mobileqq.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class BusinessCommonConfig$1
  extends BroadcastReceiver
{
  BusinessCommonConfig$1(BusinessCommonConfig paramBusinessCommonConfig, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      if (!"tencent.businessnotify.subprocess.to.qq".equals(paramIntent.getAction())) {
        return;
      }
      int i = paramIntent.getIntExtra("event", 0);
      paramContext = this.b.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("收到其他进程的通知, event[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.w(paramContext, 1, localStringBuilder.toString());
      if (i == 1) {
        BusinessCommonConfig.onDownloadRequest(this.a, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BusinessCommonConfig.1
 * JD-Core Version:    0.7.0.1
 */