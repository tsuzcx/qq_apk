package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.JudgeDownloadRsp;
import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class PreloadResourceImpl$3
  implements BusinessObserver
{
  PreloadResourceImpl$3(PreloadResourceImpl paramPreloadResourceImpl, WeakReference paramWeakReference, DownloadListener paramDownloadListener, PreloadModuleImpl paramPreloadModuleImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        Object localObject1 = (PreloadServiceImpl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (!PreloadServiceImpl.isManagerValid((PreloadServiceImpl)localObject1)) {
          return;
        }
        if (!paramBoolean)
        {
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
            QLog.d("PreloadResource", 2, ((StringBuilder)???).toString());
          }
          ((PreloadServiceImpl)localObject1).notifyResFlowCheckNext();
          return;
        }
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.mResId);
          ((StringBuilder)???).append("FlowControlRsp|");
          ((StringBuilder)???).append(paramBundle.iDownloadStatus);
          ((StringBuilder)???).append("|");
          ((StringBuilder)???).append(paramBundle.iSegTime);
          ((StringBuilder)???).append("|");
          ((StringBuilder)???).append(paramBundle.iFailedRetryMax);
          QLog.d("PreloadResource", 2, ((StringBuilder)???).toString());
        }
        synchronized (PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl))
        {
          i = paramBundle.iDownloadStatus;
          paramInt = 60;
          PreloadFlowControlConfig localPreloadFlowControlConfig;
          if (i != 0)
          {
            if (i != 1)
            {
              PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl).mDownloadStatus = 2;
              localPreloadFlowControlConfig = PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl);
              if (paramBundle.iSegTime > 60) {
                paramInt = paramBundle.iSegTime;
              }
              localPreloadFlowControlConfig.mNextCanReqTime = (paramInt * 1000 + NetConnInfoCenter.getServerTimeMillis());
            }
            else
            {
              PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl).mDownloadStatus = 1;
              localPreloadFlowControlConfig = PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl);
              if (paramBundle.iFailedRetryMax <= 0) {
                break label589;
              }
              i = paramBundle.iFailedRetryMax;
              localPreloadFlowControlConfig.mRetryDownloadTimes = i;
              localPreloadFlowControlConfig = PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl);
              if (paramBundle.iSegTime > 60) {
                paramInt = paramBundle.iSegTime;
              }
              localPreloadFlowControlConfig.mValidDownloadTime = (paramInt * 1000 + NetConnInfoCenter.getServerTimeMillis());
            }
          }
          else
          {
            PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl).mDownloadStatus = 0;
            localPreloadFlowControlConfig = PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl);
            if (paramBundle.iSegTime > 60) {
              paramInt = paramBundle.iSegTime;
            }
            localPreloadFlowControlConfig.mNextRetryReqTime = (paramInt * 1000 + NetConnInfoCenter.getServerTimeMillis());
          }
          if (paramBundle.iDownloadStatus != 0) {
            PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl).mRetryReqTimes = 0;
          }
          PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl).saveConfig();
          if (paramBundle.iDownloadStatus == 2)
          {
            ((PreloadServiceImpl)localObject1).notifyResFlowCheckNext();
            if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.notifyListenerDownloadFailInFlowControl(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadModuleImpl, (PreloadServiceImpl)localObject1);
            }
          }
          else
          {
            if (paramBundle.iDownloadStatus == 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.handleFlowConfig((IPreloadService)localObject1, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadModuleImpl, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
              return;
            }
            if (paramBundle.iDownloadStatus == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.handleFlowConfig((IPreloadService)localObject1, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadModuleImpl, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
              return;
            }
          }
        }
        return;
      }
      catch (Throwable paramBundle)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.mResId);
          ((StringBuilder)localObject1).append(" startFlowControlReq onReceive exception:");
          ((StringBuilder)localObject1).append(paramBundle);
          QLog.d("PreloadResource", 2, ((StringBuilder)localObject1).toString());
        }
      }
      label589:
      int i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.3
 * JD-Core Version:    0.7.0.1
 */