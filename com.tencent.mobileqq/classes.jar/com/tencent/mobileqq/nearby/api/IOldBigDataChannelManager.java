package com.tencent.mobileqq.nearby.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IOldBigDataChannelManager
  extends QRouteApi
{
  public static final String FILE_SUFFIX = "_circle_svc";
  
  public abstract String getCircleSrvUrl();
  
  public abstract byte[] getSrvKey();
  
  public abstract byte[] getSrvSig();
  
  public abstract void init(AppInterface paramAppInterface);
  
  public abstract void onDestroy();
  
  public abstract void onResponseException();
  
  public abstract void saveSrvParam(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager
 * JD-Core Version:    0.7.0.1
 */