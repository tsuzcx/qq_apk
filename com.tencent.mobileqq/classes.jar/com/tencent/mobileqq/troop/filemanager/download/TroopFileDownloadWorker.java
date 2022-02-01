package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReq;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataReporter;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataReporter.ReportTransferItem;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TroopFileDownloadWorker
  implements ITroopFileDownloaderSink
{
  protected long d;
  protected TroopFileTransferManager.Item e;
  protected String f;
  protected boolean g = true;
  protected ITroopFileDownloader h;
  protected TroopFileDownloadWorker.ITroopFileDownloadWorkerListener i;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  protected Bundle n;
  protected ITroopFileProtoReq o;
  protected int p = 0;
  protected TroopFileDataReporter.ReportTransferItem q = new TroopFileDataReporter.ReportTransferItem();
  protected long r = 0L;
  protected long s = 0L;
  protected long t = 0L;
  protected long u = 0L;
  protected long v = 0L;
  protected boolean w = false;
  protected int x = 0;
  protected boolean y = false;
  TroopFileReqDownloadFileObserver z = new TroopFileDownloadWorker.2(this);
  
  protected TroopFileDownloadWorker(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    this.d = paramLong;
    this.e = paramItem;
    this.i = paramITroopFileDownloadWorkerListener;
    if (this.e.Id != null) {
      paramItem = this.e.Id.toString();
    } else {
      paramItem = "";
    }
    this.f = paramItem;
    this.n = paramBundle;
  }
  
  public static TroopFileDownloadWorker b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
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
    return new TroopFileDownloadWorker(paramLong, paramItem, paramBundle, paramITroopFileDownloadWorkerListener);
  }
  
  /* Error */
  public static String o()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: lconst_1
    //   4: invokestatic 130	java/lang/Thread:sleep	(J)V
    //   7: goto +12 -> 19
    //   10: astore_2
    //   11: goto +41 -> 52
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 133	java/lang/InterruptedException:printStackTrace	()V
    //   19: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   22: lstore_0
    //   23: new 141	java/text/SimpleDateFormat
    //   26: dup
    //   27: ldc 143
    //   29: getstatic 149	java/util/Locale:US	Ljava/util/Locale;
    //   32: invokespecial 152	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   35: new 154	java/util/Date
    //   38: dup
    //   39: lload_0
    //   40: invokespecial 156	java/util/Date:<init>	(J)V
    //   43: invokevirtual 160	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   46: astore_2
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_2
    //   51: areturn
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	18	0	l1	long
    //   10	1	2	localObject	Object
    //   14	2	2	localInterruptedException	java.lang.InterruptedException
    //   46	10	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	7	10	finally
    //   15	19	10	finally
    //   19	47	10	finally
    //   3	7	14	java/lang/InterruptedException
  }
  
  protected int a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return TroopFileDataReporter.a(paramInt1, paramInt2);
  }
  
  protected int a(int paramInt, Bundle paramBundle)
  {
    return 3;
  }
  
  protected ITroopFileDownloader a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    if ((this.g) && (this.p != 5))
    {
      paramInt = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("] stop. but had stoped. mStatus:");
      ((StringBuilder)localObject).append(this.p);
      TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", paramInt, ((StringBuilder)localObject).toString());
      return;
    }
    this.g = true;
    int i1 = 8;
    a(8, 0);
    int i2 = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("] stop. mStatus:");
    ((StringBuilder)localObject).append(this.p);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i2, ((StringBuilder)localObject).toString());
    localObject = this.h;
    if (localObject != null)
    {
      ((ITroopFileDownloader)localObject).l();
      this.h = null;
    }
    if (this.o != null)
    {
      TroopFileProtocol.a(TroopFileTransferUtil.a(), this.o);
      this.o = null;
    }
    localObject = this.e;
    ((TroopFileTransferManager.Item)localObject).Pausing = 1;
    i2 = 9;
    if (paramInt == 1) {
      ((TroopFileTransferManager.Item)localObject).W2MPause = 2;
    }
    for (paramInt = i2;; paramInt = 10)
    {
      i1 = 11;
      i2 = paramInt;
      break;
      if (paramInt == 2)
      {
        ((TroopFileTransferManager.Item)localObject).Pausing = -1;
        i1 = 12;
        break;
      }
      if (paramInt != 3) {
        break;
      }
      ((TroopFileTransferManager.Item)localObject).Pausing = -1;
    }
    TroopFileDataCenter.a(this.d, this.e, i2);
    b(0);
    this.q.k = i1;
    d();
    p();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      this.q.a = ((ITroopFileDownloader)localObject).o();
      this.q.b = this.h.p();
      this.q.c = this.h.q();
      this.q.d = this.h.r();
    }
    localObject = this.q;
    ((TroopFileDataReporter.ReportTransferItem)localObject).k = paramInt1;
    ((TroopFileDataReporter.ReportTransferItem)localObject).l = paramInt2;
    ((TroopFileDataReporter.ReportTransferItem)localObject).f = this.s;
    if (this.r != 0L)
    {
      ((TroopFileDataReporter.ReportTransferItem)localObject).g = (System.currentTimeMillis() - this.r);
      if ((this.s > 0L) && (this.q.g > 0L))
      {
        float f1 = (float)this.q.g / 1000.0F;
        this.q.i = (((float)this.s / f1));
        return;
      }
      this.q.i = 0L;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.g) {
      return;
    }
    if (paramLong1 > this.e.ProgressValue) {
      this.s += paramLong1 - this.e.ProgressValue;
    } else {
      this.s = paramLong1;
    }
    this.e.ProgressValue = paramLong1;
    paramLong1 = System.currentTimeMillis();
    paramLong2 = this.t;
    if ((paramLong2 == 0L) || (paramLong1 - paramLong2 >= 1500L))
    {
      this.t = paramLong1;
      TroopFileDataCenter.b(this.d, this.e);
    }
  }
  
  protected final void a(TroopFileStatusInfo paramTroopFileStatusInfo, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      int i1 = TroopFileTransferUtil.Log.b;
      paramTroopFileStatusInfo = new StringBuilder();
      paramTroopFileStatusInfo.append("[");
      paramTroopFileStatusInfo.append(this.f);
      paramTroopFileStatusInfo.append("] addFMEntity fail app=null ");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, paramTroopFileStatusInfo.toString());
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.d);
    localFileManagerEntity.peerNick = ContactUtils.i(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.d;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = FileHttpUtils.a(FileManagerUtil.e(paramTroopFileStatusInfo.k));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = FileHttpUtils.a(FileManagerUtil.d(paramTroopFileStatusInfo.k));
      }
    }
    localFileManagerEntity.str10Md5 = com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(FileManagerUtil.g(paramTroopFileStatusInfo.k));
    try
    {
      localFileManagerEntity.localModifyTime = new File(paramTroopFileStatusInfo.k).lastModified();
      label277:
      localQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      return;
    }
    catch (Exception paramTroopFileStatusInfo)
    {
      break label277;
    }
  }
  
  public void a(String paramString)
  {
    if (this.g) {
      return;
    }
    if (this.e.ProgressTotal >= this.q.e) {
      this.s = (this.e.ProgressTotal - this.q.e);
    }
    n();
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    TroopFileTransferUtil.Log.a(paramString1, paramInt, paramString2);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.g = true;
    this.o = null;
    b(4);
    Object localObject = this.e;
    ((TroopFileTransferManager.Item)localObject).ErrorCode = 0;
    TroopFileDataCenter.a(this.d, (TroopFileTransferManager.Item)localObject, 12);
    d();
    p();
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(this.e.DownloadIp)) {
        localObject = this.e.DownloadIp;
      } else {
        localObject = "";
      }
      TroopTechReportUtils.b(paramInt1, paramInt2, (String)localObject);
    }
    this.e.retryTimes = 0;
    int i1 = TroopFileTransferUtil.Log.b;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("] onFileInvailDel  nReportResultCode:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" nReportSecResultCode:");
    ((StringBuilder)localObject).append(paramInt2);
    TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
    localObject = this.i;
    if (localObject != null) {
      ((TroopFileDownloadWorker.ITroopFileDownloadWorkerListener)localObject).a(h(), false, paramInt2, this);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.g = true;
    this.o = null;
    b(4);
    TroopFileDataCenter.a(this.d, this.e, 10, paramInt3);
    d();
    p();
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(this.e.DownloadIp)) {
        localObject = this.e.DownloadIp;
      } else {
        localObject = "";
      }
      TroopTechReportUtils.b(paramInt1, paramInt2, (String)localObject);
    }
    this.e.retryTimes = 0;
    int i1 = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("] onDownloadErr  nReportResultCode:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" nReportSecResultCode:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" troopFileError:");
    ((StringBuilder)localObject).append(paramInt3);
    TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
    localObject = this.i;
    if (localObject != null) {
      ((TroopFileDownloadWorker.ITroopFileDownloadWorkerListener)localObject).a(h(), false, paramInt2, this);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.g) {
      return;
    }
    int i5 = TroopFileTransferUtil.a(paramString1);
    if (i5 == 0) {
      i5 = TroopFileTransferUtil.b(paramString2);
    }
    int i7 = TroopFileTransferUtil.c(paramString1);
    if (!paramBoolean)
    {
      i1 = a(paramInt, paramBundle);
      i2 = a(paramInt, i7, paramBundle);
      if (paramInt == 9050) {
        i1 = 4;
      }
      a(i1, i2);
      paramString1 = this.q;
      paramString1.m = i7;
      paramString1.n = i5;
      q();
      paramString1 = this.q;
      paramString1.m = 0;
      paramString1.n = 0;
      paramString1.k = 0;
      paramString1.l = 0;
      return;
    }
    int i1 = TroopFileTransferUtil.Log.b;
    paramString1 = new StringBuilder();
    paramString1.append("[");
    paramString1.append(this.f);
    paramString1.append("] onHasErr. download fail. errCode:");
    paramString1.append(paramInt);
    paramString1.append(" transferedSize:");
    paramString1.append(paramLong);
    a("TroopFileDownloadWorker", i1, paramString1.toString());
    i1 = a(paramInt, paramBundle);
    int i2 = a(paramInt, i7, paramBundle);
    int i3 = TroopTechReportUtils.TroopFileReportResultCode.d;
    paramBoolean = NetworkUtil.isNetSupport(BaseApplication.getContext());
    int i6 = 106;
    int i4 = 7;
    if (!paramBoolean)
    {
      i3 = TroopTechReportUtils.TroopFileReportResultCode.b;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.k;
      i4 = i1;
      i2 = 306;
      i1 = i6;
    }
    else if (paramInt == -5000)
    {
      i2 = 708;
      i3 = TroopTechReportUtils.TroopFileReportResultCode.b;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.h;
      i1 = 303;
    }
    else if (paramInt == -5001)
    {
      i2 = 709;
      i3 = TroopTechReportUtils.TroopFileReportResultCode.b;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.g;
      i1 = 304;
    }
    else if (paramInt == 9039)
    {
      i2 = 710;
      i3 = TroopTechReportUtils.TroopFileReportResultCode.b;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.n;
      i1 = 308;
    }
    else if (paramInt == 9004)
    {
      i3 = TroopTechReportUtils.TroopFileReportResultCode.b;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.k;
      i2 = 306;
      i4 = 3;
      i1 = i6;
    }
    else if (paramInt == 9301)
    {
      i2 = 705;
      i3 = TroopTechReportUtils.TroopFileReportResultCode.b;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.i;
      i1 = 306;
    }
    else if (paramInt == -5001)
    {
      i2 = 704;
      i3 = TroopTechReportUtils.TroopFileReportResultCode.b;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.q;
      i1 = 305;
    }
    else if (this.h.n())
    {
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.p;
      i1 = 105;
      i4 = 4;
    }
    else
    {
      if (i5 != 0) {
        paramInt = i5;
      }
      i6 = 1;
      i4 = i1;
      i1 = i6;
    }
    a(i4, i2);
    paramString1 = this.q;
    paramString1.m = i7;
    paramString1.n = i5;
    a(true, i3, paramInt, i1);
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.e.FilePath))
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("] start filepath is null");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
      return false;
    }
    this.g = false;
    this.q.h = System.currentTimeMillis();
    this.u = 0L;
    this.v = 0L;
    this.y = false;
    Object localObject = this.n;
    boolean bool1;
    if (localObject != null)
    {
      boolean bool2 = ((Bundle)localObject).getBoolean("_wifi2mobile_resume_", false);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this.e.W2MPause == 2)
        {
          this.e.W2MPause = 0;
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    int i1 = TroopFileTransferUtil.Log.b;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("] start filename:");
    ((StringBuilder)localObject).append(this.e.FileName);
    ((StringBuilder)localObject).append(" filePath:");
    ((StringBuilder)localObject).append(this.e.FilePath);
    ((StringBuilder)localObject).append(" bResueFromW2MPause:");
    ((StringBuilder)localObject).append(bool1);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
    this.e.Pausing = 0;
    localObject = TroopFileTransferUtil.a(this.d);
    if (localObject != null)
    {
      localObject = ((TroopFileManager)localObject).a(this.e.FilePath);
      if (localObject != null) {
        this.q.s = ((TroopFileInfo)localObject).j;
      }
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("] no network");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
      this.g = true;
      b(4);
      localObject = this.q;
      ((TroopFileDataReporter.ReportTransferItem)localObject).k = 9;
      ((TroopFileDataReporter.ReportTransferItem)localObject).l = 901;
      d();
      this.q.a();
      TroopFileDataCenter.a(this.d, this.e, 10, 106);
      TroopTechReportUtils.b(TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.k);
      return false;
    }
    ThreadManager.post(new TroopFileDownloadWorker.1(this), 8, null, false);
    return true;
  }
  
  protected void b(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void b(String paramString)
  {
    int i1 = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("] onChangeUrl:");
    localStringBuilder.append(paramString);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i1, localStringBuilder.toString());
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void e()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected int f()
  {
    ITroopFileDownloader localITroopFileDownloader = this.h;
    if (localITroopFileDownloader == null) {
      return 0;
    }
    return QFileUtils.c(localITroopFileDownloader.o());
  }
  
  public void g()
  {
    int i1 = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("] onRetryDownload");
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
    localObject = this.h;
    if (localObject != null) {
      this.e.retryTimes = ((ITroopFileDownloader)localObject).m();
    }
    this.r = System.currentTimeMillis();
    this.q.e = this.e.ProgressValue;
    localObject = this.q;
    ((TroopFileDataReporter.ReportTransferItem)localObject).m = 0;
    ((TroopFileDataReporter.ReportTransferItem)localObject).n = 0;
    ((TroopFileDataReporter.ReportTransferItem)localObject).k = -1;
    ((TroopFileDataReporter.ReportTransferItem)localObject).l = 0;
    ((TroopFileDataReporter.ReportTransferItem)localObject).q = "";
    ((TroopFileDataReporter.ReportTransferItem)localObject).r = "";
  }
  
  public UUID h()
  {
    return this.e.Id;
  }
  
  public long i()
  {
    return this.d;
  }
  
  public void j()
  {
    TroopFileDataCenter.a(this.d, this.e, 8);
    b(5);
  }
  
  protected void k()
  {
    this.w = false;
    TroopFileDataCenter.a(this.d, this.e, 8);
    Object localObject1 = TroopFileTransferUtil.a();
    if (localObject1 == null)
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).append("] reqDownload app=null");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, ((StringBuilder)localObject1).toString());
      localObject1 = this.q;
      ((TroopFileDataReporter.ReportTransferItem)localObject1).k = 9;
      ((TroopFileDataReporter.ReportTransferItem)localObject1).l = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    int i1 = TroopFileTransferUtil.Log.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[");
    ((StringBuilder)localObject2).append(this.f);
    ((StringBuilder)localObject2).append("] reqDownload");
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i1, ((StringBuilder)localObject2).toString());
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
    this.o = TroopFileProtocol.a((QQAppInterface)localObject1, this.d, this.e, 0, false, false, this.z);
    b(1);
    this.u = MessageCache.c();
    TroopTechReportUtils.b();
  }
  
  protected void l()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("] startDownload app=null");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, ((StringBuilder)localObject).toString());
      localObject = this.q;
      ((TroopFileDataReporter.ReportTransferItem)localObject).k = 9;
      ((TroopFileDataReporter.ReportTransferItem)localObject).l = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      ((ITroopFileDownloader)localObject).l();
      this.h = null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/ftn_handler/");
    ((StringBuilder)localObject).append(this.e.DownloadUrl);
    ((StringBuilder)localObject).append("/?fname=");
    ((StringBuilder)localObject).append(com.tencent.mobileqq.utils.HexUtil.string2HexString(this.e.FilePath));
    String str = ((StringBuilder)localObject).toString();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.e.DownloadIp);
    boolean bool2 = TextUtils.isEmpty(this.e.DownloadDNS);
    boolean bool1 = false;
    if (!bool2)
    {
      if (FileIPv6StrateyController.b().isConfigEnableIPV6(localQQAppInterface, 3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append("] [IPv6-File] download troopfile. is config enable IPv6. domain[");
        ((StringBuilder)localObject).append(this.e.DownloadDNS);
        ((StringBuilder)localObject).append("]");
        QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject).toString());
        localObject = new FileIPv6StrateyController.DomainInfo(this.e.DownloadDNS, 0);
        localObject = FileIPv6StrateyController.b().getIPlistForV6Domain(localQQAppInterface, (FileIPv6StrateyController.DomainInfo)localObject, 3);
        if ((localObject != null) && (!((FileIPv6StrateyController.IPListInfo)localObject).a()))
        {
          if (FileIPv6StrateyController.a())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[");
            localStringBuilder.append(this.f);
            localStringBuilder.append("] [IPv6-File] download troopfile. debugIsDisableIPv4OnDoubleStack");
            QLog.d("TroopFileDownloadWorker", 1, localStringBuilder.toString());
            localArrayList.clear();
          }
          FileIPv6StrateyController.a(((FileIPv6StrateyController.IPListInfo)localObject).b, localArrayList, true, false);
          this.x = 2;
          if (((FileIPv6StrateyController.IPListInfo)localObject).a == 1) {
            this.x = 3;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[");
          ((StringBuilder)localObject).append(this.f);
          ((StringBuilder)localObject).append("] [IPv6-File] download troopfile. use IPv6. iplist:");
          ((StringBuilder)localObject).append(localArrayList.toString());
          QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[");
          ((StringBuilder)localObject).append(this.f);
          ((StringBuilder)localObject).append("] [IPv6-File] download troopfile. use IPv4");
          QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject).toString());
          localArrayList.add(this.e.DownloadDNS);
          this.x = 1;
        }
      }
      else
      {
        localArrayList.add(this.e.DownloadDNS);
        this.x = 1;
      }
    }
    else {
      this.x = 1;
    }
    this.r = System.currentTimeMillis();
    this.q.e = FileUtil.f(this.l);
    long l1 = TroopFileTransferUtil.b();
    if ((TroopFileUtils.a(localQQAppInterface)) && (!TextUtils.isEmpty(this.e.DownloadDNS)))
    {
      localObject = this.e.DownloadDNS;
      bool1 = true;
    }
    else
    {
      localObject = null;
    }
    this.y = bool1;
    int i1 = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("] startDownload. nSessionId:");
    localStringBuilder.append(l1);
    localStringBuilder.append(" firstIP=");
    localStringBuilder.append(this.e.DownloadIp);
    localStringBuilder.append(" urlParams:");
    localStringBuilder.append(str);
    localStringBuilder.append(" mTmpFilePath:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" bUseHttps:");
    localStringBuilder.append(bool1);
    localStringBuilder.append(" httpsDomain:");
    localStringBuilder.append((String)localObject);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i1, localStringBuilder.toString());
    if (b()) {
      this.h = a(localQQAppInterface, l1, this.l, str, bool1, (String)localObject);
    } else {
      this.h = TroopFileDownloader.a(localQQAppInterface, l1, this.l, this.e.ProgressTotal, localArrayList, str, this.e.cookieValue, bool1, (String)localObject);
    }
    localObject = this.h;
    if (localObject == null)
    {
      localObject = this.q;
      ((TroopFileDataReporter.ReportTransferItem)localObject).k = 9;
      ((TroopFileDataReporter.ReportTransferItem)localObject).l = 903;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    ((ITroopFileDownloader)localObject).a(this);
    this.h.k();
    b(2);
  }
  
  protected boolean m()
  {
    if ((!TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty(this.k))) {
      return false;
    }
    this.j = AppConstants.SDCARD_FILE_SAVE_PATH;
    File localFile = new File(this.j);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    this.k = AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH;
    boolean bool = true;
    localFile = new File(this.k);
    if (!localFile.exists()) {
      bool = true | localFile.mkdirs();
    }
    return bool;
  }
  
  protected void n()
  {
    long l1 = new File(this.l).length();
    long l2 = l1;
    if (l1 == 0L)
    {
      QLog.i("TroopFileDownloadWorkerfile_debug", 1, "vfs file get length error. use normal try again.");
      File localFile = new File(this.l);
      try
      {
        l2 = localFile.length();
        l1 = l2;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("normal file get length exception: ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.i("TroopFileDownloadWorkerfile_debug", 1, ((StringBuilder)localObject2).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("normal file get length[");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append("]");
      QLog.i("TroopFileDownloadWorkerfile_debug", 1, ((StringBuilder)localObject1).toString());
      l2 = l1;
    }
    if ((this.e.ProgressTotal != 0L) && (l2 != this.e.ProgressTotal))
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).append("]  file size check fail. filesize:");
      ((StringBuilder)localObject1).append(this.e.ProgressTotal);
      ((StringBuilder)localObject1).append(" transSize:");
      ((StringBuilder)localObject1).append(l2);
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, ((StringBuilder)localObject1).toString());
      a(7, 704);
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.q, 305);
      new File(this.l).delete();
      this.e.ProgressValue = 0L;
      return;
    }
    if (this.e.FileName.length() > 85)
    {
      int i2 = this.e.FileName.lastIndexOf('.');
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      i2 = this.e.FileName.length() - 85;
      if (i1 == 0)
      {
        localObject1 = this.e;
        ((TroopFileTransferManager.Item)localObject1).FileName = ((TroopFileTransferManager.Item)localObject1).FileName.substring(0, 85);
      }
      else if (i1 > i2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.e.FileName.substring(0, i1 - i2));
        ((StringBuilder)localObject1).append(this.e.FileName.substring(i1));
        localObject1 = ((StringBuilder)localObject1).toString();
        this.e.FileName = ((String)localObject1);
      }
    }
    Object localObject2 = this.e.FileName;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.e.NameForSave))
    {
      localObject1 = localObject2;
      if (this.e.SafeCheckRes == 2) {
        localObject1 = this.e.NameForSave;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = o();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.j);
    ((StringBuilder)localObject1).append((String)localObject2);
    this.m = new File(((StringBuilder)localObject1).toString()).getAbsoluteFile().toString();
    if (FileUtils.fileExists(this.m)) {
      this.m = FileManagerUtil.b(this.m);
    }
    boolean bool2 = FileManagerUtil.a(new File(this.l), new File(this.m));
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = FileManagerUtil.a(new File(this.l), new File(this.m));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("rename with vfs error, normalResult[");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("]");
      QLog.e("TroopFileDownloadWorker", 1, ((StringBuilder)localObject1).toString());
    }
    if (!bool1)
    {
      i1 = TroopFileTransferUtil.Log.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).append("] renameFile fail  mFilePath:");
      ((StringBuilder)localObject1).append(this.m);
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i1, ((StringBuilder)localObject1).toString());
      a(7, 706);
      a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.o, 307);
      return;
    }
    int i1 = TroopFileTransferUtil.Log.b;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[");
    ((StringBuilder)localObject1).append(this.f);
    ((StringBuilder)localObject1).append("] onDownlaodSuc  mFilePath:");
    ((StringBuilder)localObject1).append(this.m);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i1, ((StringBuilder)localObject1).toString());
    localObject1 = this.e;
    ((TroopFileTransferManager.Item)localObject1).LocalFile = this.m;
    i1 = FileManagerUtil.c(FileUtil.a(((TroopFileTransferManager.Item)localObject1).FileName));
    if (((i1 == 2) || (i1 == 0)) && (!FileUtil.d(this.e.getThumbnailFile(this.d, 383)))) {
      this.e.genThumb_Middle_OnGettedLargeOrOrigPic = true;
    }
    this.g = true;
    this.o = null;
    b(3);
    TroopFileDataCenter.a(this.d, this.e, 11);
    localObject1 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.e.Md5);
    localObject2 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.e.Sha);
    a(this.e.getInfo(this.d), (String)localObject1, (String)localObject2, this.e.Sha3);
    if (5 == FileManagerUtil.c(this.e.FileName))
    {
      localObject1 = TroopFileTransferUtil.a();
      if (localObject1 != null) {
        ((QQAppInterface)localObject1).getFileManagerEngine().i().a(this.d, this.e);
      }
    }
    a(0, 0);
    e();
    if (!b()) {
      r();
    }
    p();
    TroopTechReportUtils.b(TroopTechReportUtils.TroopFileReportResultCode.a, 0);
    this.e.retryTimes = 0;
    localObject1 = this.i;
    if (localObject1 != null) {
      ((TroopFileDownloadWorker.ITroopFileDownloadWorkerListener)localObject1).a(h(), true, 0, this);
    }
  }
  
  protected void p()
  {
    this.q.a();
    this.r = 0L;
    this.s = 0L;
  }
  
  protected final void q()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void r()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
 * JD-Core Version:    0.7.0.1
 */