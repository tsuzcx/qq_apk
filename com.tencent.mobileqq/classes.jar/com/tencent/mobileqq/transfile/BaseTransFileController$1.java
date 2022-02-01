package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.RichmediaIpv6ConifgBean;

class BaseTransFileController$1
  implements Runnable
{
  BaseTransFileController$1(BaseTransFileController paramBaseTransFileController) {}
  
  public void run()
  {
    this.this$0.mRichmediaIpv6ConifgBean = ((RichmediaIpv6ConifgBean)QConfigManager.a().a(538));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransFileController.1
 * JD-Core Version:    0.7.0.1
 */