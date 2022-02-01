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
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle arg3)
  {
    int i = 60;
    PreloadServiceImpl localPreloadServiceImpl;
    label137:
    JudgeDownloadRsp localJudgeDownloadRsp;
    if (paramInt == 1)
    {
      try
      {
        localPreloadServiceImpl = (PreloadServiceImpl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (!PreloadServiceImpl.isManagerValid(localPreloadServiceImpl))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener == null) {
            break label622;
          }
          this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
          return;
        }
        if (paramBoolean) {
          break label137;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
        }
        localPreloadServiceImpl.notifyResFlowCheckNext();
        return;
      }
      catch (Throwable ???)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RealTimeFlowControlObj", 2, RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj) + " startFlowControlReq onReceive exception:" + ???);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener == null) {
          break label622;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
      return;
      localJudgeDownloadRsp = (JudgeDownloadRsp)???.getSerializable("rsp");
      if (localJudgeDownloadRsp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RealTimeFlowControlObj", 2, "onReceive rsp is null:" + localJudgeDownloadRsp);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
        }
        localPreloadServiceImpl.notifyResFlowCheckNext();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RealTimeFlowControlObj", 2, RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj) + "FlowControlRsp|" + localJudgeDownloadRsp.iDownloadStatus + "|" + localJudgeDownloadRsp.iSegTime + "|" + localJudgeDownloadRsp.iFailedRetryMax);
      }
    }
    for (;;)
    {
      synchronized (RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj))
      {
        switch (localJudgeDownloadRsp.iDownloadStatus)
        {
        case 1: 
          RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj).mDownloadStatus = 2;
          localPreloadFlowControlConfig = RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj);
          if (localJudgeDownloadRsp.iSegTime > 60) {
            i = localJudgeDownloadRsp.iSegTime;
          }
          localPreloadFlowControlConfig.mNextCanReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
          if (localJudgeDownloadRsp.iDownloadStatus != 0) {
            RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj).mRetryReqTimes = 0;
          }
          RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj).saveConfig();
          if (localJudgeDownloadRsp.iDownloadStatus != 2) {
            break label586;
          }
          localPreloadServiceImpl.notifyResFlowCheckNext();
          if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener == null) {
            break label622;
          }
          this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
          return;
          RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj).mDownloadStatus = 1;
          localPreloadFlowControlConfig = RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj);
          if (localJudgeDownloadRsp.iFailedRetryMax > 0)
          {
            paramInt = localJudgeDownloadRsp.iFailedRetryMax;
            localPreloadFlowControlConfig.mRetryDownloadTimes = paramInt;
            localPreloadFlowControlConfig = RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj);
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
      RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj).mDownloadStatus = 0;
      PreloadFlowControlConfig localPreloadFlowControlConfig = RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj);
      if (localJudgeDownloadRsp.iSegTime > 60) {
        i = localJudgeDownloadRsp.iSegTime;
      }
      localPreloadFlowControlConfig.mNextRetryReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
      continue;
      label586:
      if (localJudgeDownloadRsp.iDownloadStatus == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj.a(localIPreloadService);
        return;
      }
      if (localJudgeDownloadRsp.iDownloadStatus == 1) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj.a(localIPreloadService);
      }
      label622:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.RealTimeFlowControlObj.1
 * JD-Core Version:    0.7.0.1
 */