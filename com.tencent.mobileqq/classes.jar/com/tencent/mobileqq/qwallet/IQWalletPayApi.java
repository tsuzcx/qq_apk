package com.tencent.mobileqq.qwallet;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQWalletPayApi
  extends QRouteApi
{
  public abstract void clearAllPayData();
  
  public abstract IQWalletPayApi.PCPayData getIdlePayData(boolean paramBoolean);
  
  public abstract int getIdlePayDataCount();
  
  public abstract int getPayBridgeCode(int paramInt);
  
  public abstract void onQQForeground(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean);
  
  public abstract void removePayingData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.IQWalletPayApi
 * JD-Core Version:    0.7.0.1
 */