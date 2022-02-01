package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.QQShortVideoQuicNetProcessor;
import com.tencent.mobileqq.config.business.QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.quic.open.IQuicEngine;
import com.tencent.mobileqq.transfile.quic.open.QuicEngineFactory;
import com.tencent.mobileqq.transfile.quic.open.QuicReq.Builder;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoDownloadProcessor
  extends BaseDownloadProcessor
  implements NetFailedListener
{
  public static final String TAG = "ShortVideoDownloadProcessor";
  static HashSet<String> runningTasks = new HashSet();
  private String fileMd5 = "";
  private String mFileId;
  protected boolean mIpListEmptyResp;
  protected boolean mIsQuicEncryption;
  protected ShortVideoDownloadProcessor.QuicDownloadListener mQuicDownloadListener;
  protected int mQuicFec;
  protected QuicNetReport mQuicNetReport;
  int mRedirectCount = 0;
  long mRedirectTime = 0L;
  int mReportBusiType = -1;
  protected boolean mSupportQuic;
  private String mTaskKey;
  private int videoTime;
  
  public ShortVideoDownloadProcessor() {}
  
  public ShortVideoDownloadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    paramTransFileControllerImpl = paramTransferRequest.mLocalPath;
    if (paramTransFileControllerImpl != null)
    {
      String[] arrayOfString = paramTransFileControllerImpl.split("QQ_&_MoblieQQ_&_QQ");
      if (arrayOfString.length < 3)
      {
        if (QLog.isColorLevel())
        {
          paramTransferRequest = new StringBuilder();
          paramTransferRequest.append("path was not set correctlly------path = ");
          paramTransferRequest.append(paramTransFileControllerImpl);
          QLog.d("ShortVideoDownloadProcessor", 2, paramTransferRequest.toString());
        }
        throw new IllegalArgumentException("path was not set correctlly.");
      }
      paramTransferRequest.mOutFilePath = arrayOfString[0];
      this.mFileId = arrayOfString[1];
      paramTransFileControllerImpl = new StringBuilder();
      paramTransFileControllerImpl.append(this.mFileId);
      paramTransFileControllerImpl.append(paramTransferRequest.mFileType);
      paramTransFileControllerImpl.append(paramTransferRequest.mUniseq);
      this.mTaskKey = paramTransFileControllerImpl.toString();
      if (arrayOfString.length > 3) {
        this.videoTime = Integer.parseInt(arrayOfString[3]);
      }
    }
  }
  
  private void handleReqErr(RichProto.RichProtoResp.ShortVideoDownResp paramShortVideoDownResp)
  {
    if ((!paramShortVideoDownResp.isAllowRetry) && (this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo)))
    {
      ((MessageForShortVideo)this.mUiRequest.mRec).isAllowAutoDown = false;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()-- server return not allow auto retry");
      }
    }
    if (-5100026 == this.mProcessorReport.errCode)
    {
      if (QLog.isColorLevel())
      {
        paramShortVideoDownResp = new StringBuilder();
        paramShortVideoDownResp.append("onBusiProtoResp()---- 安全打击mUiRequest.mMd5:");
        paramShortVideoDownResp.append(this.mUiRequest.mMd5);
        QLog.d("ShortVideoDownloadProcessor", 2, paramShortVideoDownResp.toString());
      }
      paramShortVideoDownResp = this.mProcessorReport;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("安全打击mUiRequest.mMd5:");
      localStringBuilder.append(this.mUiRequest.mMd5);
      paramShortVideoDownResp.setError(-5100026, localStringBuilder.toString(), null, null);
    }
    else if ((-9527 == this.mProcessorReport.errCode) && ((this.mProcessorReport.errDesc.equals("H_400_-5103017")) || (this.mProcessorReport.errDesc.equals("H_400_-5103059"))))
    {
      if (QLog.isColorLevel())
      {
        paramShortVideoDownResp = new StringBuilder();
        paramShortVideoDownResp.append("onBusiProtoResp()---- 视频文件过期errCode=");
        paramShortVideoDownResp.append(this.mProcessorReport.errCode);
        QLog.d("ShortVideoDownloadProcessor", 2, paramShortVideoDownResp.toString());
      }
      this.mProcessorReport.setError(this.mProcessorReport.errCode, HardCodeUtil.a(2131911480), null, null);
    }
    else if (-5100528 == this.mProcessorReport.errCode)
    {
      if (QLog.isColorLevel())
      {
        paramShortVideoDownResp = new StringBuilder();
        paramShortVideoDownResp.append("onBusiProtoResp()---- 后台不允许自动下载, errCode = ");
        paramShortVideoDownResp.append(this.mProcessorReport.errCode);
        QLog.d("ShortVideoDownloadProcessor", 2, paramShortVideoDownResp.toString());
      }
      this.mProcessorReport.setError(-5100528, HardCodeUtil.a(2131911485), null, null);
    }
    else
    {
      this.mProcessorReport.setError(9045, HardCodeUtil.a(2131911487), null, null);
    }
    onError();
  }
  
  private void handleReqSuc(RichProto.RichProtoResp.ShortVideoDownResp paramShortVideoDownResp)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBusiProtoResp() cdn ---- mIpListSize:");
      ((StringBuilder)localObject).append(this.mIpList);
      if (((StringBuilder)localObject).toString() == null)
      {
        localObject = Integer.valueOf(0);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.mIpList.size());
        ((StringBuilder)localObject).append(" mHostType:");
        ((StringBuilder)localObject).append(paramShortVideoDownResp.mHostType);
        ((StringBuilder)localObject).append(" domain:");
        ((StringBuilder)localObject).append(paramShortVideoDownResp.mDomain);
        ((StringBuilder)localObject).append(" url:");
        ((StringBuilder)localObject).append(paramShortVideoDownResp.mUrl);
        localObject = ((StringBuilder)localObject).toString();
      }
      QLog.d("ShortVideoDownloadProcessor", 2, new Object[] { localObject });
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBusiProtoResp() cdn ---- mUiRequest.mMd5:");
      ((StringBuilder)localObject).append(this.mUiRequest.mMd5);
      ((StringBuilder)localObject).append(" ---- downResp.md5:");
      ((StringBuilder)localObject).append(HexUtil.bytes2HexStr(paramShortVideoDownResp.md5));
      QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    this.mRespUrl = paramShortVideoDownResp.mUrl;
    this.mSupportQuic = paramShortVideoDownResp.mIsSupportQuic;
    this.mIsQuicEncryption = paramShortVideoDownResp.mIsQuicEncryption;
    this.mQuicFec = paramShortVideoDownResp.mQuicFec;
    receiveFile(paramShortVideoDownResp.mIsHttps);
  }
  
  private void setBusiType(RichProto.RichProtoReq.ShortVideoDownReq paramShortVideoDownReq)
  {
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo))) {
      paramShortVideoDownReq.busiType = ((MessageForShortVideo)this.mUiRequest.mRec).busiType;
    } else if (1008 == paramShortVideoDownReq.uinType) {
      paramShortVideoDownReq.busiType = this.mUiRequest.mBusiType;
    } else {
      paramShortVideoDownReq.busiType = 0;
    }
    this.mReportBusiType = paramShortVideoDownReq.busiType;
    paramShortVideoDownReq.subBusiType = 0;
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo)))
    {
      if (((MessageForShortVideo)this.mUiRequest.mRec).subBusiType == 1) {
        paramShortVideoDownReq.subBusiType = 1;
      }
      if (paramShortVideoDownReq.uinType == 10014) {
        paramShortVideoDownReq.subBusiType = ((MessageForShortVideo)this.mUiRequest.mRec).subBusiType;
      }
    }
  }
  
  private void setChatType(RichProto.RichProtoReq.ShortVideoDownReq paramShortVideoDownReq)
  {
    if (paramShortVideoDownReq.uinType == 0)
    {
      paramShortVideoDownReq.chatType = 0;
      return;
    }
    if (1 == paramShortVideoDownReq.uinType)
    {
      paramShortVideoDownReq.chatType = 1;
      return;
    }
    if (3000 == paramShortVideoDownReq.uinType)
    {
      paramShortVideoDownReq.chatType = 2;
      return;
    }
    if (10014 == paramShortVideoDownReq.uinType)
    {
      paramShortVideoDownReq.chatType = 4;
      return;
    }
    paramShortVideoDownReq.chatType = 3;
  }
  
  private void setFileType(RichProto.RichProtoReq.ShortVideoDownReq paramShortVideoDownReq)
  {
    if ((this.mUiRequest.mFileType != 7) && (this.mUiRequest.mFileType != 16) && (this.mUiRequest.mFileType != 18) && (this.mUiRequest.mFileType != 68))
    {
      if ((this.mUiRequest.mFileType == 6) || (this.mUiRequest.mFileType == 9) || (this.mUiRequest.mFileType == 17) || (this.mUiRequest.mFileType == 67)) {
        paramShortVideoDownReq.fileType = 2;
      }
    }
    else {
      paramShortVideoDownReq.fileType = 1;
    }
  }
  
  private void setTroopUin(RichProto.RichProtoReq.ShortVideoDownReq paramShortVideoDownReq)
  {
    if ((paramShortVideoDownReq.uinType != 0) && (1008 != paramShortVideoDownReq.uinType))
    {
      if (((this.mUiRequest.mRec instanceof MessageForShortVideo)) && (10014 == this.mUiRequest.mUinType))
      {
        paramShortVideoDownReq.troopUin = String.valueOf(((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(this.mUiRequest.mRec));
        return;
      }
      paramShortVideoDownReq.troopUin = this.mUiRequest.mPeerUin;
      return;
    }
    paramShortVideoDownReq.troopUin = null;
  }
  
  public int cancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "cancel()");
    }
    runningTasks.remove(this.mTaskKey);
    ShortVideoDownloadProcessor.QuicDownloadListener localQuicDownloadListener = this.mQuicDownloadListener;
    if (localQuicDownloadListener != null)
    {
      localQuicDownloadListener.cancel.set(true);
      this.mQuicDownloadListener = null;
    }
    return super.cancel();
  }
  
  public int checkParam()
  {
    if ((this.mUiRequest != null) && (this.mUiRequest.mOutFilePath != null))
    {
      if ((this.mUiRequest != null) && (this.mUiRequest.mRec != null) && (((MessageForShortVideo)this.mUiRequest.mRec).busiType == 0)) {
        this.mIsShortVideoReceive = true;
      }
      return 0;
    }
    this.mProcessorReport.setError(9302, HardCodeUtil.a(2131911457), null, null);
    onError();
    return -1;
  }
  
  /* Error */
  public void checkVideoMD5()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 137	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   4: getfield 163	com/tencent/mobileqq/transfile/TransferRequest:mMd5	Ljava/lang/String;
    //   7: astore 9
    //   9: aload 9
    //   11: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: istore 5
    //   16: iconst_1
    //   17: istore 4
    //   19: iconst_1
    //   20: istore_2
    //   21: iconst_1
    //   22: istore_3
    //   23: iload 5
    //   25: ifne +363 -> 388
    //   28: aload_0
    //   29: getfield 137	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   32: getfield 102	com/tencent/mobileqq/transfile/TransferRequest:mOutFilePath	Ljava/lang/String;
    //   35: astore 6
    //   37: aconst_null
    //   38: astore 8
    //   40: aconst_null
    //   41: astore 7
    //   43: new 359	java/io/FileInputStream
    //   46: dup
    //   47: aload 6
    //   49: invokespecial 360	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   52: astore 6
    //   54: aload 6
    //   56: aload 6
    //   58: invokevirtual 363	java/io/FileInputStream:available	()I
    //   61: i2l
    //   62: invokestatic 369	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   65: astore 7
    //   67: iload_3
    //   68: istore_1
    //   69: aload 7
    //   71: ifnull +152 -> 223
    //   74: aload_0
    //   75: aload 7
    //   77: invokestatic 251	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   80: putfield 46	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:fileMd5	Ljava/lang/String;
    //   83: iload_3
    //   84: istore_1
    //   85: aload_0
    //   86: getfield 46	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:fileMd5	Ljava/lang/String;
    //   89: aload 9
    //   91: invokevirtual 178	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   94: ifne +129 -> 223
    //   97: aload_0
    //   98: getfield 137	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   101: getfield 107	com/tencent/mobileqq/transfile/TransferRequest:mFileType	I
    //   104: bipush 6
    //   106: if_icmpeq +43 -> 149
    //   109: aload_0
    //   110: getfield 137	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   113: getfield 107	com/tencent/mobileqq/transfile/TransferRequest:mFileType	I
    //   116: bipush 9
    //   118: if_icmpeq +31 -> 149
    //   121: aload_0
    //   122: getfield 137	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   125: getfield 107	com/tencent/mobileqq/transfile/TransferRequest:mFileType	I
    //   128: bipush 17
    //   130: if_icmpeq +19 -> 149
    //   133: aload_0
    //   134: getfield 137	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   137: getfield 107	com/tencent/mobileqq/transfile/TransferRequest:mFileType	I
    //   140: istore_2
    //   141: iload_3
    //   142: istore_1
    //   143: iload_2
    //   144: bipush 67
    //   146: if_icmpne +77 -> 223
    //   149: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +59 -> 211
    //   155: new 77	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   162: astore 7
    //   164: aload 7
    //   166: ldc_w 371
    //   169: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 7
    //   175: aload 9
    //   177: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 7
    //   183: ldc_w 373
    //   186: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 7
    //   192: aload_0
    //   193: getfield 46	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:fileMd5	Ljava/lang/String;
    //   196: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: ldc 10
    //   202: iconst_2
    //   203: aload 7
    //   205: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 376	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: iconst_0
    //   212: istore_1
    //   213: goto +10 -> 223
    //   216: astore 8
    //   218: iconst_0
    //   219: istore_1
    //   220: goto +78 -> 298
    //   223: aload 6
    //   225: invokevirtual 379	java/io/FileInputStream:close	()V
    //   228: iload_1
    //   229: istore_2
    //   230: goto +158 -> 388
    //   233: astore 6
    //   235: iload_1
    //   236: istore_2
    //   237: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +148 -> 388
    //   243: ldc 10
    //   245: iconst_2
    //   246: ldc_w 381
    //   249: aload 6
    //   251: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   254: iload_1
    //   255: istore_2
    //   256: goto +132 -> 388
    //   259: astore 7
    //   261: goto +92 -> 353
    //   264: astore 8
    //   266: iload 4
    //   268: istore_1
    //   269: goto +29 -> 298
    //   272: astore 8
    //   274: aload 7
    //   276: astore 6
    //   278: aload 8
    //   280: astore 7
    //   282: goto +71 -> 353
    //   285: astore 7
    //   287: aload 8
    //   289: astore 6
    //   291: iload 4
    //   293: istore_1
    //   294: aload 7
    //   296: astore 8
    //   298: aload 6
    //   300: astore 7
    //   302: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +18 -> 323
    //   308: aload 6
    //   310: astore 7
    //   312: ldc 10
    //   314: iconst_2
    //   315: ldc_w 381
    //   318: aload 8
    //   320: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   323: iload_1
    //   324: istore_2
    //   325: aload 6
    //   327: ifnull +61 -> 388
    //   330: aload 6
    //   332: invokevirtual 379	java/io/FileInputStream:close	()V
    //   335: iload_1
    //   336: istore_2
    //   337: goto +51 -> 388
    //   340: astore 6
    //   342: iload_1
    //   343: istore_2
    //   344: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +41 -> 388
    //   350: goto -107 -> 243
    //   353: aload 6
    //   355: ifnull +30 -> 385
    //   358: aload 6
    //   360: invokevirtual 379	java/io/FileInputStream:close	()V
    //   363: goto +22 -> 385
    //   366: astore 6
    //   368: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq +14 -> 385
    //   374: ldc 10
    //   376: iconst_2
    //   377: ldc_w 381
    //   380: aload 6
    //   382: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   385: aload 7
    //   387: athrow
    //   388: aload_0
    //   389: getfield 153	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mProcessorReport	Lcom/tencent/mobileqq/transfile/report/ProcessorReport;
    //   392: getfield 388	com/tencent/mobileqq/transfile/report/ProcessorReport:mReportInfo	Ljava/util/HashMap;
    //   395: ldc_w 390
    //   398: iload_2
    //   399: invokestatic 392	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   402: invokevirtual 398	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   405: pop
    //   406: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	ShortVideoDownloadProcessor
    //   68	275	1	i	int
    //   20	379	2	j	int
    //   22	120	3	k	int
    //   17	275	4	m	int
    //   14	10	5	bool	boolean
    //   35	189	6	localObject1	Object
    //   233	17	6	localIOException1	java.io.IOException
    //   276	55	6	localObject2	Object
    //   340	19	6	localIOException2	java.io.IOException
    //   366	15	6	localIOException3	java.io.IOException
    //   41	163	7	localObject3	Object
    //   259	16	7	localObject4	Object
    //   280	1	7	localObject5	Object
    //   285	10	7	localIOException4	java.io.IOException
    //   300	86	7	localObject6	Object
    //   38	1	8	localObject7	Object
    //   216	1	8	localIOException5	java.io.IOException
    //   264	1	8	localIOException6	java.io.IOException
    //   272	16	8	localObject8	Object
    //   296	23	8	localObject9	Object
    //   7	169	9	str	String
    // Exception table:
    //   from	to	target	type
    //   149	211	216	java/io/IOException
    //   223	228	233	java/io/IOException
    //   54	67	259	finally
    //   74	83	259	finally
    //   85	141	259	finally
    //   149	211	259	finally
    //   54	67	264	java/io/IOException
    //   74	83	264	java/io/IOException
    //   85	141	264	java/io/IOException
    //   43	54	272	finally
    //   302	308	272	finally
    //   312	323	272	finally
    //   43	54	285	java/io/IOException
    //   330	335	340	java/io/IOException
    //   358	363	366	java/io/IOException
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if (this.mUiRequest.mIsOnlyGetUrl) {
      return;
    }
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return;
    }
    if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0)))
    {
      if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
        return;
      }
      Object localObject1 = this.mProcessorReport;
      int j = this.mProcessorReport.mReportedFlag;
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      ((ProcessorReport)localObject1).mReportedFlag = (j | i);
      if (this.mRedirectCount > 0)
      {
        new HashMap().put("businessType", String.valueOf(this.mUiRequest.mFileType));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actShortVideoRedirect", true, this.mRedirectTime, this.mRedirectCount, this.mProcessorReport.mReportInfo, "");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mRedirectReportInfo = ");
          ((StringBuilder)localObject1).append(this.mRedirectCount);
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(this.mRedirectTime);
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(this.mUiRequest.mFileType);
          QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportTag = ");
        ((StringBuilder)localObject1).append(getReportTAG());
        QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepUrl.getReportInfo(1));
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepTrans.getReportInfo(2));
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepMsg.getReportInfo(3));
      localObject1 = ((StringBuilder)localObject1).toString();
      this.mProcessorReport.mReportInfo.put("param_step", localObject1);
      this.mProcessorReport.mReportInfo.put("param_fromUin", this.mUiRequest.mPeerUin);
      if (this.mIpList.size() > 0) {
        this.mProcessorReport.mReportInfo.put("param_iplist", this.mIpList.toString());
      }
      this.mProcessorReport.mReportInfo.put("param_uuid", this.mFileId);
      this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.file.fileSize));
      this.mProcessorReport.mReportInfo.put("param_fileMd5", this.mUiRequest.mMd5);
      localObject1 = this.mProcessorReport.mReportInfo;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mReportBusiType);
      ((StringBuilder)localObject2).append("");
      ((HashMap)localObject1).put("param_busiType", ((StringBuilder)localObject2).toString());
      this.mProcessorReport.mReportInfo.put("param_videoDuration", String.valueOf(this.videoTime));
      this.mProcessorReport.mReportInfo.put("param_DownMode", String.valueOf(this.mUiRequest.mDownMode));
      localObject1 = this.mQuicNetReport;
      if ((localObject1 != null) && (!((QuicNetReport)localObject1).isHttpRetryed)) {
        i = 1;
      } else {
        i = 0;
      }
      HashMap localHashMap = this.mProcessorReport.mReportInfo;
      localObject2 = "1";
      if (i != 0) {
        localObject1 = "2";
      } else if (this.mIsHttpsDownload) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      localHashMap.put("param_isHttps", localObject1);
      this.mProcessorReport.mReportInfo.put("param_trans_consume", String.valueOf(this.mProcessorReport.mStepTrans.getTimeConsume()));
      localHashMap = this.mProcessorReport.mReportInfo;
      if (i != 0) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      localHashMap.put("parameter_quic", localObject1);
      localHashMap = this.mProcessorReport.mReportInfo;
      localObject1 = this.mQuicNetReport;
      if ((localObject1 != null) && (((QuicNetReport)localObject1).success)) {
        localObject1 = localObject2;
      } else {
        localObject1 = "0";
      }
      localHashMap.put("parameter_quic_status", localObject1);
      reportQuicNetState();
      if (paramBoolean)
      {
        reportForIpv6(true, l);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l, this.mTotolLen, this.mProcessorReport.mReportInfo, "");
      }
      else
      {
        if (this.mProcessorReport.errCode != -9527) {
          this.mProcessorReport.mReportInfo.remove("param_rspHeader");
        }
        this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
        if (this.mProcessorReport.errCode == -6103066)
        {
          localObject1 = this.mProcessorReport.mReportInfo;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("uierquest md5=");
          ((StringBuilder)localObject2).append(this.mUiRequest.mMd5);
          ((StringBuilder)localObject2).append("fileMd5=");
          ((StringBuilder)localObject2).append(this.fileMd5);
          ((HashMap)localObject1).put("param_picmd5", ((StringBuilder)localObject2).toString());
        }
        reportForIpv6(false, l);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l, 0L, this.mProcessorReport.mReportInfo, "");
      }
      setReportFlag();
    }
  }
  
  protected String getConnUrl(boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramBoolean) {
      localStringBuilder1.append("https://");
    } else {
      localStringBuilder1.append("http://");
    }
    if (this.mIpList.size() > 0)
    {
      localObject = (ServerAddr)this.mIpList.get(0);
      if ((((ServerAddr)localObject).isIpv6) && (!((ServerAddr)localObject).mIp.startsWith("[")))
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[");
        localStringBuilder2.append(((ServerAddr)localObject).mIp);
        localStringBuilder2.append("]");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      else
      {
        localStringBuilder1.append(((ServerAddr)localObject).mIp);
      }
      if ((((ServerAddr)localObject).port != 80) && (((ServerAddr)localObject).port != 0))
      {
        localStringBuilder1.append(":");
        localStringBuilder1.append(((ServerAddr)localObject).port);
      }
    }
    else
    {
      localStringBuilder1.append(this.mDownDomain);
    }
    localStringBuilder1.append("/");
    localStringBuilder1.append(this.mRespUrl);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cdn url = ");
    ((StringBuilder)localObject).append(localStringBuilder1.toString());
    logRichMediaEvent("getConnUrl", ((StringBuilder)localObject).toString());
    return localStringBuilder1.toString();
  }
  
  protected IQuicEngine getQuicEngine()
  {
    return QuicEngineFactory.createEngine();
  }
  
  protected String getReportTAG()
  {
    int i = this.mUiRequest.mFileType;
    String str = "actShortVideoDownloadVideo";
    if (i == 7) {
      return "actShortVideoDownloadThumb";
    }
    if (this.mUiRequest.mFileType == 6) {
      return "actShortVideoDownloadVideo";
    }
    if ((this.mUiRequest.mFileType != 16) && (this.mUiRequest.mFileType != 18))
    {
      if ((this.mUiRequest.mFileType == 9) || (this.mUiRequest.mFileType == 17))
      {
        this.mProcessorReport.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
        return "actShortVideoDiscussgroupDownloadVideo";
      }
    }
    else
    {
      this.mProcessorReport.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      str = "actShortVideoDiscussgroupDownloadThumb";
    }
    return str;
  }
  
  public void handleOnRespErr(NetResp paramNetResp)
  {
    long l;
    if (paramNetResp.mRespProperties.get("X-RtFlag") == null) {
      l = 9223372036854775807L;
    } else {
      l = Long.parseLong((String)paramNetResp.mRespProperties.get("X-RtFlag"));
    }
    this.mProcessorReport.mReportInfo.put("param_xRtFlag", String.valueOf(l));
    if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
    {
      logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
      this.mNetworkChgRetryCount += 1;
      clearReprotInfo();
      sendRequest();
      return;
    }
    String str = (String)paramNetResp.mRespProperties.get(HttpMsg.Param_Reason);
    this.mProcessorReport.setError(paramNetResp.mErrCode, paramNetResp.mErrDesc, str, this.mProcessorReport.mStepTrans);
    onError();
  }
  
  public void handleOnRespSuc(NetResp paramNetResp)
  {
    checkVideoMD5();
    onSuccess();
    RMServMonitorReport localRMServMonitorReport = this.mRSMReporter;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mReportBusiType);
    localStringBuilder.append("");
    localRMServMonitorReport.mBusiType = localStringBuilder.toString();
    this.mRSMReporter.mFileSize = this.file.fileSize;
    reportForServerMonitor(paramNetResp, true, "actRichMediaNetMonitor_videoDown", this.mFileId);
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.resps.get(i);
        logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        this.mIpList = selectIpList(paramRichProtoReq.mIpv6List, paramRichProtoReq.mIpList);
        boolean bool;
        if ((this.mIpList != null) && (!this.mIpList.isEmpty())) {
          bool = false;
        } else {
          bool = true;
        }
        this.mIpListEmptyResp = bool;
        this.mDownDomain = paramRichProtoReq.mDomain;
        if (this.isDomainTest)
        {
          this.mDownDomain = "grouptalk.c2c.qq.com";
          if (this.mIpList != null) {
            this.mIpList.clear();
          }
        }
        if (paramRichProtoReq.result == 0) {
          handleReqSuc(paramRichProtoReq);
        } else {
          handleReqErr(paramRichProtoReq);
        }
        i += 1;
      }
    }
  }
  
  void onError()
  {
    super.onError();
    runningTasks.remove(this.mTaskKey);
    this.file.errorCode = this.mProcessorReport.errCode;
    if (-5100026 == this.mProcessorReport.errCode) {
      sendMessageToUpdate(5001);
    } else if ((-9527 == this.mProcessorReport.errCode) && ((this.mProcessorReport.errDesc.equals("H_400_-5103017")) || (this.mProcessorReport.errDesc.equals("H_400_-5103059")))) {
      sendMessageToUpdate(5002);
    } else {
      sendMessageToUpdate(2005);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onError()---- errCode:");
      ((StringBuilder)localObject).append(this.mProcessorReport.errCode);
      QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onError()---- errDesc:");
      ((StringBuilder)localObject).append(this.mProcessorReport.errDesc);
      QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    if (this.mUiRequest != null) {
      localObject = this.mUiRequest.mResult;
    }
    if (localObject != null)
    {
      ((TransferResult)localObject).mResult = -1;
      ((TransferResult)localObject).mErrCode = this.mProcessorReport.errCode;
      ((TransferResult)localObject).mErrDesc = this.mProcessorReport.errDesc;
      ((TransferResult)localObject).mOrigReq = this.mUiRequest;
    }
    localObject = this.mDownCallBacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      DownCallBack localDownCallBack = (DownCallBack)((Iterator)localObject).next();
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.a = -1;
      localDownResult.b = this.mProcessorReport.errCode;
      localDownResult.c = this.mProcessorReport.errDesc;
      localDownCallBack.a(localDownResult);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideo.TAG", 2, "onError ");
      }
    }
  }
  
  public void onFailed(NetResp paramNetResp)
  {
    RMServMonitorReport localRMServMonitorReport = this.mRSMReporter;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mReportBusiType);
    localStringBuilder.append("");
    localRMServMonitorReport.mBusiType = localStringBuilder.toString();
    this.mRSMReporter.mFileSize = this.file.fileSize;
    reportForServerMonitor(paramNetResp, false, "actRichMediaNetMonitor_videoDown", this.mFileId);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("directMsgUrlDown:");
    ((StringBuilder)localObject).append(this.mDirectMsgUrlDown);
    ((StringBuilder)localObject).append(" result:");
    int i = paramNetResp.mResult;
    boolean bool2 = true;
    boolean bool1;
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject).append(bool1);
    logRichMediaEvent("onHttpResp", ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResp()---- result:");
      ((StringBuilder)localObject).append(paramNetResp.mResult);
      QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResp()---- errCode:");
      ((StringBuilder)localObject).append(paramNetResp.mErrCode);
      QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResp()---- errDesc:");
      ((StringBuilder)localObject).append(paramNetResp.mErrDesc);
      QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mDirectMsgUrlDown) {
      localObject = this.mProcessorReport.mStepDirectDown;
    } else {
      localObject = this.mProcessorReport.mStepTrans;
    }
    ProcessorReport localProcessorReport = this.mProcessorReport;
    if (paramNetResp.mResult == 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localProcessorReport.copyStaticsInfoFromNetResp((StepInfo)localObject, paramNetResp, bool1);
    this.mTotolLen = paramNetResp.mTotalFileLen;
    if (this.mTotolLen <= 0L) {
      this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
    }
    this.mRecvLen += paramNetResp.mWrittenBlockLen;
    this.mRedirectTime = paramNetResp.mRedirectTime;
    this.mRedirectCount = paramNetResp.mRedirectCount;
    if (paramNetResp.mResult == 0) {
      handleOnRespSuc(paramNetResp);
    } else {
      handleOnRespErr(paramNetResp);
    }
    this.mNetReq = null;
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "successfully downloaded.");
    }
    runningTasks.remove(this.mTaskKey);
    sendMessageToUpdate(2003);
    Object localObject = this.mUiRequest.mResult;
    if (localObject != null)
    {
      ((TransferResult)localObject).mResult = 0;
      ((TransferResult)localObject).mOrigReq = this.mUiRequest;
    }
    localObject = this.mDownCallBacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      DownCallBack localDownCallBack = (DownCallBack)((Iterator)localObject).next();
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.a = 0;
      localDownResult.e = this.mUiRequest.mOutFilePath;
      localDownResult.g = this.mUiRequest.mMd5;
      localDownResult.i = this.mUiRequest.mDownMode;
      localDownCallBack.a(localDownResult);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.mIsPause)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoDownloadProcessor", 2, "onUpdateProgeress: mIsPause=true, should not notify UI, just return!");
      }
      return;
    }
    this.file.transferedSize = paramLong1;
    this.file.fileSize = paramLong2;
    sendMessageToUpdate(2002);
    int i = (int)(paramLong1 * 10000L / paramLong2);
    paramNetReq = this.mDownCallBacks.iterator();
    while (paramNetReq.hasNext()) {
      ((DownCallBack)paramNetReq.next()).a(i, false);
    }
  }
  
  public void pause()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pause() mIsPause : ");
      ((StringBuilder)localObject).append(this.mIsPause);
      QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      sendMessageToUpdate(2004);
      if (this.mRichProtoReq != null)
      {
        RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
        this.mRichProtoReq = null;
      }
      if (this.mNetReq != null)
      {
        this.mNetEngine.cancelReq(this.mNetReq);
        this.mNetReq = null;
      }
      localObject = this.mQuicDownloadListener;
      if (localObject != null)
      {
        ((ShortVideoDownloadProcessor.QuicDownloadListener)localObject).cancel.set(true);
        this.mQuicDownloadListener = null;
      }
    }
  }
  
  protected void quicDownloadSuc(QuicNetReport paramQuicNetReport, HttpNetReq paramHttpNetReq)
  {
    if ((paramHttpNetReq != null) && (paramHttpNetReq.mCallback != null))
    {
      NetResp localNetResp = new NetResp(paramHttpNetReq);
      localNetResp.mHttpCode = paramQuicNetReport.httpStatus;
      localNetResp.mTotalFileLen = paramQuicNetReport.fileSize;
      localNetResp.reqCost = paramQuicNetReport.totaltime;
      Object localObject = paramQuicNetReport.headers.keySet();
      HashMap localHashMap = new HashMap();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localHashMap.put(str, paramQuicNetReport.headers.get(str));
      }
      localNetResp.setResult(0, paramQuicNetReport.errCode, paramQuicNetReport.errMsg, localHashMap);
      paramHttpNetReq.mCallback.onResp(localNetResp);
    }
  }
  
  void receiveFile(boolean paramBoolean)
  {
    this.mIsHttpsDownload = paramBoolean;
    this.mRSMReporter.mIsHttps = paramBoolean;
    if (TextUtils.isEmpty(this.mDownDomain)) {
      this.mDownDomain = "grouptalk.c2c.qq.com";
    }
    this.mProcessorReport.mStepTrans.logStartTime();
    String str = getConnUrl(paramBoolean);
    Object localObject1 = new HttpNetReq();
    if (!StringUtil.isEmpty(this.mDownDomain)) {
      ((HttpNetReq)localObject1).mReqProperties.put("host", this.mDownDomain);
    }
    ((HttpNetReq)localObject1).mCallback = this;
    ((HttpNetReq)localObject1).mFailedListener = this;
    ((HttpNetReq)localObject1).mReqUrl = str;
    ((HttpNetReq)localObject1).mIsHttps = paramBoolean;
    ((HttpNetReq)localObject1).mHostForHttpsVerify = this.mDownDomain;
    int i = 0;
    ((HttpNetReq)localObject1).mHttpMethod = 0;
    TransFileUtil.addDomainToList(this.mIpList, this.mDownDomain);
    ((HttpNetReq)localObject1).mServerList = this.mIpList;
    ((HttpNetReq)localObject1).mOutPath = this.mUiRequest.mOutFilePath;
    ((HttpNetReq)localObject1).mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    ((HttpNetReq)localObject1).mBusiProtoType = this.mUiRequest.mUinType;
    ((HttpNetReq)localObject1).mFileType = this.mUiRequest.mFileType;
    if ((this.mUiRequest.mFileType == 6) || (this.mUiRequest.mFileType == 9) || (this.mUiRequest.mFileType == 17) || (this.mUiRequest.mFileType == 67))
    {
      localObject2 = SharedPreUtils.v(BaseApplication.getContext());
      if ((localObject2 != null) && (((String)localObject2).length() > 0))
      {
        localObject2 = ((String)localObject2).split("\\|");
        if ((localObject2 != null) && (localObject2.length > 0)) {
          ((HttpNetReq)localObject1).mWhiteListContentType = ((String[])localObject2);
        }
      }
    }
    ((HttpNetReq)localObject1).mStartDownOffset = 0L;
    ((HttpNetReq)localObject1).mIsNetChgAsError = true;
    ((HttpNetReq)localObject1).mReqProperties.put("Accept-Encoding", "identity");
    ((HttpNetReq)localObject1).mSupportBreakResume = true;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mUiRequest.mOutFilePath);
    ((StringBuilder)localObject2).append(".");
    ((StringBuilder)localObject2).append(MD5.toMD5(this.mFileId));
    ((StringBuilder)localObject2).append(".tmp");
    ((HttpNetReq)localObject1).mTempPath = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("url:");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(",downOffset:");
    ((StringBuilder)localObject2).append(((HttpNetReq)localObject1).mStartDownOffset);
    logRichMediaEvent("httpDown", ((StringBuilder)localObject2).toString());
    if (!canDoNextStep())
    {
      runningTasks.remove(this.mTaskKey);
      return;
    }
    this.mNetReq = ((NetReq)localObject1);
    setMtype();
    ((HttpNetReq)localObject1).mNeedRedirectCallback = true;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("recieveFile mIsOnlyGetUrl ");
      ((StringBuilder)localObject2).append(this.mUiRequest.mIsOnlyGetUrl);
      ((StringBuilder)localObject2).append(" domain=");
      ((StringBuilder)localObject2).append(this.mDownDomain);
      ((StringBuilder)localObject2).append(" ipsize=");
      ((StringBuilder)localObject2).append(this.mIpList.size());
      QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.mUiRequest.mIsOnlyGetUrl)
    {
      localObject1 = new String[this.mIpList.size()];
      while (i < this.mIpList.size())
      {
        localObject2 = (ServerAddr)this.mIpList.get(i);
        StringBuffer localStringBuffer = new StringBuffer();
        if (paramBoolean) {
          localStringBuffer.append("https://");
        } else {
          localStringBuffer.append("http://");
        }
        localStringBuffer.append(((ServerAddr)localObject2).mIp);
        if (((ServerAddr)localObject2).port != 80)
        {
          localStringBuffer.append(":");
          localStringBuffer.append(((ServerAddr)localObject2).port);
        }
        localStringBuffer.append("/");
        localObject1[i] = TransFileUtil.replaceIp(str, localStringBuffer.toString());
        i += 1;
      }
      this.file.urls = ((String[])localObject1);
      this.file.domain = this.mDownDomain;
      this.file.stepUrlCost = this.mProcessorReport.mStepUrl.getTimeConsume();
      sendMessageToUpdate(2002);
      this.mController.removeProcessor(getKey());
      runningTasks.remove(this.mTaskKey);
      return;
    }
    tryUseQuicDownload((HttpNetReq)localObject1);
  }
  
  protected void reportQuicNetState()
  {
    if (this.mQuicNetReport != null)
    {
      String str = getReportTAG();
      boolean bool1 = "actShortVideoDownloadVideo".equals(str);
      boolean bool2 = false;
      if ((!bool1) && (!"actShortVideoDiscussgroupDownloadVideo".equals(str))) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if (("actShortVideoDownloadVideo".equals(str)) || ("actShortVideoDownloadThumb".equals(str))) {
        bool2 = true;
      }
      this.mQuicNetReport.reportBeaconEvent(bool1, bool2);
      this.mQuicNetReport = null;
    }
  }
  
  public int resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "resume()");
    }
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      sendMessageToUpdate(2001);
      this.mProcessorReport.errCode = 0;
      this.mProcessorReport.errDesc = "";
      this.mController.mHandler.post(new ShortVideoDownloadProcessor.1(this));
    }
    return 0;
  }
  
  protected void sendMessageToUpdate(int paramInt)
  {
    super.sendMessageToUpdate(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendMessageToUpdate state = ");
      localStringBuilder.append(paramInt);
      QLog.d("ShortVideoDownloadProcessor", 2, localStringBuilder.toString());
    }
    if ((this.mIsPause) && (2004 != paramInt)) {
      return;
    }
    SVBusiUtil.a((QQAppInterface)this.app, this.file, this.mUiRequest);
  }
  
  void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.ShortVideoDownReq localShortVideoDownReq = new RichProto.RichProtoReq.ShortVideoDownReq();
    localShortVideoDownReq.seq = ((int)this.mUiRequest.mUniseq);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendGetUrlReq()----busiReq.seq : ");
      localStringBuilder.append(localShortVideoDownReq.seq);
      QLog.d("ShortVideoDownloadProcessor", 2, localStringBuilder.toString());
    }
    localShortVideoDownReq.selfUin = this.mUiRequest.mSelfUin;
    localShortVideoDownReq.peerUin = this.mUiRequest.mPeerUin;
    localShortVideoDownReq.secondUin = this.mUiRequest.mSecondId;
    localShortVideoDownReq.uinType = this.mUiRequest.mUinType;
    localShortVideoDownReq.troopUin = this.mUiRequest.mPeerUin;
    localShortVideoDownReq.agentType = 0;
    localShortVideoDownReq.clientType = 2;
    localShortVideoDownReq.fileId = this.mFileId;
    localShortVideoDownReq.md5 = HexUtil.hexStr2Bytes(this.mUiRequest.mMd5);
    setChatType(localShortVideoDownReq);
    setTroopUin(localShortVideoDownReq);
    setBusiType(localShortVideoDownReq);
    setFileType(localShortVideoDownReq);
    localShortVideoDownReq.downType = this.mUiRequest.mDownMode;
    if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof Integer))) {
      localShortVideoDownReq.sceneType = ((Integer)this.mUiRequest.mExtraObj).intValue();
    }
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "short_video_dw";
    localRichProtoReq.reqs.add(localShortVideoDownReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    logRichMediaEvent("requestStart", localRichProtoReq.toString());
    if (!canDoNextStep())
    {
      runningTasks.remove(this.mTaskKey);
      return;
    }
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  protected void setMtype()
  {
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq)))
    {
      String str;
      if (UinTypeUtil.b(this.mUiRequest.mUinType)) {
        str = "videoCd";
      } else if (this.mUiRequest.mUinType == 1) {
        str = "videoGd";
      } else if (this.mUiRequest.mUinType == 3000) {
        str = "videoDd";
      } else {
        str = "videoOd";
      }
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.mNetReq).mReqUrl);
    }
  }
  
  public void start()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start()----runningTasks.contains(mTaskKey) = ");
      ((StringBuilder)localObject).append(runningTasks.contains(this.mTaskKey));
      QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo)))
    {
      localObject = (MessageForShortVideo)this.mUiRequest.mRec;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[tvk] videoFileSize = ");
      localStringBuilder.append(((MessageForShortVideo)localObject).videoFileSize);
      logRichMediaEvent("start", localStringBuilder.toString());
    }
    if ((this.mUiRequest.mDownMode == 2) && (this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo)) && (!((MessageForShortVideo)this.mUiRequest.mRec).isAllowAutoDown) && ((this.mUiRequest.mFileType == 6) || (this.mUiRequest.mFileType == 9) || (this.mUiRequest.mFileType == 17) || (this.mUiRequest.mFileType == 67)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "start()-- server not allow auto down video");
      }
      runningTasks.remove(this.mTaskKey);
      super.cancel();
      return;
    }
    if (runningTasks.contains(this.mTaskKey)) {
      return;
    }
    runningTasks.add(this.mTaskKey);
    sendMessageToUpdate(2001);
    sendRequest();
  }
  
  protected void tryUseQuicDownload(HttpNetReq paramHttpNetReq)
  {
    Object localObject = QQShortVideoQuicNetProcessor.a();
    if ((localObject != null) && (((QQShortVideoQuicNetProcessor.ShortVideoQuicNetConfBean)localObject).a()) && (this.mSupportQuic) && (!this.mIpListEmptyResp) && (!this.mIpList.isEmpty()))
    {
      localObject = getQuicEngine();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "current support quic, but quic can not be used.");
        }
        this.mQuicNetReport = new QuicNetReport();
        localObject = this.mQuicNetReport;
        ((QuicNetReport)localObject).failReason = 7;
        ((QuicNetReport)localObject).isHttpRetryed = true;
        this.mNetEngine.sendReq(paramHttpNetReq);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "current support quic, use quic. ");
      }
      useQuicDownload(paramHttpNetReq, (IQuicEngine)localObject);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("current not support quic, use net engine.supportQuic: ");
      ((StringBuilder)localObject).append(this.mSupportQuic);
      ((StringBuilder)localObject).append(" ipListEmpty: ");
      ((StringBuilder)localObject).append(this.mIpListEmptyResp);
      QLog.d("ShortVideoDownloadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    this.mNetEngine.sendReq(paramHttpNetReq);
  }
  
  protected void useQuicDownload(HttpNetReq paramHttpNetReq, IQuicEngine paramIQuicEngine)
  {
    ServerAddr localServerAddr = (ServerAddr)this.mIpList.get(0);
    Object localObject2 = localServerAddr.mIp;
    int j = localServerAddr.port;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = localObject1;
    if (((String)localObject1).startsWith("["))
    {
      localObject2 = localObject1;
      if (((String)localObject1).endsWith("]")) {
        localObject2 = ((String)localObject1).substring(1, ((String)localObject1).length() - 1);
      }
    }
    int i = j;
    if (j <= 0) {
      i = 443;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(this.mRespUrl);
    localObject1 = new QuicReq.Builder((String)localObject2, i, ((StringBuilder)localObject1).toString(), paramHttpNetReq.mOutPath);
    if (!StringUtil.isEmpty(this.mDownDomain)) {
      ((QuicReq.Builder)localObject1).addHeader("host", this.mDownDomain);
    }
    this.mQuicDownloadListener = new ShortVideoDownloadProcessor.QuicDownloadListener(this);
    paramIQuicEngine.execute(((QuicReq.Builder)localObject1).addHeader("Accept-Encoding", "identity").isQuicEncryption(this.mIsQuicEncryption).fec(this.mQuicFec).tempPath(paramHttpNetReq.mTempPath).timeOut(new TimeoutParam().getReadTimeout(NetworkCenter.getInstance().getNetType())).businessId(1).isIpv6(localServerAddr.isIpv6).rttHost("sns.cdn.qq.com").listener(this.mQuicDownloadListener).build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */