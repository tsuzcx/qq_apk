package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

class PublicAccountReportUtilsImpl$3
  implements Runnable
{
  PublicAccountReportUtilsImpl$3(PublicAccountReportUtilsImpl paramPublicAccountReportUtilsImpl, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fromUin", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("toUin", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("msgId", this.c);
    localHashMap.put("createTime", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("recvTime", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("sendFlag", this.d);
    localHashMap.put("nodeNo", String.valueOf(3000));
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if ((l > 0L) && (l <= 86400L)) {
      break label125;
    }
    l = 0L;
    label125:
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPubAccMsgReceipt", true, l, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtilsImpl.3
 * JD-Core Version:    0.7.0.1
 */