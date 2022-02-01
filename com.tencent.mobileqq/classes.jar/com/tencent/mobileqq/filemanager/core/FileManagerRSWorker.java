package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileHttpUploder;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploader;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.FileExecutor;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanageraux.core.WeiyunTask;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import com.tencent.wstt.SSCM.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class FileManagerRSWorker
  implements IFileHttpBase, IHttpCommunicatorListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new FileManagerRSWorker.5(this);
  private HttpUrlProcessor jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor;
  FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  OfflineFileHttpUploder jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder = null;
  OfflineFileUploader jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileUploader = null;
  FMSettings jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings = null;
  WeiyunTask jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = null;
  HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM;
  File jdField_a_of_type_JavaIoFile = null;
  InputStream jdField_a_of_type_JavaIoInputStream = null;
  OutputStream jdField_a_of_type_JavaIoOutputStream = null;
  Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  int[] jdField_a_of_type_ArrayOfInt = new int[0];
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  byte[] jdField_b_of_type_ArrayOfByte;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = 0L;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  byte[] jdField_c_of_type_ArrayOfByte;
  final int jdField_d_of_type_Int = 1000;
  long jdField_d_of_type_Long = 0L;
  String jdField_d_of_type_JavaLangString;
  int jdField_e_of_type_Int = 0;
  long jdField_e_of_type_Long;
  String jdField_e_of_type_JavaLangString;
  int jdField_f_of_type_Int = 0;
  long jdField_f_of_type_Long = 0L;
  String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int = 0;
  long jdField_g_of_type_Long = 0L;
  String jdField_g_of_type_JavaLangString;
  private int jdField_h_of_type_Int = 0;
  long jdField_h_of_type_Long = 0L;
  String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int = 0;
  long jdField_i_of_type_Long = 0L;
  String jdField_i_of_type_JavaLangString = null;
  private int jdField_j_of_type_Int = 0;
  long jdField_j_of_type_Long = 0L;
  String jdField_j_of_type_JavaLangString = null;
  private int jdField_k_of_type_Int;
  long jdField_k_of_type_Long = 0L;
  String jdField_k_of_type_JavaLangString = null;
  long jdField_l_of_type_Long = 0L;
  String jdField_l_of_type_JavaLangString = null;
  private long jdField_m_of_type_Long = 0L;
  private String jdField_m_of_type_JavaLangString = "";
  
  public FileManagerRSWorker(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      try
      {
        throw new NullPointerException("entry = null,why?");
      }
      catch (NullPointerException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      label215:
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramFileManagerEntity.getFilePath();
    this.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    this.jdField_g_of_type_JavaLangString = paramFileManagerEntity.Uuid;
    this.jdField_h_of_type_JavaLangString = paramFileManagerEntity.fileIdCrc;
    this.jdField_a_of_type_Boolean = paramFileManagerEntity.bUseMediaPlatform;
    this.jdField_b_of_type_Int = paramFileManagerEntity.nOpType;
    this.jdField_f_of_type_JavaLangString = paramFileManagerEntity.strServerPath;
    this.jdField_e_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings = FMSettings.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
        this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName == null)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
        }
        b();
        switch (this.jdField_b_of_type_Int)
        {
        default: 
          this.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
          this.jdField_b_of_type_Long = paramFileManagerEntity.uniseq;
          this.jdField_c_of_type_Long = paramFileManagerEntity.nSessionId;
          paramFileManagerEntity.status = 0;
          paramQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
          paramFileManagerEntity.fProgress = 0.0F;
          paramFileManagerEntity.status = 2;
          if (this.jdField_a_of_type_ComTencentWsttSSCMSSCM != null) {
            break label215;
          }
          this.jdField_a_of_type_ComTencentWsttSSCMSSCM = new SSCM();
          return;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + paramFileManagerEntity.nSessionId + "]filepath[" + this.jdField_b_of_type_JavaLangString + "]:size[" + String.valueOf(paramFileManagerEntity.fileSize) + "]");
      }
      a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.jdField_j_of_type_JavaLangString = "actFileUp";
        this.jdField_k_of_type_JavaLangString = "actFileUpDetail";
      }
      for (;;)
      {
        if ((paramFileManagerEntity.getFilePath() == null) || (paramFileManagerEntity.getFilePath().length() <= 0)) {
          break label643;
        }
        this.jdField_a_of_type_JavaIoFile = new File(paramFileManagerEntity.getFilePath());
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.jdField_j_of_type_JavaLangString = "actDiscussFileUp";
          this.jdField_k_of_type_JavaLangString = "actDiscussFileUpDetail";
        }
      }
      label643:
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath");
      }
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramFileManagerEntity.fileName);
      a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.jdField_j_of_type_JavaLangString = "actFileDown";
        this.jdField_k_of_type_JavaLangString = "actFileDownDetail";
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile) {
          break label788;
        }
        this.jdField_j_of_type_JavaLangString = "actFileUfGenDownload";
        this.jdField_k_of_type_JavaLangString = "actFileUfGenDownloadDetail";
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.jdField_j_of_type_JavaLangString = "actFileDiscDownLoad";
          this.jdField_k_of_type_JavaLangString = "actFileDiscDownLoadDetail";
        }
      }
      label788:
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "download insert, nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
      }
      this.jdField_j_of_type_JavaLangString = "actFileWyDown";
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "upload insert nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
      }
      this.jdField_j_of_type_JavaLangString = "actFileWyUp";
    }
  }
  
  private int a(int paramInt, Bundle paramBundle)
  {
    int n = paramInt;
    int i1;
    if (((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4Disc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      n = paramInt;
      if (paramBundle != null)
      {
        String str = paramBundle.getString("strHttpsDomain");
        i1 = paramBundle.getShort("httpsPort", (short)0);
        n = paramInt;
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_l_of_type_JavaLangString = str;
          if (i1 != 0) {
            break label80;
          }
          n = 443;
        }
      }
    }
    return n;
    label80:
    return i1;
  }
  
  @Nullable
  private String a(ByteStringMicro paramByteStringMicro, boolean paramBoolean, String paramString1, short paramShort1, Bundle paramBundle, String paramString2, short paramShort2, ArrayList<String> paramArrayList)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramString1 != null)
    {
      localObject1 = localObject3;
      if (paramByteStringMicro != null)
      {
        paramByteStringMicro = paramString1 + ":" + paramShort2;
        if ((!((IFMConfig)QRoute.api(IFMConfig.class)).getUserFtnSpeedTest()) || (this.jdField_c_of_type_Boolean)) {
          break label200;
        }
        paramByteStringMicro = "113.108.29.146:" + paramShort1;
      }
    }
    label200:
    for (;;)
    {
      paramArrayList.add(0, paramByteStringMicro);
      paramByteStringMicro = "";
      paramString1 = localObject2;
      if (paramBundle != null)
      {
        paramByteStringMicro = paramBundle.getString("IPv6Dns", "");
        paramString1 = paramBundle.getStringArrayList("ipv6list");
      }
      a(paramArrayList, paramByteStringMicro, paramShort2, paramString1, paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, paramString2);
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a(true);
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
        return localObject1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a(false);
      }
    }
  }
  
  private String a(String paramString)
  {
    return "/ftn_handler/" + paramString;
  }
  
  private String a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    String str = paramString4;
    if (paramString1 != null)
    {
      str = paramString4;
      if (paramString2 != null)
      {
        paramString4 = paramString1 + ":" + paramInt;
        paramString1 = a(paramString2);
        paramString2 = new ArrayList(1);
        paramString2.add(paramString4);
        if ((!TextUtils.isEmpty(paramString3)) && (FileIPv6StrateyController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5)))
        {
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. is config enable IPv6. domain[" + paramString3 + "]");
          paramString3 = new FileIPv6StrateyController.DomainInfo(paramString3, paramInt);
          paramString3 = FileIPv6StrateyController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, 5);
          if ((paramString3 == null) || (paramString3.a())) {
            break label266;
          }
          if (FileIPv6StrateyController.a())
          {
            QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download.debugIsDisableIPv4OnDoubleStack");
            paramString2.clear();
          }
          FileIPv6StrateyController.a(paramString3.jdField_a_of_type_JavaUtilList, paramString2, false, false);
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. use IPv6. hostlist:" + paramString2.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1);
        if (!this.jdField_c_of_type_Boolean) {
          break label278;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a(true);
      }
    }
    for (;;)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      return str;
      label266:
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. use IPv4");
      break;
      label278:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a(false);
    }
  }
  
  private short a(short paramShort, Bundle paramBundle)
  {
    short s1 = paramShort;
    short s2;
    if (((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      s1 = paramShort;
      if (paramBundle != null)
      {
        String str = paramBundle.getString("strHttpsDomain");
        s2 = paramBundle.getShort("httpsPort", (short)0);
        s1 = paramShort;
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_l_of_type_JavaLangString = str;
          if (s2 != 0) {
            break label80;
          }
          s1 = 443;
        }
      }
    }
    return s1;
    label80:
    return s2;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = (paramFloat1 / paramFloat2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    long l1 = System.currentTimeMillis();
    if (l1 - this.jdField_f_of_type_Long >= 1000L)
    {
      this.jdField_f_of_type_Long = l1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      if (QLog.isDevelopLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 4, "Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]Notify UI Progress! and send continue!");
      }
    }
  }
  
  private void a(long paramLong, FileManagerRSWorker.ChangeNewPath paramChangeNewPath)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(false);
    paramChangeNewPath = new ArrayList();
    paramChangeNewPath.add(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a(paramLong, paramChangeNewPath, SplashActivity.sTopActivity, new FileManagerRSWorker.13(this));
  }
  
  private void a(long paramLong, String paramString)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Recv]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] receviveFile, pos[" + paramLong + "] url:" + this.jdField_f_of_type_JavaLangString);
    if (this.jdField_b_of_type_Boolean) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Recv]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] is stoped!");
    }
    do
    {
      return;
      String str2 = "bytes=" + paramLong + "-";
      HttpMsg localHttpMsg = new HttpMsg(this.jdField_f_of_type_JavaLangString, null, this, true);
      localHttpMsg.setInstanceFollowRedirects(false);
      String str1 = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        str1 = "wifi";
      }
      localHttpMsg.setRequestProperty("Net-type", str1);
      localHttpMsg.setRequestProperty("cache-control", "no-cache");
      localHttpMsg.setRequestProperty("Range", str2);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "set cookie:" + paramString);
      }
      if (paramString != null) {
        localHttpMsg.setRequestProperty("Cookie", paramString);
      }
      localHttpMsg.setPriority(1);
      localHttpMsg.setDataSlice(true);
      localHttpMsg.fileType = 0;
      localHttpMsg.busiType = this.jdField_a_of_type_Int;
      localHttpMsg.msgId = String.valueOf(this.jdField_c_of_type_Long);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Recv]Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recv http data RANGE[" + String.valueOf(str2) + "], peerType[" + String.valueOf(this.jdField_a_of_type_Int) + "]");
      localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
      paramString = "";
      if (this.jdField_f_of_type_JavaLangString != null) {
        paramString = this.jdField_f_of_type_JavaLangString.toLowerCase();
      }
      if ((this.jdField_c_of_type_Boolean) && (paramString.startsWith("https")))
      {
        localHttpMsg.mIsHttps = true;
        localHttpMsg.mIsHostIP = HttpUrlProcessor.a(this.jdField_f_of_type_JavaLangString);
        localHttpMsg.mReqHost = this.jdField_l_of_type_JavaLangString;
      }
      localHttpMsg.timeoutParam = FileManagerUtil.a();
      ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).sendMsg(localHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
    } while (paramLong != 0L);
    a(2001);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 10, null, 6, null);
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    a(2003);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    if (FileUtils.a(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
    }
    FileManagerUtil.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] is exist, and filesize is right!");
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_j_of_type_Int, null, paramBundle);
  }
  
  private void a(FileTransferHandler.FileUploadInfo paramFileUploadInfo)
  {
    if ((paramFileUploadInfo.jdField_a_of_type_Int == 0) && (!this.jdField_b_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder.a();
      }
      b();
      if ((paramFileUploadInfo.jdField_a_of_type_ArrayOfByte == null) || (paramFileUploadInfo.jdField_a_of_type_ArrayOfByte.length <= 0)) {
        break label203;
      }
      this.jdField_g_of_type_JavaLangString = new String(paramFileUploadInfo.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, this.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
      paramFileUploadInfo = new FileManagerReporter.FileAssistantReportData();
      paramFileUploadInfo.jdField_b_of_type_JavaLangString = "send_file_suc";
      paramFileUploadInfo.jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFileUploadInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      label203:
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
    }
  }
  
  private void a(HttpMsg paramHttpMsg, Bundle paramBundle, int paramInt, long paramLong)
  {
    this.jdField_g_of_type_Int += 1;
    this.jdField_j_of_type_Int += 1;
    if (paramInt == 9056)
    {
      if (this.jdField_h_of_type_Int < 3)
      {
        this.jdField_h_of_type_Int += 1;
        this.jdField_g_of_type_Int -= 1;
      }
    }
    else if (paramInt == 9042)
    {
      if (this.jdField_i_of_type_Int >= 3) {
        break label302;
      }
      this.jdField_i_of_type_Int += 1;
      this.jdField_g_of_type_Int -= 1;
    }
    for (;;)
    {
      int n = 6000;
      if (paramInt == 9056) {
        n = 0;
      }
      ThreadManager.getFileThreadHandler().postDelayed(new FileManagerRSWorker.7(this), n);
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.jdField_c_of_type_Long + "] after [" + n + "] time retry!");
      int i1 = paramInt;
      if (9048 == paramInt) {
        i1 = 11202;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, paramLong, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(paramHttpMsg.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg.getRealUrl(), paramHttpMsg.rawRespHeader, this.jdField_j_of_type_Int, "delayTimes[" + n + "]" + paramHttpMsg.getErrorString(), null, paramBundle);
      return;
      this.jdField_h_of_type_Int = 0;
      break;
      label302:
      this.jdField_i_of_type_Int = 0;
    }
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    this.jdField_i_of_type_Long += paramInt;
    Object localObject = a(paramLong, paramInt);
    if (localObject == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Upload Step] Id[" + this.jdField_c_of_type_Long + "]sendFilePakage transferData null");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "get Stream null", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, "get Stream null", null);
      handleError(null, null);
    }
    do
    {
      return;
      localObject = new HttpMsg(paramString + "&bmd5=" + MD5.toMD5((byte[])localObject) + "&range=" + String.valueOf(paramLong), (byte[])localObject, this);
      ((HttpMsg)localObject).setInstanceFollowRedirects(false);
      ((HttpMsg)localObject).setRequestProperty("cache-control", "no-cache");
      paramString = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        paramString = "wifi";
      }
      ((HttpMsg)localObject).setRequestProperty("Net-type", paramString);
      ((HttpMsg)localObject).setRequestProperty("Range", "bytes=" + paramLong + "-");
      ((HttpMsg)localObject).setRequestMethod("POST");
      ((HttpMsg)localObject).setPriority(1);
      ((HttpMsg)localObject).fileType = 0;
      ((HttpMsg)localObject).busiType = this.jdField_a_of_type_Int;
      ((HttpMsg)localObject).msgId = String.valueOf(this.jdField_c_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_c_of_type_Long + "]send http data size[" + paramInt + "], peerType[" + this.jdField_a_of_type_Int + "]");
      }
      ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).sendMsg((HttpMsg)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = ((HttpMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.e("##########", 2, "发送一个数据包,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    paramString = new OfflineFileUploadPara();
    paramString.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    paramString.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramString.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    paramString.jdField_a_of_type_Long = this.jdField_d_of_type_Long;
    paramString.jdField_c_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (paramLong <= 104857600L)
    {
      paramString.jdField_a_of_type_Int = 1700;
      this.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(new String(paramArrayOfByte1));
      if (this.jdField_b_of_type_ArrayOfByte == null)
      {
        a(null, 0);
        return;
      }
      paramString.e = this.jdField_b_of_type_ArrayOfByte;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], filesize < 100 get sha1");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, paramFileManagerEntity);
      return;
      paramString.jdField_a_of_type_Int = 1600;
      this.jdField_c_of_type_ArrayOfByte = FileManagerUtil.d(new String(paramArrayOfByte1));
      paramFileManagerEntity.strFileSha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte);
      paramFileManagerEntity.str10Md5 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      if (this.jdField_c_of_type_ArrayOfByte == null)
      {
        a(null, 0);
        return;
      }
      paramString.f = this.jdField_c_of_type_ArrayOfByte;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], filesize > 100 get sha3");
    }
  }
  
  private void a(List<String> paramList1, String paramString, int paramInt, List<String> paramList2, boolean paramBoolean)
  {
    if ((paramList1 == null) || (!FileIPv6StrateyController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)))
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    if ((paramBoolean) && (paramList2 != null) && (paramList2.size() > 0))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download. is config enable IPv6. v6ipsize[" + paramList2.size() + "]");
      paramString = FileIPv6StrateyController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramList2);
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (FileIPv6StrateyController.a())
        {
          QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download. debugIsDisableIPv4OnDoubleStack");
          paramList1.clear();
        }
        int n = paramString.size() - 1;
        while (n >= 0)
        {
          paramList2 = (String)paramString.get(n);
          if (!TextUtils.isEmpty(paramList2)) {
            paramList1.add(0, "[" + paramList2 + "]:" + paramInt);
          }
          n -= 1;
        }
        this.jdField_c_of_type_Int = 2;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download use IPv6. iplist:" + paramList1.toString());
        return;
      }
      this.jdField_c_of_type_Int = 1;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download use IPv4");
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. is config enable IPv6. domain[" + paramString + "]");
      paramString = new FileIPv6StrateyController.DomainInfo(paramString, paramInt);
      paramString = FileIPv6StrateyController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
      if ((paramString != null) && (!paramString.a()))
      {
        if (FileIPv6StrateyController.a())
        {
          QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. debugIsDisableIPv4OnDoubleStack");
          paramList1.clear();
        }
        FileIPv6StrateyController.a(paramString.jdField_a_of_type_JavaUtilList, paramList1, false, false);
        this.jdField_c_of_type_Int = 2;
        if (paramString.jdField_a_of_type_Int == 1) {
          this.jdField_c_of_type_Int = 3;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. use IPv6. iplist:" + paramList1.toString());
        return;
      }
      this.jdField_c_of_type_Int = 1;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. use IPv4");
      return;
    }
    this.jdField_c_of_type_Int = 1;
  }
  
  private void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    if (a())
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay], SessionId[" + this.jdField_c_of_type_Long + "], working stop!");
      return;
    }
    if (paramBoolean2) {}
    for (String str1 = paramString4 + "&isthumb=0";; str1 = paramString4)
    {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = paramString6;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform = paramBoolean2;
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      if (a(paramBoolean1, paramLong1, paramString1, paramInt, "=_= ^! [CS Replay]id[", "server ret error")) {
        break;
      }
      this.jdField_i_of_type_JavaLangString = paramString2;
      if (paramString5 != null) {
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramString5);
      }
      short s = a(paramShort, paramBundle);
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str2 = (String)paramList.next();
          localArrayList.add(str2 + ":" + s);
        }
      }
      paramList = (IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
      if (paramList.isHarcodeIP())
      {
        localArrayList.clear();
        paramString3 = paramList.getHarcodeIP();
      }
      for (;;)
      {
        str1 = a(paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramBundle, str1, s, localArrayList);
        paramList = new Bundle();
        paramList.putInt("param_V6SelectType", this.jdField_c_of_type_Int);
        paramList.putInt("param_ipAddrType", d());
        if (this.jdField_c_of_type_Boolean) {}
        for (int n = 1;; n = 0)
        {
          paramList.putInt("param_ishttps", n);
          if (a(paramLong1, paramString1, paramInt, str1, paramList)) {
            break;
          }
          this.jdField_f_of_type_JavaLangString = str1;
          this.jdField_m_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong1) + "] mUseHttps:" + this.jdField_c_of_type_Boolean + " mHttpsDomain:" + this.jdField_l_of_type_JavaLangString + " downloadPort:" + s);
          if ((paramLong1 != 0L) && (paramString1 != null) && (paramString1.length() > 0))
          {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
          }
          if (-1L != this.jdField_b_of_type_Long) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_e_of_type_JavaLangString, 0, this.jdField_b_of_type_Long);
          }
          str1 = MD5.toMD5(this.jdField_g_of_type_JavaLangString);
          this.jdField_d_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + str1);
          if (NetworkUtil.d(BaseApplication.getContext())) {
            break label954;
          }
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] no network! return!");
          a(2005);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "net", null, paramList);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "net", null, paramList);
          return;
        }
        label954:
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "], strTmp[" + this.jdField_d_of_type_JavaLangString + "]");
        }
        this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
        if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
        {
          a(paramList);
          return;
        }
        if ((this.jdField_d_of_type_Long > this.jdField_a_of_type_Long) && (a(paramBoolean1, paramLong1, paramString1, paramString2, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramString4, paramInt, paramString5, paramString6, paramString7, paramLong2, paramBundle, localArrayList))) {
          break;
        }
        k();
        return;
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    if (a()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay] id[" + this.jdField_c_of_type_Long + "]OnDiscDownloadInfo, network error");
    }
    int n;
    String str;
    do
    {
      do
      {
        return;
      } while (a(paramBoolean, paramLong1, paramString1, paramInt2, "=_= v! [Disc Download Replay]id[", "ret error"));
      n = a(paramInt1, paramBundle);
      str = "";
      if (paramBundle != null) {
        str = paramBundle.getString("IPv6Dns", "");
      }
      str = a(paramString3, paramString4, n, str, null);
    } while (a(paramLong1, paramString1, paramInt2, str));
    this.jdField_f_of_type_JavaLangString = str;
    this.jdField_m_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Disc Download Replay]nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong1) + "]downLoadUrl[" + String.valueOf(this.jdField_f_of_type_JavaLangString) + "] mUseHttps:" + this.jdField_c_of_type_Boolean + " mHttpsDomain:" + this.jdField_l_of_type_JavaLangString + " downloadPort:" + n);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "nSeseeId[" + String.valueOf(this.jdField_c_of_type_Long) + "]renamed[" + String.valueOf(paramString2) + "]");
      }
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramString2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 1) {
      this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_d_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + "dsc-" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.replace("/", "")));
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "], NetWork Error, notify UI!");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "net", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "net", null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_c_of_type_Long, this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "], strTmp[" + this.jdField_d_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      a(2003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (FileUtils.a(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
      }
      FileManagerUtil.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "], fileExisted, notify UI!");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_j_of_type_Int, null);
      return;
    }
    if (this.jdField_d_of_type_Long > this.jdField_a_of_type_Long)
    {
      long l1 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a() < l1)
      {
        a(l1, new FileManagerRSWorker.3(this, paramBoolean, paramLong1, paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramLong2, paramBundle));
        return;
      }
    }
    FileManagerUtil.FileExecutor.a().execute(new FileManagerRSWorker.4(this, paramString5));
  }
  
  private void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] id[" + this.jdField_c_of_type_Long + "]onDownloadFileSuc");
    if ((paramBoolean) && ((paramFileUploadInfo.jdField_c_of_type_Int == 2) || (paramFileUploadInfo.jdField_c_of_type_Int == 0)) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramFileUploadInfo.jdField_a_of_type_Int + "],retMsg[" + paramFileUploadInfo.jdField_a_of_type_JavaLangString + "],retStat[" + paramFileUploadInfo.jdField_c_of_type_Int + "]. need to send file receipt");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramFileUploadInfo.jdField_a_of_type_Int + "],retMsg[" + paramFileUploadInfo.jdField_a_of_type_JavaLangString + "],retStat[" + paramFileUploadInfo.jdField_c_of_type_Int + "]. don't need to send file receipt");
  }
  
  private boolean a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] get DiscdownLoad info Url is null");
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      if (paramLong == 0L) {
        paramLong = 9048L;
      }
      for (;;)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "ip url error", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "ip url error", null);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(long paramLong, String paramString1, int paramInt, String paramString2, Bundle paramBundle)
  {
    if (paramString2 == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] get offlinefile info Url is null, IP is null too");
      a(2005);
      if ((paramLong == -6101L) || (paramLong == -7003L)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      if (paramLong == 0L) {
        paramLong = 9048L;
      }
      for (;;)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "ip url error", null, paramBundle);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "ip url error", null, paramBundle);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(HttpMsg paramHttpMsg)
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]已经结束,返回");
      }
    }
    do
    {
      return true;
      if (paramHttpMsg == this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) {
        break;
      }
      if ((paramHttpMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "],Req Serial[" + String.valueOf(paramHttpMsg.getSerial()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
        return true;
      }
      if (paramHttpMsg != null)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "],Req Serial[" + String.valueOf(paramHttpMsg.getSerial()) + "]");
        return true;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null);
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
    return true;
    return false;
  }
  
  /* Error */
  private boolean a(HttpMsg paramHttpMsg, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 1166	com/tencent/mobileqq/utils/httputils/HttpMsg:getResponseCode	()I
    //   4: sipush 206
    //   7: if_icmpeq +13 -> 20
    //   10: aload_1
    //   11: invokevirtual 1166	com/tencent/mobileqq/utils/httputils/HttpMsg:getResponseCode	()I
    //   14: sipush 200
    //   17: if_icmpne +184 -> 201
    //   20: aload_0
    //   21: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   24: aload_1
    //   25: invokevirtual 1169	com/tencent/mobileqq/utils/httputils/HttpMsg:getRecvData	()[B
    //   28: invokevirtual 1174	java/io/OutputStream:write	([B)V
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 109	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   36: aload_1
    //   37: invokevirtual 1169	com/tencent/mobileqq/utils/httputils/HttpMsg:getRecvData	()[B
    //   40: arraylength
    //   41: i2l
    //   42: lstore_3
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 103	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   48: lload_3
    //   49: ladd
    //   50: putfield 103	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   53: aload_0
    //   54: lload_3
    //   55: aload_0
    //   56: getfield 50	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   59: ladd
    //   60: putfield 50	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   63: aload_0
    //   64: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   67: lstore_3
    //   68: aload_1
    //   69: invokevirtual 1177	com/tencent/mobileqq/utils/httputils/HttpMsg:getTotalLen	()J
    //   72: lstore_3
    //   73: aload_0
    //   74: getfield 50	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   77: lload_3
    //   78: lcmp
    //   79: iflt +643 -> 722
    //   82: aload_0
    //   83: getfield 148	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   86: sipush 3000
    //   89: if_icmpeq +91 -> 180
    //   92: aload_0
    //   93: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   96: getfield 176	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   99: invokestatic 1180	com/tencent/mobileqq/filemanager/fileassistant/util/QFileAssistantUtils:a	(Ljava/lang/String;)Z
    //   102: ifne +78 -> 180
    //   105: aload_0
    //   106: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   109: getfield 1121	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   112: ifne +68 -> 180
    //   115: ldc 240
    //   117: iconst_1
    //   118: new 242	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 1182
    //   128: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   135: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   138: ldc_w 1184
    //   141: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 270	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: getfield 187	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   154: invokevirtual 716	com/tencent/mobileqq/app/QQAppInterface:getFileTransferHandler	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   157: aload_0
    //   158: getfield 194	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: aload_0
    //   162: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   165: aload_0
    //   166: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Boolean	Z
    //   169: aload_0
    //   170: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   173: aload_0
    //   174: getfield 101	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver	Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;
    //   177: invokevirtual 1187	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;)V
    //   180: aload_0
    //   181: aconst_null
    //   182: putfield 655	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   185: aload_0
    //   186: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   189: invokevirtual 1190	java/io/OutputStream:close	()V
    //   192: aload_0
    //   193: aconst_null
    //   194: putfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   197: aload_0
    //   198: invokespecial 1192	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:l	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 1195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   208: ldc_w 1197
    //   211: invokevirtual 1200	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   214: ifeq +141 -> 355
    //   217: aload_0
    //   218: monitorenter
    //   219: aload_0
    //   220: iconst_1
    //   221: putfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Boolean	Z
    //   224: aload_0
    //   225: monitorexit
    //   226: aload_0
    //   227: getfield 655	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   230: ifnull +98 -> 328
    //   233: ldc 240
    //   235: iconst_2
    //   236: new 242	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 1202
    //   246: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   253: invokestatic 262	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   256: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc_w 1204
    //   262: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_0
    //   266: getfield 655	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   269: invokevirtual 789	com/tencent/mobileqq/utils/httputils/HttpMsg:getSerial	()I
    //   272: invokestatic 602	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   275: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc_w 913
    //   281: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_1
    //   285: invokevirtual 1195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   288: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 270	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload_0
    //   298: getfield 187	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   301: ldc_w 637
    //   304: ldc_w 639
    //   307: invokevirtual 643	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   310: checkcast 637	com/tencent/mobileqq/transfile/api/IHttpEngineService
    //   313: invokeinterface 647 1 0
    //   318: checkcast 649	com/tencent/mobileqq/transfile/HttpCommunicator
    //   321: aload_0
    //   322: getfield 655	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   325: invokevirtual 1208	com/tencent/mobileqq/transfile/HttpCommunicator:cancelMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   328: aload_0
    //   329: getfield 187	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   332: invokevirtual 501	com/tencent/mobileqq/app/QQAppInterface:getFileManagerRSCenter	()Lcom/tencent/mobileqq/filemanager/core/FileManagerRSCenter;
    //   335: iconst_0
    //   336: invokevirtual 504	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:a	(Z)V
    //   339: aload_0
    //   340: aload_0
    //   341: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   344: new 1210	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker$6
    //   347: dup
    //   348: aload_0
    //   349: invokespecial 1211	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker$6:<init>	(Lcom/tencent/mobileqq/filemanager/core/FileManagerRSWorker;)V
    //   352: invokespecial 1097	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(JLcom/tencent/mobileqq/filemanager/core/FileManagerRSWorker$ChangeNewPath;)V
    //   355: aload_0
    //   356: getfield 187	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   359: aload_0
    //   360: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   363: getfield 211	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   366: aload_0
    //   367: getfield 84	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   370: aload_0
    //   371: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   374: aload_0
    //   375: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   378: aload_0
    //   379: getfield 178	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   382: aload_0
    //   383: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   386: aload_0
    //   387: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   390: getfield 688	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   393: ldc2_w 812
    //   396: ldc 117
    //   398: aload_0
    //   399: getfield 103	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   402: aload_0
    //   403: getfield 50	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   406: aload_0
    //   407: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   410: aload_0
    //   411: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   414: ldc 117
    //   416: aload_0
    //   417: getfield 109	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   420: ldc_w 1213
    //   423: aconst_null
    //   424: aload_2
    //   425: invokestatic 803	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   428: aload_0
    //   429: getfield 187	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   432: aload_0
    //   433: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   436: getfield 211	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   439: aload_0
    //   440: getfield 86	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   443: aload_0
    //   444: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   447: aload_0
    //   448: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   451: aload_0
    //   452: getfield 178	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   455: aload_0
    //   456: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   459: aload_0
    //   460: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   463: getfield 688	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   466: ldc2_w 812
    //   469: ldc 117
    //   471: aload_0
    //   472: getfield 103	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   475: aload_0
    //   476: getfield 50	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   479: aload_0
    //   480: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   483: aload_0
    //   484: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   487: ldc 117
    //   489: aload_0
    //   490: getfield 115	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_Int	I
    //   493: ldc_w 1213
    //   496: aconst_null
    //   497: aload_2
    //   498: invokestatic 803	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   501: aload_0
    //   502: aconst_null
    //   503: aconst_null
    //   504: invokevirtual 822	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:handleError	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   507: iconst_1
    //   508: ireturn
    //   509: astore_1
    //   510: aload_0
    //   511: monitorexit
    //   512: aload_1
    //   513: athrow
    //   514: astore_1
    //   515: aload_0
    //   516: getfield 187	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   519: aload_0
    //   520: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   523: getfield 211	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   526: aload_0
    //   527: getfield 84	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   530: aload_0
    //   531: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   534: aload_0
    //   535: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   538: aload_0
    //   539: getfield 178	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   542: aload_0
    //   543: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   546: aload_0
    //   547: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   550: getfield 688	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   553: ldc2_w 812
    //   556: ldc 117
    //   558: aload_0
    //   559: getfield 103	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   562: aload_0
    //   563: getfield 50	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   566: aload_0
    //   567: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   570: aload_0
    //   571: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   574: ldc 117
    //   576: aload_0
    //   577: getfield 109	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   580: ldc_w 1213
    //   583: aconst_null
    //   584: aload_2
    //   585: invokestatic 803	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   588: aload_0
    //   589: getfield 187	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   592: aload_0
    //   593: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   596: getfield 211	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   599: aload_0
    //   600: getfield 86	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   603: aload_0
    //   604: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   607: aload_0
    //   608: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   611: aload_0
    //   612: getfield 178	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   615: aload_0
    //   616: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   619: aload_0
    //   620: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   623: getfield 688	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   626: ldc2_w 812
    //   629: ldc 117
    //   631: aload_0
    //   632: getfield 103	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   635: aload_0
    //   636: getfield 50	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   639: aload_0
    //   640: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   643: aload_0
    //   644: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   647: ldc 117
    //   649: aload_0
    //   650: getfield 115	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_Int	I
    //   653: ldc_w 1213
    //   656: aconst_null
    //   657: aload_2
    //   658: invokestatic 803	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   661: aload_0
    //   662: aconst_null
    //   663: aconst_null
    //   664: invokevirtual 822	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:handleError	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   667: iconst_1
    //   668: ireturn
    //   669: astore_1
    //   670: ldc_w 1215
    //   673: iconst_1
    //   674: new 242	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   681: ldc 245
    //   683: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_0
    //   687: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   690: invokestatic 262	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   693: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 1217
    //   699: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload_1
    //   703: invokevirtual 1218	java/io/IOException:toString	()Ljava/lang/String;
    //   706: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokestatic 270	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   715: aload_1
    //   716: invokevirtual 1219	java/io/IOException:printStackTrace	()V
    //   719: goto -527 -> 192
    //   722: aload_0
    //   723: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   726: aload_0
    //   727: getfield 50	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   730: l2f
    //   731: aload_0
    //   732: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   735: l2f
    //   736: fdiv
    //   737: putfield 227	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   740: aload_0
    //   741: sipush 2002
    //   744: invokevirtual 273	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   747: invokestatic 477	java/lang/System:currentTimeMillis	()J
    //   750: lstore_3
    //   751: lload_3
    //   752: aload_0
    //   753: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   756: lsub
    //   757: ldc2_w 478
    //   760: lcmp
    //   761: ifge +5 -> 766
    //   764: iconst_1
    //   765: ireturn
    //   766: aload_0
    //   767: lload_3
    //   768: putfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   771: aload_0
    //   772: getfield 185	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   775: aload_0
    //   776: getfield 50	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   779: l2f
    //   780: aload_0
    //   781: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   784: l2f
    //   785: fdiv
    //   786: putfield 227	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   789: aload_0
    //   790: getfield 187	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   793: invokevirtual 486	com/tencent/mobileqq/app/QQAppInterface:getFileManagerNotifyCenter	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   796: aload_0
    //   797: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   800: aload_0
    //   801: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   804: aload_0
    //   805: getfield 178	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   808: aload_0
    //   809: getfield 148	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   812: bipush 16
    //   814: aconst_null
    //   815: iconst_0
    //   816: aconst_null
    //   817: invokevirtual 491	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   820: goto -619 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	823	0	this	FileManagerRSWorker
    //   0	823	1	paramHttpMsg	HttpMsg
    //   0	823	2	paramBundle	Bundle
    //   42	726	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   20	31	203	java/lang/Exception
    //   219	226	509	finally
    //   510	512	509	finally
    //   339	355	514	java/lang/Exception
    //   185	192	669	java/io/IOException
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if ((a()) || (this.jdField_k_of_type_Int == 1003) || (this.jdField_k_of_type_Int == 2003)) {
      return true;
    }
    if ((paramHttpMsg1 == null) && (paramHttpMsg2 == null))
    {
      b();
      a(null, 0);
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    return (paramString.contains("-6101")) || (paramString.contains("-7003")) || (paramString.contains("-403")) || (paramString.contains("-9006")) || (paramString.contains("-9004")) || (paramString.contains("-9017")) || (paramString.contains("-28137"));
  }
  
  private boolean a(boolean paramBoolean, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (!paramBoolean)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, paramString2 + String.valueOf(this.jdField_c_of_type_Long) + "] get offlinefile info is error!retCode[" + String.valueOf(paramLong) + "], retMsg:" + paramInt);
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      if (paramLong == -100001L) {}
      for (long l1 = 9043L;; l1 = 9045L)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, paramString3, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, paramString3, null);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle, ArrayList<String> paramArrayList)
  {
    long l1 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a() < l1)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_c_of_type_Long) + "] not enought space! ProcessNewPath");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramArrayList);
      a(l1, new FileManagerRSWorker.2(this, paramBoolean1, paramLong1, paramString1, paramString2, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramString4, localArrayList, paramInt, paramString5, paramString6, paramString7, paramLong2, paramBundle));
      return true;
    }
    return false;
  }
  
  private boolean b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {}
    do
    {
      return false;
      if (paramHttpMsg2 == null) {
        return true;
      }
    } while (!NetworkUtil.d(BaseApplication.getContext()));
    return true;
  }
  
  private boolean b(String paramString)
  {
    return (paramString.contains("-29120")) || (paramString.contains("-502")) || (paramString.contains("HTTP_PROXY_AUTH")) || (paramString.contains("-29150")) || (paramString.contains("-21122")) || (paramString.contains("-28123")) || (paramString.contains("-25081")) || (paramString.contains("-28126"));
  }
  
  private static String c()
  {
    try
    {
      Thread.sleep(1L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private int d()
  {
    return QFileUtils.c(this.jdField_f_of_type_JavaLangString);
  }
  
  private void k()
  {
    FileManagerUtil.FileExecutor.a().execute(new FileManagerRSWorker.1(this));
  }
  
  private void l()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Download]Id[" + this.jdField_c_of_type_Long + "] downLoad Success!");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = MessageCache.a();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Http Download]Id[" + this.jdField_c_of_type_Long + "] update successTime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + "]");
    int n = this.jdField_b_of_type_JavaLangString.length() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.length();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250 - n)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, 250 - n);
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("param_V6SelectType", this.jdField_c_of_type_Int);
    ((Bundle)localObject1).putInt("param_ipAddrType", d());
    if (this.jdField_c_of_type_Boolean) {}
    for (n = 1;; n = 0)
    {
      ((Bundle)localObject1).putInt("param_ishttps", n);
      if (FileUtils.a(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
      }
      try
      {
        boolean bool2 = FileManagerUtil.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
        boolean bool1 = bool2;
        if (!bool2)
        {
          bool1 = FileManagerUtil.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "rename with vfs error, normalResult[" + bool1 + "]");
        }
        if (bool1) {
          break;
        }
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]rename file error, strTmpPath[" + this.jdField_d_of_type_JavaLangString + "],strFilePath[" + this.jdField_b_of_type_JavaLangString + "]");
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "rename error", null, (Bundle)localObject1);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "rename error", null, (Bundle)localObject1);
        handleError(null, null);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
        localObject2 = com.qq.taf.jce.HexUtil.bytes2HexStr(FileManagerUtil.e(this.jdField_b_of_type_JavaLangString));
        if (localObject2 != null) {
          break label1355;
        }
      }
    }
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "mathMd5 is null", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "rename error", null, (Bundle)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = FileHttpUtils.a(FileManagerUtil.c(this.jdField_b_of_type_JavaLangString));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize < 104857600L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = FileHttpUtils.a(FileManagerUtil.a(this.jdField_b_of_type_JavaLangString));
      }
    }
    Object localObject2 = new File(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.localModifyTime = ((File)localObject2).lastModified();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    a(2003);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recive success, set TrafficData,size[" + String.valueOf(this.jdField_a_of_type_Long) + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_j_of_type_Int, null, (Bundle)localObject1);
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_j_of_type_Int, null, (Bundle)localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      FilePicURLDrawlableHelper.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      FilePicURLDrawlableHelper.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    for (;;)
    {
      FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("FILE_TMP_SERVER_PATH", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath);
        ((Bundle)localObject1).putLong("FILE_TMP_RELATED_ID", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId);
        ((Bundle)localObject1).putString("FILE_TMP_DIR_PATH", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath);
        ((Bundle)localObject1).putBoolean("FILE_TMP_IS_ZIPINNER_FILE", true);
        ((Bundle)localObject1).putString("FILE_TMP_ZIP_FILEID", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipFileId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(null, -1, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long, 190, null, (Bundle)localObject1);
      }
      localObject1 = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject1).jdField_b_of_type_JavaLangString = "rece_file_suc";
      ((FileManagerReporter.FileAssistantReportData)localObject1).jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject1);
      return;
      label1355:
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() > 0) && (!((String)localObject2).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "md5 is not equal", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "rename error", null, (Bundle)localObject1);
        break;
      }
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2) {
        FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      } else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
  }
  
  private void m()
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
    }
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
      if (SystemUtil.a()) {}
      for (long l1 = SystemUtil.a() * 1024L; l1 < l2; l1 = SystemUtil.b() * 1024L)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
        return;
      }
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(localFileManagerEntity, null, new FileManagerRSWorker.10(this, localFileManagerEntity));
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask.a(localFileManagerEntity.WeiYunFileId);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "start Rsworker OfflineFileHitReq:" + MessageCache.a());
    }
    FileManagerUtil.FileExecutor.a().execute(new FileManagerRSWorker.12(this));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = c();
    }
    paramString1 = new File(str + paramString1);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
    return paramString1.getAbsoluteFile().toString();
  }
  
  public void a(int paramInt)
  {
    paramInt = FileManagerUtil.b(paramInt);
    if ((this.jdField_k_of_type_Int == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.jdField_k_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
    } while (paramInt == 2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin = this.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (this.jdField_g_of_type_JavaLangString != null) {}
    for (String str = this.jdField_g_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)
    {
      localFileManagerEntity.Uuid = str;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    HttpMsg localHttpMsg = (HttpMsg)paramObject;
    int n;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "why actionType is out?!");
    case 0: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16) {
          break;
        }
        n = 0;
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
      } while (localHttpMsg == null);
      paramObject = localHttpMsg.getErrorString();
      if ((paramInt == 0) && (paramObject == null))
      {
        paramObject = "[Http_RespValue_Null]" + FileManagerUtil.a();
        paramInt = 9001;
      }
      break;
    }
    for (;;)
    {
      Object localObject = paramObject;
      if (paramObject == null) {
        localObject = "errMsgString_NUll_retCode[" + paramInt + "]";
      }
      if (((String)localObject).indexOf("-6101") > 0) {
        paramInt = 9042;
      }
      if (((String)localObject).contains("HTTP_PROXY_AUTH")) {
        paramInt = 9004;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, String.valueOf(localHttpMsg.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, localHttpMsg.getRealUrl(), localHttpMsg.rawRespHeader, this.jdField_j_of_type_Int, (String)localObject, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      n = 16;
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
        break;
      }
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_b_of_type_Int == 0) {}
    for (int n = 1; n != 0; n = 0)
    {
      this.jdField_f_of_type_JavaLangString = paramString;
      this.jdField_m_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_f_of_type_Int += 1;
      a(this.jdField_f_of_type_JavaLangString, 0L);
      return;
    }
    this.jdField_f_of_type_JavaLangString = paramString;
    this.jdField_m_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    this.jdField_f_of_type_Int += 1;
    this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
    a(this.jdField_a_of_type_Long, this.jdField_i_of_type_JavaLangString);
  }
  
  void a(String paramString, long paramLong)
  {
    if (a())
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Upload Step], working stoped!");
      return;
    }
    if (paramLong == 0L) {
      this.jdField_a_of_type_Long = 0L;
    }
    int i1 = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, 1048576);
    int i2 = Utils.a(BaseApplication.getContext());
    int n;
    if (i2 != 1)
    {
      n = i1;
      if (i2 != 2) {}
    }
    else
    {
      n = i1;
      if (i1 > 16384) {
        n = 16384;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "sendFilePakage transferedSize[" + paramLong + "], packetSize[" + n + "]");
    a(paramString, paramLong, n);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  /* Error */
  byte[] a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   4: ifnonnull +23 -> 27
    //   7: aload_0
    //   8: new 1527	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 143	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 1528	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 125	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_Long	J
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +96 -> 126
    //   33: aload_0
    //   34: getfield 125	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_Long	J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifeq +23 -> 62
    //   42: aload_0
    //   43: new 1527	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: getfield 143	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 1528	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 125	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_Long	J
    //   62: aload_0
    //   63: lload_1
    //   64: putfield 125	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_Long	J
    //   67: iload_3
    //   68: newarray byte
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   76: aload 4
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 1534	java/io/InputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 125	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_Long	J
    //   89: iload_3
    //   90: i2l
    //   91: ladd
    //   92: putfield 125	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_Long	J
    //   95: aload 4
    //   97: areturn
    //   98: astore 4
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   105: aload 4
    //   107: invokevirtual 1535	java/io/FileNotFoundException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 4
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   119: aload 4
    //   121: invokevirtual 1535	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: lload_1
    //   127: aload_0
    //   128: getfield 125	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_Long	J
    //   131: lcmp
    //   132: ifle +29 -> 161
    //   135: aload_0
    //   136: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   139: lload_1
    //   140: aload_0
    //   141: getfield 125	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_Long	J
    //   144: lsub
    //   145: invokevirtual 1539	java/io/InputStream:skip	(J)J
    //   148: pop2
    //   149: goto -87 -> 62
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 1219	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: lload_1
    //   162: aload_0
    //   163: getfield 125	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_Long	J
    //   166: lcmp
    //   167: ifge -105 -> 62
    //   170: aload_0
    //   171: new 1527	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: getfield 143	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokespecial 1528	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   182: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   185: aload_0
    //   186: lconst_0
    //   187: putfield 125	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_k_of_type_Long	J
    //   190: aload_0
    //   191: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   194: lload_1
    //   195: invokevirtual 1539	java/io/InputStream:skip	(J)J
    //   198: pop2
    //   199: goto -137 -> 62
    //   202: astore 4
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   209: aload 4
    //   211: invokevirtual 1219	java/io/IOException:printStackTrace	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore 4
    //   218: aconst_null
    //   219: astore 4
    //   221: goto -126 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	FileManagerRSWorker
    //   0	224	1	paramLong	long
    //   0	224	3	paramInt	int
    //   70	26	4	arrayOfByte	byte[]
    //   98	8	4	localFileNotFoundException1	FileNotFoundException
    //   112	8	4	localFileNotFoundException2	FileNotFoundException
    //   152	3	4	localIOException1	java.io.IOException
    //   202	8	4	localIOException2	java.io.IOException
    //   216	1	4	localException	Exception
    //   219	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	98	java/io/FileNotFoundException
    //   42	62	112	java/io/FileNotFoundException
    //   135	149	152	java/io/IOException
    //   170	199	202	java/io/IOException
    //   72	95	216	java/lang/Exception
  }
  
  public void aw_()
  {
    try
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangRunnable = new FileManagerRSWorker.8(this);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Run RSWorker" + MessageCache.a());
      }
      FileManagerUtil.FileExecutor.a().execute(this.jdField_a_of_type_JavaLangRunnable);
      if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 104857600L)) {
        n();
      }
      return;
    }
    finally {}
  }
  
  public int b()
  {
    return this.jdField_k_of_type_Int;
  }
  
  public String b()
  {
    boolean bool2 = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath dir: " + (String)localObject);
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {}
    for (boolean bool1 = ((File)localObject).mkdirs();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getRecvDir[" + bool1 + "]");
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.c();
      localObject = new File(this.jdField_c_of_type_JavaLangString);
      bool1 = bool2;
      if (!((File)localObject).exists()) {
        bool1 = ((File)localObject).mkdirs();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getTmpDir[" + bool1 + "]");
      }
      return this.jdField_c_of_type_JavaLangString;
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Boolean	Z
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_0
    //   10: getfield 1545	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 1545	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   20: bipush 64
    //   22: invokestatic 1566	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   25: pop
    //   26: aload_0
    //   27: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   30: invokevirtual 1567	java/io/InputStream:close	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   38: aload_0
    //   39: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder	Lcom/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder;
    //   42: ifnull +10 -> 52
    //   45: aload_0
    //   46: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder	Lcom/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder;
    //   49: invokevirtual 699	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:a	()V
    //   52: aload_0
    //   53: getfield 655	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   56: ifnull +96 -> 152
    //   59: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +59 -> 121
    //   65: ldc 240
    //   67: iconst_2
    //   68: new 242	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   75: ldc 245
    //   77: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   84: invokestatic 262	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   87: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 1204
    //   93: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 655	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   100: invokevirtual 789	com/tencent/mobileqq/utils/httputils/HttpMsg:getSerial	()I
    //   103: invokestatic 602	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   106: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 264
    //   112: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 270	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_0
    //   122: getfield 187	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   125: ldc_w 637
    //   128: ldc_w 639
    //   131: invokevirtual 643	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   134: checkcast 637	com/tencent/mobileqq/transfile/api/IHttpEngineService
    //   137: invokeinterface 647 1 0
    //   142: checkcast 649	com/tencent/mobileqq/transfile/HttpCommunicator
    //   145: aload_0
    //   146: getfield 655	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   149: invokevirtual 1208	com/tencent/mobileqq/transfile/HttpCommunicator:cancelMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   152: aload_0
    //   153: getfield 123	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask	Lcom/tencent/mobileqq/filemanageraux/core/WeiyunTask;
    //   156: ifnull +53 -> 209
    //   159: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +40 -> 202
    //   165: ldc 240
    //   167: iconst_2
    //   168: new 242	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   175: ldc 245
    //   177: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   184: invokestatic 262	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   187: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 1569
    //   193: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 270	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload_0
    //   203: getfield 123	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask	Lcom/tencent/mobileqq/filemanageraux/core/WeiyunTask;
    //   206: invokevirtual 1570	com/tencent/mobileqq/filemanageraux/core/WeiyunTask:a	()V
    //   209: return
    //   210: astore_1
    //   211: aload_0
    //   212: monitorexit
    //   213: aload_1
    //   214: athrow
    //   215: astore_1
    //   216: goto -178 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	FileManagerRSWorker
    //   210	4	1	localObject	Object
    //   215	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	210	finally
    //   211	213	210	finally
    //   26	38	215	java/lang/Exception
  }
  
  boolean b()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step],send LocalFile");
    if (!NetworkUtil.d(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, "NoNetWork", null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], no network!");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 13, null, 0, null);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_c_of_type_Long, 1002);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], strFilePath is null");
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, FileManagerUtil.a(), null);
      handleError(null, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], Filepath is null!");
      return false;
    }
    Object localObject;
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() != 0))
    {
      this.jdField_m_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_f_of_type_JavaLangString = ((String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = this.jdField_f_of_type_JavaLangString;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step], server Path is not empty, Goto [Upload Step]!");
        this.jdField_e_of_type_Long = 131072L;
        this.jdField_i_of_type_Long = 0L;
        a(this.jdField_f_of_type_JavaLangString, 0L);
        return true;
      }
    }
    this.jdField_a_of_type_ArrayOfByte = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long);
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 2, null, 5, null);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], getMd5 failed");
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "getfile md5 error", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "getfile md5 error", null);
      return true;
    }
    try
    {
      localObject = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      byte[] arrayOfByte = this.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= ^> sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], serverPath is null, so get upload info");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      a(this.jdField_e_of_type_JavaLangString, arrayOfByte, (byte[])localObject, this.jdField_d_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.jdField_c_of_type_Long + "], getFilePath failed");
      a(0);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, FileManagerUtil.a(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_d_of_type_Long <= 0L) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_Long * 100L / this.jdField_d_of_type_Long);
  }
  
  public void c()
  {
    b();
  }
  
  public void d()
  {
    b();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "] is Successed, return!");
      }
    }
    for (;;)
    {
      return;
      if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
        a(1004);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]stop for pause!");
        }
        long l1 = System.currentTimeMillis();
        String str = "Now[" + String.valueOf(l1) + "]startTime[" + String.valueOf(this.jdField_g_of_type_Long) + "]notifyTime[" + String.valueOf(this.jdField_f_of_type_Long) + "]C2CTime[" + String.valueOf(this.jdField_j_of_type_Long) + "]";
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, str, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, str, null);
        return;
        if ((1 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
          a(2004);
        } else if ((5 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask != null)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask.a();
        } else if ((6 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask != null)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask.a();
        } else if ((50 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask != null)) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask.a();
        }
      }
    }
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    label53:
    do
    {
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        localBundle = new Bundle();
        try
        {
          bool = a(paramHttpMsg1);
          if (bool) {
            return;
          }
          n = this.jdField_b_of_type_Int;
          if (n != 0) {
            break label53;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            boolean bool;
            localException.printStackTrace();
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, localException.toString());
            String str = "";
            Object localObject1 = localException.getStackTrace();
            int i1 = localObject1.length;
            int n = 0;
            while (n < i1)
            {
              localObject2 = localObject1[n];
              str = str + localObject2 + "&";
              n += 1;
            }
            localObject1 = "";
            Object localObject2 = "";
            if (paramHttpMsg1 != null) {
              localObject1 = paramHttpMsg1.getRealUrl();
            }
            paramHttpMsg1 = (HttpMsg)localObject2;
            if (paramHttpMsg2 != null) {
              paramHttpMsg1 = paramHttpMsg2.rawRespHeader;
            }
            FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9001L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, (String)localObject1, paramHttpMsg1, this.jdField_j_of_type_Int, str, null, localBundle);
            FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9001L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, (String)localObject1, paramHttpMsg1, this.jdField_j_of_type_Int, str, null, localBundle);
            handleError(null, null);
            continue;
            n = 0;
          }
        }
        return;
      }
      localBundle.putInt("param_V6SelectType", this.jdField_c_of_type_Int);
      localBundle.putInt("param_ipAddrType", d());
      if (!this.jdField_c_of_type_Boolean) {
        break label373;
      }
      n = 1;
      localBundle.putInt("param_ishttps", n);
      bool = a(paramHttpMsg2, localBundle);
    } while (!bool);
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_JavaIoInputStream = null;
      label12:
      a(0);
      return;
    }
    catch (Exception localException)
    {
      break label12;
    }
  }
  
  public void f()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],call receive");
    if (!NetworkUtil.d(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, "NoNetWork", null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.jdField_c_of_type_Long + "],no network!");
      return;
    }
    if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.jdField_c_of_type_Long + "],file exists!!");
      l();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_l_of_type_JavaLangString = null;
    if ((this.jdField_g_of_type_JavaLangString == null) || (this.jdField_g_of_type_JavaLangString.length() == 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],uuid is null! : " + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      g();
      return;
    }
    if (this.jdField_a_of_type_Int == 3000)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],Send getDiscFileInfo CS！");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
        return;
      }
      catch (Exception localException)
      {
        a(null, 0);
        return;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.jdField_c_of_type_Long + "],Send getDownloadInfo CS！");
    boolean bool = false;
    if (((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bool = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, bool, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
  }
  
  public void g()
  {
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>!!!! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "],is oldMsg?");
    if (a())
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "],no network");
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath)) {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath;
    }
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "] get old offlinefile info is error! serverPath is empty");
      if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], filee Exists");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
      int n = 9020;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -1) {
        n = 9080;
      }
      for (;;)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], errCode[" + n + "]");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -2) {
          n = 9081;
        }
      }
    }
    this.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + ".tmp");
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], no network");
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, "NoNetWork", null);
      return;
    }
    this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.jdField_c_of_type_Long + "], id downloaded");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      a(2003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (FileUtils.a(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
      }
      FileManagerUtil.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_g_of_type_Int, null);
      return;
    }
    if (this.jdField_d_of_type_Long > this.jdField_a_of_type_Long)
    {
      long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
      if (SystemUtil.a()) {}
      for (long l1 = SystemUtil.a() * 1024L; l1 < l2; l1 = SystemUtil.b() * 1024L)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod]Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]local sdcard space no enough!! [downsize:" + l2 + "mobile space:" + l1 + "]");
        a(2005);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 12, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "sdcard full", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "sdcard full", null);
        return;
      }
    }
    if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
      label1286:
      if (this.jdField_b_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_c_of_type_Long, 2002);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile) && (this.jdField_f_of_type_JavaLangString.toLowerCase().startsWith("https")))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain;
      }
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v>ReceiveOfflineForOldMsg Id[" + this.jdField_c_of_type_Long + "], mUseHttps:" + this.jdField_c_of_type_Boolean + " mHttpsDomain:" + this.jdField_l_of_type_JavaLangString);
      a(this.jdField_a_of_type_Long, (String)localObject1);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label1286;
    }
  }
  
  protected void h()
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    if (SystemUtil.a()) {}
    for (long l1 = SystemUtil.a() * 1024L; l1 < l2; l1 = SystemUtil.b() * 1024L)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(localFileManagerEntity, null, new FileManagerRSWorker.9(this));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create download task is fail! nSessionId[" + this.jdField_c_of_type_Long + "]fileid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId + "] filename[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "] filesize[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize + "] modifytime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId);
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    String str1 = null;
    if (paramHttpMsg2 != null) {
      str1 = paramHttpMsg2.getErrorString();
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = "null";
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleError....., Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]transferedSize[" + this.jdField_a_of_type_Long + "]isStop[" + String.valueOf(a()) + "],  status[" + String.valueOf(this.jdField_k_of_type_Int) + "], strErrString[" + str2 + "], autoRetry[" + String.valueOf(this.jdField_g_of_type_Int) + "]");
    if (a(paramHttpMsg1, paramHttpMsg2)) {}
    while ((!NetworkUtil.d(BaseApplication.getContext())) && ((a()) || (this.jdField_k_of_type_Int == 1003) || (this.jdField_k_of_type_Int == 2003))) {
      return;
    }
    Bundle localBundle = new Bundle();
    int n;
    int i1;
    if (this.jdField_b_of_type_Int != 0)
    {
      localBundle.putInt("param_V6SelectType", this.jdField_c_of_type_Int);
      localBundle.putInt("param_ipAddrType", d());
      if (this.jdField_c_of_type_Boolean)
      {
        n = 1;
        localBundle.putInt("param_ishttps", n);
      }
    }
    else
    {
      i1 = paramHttpMsg2.errCode;
      if (!FileHttpUtils.a(paramHttpMsg2.errCode)) {
        break label637;
      }
      this.jdField_j_of_type_Int += 1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor == null) {
        break label1113;
      }
    }
    label685:
    label818:
    label1113:
    for (str1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();; str1 = null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]get nextIp[" + str1 + "]errCode[" + i1 + "]");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_j_of_type_Int, paramHttpMsg2.getErrorString() + "&goChangeUrl", null, localBundle);
      label498:
      long l1;
      if ((str1 == null) || (str1.length() == 0))
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "] need chang Ip ,but can not get next ip errCode[" + i1 + "]");
        l1 = this.jdField_g_of_type_Long;
        if (!str2.contains("-29602")) {
          break label685;
        }
        n = -29602;
        paramHttpMsg2.errCode = -29602;
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -29602, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_j_of_type_Int, paramHttpMsg2.getErrorString(), null, localBundle);
      }
      for (;;)
      {
        this.jdField_g_of_type_Int = 0;
        b();
        a(paramHttpMsg2, n);
        return;
        n = 0;
        break;
        a(str1);
        return;
        label637:
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]don't need chang Ip errCode[" + i1 + "]");
        break label498;
        n = i1;
        if (b(paramHttpMsg1, paramHttpMsg2))
        {
          if (!str2.contains("SSLPeerUnverifiedException")) {
            break label818;
          }
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_j_of_type_Int, paramHttpMsg2.getErrorString(), null, localBundle);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          n = i1;
        }
      }
      if (b(str2))
      {
        i1 = 9042;
        if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))
        {
          this.jdField_f_of_type_JavaLangString = "";
          n = i1;
        }
      }
      for (;;)
      {
        if (a(str2))
        {
          n = 9042;
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9042, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_j_of_type_Int, paramHttpMsg2.getErrorString(), null, localBundle);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          break;
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!!!uuid is null!!!!!!!");
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
          n = i1;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)) {
            continue;
          }
          this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          this.jdField_f_of_type_JavaLangString = "";
          n = i1;
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]handleError-----------retryTime:" + this.jdField_g_of_type_Int);
        }
        if (this.jdField_g_of_type_Int < 8)
        {
          a(paramHttpMsg2, localBundle, n, l1);
          return;
        }
        break;
        n = i1;
      }
    }
  }
  
  public void handleRedirect(String paramString)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, new location:" + paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null)
    {
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, but curRequest is null");
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getRealUrl(), this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.rawRespHeader, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getErrorString() + "&UrlOver&handleRedirect", null);
    a(null, 0);
  }
  
  protected void i()
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null, new FileManagerRSWorker.11(this));
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask != null);
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create upload task is fail! nSessionId[" + this.jdField_c_of_type_Long + "] filePath[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
  }
  
  void j()
  {
    this.jdField_l_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = MessageCache.a();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [Http upload]Id[" + this.jdField_c_of_type_Long + "] update successTime[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + "]");
    a(1003);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= ^> [Http upload] SendFileSuccess, SessionId[" + this.jdField_c_of_type_Long + "], FileSize[" + this.jdField_d_of_type_Long + "], Uuid[" + this.jdField_g_of_type_JavaLangString + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 14, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0)) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Http upload] uuid is null Entity[" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "]");
    }
    this.jdField_j_of_type_Long = System.currentTimeMillis();
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if ((5 == paramInt) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Long < this.jdField_d_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "] HttpCommunicator.status = STATUS_END . but data no recv completed. recvData=" + this.jdField_a_of_type_Long + " filesize=" + this.jdField_d_of_type_Long);
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Long, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -9527L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_j_of_type_Int, "statusChanged mtransferedSize[" + String.valueOf(this.jdField_a_of_type_Long) + "]nFileSize[" + String.valueOf(this.jdField_d_of_type_Long) + "]", null);
      l();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker
 * JD-Core Version:    0.7.0.1
 */