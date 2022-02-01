package com.tencent.mobileqq.qwallet.transaction;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQWalletPushApi
  extends QRouteApi
{
  public abstract void parseMsg0x210Sub0x66(BaseQQAppInterface paramBaseQQAppInterface, byte[] paramArrayOfByte, long paramLong1, int paramInt1, long paramLong2, int paramInt2);
  
  public abstract void parseMsg0x210Sub0x7e(BaseQQAppInterface paramBaseQQAppInterface, byte[] paramArrayOfByte, long paramLong1, int paramInt1, long paramLong2, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.IQWalletPushApi
 * JD-Core Version:    0.7.0.1
 */