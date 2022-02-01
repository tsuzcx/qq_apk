package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.DownloadChooseRsp;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.BusinessObserver;

class PreloadServiceImpl$3
  implements BusinessObserver
{
  PreloadServiceImpl$3(PreloadServiceImpl paramPreloadServiceImpl, List paramList, DownloadListener paramDownloadListener, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramInt == 3) {
      try
      {
        paramBundle = (DownloadChooseRsp)paramBundle.getSerializable("rsp");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("download choose rsp is null:");
          localStringBuilder.append(paramBundle);
          QLog.d("PreloadService", 2, localStringBuilder.toString());
          return;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("download choose rsp:");
          localStringBuilder.append(paramBundle.vecResInfo);
          QLog.d("PreloadService", 2, localStringBuilder.toString());
        }
        PreloadServiceImpl.access$000(this.d).update(paramBundle.vecResInfo);
        ThreadManager.post(new PreloadServiceImpl.3.1(this), 5, null, true);
        return;
      }
      catch (Throwable paramBundle)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadBackControlModules onReceive exception:");
          localStringBuilder.append(paramBundle);
          QLog.d("PreloadService", 2, localStringBuilder.toString());
        }
      }
    } else {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */