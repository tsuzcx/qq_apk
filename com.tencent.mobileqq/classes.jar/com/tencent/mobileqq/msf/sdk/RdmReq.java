package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class RdmReq
  extends JceStruct
{
  static Map cache_params = new HashMap();
  public String appKey = "";
  public long elapse = 0L;
  public String eventName = "";
  public boolean isImmediatelyUpload = false;
  public boolean isMerge = false;
  public boolean isRealTime = false;
  public boolean isSucceed = true;
  public Map params = null;
  public int reportType = 0;
  public long size = 0L;
  
  static
  {
    cache_params.put("", "");
  }
  
  public RdmReq() {}
  
  public RdmReq(int paramInt, String paramString1, boolean paramBoolean1, long paramLong1, long paramLong2, Map paramMap, boolean paramBoolean2, boolean paramBoolean3, String paramString2, boolean paramBoolean4)
  {
    this.reportType = paramInt;
    this.eventName = paramString1;
    this.isSucceed = paramBoolean1;
    this.elapse = paramLong1;
    this.size = paramLong2;
    this.params = paramMap;
    this.isRealTime = paramBoolean2;
    this.isMerge = paramBoolean3;
    this.appKey = paramString2;
    this.isImmediatelyUpload = paramBoolean4;
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
    this.params = ((Map)paramJceInputStream.read(cache_params, 6, true));
    this.isRealTime = paramJceInputStream.read(this.isRealTime, 7, true);
    this.isMerge = paramJceInputStream.read(this.isMerge, 8, true);
    this.appKey = paramJceInputStream.readString(9, false);
    this.isImmediatelyUpload = paramJceInputStream.read(this.isImmediatelyUpload, 10, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RdmReq{reportType=");
    localStringBuilder.append(this.reportType);
    localStringBuilder.append(", eventName='");
    localStringBuilder.append(this.eventName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isSucceed=");
    localStringBuilder.append(this.isSucceed);
    localStringBuilder.append(", elapse=");
    localStringBuilder.append(this.elapse);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.params);
    localStringBuilder.append(", isRealTime=");
    localStringBuilder.append(this.isRealTime);
    localStringBuilder.append(", isMerge=");
    localStringBuilder.append(this.isMerge);
    localStringBuilder.append(", appKey='");
    localStringBuilder.append(this.appKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isImmediatelyUpload=");
    localStringBuilder.append(this.isImmediatelyUpload);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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
    String str = this.appKey;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    paramJceOutputStream.write(this.isImmediatelyUpload, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.RdmReq
 * JD-Core Version:    0.7.0.1
 */