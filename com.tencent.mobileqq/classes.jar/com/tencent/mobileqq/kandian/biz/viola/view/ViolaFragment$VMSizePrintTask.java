package com.tencent.mobileqq.kandian.biz.viola.view;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.tools.MemoryInfoRecordHelper;

final class ViolaFragment$VMSizePrintTask
  implements Runnable
{
  String a;
  
  public ViolaFragment$VMSizePrintTask(ViolaFragment paramViolaFragment)
  {
    this.a = paramViolaFragment.toString();
  }
  
  public void run()
  {
    try
    {
      localObject = MemoryInfoRecordHelper.c();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVirtualMemoryInfo: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", sVShortVideoCount=");
      localStringBuilder.append(ViolaFragment.access$200());
      localStringBuilder.append(", memoryInfo=");
      localStringBuilder.append((String)localObject);
      QLog.d("ViolaFragment", 1, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label67:
      break label67;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getVirtualMemoryInfo: ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", sVShortVideoCount=");
    ((StringBuilder)localObject).append(ViolaFragment.access$200());
    ((StringBuilder)localObject).append(", error");
    QLog.d("ViolaFragment", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment.VMSizePrintTask
 * JD-Core Version:    0.7.0.1
 */