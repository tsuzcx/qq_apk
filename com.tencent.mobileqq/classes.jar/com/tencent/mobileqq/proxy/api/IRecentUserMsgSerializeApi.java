package com.tencent.mobileqq.proxy.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRecentUserMsgSerializeApi
  extends QRouteApi
{
  public abstract Object recentUserMsgDeserialize(int paramInt, byte[] paramArrayOfByte);
  
  public abstract byte[] recentUserMsgSerialize(int paramInt, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.proxy.api.IRecentUserMsgSerializeApi
 * JD-Core Version:    0.7.0.1
 */