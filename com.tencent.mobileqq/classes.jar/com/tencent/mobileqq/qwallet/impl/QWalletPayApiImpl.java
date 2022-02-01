package com.tencent.mobileqq.qwallet.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;
import com.tencent.mobileqq.qwallet.IQWalletPayApi.PCPayData;

public class QWalletPayApiImpl
  implements IQWalletPayApi
{
  public void clearAllPayData() {}
  
  public IQWalletPayApi.PCPayData getIdlePayData(boolean paramBoolean)
  {
    return QWalletPushManager.a(paramBoolean);
  }
  
  public int getIdlePayDataCount()
  {
    return QWalletPushManager.a();
  }
  
  public int getPayBridgeCode(int paramInt)
  {
    return QWalletPushManager.a(paramInt);
  }
  
  public void onQQForeground(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    QWalletPushManager.a(paramBaseQQAppInterface, paramBoolean);
  }
  
  public void removePayingData() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletPayApiImpl
 * JD-Core Version:    0.7.0.1
 */