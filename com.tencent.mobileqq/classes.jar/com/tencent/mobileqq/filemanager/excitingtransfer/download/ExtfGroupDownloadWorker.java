package com.tencent.mobileqq.filemanager.excitingtransfer.download;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfDownloadFileInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfGroupFileDownloader;
import com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.IExtfDownloaderSink;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataReporter.ReportTransferItem;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.download.ITroopFileDownloader;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.ITroopFileDownloadWorkerListener;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ExtfGroupDownloadWorker
  extends TroopFileDownloadWorker
  implements IExtfDownloaderSink
{
  static long jdField_b_of_type_Long = 0L;
  protected long a;
  private SparseIntArray a;
  protected boolean a;
  private SparseIntArray jdField_b_of_type_AndroidUtilSparseIntArray;
  
  protected ExtfGroupDownloadWorker(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    super(paramLong, paramItem, paramBundle, paramITroopFileDownloadWorkerListener);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    l();
    m();
  }
  
  private int a(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 300;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 0) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        if (paramInt1 == 101) {
          return 0;
        }
        i = paramInt2;
      } while (paramInt1 == 201);
      if (b(paramInt1)) {
        return h(paramInt2);
      }
      if (a(paramInt1)) {
        return b(paramInt1, paramInt2);
      }
      if (paramInt1 == 401) {
        return 301;
      }
      if (paramInt1 == 402) {
        return g(paramInt2);
      }
      if (paramInt1 == 403) {
        return f(paramInt2);
      }
      if (paramInt1 == 404) {
        return e(paramInt2);
      }
      if (paramInt1 == 408) {
        return d(paramInt2);
      }
      if (paramInt1 == 405) {
        return c(paramInt2);
      }
      if (paramInt1 == 406) {
        return b(paramInt2);
      }
      if (paramInt1 == 407) {
        return a(paramInt2);
      }
      if (paramInt1 == 504) {
        return 0;
      }
      if (d()) {
        return 703;
      }
      if (paramInt1 == 501) {
        return 708;
      }
      if (paramInt1 == 502) {
        return 709;
      }
      if (paramInt1 == 503) {
        return 705;
      }
      if (paramInt1 == 505) {
        return 706;
      }
      if (paramInt1 == 506) {
        return 703;
      }
      i = paramInt2;
    } while (paramInt2 != 0);
    return paramInt1;
  }
  
  private ExtfGroupDownloadWorker.DownloadCompleteInfo a()
  {
    ExtfGroupDownloadWorker.DownloadCompleteInfo localDownloadCompleteInfo = new ExtfGroupDownloadWorker.DownloadCompleteInfo(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader != null) && ((this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader instanceof ExtfGroupFileDownloader)))
    {
      ExtfGroupFileDownloader localExtfGroupFileDownloader = (ExtfGroupFileDownloader)this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader;
      localDownloadCompleteInfo.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = localExtfGroupFileDownloader.a();
      localDownloadCompleteInfo.jdField_a_of_type_Int = localExtfGroupFileDownloader.a();
    }
    return localDownloadCompleteInfo;
  }
  
  public static TroopFileDownloadWorker a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("ExcitingTransfer.ExtfGroupDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("ExcitingTransfer.ExtfGroupDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("ExcitingTransfer.ExtfGroupDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    return new ExtfGroupDownloadWorker(paramLong, paramItem, paramBundle, paramITroopFileDownloadWorkerListener);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    ExtfGroupDownloadWorker.DownloadCompleteInfo localDownloadCompleteInfo;
    ExtfGroupDownloadDataReport localExtfGroupDownloadDataReport;
    Object localObject;
    if (paramInt1 == 0)
    {
      bool = true;
      localDownloadCompleteInfo = a();
      localExtfGroupDownloadDataReport = new ExtfGroupDownloadDataReport(TroopFileTransferUtil.a());
      localObject = FileManagerUtil.g(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName);
      localExtfGroupDownloadDataReport.a(paramInt1, paramInt2, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin);
      if ((this.g <= 0L) || (this.h < this.g)) {
        break label193;
      }
      localExtfGroupDownloadDataReport.b(this.g);
      localExtfGroupDownloadDataReport.c(this.h);
      label100:
      if ((localDownloadCompleteInfo == null) || (localDownloadCompleteInfo.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo == null)) {
        break label208;
      }
      localExtfGroupDownloadDataReport.a(localDownloadCompleteInfo.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo);
    }
    for (;;)
    {
      localExtfGroupDownloadDataReport.a(this.jdField_a_of_type_Long);
      localExtfGroupDownloadDataReport.a(this.jdField_b_of_type_Int);
      if ((localDownloadCompleteInfo != null) && (localDownloadCompleteInfo.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null)) {
        localExtfGroupDownloadDataReport.b(QFileUtils.b(localDownloadCompleteInfo.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.mstrLastServerHost));
      }
      localExtfGroupDownloadDataReport.a(this.jdField_d_of_type_Boolean);
      localExtfGroupDownloadDataReport.b(bool);
      return;
      bool = false;
      break;
      label193:
      localExtfGroupDownloadDataReport.b(0L);
      localExtfGroupDownloadDataReport.c(0L);
      break label100;
      label208:
      localObject = new ExcitingTransferDownloadCompletedInfo();
      if (this.jdField_d_of_type_Long > 0L)
      {
        ((ExcitingTransferDownloadCompletedInfo)localObject).muStartTime = this.jdField_d_of_type_Long;
        ((ExcitingTransferDownloadCompletedInfo)localObject).muTotalTimes = (System.currentTimeMillis() - ((ExcitingTransferDownloadCompletedInfo)localObject).muStartTime);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).muStartSize = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Long > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).muDownloadedSize = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Long;
      }
      if (paramInt3 != 0) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).mnSrvReturnCode = paramInt3;
      }
      localExtfGroupDownloadDataReport.a((ExcitingTransferDownloadCompletedInfo)localObject);
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 304) || (paramInt == 305) || (paramInt == 306) || (paramInt == 307) || (paramInt == 308);
  }
  
  private int b(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 320;
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int i;
    if (!NetworkUtil.g(BaseApplication.getContext())) {
      i = 306;
    }
    do
    {
      return i;
      i = paramInt2;
    } while (paramInt2 != 0);
    if (paramInt1 == 305) {
      return 315;
    }
    if (paramInt1 == 306) {
      return 316;
    }
    return 314;
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303) || (paramInt == 400);
  }
  
  private int c(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 319;
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    return this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1, 9);
  }
  
  private int d(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 318;
  }
  
  private int d(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 5: 
    default: 
      return 5;
    case 0: 
      return 0;
    case 1: 
    case 2: 
      return 2;
    case 3: 
    case 4: 
    case 6: 
      return 4;
    case 7: 
      return 3;
    }
    return 1;
  }
  
  private boolean d()
  {
    if (SystemUtil.a()) {}
    for (long l1 = SystemUtil.a() * 1024L;; l1 = SystemUtil.b() * 1024L)
    {
      long l2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
      if ((l2 <= 0L) || (l2 <= l1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private int e(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 317;
  }
  
  private int f(int paramInt)
  {
    int i;
    if (!NetworkUtil.g(BaseApplication.getContext())) {
      i = 306;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 0);
    return 308;
  }
  
  private int g(int paramInt)
  {
    int i;
    if (!NetworkUtil.g(BaseApplication.getContext())) {
      i = 306;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 0);
    return 309;
  }
  
  private int h(int paramInt)
  {
    int i;
    if (!NetworkUtil.g(BaseApplication.getContext())) {
      i = 306;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 0);
    return 307;
  }
  
  private int i(int paramInt)
  {
    return this.jdField_b_of_type_AndroidUtilSparseIntArray.get(paramInt, paramInt);
  }
  
  private int j(int paramInt)
  {
    int i;
    if ((paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303) || (paramInt == 400) || (paramInt == 402) || (paramInt == 403))
    {
      i = paramInt;
      if (!NetworkUtil.g(BaseApplication.getContext())) {
        i = 3;
      }
    }
    do
    {
      return i;
      if ((paramInt == 501) || (paramInt == 502) || (paramInt == 503)) {
        break;
      }
      i = paramInt;
    } while (paramInt != 505);
    if (SystemUtil.a()) {}
    for (long l1 = SystemUtil.a() * 1024L;; l1 = SystemUtil.b() * 1024L)
    {
      long l2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
      i = paramInt;
      if (l2 <= 0L) {
        break;
      }
      i = paramInt;
      if (l2 <= l1) {
        break;
      }
      return 506;
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseIntArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    }
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(0, 0);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(101, 8);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(201, 9);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(300, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(301, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(302, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(303, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(304, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(305, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(306, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(307, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(308, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(400, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(401, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(402, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(403, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(404, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(405, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(406, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(407, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(408, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(501, 7);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(502, 7);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(503, 7);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(505, 7);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(506, 7);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(504, 6);
  }
  
  private void m()
  {
    if (this.jdField_b_of_type_AndroidUtilSparseIntArray == null) {
      this.jdField_b_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    }
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(0, 0);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(1, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(100, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(101, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(102, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(2, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(3, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(302, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(303, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(304, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(305, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(313, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(309, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(312, 402);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(301, 401);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(300, 407);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(306, 303);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(4, 303);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(307, 303);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(308, 303);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(314, 304);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(315, 305);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(316, 306);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(317, 404);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(318, 408);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(319, 405);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(320, 406);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(5, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(501, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(502, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(503, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(504, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(701, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(702, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(704, 504);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(708, 501);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(709, 502);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(707, 502);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(700, 502);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(710, 506);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(703, 506);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(8, 9037);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(7, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(9, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(901, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(902, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(904, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(10, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(11, 201);
    this.jdField_b_of_type_AndroidUtilSparseIntArray.put(12, 201);
  }
  
  private void n()
  {
    int i = 2;
    if (this.jdField_d_of_type_Long != 0L) {
      i = 3;
    }
    ExtfGroupDownloadDataReport localExtfGroupDownloadDataReport = new ExtfGroupDownloadDataReport(TroopFileTransferUtil.a());
    Object localObject = FileManagerUtil.g(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName);
    localExtfGroupDownloadDataReport.a(1, i, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin);
    if ((this.g > 0L) && (this.h >= this.g))
    {
      localExtfGroupDownloadDataReport.b(this.g);
      localExtfGroupDownloadDataReport.c(this.h);
    }
    for (;;)
    {
      localObject = new ExcitingTransferDownloadCompletedInfo();
      if (this.jdField_d_of_type_Long > 0L)
      {
        ((ExcitingTransferDownloadCompletedInfo)localObject).muStartTime = this.jdField_d_of_type_Long;
        ((ExcitingTransferDownloadCompletedInfo)localObject).muTotalTimes = (System.currentTimeMillis() - ((ExcitingTransferDownloadCompletedInfo)localObject).muStartTime);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).muStartSize = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Long > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).muDownloadedSize = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Long;
      }
      localExtfGroupDownloadDataReport.a((ExcitingTransferDownloadCompletedInfo)localObject);
      localExtfGroupDownloadDataReport.a(this.jdField_a_of_type_Long);
      localExtfGroupDownloadDataReport.a(this.jdField_b_of_type_Int);
      localExtfGroupDownloadDataReport.a(this.jdField_d_of_type_Boolean);
      localExtfGroupDownloadDataReport.b(false);
      return;
      localExtfGroupDownloadDataReport.b(0L);
      localExtfGroupDownloadDataReport.c(0L);
    }
  }
  
  public int a()
  {
    if (b())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader == null) {
        return 0;
      }
      return QFileUtils.b(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadITroopFileDownloader.e());
    }
    return super.a();
  }
  
  public int a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int i = 0;
    if (b())
    {
      paramInt2 = i;
      if (paramBundle != null) {
        paramInt2 = paramBundle.getInt("nSrvReturnCode", 0);
      }
      return a(paramInt1, paramInt2);
    }
    return super.a(paramInt1, paramInt2, paramBundle);
  }
  
  public int a(int paramInt, Bundle paramBundle)
  {
    int i = 0;
    if (b())
    {
      if (paramBundle != null) {
        i = paramBundle.getInt("nSrvReturnCode", 0);
      }
      return c(paramInt, i);
    }
    return super.a(paramInt, paramBundle);
  }
  
  public ITroopFileDownloader a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "^_^ nSessionID[" + paramLong + "] get ExtfFileDownloader. bIsHttps:" + paramBoolean + " strHttpsDomain:" + paramString3 + " urlParams:" + paramString2);
    this.jdField_a_of_type_Long = paramLong;
    if (FileManagerUtil.b(paramString1)) {
      this.jdField_a_of_type_Boolean = true;
    }
    ExtfDownloadFileInfo localExtfDownloadFileInfo = new ExtfDownloadFileInfo();
    localExtfDownloadFileInfo.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal);
    localExtfDownloadFileInfo.b(paramString2);
    localExtfDownloadFileInfo.c(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue);
    int i = 80;
    localExtfDownloadFileInfo.a(paramBoolean);
    localExtfDownloadFileInfo.d(paramString3);
    if (paramBoolean) {
      i = 443;
    }
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName;
    paramString2 = paramString3;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave))
    {
      paramString2 = paramString3;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.SafeCheckRes == 2) {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave;
      }
    }
    paramString3 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString3 = a();
    }
    localExtfDownloadFileInfo.a(paramString3);
    paramString2 = new ArrayList();
    paramString2.add(new ExcitingTransferHostInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp, i));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
    {
      paramString3 = new ExcitingTransferHostInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, i);
      if (FileIPv6StrateyController.a().a(paramQQAppInterface, 3))
      {
        QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] exciting download troopfile. is config enable IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
        Object localObject = new FileIPv6StrateyController.DomainInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, i);
        localObject = FileIPv6StrateyController.a().a(paramQQAppInterface, (FileIPv6StrateyController.DomainInfo)localObject, 3);
        if ((localObject != null) && (!((FileIPv6StrateyController.IPListInfo)localObject).a()))
        {
          if (FileIPv6StrateyController.a())
          {
            QLog.d("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] exciting download troopfile. debugIsDisableIPv4OnDoubleStack");
            paramString2.clear();
          }
          i = ((FileIPv6StrateyController.IPListInfo)localObject).jdField_a_of_type_JavaUtilList.size() - 1;
          while (i >= 0)
          {
            paramString3 = (FileIPv6StrateyController.IPInfo)((FileIPv6StrateyController.IPListInfo)localObject).jdField_a_of_type_JavaUtilList.get(i);
            paramString2.add(0, new ExcitingTransferHostInfo(paramString3.a(), paramString3.jdField_a_of_type_Int));
            i -= 1;
          }
          this.jdField_b_of_type_Int = 2;
          if (((FileIPv6StrateyController.IPListInfo)localObject).jdField_a_of_type_Int == 1) {
            this.jdField_b_of_type_Int = 3;
          }
          QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] exciting download troopfile use IPv6. iplist:" + paramString2.toString());
        }
      }
    }
    for (;;)
    {
      localExtfDownloadFileInfo.a(paramString2);
      paramQQAppInterface = ExtfGroupFileDownloader.a(paramQQAppInterface, paramLong, this.jdField_c_of_type_Long, paramString1, localExtfDownloadFileInfo);
      if (paramQQAppInterface == null) {
        break;
      }
      ((ExtfGroupFileDownloader)paramQQAppInterface).a(this);
      return paramQQAppInterface;
      QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] exciting download troopfile use IPv4");
      paramString2.add(paramString3);
      this.jdField_b_of_type_Int = 1;
      continue;
      paramString2.add(paramString3);
      this.jdField_b_of_type_Int = 1;
      continue;
      this.jdField_b_of_type_Int = 1;
    }
    QLog.e("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "^_^ [" + this.jdField_a_of_type_JavaLangString + "] get ExtfFileDownloader fail.");
    return paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_d_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = "";
    }
    super.a(paramInt);
  }
  
  public void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo) {}
  
  public void a(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    int j = 3;
    if (paramExcitingTransferOneSlotComplete != null) {}
    for (int i = paramExcitingTransferOneSlotComplete.mSrvRetCode;; i = 0)
    {
      a(c(paramInt, i), a(paramInt, i));
      ExtfGroupDownloaderDataReport localExtfGroupDownloaderDataReport;
      String str;
      if (paramInt != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_e_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.f = 0;
        j();
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 0;
        if (paramExcitingTransferOneSlotComplete == null) {
          break label222;
        }
        localExtfGroupDownloaderDataReport = new ExtfGroupDownloaderDataReport(TroopFileTransferUtil.a());
        localExtfGroupDownloaderDataReport.a(this.jdField_a_of_type_Long);
        str = FileManagerUtil.g(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName);
        i = j(paramInt);
        if (i != 3) {
          break label207;
        }
        paramInt = 5;
      }
      for (;;)
      {
        localExtfGroupDownloaderDataReport.a(paramInt, i, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin);
        localExtfGroupDownloaderDataReport.a(paramExcitingTransferOneSlotComplete);
        localExtfGroupDownloaderDataReport.a(this.jdField_b_of_type_Int);
        localExtfGroupDownloaderDataReport.b(QFileUtils.b(paramExcitingTransferOneSlotComplete.mstrIp));
        localExtfGroupDownloaderDataReport.a(this.jdField_d_of_type_Boolean);
        localExtfGroupDownloaderDataReport.a();
        return;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d = 0;
        k();
        break;
        label207:
        paramInt = j;
        if (i != 506) {
          paramInt = 4;
        }
      }
      label222:
      QLog.e("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] onExtfSubUploaderResult DataReport fail. no rp");
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    if ((paramExcitingTransferDownloadSpeedInfo == null) || (paramExcitingTransferDownloadSpeedInfo.mTotalSpeed == 0)) {
      return;
    }
    long l = paramExcitingTransferDownloadSpeedInfo.mTotalSpeed;
    float f;
    if (l > 1048576L)
    {
      f = (float)l / 1048576.0F;
      paramExcitingTransferDownloadSpeedInfo = new DecimalFormat("0.00").format(f);
      paramExcitingTransferDownloadSpeedInfo = "加速下载 " + paramExcitingTransferDownloadSpeedInfo + "MB/s";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = paramExcitingTransferDownloadSpeedInfo;
      return;
      if (l > 1024L)
      {
        f = (float)l / 1024.0F;
        paramExcitingTransferDownloadSpeedInfo = new DecimalFormat("0.00").format(f);
        paramExcitingTransferDownloadSpeedInfo = "加速下载 " + paramExcitingTransferDownloadSpeedInfo + "KB/s";
      }
      else
      {
        paramExcitingTransferDownloadSpeedInfo = "加速下载 " + l + "KB/s";
      }
    }
  }
  
  public void a(String paramString)
  {
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = "";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal >= this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long) {
        this.jdField_e_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long);
      }
      if (!FileUtils.a(paramString))
      {
        TroopFileTransferUtil.Log.a("ExcitingTransfer.ExtfGroupDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "]  onDownloadSuccess but file is not exsited." + paramString);
        a(7, 706);
        a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.o, 307);
      }
      do
      {
        return;
        long l = FileManagerUtil.a(paramString);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal != 0L) && (l != this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal))
        {
          TroopFileTransferUtil.Log.a("ExcitingTransfer.ExtfGroupDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "]  file size check fail. filesize:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal + " transSize:" + l);
          a(7, 704);
          a(true, TroopTechReportUtils.TroopFileReportResultCode.jdField_b_of_type_Int, TroopTechReportUtils.TroopFileReportResultCode.q, 305);
          new File(paramString).delete();
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = 0L;
          return;
        }
        TroopFileTransferUtil.Log.c("ExcitingTransfer.ExtfGroupDownloadWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onDownlaodSuc  mFilePath:" + paramString);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile = paramString;
        int i = FileManagerUtil.a(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName));
        if (((i == 2) || (i == 0)) && (!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_c_of_type_Long, 383)))) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
        }
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = null;
        b(3);
        TroopFileDataCenter.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 11);
        paramString = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
        String str = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
        a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_c_of_type_Long), paramString, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
        if (5 == FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName))
        {
          paramString = TroopFileTransferUtil.a();
          if (paramString != null) {
            paramString.getFileManagerEngine().a().a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
          }
        }
        a(0, 0);
        c();
        i();
        TroopTechReportUtils.b(TroopTechReportUtils.TroopFileReportResultCode.jdField_a_of_type_Int, 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadWorker$ITroopFileDownloadWorkerListener == null);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadWorker$ITroopFileDownloadWorkerListener.a(a(), true, 0, this);
      return;
    }
    super.a(paramString);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    return super.a();
  }
  
  public void b()
  {
    int k = 1;
    int n = 0;
    super.b();
    if (b())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int == 8) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int == 11) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int == 12)) {
        n();
      }
    }
    else {
      return;
    }
    ExtfGroupDownloadWorker.DownloadCompleteInfo localDownloadCompleteInfo = a();
    int j;
    int i;
    if ((localDownloadCompleteInfo != null) && (localDownloadCompleteInfo.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null))
    {
      j = j(localDownloadCompleteInfo.jdField_a_of_type_Int);
      i = 4;
    }
    for (;;)
    {
      int m = i;
      if (k != 0)
      {
        if (j != 3) {
          break label204;
        }
        m = 5;
      }
      for (;;)
      {
        a(m, j, n);
        return;
        j = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d;
        i = j;
        if (j == 0) {
          i = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int;
        }
        if (this.jdField_d_of_type_Long == 0L)
        {
          k = d(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d);
          if (!this.jdField_c_of_type_Boolean) {
            break label220;
          }
          n = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.d;
          i = 2;
          j = 7;
          k = 0;
          break;
        }
        j = j(i(i));
        i = 4;
        break;
        label204:
        m = i;
        if (j == 506) {
          m = 3;
        }
      }
      label220:
      j = i;
      i = k;
      k = 0;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    float f;
    if (b())
    {
      ExtfGroupDownloadWorker.DownloadCompleteInfo localDownloadCompleteInfo = a();
      if ((localDownloadCompleteInfo != null) && (localDownloadCompleteInfo.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_a_of_type_Long = localDownloadCompleteInfo.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.muStartSize;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Long = localDownloadCompleteInfo.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.muDownloadedSize;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Long = localDownloadCompleteInfo.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.muTotalTimes;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Long <= 0L) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Long <= 0L)) {
          break label139;
        }
        f = (float)this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_c_of_type_Long / 1000.0F;
      }
    }
    label139:
    for (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_e_of_type_Long = (((float)this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_b_of_type_Long / f));; this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileDataReporter$ReportTransferItem.jdField_e_of_type_Long = 0L)
    {
      super.c();
      if (b()) {
        a(0, 0, 0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.ExtfGroupDownloadWorker
 * JD-Core Version:    0.7.0.1
 */