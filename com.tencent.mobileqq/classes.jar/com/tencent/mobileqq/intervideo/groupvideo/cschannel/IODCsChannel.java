package com.tencent.mobileqq.intervideo.groupvideo.cschannel;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IODCsChannel
  extends QRouteApi
{
  public abstract IODCsChannel get(AppInterface paramAppInterface, long paramLong);
  
  public abstract IODCsChannel get(AppInterface paramAppInterface, long paramLong, String paramString1, String paramString2);
  
  public abstract void login(int paramInt1, byte[] paramArrayOfByte, int paramInt2, IODCsChannel.CsChannelObserver paramCsChannelObserver);
  
  public abstract void sendRequest(int paramInt, byte[] paramArrayOfByte, IODCsChannel.CsChannelObserver paramCsChannelObserver);
  
  public abstract void sendRequest(int paramInt1, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt2, IODCsChannel.CsChannelObserver paramCsChannelObserver);
  
  public abstract void sendRequest(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean, IODCsChannel.CsChannelObserver paramCsChannelObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel
 * JD-Core Version:    0.7.0.1
 */