package com.tencent.mobileqq.highway;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.api.RequestOps;
import com.tencent.mobileqq.highway.api.TransactionOps;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;

public class HwEngine
  implements TransactionOps, RequestOps, INetInfoHandler
{
  public static final boolean ISDEBUG = true;
  public static int appId;
  public AppRuntime app;
  public String currentUin;
  public AtomicLong dwFlow_Wifi = new AtomicLong(0L);
  public AtomicLong dwFlow_Xg = new AtomicLong(0L);
  private SparseArray<HwNetSegConf> mBuzSegConfigs;
  public ConnManager mConnManager;
  private Context mContext;
  public RequestWorker mRequestWorker;
  private HwNetSegConf mSegConfig;
  public TransactionWorker mTransWorker;
  public WeakNetLearner mWeakNetLearner;
  private WeakNetCallback probeEngineCallBack = new WeakNetCallback()
  {
    public void onResultOverflow(HashMap<String, String> paramAnonymousHashMap)
    {
      if ((paramAnonymousHashMap == null) || (paramAnonymousHashMap.isEmpty())) {
        return;
      }
      BdhLogUtil.LogEvent("P", "probe result upload to dengta, count " + paramAnonymousHashMap.size());
      RdmReq localRdmReq = new RdmReq();
      localRdmReq.isMerge = false;
      localRdmReq.isRealTime = true;
      localRdmReq.isSucceed = true;
      localRdmReq.eventName = "actWeaknetProbe";
      localRdmReq.elapse = 0L;
      localRdmReq.size = 0L;
      localRdmReq.params = paramAnonymousHashMap;
      try
      {
        paramAnonymousHashMap = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), localRdmReq);
        paramAnonymousHashMap.setAppId(HwEngine.appId);
        paramAnonymousHashMap.setTimeout(30000L);
        MsfServiceSdk.get().sendMsg(paramAnonymousHashMap);
        return;
      }
      catch (Exception paramAnonymousHashMap)
      {
        paramAnonymousHashMap.printStackTrace();
        BdhLogUtil.LogException("P", "upload report has exception ", paramAnonymousHashMap);
      }
    }
  };
  public AtomicLong upFlow_Wifi = new AtomicLong(0L);
  public AtomicLong upFlow_Xg = new AtomicLong(0L);
  
  public HwEngine(Context paramContext, String paramString, int paramInt, AppRuntime paramAppRuntime)
  {
    this.mContext = paramContext;
    appId = paramInt;
    this.currentUin = paramString;
    this.app = paramAppRuntime;
    initHwEngine();
  }
  
  private void dumpEngineInfo()
  {
    int i = this.mTransWorker.getTransactionNum();
    int j = this.mConnManager.getCurrentConnNum();
    BdhLogUtil.LogEvent("E", "dumpEngineInfo<-- : transNum:" + i + " connNum:" + j);
  }
  
  public void SubmitAckRequest(RequestAck paramRequestAck)
  {
    this.mRequestWorker.sendAckRequest(paramRequestAck);
  }
  
  public void cancelAckRequest(RequestAck paramRequestAck)
  {
    this.mRequestWorker.cancelAckRequest(paramRequestAck);
  }
  
  public void cancelTransactionTask(Transaction paramTransaction)
  {
    this.mTransWorker.cancelTransaction(paramTransaction);
  }
  
  public void closeEngine()
  {
    BdhLogUtil.LogEvent("E", "Close Engine.");
    this.mTransWorker.onDestroy();
    this.mRequestWorker.onDestroy();
    this.mConnManager.onDestroy();
    this.mWeakNetLearner.onDestroy();
    this.mContext = null;
    this.app = null;
  }
  
  public Context getAppContext()
  {
    return this.mContext;
  }
  
  public SparseArray<HwNetSegConf> getCurrentBuzConfigs()
  {
    SparseArray localSparseArray2 = this.mBuzSegConfigs;
    SparseArray localSparseArray1 = localSparseArray2;
    if (localSparseArray2 == null)
    {
      localSparseArray1 = ConfigManager.getInstance(getAppContext(), this.app, appId, this.currentUin).getAllBuzSegConfs(getAppContext());
      this.mBuzSegConfigs = localSparseArray1;
    }
    return localSparseArray1;
  }
  
  public HwNetSegConf getCurrentConfig()
  {
    HwNetSegConf localHwNetSegConf2 = this.mSegConfig;
    HwNetSegConf localHwNetSegConf1 = localHwNetSegConf2;
    if (localHwNetSegConf2 == null)
    {
      localHwNetSegConf1 = ConfigManager.getInstance(getAppContext(), this.app, appId, this.currentUin).getNetSegConf(getAppContext());
      this.mSegConfig = localHwNetSegConf1;
    }
    return localHwNetSegConf1;
  }
  
  public void initHwEngine()
  {
    this.mConnManager = new ConnManager(this);
    this.mRequestWorker = new RequestWorker(this);
    this.mTransWorker = new TransactionWorker(this);
    this.mWeakNetLearner = new WeakNetLearner(this.mContext, this.probeEngineCallBack);
    this.mConnManager.onInit();
    this.mRequestWorker.onInit();
    this.mTransWorker.onInit();
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
  }
  
  public void onNetMobile2None()
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetMobile2None");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(false);
    ConfigManager.getInstance(this.mContext, this.app, appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetMobile2Wifi");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this.app, appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetNone2Mobile");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this.app, appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, true);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetNone2Wifi");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this.app, appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetWifi2Mobile");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this.app, appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, true);
  }
  
  public void onNetWifi2None()
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetWifi2None");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(false);
    ConfigManager.getInstance(this.mContext, this.app, appId, this.currentUin).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
  }
  
  public void preConnect()
  {
    BdhLogUtil.LogEvent("E", "preConnect.");
    this.mRequestWorker.sendConnectRequest(0L, true);
  }
  
  public void resumeTransactionTask(Transaction paramTransaction)
  {
    this.mTransWorker.resumeTransaction(paramTransaction);
  }
  
  public void stopTransactionTask(Transaction paramTransaction)
  {
    this.mTransWorker.stopTransaction(paramTransaction);
  }
  
  public int submitTransactionTask(Transaction paramTransaction)
  {
    int i = this.mTransWorker.submitTransation(paramTransaction);
    dumpEngineInfo();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.HwEngine
 * JD-Core Version:    0.7.0.1
 */