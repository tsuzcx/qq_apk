package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.AdReport;

public class TopBannerInfo$AdReport
{
  public String a;
  
  public static AdReport a(oidb_cmd0xbc9.AdReport paramAdReport)
  {
    AdReport localAdReport = new AdReport();
    localAdReport.a = paramAdReport.bytes_report_url.get().toStringUtf8();
    return localAdReport;
  }
  
  public oidb_cmd0xbc9.AdReport a()
  {
    oidb_cmd0xbc9.AdReport localAdReport = new oidb_cmd0xbc9.AdReport();
    localAdReport.bytes_report_url.set(ByteStringMicro.copyFromUtf8(this.a));
    return localAdReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.AdReport
 * JD-Core Version:    0.7.0.1
 */