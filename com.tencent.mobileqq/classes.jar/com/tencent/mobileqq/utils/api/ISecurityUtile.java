package com.tencent.mobileqq.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISecurityUtile
  extends QRouteApi
{
  public abstract String encode(String paramString);
  
  public abstract byte[] encode(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.api.ISecurityUtile
 * JD-Core Version:    0.7.0.1
 */