package com.tencent.mobileqq.pic;

import android.os.RemoteException;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class PresendPicMgr$PresendReq
{
  public String a = a();
  public boolean b = false;
  public boolean c = false;
  public CompressInfo d;
  public int e = -1;
  public int f;
  
  public PresendPicMgr$PresendReq(PresendPicMgr paramPresendPicMgr, CompressInfo paramCompressInfo, int paramInt1, int paramInt2)
  {
    this.d = paramCompressInfo;
    this.d.a = this.a;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("__");
    localStringBuilder.append(UUID.randomUUID().toString());
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current PresendReq is ");
      localStringBuilder.append(this);
      Logger.a("PresendPicMgr", "PresendReq.cancel", localStringBuilder.toString());
      this.b = true;
      boolean bool = this.c;
      if (bool)
      {
        try
        {
          Logger.a("PresendPicMgr", "PresendReq.cancel", "call cancelUpload");
          PresendPicMgr.a(this.g).a(this.a, paramInt);
        }
        catch (RemoteException localRemoteException)
        {
          if (!QLog.isColorLevel()) {
            break label107;
          }
        }
        QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
      }
      else
      {
        Logger.a("PresendPicMgr", "PresendReq.cancel", "mIsUpload is false,no need to call cancelUpload");
      }
      label107:
      return;
    }
    finally {}
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call start,current PresendReq is ");
    localStringBuilder.append(this);
    Logger.a("PresendPicMgr", "PresendReq.compressAndUploadPic", localStringBuilder.toString());
    long l = System.nanoTime();
    if (this.b)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PresendStatus: srcPah:");
      localStringBuilder.append(this.d.h);
      localStringBuilder.append(",destPath:");
      localStringBuilder.append(this.d.l);
      localStringBuilder.append(",uuid:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" ,canceled:true, peakCompress:false, peakUpload:false");
      Logger.a("PresendPicMgr", "compressAndUploadPic ", localStringBuilder.toString());
      return;
    }
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(this.d);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("PresendStatus: srcPah:");
    localStringBuilder.append(this.d.h);
    localStringBuilder.append(",destPath:");
    localStringBuilder.append(this.d.l);
    localStringBuilder.append(",uuid:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",canceled:false,peakCompress:true,peakUpload:false");
    Logger.a("PresendPicMgr", "compressAndUploadPic ", localStringBuilder.toString());
    l = (System.nanoTime() - l) / 1000000L;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Process peak,[#]compress, cost= ");
    localStringBuilder.append(l);
    Logger.a("PresendPicMgr", "PresendReq.compressAndUploadPic", localStringBuilder.toString());
    c();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("call end,current PresendReq is ");
    localStringBuilder.append(this);
    Logger.a("PresendPicMgr", "PresendReq.compressAndUploadPic", localStringBuilder.toString());
  }
  
  public void c()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current PresendReq is ");
      localStringBuilder.append(this);
      Logger.a("PresendPicMgr", "PresendReq.uploadPic", localStringBuilder.toString());
      if (this.b)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PresendStatus: srcPah:");
        localStringBuilder.append(this.d.h);
        localStringBuilder.append(",destPath:");
        localStringBuilder.append(this.d.l);
        localStringBuilder.append(",uuid:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" ,canceled:true, peakCompress:true, peakUpload:false");
        Logger.a("PresendPicMgr", "uploadPic ", localStringBuilder.toString());
        return;
      }
      if (this.d.l == null)
      {
        Logger.b("PresendPicMgr", "PresendReq.uploadPic", "mCompressInfo.destPath == null! ");
        return;
      }
      try
      {
        PresendPicMgr.a(this.g).a(this.d.l, this.a, this.d.t, this.e, this.f);
        this.c = true;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PresendStatus: srcPah:");
        localStringBuilder.append(this.d.h);
        localStringBuilder.append(",destPath:");
        localStringBuilder.append(this.d.l);
        localStringBuilder.append(",uuid:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" ,canceled:false, peakCompress:true, peakUpload:true");
        Logger.a("PresendPicMgr", "uploadPic ", localStringBuilder.toString());
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
        }
      }
      Logger.a("PresendPicMgr", "PresendReq.uploadPic", "call end");
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPresendReq");
    localStringBuilder.append("\n|-");
    localStringBuilder.append("localUUID:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("mIsCancel:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("mIsUpload:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("mCompressInfo:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr.PresendReq
 * JD-Core Version:    0.7.0.1
 */