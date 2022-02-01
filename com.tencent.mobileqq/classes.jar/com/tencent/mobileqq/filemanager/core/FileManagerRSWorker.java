package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.app.FileUploadInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileHttpUploder;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploader;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class FileManagerRSWorker
  implements IFileHttpBase, IHttpCommunicatorListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IFMSettings jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFMSettings = null;
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new FileManagerRSWorker.5(this);
  private HttpUrlProcessor jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor;
  FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  OfflineFileHttpUploder jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder = null;
  OfflineFileUploader jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileUploader = null;
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
    if (paramFileManagerEntity != null) {
      try
      {
        this.jdField_b_of_type_JavaLangString = paramFileManagerEntity.getFilePath();
        this.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
        this.jdField_g_of_type_JavaLangString = paramFileManagerEntity.Uuid;
        this.jdField_h_of_type_JavaLangString = paramFileManagerEntity.fileIdCrc;
        this.jdField_a_of_type_Boolean = paramFileManagerEntity.bUseMediaPlatform;
        this.jdField_b_of_type_Int = paramFileManagerEntity.nOpType;
        this.jdField_f_of_type_JavaLangString = paramFileManagerEntity.strServerPath;
        this.jdField_e_of_type_JavaLangString = paramFileManagerEntity.peerUin;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFMSettings = FMSettings.a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
        try
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
          this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
          if ((localObject != null) && (((FileManagerEntity)localObject).strSrcName == null))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
            ((FileManagerEntity)localObject).strSrcName = ((FileManagerEntity)localObject).fileName;
          }
          a();
          int n = this.jdField_b_of_type_Int;
          if (n != 0)
          {
            if (n != 1)
            {
              if (n != 5) {
                if (n != 6)
                {
                  if (n == 8) {
                    break label662;
                  }
                  if (n != 50) {
                    break label1003;
                  }
                }
                else
                {
                  if (QLog.isColorLevel())
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("upload insert nSessionId[");
                    ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.nSessionId));
                    ((StringBuilder)localObject).append("] ,fileId[");
                    ((StringBuilder)localObject).append(paramFileManagerEntity.WeiYunFileId);
                    ((StringBuilder)localObject).append("], fileName[");
                    ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
                    ((StringBuilder)localObject).append("], fileSize[");
                    ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.fileSize));
                    ((StringBuilder)localObject).append("], modifyTime[");
                    ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.lastTime));
                    ((StringBuilder)localObject).append("]");
                    QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
                  }
                  this.jdField_j_of_type_JavaLangString = "actFileWyUp";
                  break label1003;
                }
              }
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("download insert, nSessionId[");
                ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.nSessionId));
                ((StringBuilder)localObject).append("] ,fileId[");
                ((StringBuilder)localObject).append(paramFileManagerEntity.WeiYunFileId);
                ((StringBuilder)localObject).append("], fileName[");
                ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
                ((StringBuilder)localObject).append("], fileSize[");
                ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.fileSize));
                ((StringBuilder)localObject).append("], modifyTime[");
                ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.lastTime));
                ((StringBuilder)localObject).append("]");
                QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
              }
              this.jdField_j_of_type_JavaLangString = "actFileWyDown";
              break label1003;
            }
            label662:
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Id[");
              ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
              ((StringBuilder)localObject).append("]getTransferFilePath");
              QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
            }
            this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramFileManagerEntity.fileName);
            a(2);
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
            {
              this.jdField_j_of_type_JavaLangString = "actFileDown";
              this.jdField_k_of_type_JavaLangString = "actFileDownDetail";
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
            {
              this.jdField_j_of_type_JavaLangString = "actFileDiscDownLoad";
              this.jdField_k_of_type_JavaLangString = "actFileDiscDownLoadDetail";
            }
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
            {
              this.jdField_j_of_type_JavaLangString = "actFileUfGenDownload";
              this.jdField_k_of_type_JavaLangString = "actFileUfGenDownloadDetail";
            }
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Id[");
              ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
              ((StringBuilder)localObject).append("]filepath[");
              ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
              ((StringBuilder)localObject).append("]:size[");
              ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.fileSize));
              ((StringBuilder)localObject).append("]");
              QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
            }
            a(2);
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
            {
              this.jdField_j_of_type_JavaLangString = "actFileUp";
              this.jdField_k_of_type_JavaLangString = "actFileUpDetail";
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
            {
              this.jdField_j_of_type_JavaLangString = "actDiscussFileUp";
              this.jdField_k_of_type_JavaLangString = "actDiscussFileUpDetail";
            }
            if ((paramFileManagerEntity.getFilePath() != null) && (paramFileManagerEntity.getFilePath().length() > 0)) {
              this.jdField_a_of_type_JavaIoFile = new File(paramFileManagerEntity.getFilePath());
            }
          }
          label1003:
          this.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
          this.jdField_b_of_type_Long = paramFileManagerEntity.uniseq;
          this.jdField_c_of_type_Long = paramFileManagerEntity.nSessionId;
          paramFileManagerEntity.status = 0;
          paramQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
          paramFileManagerEntity.fProgress = 0.0F;
          paramFileManagerEntity.status = 2;
          if (this.jdField_a_of_type_ComTencentWsttSSCMSSCM == null) {
            this.jdField_a_of_type_ComTencentWsttSSCMSSCM = new SSCM();
          }
          return;
        }
        finally {}
        throw new NullPointerException("entry = null,why?");
      }
      catch (NullPointerException paramQQAppInterface) {}
    }
    paramQQAppInterface.printStackTrace();
  }
  
  private int a(int paramInt, Bundle paramBundle)
  {
    int n = paramInt;
    if (((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4Disc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      n = paramInt;
      if (paramBundle != null)
      {
        String str = paramBundle.getString("strHttpsDomain");
        int i1 = paramBundle.getShort("httpsPort", (short)0);
        n = paramInt;
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_l_of_type_JavaLangString = str;
          if (i1 == 0) {
            return 443;
          }
          n = i1;
        }
      }
    }
    return n;
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
        paramByteStringMicro = new StringBuilder();
        paramByteStringMicro.append(paramString1);
        paramByteStringMicro.append(":");
        paramByteStringMicro.append(paramShort2);
        paramString1 = paramByteStringMicro.toString();
        paramByteStringMicro = paramString1;
        if (((IFMConfig)QRoute.api(IFMConfig.class)).getUserFtnSpeedTest())
        {
          paramByteStringMicro = paramString1;
          if (!this.jdField_c_of_type_Boolean)
          {
            paramByteStringMicro = new StringBuilder();
            paramByteStringMicro.append("113.108.29.146:");
            paramByteStringMicro.append(paramShort1);
            paramByteStringMicro = paramByteStringMicro.toString();
          }
        }
        paramArrayList.add(0, paramByteStringMicro);
        paramString1 = "";
        paramByteStringMicro = localObject2;
        if (paramBundle != null)
        {
          paramString1 = paramBundle.getString("IPv6Dns", "");
          paramByteStringMicro = paramBundle.getStringArrayList("ipv6list");
        }
        a(paramArrayList, paramString1, paramShort2, paramByteStringMicro, paramBoolean);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, paramString2);
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a(true);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a(false);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      }
    }
    return localObject1;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/ftn_handler/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private String a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    String str = paramString4;
    if (paramString1 != null)
    {
      str = paramString4;
      if (paramString2 != null)
      {
        paramString4 = new StringBuilder();
        paramString4.append(paramString1);
        paramString4.append(":");
        paramString4.append(paramInt);
        paramString4 = paramString4.toString();
        paramString1 = a(paramString2);
        paramString2 = new ArrayList(1);
        paramString2.add(paramString4);
        if ((!TextUtils.isEmpty(paramString3)) && (FileIPv6StrateyController.a().isConfigEnableIPV6(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5)))
        {
          paramString4 = new StringBuilder();
          paramString4.append("[IPv6-File] Discfile download. is config enable IPv6. domain[");
          paramString4.append(paramString3);
          paramString4.append("]");
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString4.toString());
          paramString3 = new FileIPv6StrateyController.DomainInfo(paramString3, paramInt);
          paramString3 = FileIPv6StrateyController.a().getIPlistForV6Domain(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, 5);
          if ((paramString3 != null) && (!paramString3.a()))
          {
            if (FileIPv6StrateyController.a())
            {
              QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download.debugIsDisableIPv4OnDoubleStack");
              paramString2.clear();
            }
            FileIPv6StrateyController.a(paramString3.jdField_a_of_type_JavaUtilList, paramString2, false, false);
            paramString3 = new StringBuilder();
            paramString3.append("[IPv6-File] Discfile download. use IPv6. hostlist:");
            paramString3.append(paramString2.toString());
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString3.toString());
          }
          else
          {
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. use IPv4");
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1);
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a(true);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a(false);
        }
        str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      }
    }
    return str;
  }
  
  private short a(short paramShort, Bundle paramBundle)
  {
    short s1 = paramShort;
    if (((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      s1 = paramShort;
      if (paramBundle != null)
      {
        String str = paramBundle.getString("strHttpsDomain");
        short s2 = paramBundle.getShort("httpsPort", (short)0);
        s1 = paramShort;
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_l_of_type_JavaLangString = str;
          if (s2 == 0) {
            return 443;
          }
          s1 = s2;
        }
      }
    }
    return s1;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject).fProgress = (paramFloat1 / paramFloat2);
    ((FileManagerEntity)localObject).status = 2;
    long l1 = System.currentTimeMillis();
    if (l1 - this.jdField_f_of_type_Long >= 1000L)
    {
      this.jdField_f_of_type_Long = l1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Id[");
        ((StringBuilder)localObject).append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId));
        ((StringBuilder)localObject).append("]Notify UI Progress! and send continue!");
        QLog.d("FileManagerRSWorker<FileAssistant>", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void a(long paramLong, FileManagerRSWorker.ChangeNewPath paramChangeNewPath)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().b();
    paramChangeNewPath = new ArrayList();
    paramChangeNewPath.add(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFMSettings.justDoIt(paramLong, paramChangeNewPath, SplashActivity.sTopActivity, new FileManagerRSWorker.13(this));
  }
  
  private void a(long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= v> [Http Recv]id[");
    ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
    ((StringBuilder)localObject).append("] receviveFile, pos[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("] url:");
    ((StringBuilder)localObject).append(this.jdField_f_of_type_JavaLangString);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_b_of_type_Boolean)
    {
      paramString = new StringBuilder();
      paramString.append("=_= v! [Http Recv]id[");
      paramString.append(String.valueOf(this.jdField_c_of_type_Long));
      paramString.append("] is stoped!");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bytes=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("-");
    String str = ((StringBuilder)localObject).toString();
    HttpMsg localHttpMsg = new HttpMsg(this.jdField_f_of_type_JavaLangString, null, this, true);
    localHttpMsg.setInstanceFollowRedirects(false);
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      localObject = "wifi";
    } else {
      localObject = "gprs";
    }
    localHttpMsg.setRequestProperty("Net-type", (String)localObject);
    localHttpMsg.setRequestProperty("cache-control", "no-cache");
    localHttpMsg.setRequestProperty("Range", str);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set cookie:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    if (paramString != null) {
      localHttpMsg.setRequestProperty("Cookie", paramString);
    }
    localHttpMsg.setPriority(1);
    localHttpMsg.setDataSlice(true);
    localHttpMsg.fileType = 0;
    localHttpMsg.busiType = this.jdField_a_of_type_Int;
    localHttpMsg.msgId = String.valueOf(this.jdField_c_of_type_Long);
    paramString = new StringBuilder();
    paramString.append("=_= v> [Http Recv]Id[");
    paramString.append(String.valueOf(this.jdField_c_of_type_Long));
    paramString.append("]recv http data RANGE[");
    paramString.append(String.valueOf(str));
    paramString.append("], peerType[");
    paramString.append(String.valueOf(this.jdField_a_of_type_Int));
    paramString.append("]");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
    localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
    paramString = this.jdField_f_of_type_JavaLangString;
    if (paramString != null) {
      paramString = paramString.toLowerCase();
    } else {
      paramString = "";
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
    if (paramLong == 0L)
    {
      a(2001);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 10, null, 6, null);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    a(2003);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      ((FileManagerEntity)localObject).fileName = FileManagerUtil.c(((FileManagerEntity)localObject).fileName);
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    if (FileUtils.fileExists(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
    }
    FileManagerUtil.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^> [CS Replay]id[");
    ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
    ((StringBuilder)localObject).append("] is exist, and filesize is right!");
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    String str1 = this.jdField_j_of_type_JavaLangString;
    String str2 = this.jdField_f_of_type_JavaLangString;
    FileManagerUtil.a((QQAppInterface)localObject, l1, str1, 0L, str2, this.jdField_e_of_type_JavaLangString, str2, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_j_of_type_Int, null, paramBundle);
  }
  
  private void a(FileUploadInfo paramFileUploadInfo)
  {
    if ((paramFileUploadInfo.jdField_a_of_type_Int == 0) && (!this.jdField_b_of_type_Boolean))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder;
      if (localObject != null) {
        ((OfflineFileHttpUploder)localObject).a();
      }
      c();
      if ((paramFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (paramFileUploadInfo.jdField_a_of_type_ArrayOfByte.length > 0))
      {
        this.jdField_g_of_type_JavaLangString = new String(paramFileUploadInfo.jdField_a_of_type_ArrayOfByte);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
      }
      else
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
      }
      this.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, this.jdField_f_of_type_JavaLangString);
      paramFileUploadInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler();
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      paramFileUploadInfo.a((FileManagerEntity)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, ((FileManagerEntity)localObject).Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
      paramFileUploadInfo = new FileManagerReporter.FileAssistantReportData();
      paramFileUploadInfo.jdField_b_of_type_JavaLangString = "send_file_suc";
      paramFileUploadInfo.jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFileUploadInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
  }
  
  private void a(HttpMsg paramHttpMsg, Bundle paramBundle, int paramInt, long paramLong)
  {
    this.jdField_g_of_type_Int += 1;
    this.jdField_j_of_type_Int += 1;
    if (paramInt == 9056)
    {
      n = this.jdField_h_of_type_Int;
      if (n < 3)
      {
        this.jdField_h_of_type_Int = (n + 1);
        this.jdField_g_of_type_Int -= 1;
      }
      else
      {
        this.jdField_h_of_type_Int = 0;
      }
    }
    if (paramInt == 9042)
    {
      n = this.jdField_i_of_type_Int;
      if (n < 3)
      {
        this.jdField_i_of_type_Int = (n + 1);
        this.jdField_g_of_type_Int -= 1;
      }
      else
      {
        this.jdField_i_of_type_Int = 0;
      }
    }
    int n = 6000;
    if (paramInt == 9056) {
      n = 0;
    }
    ThreadManager.getFileThreadHandler().postDelayed(new FileManagerRSWorker.7(this), n);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nSessionId[");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject).append("] after [");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append("] time retry!");
    QLog.w("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    int i1 = paramInt;
    if (9048 == paramInt) {
      i1 = 11202;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    String str1 = this.jdField_k_of_type_JavaLangString;
    String str2 = this.jdField_m_of_type_JavaLangString;
    String str3 = this.jdField_e_of_type_JavaLangString;
    String str4 = this.jdField_g_of_type_JavaLangString;
    String str5 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    long l2 = i1;
    paramInt = paramHttpMsg.getSerial();
    long l3 = this.jdField_i_of_type_Long;
    long l4 = this.jdField_a_of_type_Long;
    long l5 = this.jdField_d_of_type_Long;
    String str6 = paramHttpMsg.getRealUrl();
    String str7 = paramHttpMsg.rawRespHeader;
    i1 = this.jdField_j_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("delayTimes[");
    localStringBuilder.append(n);
    localStringBuilder.append("]");
    localStringBuilder.append(paramHttpMsg.getErrorString());
    FileManagerUtil.a((QQAppInterface)localObject, l1, str1, paramLong, str2, str3, str4, str5, l2, String.valueOf(paramInt), l3, l4, l5, str6, str7, i1, localStringBuilder.toString(), null, paramBundle);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    this.jdField_i_of_type_Long += paramInt;
    Object localObject = a(paramLong, paramInt);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("=_= ^! [Upload Step] Id[");
      paramString.append(this.jdField_c_of_type_Long);
      paramString.append("]sendFilePakage transferData null");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "get Stream null", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, "get Stream null", null);
      handleError(null, null);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&bmd5=");
    localStringBuilder.append(MD5.toMD5((byte[])localObject));
    localStringBuilder.append("&range=");
    localStringBuilder.append(String.valueOf(paramLong));
    localObject = new HttpMsg(localStringBuilder.toString(), (byte[])localObject, this);
    ((HttpMsg)localObject).setInstanceFollowRedirects(false);
    ((HttpMsg)localObject).setRequestProperty("cache-control", "no-cache");
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    } else {
      paramString = "gprs";
    }
    ((HttpMsg)localObject).setRequestProperty("Net-type", paramString);
    paramString = new StringBuilder();
    paramString.append("bytes=");
    paramString.append(paramLong);
    paramString.append("-");
    ((HttpMsg)localObject).setRequestProperty("Range", paramString.toString());
    ((HttpMsg)localObject).setRequestMethod("POST");
    ((HttpMsg)localObject).setPriority(1);
    ((HttpMsg)localObject).fileType = 0;
    ((HttpMsg)localObject).busiType = this.jdField_a_of_type_Int;
    ((HttpMsg)localObject).msgId = String.valueOf(this.jdField_c_of_type_Long);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("Id[");
      paramString.append(this.jdField_c_of_type_Long);
      paramString.append("]send http data size[");
      paramString.append(paramInt);
      paramString.append("], peerType[");
      paramString.append(this.jdField_a_of_type_Int);
      paramString.append("]");
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
    }
    ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).sendMsg((HttpMsg)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = ((HttpMsg)localObject);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("发送一个数据包,nSessionID[");
      paramString.append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId));
      paramString.append("]");
      QLog.e("##########", 2, paramString.toString());
    }
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
      paramArrayOfByte1 = this.jdField_b_of_type_ArrayOfByte;
      if (paramArrayOfByte1 == null)
      {
        a(null, 0);
        return;
      }
      paramString.e = paramArrayOfByte1;
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("=_= ^> [CS Step], SessionId[");
      paramArrayOfByte1.append(this.jdField_c_of_type_Long);
      paramArrayOfByte1.append("], filesize < 100 get sha1");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramArrayOfByte1.toString());
    }
    else
    {
      paramString.jdField_a_of_type_Int = 1600;
      this.jdField_c_of_type_ArrayOfByte = FileManagerUtil.c(new String(paramArrayOfByte1));
      paramFileManagerEntity.strFileSha3 = HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte);
      paramFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      paramArrayOfByte1 = this.jdField_c_of_type_ArrayOfByte;
      if (paramArrayOfByte1 == null)
      {
        a(null, 0);
        return;
      }
      paramString.f = paramArrayOfByte1;
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("=_= ^> [CS Step], SessionId[");
      paramArrayOfByte1.append(this.jdField_c_of_type_Long);
      paramArrayOfByte1.append("], filesize > 100 get sha3");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramArrayOfByte1.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, paramFileManagerEntity);
  }
  
  private void a(List<String> paramList1, String paramString, int paramInt, List<String> paramList2, boolean paramBoolean)
  {
    if ((paramList1 != null) && (FileIPv6StrateyController.a().isConfigEnableIPV6(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)))
    {
      if ((paramBoolean) && (paramList2 != null) && (paramList2.size() > 0))
      {
        paramString = new StringBuilder();
        paramString.append("[IPv6-File] mediaplatform offlinefile download. is config enable IPv6. v6ipsize[");
        paramString.append(paramList2.size());
        paramString.append("]");
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
        paramString = FileIPv6StrateyController.a().getIPV6listForMediaPlatfrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramList2);
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
            if (!TextUtils.isEmpty(paramList2))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append(paramList2);
              localStringBuilder.append("]:");
              localStringBuilder.append(paramInt);
              paramList1.add(0, localStringBuilder.toString());
            }
            n -= 1;
          }
          this.jdField_c_of_type_Int = 2;
          paramString = new StringBuilder();
          paramString.append("[IPv6-File] mediaplatform offlinefile download use IPv6. iplist:");
          paramString.append(paramList1.toString());
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
          return;
        }
        this.jdField_c_of_type_Int = 1;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download use IPv4");
        return;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        paramList2 = new StringBuilder();
        paramList2.append("[IPv6-File] offlinefile download. is config enable IPv6. domain[");
        paramList2.append(paramString);
        paramList2.append("]");
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramList2.toString());
        paramString = new FileIPv6StrateyController.DomainInfo(paramString, paramInt);
        paramString = FileIPv6StrateyController.a().getIPlistForV6Domain(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
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
          paramString = new StringBuilder();
          paramString.append("[IPv6-File] offlinefile download. use IPv6. iplist:");
          paramString.append(paramList1.toString());
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
          return;
        }
        this.jdField_c_of_type_Int = 1;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. use IPv4");
        return;
      }
      this.jdField_c_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_Int = 1;
  }
  
  private void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    if (a())
    {
      paramString1 = new StringBuilder();
      paramString1.append("=_= v! [Disc Download Replay] id[");
      paramString1.append(this.jdField_c_of_type_Long);
      paramString1.append("]OnDiscDownloadInfo, network error");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString1.toString());
      return;
    }
    if (a(paramBoolean, paramLong1, paramString1, paramInt2, "=_= v! [Disc Download Replay]id[", "ret error")) {
      return;
    }
    int n = a(paramInt1, paramBundle);
    if (paramBundle != null) {
      localObject = paramBundle.getString("IPv6Dns", "");
    } else {
      localObject = "";
    }
    Object localObject = a(paramString3, paramString4, n, (String)localObject, null);
    if (a(paramLong1, paramString1, paramInt2, (String)localObject)) {
      return;
    }
    this.jdField_f_of_type_JavaLangString = ((String)localObject);
    this.jdField_m_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= v [Disc Download Replay]nSessionID[");
    ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
    ((StringBuilder)localObject).append("],retCode[");
    ((StringBuilder)localObject).append(String.valueOf(paramLong1));
    ((StringBuilder)localObject).append("]downLoadUrl[");
    ((StringBuilder)localObject).append(String.valueOf(this.jdField_f_of_type_JavaLangString));
    ((StringBuilder)localObject).append("] mUseHttps:");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
    ((StringBuilder)localObject).append(" mHttpsDomain:");
    ((StringBuilder)localObject).append(this.jdField_l_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" downloadPort:");
    ((StringBuilder)localObject).append(n);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
      ((StringBuilder)localObject).append("] will show taost, retCode[");
      ((StringBuilder)localObject).append(String.valueOf(paramLong1));
      ((StringBuilder)localObject).append("], retMsg:");
      ((StringBuilder)localObject).append(paramString1);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("nSeseeId[");
        ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
        ((StringBuilder)localObject).append("]renamed[");
        ((StringBuilder)localObject).append(String.valueOf(paramString2));
        ((StringBuilder)localObject).append("]");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramString2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 1) {
      this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append("dsc-");
    ((StringBuilder)localObject).append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.replace("/", "")));
    this.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      paramString1 = new StringBuilder();
      paramString1.append("nSessionId[");
      paramString1.append(String.valueOf(this.jdField_c_of_type_Long));
      paramString1.append("], NetWork Error, notify UI!");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, paramString1.toString());
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramLong2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      paramString2 = this.jdField_j_of_type_JavaLangString;
      l1 = this.jdField_g_of_type_Long;
      paramString3 = this.jdField_m_of_type_JavaLangString;
      paramString4 = this.jdField_e_of_type_JavaLangString;
      paramString5 = this.jdField_g_of_type_JavaLangString;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(String.valueOf(paramLong1));
      FileManagerUtil.a(paramString1, paramLong2, paramString2, l1, paramString3, paramString4, paramString5, paramBundle, 2L, ((StringBuilder)localObject).toString(), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "net", null);
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramLong2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      paramString2 = this.jdField_k_of_type_JavaLangString;
      l1 = this.jdField_g_of_type_Long;
      paramString3 = this.jdField_m_of_type_JavaLangString;
      paramString4 = this.jdField_e_of_type_JavaLangString;
      paramString5 = this.jdField_g_of_type_JavaLangString;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(String.valueOf(paramLong1));
      FileManagerUtil.a(paramString1, paramLong2, paramString2, l1, paramString3, paramString4, paramString5, paramBundle, 2L, ((StringBuilder)localObject).toString(), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "net", null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_c_of_type_Long, this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sessionId[");
      ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
      ((StringBuilder)localObject).append("], strTmp[");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
    long l1 = this.jdField_a_of_type_Long;
    long l2 = this.jdField_d_of_type_Long;
    if (l1 == l2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      a(2003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        paramString1.fileName = FileManagerUtil.c(paramString1.fileName);
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (FileUtils.fileExists(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
      }
      FileManagerUtil.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
      paramString1 = new StringBuilder();
      paramString1.append("nSessionId[");
      paramString1.append(String.valueOf(this.jdField_c_of_type_Long));
      paramString1.append("], fileExisted, notify UI!");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString1.toString());
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramLong1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      paramString2 = this.jdField_j_of_type_JavaLangString;
      paramString3 = this.jdField_f_of_type_JavaLangString;
      FileManagerUtil.a(paramString1, paramLong1, paramString2, 0L, paramString3, this.jdField_e_of_type_JavaLangString, paramString3, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_j_of_type_Int, null);
      return;
    }
    if (l2 > l1)
    {
      l1 = l2 - l1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFMSettings.getDefalutStorgeFreeSpace() < l1)
      {
        a(l1, new FileManagerRSWorker.3(this, paramBoolean, paramLong1, paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramLong2, paramBundle));
        return;
      }
    }
    QQFileManagerUtil.FileExecutor.a().execute(new FileManagerRSWorker.4(this, paramString5));
  }
  
  private void a(boolean paramBoolean, FileUploadInfo paramFileUploadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("=_= v! [SetFileDownloadStatus Replay] id[");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("]onDownloadFileSuc");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
    if ((paramBoolean) && ((paramFileUploadInfo.jdField_c_of_type_Int == 2) || (paramFileUploadInfo.jdField_c_of_type_Int == 0)) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("],retCode[");
      localStringBuilder.append(paramFileUploadInfo.jdField_a_of_type_Int);
      localStringBuilder.append("],retMsg[");
      localStringBuilder.append(paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("],retStat[");
      localStringBuilder.append(paramFileUploadInfo.jdField_c_of_type_Int);
      localStringBuilder.append("]. need to send file receipt");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("],retCode[");
    localStringBuilder.append(paramFileUploadInfo.jdField_a_of_type_Int);
    localStringBuilder.append("],retMsg[");
    localStringBuilder.append(paramFileUploadInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("],retStat[");
    localStringBuilder.append(paramFileUploadInfo.jdField_c_of_type_Int);
    localStringBuilder.append("]. don't need to send file receipt");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  private boolean a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null)
    {
      paramString2 = new StringBuilder();
      paramString2.append("=_= v! [Disc Download Replay]id[");
      paramString2.append(String.valueOf(this.jdField_c_of_type_Long));
      paramString2.append("] get DiscdownLoad info Url is null");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString2.toString());
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      long l1 = paramLong;
      if (paramLong == 0L) {
        l1 = 9048L;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "ip url error", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "ip url error", null);
      return true;
    }
    return false;
  }
  
  private boolean a(long paramLong, String paramString1, int paramInt, String paramString2, Bundle paramBundle)
  {
    if (paramString2 == null)
    {
      paramString2 = new StringBuilder();
      paramString2.append("=_= ^! [CS Replay]id[");
      paramString2.append(String.valueOf(this.jdField_c_of_type_Long));
      paramString2.append("] get offlinefile info Url is null, IP is null too");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString2.toString());
      a(2005);
      if ((paramLong == -6101L) || (paramLong == -7003L)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      long l1 = paramLong;
      if (paramLong == 0L) {
        l1 = 9048L;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "ip url error", null, paramBundle);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l1, String.valueOf(paramInt), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "ip url error", null, paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return true;
    }
    return false;
  }
  
  private boolean a(HttpMsg paramHttpMsg)
  {
    if (a())
    {
      if (QLog.isColorLevel())
      {
        paramHttpMsg = new StringBuilder();
        paramHttpMsg.append("nSessionID[");
        paramHttpMsg.append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId));
        paramHttpMsg.append("]已经结束,返回");
        QLog.e("##########", 2, paramHttpMsg.toString());
      }
      return true;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
    if (paramHttpMsg != localObject)
    {
      if ((paramHttpMsg != null) && (localObject != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("id[");
        ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
        ((StringBuilder)localObject).append("],Req Serial[");
        ((StringBuilder)localObject).append(String.valueOf(paramHttpMsg.getSerial()));
        ((StringBuilder)localObject).append("], curRequest Serial[");
        ((StringBuilder)localObject).append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()));
        ((StringBuilder)localObject).append("]");
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        return true;
      }
      if (paramHttpMsg != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("id[");
        ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
        ((StringBuilder)localObject).append("],Req Serial[");
        ((StringBuilder)localObject).append(String.valueOf(paramHttpMsg.getSerial()));
        ((StringBuilder)localObject).append("]");
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
      {
        paramHttpMsg = new StringBuilder();
        paramHttpMsg.append("id[");
        paramHttpMsg.append(String.valueOf(this.jdField_c_of_type_Long));
        paramHttpMsg.append("],curRequest Serial[");
        paramHttpMsg.append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()));
        paramHttpMsg.append("]");
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, paramHttpMsg.toString());
      }
      return true;
    }
    return false;
  }
  
  private boolean a(HttpMsg paramHttpMsg, Bundle paramBundle)
  {
    if ((paramHttpMsg.getResponseCode() == 206) || (paramHttpMsg.getResponseCode() == 200)) {}
    try
    {
      this.jdField_a_of_type_JavaIoOutputStream.write(paramHttpMsg.getRecvData());
      this.jdField_g_of_type_Int = 0;
      long l1 = paramHttpMsg.getRecvData().length;
      this.jdField_i_of_type_Long += l1;
      this.jdField_a_of_type_Long += l1;
      l1 = this.jdField_d_of_type_Long;
      l1 = paramHttpMsg.getTotalLen();
      long l2 = this.jdField_a_of_type_Long;
      if (l2 >= l1)
      {
        if ((this.jdField_a_of_type_Int != 3000) && (!QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend))
        {
          paramHttpMsg = new StringBuilder();
          paramHttpMsg.append("=_= v> [Set FileStatus]Id[");
          paramHttpMsg.append(this.jdField_c_of_type_Long);
          paramHttpMsg.append("] set Download Success");
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramHttpMsg.toString());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
        try
        {
          this.jdField_a_of_type_JavaIoOutputStream.close();
        }
        catch (IOException paramHttpMsg)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("Id[");
          paramBundle.append(String.valueOf(this.jdField_c_of_type_Long));
          paramBundle.append("]exception io FileMsg, ");
          paramBundle.append(paramHttpMsg.toString());
          QLog.i("8pic", 1, paramBundle.toString());
          paramHttpMsg.printStackTrace();
        }
        this.jdField_a_of_type_JavaIoOutputStream = null;
        l();
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)l2 / (float)this.jdField_d_of_type_Long);
      a(2002);
      l1 = System.currentTimeMillis();
      if (l1 - this.jdField_f_of_type_Long < 1000L) {
        return true;
      }
      this.jdField_f_of_type_Long = l1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 16, null, 0, null);
      return false;
    }
    catch (Exception paramHttpMsg)
    {
      if (!paramHttpMsg.getMessage().contains("ENOSPC")) {
        break label712;
      }
    }
    label553:
    try
    {
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("=_= v! Id[");
        localStringBuilder.append(String.valueOf(this.jdField_c_of_type_Long));
        localStringBuilder.append("]stop serial[");
        localStringBuilder.append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()));
        localStringBuilder.append("]:");
        localStringBuilder.append(paramHttpMsg.getMessage());
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, localStringBuilder.toString());
        ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).cancelMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(false);
    }
    finally {}
    try
    {
      a(this.jdField_d_of_type_Long, new FileManagerRSWorker.6(this));
    }
    catch (Exception paramHttpMsg)
    {
      break label553;
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "write stream error", null, paramBundle);
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "write stream error", null, paramBundle);
    handleError(null, null);
    return true;
    label712:
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "write stream error", null, paramBundle);
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "write stream error", null, paramBundle);
    handleError(null, null);
    return true;
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (!a())
    {
      int n = this.jdField_k_of_type_Int;
      if (n != 1003)
      {
        if (n == 2003) {
          return true;
        }
        if ((paramHttpMsg1 == null) && (paramHttpMsg2 == null))
        {
          c();
          a(null, 0);
          return true;
        }
        return false;
      }
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    return (paramString.contains("-6101")) || (paramString.contains("-7003")) || (paramString.contains("-403")) || (paramString.contains("-9006")) || (paramString.contains("-9004")) || (paramString.contains("-9017")) || (paramString.contains("-28137"));
  }
  
  private boolean a(boolean paramBoolean, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (!paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
      ((StringBuilder)localObject).append("] get offlinefile info is error!retCode[");
      ((StringBuilder)localObject).append(String.valueOf(paramLong));
      ((StringBuilder)localObject).append("], retMsg:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      long l1;
      if (paramLong == -100001L) {
        l1 = 9043L;
      } else {
        l1 = 9045L;
      }
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      long l2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      paramString2 = this.jdField_j_of_type_JavaLangString;
      long l3 = this.jdField_g_of_type_Long;
      localObject = this.jdField_m_of_type_JavaLangString;
      String str1 = this.jdField_e_of_type_JavaLangString;
      String str2 = this.jdField_g_of_type_JavaLangString;
      String str3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramInt));
      localStringBuilder.append("&");
      localStringBuilder.append(String.valueOf(paramLong));
      FileManagerUtil.a(paramString1, l2, paramString2, l3, (String)localObject, str1, str2, str3, l1, localStringBuilder.toString(), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, paramString3, null);
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      paramString2 = this.jdField_k_of_type_JavaLangString;
      l3 = this.jdField_g_of_type_Long;
      localObject = this.jdField_m_of_type_JavaLangString;
      str1 = this.jdField_e_of_type_JavaLangString;
      str2 = this.jdField_g_of_type_JavaLangString;
      str3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramInt));
      localStringBuilder.append("&");
      localStringBuilder.append(String.valueOf(paramLong));
      FileManagerUtil.a(paramString1, l2, paramString2, l3, (String)localObject, str1, str2, str3, l1, localStringBuilder.toString(), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, paramString3, null);
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle, ArrayList<String> paramArrayList)
  {
    long l1 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFMSettings.getDefalutStorgeFreeSpace() < l1)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^> [CS Replay]id[");
      ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
      ((StringBuilder)localObject).append("] not enought space! ProcessNewPath");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      localObject = new ArrayList();
      ((List)localObject).addAll(paramArrayList);
      a(l1, new FileManagerRSWorker.2(this, paramBoolean1, paramLong1, paramString1, paramString2, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramString4, (List)localObject, paramInt, paramString5, paramString6, paramString7, paramLong2, paramBundle));
      return true;
    }
    return false;
  }
  
  private boolean b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {
      return false;
    }
    if (paramHttpMsg2 == null) {
      return true;
    }
    return NetworkUtil.isNetSupport(BaseApplication.getContext());
  }
  
  private boolean b(String paramString)
  {
    return (paramString.contains("-29120")) || (paramString.contains("-502")) || (paramString.contains("HTTP_PROXY_AUTH")) || (paramString.contains("-29150")) || (paramString.contains("-21122")) || (paramString.contains("-28123")) || (paramString.contains("-25081")) || (paramString.contains("-28126"));
  }
  
  /* Error */
  private static String c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: lconst_1
    //   4: invokestatic 1241	java/lang/Thread:sleep	(J)V
    //   7: goto +12 -> 19
    //   10: astore_2
    //   11: goto +42 -> 53
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 1242	java/lang/InterruptedException:printStackTrace	()V
    //   19: invokestatic 480	java/lang/System:currentTimeMillis	()J
    //   22: lstore_0
    //   23: new 1244	java/text/SimpleDateFormat
    //   26: dup
    //   27: ldc_w 1246
    //   30: getstatic 1252	java/util/Locale:US	Ljava/util/Locale;
    //   33: invokespecial 1255	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   36: new 1257	java/util/Date
    //   39: dup
    //   40: lload_0
    //   41: invokespecial 1259	java/util/Date:<init>	(J)V
    //   44: invokevirtual 1263	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   47: astore_2
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_2
    //   52: areturn
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	19	0	l1	long
    //   10	1	2	localObject	Object
    //   14	2	2	localInterruptedException	java.lang.InterruptedException
    //   47	10	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	7	10	finally
    //   15	19	10	finally
    //   19	48	10	finally
    //   3	7	14	java/lang/InterruptedException
  }
  
  private int d()
  {
    return QFileUtils.c(this.jdField_f_of_type_JavaLangString);
  }
  
  private void k()
  {
    QQFileManagerUtil.FileExecutor.a().execute(new FileManagerRSWorker.1(this));
  }
  
  private void l()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void m()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      ((FileManagerEntity)localObject1).status = 0;
      ((FileManagerEntity)localObject1).isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    long l1;
    if (SystemUtil.a()) {
      l1 = SystemUtil.a();
    } else {
      l1 = SystemUtil.b();
    }
    l1 *= 1024L;
    if (l1 < l2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Id[");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject1).append("]downLoadWeiYunFile local space no enough!! [downsize:");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append("sdcardsize:");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      ((FileManagerEntity)localObject1).status = 0;
      ((FileManagerEntity)localObject1).isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      localObject2 = this.jdField_j_of_type_JavaLangString;
      l2 = this.jdField_g_of_type_Long;
      long l3 = this.jdField_a_of_type_Long;
      FileManagerUtil.a((QQAppInterface)localObject1, l1, (String)localObject2, l2, "", "", "", "", 9040L, "", l3, l3, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_d_of_type_Long = ((FileManagerEntity)localObject1).fileSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a((FileManagerEntity)localObject1, null, new FileManagerRSWorker.10(this, (FileManagerEntity)localObject1));
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask;
    if (localObject2 != null) {
      ((WeiyunTask)localObject2).a(((FileManagerEntity)localObject1).WeiYunFileId);
    }
  }
  
  private void n()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start Rsworker OfflineFileHitReq:");
      localStringBuilder.append(MessageCache.a());
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
    }
    QQFileManagerUtil.FileExecutor.a().execute(new FileManagerRSWorker.12(this));
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFMSettings.getDefaultRecvPath();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Id[");
    ((StringBuilder)localObject2).append(String.valueOf(this.jdField_c_of_type_Long));
    ((StringBuilder)localObject2).append("]getTransferFilePath dir: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool2 = true;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, (String)localObject2);
    localObject1 = new File((String)localObject1);
    if (!((File)localObject1).exists()) {
      bool1 = ((File)localObject1).mkdirs();
    } else {
      bool1 = true;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("id[");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject1).append("]getRecvDir[");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFMSettings.getDefaultTmpPath();
    localObject1 = new File(this.jdField_c_of_type_JavaLangString);
    boolean bool1 = bool2;
    if (!((File)localObject1).exists()) {
      bool1 = ((File)localObject1).mkdirs();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("id[");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject1).append("]getTmpDir[");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFMSettings.getDefaultRecvPath();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = c();
    }
    paramString2 = new StringBuilder();
    paramString2.append(str);
    paramString2.append(paramString1);
    paramString1 = new File(paramString2.toString());
    paramString2 = new StringBuilder();
    paramString2.append("Id[");
    paramString2.append(String.valueOf(this.jdField_c_of_type_Long));
    paramString2.append("]getTransferFilePath : ");
    paramString2.append(paramString1.getAbsoluteFile().toString());
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString2.toString());
    return paramString1.getAbsoluteFile().toString();
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= v> [CS Send] Id[");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject).append("],call receive");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, "NoNetWork", null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= v>! [CS Send] Id[");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject).append("],no network!");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= v>! [CS Send] Id[");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject).append("],file exists!!");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      l();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_l_of_type_JavaLangString = null;
    localObject = this.jdField_g_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).length() != 0)) {
      if (this.jdField_a_of_type_Int == 3000)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("=_= v> [CS Send] Id[");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject).append("],Send getDiscFileInfo CS！");
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
      return;
    }
    catch (Exception localException)
    {
      label448:
      boolean bool;
      break label448;
    }
    a(null, 0);
    return;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= v> [CS Send] Id[");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject).append("],Send getDownloadInfo CS！");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    bool = ((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, bool, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
    return;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= v> [CS Send] Id[");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject).append("],uuid is null! : ");
    ((StringBuilder)localObject).append(FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    b();
  }
  
  public void a(int paramInt)
  {
    paramInt = FileManagerUtil.b(paramInt);
    if ((this.jdField_k_of_type_Int == paramInt) && (paramInt == 2)) {
      return;
    }
    this.jdField_k_of_type_Int = paramInt;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.status = paramInt;
    localFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
    if (paramInt != 2)
    {
      localFileManagerEntity.peerUin = this.jdField_e_of_type_JavaLangString;
      localFileManagerEntity.peerType = this.jdField_a_of_type_Int;
      localFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
      String str = this.jdField_g_of_type_JavaLangString;
      if (str == null) {
        str = localFileManagerEntity.Uuid;
      }
      localFileManagerEntity.Uuid = str;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    HttpMsg localHttpMsg = (HttpMsg)paramObject;
    int i1 = this.jdField_b_of_type_Int;
    int n = 16;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 5) {
          if (i1 != 6)
          {
            if (i1 != 8)
            {
              if (i1 != 50) {
                QLog.e("FileManagerRSWorker<FileAssistant>", 1, "why actionType is out?!");
              }
            }
            else
            {
              paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
              paramObject.isReaded = false;
              paramObject.fProgress = ((float)this.jdField_a_of_type_Long / (float)paramObject.fileSize);
              paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
              if (paramObject.status != 16) {
                n = 0;
              }
              paramObject.status = n;
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
              break label601;
            }
          }
          else
          {
            paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
            if (paramObject.status != 16) {
              n = 0;
            }
            paramObject.status = n;
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
            break label601;
          }
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        if (paramObject.status != 16) {
          n = 0;
        }
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
        paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        paramObject.isReaded = false;
        if (paramObject.status != 16) {
          n = 0;
        }
        paramObject.status = n;
        paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        paramObject.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        paramObject.uniseq = this.jdField_b_of_type_Long;
        paramObject.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      paramObject.isReaded = false;
      if (paramObject.status != 16) {
        n = 0;
      }
      paramObject.status = n;
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      paramObject.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
      paramObject.uniseq = this.jdField_b_of_type_Long;
      paramObject.Uuid = this.jdField_g_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
    }
    label601:
    if (localHttpMsg == null) {
      return;
    }
    paramObject = localHttpMsg.getErrorString();
    if ((paramInt == 0) && (paramObject == null))
    {
      paramObject = new StringBuilder();
      paramObject.append("[Http_RespValue_Null]");
      paramObject.append(FileManagerUtil.a());
      paramObject = paramObject.toString();
      paramInt = 9001;
    }
    Object localObject = paramObject;
    if (paramObject == null)
    {
      paramObject = new StringBuilder();
      paramObject.append("errMsgString_NUll_retCode[");
      paramObject.append(paramInt);
      paramObject.append("]");
      localObject = paramObject.toString();
    }
    if (((String)localObject).indexOf("-6101") > 0) {
      paramInt = 9042;
    }
    if (((String)localObject).contains("HTTP_PROXY_AUTH")) {
      paramInt = 9004;
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, String.valueOf(localHttpMsg.getSerial()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, localHttpMsg.getRealUrl(), localHttpMsg.rawRespHeader, this.jdField_j_of_type_Int, (String)localObject, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  void a(String paramString)
  {
    int n;
    if (this.jdField_b_of_type_Int == 0) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0)
    {
      this.jdField_f_of_type_JavaLangString = paramString;
      paramString = this.jdField_f_of_type_JavaLangString;
      this.jdField_m_of_type_JavaLangString = paramString;
      this.jdField_f_of_type_Int += 1;
      a(paramString, 0L);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendFilePakage transferedSize[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], packetSize[");
    localStringBuilder.append(n);
    localStringBuilder.append("]");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
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
  
  byte[] a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_JavaIoInputStream == null) {
      try
      {
        this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_b_of_type_JavaLangString);
        this.jdField_k_of_type_Long = 0L;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        this.jdField_a_of_type_JavaIoInputStream = null;
        localFileNotFoundException1.printStackTrace();
        return null;
      }
    }
    if (paramLong == 0L)
    {
      if (this.jdField_k_of_type_Long != 0L) {
        try
        {
          this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_b_of_type_JavaLangString);
          this.jdField_k_of_type_Long = 0L;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          this.jdField_a_of_type_JavaIoInputStream = null;
          localFileNotFoundException2.printStackTrace();
          return null;
        }
      }
    }
    else
    {
      long l1 = this.jdField_k_of_type_Long;
      if (paramLong > l1) {
        try
        {
          this.jdField_a_of_type_JavaIoInputStream.skip(paramLong - l1);
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          return null;
        }
      } else if (paramLong < l1) {
        try
        {
          this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_b_of_type_JavaLangString);
          this.jdField_k_of_type_Long = 0L;
          this.jdField_a_of_type_JavaIoInputStream.skip(paramLong);
        }
        catch (IOException localIOException2)
        {
          this.jdField_a_of_type_JavaIoInputStream = null;
          localIOException2.printStackTrace();
          return null;
        }
      }
    }
    this.jdField_k_of_type_Long = paramLong;
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.read(arrayOfByte, 0, paramInt);
      this.jdField_k_of_type_Long += paramInt;
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      label222:
      break label222;
    }
    return null;
  }
  
  public int b()
  {
    return this.jdField_k_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  public void b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("=_= v>!!!! [Http Downlaod] Id[");
    ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject1).append("],is oldMsg?");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = Boolean.valueOf(true);
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, (String)localObject2);
    if (a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("=_= v>! [Http Downlaod] Id[");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject1).append("],no network");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath)) {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath;
    }
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id[");
      ((StringBuilder)localObject2).append(String.valueOf(this.jdField_c_of_type_Long));
      ((StringBuilder)localObject2).append("] get old offlinefile info is error! serverPath is empty");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      if (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), localObject1, this.jdField_f_of_type_JavaLangString }, 0, null);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("=_= v> [Http Downlaod] Id[");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject1).append("], filee Exists");
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
      int n = 9020;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -1) {
        n = 9080;
      } else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -2) {
        n = 9081;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("=_= v! [Http Downlaod] Id[");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject1).append("], errCode[");
      ((StringBuilder)localObject1).append(n);
      ((StringBuilder)localObject1).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(".tmp");
    this.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("=_= v! [Http Downlaod] Id[");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject1).append("], no network");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, "NoNetWork", null);
      return;
    }
    this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
    long l1 = this.jdField_a_of_type_Long;
    long l2 = this.jdField_d_of_type_Long;
    if (l1 == l2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("=_= v! [Http Downlaod] Id[");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject2).append("], id downloaded");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      a(2003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), localObject1, this.jdField_f_of_type_JavaLangString }, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        ((FileManagerEntity)localObject1).fileName = FileManagerUtil.c(((FileManagerEntity)localObject1).fileName);
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (FileUtils.fileExists(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
      }
      FileManagerUtil.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_g_of_type_Int, null);
      return;
    }
    if (l2 > l1)
    {
      l2 -= l1;
      if (SystemUtil.a()) {
        l1 = SystemUtil.a();
      } else {
        l1 = SystemUtil.b();
      }
      l1 *= 1024L;
      if (l1 < l2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("=_= v! [Http Downlaod]Id[");
        ((StringBuilder)localObject1).append(String.valueOf(this.jdField_c_of_type_Long));
        ((StringBuilder)localObject1).append("]local sdcard space no enough!! [downsize:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("mobile space:");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append("]");
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
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
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      label1421:
      FileManagerEntity localFileManagerEntity;
      break label1421;
    }
    if (this.jdField_b_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_c_of_type_Long, 2002);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.status = 2;
    localObject2 = null;
    localObject1 = localObject2;
    if (localFileManagerEntity.isZipInnerFile)
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
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("=_= v>ReceiveOfflineForOldMsg Id[");
    ((StringBuilder)localObject2).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject2).append("], mUseHttps:");
    ((StringBuilder)localObject2).append(this.jdField_c_of_type_Boolean);
    ((StringBuilder)localObject2).append(" mHttpsDomain:");
    ((StringBuilder)localObject2).append(this.jdField_l_of_type_JavaLangString);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    a(this.jdField_a_of_type_Long, (String)localObject1);
  }
  
  boolean b()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step],send LocalFile");
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject1).status = 2;
    ((FileManagerEntity)localObject1).fProgress = 0.0F;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendLocalFile, SessionId[");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject1).append("], strFilePath is null");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, FileManagerUtil.a(), null);
      handleError(null, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], Filepath is null!");
      return false;
    }
    localObject1 = this.jdField_f_of_type_JavaLangString;
    if ((localObject1 != null) && (((String)localObject1).length() != 0))
    {
      localObject1 = this.jdField_f_of_type_JavaLangString;
      this.jdField_m_of_type_JavaLangString = ((String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.jdField_f_of_type_JavaLangString = ((String)localObject1);
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
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("=_= ^! [CS Step], SessionId[");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject1).append("], getMd5 failed");
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "getfile md5 error", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, "getfile md5 error", null);
      return true;
    }
    try
    {
      localObject1 = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      byte[] arrayOfByte = this.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("=_= ^> sendLocalFile, SessionId[");
        ((StringBuilder)localObject2).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject2).append("], serverPath is null, so get upload info");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        ((FileManagerEntity)localObject2).tmpSessionSig = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject2).peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      a(this.jdField_e_of_type_JavaLangString, arrayOfByte, (byte[])localObject1, this.jdField_d_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("=_= ^! [CS Step], SessionId[");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append("], getFilePath failed");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
      a(0);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_j_of_type_Int, FileManagerUtil.a(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
    }
    return false;
  }
  
  public int c()
  {
    long l1 = this.jdField_d_of_type_Long;
    if (l1 <= 0L) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_Long * 100L / l1);
  }
  
  /* Error */
  public void c()
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
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +10 -> 25
    //   18: aload_1
    //   19: bipush 64
    //   21: invokestatic 1549	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   24: pop
    //   25: aload_0
    //   26: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   29: invokevirtual 1550	java/io/InputStream:close	()V
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   37: aload_0
    //   38: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder	Lcom/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +7 -> 50
    //   46: aload_1
    //   47: invokevirtual 727	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:a	()V
    //   50: aload_0
    //   51: getfield 681	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   54: ifnull +107 -> 161
    //   57: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +70 -> 130
    //   63: new 202	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   70: astore_1
    //   71: aload_1
    //   72: ldc 253
    //   74: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_1
    //   79: aload_0
    //   80: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   83: invokestatic 218	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   86: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: ldc_w 1172
    //   94: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_1
    //   99: aload_0
    //   100: getfield 681	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   103: invokevirtual 817	com/tencent/mobileqq/utils/httputils/HttpMsg:getSerial	()I
    //   106: invokestatic 628	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   109: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_1
    //   114: ldc 237
    //   116: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc 239
    //   122: iconst_2
    //   123: aload_1
    //   124: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_0
    //   131: getfield 179	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   134: ldc_w 663
    //   137: ldc_w 665
    //   140: invokevirtual 669	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   143: checkcast 663	com/tencent/mobileqq/transfile/api/IHttpEngineService
    //   146: invokeinterface 673 1 0
    //   151: checkcast 675	com/tencent/mobileqq/transfile/HttpCommunicator
    //   154: aload_0
    //   155: getfield 681	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   158: invokevirtual 1176	com/tencent/mobileqq/transfile/HttpCommunicator:cancelMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   161: aload_0
    //   162: getfield 123	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask	Lcom/tencent/mobileqq/filemanageraux/core/WeiyunTask;
    //   165: ifnull +61 -> 226
    //   168: invokestatic 200	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +48 -> 219
    //   174: new 202	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   181: astore_1
    //   182: aload_1
    //   183: ldc 253
    //   185: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_1
    //   190: aload_0
    //   191: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   194: invokestatic 218	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   197: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_1
    //   202: ldc_w 1552
    //   205: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: ldc 239
    //   211: iconst_2
    //   212: aload_1
    //   213: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 245	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: getfield 123	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask	Lcom/tencent/mobileqq/filemanageraux/core/WeiyunTask;
    //   223: invokevirtual 1553	com/tencent/mobileqq/filemanageraux/core/WeiyunTask:a	()V
    //   226: return
    //   227: astore_1
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_1
    //   231: athrow
    //   232: astore_1
    //   233: goto -196 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	FileManagerRSWorker
    //   13	200	1	localObject1	Object
    //   227	4	1	localObject2	Object
    //   232	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	227	finally
    //   228	230	227	finally
    //   25	37	232	java/lang/Exception
  }
  
  public void d()
  {
    c();
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    int n;
    label393:
    label398:
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      Bundle localBundle = new Bundle();
      int i1 = 0;
      Object localObject1;
      String str;
      try
      {
        boolean bool = a(paramHttpMsg1);
        if (bool) {
          return;
        }
        if (this.jdField_b_of_type_Int == 0) {
          break label377;
        }
        localBundle.putInt("param_V6SelectType", this.jdField_c_of_type_Int);
        localBundle.putInt("param_ipAddrType", d());
        if (!this.jdField_c_of_type_Boolean) {
          break label393;
        }
        n = 1;
        localBundle.putInt("param_ishttps", n);
        bool = a(paramHttpMsg2, localBundle);
        if (!bool) {
          break label377;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, localException.toString());
        localObject1 = localException.getStackTrace();
        int i2 = localObject1.length;
        str = "";
        n = i1;
        while (n < i2)
        {
          Object localObject2 = localObject1[n];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(localObject2);
          localStringBuilder.append("&");
          str = localStringBuilder.toString();
          n += 1;
        }
        localObject1 = "";
        if (paramHttpMsg1 != null) {
          localObject1 = paramHttpMsg1.getRealUrl();
        }
        if (paramHttpMsg2 == null) {
          break label398;
        }
      }
      paramHttpMsg1 = paramHttpMsg2.rawRespHeader;
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9001L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, (String)localObject1, paramHttpMsg1, this.jdField_j_of_type_Int, str, null, localBundle);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9001L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, (String)localObject1, paramHttpMsg1, this.jdField_j_of_type_Int, str, null, localBundle);
      handleError(null, null);
      label377:
      return;
    }
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
    c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if ((localObject != null) && (((FileManagerEntity)localObject).status == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Id[");
        ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
        ((StringBuilder)localObject).append("] is Successed, return!");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null))
    {
      a(1004);
    }
    else if ((1 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null))
    {
      a(2004);
    }
    else
    {
      if (5 == this.jdField_b_of_type_Int)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask;
        if (localObject != null)
        {
          ((WeiyunTask)localObject).a();
          break label193;
        }
      }
      if (6 == this.jdField_b_of_type_Int)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask;
        if (localObject != null)
        {
          ((WeiyunTask)localObject).a();
          break label193;
        }
      }
      if (50 == this.jdField_b_of_type_Int)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask;
        if (localObject != null) {
          ((WeiyunTask)localObject).a();
        }
      }
    }
    label193:
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject != null)
    {
      ((FileManagerEntity)localObject).status = 3;
      ((FileManagerEntity)localObject).fProgress = ((float)this.jdField_a_of_type_Long / (float)((FileManagerEntity)localObject).fileSize);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Id[");
        ((StringBuilder)localObject).append(String.valueOf(this.jdField_c_of_type_Long));
        ((StringBuilder)localObject).append("]stop for pause!");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      long l1 = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Now[");
      ((StringBuilder)localObject).append(String.valueOf(l1));
      ((StringBuilder)localObject).append("]startTime[");
      ((StringBuilder)localObject).append(String.valueOf(this.jdField_g_of_type_Long));
      ((StringBuilder)localObject).append("]notifyTime[");
      ((StringBuilder)localObject).append(String.valueOf(this.jdField_f_of_type_Long));
      ((StringBuilder)localObject).append("]C2CTime[");
      ((StringBuilder)localObject).append(String.valueOf(this.jdField_j_of_type_Long));
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_g_of_type_Int, (String)localObject, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_k_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_m_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_m_of_type_JavaLangString, "", this.jdField_j_of_type_Int, (String)localObject, null);
    }
  }
  
  public void g()
  {
    try
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangRunnable = new FileManagerRSWorker.8(this);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Run RSWorker");
        localStringBuilder.append(MessageCache.a());
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
      }
      QQFileManagerUtil.FileExecutor.a().execute(this.jdField_a_of_type_JavaLangRunnable);
      if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 104857600L)) {
        n();
      }
      return;
    }
    finally {}
  }
  
  protected void h()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      ((FileManagerEntity)localObject).status = 0;
      ((FileManagerEntity)localObject).isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    long l1;
    if (SystemUtil.a()) {
      l1 = SystemUtil.a();
    } else {
      l1 = SystemUtil.b();
    }
    l1 *= 1024L;
    if (l1 < l2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject).append("]downLoadWeiYunFile local space no enough!! [downsize:");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("sdcardsize:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      ((FileManagerEntity)localObject).status = 0;
      ((FileManagerEntity)localObject).isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      String str = this.jdField_j_of_type_JavaLangString;
      l2 = this.jdField_g_of_type_Long;
      long l3 = this.jdField_a_of_type_Long;
      FileManagerUtil.a((QQAppInterface)localObject, l1, str, l2, "", "", "", "", 9040L, "", l3, l3, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_d_of_type_Long = ((FileManagerEntity)localObject).fileSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a((FileManagerEntity)localObject, null, new FileManagerRSWorker.9(this));
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create download task is fail! nSessionId[");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject).append("]fileid[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId);
      ((StringBuilder)localObject).append("] filename[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      ((StringBuilder)localObject).append("] filesize[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      ((StringBuilder)localObject).append("] modifytime[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime);
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      return;
    }
    ((WeiyunTask)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId);
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void handleRedirect(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleRedirect, new location:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null)
    {
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, but curRequest is null");
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    localObject = this.jdField_j_of_type_JavaLangString;
    long l2 = this.jdField_g_of_type_Long;
    String str1 = this.jdField_m_of_type_JavaLangString;
    String str2 = this.jdField_e_of_type_JavaLangString;
    String str3 = this.jdField_g_of_type_JavaLangString;
    String str4 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    int n = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial();
    long l3 = this.jdField_i_of_type_Long;
    long l4 = this.jdField_a_of_type_Long;
    long l5 = this.jdField_d_of_type_Long;
    String str5 = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getRealUrl();
    String str6 = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.rawRespHeader;
    int i1 = this.jdField_j_of_type_Int;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getErrorString());
    localStringBuilder.append("&UrlOver&handleRedirect");
    FileManagerUtil.a(paramString, l1, (String)localObject, l2, str1, str2, str3, str4, 9004L, String.valueOf(n), l3, l4, l5, str5, str6, i1, localStringBuilder.toString(), null);
    a(null, 0);
  }
  
  protected void i()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      ((FileManagerEntity)localObject).status = 0;
      ((FileManagerEntity)localObject).isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, 0L, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject).status = 2;
    this.jdField_d_of_type_Long = ((FileManagerEntity)localObject).fileSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null, new FileManagerRSWorker.11(this));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiyunTask == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create upload task is fail! nSessionId[");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject).append("] filePath[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
    }
  }
  
  void j()
  {
    this.jdField_l_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject).bOnceSuccess = true;
    ((FileManagerEntity)localObject).lastSuccessTime = MessageCache.a();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^> [Http upload]Id[");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject).append("] update successTime[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime);
    ((StringBuilder)localObject).append("]");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    a(1003);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^> [Http upload] SendFileSuccess, SessionId[");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject).append("], FileSize[");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Long);
    ((StringBuilder)localObject).append("], Uuid[");
    ((StringBuilder)localObject).append(this.jdField_g_of_type_JavaLangString);
    ((StringBuilder)localObject).append("]");
    QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 14, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^! [Http upload] uuid is null Entity[");
      ((StringBuilder)localObject).append(FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    this.jdField_j_of_type_Long = System.currentTimeMillis();
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileTransferHandler)localObject).a(localFileManagerEntity, this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, localFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if ((5 == paramInt) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Long < this.jdField_d_of_type_Long))
    {
      if (QLog.isColorLevel())
      {
        paramHttpMsg1 = new StringBuilder();
        paramHttpMsg1.append("nSessionID[");
        paramHttpMsg1.append(String.valueOf(this.jdField_c_of_type_Long));
        paramHttpMsg1.append("] HttpCommunicator.status = STATUS_END . but data no recv completed. recvData=");
        paramHttpMsg1.append(this.jdField_a_of_type_Long);
        paramHttpMsg1.append(" filesize=");
        paramHttpMsg1.append(this.jdField_d_of_type_Long);
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, paramHttpMsg1.toString());
      }
      paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      long l1 = this.jdField_c_of_type_Long;
      String str1 = this.jdField_k_of_type_JavaLangString;
      long l2 = this.jdField_g_of_type_Long;
      String str2 = this.jdField_f_of_type_JavaLangString;
      String str3 = this.jdField_e_of_type_JavaLangString;
      String str4 = this.jdField_g_of_type_JavaLangString;
      String str5 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      long l3 = this.jdField_i_of_type_Long;
      long l4 = this.jdField_a_of_type_Long;
      long l5 = this.jdField_d_of_type_Long;
      String str6 = paramHttpMsg2.getRealUrl();
      paramHttpMsg2 = paramHttpMsg2.rawRespHeader;
      paramInt = this.jdField_j_of_type_Int;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("statusChanged mtransferedSize[");
      localStringBuilder.append(String.valueOf(this.jdField_a_of_type_Long));
      localStringBuilder.append("]nFileSize[");
      localStringBuilder.append(String.valueOf(this.jdField_d_of_type_Long));
      localStringBuilder.append("]");
      FileManagerUtil.a(paramHttpMsg1, l1, str1, l2, str2, str3, str4, str5, -9527L, "", l3, l4, l5, str6, paramHttpMsg2, paramInt, localStringBuilder.toString(), null);
      l();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker
 * JD-Core Version:    0.7.0.1
 */