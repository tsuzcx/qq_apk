package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.qphone.base.util.QLog;

class SubAccountControlServiceImpl$2
  implements Runnable
{
  SubAccountControlServiceImpl$2(SubAccountControlServiceImpl paramSubAccountControlServiceImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchTimedMsgTask() run. startAllSubMessageAccountMsg(false) app.isRunning=");
      Object localObject;
      if (this.this$0.app == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(this.this$0.app.isRunning());
      }
      localStringBuilder.append(localObject);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
    }
    if ((this.this$0.app != null) && (this.this$0.app.isRunning())) {
      ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).startAllSubMessageAccountMsg(false, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */