package com.tencent.mobileqq.transfile.predownload.schedule;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.ProcessStats;
import com.tencent.qqperf.tools.ProcessStats.Stats;

class PreDownloadScheduler$1
  implements FPSCalculator.GetFPSListener
{
  PreDownloadScheduler$1(PreDownloadScheduler paramPreDownloadScheduler) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (!PreDownloadScheduler.access$100(this.this$0)) {
      return;
    }
    if (!PreDownloadScheduler.access$200(this.this$0))
    {
      PreDownloadScheduler.access$302(this.this$0, paramLong);
      PreDownloadScheduler.access$402(this.this$0, paramDouble);
      PreDownloadScheduler.access$502(this.this$0, ProcessStats.a.a);
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
        if (PreDownloadScheduler.access$500(this.this$0) >= PreDownloadScheduler.access$1200(this.this$0)) {
          break label502;
        }
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
    }
    for (;;)
    {
      Object localObject;
      if (((!PreDownloadScheduler.access$1000(this.this$0)) || (!PreDownloadScheduler.access$700(this.this$0))) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder("[system info]:");
        ((StringBuilder)localObject).append(",mCurFPSTime=").append(PreDownloadScheduler.access$300(this.this$0));
        ((StringBuilder)localObject).append(",mCurFPS=").append(PreDownloadScheduler.access$400(this.this$0));
        ((StringBuilder)localObject).append(",mCurCPU=").append(PreDownloadScheduler.access$500(this.this$0));
        ((StringBuilder)localObject).append(",mFPSReadyCount=").append(PreDownloadScheduler.access$800(this.this$0));
        ((StringBuilder)localObject).append(",mCPUReadyCount=").append(PreDownloadScheduler.access$1300(this.this$0));
        ((StringBuilder)localObject).append(",mFPSReady=").append(PreDownloadScheduler.access$700(this.this$0));
        ((StringBuilder)localObject).append(",mCPUReady=").append(PreDownloadScheduler.access$1000(this.this$0));
        QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject).toString());
      }
      PreDownloadScheduler.access$1100(this.this$0).sendEmptyMessage(1005);
      return;
      Bundle localBundle;
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
      break;
      label502:
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
      continue;
      PreDownloadScheduler.access$1002(this.this$0, true);
      PreDownloadScheduler.access$702(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler.1
 * JD-Core Version:    0.7.0.1
 */