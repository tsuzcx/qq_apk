package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.JudgeDownloadRsp;
import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class RealTimeFlowControlObj$1
  implements BusinessObserver
{
  RealTimeFlowControlObj$1(RealTimeFlowControlObj paramRealTimeFlowControlObj, WeakReference paramWeakReference, DownloadListener paramDownloadListener) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        Object localObject1 = (PreloadServiceImpl)this.a.get();
        if (!PreloadServiceImpl.isManagerValid((PreloadServiceImpl)localObject1))
        {
          if (this.b != null) {
            this.c.a(this.b);
          }
        }
        else
        {
          if (!paramBoolean)
          {
            if (this.b != null) {
              this.c.a(this.b);
            }
            ((PreloadServiceImpl)localObject1).notifyResFlowCheckNext();
            return;
          }
          paramBundle = (JudgeDownloadRsp)paramBundle.getSerializable("rsp");
          if (paramBundle == null)
          {
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("onReceive rsp is null:");
              ((StringBuilder)???).append(paramBundle);
              QLog.d("RealTimeFlowControlObj", 2, ((StringBuilder)???).toString());
            }
            if (this.b != null) {
              this.c.a(this.b);
            }
            ((PreloadServiceImpl)localObject1).notifyResFlowCheckNext();
            return;
          }
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append(RealTimeFlowControlObj.a(this.c));
            ((StringBuilder)???).append("FlowControlRsp|");
            ((StringBuilder)???).append(paramBundle.iDownloadStatus);
            ((StringBuilder)???).append("|");
            ((StringBuilder)???).append(paramBundle.iSegTime);
            ((StringBuilder)???).append("|");
            ((StringBuilder)???).append(paramBundle.iFailedRetryMax);
            QLog.d("RealTimeFlowControlObj", 2, ((StringBuilder)???).toString());
          }
          synchronized (RealTimeFlowControlObj.b(this.c))
          {
            i = paramBundle.iDownloadStatus;
            paramInt = 60;
            PreloadFlowControlConfig localPreloadFlowControlConfig;
            if (i != 0)
            {
              if (i != 1)
              {
                RealTimeFlowControlObj.b(this.c).mDownloadStatus = 2;
                localPreloadFlowControlConfig = RealTimeFlowControlObj.b(this.c);
                if (paramBundle.iSegTime > 60) {
                  paramInt = paramBundle.iSegTime;
                }
                localPreloadFlowControlConfig.mNextCanReqTime = (paramInt * 1000 + NetConnInfoCenter.getServerTimeMillis());
              }
              else
              {
                RealTimeFlowControlObj.b(this.c).mDownloadStatus = 1;
                localPreloadFlowControlConfig = RealTimeFlowControlObj.b(this.c);
                if (paramBundle.iFailedRetryMax <= 0) {
                  break label639;
                }
                i = paramBundle.iFailedRetryMax;
                localPreloadFlowControlConfig.mRetryDownloadTimes = i;
                localPreloadFlowControlConfig = RealTimeFlowControlObj.b(this.c);
                if (paramBundle.iSegTime > 60) {
                  paramInt = paramBundle.iSegTime;
                }
                localPreloadFlowControlConfig.mValidDownloadTime = (paramInt * 1000 + NetConnInfoCenter.getServerTimeMillis());
              }
            }
            else
            {
              RealTimeFlowControlObj.b(this.c).mDownloadStatus = 0;
              localPreloadFlowControlConfig = RealTimeFlowControlObj.b(this.c);
              if (paramBundle.iSegTime > 60) {
                paramInt = paramBundle.iSegTime;
              }
              localPreloadFlowControlConfig.mNextRetryReqTime = (paramInt * 1000 + NetConnInfoCenter.getServerTimeMillis());
            }
            if (paramBundle.iDownloadStatus != 0) {
              RealTimeFlowControlObj.b(this.c).mRetryReqTimes = 0;
            }
            RealTimeFlowControlObj.b(this.c).saveConfig();
            if (paramBundle.iDownloadStatus == 2)
            {
              ((PreloadServiceImpl)localObject1).notifyResFlowCheckNext();
              if (this.b != null) {
                this.c.a(this.b);
              }
            }
            else
            {
              if (paramBundle.iDownloadStatus == 0)
              {
                this.c.a((IPreloadService)localObject1);
                return;
              }
              if (paramBundle.iDownloadStatus == 1)
              {
                this.c.a((IPreloadService)localObject1);
                return;
              }
            }
          }
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(RealTimeFlowControlObj.a(this.c));
          ((StringBuilder)localObject1).append(" startFlowControlReq onReceive exception:");
          ((StringBuilder)localObject1).append(paramBundle);
          QLog.d("RealTimeFlowControlObj", 2, ((StringBuilder)localObject1).toString());
        }
        paramBundle = this.b;
        if (paramBundle != null) {
          this.c.a(paramBundle);
        }
      }
      return;
      label639:
      int i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.RealTimeFlowControlObj.1
 * JD-Core Version:    0.7.0.1
 */