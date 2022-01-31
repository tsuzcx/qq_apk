package com.tencent.qphone.base.report;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class StrupBuff
  extends JceStruct
{
  static Map cache_logstring;
  public byte encoding = 0;
  public Map logstring = null;
  public String prefix = "";
  
  public StrupBuff() {}
  
  public StrupBuff(Map paramMap, String paramString, byte paramByte)
  {
    this.logstring = paramMap;
    this.prefix = paramString;
    this.encoding = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_logstring == null)
    {
      cache_logstring = new HashMap();
      ArrayList localArrayList = new ArrayList();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      localArrayList.add(arrayOfByte);
      cache_logstring.put("", localArrayList);
    }
    this.logstring = ((Map)paramJceInputStream.read(cache_logstring, 0, true));
    this.prefix = paramJceInputStream.readString(1, false);
    this.encoding = paramJceInputStream.read(this.encoding, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.logstring, 0);
    if (this.prefix != null) {
      paramJceOutputStream.write(this.prefix, 1);
    }
    paramJceOutputStream.write(this.encoding, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.report.StrupBuff
 * JD-Core Version:    0.7.0.1
 */