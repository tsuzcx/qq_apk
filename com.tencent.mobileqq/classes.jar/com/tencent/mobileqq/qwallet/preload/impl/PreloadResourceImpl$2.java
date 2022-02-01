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

class PreloadResourceImpl$2
  extends DownloadListener
{
  private boolean f = false;
  
  PreloadResourceImpl$2(PreloadResourceImpl paramPreloadResourceImpl, int paramInt, WeakReference paramWeakReference, DownloadListener paramDownloadListener, long paramLong) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    Object localObject = (PreloadServiceImpl)this.b.get();
    if (PreloadServiceImpl.isManagerValid((PreloadServiceImpl)localObject)) {
      ((PreloadServiceImpl)localObject).notifyResFlowCheckNext();
    }
    localObject = this.c;
    if (localObject != null) {
      ((DownloadListener)localObject).onDoneFile(paramDownloadTask);
    }
    localObject = new DownloadReportReq();
    if (paramDownloadTask.c == 0) {
      ((DownloadReportReq)localObject).iType = 1;
    } else {
      ((DownloadReportReq)localObject).iType = 2;
    }
    int j = -1;
    int i = j;
    if (paramDownloadTask.g != null)
    {
      i = j;
      if (!TextUtils.isEmpty(paramDownloadTask.b))
      {
        File localFile = (File)paramDownloadTask.g.get(paramDownloadTask.b);
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
    ((DownloadReportReq)localObject).vecResInfo = this.e.getMyResInfos(i);
    ((DownloadReportReq)localObject).iUin = this.d;
    ((DownloadReportReq)localObject).sPhoneType = DeviceInfoUtil.u();
    ((DownloadReportReq)localObject).sOsVersion = DeviceInfoUtil.g();
    ((DownloadReportReq)localObject).sQQVersion = DeviceInfoUtil.e();
    ((DownloadReportReq)localObject).iScene = paramDownloadTask.b().getInt("scene");
    QWalletCommonServlet.a((JceStruct)localObject, null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e.mResId);
      localStringBuilder.append(" flow down result:");
      localStringBuilder.append(paramDownloadTask.c);
      localStringBuilder.append(localObject);
      QLog.d("PreloadResource", 2, localStringBuilder.toString());
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (!this.f)
    {
      this.f = true;
      long l1 = System.currentTimeMillis();
      long l2 = paramDownloadTask.A;
      double d1 = paramDownloadTask.z;
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
      paramDownloadTask.vecResInfo = this.e.getMyResInfos();
      paramDownloadTask.iType = 0;
      paramDownloadTask.iUin = this.d;
      QWalletCommonServlet.a(paramDownloadTask, null);
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append(this.e.mResId);
        paramDownloadTask.append(" flow down speed:");
        paramDownloadTask.append(d1);
        QLog.d("PreloadResource", 2, paramDownloadTask.toString());
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    paramDownloadTask.z = 1048576L;
    int i = this.a;
    if (i <= 3) {
      i = 3;
    }
    paramDownloadTask.e = i;
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.2
 * JD-Core Version:    0.7.0.1
 */