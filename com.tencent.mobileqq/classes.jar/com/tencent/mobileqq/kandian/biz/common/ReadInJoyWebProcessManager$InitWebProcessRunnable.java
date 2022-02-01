package com.tencent.mobileqq.kandian.biz.common;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ReadInJoyWebProcessManager$InitWebProcessRunnable
  implements Runnable
{
  private QQAppInterface a;
  
  public ReadInJoyWebProcessManager$InitWebProcessRunnable(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
      localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.e()));
      localHashMap.put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
      localHashMap.put("param_cpuFreq", String.valueOf(DeviceInfoUtil.b()));
      localHashMap.put("param_preloadLevel", String.valueOf(paramInt));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("preloadToolProcessReport:");
        localStringBuilder.append(localHashMap.toString());
        QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, localStringBuilder.toString());
      }
      StatisticCollector.getInstance(this.a.getApp()).collectPerformance(this.a.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception: ");
        localStringBuilder.append(localException);
        QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void run()
  {
    if (!((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist())
    {
      Object localObject = this.a;
      if (localObject == null) {
        return;
      }
      localObject = (IWebProcessManagerService)((QQAppInterface)localObject).getRuntimeService(IWebProcessManagerService.class, "");
      if (localObject == null) {
        return;
      }
      int i = RIJWebSearchUtils.a();
      if (RIJWebSearchUtils.a()) {
        a(i);
      }
      if (i == 1) {
        ((IWebProcessManagerService)localObject).startWebProcess(200, null);
      } else if (i == 2) {
        ((IWebProcessManagerService)localObject).startWebProcess(201, null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, "enter folder preload web process");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyWebProcessManager.InitWebProcessRunnable
 * JD-Core Version:    0.7.0.1
 */