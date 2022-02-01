package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.SubAccountConfigBean;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;

public class SubAccountConfigApiImpl
  implements ISubAccountConfigApi
{
  public boolean getIsHideSubAccountTroopMsg()
  {
    SubAccountConfigBean localSubAccountConfigBean = (SubAccountConfigBean)QConfigManager.b().b(607);
    if (localSubAccountConfigBean != null) {
      return localSubAccountConfigBean.a;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountConfigApiImpl
 * JD-Core Version:    0.7.0.1
 */