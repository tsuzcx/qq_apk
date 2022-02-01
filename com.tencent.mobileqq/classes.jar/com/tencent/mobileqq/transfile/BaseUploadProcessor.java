package com.tencent.mobileqq.transfile;

import blkh;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseUploadProcessor
  extends BaseTransProcessor
{
  static final int MAX_PKG_SIZE = 131072;
  static final int SPAN_SSCM_SLICE_SIZE = 14600;
  static final int TRY_SPAN_SIZE = 32768;
  long mBlockSize = 20480L;
  protected int mChannelStatus = 0;
  public long mEnterAioTime;
  String mExtName;
  String mFileName;
  long mFileSize;
  int mHeight;
  ArrayList<ServerAddr> mIpList = new ArrayList();
  boolean mIsPicSecondTransfered = false;
  byte[] mLocalMd5;
  String mMd5Str;
  public int mPicType = -1;
  RandomAccessFile mRaf;
  int mReqUrlCount = 0;
  String mResid;
  boolean mSSCMSpanned = false;
  int mServerRollbackCount = 0;
  protected byte[] mSessionKey;
  protected byte[] mSigSession;
  long mStartOffset;
  protected Transaction mTrans;
  long mTransferedSize = 0L;
  int mTryCount = 0;
  String mUkey;
  String mUuid;
  int mWidth;
  protected boolean needSendMsg = true;
  public int shouldMsgReportSucc = -1;
  blkh sscmObject = new blkh();
  boolean useServerInitSize = false;
  
  public BaseUploadProcessor() {}
  
  public BaseUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    setKey(paramTransferRequest.mPeerUin + paramTransferRequest.mUniseq);
    this.needSendMsg = paramTransferRequest.needSendMsg;
  }
  
  public void addBDHReportInfo(HashMap<String, String> paramHashMap)
  {
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    String str6 = (String)paramHashMap.get("param_conf_connNum");
    String str7 = (String)paramHashMap.get("param_fin_lost");
    this.mReportInfo.put("serverip", paramHashMap.get("ip"));
    this.mReportInfo.put("param_bdhPort", paramHashMap.get("port"));
    this.mReportInfo.put("X-piccachetime", str1);
    this.mReportInfo.put("param_BdhTrans", str2);
    this.mReportInfo.put("param_segspercnt", str3);
    this.mReportInfo.put("param_conf_segSize", str4);
    this.mReportInfo.put("param_conf_segNum", str5);
    this.mReportInfo.put("param_conf_connNum", str6);
    this.mReportInfo.put("param_fin_lost", str7);
    this.mReportInfo.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.mReportInfo.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.mReportInfo.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.mReportInfo.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.mReportInfo.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.mReportInfo.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.mReportInfo.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    this.mRSMReporter.mConnCost = ((String)paramHashMap.get("param_Ip_ConnCost"));
    this.mReportInfo.put("param_BDH_Cache_Diff", paramHashMap.get("param_BDH_Cache_Diff"));
    this.mReportInfo.put("param_is_ipv6", paramHashMap.get("param_is_ipv6"));
    this.mReportInfo.put("param_hasV6List", paramHashMap.get("param_hasV6List"));
    this.mReportInfo.put("param_ipv6First", paramHashMap.get("param_ipv6First"));
    this.reportTimeHt = this.mTrans.mTransReport.timeCost_Ht;
    this.reportTimePicCache = this.mTrans.mTransReport.timeCost_Cache;
  }
  
  public int cancel()
  {
    return super.cancel();
  }
  
  protected boolean checkBDHSessionValid()
  {
    return (this.mSigSession != null) && (this.mSigSession.length > 0) && (this.mSessionKey != null) && (this.mSessionKey.length > 0);
  }
  
  protected void collectChnlCostReport()
  {
    int i = 1;
    if ((this.mChannelStatus == 2) && (!this.mReportInfo.containsKey("param_BdhTrans"))) {
      if ((this.reportTimeTrans > 0L) && (this.reportTimePicCache > 0L))
      {
        if ((this.isReportValid) && (i != 0))
        {
          this.costReport = new StringBuilder();
          this.costReport.append("s").append(this.segmentNum).append("_").append("tr").append(this.reportTimeTrans).append("_").append("ht").append(this.reportTimeHt).append("_").append("pic").append(this.reportTimePicCache).append(";");
          this.mReportInfo.put("X-piccachetime", String.valueOf(this.reportTimePicCache));
          this.mReportInfo.put("param_CostEach", this.costReport.toString());
          this.mReportInfo.put("param_sliceNum", String.valueOf(this.segmentNum));
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sn:").append(this.segmentNum).append(";").append("tc_s:").append(this.reportTimeTrans).append(";").append("tc_h:").append(this.reportTimeHt).append(";").append("tc_p:").append(this.reportTimePicCache).append(";");
        this.mReportInfo.put("param_BdhTrans", localStringBuilder.toString());
      }
    }
    while ((this.mChannelStatus != 1) || (this.mTrans == null)) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        return;
        i = 0;
      }
    }
    this.mReportInfo.put("X-piccachetime", String.valueOf(this.mTrans.mTransReport.timeCost_Cache));
  }
  
  protected HttpNetReq constructHttpNetReq(byte[] paramArrayOfByte)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = getConnUrl(paramArrayOfByte);
    localHttpNetReq.mHttpMethod = 1;
    localHttpNetReq.mSendData = paramArrayOfByte;
    localHttpNetReq.mServerList = this.mIpList;
    localHttpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    localHttpNetReq.mBusiProtoType = this.mUiRequest.mUinType;
    localHttpNetReq.mFileType = this.mUiRequest.mFileType;
    localHttpNetReq.mIsNetChgAsError = true;
    localHttpNetReq.mReqProperties.put("Range", "bytes=" + this.mTransferedSize + "-");
    localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
    return localHttpNetReq;
  }
  
  protected void finalize()
  {
    super.finalize();
    if (this.mRaf != null) {}
    try
    {
      this.mRaf.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    finally
    {
      this.mRaf = null;
    }
  }
  
  public void fixTimeAtPttPreSend()
  {
    this.mStartTime = System.nanoTime();
  }
  
  protected long getBlockSize(long paramLong)
  {
    long l = this.mFileSize;
    return Math.min(this.mBlockSize, l - paramLong);
  }
  
  protected String getConnUrl(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  /* Error */
  boolean getMd5()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 312	com/tencent/mobileqq/transfile/BaseUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   4: getfield 384	com/tencent/mobileqq/transfile/TransferRequest:mLocalPath	Ljava/lang/String;
    //   7: astore 4
    //   9: new 386	java/io/FileInputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 388	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_0
    //   22: aload_3
    //   23: aload_0
    //   24: getfield 392	com/tencent/mobileqq/transfile/BaseUploadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   27: getfield 397	com/tencent/mobileqq/transfile/FileMsg:fileSize	J
    //   30: invokestatic 403	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   33: putfield 405	com/tencent/mobileqq/transfile/BaseUploadProcessor:mLocalMd5	[B
    //   36: aload_3
    //   37: astore_2
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 405	com/tencent/mobileqq/transfile/BaseUploadProcessor:mLocalMd5	[B
    //   43: invokestatic 410	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   46: putfield 412	com/tencent/mobileqq/transfile/BaseUploadProcessor:mFileName	Ljava/lang/String;
    //   49: aload_3
    //   50: astore_2
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 412	com/tencent/mobileqq/transfile/BaseUploadProcessor:mFileName	Ljava/lang/String;
    //   56: putfield 414	com/tencent/mobileqq/transfile/BaseUploadProcessor:mMd5Str	Ljava/lang/String;
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 392	com/tencent/mobileqq/transfile/BaseUploadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   65: aload_0
    //   66: getfield 412	com/tencent/mobileqq/transfile/BaseUploadProcessor:mFileName	Ljava/lang/String;
    //   69: putfield 417	com/tencent/mobileqq/transfile/FileMsg:fileMd5	Ljava/lang/String;
    //   72: aload_3
    //   73: astore_2
    //   74: aload_0
    //   75: new 96	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   82: aload_0
    //   83: getfield 412	com/tencent/mobileqq/transfile/BaseUploadProcessor:mFileName	Ljava/lang/String;
    //   86: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 419
    //   92: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 421	com/tencent/mobileqq/transfile/BaseUploadProcessor:mExtName	Ljava/lang/String;
    //   99: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: putfield 412	com/tencent/mobileqq/transfile/BaseUploadProcessor:mFileName	Ljava/lang/String;
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 422	java/io/FileInputStream:close	()V
    //   116: iconst_1
    //   117: istore_1
    //   118: iload_1
    //   119: ireturn
    //   120: astore_2
    //   121: aload_3
    //   122: astore_2
    //   123: new 424	java/io/File
    //   126: dup
    //   127: aload 4
    //   129: invokespecial 425	java/io/File:<init>	(Ljava/lang/String;)V
    //   132: astore 4
    //   134: aload_3
    //   135: astore_2
    //   136: aload 4
    //   138: invokevirtual 428	java/io/File:exists	()Z
    //   141: istore_1
    //   142: iload_1
    //   143: ifeq -107 -> 36
    //   146: aload_3
    //   147: astore_2
    //   148: aload 4
    //   150: invokestatic 434	bkvq:a	(Ljava/io/File;)Ljava/lang/String;
    //   153: astore 4
    //   155: aload 4
    //   157: ifnull +17 -> 174
    //   160: aload_3
    //   161: astore_2
    //   162: aload_0
    //   163: aload 4
    //   165: invokestatic 438	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   168: putfield 405	com/tencent/mobileqq/transfile/BaseUploadProcessor:mLocalMd5	[B
    //   171: goto -135 -> 36
    //   174: ldc_w 440
    //   177: astore 4
    //   179: goto -19 -> 160
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 358	java/io/IOException:printStackTrace	()V
    //   187: goto -71 -> 116
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_3
    //   194: aload_3
    //   195: astore_2
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 405	com/tencent/mobileqq/transfile/BaseUploadProcessor:mLocalMd5	[B
    //   201: aload_3
    //   202: astore_2
    //   203: aload_0
    //   204: aload 4
    //   206: invokevirtual 444	com/tencent/mobileqq/transfile/BaseUploadProcessor:analysisIOProblem	(Ljava/io/IOException;)V
    //   209: iconst_0
    //   210: istore_1
    //   211: aload_3
    //   212: ifnull -94 -> 118
    //   215: aload_3
    //   216: invokevirtual 422	java/io/FileInputStream:close	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_2
    //   222: aload_2
    //   223: invokevirtual 358	java/io/IOException:printStackTrace	()V
    //   226: iconst_0
    //   227: ireturn
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 422	java/io/FileInputStream:close	()V
    //   239: aload_3
    //   240: athrow
    //   241: astore_2
    //   242: aload_2
    //   243: invokevirtual 358	java/io/IOException:printStackTrace	()V
    //   246: goto -7 -> 239
    //   249: astore_3
    //   250: goto -19 -> 231
    //   253: astore 4
    //   255: goto -61 -> 194
    //   258: astore_2
    //   259: goto -223 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	BaseUploadProcessor
    //   117	94	1	bool	boolean
    //   20	54	2	localFileInputStream1	java.io.FileInputStream
    //   120	1	2	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   122	40	2	localFileInputStream2	java.io.FileInputStream
    //   182	2	2	localIOException1	IOException
    //   195	8	2	localFileInputStream3	java.io.FileInputStream
    //   221	2	2	localIOException2	IOException
    //   230	6	2	localObject1	Object
    //   241	2	2	localIOException3	IOException
    //   258	1	2	localIOException4	IOException
    //   18	198	3	localFileInputStream4	java.io.FileInputStream
    //   228	12	3	localObject2	Object
    //   249	1	3	localObject3	Object
    //   7	171	4	localObject4	Object
    //   190	15	4	localIOException5	IOException
    //   253	1	4	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   21	36	120	java/lang/UnsatisfiedLinkError
    //   112	116	182	java/io/IOException
    //   9	19	190	java/io/IOException
    //   215	219	221	java/io/IOException
    //   9	19	228	finally
    //   235	239	241	java/io/IOException
    //   21	36	249	finally
    //   38	49	249	finally
    //   51	59	249	finally
    //   61	72	249	finally
    //   74	108	249	finally
    //   123	134	249	finally
    //   136	142	249	finally
    //   148	155	249	finally
    //   162	171	249	finally
    //   196	201	249	finally
    //   203	209	249	finally
    //   21	36	253	java/io/IOException
    //   38	49	253	java/io/IOException
    //   51	59	253	java/io/IOException
    //   61	72	253	java/io/IOException
    //   74	108	253	java/io/IOException
    //   123	134	253	java/io/IOException
    //   136	142	253	java/io/IOException
    //   148	155	258	java/io/IOException
    //   162	171	258	java/io/IOException
  }
  
  byte[] getStreamData(int paramInt1, int paramInt2)
  {
    try
    {
      this.mRaf.seek(paramInt1);
      byte[] arrayOfByte = new byte[paramInt2];
      int i = 0;
      paramInt1 = paramInt2;
      while (i < paramInt2)
      {
        int j = this.mRaf.read(arrayOfByte, i, paramInt1);
        if (j == -1)
        {
          setError(9303, "fileSize not enough");
          this.mStepTrans.logFinishTime();
          return null;
        }
        i += j;
        paramInt1 -= j;
      }
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      analysisIOProblem(localIOException);
      localIOException.printStackTrace();
    }
    return null;
  }
  
  protected void initBDHSession()
  {
    try
    {
      int i;
      if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session() != null)
      {
        i = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session().length;
        this.mSigSession = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session(), 0, this.mSigSession, 0, i);
      }
      if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey() != null)
      {
        i = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey().length;
        this.mSessionKey = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey(), 0, this.mSessionKey, 0, i);
      }
      return;
    }
    finally {}
  }
  
  protected boolean isNetworkAvailable()
  {
    HwNetworkCenter.getInstance(BaseApplication.getContext()).updateNetInfo(BaseApplication.getContext());
    return HwNetworkCenter.getInstance(BaseApplication.getContext()).getNetType() != 0L;
  }
  
  protected void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, paramString);
    }
  }
  
  public void pause()
  {
    super.pause();
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("pause", "");
      }
      sendMessageToUpdate(1004);
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
    }
  }
  
  protected void reportDataFlow(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    if (paramLong1 != 0L) {
      this.app.countFlow(true, 1, paramInt, this.mUiRequest.mUinType, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.app.countFlow(true, 1, paramInt, this.mUiRequest.mUinType, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.app.countFlow(true, 0, paramInt, this.mUiRequest.mUinType, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.app.countFlow(true, 0, paramInt, this.mUiRequest.mUinType, paramLong4);
    }
  }
  
  protected void reportForServerMonitor(String paramString1, boolean paramBoolean, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.mRSMReporter.mMD5 = paramString4;
    this.mRSMReporter.mUUID = paramString5;
    this.mRSMReporter.mBusiType = paramString6;
    this.mRSMReporter.mFailCode = String.valueOf(paramInt);
    this.mRSMReporter.mServerIp = paramString2;
    this.mRSMReporter.mServerPort = paramString3;
    this.mRSMReporter.mFileSize = this.mFileSize;
    doReportForServerMonitor(paramString1, paramBoolean);
  }
  
  public int resume()
  {
    return super.resume();
  }
  
  protected void sendFile()
  {
    this.mStepTrans.logStartTime();
    long l1 = this.mTransferedSize;
    long l2 = getBlockSize(l1);
    Object localObject = getStreamData((int)l1, (int)l2);
    if (localObject == null) {
      onError();
    }
    do
    {
      return;
      logRichMediaEvent("sendingdata", "pos:" + l1 + "  transferData len:" + localObject.length);
      localObject = constructHttpNetReq((byte[])localObject);
      if (l1 + l2 >= this.mFileSize) {
        ((HttpNetReq)localObject).mReqProperties.put("Connection", "close");
      }
    } while (!canDoNextStep());
    this.mNetReq = ((NetReq)localObject);
    setMtype();
    this.mNetEngine.sendReq((NetReq)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseUploadProcessor
 * JD-Core Version:    0.7.0.1
 */