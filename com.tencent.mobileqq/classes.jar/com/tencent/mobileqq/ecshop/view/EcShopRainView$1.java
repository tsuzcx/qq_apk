package com.tencent.mobileqq.ecshop.view;

import com.tencent.qphone.base.util.QLog;

class EcShopRainView$1
  implements Runnable
{
  EcShopRainView$1(EcShopRainView paramEcShopRainView, EcShopRainView.Conf paramConf) {}
  
  public void run()
  {
    try
    {
      EcShopRainView.a(this.this$0, this.a);
      EcShopRainView.a(this.this$0, true);
      this.this$0.invalidate();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("EcShopRainView", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcShopRainView.1
 * JD-Core Version:    0.7.0.1
 */