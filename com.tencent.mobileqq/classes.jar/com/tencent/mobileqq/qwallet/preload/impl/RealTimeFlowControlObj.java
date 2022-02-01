package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.JudgeDownloadReq;
import Wallet.ResInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
      localArrayList.add(localResInfo);
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void a(JudgeDownloadReq paramJudgeDownloadReq, PreloadServiceImpl paramPreloadServiceImpl, DownloadListener paramDownloadListener)
  {
    QWalletCommonServlet.a(paramJudgeDownloadReq, new RealTimeFlowControlObj.1(this, new WeakReference(paramPreloadServiceImpl), paramDownloadListener), 1);
  }
  
  public void a(IPreloadService arg1)
  {
    PreloadServiceImpl localPreloadServiceImpl1 = (PreloadServiceImpl)???;
    ??? = PreloadStaticApi.a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.url, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.isForceUnzip, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.filePos);
    if (PreloadStaticApi.a(???, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, ???.filePath);
      }
      localPreloadServiceImpl1.notifyResFlowCheckNext();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig == null)
    {
      this.jdField_a_of_type_JavaLangString = localPreloadServiceImpl1.getResIdByUrl(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.url);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.url);
      }
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig = PreloadFlowControlConfig.getFlowControlConfig(this.jdField_a_of_type_JavaLangString, localPreloadServiceImpl1.mApp);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RealTimeFlowControlObj", 2, this.jdField_a_of_type_JavaLangString + "handleFlowConfig:" + this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mDownloadStatus);
    }
    long l1 = localPreloadServiceImpl1.mApp.getLongAccountUin();
    String str1 = DeviceInfoUtil.i();
    String str2 = DeviceInfoUtil.c();
    float f1 = (float)DeviceInfoUtil.b();
    float f2 = (float)DeviceInfoUtil.c();
    int i = DeviceInfoUtil.b();
    long l2 = DeviceInfoUtil.a() / 1024L;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig)
      {
        switch (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mDownloadStatus)
        {
        case -1: 
          localPreloadServiceImpl1.notifyResFlowCheckNext();
          return;
        }
      }
      a(JudgeDownloadReq.createReq(a(0), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl2, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
      continue;
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("RealTimeFlowControlObj", 2, this.jdField_a_of_type_JavaLangString + "STATUS_NOW_DOWNLOAD|" + l3 + "|" + this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mValidDownloadTime);
      }
      DownloadListener localDownloadListener;
      if (l3 < this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mValidDownloadTime)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RealTimeFlowControlObj", 2, this.jdField_a_of_type_JavaLangString + "begin download");
        }
        localDownloadListener = a(l1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localPreloadServiceImpl2, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mRetryDownloadTimes);
        PreloadComDownloader.a().a(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam, localDownloadListener, null);
      }
      else
      {
        a(JudgeDownloadReq.createReq(a(0), l1, 0, str1, str2, f1, f2, i, l2), localDownloadListener, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
        continue;
        l3 = NetConnInfoCenter.getServerTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("RealTimeFlowControlObj", 2, this.jdField_a_of_type_JavaLangString + " STATUS_NOT_DOWNLOAD|" + l3 + "|" + this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mNextCanReqTime);
        }
        if (l3 > this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mNextCanReqTime)
        {
          a(JudgeDownloadReq.createReq(a(0), l1, 0, str1, str2, f1, f2, i, l2), localDownloadListener, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
        }
        else
        {
          localDownloadListener.notifyResFlowCheckNext();
          if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener != null)
          {
            a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
            continue;
            l3 = NetConnInfoCenter.getServerTimeMillis();
            long l4 = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mNextRetryReqTime - l3;
            if (QLog.isColorLevel()) {
              QLog.d("RealTimeFlowControlObj", 2, this.jdField_a_of_type_JavaLangString + "STATUS_WAIT_TO_REQ|" + l3 + "|" + this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mNextRetryReqTime + "|" + l4);
            }
            if (l4 <= 0L)
            {
              ArrayList localArrayList = a(0);
              PreloadFlowControlConfig localPreloadFlowControlConfig = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig;
              int j = localPreloadFlowControlConfig.mRetryReqTimes + 1;
              localPreloadFlowControlConfig.mRetryReqTimes = j;
              a(JudgeDownloadReq.createReq(localArrayList, l1, j, str1, str2, f1, f2, i, l2), localDownloadListener, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
            }
            else
            {
              localDownloadListener.notifyResFlowCheckNext();
              if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener != null) {
                a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
              }
            }
          }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.RealTimeFlowControlObj
 * JD-Core Version:    0.7.0.1
 */