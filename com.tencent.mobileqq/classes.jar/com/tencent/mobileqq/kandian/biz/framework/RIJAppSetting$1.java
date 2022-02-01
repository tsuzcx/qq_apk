package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class RIJAppSetting$1
  implements Runnable
{
  RIJAppSetting$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      if (!localQQAppInterface.isLogin()) {
        return;
      }
      if (RIJAppSetting.b)
      {
        RIJAppSetting.c(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("RIJAppSetting", 2, "handNet2Wifi is show conversation");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting.1
 * JD-Core Version:    0.7.0.1
 */