package com.tencent.mobileqq.highway.transaction;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.netprobe.ProbeCallback;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.highway.netprobe.ProbeItem.ProbeResult;
import com.tencent.mobileqq.highway.netprobe.ProbeResponse;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.DataHole;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.QueryHoleRsp;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.RequestDataTrans;
import com.tencent.mobileqq.highway.segment.RequestFinishQuery;
import com.tencent.mobileqq.highway.segment.RequestInfoQuery;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.utils.BaseConstants.BdhBusinessType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.TransactionReport;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Transaction
  implements ProbeCallback
{
  public static final int HOLE_MASK_FIN = 3;
  public static final int HOLE_MASK_HOLD = 4;
  public static final int HOLE_MASK_INIT = 0;
  public static final int HOLE_MASK_SENT = 2;
  public static final int HOLE_MASK_WAIT = 1;
  public static final int HOLE_SIZE_PER_HOLE = 8192;
  private static final int MAX_QUERY_HOLE_RSP_SIZE = 5;
  public static final long waitForSessionkeyTimeout = 30000L;
  public byte[] MD5;
  public Tracker TRACKER;
  private AtomicBoolean TimerStarted = new AtomicBoolean(false);
  public volatile boolean bQueryForFIN;
  public byte[] bitmap;
  public int cacheIp;
  ITransactionCallback cb;
  public ITransCallbackForReport cbForReport;
  public byte[] extendInfo;
  public String filePath;
  public AtomicBoolean hasSwitch2BackupChannel = new AtomicBoolean(false);
  public AtomicBoolean isFinish = new AtomicBoolean(false);
  public boolean isOpenUpEnable;
  public AtomicBoolean isSuccess = new AtomicBoolean(false);
  public CSDataHighwayHead.LoginSigHead loginSigHead;
  public byte[] mBuExtendinfo;
  public int mBuzCmdId;
  public int mCurrentQueryFinishCount;
  public int mErrorCode = -1;
  private AtomicBoolean mIsPause = new AtomicBoolean(false);
  public String mMD5Str;
  boolean mNeedSegmentLikeVideo = false;
  private HashMap<String, String> mReport = new HashMap();
  public Transaction.TransTimeOutMonitor mTimeOutMonitor;
  public TransReport mTransReport = new TransReport();
  private TransactionWorker mTransWorker;
  boolean needCryptExtendInfo = false;
  public int offset;
  public String peerUin;
  public int preSendDots;
  private RandomAccessFile raf;
  public int reUploadHwSeq;
  public boolean reUploadTransaction;
  private ConcurrentHashMap<Integer, HwRequest> sentRequestsRetry = new ConcurrentHashMap();
  public long startTime;
  public byte[] ticket;
  public int totalLength;
  int transationId = -1;
  private int transferedSize;
  public int transferedSizeBDH;
  
  /* Error */
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, ITransactionCallback paramITransactionCallback, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: aload_3
    //   4: iload 4
    //   6: aconst_null
    //   7: aload 5
    //   9: aload 6
    //   11: invokespecial 86	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;)V
    //   14: aload_0
    //   15: aload 7
    //   17: putfield 88	com/tencent/mobileqq/highway/transaction/Transaction:extendInfo	[B
    //   20: aload_0
    //   21: iload 8
    //   23: putfield 90	com/tencent/mobileqq/highway/transaction/Transaction:needCryptExtendInfo	Z
    //   26: ldc 92
    //   28: monitorenter
    //   29: aload_1
    //   30: invokestatic 96	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   33: invokevirtual 100	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +83 -> 121
    //   41: aload_3
    //   42: arraylength
    //   43: ifeq +78 -> 121
    //   46: aload_3
    //   47: arraylength
    //   48: istore_2
    //   49: aload_0
    //   50: iload_2
    //   51: newarray byte
    //   53: putfield 102	com/tencent/mobileqq/highway/transaction/Transaction:ticket	[B
    //   56: aload_3
    //   57: iconst_0
    //   58: aload_0
    //   59: getfield 102	com/tencent/mobileqq/highway/transaction/Transaction:ticket	[B
    //   62: iconst_0
    //   63: iload_2
    //   64: invokestatic 108	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   67: iload 8
    //   69: ifeq +52 -> 121
    //   72: aload_1
    //   73: invokestatic 96	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   76: invokevirtual 111	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +44 -> 125
    //   84: aload_1
    //   85: arraylength
    //   86: ifeq +39 -> 125
    //   89: aload_1
    //   90: arraylength
    //   91: istore_2
    //   92: iload_2
    //   93: newarray byte
    //   95: astore_3
    //   96: aload_1
    //   97: iconst_0
    //   98: aload_3
    //   99: iconst_0
    //   100: iload_2
    //   101: invokestatic 108	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   104: aload_0
    //   105: new 113	com/tencent/qphone/base/util/Cryptor
    //   108: dup
    //   109: invokespecial 116	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   112: aload 7
    //   114: aload_3
    //   115: invokevirtual 120	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   118: putfield 88	com/tencent/mobileqq/highway/transaction/Transaction:extendInfo	[B
    //   121: ldc 92
    //   123: monitorexit
    //   124: return
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 102	com/tencent/mobileqq/highway/transaction/Transaction:ticket	[B
    //   130: goto -9 -> 121
    //   133: astore_1
    //   134: ldc 92
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	Transaction
    //   0	139	1	paramString1	String
    //   0	139	2	paramInt1	int
    //   0	139	3	paramString2	String
    //   0	139	4	paramInt2	int
    //   0	139	5	paramArrayOfByte1	byte[]
    //   0	139	6	paramITransactionCallback	ITransactionCallback
    //   0	139	7	paramArrayOfByte2	byte[]
    //   0	139	8	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   29	37	133	finally
    //   41	67	133	finally
    //   72	80	133	finally
    //   84	121	133	finally
    //   121	124	133	finally
    //   125	130	133	finally
    //   134	137	133	finally
  }
  
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ITransactionCallback paramITransactionCallback)
  {
    this.peerUin = paramString1;
    this.filePath = paramString2;
    this.offset = paramInt2;
    this.mBuzCmdId = paramInt1;
    this.MD5 = paramArrayOfByte2;
    this.ticket = paramArrayOfByte1;
    this.cb = paramITransactionCallback;
    if (this.offset < 0) {
      this.offset = 0;
    }
    this.isOpenUpEnable = false;
    this.mMD5Str = BdhUtils.bytes2HexStr(paramArrayOfByte2);
  }
  
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ITransactionCallback paramITransactionCallback, int paramInt3, byte[] paramArrayOfByte3, CSDataHighwayHead.LoginSigHead paramLoginSigHead)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramITransactionCallback);
    this.isOpenUpEnable = true;
    this.preSendDots = paramInt3;
    this.extendInfo = paramArrayOfByte3;
    this.loginSigHead = paramLoginSigHead;
  }
  
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ITransactionCallback paramITransactionCallback, byte[] paramArrayOfByte3)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramITransactionCallback);
    this.extendInfo = paramArrayOfByte3;
  }
  
  private void extendTimeExceedLimit()
  {
    Transaction.TransTimeOutMonitor localTransTimeOutMonitor = this.mTimeOutMonitor;
    if (localTransTimeOutMonitor.needExtendTimeExceedLimit())
    {
      BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " ExtendTimeExceedLimit.");
      localTransTimeOutMonitor.isKilled = true;
      if (this.mTransWorker != null)
      {
        this.mTimeOutMonitor = new Transaction.TransTimeOutMonitor(this);
        this.mTransWorker.startTransRunnable(localTransTimeOutMonitor, this.mTimeOutMonitor);
      }
    }
  }
  
  private void finishAndDetachFromWorker(boolean paramBoolean)
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "Finish. IsSuccess:" + paramBoolean);
    if (this.mTransWorker != null)
    {
      this.mTransWorker.onTransactionFinish(paramBoolean, this);
      this.mTransWorker = null;
    }
    try
    {
      if (this.raf != null)
      {
        this.raf.close();
        this.raf = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      BdhLogUtil.LogException("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "Finish Error: IsSuccess:" + paramBoolean, localIOException);
    }
  }
  
  private boolean isPause()
  {
    return this.mIsPause.get();
  }
  
  private void stopTimeoutTimer()
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " StopTimeoutTime.");
    this.TimerStarted.set(false);
    if (this.mTimeOutMonitor != null) {
      this.mTimeOutMonitor.isKilled = true;
    }
    if (this.mTransWorker != null) {
      this.mTransWorker.stopTransRunnable(this.mTimeOutMonitor);
    }
  }
  
  private HashMap<String, String> updateAndGetReporter()
  {
    this.mTransReport.ipConnCost = this.mTransWorker.getIpConnectCost();
    this.mTransReport.dataFlow = this.mTransWorker.getReportDataFlow();
    this.mTransReport.ipAddr = this.mTransWorker.getLastUsedIp();
    this.mTransReport.port = this.mTransWorker.getLastUsedPort();
    this.mTransReport.mTransferedSize = this.transferedSize;
    return this.mTransReport.getReportInfo();
  }
  
  public void cancelTransaction()
  {
    if (!this.isFinish.compareAndSet(false, true)) {}
    while (this.TRACKER == null) {
      return;
    }
    this.TRACKER.logStep("CANCL", "");
    stopTimeoutTimer();
    finishAndDetachFromWorker(false);
  }
  
  public void continueTrans()
  {
    QLog.d("BDH_LOG", 1, "T \tT_ID:" + getTransationId() + "\tcontinueTrans.");
    if (this.isFinish.get()) {
      return;
    }
    int j = this.totalLength / 8192;
    int i = j;
    if (this.totalLength % 8192 != 0) {
      i = j + 1;
    }
    j = this.preSendDots;
    while (j < i)
    {
      if (this.bitmap[j] == 4) {
        this.bitmap[j] = 0;
      }
      j += 1;
    }
    this.mTransWorker.notifyToSend();
  }
  
  public int getBuzType()
  {
    if (this.mNeedSegmentLikeVideo) {}
    while ((this.mBuzCmdId == 12) || (this.mBuzCmdId == 25)) {
      return 1;
    }
    if ((this.mBuzCmdId == 1) || (this.mBuzCmdId == 4)) {
      return 0;
    }
    return 0;
  }
  
  public byte[] getData(DataTransInfo paramDataTransInfo)
  {
    int j = 0;
    Object localObject = null;
    for (;;)
    {
      int i;
      int k;
      try
      {
        if (this.isFinish.get())
        {
          paramDataTransInfo.errno = 0;
          paramDataTransInfo = localObject;
          return paramDataTransInfo;
        }
        try
        {
          i = paramDataTransInfo.length;
          byte[] arrayOfByte = new byte[paramDataTransInfo.length];
          this.raf.seek(paramDataTransInfo.offset);
          if (j >= paramDataTransInfo.length) {
            break label176;
          }
          k = this.raf.read(arrayOfByte, j, i);
          if (k != -1) {
            break label163;
          }
          paramDataTransInfo.errno = 9303;
          paramDataTransInfo = localObject;
        }
        catch (IOException localIOException)
        {
          BdhLogUtil.LogException("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "GetData Error.", localIOException);
          paramDataTransInfo.errno = BdhUtils.analysisIOProblem(localIOException);
          paramDataTransInfo = localObject;
        }
        continue;
        j += k;
      }
      finally {}
      label163:
      i -= k;
      continue;
      label176:
      paramDataTransInfo = localIOException;
    }
  }
  
  public ConcurrentHashMap<Integer, HwRequest> getRetryRequests()
  {
    return this.sentRequestsRetry;
  }
  
  public int getTransationId()
  {
    return this.transationId;
  }
  
  int initSegmentList(TransactionWorker paramTransactionWorker, boolean paramBoolean)
  {
    int i = 9042;
    QLog.d("BDH_LOG", 1, "T T_ID:" + getTransationId() + "\tinitSegmentList : \tisOpenUpEnable : " + this.isOpenUpEnable);
    this.mTransReport.mIsPreConnExist = paramBoolean;
    File localFile = new File(this.filePath);
    this.mTransWorker = paramTransactionWorker;
    if (localFile.exists())
    {
      if (!localFile.canRead()) {
        i = 9070;
      }
    }
    else {
      return i;
    }
    this.totalLength = ((int)localFile.length());
    if (this.totalLength <= 0) {
      return 9071;
    }
    try
    {
      this.raf = new RandomAccessFile(localFile, "r");
      int j = this.totalLength / 8192;
      i = j;
      if (this.totalLength % 8192 != 0) {
        i = j + 1;
      }
      int k = this.offset / 8192;
      this.bitmap = new byte[i];
      if (this.isOpenUpEnable)
      {
        j = 0;
        if (j < i)
        {
          if (j < this.preSendDots) {
            this.bitmap[j] = 0;
          }
          for (;;)
          {
            j += 1;
            break;
            this.bitmap[j] = 4;
          }
        }
      }
      else
      {
        j = 0;
        if (j < i)
        {
          if (j < k) {
            this.bitmap[j] = 3;
          }
          for (;;)
          {
            j += 1;
            break;
            this.bitmap[j] = 0;
          }
        }
      }
      this.TRACKER = new Tracker(this.transationId, this.totalLength);
      this.mTimeOutMonitor = new Transaction.TransTimeOutMonitor(this);
      this.TRACKER.logStep("INITI", "DotsNum:" + i + " StartHole:" + k);
      return 0;
    }
    catch (FileNotFoundException paramTransactionWorker) {}
    return 9042;
  }
  
  void needBDHReport(HashMap<String, String> paramHashMap)
  {
    int j = 0;
    if (this.mCurrentQueryFinishCount > 0) {
      TransactionReport.reportQueryFinishQuality(this, this.mCurrentQueryFinishCount);
    }
    paramHashMap = BaseConstants.BdhBusinessType.reportBDHExcept;
    int k = paramHashMap.length;
    int i = 0;
    if (i < k) {
      if (paramHashMap[i] != this.mBuzCmdId) {}
    }
    for (i = j;; i = 1)
    {
      if (i == 0) {}
      while ((this.startTime == 0L) || (this.totalLength == 0) || (this.mTransWorker == null))
      {
        return;
        i += 1;
        break;
      }
      TransactionReport.reportFunction("actBDHTask", this, null);
      return;
    }
  }
  
  public void onProbeFinish(ProbeResponse paramProbeResponse)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    Iterator localIterator1 = paramProbeResponse.mProbeItemResults.keySet().iterator();
    while (localIterator1.hasNext())
    {
      paramProbeResponse = (ProbeItem)localIterator1.next();
      if ("ProbeChain".equals(paramProbeResponse.getProbeName()))
      {
        Iterator localIterator2 = ((ProbeChain)paramProbeResponse).chain.iterator();
        label68:
        ProbeItem localProbeItem;
        StringBuilder localStringBuilder2;
        while (localIterator2.hasNext())
        {
          localProbeItem = (ProbeItem)localIterator2.next();
          if (localProbeItem.mResult != null)
          {
            localStringBuilder2 = localStringBuilder1.append(localProbeItem.getProbeName()).append("[");
            if (!localProbeItem.mResult.success) {
              break label169;
            }
          }
        }
        label169:
        for (paramProbeResponse = "1";; paramProbeResponse = "0")
        {
          localStringBuilder2.append(paramProbeResponse).append("]").append("[").append(localProbeItem.mResult.errCode).append("];");
          break label68;
          break;
        }
      }
    }
    paramProbeResponse = (String)this.mReport.get("rep_bdhTrans");
    if (paramProbeResponse != null)
    {
      paramProbeResponse = paramProbeResponse + localStringBuilder1;
      this.mReport.put("rep_bdhTrans", paramProbeResponse);
    }
    if (this.cb != null) {
      this.cb.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
    }
  }
  
  public void onProbeProgress(String paramString) {}
  
  public void onQuertHoleError(byte[] paramArrayOfByte)
  {
    if (this.isFinish.get()) {
      return;
    }
    BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " QueryDebug Query OnQuertHoleError : CopyBitmap:" + Arrays.toString(paramArrayOfByte) + " CurrentBitmap:" + Arrays.toString(this.bitmap));
    int i = 0;
    while (i < this.bitmap.length)
    {
      if ((this.bitmap[i] != 3) && (paramArrayOfByte[i] == 2)) {
        this.bitmap[i] = 0;
      }
      i += 1;
    }
    this.TRACKER.logStep("QUERY", "QueryHoleError Bitmap:" + Arrays.toString(this.bitmap));
    this.mTransWorker.notifyToSend();
  }
  
  public void onQueryHoleResp(CSDataHighwayHead.QueryHoleRsp paramQueryHoleRsp, byte[] paramArrayOfByte, boolean paramBoolean, HwResponse paramHwResponse, RequestInfoQuery paramRequestInfoQuery)
  {
    if (this.isFinish.get()) {
      return;
    }
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + " \tT_ID:" + getTransationId() + "\tQueryHoleResp");
    int i = paramQueryHoleRsp.uint32_result.get();
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    BdhUtils.copyData(arrayOfByte, 0, paramArrayOfByte, 0, paramArrayOfByte.length);
    if (i != 0)
    {
      onQuertHoleError(paramArrayOfByte);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Holes:");
    paramQueryHoleRsp = paramQueryHoleRsp.rpt_data_hole.get();
    int m;
    int n;
    int j;
    int k;
    if ((paramQueryHoleRsp != null) && (!paramQueryHoleRsp.isEmpty()))
    {
      paramHwResponse = paramQueryHoleRsp.iterator();
      i = 0;
      if (paramHwResponse.hasNext())
      {
        paramRequestInfoQuery = (CSDataHighwayHead.DataHole)paramHwResponse.next();
        m = (int)paramRequestInfoQuery.uint64_begin.get();
        n = (int)paramRequestInfoQuery.uint64_end.get();
        j = m / 8192;
        k = (n - 1) / 8192;
        if (k <= i) {
          break label732;
        }
        i = k;
      }
    }
    label732:
    for (;;)
    {
      localStringBuilder.append("Holes Start:").append(j).append(" End:").append(k);
      BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnQueryHoleResp : holes :  HoleStart:" + m + " HoleEnd:" + n + " BitmapS:" + j + " BitmapE:" + k);
      while (j <= k)
      {
        if (paramArrayOfByte[j] == 2) {
          paramArrayOfByte[j] = 0;
        }
        j += 1;
      }
      break;
      j = i;
      if (i >= paramArrayOfByte.length) {
        j = paramArrayOfByte.length - 1;
      }
      if (paramQueryHoleRsp.size() >= 5) {
        while (j < paramArrayOfByte.length)
        {
          paramArrayOfByte[j] = 0;
          j += 1;
        }
      }
      i = 0;
      if (i < paramArrayOfByte.length)
      {
        if ((arrayOfByte[i] == 2) && (paramArrayOfByte[i] == 0) && ((this.bQueryForFIN) || (this.bitmap[i] != 3))) {
          this.bitmap[i] = 0;
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramArrayOfByte[i] == 2) {
            this.bitmap[i] = 3;
          }
        }
      }
      this.bQueryForFIN = false;
      this.mCurrentQueryFinishCount = 0;
      for (;;)
      {
        this.TRACKER.logStep("QUERY", "QueryHoleResp " + localStringBuilder.toString());
        BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnQueryHoleResp : Merged : CopyBitmap:" + Arrays.toString(paramArrayOfByte) + " CurrentBitmap:" + Arrays.toString(this.bitmap));
        this.mTransWorker.notifyToSend();
        return;
        localStringBuilder.append("null");
        BdhLogUtil.LogEvent("R", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " finish flag is null and hole is null mCurrentQueryFinishCount:" + this.mCurrentQueryFinishCount + " bQueryForFIN:" + this.bQueryForFIN);
        if (this.bQueryForFIN) {
          if (this.mCurrentQueryFinishCount < RequestFinishQuery.QUERY_HOLE_MAX_COUNT) {
            queryTransactionFinish();
          } else {
            onTransFailed(9306, "QueryFinishFail", paramHwResponse.retCode, paramHwResponse.buzRetCode, paramRequestInfoQuery.retryCount, paramHwResponse.mBuExtendinfo);
          }
        }
      }
    }
  }
  
  public void onRequestFailed(int paramInt)
  {
    if (this.cbForReport != null) {
      this.cbForReport.onFailed(paramInt, this.mTransWorker.getLastUsedIp(), this.mTransWorker.getLastUsedPort());
    }
  }
  
  public void onSwitchToBackupChannel()
  {
    stopTimeoutTimer();
    if (this.hasSwitch2BackupChannel.get()) {}
    do
    {
      return;
      this.hasSwitch2BackupChannel.set(true);
    } while (this.cb == null);
    this.cb.onSwitch2BackupChannel();
  }
  
  public void onTransFailed(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    if (!this.isFinish.compareAndSet(false, true)) {}
    label118:
    do
    {
      return;
      BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnTransFailed : ERR_C:" + paramInt1 + " ERR_H:" + paramInt2 + " ERR_B:" + paramInt3);
      stopTimeoutTimer();
      this.mTransReport.updateRetryInfo(paramInt4);
      this.mBuExtendinfo = paramArrayOfByte;
      this.mErrorCode = paramInt1;
      if (paramInt3 != 0)
      {
        this.mErrorCode = paramInt3;
        if (this.mTransWorker != null)
        {
          this.mTransReport.bHasNet = this.mTransWorker.updateAndCheckNet();
          this.mTransReport.isConnected = this.mTransWorker.isNetworkConnected();
          this.mTransReport.connErrCode = this.mTransWorker.getConnErroCode();
          this.mTransReport.setFailReason(this.mErrorCode, paramString);
          if ((this.mErrorCode == -1002) || (this.mErrorCode == -1005))
          {
            this.mTransWorker.dumpEngineInfo();
            paramString = this.TRACKER.dumpTrackerInfo();
            this.TRACKER.logStep("QUERY", "TransFailed  Bitmap:" + Arrays.toString(this.bitmap));
            QLog.d("T", 1, "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " TRACEKERINFO:" + paramString);
            if (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode)) {
              this.mErrorCode = 9004;
            }
          }
          if ((this.mBuzCmdId != 1) && (this.mBuzCmdId != 2) && (this.mBuzCmdId != 4)) {
            break label539;
          }
          if ((this.mTransReport.bHasNet) && (!BdhUtils.isNetWorkProb(this.mTransReport.connErrCode))) {
            break label489;
          }
          this.mErrorCode = 9004;
        }
      }
      for (;;)
      {
        this.mReport = updateAndGetReporter();
        needBDHReport(this.mReport);
        if ((!this.mTransReport.bHasNet) || ((paramInt1 != -1002) && (paramInt1 != -1005) && (paramInt1 != -1003) && (paramInt1 != -1014))) {
          break label572;
        }
        boolean bool = this.mTransWorker.startNetDetection(this);
        finishAndDetachFromWorker(false);
        if ((bool) || (this.cb == null)) {
          break;
        }
        this.cb.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
        return;
        if (paramInt2 == 0) {
          break label118;
        }
        this.mErrorCode = paramInt2;
        break label118;
        if ((this.mErrorCode <= 0) && ((!this.mTransReport.bHasNet) || (!this.mTransReport.isConnected) || (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode))))
        {
          this.mErrorCode = 9004;
          continue;
          if ((!this.mTransReport.bHasNet) || (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode))) {
            this.mErrorCode = 9004;
          }
        }
      }
      finishAndDetachFromWorker(false);
    } while (this.cb == null);
    label489:
    this.cb.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
    label539:
    label572:
    return;
  }
  
  public void onTransProgress(RequestDataTrans paramRequestDataTrans, HwResponse paramHwResponse)
  {
    if (this.isFinish.get()) {}
    do
    {
      int m;
      int n;
      do
      {
        return;
        paramRequestDataTrans = paramRequestDataTrans.mInfo;
        extendTimeExceedLimit();
        this.mTransReport.updateRetryInfo(paramRequestDataTrans.retryTimes);
        if (paramRequestDataTrans != null)
        {
          paramHwResponse = this.mTransReport;
          paramHwResponse.timeCost_Send = ((int)(paramHwResponse.timeCost_Send + (paramRequestDataTrans.timeCost_req - paramRequestDataTrans.timeCost_hw - paramRequestDataTrans.timeCost_cache)));
          paramHwResponse = this.mTransReport;
          paramHwResponse.timeCost_Ht = ((int)(paramHwResponse.timeCost_Ht + paramRequestDataTrans.timeCost_hw));
          paramHwResponse = this.mTransReport;
          paramHwResponse.timeCost_Cache = ((int)(paramHwResponse.timeCost_Cache + paramRequestDataTrans.timeCost_cache));
        }
        m = paramRequestDataTrans.bitmapS;
        n = paramRequestDataTrans.bitmapE;
      } while (n >= this.bitmap.length);
      int i = m;
      while (i <= n)
      {
        this.bitmap[i] = 3;
        i += 1;
      }
      i = 0;
      int k;
      for (int j = 0; i < this.bitmap.length; j = k)
      {
        k = j;
        if (this.bitmap[i] == 3) {
          k = j + 1;
        }
        i += 1;
      }
      this.transferedSize = (j * 8192);
      if (this.bitmap[(this.bitmap.length - 1)] == 3) {
        this.transferedSize -= this.bitmap.length * 8192 - this.totalLength;
      }
      if (this.transferedSizeBDH - this.transferedSize > this.totalLength / 10)
      {
        j = this.transferedSizeBDH / 8192;
        i = 0;
        while (i < j)
        {
          this.bitmap[i] = 3;
          i += 1;
        }
        this.mTransWorker.getHwEngine().mRequestWorker.remove2SENDRequest(this.transationId, j);
        BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "UpdateTransferedSizeToServerRange,local size:" + this.transferedSize + " server size:" + this.transferedSizeBDH);
      }
      if (this.transferedSize >= this.totalLength)
      {
        BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "NotifySegmentProgress Error : Finish flag is lost.");
        this.mTransReport.bFINLost = true;
      }
      if (this.cb != null)
      {
        BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " NotifySegmentProgress Total:" + this.totalLength + " TransSize:" + this.transferedSize + " allHoles:" + this.bitmap.length + " [" + m + ":" + n + "]");
        this.cb.onUpdateProgress(this.transferedSize);
      }
      this.TRACKER.logStep("PRGRS", "TransProgress Start:" + m + " End:" + n);
    } while ((!this.mTransReport.bFINLost) || (this.bQueryForFIN));
    this.bQueryForFIN = true;
    this.mTransReport.bFINLost = false;
    queryTransactionFinish();
    this.TRACKER.logStep("QUERY", "FinFlagLost  Bitmap:" + Arrays.toString(this.bitmap));
  }
  
  public void onTransReUpload(int paramInt)
  {
    this.reUploadTransaction = true;
    this.reUploadHwSeq = paramInt;
    this.transferedSizeBDH = 0;
    extendTimeExceedLimit();
    int i = this.totalLength / 8192;
    paramInt = i;
    if (this.totalLength % 8192 != 0) {
      paramInt = i + 1;
    }
    this.mTransWorker.getHwEngine().mRequestWorker.remove2SENDRequest(this.transationId, paramInt);
    i = 0;
    while (i < paramInt)
    {
      this.bitmap[i] = 0;
      i += 1;
    }
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "reUpload long video");
    this.TRACKER.logStep("REUPLOAD", "ReUpload trasaction");
    this.mTransReport.hasReUpload = true;
  }
  
  public void onTransSuccess(DataTransInfo paramDataTransInfo, byte[] paramArrayOfByte)
  {
    BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " NotifySegmentSuccess");
    if (!this.isFinish.compareAndSet(false, true)) {}
    do
    {
      return;
      this.isSuccess.set(true);
      stopTimeoutTimer();
      if (paramDataTransInfo != null) {
        this.mTransReport.updateRetryInfo(paramDataTransInfo.retryTimes);
      }
      if (paramDataTransInfo != null)
      {
        TransReport localTransReport = this.mTransReport;
        localTransReport.timeCost_Send = ((int)(localTransReport.timeCost_Send + (paramDataTransInfo.timeCost_req - paramDataTransInfo.timeCost_hw - paramDataTransInfo.timeCost_cache)));
        localTransReport = this.mTransReport;
        localTransReport.timeCost_Ht = ((int)(localTransReport.timeCost_Ht + paramDataTransInfo.timeCost_hw));
        localTransReport = this.mTransReport;
        localTransReport.timeCost_Cache = ((int)(localTransReport.timeCost_Cache + paramDataTransInfo.timeCost_cache));
      }
      this.mBuExtendinfo = paramArrayOfByte;
      this.transferedSize = this.totalLength;
      paramDataTransInfo = updateAndGetReporter();
      needBDHReport(paramDataTransInfo);
      finishAndDetachFromWorker(true);
    } while (this.cb == null);
    this.cb.onSuccess(this.mBuExtendinfo, paramDataTransInfo);
  }
  
  DataTransInfo peekNextSegment(HwNetSegConf paramHwNetSegConf)
  {
    int j = (int)paramHwNetSegConf.segSize;
    if ((this.isFinish.get()) || (isPause())) {
      return null;
    }
    if ((this.mTransReport.confSegSize == 0L) && (paramHwNetSegConf != null))
    {
      this.mTransReport.confSegSize = ((int)paramHwNetSegConf.segSize);
      this.mTransReport.confSegNum = ((int)paramHwNetSegConf.segNum);
      this.mTransReport.confConnNum = ((int)paramHwNetSegConf.curConnNum);
    }
    int i = j / 8192;
    int m = i;
    if (j % 8192 > 0) {
      m = i + 1;
    }
    i = 0;
    j = -1;
    int k;
    int n;
    if (i < this.bitmap.length) {
      if (this.bitmap[i] == 0)
      {
        k = j;
        if (j == -1) {
          k = i;
        }
        if (i != this.bitmap.length - 1)
        {
          n = k;
          if (m != i + 1 - k) {
            break label334;
          }
        }
        j = k;
      }
    }
    for (;;)
    {
      label164:
      if ((j != -1) && (i != -1))
      {
        paramHwNetSegConf = this.mTransReport;
        paramHwNetSegConf.sliceNum += 1;
        paramHwNetSegConf = new DataTransInfo(this);
        paramHwNetSegConf.fileSize = this.totalLength;
        paramHwNetSegConf.offset = (j * 8192);
        paramHwNetSegConf.bitmapS = j;
        paramHwNetSegConf.bitmapE = i;
        if (i == this.bitmap.length - 1)
        {
          paramHwNetSegConf.length = ((i - j) * 8192 + (this.totalLength - (this.bitmap.length - 1) * 8192));
          k = j;
          for (;;)
          {
            if (k <= i)
            {
              this.bitmap[k] = 1;
              k += 1;
              continue;
              if ((this.isOpenUpEnable) && (this.bitmap[i] == 4))
              {
                if (j == -1) {
                  break label421;
                }
                i -= 1;
              }
            }
          }
        }
      }
      for (;;)
      {
        label264:
        stopTimeoutTimer();
        break label164;
        n = j;
        if (j != -1) {
          break label164;
        }
        label334:
        i += 1;
        j = n;
        break;
        paramHwNetSegConf.length = ((i - j + 1) * 8192);
        break label264;
        this.TRACKER.logStep("SLICE", "Start:" + j + " End:" + i + " Length:" + paramHwNetSegConf.length);
        startTimeoutTimer();
        return paramHwNetSegConf;
        return null;
        label421:
        i = -1;
      }
      i = -1;
    }
  }
  
  public void queryTransactionFinish()
  {
    byte[] arrayOfByte = new byte[this.bitmap.length];
    int i = 0;
    while (i <= this.bitmap.length - 1)
    {
      arrayOfByte[i] = 2;
      i += 1;
    }
    this.mTransWorker.getHwEngine().mRequestWorker.sendInfoQueryFinish(this, arrayOfByte, this.mCurrentQueryFinishCount);
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.mIsPause.set(paramBoolean);
    if (isPause()) {
      stopTimeoutTimer();
    }
  }
  
  public void setVideoSegmentMode(boolean paramBoolean)
  {
    this.mNeedSegmentLikeVideo = paramBoolean;
  }
  
  void startTimeoutTimer()
  {
    if (this.TimerStarted.compareAndSet(false, true))
    {
      BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "startTimeoutTimer.");
      Object localObject = this.cb;
      if (localObject != null) {
        ((ITransactionCallback)localObject).onTransStart();
      }
      if (this.mTransWorker != null)
      {
        localObject = this.mTimeOutMonitor;
        ((Transaction.TransTimeOutMonitor)localObject).isKilled = true;
        this.mTimeOutMonitor = new Transaction.TransTimeOutMonitor(this);
        this.mTransWorker.startTransRunnable((Runnable)localObject, this.mTimeOutMonitor);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.Transaction
 * JD-Core Version:    0.7.0.1
 */