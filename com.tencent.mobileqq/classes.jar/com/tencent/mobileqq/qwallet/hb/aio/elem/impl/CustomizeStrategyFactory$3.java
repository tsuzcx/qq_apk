package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$3
  implements Runnable
{
  CustomizeStrategyFactory$3(CustomizeStrategyFactory paramCustomizeStrategyFactory, RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      this.a.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = QWalletTools.a(this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$AnimConfig.a);
      this.a.c = true;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preProcessAnim-throw:");
        localStringBuilder.append(localThrowable);
        QLog.e("CustomizeStrategyFactory", 2, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeStrategyFactory", 2, "preProcessAnim-preProcess finished");
    }
    CustomizeStrategyFactory.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.3
 * JD-Core Version:    0.7.0.1
 */