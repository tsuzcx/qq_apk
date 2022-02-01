package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

final class PublicAccountReportUtils$3
  implements Runnable
{
  PublicAccountReportUtils$3(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fromUin", this.a);
    localHashMap.put("toUin", this.b);
    localHashMap.put("msgId", this.c);
    localHashMap.put("createTime", String.valueOf(this.d));
    localHashMap.put("recvTime", String.valueOf(this.e));
    localHashMap.put("sendFlag", this.f);
    localHashMap.put("nodeNo", String.valueOf(3000));
    long l = this.e - this.d;
    if ((l > 0L) && (l <= 86400L)) {
      break label125;
    }
    l = 0L;
    label125:
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPubAccMsgReceipt", true, l, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils.3
 * JD-Core Version:    0.7.0.1
 */