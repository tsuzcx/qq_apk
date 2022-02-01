package com.tencent.mobileqq.kandian.glue.viola.view;

import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.qphone.base.util.QLog;

class ViolaBaseView$13
  implements Runnable
{
  ViolaBaseView$13(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    try
    {
      ViolaBaseView.a(this.this$0, new ViolaBaseView.13.1(this));
      FPSCalculator.a().a(ViolaBaseView.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        String str = ViolaBaseView.b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pageOpenSuccess Exception:");
        localStringBuilder.append(localException.getMessage());
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.13
 * JD-Core Version:    0.7.0.1
 */