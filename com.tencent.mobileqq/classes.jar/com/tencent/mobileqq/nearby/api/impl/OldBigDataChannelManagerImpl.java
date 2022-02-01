package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager;
import com.tencent.mobileqq.nearby.api.OldBigDataChannelManager;
import mqq.manager.Manager;

public class OldBigDataChannelManagerImpl
  implements IOldBigDataChannelManager, Manager
{
  private OldBigDataChannelManager mOldBigDataChannelManager;
  
  public String getCircleSrvUrl()
  {
    return this.mOldBigDataChannelManager.a();
  }
  
  public byte[] getSrvKey()
  {
    return this.mOldBigDataChannelManager.a();
  }
  
  public byte[] getSrvSig()
  {
    return this.mOldBigDataChannelManager.b();
  }
  
  public void init(AppInterface paramAppInterface)
  {
    this.mOldBigDataChannelManager = new OldBigDataChannelManager(paramAppInterface);
  }
  
  public void onDestroy()
  {
    this.mOldBigDataChannelManager.onDestroy();
  }
  
  public void onResponseException()
  {
    this.mOldBigDataChannelManager.a();
  }
  
  public void saveSrvParam(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString)
  {
    this.mOldBigDataChannelManager.a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.OldBigDataChannelManagerImpl
 * JD-Core Version:    0.7.0.1
 */