package com.tencent.mobileqq.transfile;

import abwz;
import amtj;
import android.text.TextUtils;
import aqbp;
import aqbq;
import aycx;
import aycy;
import bbqf;
import bfyz;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.quic.QuicNetResMgr;
import com.tencent.mobileqq.transfile.quic.open.QuicDownloader;
import com.tencent.mobileqq.transfile.quic.open.QuicDownloader.Builder;
import com.tencent.mobileqq.transfile.quic.open.QuicNetFactory;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
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
  implements INetEngine.NetFailedListener
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
  
  public ShortVideoDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    paramTransFileController = paramTransferRequest.mLocalPath;
    if (paramTransFileController != null)
    {
      String[] arrayOfString = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
      if (arrayOfString.length < 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
        }
        throw new IllegalArgumentException("path was not set correctlly.");
      }
      paramTransferRequest.mOutFilePath = arrayOfString[0];
      this.mFileId = arrayOfString[1];
      this.mTaskKey = (this.mFileId + paramTransferRequest.mFileType + paramTransferRequest.mUniseq);
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
    if (-5100026 == this.errCode)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 安全打击mUiRequest.mMd5:" + this.mUiRequest.mMd5);
      }
      setError(-5100026, "安全打击mUiRequest.mMd5:" + this.mUiRequest.mMd5);
    }
    for (;;)
    {
      onError();
      return;
      if ((-9527 == this.errCode) && ((this.errDesc.equals("H_400_-5103017")) || (this.errDesc.equals("H_400_-5103059"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + this.errCode);
        }
        setError(this.errCode, amtj.a(2131713175));
      }
      else if (-5100528 == this.errCode)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 后台不允许自动下载, errCode = " + this.errCode);
        }
        setError(-5100528, amtj.a(2131713180));
      }
      else
      {
        setError(9045, amtj.a(2131713182));
      }
    }
  }
  
  private void handleReqSuc(RichProto.RichProtoResp.ShortVideoDownResp paramShortVideoDownResp)
  {
    if (QLog.isColorLevel()) {
      if ("onBusiProtoResp() cdn ---- mIpListSize:" + this.mIpList != null) {
        break label137;
      }
    }
    label137:
    for (Object localObject = Integer.valueOf(0);; localObject = this.mIpList.size() + " mHostType:" + paramShortVideoDownResp.mHostType + " domain:" + paramShortVideoDownResp.mDomain + " url:" + paramShortVideoDownResp.mUrl)
    {
      QLog.d("ShortVideoDownloadProcessor", 2, new Object[] { localObject });
      QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- mUiRequest.mMd5:" + this.mUiRequest.mMd5 + " ---- downResp.md5:" + HexUtil.bytes2HexStr(paramShortVideoDownResp.md5));
      this.mRespUrl = paramShortVideoDownResp.mUrl;
      this.mSupportQuic = paramShortVideoDownResp.mIsSupportQuic;
      this.mIsQuicEncryption = paramShortVideoDownResp.mIsQuicEncryption;
      this.mQuicFec = paramShortVideoDownResp.mQuicFec;
      receiveFile(paramShortVideoDownResp.mIsHttps);
      return;
    }
  }
  
  private void setBusiType(RichProto.RichProtoReq.ShortVideoDownReq paramShortVideoDownReq)
  {
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo)))
    {
      paramShortVideoDownReq.busiType = ((MessageForShortVideo)this.mUiRequest.mRec).busiType;
      this.mReportBusiType = paramShortVideoDownReq.busiType;
      paramShortVideoDownReq.subBusiType = 0;
      if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo)))
      {
        if (!(this.mUiRequest.mRec instanceof MessageForLightVideo)) {
          break label127;
        }
        paramShortVideoDownReq.subBusiType = 3;
      }
    }
    label127:
    while (((MessageForShortVideo)this.mUiRequest.mRec).subBusiType != 1)
    {
      return;
      if (1008 == paramShortVideoDownReq.uinType)
      {
        paramShortVideoDownReq.busiType = this.mUiRequest.mBusiType;
        break;
      }
      paramShortVideoDownReq.busiType = 0;
      break;
    }
    paramShortVideoDownReq.subBusiType = 1;
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
    paramShortVideoDownReq.chatType = 3;
  }
  
  private void setFileType(RichProto.RichProtoReq.ShortVideoDownReq paramShortVideoDownReq)
  {
    if ((this.mUiRequest.mFileType == 7) || (this.mUiRequest.mFileType == 16) || (this.mUiRequest.mFileType == 18)) {
      paramShortVideoDownReq.fileType = 1;
    }
    while ((this.mUiRequest.mFileType != 6) && (this.mUiRequest.mFileType != 9) && (this.mUiRequest.mFileType != 17)) {
      return;
    }
    paramShortVideoDownReq.fileType = 2;
  }
  
  private void setTroopUin(RichProto.RichProtoReq.ShortVideoDownReq paramShortVideoDownReq)
  {
    if ((paramShortVideoDownReq.uinType == 0) || (1008 == paramShortVideoDownReq.uinType))
    {
      paramShortVideoDownReq.troopUin = null;
      return;
    }
    paramShortVideoDownReq.troopUin = this.mUiRequest.mPeerUin;
  }
  
  public int cancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "cancel()");
    }
    runningTasks.remove(this.mTaskKey);
    if (this.mQuicDownloadListener != null)
    {
      this.mQuicDownloadListener.cancel.set(true);
      this.mQuicDownloadListener = null;
    }
    return super.cancel();
  }
  
  public int checkParam()
  {
    if ((this.mUiRequest == null) || (this.mUiRequest.mOutFilePath == null))
    {
      setError(9302, amtj.a(2131713152));
      onError();
      return -1;
    }
    if ((this.mUiRequest != null) && (this.mUiRequest.mRec != null) && (((MessageForShortVideo)this.mUiRequest.mRec).busiType == 0)) {
      this.mIsShortVideoReceive = true;
    }
    return 0;
  }
  
  /* Error */
  public void checkVideoMD5()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 136	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   6: getfield 156	com/tencent/mobileqq/transfile/TransferRequest:mMd5	Ljava/lang/String;
    //   9: astore 5
    //   11: aload 5
    //   13: invokestatic 334	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifne +359 -> 375
    //   19: aload_0
    //   20: getfield 136	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   23: getfield 101	com/tencent/mobileqq/transfile/TransferRequest:mOutFilePath	Ljava/lang/String;
    //   26: astore 4
    //   28: aconst_null
    //   29: astore 6
    //   31: new 336	java/io/FileInputStream
    //   34: dup
    //   35: aload 4
    //   37: invokespecial 337	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   40: astore 4
    //   42: aload 4
    //   44: aload 4
    //   46: invokevirtual 340	java/io/FileInputStream:available	()I
    //   49: i2l
    //   50: invokestatic 346	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   53: astore 6
    //   55: aload 6
    //   57: ifnull +313 -> 370
    //   60: aload_0
    //   61: aload 6
    //   63: invokestatic 223	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   66: putfield 46	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:fileMd5	Ljava/lang/String;
    //   69: aload_0
    //   70: getfield 46	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:fileMd5	Ljava/lang/String;
    //   73: aload 5
    //   75: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifne +292 -> 370
    //   81: aload_0
    //   82: getfield 136	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   85: getfield 106	com/tencent/mobileqq/transfile/TransferRequest:mFileType	I
    //   88: bipush 6
    //   90: if_icmpeq +29 -> 119
    //   93: aload_0
    //   94: getfield 136	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   97: getfield 106	com/tencent/mobileqq/transfile/TransferRequest:mFileType	I
    //   100: bipush 9
    //   102: if_icmpeq +17 -> 119
    //   105: aload_0
    //   106: getfield 136	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   109: getfield 106	com/tencent/mobileqq/transfile/TransferRequest:mFileType	I
    //   112: istore_1
    //   113: iload_1
    //   114: bipush 17
    //   116: if_icmpne +254 -> 370
    //   119: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +43 -> 165
    //   125: ldc 10
    //   127: iconst_2
    //   128: new 76	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 348
    //   138: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 5
    //   143: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 350
    //   149: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 46	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:fileMd5	Ljava/lang/String;
    //   156: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 353	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iconst_0
    //   166: istore_1
    //   167: iload_1
    //   168: istore_2
    //   169: aload 4
    //   171: ifnull +10 -> 181
    //   174: aload 4
    //   176: invokevirtual 356	java/io/FileInputStream:close	()V
    //   179: iload_1
    //   180: istore_2
    //   181: aload_0
    //   182: getfield 360	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:mReportInfo	Ljava/util/HashMap;
    //   185: astore 4
    //   187: iload_2
    //   188: ifeq +153 -> 341
    //   191: iload_3
    //   192: istore_1
    //   193: aload 4
    //   195: ldc_w 362
    //   198: iload_1
    //   199: invokestatic 364	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   202: invokevirtual 370	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: return
    //   207: astore 4
    //   209: iload_1
    //   210: istore_2
    //   211: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq -33 -> 181
    //   217: ldc 10
    //   219: iconst_2
    //   220: ldc_w 372
    //   223: aload 4
    //   225: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   228: iload_1
    //   229: istore_2
    //   230: goto -49 -> 181
    //   233: astore 5
    //   235: iconst_1
    //   236: istore_1
    //   237: aload 6
    //   239: astore 4
    //   241: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +14 -> 258
    //   247: ldc 10
    //   249: iconst_2
    //   250: ldc_w 372
    //   253: aload 5
    //   255: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: iload_1
    //   259: istore_2
    //   260: aload 4
    //   262: ifnull -81 -> 181
    //   265: aload 4
    //   267: invokevirtual 356	java/io/FileInputStream:close	()V
    //   270: iload_1
    //   271: istore_2
    //   272: goto -91 -> 181
    //   275: astore 4
    //   277: iload_1
    //   278: istore_2
    //   279: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq -101 -> 181
    //   285: ldc 10
    //   287: iconst_2
    //   288: ldc_w 372
    //   291: aload 4
    //   293: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   296: iload_1
    //   297: istore_2
    //   298: goto -117 -> 181
    //   301: astore 5
    //   303: aconst_null
    //   304: astore 4
    //   306: aload 4
    //   308: ifnull +8 -> 316
    //   311: aload 4
    //   313: invokevirtual 356	java/io/FileInputStream:close	()V
    //   316: aload 5
    //   318: athrow
    //   319: astore 4
    //   321: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq -8 -> 316
    //   327: ldc 10
    //   329: iconst_2
    //   330: ldc_w 372
    //   333: aload 4
    //   335: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   338: goto -22 -> 316
    //   341: iconst_0
    //   342: istore_1
    //   343: goto -150 -> 193
    //   346: astore 5
    //   348: goto -42 -> 306
    //   351: astore 5
    //   353: goto -47 -> 306
    //   356: astore 5
    //   358: iconst_1
    //   359: istore_1
    //   360: goto -119 -> 241
    //   363: astore 5
    //   365: iconst_0
    //   366: istore_1
    //   367: goto -126 -> 241
    //   370: iconst_1
    //   371: istore_1
    //   372: goto -205 -> 167
    //   375: iconst_1
    //   376: istore_2
    //   377: goto -196 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	ShortVideoDownloadProcessor
    //   112	260	1	i	int
    //   168	209	2	j	int
    //   1	191	3	k	int
    //   26	168	4	localObject1	Object
    //   207	17	4	localIOException1	java.io.IOException
    //   239	27	4	localObject2	Object
    //   275	17	4	localIOException2	java.io.IOException
    //   304	8	4	localObject3	Object
    //   319	15	4	localIOException3	java.io.IOException
    //   9	133	5	str	String
    //   233	21	5	localIOException4	java.io.IOException
    //   301	16	5	localObject4	Object
    //   346	1	5	localObject5	Object
    //   351	1	5	localObject6	Object
    //   356	1	5	localIOException5	java.io.IOException
    //   363	1	5	localIOException6	java.io.IOException
    //   29	209	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   174	179	207	java/io/IOException
    //   31	42	233	java/io/IOException
    //   265	270	275	java/io/IOException
    //   31	42	301	finally
    //   311	316	319	java/io/IOException
    //   42	55	346	finally
    //   60	113	346	finally
    //   119	165	346	finally
    //   241	258	351	finally
    //   42	55	356	java/io/IOException
    //   60	113	356	java/io/IOException
    //   119	165	363	java/io/IOException
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if (this.mUiRequest.mIsOnlyGetUrl) {}
    while (((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) || (this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return;
    }
    int j = this.mReportedFlag;
    int i;
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      if (this.mRedirectCount > 0)
      {
        new HashMap().put("businessType", String.valueOf(this.mUiRequest.mFileType));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actShortVideoRedirect", true, this.mRedirectTime, this.mRedirectCount, this.mReportInfo, "");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "mRedirectReportInfo = " + this.mRedirectCount + " " + this.mRedirectTime + " " + this.mUiRequest.mFileType);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "reportTag = " + getReportTAG());
      }
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      str = this.mStepUrl.getReportInfo(1) + ";" + this.mStepTrans.getReportInfo(2) + ";" + this.mStepMsg.getReportInfo(3);
      this.mReportInfo.put("param_step", str);
      this.mReportInfo.put("param_fromUin", this.mUiRequest.mPeerUin);
      if (this.mIpList.size() > 0) {
        this.mReportInfo.put("param_iplist", this.mIpList.toString());
      }
      this.mReportInfo.put("param_uuid", this.mFileId);
      this.mReportInfo.put("param_picSize", String.valueOf(this.file.fileSize));
      this.mReportInfo.put("param_fileMd5", this.mUiRequest.mMd5);
      this.mReportInfo.put("param_busiType", this.mReportBusiType + "");
      this.mReportInfo.put("param_videoDuration", String.valueOf(this.videoTime));
      this.mReportInfo.put("param_DownMode", String.valueOf(this.mUiRequest.mDownMode));
      HashMap localHashMap = this.mReportInfo;
      if (!this.mIsHttpsDownload) {
        break label593;
      }
      str = "1";
      label509:
      localHashMap.put("param_isHttps", str);
      this.mReportInfo.put("param_trans_consume", String.valueOf(this.mStepTrans.getTimeConsume()));
      reportQuicNetState();
      if (!paramBoolean) {
        break label601;
      }
      reportForIpv6(true, l);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l, this.mTotolLen, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      return;
      i = 1;
      break;
      label593:
      str = "0";
      break label509;
      label601:
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      if (this.errCode == -6103066) {
        this.mReportInfo.put("param_picmd5", "uierquest md5=" + this.mUiRequest.mMd5 + "fileMd5=" + this.fileMd5);
      }
      reportForIpv6(false, l);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l, 0L, this.mReportInfo, "");
    }
  }
  
  protected String getConnUrl(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ServerAddr localServerAddr;
    if (paramBoolean)
    {
      localStringBuilder.append("https://");
      if (this.mIpList.size() <= 0) {
        break label204;
      }
      localServerAddr = (ServerAddr)this.mIpList.get(0);
      if ((!localServerAddr.isIpv6) || (localServerAddr.mIp.startsWith("["))) {
        break label192;
      }
      localStringBuilder.append("[" + localServerAddr.mIp + "]");
      label96:
      if ((localServerAddr.port != 80) && (localServerAddr.port != 0))
      {
        localStringBuilder.append(":");
        localStringBuilder.append(localServerAddr.port);
      }
    }
    for (;;)
    {
      localStringBuilder.append("/");
      localStringBuilder.append(this.mRespUrl);
      logRichMediaEvent("getConnUrl", "cdn url = " + localStringBuilder.toString());
      return localStringBuilder.toString();
      localStringBuilder.append("http://");
      break;
      label192:
      localStringBuilder.append(localServerAddr.mIp);
      break label96;
      label204:
      localStringBuilder.append(this.mDownDomain);
    }
  }
  
  protected QuicDownloader getQuicDownloader()
  {
    return QuicNetFactory.getInstance().createQuicDownloader();
  }
  
  protected String getReportTAG()
  {
    String str = "actShortVideoDownloadVideo";
    if (this.mUiRequest.mFileType == 7) {
      str = "actShortVideoDownloadThumb";
    }
    do
    {
      return str;
      if (this.mUiRequest.mFileType == 6) {
        return "actShortVideoDownloadVideo";
      }
      if ((this.mUiRequest.mFileType == 16) || (this.mUiRequest.mFileType == 18))
      {
        this.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
        return "actShortVideoDiscussgroupDownloadThumb";
      }
    } while ((this.mUiRequest.mFileType != 9) && (this.mUiRequest.mFileType != 17));
    this.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
    return "actShortVideoDiscussgroupDownloadVideo";
  }
  
  public void handleOnRespErr(NetResp paramNetResp)
  {
    if (paramNetResp.mRespProperties.get("X-RtFlag") == null) {}
    for (long l = 9223372036854775807L;; l = Long.parseLong((String)paramNetResp.mRespProperties.get("X-RtFlag")))
    {
      this.mReportInfo.put("param_xRtFlag", String.valueOf(l));
      if ((paramNetResp.mErrCode != 9364) || (this.mNetworkChgRetryCount >= 3)) {
        break;
      }
      logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
      this.mNetworkChgRetryCount += 1;
      clearReprotInfo();
      sendRequest();
      return;
    }
    String str = (String)paramNetResp.mRespProperties.get(HttpMsg.Param_Reason);
    setError(paramNetResp.mErrCode, paramNetResp.mErrDesc, str, this.mStepTrans);
    onError();
  }
  
  public void handleOnRespSuc(NetResp paramNetResp)
  {
    checkVideoMD5();
    onSuccess();
    this.mRSMReporter.mBusiType = (this.mReportBusiType + "");
    this.mRSMReporter.mFileSize = this.file.fileSize;
    reportForServerMonitor(paramNetResp, true, "actRichMediaNetMonitor_videoDown", this.mFileId);
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.resps.get(i);
        logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        this.mIpList = selectIpList(paramRichProtoReq.mIpv6List, paramRichProtoReq.mIpList);
        boolean bool;
        if ((this.mIpList == null) || (this.mIpList.isEmpty()))
        {
          bool = true;
          label94:
          this.mIpListEmptyResp = bool;
          this.mDownDomain = paramRichProtoReq.mDomain;
          if (this.isDomainTest)
          {
            this.mDownDomain = "grouptalk.c2c.qq.com";
            if (this.mIpList != null) {
              this.mIpList.clear();
            }
          }
          if (paramRichProtoReq.result != 0) {
            break label161;
          }
          handleReqSuc(paramRichProtoReq);
        }
        for (;;)
        {
          i += 1;
          break;
          bool = false;
          break label94;
          label161:
          handleReqErr(paramRichProtoReq);
        }
      }
    }
  }
  
  void onError()
  {
    super.onError();
    runningTasks.remove(this.mTaskKey);
    this.file.errorCode = this.errCode;
    if (-5100026 == this.errCode) {
      sendMessageToUpdate(5001);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errCode:" + this.errCode);
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errDesc:" + this.errDesc);
      }
      Object localObject = null;
      if (this.mUiRequest != null) {
        localObject = this.mUiRequest.mResult;
      }
      if (localObject != null)
      {
        ((TransferResult)localObject).mResult = -1;
        ((TransferResult)localObject).mErrCode = this.errCode;
        ((TransferResult)localObject).mErrDesc = this.errDesc;
        ((TransferResult)localObject).mOrigReq = this.mUiRequest;
      }
      localObject = this.mDownCallBacks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aycx localaycx = (aycx)((Iterator)localObject).next();
        aycy localaycy = new aycy();
        localaycy.jdField_a_of_type_Int = -1;
        localaycy.jdField_b_of_type_Int = this.errCode;
        localaycy.jdField_a_of_type_JavaLangString = this.errDesc;
        localaycx.a(localaycy);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideo.TAG", 2, "onError ");
        }
      }
      if ((-9527 == this.errCode) && ((this.errDesc.equals("H_400_-5103017")) || (this.errDesc.equals("H_400_-5103059")))) {
        sendMessageToUpdate(5002);
      } else {
        sendMessageToUpdate(2005);
      }
    }
  }
  
  public void onFailed(NetResp paramNetResp)
  {
    this.mRSMReporter.mBusiType = (this.mReportBusiType + "");
    this.mRSMReporter.mFileSize = this.file.fileSize;
    reportForServerMonitor(paramNetResp, false, "actRichMediaNetMonitor_videoDown", this.mFileId);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool2 = true;
    super.onResp(paramNetResp);
    Object localObject = new StringBuilder().append("directMsgUrlDown:").append(this.mDirectMsgUrlDown).append(" result:");
    boolean bool1;
    if (paramNetResp.mResult == 0)
    {
      bool1 = true;
      logRichMediaEvent("onHttpResp", bool1);
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onResp()---- result:" + paramNetResp.mResult);
        QLog.d("ShortVideoDownloadProcessor", 2, "onResp()---- errCode:" + paramNetResp.mErrCode);
        QLog.d("ShortVideoDownloadProcessor", 2, "onResp()---- errDesc:" + paramNetResp.mErrDesc);
      }
      if (!this.mDirectMsgUrlDown) {
        break label268;
      }
      localObject = this.mStepDirectDown;
      label166:
      if (paramNetResp.mResult != 0) {
        break label277;
      }
      bool1 = bool2;
      label175:
      copyStatisInfoFromNetResp((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      this.mTotolLen = paramNetResp.mTotalFileLen;
      if (this.mTotolLen <= 0L) {
        this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
      }
      this.mRecvLen += paramNetResp.mWrittenBlockLen;
      this.mRedirectTime = paramNetResp.mRedirectTime;
      this.mRedirectCount = paramNetResp.mRedirectCount;
      if (paramNetResp.mResult != 0) {
        break label282;
      }
      handleOnRespSuc(paramNetResp);
    }
    for (;;)
    {
      this.mNetReq = null;
      return;
      bool1 = false;
      break;
      label268:
      localObject = this.mStepTrans;
      break label166;
      label277:
      bool1 = false;
      break label175;
      label282:
      handleOnRespErr(paramNetResp);
    }
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
      aycx localaycx = (aycx)((Iterator)localObject).next();
      aycy localaycy = new aycy();
      localaycy.jdField_a_of_type_Int = 0;
      localaycy.jdField_b_of_type_JavaLangString = this.mUiRequest.mOutFilePath;
      localaycy.c = this.mUiRequest.mMd5;
      localaycy.d = this.mUiRequest.mDownMode;
      localaycx.a(localaycy);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.mIsPause) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoDownloadProcessor", 2, "onUpdateProgeress: mIsPause=true, should not notify UI, just return!");
      }
    }
    for (;;)
    {
      return;
      this.file.transferedSize = paramLong1;
      this.file.fileSize = paramLong2;
      sendMessageToUpdate(2002);
      int i = (int)(10000L * paramLong1 / paramLong2);
      paramNetReq = this.mDownCallBacks.iterator();
      while (paramNetReq.hasNext()) {
        ((aycx)paramNetReq.next()).a(i, false);
      }
    }
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "pause() mIsPause : " + this.mIsPause);
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
      if (this.mQuicDownloadListener != null)
      {
        this.mQuicDownloadListener.cancel.set(true);
        this.mQuicDownloadListener = null;
      }
    }
  }
  
  protected void quicDownloadSuc(QuicNetReport paramQuicNetReport, HttpNetReq paramHttpNetReq)
  {
    if (paramHttpNetReq.mCallback != null)
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
    this.mStepTrans.logStartTime();
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
    ((HttpNetReq)localObject1).mHttpMethod = 0;
    addDomainToList(this.mIpList, this.mDownDomain);
    ((HttpNetReq)localObject1).mServerList = this.mIpList;
    ((HttpNetReq)localObject1).mOutPath = this.mUiRequest.mOutFilePath;
    ((HttpNetReq)localObject1).mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    ((HttpNetReq)localObject1).mBusiProtoType = this.mUiRequest.mUinType;
    ((HttpNetReq)localObject1).mFileType = this.mUiRequest.mFileType;
    Object localObject2;
    if ((this.mUiRequest.mFileType == 6) || (this.mUiRequest.mFileType == 9) || (this.mUiRequest.mFileType == 17))
    {
      localObject2 = bfyz.f(BaseApplication.getContext());
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
    ((HttpNetReq)localObject1).mBreakDownFix = mPicBreakDownFixForOldHttpEngine;
    ((HttpNetReq)localObject1).mTempPath = (this.mUiRequest.mOutFilePath + "." + MD5.toMD5(this.mFileId) + ".tmp");
    logRichMediaEvent("httpDown", "url:" + str + ",downOffset:" + ((HttpNetReq)localObject1).mStartDownOffset);
    if (!canDoNextStep())
    {
      runningTasks.remove(this.mTaskKey);
      return;
    }
    this.mNetReq = ((NetReq)localObject1);
    setMtype();
    ((HttpNetReq)localObject1).mNeedRedirectCallback = true;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mIsOnlyGetUrl " + this.mUiRequest.mIsOnlyGetUrl + " domain=" + this.mDownDomain + " ipsize=" + this.mIpList.size());
    }
    if (this.mUiRequest.mIsOnlyGetUrl)
    {
      localObject1 = new String[this.mIpList.size()];
      int i = 0;
      if (i < this.mIpList.size())
      {
        localObject2 = (ServerAddr)this.mIpList.get(i);
        StringBuffer localStringBuffer = new StringBuffer();
        if (paramBoolean) {
          localStringBuffer.append("https://");
        }
        for (;;)
        {
          localStringBuffer.append(((ServerAddr)localObject2).mIp);
          if (((ServerAddr)localObject2).port != 80)
          {
            localStringBuffer.append(":");
            localStringBuffer.append(((ServerAddr)localObject2).port);
          }
          localStringBuffer.append("/");
          localObject1[i] = RichMediaUtil.replaceIp(str, localStringBuffer.toString());
          i += 1;
          break;
          localStringBuffer.append("http://");
        }
      }
      this.file.urls = ((String[])localObject1);
      this.file.domain = this.mDownDomain;
      this.file.stepUrlCost = this.mStepUrl.getTimeConsume();
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
      if ((!"actShortVideoDownloadVideo".equals(str)) && (!"actShortVideoDiscussgroupDownloadVideo".equals(str))) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      this.mQuicNetReport.reportBeaconEvent(bool);
      this.mQuicNetReport = null;
      return;
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
      this.errCode = 0;
      this.errDesc = "";
      this.mController.mHandler.post(new ShortVideoDownloadProcessor.1(this));
    }
    return 0;
  }
  
  protected void sendMessageToUpdate(int paramInt)
  {
    super.sendMessageToUpdate(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendMessageToUpdate state = " + paramInt);
    }
    if ((this.mIsPause) && (2004 != paramInt)) {
      return;
    }
    bbqf.a(this.app, this.file, this.mUiRequest);
  }
  
  void sendRequest()
  {
    this.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.ShortVideoDownReq localShortVideoDownReq = new RichProto.RichProtoReq.ShortVideoDownReq();
    localShortVideoDownReq.seq = ((int)this.mUiRequest.mUniseq);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + localShortVideoDownReq.seq);
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
    localRichProtoReq.protoReqMgr = this.app.getProtoReqManager();
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepUrl);
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
    String str;
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq)))
    {
      if (!abwz.d(this.mUiRequest.mUinType)) {
        break label59;
      }
      str = "videoCd";
    }
    for (;;)
    {
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.mNetReq).mReqUrl);
      return;
      label59:
      if (this.mUiRequest.mUinType == 1) {
        str = "videoGd";
      } else if (this.mUiRequest.mUinType == 3000) {
        str = "videoDd";
      } else {
        str = "videoOd";
      }
    }
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "start()----runningTasks.contains(mTaskKey) = " + runningTasks.contains(this.mTaskKey));
    }
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.mUiRequest.mRec;
      logRichMediaEvent("start", "[tvk] videoFileSize = " + localMessageForShortVideo.videoFileSize);
    }
    if ((this.mUiRequest.mDownMode == 2) && (this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo)) && (!((MessageForShortVideo)this.mUiRequest.mRec).isAllowAutoDown) && ((this.mUiRequest.mFileType == 6) || (this.mUiRequest.mFileType == 9) || (this.mUiRequest.mFileType == 17)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "start()-- server not allow auto down video");
      }
      runningTasks.remove(this.mTaskKey);
      super.cancel();
    }
    while (runningTasks.contains(this.mTaskKey)) {
      return;
    }
    runningTasks.add(this.mTaskKey);
    sendMessageToUpdate(2001);
    sendRequest();
  }
  
  protected void tryUseQuicDownload(HttpNetReq paramHttpNetReq)
  {
    aqbq localaqbq = aqbp.a();
    if ((localaqbq != null) && (localaqbq.a()) && (this.mSupportQuic) && (!this.mIpListEmptyResp) && (!this.mIpList.isEmpty()))
    {
      QuicDownloader localQuicDownloader = getQuicDownloader();
      if (localQuicDownloader == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "current support quic, but quic can not be used.");
        }
        this.mQuicNetReport = new QuicNetReport();
        this.mQuicNetReport.failReason = 7;
        this.mNetEngine.sendReq(paramHttpNetReq);
        QuicNetResMgr.getInstance().downloadQuicRes(localaqbq);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "current support quic, use quic. ");
      }
      useQuicDownload(paramHttpNetReq, localQuicDownloader);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "current not support quic, use net engine.supportQuic: " + this.mSupportQuic + " ipListEmpty: " + this.mIpListEmptyResp);
    }
    this.mNetEngine.sendReq(paramHttpNetReq);
  }
  
  protected void useQuicDownload(HttpNetReq paramHttpNetReq, QuicDownloader paramQuicDownloader)
  {
    ServerAddr localServerAddr = (ServerAddr)this.mIpList.get(0);
    String str2 = localServerAddr.mIp;
    int i = localServerAddr.port;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    if ((str1.startsWith("[")) && (str1.endsWith("]"))) {
      str1 = str1.substring(1, str1.length() - 1);
    }
    for (;;)
    {
      if (i <= 0) {
        i = 443;
      }
      for (;;)
      {
        paramHttpNetReq = paramQuicDownloader.build(str1, i, "/" + this.mRespUrl, paramHttpNetReq.mOutPath);
        if (!StringUtil.isEmpty(this.mDownDomain)) {
          paramHttpNetReq.addHeader("host", this.mDownDomain);
        }
        this.mQuicDownloadListener = new ShortVideoDownloadProcessor.QuicDownloadListener(this);
        paramHttpNetReq.addHeader("Accept-Encoding", "identity").isQuicEncryption(this.mIsQuicEncryption).fec(this.mQuicFec).timeOut(new RichMediaStrategy.OldEngineDPCProfile.TimeoutParam().getReadTimeout(NetworkCenter.getInstance().getNetType())).businessId(1).isIpv6(localServerAddr.isIpv6).listener(this.mQuicDownloadListener).start();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */