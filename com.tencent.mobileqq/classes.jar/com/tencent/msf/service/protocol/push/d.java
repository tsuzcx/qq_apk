package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends JceStruct
{
  static Map d;
  public long a;
  public Map b;
  public String c = "";
  
  public d() {}
  
  public d(long paramLong, Map paramMap, String paramString)
  {
    this.a = paramLong;
    this.b = paramMap;
    this.c = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    if (d == null)
    {
      d = new HashMap();
      SvcMsgPush localSvcMsgPush = new SvcMsgPush();
      d.put(Long.valueOf(0L), localSvcMsgPush);
    }
    this.b = ((Map)paramJceInputStream.read(d, 1, true));
    this.c = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.d
 * JD-Core Version:    0.7.0.1
 */