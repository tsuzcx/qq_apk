package com.tencent.tbs.one.impl.common.statistic;

import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ProgressiveCallback;
import com.tencent.tbs.one.impl.net.HttpRequestJob;
import java.util.HashMap;
import java.util.Map;

class StatisticReport$3$1
  extends ProgressiveCallback<byte[]>
{
  StatisticReport$3$1(StatisticReport.3 param3) {}
  
  public void onCompleted(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length > 1048576) && (StatisticInfo.getApnType(this.this$0.val$context) != 3))
    {
      Logging.w("Log size greater than 1MB, and current network is not WI-FI, log report halt!", new Object[0]);
      return;
    }
    Logging.d("Packaging log files completed, uploading...", new Object[0]);
    HashMap localHashMap = new HashMap();
    localHashMap.put("Content-Type", "application/octet-stream");
    localHashMap.put("Charset", "UTF-8");
    localHashMap.put("Content-length", paramArrayOfByte.length + "");
    localHashMap.put("q-proxy-log", "tbsonelog");
    String str = StatisticInfo.getDeviceIdentifier(this.this$0.val$context);
    Logging.d("Uploading tbsonelog, identifier are: " + str, new Object[0]);
    localHashMap.put("q-guid", str);
    localHashMap.put("q-params", "");
    localHashMap.put("openrandom", "tbsonelog");
    localHashMap.put("openmode", StatisticInfo.getDeviceModel());
    new HttpRequestJob(this.this$0.val$context, "https://qprostat.imtt.qq.com", "POST", localHashMap, paramArrayOfByte).start(new StatisticReport.3.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticReport.3.1
 * JD-Core Version:    0.7.0.1
 */