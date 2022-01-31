package com.tencent.mobileqq.highway.config;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.highway.utils.PTVUpConfigInfo;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class ConfigManager
  implements IHwManager
{
  private static final String HW_CONFIG_PUSH_FILENAME = "highway_config_push";
  private static final String HW_CONFIG_SSOGET_FILENAME = "highway_config_ssoget";
  public static final String TAG = "HWConfigManager";
  private static volatile ConfigManager mUniqueInstance;
  public static int mUseHardCodeIp = -1;
  private Context mContext4MSFGet;
  public int mCurnetIptype;
  private IpContainer mGetIpContainer;
  private ArrayList<HwNetSegConf> mHCNetSegConfList;
  private HardCodeIpList mHardCodeIpList;
  private CopyOnWriteArrayList<String> mHcDomainCandicateList;
  private HwEngine mHwEngine;
  public Ipv6Available mIpv6Available;
  private boolean mIsGettingConfg;
  private IpContainer mPushIpContainer;
  
  private ConfigManager(Context paramContext, AppRuntime paramAppRuntime, String paramString, HwEngine paramHwEngine)
  {
    this.mHwEngine = paramHwEngine;
    this.mIpv6Available = new Ipv6Available();
    this.mHCNetSegConfList = new ArrayList();
    this.mHCNetSegConfList.add(new HwNetSegConf(0L, 8192L, 8L, 1L));
    this.mHCNetSegConfList.add(new HwNetSegConf(1L, 32768L, 8L, 2L));
    this.mHCNetSegConfList.add(new HwNetSegConf(2L, 8192L, 2L, 1L));
    this.mHCNetSegConfList.add(new HwNetSegConf(3L, 16384L, 6L, 2L));
    this.mHCNetSegConfList.add(new HwNetSegConf(4L, 32768L, 8L, 2L));
    initIpConfig(paramContext, paramAppRuntime);
  }
  
  public static ConfigManager getInstance(Context paramContext, HwEngine paramHwEngine)
  {
    if (mUniqueInstance == null) {
      if ((paramContext == null) || (paramHwEngine == null) || (paramHwEngine.app == null) || (paramHwEngine.currentUin == null)) {
        return null;
      }
    }
    try
    {
      if (mUniqueInstance == null) {
        mUniqueInstance = new ConfigManager(paramContext, paramHwEngine.app, paramHwEngine.currentUin, paramHwEngine);
      }
      return mUniqueInstance;
    }
    finally {}
  }
  
  private HwNetSegConf getNetSegConfByType(ArrayList<HwNetSegConf> paramArrayList, int paramInt)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HwNetSegConf localHwNetSegConf = (HwNetSegConf)paramArrayList.next();
      if (localHwNetSegConf.netType == paramInt) {
        return localHwNetSegConf;
      }
    }
    return null;
  }
  
  private void initIpConfig(Context paramContext, AppRuntime paramAppRuntime)
  {
    this.mHcDomainCandicateList = new CopyOnWriteArrayList();
    this.mHcDomainCandicateList.add("htdata3.qq.com");
    this.mHardCodeIpList = new HardCodeIpList();
    this.mPushIpContainer = new IpContainer(paramContext, "highway_config_push", paramAppRuntime);
    this.mGetIpContainer = new IpContainer(paramContext, "highway_config_ssoget", paramAppRuntime);
  }
  
  private void onSvrConnFailed(EndPoint paramEndPoint)
  {
    this.mPushIpContainer.onConnFailed(paramEndPoint);
    this.mGetIpContainer.onConnFailed(paramEndPoint);
  }
  
  private void onSvrConnSuccess(EndPoint paramEndPoint)
  {
    BdhLogUtil.LogEvent("C", "onSvrConnSuccess() IP = " + paramEndPoint.host);
    this.mPushIpContainer.onConnSuccess(paramEndPoint);
    this.mGetIpContainer.onConnSuccess(paramEndPoint);
  }
  
  public SparseArray<HwNetSegConf> getAllBuzSegConfs(Context paramContext)
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(1, getNetSegConf(paramContext, 1));
    localSparseArray.put(0, getNetSegConf(paramContext, 0));
    localSparseArray.put(0, getNetSegConf(paramContext, 0));
    return localSparseArray;
  }
  
  public HwEngine getHwEngine()
  {
    return this.mHwEngine;
  }
  
  public List<EndPoint> getIpList(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList1 = null;
    ArrayList localArrayList3 = new ArrayList();
    if (this.mPushIpContainer != null) {
      localArrayList1 = this.mPushIpContainer.findIpCurNetList(paramContext, paramBoolean);
    }
    ArrayList localArrayList2 = localArrayList1;
    if (this.mGetIpContainer != null)
    {
      localArrayList2 = localArrayList1;
      if (localArrayList1 == null) {
        localArrayList2 = this.mGetIpContainer.findIpCurNetList(paramContext, paramBoolean);
      }
    }
    if (localArrayList2 != null) {
      localArrayList3.addAll(localArrayList2);
    }
    return localArrayList3;
  }
  
  public HwNetSegConf getNetSegConf(Context paramContext)
  {
    return getNetSegConf(paramContext, 0);
  }
  
  public HwNetSegConf getNetSegConf(Context paramContext, int paramInt)
  {
    ArrayList localArrayList1 = this.mHCNetSegConfList;
    Object localObject = this.mPushIpContainer.getNetSegConf(paramInt);
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      switch (HwNetworkUtil.getSystemNetwork(paramContext))
      {
      default: 
        paramInt = 0;
      }
    }
    for (;;)
    {
      paramContext = getNetSegConfByType((ArrayList)localObject, paramInt);
      if (paramContext == null) {
        break label145;
      }
      return paramContext;
      ArrayList localArrayList2 = this.mGetIpContainer.getNetSegConf(paramInt);
      if (localArrayList2 != null)
      {
        localObject = localArrayList2;
        if (!localArrayList2.isEmpty()) {
          break;
        }
      }
      localObject = localArrayList1;
      break;
      paramInt = 0;
      continue;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
    label145:
    BdhLogUtil.LogEvent("C", "getNetSegConf() cannot find segment config from PUSH or HTTP GET");
    return getNetSegConfByType(this.mHCNetSegConfList, paramInt);
  }
  
  public EndPoint getNextSrvAddr(Context paramContext, AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    Object localObject2;
    if (this.mPushIpContainer != null)
    {
      localObject2 = this.mPushIpContainer.findIpCurNet(paramContext, paramBoolean);
      localObject1 = localObject2;
      if (localObject2 != null) {
        BdhLogUtil.LogEvent("C", "getNextSrvAddr, mPushIpContainer.findIpCurNet, epFromPush = " + ((EndPoint)localObject2).toString() + " with key= " + ((EndPoint)localObject2).keyOfAPN + ", timestamp = " + ((EndPoint)localObject2).timestamp);
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      Object localObject3;
      if (this.mGetIpContainer != null)
      {
        localObject3 = this.mGetIpContainer.findIpCurNet(paramContext, paramBoolean);
        localObject2 = localObject3;
        if (localObject3 != null) {
          BdhLogUtil.LogEvent("C", "getNextSrvAddr, mGetIpContainer.findIpCurNet, epFromGet =  " + ((EndPoint)localObject3).toString() + " with key= " + ((EndPoint)localObject3).keyOfAPN + ", timestamp = " + ((EndPoint)localObject3).timestamp);
        }
      }
      for (localObject2 = localObject3;; localObject2 = null)
      {
        if ((localObject1 != null) && (localObject2 != null)) {
          if (((EndPoint)localObject1).timestamp > ((EndPoint)localObject2).timestamp) {
            localObject3 = localObject1;
          }
        }
        do
        {
          do
          {
            do
            {
              return localObject3;
              return localObject2;
              localObject3 = localObject1;
            } while (localObject1 != null);
            if (localObject2 != null) {
              return localObject2;
            }
            if (!this.mIsGettingConfg)
            {
              this.mContext4MSFGet = paramContext;
              HwServlet.getConfig(paramAppRuntime, paramString);
            }
            if (this.mPushIpContainer != null)
            {
              paramString = this.mPushIpContainer.findIpRecent(paramContext, paramBoolean);
              localObject1 = paramString;
              if (paramString != null)
              {
                BdhLogUtil.LogEvent("C", "getNextSrvAddr, mPushIpContainer.findIpRecent, epFromPush = " + paramString.toString() + " with key= " + paramString.keyOfAPN + ", timestamp = " + paramString.timestamp);
                localObject1 = paramString;
              }
            }
            if (this.mGetIpContainer != null)
            {
              paramString = this.mGetIpContainer.findIpRecent(paramContext, paramBoolean);
              localObject2 = paramString;
              if (paramString != null)
              {
                BdhLogUtil.LogEvent("C", "getNextSrvAddr, mGetIpContainer.findIpRecent, epFromGet =  " + paramString.toString() + " with key= " + paramString.keyOfAPN + ", timestamp = " + paramString.timestamp);
                localObject2 = paramString;
              }
            }
            if ((localObject1 == null) || (localObject2 == null)) {
              break;
            }
            localObject3 = localObject1;
          } while (((EndPoint)localObject1).timestamp > ((EndPoint)localObject2).timestamp);
          return localObject2;
          localObject3 = localObject1;
        } while (localObject1 != null);
        if (localObject2 != null) {
          return localObject2;
        }
        if (mUseHardCodeIp == -1) {
          mUseHardCodeIp = 1;
        }
        paramString = this.mHardCodeIpList.getRandomFromCandicate4HardCode(this.mHcDomainCandicateList);
        if (paramString != null)
        {
          BdhLogUtil.LogEvent("C", "getNextSrvAddr(), mHardCodeIpList.getRandomFromCandicate4HardCode, epDomain =  " + paramString.host + " port=" + paramString.port);
          return paramString;
        }
        if (!paramBoolean)
        {
          paramString = this.mHardCodeIpList.getNextIp(paramContext);
          if (paramString != null)
          {
            BdhLogUtil.LogEvent("C", "getNextSrvAddr(), mHardCodeIpList.getNextIp, epHardCode =  " + paramString.host + " port=" + paramString.port);
            return paramString;
          }
        }
        initIpConfig(paramContext, paramAppRuntime);
        return null;
      }
    }
  }
  
  public boolean hasIpv6List(Context paramContext)
  {
    if ((this.mPushIpContainer != null) && (this.mPushIpContainer.findIpCurNet(paramContext, true) != null))
    {
      BdhLogUtil.LogEvent("C", "hasIpv6List: mPushIpContainer has ipv6 list ");
      return true;
    }
    if ((this.mGetIpContainer != null) && (this.mGetIpContainer.findIpCurNet(paramContext, true) != null))
    {
      BdhLogUtil.LogEvent("C", "hasIpv6List: mGetIpContainer has ipv6 list ");
      return true;
    }
    return false;
  }
  
  public boolean isIpv6On()
  {
    if (this.mHwEngine == null)
    {
      BdhLogUtil.LogEvent("C", "isIpv6On, mHwEngine is null ");
      return false;
    }
    BdhLogUtil.LogEvent("C", "isIpv6On, ipv6Switch = " + this.mHwEngine.ipv6Switch + ", ipv6SwitchDual = " + this.mHwEngine.ipv6SwitchDual);
    if (!this.mHwEngine.ipv6Switch) {
      return false;
    }
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    this.mCurnetIptype = i;
    BdhLogUtil.LogEvent("C", "isIpv6On,getActiveNetIpFamily = " + i);
    if ((i == 3) && (!this.mHwEngine.ipv6SwitchDual))
    {
      BdhLogUtil.LogEvent("C", "isIpv6On, ipv6SwitchDual is false ");
      return false;
    }
    if ((i != 2) && (i != 3)) {
      return false;
    }
    Context localContext = this.mHwEngine.getAppContext();
    if (localContext == null)
    {
      BdhLogUtil.LogEvent("C", "isIpv6On, context is null ");
      return false;
    }
    i = -1;
    if (this.mIpv6Available != null)
    {
      i = this.mIpv6Available.getAvailable(localContext);
      BdhLogUtil.LogEvent("C", "isIpv6On, ipv6Available = " + i);
    }
    if ((hasIpv6List(localContext)) && (i != 0))
    {
      BdhLogUtil.LogEvent("C", "isIpv6On, return true");
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    try
    {
      mUniqueInstance = null;
      return;
    }
    finally {}
  }
  
  public void onInit() {}
  
  public void onNetWorkChange(Context paramContext, AppRuntime paramAppRuntime, String paramString, boolean paramBoolean) {}
  
  public void onSrvAddrPush(Context paramContext, AppRuntime paramAppRuntime, String paramString, HwConfig paramHwConfig)
  {
    BdhLogUtil.LogEvent("C", "onSrvAddrPush() ");
    if ((paramHwConfig.ipConf != null) && (paramHwConfig.ipConf.uint32_refresh_cached_ip.get() == 1)) {
      IpContainer.refreshIpLearning();
    }
    if ((paramHwConfig.ipConf != null) && (paramHwConfig.ipConf.uint32_enable_ip_learn.get() == 1))
    {
      com.tencent.mobileqq.highway.iplearning.IpLearningImpl.sEnableIpLearning = 1;
      if (paramHwConfig.dtConf != null) {
        BdhSegTimeoutUtil.updateFromSrv(paramHwConfig.dtConf);
      }
      if (paramHwConfig.openUpConf != null) {
        OpenUpConfig.updateFromSrv(paramHwConfig.openUpConf);
      }
      if (paramHwConfig.videoConf == null) {
        break label146;
      }
      VideoUpConfigInfo.updateFromSrc(paramHwConfig.videoConf);
      label109:
      if (paramHwConfig.ptvCof == null) {
        break label157;
      }
      PTVUpConfigInfo.updateFromSrc(paramHwConfig.ptvCof);
    }
    for (;;)
    {
      this.mPushIpContainer.addNew(paramContext, paramHwConfig, paramAppRuntime, this);
      return;
      com.tencent.mobileqq.highway.iplearning.IpLearningImpl.sEnableIpLearning = 0;
      break;
      label146:
      BdhLogUtil.LogEvent("C", "onSrvAddrPush : hwConfig.videoConf is null ");
      break label109;
      label157:
      BdhLogUtil.LogEvent("C", "onSrvAddrPush : hwConfig.ptvCof is null ");
    }
  }
  
  public void onSrvAddrSsoGet(HwConfig paramHwConfig, AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramHwConfig == null) || (paramHwConfig.ipList.isEmpty()) || (this.mContext4MSFGet == null)) {
      return;
    }
    BdhLogUtil.LogEvent("C", "onSrvAddrHttpGet() ");
    this.mGetIpContainer.addNew(this.mContext4MSFGet, paramHwConfig, paramAppRuntime, this);
    this.mIsGettingConfg = false;
    this.mContext4MSFGet = null;
  }
  
  public void onSrvAddrUnavailable(Context paramContext, AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 3) {
      BdhLogUtil.LogEvent("C", "onSrvAddrUnavailable() connError_unreachable");
    }
    do
    {
      return;
      BdhLogUtil.LogEvent("C", "onSrvAddrUnavailable() IP = " + paramString2);
      boolean bool2 = this.mPushIpContainer.fail(paramString2, paramBoolean);
      boolean bool3 = this.mGetIpContainer.fail(paramString2, paramBoolean);
      boolean bool1 = false;
      paramBoolean = bool1;
      if (!bool2)
      {
        paramBoolean = bool1;
        if (!bool3)
        {
          paramBoolean = bool1;
          if (this.mHcDomainCandicateList != null)
          {
            paramBoolean = HardCodeIpList.foundNRemoveIP(this.mHcDomainCandicateList, paramString2);
            BdhLogUtil.LogEvent("C", "onSrvAddrUnavailable, remove from mHcDomainCandicateList ");
          }
        }
      }
    } while ((paramBoolean) || (this.mHardCodeIpList == null));
    this.mHardCodeIpList.foundNRemove(paramString2);
    BdhLogUtil.LogEvent("C", "onSrvAddrUnavailable, remove from mHardCodeIpList ");
  }
  
  public void onSvrConnFinish(EndPoint paramEndPoint, int paramInt)
  {
    BdhLogUtil.LogEvent("C", " onSvrConnFinish IP = " + paramEndPoint.host + " err:" + paramInt);
    if (paramInt == 0) {
      onSvrConnSuccess(paramEndPoint);
    }
    while (paramInt == 3) {
      return;
    }
    onSvrConnFailed(paramEndPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.ConfigManager
 * JD-Core Version:    0.7.0.1
 */