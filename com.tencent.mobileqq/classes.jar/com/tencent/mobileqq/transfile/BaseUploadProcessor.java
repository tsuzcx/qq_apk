package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
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
  protected byte[] mLocalMd5;
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
  protected Transaction mTrans = null;
  long mTransferedSize = 0L;
  int mTryCount = 0;
  String mUkey;
  String mUuid;
  int mWidth;
  protected boolean needSendMsg = true;
  public int shouldMsgReportSucc = -1;
  SSCM sscmObject = new SSCM();
  boolean useServerInitSize = false;
  
  public BaseUploadProcessor() {}
  
  public BaseUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    paramBaseTransFileController = new StringBuilder();
    paramBaseTransFileController.append(paramTransferRequest.mPeerUin);
    paramBaseTransFileController.append(paramTransferRequest.mUniseq);
    setKey(paramBaseTransFileController.toString());
    this.needSendMsg = paramTransferRequest.needSendMsg;
  }
  
  public static int ipToLong(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramString = paramString.split("\\.");
      arrayOfByte[0] = ((byte)(Integer.parseInt(paramString[0]) & 0xFF));
      arrayOfByte[1] = ((byte)(Integer.parseInt(paramString[1]) & 0xFF));
      arrayOfByte[2] = ((byte)(Integer.parseInt(paramString[2]) & 0xFF));
      arrayOfByte[3] = ((byte)(Integer.parseInt(paramString[3]) & 0xFF));
      int i = arrayOfByte[3];
      int j = arrayOfByte[2];
      int k = arrayOfByte[1];
      int m = arrayOfByte[0];
      return i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000 | m << 24 & 0xFF000000;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
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
    this.mProcessorReport.mReportInfo.put("serverip", paramHashMap.get("ip"));
    this.mProcessorReport.mReportInfo.put("param_bdhPort", paramHashMap.get("port"));
    this.mProcessorReport.mReportInfo.put("X-piccachetime", str1);
    this.mProcessorReport.mReportInfo.put("param_BdhTrans", str2);
    this.mProcessorReport.mReportInfo.put("param_segspercnt", str3);
    this.mProcessorReport.mReportInfo.put("param_conf_segSize", str4);
    this.mProcessorReport.mReportInfo.put("param_conf_segNum", str5);
    this.mProcessorReport.mReportInfo.put("param_conf_connNum", str6);
    this.mProcessorReport.mReportInfo.put("param_fin_lost", str7);
    this.mProcessorReport.mReportInfo.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.mProcessorReport.mReportInfo.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.mProcessorReport.mReportInfo.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.mProcessorReport.mReportInfo.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.mProcessorReport.mReportInfo.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.mProcessorReport.mReportInfo.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.mProcessorReport.mReportInfo.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    this.mRSMReporter.mConnCost = ((String)paramHashMap.get("param_Ip_ConnCost"));
    this.mProcessorReport.mReportInfo.put("param_BDH_Cache_Diff", paramHashMap.get("param_BDH_Cache_Diff"));
    this.mProcessorReport.mReportInfo.put("param_is_ipv6", paramHashMap.get("param_is_ipv6"));
    this.mProcessorReport.mReportInfo.put("param_hasV6List", paramHashMap.get("param_hasV6List"));
    this.mProcessorReport.mReportInfo.put("param_ipv6First", paramHashMap.get("param_ipv6First"));
    this.reportTimeHt = this.mTrans.mTransReport.timeCost_Ht;
    this.reportTimePicCache = this.mTrans.mTransReport.timeCost_Cache;
  }
  
  public int cancel()
  {
    int i = super.cancel();
    recycleFD();
    return i;
  }
  
  protected void collectChnlCostReport()
  {
    if ((this.mChannelStatus == 1) && (this.mTrans != null)) {
      this.mProcessorReport.mReportInfo.put("X-piccachetime", String.valueOf(this.mTrans.mTransReport.timeCost_Cache));
    }
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
    paramArrayOfByte = localHttpNetReq.mReqProperties;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bytes=");
    localStringBuilder.append(this.mTransferedSize);
    localStringBuilder.append("-");
    paramArrayOfByte.put("Range", localStringBuilder.toString());
    localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
    return localHttpNetReq;
  }
  
  public void fixTimeAtPttPreSend()
  {
    this.mProcessorReport.mStartTime = System.nanoTime();
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
    //   1: getfield 291	com/tencent/mobileqq/transfile/BaseUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   4: getfield 352	com/tencent/mobileqq/transfile/TransferRequest:mLocalPath	Ljava/lang/String;
    //   7: astore 4
    //   9: new 354	java/io/FileInputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 356	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_0
    //   22: aload_3
    //   23: aload_0
    //   24: getfield 360	com/tencent/mobileqq/transfile/BaseUploadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   27: getfield 365	com/tencent/mobileqq/transfile/FileMsg:fileSize	J
    //   30: invokestatic 371	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   33: putfield 373	com/tencent/mobileqq/transfile/BaseUploadProcessor:mLocalMd5	[B
    //   36: goto +61 -> 97
    //   39: astore 4
    //   41: goto +173 -> 214
    //   44: aload_3
    //   45: astore_2
    //   46: new 375	java/io/File
    //   49: dup
    //   50: aload 4
    //   52: invokespecial 376	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore 4
    //   57: aload_3
    //   58: astore_2
    //   59: aload 4
    //   61: invokevirtual 379	java/io/File:exists	()Z
    //   64: istore_1
    //   65: iload_1
    //   66: ifeq +31 -> 97
    //   69: aload_3
    //   70: astore_2
    //   71: aload 4
    //   73: invokestatic 385	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   76: astore 4
    //   78: aload 4
    //   80: ifnull +199 -> 279
    //   83: goto +3 -> 86
    //   86: aload_3
    //   87: astore_2
    //   88: aload_0
    //   89: aload 4
    //   91: invokestatic 391	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   94: putfield 373	com/tencent/mobileqq/transfile/BaseUploadProcessor:mLocalMd5	[B
    //   97: aload_3
    //   98: astore_2
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 373	com/tencent/mobileqq/transfile/BaseUploadProcessor:mLocalMd5	[B
    //   104: invokestatic 394	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   107: putfield 396	com/tencent/mobileqq/transfile/BaseUploadProcessor:mFileName	Ljava/lang/String;
    //   110: aload_3
    //   111: astore_2
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 396	com/tencent/mobileqq/transfile/BaseUploadProcessor:mFileName	Ljava/lang/String;
    //   117: putfield 398	com/tencent/mobileqq/transfile/BaseUploadProcessor:mMd5Str	Ljava/lang/String;
    //   120: aload_3
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 360	com/tencent/mobileqq/transfile/BaseUploadProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   126: aload_0
    //   127: getfield 396	com/tencent/mobileqq/transfile/BaseUploadProcessor:mFileName	Ljava/lang/String;
    //   130: putfield 401	com/tencent/mobileqq/transfile/FileMsg:fileMd5	Ljava/lang/String;
    //   133: aload_3
    //   134: astore_2
    //   135: new 98	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   142: astore 4
    //   144: aload_3
    //   145: astore_2
    //   146: aload 4
    //   148: aload_0
    //   149: getfield 396	com/tencent/mobileqq/transfile/BaseUploadProcessor:mFileName	Ljava/lang/String;
    //   152: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_3
    //   157: astore_2
    //   158: aload 4
    //   160: ldc_w 403
    //   163: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_3
    //   168: astore_2
    //   169: aload 4
    //   171: aload_0
    //   172: getfield 405	com/tencent/mobileqq/transfile/BaseUploadProcessor:mExtName	Ljava/lang/String;
    //   175: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_3
    //   180: astore_2
    //   181: aload_0
    //   182: aload 4
    //   184: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: putfield 396	com/tencent/mobileqq/transfile/BaseUploadProcessor:mFileName	Ljava/lang/String;
    //   190: aload_3
    //   191: invokevirtual 408	java/io/FileInputStream:close	()V
    //   194: goto +8 -> 202
    //   197: astore_2
    //   198: aload_2
    //   199: invokevirtual 409	java/io/IOException:printStackTrace	()V
    //   202: iconst_1
    //   203: ireturn
    //   204: astore_2
    //   205: aconst_null
    //   206: astore_3
    //   207: goto +46 -> 253
    //   210: astore 4
    //   212: aconst_null
    //   213: astore_3
    //   214: aload_3
    //   215: astore_2
    //   216: aload_0
    //   217: aconst_null
    //   218: putfield 373	com/tencent/mobileqq/transfile/BaseUploadProcessor:mLocalMd5	[B
    //   221: aload_3
    //   222: astore_2
    //   223: aload_0
    //   224: aload 4
    //   226: invokevirtual 413	com/tencent/mobileqq/transfile/BaseUploadProcessor:analysisIOProblem	(Ljava/io/IOException;)V
    //   229: aload_3
    //   230: ifnull +14 -> 244
    //   233: aload_3
    //   234: invokevirtual 408	java/io/FileInputStream:close	()V
    //   237: iconst_0
    //   238: ireturn
    //   239: astore_2
    //   240: aload_2
    //   241: invokevirtual 409	java/io/IOException:printStackTrace	()V
    //   244: iconst_0
    //   245: ireturn
    //   246: astore 4
    //   248: aload_2
    //   249: astore_3
    //   250: aload 4
    //   252: astore_2
    //   253: aload_3
    //   254: ifnull +15 -> 269
    //   257: aload_3
    //   258: invokevirtual 408	java/io/FileInputStream:close	()V
    //   261: goto +8 -> 269
    //   264: astore_3
    //   265: aload_3
    //   266: invokevirtual 409	java/io/IOException:printStackTrace	()V
    //   269: aload_2
    //   270: athrow
    //   271: astore_2
    //   272: goto -228 -> 44
    //   275: astore_2
    //   276: goto -179 -> 97
    //   279: ldc_w 415
    //   282: astore 4
    //   284: goto -198 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	BaseUploadProcessor
    //   64	2	1	bool	boolean
    //   20	161	2	localObject1	Object
    //   197	2	2	localIOException1	IOException
    //   204	1	2	localObject2	Object
    //   215	8	2	localObject3	Object
    //   239	10	2	localIOException2	IOException
    //   252	18	2	localObject4	Object
    //   271	1	2	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   275	1	2	localIOException3	IOException
    //   18	240	3	localObject5	Object
    //   264	2	3	localIOException4	IOException
    //   7	7	4	str1	String
    //   39	12	4	localIOException5	IOException
    //   55	128	4	localObject6	Object
    //   210	15	4	localIOException6	IOException
    //   246	5	4	localObject7	Object
    //   282	1	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   21	36	39	java/io/IOException
    //   46	57	39	java/io/IOException
    //   59	65	39	java/io/IOException
    //   99	110	39	java/io/IOException
    //   112	120	39	java/io/IOException
    //   122	133	39	java/io/IOException
    //   135	144	39	java/io/IOException
    //   146	156	39	java/io/IOException
    //   158	167	39	java/io/IOException
    //   169	179	39	java/io/IOException
    //   181	190	39	java/io/IOException
    //   190	194	197	java/io/IOException
    //   9	19	204	finally
    //   9	19	210	java/io/IOException
    //   233	237	239	java/io/IOException
    //   21	36	246	finally
    //   46	57	246	finally
    //   59	65	246	finally
    //   71	78	246	finally
    //   88	97	246	finally
    //   99	110	246	finally
    //   112	120	246	finally
    //   122	133	246	finally
    //   135	144	246	finally
    //   146	156	246	finally
    //   158	167	246	finally
    //   169	179	246	finally
    //   181	190	246	finally
    //   216	221	246	finally
    //   223	229	246	finally
    //   257	261	264	java/io/IOException
    //   21	36	271	java/lang/UnsatisfiedLinkError
    //   71	78	275	java/io/IOException
    //   88	97	275	java/io/IOException
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
          this.mProcessorReport.setError(9303, "fileSize not enough", null, null);
          this.mProcessorReport.mStepTrans.logFinishTime();
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
  
  void onError()
  {
    super.onError();
    recycleFD();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    recycleFD();
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
  
  /* Error */
  protected void recycleFD()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 419	com/tencent/mobileqq/transfile/BaseUploadProcessor:mRaf	Ljava/io/RandomAccessFile;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +32 -> 38
    //   9: aload_1
    //   10: invokevirtual 522	java/io/RandomAccessFile:close	()V
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield 419	com/tencent/mobileqq/transfile/BaseUploadProcessor:mRaf	Ljava/io/RandomAccessFile;
    //   18: return
    //   19: astore_1
    //   20: goto +11 -> 31
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 409	java/io/IOException:printStackTrace	()V
    //   28: goto -15 -> 13
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 419	com/tencent/mobileqq/transfile/BaseUploadProcessor:mRaf	Ljava/io/RandomAccessFile;
    //   36: aload_1
    //   37: athrow
    //   38: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	BaseUploadProcessor
    //   4	6	1	localRandomAccessFile	RandomAccessFile
    //   19	1	1	localObject	Object
    //   23	14	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   9	13	19	finally
    //   24	28	19	finally
    //   9	13	23	java/io/IOException
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
    this.mRSMReporter.doReportForServerMonitor(paramString1, paramBoolean, this.mProcessorReport.reason, this.mProcessorReport.errDesc, this.mUiRequest.mUinType, this.mUiRequest.mPeerUin, true, this.mProcessorReport.mStepTrans);
  }
  
  public int resume()
  {
    return super.resume();
  }
  
  protected void sendFile()
  {
    this.mProcessorReport.mStepTrans.logStartTime();
    long l1 = this.mTransferedSize;
    long l2 = getBlockSize(l1);
    Object localObject = getStreamData((int)l1, (int)l2);
    if (localObject == null)
    {
      onError();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pos:");
    localStringBuilder.append(l1);
    localStringBuilder.append("  transferData len:");
    localStringBuilder.append(localObject.length);
    logRichMediaEvent("sendingdata", localStringBuilder.toString());
    localObject = constructHttpNetReq((byte[])localObject);
    if (l1 + l2 >= this.mFileSize) {
      ((HttpNetReq)localObject).mReqProperties.put("Connection", "close");
    }
    if (!canDoNextStep()) {
      return;
    }
    this.mNetReq = ((NetReq)localObject);
    setMtype();
    this.mNetEngine.sendReq((NetReq)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseUploadProcessor
 * JD-Core Version:    0.7.0.1
 */