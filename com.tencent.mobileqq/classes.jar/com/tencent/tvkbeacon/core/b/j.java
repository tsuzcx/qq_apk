package com.tencent.tvkbeacon.core.b;

import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.info.b;
import com.tencent.tvkbeacon.core.protocol.common.RequestPackage;

public final class j
{
  public static RequestPackage a(int paramInt1, b paramb, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString)
  {
    if (paramb == null)
    {
      c.d("error no com info! ", new Object[0]);
      return null;
    }
    try
    {
      RequestPackage localRequestPackage = new RequestPackage();
      localRequestPackage.model = paramb.e();
      localRequestPackage.osVersion = paramb.f();
      localRequestPackage.platformId = paramb.g();
      localRequestPackage.appkey = paramString;
      localRequestPackage.appVersion = paramb.b(paramString);
      localRequestPackage.sdkId = paramb.c();
      localRequestPackage.sdkVersion = paramb.d();
      localRequestPackage.reserved = "";
      localRequestPackage.cmd = paramInt1;
      localRequestPackage.encryType = ((byte)paramInt3);
      localRequestPackage.zipType = ((byte)paramInt2);
      paramb = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramb = "".getBytes();
      }
      localRequestPackage.sBuffer = paramb;
      return localRequestPackage;
    }
    catch (Throwable paramb)
    {
      c.a(paramb);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.b.j
 * JD-Core Version:    0.7.0.1
 */