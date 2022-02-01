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
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle arg3)
  {
    int i = 60;
    PreloadServiceImpl localPreloadServiceImpl;
    label83:
    JudgeDownloadRsp localJudgeDownloadRsp;
    if (paramInt == 1)
    {
      try
      {
        localPreloadServiceImpl = (PreloadServiceImpl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (!PreloadServiceImpl.isManagerValid(localPreloadServiceImpl)) {
          return;
        }
        if (paramBoolean) {
          break label83;
        }
        localPreloadServiceImpl.notifyResFlowCheckNext();
        return;
      }
      catch (Throwable ???)
      {
        if (!QLog.isColorLevel()) {
          break label572;
        }
      }
      QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.mResId + " startFlowControlReq onReceive exception:" + ???);
      return;
      localJudgeDownloadRsp = (JudgeDownloadRsp)???.getSerializable("rsp");
      if (localJudgeDownloadRsp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, "onReceive rsp is null:" + localJudgeDownloadRsp);
        }
        localPreloadServiceImpl.notifyResFlowCheckNext();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.mResId + "FlowControlRsp|" + localJudgeDownloadRsp.iDownloadStatus + "|" + localJudgeDownloadRsp.iSegTime + "|" + localJudgeDownloadRsp.iFailedRetryMax);
      }
    }
    for (;;)
    {
      synchronized (PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl))
      {
        switch (localJudgeDownloadRsp.iDownloadStatus)
        {
        case 1: 
          PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl).mDownloadStatus = 2;
          localPreloadFlowControlConfig = PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl);
          if (localJudgeDownloadRsp.iSegTime > 60) {
            i = localJudgeDownloadRsp.iSegTime;
          }
          localPreloadFlowControlConfig.mNextCanReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
          if (localJudgeDownloadRsp.iDownloadStatus != 0) {
            PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl).mRetryReqTimes = 0;
          }
          PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl).saveConfig();
          if (localJudgeDownloadRsp.iDownloadStatus != 2) {
            break label520;
          }
          localPreloadServiceImpl.notifyResFlowCheckNext();
          if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener == null) {
            break label572;
          }
          this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.notifyListenerDownloadFailInFlowControl(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadModuleImpl, localPreloadServiceImpl);
          return;
          PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl).mDownloadStatus = 1;
          localPreloadFlowControlConfig = PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl);
          if (localJudgeDownloadRsp.iFailedRetryMax > 0)
          {
            paramInt = localJudgeDownloadRsp.iFailedRetryMax;
            localPreloadFlowControlConfig.mRetryDownloadTimes = paramInt;
            localPreloadFlowControlConfig = PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl);
            if (localJudgeDownloadRsp.iSegTime > 60) {
              i = localJudgeDownloadRsp.iSegTime;
            }
            localPreloadFlowControlConfig.mValidDownloadTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
          }
          break;
        }
      }
      paramInt = 3;
      continue;
      PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl).mDownloadStatus = 0;
      PreloadFlowControlConfig localPreloadFlowControlConfig = PreloadResourceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl);
      if (localJudgeDownloadRsp.iSegTime > 60) {
        i = localJudgeDownloadRsp.iSegTime;
      }
      localPreloadFlowControlConfig.mNextRetryReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
      continue;
      label520:
      if (localJudgeDownloadRsp.iDownloadStatus == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.handleFlowConfig(localIPreloadService, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadModuleImpl, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
        return;
      }
      if (localJudgeDownloadRsp.iDownloadStatus == 1) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.handleFlowConfig(localIPreloadService, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadModuleImpl, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
      }
      label572:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.3
 * JD-Core Version:    0.7.0.1
 */