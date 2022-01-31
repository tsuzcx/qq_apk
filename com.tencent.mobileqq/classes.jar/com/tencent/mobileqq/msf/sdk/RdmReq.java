package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class RdmReq
  extends JceStruct
{
  static Map cache_params;
  public long elapse = 0L;
  public String eventName = "";
  public boolean isMerge = false;
  public boolean isRealTime = false;
  public boolean isSucceed = true;
  public Map params = null;
  public int reportType = 0;
  public long size = 0L;
  
  public RdmReq() {}
  
  public RdmReq(int paramInt, String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.reportType = paramInt;
    this.eventName = paramString;
    this.isSucceed = paramBoolean1;
    this.elapse = paramLong1;
    this.size = paramLong2;
    this.params = paramMap;
    this.isRealTime = paramBoolean2;
    this.isMerge = paramBoolean3;
  }
  
  public String className()
  {
    return "rdm.RdmReq";
  }
  
  public String fullClassName()
  {
    return "rdm.RdmReq";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reportType = paramJceInputStream.read(this.reportType, 1, true);
    this.eventName = paramJceInputStream.readString(2, true);
    this.isSucceed = paramJceInputStream.read(this.isSucceed, 3, true);
    this.elapse = paramJceInputStream.read(this.elapse, 4, true);
    this.size = paramJceInputStream.read(this.size, 5, true);
    if (cache_params == null)
    {
      cache_params = new HashMap();
      cache_params.put("", "");
    }
    this.params = ((Map)paramJceInputStream.read(cache_params, 6, true));
    this.isRealTime = paramJceInputStream.read(this.isRealTime, 7, true);
    this.isMerge = paramJceInputStream.read(this.isMerge, 8, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reportType, 1);
    paramJceOutputStream.write(this.eventName, 2);
    paramJceOutputStream.write(this.isSucceed, 3);
    paramJceOutputStream.write(this.elapse, 4);
    paramJceOutputStream.write(this.size, 5);
    paramJceOutputStream.write(this.params, 6);
    paramJceOutputStream.write(this.isRealTime, 7);
    paramJceOutputStream.write(this.isMerge, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.RdmReq
 * JD-Core Version:    0.7.0.1
 */