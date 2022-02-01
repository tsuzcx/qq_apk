package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.RichmediaIpv6ConifgBean;

public class InitHwEngineImp
  implements IHwEngineValue
{
  public boolean getIpv6Switch()
  {
    RichmediaIpv6ConifgBean localRichmediaIpv6ConifgBean = (RichmediaIpv6ConifgBean)QConfigManager.b().b(538);
    return (localRichmediaIpv6ConifgBean != null) && (localRichmediaIpv6ConifgBean.a);
  }
  
  public int getLocaleId()
  {
    return LocaleManager.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.InitHwEngineImp
 * JD-Core Version:    0.7.0.1
 */