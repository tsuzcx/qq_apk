package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.AdReport;

public class RefreshData$AdReport
{
  public String a;
  
  public static AdReport a(oidb_0x5bd.AdReport paramAdReport)
  {
    AdReport localAdReport = new AdReport();
    localAdReport.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localAdReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.RefreshData.AdReport
 * JD-Core Version:    0.7.0.1
 */