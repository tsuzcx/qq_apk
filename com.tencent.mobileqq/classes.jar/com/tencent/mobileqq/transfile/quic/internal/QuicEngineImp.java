package com.tencent.mobileqq.transfile.quic.internal;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.quic.open.ILoadSo;
import com.tencent.mobileqq.transfile.quic.open.ILoadSoCallback;
import com.tencent.mobileqq.transfile.quic.open.IQuicEngine;
import com.tencent.mobileqq.transfile.quic.open.QuicReq;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport.Stats;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuicEngineImp
  implements ILoadSoCallback, IQuicEngine
{
  private static final int SO_LOADED = 2;
  private static final int SO_LOADING = 1;
  private static final String TAG = "QuicEngineImp";
  public static QuicNetReport.Stats sLastStats;
  private ILoadSo mILoadSo;
  private List<QuicReq> mReqWaitingList = new ArrayList();
  private volatile int mSoLoadStatus;
  
  public QuicEngineImp() {}
  
  public QuicEngineImp(ILoadSo paramILoadSo)
  {
    this.mILoadSo = paramILoadSo;
  }
  
  private void addToThreadPoll(QuicReq paramQuicReq)
  {
    paramQuicReq.mExcuteTime = System.currentTimeMillis();
    ThreadManagerV2.excute(new QuicEngineImp.1(this, paramQuicReq), 128, null, false);
  }
  
  private void callbackWatingReqFail()
  {
    Object localObject = this.mReqWaitingList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QuicReq localQuicReq = (QuicReq)((Iterator)localObject).next();
        DownloadListener localDownloadListener = localQuicReq.mDownloadListener;
        if (localDownloadListener != null)
        {
          QuicNetReport localQuicNetReport = new QuicNetReport();
          localQuicNetReport.channel = "quic";
          localQuicNetReport.tempPath = localQuicReq.mTempPath;
          localQuicNetReport.savePath = localQuicReq.mSavePath;
          localQuicNetReport.id = localQuicNetReport.tempPath.hashCode();
          localQuicNetReport.url = localQuicReq.mPath;
          localQuicNetReport.ip = localQuicReq.mIp;
          localQuicNetReport.errMsg = "so load fail";
          localQuicNetReport.port = localQuicReq.mPort;
          localQuicNetReport.isIpv6 = localQuicReq.mIsIpv6;
          localQuicNetReport.rttHost = localQuicReq.mRttHost;
          localQuicNetReport.businessId = localQuicReq.mBussinessId;
          localQuicNetReport.timeOut = localQuicReq.mTimeOut;
          localQuicNetReport.failReason = 10;
          localDownloadListener.onDownloadFailed(localQuicReq.mPath, localQuicNetReport);
        }
      }
      this.mReqWaitingList.clear();
    }
  }
  
  private void doQuicTask(QuicReq paramQuicReq)
  {
    Object localObject1 = paramQuicReq.mSavePath;
    String str1 = paramQuicReq.mPath;
    String str2 = Task.getTempPath(paramQuicReq.mTempPath, (String)localObject1, str1);
    if (TextUtils.isEmpty(str2)) {
      return;
    }
    if (QuicDownloadRunnable.isExistTaskAddIfNeed(str2))
    {
      QLog.d("quic", 4, "task is running.");
      taskDownloadingCallback(paramQuicReq, (String)localObject1, str1, str2);
      return;
    }
    long l = paramQuicReq.mExcuteTime;
    Object localObject2 = paramQuicReq.mDownloadListener;
    if ((localObject2 != null) && (((DownloadListener)localObject2).isCanceled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("quic", 4, "task is canceled.");
      }
      QuicDownloadRunnable.removeRunningTask(str2);
      taskCanceledCallback(paramQuicReq, (String)localObject1, str1, str2);
      return;
    }
    QuicDownloadRunnable localQuicDownloadRunnable = new QuicDownloadRunnable();
    try
    {
      localObject2 = new QuicDownloadTask(localQuicDownloadRunnable, str1, (String)localObject1, str2, paramQuicReq.mHeaders, (DownloadListener)localObject2);
      ((QuicDownloadTask)localObject2).initDownloadFile();
      if (l > 0L) {
        ((QuicDownloadTask)localObject2).report.waitCost = (System.currentTimeMillis() - l);
      }
      ((QuicDownloadTask)localObject2).report.ip = paramQuicReq.mIp;
      ((QuicDownloadTask)localObject2).report.port = paramQuicReq.mPort;
      ((QuicDownloadTask)localObject2).report.isIpv6 = paramQuicReq.mIsIpv6;
      ((QuicDownloadTask)localObject2).report.rttHost = paramQuicReq.mRttHost;
      ((QuicDownloadTask)localObject2).report.businessId = paramQuicReq.mBussinessId;
      ((QuicDownloadTask)localObject2).report.timeOut = paramQuicReq.mTimeOut;
      ((QuicDownloadTask)localObject2).timeOut = paramQuicReq.mTimeOut;
      try
      {
        if (sLastStats != null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("report stats: ");
            ((StringBuilder)localObject1).append(sLastStats.toString());
            QLog.d("quic", 2, ((StringBuilder)localObject1).toString());
          }
          ((QuicDownloadTask)localObject2).report.lastStats = sLastStats;
          sLastStats = null;
        }
        ((QuicDownloadTask)localObject2).encryption = paramQuicReq.mIsQuicEncryption;
        ((QuicDownloadTask)localObject2).fec = paramQuicReq.mFec;
        localQuicDownloadRunnable.enqueue((QuicDownloadTask)localObject2);
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      QuicDownloadRunnable.removeRunningTask(str2);
      taskFailedCallback(paramQuicReq, (String)localObject1, str1, str2, 2, localException.getMessage());
    }
  }
  
  private void executeWatingReq()
  {
    Object localObject = this.mReqWaitingList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        addToThreadPoll((QuicReq)((Iterator)localObject).next());
      }
      this.mReqWaitingList.clear();
    }
  }
  
  public static QuicNetReport.Stats saveNetStats(QuicNetReport paramQuicNetReport)
  {
    QuicNetReport.Stats localStats = QuicNetReport.convertJsontoStats(paramQuicNetReport.extra);
    if (localStats != null)
    {
      if ((paramQuicNetReport.srvMessage != null) && (paramQuicNetReport.srvMessage.length > 0))
      {
        int i = paramQuicNetReport.srvMessage.length;
        localStats.mSrvMessage = new byte[i];
        System.arraycopy(paramQuicNetReport.srvMessage, 0, localStats.mSrvMessage, 0, i);
      }
      if (localStats.isValid()) {
        try
        {
          sLastStats = localStats;
          if (QLog.isColorLevel()) {
            QLog.d("quic", 4, localStats.toString());
          }
          return localStats;
        }
        finally {}
      }
    }
    return null;
  }
  
  private void taskCanceledCallback(QuicReq paramQuicReq, String paramString1, String paramString2, String paramString3)
  {
    taskFailedCallback(paramQuicReq, paramString1, paramString2, paramString3, 9);
  }
  
  private void taskDownloadingCallback(QuicReq paramQuicReq, String paramString1, String paramString2, String paramString3)
  {
    taskFailedCallback(paramQuicReq, paramString1, paramString2, paramString3, 8);
  }
  
  private void taskFailedCallback(QuicReq paramQuicReq, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    taskFailedCallback(paramQuicReq, paramString1, paramString2, paramString3, paramInt, "");
  }
  
  private void taskFailedCallback(QuicReq paramQuicReq, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    DownloadListener localDownloadListener = paramQuicReq.mDownloadListener;
    if (localDownloadListener != null)
    {
      QuicNetReport localQuicNetReport = new QuicNetReport();
      localQuicNetReport.channel = "quic";
      localQuicNetReport.tempPath = paramString3;
      localQuicNetReport.savePath = paramString1;
      localQuicNetReport.id = localQuicNetReport.tempPath.hashCode();
      localQuicNetReport.url = paramString2;
      localQuicNetReport.ip = paramQuicReq.mIp;
      localQuicNetReport.errMsg = paramString4;
      localQuicNetReport.port = paramQuicReq.mPort;
      localQuicNetReport.isIpv6 = paramQuicReq.mIsIpv6;
      localQuicNetReport.rttHost = paramQuicReq.mRttHost;
      localQuicNetReport.businessId = paramQuicReq.mBussinessId;
      localQuicNetReport.timeOut = paramQuicReq.mTimeOut;
      localQuicNetReport.failReason = paramInt;
      localDownloadListener.onDownloadFailed(paramString2, localQuicNetReport);
    }
  }
  
  public boolean execute(QuicReq paramQuicReq)
  {
    if (Utils.checkIfCPUx86())
    {
      QLog.e("quic", 4, "the phone cpu is x86");
      return false;
    }
    if (paramQuicReq == null) {
      return false;
    }
    if (!TextUtils.isEmpty(paramQuicReq.mPath))
    {
      if (!TextUtils.isEmpty(paramQuicReq.mSavePath))
      {
        if (!TextUtils.isEmpty(paramQuicReq.mIp))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("start ip: ");
            localStringBuilder.append(paramQuicReq.mIp);
            localStringBuilder.append(" port: ");
            localStringBuilder.append(paramQuicReq.mPort);
            QLog.d("quic", 4, localStringBuilder.toString());
          }
          try
          {
            if (this.mSoLoadStatus == 2)
            {
              addToThreadPoll(paramQuicReq);
            }
            else if (this.mSoLoadStatus == 1)
            {
              this.mReqWaitingList.add(paramQuicReq);
            }
            else if (this.mSoLoadStatus == 0)
            {
              this.mReqWaitingList.add(paramQuicReq);
              init();
            }
            return true;
          }
          finally {}
        }
        throw new IllegalArgumentException("ip is empty!!!");
      }
      throw new IllegalArgumentException("savePath is empty!!!");
    }
    throw new IllegalArgumentException("url path is empty!!!");
  }
  
  public void init()
  {
    try
    {
      if ((this.mSoLoadStatus == 0) && (this.mILoadSo != null))
      {
        this.mSoLoadStatus = 1;
        this.mILoadSo.loadSo(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isSoReady()
  {
    return this.mSoLoadStatus == 2;
  }
  
  public void onLoad(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLoad, isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("QuicEngineImp", 1, localStringBuilder.toString());
      if (paramBoolean)
      {
        try
        {
          QuicNative.init();
          QuicNative.setDebugLog(false);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("quic", 4, localThrowable, new Object[0]);
          this.mSoLoadStatus = 0;
          callbackWatingReqFail();
        }
        this.mSoLoadStatus = 2;
        executeWatingReq();
      }
      else
      {
        this.mSoLoadStatus = 0;
        callbackWatingReqFail();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.QuicEngineImp
 * JD-Core Version:    0.7.0.1
 */