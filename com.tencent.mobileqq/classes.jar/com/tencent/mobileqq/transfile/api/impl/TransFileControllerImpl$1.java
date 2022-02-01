package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.RichmediaIpv6ConifgBean;

class TransFileControllerImpl$1
  implements Runnable
{
  TransFileControllerImpl$1(TransFileControllerImpl paramTransFileControllerImpl) {}
  
  public void run()
  {
    this.this$0.mRichmediaIpv6ConifgBean = ((RichmediaIpv6ConifgBean)QConfigManager.b().b(538));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */