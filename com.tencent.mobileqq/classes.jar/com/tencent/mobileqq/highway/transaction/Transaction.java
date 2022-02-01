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
import com.tencent.mobileqq.highway.openup.SessionInfo;
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
import com.tencent.qphone.base.util.Cryptor;
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
  public Tracker TRACKER = null;
  private AtomicBoolean TimerStarted = new AtomicBoolean(false);
  public volatile boolean bQueryForFIN = false;
  public byte[] bitmap;
  public CacheIpInfo cacheIpInfo;
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
  public int mCurrentQueryFinishCount = 0;
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
  public int reUploadHwSeq = 0;
  public boolean reUploadTransaction = false;
  private ConcurrentHashMap<Integer, HwRequest> sentRequestsRetry = new ConcurrentHashMap();
  public long startTime;
  public byte[] ticket;
  public int totalLength = 0;
  int transationId = -1;
  private int transferedSize = 0;
  public int transferedSizeBDH = 0;
  
  public Transaction(String paramString1, int paramInt1, String paramString2, int paramInt2, byte[] paramArrayOfByte1, ITransactionCallback paramITransactionCallback, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, null, paramArrayOfByte1, paramITransactionCallback);
    this.extendInfo = paramArrayOfByte2;
    this.needCryptExtendInfo = paramBoolean;
    try
    {
      paramString2 = SessionInfo.getInstance(paramString1).getHttpconn_sig_session();
      if ((paramString2 != null) && (paramString2.length != 0))
      {
        paramInt1 = paramString2.length;
        this.ticket = new byte[paramInt1];
        System.arraycopy(paramString2, 0, this.ticket, 0, paramInt1);
        if (paramBoolean)
        {
          paramString1 = SessionInfo.getInstance(paramString1).getSessionKey();
          if ((paramString1 != null) && (paramString1.length != 0))
          {
            paramInt1 = paramString1.length;
            paramString2 = new byte[paramInt1];
            System.arraycopy(paramString1, 0, paramString2, 0, paramInt1);
            this.extendInfo = new Cryptor().encrypt(paramArrayOfByte2, paramString2);
          }
          else
          {
            this.ticket = null;
          }
        }
      }
      return;
    }
    finally {}
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("B_ID:");
      localStringBuilder.append(this.mBuzCmdId);
      localStringBuilder.append("\tT_ID:");
      localStringBuilder.append(getTransationId());
      localStringBuilder.append(" ExtendTimeExceedLimit.");
      BdhLogUtil.LogEvent("T", localStringBuilder.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("B_ID:");
    ((StringBuilder)localObject).append(this.mBuzCmdId);
    ((StringBuilder)localObject).append("\tT_ID:");
    ((StringBuilder)localObject).append(getTransationId());
    ((StringBuilder)localObject).append("Finish. IsSuccess:");
    ((StringBuilder)localObject).append(paramBoolean);
    BdhLogUtil.LogEvent("T", ((StringBuilder)localObject).toString());
    localObject = this.mTransWorker;
    if (localObject != null)
    {
      ((TransactionWorker)localObject).onTransactionFinish(paramBoolean, this);
      this.mTransWorker = null;
    }
    try
    {
      if (this.raf != null)
      {
        this.raf.close();
        this.raf = null;
        return;
      }
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("B_ID:");
      localStringBuilder.append(this.mBuzCmdId);
      localStringBuilder.append("\tT_ID:");
      localStringBuilder.append(getTransationId());
      localStringBuilder.append("Finish Error: IsSuccess:");
      localStringBuilder.append(paramBoolean);
      BdhLogUtil.LogException("T", localStringBuilder.toString(), localIOException);
    }
  }
  
  private boolean isPause()
  {
    return this.mIsPause.get();
  }
  
  private void stopTimeoutTimer()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("B_ID:");
    ((StringBuilder)localObject).append(this.mBuzCmdId);
    ((StringBuilder)localObject).append("\tT_ID:");
    ((StringBuilder)localObject).append(getTransationId());
    ((StringBuilder)localObject).append(" StopTimeoutTime.");
    BdhLogUtil.LogEvent("T", ((StringBuilder)localObject).toString());
    this.TimerStarted.set(false);
    localObject = this.mTimeOutMonitor;
    if (localObject != null) {
      ((Transaction.TransTimeOutMonitor)localObject).isKilled = true;
    }
    localObject = this.mTransWorker;
    if (localObject != null) {
      ((TransactionWorker)localObject).stopTransRunnable(this.mTimeOutMonitor);
    }
  }
  
  private HashMap<String, String> updateAndGetReporter()
  {
    this.mTransReport.ipConnCost = this.mTransWorker.getIpConnectCost();
    this.mTransReport.dataFlow = this.mTransWorker.getReportDataFlow();
    this.mTransReport.ipAddr = this.mTransWorker.getLastUsedIp();
    this.mTransReport.port = this.mTransWorker.getLastUsedPort();
    TransReport localTransReport = this.mTransReport;
    localTransReport.mTransferedSize = this.transferedSize;
    return localTransReport.getReportInfo();
  }
  
  public void cancelTransaction()
  {
    if (!this.isFinish.compareAndSet(false, true)) {
      return;
    }
    Tracker localTracker = this.TRACKER;
    if (localTracker == null) {
      return;
    }
    localTracker.logStep("CANCL", "");
    stopTimeoutTimer();
    finishAndDetachFromWorker(false);
  }
  
  public void continueTrans()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("T \tT_ID:");
    ((StringBuilder)localObject).append(getTransationId());
    ((StringBuilder)localObject).append("\tcontinueTrans.");
    QLog.d("BDH_LOG", 1, ((StringBuilder)localObject).toString());
    if (this.isFinish.get()) {
      return;
    }
    int k = this.totalLength;
    int j = k / 8192;
    int i = j;
    if (k % 8192 != 0) {
      i = j + 1;
    }
    j = this.preSendDots;
    while (j < i)
    {
      localObject = this.bitmap;
      if (localObject[j] == 4) {
        localObject[j] = 0;
      }
      j += 1;
    }
    this.mTransWorker.notifyToSend();
  }
  
  public int getBuzType()
  {
    if (this.mNeedSegmentLikeVideo) {
      return 1;
    }
    int i = this.mBuzCmdId;
    if (i != 12)
    {
      if (i == 25) {
        return 1;
      }
      if ((i != 1) && (i == 4)) {}
      return 0;
    }
    return 1;
  }
  
  public byte[] getData(DataTransInfo paramDataTransInfo)
  {
    try
    {
      boolean bool = this.isFinish.get();
      int j = 0;
      if (bool)
      {
        paramDataTransInfo.errno = 0;
        return null;
      }
      try
      {
        int i = paramDataTransInfo.length;
        byte[] arrayOfByte = new byte[paramDataTransInfo.length];
        this.raf.seek(paramDataTransInfo.offset);
        while (j < paramDataTransInfo.length)
        {
          int k = this.raf.read(arrayOfByte, j, i);
          if (k == -1)
          {
            paramDataTransInfo.errno = 9303;
            return null;
          }
          j += k;
          i -= k;
        }
        return arrayOfByte;
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("B_ID:");
        localStringBuilder.append(this.mBuzCmdId);
        localStringBuilder.append("\tT_ID:");
        localStringBuilder.append(getTransationId());
        localStringBuilder.append("GetData Error.");
        BdhLogUtil.LogException("T", localStringBuilder.toString(), localIOException);
        paramDataTransInfo.errno = BdhUtils.analysisIOProblem(localIOException);
        return null;
      }
      throw paramDataTransInfo;
    }
    finally {}
    for (;;) {}
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("T T_ID:");
    ((StringBuilder)localObject).append(getTransationId());
    ((StringBuilder)localObject).append("\tinitSegmentList : \tisOpenUpEnable : ");
    ((StringBuilder)localObject).append(this.isOpenUpEnable);
    QLog.d("BDH_LOG", 1, ((StringBuilder)localObject).toString());
    this.mTransReport.mIsPreConnExist = paramBoolean;
    localObject = new File(this.filePath);
    this.mTransWorker = paramTransactionWorker;
    if (((File)localObject).exists())
    {
      if (!((File)localObject).canRead()) {
        return 9070;
      }
      this.totalLength = ((int)((File)localObject).length());
      if (this.totalLength <= 0) {
        return 9071;
      }
    }
    try
    {
      this.raf = new RandomAccessFile((File)localObject, "r");
      int k = this.totalLength;
      int j = k / 8192;
      int i = j;
      if (k % 8192 != 0) {
        i = j + 1;
      }
      k = this.offset / 8192;
      this.bitmap = new byte[i];
      if (this.isOpenUpEnable)
      {
        j = 0;
        while (j < i)
        {
          if (j < this.preSendDots) {
            this.bitmap[j] = 0;
          } else {
            this.bitmap[j] = 4;
          }
          j += 1;
        }
      }
      j = 0;
      while (j < i)
      {
        if (j < k) {
          this.bitmap[j] = 3;
        } else {
          this.bitmap[j] = 0;
        }
        j += 1;
      }
      this.TRACKER = new Tracker(this.transationId, this.totalLength);
      this.mTimeOutMonitor = new Transaction.TransTimeOutMonitor(this);
      paramTransactionWorker = this.TRACKER;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DotsNum:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" StartHole:");
      ((StringBuilder)localObject).append(k);
      paramTransactionWorker.logStep("INITI", ((StringBuilder)localObject).toString());
      return 0;
    }
    catch (FileNotFoundException paramTransactionWorker) {}
    return 9042;
    return 9042;
  }
  
  void needBDHReport(HashMap<String, String> paramHashMap)
  {
    int i = this.mCurrentQueryFinishCount;
    if (i > 0) {
      TransactionReport.reportQueryFinishQuality(this, i);
    }
    paramHashMap = BaseConstants.BdhBusinessType.reportBDHExcept;
    int k = paramHashMap.length;
    int j = 0;
    i = 0;
    while (i < k)
    {
      if (paramHashMap[i] == this.mBuzCmdId)
      {
        i = j;
        break label56;
      }
      i += 1;
    }
    i = 1;
    label56:
    if (i == 0) {
      return;
    }
    if ((this.startTime != 0L) && (this.totalLength != 0))
    {
      if (this.mTransWorker == null) {
        return;
      }
      TransactionReport.reportFunction("actBDHTask", this, null);
    }
  }
  
  public void onProbeFinish(ProbeResponse paramProbeResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject = paramProbeResponse.mProbeItemResults.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramProbeResponse = (ProbeItem)((Iterator)localObject).next();
      if ("ProbeChain".equals(paramProbeResponse.getProbeName()))
      {
        Iterator localIterator = ((ProbeChain)paramProbeResponse).chain.iterator();
        while (localIterator.hasNext())
        {
          ProbeItem localProbeItem = (ProbeItem)localIterator.next();
          if (localProbeItem.mResult != null)
          {
            localStringBuilder.append(localProbeItem.getProbeName());
            localStringBuilder.append("[");
            if (localProbeItem.mResult.success) {
              paramProbeResponse = "1";
            } else {
              paramProbeResponse = "0";
            }
            localStringBuilder.append(paramProbeResponse);
            localStringBuilder.append("]");
            localStringBuilder.append("[");
            localStringBuilder.append(localProbeItem.mResult.errCode);
            localStringBuilder.append("];");
          }
        }
      }
    }
    paramProbeResponse = (String)this.mReport.get("rep_bdhTrans");
    if (paramProbeResponse != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramProbeResponse);
      ((StringBuilder)localObject).append(localStringBuilder);
      paramProbeResponse = ((StringBuilder)localObject).toString();
      this.mReport.put("rep_bdhTrans", paramProbeResponse);
    }
    paramProbeResponse = this.cb;
    if (paramProbeResponse != null) {
      paramProbeResponse.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
    }
  }
  
  public void onProbeProgress(String paramString) {}
  
  public void onQuertHoleError(byte[] paramArrayOfByte)
  {
    if (this.isFinish.get()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("B_ID:");
    ((StringBuilder)localObject).append(this.mBuzCmdId);
    ((StringBuilder)localObject).append("\tT_ID:");
    ((StringBuilder)localObject).append(getTransationId());
    ((StringBuilder)localObject).append(" QueryDebug Query OnQuertHoleError : CopyBitmap:");
    ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfByte));
    ((StringBuilder)localObject).append(" CurrentBitmap:");
    ((StringBuilder)localObject).append(Arrays.toString(this.bitmap));
    BdhLogUtil.LogEvent("R", ((StringBuilder)localObject).toString());
    int i = 0;
    for (;;)
    {
      localObject = this.bitmap;
      if (i >= localObject.length) {
        break;
      }
      if ((localObject[i] != 3) && (paramArrayOfByte[i] == 2)) {
        localObject[i] = 0;
      }
      i += 1;
    }
    paramArrayOfByte = this.TRACKER;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QueryHoleError Bitmap:");
    ((StringBuilder)localObject).append(Arrays.toString(this.bitmap));
    paramArrayOfByte.logStep("QUERY", ((StringBuilder)localObject).toString());
    this.mTransWorker.notifyToSend();
  }
  
  public void onQueryHoleResp(CSDataHighwayHead.QueryHoleRsp paramQueryHoleRsp, byte[] paramArrayOfByte, boolean paramBoolean, HwResponse paramHwResponse, RequestInfoQuery paramRequestInfoQuery)
  {
    if (this.isFinish.get()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("B_ID:");
    localStringBuilder.append(this.mBuzCmdId);
    localStringBuilder.append(" \tT_ID:");
    localStringBuilder.append(getTransationId());
    localStringBuilder.append("\tQueryHoleResp");
    BdhLogUtil.LogEvent("T", localStringBuilder.toString());
    int i = paramQueryHoleRsp.uint32_result.get();
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    BdhUtils.copyData(arrayOfByte, 0, paramArrayOfByte, 0, paramArrayOfByte.length);
    if (i != 0)
    {
      onQuertHoleError(paramArrayOfByte);
      return;
    }
    localStringBuilder = new StringBuilder("Holes:");
    paramQueryHoleRsp = paramQueryHoleRsp.rpt_data_hole.get();
    if ((paramQueryHoleRsp != null) && (!paramQueryHoleRsp.isEmpty()))
    {
      paramHwResponse = paramQueryHoleRsp.iterator();
      for (i = 0; paramHwResponse.hasNext(); i = j)
      {
        paramRequestInfoQuery = (CSDataHighwayHead.DataHole)paramHwResponse.next();
        int n = (int)paramRequestInfoQuery.uint64_begin.get();
        int i1 = (int)paramRequestInfoQuery.uint64_end.get();
        int m = n / 8192;
        int k = (i1 - 1) / 8192;
        j = i;
        if (k > i) {
          j = k;
        }
        localStringBuilder.append("Holes Start:");
        localStringBuilder.append(m);
        localStringBuilder.append(" End:");
        localStringBuilder.append(k);
        paramRequestInfoQuery = new StringBuilder();
        paramRequestInfoQuery.append("B_ID:");
        paramRequestInfoQuery.append(this.mBuzCmdId);
        paramRequestInfoQuery.append("\tT_ID:");
        paramRequestInfoQuery.append(getTransationId());
        paramRequestInfoQuery.append(" OnQueryHoleResp : holes :  HoleStart:");
        paramRequestInfoQuery.append(n);
        paramRequestInfoQuery.append(" HoleEnd:");
        paramRequestInfoQuery.append(i1);
        paramRequestInfoQuery.append(" BitmapS:");
        paramRequestInfoQuery.append(m);
        paramRequestInfoQuery.append(" BitmapE:");
        paramRequestInfoQuery.append(k);
        BdhLogUtil.LogEvent("R", paramRequestInfoQuery.toString());
        i = m;
        while (i <= k)
        {
          if (paramArrayOfByte[i] == 2) {
            paramArrayOfByte[i] = 0;
          }
          i += 1;
        }
      }
      int j = i;
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
      while (i < paramArrayOfByte.length)
      {
        if ((arrayOfByte[i] == 2) && (paramArrayOfByte[i] == 0) && ((this.bQueryForFIN) || (this.bitmap[i] != 3))) {
          this.bitmap[i] = 0;
        } else if (paramArrayOfByte[i] == 2) {
          this.bitmap[i] = 3;
        }
        i += 1;
      }
      this.bQueryForFIN = false;
      this.mCurrentQueryFinishCount = 0;
    }
    else
    {
      localStringBuilder.append("null");
      paramQueryHoleRsp = new StringBuilder();
      paramQueryHoleRsp.append("B_ID:");
      paramQueryHoleRsp.append(this.mBuzCmdId);
      paramQueryHoleRsp.append("\tT_ID:");
      paramQueryHoleRsp.append(getTransationId());
      paramQueryHoleRsp.append(" finish flag is null and hole is null mCurrentQueryFinishCount:");
      paramQueryHoleRsp.append(this.mCurrentQueryFinishCount);
      paramQueryHoleRsp.append(" bQueryForFIN:");
      paramQueryHoleRsp.append(this.bQueryForFIN);
      BdhLogUtil.LogEvent("R", paramQueryHoleRsp.toString());
      if (this.bQueryForFIN) {
        if (this.mCurrentQueryFinishCount < RequestFinishQuery.QUERY_HOLE_MAX_COUNT) {
          queryTransactionFinish();
        } else {
          onTransFailed(9306, "QueryFinishFail", paramHwResponse.retCode, paramHwResponse.buzRetCode, paramRequestInfoQuery.retryCount, paramHwResponse.mBuExtendinfo);
        }
      }
    }
    paramQueryHoleRsp = this.TRACKER;
    paramHwResponse = new StringBuilder();
    paramHwResponse.append("QueryHoleResp ");
    paramHwResponse.append(localStringBuilder.toString());
    paramQueryHoleRsp.logStep("QUERY", paramHwResponse.toString());
    paramQueryHoleRsp = new StringBuilder();
    paramQueryHoleRsp.append("B_ID:");
    paramQueryHoleRsp.append(this.mBuzCmdId);
    paramQueryHoleRsp.append("\tT_ID:");
    paramQueryHoleRsp.append(getTransationId());
    paramQueryHoleRsp.append(" OnQueryHoleResp : Merged : CopyBitmap:");
    paramQueryHoleRsp.append(Arrays.toString(paramArrayOfByte));
    paramQueryHoleRsp.append(" CurrentBitmap:");
    paramQueryHoleRsp.append(Arrays.toString(this.bitmap));
    BdhLogUtil.LogEvent("R", paramQueryHoleRsp.toString());
    this.mTransWorker.notifyToSend();
  }
  
  public void onRequestFailed(int paramInt)
  {
    ITransCallbackForReport localITransCallbackForReport = this.cbForReport;
    if (localITransCallbackForReport != null) {
      localITransCallbackForReport.onFailed(paramInt, this.mTransWorker.getLastUsedIp(), this.mTransWorker.getLastUsedPort());
    }
  }
  
  public void onSwitchToBackupChannel()
  {
    stopTimeoutTimer();
    if (this.hasSwitch2BackupChannel.get()) {
      return;
    }
    this.hasSwitch2BackupChannel.set(true);
    ITransactionCallback localITransactionCallback = this.cb;
    if (localITransactionCallback != null) {
      localITransactionCallback.onSwitch2BackupChannel();
    }
  }
  
  public void onTransFailed(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    if (!this.isFinish.compareAndSet(false, true)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("B_ID:");
    localStringBuilder.append(this.mBuzCmdId);
    localStringBuilder.append("\tT_ID:");
    localStringBuilder.append(getTransationId());
    localStringBuilder.append(" OnTransFailed : ERR_C:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ERR_H:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" ERR_B:");
    localStringBuilder.append(paramInt3);
    BdhLogUtil.LogEvent("T", localStringBuilder.toString());
    stopTimeoutTimer();
    this.mTransReport.updateRetryInfo(paramInt4);
    this.mBuExtendinfo = paramArrayOfByte;
    this.mErrorCode = paramInt1;
    if (paramInt3 != 0) {
      this.mErrorCode = paramInt3;
    } else if (paramInt2 != 0) {
      this.mErrorCode = paramInt2;
    }
    paramArrayOfByte = this.mTransWorker;
    if (paramArrayOfByte != null)
    {
      this.mTransReport.bHasNet = paramArrayOfByte.updateAndCheckNet();
      this.mTransReport.isConnected = this.mTransWorker.isNetworkConnected();
      this.mTransReport.connErrCode = this.mTransWorker.getConnErroCode();
      this.mTransReport.setFailReason(this.mErrorCode, paramString);
      paramInt2 = this.mErrorCode;
      if ((paramInt2 == -1002) || (paramInt2 == -1005))
      {
        this.mTransWorker.dumpEngineInfo();
        paramString = this.TRACKER.dumpTrackerInfo();
        paramArrayOfByte = this.TRACKER;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("TransFailed  Bitmap:");
        localStringBuilder.append(Arrays.toString(this.bitmap));
        paramArrayOfByte.logStep("QUERY", localStringBuilder.toString());
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("B_ID:");
        paramArrayOfByte.append(this.mBuzCmdId);
        paramArrayOfByte.append("\tT_ID:");
        paramArrayOfByte.append(getTransationId());
        paramArrayOfByte.append(" TRACEKERINFO:");
        paramArrayOfByte.append(paramString);
        QLog.d("T", 1, paramArrayOfByte.toString());
        if (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode)) {
          this.mErrorCode = 9004;
        }
      }
      paramInt2 = this.mBuzCmdId;
      if ((paramInt2 != 1) && (paramInt2 != 2) && (paramInt2 != 4))
      {
        if ((!this.mTransReport.bHasNet) || (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode))) {
          this.mErrorCode = 9004;
        }
      }
      else if ((this.mTransReport.bHasNet) && (!BdhUtils.isNetWorkProb(this.mTransReport.connErrCode)))
      {
        if ((this.mErrorCode <= 0) && ((!this.mTransReport.bHasNet) || (!this.mTransReport.isConnected) || (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode)))) {
          this.mErrorCode = 9004;
        }
      }
      else {
        this.mErrorCode = 9004;
      }
    }
    this.mReport = updateAndGetReporter();
    needBDHReport(this.mReport);
    if ((this.mTransReport.bHasNet) && ((paramInt1 == -1002) || (paramInt1 == -1005) || (paramInt1 == -1003) || (paramInt1 == -1014)))
    {
      boolean bool = this.mTransWorker.startNetDetection(this);
      finishAndDetachFromWorker(false);
      if (!bool)
      {
        paramString = this.cb;
        if (paramString != null) {
          paramString.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
        }
      }
    }
    else
    {
      finishAndDetachFromWorker(false);
      paramString = this.cb;
      if (paramString != null) {
        paramString.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
      }
    }
  }
  
  public void onTransProgress(RequestDataTrans paramRequestDataTrans, HwResponse paramHwResponse)
  {
    if (this.isFinish.get()) {
      return;
    }
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
    int m = paramRequestDataTrans.bitmapS;
    int n = paramRequestDataTrans.bitmapE;
    if (n >= this.bitmap.length) {
      return;
    }
    int i = m;
    while (i <= n)
    {
      this.bitmap[i] = 3;
      i += 1;
    }
    i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      paramRequestDataTrans = this.bitmap;
      if (i >= paramRequestDataTrans.length) {
        break;
      }
      k = j;
      if (paramRequestDataTrans[i] == 3) {
        k = j + 1;
      }
      i += 1;
    }
    this.transferedSize = (j * 8192);
    if (paramRequestDataTrans[(paramRequestDataTrans.length - 1)] == 3) {
      this.transferedSize -= paramRequestDataTrans.length * 8192 - this.totalLength;
    }
    i = this.transferedSizeBDH;
    if (i - this.transferedSize > this.totalLength / 10)
    {
      j = i / 8192;
      i = 0;
      while (i < j)
      {
        this.bitmap[i] = 3;
        i += 1;
      }
      this.mTransWorker.getHwEngine().mRequestWorker.remove2SENDRequest(this.transationId, j);
      paramRequestDataTrans = new StringBuilder();
      paramRequestDataTrans.append("B_ID:");
      paramRequestDataTrans.append(this.mBuzCmdId);
      paramRequestDataTrans.append("\tT_ID:");
      paramRequestDataTrans.append(getTransationId());
      paramRequestDataTrans.append("UpdateTransferedSizeToServerRange,local size:");
      paramRequestDataTrans.append(this.transferedSize);
      paramRequestDataTrans.append(" server size:");
      paramRequestDataTrans.append(this.transferedSizeBDH);
      BdhLogUtil.LogEvent("T", paramRequestDataTrans.toString());
    }
    if (this.transferedSize >= this.totalLength)
    {
      paramRequestDataTrans = new StringBuilder();
      paramRequestDataTrans.append("B_ID:");
      paramRequestDataTrans.append(this.mBuzCmdId);
      paramRequestDataTrans.append("\tT_ID:");
      paramRequestDataTrans.append(getTransationId());
      paramRequestDataTrans.append("NotifySegmentProgress Error : Finish flag is lost.");
      BdhLogUtil.LogEvent("T", paramRequestDataTrans.toString());
      this.mTransReport.bFINLost = true;
    }
    if (this.cb != null)
    {
      paramRequestDataTrans = new StringBuilder();
      paramRequestDataTrans.append("B_ID:");
      paramRequestDataTrans.append(this.mBuzCmdId);
      paramRequestDataTrans.append("\tT_ID:");
      paramRequestDataTrans.append(getTransationId());
      paramRequestDataTrans.append(" NotifySegmentProgress Total:");
      paramRequestDataTrans.append(this.totalLength);
      paramRequestDataTrans.append(" TransSize:");
      paramRequestDataTrans.append(this.transferedSize);
      paramRequestDataTrans.append(" allHoles:");
      paramRequestDataTrans.append(this.bitmap.length);
      paramRequestDataTrans.append(" [");
      paramRequestDataTrans.append(m);
      paramRequestDataTrans.append(":");
      paramRequestDataTrans.append(n);
      paramRequestDataTrans.append("]");
      BdhLogUtil.LogEvent("T", paramRequestDataTrans.toString());
      this.cb.onUpdateProgress(this.transferedSize);
    }
    paramRequestDataTrans = this.TRACKER;
    paramHwResponse = new StringBuilder();
    paramHwResponse.append("TransProgress Start:");
    paramHwResponse.append(m);
    paramHwResponse.append(" End:");
    paramHwResponse.append(n);
    paramRequestDataTrans.logStep("PRGRS", paramHwResponse.toString());
    if ((this.mTransReport.bFINLost) && (!this.bQueryForFIN))
    {
      this.bQueryForFIN = true;
      this.mTransReport.bFINLost = false;
      queryTransactionFinish();
      paramRequestDataTrans = this.TRACKER;
      paramHwResponse = new StringBuilder();
      paramHwResponse.append("FinFlagLost  Bitmap:");
      paramHwResponse.append(Arrays.toString(this.bitmap));
      paramRequestDataTrans.logStep("QUERY", paramHwResponse.toString());
    }
  }
  
  public void onTransReUpload(int paramInt)
  {
    this.reUploadTransaction = true;
    this.reUploadHwSeq = paramInt;
    this.transferedSizeBDH = 0;
    extendTimeExceedLimit();
    int j = this.totalLength;
    int i = j / 8192;
    paramInt = i;
    if (j % 8192 != 0) {
      paramInt = i + 1;
    }
    this.mTransWorker.getHwEngine().mRequestWorker.remove2SENDRequest(this.transationId, paramInt);
    i = 0;
    while (i < paramInt)
    {
      this.bitmap[i] = 0;
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("B_ID:");
    localStringBuilder.append(this.mBuzCmdId);
    localStringBuilder.append("\tT_ID:");
    localStringBuilder.append(getTransationId());
    localStringBuilder.append("reUpload long video");
    BdhLogUtil.LogEvent("T", localStringBuilder.toString());
    this.TRACKER.logStep("REUPLOAD", "ReUpload trasaction");
    this.mTransReport.hasReUpload = true;
  }
  
  public void onTransSuccess(DataTransInfo paramDataTransInfo, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("B_ID:");
    ((StringBuilder)localObject).append(this.mBuzCmdId);
    ((StringBuilder)localObject).append("\tT_ID:");
    ((StringBuilder)localObject).append(getTransationId());
    ((StringBuilder)localObject).append(" NotifySegmentSuccess");
    BdhLogUtil.LogEvent("T", ((StringBuilder)localObject).toString());
    if (!this.isFinish.compareAndSet(false, true)) {
      return;
    }
    this.isSuccess.set(true);
    stopTimeoutTimer();
    if (paramDataTransInfo != null) {
      this.mTransReport.updateRetryInfo(paramDataTransInfo.retryTimes);
    }
    if (paramDataTransInfo != null)
    {
      localObject = this.mTransReport;
      ((TransReport)localObject).timeCost_Send = ((int)(((TransReport)localObject).timeCost_Send + (paramDataTransInfo.timeCost_req - paramDataTransInfo.timeCost_hw - paramDataTransInfo.timeCost_cache)));
      localObject = this.mTransReport;
      ((TransReport)localObject).timeCost_Ht = ((int)(((TransReport)localObject).timeCost_Ht + paramDataTransInfo.timeCost_hw));
      localObject = this.mTransReport;
      ((TransReport)localObject).timeCost_Cache = ((int)(((TransReport)localObject).timeCost_Cache + paramDataTransInfo.timeCost_cache));
    }
    this.mBuExtendinfo = paramArrayOfByte;
    this.transferedSize = this.totalLength;
    paramDataTransInfo = updateAndGetReporter();
    needBDHReport(paramDataTransInfo);
    finishAndDetachFromWorker(true);
    paramArrayOfByte = this.cb;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.onSuccess(this.mBuExtendinfo, paramDataTransInfo);
    }
  }
  
  DataTransInfo peekNextSegment(HwNetSegConf paramHwNetSegConf)
  {
    int j = (int)paramHwNetSegConf.segSize;
    boolean bool = this.isFinish.get();
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (!bool)
    {
      if (isPause()) {
        return null;
      }
      if ((this.mTransReport.confSegSize == 0L) && (paramHwNetSegConf != null))
      {
        this.mTransReport.confSegSize = ((int)paramHwNetSegConf.segSize);
        this.mTransReport.confSegNum = ((int)paramHwNetSegConf.segNum);
        this.mTransReport.confConnNum = ((int)paramHwNetSegConf.curConnNum);
      }
      int i = j / 8192;
      int n = i;
      if (j % 8192 > 0) {
        n = i + 1;
      }
      j = 0;
      for (i = -1;; i = m)
      {
        paramHwNetSegConf = this.bitmap;
        if (j >= paramHwNetSegConf.length) {
          break;
        }
        if (paramHwNetSegConf[j] == 0)
        {
          int k = i;
          if (i == -1) {
            k = j;
          }
          m = j;
          i = k;
          if (j == this.bitmap.length - 1) {
            break label250;
          }
          m = k;
          if (n == j + 1 - k)
          {
            m = j;
            i = k;
            break label250;
          }
        }
        else
        {
          if ((this.isOpenUpEnable) && (paramHwNetSegConf[j] == 4))
          {
            if (i != -1) {
              m = j - 1;
            } else {
              m = -1;
            }
            stopTimeoutTimer();
            break label250;
          }
          m = i;
          if (i != -1)
          {
            m = j;
            break label250;
          }
        }
        j += 1;
      }
      int m = -1;
      label250:
      localObject = localStringBuilder;
      if (i != -1)
      {
        localObject = localStringBuilder;
        if (m != -1)
        {
          paramHwNetSegConf = this.mTransReport;
          paramHwNetSegConf.sliceNum += 1;
          localObject = new DataTransInfo(this);
          j = this.totalLength;
          ((DataTransInfo)localObject).fileSize = j;
          ((DataTransInfo)localObject).offset = (i * 8192);
          ((DataTransInfo)localObject).bitmapS = i;
          ((DataTransInfo)localObject).bitmapE = m;
          paramHwNetSegConf = this.bitmap;
          if (m == paramHwNetSegConf.length - 1) {
            ((DataTransInfo)localObject).length = ((m - i) * 8192 + (j - (paramHwNetSegConf.length - 1) * 8192));
          } else {
            ((DataTransInfo)localObject).length = ((m - i + 1) * 8192);
          }
          j = i;
          while (j <= m)
          {
            this.bitmap[j] = 1;
            j += 1;
          }
          paramHwNetSegConf = this.TRACKER;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Start:");
          localStringBuilder.append(i);
          localStringBuilder.append(" End:");
          localStringBuilder.append(m);
          localStringBuilder.append(" Length:");
          localStringBuilder.append(((DataTransInfo)localObject).length);
          paramHwNetSegConf.logStep("SLICE", localStringBuilder.toString());
          startTimeoutTimer();
        }
      }
    }
    return localObject;
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("B_ID:");
      ((StringBuilder)localObject).append(this.mBuzCmdId);
      ((StringBuilder)localObject).append("\tT_ID:");
      ((StringBuilder)localObject).append(getTransationId());
      ((StringBuilder)localObject).append("startTimeoutTimer.");
      BdhLogUtil.LogEvent("T", ((StringBuilder)localObject).toString());
      localObject = this.cb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.Transaction
 * JD-Core Version:    0.7.0.1
 */