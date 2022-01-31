package com.tencent.tvkbeacon.core.protocol.common;

import com.tencent.tvkbeacon.core.wup.JceStruct;
import com.tencent.tvkbeacon.core.wup.a;
import com.tencent.tvkbeacon.core.wup.b;
import java.util.HashMap;
import java.util.Map;

public final class SocketResponsePackage
  extends JceStruct
{
  static byte[] cache_body;
  static Map<String, String> cache_header = new HashMap();
  public byte[] body = null;
  public Map<String, String> header = null;
  public String msg = "";
  public int statusCode = 0;
  
  static
  {
    cache_header.put("", "");
    byte[] arrayOfByte = (byte[])new byte[1];
    cache_body = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public SocketResponsePackage() {}
  
  public SocketResponsePackage(int paramInt, Map<String, String> paramMap, byte[] paramArrayOfByte, String paramString)
  {
    this.statusCode = paramInt;
    this.header = paramMap;
    this.body = paramArrayOfByte;
    this.msg = paramString;
  }
  
  public final void readFrom(a parama)
  {
    this.statusCode = parama.a(this.statusCode, 0, true);
    this.header = ((Map)parama.a(cache_header, 1, true));
    this.body = ((byte[])parama.c(2, true));
    this.msg = parama.b(3, false);
  }
  
  public final void writeTo(b paramb)
  {
    paramb.a(this.statusCode, 0);
    paramb.a(this.header, 1);
    paramb.a(this.body, 2);
    if (this.msg != null) {
      paramb.a(this.msg, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.protocol.common.SocketResponsePackage
 * JD-Core Version:    0.7.0.1
 */