package com.tencent.mobileqq.kandian.glue.report;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class RIJUserDeviceInfoReport
{
  public static String a()
  {
    if (TextUtils.isEmpty(ReadInJoyUtils.a))
    {
      Object localObject2 = RIJDeviceUtil.a();
      Object localObject3 = RIJDeviceUtil.b();
      if ((!((String)localObject2).equals("null")) && (!((String)localObject3).equals("null")))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0,");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append((String)localObject3);
        ReadInJoyUtils.a = ((StringBuilder)localObject1).toString();
        return ReadInJoyUtils.a;
      }
      Object localObject1 = localObject2;
      if (((String)localObject2).equals("null")) {
        localObject1 = "0";
      }
      localObject2 = localObject3;
      if (((String)localObject3).equals("null")) {
        localObject2 = "0";
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("0,");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(",");
      ((StringBuilder)localObject3).append((String)localObject2);
      return ((StringBuilder)localObject3).toString();
    }
    return ReadInJoyUtils.a;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramQQAppInterface.getAccount());
    localHashMap.put("param_cpu", String.valueOf(DeviceInfoUtil.h()));
    localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
    localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.r()));
    localHashMap.put("param_version", "8.8.17");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actUserDeviceInfoReport", true, 100L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJUserDeviceInfoReport
 * JD-Core Version:    0.7.0.1
 */