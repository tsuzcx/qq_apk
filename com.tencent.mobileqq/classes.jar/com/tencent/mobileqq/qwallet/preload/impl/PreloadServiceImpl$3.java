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
    if (!paramBoolean) {}
    do
    {
      for (;;)
      {
        return;
        if (paramInt == 3) {
          try
          {
            paramBundle = (DownloadChooseRsp)paramBundle.getSerializable("rsp");
            if (paramBundle != null) {
              break label89;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("PreloadService", 2, "download choose rsp is null:" + paramBundle);
              return;
            }
          }
          catch (Throwable paramBundle) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PreloadService", 2, "downloadBackControlModules onReceive exception:" + paramBundle);
    return;
    label89:
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "download choose rsp:" + paramBundle.vecResInfo);
    }
    PreloadServiceImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadServiceImpl).update(paramBundle.vecResInfo);
    ThreadManager.post(new PreloadServiceImpl.3.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */