package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.DownloadReportReq;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

class PreloadResourceImpl$2
  extends DownloadListener
{
  private boolean jdField_a_of_type_Boolean = false;
  
  PreloadResourceImpl$2(PreloadResourceImpl paramPreloadResourceImpl, int paramInt, WeakReference paramWeakReference, DownloadListener paramDownloadListener, long paramLong) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    Object localObject = (PreloadServiceImpl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadServiceImpl.isManagerValid((PreloadServiceImpl)localObject)) {
      ((PreloadServiceImpl)localObject).notifyResFlowCheckNext();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener.onDoneFile(paramDownloadTask);
    }
    localObject = new DownloadReportReq();
    int i;
    File localFile;
    long l;
    if (paramDownloadTask.jdField_a_of_type_Int == 0)
    {
      ((DownloadReportReq)localObject).iType = 1;
      int j = -1;
      i = j;
      if (paramDownloadTask.jdField_a_of_type_JavaUtilMap != null)
      {
        i = j;
        if (!TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString))
        {
          localFile = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
          if (localFile != null) {
            break label242;
          }
          l = -2L;
          label113:
          i = (int)l;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        ((DownloadReportReq)localObject).vecResInfo = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.getMyResInfos(i);
        ((DownloadReportReq)localObject).iUin = this.jdField_a_of_type_Long;
        ((DownloadReportReq)localObject).sPhoneType = DeviceInfoUtil.i();
        ((DownloadReportReq)localObject).sOsVersion = DeviceInfoUtil.e();
        ((DownloadReportReq)localObject).sQQVersion = DeviceInfoUtil.c();
        ((DownloadReportReq)localObject).iScene = paramDownloadTask.a().getInt("scene");
        QWalletCommonServlet.a((JceStruct)localObject, null);
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.mResId + " flow down result:" + paramDownloadTask.jdField_a_of_type_Int + localObject);
        }
        return;
        ((DownloadReportReq)localObject).iType = 2;
        break;
        try
        {
          label242:
          if (localFile.exists())
          {
            l = localFile.length();
            break label113;
          }
          l = -3L;
        }
        catch (Throwable localThrowable)
        {
          i = -4;
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    double d;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      long l1 = System.currentTimeMillis();
      long l2 = paramDownloadTask.g;
      d = paramDownloadTask.f / (l1 - l2);
      if (d >= 1.0D) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      paramDownloadTask = new DownloadReportReq();
      paramDownloadTask.sSpeed = (d + "");
      paramDownloadTask.vecResInfo = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.getMyResInfos();
      paramDownloadTask.iType = 0;
      paramDownloadTask.iUin = this.jdField_a_of_type_Long;
      QWalletCommonServlet.a(paramDownloadTask, null);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl.mResId + " flow down speed:" + d);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    int i = 3;
    paramDownloadTask.f = 1048576L;
    if (this.jdField_a_of_type_Int > 3) {
      i = this.jdField_a_of_type_Int;
    }
    paramDownloadTask.b = i;
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.2
 * JD-Core Version:    0.7.0.1
 */