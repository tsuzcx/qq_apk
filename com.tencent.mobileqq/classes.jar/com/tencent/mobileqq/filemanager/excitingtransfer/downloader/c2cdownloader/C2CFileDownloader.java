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
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  C2CDataReporter jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  
  public C2CFileDownloader(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface);
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "file download for C2CFileDownloader");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.jdField_a_of_type_JavaLangString = FileManagerUtil.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.d = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.c = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin);
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
          l = SystemUtil.a();
        } else {
          l = SystemUtil.b();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > l * 1024L) {
          return 506;
        }
      }
    }
    else {
      if ((!AppNetConnInfo.isNetSupport()) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())) {
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
    if ((paramList1 != null) && (FileIPv6StrateyController.a().isConfigEnableIPV6(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)))
    {
      if ((paramBoolean) && (paramList2 != null) && (paramList2.size() > 0))
      {
        paramString = new StringBuilder();
        paramString.append("[IPv6-File] offline mediaplatform exciting download. is config enable IPv6. v6ipsize[");
        paramString.append(paramList2.size());
        paramString.append("]");
        QLog.i("C2CFileDownloader<FileAssistant>", 1, paramString.toString());
        paramString = FileIPv6StrateyController.a().getIPV6listForMediaPlatfrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramList2);
        if ((paramString != null) && (paramString.size() > 0))
        {
          if (FileIPv6StrateyController.a())
          {
            QLog.d("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download. debugIsDisableIPv4OnDoubleStack");
            paramList1.clear();
          }
          paramList1.addAll(0, paramString);
          this.jdField_b_of_type_Int = 2;
          paramString = new StringBuilder();
          paramString.append("[IPv6-File] offline mediaplatform exciting download use IPv6. iplist:");
          paramString.append(paramList1.toString());
          QLog.i("C2CFileDownloader<FileAssistant>", 1, paramString.toString());
        }
        else
        {
          this.jdField_b_of_type_Int = 1;
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
        paramString = FileIPv6StrateyController.a().getIPlistForV6Domain(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
        if ((paramString != null) && (!paramString.a()))
        {
          if (FileIPv6StrateyController.a())
          {
            QLog.d("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download. debugIsDisableIPv4OnDoubleStack");
            paramList1.clear();
          }
          FileIPv6StrateyController.a(paramString.jdField_a_of_type_JavaUtilList, paramList1, true, true);
          this.jdField_b_of_type_Int = 2;
          if (paramString.jdField_a_of_type_Int == 1) {
            this.jdField_b_of_type_Int = 3;
          }
          paramString = new StringBuilder();
          paramString.append("[IPv6-File] offline exciting download use IPv6. iplist:");
          paramString.append(paramList1.toString());
          QLog.i("C2CFileDownloader<FileAssistant>", 1, paramString.toString());
        }
        else
        {
          this.jdField_b_of_type_Int = 1;
          QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download use IPv4");
        }
      }
      else
      {
        this.jdField_b_of_type_Int = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.b(this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.b(this.jdField_b_of_type_Int);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  protected BaseDataReport a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter = new C2CDataReporter(paramQQAppInterface);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter;
  }
  
  public String a()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFMSettings.getDefaultTmpPath();
    String str2 = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  protected void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (paramExcitingTransferDownloadCompletedInfo == null) {
      return;
    }
    paramExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo.mstrFileSavePath;
    FileManagerUtil.a(paramExcitingTransferDownloadCompletedInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(paramExcitingTransferDownloadCompletedInfo);
    int j = paramExcitingTransferDownloadCompletedInfo.length();
    int k = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.length();
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length;
    j = 250 - (j - k);
    if (i > j)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      ((FileManagerEntity)localObject).fileName = FileManagerUtil.a(((FileManagerEntity)localObject).fileName, j);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(paramExcitingTransferDownloadCompletedInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(paramExcitingTransferDownloadCompletedInfo);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject).nFileType = FileManagerUtil.a(((FileManagerEntity)localObject).fileName);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = FileHttpUtils.a(FileManagerUtil.b(paramExcitingTransferDownloadCompletedInfo));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize < 104857600L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = FileHttpUtils.a(FileManagerUtil.a(paramExcitingTransferDownloadCompletedInfo));
      }
    }
    localObject = new VFSFile(paramExcitingTransferDownloadCompletedInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.localModifyTime = ((VFSFile)localObject).lastModified();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = MessageCache.a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject).status = 1;
    ((FileManagerEntity)localObject).setCloudType(3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 11, new Object[] { paramExcitingTransferDownloadCompletedInfo, "", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), "", "" }, 0, null);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      FilePicURLDrawlableHelper.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      FilePicURLDrawlableHelper.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      FilePicURLDrawlableHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2)
    {
      FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  protected void a(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.c();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, false, new C2CFileDownloader.1(this, paramExcitingTransferDownloadReqInfo));
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 12, null, 6, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, String paramString5, Bundle paramBundle, ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo)
  {
    if (a())
    {
      paramString1 = new StringBuilder();
      paramString1.append("=_= vk [CS Replay]id[");
      paramString1.append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId));
      paramString1.append("] but isStoped");
      QLog.e("C2CFileDownloader<FileAssistant>", 1, paramString1.toString());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.d();
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.b(paramLong);
      a(null, 0);
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferBaseDataReport.a();
      a(null, 0);
      return;
    }
    paramExcitingTransferDownloadReqInfo.fileSize = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    paramExcitingTransferDownloadReqInfo.isSupportHttps = false;
    if ((((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramBundle != null))
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
    this.jdField_a_of_type_Boolean = paramExcitingTransferDownloadReqInfo.isSupportHttps;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.c(this.jdField_a_of_type_Boolean);
    if (a(paramLong, paramByteStringMicro, paramString3)) {
      return;
    }
    if ((paramLong != 0L) && (paramString1 != null) && (paramString1.length() > 0))
    {
      paramByteStringMicro = new StringBuilder();
      paramByteStringMicro.append("=_= ^> [CS Replay]id[");
      paramByteStringMicro.append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId));
      paramByteStringMicro.append("] will show taost, retCode[");
      paramByteStringMicro.append(String.valueOf(paramLong));
      paramByteStringMicro.append("], retMsg:");
      paramByteStringMicro.append(paramString1);
      QLog.e("C2CFileDownloader<FileAssistant>", 1, paramByteStringMicro.toString());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 4, null, (int)paramLong, paramString1);
    }
    if (paramList == null) {
      paramString1 = new ArrayList();
    } else {
      paramString1 = paramList;
    }
    paramString1.add(0, paramString3);
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    paramString1.append(AppSetting.a());
    paramString1.append(";");
    paramString1.append(paramString2);
    paramString1.append(";\r\n");
    paramExcitingTransferDownloadReqInfo.strCookie = paramString1.toString();
    paramExcitingTransferDownloadReqInfo.serverPath = paramString4;
    paramExcitingTransferDownloadReqInfo.strTempFilePath = a();
    paramExcitingTransferDownloadReqInfo.strFileName = paramString5;
    paramExcitingTransferDownloadReqInfo.strSaveFileDir = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFMSettings.getDefaultRecvPath();
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    paramString1.bUseMediaPlatform = paramBoolean2;
    paramString1.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.e();
    a();
  }
  
  protected boolean a(long paramLong, ByteStringMicro paramByteStringMicro, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramByteStringMicro != null)) {
      return false;
    }
    if ((paramLong == -6101L) || (paramLong == -7003L)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
    }
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.jdField_b_of_type_Long = 9048L;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.jdField_a_of_type_Long = 2L;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a(5);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a(false);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.c(paramLong);
    }
    a(null, (int)paramLong);
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  public int c()
  {
    return (int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F);
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
    int k = a(paramInt);
    int i = 4;
    int j;
    if (k == 9004)
    {
      i = 5;
      j = 3;
    }
    else
    {
      j = k;
      if (k == 506)
      {
        i = 3;
        j = k;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a(i, j, paramExcitingTransferOneSlotComplete);
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.c(0);
    }
    int i;
    if (paramInt != 0)
    {
      i = a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.jdField_b_of_type_Long = i;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.jdField_a_of_type_Long = 4L;
      if (i == 9004)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.jdField_a_of_type_Long = 5L;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a(3);
      }
      else if (i == 506)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.jdField_a_of_type_Long = 3L;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a(i);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a(i);
      }
      a(null, i);
    }
    else
    {
      if (!QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.jdField_b_of_type_Long = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a(0);
      a(paramExcitingTransferDownloadCompletedInfo);
      i = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        i = paramInt;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if (paramExcitingTransferDownloadCompletedInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a(paramExcitingTransferDownloadCompletedInfo);
      paramExcitingTransferDownloadCompletedInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter;
      if (i == 0) {
        bool = true;
      }
      paramExcitingTransferDownloadCompletedInfo.a(bool);
    }
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CDataReporter.a(paramLong2);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.status = 2;
    localFileManagerEntity.fProgress = ((float)paramLong2 / (float)localFileManagerEntity.fileSize);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  public void onRecvStart() {}
  
  public void onSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    paramExcitingTransferDownloadSpeedInfo = QFileUtils.b(paramExcitingTransferDownloadSpeedInfo.mTotalSpeed);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mExcitingSpeed = paramExcitingTransferDownloadSpeedInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.downloader.c2cdownloader.C2CFileDownloader
 * JD-Core Version:    0.7.0.1
 */