package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.FileExecutor;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

public class OfflineSendWorker
  implements FileUploader.IFileUploaderSink, IFileHttpBase
{
  protected int a;
  protected long a;
  private VFSFile jdField_a_of_type_ComTencentMmVfsVFSFile;
  protected final QQAppInterface a;
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new OfflineSendWorker.3(this);
  protected IFileUploader a;
  protected final FileManagerEntity a;
  protected final String a;
  protected boolean a;
  protected byte[] a;
  protected int b;
  protected long b;
  protected final String b;
  protected boolean b;
  protected byte[] b;
  private int jdField_c_of_type_Int = -1;
  protected long c;
  private String jdField_c_of_type_JavaLangString;
  protected boolean c;
  protected byte[] c;
  protected long d;
  private boolean d;
  protected byte[] d;
  private long jdField_e_of_type_Long = 0L;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = true;
  
  public OfflineSendWorker(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_JavaLangString = "actFileUp";
    this.jdField_b_of_type_JavaLangString = "actFileUpDetail";
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_ArrayOfByte = null;
    this.jdField_d_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMmVfsVFSFile = new VFSFile(paramFileManagerEntity.getFilePath());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    paramQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
  }
  
  private void a(int paramInt)
  {
    paramInt = FileManagerUtil.b(paramInt);
    if ((this.jdField_c_of_type_Int == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt;
    } while (paramInt == 2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  private void a(long paramLong, int paramInt, String paramString)
  {
    a(paramLong, paramInt, paramString, null);
  }
  
  private void a(FileTransferHandler.FileUploadInfo paramFileUploadInfo)
  {
    a(1005);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
    QLog.w("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]ResultCodeNoServerAddr ip = 0");
    int i = paramFileUploadInfo.jdField_a_of_type_Int;
    String str = paramFileUploadInfo.jdField_a_of_type_JavaLangString;
    if (paramFileUploadInfo.jdField_a_of_type_Int == 0)
    {
      i = 9048;
      str = "onUpSend ip url error";
    }
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, str);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, str);
  }
  
  private void a(FileTransferHandler.FileUploadInfo paramFileUploadInfo, List<String> paramList)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    String str1 = null;
    short s = paramFileUploadInfo.jdField_a_of_type_Short;
    boolean bool1;
    if ((((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsUpload4C2C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramFileUploadInfo.jdField_d_of_type_Int == 2) && (!TextUtils.isEmpty(paramFileUploadInfo.jdField_c_of_type_JavaLangString)))
    {
      str1 = paramFileUploadInfo.jdField_c_of_type_JavaLangString;
      s = paramFileUploadInfo.jdField_b_of_type_Short;
      if (s == 0)
      {
        s = 443;
        bool1 = true;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          localArrayList.add(str2 + ":" + s);
        }
      }
      localArrayList.add(0, paramFileUploadInfo.jdField_b_of_type_JavaLangString + ":" + s);
      Object localObject = new ArrayList();
      if (paramList != null) {
        ((List)localObject).addAll(paramList);
      }
      ((List)localObject).add(0, paramFileUploadInfo.jdField_b_of_type_JavaLangString);
      if (!e()) {
        this.jdField_c_of_type_Boolean = bool1;
      }
      if (b(paramFileUploadInfo))
      {
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload. is config enable IPv6. domain[" + paramFileUploadInfo.jdField_d_of_type_JavaLangString + "]");
        paramList = new FileIPv6StrateyController.DomainInfo(paramFileUploadInfo.jdField_d_of_type_JavaLangString, s);
        paramList = FileIPv6StrateyController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, 1);
        if ((paramList != null) && (!paramList.a()))
        {
          if (FileIPv6StrateyController.a())
          {
            QLog.d("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload. debugIsDisableIPv4OnDoubleStack");
            localArrayList.clear();
            ((List)localObject).clear();
          }
          FileIPv6StrateyController.a(paramList.jdField_a_of_type_JavaUtilList, localArrayList, false, false);
          FileIPv6StrateyController.a(paramList.jdField_a_of_type_JavaUtilList, (List)localObject, true, false);
          this.jdField_b_of_type_Int = 2;
          if (paramList.jdField_a_of_type_Int == 1) {
            this.jdField_b_of_type_Int = 3;
          }
          QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload use IPv6. iplist:" + localArrayList.toString());
          bool2 = bool3;
        }
      }
      for (;;)
      {
        a(paramFileUploadInfo, bool1, str1, s, localArrayList, (List)localObject, bool2);
        return;
        this.jdField_b_of_type_Int = 1;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "[IPv6-File] offline upload use IPv4");
        bool2 = false;
        continue;
        this.jdField_b_of_type_Int = 1;
      }
      bool1 = true;
      continue;
      bool1 = false;
    }
  }
  
  private void a(FileTransferHandler.FileUploadInfo paramFileUploadInfo, boolean paramBoolean1, String paramString, short paramShort, List<String> paramList1, List<String> paramList2, boolean paramBoolean2)
  {
    ThreadManager.post(new OfflineSendWorker.4(this, paramFileUploadInfo, paramBoolean1, paramString, paramList1, paramList2, paramShort, paramBoolean2), 5, null, false);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "start OfflineFileHitReq:" + MessageCache.a());
    }
    FileManagerUtil.FileExecutor.a().execute(new OfflineSendWorker.2(this, paramString, paramLong, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte2, paramArrayOfByte1));
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    paramFileTransferObserver = new OfflineFileUploadPara();
    paramFileTransferObserver.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    paramFileTransferObserver.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramFileTransferObserver.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    paramFileTransferObserver.jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    paramFileManagerEntity.strFileMd5 = FileHttpUtils.a(paramArrayOfByte3);
    paramFileTransferObserver.jdField_c_of_type_ArrayOfByte = paramArrayOfByte3;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte3;
    byte[] arrayOfByte = new byte[paramArrayOfByte3.length + 4];
    PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte3, paramArrayOfByte3.length);
    PkgTools.DWord2Byte(arrayOfByte, paramArrayOfByte3.length, paramFileManagerEntity.fileSize);
    this.jdField_c_of_type_JavaLangString = com.qq.taf.jce.HexUtil.bytes2HexStr(arrayOfByte).toLowerCase(Locale.US);
    int i;
    if ((((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).isMediaPlatformEnabled()) || (b())) {
      if (e())
      {
        i = 1;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "SendOfflineFile: UseMediaPlatform enabled");
      }
    }
    while (i != 0)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "多媒体平台, 不管大小统一使用v3 协议，采用小文件策略");
      paramFileTransferObserver.jdField_a_of_type_Boolean = true;
      paramFileTransferObserver.jdField_a_of_type_Int = 1700;
      paramString = FileManagerUtil.a(new String(paramArrayOfByte1));
      if (paramString == null)
      {
        a(null, 0);
        return;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "SendOfflineFile: UseMediaPlatform enabled, but is retry or not use Exciting Send");
        i = 0;
        continue;
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "SendOfflineFile: UseMediaPlatform not enabled");
        i = 0;
      }
      else
      {
        k();
        paramFileManagerEntity.strFileSHA = FileHttpUtils.a(paramString);
        a(paramString);
        paramFileTransferObserver.e = paramString;
        a(false, paramFileTransferObserver.e);
        paramFileTransferObserver.jdField_d_of_type_ArrayOfByte = FileManagerUtil.b(new String(paramArrayOfByte1));
        paramFileTransferObserver.f = FileManagerUtil.d(new String(paramArrayOfByte1));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramFileTransferObserver, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, paramFileManagerEntity);
      return;
      if (paramLong <= 104857600L)
      {
        paramFileTransferObserver.jdField_a_of_type_Int = 1700;
        paramString = FileManagerUtil.a(new String(paramArrayOfByte1));
        if (paramString == null)
        {
          a(null, 0);
          return;
        }
        k();
        paramFileManagerEntity.strFileSHA = FileHttpUtils.a(paramString);
        a(paramString);
        paramFileTransferObserver.e = paramString;
        a(false, paramFileTransferObserver.e);
      }
      else
      {
        paramFileTransferObserver.jdField_a_of_type_Int = 1600;
        arrayOfByte = FileManagerUtil.d(new String(paramArrayOfByte1));
        if (arrayOfByte == null)
        {
          a(null, 0);
          return;
        }
        paramFileManagerEntity.strFileSha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(arrayOfByte);
        paramFileManagerEntity.str10Md5 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramArrayOfByte3);
        paramFileTransferObserver.f = arrayOfByte;
        this.jdField_d_of_type_ArrayOfByte = arrayOfByte;
        a(paramString, paramArrayOfByte1, paramArrayOfByte2, paramLong, paramArrayOfByte3, arrayOfByte);
      }
    }
  }
  
  private boolean a(FileTransferHandler.FileUploadInfo paramFileUploadInfo)
  {
    return (!paramFileUploadInfo.jdField_b_of_type_Boolean) && ((paramFileUploadInfo.jdField_b_of_type_JavaLangString == null) || (paramFileUploadInfo.jdField_b_of_type_JavaLangString.length() == 0));
  }
  
  private void b(long paramLong, int paramInt, String paramString)
  {
    b(paramLong, paramInt, paramString, null);
  }
  
  private void b(FileTransferHandler.FileUploadInfo paramFileUploadInfo)
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,onUpdateSendOfflineFile-->failed");
    a(1005);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
    int i = paramFileUploadInfo.jdField_a_of_type_Int;
    if (-100001 == paramFileUploadInfo.jdField_a_of_type_Int) {
      i = 9043;
    }
    String str = "server retError";
    if (paramFileUploadInfo.jdField_a_of_type_JavaLangString != null) {
      str = paramFileUploadInfo.jdField_a_of_type_JavaLangString;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, str);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, str);
  }
  
  private boolean b(FileTransferHandler.FileUploadInfo paramFileUploadInfo)
  {
    return (!TextUtils.isEmpty(paramFileUploadInfo.jdField_d_of_type_JavaLangString)) && (FileIPv6StrateyController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1));
  }
  
  private boolean g()
  {
    if ((e()) && (d()) && (c()))
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "re sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], custom uploader handled");
      return true;
    }
    return false;
  }
  
  private void n()
  {
    b();
    a(null, 0);
  }
  
  private void o()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [MiaoChuan] Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] is exist, Go [SetFileStatus Step]");
    j();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
    FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
    localFileAssistantReportData.jdField_b_of_type_JavaLangString = "send_file_suc";
    localFileAssistantReportData.jdField_a_of_type_Int = 1;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localFileAssistantReportData);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.f = false;
  }
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  protected IFileUploader a(FileTransferHandler.FileUploadInfo paramFileUploadInfo, List<String> paramList, int paramInt, boolean paramBoolean, String paramString)
  {
    return null;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    a(1002);
    paramLong = System.currentTimeMillis();
    if (paramLong - this.jdField_e_of_type_Long >= 1000L)
    {
      this.jdField_e_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    long l2 = 1L;
    long l1 = l2;
    if (!this.jdField_b_of_type_Boolean)
    {
      l1 = l2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a() > this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.b()) {
          l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.b();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (e()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", b());
    localBundle.putInt("param_V6SelectType", this.jdField_b_of_type_Int);
    localBundle.putInt("param_ipAddrType", d());
    if (this.jdField_c_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("param_ishttps", i);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null) {
        break;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, null, paramString2, 0, paramString1, null, localBundle);
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a(), paramString2, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.b(), paramString1, null, localBundle);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    paramInt = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
    paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
    for (;;)
    {
      paramObject.status = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      return;
      paramInt = 16;
    }
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == 0)
    {
      paramInt = 9001;
      paramString1 = "[Http_RespValue_Null]" + FileManagerUtil.a();
    }
    for (;;)
    {
      String str = paramString1;
      if (paramString1 == null) {
        str = "errMsgString_NUll_retCode[" + paramInt + "]";
      }
      if (!paramBoolean)
      {
        b(paramLong, paramInt, str, paramString2);
        return;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = null;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain = "";
      }
      c(System.currentTimeMillis());
      b(paramLong, paramInt, str, paramString2);
      n();
      return;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!paramBoolean)
    {
      b(paramLong, 9009, paramString1, paramString2);
      return;
    }
    a(1005);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
    b();
    a(paramLong, 9009, paramString1, paramString2);
  }
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  protected void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      this.jdField_c_of_type_ArrayOfByte = paramArrayOfByte;
      this.jdField_a_of_type_Int = 2;
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "setSha err sha=null. sessionid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a(Bundle paramBundle)
  {
    if (((this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_c_of_type_ArrayOfByte.length == 0)) && (paramBundle != null)) {
      paramBundle.putInt("_shaCalcProgress_", this.jdField_a_of_type_Int);
    }
    return this.jdField_c_of_type_ArrayOfByte;
  }
  
  public void aw_()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    ThreadManager.post(new Thread(new OfflineSendWorker.1(this)), 5, null, true);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
  }
  
  protected long b()
  {
    if ((this.jdField_c_of_type_Long == 0L) || (this.jdField_d_of_type_Long == 0L)) {}
    while (this.jdField_d_of_type_Long <= this.jdField_c_of_type_Long) {
      return 0L;
    }
    return this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a();
    }
    if (this.jdField_c_of_type_Long > 0L) {
      c(System.currentTimeMillis());
    }
  }
  
  protected void b(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  protected void b(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    long l2 = 1L;
    long l1 = l2;
    if (!this.jdField_b_of_type_Boolean)
    {
      l1 = l2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a() > this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.b()) {
          l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.b();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (e()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", b());
    localBundle.putInt("param_V6SelectType", this.jdField_b_of_type_Int);
    localBundle.putInt("param_ipAddrType", d());
    if (this.jdField_c_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("param_ishttps", i);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null) {
        break;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, null, null, 0, paramString2, null, localBundle);
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", l1, paramLong, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a(), paramString2, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.b(), paramString1, null, localBundle);
  }
  
  protected void b(String paramString)
  {
    long l2 = 1L;
    long l1 = l2;
    if (!this.jdField_b_of_type_Boolean)
    {
      l1 = l2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.b()) {
          l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize - this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.b();
        }
      }
    }
    Bundle localBundle = new Bundle();
    if (e()) {
      localBundle.putInt("param_fromType", 1);
    }
    localBundle.putLong("param_transferTime", b());
    localBundle.putInt("param_V6SelectType", this.jdField_b_of_type_Int);
    localBundle.putInt("param_ipAddrType", d());
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      i = 1;
      localBundle.putInt("param_ishttps", i);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader == null) {
        break label327;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.b(), paramString, localBundle);
      if (!e()) {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.b(), paramString, localBundle);
      }
    }
    label327:
    do
    {
      return;
      i = 0;
      break;
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUp", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 0, paramString, localBundle);
    } while (e());
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 0, paramString, localBundle);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize <= 0L) {}
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader == null) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a() * 100L / this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
  }
  
  public void c()
  {
    b();
  }
  
  protected void c(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
  
  protected boolean c()
  {
    return false;
  }
  
  protected int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader == null) {
      return 0;
    }
    return QFileUtils.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a());
  }
  
  public void d()
  {
    b();
    if (1 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] is Successed, return!");
      }
      return;
    }
    a(3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
    long l = System.currentTimeMillis();
    String str = "Now[" + l + "]startTime[" + this.jdField_a_of_type_Long + "]notifyTime[" + this.jdField_e_of_type_Long + "]";
    l = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null) {
      l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a();
    }
    a(l, 9037, str);
    b(l, 9037, str);
  }
  
  protected boolean d()
  {
    return false;
  }
  
  public void e()
  {
    b();
  }
  
  protected boolean e()
  {
    return false;
  }
  
  public void f()
  {
    c(System.currentTimeMillis());
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null)) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a();
    }
    o();
  }
  
  public boolean f()
  {
    if (this.f)
    {
      b();
      return true;
    }
    return false;
  }
  
  public void g()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [Upload Step]Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdate success, go [SetFileStatus Step]");
    j();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    c(System.currentTimeMillis());
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    a(1003);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a() }, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
    FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
    localFileAssistantReportData.jdField_b_of_type_JavaLangString = "send_file_suc";
    localFileAssistantReportData.jdField_a_of_type_Int = 1;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localFileAssistantReportData);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.f = false;
  }
  
  public void h()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain = "";
      m();
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]onOutDate, but not use last server path");
  }
  
  public void i() {}
  
  protected void j()
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "cancelShaReq. sessionid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]");
  }
  
  protected void k() {}
  
  protected void l() {}
  
  protected void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 13, null, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, 1002);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    b(0L);
    c(0L);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], strFilePath is null");
      }
      b(0L, 9005, FileManagerUtil.a());
      a(0L, 9005, FileManagerUtil.a());
      n();
    }
    do
    {
      do
      {
        return;
        l();
      } while (g());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain = "";
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], serverPath is null, so get upload info");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      byte[] arrayOfByte2;
      byte[] arrayOfByte3;
      try
      {
        byte[] arrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes("utf-8");
        arrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath().getBytes("utf-8");
        arrayOfByte3 = FileManagerUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
        if (arrayOfByte3 == null)
        {
          a(0);
          b(0L, 9042, "get md5 failed");
          a(0L, 9042, "get md5 failed");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("OfflineSendWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "], getMd5 failed");
        }
        a(0);
        b(0L, 9005, FileManagerUtil.a());
        a(0L, 9005, FileManagerUtil.a());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, arrayOfByte2, localUnsupportedEncodingException, arrayOfByte3, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    } while (!QLog.isColorLevel());
    QLog.e("##########", 2, "发送CS包,请求上传,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflineSendWorker
 * JD-Core Version:    0.7.0.1
 */