package com.tencent.mobileqq.webprocess;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class WebProcessManager$1
  extends BroadcastReceiver
{
  WebProcessManager$1(WebProcessManager paramWebProcessManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("user_type", 0);
    int j = paramIntent.getIntExtra("from_type", 0);
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface))
    {
      paramContext = (BabyQHandler)((QQAppInterface)paramContext).getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (paramContext != null) {
        paramContext.a(i, j);
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("babyq receiver recv user_type=");
        paramContext.append(i);
        paramContext.append(", from_type=");
        paramContext.append(j);
        QLog.d("WebProcessManager", 2, paramContext.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager.1
 * JD-Core Version:    0.7.0.1
 */