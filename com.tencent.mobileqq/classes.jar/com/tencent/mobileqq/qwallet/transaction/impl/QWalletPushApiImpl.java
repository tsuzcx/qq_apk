package com.tencent.mobileqq.qwallet.transaction.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.impl.QWalletPushManager;
import com.tencent.mobileqq.qwallet.transaction.IQWalletPushApi;

public class QWalletPushApiImpl
  implements IQWalletPushApi
{
  public void parseMsg0x210Sub0x66(BaseQQAppInterface paramBaseQQAppInterface, byte[] paramArrayOfByte, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    QWalletPushManager.a(paramBaseQQAppInterface, paramArrayOfByte, paramLong1, paramInt1, paramLong2, paramInt2);
  }
  
  public void parseMsg0x210Sub0x7e(BaseQQAppInterface paramBaseQQAppInterface, byte[] paramArrayOfByte, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    QWalletPushManager.b(paramBaseQQAppInterface, paramArrayOfByte, paramLong1, paramInt1, paramLong2, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.QWalletPushApiImpl
 * JD-Core Version:    0.7.0.1
 */