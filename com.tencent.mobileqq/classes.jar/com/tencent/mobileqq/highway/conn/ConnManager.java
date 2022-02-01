package com.tencent.mobileqq.highway.conn;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.ipv6.HappyEyeballsRace;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.ipv6.Ipv6Flags;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.segment.RequestWorker.RequestHandler;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.highway.utils.HwStatisticMgr;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ConnManager
  implements IHwManager, IConnectionListener
{
  private static final int IP_TIMEOUT_FOR_HTTP_PATCH_MAX = 3;
  public static AtomicInteger connSeq = new AtomicInteger(1);
  private long _connStartTime = -1L;
  private AtomicBoolean bUseHttpPatch = new AtomicBoolean(false);
  private int connCount = -1;
  public ArrayList<ConnReportInfo> connInfoList = new ArrayList();
  public volatile int connectedConn = 0;
  public ConcurrentHashMap<Integer, IConnection> connections = new ConcurrentHashMap();
  public HwEngine engine;
  public ConcurrentHashMap<Integer, Runnable> heartBreaks = new ConcurrentHashMap();
  private int iHttpPatchConnId = -1;
  public EndPoint lastEndPoint = null;
  private HappyEyeballsRace mHERace = new HappyEyeballsRace();
  public boolean mHasIpv6List;
  private ConcurrentHashMap<String, String> mIpTimeOutCounter = new ConcurrentHashMap();
  private List<EndPoint> mReportEndPoint;
  private int mReportFailCnt = 0;
  private boolean mReportHasStart = false;
  private long mReportStart = -1L;
  private int mReportSuccCnt = 0;
  public volatile AtomicLong vConnCost = new AtomicLong(-1L);
  public volatile int vConnErrCode = 0;
  
  public ConnManager(HwEngine paramHwEngine)
  {
    this.engine = paramHwEngine;
  }
  
  private void createMultiConn(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createMultiConn， isIpv6 = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", maxConnNum = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", netType = ");
    localStringBuilder.append(paramInt2);
    BdhLogUtil.LogEvent("C", localStringBuilder.toString());
    while ((this.connections.size() < paramInt1) && (openNewConnection(paramInt2, false, paramBoolean) != null)) {}
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
        while (this.connections.size() < j)
        {
          i = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
          if (i == 0)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("CreateNewConnectionIfNeed : No network in networkCenter : ConnSize:");
            localStringBuilder.append(this.connections.size());
            localStringBuilder.append(" currentRequests:");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(" maxConnNum:");
            localStringBuilder.append(j);
            BdhLogUtil.LogEvent("C", localStringBuilder.toString());
            HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
            this.engine.mRequestWorker.sendConnectRequest(5000L, false);
            return;
          }
          if (this.mHERace.mIsRacing)
          {
            BdhLogUtil.LogEvent("C", "CreateNewConnectionIfNeed : is racing , return. ");
            return;
          }
          paramBoolean = isIpv6SwitchOpen(this.engine);
          int k = NetConnInfoCenter.getActiveNetIpFamily(true);
          boolean bool = hasIpv6List();
          this.mHasIpv6List = bool;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("CreateNewConnectionIfNeed : ipv6SwitchOpen = ");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append(" , netStack = ");
          localStringBuilder.append(k);
          localStringBuilder.append(" , hasIpv6List = ");
          localStringBuilder.append(bool);
          BdhLogUtil.LogEvent("C", localStringBuilder.toString());
          if (k == 3)
          {
            if ((this.connections.size() == 0) && (paramBoolean) && (bool)) {
              startRacing(i);
            } else {
              createMultiConn(this.mHERace.mIsIpv6Fast, j, i);
            }
          }
          else if (k == 2) {
            createMultiConn(true, j, i);
          } else {
            createMultiConn(false, j, i);
          }
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      BdhLogUtil.LogException("C", "Create Conn Error.", localException);
    }
  }
  
  private void createRacingConn(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("createRacingConn，isIpv6 =  ");
    ((StringBuilder)???).append(paramBoolean2);
    BdhLogUtil.LogEvent("C", ((StringBuilder)???).toString());
    IConnection localIConnection = openNewConnection(paramInt, paramBoolean1, paramBoolean2);
    if (localIConnection != null) {
      synchronized (this.mHERace)
      {
        this.mHERace.mConnList.add(localIConnection);
        return;
      }
    }
  }
  
  private boolean hasIpv6List()
  {
    Object localObject = this.engine;
    if (localObject != null)
    {
      localObject = ConfigManager.getInstance(((HwEngine)localObject).getAppContext(), this.engine);
      if (localObject != null) {
        return ((ConfigManager)localObject).hasIpv6List(this.engine.getAppContext());
      }
    }
    return false;
  }
  
  private IConnection openNewConnection(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = ConfigManager.getInstance(this.engine.getAppContext(), this.engine).getNextSrvAddr(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, paramBoolean2);
    ??? = new StringBuilder();
    ((StringBuilder)???).append("openNewConnection, isIpv6 = ");
    ((StringBuilder)???).append(paramBoolean2);
    ((StringBuilder)???).append(",ep = ");
    ((StringBuilder)???).append(((EndPoint)localObject2).toString());
    BdhLogUtil.LogEvent("C", ((StringBuilder)???).toString());
    if ((this.connectedConn <= 0) && (this._connStartTime == -1L)) {
      this._connStartTime = SystemClock.uptimeMillis();
    }
    synchronized (this.connections)
    {
      int i = this.connections.size();
      if (localObject2 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("OpenNewConnection : ep is Null, connSize:");
        ((StringBuilder)localObject2).append(i);
        BdhLogUtil.LogEvent("C", ((StringBuilder)localObject2).toString());
        if (i == 0) {
          this.engine.mTransWorker.switchToBackupChannel();
        }
        return null;
      }
      this.lastEndPoint = ((EndPoint)localObject2);
      reportChannelStart((EndPoint)localObject2);
      if ((!paramBoolean1) && (((EndPoint)localObject2).protoType == 1))
      {
        i = connSeq.incrementAndGet();
        if (paramInt == 1) {
          paramInt = 10000;
        } else {
          paramInt = 20000;
        }
        ??? = new TcpConnection(this, i, (EndPoint)localObject2, paramInt, 30000, paramBoolean2);
      }
      else
      {
        localObject2 = new HttpConnection(this, connSeq.incrementAndGet(), (EndPoint)localObject2, paramBoolean2);
        ??? = localObject2;
        if (paramBoolean1)
        {
          this.iHttpPatchConnId = ((IConnection)localObject2).getConnId();
          ??? = new StringBuilder();
          ((StringBuilder)???).append("OpenNewConnection For Http Patch : ID[");
          ((StringBuilder)???).append(this.iHttpPatchConnId);
          ((StringBuilder)???).append("]");
          BdhLogUtil.LogEvent("C", ((StringBuilder)???).toString());
          ??? = localObject2;
        }
      }
      ((IConnection)???).setConnectListener(this);
      if (((IConnection)???).connect())
      {
        this.connections.put(Integer.valueOf(((IConnection)???).getConnId()), ???);
        return ???;
      }
      return null;
    }
  }
  
  private void startRacing(int paramInt)
  {
    BdhLogUtil.LogEvent("C", "startRacing . ");
    Object localObject = this.mHERace;
    boolean bool = true;
    ((HappyEyeballsRace)localObject).mIsRacing = true;
    if ((!isIpv6SwitchOpen(this.engine)) || (!Ipv6Config.getFlags().isIpv6BDHFirst())) {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startRacing，ipv6First =  ");
    ((StringBuilder)localObject).append(bool);
    BdhLogUtil.LogEvent("C", ((StringBuilder)localObject).toString());
    createRacingConn(paramInt, false, bool);
    this.mHERace.mRacingRunnable = new ConnManager.1(this, paramInt, bool);
    this.engine.mRequestWorker.mRequestHandler.postDelayed(this.mHERace.mRacingRunnable, Ipv6Config.getFlags().mConnAttemptDelay);
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
    if (i == 1)
    {
      this.engine.dwFlow_Wifi.addAndGet(paramLong);
      return;
    }
    if (i == 0) {
      return;
    }
    this.engine.dwFlow_Xg.addAndGet(paramLong);
  }
  
  public void increaseDataFlowUp(long paramLong)
  {
    int i = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
    if (i == 1)
    {
      this.engine.upFlow_Wifi.addAndGet(paramLong);
      return;
    }
    if (i == 0) {
      return;
    }
    this.engine.upFlow_Xg.addAndGet(paramLong);
  }
  
  public boolean isIpv6Fast()
  {
    return this.mHERace.mIsIpv6Fast;
  }
  
  public boolean isIpv6SwitchOpen(HwEngine paramHwEngine)
  {
    if ((paramHwEngine != null) && (paramHwEngine.ipv6Switch))
    {
      BdhLogUtil.LogEvent("E", "engine.ipv6Switch is true");
      return true;
    }
    return false;
  }
  
  public void onConnect(boolean paramBoolean, int paramInt1, IConnection paramIConnection, EndPoint paramEndPoint, int paramInt2, ConnReportInfo paramConnReportInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ConnManager.onConnect, isSuccess = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", errno = ");
    ((StringBuilder)localObject).append(paramInt2);
    BdhLogUtil.LogEvent("C", ((StringBuilder)localObject).toString());
    localObject = this.engine.getAppContext();
    if (localObject != null) {
      localObject = ConfigManager.getInstance((Context)localObject, this.engine);
    } else {
      localObject = null;
    }
    synchronized (this.connections)
    {
      this.mHERace.doOnConect(paramBoolean, paramIConnection, this.engine);
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
      else
      {
        this.connections.remove(Integer.valueOf(paramIConnection.getConnId()));
        if (localObject != null) {
          ((ConfigManager)localObject).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, paramEndPoint.host, paramInt2, paramIConnection.isIpv6());
        }
        if (paramInt2 == 3) {
          this.engine.mRequestWorker.sendConnectRequest(5000L, false);
        } else {
          this.engine.mRequestWorker.sendConnectRequest(0L, false);
        }
      }
      if (localObject != null) {
        ((ConfigManager)localObject).onSvrConnFinish(paramEndPoint, paramInt2);
      }
      this.vConnErrCode = paramInt2;
      reportConnectResult(paramEndPoint, paramBoolean, paramInt2, paramConnReportInfo.connElapseTime);
      paramIConnection = new StringBuilder();
      paramIConnection.append("OnConnect :　connId:");
      paramIConnection.append(paramInt1);
      paramIConnection.append(" Size:");
      paramIConnection.append(this.connections.size());
      paramIConnection.append(" errno:");
      paramIConnection.append(paramInt2);
      BdhLogUtil.LogEvent("C", paramIConnection.toString());
      return;
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
    Object localObject = (IConnection)this.connections.remove(Integer.valueOf(paramIConnection.getConnId()));
    if (localObject != null)
    {
      BdhLogUtil.LogEvent("C", "OnDisConnect, mHERace.doOnConnFail.");
      this.mHERace.doOnConnFail((IConnection)localObject);
      this.connectedConn -= 1;
      this.engine.mRequestWorker.onConnClose(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnDisConnect :　connId:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" Size:");
      ((StringBuilder)localObject).append(this.connections.size());
      BdhLogUtil.LogEvent("C", ((StringBuilder)localObject).toString());
    }
    if (paramIConnection.getConnId() == this.iHttpPatchConnId)
    {
      this.iHttpPatchConnId = -1;
      this.bUseHttpPatch.set(false);
    }
  }
  
  public void onHeartBreakResp(int paramInt, EndPoint paramEndPoint, boolean paramBoolean)
  {
    paramEndPoint = new StringBuilder();
    paramEndPoint.append("onHeartBreakResp : connId = ");
    paramEndPoint.append(paramInt);
    paramEndPoint.append(", isUrgent = ");
    paramEndPoint.append(paramBoolean);
    BdhLogUtil.LogEvent("C", paramEndPoint.toString());
    paramEndPoint = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if ((paramEndPoint != null) && (paramBoolean))
    {
      paramEndPoint.setUrgentFlag(false);
      this.heartBreaks.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void onIPV6IllegalUserErr(int paramInt)
  {
    Object localObject2 = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localObject2 != null)
    {
      Object localObject1 = ((IConnection)localObject2).getEndPoint();
      ((IConnection)localObject2).disConnect();
      localObject2 = this.engine.getAppContext();
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject1 = ConfigManager.getInstance((Context)localObject2, this.engine);
        if (localObject1 != null) {
          ((ConfigManager)localObject1).clearIpv6Cfg((Context)localObject2);
        }
      }
    }
    createNewConnectionIfNeed(1, false);
  }
  
  public void onInit() {}
  
  public void onRecvInvalidData(EndPoint paramEndPoint, IConnection paramIConnection)
  {
    Context localContext = this.engine.getAppContext();
    if ((paramEndPoint != null) && (localContext != null))
    {
      ConfigManager localConfigManager = ConfigManager.getInstance(localContext, this.engine);
      if (localConfigManager != null) {
        localConfigManager.onSrvAddrUnavailable(localContext, this.engine.app, this.engine.currentUin, paramEndPoint.host, 15, paramIConnection.isIpv6());
      }
      paramIConnection = new StringBuilder();
      paramIConnection.append("receive the invalid data,start weak net probe! ip:");
      paramIConnection.append(paramEndPoint.host);
      BdhLogUtil.LogEvent("P", paramIConnection.toString());
    }
  }
  
  public void onRequestTimeOut(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onRequestTimeOut : connId:");
    ((StringBuilder)localObject1).append(paramInt);
    BdhLogUtil.LogEvent("C", ((StringBuilder)localObject1).toString());
    localObject1 = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localObject1 != null)
    {
      ??? = ((IConnection)localObject1).getEndPoint();
      if (((IConnection)localObject1).getProtoType() == 1)
      {
        ((IConnection)localObject1).setUrgentFlag(true);
        this.mIpTimeOutCounter.put(((EndPoint)???).host, ((EndPoint)???).host);
        if ((this.bUseHttpPatch.compareAndSet(false, true)) && (this.mIpTimeOutCounter.size() >= 3))
        {
          this.mIpTimeOutCounter.clear();
          paramInt = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onRequestTimeOut : About to create a http patch. netType:");
          ((StringBuilder)???).append(paramInt);
          BdhLogUtil.LogEvent("C", ((StringBuilder)???).toString());
          if (paramInt == 1)
          {
            paramInt = (int)this.engine.getCurrentConfig().curConnNum;
            synchronized (this.connections)
            {
              if (this.connections.size() < paramInt) {
                openNewConnection(1, true, ((IConnection)localObject1).isIpv6());
              }
              return;
            }
          }
          this.bUseHttpPatch.set(false);
        }
      }
      else if (localObject2.getProtoType() == 2)
      {
        this.mIpTimeOutCounter.clear();
        Object localObject4 = this.engine.getAppContext();
        if ((??? != null) && (localObject4 != null))
        {
          localObject4 = ConfigManager.getInstance((Context)localObject4, this.engine);
          if (localObject4 != null) {
            ((ConfigManager)localObject4).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, ((EndPoint)???).host, 7, localObject2.isIpv6());
          }
        }
        localObject2.disConnect();
        createNewConnectionIfNeed(1, false);
      }
    }
  }
  
  public void onRequestWriteTimeout(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRequestWriteTimeout : connId:");
    ((StringBuilder)localObject).append(paramInt);
    BdhLogUtil.LogEvent("C", ((StringBuilder)localObject).toString());
    localObject = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      ((IConnection)localObject).disConnect();
    }
  }
  
  public void onUrgentHeartBreakTimeout(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onUrgentHeartBreakTimeout : connId:");
    ((StringBuilder)localObject1).append(paramInt);
    BdhLogUtil.LogEvent("C", ((StringBuilder)localObject1).toString());
    localObject1 = (IConnection)this.connections.get(Integer.valueOf(paramInt));
    if (localObject1 != null)
    {
      EndPoint localEndPoint = ((IConnection)localObject1).getEndPoint();
      ((IConnection)localObject1).disConnect();
      Object localObject2 = this.engine.getAppContext();
      if ((localEndPoint != null) && (localObject2 != null))
      {
        localObject2 = ConfigManager.getInstance((Context)localObject2, this.engine);
        if (localObject2 != null) {
          ((ConfigManager)localObject2).onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.app, this.engine.currentUin, localEndPoint.host, 7, ((IConnection)localObject1).isIpv6());
        }
      }
    }
    createNewConnectionIfNeed(1, false);
  }
  
  public HwRequest pullNextRequest(IConnection paramIConnection, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 2;
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
    } else {
      this.mReportFailCnt += 1;
    }
    this.mReportEndPoint.add(paramEndPoint);
    if ((paramBoolean) || (this.mReportFailCnt >= 8)) {
      reportChannelStop(paramBoolean);
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
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.ConnManager
 * JD-Core Version:    0.7.0.1
 */