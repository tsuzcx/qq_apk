package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

class VideoFeedsCPUMonitor$1$1
  implements Runnable
{
  VideoFeedsCPUMonitor$1$1(VideoFeedsCPUMonitor.1 param1) {}
  
  public void run()
  {
    Thread localThread = new Thread(new VideoFeedsCPUMonitor.1.1.1(this));
    try
    {
      Thread.sleep(10000L);
      localThread.start();
      long l1 = System.currentTimeMillis();
      long l2 = VideoFeedsCPUMonitor.e();
      if (VideoFeedsCPUMonitor.b().get() != 2) {
        break label244;
      }
      long l3 = System.currentTimeMillis();
      VideoFeedsCPUMonitor.c().getAndAdd(1);
      if (QLog.isColorLevel())
      {
        localObject = VideoFeedsCPUMonitor.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cost = ");
        localStringBuilder.append(l3 - l1);
        localStringBuilder.append(", runCount = ");
        localStringBuilder.append(l2);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("result", String.valueOf(l2));
        ((JSONObject)localObject).put("costTime", String.valueOf(l3 - l1));
        ((JSONObject)localObject).put("deviceModel", DeviceInfoUtil.f());
        ((JSONObject)localObject).put("manufactureInfo", DeviceInfoUtil.t());
        ((JSONObject)localObject).put("uin", RIJQQAppInterfaceUtil.d());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      PublicAccountReportUtils.a(null, null, "0X8009576", "0X8009576", 0, 0, RIJQQAppInterfaceUtil.d(), "1", "", ((JSONObject)localObject).toString(), false);
    }
    catch (InterruptedException localInterruptedException)
    {
      label229:
      break label229;
    }
    if (QLog.isColorLevel()) {
      QLog.d(VideoFeedsCPUMonitor.a(), 2, "InterruptedException");
    }
    label244:
    if (localThread.isAlive()) {
      localThread.interrupt();
    }
    VideoFeedsCPUMonitor.b().set(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsCPUMonitor.1.1
 * JD-Core Version:    0.7.0.1
 */