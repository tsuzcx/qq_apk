package com.tencent.mobileqq.transfile.quic.internal;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.quic.open.ILoadSo;
import com.tencent.mobileqq.transfile.quic.open.ILoadSoCallback;
import com.tencent.mobileqq.transfile.quic.open.IQuicEngine;
import com.tencent.mobileqq.transfile.quic.open.QuicReq;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport.Stats;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuicEngineImp
  implements ILoadSoCallback, IQuicEngine
{
  private static final int SO_LOADED = 2;
  private static final int SO_LOADING = 1;
  private static final String TAG = "QuicEngineImp";
  public static QuicNetReport.Stats sLastStats;
  private ILoadSo mILoadSo;
  private List<QuicReq> mReqWaitingList = new ArrayList();
  private volatile int mSoLoadStatus;
  
  public QuicEngineImp() {}
  
  public QuicEngineImp(ILoadSo paramILoadSo)
  {
    this.mILoadSo = paramILoadSo;
  }
  
  private void addToThreadPoll(QuicReq paramQuicReq)
  {
    paramQuicReq.mExcuteTime = System.currentTimeMillis();
    ThreadManagerV2.excute(new QuicEngineImp.1(this, paramQuicReq), 128, null, false);
  }
  
  private void callbackWatingReqFail()
  {
    if (this.mReqWaitingList != null)
    {
      Iterator localIterator = this.mReqWaitingList.iterator();
      while (localIterator.hasNext())
      {
        QuicReq localQuicReq = (QuicReq)localIterator.next();
        DownloadListener localDownloadListener = localQuicReq.mDownloadListener;
        if (localDownloadListener != null)
        {
          QuicNetReport localQuicNetReport = new QuicNetReport();
          localQuicNetReport.channel = "quic";
          localQuicNetReport.tempPath = localQuicReq.mTempPath;
          localQuicNetReport.savePath = localQuicReq.mSavePath;
          localQuicNetReport.id = localQuicNetReport.tempPath.hashCode();
          localQuicNetReport.url = localQuicReq.mPath;
          localQuicNetReport.ip = localQuicReq.mIp;
          localQuicNetReport.errMsg = "so load fail";
          localQuicNetReport.port = localQuicReq.mPort;
          localQuicNetReport.isIpv6 = localQuicReq.mIsIpv6;
          localQuicNetReport.rttHost = localQuicReq.mRttHost;
          localQuicNetReport.businessId = localQuicReq.mBussinessId;
          localQuicNetReport.timeOut = localQuicReq.mTimeOut;
          localQuicNetReport.failReason = 10;
          localDownloadListener.onDownloadFailed(localQuicReq.mPath, localQuicNetReport);
        }
      }
      this.mReqWaitingList.clear();
    }
  }
  
  /* Error */
  private void doQuicTask(QuicReq paramQuicReq)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 105	com/tencent/mobileqq/transfile/quic/open/QuicReq:mSavePath	Ljava/lang/String;
    //   4: astore 4
    //   6: aload_1
    //   7: getfield 120	com/tencent/mobileqq/transfile/quic/open/QuicReq:mPath	Ljava/lang/String;
    //   10: astore 5
    //   12: aload_1
    //   13: getfield 99	com/tencent/mobileqq/transfile/quic/open/QuicReq:mTempPath	Ljava/lang/String;
    //   16: aload 4
    //   18: aload 5
    //   20: invokestatic 185	com/tencent/mobileqq/transfile/quic/internal/Task:getTempPath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 6
    //   25: aload 6
    //   27: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +4 -> 34
    //   33: return
    //   34: aload 6
    //   36: invokestatic 197	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:isExistTaskAddIfNeed	(Ljava/lang/String;)Z
    //   39: ifeq +23 -> 62
    //   42: ldc 93
    //   44: iconst_4
    //   45: ldc 199
    //   47: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: aload_1
    //   52: aload 4
    //   54: aload 5
    //   56: aload 6
    //   58: invokespecial 209	com/tencent/mobileqq/transfile/quic/internal/QuicEngineImp:taskDownloadingCallback	(Lcom/tencent/mobileqq/transfile/quic/open/QuicReq;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   61: return
    //   62: aload_1
    //   63: getfield 57	com/tencent/mobileqq/transfile/quic/open/QuicReq:mExcuteTime	J
    //   66: lstore_2
    //   67: aload_1
    //   68: getfield 88	com/tencent/mobileqq/transfile/quic/open/QuicReq:mDownloadListener	Lcom/tencent/mobileqq/transfile/quic/report/DownloadListener;
    //   71: astore 8
    //   73: aload 8
    //   75: ifnull +44 -> 119
    //   78: aload 8
    //   80: invokeinterface 212 1 0
    //   85: ifeq +34 -> 119
    //   88: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +11 -> 102
    //   94: ldc 93
    //   96: iconst_4
    //   97: ldc 217
    //   99: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload 6
    //   104: invokestatic 221	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:removeRunningTask	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: aload_1
    //   109: aload 4
    //   111: aload 5
    //   113: aload 6
    //   115: invokespecial 224	com/tencent/mobileqq/transfile/quic/internal/QuicEngineImp:taskCanceledCallback	(Lcom/tencent/mobileqq/transfile/quic/open/QuicReq;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   118: return
    //   119: new 193	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable
    //   122: dup
    //   123: invokespecial 225	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:<init>	()V
    //   126: astore 7
    //   128: new 227	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask
    //   131: dup
    //   132: aload 7
    //   134: aload 5
    //   136: aload 4
    //   138: aload 6
    //   140: aload_1
    //   141: getfield 231	com/tencent/mobileqq/transfile/quic/open/QuicReq:mHeaders	Ljava/util/Map;
    //   144: aload 8
    //   146: invokespecial 234	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:<init>	(Lcom/tencent/mobileqq/transfile/quic/internal/ITaskHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/tencent/mobileqq/transfile/quic/report/DownloadListener;)V
    //   149: astore 8
    //   151: aload 8
    //   153: invokevirtual 237	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:initDownloadFile	()V
    //   156: lload_2
    //   157: lconst_0
    //   158: lcmp
    //   159: ifle +16 -> 175
    //   162: aload 8
    //   164: getfield 241	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   167: invokestatic 51	java/lang/System:currentTimeMillis	()J
    //   170: lload_2
    //   171: lsub
    //   172: putfield 244	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:waitCost	J
    //   175: aload 8
    //   177: getfield 241	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   180: aload_1
    //   181: getfield 126	com/tencent/mobileqq/transfile/quic/open/QuicReq:mIp	Ljava/lang/String;
    //   184: putfield 129	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:ip	Ljava/lang/String;
    //   187: aload 8
    //   189: getfield 241	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   192: aload_1
    //   193: getfield 137	com/tencent/mobileqq/transfile/quic/open/QuicReq:mPort	I
    //   196: putfield 140	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:port	I
    //   199: aload 8
    //   201: getfield 241	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   204: aload_1
    //   205: getfield 144	com/tencent/mobileqq/transfile/quic/open/QuicReq:mIsIpv6	Z
    //   208: putfield 147	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:isIpv6	Z
    //   211: aload 8
    //   213: getfield 241	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   216: aload_1
    //   217: getfield 150	com/tencent/mobileqq/transfile/quic/open/QuicReq:mRttHost	Ljava/lang/String;
    //   220: putfield 153	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:rttHost	Ljava/lang/String;
    //   223: aload 8
    //   225: getfield 241	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   228: aload_1
    //   229: getfield 156	com/tencent/mobileqq/transfile/quic/open/QuicReq:mBussinessId	I
    //   232: putfield 159	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:businessId	I
    //   235: aload 8
    //   237: getfield 241	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   240: aload_1
    //   241: getfield 162	com/tencent/mobileqq/transfile/quic/open/QuicReq:mTimeOut	I
    //   244: putfield 165	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:timeOut	I
    //   247: aload 8
    //   249: aload_1
    //   250: getfield 162	com/tencent/mobileqq/transfile/quic/open/QuicReq:mTimeOut	I
    //   253: putfield 245	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:timeOut	I
    //   256: aload_0
    //   257: monitorenter
    //   258: getstatic 247	com/tencent/mobileqq/transfile/quic/internal/QuicEngineImp:sLastStats	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats;
    //   261: ifnull +54 -> 315
    //   264: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +33 -> 300
    //   270: ldc 93
    //   272: iconst_2
    //   273: new 249	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   280: ldc 252
    //   282: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: getstatic 247	com/tencent/mobileqq/transfile/quic/internal/QuicEngineImp:sLastStats	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats;
    //   288: invokevirtual 262	com/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats:toString	()Ljava/lang/String;
    //   291: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload 8
    //   302: getfield 241	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   305: getstatic 247	com/tencent/mobileqq/transfile/quic/internal/QuicEngineImp:sLastStats	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats;
    //   308: putfield 266	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:lastStats	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats;
    //   311: aconst_null
    //   312: putstatic 247	com/tencent/mobileqq/transfile/quic/internal/QuicEngineImp:sLastStats	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport$Stats;
    //   315: aload_0
    //   316: monitorexit
    //   317: aload 8
    //   319: aload_1
    //   320: getfield 269	com/tencent/mobileqq/transfile/quic/open/QuicReq:mIsQuicEncryption	Z
    //   323: putfield 272	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:encryption	Z
    //   326: aload 8
    //   328: aload_1
    //   329: getfield 275	com/tencent/mobileqq/transfile/quic/open/QuicReq:mFec	I
    //   332: putfield 278	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:fec	I
    //   335: aload 7
    //   337: aload 8
    //   339: invokevirtual 282	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:enqueue	(Lcom/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask;)V
    //   342: return
    //   343: astore 7
    //   345: aload 6
    //   347: invokestatic 221	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:removeRunningTask	(Ljava/lang/String;)V
    //   350: aload_0
    //   351: aload_1
    //   352: aload 4
    //   354: aload 5
    //   356: aload 6
    //   358: iconst_2
    //   359: aload 7
    //   361: invokevirtual 285	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   364: invokespecial 289	com/tencent/mobileqq/transfile/quic/internal/QuicEngineImp:taskFailedCallback	(Lcom/tencent/mobileqq/transfile/quic/open/QuicReq;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   367: return
    //   368: astore_1
    //   369: aload_0
    //   370: monitorexit
    //   371: aload_1
    //   372: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	this	QuicEngineImp
    //   0	373	1	paramQuicReq	QuicReq
    //   66	105	2	l	long
    //   4	349	4	str1	String
    //   10	345	5	str2	String
    //   23	334	6	str3	String
    //   126	210	7	localQuicDownloadRunnable	QuicDownloadRunnable
    //   343	17	7	localException	java.lang.Exception
    //   71	267	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   128	156	343	java/lang/Exception
    //   258	300	368	finally
    //   300	315	368	finally
    //   315	317	368	finally
    //   369	371	368	finally
  }
  
  private void executeWatingReq()
  {
    if (this.mReqWaitingList != null)
    {
      Iterator localIterator = this.mReqWaitingList.iterator();
      while (localIterator.hasNext()) {
        addToThreadPoll((QuicReq)localIterator.next());
      }
      this.mReqWaitingList.clear();
    }
  }
  
  public static QuicNetReport.Stats saveNetStats(QuicNetReport paramQuicNetReport)
  {
    QuicNetReport.Stats localStats = QuicNetReport.convertJsontoStats(paramQuicNetReport.extra);
    if (localStats != null)
    {
      if ((paramQuicNetReport.srvMessage != null) && (paramQuicNetReport.srvMessage.length > 0))
      {
        int i = paramQuicNetReport.srvMessage.length;
        localStats.mSrvMessage = new byte[i];
        System.arraycopy(paramQuicNetReport.srvMessage, 0, localStats.mSrvMessage, 0, i);
      }
      if (localStats.isValid()) {
        try
        {
          sLastStats = localStats;
          if (QLog.isColorLevel()) {
            QLog.d("quic", 4, localStats.toString());
          }
          return localStats;
        }
        finally {}
      }
    }
    return null;
  }
  
  private void taskCanceledCallback(QuicReq paramQuicReq, String paramString1, String paramString2, String paramString3)
  {
    taskFailedCallback(paramQuicReq, paramString1, paramString2, paramString3, 9);
  }
  
  private void taskDownloadingCallback(QuicReq paramQuicReq, String paramString1, String paramString2, String paramString3)
  {
    taskFailedCallback(paramQuicReq, paramString1, paramString2, paramString3, 8);
  }
  
  private void taskFailedCallback(QuicReq paramQuicReq, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    taskFailedCallback(paramQuicReq, paramString1, paramString2, paramString3, paramInt, "");
  }
  
  private void taskFailedCallback(QuicReq paramQuicReq, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    DownloadListener localDownloadListener = paramQuicReq.mDownloadListener;
    if (localDownloadListener != null)
    {
      QuicNetReport localQuicNetReport = new QuicNetReport();
      localQuicNetReport.channel = "quic";
      localQuicNetReport.tempPath = paramString3;
      localQuicNetReport.savePath = paramString1;
      localQuicNetReport.id = localQuicNetReport.tempPath.hashCode();
      localQuicNetReport.url = paramString2;
      localQuicNetReport.ip = paramQuicReq.mIp;
      localQuicNetReport.errMsg = paramString4;
      localQuicNetReport.port = paramQuicReq.mPort;
      localQuicNetReport.isIpv6 = paramQuicReq.mIsIpv6;
      localQuicNetReport.rttHost = paramQuicReq.mRttHost;
      localQuicNetReport.businessId = paramQuicReq.mBussinessId;
      localQuicNetReport.timeOut = paramQuicReq.mTimeOut;
      localQuicNetReport.failReason = paramInt;
      localDownloadListener.onDownloadFailed(paramString2, localQuicNetReport);
    }
  }
  
  public boolean execute(QuicReq paramQuicReq)
  {
    if (Utils.checkIfCPUx86()) {
      QLog.e("quic", 4, "the phone cpu is x86");
    }
    while (paramQuicReq == null) {
      return false;
    }
    if (TextUtils.isEmpty(paramQuicReq.mPath)) {
      throw new IllegalArgumentException("url path is empty!!!");
    }
    if (TextUtils.isEmpty(paramQuicReq.mSavePath)) {
      throw new IllegalArgumentException("savePath is empty!!!");
    }
    if (TextUtils.isEmpty(paramQuicReq.mIp)) {
      throw new IllegalArgumentException("ip is empty!!!");
    }
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, "start ip: " + paramQuicReq.mIp + " port: " + paramQuicReq.mPort);
    }
    for (;;)
    {
      try
      {
        if (this.mSoLoadStatus == 2)
        {
          addToThreadPoll(paramQuicReq);
          return true;
        }
        if (this.mSoLoadStatus == 1)
        {
          this.mReqWaitingList.add(paramQuicReq);
          continue;
        }
        if (this.mSoLoadStatus != 0) {
          continue;
        }
      }
      finally {}
      this.mReqWaitingList.add(paramQuicReq);
      init();
    }
  }
  
  public void init()
  {
    try
    {
      if ((this.mSoLoadStatus == 0) && (this.mILoadSo != null))
      {
        this.mSoLoadStatus = 1;
        this.mILoadSo.loadSo(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isSoReady()
  {
    return this.mSoLoadStatus == 2;
  }
  
  public void onLoad(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        QLog.d("QuicEngineImp", 1, "onLoad, isSuccess = " + paramBoolean);
        if (paramBoolean) {
          try
          {
            QuicNative.init();
            QuicNative.setDebugLog(false);
            this.mSoLoadStatus = 2;
            executeWatingReq();
            return;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("quic", 4, localThrowable, new Object[0]);
            this.mSoLoadStatus = 0;
            callbackWatingReqFail();
            continue;
          }
        }
        this.mSoLoadStatus = 0;
      }
      finally {}
      callbackWatingReqFail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.QuicEngineImp
 * JD-Core Version:    0.7.0.1
 */