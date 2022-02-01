package com.tencent.mobileqq.kandian.biz.tab;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class ReadinjoyTabFrame$InitWebProcessRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long = 0L;
  private WeakReference<RIJTabFrameBase> jdField_a_of_type_JavaLangRefWeakReference;
  
  public void a(RIJTabFrameBase paramRIJTabFrameBase)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRIJTabFrameBase);
  }
  
  public void run()
  {
    if (((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist()) {
      return;
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      RIJTabFrameBase localRIJTabFrameBase = (RIJTabFrameBase)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localObject = (IWebProcessManagerService)localRIJTabFrameBase.a.getRuntimeService(IWebProcessManagerService.class, "multi");
      if (localObject != null)
      {
        int i = RIJWebSearchUtils.a();
        if (RIJWebSearchUtils.a()) {
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
              QLog.d("Q.readinjoy.4tab", 2, localStringBuilder.toString());
            }
            StatisticCollector.getInstance(localRIJTabFrameBase.a()).collectPerformance(((QQAppInterface)localRIJTabFrameBase.a).getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
          }
          catch (Exception localException)
          {
            QLog.d("Q.readinjoy.4tab", 2, "", localException);
          }
        }
        if (i == 1) {
          ((IWebProcessManagerService)localObject).startWebProcess(200, null);
        } else if (i == 2) {
          ((IWebProcessManagerService)localObject).startWebProcess(201, null);
        }
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "enter folder preload web process");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.InitWebProcessRunnable
 * JD-Core Version:    0.7.0.1
 */