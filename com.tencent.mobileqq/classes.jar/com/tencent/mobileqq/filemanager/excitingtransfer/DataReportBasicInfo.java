package com.tencent.mobileqq.filemanager.excitingtransfer;

import java.util.HashMap;

public class DataReportBasicInfo
{
  public long a = 0L;
  public long b = 0L;
  public int c;
  public String d;
  public long e;
  public int f;
  public long g;
  private int h = 3;
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_Result", String.valueOf(this.a));
    localHashMap.put("param_SubReason", String.valueOf(this.b));
    localHashMap.put("param_XTFReceiverType", String.valueOf(this.c));
    localHashMap.put("param_Suffix", String.valueOf(this.d));
    localHashMap.put("param_TargetUin", String.valueOf(this.e));
    localHashMap.put("param_TargetType", String.valueOf(this.f));
    localHashMap.put("param_FileSize", String.valueOf(this.g));
    localHashMap.put("param_TranferPlatform", String.valueOf(this.h));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.DataReportBasicInfo
 * JD-Core Version:    0.7.0.1
 */