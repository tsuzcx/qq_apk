package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReq;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;

public class TroopFileThumbnailFetchWorker
  implements TroopFileThumbnailDownloader.IFileThumbDownloaderSink
{
  protected long a;
  protected TroopFileTransferManager.Item b;
  protected String c;
  protected boolean d = true;
  protected TroopFileThumbnailDownloader e;
  protected TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected int k;
  protected boolean l = false;
  protected ITroopFileProtoReq m;
  protected Timer n;
  protected int o = 0;
  TroopFileReqDownloadFileObserver p = new TroopFileThumbnailFetchWorker.2(this);
  
  protected TroopFileThumbnailFetchWorker(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener paramITroopFileThumbFetchWorkerListener)
  {
    this.a = paramLong;
    this.b = paramItem;
    this.f = paramITroopFileThumbFetchWorkerListener;
    this.k = paramInt;
    this.c = TroopFileThumbnailFetchMgr.b(this.b.Id, paramInt);
    if (FileManagerUtil.c(FileUtil.a(this.b.FileName)) == 2) {
      this.l = true;
    }
  }
  
  public static TroopFileThumbnailFetchWorker a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener paramITroopFileThumbFetchWorkerListener)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. item.id=null");
      return null;
    }
    if (paramInt == 0)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. nThumbSize=0");
      return null;
    }
    return new TroopFileThumbnailFetchWorker(paramLong, paramItem, paramInt, paramITroopFileThumbFetchWorkerListener);
  }
  
  private void j()
  {
    try
    {
      if (this.n != null)
      {
        this.n.cancel();
        this.n = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public UUID a()
  {
    return this.b.Id;
  }
  
  public void a(int paramInt)
  {
    if ((this.b.duration == 0) && (paramInt != 0))
    {
      this.b.duration = paramInt;
      this.e.b(true);
    }
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      paramInt1 = TroopFileTransferUtil.Log.b;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.c);
      paramString.append("] startFetch app=null");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", paramInt1, paramString.toString());
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    FileUtils.deleteFile(this.i);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("/ftn_handler/");
    ((StringBuilder)localObject1).append(this.b.DownloadUrl);
    ((StringBuilder)localObject1).append("/?fname=");
    ((StringBuilder)localObject1).append(this.b.FilePath);
    ((StringBuilder)localObject1).append("&pictype=cut&size=");
    ((StringBuilder)localObject1).append(this.k);
    ((StringBuilder)localObject1).append("*");
    ((StringBuilder)localObject1).append(this.k);
    localObject1 = ((StringBuilder)localObject1).toString();
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    StringBuilder localStringBuilder;
    if (this.l)
    {
      int i1 = 443;
      if (paramInt1 <= 0) {
        paramInt1 = 443;
      }
      if ((TroopFileUtils.c(localQQAppInterface)) && (!TextUtils.isEmpty(paramString)))
      {
        bool = true;
      }
      else
      {
        bool = false;
        paramString = null;
      }
      if (bool) {
        if (paramInt2 <= 0) {
          paramInt1 = i1;
        } else {
          paramInt1 = paramInt2;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("/ftn_video_pic/rkey=");
      ((StringBuilder)localObject1).append(this.b.DownloadUrl);
      ((StringBuilder)localObject1).append("&filetype=17&size=");
      ((StringBuilder)localObject1).append(this.k);
      ((StringBuilder)localObject1).append("*");
      ((StringBuilder)localObject1).append(this.k);
      ((StringBuilder)localObject1).append("&");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.b.DownloadIp);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(paramInt1);
      localArrayList.add(((StringBuilder)localObject2).toString());
      if (!TextUtils.isEmpty(this.b.DownloadDNS)) {
        if (FileIPv6StrateyController.b().isConfigEnableIPV6(localQQAppInterface, 3))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[");
          ((StringBuilder)localObject2).append(this.c);
          ((StringBuilder)localObject2).append("] [IPv6-File] download troopVideo thumb. is config enable IPv6. domain[");
          ((StringBuilder)localObject2).append(this.b.DownloadDNS);
          ((StringBuilder)localObject2).append("]");
          QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
          localObject2 = new FileIPv6StrateyController.DomainInfo(this.b.DownloadDNS, paramInt1);
          localObject2 = FileIPv6StrateyController.b().getIPlistForV6Domain(localQQAppInterface, (FileIPv6StrateyController.DomainInfo)localObject2, 3);
          if ((localObject2 != null) && (!((FileIPv6StrateyController.IPListInfo)localObject2).a()))
          {
            if (FileIPv6StrateyController.a())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append(this.c);
              localStringBuilder.append("] [IPv6-File] download troopVideo thumb. debugIsDisableIPv4OnDoubleStack");
              QLog.d("TroopFileDownloadWorker", 1, localStringBuilder.toString());
              localArrayList.clear();
            }
            FileIPv6StrateyController.a(((FileIPv6StrateyController.IPListInfo)localObject2).b, localArrayList, false, false);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(this.c);
            ((StringBuilder)localObject2).append("] [IPv6-File] download troopVideo thumb. use IPv6. iplist:");
            ((StringBuilder)localObject2).append(localArrayList.toString());
            QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(this.c);
            ((StringBuilder)localObject2).append("] [IPv6-File] download troopVideo thumb. use IPv4:");
            QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.b.DownloadDNS);
            ((StringBuilder)localObject2).append(":");
            ((StringBuilder)localObject2).append(paramInt1);
            localArrayList.add(((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.b.DownloadDNS);
          ((StringBuilder)localObject2).append(":");
          ((StringBuilder)localObject2).append(paramInt1);
          localArrayList.add(((StringBuilder)localObject2).toString());
        }
      }
    }
    else
    {
      if ((TroopFileUtils.c(localQQAppInterface)) && (!TextUtils.isEmpty(this.b.DownloadDNS)))
      {
        paramString = this.b.DownloadDNS;
        bool = true;
      }
      else
      {
        bool = false;
        paramString = null;
      }
      localArrayList.add(this.b.DownloadIp);
      if (!TextUtils.isEmpty(this.b.DownloadDNS)) {
        if (FileIPv6StrateyController.b().isConfigEnableIPV6(localQQAppInterface, 3))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[");
          ((StringBuilder)localObject2).append(this.c);
          ((StringBuilder)localObject2).append("] [IPv6-File] download troopImage thumb. is config enable IPv6. domain[");
          ((StringBuilder)localObject2).append(this.b.DownloadDNS);
          ((StringBuilder)localObject2).append("]");
          QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
          localObject2 = new FileIPv6StrateyController.DomainInfo(this.b.DownloadDNS, 0);
          localObject2 = FileIPv6StrateyController.b().getIPlistForV6Domain(localQQAppInterface, (FileIPv6StrateyController.DomainInfo)localObject2, 3);
          if ((localObject2 != null) && (!((FileIPv6StrateyController.IPListInfo)localObject2).a()))
          {
            if (FileIPv6StrateyController.a())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append(this.c);
              localStringBuilder.append("] [IPv6-File] download troopImage thumb. debugIsDisableIPv4OnDoubleStack");
              QLog.d("TroopFileDownloadWorker", 1, localStringBuilder.toString());
              localArrayList.clear();
            }
            FileIPv6StrateyController.a(((FileIPv6StrateyController.IPListInfo)localObject2).b, localArrayList, true, false);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(this.c);
            ((StringBuilder)localObject2).append("] [IPv6-File] download troopImage thumb. use IPv6. iplist:");
            ((StringBuilder)localObject2).append(localArrayList.toString());
            QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[");
            ((StringBuilder)localObject2).append(this.c);
            ((StringBuilder)localObject2).append("] [IPv6-File] download troopImage thumb. use IPv4");
            QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject2).toString());
            localArrayList.add(this.b.DownloadDNS);
          }
        }
        else
        {
          localArrayList.add(this.b.DownloadDNS);
        }
      }
    }
    long l1 = TroopFileTransferUtil.b();
    paramInt1 = TroopFileTransferUtil.Log.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("] startFetch. nSessionId:");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append(" firstIP=");
    ((StringBuilder)localObject2).append(this.b.DownloadIp);
    ((StringBuilder)localObject2).append(" urlParams:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" mTmpFilePath:");
    ((StringBuilder)localObject2).append(this.i);
    ((StringBuilder)localObject2).append(" bUseHttps:");
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append(" httpsDomain:");
    ((StringBuilder)localObject2).append(paramString);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", paramInt1, ((StringBuilder)localObject2).toString());
    localObject2 = this.e;
    if (localObject2 != null)
    {
      ((TroopFileThumbnailDownloader)localObject2).l();
      this.e = null;
    }
    this.e = TroopFileThumbnailDownloader.a(localQQAppInterface, l1, this.i, 0L, localArrayList, (String)localObject1, this.b.cookieValue, this.l, bool, paramString);
    paramString = this.e;
    if (paramString == null)
    {
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    paramString.a(this);
    this.e.j();
    this.e.a(false);
    if (this.b.duration != 0) {
      this.e.b(true);
    }
    this.e.k();
    b(2);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(String paramString)
  {
    if (this.d) {
      return;
    }
    a(false);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.d = true;
    this.m = null;
    j();
    if ((!paramBoolean) && (!FileManagerUtil.a(new VFSFile(this.i), new VFSFile(this.j))))
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] renameFile fail  mFilePath:");
      ((StringBuilder)localObject).append(this.j);
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
      if (FileUtils.fileExistsAndNotEmpty(this.j))
      {
        c(TroopTechReportUtils.TroopFileReportResultCode.o);
        return;
      }
    }
    b(3);
    i();
    int i1 = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("] onFetchSuc  mFilePath:");
    ((StringBuilder)localObject).append(this.j);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
    if (!paramBoolean) {
      this.b.StatusUpdateTimeMs = 0L;
    }
    if ((this.k == 640) && (!FileUtil.d(this.b.getThumbnailFile(this.a, 383)))) {
      this.b.genThumb_Middle_OnGettedLargeOrOrigPic = true;
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    FilePicURLDrawlableHelper.a(this.j, (BitmapFactory.Options)localObject);
    if ((((BitmapFactory.Options)localObject).outWidth > 0) && (((BitmapFactory.Options)localObject).outHeight > 0))
    {
      this.b.width = ((BitmapFactory.Options)localObject).outWidth;
      this.b.height = ((BitmapFactory.Options)localObject).outHeight;
    }
    TroopFileDataCenter.a(this.a, this.b);
    TroopFileDataCenter.b(this.a, this.b);
    localObject = this.f;
    if (localObject != null) {
      ((TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener)localObject).a(b(), true, 0, this);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.d) {
      return;
    }
    if (!paramBoolean) {
      return;
    }
    int i1 = TroopFileTransferUtil.Log.b;
    paramString1 = new StringBuilder();
    paramString1.append("[");
    paramString1.append(this.c);
    paramString1.append("] onHasErr. fetch fail. errCode:");
    paramString1.append(paramInt);
    paramString1.append(" transferedSize:");
    paramString1.append(paramLong);
    TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, paramString1.toString());
    if (paramInt == -5000)
    {
      i1 = TroopTechReportUtils.TroopFileReportResultCode.h;
    }
    else if (paramInt == -5001)
    {
      i1 = TroopTechReportUtils.TroopFileReportResultCode.g;
    }
    else if (paramInt == 9039)
    {
      i1 = TroopTechReportUtils.TroopFileReportResultCode.n;
    }
    else if (paramInt == 9004)
    {
      i1 = TroopTechReportUtils.TroopFileReportResultCode.k;
    }
    else if (paramInt == 9301)
    {
      i1 = TroopTechReportUtils.TroopFileReportResultCode.i;
    }
    else if (paramInt == -5001)
    {
      i1 = TroopTechReportUtils.TroopFileReportResultCode.q;
    }
    else if (this.e.n())
    {
      i1 = TroopTechReportUtils.TroopFileReportResultCode.p;
    }
    else
    {
      i1 = paramInt;
      if (paramInt == -5003) {
        i1 = TroopTechReportUtils.TroopFileReportResultCode.y;
      }
    }
    c(i1);
  }
  
  public String b()
  {
    return this.c;
  }
  
  protected void b(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void b(String paramString) {}
  
  protected void c(int paramInt)
  {
    this.d = true;
    this.m = null;
    j();
    if (!TextUtils.isEmpty(this.i)) {
      FileUtils.deleteFile(this.i);
    }
    b(4);
    h();
    int i1 = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("] onFetchErr  errCode:");
    ((StringBuilder)localObject).append(paramInt);
    TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
    this.b.StatusUpdateTimeMs = 0L;
    if (paramInt == TroopTechReportUtils.TroopFileReportResultCode.y) {
      this.b.thumbInvalidCode = 1;
    } else if (paramInt == TroopTechReportUtils.TroopFileReportResultCode.p) {
      this.b.thumbInvalidCode = 2;
    } else {
      this.b.thumbInvalidCode = 0;
    }
    TroopFileDataCenter.b(this.a, this.b);
    localObject = this.f;
    if (localObject != null) {
      ((TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener)localObject).a(b(), false, paramInt, this);
    }
  }
  
  public boolean c()
  {
    int i1 = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] start fetch thumb. filename:");
    localStringBuilder.append(this.b.FileName);
    localStringBuilder.append(" filePath:");
    localStringBuilder.append(this.b.FilePath);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i1, localStringBuilder.toString());
    this.d = false;
    ThreadManager.post(new TroopFileThumbnailFetchWorker.1(this), 8, null, false);
    return true;
  }
  
  public void d()
  {
    if (this.d)
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] stop. but had stoped. mStatus:");
      ((StringBuilder)localObject).append(this.o);
      TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
      return;
    }
    this.d = true;
    int i1 = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("] stop fetch. mStatus:");
    ((StringBuilder)localObject).append(this.o);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
    if (this.o == 2)
    {
      localObject = this.e;
      if (localObject != null)
      {
        ((TroopFileThumbnailDownloader)localObject).l();
        this.e = null;
      }
      else
      {
        i1 = TroopFileTransferUtil.Log.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append("] stop downloader=null");
        TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
      }
    }
    j();
    if (this.m != null)
    {
      TroopFileProtocol.a(TroopFileTransferUtil.a(), this.m);
      this.m = null;
    }
    h();
    if (!TextUtils.isEmpty(this.i)) {
      FileUtils.deleteFile(this.i);
    }
    localObject = this.b;
    ((TroopFileTransferManager.Item)localObject).StatusUpdateTimeMs = 0L;
    TroopFileDataCenter.b(this.a, (TroopFileTransferManager.Item)localObject);
    b(0);
  }
  
  protected void e()
  {
    Object localObject = TroopFileTransferUtil.a();
    if (localObject == null)
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] reqFetch app=null");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    int i1 = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] reqFetch");
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i1, localStringBuilder.toString());
    this.m = TroopFileProtocol.a((QQAppInterface)localObject, this.a, this.b, this.k, false, false, this.p);
    b(1);
  }
  
  protected void f()
  {
    if ((!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.h))) {
      return;
    }
    this.g = TroopFileThumbnailMgr.d();
    this.h = this.g;
  }
  
  public void g() {}
  
  protected void h()
  {
    TroopFileThumbnailMgr.b(this.b, this.k);
    if (this.k == 383) {
      this.b.ThumbnailDownloading_Middle_Fail = true;
    }
  }
  
  protected void i()
  {
    TroopFileThumbnailMgr.b(this.b, this.k);
    boolean bool = TroopFileThumbnailMgr.a(this.a, this.b, this.k, this.j);
    if (this.k == 383) {
      this.b.ThumbnailDownloading_Middle_Fail = (bool ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker
 * JD-Core Version:    0.7.0.1
 */