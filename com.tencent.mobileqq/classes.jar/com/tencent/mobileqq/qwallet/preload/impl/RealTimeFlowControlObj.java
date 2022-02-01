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
  DownloadParam a;
  DownloadListener b;
  private PreloadFlowControlConfig c;
  private String d;
  
  public RealTimeFlowControlObj(DownloadParam paramDownloadParam, DownloadListener paramDownloadListener)
  {
    this.a = paramDownloadParam;
    this.b = paramDownloadListener;
  }
  
  private void a(DownloadListener paramDownloadListener, String paramString)
  {
    if (paramDownloadListener == null) {
      return;
    }
    paramString = new DownloadTask(this.a.url, new File(paramString));
    paramString.c = 0;
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
      localResInfo.sResId = this.d;
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
    ??? = PreloadStaticApi.b(this.a.url, this.a.isForceUnzip, this.a.filePos);
    Object localObject1;
    if (PreloadStaticApi.a(???, this.a))
    {
      localObject1 = this.b;
      if (localObject1 != null) {
        a((DownloadListener)localObject1, ???.filePath);
      }
      localPreloadServiceImpl.notifyResFlowCheckNext();
      return;
    }
    if (this.c == null)
    {
      this.d = localPreloadServiceImpl.getResIdByUrl(this.a.url);
      if (TextUtils.isEmpty(this.d)) {
        this.d = MD5.toMD5(this.a.url);
      }
      this.c = PreloadFlowControlConfig.getFlowControlConfig(this.d, localPreloadServiceImpl.mApp);
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append(this.d);
      ???.append("handleFlowConfig:");
      ???.append(this.c.mDownloadStatus);
      QLog.d("RealTimeFlowControlObj", 2, ???.toString());
    }
    long l1 = localPreloadServiceImpl.mApp.getLongAccountUin();
    String str1 = DeviceInfoUtil.u();
    String str2 = DeviceInfoUtil.e();
    float f1 = (float)DeviceInfoUtil.k();
    float f2 = (float)DeviceInfoUtil.l();
    int i = DeviceInfoUtil.h();
    long l2 = DeviceInfoUtil.a() / 1024L;
    Object localObject4;
    synchronized (this.c)
    {
      int j = this.c.mDownloadStatus;
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
            ((StringBuilder)localObject1).append(this.d);
            ((StringBuilder)localObject1).append(" STATUS_NOT_DOWNLOAD|");
            ((StringBuilder)localObject1).append(l3);
            ((StringBuilder)localObject1).append("|");
            localObject4 = this.c;
          }
        }
      }
      try
      {
        ((StringBuilder)localObject1).append(((PreloadFlowControlConfig)localObject4).mNextCanReqTime);
        QLog.d("RealTimeFlowControlObj", 2, ((StringBuilder)localObject1).toString());
        if (l3 > this.c.mNextCanReqTime)
        {
          a(JudgeDownloadReq.createReq(a(0), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, this.b);
        }
        else
        {
          localPreloadServiceImpl.notifyResFlowCheckNext();
          if (this.b != null) {
            a(this.b);
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
        ((StringBuilder)localObject4).append(this.d);
        ((StringBuilder)localObject4).append("STATUS_NOW_DOWNLOAD|");
        ((StringBuilder)localObject4).append(l3);
        ((StringBuilder)localObject4).append("|");
        ((StringBuilder)localObject4).append(this.c.mValidDownloadTime);
        QLog.d("RealTimeFlowControlObj", 2, ((StringBuilder)localObject4).toString());
        if (l3 < this.c.mValidDownloadTime)
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(this.d);
            ((StringBuilder)localObject4).append("begin download");
            QLog.d("RealTimeFlowControlObj", 2, ((StringBuilder)localObject4).toString());
          }
          localObject4 = this.b;
          i = this.c.mRetryDownloadTimes;
          ??? = (IPreloadService)localObject1;
          localObject1 = ???;
        }
        for (;;)
        {
          try
          {
            localObject4 = a(l1, (DownloadListener)localObject4, localPreloadServiceImpl, i);
            localObject1 = ???;
            PreloadComDownloader.a().a(this.a, (DownloadListener)localObject4, null);
            continue;
            ??? = (IPreloadService)localObject1;
            localObject1 = ???;
            a(JudgeDownloadReq.createReq(a(0), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, this.b);
            continue;
            localObject4 = ???;
            localObject1 = localObject4;
            l3 = NetConnInfoCenter.getServerTimeMillis();
            localObject1 = localObject4;
            long l4 = this.c.mNextRetryReqTime - l3;
            localObject1 = localObject4;
            if (QLog.isColorLevel())
            {
              localObject1 = localObject4;
              ??? = new StringBuilder();
              localObject1 = localObject4;
              ???.append(this.d);
              localObject1 = localObject4;
              ???.append("STATUS_WAIT_TO_REQ|");
              localObject1 = localObject4;
              ???.append(l3);
              localObject1 = localObject4;
              ???.append("|");
              localObject1 = localObject4;
              ???.append(this.c.mNextRetryReqTime);
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
              PreloadFlowControlConfig localPreloadFlowControlConfig = this.c;
              localObject1 = localObject4;
              j = localPreloadFlowControlConfig.mRetryReqTimes + 1;
              localObject1 = localObject4;
              localPreloadFlowControlConfig.mRetryReqTimes = j;
              localObject1 = localObject4;
              a(JudgeDownloadReq.createReq(???, l1, j, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, this.b);
              ??? = (IPreloadService)localObject4;
            }
            else
            {
              localObject1 = localObject4;
              localPreloadServiceImpl.notifyResFlowCheckNext();
              ??? = (IPreloadService)localObject4;
              localObject1 = localObject4;
              if (this.b != null)
              {
                localObject1 = localObject4;
                a(this.b);
                ??? = (IPreloadService)localObject4;
                continue;
                localObject1 = ???;
                a(JudgeDownloadReq.createReq(a(0), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, this.b);
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
    Object localObject = this.a.url;
    localObject = new DownloadTask((String)localObject, new File(PreloadStaticApi.b((String)localObject, this.a.filePos)));
    ((DownloadTask)localObject).c = -5;
    paramDownloadListener.onDoneFile((DownloadTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.RealTimeFlowControlObj
 * JD-Core Version:    0.7.0.1
 */