package com.tencent.mobileqq.filemanager.excitingtransfer.downloader.c2cdownloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.BaseDataReport;
import com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C2CFileDownloader
  extends BaseDownloader
{
  C2CDataReporter e;
  long f = 0L;
  boolean g = false;
  private FileManagerEntity h = null;
  private QQAppInterface i = null;
  private int j = 0;
  
  public C2CFileDownloader(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface);
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "file download for C2CFileDownloader");
    this.h = paramFileManagerEntity;
    this.i = paramQQAppInterface;
    this.e.b.d = FileManagerUtil.t(this.h.fileName);
    this.e.b.g = this.h.fileSize;
    this.e.b.f = this.h.peerType;
    try
    {
      this.e.b.e = Long.parseLong(this.h.peerUin);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, paramQQAppInterface.toString());
    }
  }
  
  private int a(int paramInt)
  {
    if ((paramInt != 300) && (paramInt != 301) && (paramInt != 302) && (paramInt != 303) && (paramInt != 400) && (paramInt != 402) && (paramInt != 403))
    {
      if ((paramInt == 501) || (paramInt == 502) || (paramInt == 503) || (paramInt == 505))
      {
        long l;
        if (SystemUtil.a()) {
          l = SystemUtil.b();
        } else {
          l = SystemUtil.c();
        }
        if (this.h.fileSize > l * 1024L) {
          return 506;
        }
      }
    }
    else {
      if ((!AppNetConnInfo.isNetSupport()) || (!this.i.isLogin())) {
        break label138;
      }
    }
    return paramInt;
    label138:
    return 9004;
  }
  
  private void a(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(List<String> paramList1, String paramString, int paramInt, List<String> paramList2, boolean paramBoolean)
  {
    if ((paramList1 != null) && (FileIPv6StrateyController.b().isConfigEnableIPV6(this.i, 1)))
    {
      if ((paramBoolean) && (paramList2 != null) && (paramList2.size() > 0))
      {
        paramString = new StringBuilder();
        paramString.append("[IPv6-File] offline mediaplatform exciting download. is config enable IPv6. v6ipsize[");
        paramString.append(paramList2.size());
        paramString.append("]");
        QLog.i("C2CFileDownloader<FileAssistant>", 1, paramString.toString());
        paramString = FileIPv6StrateyController.b().getIPV6listForMediaPlatfrom(this.i, 1, paramList2);
        if ((paramString != null) && (paramString.size() > 0))
        {
          if (FileIPv6StrateyController.a())
          {
            QLog.d("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download. debugIsDisableIPv4OnDoubleStack");
            paramList1.clear();
          }
          paramList1.addAll(0, paramString);
          this.j = 2;
          paramString = new StringBuilder();
          paramString.append("[IPv6-File] offline mediaplatform exciting download use IPv6. iplist:");
          paramString.append(paramList1.toString());
          QLog.i("C2CFileDownloader<FileAssistant>", 1, paramString.toString());
        }
        else
        {
          this.j = 1;
          QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download use IPv4");
        }
      }
      else if (!TextUtils.isEmpty(paramString))
      {
        paramList2 = new StringBuilder();
        paramList2.append("[IPv6-File] offline exciting download. is config enable IPv6. domain[");
        paramList2.append(paramString);
        paramList2.append("]");
        QLog.i("C2CFileDownloader<FileAssistant>", 1, paramList2.toString());
        paramString = new FileIPv6StrateyController.DomainInfo(paramString, paramInt);
        paramString = FileIPv6StrateyController.b().getIPlistForV6Domain(this.i, paramString, 1);
        if ((paramString != null) && (!paramString.a()))
        {
          if (FileIPv6StrateyController.a())
          {
            QLog.d("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download. debugIsDisableIPv4OnDoubleStack");
            paramList1.clear();
          }
          FileIPv6StrateyController.a(paramString.b, paramList1, true, true);
          this.j = 2;
          if (paramString.a == 1) {
            this.j = 3;
          }
          paramString = new StringBuilder();
          paramString.append("[IPv6-File] offline exciting download use IPv6. iplist:");
          paramString.append(paramList1.toString());
          QLog.i("C2CFileDownloader<FileAssistant>", 1, paramString.toString());
        }
        else
        {
          this.j = 1;
          QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download use IPv4");
        }
      }
      else
      {
        this.j = 1;
      }
      this.e.b(this.j);
      return;
    }
    this.j = 1;
    this.e.b(this.j);
  }
  
  protected BaseDataReport a(QQAppInterface paramQQAppInterface)
  {
    this.e = new C2CDataReporter(paramQQAppInterface);
    return this.e;
  }
  
  protected void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (paramExcitingTransferDownloadCompletedInfo == null) {
      return;
    }
    paramExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo.mstrFileSavePath;
    FileManagerUtil.h(paramExcitingTransferDownloadCompletedInfo);
    this.h.fileName = FileManagerUtil.a(paramExcitingTransferDownloadCompletedInfo);
    int m = paramExcitingTransferDownloadCompletedInfo.length();
    int n = this.h.fileName.length();
    int k = this.h.fileName.getBytes().length;
    m = 250 - (m - n);
    if (k > m)
    {
      localObject = this.h;
      ((FileManagerEntity)localObject).fileName = FileManagerUtil.a(((FileManagerEntity)localObject).fileName, m);
    }
    this.h.setFilePath(paramExcitingTransferDownloadCompletedInfo);
    this.h.fileName = FileManagerUtil.a(paramExcitingTransferDownloadCompletedInfo);
    Object localObject = this.h;
    ((FileManagerEntity)localObject).nFileType = FileManagerUtil.c(((FileManagerEntity)localObject).fileName);
    if (this.h.nFileType == 0)
    {
      this.h.strFileSha3 = FileHttpUtils.a(FileManagerUtil.e(paramExcitingTransferDownloadCompletedInfo));
      if (this.h.fileSize < 104857600L) {
        this.h.strFileSHA = FileHttpUtils.a(FileManagerUtil.d(paramExcitingTransferDownloadCompletedInfo));
      }
    }
    localObject = new VFSFile(paramExcitingTransferDownloadCompletedInfo);
    this.h.localModifyTime = ((VFSFile)localObject).lastModified();
    this.h.lastSuccessTime = MessageCache.c();
    localObject = this.h;
    ((FileManagerEntity)localObject).status = 1;
    ((FileManagerEntity)localObject).setCloudType(3);
    this.i.getFileManagerNotifyCenter().a(this.h.uniseq, this.h.nSessionId, this.h.peerUin, this.h.peerType, 11, new Object[] { paramExcitingTransferDownloadCompletedInfo, "", Long.valueOf(this.h.fileSize), Boolean.valueOf(true), "", "" }, 0, null);
    if (this.h.nFileType == 0)
    {
      FilePicURLDrawlableHelper.f(this.h);
      FilePicURLDrawlableHelper.d(this.h);
      FilePicURLDrawlableHelper.a(this.h);
    }
    else if (this.h.nFileType == 2)
    {
      FileManagerUtil.g(this.h);
    }
    FileManagerUtil.n(this.h);
  }
  
  protected void a(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo)
  {
    this.f = System.currentTimeMillis();
    this.e.f();
    this.g = false;
    this.i.getFileTransferHandler().a(this.h.Uuid, this.h.fileIdCrc, this.h.bSend, false, new C2CFileDownloader.1(this, paramExcitingTransferDownloadReqInfo));
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if (this.h.status != 16) {
      this.h.status = 0;
    }
    this.i.getFileManagerNotifyCenter().a(this.h.uniseq, this.h.nSessionId, this.h.peerUin, this.h.peerType, 12, null, 6, null);
    this.i.getFileManagerDataCenter().c(this.h);
  }
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, String paramString5, Bundle paramBundle, ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo)
  {
    if (a())
    {
      paramString1 = new StringBuilder();
      paramString1.append("=_= vk [CS Replay]id[");
      paramString1.append(String.valueOf(this.h.nSessionId));
      paramString1.append("] but isStoped");
      QLog.e("C2CFileDownloader<FileAssistant>", 1, paramString1.toString());
      return;
    }
    this.e.g();
    if (!paramBoolean1)
    {
      this.e.b(paramLong);
      a(null, 0);
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.a.d();
      a(null, 0);
      return;
    }
    paramExcitingTransferDownloadReqInfo.fileSize = this.h.fileSize;
    paramExcitingTransferDownloadReqInfo.isSupportHttps = false;
    if ((((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.i)) && (paramBundle != null))
    {
      String str = paramBundle.getString("strHttpsDomain");
      short s = paramBundle.getShort("httpsPort", (short)0);
      if (!TextUtils.isEmpty(str))
      {
        paramShort = s;
        if (s == 0) {
          paramShort = 443;
        }
        paramExcitingTransferDownloadReqInfo.isSupportHttps = true;
        paramExcitingTransferDownloadReqInfo.sslCName = str;
      }
    }
    this.g = paramExcitingTransferDownloadReqInfo.isSupportHttps;
    this.e.d(this.g);
    if (a(paramLong, paramByteStringMicro, paramString3)) {
      return;
    }
    if ((paramLong != 0L) && (paramString1 != null) && (paramString1.length() > 0))
    {
      paramByteStringMicro = new StringBuilder();
      paramByteStringMicro.append("=_= ^> [CS Replay]id[");
      paramByteStringMicro.append(String.valueOf(this.h.nSessionId));
      paramByteStringMicro.append("] will show taost, retCode[");
      paramByteStringMicro.append(String.valueOf(paramLong));
      paramByteStringMicro.append("], retMsg:");
      paramByteStringMicro.append(paramString1);
      QLog.e("C2CFileDownloader<FileAssistant>", 1, paramByteStringMicro.toString());
      this.i.getFileManagerNotifyCenter().a(this.h.uniseq, this.h.nSessionId, this.h.peerUin, this.h.peerType, 4, null, (int)paramLong, paramString1);
    }
    if (paramList == null) {
      paramString1 = new ArrayList();
    } else {
      paramString1 = paramList;
    }
    paramString1.add(0, paramString3);
    paramString3 = this.i;
    paramByteStringMicro = "";
    paramString3 = (IQFileConfigManager)paramString3.getRuntimeService(IQFileConfigManager.class, "");
    if (paramString3.isHarcodeIP())
    {
      paramString1.clear();
      paramString1.add(paramString3.getHarcodeIP());
    }
    if (paramBundle != null)
    {
      paramByteStringMicro = paramBundle.getString("IPv6Dns", "");
      paramString3 = paramBundle.getStringArrayList("ipv6list");
    }
    else
    {
      paramString3 = null;
    }
    a(paramString1, paramByteStringMicro, paramShort, paramString3, paramBoolean2);
    paramByteStringMicro = new StringBuilder();
    paramByteStringMicro.append("get lstUrl size:");
    paramByteStringMicro.append(paramString1.size());
    QLog.i("C2CFileDownloader<FileAssistant>", 1, paramByteStringMicro.toString());
    paramByteStringMicro = new ArrayList();
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext()) {
      paramByteStringMicro.add(new ExcitingTransferHostInfo((String)paramString1.next(), paramShort));
    }
    paramExcitingTransferDownloadReqInfo.mHosts = ((ExcitingTransferHostInfo[])paramByteStringMicro.toArray(new ExcitingTransferHostInfo[paramByteStringMicro.size()]));
    paramString1 = new StringBuilder();
    paramString1.append("Cookie:t=0;v=");
    paramString1.append(AppSetting.d());
    paramString1.append(";");
    paramString1.append(paramString2);
    paramString1.append(";\r\n");
    paramExcitingTransferDownloadReqInfo.strCookie = paramString1.toString();
    paramExcitingTransferDownloadReqInfo.serverPath = paramString4;
    paramExcitingTransferDownloadReqInfo.strTempFilePath = e();
    paramExcitingTransferDownloadReqInfo.strFileName = paramString5;
    paramExcitingTransferDownloadReqInfo.strSaveFileDir = this.c.getDefaultRecvPath();
    paramString1 = this.h;
    paramString1.bUseMediaPlatform = paramBoolean2;
    paramString1.status = 2;
    this.e.h();
    d();
  }
  
  protected boolean a(long paramLong, ByteStringMicro paramByteStringMicro, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramByteStringMicro != null)) {
      return false;
    }
    if ((paramLong == -6101L) || (paramLong == -7003L)) {
      this.h.status = 16;
    }
    if (paramLong == 0L)
    {
      this.e.b.b = 9048L;
      this.e.b.a = 2L;
      this.e.a(5);
      this.e.b(false);
    }
    else
    {
      this.e.c(paramLong);
    }
    a(null, (int)paramLong);
    return true;
  }
  
  public long c()
  {
    return this.h.fileSize;
  }
  
  public String e()
  {
    String str1 = this.c.getDefaultTmpPath();
    String str2 = MD5.toMD5(this.h.Uuid);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public int h()
  {
    return this.h.status;
  }
  
  public int i()
  {
    return (int)(this.h.fProgress * 100.0F);
  }
  
  public void onOneSlotComplete(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    if (paramExcitingTransferOneSlotComplete == null)
    {
      paramExcitingTransferOneSlotComplete = new StringBuilder();
      paramExcitingTransferOneSlotComplete.append("OnOneSlotComplete:");
      paramExcitingTransferOneSlotComplete.append(paramInt);
      paramExcitingTransferOneSlotComplete.append(" slotInfo is null");
      QLog.i("C2CFileDownloader<FileAssistant>", 1, paramExcitingTransferOneSlotComplete.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnOneSlotComplete:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" slotInfo : ");
    localStringBuilder.append(paramExcitingTransferOneSlotComplete.toString());
    QLog.i("C2CFileDownloader<FileAssistant>", 1, localStringBuilder.toString());
    int n = a(paramInt);
    int k = 4;
    int m;
    if (n == 9004)
    {
      k = 5;
      m = 3;
    }
    else
    {
      m = n;
      if (n == 506)
      {
        k = 3;
        m = n;
      }
    }
    this.e.a(k, m, paramExcitingTransferOneSlotComplete);
    a(paramInt, paramExcitingTransferOneSlotComplete);
  }
  
  public void onRecvComplete(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file download result:");
    localStringBuilder.append(paramInt);
    QLog.i("C2CFileDownloader<FileAssistant>", 1, localStringBuilder.toString());
    boolean bool = false;
    if (paramExcitingTransferDownloadCompletedInfo != null) {
      this.e.c(0);
    }
    int k;
    if (paramInt != 0)
    {
      k = a(paramInt);
      this.e.b.b = k;
      this.e.b.a = 4L;
      if (k == 9004)
      {
        this.e.b.a = 5L;
        this.e.a(3);
      }
      else if (k == 506)
      {
        this.e.b.a = 3L;
        this.e.a(k);
      }
      else
      {
        this.e.a(k);
      }
      a(null, k);
    }
    else
    {
      if (!QFileAssistantUtils.a(this.h.peerUin)) {
        this.i.getFileTransferHandler().a(this.i.getCurrentUin(), this.h.Uuid, this.h.bUseMediaPlatform, this.h.fileIdCrc, null);
      }
      this.e.b.b = paramInt;
      this.e.b.a = 0L;
      this.e.a(0);
      a(paramExcitingTransferDownloadCompletedInfo);
      k = paramInt;
      if (this.h.nFileType == 5)
      {
        this.i.getFileManagerEngine().i().a(this.h);
        k = paramInt;
      }
    }
    this.i.getFileManagerDataCenter().c(this.h);
    if (paramExcitingTransferDownloadCompletedInfo != null)
    {
      this.e.a(paramExcitingTransferDownloadCompletedInfo);
      paramExcitingTransferDownloadCompletedInfo = this.e;
      if (k == 0) {
        bool = true;
      }
      paramExcitingTransferDownloadCompletedInfo.b(bool);
    }
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    this.e.a(paramLong2);
    FileManagerEntity localFileManagerEntity = this.h;
    localFileManagerEntity.status = 2;
    localFileManagerEntity.fProgress = ((float)paramLong2 / (float)localFileManagerEntity.fileSize);
    this.i.getFileManagerNotifyCenter().a(this.h.uniseq, this.h.nSessionId, this.h.peerUin, this.h.peerType, 16, null, 0, null);
  }
  
  public void onRecvStart() {}
  
  public void onSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    paramExcitingTransferDownloadSpeedInfo = QFileUtils.b(paramExcitingTransferDownloadSpeedInfo.mTotalSpeed);
    this.h.mExcitingSpeed = paramExcitingTransferDownloadSpeedInfo;
  }
  
  public String p()
  {
    return this.h.WeiYunFileId;
  }
  
  public FileManagerEntity q()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.downloader.c2cdownloader.C2CFileDownloader
 * JD-Core Version:    0.7.0.1
 */