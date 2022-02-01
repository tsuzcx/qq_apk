package com.tencent.mobileqq.wink.edit.manager;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.wink.edit.service.CompressUniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract class WinkDataBaseServiceHandler
  extends BusinessHandler
{
  protected WinkDataBaseServiceHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public abstract Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public final <T> T a(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    CompressUniPacket localCompressUniPacket = new CompressUniPacket(true);
    try
    {
      localCompressUniPacket.setEncodeName("utf-8");
      localCompressUniPacket.decode(paramArrayOfByte);
      return localCompressUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte)
    {
      label31:
      break label31;
    }
    return null;
  }
  
  public abstract boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
 * JD-Core Version:    0.7.0.1
 */