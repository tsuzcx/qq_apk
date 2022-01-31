package com.tencent.upload.e;

import com.qq.jce.wup.UniPacket;

public class e
{
  public static final Object a(String paramString, byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setEncodeName("UTF-8");
    localUniPacket.decode(paramArrayOfByte);
    paramString = localUniPacket.get(paramString);
    localUniPacket.clearCacheData();
    return paramString;
  }
  
  public static final byte[] a(String paramString, Object paramObject)
    throws Exception
  {
    if ((paramString == null) || (paramObject == null)) {
      return null;
    }
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setEncodeName("UTF-8");
    localUniPacket.setRequestId(0);
    localUniPacket.setFuncName("FuncName");
    localUniPacket.setServantName("ServantName");
    localUniPacket.put(paramString, paramObject);
    paramString = localUniPacket.encode();
    localUniPacket.clearCacheData();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.e
 * JD-Core Version:    0.7.0.1
 */