package com.tencent.mobileqq.filemanager.excitingtransfer.download;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
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
  static long c;
  private SparseIntArray A;
  private SparseIntArray B;
  protected long a = 0L;
  protected boolean b = false;
  
  protected ExtfGroupDownloadWorker(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    super(paramLong, paramItem, paramBundle, paramITroopFileDownloadWorkerListener);
    t();
    v();
  }
  
  public static TroopFileDownloadWorker a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener paramITroopFileDownloadWorkerListener)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("ExcitingTransfer.ExtfGroupDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("ExcitingTransfer.ExtfGroupDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("ExcitingTransfer.ExtfGroupDownloadWorker", TroopFileTransferUtil.Log.b, "getWoker. item.id=null");
      return null;
    }
    return new ExtfGroupDownloadWorker(paramLong, paramItem, paramBundle, paramITroopFileDownloadWorkerListener);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt1 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ExtfGroupDownloadWorker.DownloadCompleteInfo localDownloadCompleteInfo = u();
    ExtfGroupDownloadDataReport localExtfGroupDownloadDataReport = new ExtfGroupDownloadDataReport(TroopFileTransferUtil.a());
    Object localObject = FileManagerUtil.t(this.e.FileName);
    localExtfGroupDownloadDataReport.a(paramInt1, paramInt2, (String)localObject, this.e.ProgressTotal, this.e.troopuin);
    if ((this.u > 0L) && (this.v >= this.u))
    {
      localExtfGroupDownloadDataReport.b(this.u);
      localExtfGroupDownloadDataReport.c(this.v);
    }
    else
    {
      localExtfGroupDownloadDataReport.b(0L);
      localExtfGroupDownloadDataReport.c(0L);
    }
    if ((localDownloadCompleteInfo != null) && (localDownloadCompleteInfo.a != null))
    {
      localExtfGroupDownloadDataReport.a(localDownloadCompleteInfo.a);
    }
    else
    {
      localObject = new ExcitingTransferDownloadCompletedInfo();
      if (this.r > 0L)
      {
        ((ExcitingTransferDownloadCompletedInfo)localObject).muStartTime = this.r;
        ((ExcitingTransferDownloadCompletedInfo)localObject).muTotalTimes = (System.currentTimeMillis() - ((ExcitingTransferDownloadCompletedInfo)localObject).muStartTime);
      }
      if (this.q.e > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).muStartSize = this.q.e;
      }
      if (this.q.f > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).muDownloadedSize = this.q.f;
      }
      if (paramInt3 != 0) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).mnSrvReturnCode = paramInt3;
      }
      localExtfGroupDownloadDataReport.a((ExcitingTransferDownloadCompletedInfo)localObject);
    }
    localExtfGroupDownloadDataReport.a(this.a);
    localExtfGroupDownloadDataReport.a(this.x);
    if ((localDownloadCompleteInfo != null) && (localDownloadCompleteInfo.a != null)) {
      localExtfGroupDownloadDataReport.b(QFileUtils.b(localDownloadCompleteInfo.a.mstrLastServerHost));
    }
    localExtfGroupDownloadDataReport.a(this.y);
    localExtfGroupDownloadDataReport.b(bool);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    if (paramInt1 == 101) {
      return 0;
    }
    if (paramInt1 == 201) {
      return paramInt2;
    }
    if (l(paramInt1)) {
      return k(paramInt2);
    }
    if (j(paramInt1)) {
      return c(paramInt1, paramInt2);
    }
    if (paramInt1 == 401) {
      return 301;
    }
    if (paramInt1 == 402) {
      return i(paramInt2);
    }
    if (paramInt1 == 403) {
      return h(paramInt2);
    }
    if (paramInt1 == 404) {
      return g(paramInt2);
    }
    if (paramInt1 == 408) {
      return f(paramInt2);
    }
    if (paramInt1 == 405) {
      return e(paramInt2);
    }
    if (paramInt1 == 406) {
      return d(paramInt2);
    }
    if (paramInt1 == 407) {
      return c(paramInt2);
    }
    if (paramInt1 == 504) {
      return 0;
    }
    if (s()) {
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
    if (paramInt2 != 0) {
      paramInt1 = paramInt2;
    }
    return paramInt1;
  }
  
  private int c(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 300;
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
      return 306;
    }
    if (paramInt2 != 0) {
      return paramInt2;
    }
    if (paramInt1 == 305) {
      return 315;
    }
    if (paramInt1 == 306) {
      return 316;
    }
    return 314;
  }
  
  private int d(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 320;
  }
  
  private int d(int paramInt1, int paramInt2)
  {
    return this.A.get(paramInt1, 9);
  }
  
  private int e(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 319;
  }
  
  private int e(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 5: 
    default: 
      return 5;
    case 8: 
      return 1;
    case 7: 
      return 3;
    case 3: 
    case 4: 
    case 6: 
      return 4;
    case 1: 
    case 2: 
      return 2;
    }
    return 0;
  }
  
  private int f(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 318;
  }
  
  private int g(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return 317;
  }
  
  private int h(int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
      return 306;
    }
    if (paramInt != 0) {
      return paramInt;
    }
    return 308;
  }
  
  private int i(int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
      return 306;
    }
    if (paramInt != 0) {
      return paramInt;
    }
    return 309;
  }
  
  private boolean j(int paramInt)
  {
    return (paramInt == 304) || (paramInt == 305) || (paramInt == 306) || (paramInt == 307) || (paramInt == 308);
  }
  
  private int k(int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
      return 306;
    }
    if (paramInt != 0) {
      return paramInt;
    }
    return 307;
  }
  
  private boolean l(int paramInt)
  {
    return (paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303) || (paramInt == 400);
  }
  
  private int m(int paramInt)
  {
    return this.B.get(paramInt, paramInt);
  }
  
  private int n(int paramInt)
  {
    int i;
    if ((paramInt != 300) && (paramInt != 301) && (paramInt != 302) && (paramInt != 303) && (paramInt != 400) && (paramInt != 402) && (paramInt != 403))
    {
      if ((paramInt != 501) && (paramInt != 502) && (paramInt != 503))
      {
        i = paramInt;
        if (paramInt != 505) {}
      }
      else
      {
        long l1;
        if (SystemUtil.a()) {
          l1 = SystemUtil.b();
        } else {
          l1 = SystemUtil.c();
        }
        long l2 = this.e.ProgressTotal - this.e.ProgressValue;
        i = paramInt;
        if (l2 > 0L)
        {
          i = paramInt;
          if (l2 > l1 * 1024L) {
            return 506;
          }
        }
      }
    }
    else
    {
      i = paramInt;
      if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
        i = 3;
      }
    }
    return i;
  }
  
  private boolean s()
  {
    long l1;
    if (SystemUtil.a()) {
      l1 = SystemUtil.b();
    } else {
      l1 = SystemUtil.c();
    }
    long l2 = this.e.ProgressTotal - this.e.ProgressValue;
    return (l2 > 0L) && (l2 > l1 * 1024L);
  }
  
  private void t()
  {
    if (this.A == null) {
      this.A = new SparseIntArray();
    }
    this.A.put(0, 0);
    this.A.put(101, 8);
    this.A.put(201, 9);
    this.A.put(300, 3);
    this.A.put(301, 3);
    this.A.put(302, 3);
    this.A.put(303, 3);
    this.A.put(304, 3);
    this.A.put(305, 3);
    this.A.put(306, 3);
    this.A.put(307, 3);
    this.A.put(308, 3);
    this.A.put(400, 3);
    this.A.put(401, 3);
    this.A.put(402, 3);
    this.A.put(403, 3);
    this.A.put(404, 3);
    this.A.put(405, 3);
    this.A.put(406, 3);
    this.A.put(407, 3);
    this.A.put(408, 3);
    this.A.put(501, 7);
    this.A.put(502, 7);
    this.A.put(503, 7);
    this.A.put(505, 7);
    this.A.put(506, 7);
    this.A.put(504, 6);
  }
  
  private ExtfGroupDownloadWorker.DownloadCompleteInfo u()
  {
    ExtfGroupDownloadWorker.DownloadCompleteInfo localDownloadCompleteInfo = new ExtfGroupDownloadWorker.DownloadCompleteInfo(this);
    if ((this.h != null) && ((this.h instanceof ExtfGroupFileDownloader)))
    {
      ExtfGroupFileDownloader localExtfGroupFileDownloader = (ExtfGroupFileDownloader)this.h;
      localDownloadCompleteInfo.a = localExtfGroupFileDownloader.i();
      localDownloadCompleteInfo.b = localExtfGroupFileDownloader.j();
    }
    return localDownloadCompleteInfo;
  }
  
  private void v()
  {
    if (this.B == null) {
      this.B = new SparseIntArray();
    }
    this.B.put(0, 0);
    this.B.put(1, 402);
    this.B.put(100, 402);
    this.B.put(101, 402);
    this.B.put(102, 402);
    this.B.put(2, 402);
    this.B.put(3, 402);
    this.B.put(302, 402);
    this.B.put(303, 402);
    this.B.put(304, 402);
    this.B.put(305, 402);
    this.B.put(313, 402);
    this.B.put(309, 402);
    this.B.put(312, 402);
    this.B.put(301, 401);
    this.B.put(300, 407);
    this.B.put(306, 303);
    this.B.put(4, 303);
    this.B.put(307, 303);
    this.B.put(308, 303);
    this.B.put(314, 304);
    this.B.put(315, 305);
    this.B.put(316, 306);
    this.B.put(317, 404);
    this.B.put(318, 408);
    this.B.put(319, 405);
    this.B.put(320, 406);
    this.B.put(5, 201);
    this.B.put(501, 201);
    this.B.put(502, 201);
    this.B.put(503, 201);
    this.B.put(504, 201);
    this.B.put(701, 201);
    this.B.put(702, 201);
    this.B.put(704, 504);
    this.B.put(708, 501);
    this.B.put(709, 502);
    this.B.put(707, 502);
    this.B.put(700, 502);
    this.B.put(710, 506);
    this.B.put(703, 506);
    this.B.put(8, 9037);
    this.B.put(7, 201);
    this.B.put(9, 201);
    this.B.put(901, 201);
    this.B.put(902, 201);
    this.B.put(904, 201);
    this.B.put(10, 201);
    this.B.put(11, 201);
    this.B.put(12, 201);
  }
  
  private void w()
  {
    int i;
    if (this.r != 0L) {
      i = 3;
    } else {
      i = 2;
    }
    ExtfGroupDownloadDataReport localExtfGroupDownloadDataReport = new ExtfGroupDownloadDataReport(TroopFileTransferUtil.a());
    Object localObject = FileManagerUtil.t(this.e.FileName);
    localExtfGroupDownloadDataReport.a(1, i, (String)localObject, this.e.ProgressTotal, this.e.troopuin);
    if ((this.u > 0L) && (this.v >= this.u))
    {
      localExtfGroupDownloadDataReport.b(this.u);
      localExtfGroupDownloadDataReport.c(this.v);
    }
    else
    {
      localExtfGroupDownloadDataReport.b(0L);
      localExtfGroupDownloadDataReport.c(0L);
    }
    localObject = new ExcitingTransferDownloadCompletedInfo();
    if (this.r > 0L)
    {
      ((ExcitingTransferDownloadCompletedInfo)localObject).muStartTime = this.r;
      ((ExcitingTransferDownloadCompletedInfo)localObject).muTotalTimes = (System.currentTimeMillis() - ((ExcitingTransferDownloadCompletedInfo)localObject).muStartTime);
    }
    if (this.q.e > 0L) {
      ((ExcitingTransferDownloadCompletedInfo)localObject).muStartSize = this.q.e;
    }
    if (this.q.f > 0L) {
      ((ExcitingTransferDownloadCompletedInfo)localObject).muDownloadedSize = this.q.f;
    }
    localExtfGroupDownloadDataReport.a((ExcitingTransferDownloadCompletedInfo)localObject);
    localExtfGroupDownloadDataReport.a(this.a);
    localExtfGroupDownloadDataReport.a(this.x);
    localExtfGroupDownloadDataReport.a(this.y);
    localExtfGroupDownloadDataReport.b(false);
  }
  
  protected int a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (b())
    {
      paramInt2 = 0;
      if (paramBundle != null) {
        paramInt2 = paramBundle.getInt("nSrvReturnCode", 0);
      }
      return b(paramInt1, paramInt2);
    }
    return super.a(paramInt1, paramInt2, paramBundle);
  }
  
  protected int a(int paramInt, Bundle paramBundle)
  {
    if (b())
    {
      int i = 0;
      if (paramBundle != null) {
        i = paramBundle.getInt("nSrvReturnCode", 0);
      }
      return d(paramInt, i);
    }
    return super.a(paramInt, paramBundle);
  }
  
  protected ITroopFileDownloader a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("^_^ nSessionID[");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("] get ExtfFileDownloader. bIsHttps:");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(" strHttpsDomain:");
    ((StringBuilder)localObject1).append(paramString3);
    ((StringBuilder)localObject1).append(" urlParams:");
    ((StringBuilder)localObject1).append(paramString2);
    QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, ((StringBuilder)localObject1).toString());
    this.a = paramLong;
    if (FileManagerUtil.n(paramString1)) {
      this.b = true;
    }
    localObject1 = new ExtfDownloadFileInfo();
    ((ExtfDownloadFileInfo)localObject1).a(this.e.ProgressTotal);
    ((ExtfDownloadFileInfo)localObject1).b(paramString2);
    ((ExtfDownloadFileInfo)localObject1).c(this.e.cookieValue);
    int i = 80;
    ((ExtfDownloadFileInfo)localObject1).a(paramBoolean);
    ((ExtfDownloadFileInfo)localObject1).d(paramString3);
    if (paramBoolean) {
      i = 443;
    }
    paramString3 = this.e.FileName;
    paramString2 = paramString3;
    if (!TextUtils.isEmpty(this.e.NameForSave))
    {
      paramString2 = paramString3;
      if (this.e.SafeCheckRes == 2) {
        paramString2 = this.e.NameForSave;
      }
    }
    paramString3 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString3 = o();
    }
    ((ExtfDownloadFileInfo)localObject1).a(paramString3);
    paramString2 = new ArrayList();
    paramString2.add(new ExcitingTransferHostInfo(this.e.DownloadIp, i));
    if (!TextUtils.isEmpty(this.e.DownloadDNS))
    {
      paramString3 = new ExcitingTransferHostInfo(this.e.DownloadDNS, i);
      if (FileIPv6StrateyController.b().isConfigEnableIPV6(paramQQAppInterface, 3))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append(this.f);
        ((StringBuilder)localObject2).append("] [IPv6-File] exciting download troopfile. is config enable IPv6. domain[");
        ((StringBuilder)localObject2).append(this.e.DownloadDNS);
        ((StringBuilder)localObject2).append("]");
        QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, ((StringBuilder)localObject2).toString());
        localObject2 = new FileIPv6StrateyController.DomainInfo(this.e.DownloadDNS, i);
        localObject2 = FileIPv6StrateyController.b().getIPlistForV6Domain(paramQQAppInterface, (FileIPv6StrateyController.DomainInfo)localObject2, 3);
        if ((localObject2 != null) && (!((FileIPv6StrateyController.IPListInfo)localObject2).a()))
        {
          if (FileIPv6StrateyController.a())
          {
            paramString3 = new StringBuilder();
            paramString3.append("[");
            paramString3.append(this.f);
            paramString3.append("] [IPv6-File] exciting download troopfile. debugIsDisableIPv4OnDoubleStack");
            QLog.d("ExcitingTransfer.ExtfGroupDownloadWorker", 1, paramString3.toString());
            paramString2.clear();
          }
          i = ((FileIPv6StrateyController.IPListInfo)localObject2).b.size() - 1;
          while (i >= 0)
          {
            paramString3 = (FileIPv6StrateyController.IPInfo)((FileIPv6StrateyController.IPListInfo)localObject2).b.get(i);
            paramString2.add(0, new ExcitingTransferHostInfo(paramString3.a(), paramString3.b));
            i -= 1;
          }
          this.x = 2;
          if (((FileIPv6StrateyController.IPListInfo)localObject2).a == 1) {
            this.x = 3;
          }
          paramString3 = new StringBuilder();
          paramString3.append("[");
          paramString3.append(this.f);
          paramString3.append("] [IPv6-File] exciting download troopfile use IPv6. iplist:");
          paramString3.append(paramString2.toString());
          QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, paramString3.toString());
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[");
          ((StringBuilder)localObject2).append(this.f);
          ((StringBuilder)localObject2).append("] [IPv6-File] exciting download troopfile use IPv4");
          QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, ((StringBuilder)localObject2).toString());
          paramString2.add(paramString3);
          this.x = 1;
        }
      }
      else
      {
        paramString2.add(paramString3);
        this.x = 1;
      }
    }
    else
    {
      this.x = 1;
    }
    ((ExtfDownloadFileInfo)localObject1).a(paramString2);
    paramQQAppInterface = ExtfGroupFileDownloader.a(paramQQAppInterface, paramLong, this.d, paramString1, (ExtfDownloadFileInfo)localObject1);
    if (paramQQAppInterface != null)
    {
      ((ExtfGroupFileDownloader)paramQQAppInterface).a(this);
      return paramQQAppInterface;
    }
    paramString1 = new StringBuilder();
    paramString1.append("^_^ [");
    paramString1.append(this.f);
    paramString1.append("] get ExtfFileDownloader fail.");
    QLog.e("ExcitingTransfer.ExtfGroupDownloadWorker", 1, paramString1.toString());
    return paramQQAppInterface;
  }
  
  public void a(int paramInt)
  {
    if (b()) {
      this.e.mExcitingSpeed = "";
    }
    super.a(paramInt);
  }
  
  public void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo) {}
  
  public void a(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    int i;
    if (paramExcitingTransferOneSlotComplete != null) {
      i = paramExcitingTransferOneSlotComplete.mSrvRetCode;
    } else {
      i = 0;
    }
    a(d(paramInt, i), b(paramInt, i));
    if (paramInt != 0)
    {
      this.q.m = 0;
      this.q.n = 0;
      q();
      this.q.k = 0;
      this.q.l = 0;
    }
    else
    {
      this.q.k = 0;
      this.q.l = 0;
      r();
    }
    if (paramExcitingTransferOneSlotComplete != null)
    {
      ExtfGroupDownloaderDataReport localExtfGroupDownloaderDataReport = new ExtfGroupDownloaderDataReport(TroopFileTransferUtil.a());
      localExtfGroupDownloaderDataReport.a(this.a);
      String str = FileManagerUtil.t(this.e.FileName);
      i = n(paramInt);
      if (i == 3) {
        paramInt = 5;
      } else if (i == 506) {
        paramInt = 3;
      } else {
        paramInt = 4;
      }
      localExtfGroupDownloaderDataReport.a(paramInt, i, str, this.e.ProgressTotal, this.e.troopuin);
      localExtfGroupDownloaderDataReport.a(paramExcitingTransferOneSlotComplete);
      localExtfGroupDownloaderDataReport.a(this.x);
      localExtfGroupDownloaderDataReport.b(QFileUtils.b(paramExcitingTransferOneSlotComplete.mstrIp));
      localExtfGroupDownloaderDataReport.a(this.y);
      localExtfGroupDownloaderDataReport.b();
      return;
    }
    paramExcitingTransferOneSlotComplete = new StringBuilder();
    paramExcitingTransferOneSlotComplete.append("[");
    paramExcitingTransferOneSlotComplete.append(this.f);
    paramExcitingTransferOneSlotComplete.append("] onExtfSubUploaderResult DataReport fail. no rp");
    QLog.e("ExcitingTransfer.ExtfGroupDownloadWorker", 1, paramExcitingTransferOneSlotComplete.toString());
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    if (paramExcitingTransferDownloadSpeedInfo != null)
    {
      if (paramExcitingTransferDownloadSpeedInfo.mTotalSpeed == 0) {
        return;
      }
      long l = paramExcitingTransferDownloadSpeedInfo.mTotalSpeed;
      float f;
      StringBuilder localStringBuilder;
      if (l > 1048576L)
      {
        f = (float)l / 1048576.0F;
        paramExcitingTransferDownloadSpeedInfo = new DecimalFormat("0.00").format(f);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("加速下载 ");
        localStringBuilder.append(paramExcitingTransferDownloadSpeedInfo);
        localStringBuilder.append("MB/s");
        paramExcitingTransferDownloadSpeedInfo = localStringBuilder.toString();
      }
      else if (l > 1024L)
      {
        f = (float)l / 1024.0F;
        paramExcitingTransferDownloadSpeedInfo = new DecimalFormat("0.00").format(f);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("加速下载 ");
        localStringBuilder.append(paramExcitingTransferDownloadSpeedInfo);
        localStringBuilder.append("KB/s");
        paramExcitingTransferDownloadSpeedInfo = localStringBuilder.toString();
      }
      else
      {
        paramExcitingTransferDownloadSpeedInfo = new StringBuilder();
        paramExcitingTransferDownloadSpeedInfo.append("加速下载 ");
        paramExcitingTransferDownloadSpeedInfo.append(l);
        paramExcitingTransferDownloadSpeedInfo.append("KB/s");
        paramExcitingTransferDownloadSpeedInfo = paramExcitingTransferDownloadSpeedInfo.toString();
      }
      this.e.mExcitingSpeed = paramExcitingTransferDownloadSpeedInfo;
    }
  }
  
  public void a(String paramString)
  {
    if (b())
    {
      this.e.mExcitingSpeed = "";
      if (this.e.ProgressTotal >= this.q.e) {
        this.s = (this.e.ProgressTotal - this.q.e);
      }
      if (!FileUtils.fileExists(paramString))
      {
        i = TroopFileTransferUtil.Log.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append("]  onDownloadSuccess but file is not exsited.");
        ((StringBuilder)localObject).append(paramString);
        TroopFileTransferUtil.Log.a("ExcitingTransfer.ExtfGroupDownloadWorker", i, ((StringBuilder)localObject).toString());
        a(7, 706);
        a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.o, 307);
        return;
      }
      long l = FileManagerUtil.h(paramString);
      if ((this.e.ProgressTotal != 0L) && (l != this.e.ProgressTotal))
      {
        i = TroopFileTransferUtil.Log.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append("]  file size check fail. filesize:");
        ((StringBuilder)localObject).append(this.e.ProgressTotal);
        ((StringBuilder)localObject).append(" transSize:");
        ((StringBuilder)localObject).append(l);
        TroopFileTransferUtil.Log.a("ExcitingTransfer.ExtfGroupDownloadWorker", i, ((StringBuilder)localObject).toString());
        a(7, 704);
        a(true, TroopTechReportUtils.TroopFileReportResultCode.b, TroopTechReportUtils.TroopFileReportResultCode.q, 305);
        new File(paramString).delete();
        this.e.ProgressValue = 0L;
        return;
      }
      int i = TroopFileTransferUtil.Log.b;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("] onDownlaodSuc  mFilePath:");
      ((StringBuilder)localObject).append(paramString);
      TroopFileTransferUtil.Log.c("ExcitingTransfer.ExtfGroupDownloadWorker", i, ((StringBuilder)localObject).toString());
      this.e.LocalFile = paramString;
      i = FileManagerUtil.c(FileUtil.a(this.e.FileName));
      if (((i == 2) || (i == 0)) && (!FileUtil.d(this.e.getThumbnailFile(this.d, 383)))) {
        this.e.genThumb_Middle_OnGettedLargeOrOrigPic = true;
      }
      this.g = true;
      this.o = null;
      b(3);
      TroopFileDataCenter.a(this.d, this.e, 11);
      paramString = HexUtil.bytes2HexStr(this.e.Md5);
      localObject = HexUtil.bytes2HexStr(this.e.Sha);
      a(this.e.getInfo(this.d), paramString, (String)localObject, this.e.Sha3);
      if (5 == FileManagerUtil.c(this.e.FileName))
      {
        paramString = TroopFileTransferUtil.a();
        if (paramString != null) {
          paramString.getFileManagerEngine().i().a(this.d, this.e);
        }
      }
      a(0, 0);
      e();
      p();
      TroopTechReportUtils.b(TroopTechReportUtils.TroopFileReportResultCode.a, 0);
      this.e.retryTimes = 0;
      if (this.i != null) {
        this.i.a(h(), true, 0, this);
      }
    }
    else
    {
      super.a(paramString);
    }
  }
  
  public boolean a()
  {
    this.b = false;
    this.r = 0L;
    return super.a();
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public void c()
  {
    this.r = System.currentTimeMillis();
  }
  
  protected void d()
  {
    super.d();
    if (b())
    {
      if ((this.q.k != 8) && (this.q.k != 11) && (this.q.k != 12))
      {
        ExtfGroupDownloadWorker.DownloadCompleteInfo localDownloadCompleteInfo = u();
        int m = 1;
        int k = 4;
        int n = 0;
        int j = 0;
        int i;
        if ((localDownloadCompleteInfo != null) && (localDownloadCompleteInfo.a != null))
        {
          i = n(localDownloadCompleteInfo.b);
        }
        else
        {
          int i1 = this.q.l;
          i = i1;
          if (i1 == 0) {
            i = this.q.k;
          }
          if (this.r == 0L)
          {
            k = e(this.q.k, this.q.l);
            if (this.w)
            {
              k = 2;
              i = 7;
              j = this.q.l;
            }
            m = 0;
            n = j;
          }
          else
          {
            i = n(m(i));
          }
        }
        j = k;
        if (m != 0) {
          if (i == 3)
          {
            j = 5;
          }
          else
          {
            j = k;
            if (i == 506) {
              j = 3;
            }
          }
        }
        a(j, i, n);
        return;
      }
      w();
    }
  }
  
  protected void e()
  {
    if (b())
    {
      ExtfGroupDownloadWorker.DownloadCompleteInfo localDownloadCompleteInfo = u();
      if ((localDownloadCompleteInfo != null) && (localDownloadCompleteInfo.a != null))
      {
        this.q.e = localDownloadCompleteInfo.a.muStartSize;
        this.q.f = localDownloadCompleteInfo.a.muDownloadedSize;
        this.q.g = localDownloadCompleteInfo.a.muTotalTimes;
        if ((this.q.f > 0L) && (this.q.g > 0L))
        {
          float f = (float)this.q.g / 1000.0F;
          this.q.i = (((float)this.q.f / f));
        }
        else
        {
          this.q.i = 0L;
        }
      }
    }
    super.e();
    if (b()) {
      a(0, 0, 0);
    }
  }
  
  protected int f()
  {
    if (b())
    {
      if (this.h == null) {
        return 0;
      }
      return QFileUtils.b(this.h.p());
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.ExtfGroupDownloadWorker
 * JD-Core Version:    0.7.0.1
 */