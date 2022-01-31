package com.tencent.mobileqq.highway.conn;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.highway.utils.HwStatisticMgr;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;

public class ConnManager
  implements IHwManager, IConnectionListener
{
  public static boolean CONN_NUM_CUSTOM = false;
  public static final int IO_TYPE_SYNC = 1;
  private static final int IP_TIMEOUT_FOR_HTTP_PATCH_MAX = 3;
  public static AtomicInteger connSeq = new AtomicInteger(1);
  private long _connStartTime = -1L;
  private AtomicBoolean bUseHttpPatch = new AtomicBoolean(false);
  private int connCount = -1;
  public ArrayList<ConnReportInfo> connInfoList = new ArrayList();
  public volatile int connectedConn;
  public ConcurrentHashMap<Integer, IConnection> connections = new ConcurrentHashMap();
  public HwEngine engine;
  public ConcurrentHashMap<Integer, Runnable> heartBreaks = new ConcurrentHashMap();
  private int iHttpPatchConnId = -1;
  public EndPoint lastEndPoint;
  private ConcurrentHashMap<String, String> mIpTimeOutCounter = new ConcurrentHashMap();
  private List<EndPoint> mReportEndPoint;
  private int mReportFailCnt;
  private boolean mReportHasStart;
  private long mReportStart = -1L;
  private int mReportSuccCnt;
  public volatile AtomicLong vConnCost = new AtomicLong(-1L);
  public volatile int vConnErrCode;
  
  public ConnManager(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
  }
  
  private void createNewConnectionIfNeed(int paramInt, boolean paramBoolean)
  {
    try
    {
      int j = (int)this.engine.getCurrentConfig().curConnNum;
      int i = j;
      if (!paramBoolean)
      {
        i = j;
        if (paramInt <= 1) {
          i = 1;
        }
      }
      j = i;
      if (this.bUseHttpPatch.get()) {
        j = i + 1;
      }
      synchronized (this.connections)
      {
        do
        {
          if (this.connections.size() >= j) {
            break;
          }
          i = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
          if (i == 0)
          {
            BdhLogUtil.LogEvent("C", "CreateNewConnectionIfNeed : No network in networkCenter : ConnSize:" + this.connections.size() + " currentRequests:" + paramInt + " maxConnNum:" + j);
            HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
            this.engine.mRequestWorker.sendConnectRequest(5000L, false);
            return;
          }
        } while (openNewConnection(i, false));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      BdhLogUtil.LogException("C", "Create Conn Error.", localException);
    }
  }
  
  private boolean openNewConnection(int paramInt, boolean paramBoolean)
  {
    ??? = this.engine.getAppContext();
    Object localObject2 = this.engine.app;
    HwEngine localHwEngine = this.engine;
    localObject2 = ConfigManager.getInstance((Context)???, (AppRuntime)localObject2, HwEngine.appId, this.engine.currentUin).getNextSrvAddr(this.engine.getAppContext(), this.engine.app, this.engine.currentUin);
    if ((this.connectedConn <= 0) && (this._connStartTime == -1L)) {
      this._connStartTime = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      synchronized (this.connections)
      {
        int i = this.connections.size();
        if (localObject2 == null)
        {
          BdhLogUtil.LogEvent("C", "OpenNewConnection : ep is Null, connSize:" + i);
          if (i == 0) {
            this.engine.mTransWorker.switchToBackupChannel();
          }
          return false;
        }
        this.lastEndPoint = ((EndPoint)localObject2);
        reportChannelStart((EndPoint)localObject2);
        if ((paramBoolean) || (((EndPoint)localObject2).protoType != 1)) {
          break label278;
        }
        i = connSeq.incrementAndGet();
        if (paramInt == 1)
        {
          paramInt = 10000;
          ??? = new TcpConnection(this, i, (EndPoint)localObject2, paramInt, 30000);
          if ((??? == null) || (!((IConnection)???).connect())) {
            break;
          }
          ((IConnection)???).setConnectListener(this);
          this.connections.put(Integer.valueOf(((IConnection)???).getConnId()), ???);
          return true;
        }
      }
      paramInt = 20000;
      continue;
      label278:
      HttpConnection localHttpConnection = new HttpConnection(this, connSeq.incrementAndGet(), localEndPoint);
      ??? = localHttpConnection;
      if (paramBoolean)
      {
        this.iHttpPatchConnId = localHttpConnection.getConnId();
        BdhLogUtil.LogEvent("C", "OpenNewConnection For Http Patch : ID[" + this.iHttpPatchConnId + "]");
        ??? = localHttpConnection;
      }
    }
    return false;
  }
  
  public long getConnCost()
  {
    return this.vConnCost.getAndSet(-1L);
  }
  
  public int getCurrentConnNum()
  {
    synchronized (this.connections)
    {
      int i = this.connections.size();
      return i;
    }
  }
  
  public boolean hasNet()
  {
    HwNetworkCenter localHwNetworkCenter = HwNetworkCenter.getInstance(this.engine.getAppContext());
    localHwNetworkCenter.updateNetInfo(this.engine.getAppContext());
    return localHwNetworkCenter.getNetType() != 0;
  }
  
  public void increaseDataFlowDw(long paramLong)
  {
    int i = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
    if (i == 1) {
      this.engine.dwFlow_Wifi.addAndGet(paramLong);
    }
    while (i == 0) {
      return;
    }
    this.engine.dwFlow_Xg.addAndGet(paramLong);
  }
  
  public void increaseDataFlowUp(long paramLong)
  {
    int i = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
    if (i == 1) {
      this.engine.upFlow_Wifi.addAndGet(paramLong);
    }
    while (i == 0) {
      return;
    }
    this.engine.upFlow_Xg.addAndGet(paramLong);
  }
  
  public void onConnect(boolean paramBoolean, int paramInt1, IConnection paramIConnection, EndPoint paramEndPoint, int paramInt2, ConnReportInfo paramConnReportInfo)
  {
    Object localObject = null;
    Context localContext = this.engine.getAppContext();
    if (localContext != null)
    {
      localObject = this.engine.app;
      HwEngine localHwEngine = this.engine;
      localObject = ConfigManager.getInstance(localContext, (AppRuntime)localObject, HwEngine.appId, this.engine.currentUin);
    }
    if (paramBoolean)
    {
      this.connectedConn += 1;
      this.engine.mRequestWorker.onConnConnected(paramInt1);
      if (paramIConnection.getProtoType() != 2) {
        this.engine.mRequestWorker.sendHeartBreak(paramInt1, false, false, 0);
      }
      if (this._connStartTime >= 0L)
      {
        long l1 = SystemClock.uptimeMillis();
        long l2 = this._connStartTime;
        this._connStartTime = -1L;
        this.vConnCost.compareAndSet(-1L, l1 - l2);
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((ConfigManager)localObject).onSvrConnFinish(paramEndPoint, paramInt2);
      }
      this.vConnErrCode = paramInt2;
      reportConnectResult(paramEndPoint, paramBoolean, paramInt2, paramConnReportInfo.connElapseTime);
      BdhLogUtil.LogEvent("C", "OnConnect :　connId:" + paramInt1 + " Size:" + this.connections.size() + " errno:" + paramInt2);
      return;
      this.connections.remove(Integer.valueOf(paramIConnection.getConnId()));
      if (localObject != null) {
        ((ConfigManager)localObject).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, paramEndPoint.host, paramInt2);
      }
      if (paramInt2 == 3) {
        this.engine.mRequestWorker.sendConnectRequest(5000L, false);
      } else {
        this.engine.mRequestWorker.sendConnectRequest(0L, false);
      }
    }
  }
  
  public void onConnectionIdle(int paramInt, boolean paramBoolean)
  {
    this.engine.mRequestWorker.sendHeartBreak(paramInt, false, paramBoolean, 60000);
  }
  
  public void onDecodeSucessfully(List<HwResponse> paramList)
  {
    this.engine.mRequestWorker.onReceiveResp(paramList);
  }
  
  public void onDestroy() {}
  
  public void onDisConnect(int paramInt, IConnection paramIConnection)
  {
    HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
    if ((IConnection)this.connections.remove(Integer.valueOf(paramIConnection.getConnId())) != null)
    {
      this.connectedConn -= 1;
      this.engine.mRequestWorker.onConnClose(paramInt);
      BdhLogUtil.LogEvent("C", "OnDisConnect :　connId:" + paramInt + " Size:" + this.connections.size());
    }
    if (paramIConnection.getConnId() == this.iHttpPatchConnId)
    {
      this.iHttpPatchConnId = -1;
      this.bUseHttpPatch.set(false);
    }
  }
  
  public void onHeartBreakResp(int paramInt, EndPoint paramEndPoint)
  {
    BdhLogUtil.LogEvent("C", "onHeartBreakResp : connId:" + paramInt);
    paramEndPoint = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (paramEndPoint != null)
    {
      paramEndPoint.setUrgentFlag(false);
      this.heartBreaks.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void onInit() {}
  
  public void onRecvInvalidData(EndPoint paramEndPoint)
  {
    Context localContext = this.engine.getAppContext();
    if ((paramEndPoint != null) && (localContext != null))
    {
      Object localObject = this.engine.app;
      HwEngine localHwEngine = this.engine;
      localObject = ConfigManager.getInstance(localContext, (AppRuntime)localObject, HwEngine.appId, this.engine.currentUin);
      if (localObject != null) {
        ((ConfigManager)localObject).onSrvAddrUnavailable(localContext, this.engine.app, this.engine.currentUin, paramEndPoint.host, 15);
      }
      BdhLogUtil.LogEvent("P", "receive the invalid data,start weak net probe! ip:" + paramEndPoint.host);
    }
  }
  
  public void onRequestTimeOut(int paramInt)
  {
    BdhLogUtil.LogEvent("C", "onRequestTimeOut : connId:" + paramInt);
    ??? = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (??? != null)
    {
      EndPoint localEndPoint = ((IConnection)???).getEndPoint();
      if (((IConnection)???).getProtoType() == 1)
      {
        ((IConnection)???).setUrgentFlag(true);
        this.mIpTimeOutCounter.put(localEndPoint.host, localEndPoint.host);
        if ((this.bUseHttpPatch.compareAndSet(false, true)) && (this.mIpTimeOutCounter.size() >= 3))
        {
          this.mIpTimeOutCounter.clear();
          paramInt = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
          BdhLogUtil.LogEvent("C", "onRequestTimeOut : About to create a http patch. netType:" + paramInt);
          if (paramInt == 1)
          {
            paramInt = (int)this.engine.getCurrentConfig().curConnNum;
            synchronized (this.connections)
            {
              if (this.connections.size() < paramInt) {
                openNewConnection(1, true);
              }
              return;
            }
          }
          this.bUseHttpPatch.set(false);
        }
      }
      else if (((IConnection)???).getProtoType() == 2)
      {
        this.mIpTimeOutCounter.clear();
        Object localObject3 = this.engine.getAppContext();
        if ((localObject2 != null) && (localObject3 != null))
        {
          AppRuntime localAppRuntime = this.engine.app;
          HwEngine localHwEngine = this.engine;
          localObject3 = ConfigManager.getInstance((Context)localObject3, localAppRuntime, HwEngine.appId, this.engine.currentUin);
          if (localObject3 != null) {
            ((ConfigManager)localObject3).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, localObject2.host, 7);
          }
        }
        ((IConnection)???).disConnect();
        createNewConnectionIfNeed(1, false);
      }
    }
  }
  
  public void onRequestWriteTimeout(int paramInt)
  {
    BdhLogUtil.LogEvent("C", "onRequestWriteTimeout : connId:" + paramInt);
    IConnection localIConnection = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localIConnection != null) {
      localIConnection.disConnect();
    }
  }
  
  public void onUrgentHeartBreakTimeout(int paramInt)
  {
    BdhLogUtil.LogEvent("C", "onUrgentHeartBreakTimeout : connId:" + paramInt);
    Object localObject = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      EndPoint localEndPoint = ((IConnection)localObject).getEndPoint();
      ((IConnection)localObject).disConnect();
      localObject = this.engine.getAppContext();
      if ((localEndPoint != null) && (localObject != null))
      {
        AppRuntime localAppRuntime = this.engine.app;
        HwEngine localHwEngine = this.engine;
        localObject = ConfigManager.getInstance((Context)localObject, localAppRuntime, HwEngine.appId, this.engine.currentUin);
        if (localObject != null) {
          ((ConfigManager)localObject).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, localEndPoint.host, 7);
        }
      }
    }
    createNewConnectionIfNeed(1, false);
  }
  
  public HwRequest pullNextRequest(IConnection paramIConnection, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    int i = 2;
    if (paramBoolean) {
      i = 0;
    }
    HwRequest localHwRequest = this.engine.mRequestWorker.getMaxPriorityRequest(paramIConnection.getConnId(), i, paramLong1, paramLong2, paramInt);
    if ((localHwRequest == null) && (paramIConnection.getProtoType() == 2) && (this.engine.mTransWorker.getTransactionNum() == 0)) {
      paramIConnection.disConnect();
    }
    return localHwRequest;
  }
  
  public void reportChannelStart(EndPoint paramEndPoint)
  {
    int i = this.connCount + 1;
    this.connCount = i;
    paramEndPoint.connIndex = i;
    if (this.mReportHasStart) {
      return;
    }
    this.mReportStart = SystemClock.uptimeMillis();
    this.mReportHasStart = true;
    this.mReportFailCnt = 0;
    this.mReportSuccCnt = 0;
    this.mReportEndPoint = Collections.synchronizedList(new ArrayList());
  }
  
  public void reportChannelStop(boolean paramBoolean)
  {
    if (!this.mReportHasStart) {
      return;
    }
    this.mReportHasStart = false;
    if (paramBoolean) {
      this.connCount = -1;
    }
    int i = this.mReportFailCnt;
    int j = this.mReportSuccCnt;
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.mReportStart;
    HwEngine localHwEngine = this.engine;
    HwStatisticMgr.doReportConnection(HwEngine.appId, this.engine.currentUin, paramBoolean, i + j, this.mReportSuccCnt, this.mReportFailCnt, this.mReportEndPoint, l1 - l2);
  }
  
  public void reportConnectResult(EndPoint paramEndPoint, boolean paramBoolean, int paramInt, long paramLong)
  {
    paramEndPoint.connResult = paramInt;
    paramEndPoint.cost = paramLong;
    if (paramBoolean) {
      this.mReportSuccCnt += 1;
    }
    for (;;)
    {
      this.mReportEndPoint.add(paramEndPoint);
      if ((paramBoolean) || (this.mReportFailCnt >= 8)) {
        reportChannelStop(paramBoolean);
      }
      return;
      this.mReportFailCnt += 1;
    }
  }
  
  public void wakeupConnectionToWrite(int paramInt, boolean paramBoolean)
  {
    createNewConnectionIfNeed(paramInt, paramBoolean);
    synchronized (this.connections)
    {
      Iterator localIterator = this.connections.values().iterator();
      while (localIterator.hasNext())
      {
        IConnection localIConnection = (IConnection)localIterator.next();
        if (localIConnection.isWritable()) {
          localIConnection.wakeupChannel();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.ConnManager
 * JD-Core Version:    0.7.0.1
 */