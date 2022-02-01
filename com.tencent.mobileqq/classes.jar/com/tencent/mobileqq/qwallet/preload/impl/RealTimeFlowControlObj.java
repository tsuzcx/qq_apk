package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.JudgeDownloadReq;
import Wallet.ResInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.FlowControlObj;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class RealTimeFlowControlObj
  extends IPreloadService.FlowControlObj
{
  DownloadParam jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam;
  private PreloadFlowControlConfig jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  private String jdField_a_of_type_JavaLangString;
  
  public RealTimeFlowControlObj(DownloadParam paramDownloadParam, DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam = paramDownloadParam;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = paramDownloadListener;
  }
  
  private void a(DownloadListener paramDownloadListener, String paramString)
  {
    if (paramDownloadListener == null) {
      return;
    }
    paramString = new DownloadTask(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.url, new File(paramString));
    paramString.a = 0;
    paramDownloadListener.onDoneFile(paramString);
  }
  
  public DownloadListener a(long paramLong, DownloadListener paramDownloadListener, PreloadServiceImpl paramPreloadServiceImpl, int paramInt)
  {
    return new RealTimeFlowControlObj.2(this, paramInt, new WeakReference(paramPreloadServiceImpl), paramDownloadListener, paramLong);
  }
  
  public ArrayList<ResInfo> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ResInfo localResInfo = new ResInfo();
    try
    {
      localResInfo.sResId = this.jdField_a_of_type_JavaLangString;
      localResInfo.iSize = paramInt;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    localArrayList.add(localResInfo);
    return localArrayList;
  }
  
  public void a(JudgeDownloadReq paramJudgeDownloadReq, PreloadServiceImpl paramPreloadServiceImpl, DownloadListener paramDownloadListener)
  {
    QWalletCommonServlet.a(paramJudgeDownloadReq, new RealTimeFlowControlObj.1(this, new WeakReference(paramPreloadServiceImpl), paramDownloadListener), 1);
  }
  
  public void a(IPreloadService arg1)
  {
    PreloadServiceImpl localPreloadServiceImpl = (PreloadServiceImpl)???;
    ??? = PreloadStaticApi.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.url, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.isForceUnzip, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.filePos);
    Object localObject1;
    if (PreloadStaticApi.a(???, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
      if (localObject1 != null) {
        a((DownloadListener)localObject1, ???.filePath);
      }
      localPreloadServiceImpl.notifyResFlowCheckNext();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig == null)
    {
      this.jdField_a_of_type_JavaLangString = localPreloadServiceImpl.getResIdByUrl(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.url);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.url);
      }
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig = PreloadFlowControlConfig.getFlowControlConfig(this.jdField_a_of_type_JavaLangString, localPreloadServiceImpl.mApp);
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append(this.jdField_a_of_type_JavaLangString);
      ???.append("handleFlowConfig:");
      ???.append(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mDownloadStatus);
      QLog.d("RealTimeFlowControlObj", 2, ???.toString());
    }
    long l1 = localPreloadServiceImpl.mApp.getLongAccountUin();
    String str1 = DeviceInfoUtil.i();
    String str2 = DeviceInfoUtil.c();
    float f1 = (float)DeviceInfoUtil.b();
    float f2 = (float)DeviceInfoUtil.c();
    int i = DeviceInfoUtil.b();
    long l2 = DeviceInfoUtil.a() / 1024L;
    Object localObject4;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mDownloadStatus;
      if (j != -1) {
        if (j != 0) {
          if (j != 1)
          {
            if (j != 2)
            {
              localPreloadServiceImpl.notifyResFlowCheckNext();
              break label978;
            }
            l3 = NetConnInfoCenter.getServerTimeMillis();
            if (!QLog.isColorLevel()) {
              break label1001;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject1).append(" STATUS_NOT_DOWNLOAD|");
            ((StringBuilder)localObject1).append(l3);
            ((StringBuilder)localObject1).append("|");
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig;
          }
        }
      }
      try
      {
        ((StringBuilder)localObject1).append(((PreloadFlowControlConfig)localObject4).mNextCanReqTime);
        QLog.d("RealTimeFlowControlObj", 2, ((StringBuilder)localObject1).toString());
        if (l3 > this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mNextCanReqTime)
        {
          a(JudgeDownloadReq.createReq(a(0), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
        }
        else
        {
          localPreloadServiceImpl.notifyResFlowCheckNext();
          if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener != null) {
            a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
          }
        }
      }
      finally
      {
        for (;;)
        {
          label978:
          label1001:
          localObject4 = ???;
          ??? = localObject2;
        }
      }
      localObject1 = ???;
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject4).append("STATUS_NOW_DOWNLOAD|");
        ((StringBuilder)localObject4).append(l3);
        ((StringBuilder)localObject4).append("|");
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mValidDownloadTime);
        QLog.d("RealTimeFlowControlObj", 2, ((StringBuilder)localObject4).toString());
        if (l3 < this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mValidDownloadTime)
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject4).append("begin download");
            QLog.d("RealTimeFlowControlObj", 2, ((StringBuilder)localObject4).toString());
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
          i = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mRetryDownloadTimes;
          ??? = (IPreloadService)localObject1;
          localObject1 = ???;
        }
        for (;;)
        {
          try
          {
            localObject4 = a(l1, (DownloadListener)localObject4, localPreloadServiceImpl, i);
            localObject1 = ???;
            PreloadComDownloader.a().a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam, (DownloadListener)localObject4, null);
            continue;
            ??? = (IPreloadService)localObject1;
            localObject1 = ???;
            a(JudgeDownloadReq.createReq(a(0), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
            continue;
            localObject4 = ???;
            localObject1 = localObject4;
            l3 = NetConnInfoCenter.getServerTimeMillis();
            localObject1 = localObject4;
            long l4 = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mNextRetryReqTime - l3;
            localObject1 = localObject4;
            if (QLog.isColorLevel())
            {
              localObject1 = localObject4;
              ??? = new StringBuilder();
              localObject1 = localObject4;
              ???.append(this.jdField_a_of_type_JavaLangString);
              localObject1 = localObject4;
              ???.append("STATUS_WAIT_TO_REQ|");
              localObject1 = localObject4;
              ???.append(l3);
              localObject1 = localObject4;
              ???.append("|");
              localObject1 = localObject4;
              ???.append(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mNextRetryReqTime);
              localObject1 = localObject4;
              ???.append("|");
              localObject1 = localObject4;
              ???.append(l4);
              localObject1 = localObject4;
              QLog.d("RealTimeFlowControlObj", 2, ???.toString());
            }
            if (l4 <= 0L)
            {
              localObject1 = localObject4;
              ??? = a(0);
              localObject1 = localObject4;
              PreloadFlowControlConfig localPreloadFlowControlConfig = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig;
              localObject1 = localObject4;
              j = localPreloadFlowControlConfig.mRetryReqTimes + 1;
              localObject1 = localObject4;
              localPreloadFlowControlConfig.mRetryReqTimes = j;
              localObject1 = localObject4;
              a(JudgeDownloadReq.createReq(???, l1, j, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
              ??? = (IPreloadService)localObject4;
            }
            else
            {
              localObject1 = localObject4;
              localPreloadServiceImpl.notifyResFlowCheckNext();
              ??? = (IPreloadService)localObject4;
              localObject1 = localObject4;
              if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener != null)
              {
                localObject1 = localObject4;
                a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
                ??? = (IPreloadService)localObject4;
                continue;
                localObject1 = ???;
                a(JudgeDownloadReq.createReq(a(0), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
              }
            }
            localObject1 = ???;
            return;
          }
          finally
          {
            localObject4 = localObject1;
            continue;
          }
          localObject1 = localObject4;
          throw ???;
          break;
        }
      }
    }
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    if (paramDownloadListener == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.url;
    localObject = new DownloadTask((String)localObject, new File(PreloadStaticApi.b((String)localObject, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.filePos)));
    ((DownloadTask)localObject).a = -5;
    paramDownloadListener.onDoneFile((DownloadTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.RealTimeFlowControlObj
 * JD-Core Version:    0.7.0.1
 */