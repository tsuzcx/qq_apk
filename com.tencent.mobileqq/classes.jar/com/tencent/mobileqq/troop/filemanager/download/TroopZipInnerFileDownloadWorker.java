package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileGetFilePreviewObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.List;

public class TroopZipInnerFileDownloadWorker
  extends TroopFileDownloadWorker
{
  protected String A;
  TroopFileGetFilePreviewObserver B = new TroopZipInnerFileDownloadWorker.1(this);
  protected List<String> a = new ArrayList();
  protected String b;
  protected boolean c = false;
  
  protected TroopZipInnerFileDownloadWorker(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    super(paramLong, paramItem, paramBundle, paramITroopFileDownloadWorkerListener);
  }
  
  public static TroopZipInnerFileDownloadWorker a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. item.id=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipFilePath))
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. zipFilePath=null");
      return null;
    }
    if (TextUtils.isEmpty(paramItem.zipInnerPath))
    {
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. zipInnerPath=null");
      return null;
    }
    return new TroopZipInnerFileDownloadWorker(paramLong, paramItem, paramBundle, paramITroopFileDownloadWorkerListener);
  }
  
  String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramLong >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramLong >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramLong >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    this.a.clear();
    return super.a();
  }
  
  protected void k()
  {
    TroopFileDataCenter.a(this.d, this.e, 8);
    Object localObject1 = TroopFileTransferUtil.a();
    if (localObject1 == null)
    {
      i = TroopFileTransferUtil.Log.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).append("] reqDownload app=null");
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", i, ((StringBuilder)localObject1).toString());
      this.q.k = 9;
      this.q.l = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    int i = TroopFileTransferUtil.Log.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[");
    ((StringBuilder)localObject2).append(this.f);
    ((StringBuilder)localObject2).append("] reqDownload");
    TroopFileTransferUtil.Log.c("TroopZipInnerFileDownloadWorker", i, ((StringBuilder)localObject2).toString());
    Object localObject3 = TroopFileTransferUtil.a(this.d);
    if (localObject3 != null)
    {
      localObject2 = ((TroopFileManager)localObject3).a(this.e.FilePath);
      if (localObject2 != null)
      {
        localObject3 = ((TroopFileManager)localObject3).a(((TroopFileInfo)localObject2).o);
        if (localObject3 != null)
        {
          ((TroopFileInfo)localObject2).p = 8;
          ((TroopFileInfo)localObject3).a((TroopFileInfo)localObject2);
        }
      }
    }
    this.c = false;
    this.A = null;
    this.o = TroopFileProtocol.a((QQAppInterface)localObject1, this.d, this.e.zipFilePath, this.e.zipBusId, this.B);
    b(1);
    TroopTechReportUtils.b();
  }
  
  protected void l()
  {
    Object localObject1 = TroopFileTransferUtil.a();
    if (localObject1 == null)
    {
      i = TroopFileTransferUtil.Log.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).append("] startDownload app=null");
      TroopFileTransferUtil.Log.a("TroopZipInnerFileDownloadWorker", i, ((StringBuilder)localObject1).toString());
      this.q.k = 9;
      this.q.l = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    Object localObject2 = MD5.toMD5(this.e.FilePath);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.k);
    localStringBuilder.append((String)localObject2);
    this.l = localStringBuilder.toString();
    if (this.h != null)
    {
      this.h.l();
      this.h = null;
    }
    this.r = System.currentTimeMillis();
    this.q.e = FileUtil.f(this.l);
    long l = TroopFileTransferUtil.b();
    int i = TroopFileTransferUtil.Log.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[");
    ((StringBuilder)localObject2).append(this.f);
    ((StringBuilder)localObject2).append("] startDownload. nSessionId:");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(" firstIP=");
    ((StringBuilder)localObject2).append(this.e.DownloadIp);
    ((StringBuilder)localObject2).append(" urlParams:");
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append(" mTmpFilePath:");
    ((StringBuilder)localObject2).append(this.l);
    TroopFileTransferUtil.Log.c("TroopZipInnerFileDownloadWorker", i, ((StringBuilder)localObject2).toString());
    this.h = TroopFileDownloader.a((QQAppInterface)localObject1, l, this.l, this.e.ProgressTotal, this.a, this.b, null, this.c, this.A);
    if (this.h == null)
    {
      this.q.k = 9;
      this.q.l = 903;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    this.h.a(this);
    this.h.k();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopZipInnerFileDownloadWorker
 * JD-Core Version:    0.7.0.1
 */