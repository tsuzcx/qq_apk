package com.tencent.mobileqq.vas.api;

import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

@QAPI(process={""})
public abstract interface IJce
  extends QRouteApi
{
  public static final int TYPE_REQ = 1;
  public static final int TYPE_STREQ = 2;
  
  public abstract IJce build(String paramString1, String paramString2);
  
  public abstract IJce build(String paramString1, String paramString2, int paramInt);
  
  public abstract IJce build(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, UniPacket paramUniPacket);
  
  public abstract void encode(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, int paramInt);
  
  public abstract String getCmd();
  
  public abstract void request(String paramString, JceStruct paramJceStruct1, JceStruct paramJceStruct2, BusinessObserver paramBusinessObserver, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IJce
 * JD-Core Version:    0.7.0.1
 */