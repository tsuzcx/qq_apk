package com.tencent.mobileqq.highway;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.api.HighwayConfBean;
import com.tencent.mobileqq.highway.api.RequestOps;
import com.tencent.mobileqq.highway.api.TransactionOps;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;

public class HwEngine
  implements RequestOps, TransactionOps, INetInfoHandler
{
  public static final boolean ISDEBUG = true;
  public static int appId;
  public static int localeId;
  public AppRuntime app;
  public String currentUin;
  public AtomicLong dwFlow_Wifi = new AtomicLong(0L);
  public AtomicLong dwFlow_Xg = new AtomicLong(0L);
  public boolean ipv6Switch;
  private SparseArray<HwNetSegConf> mBuzSegConfigs = null;
  public ConnManager mConnManager;
  private Context mContext;
  public RequestWorker mRequestWorker;
  private HwNetSegConf mSegConfig = null;
  public TransactionWorker mTransWorker;
  public WeakNetLearner mWeakNetLearner;
  private WeakNetCallback probeEngineCallBack = new HwEngine.1(this);
  public AtomicLong upFlow_Wifi = new AtomicLong(0L);
  public AtomicLong upFlow_Xg = new AtomicLong(0L);
  
  public HwEngine(Context paramContext, String paramString, int paramInt1, AppRuntime paramAppRuntime, int paramInt2, boolean paramBoolean)
  {
    this.mContext = paramContext;
    appId = paramInt1;
    localeId = paramInt2;
    this.currentUin = paramString;
    this.app = paramAppRuntime;
    this.ipv6Switch = paramBoolean;
    initHwEngine();
  }
  
  private void dumpEngineInfo()
  {
    int i = this.mTransWorker.getTransactionNum();
    int j = this.mConnManager.getCurrentConnNum();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dumpEngineInfo<-- : transNum:");
    localStringBuilder.append(i);
    localStringBuilder.append(" connNum:");
    localStringBuilder.append(j);
    BdhLogUtil.LogEvent("E", localStringBuilder.toString());
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
    HwServlet.resetStartMask();
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
      localSparseArray1 = ConfigManager.getInstance(getAppContext(), this).getAllBuzSegConfs(getAppContext());
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
      localHwNetSegConf1 = ConfigManager.getInstance(getAppContext(), this).getNetSegConf(getAppContext());
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
    HighwayConfBean.init(this.app);
  }
  
  public void onNetMobile2None()
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetMobile2None");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(false);
    ConfigManager.getInstance(this.mContext, this).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetMobile2Wifi");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetNone2Mobile");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this).onNetWorkChange(this.mContext, this.app, this.currentUin, true);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetNone2Wifi");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetWifi2Mobile");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(true);
    ConfigManager.getInstance(this.mContext, this).onNetWorkChange(this.mContext, this.app, this.currentUin, true);
  }
  
  public void onNetWifi2None()
  {
    BdhLogUtil.LogEvent("N", "NetChanged_ onNetWifi2None");
    this.mSegConfig = null;
    this.mBuzSegConfigs = null;
    HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
    this.mRequestWorker.onNetworkChanged(false);
    ConfigManager.getInstance(this.mContext, this).onNetWorkChange(this.mContext, this.app, this.currentUin, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.HwEngine
 * JD-Core Version:    0.7.0.1
 */