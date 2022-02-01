package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.DownloadReportReq;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

class RealTimeFlowControlObj$2
  extends DownloadListener
{
  private boolean jdField_a_of_type_Boolean = false;
  
  RealTimeFlowControlObj$2(RealTimeFlowControlObj paramRealTimeFlowControlObj, int paramInt, WeakReference paramWeakReference, DownloadListener paramDownloadListener, long paramLong) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    Object localObject = (PreloadServiceImpl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadServiceImpl.isManagerValid((PreloadServiceImpl)localObject)) {
      ((PreloadServiceImpl)localObject).notifyResFlowCheckNext();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
    if (localObject != null) {
      ((DownloadListener)localObject).onDoneFile(paramDownloadTask);
    }
    localObject = new DownloadReportReq();
    if (paramDownloadTask.jdField_a_of_type_Int == 0) {
      ((DownloadReportReq)localObject).iType = 1;
    } else {
      ((DownloadReportReq)localObject).iType = 2;
    }
    int j = -1;
    int i = j;
    if (paramDownloadTask.jdField_a_of_type_JavaUtilMap != null)
    {
      i = j;
      if (!TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString))
      {
        File localFile = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
        long l;
        if (localFile == null) {
          l = -2L;
        }
        try
        {
          if (localFile.exists()) {
            l = localFile.length();
          } else {
            l = -3L;
          }
          i = (int)l;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          i = -4;
        }
      }
    }
    ((DownloadReportReq)localObject).vecResInfo = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj.a(i);
    ((DownloadReportReq)localObject).iUin = this.jdField_a_of_type_Long;
    ((DownloadReportReq)localObject).sPhoneType = DeviceInfoUtil.i();
    ((DownloadReportReq)localObject).sOsVersion = DeviceInfoUtil.e();
    ((DownloadReportReq)localObject).sQQVersion = DeviceInfoUtil.c();
    ((DownloadReportReq)localObject).iScene = paramDownloadTask.a().getInt("scene");
    QWalletCommonServlet.a((JceStruct)localObject, null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj));
      localStringBuilder.append(" flow down result:");
      localStringBuilder.append(paramDownloadTask.jdField_a_of_type_Int);
      localStringBuilder.append(localObject);
      QLog.d("RealTimeFlowControlObj", 2, localStringBuilder.toString());
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      long l1 = System.currentTimeMillis();
      long l2 = paramDownloadTask.g;
      double d1 = paramDownloadTask.f;
      double d2 = l1 - l2;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      if (d1 < 1.0D) {
        return;
      }
      paramDownloadTask = new DownloadReportReq();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(d1);
      localStringBuilder.append("");
      paramDownloadTask.sSpeed = localStringBuilder.toString();
      paramDownloadTask.vecResInfo = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj.a(0);
      paramDownloadTask.iType = 0;
      paramDownloadTask.iUin = this.jdField_a_of_type_Long;
      QWalletCommonServlet.a(paramDownloadTask, null);
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append(RealTimeFlowControlObj.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplRealTimeFlowControlObj));
        paramDownloadTask.append(" flow down speed:");
        paramDownloadTask.append(d1);
        QLog.d("RealTimeFlowControlObj", 2, paramDownloadTask.toString());
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    paramDownloadTask.f = 1048576L;
    paramDownloadTask.b = Math.max(this.jdField_a_of_type_Int, 3);
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.RealTimeFlowControlObj.2
 * JD-Core Version:    0.7.0.1
 */