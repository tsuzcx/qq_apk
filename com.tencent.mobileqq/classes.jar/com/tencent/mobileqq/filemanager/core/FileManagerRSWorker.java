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
  boolean A = false;
  FileManagerEntity B;
  long C = 0L;
  long D = 0L;
  OfflineFileUploader E = null;
  OfflineFileHttpUploder F = null;
  byte[] G;
  byte[] H;
  IFMSettings I = null;
  int J = 0;
  String K = null;
  String L = null;
  File M = null;
  boolean N = false;
  String O = null;
  final int P = 1000;
  long Q = 0L;
  long R = 0L;
  int S = 0;
  int T = 0;
  WeiyunTask U = null;
  long V = 0L;
  long W = 0L;
  private long X = 0L;
  private HttpUrlProcessor Y;
  private FileTransferObserver Z = new FileManagerRSWorker.5(this);
  QQAppInterface a;
  private int aa = 0;
  private int ab = 0;
  private int ac = 0;
  private int ad = 0;
  private String ae = "";
  private int af;
  String b;
  String c;
  String d;
  String e;
  String f;
  int g;
  String h;
  String i;
  String j;
  boolean k;
  byte[] l;
  HttpMsg m;
  int n;
  long o = 0L;
  int[] p = new int[0];
  long q = 0L;
  long r = 0L;
  long s = 0L;
  String t = null;
  OutputStream u = null;
  InputStream v = null;
  SSCM w;
  long x;
  long y = 0L;
  Runnable z;
  
  public FileManagerRSWorker(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null) {
      try
      {
        this.c = paramFileManagerEntity.getFilePath();
        this.g = paramFileManagerEntity.peerType;
        this.i = paramFileManagerEntity.Uuid;
        this.j = paramFileManagerEntity.fileIdCrc;
        this.k = paramFileManagerEntity.bUseMediaPlatform;
        this.n = paramFileManagerEntity.nOpType;
        this.h = paramFileManagerEntity.strServerPath;
        this.f = paramFileManagerEntity.peerUin;
        this.I = FMSettings.a();
        this.B = paramFileManagerEntity;
        try
        {
          this.A = true;
          this.a = paramQQAppInterface;
          this.b = paramQQAppInterface.getAccount();
          Object localObject = this.B;
          if ((localObject != null) && (((FileManagerEntity)localObject).strSrcName == null))
          {
            localObject = this.B;
            ((FileManagerEntity)localObject).strSrcName = ((FileManagerEntity)localObject).fileName;
          }
          g();
          int i1 = this.n;
          if (i1 != 0)
          {
            if (i1 != 1)
            {
              if (i1 != 5) {
                if (i1 != 6)
                {
                  if (i1 == 8) {
                    break label677;
                  }
                  if (i1 != 50) {
                    break label1024;
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
                  this.K = "actFileWyUp";
                  break label1024;
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
              this.K = "actFileWyDown";
              break label1024;
            }
            label677:
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Id[");
              ((StringBuilder)localObject).append(String.valueOf(this.r));
              ((StringBuilder)localObject).append("]getTransferFilePath");
              QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
            }
            this.c = a(this.f, paramFileManagerEntity.fileName);
            a(2);
            if (this.B.peerType == 0)
            {
              this.K = "actFileDown";
              this.L = "actFileDownDetail";
            }
            else if (this.B.peerType == 3000)
            {
              this.K = "actFileDiscDownLoad";
              this.L = "actFileDiscDownLoadDetail";
            }
            if (this.B.isZipInnerFile)
            {
              this.K = "actFileUfGenDownload";
              this.L = "actFileUfGenDownloadDetail";
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
              ((StringBuilder)localObject).append(this.c);
              ((StringBuilder)localObject).append("]:size[");
              ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.fileSize));
              ((StringBuilder)localObject).append("]");
              QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
            }
            a(2);
            if (this.B.peerType == 0)
            {
              this.K = "actFileUp";
              this.L = "actFileUpDetail";
            }
            else if (this.B.peerType == 3000)
            {
              this.K = "actDiscussFileUp";
              this.L = "actDiscussFileUpDetail";
            }
            if ((paramFileManagerEntity.getFilePath() != null) && (paramFileManagerEntity.getFilePath().length() > 0)) {
              this.M = new File(paramFileManagerEntity.getFilePath());
            }
          }
          label1024:
          this.s = paramFileManagerEntity.fileSize;
          this.q = paramFileManagerEntity.uniseq;
          this.r = paramFileManagerEntity.nSessionId;
          paramFileManagerEntity.status = 0;
          paramQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
          paramFileManagerEntity.fProgress = 0.0F;
          paramFileManagerEntity.status = 2;
          if (this.w == null) {
            this.w = new SSCM();
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
    int i1 = paramInt;
    if (((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4Disc(this.a))
    {
      i1 = paramInt;
      if (paramBundle != null)
      {
        String str = paramBundle.getString("strHttpsDomain");
        int i2 = paramBundle.getShort("httpsPort", (short)0);
        i1 = paramInt;
        if (!TextUtils.isEmpty(str))
        {
          this.N = true;
          this.O = str;
          if (i2 == 0) {
            return 443;
          }
          i1 = i2;
        }
      }
    }
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
        paramByteStringMicro = new StringBuilder();
        paramByteStringMicro.append(paramString1);
        paramByteStringMicro.append(":");
        paramByteStringMicro.append(paramShort2);
        paramString1 = paramByteStringMicro.toString();
        paramByteStringMicro = paramString1;
        if (((IFMConfig)QRoute.api(IFMConfig.class)).getUserFtnSpeedTest())
        {
          paramByteStringMicro = paramString1;
          if (!this.N)
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
        this.Y = new HttpUrlProcessor(this.a, paramArrayList, paramString2);
        if (this.N) {
          this.Y.a(true);
        } else {
          this.Y.a(false);
        }
        localObject1 = this.Y.b();
      }
    }
    return localObject1;
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
        paramString1 = d(paramString2);
        paramString2 = new ArrayList(1);
        paramString2.add(paramString4);
        if ((!TextUtils.isEmpty(paramString3)) && (FileIPv6StrateyController.b().isConfigEnableIPV6(this.a, 5)))
        {
          paramString4 = new StringBuilder();
          paramString4.append("[IPv6-File] Discfile download. is config enable IPv6. domain[");
          paramString4.append(paramString3);
          paramString4.append("]");
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString4.toString());
          paramString3 = new FileIPv6StrateyController.DomainInfo(paramString3, paramInt);
          paramString3 = FileIPv6StrateyController.b().getIPlistForV6Domain(this.a, paramString3, 5);
          if ((paramString3 != null) && (!paramString3.a()))
          {
            if (FileIPv6StrateyController.a())
            {
              QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download.debugIsDisableIPv4OnDoubleStack");
              paramString2.clear();
            }
            FileIPv6StrateyController.a(paramString3.b, paramString2, false, false);
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
        this.Y = new HttpUrlProcessor(this.a, paramString2, paramString1);
        if (this.N) {
          this.Y.a(true);
        } else {
          this.Y.a(false);
        }
        str = this.Y.b();
      }
    }
    return str;
  }
  
  private short a(short paramShort, Bundle paramBundle)
  {
    short s1 = paramShort;
    if (((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.a))
    {
      s1 = paramShort;
      if (paramBundle != null)
      {
        String str = paramBundle.getString("strHttpsDomain");
        short s2 = paramBundle.getShort("httpsPort", (short)0);
        s1 = paramShort;
        if (!TextUtils.isEmpty(str))
        {
          this.N = true;
          this.O = str;
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
    Object localObject = this.B;
    ((FileManagerEntity)localObject).fProgress = (paramFloat1 / paramFloat2);
    ((FileManagerEntity)localObject).status = 2;
    long l1 = System.currentTimeMillis();
    if (l1 - this.y >= 1000L)
    {
      this.y = l1;
      this.B.setCloudType(3);
      this.a.getFileManagerNotifyCenter().a(this.B.uniseq, this.B.nSessionId, this.B.peerUin, this.B.peerType, 16, null, 0, null);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Id[");
        ((StringBuilder)localObject).append(String.valueOf(this.B.nSessionId));
        ((StringBuilder)localObject).append("]Notify UI Progress! and send continue!");
        QLog.d("FileManagerRSWorker<FileAssistant>", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void a(long paramLong, FileManagerRSWorker.ChangeNewPath paramChangeNewPath)
  {
    this.a.getFileManagerRSCenter().a(false);
    this.a.getFileManagerEngine().j().b();
    this.a.getFileManagerEngine().l().b();
    paramChangeNewPath = new ArrayList();
    paramChangeNewPath.add(this.e);
    this.I.justDoIt(paramLong, paramChangeNewPath, SplashActivity.sTopActivity, new FileManagerRSWorker.13(this));
  }
  
  private void a(long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= v> [Http Recv]id[");
    ((StringBuilder)localObject).append(String.valueOf(this.r));
    ((StringBuilder)localObject).append("] receviveFile, pos[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("] url:");
    ((StringBuilder)localObject).append(this.h);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if (this.A)
    {
      paramString = new StringBuilder();
      paramString.append("=_= v! [Http Recv]id[");
      paramString.append(String.valueOf(this.r));
      paramString.append("] is stoped!");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bytes=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("-");
    String str = ((StringBuilder)localObject).toString();
    HttpMsg localHttpMsg = new HttpMsg(this.h, null, this, true);
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
    localHttpMsg.busiType = this.g;
    localHttpMsg.msgId = String.valueOf(this.r);
    paramString = new StringBuilder();
    paramString.append("=_= v> [Http Recv]Id[");
    paramString.append(String.valueOf(this.r));
    paramString.append("]recv http data RANGE[");
    paramString.append(String.valueOf(str));
    paramString.append("], peerType[");
    paramString.append(String.valueOf(this.g));
    paramString.append("]");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
    localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
    paramString = this.h;
    if (paramString != null) {
      paramString = paramString.toLowerCase();
    } else {
      paramString = "";
    }
    if ((this.N) && (paramString.startsWith("https")))
    {
      localHttpMsg.mIsHttps = true;
      localHttpMsg.mIsHostIP = HttpUrlProcessor.a(this.h);
      localHttpMsg.mReqHost = this.O;
    }
    localHttpMsg.timeoutParam = FileManagerUtil.h();
    ((HttpCommunicator)((IHttpEngineService)this.a.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).sendMsg(localHttpMsg);
    this.m = localHttpMsg;
    if (paramLong == 0L)
    {
      a(2001);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 10, null, 6, null);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    this.B.setCloudType(3);
    a(2003);
    this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 11, new Object[] { this.c, Long.valueOf(this.s), Boolean.valueOf(true), this.h }, 0, null);
    this.B.fileName = FileManagerUtil.a(this.c);
    if (this.B.fileName.getBytes().length > 250)
    {
      localObject = this.B;
      ((FileManagerEntity)localObject).fileName = FileManagerUtil.j(((FileManagerEntity)localObject).fileName);
      this.c = a(this.f, this.B.fileName);
    }
    if (FileUtils.fileExists(this.c)) {
      this.c = FileManagerUtil.b(this.c);
    }
    FileManagerUtil.a(new File(this.e), new File(this.c));
    this.B.fileName = FileManagerUtil.a(this.c);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^> [CS Replay]id[");
    ((StringBuilder)localObject).append(String.valueOf(this.r));
    ((StringBuilder)localObject).append("] is exist, and filesize is right!");
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    long l1 = this.B.nSessionId;
    String str1 = this.K;
    String str2 = this.h;
    FileManagerUtil.a((QQAppInterface)localObject, l1, str1, 0L, str2, this.f, str2, this.B.strFileMd5, 0L, 0L, this.s, this.ad, null, paramBundle);
  }
  
  private void a(FileUploadInfo paramFileUploadInfo)
  {
    if ((paramFileUploadInfo.a == 0) && (!this.A))
    {
      Object localObject = this.F;
      if (localObject != null) {
        ((OfflineFileHttpUploder)localObject).a();
      }
      f();
      if ((paramFileUploadInfo.h != null) && (paramFileUploadInfo.h.length > 0))
      {
        this.i = new String(paramFileUploadInfo.h);
        this.B.Uuid = this.i;
      }
      else
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
      }
      this.R = System.currentTimeMillis();
      this.D = System.currentTimeMillis();
      FileManagerUtil.b(this.B.nSessionId);
      this.a.getFileManagerNotifyCenter().a(this.B, 5, this.h);
      paramFileUploadInfo = this.a.getFileTransferHandler();
      localObject = this.B;
      paramFileUploadInfo.a((FileManagerEntity)localObject, this.b, this.f, ((FileManagerEntity)localObject).Uuid, this.Z);
      paramFileUploadInfo = new FileManagerReporter.FileAssistantReportData();
      paramFileUploadInfo.b = "send_file_suc";
      paramFileUploadInfo.c = 1;
      FileManagerReporter.a(this.a.getCurrentAccountUin(), paramFileUploadInfo);
      this.B.status = 1;
      this.a.getFileManagerDataCenter().c(this.B);
    }
  }
  
  private void a(HttpMsg paramHttpMsg, Bundle paramBundle, int paramInt, long paramLong)
  {
    this.aa += 1;
    this.ad += 1;
    if (paramInt == 9056)
    {
      i1 = this.ab;
      if (i1 < 3)
      {
        this.ab = (i1 + 1);
        this.aa -= 1;
      }
      else
      {
        this.ab = 0;
      }
    }
    if (paramInt == 9042)
    {
      i1 = this.ac;
      if (i1 < 3)
      {
        this.ac = (i1 + 1);
        this.aa -= 1;
      }
      else
      {
        this.ac = 0;
      }
    }
    int i1 = 6000;
    if (paramInt == 9056) {
      i1 = 0;
    }
    ThreadManager.getFileThreadHandler().postDelayed(new FileManagerRSWorker.7(this), i1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nSessionId[");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append("] after [");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("] time retry!");
    QLog.w("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    int i2 = paramInt;
    if (9048 == paramInt) {
      i2 = 11202;
    }
    localObject = this.a;
    long l1 = this.B.nSessionId;
    String str1 = this.L;
    String str2 = this.ae;
    String str3 = this.f;
    String str4 = this.i;
    String str5 = this.B.strFileMd5;
    long l2 = i2;
    paramInt = paramHttpMsg.getSerial();
    long l3 = this.Q;
    long l4 = this.o;
    long l5 = this.s;
    String str6 = paramHttpMsg.getRealUrl();
    String str7 = paramHttpMsg.rawRespHeader;
    i2 = this.ad;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("delayTimes[");
    localStringBuilder.append(i1);
    localStringBuilder.append("]");
    localStringBuilder.append(paramHttpMsg.getErrorString());
    FileManagerUtil.a((QQAppInterface)localObject, l1, str1, paramLong, str2, str3, str4, str5, l2, String.valueOf(paramInt), l3, l4, l5, str6, str7, i2, localStringBuilder.toString(), null, paramBundle);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    this.Q += paramInt;
    Object localObject = a(paramLong, paramInt);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("=_= ^! [Upload Step] Id[");
      paramString.append(this.r);
      paramString.append("]sendFilePakage transferData null");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9003L, "", 0L, 0L, this.s, "", "", this.aa, "get Stream null", null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9003L, "", 0L, 0L, this.s, "", "", this.ad, "get Stream null", null);
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
    ((HttpMsg)localObject).busiType = this.g;
    ((HttpMsg)localObject).msgId = String.valueOf(this.r);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("Id[");
      paramString.append(this.r);
      paramString.append("]send http data size[");
      paramString.append(paramInt);
      paramString.append("], peerType[");
      paramString.append(this.g);
      paramString.append("]");
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, paramString.toString());
    }
    ((HttpCommunicator)((IHttpEngineService)this.a.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).sendMsg((HttpMsg)localObject);
    this.m = ((HttpMsg)localObject);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("发送一个数据包,nSessionID[");
      paramString.append(String.valueOf(this.B.nSessionId));
      paramString.append("]");
      QLog.e("##########", 2, paramString.toString());
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    paramString = new OfflineFileUploadPara();
    paramString.a = this.f;
    paramString.f = paramArrayOfByte2;
    paramString.e = paramArrayOfByte1;
    paramString.b = this.s;
    paramString.g = this.l;
    if (paramLong <= 104857600L)
    {
      paramString.c = 1700;
      this.G = FileManagerUtil.d(new String(paramArrayOfByte1));
      paramArrayOfByte1 = this.G;
      if (paramArrayOfByte1 == null)
      {
        a(null, 0);
        return;
      }
      paramString.i = paramArrayOfByte1;
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("=_= ^> [CS Step], SessionId[");
      paramArrayOfByte1.append(this.r);
      paramArrayOfByte1.append("], filesize < 100 get sha1");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramArrayOfByte1.toString());
    }
    else
    {
      paramString.c = 1600;
      this.H = FileManagerUtil.f(new String(paramArrayOfByte1));
      paramFileManagerEntity.strFileSha3 = HexUtil.bytes2HexStr(this.H);
      paramFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(this.l);
      paramArrayOfByte1 = this.H;
      if (paramArrayOfByte1 == null)
      {
        a(null, 0);
        return;
      }
      paramString.j = paramArrayOfByte1;
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("=_= ^> [CS Step], SessionId[");
      paramArrayOfByte1.append(this.r);
      paramArrayOfByte1.append("], filesize > 100 get sha3");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramArrayOfByte1.toString());
    }
    this.a.getFileTransferHandler().a(paramString, this.Z, paramFileManagerEntity);
  }
  
  private void a(List<String> paramList1, String paramString, int paramInt, List<String> paramList2, boolean paramBoolean)
  {
    if ((paramList1 != null) && (FileIPv6StrateyController.b().isConfigEnableIPV6(this.a, 1)))
    {
      if ((paramBoolean) && (paramList2 != null) && (paramList2.size() > 0))
      {
        paramString = new StringBuilder();
        paramString.append("[IPv6-File] mediaplatform offlinefile download. is config enable IPv6. v6ipsize[");
        paramString.append(paramList2.size());
        paramString.append("]");
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
        paramString = FileIPv6StrateyController.b().getIPV6listForMediaPlatfrom(this.a, 1, paramList2);
        if ((paramString != null) && (paramString.size() > 0))
        {
          if (FileIPv6StrateyController.a())
          {
            QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download. debugIsDisableIPv4OnDoubleStack");
            paramList1.clear();
          }
          int i1 = paramString.size() - 1;
          while (i1 >= 0)
          {
            paramList2 = (String)paramString.get(i1);
            if (!TextUtils.isEmpty(paramList2))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append(paramList2);
              localStringBuilder.append("]:");
              localStringBuilder.append(paramInt);
              paramList1.add(0, localStringBuilder.toString());
            }
            i1 -= 1;
          }
          this.J = 2;
          paramString = new StringBuilder();
          paramString.append("[IPv6-File] mediaplatform offlinefile download use IPv6. iplist:");
          paramString.append(paramList1.toString());
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
          return;
        }
        this.J = 1;
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
        paramString = FileIPv6StrateyController.b().getIPlistForV6Domain(this.a, paramString, 1);
        if ((paramString != null) && (!paramString.a()))
        {
          if (FileIPv6StrateyController.a())
          {
            QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. debugIsDisableIPv4OnDoubleStack");
            paramList1.clear();
          }
          FileIPv6StrateyController.a(paramString.b, paramList1, false, false);
          this.J = 2;
          if (paramString.a == 1) {
            this.J = 3;
          }
          paramString = new StringBuilder();
          paramString.append("[IPv6-File] offlinefile download. use IPv6. iplist:");
          paramString.append(paramList1.toString());
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString.toString());
          return;
        }
        this.J = 1;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. use IPv4");
        return;
      }
      this.J = 1;
      return;
    }
    this.J = 1;
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
      paramString1.append(this.r);
      paramString1.append("]OnDiscDownloadInfo, network error");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString1.toString());
      return;
    }
    if (a(paramBoolean, paramLong1, paramString1, paramInt2, "=_= v! [Disc Download Replay]id[", "ret error")) {
      return;
    }
    int i1 = a(paramInt1, paramBundle);
    if (paramBundle != null) {
      localObject = paramBundle.getString("IPv6Dns", "");
    } else {
      localObject = "";
    }
    Object localObject = a(paramString3, paramString4, i1, (String)localObject, null);
    if (a(paramLong1, paramString1, paramInt2, (String)localObject)) {
      return;
    }
    this.h = ((String)localObject);
    this.ae = this.h;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= v [Disc Download Replay]nSessionID[");
    ((StringBuilder)localObject).append(String.valueOf(this.r));
    ((StringBuilder)localObject).append("],retCode[");
    ((StringBuilder)localObject).append(String.valueOf(paramLong1));
    ((StringBuilder)localObject).append("]downLoadUrl[");
    ((StringBuilder)localObject).append(String.valueOf(this.h));
    ((StringBuilder)localObject).append("] mUseHttps:");
    ((StringBuilder)localObject).append(this.N);
    ((StringBuilder)localObject).append(" mHttpsDomain:");
    ((StringBuilder)localObject).append(this.O);
    ((StringBuilder)localObject).append(" downloadPort:");
    ((StringBuilder)localObject).append(i1);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(String.valueOf(this.r));
      ((StringBuilder)localObject).append("] will show taost, retCode[");
      ((StringBuilder)localObject).append(String.valueOf(paramLong1));
      ((StringBuilder)localObject).append("], retMsg:");
      ((StringBuilder)localObject).append(paramString1);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 4, null, (int)paramLong1, paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("nSeseeId[");
        ((StringBuilder)localObject).append(String.valueOf(this.r));
        ((StringBuilder)localObject).append("]renamed[");
        ((StringBuilder)localObject).append(String.valueOf(paramString2));
        ((StringBuilder)localObject).append("]");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      this.c = a(this.f, paramString2);
    }
    if (this.B.getCloudType() == 1) {
      this.c = FileManagerUtil.b(this.c);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("dsc-");
    ((StringBuilder)localObject).append(String.valueOf(this.B.Uuid.replace("/", "")));
    this.e = ((StringBuilder)localObject).toString();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2005);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 1, null, 2, null);
      paramString1 = new StringBuilder();
      paramString1.append("nSessionId[");
      paramString1.append(String.valueOf(this.r));
      paramString1.append("], NetWork Error, notify UI!");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, paramString1.toString());
      paramString1 = this.a;
      paramLong2 = this.B.nSessionId;
      paramString2 = this.K;
      l1 = this.C;
      paramString3 = this.ae;
      paramString4 = this.f;
      paramString5 = this.i;
      paramBundle = this.B.strFileMd5;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(String.valueOf(paramLong1));
      FileManagerUtil.a(paramString1, paramLong2, paramString2, l1, paramString3, paramString4, paramString5, paramBundle, 2L, ((StringBuilder)localObject).toString(), this.Q, this.o, this.s, this.ae, "", this.aa, "net", null);
      paramString1 = this.a;
      paramLong2 = this.B.nSessionId;
      paramString2 = this.L;
      l1 = this.C;
      paramString3 = this.ae;
      paramString4 = this.f;
      paramString5 = this.i;
      paramBundle = this.B.strFileMd5;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(String.valueOf(paramLong1));
      FileManagerUtil.a(paramString1, paramLong2, paramString2, l1, paramString3, paramString4, paramString5, paramBundle, 2L, ((StringBuilder)localObject).toString(), this.Q, this.o, this.s, this.ae, "", this.ad, "net", null);
      return;
    }
    this.a.getFileManagerDataCenter().a(this.r, this.c);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sessionId[");
      ((StringBuilder)localObject).append(String.valueOf(this.r));
      ((StringBuilder)localObject).append("], strTmp[");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    this.o = FileManagerUtil.h(this.e);
    long l1 = this.o;
    long l2 = this.s;
    if (l1 == l2)
    {
      this.B.setCloudType(3);
      a(2003);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 11, new Object[] { this.c, Long.valueOf(this.s), Boolean.valueOf(true), this.h }, 0, null);
      this.B.fileName = FileManagerUtil.a(this.c);
      if (this.B.fileName.getBytes().length > 250)
      {
        paramString1 = this.B;
        paramString1.fileName = FileManagerUtil.j(paramString1.fileName);
        this.c = a(this.f, this.B.fileName);
      }
      if (FileUtils.fileExists(this.c)) {
        this.c = FileManagerUtil.b(this.c);
      }
      FileManagerUtil.a(new File(this.e), new File(this.c));
      this.B.fileName = FileManagerUtil.a(this.c);
      paramString1 = new StringBuilder();
      paramString1.append("nSessionId[");
      paramString1.append(String.valueOf(this.r));
      paramString1.append("], fileExisted, notify UI!");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString1.toString());
      paramString1 = this.a;
      paramLong1 = this.B.nSessionId;
      paramString2 = this.K;
      paramString3 = this.h;
      FileManagerUtil.a(paramString1, paramLong1, paramString2, 0L, paramString3, this.f, paramString3, this.B.strFileMd5, 0L, 0L, this.s, this.ad, null);
      return;
    }
    if (l2 > l1)
    {
      l1 = l2 - l1;
      if (this.I.getDefalutStorgeFreeSpace() < l1)
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
    localStringBuilder.append(this.r);
    localStringBuilder.append("]onDownloadFileSuc");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
    if ((paramBoolean) && ((paramFileUploadInfo.l == 2) || (paramFileUploadInfo.l == 0)) && (!this.B.bSend))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("],retCode[");
      localStringBuilder.append(paramFileUploadInfo.a);
      localStringBuilder.append("],retMsg[");
      localStringBuilder.append(paramFileUploadInfo.b);
      localStringBuilder.append("],retStat[");
      localStringBuilder.append(paramFileUploadInfo.l);
      localStringBuilder.append("]. need to send file receipt");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
      if (this.B.strSrcName != null)
      {
        this.a.getFileTransferHandler().a(this.f, this.B.strSrcName, this.B.Uuid, this.s, this.B.uniseq);
        return;
      }
      this.a.getFileTransferHandler().a(this.f, this.B.fileName, this.B.Uuid, this.s, this.B.uniseq);
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("],retCode[");
    localStringBuilder.append(paramFileUploadInfo.a);
    localStringBuilder.append("],retMsg[");
    localStringBuilder.append(paramFileUploadInfo.b);
    localStringBuilder.append("],retStat[");
    localStringBuilder.append(paramFileUploadInfo.l);
    localStringBuilder.append("]. don't need to send file receipt");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  private boolean a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null)
    {
      paramString2 = new StringBuilder();
      paramString2.append("=_= v! [Disc Download Replay]id[");
      paramString2.append(String.valueOf(this.r));
      paramString2.append("] get DiscdownLoad info Url is null");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString2.toString());
      a(2005);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 12, null, (int)paramLong, paramString1);
      long l1 = paramLong;
      if (paramLong == 0L) {
        l1 = 9048L;
      }
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, l1, String.valueOf(paramInt), this.Q, this.o, this.s, this.ae, "", this.aa, "ip url error", null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, l1, String.valueOf(paramInt), this.Q, this.o, this.s, this.ae, "", this.ad, "ip url error", null);
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
      paramString2.append(String.valueOf(this.r));
      paramString2.append("] get offlinefile info Url is null, IP is null too");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString2.toString());
      a(2005);
      if ((paramLong == -6101L) || (paramLong == -7003L)) {
        this.B.status = 16;
      }
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 12, null, (int)paramLong, paramString1);
      long l1 = paramLong;
      if (paramLong == 0L) {
        l1 = 9048L;
      }
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, l1, String.valueOf(paramInt), this.Q, this.o, this.s, this.ae, "", this.aa, "ip url error", null, paramBundle);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, l1, String.valueOf(paramInt), this.Q, this.o, this.s, this.ae, "", this.ad, "ip url error", null, paramBundle);
      this.a.getFileManagerDataCenter().c(this.B);
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
        paramHttpMsg.append(String.valueOf(this.B.nSessionId));
        paramHttpMsg.append("]已经结束,返回");
        QLog.e("##########", 2, paramHttpMsg.toString());
      }
      return true;
    }
    Object localObject = this.m;
    if (paramHttpMsg != localObject)
    {
      if ((paramHttpMsg != null) && (localObject != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("id[");
        ((StringBuilder)localObject).append(String.valueOf(this.r));
        ((StringBuilder)localObject).append("],Req Serial[");
        ((StringBuilder)localObject).append(String.valueOf(paramHttpMsg.getSerial()));
        ((StringBuilder)localObject).append("], curRequest Serial[");
        ((StringBuilder)localObject).append(String.valueOf(this.m.getSerial()));
        ((StringBuilder)localObject).append("]");
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        return true;
      }
      if (paramHttpMsg != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("id[");
        ((StringBuilder)localObject).append(String.valueOf(this.r));
        ((StringBuilder)localObject).append("],Req Serial[");
        ((StringBuilder)localObject).append(String.valueOf(paramHttpMsg.getSerial()));
        ((StringBuilder)localObject).append("]");
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        return true;
      }
      if (this.m != null)
      {
        paramHttpMsg = new StringBuilder();
        paramHttpMsg.append("id[");
        paramHttpMsg.append(String.valueOf(this.r));
        paramHttpMsg.append("],curRequest Serial[");
        paramHttpMsg.append(String.valueOf(this.m.getSerial()));
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
      this.u.write(paramHttpMsg.getRecvData());
      this.aa = 0;
      long l1 = paramHttpMsg.getRecvData().length;
      this.Q += l1;
      this.o += l1;
      l1 = this.s;
      l1 = paramHttpMsg.getTotalLen();
      long l2 = this.o;
      if (l2 >= l1)
      {
        if ((this.g != 3000) && (!QFileAssistantUtils.a(this.B.peerUin)) && (!this.B.bSend))
        {
          paramHttpMsg = new StringBuilder();
          paramHttpMsg.append("=_= v> [Set FileStatus]Id[");
          paramHttpMsg.append(this.r);
          paramHttpMsg.append("] set Download Success");
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramHttpMsg.toString());
          this.a.getFileTransferHandler().a(this.b, this.i, this.k, this.j, this.Z);
        }
        this.m = null;
        try
        {
          this.u.close();
        }
        catch (IOException paramHttpMsg)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("Id[");
          paramBundle.append(String.valueOf(this.r));
          paramBundle.append("]exception io FileMsg, ");
          paramBundle.append(paramHttpMsg.toString());
          QLog.i("8pic", 1, paramBundle.toString());
          paramHttpMsg.printStackTrace();
        }
        this.u = null;
        u();
        return false;
      }
      this.B.fProgress = ((float)l2 / (float)this.s);
      a(2002);
      l1 = System.currentTimeMillis();
      if (l1 - this.y < 1000L) {
        return true;
      }
      this.y = l1;
      this.B.fProgress = ((float)this.o / (float)this.s);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 16, null, 0, null);
      return false;
    }
    catch (Exception paramHttpMsg)
    {
      if (!paramHttpMsg.getMessage().contains("ENOSPC")) {
        break label715;
      }
    }
    label556:
    try
    {
      this.A = true;
      if (this.m != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("=_= v! Id[");
        localStringBuilder.append(String.valueOf(this.r));
        localStringBuilder.append("]stop serial[");
        localStringBuilder.append(String.valueOf(this.m.getSerial()));
        localStringBuilder.append("]:");
        localStringBuilder.append(paramHttpMsg.getMessage());
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, localStringBuilder.toString());
        ((HttpCommunicator)((IHttpEngineService)this.a.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).cancelMsg(this.m);
      }
      this.a.getFileManagerRSCenter().a(false);
    }
    finally {}
    try
    {
      a(this.s, new FileManagerRSWorker.6(this));
    }
    catch (Exception paramHttpMsg)
    {
      break label556;
    }
    FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9003L, "", this.Q, this.o, this.s, this.ae, "", this.aa, "write stream error", null, paramBundle);
    FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9003L, "", this.Q, this.o, this.s, this.ae, "", this.ad, "write stream error", null, paramBundle);
    handleError(null, null);
    return true;
    label715:
    FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9003L, "", this.Q, this.o, this.s, this.ae, "", this.aa, "write stream error", null, paramBundle);
    FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9003L, "", this.Q, this.o, this.s, this.ae, "", this.ad, "write stream error", null, paramBundle);
    handleError(null, null);
    return true;
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (!a())
    {
      int i1 = this.af;
      if (i1 != 1003)
      {
        if (i1 == 2003) {
          return true;
        }
        if ((paramHttpMsg1 == null) && (paramHttpMsg2 == null))
        {
          f();
          a(null, 0);
          return true;
        }
        return false;
      }
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (!paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(String.valueOf(this.r));
      ((StringBuilder)localObject).append("] get offlinefile info is error!retCode[");
      ((StringBuilder)localObject).append(String.valueOf(paramLong));
      ((StringBuilder)localObject).append("], retMsg:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      a(2005);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 12, null, (int)paramLong, paramString1);
      long l1;
      if (paramLong == -100001L) {
        l1 = 9043L;
      } else {
        l1 = 9045L;
      }
      paramString1 = this.a;
      long l2 = this.B.nSessionId;
      paramString2 = this.K;
      long l3 = this.C;
      localObject = this.ae;
      String str1 = this.f;
      String str2 = this.i;
      String str3 = this.B.strFileMd5;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramInt));
      localStringBuilder.append("&");
      localStringBuilder.append(String.valueOf(paramLong));
      FileManagerUtil.a(paramString1, l2, paramString2, l3, (String)localObject, str1, str2, str3, l1, localStringBuilder.toString(), this.Q, this.o, this.s, this.ae, "", this.aa, paramString3, null);
      paramString1 = this.a;
      l2 = this.B.nSessionId;
      paramString2 = this.L;
      l3 = this.C;
      localObject = this.ae;
      str1 = this.f;
      str2 = this.i;
      str3 = this.B.strFileMd5;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramInt));
      localStringBuilder.append("&");
      localStringBuilder.append(String.valueOf(paramLong));
      FileManagerUtil.a(paramString1, l2, paramString2, l3, (String)localObject, str1, str2, str3, l1, localStringBuilder.toString(), this.Q, this.o, this.s, this.ae, "", this.ad, paramString3, null);
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle, ArrayList<String> paramArrayList)
  {
    long l1 = this.s - this.o;
    if (this.I.getDefalutStorgeFreeSpace() < l1)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^> [CS Replay]id[");
      ((StringBuilder)localObject).append(String.valueOf(this.r));
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
    return (paramString.contains("-6101")) || (paramString.contains("-7003")) || (paramString.contains("-403")) || (paramString.contains("-9006")) || (paramString.contains("-9004")) || (paramString.contains("-9017")) || (paramString.contains("-28137"));
  }
  
  private boolean c(String paramString)
  {
    return (paramString.contains("-29120")) || (paramString.contains("-502")) || (paramString.contains("HTTP_PROXY_AUTH")) || (paramString.contains("-29150")) || (paramString.contains("-21122")) || (paramString.contains("-28123")) || (paramString.contains("-25081")) || (paramString.contains("-28126"));
  }
  
  private String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/ftn_handler/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void t()
  {
    QQFileManagerUtil.FileExecutor.a().execute(new FileManagerRSWorker.1(this));
  }
  
  private void u()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  /* Error */
  private static String v()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: lconst_1
    //   4: invokestatic 1295	java/lang/Thread:sleep	(J)V
    //   7: goto +12 -> 19
    //   10: astore_2
    //   11: goto +42 -> 53
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 1296	java/lang/InterruptedException:printStackTrace	()V
    //   19: invokestatic 518	java/lang/System:currentTimeMillis	()J
    //   22: lstore_0
    //   23: new 1298	java/text/SimpleDateFormat
    //   26: dup
    //   27: ldc_w 1300
    //   30: getstatic 1306	java/util/Locale:US	Ljava/util/Locale;
    //   33: invokespecial 1309	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   36: new 1311	java/util/Date
    //   39: dup
    //   40: lload_0
    //   41: invokespecial 1313	java/util/Date:<init>	(J)V
    //   44: invokevirtual 1317	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
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
  
  private void w()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject1 = this.B;
      ((FileManagerEntity)localObject1).status = 0;
      ((FileManagerEntity)localObject1).isReaded = false;
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.a.getFileManagerDataCenter().a();
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, "", "", "", "", 9004L, "", 0L, 0L, this.B.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.s - this.o;
    long l1;
    if (SystemUtil.a()) {
      l1 = SystemUtil.b();
    } else {
      l1 = SystemUtil.c();
    }
    l1 *= 1024L;
    if (l1 < l2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Id[");
      ((StringBuilder)localObject1).append(this.r);
      ((StringBuilder)localObject1).append("]downLoadWeiYunFile local space no enough!! [downsize:");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append("sdcardsize:");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.B;
      ((FileManagerEntity)localObject1).status = 0;
      ((FileManagerEntity)localObject1).isReaded = false;
      this.a.getFileManagerDataCenter().a();
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 36, null, 12, null);
      localObject1 = this.a;
      l1 = this.B.nSessionId;
      localObject2 = this.K;
      l2 = this.C;
      long l3 = this.o;
      FileManagerUtil.a((QQAppInterface)localObject1, l1, (String)localObject2, l2, "", "", "", "", 9040L, "", l3, l3, this.B.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    Object localObject1 = this.B;
    this.s = ((FileManagerEntity)localObject1).fileSize;
    this.U = this.a.getFileManagerEngine().d().a((FileManagerEntity)localObject1, null, new FileManagerRSWorker.10(this, (FileManagerEntity)localObject1));
    Object localObject2 = this.U;
    if (localObject2 != null) {
      ((WeiyunTask)localObject2).a(((FileManagerEntity)localObject1).WeiYunFileId);
    }
  }
  
  private void x()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start Rsworker OfflineFileHitReq:");
      localStringBuilder.append(MessageCache.c());
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
    }
    QQFileManagerUtil.FileExecutor.a().execute(new FileManagerRSWorker.12(this));
  }
  
  private int y()
  {
    return QFileUtils.c(this.h);
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = this.I.getDefaultRecvPath();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = v();
    }
    paramString2 = new StringBuilder();
    paramString2.append(str);
    paramString2.append(paramString1);
    paramString1 = new File(paramString2.toString());
    paramString2 = new StringBuilder();
    paramString2.append("Id[");
    paramString2.append(String.valueOf(this.r));
    paramString2.append("]getTransferFilePath : ");
    paramString2.append(paramString1.getAbsoluteFile().toString());
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, paramString2.toString());
    return paramString1.getAbsoluteFile().toString();
  }
  
  public void a(int paramInt)
  {
    paramInt = FileManagerUtil.d(paramInt);
    if ((this.af == paramInt) && (paramInt == 2)) {
      return;
    }
    this.af = paramInt;
    FileManagerEntity localFileManagerEntity = this.B;
    localFileManagerEntity.status = paramInt;
    localFileManagerEntity.fProgress = ((float)this.o / (float)this.s);
    if (paramInt != 2)
    {
      localFileManagerEntity.peerUin = this.f;
      localFileManagerEntity.peerType = this.g;
      localFileManagerEntity.uniseq = this.q;
      String str = this.i;
      if (str == null) {
        str = localFileManagerEntity.Uuid;
      }
      localFileManagerEntity.Uuid = str;
      this.a.getFileManagerDataCenter().c(this.B);
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    HttpMsg localHttpMsg = (HttpMsg)paramObject;
    int i2 = this.n;
    int i1 = 16;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 5) {
          if (i2 != 6)
          {
            if (i2 != 8)
            {
              if (i2 != 50) {
                QLog.e("FileManagerRSWorker<FileAssistant>", 1, "why actionType is out?!");
              }
            }
            else
            {
              paramObject = this.B;
              paramObject.isReaded = false;
              paramObject.fProgress = ((float)this.o / (float)paramObject.fileSize);
              paramObject = this.B;
              if (paramObject.status != 16) {
                i1 = 0;
              }
              paramObject.status = i1;
              this.B.Uuid = this.i;
              this.a.getFileManagerDataCenter().c(this.B);
              this.a.getFileManagerDataCenter().a();
              this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 12, null, 6, null);
              break label602;
            }
          }
          else
          {
            paramObject = this.B;
            if (paramObject.status != 16) {
              i1 = 0;
            }
            paramObject.status = i1;
            this.B.isReaded = false;
            this.a.getFileManagerDataCenter().a();
            this.a.getFileManagerDataCenter().c(this.B);
            this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 38, null, 11, null);
            break label602;
          }
        }
        paramObject = this.B;
        if (paramObject.status != 16) {
          i1 = 0;
        }
        paramObject.status = i1;
        this.B.isReaded = false;
        this.a.getFileManagerDataCenter().a();
        this.a.getFileManagerDataCenter().c(this.B);
        this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 36, null, 11, null);
      }
      else
      {
        this.B.isReaded = false;
        this.a.getFileManagerDataCenter().a();
        paramObject = this.B;
        paramObject.isReaded = false;
        if (paramObject.status != 16) {
          i1 = 0;
        }
        paramObject.status = i1;
        paramObject = this.B;
        paramObject.fProgress = ((float)this.o / (float)this.s);
        paramObject.uniseq = this.q;
        paramObject.Uuid = this.i;
        this.a.getFileManagerDataCenter().c(this.B);
        this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 12, null, 6, null);
      }
    }
    else
    {
      this.a.getFileManagerDataCenter().a();
      paramObject = this.B;
      paramObject.isReaded = false;
      if (paramObject.status != 16) {
        i1 = 0;
      }
      paramObject.status = i1;
      paramObject = this.B;
      paramObject.fProgress = ((float)this.o / (float)this.s);
      paramObject.uniseq = this.q;
      paramObject.Uuid = this.i;
      this.a.getFileManagerDataCenter().c(this.B);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 15, null, 5, null);
    }
    label602:
    if (localHttpMsg == null) {
      return;
    }
    paramObject = localHttpMsg.getErrorString();
    if ((paramInt == 0) && (paramObject == null))
    {
      paramObject = new StringBuilder();
      paramObject.append("[Http_RespValue_Null]");
      paramObject.append(FileManagerUtil.d());
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
    FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, paramInt, String.valueOf(localHttpMsg.getSerial()), this.Q, this.o, this.s, localHttpMsg.getRealUrl(), localHttpMsg.rawRespHeader, this.ad, (String)localObject, null);
    this.a.getFileManagerDataCenter().c(this.B);
  }
  
  void a(String paramString)
  {
    int i1;
    if (this.n == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      this.h = paramString;
      paramString = this.h;
      this.ae = paramString;
      this.T += 1;
      a(paramString, 0L);
      return;
    }
    this.h = paramString;
    this.ae = this.h;
    this.T += 1;
    this.o = FileManagerUtil.h(this.e);
    a(this.o, this.t);
  }
  
  void a(String paramString, long paramLong)
  {
    if (a())
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Upload Step], working stoped!");
      return;
    }
    if (paramLong == 0L) {
      this.o = 0L;
    }
    int i2 = this.w.a(BaseApplication.getContext(), this.s, paramLong, 1048576);
    int i3 = Utils.a(BaseApplication.getContext());
    int i1;
    if (i3 != 1)
    {
      i1 = i2;
      if (i3 != 2) {}
    }
    else
    {
      i1 = i2;
      if (i2 > 16384) {
        i1 = 16384;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendFilePakage transferedSize[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], packetSize[");
    localStringBuilder.append(i1);
    localStringBuilder.append("]");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
    a(paramString, paramLong, i1);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.A;
      return bool;
    }
    finally {}
  }
  
  byte[] a(long paramLong, int paramInt)
  {
    if (this.v == null) {
      try
      {
        this.v = new FileInputStream(this.c);
        this.V = 0L;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        this.v = null;
        localFileNotFoundException1.printStackTrace();
        return null;
      }
    }
    if (paramLong == 0L)
    {
      if (this.V != 0L) {
        try
        {
          this.v = new FileInputStream(this.c);
          this.V = 0L;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          this.v = null;
          localFileNotFoundException2.printStackTrace();
          return null;
        }
      }
    }
    else
    {
      long l1 = this.V;
      if (paramLong > l1) {
        try
        {
          this.v.skip(paramLong - l1);
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          return null;
        }
      } else if (paramLong < l1) {
        try
        {
          this.v = new FileInputStream(this.c);
          this.V = 0L;
          this.v.skip(paramLong);
        }
        catch (IOException localIOException2)
        {
          this.v = null;
          localIOException2.printStackTrace();
          return null;
        }
      }
    }
    this.V = paramLong;
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      this.v.read(arrayOfByte, 0, paramInt);
      this.V += paramInt;
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
    return this.n;
  }
  
  public long c()
  {
    return this.s;
  }
  
  public void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= v> [CS Send] Id[");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append("],call receive");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 1, null, 2, null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9004L, "", 0L, 0L, this.s, "", "", this.aa, "NoNetWork", null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9004L, "", 0L, 0L, this.s, "", "", this.ad, "NoNetWork", null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= v>! [CS Send] Id[");
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append("],no network!");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (FileUtil.b(this.B.getFilePath()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= v>! [CS Send] Id[");
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append("],file exists!!");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      u();
      return;
    }
    this.N = false;
    this.O = null;
    localObject = this.i;
    if ((localObject != null) && (((String)localObject).length() != 0)) {
      if (this.g == 3000)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("=_= v> [CS Send] Id[");
        ((StringBuilder)localObject).append(this.r);
        ((StringBuilder)localObject).append("],Send getDiscFileInfo CS！");
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
    }
    try
    {
      this.a.getFileTransferHandler().a(this.B.nSessionId, this.B.fileName, Long.parseLong(this.B.peerUin), this.B.Uuid, this.Z);
      return;
    }
    catch (Exception localException)
    {
      label452:
      boolean bool;
      break label452;
    }
    a(null, 0);
    return;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= v> [CS Send] Id[");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append("],Send getDownloadInfo CS！");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    bool = ((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.a);
    this.a.getFileTransferHandler().a(this.i, this.B.fileIdCrc, this.B.bSend, bool, this.Z);
    return;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= v> [CS Send] Id[");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append("],uuid is null! : ");
    ((StringBuilder)localObject).append(FileManagerUtil.c(this.B));
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    e();
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    int i1;
    label394:
    label399:
    synchronized (this.p)
    {
      Bundle localBundle = new Bundle();
      int i2 = 0;
      Object localObject1;
      String str;
      try
      {
        boolean bool = a(paramHttpMsg1);
        if (bool) {
          return;
        }
        if (this.n == 0) {
          break label378;
        }
        localBundle.putInt("param_V6SelectType", this.J);
        localBundle.putInt("param_ipAddrType", y());
        if (!this.N) {
          break label394;
        }
        i1 = 1;
        localBundle.putInt("param_ishttps", i1);
        bool = a(paramHttpMsg2, localBundle);
        if (!bool) {
          break label378;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, localException.toString());
        localObject1 = localException.getStackTrace();
        int i3 = localObject1.length;
        str = "";
        i1 = i2;
        while (i1 < i3)
        {
          Object localObject2 = localObject1[i1];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(localObject2);
          localStringBuilder.append("&");
          str = localStringBuilder.toString();
          i1 += 1;
        }
        localObject1 = "";
        if (paramHttpMsg1 != null) {
          localObject1 = paramHttpMsg1.getRealUrl();
        }
        if (paramHttpMsg2 == null) {
          break label399;
        }
      }
      paramHttpMsg1 = paramHttpMsg2.rawRespHeader;
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9001L, null, this.Q, this.o, this.s, (String)localObject1, paramHttpMsg1, this.ad, str, null, localBundle);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9001L, null, this.Q, this.o, this.s, (String)localObject1, paramHttpMsg1, this.ad, str, null, localBundle);
      handleError(null, null);
      label378:
      return;
    }
  }
  
  public void e()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("=_= v>!!!! [Http Downlaod] Id[");
    ((StringBuilder)localObject1).append(this.r);
    ((StringBuilder)localObject1).append("],is oldMsg?");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = Boolean.valueOf(true);
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, (String)localObject2);
    if (a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("=_= v>! [Http Downlaod] Id[");
      ((StringBuilder)localObject1).append(this.r);
      ((StringBuilder)localObject1).append("],no network");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    if (!TextUtils.isEmpty(this.B.strServerPath)) {
      this.h = this.B.strServerPath;
    }
    if (TextUtils.isEmpty(this.h))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id[");
      ((StringBuilder)localObject2).append(String.valueOf(this.r));
      ((StringBuilder)localObject2).append("] get old offlinefile info is error! serverPath is empty");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      if (FileUtil.b(this.B.getFilePath()))
      {
        this.B.setCloudType(3);
        this.B.status = 1;
        this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 11, new Object[] { this.c, Long.valueOf(this.s), localObject1, this.h }, 0, null);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("=_= v> [Http Downlaod] Id[");
        ((StringBuilder)localObject1).append(this.r);
        ((StringBuilder)localObject1).append("], filee Exists");
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      this.B.status = 16;
      a(2005);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 12, null, 6, null);
      int i1 = 9020;
      if (this.B.nWeiYunSrcType == -1) {
        i1 = 9080;
      } else if (this.B.nWeiYunSrcType == -2) {
        i1 = 9081;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("=_= v! [Http Downlaod] Id[");
      ((StringBuilder)localObject1).append(this.r);
      ((StringBuilder)localObject1).append("], errCode[");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append(".tmp");
    this.e = ((StringBuilder)localObject2).toString();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("=_= v! [Http Downlaod] Id[");
      ((StringBuilder)localObject1).append(this.r);
      ((StringBuilder)localObject1).append("], no network");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      a(2005);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 1, null, 2, null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9004L, "", 0L, 0L, this.s, "", "", this.aa, "NoNetWork", null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9004L, "", 0L, 0L, this.s, "", "", this.ad, "NoNetWork", null);
      return;
    }
    this.o = FileManagerUtil.h(this.e);
    long l1 = this.o;
    long l2 = this.s;
    if (l1 == l2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("=_= v! [Http Downlaod] Id[");
      ((StringBuilder)localObject2).append(this.r);
      ((StringBuilder)localObject2).append("], id downloaded");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      this.B.setCloudType(3);
      a(2003);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 11, new Object[] { this.c, Long.valueOf(this.s), localObject1, this.h }, 0, null);
      this.B.fileName = FileManagerUtil.a(this.c);
      if (this.B.fileName.getBytes().length > 250)
      {
        localObject1 = this.B;
        ((FileManagerEntity)localObject1).fileName = FileManagerUtil.j(((FileManagerEntity)localObject1).fileName);
        this.c = a(this.f, this.B.fileName);
      }
      if (FileUtils.fileExists(this.c)) {
        this.c = FileManagerUtil.b(this.c);
      }
      FileManagerUtil.a(new File(this.e), new File(this.c));
      this.B.fileName = FileManagerUtil.a(this.c);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, 0L, this.h, this.f, this.i, this.B.strFileMd5, 0L, 0L, this.s, this.aa, null);
      return;
    }
    if (l2 > l1)
    {
      l2 -= l1;
      if (SystemUtil.a()) {
        l1 = SystemUtil.b();
      } else {
        l1 = SystemUtil.c();
      }
      l1 *= 1024L;
      if (l1 < l2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("=_= v! [Http Downlaod]Id[");
        ((StringBuilder)localObject1).append(String.valueOf(this.r));
        ((StringBuilder)localObject1).append("]local sdcard space no enough!! [downsize:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("mobile space:");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append("]");
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
        a(2005);
        this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 12, null, 12, null);
        FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9040L, "", this.Q, this.o, this.s, this.ae, "", this.aa, "sdcard full", null);
        FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9040L, "", this.Q, this.o, this.s, this.ae, "", this.ad, "sdcard full", null);
        return;
      }
    }
    if (this.u == null) {}
    try
    {
      this.u = new FileOutputStream(this.e, true);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      label1431:
      FileManagerEntity localFileManagerEntity;
      break label1431;
    }
    if (this.n == 1) {
      this.a.getFileManagerDataCenter().a(this.r, 2002);
    }
    this.B.status = 0;
    this.a.getFileManagerDataCenter().c(this.B);
    localFileManagerEntity = this.B;
    localFileManagerEntity.status = 2;
    localObject2 = null;
    localObject1 = localObject2;
    if (localFileManagerEntity.isZipInnerFile)
    {
      localObject1 = localObject2;
      if (this.B.WeiYunFileId != null) {
        localObject1 = this.B.WeiYunFileId;
      }
    }
    if ((this.B.isZipInnerFile) && (this.h.toLowerCase().startsWith("https")))
    {
      this.N = true;
      this.O = this.B.httpsDomain;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("=_= v>ReceiveOfflineForOldMsg Id[");
    ((StringBuilder)localObject2).append(this.r);
    ((StringBuilder)localObject2).append("], mUseHttps:");
    ((StringBuilder)localObject2).append(this.N);
    ((StringBuilder)localObject2).append(" mHttpsDomain:");
    ((StringBuilder)localObject2).append(this.O);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    a(this.o, (String)localObject1);
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 112	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:A	Z
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_0
    //   10: getfield 1552	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:z	Ljava/lang/Runnable;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +10 -> 25
    //   18: aload_1
    //   19: bipush 64
    //   21: invokestatic 1556	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   24: pop
    //   25: aload_0
    //   26: getfield 108	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:v	Ljava/io/InputStream;
    //   29: invokevirtual 1557	java/io/InputStream:close	()V
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 108	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:v	Ljava/io/InputStream;
    //   37: aload_0
    //   38: getfield 120	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:F	Lcom/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +7 -> 50
    //   46: aload_1
    //   47: invokevirtual 767	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileHttpUploder:a	()V
    //   50: aload_0
    //   51: getfield 719	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:m	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   54: ifnull +110 -> 164
    //   57: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +73 -> 133
    //   63: new 244	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   70: astore_1
    //   71: aload_1
    //   72: ldc_w 295
    //   75: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_1
    //   80: aload_0
    //   81: getfield 100	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:r	J
    //   84: invokestatic 260	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   87: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: ldc_w 1217
    //   95: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_1
    //   100: aload_0
    //   101: getfield 719	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:m	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   104: invokevirtual 855	com/tencent/mobileqq/utils/httputils/HttpMsg:getSerial	()I
    //   107: invokestatic 666	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   110: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_1
    //   115: ldc_w 279
    //   118: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc_w 281
    //   125: iconst_2
    //   126: aload_1
    //   127: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_0
    //   134: getfield 221	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   137: ldc_w 701
    //   140: ldc_w 703
    //   143: invokevirtual 707	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   146: checkcast 701	com/tencent/mobileqq/transfile/api/IHttpEngineService
    //   149: invokeinterface 711 1 0
    //   154: checkcast 713	com/tencent/mobileqq/transfile/HttpCommunicator
    //   157: aload_0
    //   158: getfield 719	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:m	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   161: invokevirtual 1221	com/tencent/mobileqq/transfile/HttpCommunicator:cancelMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   164: aload_0
    //   165: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:U	Lcom/tencent/mobileqq/filemanageraux/core/WeiyunTask;
    //   168: ifnull +63 -> 231
    //   171: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +50 -> 224
    //   177: new 244	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   184: astore_1
    //   185: aload_1
    //   186: ldc_w 295
    //   189: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: aload_0
    //   195: getfield 100	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:r	J
    //   198: invokestatic 260	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   201: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_1
    //   206: ldc_w 1559
    //   209: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: ldc_w 281
    //   216: iconst_2
    //   217: aload_1
    //   218: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_0
    //   225: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:U	Lcom/tencent/mobileqq/filemanageraux/core/WeiyunTask;
    //   228: invokevirtual 1560	com/tencent/mobileqq/filemanageraux/core/WeiyunTask:a	()V
    //   231: return
    //   232: astore_1
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    //   237: astore_1
    //   238: goto -201 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	FileManagerRSWorker
    //   13	205	1	localObject1	Object
    //   232	4	1	localObject2	Object
    //   237	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	232	finally
    //   233	235	232	finally
    //   25	37	237	java/lang/Exception
  }
  
  public String g()
  {
    Object localObject1 = this.I.getDefaultRecvPath();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Id[");
    ((StringBuilder)localObject2).append(String.valueOf(this.r));
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
      ((StringBuilder)localObject1).append(this.r);
      ((StringBuilder)localObject1).append("]getRecvDir[");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    this.d = this.I.getDefaultTmpPath();
    localObject1 = new File(this.d);
    boolean bool1 = bool2;
    if (!((File)localObject1).exists()) {
      bool1 = ((File)localObject1).mkdirs();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("id[");
      ((StringBuilder)localObject1).append(this.r);
      ((StringBuilder)localObject1).append("]getTmpDir[");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    return this.d;
  }
  
  public int h()
  {
    return this.af;
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
    if (this.m == null)
    {
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, but curRequest is null");
      return;
    }
    paramString = this.a;
    long l1 = this.B.nSessionId;
    localObject = this.K;
    long l2 = this.C;
    String str1 = this.ae;
    String str2 = this.f;
    String str3 = this.i;
    String str4 = this.B.strFileMd5;
    int i1 = this.m.getSerial();
    long l3 = this.Q;
    long l4 = this.o;
    long l5 = this.s;
    String str5 = this.m.getRealUrl();
    String str6 = this.m.rawRespHeader;
    int i2 = this.ad;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.m.getErrorString());
    localStringBuilder.append("&UrlOver&handleRedirect");
    FileManagerUtil.a(paramString, l1, (String)localObject, l2, str1, str2, str3, str4, 9004L, String.valueOf(i1), l3, l4, l5, str5, str6, i2, localStringBuilder.toString(), null);
    a(null, 0);
  }
  
  public int i()
  {
    long l1 = this.s;
    if (l1 <= 0L) {
      return 0;
    }
    return (int)(this.o * 100L / l1);
  }
  
  public void j()
  {
    f();
  }
  
  public void k()
  {
    try
    {
      this.v.close();
      this.v = null;
      label12:
      a(0);
      return;
    }
    catch (Exception localException)
    {
      break label12;
    }
  }
  
  public void l()
  {
    f();
    Object localObject = this.B;
    if ((localObject != null) && (((FileManagerEntity)localObject).status == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Id[");
        ((StringBuilder)localObject).append(String.valueOf(this.r));
        ((StringBuilder)localObject).append("] is Successed, return!");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if ((this.n == 0) && (this.B != null))
    {
      a(1004);
    }
    else if ((1 == this.n) && (this.B != null))
    {
      a(2004);
    }
    else
    {
      if (5 == this.n)
      {
        localObject = this.U;
        if (localObject != null)
        {
          ((WeiyunTask)localObject).a();
          break label195;
        }
      }
      if (6 == this.n)
      {
        localObject = this.U;
        if (localObject != null)
        {
          ((WeiyunTask)localObject).a();
          break label195;
        }
      }
      if (50 == this.n)
      {
        localObject = this.U;
        if (localObject != null) {
          ((WeiyunTask)localObject).a();
        }
      }
    }
    label195:
    localObject = this.B;
    if (localObject != null)
    {
      ((FileManagerEntity)localObject).status = 3;
      ((FileManagerEntity)localObject).fProgress = ((float)this.o / (float)((FileManagerEntity)localObject).fileSize);
      this.a.getFileManagerDataCenter().c(this.B);
      this.a.getFileManagerNotifyCenter().a(true, 3, null);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Id[");
        ((StringBuilder)localObject).append(String.valueOf(this.r));
        ((StringBuilder)localObject).append("]stop for pause!");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      long l1 = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Now[");
      ((StringBuilder)localObject).append(String.valueOf(l1));
      ((StringBuilder)localObject).append("]startTime[");
      ((StringBuilder)localObject).append(String.valueOf(this.C));
      ((StringBuilder)localObject).append("]notifyTime[");
      ((StringBuilder)localObject).append(String.valueOf(this.y));
      ((StringBuilder)localObject).append("]C2CTime[");
      ((StringBuilder)localObject).append(String.valueOf(this.R));
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9037L, "", this.Q, this.o, this.s, this.ae, "", this.aa, (String)localObject, null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9037L, "", this.Q, this.o, this.s, this.ae, "", this.ad, (String)localObject, null);
    }
  }
  
  public void m()
  {
    try
    {
      this.A = false;
      this.z = new FileManagerRSWorker.8(this);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Run RSWorker");
        localStringBuilder.append(MessageCache.c());
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
      }
      QQFileManagerUtil.FileExecutor.a().execute(this.z);
      if ((this.n == 0) && (this.B.fileSize > 104857600L)) {
        x();
      }
      return;
    }
    finally {}
  }
  
  protected void n()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject = this.B;
      ((FileManagerEntity)localObject).status = 0;
      ((FileManagerEntity)localObject).isReaded = false;
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.a.getFileManagerDataCenter().a();
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, "", "", "", "", 9004L, "", 0L, 0L, this.B.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.s - this.o;
    long l1;
    if (SystemUtil.a()) {
      l1 = SystemUtil.b();
    } else {
      l1 = SystemUtil.c();
    }
    l1 *= 1024L;
    if (l1 < l2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append("]downLoadWeiYunFile local space no enough!! [downsize:");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("sdcardsize:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      localObject = this.B;
      ((FileManagerEntity)localObject).status = 0;
      ((FileManagerEntity)localObject).isReaded = false;
      this.a.getFileManagerDataCenter().a();
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 36, null, 12, null);
      localObject = this.a;
      l1 = this.B.nSessionId;
      String str = this.K;
      l2 = this.C;
      long l3 = this.o;
      FileManagerUtil.a((QQAppInterface)localObject, l1, str, l2, "", "", "", "", 9040L, "", l3, l3, this.B.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    Object localObject = this.B;
    this.s = ((FileManagerEntity)localObject).fileSize;
    this.U = this.a.getFileManagerEngine().d().a((FileManagerEntity)localObject, null, new FileManagerRSWorker.9(this));
    localObject = this.U;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create download task is fail! nSessionId[");
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append("]fileid[");
      ((StringBuilder)localObject).append(this.B.WeiYunFileId);
      ((StringBuilder)localObject).append("] filename[");
      ((StringBuilder)localObject).append(this.B.fileName);
      ((StringBuilder)localObject).append("] filesize[");
      ((StringBuilder)localObject).append(this.B.fileSize);
      ((StringBuilder)localObject).append("] modifytime[");
      ((StringBuilder)localObject).append(this.B.lastTime);
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 36, null, 11, null);
      return;
    }
    ((WeiyunTask)localObject).a(this.B.WeiYunFileId);
  }
  
  protected void o()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject = this.B;
      ((FileManagerEntity)localObject).status = 0;
      ((FileManagerEntity)localObject).isReaded = false;
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 38, null, 11, null);
      this.a.getFileManagerDataCenter().a();
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, 0L, "", "", "", "", 9004L, "", 0L, 0L, this.B.fileSize, "", "", 0, "no network", null);
      return;
    }
    this.B.status = 0;
    this.a.getFileManagerDataCenter().c(this.B);
    Object localObject = this.B;
    ((FileManagerEntity)localObject).status = 2;
    this.s = ((FileManagerEntity)localObject).fileSize;
    this.U = this.a.getFileManagerEngine().d().a(this.B.getFilePath(), null, new FileManagerRSWorker.11(this));
    if (this.U == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create upload task is fail! nSessionId[");
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append("] filePath[");
      ((StringBuilder)localObject).append(this.B.getFilePath());
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 38, null, 11, null);
    }
  }
  
  public String p()
  {
    return this.B.WeiYunFileId;
  }
  
  public FileManagerEntity q()
  {
    return this.B;
  }
  
  void r()
  {
    this.W = System.currentTimeMillis();
    this.B.setCloudType(3);
    Object localObject = this.B;
    ((FileManagerEntity)localObject).bOnceSuccess = true;
    ((FileManagerEntity)localObject).lastSuccessTime = MessageCache.c();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^> [Http upload]Id[");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append("] update successTime[");
    ((StringBuilder)localObject).append(this.B.lastSuccessTime);
    ((StringBuilder)localObject).append("]");
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    a(1003);
    this.B.status = 1;
    this.a.getFileManagerDataCenter().c(this.B);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^> [Http upload] SendFileSuccess, SessionId[");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append("], FileSize[");
    ((StringBuilder)localObject).append(this.s);
    ((StringBuilder)localObject).append("], Uuid[");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("]");
    QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 14, new Object[] { this.c, Long.valueOf(this.s), Boolean.valueOf(true), this.h }, 0, null);
    if ((this.B.Uuid == null) || (this.B.Uuid.length() == 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^! [Http upload] uuid is null Entity[");
      ((StringBuilder)localObject).append(FileManagerUtil.c(this.B));
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    this.R = System.currentTimeMillis();
    this.D = System.currentTimeMillis();
    localObject = this.a.getFileTransferHandler();
    FileManagerEntity localFileManagerEntity = this.B;
    ((FileTransferHandler)localObject).a(localFileManagerEntity, this.b, this.f, localFileManagerEntity.Uuid, this.Z);
  }
  
  boolean s()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step],send LocalFile");
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 1, null, 2, null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9004L, "", 0L, 0L, this.s, "", "", this.aa, "NoNetWork", null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9004L, "", 0L, 0L, this.s, "", "", this.ad, "NoNetWork", null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], no network!");
      return false;
    }
    this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 13, null, 0, null);
    if (this.n == 0) {
      this.a.getFileManagerDataCenter().a(this.r, 1002);
    }
    this.B.status = 0;
    this.a.getFileManagerDataCenter().c(this.B);
    Object localObject1 = this.B;
    ((FileManagerEntity)localObject1).status = 2;
    ((FileManagerEntity)localObject1).fProgress = 0.0F;
    if (this.c == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendLocalFile, SessionId[");
        ((StringBuilder)localObject1).append(this.r);
        ((StringBuilder)localObject1).append("], strFilePath is null");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
      }
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9005L, null, this.Q, this.o, this.s, "", "", this.ad, FileManagerUtil.d(), null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9005L, null, this.Q, this.o, this.s, "", "", this.ad, FileManagerUtil.d(), null);
      handleError(null, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], Filepath is null!");
      return false;
    }
    localObject1 = this.h;
    if ((localObject1 != null) && (((String)localObject1).length() != 0))
    {
      localObject1 = this.h;
      this.ae = ((String)localObject1);
      this.Y = new HttpUrlProcessor(this.a, (String)localObject1);
      localObject1 = this.Y.b();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.h = ((String)localObject1);
        this.B.strServerPath = this.h;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step], server Path is not empty, Goto [Upload Step]!");
        this.x = 131072L;
        this.Q = 0L;
        a(this.h, 0L);
        return true;
      }
    }
    this.l = FileManagerUtil.a(this.c, this.s);
    if (this.l == null)
    {
      a(0);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 2, null, 5, null);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("=_= ^! [CS Step], SessionId[");
        ((StringBuilder)localObject1).append(this.r);
        ((StringBuilder)localObject1).append("], getMd5 failed");
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      }
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9041L, "", this.Q, this.o, this.s, this.ae, "", this.aa, "getfile md5 error", null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9041L, "", this.Q, this.o, this.s, this.ae, "", this.ad, "getfile md5 error", null);
      return true;
    }
    try
    {
      localObject1 = FileManagerUtil.a(this.c).getBytes("utf-8");
      byte[] arrayOfByte = this.c.getBytes("utf-8");
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("=_= ^> sendLocalFile, SessionId[");
        ((StringBuilder)localObject2).append(this.r);
        ((StringBuilder)localObject2).append("], serverPath is null, so get upload info");
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.B.tmpSessionType > 0L)
      {
        localObject2 = this.B;
        ((FileManagerEntity)localObject2).tmpSessionSig = FileManagerUtil.a(this.a, ((FileManagerEntity)localObject2).peerUin, (int)this.B.tmpSessionType);
      }
      a(this.f, arrayOfByte, (byte[])localObject1, this.s, this.l, this.Z, this.B);
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("=_= ^! [CS Step], SessionId[");
      localStringBuilder.append(this.r);
      localStringBuilder.append("], getFilePath failed");
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, localStringBuilder.toString());
      a(0);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.K, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9005L, null, this.Q, this.o, this.s, "", "", this.ad, FileManagerUtil.d(), null);
      FileManagerUtil.a(this.a, this.B.nSessionId, this.L, this.C, this.ae, this.f, this.i, this.B.strFileMd5, 9005L, null, this.Q, this.o, this.s, "", "", this.ad, FileManagerUtil.d(), null);
      this.a.getFileManagerNotifyCenter().a(this.q, this.r, this.f, this.g, 15, null, 5, null);
    }
    return false;
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if ((5 == paramInt) && (this.n != 0) && (this.o < this.s))
    {
      if (QLog.isColorLevel())
      {
        paramHttpMsg1 = new StringBuilder();
        paramHttpMsg1.append("nSessionID[");
        paramHttpMsg1.append(String.valueOf(this.r));
        paramHttpMsg1.append("] HttpCommunicator.status = STATUS_END . but data no recv completed. recvData=");
        paramHttpMsg1.append(this.o);
        paramHttpMsg1.append(" filesize=");
        paramHttpMsg1.append(this.s);
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, paramHttpMsg1.toString());
      }
      paramHttpMsg1 = this.a;
      long l1 = this.r;
      String str1 = this.L;
      long l2 = this.C;
      String str2 = this.h;
      String str3 = this.f;
      String str4 = this.i;
      String str5 = this.B.strFileMd5;
      long l3 = this.Q;
      long l4 = this.o;
      long l5 = this.s;
      String str6 = paramHttpMsg2.getRealUrl();
      paramHttpMsg2 = paramHttpMsg2.rawRespHeader;
      paramInt = this.ad;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("statusChanged mtransferedSize[");
      localStringBuilder.append(String.valueOf(this.o));
      localStringBuilder.append("]nFileSize[");
      localStringBuilder.append(String.valueOf(this.s));
      localStringBuilder.append("]");
      FileManagerUtil.a(paramHttpMsg1, l1, str1, l2, str2, str3, str4, str5, -9527L, "", l3, l4, l5, str6, paramHttpMsg2, paramInt, localStringBuilder.toString(), null);
      u();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker
 * JD-Core Version:    0.7.0.1
 */