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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.report.IVACDReportService;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
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
  private VACDReportDBHelper mDbHelper = new VACDReportDBHelper(MobileQQ.sMobileQQ);
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
    Object localObject = this.mReportInfos;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      boolean bool;
      do
      {
        localObject = new ArrayList();
        bool = preProcessReports((List)localObject);
        sendReports((List)localObject);
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
    if (this.mLocalTimeOutThread == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TimeOutThread start. isOnlyCheckTimeoutOnQQStart=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("VACDReport", 2, ((StringBuilder)localObject).toString());
      }
      this.mLocalTimeOutThread = new HandlerThread("QWalletReport_Check");
      this.mLocalTimeOutThread.start();
      this.mLocalTimeOutHandler = new Handler(this.mLocalTimeOutThread.getLooper());
      Object localObject = this.mLocalTimeOutHandler;
      VACDReportServiceImpl.2 local2 = new VACDReportServiceImpl.2(this, paramBoolean);
      long l;
      if (paramBoolean) {
        l = 5000L;
      } else {
        l = 0L;
      }
      ((Handler)localObject).postDelayed(local2, l);
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
    for (;;)
    {
      int i;
      int k;
      try
      {
        localObject = new ArrayList(this.mReportInfos.values());
        if (((List)localObject).isEmpty()) {
          return false;
        }
        Iterator localIterator = ((List)localObject).iterator();
        if (localIterator.hasNext())
        {
          ReportInfo localReportInfo = (ReportInfo)localIterator.next();
          if ((localReportInfo == null) || (localReportInfo.body == null) || (localReportInfo.body.reportItems == null) || (localReportInfo.body.reportItems.isEmpty()) || (localReportInfo.header == null) || (localReportInfo.header.totalTime < 0L)) {
            continue;
          }
          long l = localReportInfo.header.seqno;
          if (this.mSendingReportInfos.containsKey(Long.valueOf(l)))
          {
            if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - ((Long)this.mSendingReportInfos.get(Long.valueOf(l))).longValue()) <= 35000L) {
              continue;
            }
            this.mSendingReportInfos.remove(Long.valueOf(l));
          }
          l = paramList.size();
          boolean bool2 = true;
          if (l > 10L) {
            return true;
          }
          paramList.add(localReportInfo);
          Collections.sort(localReportInfo.body.reportItems);
          ArrayList localArrayList = localReportInfo.body.reportItems;
          localObject = null;
          i = 0;
          if (i < localArrayList.size())
          {
            ReportItem localReportItem = (ReportItem)localArrayList.get(i);
            if (i == 0) {
              localReportItem.costTime = 0L;
            } else {
              localReportItem.costTime = (localReportItem.createTime - ((ReportItem)localObject).createTime);
            }
          }
          else
          {
            if ((localObject != null) && (((ReportItem)localObject).result != 0)) {
              localReportInfo.header.result = ((ReportItem)localObject).result;
            }
            if (localReportInfo.header.result != -1) {
              continue;
            }
            k = localArrayList.size() - 2;
            int j = 0;
            i = j;
            boolean bool1 = bool2;
            if (k >= 0)
            {
              localObject = (ReportItem)localArrayList.get(k);
              if (localObject == null) {
                break label682;
              }
              i = j;
              if (!TextUtils.isEmpty(((ReportItem)localObject).step))
              {
                i = j;
                if (((ReportItem)localObject).step.equals("qpay_gate.cgi.end"))
                {
                  bool1 = TextUtils.isEmpty(((ReportItem)localObject).params);
                  i = j;
                  if (!bool1) {
                    try
                    {
                      int m = ((ReportItem)localObject).params.indexOf("&cardtype=");
                      i = j;
                      if (m != -1)
                      {
                        i = m + 10;
                        i = Integer.valueOf(((ReportItem)localObject).params.substring(i, i + 1)).intValue();
                      }
                    }
                    catch (Exception localException)
                    {
                      localException.printStackTrace();
                      i = 0;
                    }
                  }
                }
              }
              j = i;
              if (((ReportItem)localObject).result == 0) {
                break label682;
              }
              if (((ReportItem)localObject).result == -1)
              {
                j = i;
                break label682;
              }
              localReportInfo.header.result = ((ReportItem)localObject).result;
              bool1 = false;
            }
            if ((bool1) && (i > 0)) {
              localReportInfo.header.result = (i + 668900);
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleUserGiveUp seqno=");
            ((StringBuilder)localObject).append(localReportInfo.header.seqno);
            ((StringBuilder)localObject).append(",result:");
            ((StringBuilder)localObject).append(localReportInfo.header.result);
            ((StringBuilder)localObject).append(",isUserGiveUp");
            ((StringBuilder)localObject).append(bool1);
            QLog.d("VACDReport", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          return false;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
      i += 1;
      Object localObject = localException;
      continue;
      label682:
      k -= 1;
    }
  }
  
  private void sendReports(List<ReportInfo> paramList)
  {
    if (paramList != null) {
      if (paramList.size() == 0) {
        return;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new StringBuffer();
        i = 0;
        if (i < paramList.size())
        {
          this.mSendingReportInfos.put(Long.valueOf(((ReportInfo)paramList.get(i)).header.seqno), Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
          ((StringBuffer)localObject1).append(((ReportInfo)paramList.get(i)).header.seqno);
          if (i >= paramList.size() - 1) {
            break label263;
          }
          ((StringBuffer)localObject1).append('|');
          break label263;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sendReports, sendingSize=");
          ((StringBuilder)localObject2).append(this.mSendingReportInfos.size());
          ((StringBuilder)localObject2).append(", seqnoList=");
          ((StringBuilder)localObject2).append(((StringBuffer)localObject1).toString());
          QLog.d("VACDReport", 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = new ReportReq();
        ((ReportReq)localObject1).reports = new ArrayList(paramList);
        paramList = QWalletHelperImpl.getAppRuntime();
        Object localObject2 = new NewIntent(paramList.getApplication(), VACDReportServlet.class);
        ((NewIntent)localObject2).putExtra("req", (Serializable)localObject1);
        ((NewIntent)localObject2).putExtra("cmd_type", 1);
        ((NewIntent)localObject2).setObserver(this.mReportObserver);
        paramList.startServlet((NewIntent)localObject2);
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
      return;
      label263:
      i += 1;
    }
  }
  
  private void writeCacheToDB(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("writeCacheToDB, from=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", headerSize=");
      localStringBuilder.append(this.mDBCacheReportHeaders.size());
      localStringBuilder.append(", itemSize=");
      localStringBuilder.append(this.mDBCacheReportItems.size());
      QLog.i("VACDReport", 2, localStringBuilder.toString());
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
    if (paramReportItem == null)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("addReportItem seqno=");
        paramString.append(paramLong);
        paramString.append("  item is null return.");
        QLog.d("VACDReport", 2, paramString.toString());
      }
      return;
    }
    init();
    Object localObject = this.mReportCacheHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage();
      if (localObject != null)
      {
        ((Message)localObject).arg1 = 2;
        ((Message)localObject).obj = new Object[] { Long.valueOf(paramLong), paramString, paramReportItem };
        this.mReportCacheHandler.sendMessage((Message)localObject);
      }
    }
  }
  
  public void endReport(long paramLong, ReportItem paramReportItem)
  {
    if (paramReportItem == null)
    {
      if (QLog.isColorLevel())
      {
        paramReportItem = new StringBuilder();
        paramReportItem.append("endReport seqno=");
        paramReportItem.append(paramLong);
        paramReportItem.append("  item is null return.");
        QLog.d("VACDReport", 2, paramReportItem.toString());
      }
      return;
    }
    init();
    Object localObject = this.mReportCacheHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage();
      if (localObject != null)
      {
        ((Message)localObject).arg1 = 3;
        ((Message)localObject).obj = new Object[] { Long.valueOf(paramLong), paramReportItem };
        this.mReportCacheHandler.sendMessage((Message)localObject);
      }
    }
  }
  
  public void init(boolean paramBoolean)
  {
    this.mLastReportTime = NetConnInfoCenter.getServerTimeMillis();
    if (this.isInit) {
      return;
    }
    try
    {
      synchronized (mInitLock)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("VACDReportServiceImpl start, isOnlyCheckTimeoutOnQQStart=");
          localStringBuilder.append(paramBoolean);
          QLog.d("VACDReport", 2, localStringBuilder.toString());
        }
        this.isInit = true;
        isDoneCheckTimeout = true;
        ThreadManager.post(new VACDReportServiceImpl.1(this), 10, null, false);
        if (!paramBoolean)
        {
          initWriteDBThread();
          initReportThread();
        }
        initTimeOutThread(paramBoolean);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VACDReport", 1, "init error", localThrowable);
      onDestroy();
      return;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy()
  {
    synchronized (mLock)
    {
      if (!this.isInit) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VACDReportServiceImpl destroy@");
        localStringBuilder.append(hashCode());
        QLog.d("VACDReport", 2, localStringBuilder.toString());
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
    if (paramReportHeader == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "singleReport:header is null return");
      }
      return;
    }
    if (paramReportHeader.seqno <= 0L)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("singleReport header seqno=");
        paramString.append(paramReportHeader.seqno);
        paramString.append(" is illegal!");
        QLog.d("VACDReport", 2, paramString.toString());
      }
      return;
    }
    if (paramReportItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "singleReport:item is null return");
      }
      return;
    }
    init();
    Object localObject = this.mReportCacheHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage();
      if (localObject != null)
      {
        ((Message)localObject).arg1 = 4;
        ((Message)localObject).obj = new Object[] { paramString, paramReportHeader, paramReportItem };
        this.mReportCacheHandler.sendMessage((Message)localObject);
      }
    }
  }
  
  public void startReport(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem)
  {
    if (paramReportHeader == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "startReport header is null return");
      }
      return;
    }
    if (paramReportHeader.seqno <= 0L)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("startReport header seqno=");
        paramString.append(paramReportHeader.seqno);
        paramString.append(" is illegal!");
        QLog.d("VACDReport", 2, paramString.toString());
      }
      return;
    }
    init();
    Object localObject = this.mReportCacheHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage();
      if (localObject != null)
      {
        ((Message)localObject).arg1 = 1;
        ((Message)localObject).obj = new Object[] { paramString, paramReportHeader, paramReportItem };
        this.mReportCacheHandler.sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */