package com.tencent.mobileqq.transfile.predownload.schedule;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qqperf.api.IProcessStats;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.qphone.base.util.QLog;

class PreDownloadScheduler$1
  implements FPSCalculator.GetFPSListener
{
  PreDownloadScheduler$1(PreDownloadScheduler paramPreDownloadScheduler) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (!PreDownloadScheduler.access$100(this.this$0)) {
      return;
    }
    Object localObject;
    if (!PreDownloadScheduler.access$200(this.this$0))
    {
      PreDownloadScheduler.access$302(this.this$0, paramLong);
      PreDownloadScheduler.access$402(this.this$0, paramDouble);
      PreDownloadScheduler.access$502(this.this$0, ((IProcessStats)QRoute.api(IProcessStats.class)).getCpuUsage());
      Bundle localBundle;
      if (PreDownloadScheduler.access$400(this.this$0) > PreDownloadScheduler.access$600(this.this$0))
      {
        if (!PreDownloadScheduler.access$700(this.this$0))
        {
          PreDownloadScheduler.access$808(this.this$0);
          if (PreDownloadScheduler.access$800(this.this$0) >= PreDownloadScheduler.access$900(this.this$0))
          {
            PreDownloadScheduler.access$702(this.this$0, true);
            PreDownloadScheduler.access$802(this.this$0, 0L);
          }
        }
      }
      else
      {
        if ((PreDownloadScheduler.access$1000(this.this$0)) && (PreDownloadScheduler.access$700(this.this$0)))
        {
          localObject = new Message();
          ((Message)localObject).what = 1007;
          localBundle = new Bundle();
          localBundle.putDouble("FPS", PreDownloadScheduler.access$400(this.this$0));
          localBundle.putDouble("CPU", PreDownloadScheduler.access$500(this.this$0));
          ((Message)localObject).obj = localBundle;
          PreDownloadScheduler.access$1100(this.this$0).sendMessage((Message)localObject);
        }
        PreDownloadScheduler.access$702(this.this$0, false);
        PreDownloadScheduler.access$802(this.this$0, 0L);
      }
      if (PreDownloadScheduler.access$500(this.this$0) < PreDownloadScheduler.access$1200(this.this$0))
      {
        if (!PreDownloadScheduler.access$1000(this.this$0))
        {
          PreDownloadScheduler.access$1308(this.this$0);
          if (PreDownloadScheduler.access$1300(this.this$0) >= PreDownloadScheduler.access$900(this.this$0))
          {
            PreDownloadScheduler.access$1002(this.this$0, true);
            PreDownloadScheduler.access$1302(this.this$0, 0L);
          }
        }
      }
      else
      {
        if ((PreDownloadScheduler.access$1000(this.this$0)) && (PreDownloadScheduler.access$700(this.this$0)))
        {
          localObject = new Message();
          ((Message)localObject).what = 1007;
          localBundle = new Bundle();
          localBundle.putDouble("FPS", PreDownloadScheduler.access$400(this.this$0));
          localBundle.putDouble("CPU", PreDownloadScheduler.access$500(this.this$0));
          ((Message)localObject).obj = localBundle;
          PreDownloadScheduler.access$1100(this.this$0).sendMessage((Message)localObject);
        }
        PreDownloadScheduler.access$1002(this.this$0, false);
        PreDownloadScheduler.access$1302(this.this$0, 0L);
      }
    }
    else
    {
      PreDownloadScheduler.access$1002(this.this$0, true);
      PreDownloadScheduler.access$702(this.this$0, true);
    }
    if (((!PreDownloadScheduler.access$1000(this.this$0)) || (!PreDownloadScheduler.access$700(this.this$0))) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder("[system info]:");
      ((StringBuilder)localObject).append(",mCurFPSTime=");
      ((StringBuilder)localObject).append(PreDownloadScheduler.access$300(this.this$0));
      ((StringBuilder)localObject).append(",mCurFPS=");
      ((StringBuilder)localObject).append(PreDownloadScheduler.access$400(this.this$0));
      ((StringBuilder)localObject).append(",mCurCPU=");
      ((StringBuilder)localObject).append(PreDownloadScheduler.access$500(this.this$0));
      ((StringBuilder)localObject).append(",mFPSReadyCount=");
      ((StringBuilder)localObject).append(PreDownloadScheduler.access$800(this.this$0));
      ((StringBuilder)localObject).append(",mCPUReadyCount=");
      ((StringBuilder)localObject).append(PreDownloadScheduler.access$1300(this.this$0));
      ((StringBuilder)localObject).append(",mFPSReady=");
      ((StringBuilder)localObject).append(PreDownloadScheduler.access$700(this.this$0));
      ((StringBuilder)localObject).append(",mCPUReady=");
      ((StringBuilder)localObject).append(PreDownloadScheduler.access$1000(this.this$0));
      QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject).toString());
    }
    PreDownloadScheduler.access$1100(this.this$0).sendEmptyMessage(1005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler.1
 * JD-Core Version:    0.7.0.1
 */