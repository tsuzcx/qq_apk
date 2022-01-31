package com.tencent.mobileqq.msf.core.c;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class o
  extends JceStruct
{
  static Map d;
  static Map e;
  public String a = "";
  public Map b = null;
  public Map c = null;
  
  public o() {}
  
  public o(String paramString, Map paramMap1, Map paramMap2)
  {
    this.a = paramString;
    this.b = paramMap1;
    this.c = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(1, true);
    if (d == null)
    {
      d = new HashMap();
      d.put("", Long.valueOf(0L));
    }
    this.b = ((Map)paramJceInputStream.read(d, 2, true));
    if (e == null)
    {
      e = new HashMap();
      e.put("", Long.valueOf(0L));
    }
    this.c = ((Map)paramJceInputStream.read(e, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.o
 * JD-Core Version:    0.7.0.1
 */