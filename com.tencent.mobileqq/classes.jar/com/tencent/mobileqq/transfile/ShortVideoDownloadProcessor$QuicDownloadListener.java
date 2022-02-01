package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.quic.internal.QuicEngineImp;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoDownloadProcessor$QuicDownloadListener
  implements DownloadListener
{
  public AtomicBoolean cancel = new AtomicBoolean(false);
  private WeakReference<ShortVideoDownloadProcessor> mVideoDownloadProcessor;
  
  public ShortVideoDownloadProcessor$QuicDownloadListener(ShortVideoDownloadProcessor paramShortVideoDownloadProcessor)
  {
    this.mVideoDownloadProcessor = new WeakReference(paramShortVideoDownloadProcessor);
  }
  
  public boolean isCanceled()
  {
    return this.cancel.get();
  }
  
  public void onDownloadFailed(String paramString, QuicNetReport paramQuicNetReport)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("quic download failed. use http try again. errCode: ");
      paramString.append(paramQuicNetReport.errCode);
      paramString.append(" errMsg: ");
      paramString.append(paramQuicNetReport.errMsg);
      paramString.append(" ip: ");
      paramString.append(paramQuicNetReport.ip);
      paramString.append(" port: ");
      paramString.append(paramQuicNetReport.port);
      QLog.d("ShortVideoDownloadProcessor", 4, paramString.toString());
    }
    if (this.cancel.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 4, "task canceled.");
      }
      return;
    }
    paramString = (ShortVideoDownloadProcessor)this.mVideoDownloadProcessor.get();
    boolean bool = true;
    if (paramString != null)
    {
      HttpNetReq localHttpNetReq = (HttpNetReq)paramString.mNetReq;
      if (localHttpNetReq != null)
      {
        if (paramQuicNetReport.failReason == 8)
        {
          if (localHttpNetReq.mCallback != null)
          {
            QLog.d("ShortVideoDownloadProcessor", 4, "shortVideoDownloadProcessor failReason downloading.");
            paramString = new NetResp(localHttpNetReq);
            paramString.mResult = 3;
            localHttpNetReq.mCallback.onResp(paramString);
          }
          return;
        }
        paramQuicNetReport.isHttpRetryed = true;
        paramQuicNetReport.stats = QuicEngineImp.saveNetStats(paramQuicNetReport);
        paramString.mQuicNetReport = paramQuicNetReport;
        paramString.mNetEngine.sendReq(localHttpNetReq);
        return;
      }
    }
    paramQuicNetReport = new StringBuilder();
    paramQuicNetReport.append("shortVideoDownloadProcessor or netReq is null. processor: ");
    if (paramString != null) {
      bool = false;
    }
    paramQuicNetReport.append(bool);
    QLog.e("ShortVideoDownloadProcessor", 4, paramQuicNetReport.toString());
  }
  
  public void onDownloadProgress(String paramString, long paramLong1, long paramLong2)
  {
    if (this.cancel.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 4, "task canceled.");
      }
      return;
    }
    paramString = (ShortVideoDownloadProcessor)this.mVideoDownloadProcessor.get();
    if (paramString != null)
    {
      localObject = (HttpNetReq)paramString.mNetReq;
      if (localObject != null)
      {
        if (((HttpNetReq)localObject).mCallback != null) {
          ((HttpNetReq)localObject).mCallback.onUpdateProgeress((NetReq)localObject, paramLong2, paramLong1);
        }
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shortVideoDownloadProcessor or netReq is null. processor: ");
    boolean bool;
    if (paramString == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.e("ShortVideoDownloadProcessor", 4, ((StringBuilder)localObject).toString());
  }
  
  public void onDownloadSucceed(String paramString, QuicNetReport paramQuicNetReport)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("quic download cost time: ");
      paramString.append(paramQuicNetReport.totaltime);
      paramString.append(" waitTime: ");
      paramString.append(paramQuicNetReport.waitCost);
      paramString.append("  firstCostTime: ");
      paramString.append(paramQuicNetReport.firstPackageCost);
      QLog.d("ShortVideoDownloadProcessor", 2, paramString.toString());
    }
    if (this.cancel.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 4, "task canceled.");
      }
      return;
    }
    paramString = (ShortVideoDownloadProcessor)this.mVideoDownloadProcessor.get();
    boolean bool = true;
    if (paramString != null)
    {
      HttpNetReq localHttpNetReq = (HttpNetReq)paramString.mNetReq;
      if (localHttpNetReq != null)
      {
        paramQuicNetReport.stats = QuicEngineImp.saveNetStats(paramQuicNetReport);
        paramQuicNetReport.success = true;
        paramString.mQuicNetReport = paramQuicNetReport;
        paramString.quicDownloadSuc(paramQuicNetReport, localHttpNetReq);
        return;
      }
    }
    paramQuicNetReport = new StringBuilder();
    paramQuicNetReport.append("shortVideoDownloadProcessor or netReq is null. processor: ");
    if (paramString != null) {
      bool = false;
    }
    paramQuicNetReport.append(bool);
    QLog.e("ShortVideoDownloadProcessor", 4, paramQuicNetReport.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor.QuicDownloadListener
 * JD-Core Version:    0.7.0.1
 */