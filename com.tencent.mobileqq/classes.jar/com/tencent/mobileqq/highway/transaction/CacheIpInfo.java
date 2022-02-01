package com.tencent.mobileqq.highway.transaction;

import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class CacheIpInfo
{
  private int cache_addr_port;
  private int cache_addr_res;
  private String ip;
  
  public CacheIpInfo(HwResponse paramHwResponse, HwRequest paramHwRequest)
  {
    if (paramHwResponse.segmentResp.uint32_cache_addr.has())
    {
      int i = paramHwResponse.segmentResp.uint32_cache_addr.get();
      int j = paramHwResponse.segmentResp.uint32_cache_port.get();
      paramHwResponse = new StringBuilder();
      paramHwResponse.append(HwRequest.intToIP(i));
      paramHwResponse.append(":");
      paramHwResponse.append(j);
      paramHwResponse = paramHwResponse.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RequestUpload HandleResp : cache_addr res from server is : ( ");
      localStringBuilder.append(paramHwResponse);
      localStringBuilder.append(" ) Seq:");
      localStringBuilder.append(paramHwRequest.getHwSeq());
      BdhLogUtil.LogEvent("R", localStringBuilder.toString());
      this.cache_addr_res = i;
      this.cache_addr_port = j;
      this.ip = paramHwResponse;
    }
  }
  
  public void checkCacheIp(HwResponse paramHwResponse, HwRequest paramHwRequest)
  {
    if ((paramHwResponse.segmentResp.uint32_update_cacheip.has()) && (paramHwResponse.segmentResp.uint32_update_cacheip.get() == 1)) {
      try
      {
        int i = paramHwResponse.segmentResp.uint32_cache_addr.get();
        int j = paramHwResponse.segmentResp.uint32_cache_port.get();
        paramHwResponse = new StringBuilder();
        paramHwResponse.append(paramHwRequest.getClass().getSimpleName());
        paramHwResponse.append(" HandleResp : cache ip Diff !");
        paramHwResponse.append(i);
        paramHwResponse.append(" ( ");
        paramHwResponse.append(HwRequest.intToIP(i));
        paramHwResponse.append(":");
        paramHwResponse.append(j);
        paramHwResponse.append(" ) Seq:");
        paramHwResponse.append(paramHwRequest.getHwSeq());
        BdhLogUtil.LogEvent("R", paramHwResponse.toString());
        this.cache_addr_res = i;
        this.cache_addr_port = j;
        return;
      }
      finally {}
    }
  }
  
  public void writeHeadCacheIp(CSDataHighwayHead.SegHead paramSegHead, HwRequest paramHwRequest)
  {
    if ((this.cache_addr_res != 0) && (this.cache_addr_port != 0))
    {
      paramSegHead.uint32_cache_addr.set(this.cache_addr_res);
      paramSegHead.uint32_cache_port.set(this.cache_addr_port);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.CacheIpInfo
 * JD-Core Version:    0.7.0.1
 */