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
  protected int a;
  protected Bundle a;
  TroopFileReqDownloadFileObserver a;
  protected ITroopFileProtoReq a;
  protected TroopFileDataReporter.ReportTransferItem a;
  protected ITroopFileDownloader a;
  protected TroopFileDownloadWorker.ITroopFileDownloadWorkerListener a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  protected int b;
  protected String b;
  protected boolean b;
  protected long c;
  protected String c;
  protected boolean c;
  protected long d;
  protected String d;
  protected boolean d;
  protected long e;
  protected String e;
  protected long f = 0L;
  protected long g = 0L;
  protected long h = 0L;
  
  protected TroopFileDownloadWorker(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem = new TroopFileDataReporter.ReportTransferItem();
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver = new TroopFileDownloadWorker.2(this);
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadWorker$ITroopFileDownloadWorkerListener = paramITroopFileDownloadWorkerListener;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {
      paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();
    } else {
      paramItem = "";
    }
    this.jdField_a_of_type_JavaLangString = paramItem;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: lconst_1
    //   4: invokestatic 95	java/lang/Thread:sleep	(J)V
    //   7: goto +12 -> 19
    //   10: astore_2
    //   11: goto +41 -> 52
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 98	java/lang/InterruptedException:printStackTrace	()V
    //   19: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   22: lstore_0
    //   23: new 106	java/text/SimpleDateFormat
    //   26: dup
    //   27: ldc 108
    //   29: getstatic 114	java/util/Locale:US	Ljava/util/Locale;
    //   32: invokespecial 117	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   35: new 119	java/util/Date
    //   38: dup
    //   39: lload_0
    //   40: invokespecial 121	java/util/Date:<init>	(J)V
    //   43: invokevirtual 125	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
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
    //   22	18	0	l	long
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
  
  public static TroopFileDownloadWorker b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    return new TroopFileDownloadWorker(paramLong, paramItem, paramBundle, paramITroopFileDownloadWorkerListener);
  }
  
  protected int a()
  {
    ITroopFileDownloader localITroopFileDownloader = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader;
    if (localITroopFileDownloader == null) {
      return 0;
    }
    return QFileUtils.c(localITroopFileDownloader.d());
  }
  
  protected int a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return TroopFileDataReporter.a(paramInt1, paramInt2);
  }
  
  protected int a(int paramInt, Bundle paramBundle)
  {
    return 3;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  protected ITroopFileDownloader a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    return null;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int != 5))
    {
      paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] stop. but had stoped. mStatus:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", paramInt, ((StringBuilder)localObject).toString());
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    int i = 8;
    a(8, 0);
    int j = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] stop. mStatus:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", j, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader;
    if (localObject != null)
    {
      ((ITroopFileDownloader)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq != null)
    {
      TroopFileProtocol.a(TroopFileTransferUtil.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
    ((TroopFileTransferManager.Item)localObject).Pausing = 1;
    j = 9;
    if (paramInt == 1) {
      ((TroopFileTransferManager.Item)localObject).W2MPause = 2;
    }
    for (paramInt = j;; paramInt = 10)
    {
      i = 11;
      j = paramInt;
      break;
      if (paramInt == 2)
      {
        ((TroopFileTransferManager.Item)localObject).Pausing = -1;
        i = 12;
        break;
      }
      if (paramInt != 3) {
        break;
      }
      ((TroopFileTransferManager.Item)localObject).Pausing = -1;
    }
    TroopFileDataCenter.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, j);
    b(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = i;
    b();
    i();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_JavaLangString = ((ITroopFileDownloader)localObject).d();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader.e();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader.c();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader.d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
    ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_c_of_type_Int = paramInt1;
    ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_d_of_type_Int = paramInt2;
    ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_b_of_type_Long = this.jdField_e_of_type_Long;
    if (this.jdField_d_of_type_Long != 0L)
    {
      ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_d_of_type_Long);
      if ((this.jdField_e_of_type_Long > 0L) && (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Long > 0L))
      {
        float f1 = (float)this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Long / 1000.0F;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_e_of_type_Long = (((float)this.jdField_e_of_type_Long / f1));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_e_of_type_Long = 0L;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (paramLong1 > this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue) {
      this.jdField_e_of_type_Long += paramLong1 - this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    } else {
      this.jdField_e_of_type_Long = paramLong1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = paramLong1;
    paramLong1 = System.currentTimeMillis();
    paramLong2 = this.f;
    if ((paramLong2 == 0L) || (paramLong1 - paramLong2 >= 1500L))
    {
      this.f = paramLong1;
      TroopFileDataCenter.b(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    }
  }
  
  protected final void a(TroopFileStatusInfo paramTroopFileStatusInfo, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramTroopFileStatusInfo = new StringBuilder();
      paramTroopFileStatusInfo.append("[");
      paramTroopFileStatusInfo.append(this.jdField_a_of_type_JavaLangString);
      paramTroopFileStatusInfo.append("] addFMEntity fail app=null ");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, paramTroopFileStatusInfo.toString());
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.jdField_b_of_type_Long);
    localFileManagerEntity.peerNick = ContactUtils.h(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.jdField_c_of_type_Long;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = FileHttpUtils.a(FileManagerUtil.b(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = FileHttpUtils.a(FileManagerUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString));
      }
    }
    localFileManagerEntity.str10Md5 = com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(FileManagerUtil.d(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString));
    try
    {
      localFileManagerEntity.localModifyTime = new File(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString).lastModified();
      label276:
      localQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      return;
    }
    catch (Exception paramTroopFileStatusInfo)
    {
      break label276;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal >= this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long) {
      this.jdField_e_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long);
    }
    h();
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    TroopFileTransferUtil.Log.a(paramString1, paramInt, paramString2);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq = null;
    b(4);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
    ((TroopFileTransferManager.Item)localObject).ErrorCode = 0;
    TroopFileDataCenter.a(this.jdField_c_of_type_Long, (TroopFileTransferManager.Item)localObject, 12);
    b();
    i();
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      } else {
        localObject = "";
      }
      TroopTechReportUtils.b(paramInt1, paramInt2, (String)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] onFileInvailDel  nReportResultCode:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" nReportSecResultCode:");
    ((StringBuilder)localObject).append(paramInt2);
    TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadWorker$ITroopFileDownloadWorkerListener;
    if (localObject != null) {
      ((TroopFileDownloadWorker.ITroopFileDownloadWorkerListener)localObject).a(a(), false, paramInt2, this);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq = null;
    b(4);
    TroopFileDataCenter.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, paramInt3);
    b();
    i();
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp;
      } else {
        localObject = "";
      }
      TroopTechReportUtils.b(paramInt1, paramInt2, (String)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] onDownloadErr  nReportResultCode:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" nReportSecResultCode:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" troopFileError:");
    ((StringBuilder)localObject).append(paramInt3);
    TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadWorker$ITroopFileDownloadWorkerListener;
    if (localObject != null) {
      ((TroopFileDownloadWorker.ITroopFileDownloadWorkerListener)localObject).a(a(), false, paramInt2, this);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    int n = TroopFileTransferUtil.a(paramString1);
    if (n == 0) {
      n = TroopFileTransferUtil.b(paramString2);
    }
    int i2 = TroopFileTransferUtil.c(paramString1);
    if (!paramBoolean)
    {
      i = a(paramInt, paramBundle);
      j = a(paramInt, i2, paramBundle);
      if (paramInt == 9050) {
        i = 4;
      }
      a(i, j);
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
      paramString1.jdField_e_of_type_Int = i2;
      paramString1.f = n;
      j();
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
      paramString1.jdField_e_of_type_Int = 0;
      paramString1.f = 0;
      paramString1.jdField_c_of_type_Int = 0;
      paramString1.jdField_d_of_type_Int = 0;
      return;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    paramString1 = new StringBuilder();
    paramString1.append("[");
    paramString1.append(this.jdField_a_of_type_JavaLangString);
    paramString1.append("] onHasErr. download fail. errCode:");
    paramString1.append(paramInt);
    paramString1.append(" transferedSize:");
    paramString1.append(paramLong);
    a("TroopFileDownloadWorker", i, paramString1.toString());
    i = a(paramInt, paramBundle);
    int j = a(paramInt, i2, paramBundle);
    int k = TroopTechReportUtils.TroopFileReportResultCode.jdField_d_of_type_Int;
    paramBoolean = NetworkUtil.isNetSupport(BaseApplication.getContext());
    int i1 = 106;
    int m = 7;
    if (!paramBoolean)
    {
      k = TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.k;
      m = i;
      j = 306;
      i = i1;
    }
    else if (paramInt == -5000)
    {
      j = 708;
      k = TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.h;
      i = 303;
    }
    else if (paramInt == -5001)
    {
      j = 709;
      k = TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.g;
      i = 304;
    }
    else if (paramInt == 9039)
    {
      j = 710;
      k = TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.n;
      i = 308;
    }
    else if (paramInt == 9004)
    {
      k = TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.k;
      j = 306;
      m = 3;
      i = i1;
    }
    else if (paramInt == 9301)
    {
      j = 705;
      k = TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.i;
      i = 306;
    }
    else if (paramInt == -5001)
    {
      j = 704;
      k = TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.q;
      i = 305;
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader.b())
    {
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.p;
      i = 105;
      m = 4;
    }
    else
    {
      if (n != 0) {
        paramInt = n;
      }
      i1 = 1;
      m = i;
      i = i1;
    }
    a(m, j);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
    paramString1.jdField_e_of_type_Int = i2;
    paramString1.f = n;
    a(true, k, paramInt, i);
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath))
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] start filepath is null");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
      return false;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Long = System.currentTimeMillis();
    this.g = 0L;
    this.h = 0L;
    this.jdField_d_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    boolean bool1;
    if (localObject != null)
    {
      boolean bool2 = ((Bundle)localObject).getBoolean("_wifi2mobile_resume_", false);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause = 0;
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] start filename:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName);
    ((StringBuilder)localObject).append(" filePath:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    ((StringBuilder)localObject).append(" bResueFromW2MPause:");
    ((StringBuilder)localObject).append(bool1);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 0;
    localObject = TroopFileTransferUtil.a(this.jdField_c_of_type_Long);
    if (localObject != null)
    {
      localObject = ((TroopFileManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.h = ((TroopFileInfo)localObject).jdField_c_of_type_Int;
      }
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] no network");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
      this.jdField_b_of_type_Boolean = true;
      b(4);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
      ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_c_of_type_Int = 9;
      ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_d_of_type_Int = 901;
      b();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.a();
      TroopFileDataCenter.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 10, 106);
      TroopTechReportUtils.b(TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.k);
      return false;
    }
    ThreadManager.post(new TroopFileDownloadWorker.1(this), 8, null, false);
    return true;
  }
  
  protected void b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("] onChangeUrl:");
    localStringBuilder.append(paramString);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i, localStringBuilder.toString());
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void c()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected boolean c()
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      return false;
    }
    this.jdField_b_of_type_JavaLangString = AppConstants.SDCARD_FILE_SAVE_PATH;
    File localFile = new File(this.jdField_b_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    this.jdField_c_of_type_JavaLangString = AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH;
    boolean bool = true;
    localFile = new File(this.jdField_c_of_type_JavaLangString);
    if (!localFile.exists()) {
      bool = true | localFile.mkdirs();
    }
    return bool;
  }
  
  public void d()
  {
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] onRetryDownload");
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader;
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = ((ITroopFileDownloader)localObject).b();
    }
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
    ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_e_of_type_Int = 0;
    ((TroopFileDataReporter.ReportTransferItem)localObject).f = 0;
    ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_c_of_type_Int = -1;
    ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_d_of_type_Int = 0;
    ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_c_of_type_JavaLangString = "";
    ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_d_of_type_JavaLangString = "";
  }
  
  public void e()
  {
    TroopFileDataCenter.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    b(5);
  }
  
  protected void f()
  {
    this.jdField_c_of_type_Boolean = false;
    TroopFileDataCenter.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 8);
    Object localObject1 = TroopFileTransferUtil.a();
    if (localObject1 == null)
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("] reqDownload app=null");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject1).toString());
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
      ((TroopFileDataReporter.ReportTransferItem)localObject1).jdField_c_of_type_Int = 9;
      ((TroopFileDataReporter.ReportTransferItem)localObject1).jdField_d_of_type_Int = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("] reqDownload");
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i, ((StringBuilder)localObject2).toString());
    Object localObject3 = TroopFileTransferUtil.a(this.jdField_c_of_type_Long);
    if (localObject3 != null)
    {
      localObject2 = ((TroopFileManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
      if (localObject2 != null)
      {
        localObject3 = ((TroopFileManager)localObject3).a(((TroopFileInfo)localObject2).g);
        if (localObject3 != null)
        {
          ((TroopFileInfo)localObject2).jdField_e_of_type_Int = 8;
          ((TroopFileInfo)localObject3).a((TroopFileInfo)localObject2);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq = TroopFileProtocol.a((QQAppInterface)localObject1, this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, false, false, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver);
    b(1);
    this.g = MessageCache.a();
    TroopTechReportUtils.b();
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] startDownload app=null");
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
      ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_c_of_type_Int = 9;
      ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_d_of_type_Int = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader;
    if (localObject != null)
    {
      ((ITroopFileDownloader)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader = null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/ftn_handler/");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl);
    ((StringBuilder)localObject).append("/?fname=");
    ((StringBuilder)localObject).append(com.tencent.mobileqq.utils.HexUtil.String2HexString(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath));
    String str = ((StringBuilder)localObject).toString();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
    boolean bool2 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
    boolean bool1 = false;
    if (!bool2)
    {
      if (FileIPv6StrateyController.a().isConfigEnableIPV6(localQQAppInterface, 3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("] [IPv6-File] download troopfile. is config enable IPv6. domain[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
        ((StringBuilder)localObject).append("]");
        QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject).toString());
        localObject = new FileIPv6StrateyController.DomainInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, 0);
        localObject = FileIPv6StrateyController.a().getIPlistForV6Domain(localQQAppInterface, (FileIPv6StrateyController.DomainInfo)localObject, 3);
        if ((localObject != null) && (!((FileIPv6StrateyController.IPListInfo)localObject).a()))
        {
          if (FileIPv6StrateyController.a())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[");
            localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
            localStringBuilder.append("] [IPv6-File] download troopfile. debugIsDisableIPv4OnDoubleStack");
            QLog.d("TroopFileDownloadWorker", 1, localStringBuilder.toString());
            localArrayList.clear();
          }
          FileIPv6StrateyController.a(((FileIPv6StrateyController.IPListInfo)localObject).jdField_a_of_type_JavaUtilList, localArrayList, true, false);
          this.jdField_b_of_type_Int = 2;
          if (((FileIPv6StrateyController.IPListInfo)localObject).jdField_a_of_type_Int == 1) {
            this.jdField_b_of_type_Int = 3;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("] [IPv6-File] download troopfile. use IPv6. iplist:");
          ((StringBuilder)localObject).append(localArrayList.toString());
          QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("] [IPv6-File] download troopfile. use IPv4");
          QLog.i("TroopFileDownloadWorker", 1, ((StringBuilder)localObject).toString());
          localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
          this.jdField_b_of_type_Int = 1;
        }
      }
      else
      {
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS);
        this.jdField_b_of_type_Int = 1;
      }
    }
    else {
      this.jdField_b_of_type_Int = 1;
    }
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long = FileUtil.a(this.jdField_d_of_type_JavaLangString);
    long l = TroopFileTransferUtil.a();
    if ((TroopFileUtils.a(localQQAppInterface)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS;
      bool1 = true;
    }
    else
    {
      localObject = null;
    }
    this.jdField_d_of_type_Boolean = bool1;
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("] startDownload. nSessionId:");
    localStringBuilder.append(l);
    localStringBuilder.append(" firstIP=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp);
    localStringBuilder.append(" urlParams:");
    localStringBuilder.append(str);
    localStringBuilder.append(" mTmpFilePath:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(" bUseHttps:");
    localStringBuilder.append(bool1);
    localStringBuilder.append(" httpsDomain:");
    localStringBuilder.append((String)localObject);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i, localStringBuilder.toString());
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader = a(localQQAppInterface, l, this.jdField_d_of_type_JavaLangString, str, bool1, (String)localObject);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader = TroopFileDownloader.a(localQQAppInterface, l, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, localArrayList, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue, bool1, (String)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader;
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
      ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_c_of_type_Int = 9;
      ((TroopFileDataReporter.ReportTransferItem)localObject).jdField_d_of_type_Int = 903;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    ((ITroopFileDownloader)localObject).a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader.b();
    b(2);
  }
  
  protected void h()
  {
    long l1 = new File(this.jdField_d_of_type_JavaLangString).length();
    long l2 = l1;
    if (l1 == 0L)
    {
      QLog.i("TroopFileDownloadWorkerfile_debug", 1, "vfs file get length error. use normal try again.");
      File localFile = new File(this.jdField_d_of_type_JavaLangString);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal != 0L) && (l2 != this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal))
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("]  file size check fail. filesize:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal);
      ((StringBuilder)localObject1).append(" transSize:");
      ((StringBuilder)localObject1).append(l2);
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject1).toString());
      a(7, 704);
      a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.q, 305);
      new File(this.jdField_d_of_type_JavaLangString).delete();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = 0L;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.length() > 85)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.lastIndexOf('.');
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.length() - 85;
      if (i == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
        ((TroopFileTransferManager.Item)localObject1).FileName = ((TroopFileTransferManager.Item)localObject1).FileName.substring(0, 85);
      }
      else if (i > j)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(0, i - j));
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName.substring(i));
        localObject1 = ((StringBuilder)localObject1).toString();
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName = ((String)localObject1);
      }
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.SafeCheckRes == 2) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = a();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append((String)localObject2);
    this.jdField_e_of_type_JavaLangString = new File(((StringBuilder)localObject1).toString()).getAbsoluteFile().toString();
    if (FileUtils.fileExists(this.jdField_e_of_type_JavaLangString)) {
      this.jdField_e_of_type_JavaLangString = FileManagerUtil.b(this.jdField_e_of_type_JavaLangString);
    }
    boolean bool2 = FileManagerUtil.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_e_of_type_JavaLangString));
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = FileManagerUtil.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_e_of_type_JavaLangString));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("rename with vfs error, normalResult[");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("]");
      QLog.e("TroopFileDownloadWorker", 1, ((StringBuilder)localObject1).toString());
    }
    if (!bool1)
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("] renameFile fail  mFilePath:");
      ((StringBuilder)localObject1).append(this.jdField_e_of_type_JavaLangString);
      TroopFileTransferUtil.Log.a("TroopFileDownloadWorker", i, ((StringBuilder)localObject1).toString());
      a(7, 706);
      a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.o, 307);
      return;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("] onDownlaodSuc  mFilePath:");
    ((StringBuilder)localObject1).append(this.jdField_e_of_type_JavaLangString);
    TroopFileTransferUtil.Log.c("TroopFileDownloadWorker", i, ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
    ((TroopFileTransferManager.Item)localObject1).LocalFile = this.jdField_e_of_type_JavaLangString;
    i = FileManagerUtil.a(FileUtil.a(((TroopFileTransferManager.Item)localObject1).FileName));
    if (((i == 2) || (i == 0)) && (!FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_c_of_type_Long, 383)))) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq = null;
    b(3);
    TroopFileDataCenter.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 11);
    localObject1 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
    localObject2 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
    a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_c_of_type_Long), (String)localObject1, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
    if (5 == FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName))
    {
      localObject1 = TroopFileTransferUtil.a();
      if (localObject1 != null) {
        ((QQAppInterface)localObject1).getFileManagerEngine().a().a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      }
    }
    a(0, 0);
    c();
    if (!b()) {
      k();
    }
    i();
    TroopTechReportUtils.b(TroopTechReportUtils.TroopFileReportResultCode.jdField_a_of_type_Int, 0);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadWorker$ITroopFileDownloadWorkerListener;
    if (localObject1 != null) {
      ((TroopFileDownloadWorker.ITroopFileDownloadWorkerListener)localObject1).a(a(), true, 0, this);
    }
  }
  
  protected void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.a();
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
  }
  
  protected final void j()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void k()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
 * JD-Core Version:    0.7.0.1
 */