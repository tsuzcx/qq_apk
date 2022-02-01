package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class ReadInJoyFeedsActivity$MyRunnable
  implements Runnable
{
  private WeakReference<ReadInJoyFeedsActivity> a;
  
  public ReadInJoyFeedsActivity$MyRunnable(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity1, ReadInJoyFeedsActivity paramReadInJoyFeedsActivity2)
  {
    this.a = new WeakReference(paramReadInJoyFeedsActivity2);
  }
  
  public void run()
  {
    if (((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist()) {
      return;
    }
    Object localObject = this.a;
    int i;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (IWebProcessManagerService)((ReadInJoyFeedsActivity)this.a.get()).app.getRuntimeService(IWebProcessManagerService.class, "");
      if (localObject != null)
      {
        i = RIJWebSearchUtils.a();
        if (!RIJWebSearchUtils.a()) {}
      }
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
      localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.e()));
      localHashMap.put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
      localHashMap.put("param_cpuFreq", String.valueOf(DeviceInfoUtil.b()));
      localHashMap.put("param_preloadLevel", String.valueOf(i));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preloadToolProcessReport:");
        localStringBuilder.append(localHashMap.toString());
        QLog.d("ReadInJoyBaseActivity", 2, localStringBuilder.toString());
      }
      StatisticCollector.getInstance(this.this$0).collectPerformance(this.this$0.app.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
    }
    catch (Exception localException)
    {
      label230:
      break label230;
    }
    if (i == 1) {
      ((IWebProcessManagerService)localObject).startWebProcess(200, null);
    } else if (i == 2) {
      ((IWebProcessManagerService)localObject).startWebProcess(201, null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseActivity", 2, "enter folder preload web process");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyFeedsActivity.MyRunnable
 * JD-Core Version:    0.7.0.1
 */