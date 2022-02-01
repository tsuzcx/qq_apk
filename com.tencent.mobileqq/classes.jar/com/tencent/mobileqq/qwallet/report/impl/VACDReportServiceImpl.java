package com.tencent.mobileqq.qwallet.report.impl;

import VACDReport.ReportBody;
import VACDReport.ReportHeader;
import VACDReport.ReportInfo;
import VACDReport.ReportItem;
import VACDReport.ReportReq;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.report.IVACDReportService;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class VACDReportServiceImpl
  implements IVACDReportService
{
  private static final int DEFAULT_CAPACITY = 8;
  private static final long LOCAL_TIME_OUT_INTERVAL = 600000L;
  private static final long LOCAL_TIME_OUT_PERIOD = 2100000L;
  private static final int LOCAL_TIME_OUT_RESULT = 668808;
  private static final long MAX_SEND_REPORT_COUNT = 10L;
  private static final long SEND_TIMEOUT = 35000L;
  private static final int STEP_ADD = 2;
  private static final int STEP_END = 3;
  private static final int STEP_REPORT = 5;
  private static final int STEP_SINGLE = 4;
  private static final int STEP_START = 1;
  private static final int WRITE_PERIOD = 2000;
  public static boolean isDoneCheckTimeout = false;
  private static byte[] mInitLock;
  private static byte[] mLock = new byte[0];
  public final long EXIT_TIME_OUT_PREIOD = 3600000L;
  private boolean isInit = false;
  private ArrayList<ReportHeader> mDBCacheReportHeaders = new ArrayList(8);
  private ArrayList<ReportItem> mDBCacheReportItems = new ArrayList(8);
  private VACDReportDBHelper mDbHelper = new VACDReportDBHelper(BaseApplicationImpl.getApplication());
  private AtomicBoolean mIsInitWriteDBThread = new AtomicBoolean(true);
  public long mLastReportTime;
  private Handler mLocalTimeOutHandler;
  private HandlerThread mLocalTimeOutThread;
  private Handler mReportCacheHandler;
  private HandlerThread mReportCacheThread;
  private Map<Long, ReportInfo> mReportInfos = Collections.synchronizedMap(new HashMap(8));
  private BusinessObserver mReportObserver = new VACDReportServiceImpl.5(this);
  private Map<Long, Long> mSendingReportInfos = Collections.synchronizedMap(new HashMap(8));
  private Handler mWriteHandler;
  private HandlerThread mWriteThread;
  
  static
  {
    mInitLock = new byte[0];
  }
  
  private void handleReponse(List<ReportHeader> paramList)
  {
    ThreadManager.post(new VACDReportServiceImpl.6(this, paramList), 10, null, true);
  }
  
  private void handleReports(int paramInt)
  {
    writeCacheToDB(paramInt);
    if ((this.mReportInfos != null) && (!this.mReportInfos.isEmpty()))
    {
      boolean bool;
      do
      {
        ArrayList localArrayList = new ArrayList();
        bool = preProcessReports(localArrayList);
        sendReports(localArrayList);
      } while (bool);
    }
  }
  
  private void init()
  {
    init(false);
  }
  
  private void initReportThread()
  {
    if (this.mReportCacheThread == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "ReportThread start.");
      }
      this.mReportCacheThread = new HandlerThread("QWalletReport_Report");
      this.mReportCacheThread.start();
      this.mReportCacheHandler = new VACDReportServiceImpl.3(this, this.mReportCacheThread.getLooper());
    }
  }
  
  private void initTimeOutThread(boolean paramBoolean)
  {
    Handler localHandler;
    VACDReportServiceImpl.2 local2;
    if (this.mLocalTimeOutThread == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "TimeOutThread start. isOnlyCheckTimeoutOnQQStart=" + paramBoolean);
      }
      this.mLocalTimeOutThread = new HandlerThread("QWalletReport_Check");
      this.mLocalTimeOutThread.start();
      this.mLocalTimeOutHandler = new Handler(this.mLocalTimeOutThread.getLooper());
      localHandler = this.mLocalTimeOutHandler;
      local2 = new VACDReportServiceImpl.2(this, paramBoolean);
      if (!paramBoolean) {
        break label112;
      }
    }
    label112:
    for (long l = 5000L;; l = 0L)
    {
      localHandler.postDelayed(local2, l);
      return;
    }
  }
  
  private void initWriteDBThread()
  {
    if (this.mIsInitWriteDBThread.compareAndSet(true, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "WriteDBThread start.");
      }
      this.mWriteThread = new HandlerThread("QWalletReport_WriteDB");
      this.mWriteThread.start();
      this.mWriteHandler = new Handler(this.mWriteThread.getLooper());
      this.mWriteHandler.postDelayed(new VACDReportServiceImpl.4(this, new byte[0]), 2000L);
    }
  }
  
  private boolean preProcessReports(List<ReportInfo> paramList)
  {
    Object localObject;
    ReportInfo localReportInfo;
    ArrayList localArrayList;
    int i;
    label253:
    do
    {
      try
      {
        localObject = new ArrayList(this.mReportInfos.values());
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break;
        }
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localReportInfo = (ReportInfo)localIterator.next();
          if ((localReportInfo != null) && (localReportInfo.body != null) && (localReportInfo.body.reportItems != null) && (!localReportInfo.body.reportItems.isEmpty()) && (localReportInfo.header != null) && (localReportInfo.header.totalTime >= 0L))
          {
            long l = localReportInfo.header.seqno;
            if (this.mSendingReportInfos.containsKey(Long.valueOf(l)))
            {
              if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - ((Long)this.mSendingReportInfos.get(Long.valueOf(l))).longValue()) > 35000L) {
                this.mSendingReportInfos.remove(Long.valueOf(l));
              }
            }
            else
            {
              if (paramList.size() > 10L) {
                return true;
              }
              paramList.add(localReportInfo);
              Collections.sort(localReportInfo.body.reportItems);
              localArrayList = localReportInfo.body.reportItems;
              localObject = null;
              i = 0;
              if (i >= localArrayList.size()) {
                break label316;
              }
              ReportItem localReportItem = (ReportItem)localArrayList.get(i);
              if (i == 0) {
                localReportItem.costTime = 0L;
              } else {
                localReportItem.costTime = (localReportItem.createTime - ((ReportItem)localObject).createTime);
              }
            }
          }
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
      return false;
      if ((localObject != null) && (((ReportItem)localObject).result != 0)) {
        localReportInfo.header.result = ((ReportItem)localObject).result;
      }
    } while (localReportInfo.header.result != -1);
    label316:
    int j = 0;
    int k = localArrayList.size() - 2;
    for (;;)
    {
      boolean bool;
      if (k >= 0)
      {
        localObject = (ReportItem)localArrayList.get(k);
        if (localObject == null) {
          break label652;
        }
        i = j;
        if (!TextUtils.isEmpty(((ReportItem)localObject).step))
        {
          i = j;
          if (((ReportItem)localObject).step.equals("qpay_gate.cgi.end"))
          {
            bool = TextUtils.isEmpty(((ReportItem)localObject).params);
            i = j;
            if (bool) {}
          }
        }
        try
        {
          int m = ((ReportItem)localObject).params.indexOf("&cardtype=");
          i = j;
          if (m != -1)
          {
            i = "&cardtype=".length() + m;
            i = Integer.valueOf(((ReportItem)localObject).params.substring(i, i + 1)).intValue();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
        }
        j = i;
        if (((ReportItem)localObject).result == 0) {
          break label652;
        }
        j = i;
        if (((ReportItem)localObject).result == -1) {
          break label652;
        }
        localReportInfo.header.result = ((ReportItem)localObject).result;
        bool = false;
      }
      for (;;)
      {
        if ((bool) && (i > 0)) {
          localReportInfo.header.result = (i + 668900);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VACDReport", 2, "handleUserGiveUp seqno=" + localReportInfo.header.seqno + ",result:" + localReportInfo.header.result + ",isUserGiveUp" + bool);
        break;
        bool = true;
        i = j;
      }
      return false;
      i += 1;
      localObject = localException;
      break label253;
      label652:
      k -= 1;
    }
  }
  
  private void sendReports(List<ReportInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new StringBuffer();
        i = 0;
        if (i < paramList.size())
        {
          this.mSendingReportInfos.put(Long.valueOf(((ReportInfo)paramList.get(i)).header.seqno), Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
          ((StringBuffer)localObject).append(((ReportInfo)paramList.get(i)).header.seqno);
          if (i < paramList.size() - 1) {
            ((StringBuffer)localObject).append('|');
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("VACDReport", 2, "sendReports, sendingSize=" + this.mSendingReportInfos.size() + ", seqnoList=" + ((StringBuffer)localObject).toString());
          }
          localObject = new ReportReq();
          ((ReportReq)localObject).reports = new ArrayList(paramList);
          paramList = BaseApplicationImpl.getApplication().getRuntime();
          NewIntent localNewIntent = new NewIntent(paramList.getApplication(), VACDReportServlet.class);
          localNewIntent.putExtra("req", (Serializable)localObject);
          localNewIntent.putExtra("cmd_type", 1);
          localNewIntent.setObserver(this.mReportObserver);
          paramList.startServlet(localNewIntent);
          return;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  private void writeCacheToDB(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VACDReport", 2, "writeCacheToDB, from=" + paramInt + ", headerSize=" + this.mDBCacheReportHeaders.size() + ", itemSize=" + this.mDBCacheReportItems.size());
    }
    if (this.mDBCacheReportHeaders.size() > 0)
    {
      this.mDbHelper.c(this.mDBCacheReportHeaders);
      this.mDBCacheReportHeaders.clear();
    }
    if (this.mDBCacheReportItems.size() > 0)
    {
      this.mDbHelper.b(this.mDBCacheReportItems);
      this.mDBCacheReportItems.clear();
    }
  }
  
  public void addReportItem(long paramLong, String paramString, ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "addReportItem seqno=" + paramLong + "  item is null return.");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        return;
        init();
      } while (this.mReportCacheHandler == null);
      localMessage = this.mReportCacheHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 2;
    localMessage.obj = new Object[] { Long.valueOf(paramLong), paramString, paramReportItem };
    this.mReportCacheHandler.sendMessage(localMessage);
  }
  
  public void endReport(long paramLong, ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "endReport seqno=" + paramLong + "  item is null return.");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        return;
        init();
      } while (this.mReportCacheHandler == null);
      localMessage = this.mReportCacheHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 3;
    localMessage.obj = new Object[] { Long.valueOf(paramLong), paramReportItem };
    this.mReportCacheHandler.sendMessage(localMessage);
  }
  
  /* Error */
  public void init(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 358	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   4: putfield 568	com/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl:mLastReportTime	J
    //   7: aload_0
    //   8: getfield 86	com/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl:isInit	Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: getstatic 74	com/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl:mInitLock	[B
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +29 -> 53
    //   27: ldc 211
    //   29: iconst_2
    //   30: new 241	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 570
    //   40: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_1
    //   44: invokevirtual 251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield 86	com/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl:isInit	Z
    //   58: iconst_1
    //   59: putstatic 76	com/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl:isDoneCheckTimeout	Z
    //   62: new 572	com/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl$1
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 573	com/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl$1:<init>	(Lcom/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl;)V
    //   70: bipush 10
    //   72: aconst_null
    //   73: iconst_0
    //   74: invokestatic 182	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   77: iload_1
    //   78: ifne +11 -> 89
    //   81: aload_0
    //   82: invokespecial 575	com/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl:initWriteDBThread	()V
    //   85: aload_0
    //   86: invokespecial 577	com/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl:initReportThread	()V
    //   89: aload_0
    //   90: iload_1
    //   91: invokespecial 579	com/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl:initTimeOutThread	(Z)V
    //   94: aload_2
    //   95: monitorexit
    //   96: return
    //   97: astore_3
    //   98: aload_2
    //   99: monitorexit
    //   100: aload_3
    //   101: athrow
    //   102: astore_3
    //   103: ldc 211
    //   105: iconst_1
    //   106: ldc_w 581
    //   109: aload_3
    //   110: invokestatic 585	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_0
    //   114: invokevirtual 588	com/tencent/mobileqq/qwallet/report/impl/VACDReportServiceImpl:onDestroy	()V
    //   117: goto -23 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	VACDReportServiceImpl
    //   0	120	1	paramBoolean	boolean
    //   97	4	3	localObject	Object
    //   102	8	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   21	53	97	finally
    //   53	77	97	finally
    //   81	89	97	finally
    //   89	94	97	finally
    //   94	96	97	finally
    //   98	100	97	finally
    //   103	117	97	finally
    //   21	53	102	java/lang/Throwable
    //   53	77	102	java/lang/Throwable
    //   81	89	102	java/lang/Throwable
    //   89	94	102	java/lang/Throwable
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy()
  {
    synchronized (mLock)
    {
      if (!this.isInit) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "VACDReportServiceImpl destroy@" + hashCode());
      }
      this.isInit = false;
      mLock.notifyAll();
      if (this.mReportCacheHandler != null) {
        this.mReportCacheHandler.removeCallbacksAndMessages(null);
      }
      if (this.mReportCacheThread != null)
      {
        this.mReportCacheThread.quit();
        this.mReportCacheThread = null;
      }
      if (this.mWriteThread != null)
      {
        this.mWriteThread.quit();
        this.mWriteThread = null;
      }
      if (this.mLocalTimeOutHandler != null) {
        this.mLocalTimeOutHandler.removeCallbacksAndMessages(null);
      }
      if (this.mLocalTimeOutThread != null)
      {
        this.mLocalTimeOutThread.quit();
        this.mLocalTimeOutThread = null;
      }
      if (this.mReportInfos != null) {
        this.mReportInfos.clear();
      }
      if (this.mSendingReportInfos != null) {
        this.mSendingReportInfos.clear();
      }
      return;
    }
  }
  
  public void singleReport(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem)
  {
    if (paramReportHeader == null) {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "singleReport:header is null return");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramReportHeader.seqno > 0L) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("VACDReport", 2, "singleReport header seqno=" + paramReportHeader.seqno + " is illegal!");
          return;
          if (paramReportItem != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("VACDReport", 2, "singleReport:item is null return");
        return;
        init();
      } while (this.mReportCacheHandler == null);
      localMessage = this.mReportCacheHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 4;
    localMessage.obj = new Object[] { paramString, paramReportHeader, paramReportItem };
    this.mReportCacheHandler.sendMessage(localMessage);
  }
  
  public void startReport(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem)
  {
    if (paramReportHeader == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "startReport header is null return");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        do
        {
          return;
          if (paramReportHeader.seqno > 0L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VACDReport", 2, "startReport header seqno=" + paramReportHeader.seqno + " is illegal!");
        return;
        init();
      } while (this.mReportCacheHandler == null);
      localMessage = this.mReportCacheHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 1;
    localMessage.obj = new Object[] { paramString, paramReportHeader, paramReportItem };
    this.mReportCacheHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */