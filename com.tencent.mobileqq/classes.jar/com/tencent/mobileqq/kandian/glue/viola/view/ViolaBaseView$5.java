package com.tencent.mobileqq.kandian.glue.viola.view;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.qphone.base.util.QLog;

class ViolaBaseView$5
  implements Runnable
{
  ViolaBaseView$5(ViolaBaseView paramViolaBaseView, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaBaseView", 2, "ThreadManager 执行");
      }
      long l = System.currentTimeMillis();
      ViolaAccessHelper.a(this.a, ViolaBaseView.g(this.this$0), ViolaBaseView.a(this.this$0), new ViolaBaseView.5.1(this, l));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SDKInitialize Exception:");
        localStringBuilder.append(localException.getMessage());
        QLog.e("ViolaBaseView", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.5
 * JD-Core Version:    0.7.0.1
 */