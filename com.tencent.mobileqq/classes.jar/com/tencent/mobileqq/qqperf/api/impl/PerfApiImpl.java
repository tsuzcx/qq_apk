package com.tencent.mobileqq.qqperf.api.impl;

import android.app.Activity;
import com.tencent.mfsdk.impls.memory.ActivityLeakSolutionInner;
import com.tencent.mfsdk.impls.memory.MemoryDumpHelper;
import com.tencent.mfsdk.tools.PhoneUtil;
import com.tencent.mobileqq.app.ProcessUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.guard.GuardConfig;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class PerfApiImpl
  implements IPerfApi
{
  public String getDeviceId()
  {
    return PhoneUtil.a(MobileQQ.getContext(), QBaseActivity.sTopActivity);
  }
  
  public String getGuardConfigID()
  {
    return GuardConfig.a().a();
  }
  
  public String getTopActivityName()
  {
    return ProcessUtil.a();
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    try
    {
      ActivityLeakSolutionInner.a(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("PerfApiImpl", 1, "onActivityDestroyed ", paramActivity);
    }
  }
  
  public boolean onQAPMLeakListenerFilter(Object paramObject)
  {
    return false;
  }
  
  public void startDumpingMemory(String paramString1, String paramString2, long paramLong)
  {
    MemoryDumpHelper.a().a(paramString1, paramString2, paramLong);
  }
  
  public void startDumpingMemoryLeak(String paramString)
  {
    MemoryDumpHelper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqperf.api.impl.PerfApiImpl
 * JD-Core Version:    0.7.0.1
 */