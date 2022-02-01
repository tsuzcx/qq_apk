package com.tencent.mobileqq.troop.filemanager.upload;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqResendFileObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqUploadFileObserver;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataReporter;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataReporter.ReportTransferItem;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.ProtoRequest;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public class TroopFileUploadWorker
  extends TroopFileUploadFeedsSender
  implements ITroopFileUploaderSink, TroopFileScaner.ITroopFileScanPrg, TroopFileUploadMgr.ITroopFileUploadWorker
{
  protected Bundle a;
  TroopFileReqResendFileObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqResendFileObserver = new TroopFileUploadWorker.2(this);
  TroopFileReqUploadFileObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqUploadFileObserver = new TroopFileUploadWorker.1(this);
  protected TroopFileDataReporter.ReportTransferItem a;
  protected TroopFileProtoReqMgr.ProtoRequest a;
  protected ITroopFileUploader a;
  protected TroopFileUploadMgr.ITroopFileUploadWorkerListener a;
  protected Timer a;
  protected boolean a;
  protected byte[] a;
  protected int b;
  protected boolean b;
  protected int c;
  protected long f = 0L;
  protected long g;
  protected long h = 0L;
  protected long i = 0L;
  protected long j = 0L;
  
  protected TroopFileUploadWorker(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileUploadMgr.ITroopFileUploadWorkerListener paramITroopFileUploadWorkerListener)
  {
    super(paramLong, paramItem);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem = new TroopFileDataReporter.ReportTransferItem();
    this.jdField_g_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener = paramITroopFileUploadWorkerListener;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  private boolean a(Bundle paramBundle, long paramLong)
  {
    if (paramLong != this.jdField_e_of_type_Long) {}
    do
    {
      return false;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(a())));
    if (this.jdField_a_of_type_Boolean)
    {
      TroopFileTransferUtil.Log.b("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onReqUploadFileResult.but stoped");
      return false;
    }
    return true;
  }
  
  public static TroopFileUploadWorker b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileUploadMgr.ITroopFileUploadWorkerListener paramITroopFileUploadWorkerListener)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. item.id=null");
    }
    return new TroopFileUploadWorker(paramLong, paramItem, paramBundle, paramITroopFileUploadWorkerListener);
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.a();
    this.h = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.i = 0L;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId;
  }
  
  protected int a(int paramInt)
  {
    return 3;
  }
  
  protected int a(int paramInt1, int paramInt2)
  {
    return TroopFileDataReporter.a(paramInt1, paramInt2);
  }
  
  protected ITroopFileUploader a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    int m = 2;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int != 7))
    {
      TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    a(8, 0);
    TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. mStatus:" + this.jdField_b_of_type_Int + " reason:" + paramInt);
    int k;
    if (this.jdField_b_of_type_Int == 1)
    {
      TroopFileScaner.a().a(this.f);
      e();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest != null)
      {
        TroopFileProtocol.a(TroopFileTransferUtil.a(), this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest);
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 1;
      k = 8;
      if (paramInt != 1) {
        break label299;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause = 2;
      k = 11;
    }
    for (;;)
    {
      TroopFileDataCenter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, m);
      b(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = k;
      c();
      p();
      return;
      if (this.jdField_b_of_type_Int != 3) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a();
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader = null;
        break;
      }
      TroopFileTransferUtil.Log.b("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop upload. uploader=null");
      break;
      label299:
      if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = -1;
        k = 12;
      }
      else if (paramInt == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = -1;
        k = 11;
        m = 3;
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.h();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = paramInt2;
    long l2 = this.i;
    long l1 = l2;
    if (paramInt1 == 0)
    {
      l1 = l2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a();
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.d();
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Boolean) {
          break label246;
        }
      }
    }
    label246:
    for (l1 = 0L;; l1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Long = l1;
      if (this.h != 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Long = (System.currentTimeMillis() - this.h);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Long <= 0L) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Long <= 0L)) {
          break;
        }
        float f1 = (float)this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Long / 1000.0F;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_e_of_type_Long = (((float)this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Long / f1));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_e_of_type_Long = 0L;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramLong > this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue) {}
    for (this.i += paramLong - this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;; this.i = paramLong)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = paramLong;
      paramLong = System.currentTimeMillis();
      if ((this.j != 0L) && (paramLong - this.j < 1500L)) {
        break;
      }
      this.j = paramLong;
      TroopFileDataCenter.b(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    int m = 0;
    int k = m;
    if (paramLong2 != 0L)
    {
      k = m;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal == 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal = paramLong2;
        k = 1;
      }
    }
    TroopTechReportUtils.a();
    if (k != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      TroopFileDataCenter.b(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Bundle paramBundle, int paramInt)
  {
    if (this.f != paramLong1) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      TroopFileTransferUtil.Log.b("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. but had stop");
      return;
    }
    if (this.jdField_g_of_type_Long != 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_g_of_type_Long = (System.currentTimeMillis() - this.jdField_g_of_type_Long);
      this.jdField_g_of_type_Long = 0L;
    }
    TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. errCode:" + paramInt);
    if (paramInt != 0)
    {
      int k = 1;
      int m = TroopTechReportUtils.TroopFileReportResultCode.l;
      if (paramInt == -2)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 5;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 501;
        k = 102;
        paramInt = TroopTechReportUtils.TroopFileReportResultCode.s;
      }
      for (;;)
      {
        a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, paramInt, k);
        return;
        if (paramInt == -1)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 7;
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 700;
          k = 201;
          paramInt = TroopTechReportUtils.TroopFileReportResultCode.jdField_g_of_type_Int;
        }
        else if (paramInt == -4)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 5;
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 502;
          k = 205;
          paramInt = TroopTechReportUtils.TroopFileReportResultCode.jdField_e_of_type_Int;
        }
        else if (paramInt == -3)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 7;
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 701;
          k = 203;
          paramInt = TroopTechReportUtils.TroopFileReportResultCode.j;
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 5;
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 503;
          paramInt = m;
        }
      }
    }
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. md5 or sha is null");
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 5;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 503;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.l, 211);
      return;
    }
    if ((paramLong2 != 0L) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal == 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal = paramLong2;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 = paramArrayOfByte1;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha = paramArrayOfByte2;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramArrayOfByte3);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte3;
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width = paramBundle.getInt("_with_", 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height = paramBundle.getInt("_height_", 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration = paramBundle.getInt("_duration_", 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
    TroopFileDataCenter.b(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    m();
  }
  
  protected final void a(TroopFileStatusInfo paramTroopFileStatusInfo, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.jdField_b_of_type_Long);
    localFileManagerEntity.peerNick = ContactUtils.o(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.jdField_e_of_type_Long;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = FileHttpUtils.a(FileManagerUtil.c(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = FileHttpUtils.a(FileManagerUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString));
      }
    }
    localFileManagerEntity.str10Md5 = com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(FileManagerUtil.e(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString).lastModified();
      label229:
      localQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      return;
    }
    catch (Exception paramTroopFileStatusInfo)
    {
      break label229;
    }
  }
  
  public void a(String paramString)
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onChangeUrl:" + paramString);
  }
  
  protected void a(oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody) {}
  
  protected void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload app=null");
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a(null);
    }
    String str1 = com.qq.taf.jce.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey);
    String str2 = com.qq.taf.jce.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
    long l = TroopFileTransferUtil.a();
    Object localObject2;
    boolean bool1;
    Object localObject1;
    if (b())
    {
      boolean bool2 = false;
      localObject2 = null;
      bool1 = bool2;
      localObject1 = localObject2;
      if (TroopFileUtils.a(localQQAppInterface))
      {
        bool1 = bool2;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns))
        {
          bool1 = true;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns;
        }
      }
      TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload. nSessionId:" + l + " use custom fileuploader bUseHttps:" + bool1 + " httpsDomain:" + (String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader = a(localQQAppInterface, l, paramBoolean, bool1, (String)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 9;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 904;
        a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      }
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp);
      if ((!paramBoolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns))) {
        if (FileIPv6StrateyController.a().a(localQQAppInterface, 3))
        {
          QLog.i("TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. is config enable IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
          localObject1 = new FileIPv6StrateyController.DomainInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns, 0);
          localObject1 = FileIPv6StrateyController.a().a(localQQAppInterface, (FileIPv6StrateyController.DomainInfo)localObject1, 3);
          if ((localObject1 != null) && (!((FileIPv6StrateyController.IPListInfo)localObject1).a()))
          {
            if (FileIPv6StrateyController.a())
            {
              QLog.d("TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. debugIsDisableIPv4OnDoubleStack");
              localArrayList.clear();
            }
            FileIPv6StrateyController.a(((FileIPv6StrateyController.IPListInfo)localObject1).jdField_a_of_type_JavaUtilList, localArrayList, true, false);
            this.jdField_c_of_type_Int = 2;
            if (((FileIPv6StrateyController.IPListInfo)localObject1).jdField_a_of_type_Int == 1) {
              this.jdField_c_of_type_Int = 3;
            }
            QLog.i("TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. use IPv6. iplist:" + localArrayList.toString());
          }
        }
      }
      for (;;)
      {
        bool1 = false;
        localObject2 = null;
        paramBoolean = bool1;
        localObject1 = localObject2;
        if (TroopFileUtils.a(localQQAppInterface))
        {
          paramBoolean = bool1;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns))
          {
            paramBoolean = true;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns;
          }
        }
        this.jdField_b_of_type_Boolean = paramBoolean;
        TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload. nSessionId:" + l + " UseLastUploadIp=false firstIP=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp + " bUseHttps:" + paramBoolean + " httpsDomain:" + (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader = TroopFileUploader.a(localQQAppInterface, l, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile, str1, str2, localArrayList, "/ftn_handler", paramBoolean, (String)localObject1);
        break;
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns);
        this.jdField_c_of_type_Int = 1;
        QLog.i("TroopFileUploadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. use IPv4");
        continue;
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns);
        this.jdField_c_of_type_Int = 1;
        continue;
        this.jdField_c_of_type_Int = 1;
      }
    }
    this.h = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a();
    b(3);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = null;
    e();
    b(6);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
    TroopFileDataCenter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
    c();
    p();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp;
      }
      TroopTechReportUtils.a(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileInvailDel  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener.a(a(), false, paramInt2, this);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = null;
    e();
    b(6);
    TroopFileDataCenter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, paramInt3);
    c();
    p();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp;
      }
      TroopTechReportUtils.a(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadErr  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2 + " troopFileError:" + paramInt3);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener.a(a(), false, paramInt2, this);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = null;
    e();
    b(6);
    TroopFileDataCenter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, paramSimpleErrorInfo);
    c();
    p();
    if (paramBoolean)
    {
      String str = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp)) {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp;
      }
      TroopTechReportUtils.a(paramInt1, paramInt2, str);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
    TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadErr  nReportResultCode:" + paramInt1 + " nReportSecResultCode:" + paramInt2 + " troopFileError:" + paramSimpleErrorInfo.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener.a(a(), false, paramInt2, this);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int k = TroopFileTransferUtil.a(paramString1);
    int n = k;
    if (k == 0) {
      n = TroopFileTransferUtil.b(paramString2);
    }
    int i7 = TroopFileTransferUtil.c(paramString1);
    int m;
    if (!paramBoolean)
    {
      k = a(paramInt);
      m = a(paramInt, i7);
      if (paramInt == 9050) {
        k = 4;
      }
      a(k, m);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_e_of_type_Int = i7;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.f = n;
      n();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.f = 0;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 0;
      return;
    }
    TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. upload fail. errCode:" + paramInt + " transferedSize:" + paramLong + " rspHeader:" + paramString2 + " errMsg:" + paramString1);
    int i3 = a(paramInt);
    int i5 = a(paramInt, i7);
    int i6 = 1;
    int i4 = TroopTechReportUtils.TroopFileReportResultCode.jdField_d_of_type_Int;
    int i1;
    int i2;
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      m = 306;
      i1 = TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int;
      paramInt = TroopTechReportUtils.TroopFileReportResultCode.k;
      k = 106;
      i2 = i3;
    }
    for (;;)
    {
      a(i2, m);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_e_of_type_Int = i7;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.f = n;
      a(true, i1, paramInt, k);
      return;
      if (paramInt == 9343)
      {
        m = 313;
        paramInt = TroopTechReportUtils.TroopFileReportResultCode.C;
        i1 = i4;
        k = i6;
        i2 = i3;
      }
      else if (paramInt == 9303)
      {
        i2 = 7;
        m = 707;
        i1 = TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int;
        paramInt = TroopTechReportUtils.TroopFileReportResultCode.j;
        k = 203;
      }
      else if (paramInt == 9042)
      {
        m = 311;
        paramInt = TroopTechReportUtils.TroopFileReportResultCode.jdField_g_of_type_Int;
        k = 206;
        i1 = i4;
        i2 = i3;
      }
      else if ((n == -38006) || (n == -38007) || (n == -38020))
      {
        m = 311;
        k = 206;
        paramInt = n;
        i1 = i4;
        i2 = i3;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.c())
      {
        i2 = 4;
        if (n != 0) {
          paramInt = n;
        }
        k = 105;
        i1 = i4;
        m = i5;
      }
      else
      {
        i1 = i4;
        k = i6;
        m = i5;
        i2 = i3;
        if (n != 0)
        {
          paramInt = n;
          i1 = i4;
          k = i6;
          m = i5;
          i2 = i3;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    a(3, 312);
    a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_d_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.v, 102);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.bExtfTransfer = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = false;
    boolean bool2;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("_wifi2mobile_resume_", false);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause == 2) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause = 0;
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filepath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile + " bResueFromW2MPause:" + bool1);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 0;
      if (!NetworkUtil.g(BaseApplication.getContext()))
      {
        TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] no network");
        this.jdField_a_of_type_Boolean = true;
        b(6);
        TroopFileDataCenter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, 106);
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 9;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 901;
        c();
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.a();
        TroopTechReportUtils.a(TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.k);
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 == null) {
        l();
      }
      for (;;)
      {
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath == null) {
          m();
        } else {
          b();
        }
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile;
  }
  
  protected void b()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqReUpload app=null");
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqReUpload");
    TroopFileDataCenter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 1);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = TroopFileProtocol.a(localQQAppInterface, this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqResendFileObserver);
    b(2);
  }
  
  protected void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.f != paramLong1) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ScanPos = paramLong2;
  }
  
  protected void b(boolean paramBoolean)
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadSuc. bHit:" + paramBoolean);
    e();
    b(5);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal;
    TroopFileDataCenter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 6);
    j();
    Object localObject = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
    String str = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
    a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_e_of_type_Long), (String)localObject, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Boolean = paramBoolean;
    a(0, 0);
    d();
    if (!b()) {
      o();
    }
    p();
    localObject = TroopFileTransferUtil.a();
    str = this.jdField_e_of_type_Long + "";
    StringBuilder localStringBuilder = new StringBuilder();
    if ("/".equals(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mParentId)) {}
    for (int k = 0;; k = 1)
    {
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_files", "", "oper", "upload_suc", 0, 0, str, k + "", "", "");
      TroopTechReportUtils.a(TroopTechReportUtils.TroopFileReportResultCode.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener.a(a(), true, 0, this);
      }
      return;
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height;
  }
  
  public String c()
  {
    return FileHttpUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
  }
  
  protected void c()
  {
    int k = 1;
    TroopFileDataReporter.ReportTransferItem localReportTransferItem;
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_g_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.h = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.i = e();
      localReportTransferItem = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
      if (!this.jdField_b_of_type_Boolean) {
        break label86;
      }
    }
    for (;;)
    {
      localReportTransferItem.j = k;
      TroopFileDataReporter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileUp", this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_g_of_type_Int = 0;
      break;
      label86:
      k = 0;
    }
  }
  
  public int d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration;
  }
  
  public String d()
  {
    return FileHttpUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
  }
  
  protected void d()
  {
    int k = 1;
    TroopFileDataReporter.ReportTransferItem localReportTransferItem;
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_g_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.h = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.i = e();
      localReportTransferItem = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
      if (!this.jdField_b_of_type_Boolean) {
        break label86;
      }
    }
    for (;;)
    {
      localReportTransferItem.j = k;
      TroopFileDataReporter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem, "actGroupFileUp");
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_g_of_type_Int = 0;
      break;
      label86:
      k = 0;
    }
  }
  
  public boolean d()
  {
    return true;
  }
  
  protected int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader == null) {
      return 0;
    }
    return QFileUtils.c(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a());
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    new Handler().postDelayed(new TroopFileUploadWorker.3(this), 200L);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    b(false);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onOutDate. upload fail");
    a(3, 302);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.f = -29120;
    a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_d_of_type_Int, -29120, 206);
  }
  
  public void i()
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onRetrySend");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a();
    }
    this.h = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.f = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_JavaLangString = "";
  }
  
  public void k()
  {
    TroopFileDataCenter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0);
    b(7);
  }
  
  protected void l()
  {
    TroopFileDataCenter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0);
    this.f = TroopFileScaner.a().a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile, this, null);
    if (this.f == 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 5;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 504;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    b(1);
    TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] scanFile. cookie:" + this.f);
  }
  
  protected void m()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqUploadFile app=null");
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 9;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_d_of_type_Int = 902;
      a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.w, 1);
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileUploadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqUploadFile");
    TroopFileDataCenter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 1);
    a();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = TroopFileProtocol.a(localQQAppInterface, Long.valueOf(this.jdField_e_of_type_Long).longValue(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqUploadFileObserver);
    b(2);
  }
  
  protected final void n()
  {
    int k = 1;
    TroopFileDataReporter.ReportTransferItem localReportTransferItem;
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_g_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.h = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.i = e();
      localReportTransferItem = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
      if (!this.jdField_b_of_type_Boolean) {
        break label86;
      }
    }
    for (;;)
    {
      localReportTransferItem.j = k;
      TroopFileDataReporter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, "actGroupFileUpDetail", this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_g_of_type_Int = 0;
      break;
      label86:
      k = 0;
    }
  }
  
  protected final void o()
  {
    int k = 1;
    TroopFileDataReporter.ReportTransferItem localReportTransferItem;
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_g_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.h = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.i = e();
      localReportTransferItem = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem;
      if (!this.jdField_b_of_type_Boolean) {
        break label86;
      }
    }
    for (;;)
    {
      localReportTransferItem.j = k;
      TroopFileDataReporter.a(this.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem, "actGroupFileUpDetail");
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_g_of_type_Int = 0;
      break;
      label86:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadWorker
 * JD-Core Version:    0.7.0.1
 */