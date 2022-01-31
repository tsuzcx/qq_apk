package com.tencent.tvkbeacon.core.protocol.common;

import com.tencent.tvkbeacon.core.wup.JceStruct;
import com.tencent.tvkbeacon.core.wup.a;
import com.tencent.tvkbeacon.core.wup.b;

public final class RequestPackage
  extends JceStruct
{
  static byte[] cache_sBuffer;
  public String appVersion = "";
  public String appkey = "";
  public int cmd = 0;
  public byte encryType = 0;
  public String model = "";
  public String osVersion = "";
  public byte platformId = 0;
  public String reserved = "";
  public byte[] sBuffer = null;
  public String sdkId = "";
  public String sdkVersion = "";
  public byte zipType = 0;
  
  public RequestPackage() {}
  
  public RequestPackage(byte paramByte1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, byte[] paramArrayOfByte, byte paramByte2, byte paramByte3, String paramString5, String paramString6, String paramString7)
  {
    this.platformId = paramByte1;
    this.appkey = paramString1;
    this.appVersion = paramString2;
    this.sdkId = paramString3;
    this.sdkVersion = paramString4;
    this.cmd = paramInt;
    this.sBuffer = paramArrayOfByte;
    this.encryType = paramByte2;
    this.zipType = paramByte3;
    this.model = paramString5;
    this.osVersion = paramString6;
    this.reserved = paramString7;
  }
  
  public final void readFrom(a parama)
  {
    this.platformId = parama.a(this.platformId, 0, true);
    this.appkey = parama.b(1, true);
    this.appVersion = parama.b(2, true);
    this.sdkId = parama.b(3, true);
    this.sdkVersion = parama.b(4, true);
    this.cmd = parama.a(this.cmd, 5, true);
    if (cache_sBuffer == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      cache_sBuffer = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.sBuffer = ((byte[])parama.c(6, true));
    this.encryType = parama.a(this.encryType, 7, true);
    this.zipType = parama.a(this.zipType, 8, true);
    this.model = parama.b(9, false);
    this.osVersion = parama.b(10, false);
    this.reserved = parama.b(11, false);
  }
  
  public final void writeTo(b paramb)
  {
    paramb.a(this.platformId, 0);
    paramb.a(this.appkey, 1);
    paramb.a(this.appVersion, 2);
    paramb.a(this.sdkId, 3);
    paramb.a(this.sdkVersion, 4);
    paramb.a(this.cmd, 5);
    paramb.a(this.sBuffer, 6);
    paramb.a(this.encryType, 7);
    paramb.a(this.zipType, 8);
    if (this.model != null) {
      paramb.a(this.model, 9);
    }
    if (this.osVersion != null) {
      paramb.a(this.osVersion, 10);
    }
    if (this.reserved != null) {
      paramb.a(this.reserved, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.protocol.common.RequestPackage
 * JD-Core Version:    0.7.0.1
 */