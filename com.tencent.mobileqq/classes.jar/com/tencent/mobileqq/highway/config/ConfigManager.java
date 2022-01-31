package com.tencent.mobileqq.highway.config;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.iplearning.IpLearning;
import com.tencent.mobileqq.highway.iplearning.IpLearning.IpLearningAdapter;
import com.tencent.mobileqq.highway.iplearning.IpLearningImpl;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf;
import com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.highway.utils.PTVUpConfigInfo;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class ConfigManager
  implements IHwManager
{
  private static final boolean FOR_MAX = false;
  public static final int HOLES_PER_SEGMENT = 12;
  private static final String HW_CONFIG_PUSH_FILENAME = "highway_config_push";
  private static final String HW_CONFIG_SSOGET_FILENAME = "highway_config_ssoget";
  private static final boolean IS_TEST_USE_CASE = false;
  public static final int MAX_CONNECT_NUM = 1;
  public static final int MAX_PARALLEL_SEGMENT = 50;
  private static final String PROXY_TAG = "PROXY_IP";
  public static final String TAG = "ConfigManager";
  private static volatile ConfigManager mUniqueInstance;
  private Context mContext4MSFGet;
  private boolean mDomainFirst = true;
  private ArrayList<HwNetSegConf> mHCNetSegConfList = new ArrayList();
  private HardCodeIpList mHardCodeIpList;
  private boolean mHasTriggerMSFGetSucc;
  private CopyOnWriteArrayList<String> mHcDomainCandicateList;
  private ConcurrentHashMap<String, IpLearning> mIpLearners = new ConcurrentHashMap();
  private int mOperator;
  private ArrayList<Integer> mPort4HardCode;
  private IpContainer mPushIpList;
  private IpContainer mPushSsoGetIpList;
  private int mStatus = 0;
  private int maxConnNum = 1;
  
  private ConfigManager(Context paramContext, AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    this.mHCNetSegConfList.add(new HwNetSegConf(0L, 8192L, 8L, 1L));
    this.mHCNetSegConfList.add(new HwNetSegConf(1L, 32768L, 8L, 2L));
    this.mHCNetSegConfList.add(new HwNetSegConf(2L, 8192L, 2L, 1L));
    this.mHCNetSegConfList.add(new HwNetSegConf(3L, 16384L, 6L, 2L));
    this.mHCNetSegConfList.add(new HwNetSegConf(4L, 32768L, 8L, 2L));
    this.mPort4HardCode = new ArrayList();
    this.mPort4HardCode.add(Integer.valueOf(80));
    this.mPort4HardCode.add(Integer.valueOf(8080));
    this.mPort4HardCode.add(Integer.valueOf(443));
    resetSrvAddrState(paramContext, paramAppRuntime, paramString);
  }
  
  private boolean domainFirst(Context paramContext)
  {
    switch (HwNetworkUtil.getSystemNetwork(paramContext))
    {
    case 2: 
    case 3: 
    default: 
      return false;
    }
    return true;
  }
  
  private void enterError(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterError() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 7;
  }
  
  private void enterHcDomain(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterHcDomain() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 5;
    if (this.mHcDomainCandicateList.isEmpty())
    {
      if (this.mDomainFirst) {
        enterHcIp(paramContext, paramAppRuntime, paramString);
      }
    }
    else {
      return;
    }
    enterPushSsoGet(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterHcIp(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterHcIp() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 6;
    if (this.mHardCodeIpList.isEmpty(paramContext))
    {
      if (this.mDomainFirst) {
        enterPushSsoGet(paramContext, paramAppRuntime, paramString);
      }
    }
    else {
      return;
    }
    enterHcDomain(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterInit(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterInit() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 2;
    if (!this.mPushIpList.isEmpty(paramContext))
    {
      enterPushIp(paramContext, paramAppRuntime, paramString);
      return;
    }
    if (!this.mPushSsoGetIpList.isEmpty(paramContext))
    {
      enterPushSsoGet(paramContext, paramAppRuntime, paramString);
      return;
    }
    if (domainFirst(paramContext))
    {
      this.mDomainFirst = true;
      enterHcDomain(paramContext, paramAppRuntime, paramString);
      return;
    }
    this.mDomainFirst = false;
    enterHcIp(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterPre(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterPre() last status = " + getSrvAddrStatusName(this.mStatus));
    this.mStatus = 1;
    this.mPushIpList = new IpContainer(paramContext, "highway_config_push", paramAppRuntime);
    this.mPushSsoGetIpList = new IpContainer(paramContext, "highway_config_ssoget", paramAppRuntime);
    this.mHcDomainCandicateList = new CopyOnWriteArrayList();
    this.mHcDomainCandicateList.add("htdata3.qq.com");
    this.mHardCodeIpList = new HardCodeIpList();
    enterInit(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterPushIp(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterPushIp() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 3;
    if (this.mPushIpList.isEmpty(paramContext)) {
      enterPushSsoGet(paramContext, paramAppRuntime, paramString);
    }
  }
  
  private void enterPushSsoGet(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterPushHttpget() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 4;
    boolean bool = this.mPushSsoGetIpList.isEmpty(paramContext);
    if ((bool) || (!this.mHasTriggerMSFGetSucc))
    {
      this.mContext4MSFGet = paramContext;
      HwServlet.getConfig(paramAppRuntime, paramString);
    }
    if (bool) {
      enterError(paramContext, paramAppRuntime, paramString);
    }
  }
  
  private static boolean foundNRemoveIP(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList, String paramString)
  {
    if (paramCopyOnWriteArrayList == null) {}
    int i;
    do
    {
      return false;
      int j = 0;
      Iterator localIterator = paramCopyOnWriteArrayList.iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((String)localIterator.next()).equalsIgnoreCase(paramString));
      i = 1;
    } while (i == 0);
    paramCopyOnWriteArrayList.remove(paramString);
    return true;
  }
  
  public static ConfigManager getInstance(Context paramContext, AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    if (mUniqueInstance == null) {
      if ((paramContext == null) || (paramAppRuntime == null) || (paramInt == 0) || (paramString == null)) {
        return null;
      }
    }
    try
    {
      if (mUniqueInstance == null) {
        mUniqueInstance = new ConfigManager(paramContext, paramAppRuntime, paramInt, paramString);
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
  
  private IpLearning getOrCreateIpLearnerByKey(String paramString)
  {
    Object localObject;
    if ((IpLearningImpl.sEnableIpLearning == -1) || (IpLearningImpl.sEnableIpLearning == 0))
    {
      localObject = new IpLearning.IpLearningAdapter();
      this.mIpLearners.put(paramString, localObject);
      paramString = (String)localObject;
    }
    IpLearning localIpLearning;
    do
    {
      return paramString;
      localObject = new IpLearningImpl();
      localIpLearning = (IpLearning)this.mIpLearners.putIfAbsent(paramString, localObject);
      paramString = (String)localObject;
    } while (localIpLearning == null);
    return localIpLearning;
  }
  
  private EndPoint getOrderlyFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty())) {
      return new EndPoint((String)paramCopyOnWriteArrayList.get(0), ((Integer)this.mPort4HardCode.get(rand(this.mPort4HardCode.size() - 1))).intValue());
    }
    return null;
  }
  
  private EndPoint getRandomFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty())) {
      return new EndPoint((String)paramCopyOnWriteArrayList.get(rand(paramCopyOnWriteArrayList.size() - 1)), ((Integer)this.mPort4HardCode.get(rand(this.mPort4HardCode.size() - 1))).intValue());
    }
    return null;
  }
  
  private String getSrvAddrStatusName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "NONE";
    case 0: 
      return "NONE";
    case 1: 
      return "PRE";
    case 2: 
      return "INIT";
    case 3: 
      return "PUSH_IP";
    case 4: 
      return "PUSH_SSOGET";
    case 5: 
      return "HC_DOMAIN";
    }
    return "HC_IP";
  }
  
  private static void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigManager", 2, paramString);
    }
  }
  
  private void onSvrConnFailed(EndPoint paramEndPoint)
  {
    switch (this.mStatus)
    {
    case 2: 
    default: 
      return;
    case 3: 
      this.mPushIpList.onConnFailed(paramEndPoint);
      return;
    }
    this.mPushSsoGetIpList.onConnFailed(paramEndPoint);
  }
  
  private void onSvrConnSuccess(EndPoint paramEndPoint)
  {
    log("onSvrConnSuccess() IP = " + paramEndPoint.host + " mStatus:" + this.mStatus);
    switch (this.mStatus)
    {
    case 2: 
    default: 
      return;
    case 3: 
      this.mPushIpList.onConnSuccess(paramEndPoint);
      return;
    }
    this.mPushSsoGetIpList.onConnSuccess(paramEndPoint);
  }
  
  private static int rand(int paramInt)
  {
    return (int)(Math.random() * (paramInt + 1));
  }
  
  public void changeMaxConnNum(int paramInt)
  {
    if (this.maxConnNum != paramInt) {
      this.maxConnNum = paramInt;
    }
  }
  
  public SparseArray<HwNetSegConf> getAllBuzSegConfs(Context paramContext)
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(1, getNetSegConf(paramContext, 1));
    localSparseArray.put(0, getNetSegConf(paramContext, 0));
    localSparseArray.put(0, getNetSegConf(paramContext, 0));
    return localSparseArray;
  }
  
  public int getMaxConnNum()
  {
    return this.maxConnNum;
  }
  
  public HwNetSegConf getNetSegConf(Context paramContext)
  {
    return getNetSegConf(paramContext, 0);
  }
  
  public HwNetSegConf getNetSegConf(Context paramContext, int paramInt)
  {
    int i = 1;
    Object localObject = this.mHCNetSegConfList;
    ArrayList localArrayList = this.mPushIpList.getNetSegConf(paramInt);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      localObject = localArrayList;
      paramInt = 0;
      switch (HwNetworkUtil.getSystemNetwork(paramContext))
      {
      }
    }
    for (;;)
    {
      paramContext = getNetSegConfByType((ArrayList)localObject, paramInt);
      if (paramContext == null) {
        break label172;
      }
      return paramContext;
      localArrayList = this.mPushSsoGetIpList.getNetSegConf(paramInt);
      if (localArrayList != null)
      {
        paramInt = 1;
        label111:
        if (localArrayList.isEmpty()) {
          break label137;
        }
      }
      while ((paramInt & i) != 0)
      {
        localObject = localArrayList;
        break;
        paramInt = 0;
        break label111;
        label137:
        i = 0;
      }
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
    label172:
    log("getNetSegConf() cannot find segment config from PUSH or HTTP GET");
    return getNetSegConfByType(this.mHCNetSegConfList, paramInt);
  }
  
  public EndPoint getNextSrvAddr(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    EndPoint localEndPoint;
    switch (this.mStatus)
    {
    default: 
      localEndPoint = null;
    }
    while (localEndPoint != null)
    {
      log("getNextSrvAddr() IP = " + localEndPoint.host + " port=" + localEndPoint.port + "  current status = " + getSrvAddrStatusName(this.mStatus));
      return localEndPoint;
      localEndPoint = null;
      continue;
      localEndPoint = this.mPushIpList.get(paramContext);
      continue;
      localEndPoint = this.mPushSsoGetIpList.get(paramContext);
      continue;
      localEndPoint = getRandomFromCandicate4HardCode(this.mHcDomainCandicateList);
      continue;
      localEndPoint = this.mHardCodeIpList.getNextIp(paramContext);
      continue;
      localEndPoint = null;
    }
    log("getNextSrvAddr() IP = none current  status = " + getSrvAddrStatusName(this.mStatus));
    resetSrvAddrState(paramContext, paramAppRuntime, paramString);
    return localEndPoint;
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  public void onNetWorkChange(Context paramContext, AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if ((this.mStatus == 7) && (!this.mHardCodeIpList.isEmpty(paramContext)))
    {
      log("onNetWorkChange() current status = " + getSrvAddrStatusName(this.mStatus));
      enterHcIp(paramContext, paramAppRuntime, paramString);
    }
    if (paramBoolean) {
      onProxyIpChanged(paramAppRuntime);
    }
  }
  
  public void onProxyIpChanged(AppRuntime paramAppRuntime)
  {
    this.mPushIpList.addProxyIp(paramAppRuntime, true);
    this.mPushSsoGetIpList.addProxyIp(paramAppRuntime, true);
  }
  
  public void onSrvAddrPush(Context paramContext, AppRuntime paramAppRuntime, String paramString, HwConfig paramHwConfig)
  {
    log("<BDH_LOG>onSrvAddrPush() current status = " + getSrvAddrStatusName(this.mStatus));
    if ((paramHwConfig.ipConf != null) && (paramHwConfig.ipConf.uint32_refresh_cached_ip.get() == 1)) {
      refreshIpLearning();
    }
    if ((paramHwConfig.ipConf != null) && (paramHwConfig.ipConf.uint32_enable_ip_learn.get() == 1))
    {
      IpLearningImpl.sEnableIpLearning = 1;
      if (paramHwConfig.dtConf != null) {
        BdhSegTimeoutUtil.updateFromSrv(paramHwConfig.dtConf);
      }
      if (paramHwConfig.openUpConf != null) {
        OpenUpConfig.updateFromSrv(paramHwConfig.openUpConf);
      }
      if (paramHwConfig.videoConf == null) {
        break label177;
      }
      VideoUpConfigInfo.updateFromSrc(paramHwConfig.videoConf);
      label132:
      if (paramHwConfig.ptvCof == null) {
        break label195;
      }
      PTVUpConfigInfo.updateFromSrc(paramHwConfig.ptvCof);
    }
    for (;;)
    {
      if (this.mPushIpList.addNew(paramContext, paramHwConfig, paramAppRuntime)) {
        enterInit(paramContext, paramAppRuntime, paramString);
      }
      return;
      IpLearningImpl.sEnableIpLearning = 0;
      break;
      label177:
      if (!QLog.isColorLevel()) {
        break label132;
      }
      QLog.d("ConfigManager", 2, "<BDH_LOG> onSrvAddrPush : hwConfig.videoConf is null ");
      break label132;
      label195:
      if (QLog.isColorLevel()) {
        QLog.d("ConfigManager", 2, "<BDH_LOG> onSrvAddrPush : hwConfig.ptvCof is null ");
      }
    }
  }
  
  public void onSrvAddrSsoGet(HwConfig paramHwConfig, AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramHwConfig == null) || (paramHwConfig.ipList.isEmpty()) || (this.mContext4MSFGet == null)) {
      return;
    }
    log("onSrvAddrHttpGet() current status = " + getSrvAddrStatusName(this.mStatus));
    this.mHasTriggerMSFGetSucc = true;
    if ((this.mPushSsoGetIpList.addNew(this.mContext4MSFGet, paramHwConfig, paramAppRuntime)) && (this.mStatus == 7)) {
      enterPushSsoGet(this.mContext4MSFGet, paramAppRuntime, paramString);
    }
    this.mContext4MSFGet = null;
  }
  
  public void onSrvAddrUnavailable(Context paramContext, AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 3) {
      log("onSrvAddrUnavailable() connError_unreachable");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            log("onSrvAddrUnavailable() IP = " + paramString2);
            switch (this.mStatus)
            {
            case 2: 
            case 7: 
            default: 
              return;
            }
          } while (!this.mPushIpList.fail(paramString2));
          enterPushIp(paramContext, paramAppRuntime, paramString1);
          return;
        } while (!this.mPushSsoGetIpList.fail(paramString2));
        enterPushSsoGet(paramContext, paramAppRuntime, paramString1);
        return;
      } while (!foundNRemoveIP(this.mHcDomainCandicateList, paramString2));
      enterHcDomain(paramContext, paramAppRuntime, paramString1);
      return;
    } while ((this.mHardCodeIpList == null) || (!this.mHardCodeIpList.foundNRemove(paramString2)));
    enterHcIp(paramContext, paramAppRuntime, paramString1);
  }
  
  public void onSvrConnFinish(EndPoint paramEndPoint, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IpLearning", 2, " onSvrConnFinish IP = " + paramEndPoint.host + " mStatus:" + this.mStatus + " err:" + paramInt);
    }
    if (paramInt == 0) {
      onSvrConnSuccess(paramEndPoint);
    }
    while (paramInt == 3) {
      return;
    }
    onSvrConnFailed(paramEndPoint);
  }
  
  public void refreshIpLearning()
  {
    this.mIpLearners.clear();
  }
  
  public void resetSrvAddrState(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("resetSrvAddrState()");
    enterPre(paramContext, paramAppRuntime, paramString);
  }
  
  public void setOperator(int paramInt)
  {
    this.mOperator = paramInt;
  }
  
  private class Candiate
  {
    public int index;
    public String ip;
    
    public Candiate(String paramString)
    {
      this.ip = paramString;
      this.index = ConfigManager.rand(100);
    }
  }
  
  public class CustomComparator
    implements Comparator<ConfigManager.Candiate>
  {
    public CustomComparator() {}
    
    public int compare(ConfigManager.Candiate paramCandiate1, ConfigManager.Candiate paramCandiate2)
    {
      if (paramCandiate1.index < paramCandiate2.index) {
        return -1;
      }
      if (paramCandiate1.index == paramCandiate2.index) {
        return 0;
      }
      return 1;
    }
  }
  
  private class HardCodeIpList
  {
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaMobile;
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaTelecom;
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaUnicom;
    private CopyOnWriteArrayList<String> mHcIpCandicateListOverseas;
    private CopyOnWriteArrayList<String> mHcIpCandicateListWifi;
    
    public HardCodeIpList()
    {
      if (this.mHcIpCandicateListWifi == null)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        ArrayList localArrayList4 = new ArrayList();
        localArrayList3.add(new ConfigManager.Candiate(ConfigManager.this, "121.51.141.73"));
        localArrayList3.add(new ConfigManager.Candiate(ConfigManager.this, "121.51.139.184"));
        localArrayList3.add(new ConfigManager.Candiate(ConfigManager.this, "183.192.196.205"));
        localArrayList3.add(new ConfigManager.Candiate(ConfigManager.this, "183.192.196.210"));
        localArrayList3.add(new ConfigManager.Candiate(ConfigManager.this, "111.13.34.183"));
        localArrayList3.add(new ConfigManager.Candiate(ConfigManager.this, "111.30.144.63"));
        Collections.sort(localArrayList3, new ConfigManager.CustomComparator(ConfigManager.this));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "58.250.136.56"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "163.177.92.121"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "223.167.86.42"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "223.167.104.34"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "111.161.111.177"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "111.161.64.121"));
        Collections.sort(localArrayList2, new ConfigManager.CustomComparator(ConfigManager.this));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "183.3.225.58"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "183.3.235.188"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "101.227.143.109"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "180.163.25.38"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "123.151.71.152"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "123.151.137.126"));
        Collections.sort(localArrayList1, new ConfigManager.CustomComparator(ConfigManager.this));
        localArrayList4.add(new ConfigManager.Candiate(ConfigManager.this, "103.7.30.143"));
        localArrayList4.add(new ConfigManager.Candiate(ConfigManager.this, "203.205.140.60"));
        Collections.sort(localArrayList4, new ConfigManager.CustomComparator(ConfigManager.this));
        this.mHcIpCandicateListWifi = new CopyOnWriteArrayList();
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList3.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList4.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList3.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList4.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(2)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(2)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList3.get(2)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(3)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(3)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList3.get(3)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(4)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(4)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList3.get(4)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(5)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(5)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList3.get(5)).ip);
      }
      if (this.mHcIpCandicateListChinaMobile == null)
      {
        this.mHcIpCandicateListChinaMobile = new CopyOnWriteArrayList();
        this.mHcIpCandicateListChinaMobile.add("121.51.141.73");
        this.mHcIpCandicateListChinaMobile.add("121.51.139.184");
        this.mHcIpCandicateListChinaMobile.add("183.192.196.205");
        this.mHcIpCandicateListChinaMobile.add("183.192.196.210");
        this.mHcIpCandicateListChinaMobile.add("111.30.159.176");
        this.mHcIpCandicateListChinaMobile.add("111.30.159.160");
      }
      if (this.mHcIpCandicateListChinaUnicom == null)
      {
        this.mHcIpCandicateListChinaUnicom = new CopyOnWriteArrayList();
        this.mHcIpCandicateListChinaUnicom.add("58.250.136.56");
        this.mHcIpCandicateListChinaUnicom.add("163.177.92.121");
        this.mHcIpCandicateListChinaUnicom.add("223.167.86.42");
        this.mHcIpCandicateListChinaUnicom.add("223.167.104.34");
        this.mHcIpCandicateListChinaUnicom.add("220.194.95.148");
        this.mHcIpCandicateListChinaUnicom.add("220.194.95.147");
      }
      if (this.mHcIpCandicateListChinaTelecom == null)
      {
        this.mHcIpCandicateListChinaTelecom = new CopyOnWriteArrayList();
        this.mHcIpCandicateListChinaTelecom.add("183.3.225.58");
        this.mHcIpCandicateListChinaTelecom.add("183.3.235.188");
        this.mHcIpCandicateListChinaTelecom.add("101.227.143.109");
        this.mHcIpCandicateListChinaTelecom.add("180.163.25.38");
        this.mHcIpCandicateListChinaTelecom.add("123.151.190.162");
        this.mHcIpCandicateListChinaTelecom.add("123.151.190.163");
      }
      if (this.mHcIpCandicateListOverseas == null)
      {
        this.mHcIpCandicateListOverseas = new CopyOnWriteArrayList();
        this.mHcIpCandicateListOverseas.add("103.7.30.143");
        this.mHcIpCandicateListOverseas.add("203.205.140.60");
      }
    }
    
    public boolean foundNRemove(String paramString)
    {
      if (ConfigManager.foundNRemoveIP(this.mHcIpCandicateListWifi, paramString)) {}
      while ((ConfigManager.foundNRemoveIP(this.mHcIpCandicateListChinaMobile, paramString)) || (ConfigManager.foundNRemoveIP(this.mHcIpCandicateListChinaUnicom, paramString)) || (ConfigManager.foundNRemoveIP(this.mHcIpCandicateListChinaTelecom, paramString))) {
        return true;
      }
      return false;
    }
    
    public EndPoint getNextIp(Context paramContext)
    {
      if (HwNetworkUtil.isWifiEnabled(paramContext)) {
        return ConfigManager.this.getOrderlyFromCandicate4HardCode(this.mHcIpCandicateListWifi);
      }
      switch (HwNetworkUtil.getCarrierOperatorType(paramContext))
      {
      default: 
        return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListOverseas);
      case 2: 
        return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaMobile);
      case 3: 
        return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaUnicom);
      }
      return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaTelecom);
    }
    
    public boolean isEmpty(Context paramContext)
    {
      if (HwNetworkUtil.isWifiEnabled(paramContext)) {
        return this.mHcIpCandicateListWifi.isEmpty();
      }
      switch (HwNetworkUtil.getCarrierOperatorType(paramContext))
      {
      default: 
        return this.mHcIpCandicateListOverseas.isEmpty();
      case 2: 
        return this.mHcIpCandicateListChinaMobile.isEmpty();
      case 3: 
        return this.mHcIpCandicateListChinaUnicom.isEmpty();
      }
      return this.mHcIpCandicateListChinaTelecom.isEmpty();
    }
  }
  
  public class IpContainer
  {
    private static final String KEY_PRE_APN = "APN_";
    private static final String KEY_PRE_BSSID = "BSSID_";
    private static final String KEY_PRE_SSID = "SSID_";
    private static final String SUB_TAG = "IpContainer.";
    private ConfigManager.PersistentConfig mCfg;
    private String mFileName;
    
    public IpContainer(Context paramContext, String paramString, AppRuntime paramAppRuntime)
    {
      this.mFileName = paramString;
      this.mCfg = readDiskOrCreateNew(paramContext, paramString);
      addProxyIp(paramAppRuntime, false);
    }
    
    private Result find(Context paramContext)
    {
      Result localResult = new Result(null);
      paramContext = getCurrentKey(paramContext);
      localResult.keyList = paramContext;
      localResult.found = false;
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        String str = (String)paramContext.next();
        ArrayList localArrayList = (ArrayList)this.mCfg.mIpList.get(str);
        if (localArrayList != null)
        {
          ConfigManager.log("IpContainer.find() key=" + str + "   value= " + ((EndPoint)localArrayList.get(0)).toString());
          localResult.found = true;
          localResult.epList = localArrayList;
        }
      }
      return localResult;
    }
    
    private boolean findNRemove(ArrayList<EndPoint> paramArrayList, String paramString)
    {
      if (paramArrayList == null)
      {
        bool2 = false;
        return bool2;
      }
      boolean bool2 = false;
      EndPoint localEndPoint = null;
      int i = 0;
      label22:
      for (boolean bool1 = bool2;; bool1 = true)
      {
        try
        {
          if (i < paramArrayList.size())
          {
            localEndPoint = (EndPoint)paramArrayList.get(i);
            if (localEndPoint.host.equalsIgnoreCase(paramString))
            {
              if (paramArrayList.size() <= i) {
                continue;
              }
              paramArrayList.remove(i);
              continue;
            }
          }
          else
          {
            bool2 = bool1;
            if (!bool1) {
              break;
            }
            bool2 = bool1;
            if (localEndPoint.protoType != 1) {
              break;
            }
            localEndPoint.protoType = 2;
            paramArrayList.add(paramArrayList.size(), localEndPoint);
            bool2 = bool1;
            break;
          }
        }
        finally {}
        i += 1;
        break label22;
      }
    }
    
    private ArrayList<String> getCurrentKey(Context paramContext)
    {
      ArrayList localArrayList = new ArrayList();
      switch (HwNetworkUtil.getSystemNetwork(paramContext))
      {
      default: 
        return localArrayList;
      case 1: 
        localArrayList.add("BSSID_" + HwNetworkUtil.getCurrentWifiBSSID(paramContext));
        localArrayList.add("SSID_" + HwNetworkUtil.getCurrentWifiSSID(paramContext));
        return localArrayList;
      }
      localArrayList.add("APN_" + HwNetworkUtil.getCurrentApn(paramContext));
      return localArrayList;
    }
    
    private void insertOrReplace(Context paramContext, ConfigManager.PersistentConfig paramPersistentConfig, ArrayList<EndPoint> paramArrayList, boolean paramBoolean)
    {
      paramContext = getCurrentKey(paramContext).iterator();
      while (paramContext.hasNext())
      {
        String str = (String)paramContext.next();
        ConfigManager.log("IpContainer.insert() key= " + str + "   value= " + ((EndPoint)paramArrayList.get(0)).toString());
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          EndPoint localEndPoint1 = (EndPoint)localIterator.next();
          EndPoint localEndPoint2 = new EndPoint(localEndPoint1.host, localEndPoint1.port, localEndPoint1.type);
          localEndPoint2.ipIndex = i;
          localEndPoint2.keyOfAPN = str;
          localEndPoint2.isSameIsp = localEndPoint1.isSameIsp;
          localArrayList.add(localEndPoint2);
          i += 1;
        }
        if (paramBoolean)
        {
          localArrayList = ConfigManager.this.getOrCreateIpLearnerByKey(str).adjustNewIpList(localArrayList);
          paramPersistentConfig.mIpList.put(str, localArrayList);
        }
        else
        {
          paramPersistentConfig.mIpList.put(str, localArrayList);
        }
      }
    }
    
    /* Error */
    private ConfigManager.PersistentConfig loadFromDisk(Context paramContext, String paramString)
    {
      // Byte code:
      //   0: new 214	java/io/File
      //   3: dup
      //   4: aload_1
      //   5: invokevirtual 220	android/content/Context:getFilesDir	()Ljava/io/File;
      //   8: invokevirtual 223	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   11: aload_2
      //   12: invokespecial 226	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   15: invokevirtual 229	java/io/File:exists	()Z
      //   18: ifne +29 -> 47
      //   21: new 97	java/lang/StringBuilder
      //   24: dup
      //   25: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   28: ldc 231
      //   30: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   33: aload_2
      //   34: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   43: aconst_null
      //   44: astore_1
      //   45: aload_1
      //   46: areturn
      //   47: aconst_null
      //   48: astore 10
      //   50: aconst_null
      //   51: astore 9
      //   53: new 233	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB
      //   56: dup
      //   57: invokespecial 234	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:<init>	()V
      //   60: astore 13
      //   62: aconst_null
      //   63: astore 6
      //   65: aconst_null
      //   66: astore 7
      //   68: aconst_null
      //   69: astore 4
      //   71: aconst_null
      //   72: astore 11
      //   74: aconst_null
      //   75: astore 12
      //   77: aconst_null
      //   78: astore 8
      //   80: aload 12
      //   82: astore 5
      //   84: aload_1
      //   85: aload_2
      //   86: invokevirtual 238	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
      //   89: astore_1
      //   90: aload 12
      //   92: astore 5
      //   94: aload_1
      //   95: astore 4
      //   97: aload_1
      //   98: astore 6
      //   100: aload_1
      //   101: astore 7
      //   103: new 240	java/io/ByteArrayOutputStream
      //   106: dup
      //   107: invokespecial 241	java/io/ByteArrayOutputStream:<init>	()V
      //   110: astore_2
      //   111: sipush 1024
      //   114: newarray byte
      //   116: astore 4
      //   118: aload_1
      //   119: aload 4
      //   121: iconst_0
      //   122: aload 4
      //   124: arraylength
      //   125: invokevirtual 247	java/io/FileInputStream:read	([BII)I
      //   128: istore_3
      //   129: iload_3
      //   130: iconst_m1
      //   131: if_icmpeq +73 -> 204
      //   134: aload_2
      //   135: aload 4
      //   137: iconst_0
      //   138: iload_3
      //   139: invokevirtual 251	java/io/ByteArrayOutputStream:write	([BII)V
      //   142: goto -24 -> 118
      //   145: astore 8
      //   147: aload 9
      //   149: astore 6
      //   151: aload_2
      //   152: astore 5
      //   154: aload_1
      //   155: astore 4
      //   157: aload 8
      //   159: invokevirtual 254	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
      //   162: aload_2
      //   163: astore 5
      //   165: aload_1
      //   166: astore 4
      //   168: ldc_w 256
      //   171: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   174: aload_1
      //   175: ifnull +7 -> 182
      //   178: aload_1
      //   179: invokevirtual 259	java/io/FileInputStream:close	()V
      //   182: aload 6
      //   184: astore_1
      //   185: aload_2
      //   186: ifnull -141 -> 45
      //   189: aload_2
      //   190: invokevirtual 260	java/io/ByteArrayOutputStream:close	()V
      //   193: aload 6
      //   195: areturn
      //   196: astore_1
      //   197: aload_1
      //   198: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   201: aload 6
      //   203: areturn
      //   204: aload_2
      //   205: invokevirtual 264	java/io/ByteArrayOutputStream:flush	()V
      //   208: aload 13
      //   210: aload_2
      //   211: invokevirtual 268	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   214: invokevirtual 272	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
      //   217: pop
      //   218: new 85	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig
      //   221: dup
      //   222: aload_0
      //   223: getfield 32	com/tencent/mobileqq/highway/config/ConfigManager$IpContainer:this$0	Lcom/tencent/mobileqq/highway/config/ConfigManager;
      //   226: aconst_null
      //   227: invokespecial 275	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:<init>	(Lcom/tencent/mobileqq/highway/config/ConfigManager;Lcom/tencent/mobileqq/highway/config/ConfigManager$1;)V
      //   230: astore 4
      //   232: aload 4
      //   234: new 91	java/util/concurrent/ConcurrentHashMap
      //   237: dup
      //   238: invokespecial 276	java/util/concurrent/ConcurrentHashMap:<init>	()V
      //   241: putfield 89	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
      //   244: aload 4
      //   246: new 67	java/util/ArrayList
      //   249: dup
      //   250: invokespecial 150	java/util/ArrayList:<init>	()V
      //   253: putfield 279	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mSegConf	Ljava/util/ArrayList;
      //   256: aload 4
      //   258: new 67	java/util/ArrayList
      //   261: dup
      //   262: invokespecial 150	java/util/ArrayList:<init>	()V
      //   265: putfield 282	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mShortVideoSegConf	Ljava/util/ArrayList;
      //   268: aload 13
      //   270: getfield 286	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   273: invokevirtual 291	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   276: invokeinterface 294 1 0
      //   281: astore 5
      //   283: aload 5
      //   285: invokeinterface 77 1 0
      //   290: ifeq +191 -> 481
      //   293: aload 5
      //   295: invokeinterface 81 1 0
      //   300: checkcast 296	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
      //   303: astore 7
      //   305: aload 7
      //   307: getfield 300	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
      //   310: invokevirtual 304	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
      //   313: astore 6
      //   315: aload 7
      //   317: getfield 307	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   320: invokevirtual 291	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   323: checkcast 67	java/util/ArrayList
      //   326: astore 8
      //   328: new 67	java/util/ArrayList
      //   331: dup
      //   332: invokespecial 150	java/util/ArrayList:<init>	()V
      //   335: astore 7
      //   337: aload 8
      //   339: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   342: astore 8
      //   344: aload 8
      //   346: invokeinterface 77 1 0
      //   351: ifeq +55 -> 406
      //   354: aload 8
      //   356: invokeinterface 81 1 0
      //   361: checkcast 309	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
      //   364: astore 9
      //   366: aload 7
      //   368: new 111	com/tencent/mobileqq/highway/utils/EndPoint
      //   371: dup
      //   372: aload 9
      //   374: getfield 312	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
      //   377: invokevirtual 304	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
      //   380: aload 9
      //   382: getfield 316	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
      //   385: invokevirtual 320	com/tencent/mobileqq/pb/PBInt32Field:get	()I
      //   388: aload 9
      //   390: getfield 324	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   393: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   396: invokespecial 332	com/tencent/mobileqq/highway/utils/EndPoint:<init>	(Ljava/lang/String;IJ)V
      //   399: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   402: pop
      //   403: goto -59 -> 344
      //   406: aload 4
      //   408: getfield 89	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
      //   411: aload 6
      //   413: aload 7
      //   415: invokevirtual 206	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   418: pop
      //   419: goto -136 -> 283
      //   422: astore 8
      //   424: aload 4
      //   426: astore 7
      //   428: aload_2
      //   429: astore 5
      //   431: aload_1
      //   432: astore 4
      //   434: aload 8
      //   436: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   439: aload_2
      //   440: astore 5
      //   442: aload_1
      //   443: astore 4
      //   445: ldc_w 334
      //   448: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   451: aload_1
      //   452: ifnull +7 -> 459
      //   455: aload_1
      //   456: invokevirtual 259	java/io/FileInputStream:close	()V
      //   459: aload 7
      //   461: astore_1
      //   462: aload_2
      //   463: ifnull -418 -> 45
      //   466: aload_2
      //   467: invokevirtual 260	java/io/ByteArrayOutputStream:close	()V
      //   470: aload 7
      //   472: areturn
      //   473: astore_1
      //   474: aload_1
      //   475: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   478: aload 7
      //   480: areturn
      //   481: aload 13
      //   483: getfield 337	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_net_seg_conf_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   486: invokevirtual 291	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   489: invokeinterface 294 1 0
      //   494: astore 5
      //   496: aload 5
      //   498: invokeinterface 77 1 0
      //   503: ifeq +98 -> 601
      //   506: aload 5
      //   508: invokeinterface 81 1 0
      //   513: checkcast 339	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
      //   516: astore 6
      //   518: new 341	com/tencent/mobileqq/highway/config/HwNetSegConf
      //   521: dup
      //   522: aload 6
      //   524: getfield 344	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   527: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   530: aload 6
      //   532: getfield 347	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   535: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   538: aload 6
      //   540: getfield 350	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   543: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   546: aload 6
      //   548: getfield 353	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   551: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   554: invokespecial 356	com/tencent/mobileqq/highway/config/HwNetSegConf:<init>	(JJJJ)V
      //   557: astore 6
      //   559: aload 4
      //   561: getfield 279	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mSegConf	Ljava/util/ArrayList;
      //   564: aload 6
      //   566: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   569: pop
      //   570: goto -74 -> 496
      //   573: astore 4
      //   575: aload_2
      //   576: astore 5
      //   578: aload 4
      //   580: astore_2
      //   581: aload_1
      //   582: ifnull +7 -> 589
      //   585: aload_1
      //   586: invokevirtual 259	java/io/FileInputStream:close	()V
      //   589: aload 5
      //   591: ifnull +8 -> 599
      //   594: aload 5
      //   596: invokevirtual 260	java/io/ByteArrayOutputStream:close	()V
      //   599: aload_2
      //   600: athrow
      //   601: aload 13
      //   603: getfield 359	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_short_video_net_conf	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   606: invokevirtual 291	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   609: invokeinterface 294 1 0
      //   614: astore 5
      //   616: aload 5
      //   618: invokeinterface 77 1 0
      //   623: ifeq +70 -> 693
      //   626: aload 5
      //   628: invokeinterface 81 1 0
      //   633: checkcast 339	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
      //   636: astore 6
      //   638: new 341	com/tencent/mobileqq/highway/config/HwNetSegConf
      //   641: dup
      //   642: aload 6
      //   644: getfield 344	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   647: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   650: aload 6
      //   652: getfield 347	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   655: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   658: aload 6
      //   660: getfield 350	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   663: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   666: aload 6
      //   668: getfield 353	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   671: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   674: invokespecial 356	com/tencent/mobileqq/highway/config/HwNetSegConf:<init>	(JJJJ)V
      //   677: astore 6
      //   679: aload 4
      //   681: getfield 282	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mShortVideoSegConf	Ljava/util/ArrayList;
      //   684: aload 6
      //   686: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   689: pop
      //   690: goto -74 -> 616
      //   693: aload_1
      //   694: ifnull +7 -> 701
      //   697: aload_1
      //   698: invokevirtual 259	java/io/FileInputStream:close	()V
      //   701: aload_2
      //   702: ifnull +117 -> 819
      //   705: aload_2
      //   706: invokevirtual 260	java/io/ByteArrayOutputStream:close	()V
      //   709: aload 4
      //   711: areturn
      //   712: astore_1
      //   713: aload_1
      //   714: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   717: goto -16 -> 701
      //   720: astore_1
      //   721: aload_1
      //   722: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   725: aload 4
      //   727: areturn
      //   728: astore_1
      //   729: aload_1
      //   730: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   733: goto -551 -> 182
      //   736: astore_1
      //   737: aload_1
      //   738: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   741: goto -282 -> 459
      //   744: astore_1
      //   745: aload_1
      //   746: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   749: goto -160 -> 589
      //   752: astore_1
      //   753: aload_1
      //   754: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   757: goto -158 -> 599
      //   760: astore_2
      //   761: aload 4
      //   763: astore_1
      //   764: goto -183 -> 581
      //   767: astore 4
      //   769: aload_2
      //   770: astore 5
      //   772: aload 4
      //   774: astore_2
      //   775: goto -194 -> 581
      //   778: astore 8
      //   780: aload 11
      //   782: astore_2
      //   783: aload 10
      //   785: astore 7
      //   787: aload 6
      //   789: astore_1
      //   790: goto -362 -> 428
      //   793: astore 8
      //   795: aload 10
      //   797: astore 7
      //   799: goto -371 -> 428
      //   802: astore_1
      //   803: aload 8
      //   805: astore_2
      //   806: aload_1
      //   807: astore 8
      //   809: aload 9
      //   811: astore 6
      //   813: aload 7
      //   815: astore_1
      //   816: goto -665 -> 151
      //   819: aload 4
      //   821: areturn
      //   822: astore 8
      //   824: aload 4
      //   826: astore 6
      //   828: goto -677 -> 151
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	831	0	this	IpContainer
      //   0	831	1	paramContext	Context
      //   0	831	2	paramString	String
      //   128	11	3	i	int
      //   69	491	4	localObject1	Object
      //   573	189	4	localPersistentConfig1	ConfigManager.PersistentConfig
      //   767	58	4	localPersistentConfig2	ConfigManager.PersistentConfig
      //   82	689	5	localObject2	Object
      //   63	764	6	localObject3	Object
      //   66	748	7	localObject4	Object
      //   78	1	8	localObject5	Object
      //   145	13	8	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
      //   326	29	8	localObject6	Object
      //   422	13	8	localIOException1	java.io.IOException
      //   778	1	8	localIOException2	java.io.IOException
      //   793	11	8	localIOException3	java.io.IOException
      //   807	1	8	localContext	Context
      //   822	1	8	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
      //   51	759	9	localHwEndPointPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwEndPointPB
      //   48	748	10	localObject7	Object
      //   72	709	11	localObject8	Object
      //   75	16	12	localObject9	Object
      //   60	542	13	localHwConfigPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwConfigPB
      // Exception table:
      //   from	to	target	type
      //   111	118	145	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   118	129	145	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   134	142	145	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   204	232	145	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   189	193	196	java/io/IOException
      //   232	283	422	java/io/IOException
      //   283	344	422	java/io/IOException
      //   344	403	422	java/io/IOException
      //   406	419	422	java/io/IOException
      //   481	496	422	java/io/IOException
      //   496	570	422	java/io/IOException
      //   601	616	422	java/io/IOException
      //   616	690	422	java/io/IOException
      //   466	470	473	java/io/IOException
      //   232	283	573	finally
      //   283	344	573	finally
      //   344	403	573	finally
      //   406	419	573	finally
      //   481	496	573	finally
      //   496	570	573	finally
      //   601	616	573	finally
      //   616	690	573	finally
      //   697	701	712	java/io/IOException
      //   705	709	720	java/io/IOException
      //   178	182	728	java/io/IOException
      //   455	459	736	java/io/IOException
      //   585	589	744	java/io/IOException
      //   594	599	752	java/io/IOException
      //   84	90	760	finally
      //   103	111	760	finally
      //   157	162	760	finally
      //   168	174	760	finally
      //   434	439	760	finally
      //   445	451	760	finally
      //   111	118	767	finally
      //   118	129	767	finally
      //   134	142	767	finally
      //   204	232	767	finally
      //   84	90	778	java/io/IOException
      //   103	111	778	java/io/IOException
      //   111	118	793	java/io/IOException
      //   118	129	793	java/io/IOException
      //   134	142	793	java/io/IOException
      //   204	232	793	java/io/IOException
      //   84	90	802	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   103	111	802	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   232	283	822	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   283	344	822	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   344	403	822	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   406	419	822	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   481	496	822	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   496	570	822	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   601	616	822	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   616	690	822	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    }
    
    private ConfigManager.PersistentConfig readDiskOrCreateNew(Context paramContext, String paramString)
    {
      paramContext = loadFromDisk(paramContext, paramString);
      if (paramContext == null)
      {
        paramContext = new ConfigManager.PersistentConfig(ConfigManager.this, null);
        paramContext.mIpList = new ConcurrentHashMap();
        paramContext.mSegConf = new ArrayList();
        paramContext.mShortVideoSegConf = new ArrayList();
        ConfigManager.log("IpContainer." + paramString + " does NOT exists.");
        return paramContext;
      }
      ConfigManager.log("IpContainer." + paramString + " does exists.");
      return paramContext;
    }
    
    /* Error */
    private void write2disk(Context paramContext, String paramString, ConfigManager.PersistentConfig paramPersistentConfig)
    {
      // Byte code:
      //   0: new 233	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB
      //   3: dup
      //   4: invokespecial 234	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:<init>	()V
      //   7: astore 6
      //   9: aload_3
      //   10: getfield 89	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
      //   13: invokevirtual 373	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
      //   16: invokeinterface 376 1 0
      //   21: astore 4
      //   23: aload 4
      //   25: invokeinterface 77 1 0
      //   30: ifeq +178 -> 208
      //   33: aload 4
      //   35: invokeinterface 81 1 0
      //   40: checkcast 378	java/util/Map$Entry
      //   43: astore 7
      //   45: aload 7
      //   47: invokeinterface 381 1 0
      //   52: checkcast 83	java/lang/String
      //   55: astore 5
      //   57: aload 7
      //   59: invokeinterface 384 1 0
      //   64: checkcast 67	java/util/ArrayList
      //   67: astore 8
      //   69: new 67	java/util/ArrayList
      //   72: dup
      //   73: invokespecial 150	java/util/ArrayList:<init>	()V
      //   76: astore 7
      //   78: aload 8
      //   80: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   83: astore 8
      //   85: aload 8
      //   87: invokeinterface 77 1 0
      //   92: ifeq +74 -> 166
      //   95: aload 8
      //   97: invokeinterface 81 1 0
      //   102: checkcast 111	com/tencent/mobileqq/highway/utils/EndPoint
      //   105: astore 9
      //   107: new 309	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
      //   110: dup
      //   111: invokespecial 385	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:<init>	()V
      //   114: astore 10
      //   116: aload 10
      //   118: getfield 312	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
      //   121: aload 9
      //   123: getfield 132	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
      //   126: invokevirtual 388	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
      //   129: aload 10
      //   131: getfield 316	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
      //   134: aload 9
      //   136: getfield 177	com/tencent/mobileqq/highway/utils/EndPoint:port	I
      //   139: invokevirtual 391	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
      //   142: aload 10
      //   144: getfield 324	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   147: aload 9
      //   149: getfield 395	com/tencent/mobileqq/highway/utils/EndPoint:timestampe	J
      //   152: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   155: aload 7
      //   157: aload 10
      //   159: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   162: pop
      //   163: goto -78 -> 85
      //   166: new 296	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
      //   169: dup
      //   170: invokespecial 399	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:<init>	()V
      //   173: astore 8
      //   175: aload 8
      //   177: getfield 300	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
      //   180: aload 5
      //   182: invokevirtual 388	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
      //   185: aload 8
      //   187: getfield 307	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   190: aload 7
      //   192: invokevirtual 402	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
      //   195: aload 6
      //   197: getfield 286	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   200: aload 8
      //   202: invokevirtual 405	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
      //   205: goto -182 -> 23
      //   208: new 67	java/util/ArrayList
      //   211: dup
      //   212: invokespecial 150	java/util/ArrayList:<init>	()V
      //   215: astore 4
      //   217: aload_3
      //   218: getfield 279	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mSegConf	Ljava/util/ArrayList;
      //   221: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   224: astore 5
      //   226: aload 5
      //   228: invokeinterface 77 1 0
      //   233: ifeq +87 -> 320
      //   236: aload 5
      //   238: invokeinterface 81 1 0
      //   243: checkcast 341	com/tencent/mobileqq/highway/config/HwNetSegConf
      //   246: astore 7
      //   248: new 339	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
      //   251: dup
      //   252: invokespecial 406	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:<init>	()V
      //   255: astore 8
      //   257: aload 8
      //   259: getfield 344	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   262: aload 7
      //   264: getfield 409	com/tencent/mobileqq/highway/config/HwNetSegConf:netType	J
      //   267: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   270: aload 8
      //   272: getfield 347	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   275: aload 7
      //   277: getfield 412	com/tencent/mobileqq/highway/config/HwNetSegConf:segSize	J
      //   280: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   283: aload 8
      //   285: getfield 350	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   288: aload 7
      //   290: getfield 415	com/tencent/mobileqq/highway/config/HwNetSegConf:segNum	J
      //   293: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   296: aload 8
      //   298: getfield 353	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   301: aload 7
      //   303: getfield 418	com/tencent/mobileqq/highway/config/HwNetSegConf:curConnNum	J
      //   306: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   309: aload 4
      //   311: aload 8
      //   313: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   316: pop
      //   317: goto -91 -> 226
      //   320: aload 6
      //   322: getfield 337	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_net_seg_conf_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   325: aload 4
      //   327: invokevirtual 402	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
      //   330: new 67	java/util/ArrayList
      //   333: dup
      //   334: invokespecial 150	java/util/ArrayList:<init>	()V
      //   337: astore 4
      //   339: aload_3
      //   340: getfield 279	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mSegConf	Ljava/util/ArrayList;
      //   343: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   346: astore_3
      //   347: aload_3
      //   348: invokeinterface 77 1 0
      //   353: ifeq +86 -> 439
      //   356: aload_3
      //   357: invokeinterface 81 1 0
      //   362: checkcast 341	com/tencent/mobileqq/highway/config/HwNetSegConf
      //   365: astore 5
      //   367: new 339	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
      //   370: dup
      //   371: invokespecial 406	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:<init>	()V
      //   374: astore 7
      //   376: aload 7
      //   378: getfield 344	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   381: aload 5
      //   383: getfield 409	com/tencent/mobileqq/highway/config/HwNetSegConf:netType	J
      //   386: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   389: aload 7
      //   391: getfield 347	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   394: aload 5
      //   396: getfield 412	com/tencent/mobileqq/highway/config/HwNetSegConf:segSize	J
      //   399: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   402: aload 7
      //   404: getfield 350	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   407: aload 5
      //   409: getfield 415	com/tencent/mobileqq/highway/config/HwNetSegConf:segNum	J
      //   412: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   415: aload 7
      //   417: getfield 353	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   420: aload 5
      //   422: getfield 418	com/tencent/mobileqq/highway/config/HwNetSegConf:curConnNum	J
      //   425: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   428: aload 4
      //   430: aload 7
      //   432: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   435: pop
      //   436: goto -89 -> 347
      //   439: aload 6
      //   441: getfield 359	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_short_video_net_conf	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   444: aload 4
      //   446: invokevirtual 402	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
      //   449: new 214	java/io/File
      //   452: dup
      //   453: aload_1
      //   454: invokevirtual 220	android/content/Context:getFilesDir	()Ljava/io/File;
      //   457: invokevirtual 223	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   460: aload_2
      //   461: invokespecial 226	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   464: astore_3
      //   465: aconst_null
      //   466: astore 5
      //   468: aconst_null
      //   469: astore_1
      //   470: aconst_null
      //   471: astore 4
      //   473: new 420	java/io/FileOutputStream
      //   476: dup
      //   477: aload_3
      //   478: invokespecial 423	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   481: astore_3
      //   482: aload_3
      //   483: aload 6
      //   485: invokevirtual 424	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:toByteArray	()[B
      //   488: invokevirtual 427	java/io/FileOutputStream:write	([B)V
      //   491: new 97	java/lang/StringBuilder
      //   494: dup
      //   495: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   498: ldc_w 429
      //   501: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   504: aload_2
      //   505: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   508: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   511: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   514: aload_3
      //   515: ifnull +139 -> 654
      //   518: aload_3
      //   519: invokevirtual 430	java/io/FileOutputStream:close	()V
      //   522: return
      //   523: astore_1
      //   524: aload_1
      //   525: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   528: return
      //   529: astore_1
      //   530: aload 4
      //   532: astore_3
      //   533: aload_1
      //   534: astore 4
      //   536: aload_3
      //   537: astore_1
      //   538: aload 4
      //   540: invokevirtual 431	java/io/FileNotFoundException:printStackTrace	()V
      //   543: aload_3
      //   544: astore_1
      //   545: new 97	java/lang/StringBuilder
      //   548: dup
      //   549: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   552: ldc_w 433
      //   555: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   558: aload_2
      //   559: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   562: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   565: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   568: aload_3
      //   569: ifnull -47 -> 522
      //   572: aload_3
      //   573: invokevirtual 430	java/io/FileOutputStream:close	()V
      //   576: return
      //   577: astore_1
      //   578: aload_1
      //   579: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   582: return
      //   583: astore_3
      //   584: aload 5
      //   586: astore_2
      //   587: aload_2
      //   588: astore_1
      //   589: aload_3
      //   590: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   593: aload_2
      //   594: astore_1
      //   595: ldc_w 435
      //   598: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   601: aload_2
      //   602: ifnull -80 -> 522
      //   605: aload_2
      //   606: invokevirtual 430	java/io/FileOutputStream:close	()V
      //   609: return
      //   610: astore_1
      //   611: aload_1
      //   612: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   615: return
      //   616: astore_2
      //   617: aload_1
      //   618: ifnull +7 -> 625
      //   621: aload_1
      //   622: invokevirtual 430	java/io/FileOutputStream:close	()V
      //   625: aload_2
      //   626: athrow
      //   627: astore_1
      //   628: aload_1
      //   629: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   632: goto -7 -> 625
      //   635: astore_2
      //   636: aload_3
      //   637: astore_1
      //   638: goto -21 -> 617
      //   641: astore_1
      //   642: aload_3
      //   643: astore_2
      //   644: aload_1
      //   645: astore_3
      //   646: goto -59 -> 587
      //   649: astore 4
      //   651: goto -115 -> 536
      //   654: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	655	0	this	IpContainer
      //   0	655	1	paramContext	Context
      //   0	655	2	paramString	String
      //   0	655	3	paramPersistentConfig	ConfigManager.PersistentConfig
      //   21	518	4	localObject1	Object
      //   649	1	4	localFileNotFoundException	java.io.FileNotFoundException
      //   55	530	5	localObject2	Object
      //   7	477	6	localHwConfigPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwConfigPB
      //   43	388	7	localObject3	Object
      //   67	245	8	localObject4	Object
      //   105	43	9	localEndPoint	EndPoint
      //   114	44	10	localHwEndPointPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwEndPointPB
      // Exception table:
      //   from	to	target	type
      //   518	522	523	java/io/IOException
      //   473	482	529	java/io/FileNotFoundException
      //   572	576	577	java/io/IOException
      //   473	482	583	java/io/IOException
      //   605	609	610	java/io/IOException
      //   473	482	616	finally
      //   538	543	616	finally
      //   545	568	616	finally
      //   589	593	616	finally
      //   595	601	616	finally
      //   621	625	627	java/io/IOException
      //   482	514	635	finally
      //   482	514	641	java/io/IOException
      //   482	514	649	java/io/FileNotFoundException
    }
    
    public boolean addNew(Context paramContext, HwConfig paramHwConfig, AppRuntime paramAppRuntime)
    {
      try
      {
        ConfigManager.log("IpContainer.addNew() " + paramHwConfig.ipList2String());
        long l = SystemClock.uptimeMillis();
        localObject = paramHwConfig.ipList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((EndPoint)((Iterator)localObject).next()).timestampe = l;
        }
        bool2 = false;
      }
      finally {}
      Object localObject = readDiskOrCreateNew(paramContext, this.mFileName);
      boolean bool1 = bool2;
      if (paramHwConfig != null)
      {
        bool1 = bool2;
        if (paramHwConfig.ipList != null)
        {
          bool1 = bool2;
          if (!paramHwConfig.ipList.isEmpty())
          {
            bool1 = true;
            insertOrReplace(paramContext, (ConfigManager.PersistentConfig)localObject, paramHwConfig.ipList, false);
            insertOrReplace(paramContext, this.mCfg, paramHwConfig.ipList, true);
            addProxyIp(paramAppRuntime, false);
          }
        }
      }
      boolean bool2 = bool1;
      if (paramHwConfig != null)
      {
        bool2 = bool1;
        if (paramHwConfig.netSegConfList != null)
        {
          bool2 = bool1;
          if (!paramHwConfig.netSegConfList.isEmpty())
          {
            bool2 = true;
            ((ConfigManager.PersistentConfig)localObject).mSegConf = paramHwConfig.netSegConfList;
            ((ConfigManager.PersistentConfig)localObject).mShortVideoSegConf = paramHwConfig.shortVideoSegConfList;
            this.mCfg.mSegConf = paramHwConfig.netSegConfList;
            this.mCfg.mShortVideoSegConf = paramHwConfig.shortVideoSegConfList;
          }
        }
      }
      if (bool2) {
        write2disk(paramContext, this.mFileName, (ConfigManager.PersistentConfig)localObject);
      }
      return bool2;
    }
    
    public void addProxyIp(AppRuntime paramAppRuntime, boolean paramBoolean)
    {
      Object localObject1 = ((ProxyIpManager)paramAppRuntime.getManager(3)).getProxyIp(1);
      if ((localObject1 == null) || (((List)localObject1).isEmpty()))
      {
        if (paramBoolean) {
          deleteProxyIp();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PROXY_IP", 2, "[TCP] Proxy IP List is empty!");
        }
      }
      do
      {
        return;
        deleteProxyIp();
        paramAppRuntime = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ProxyIpManager.ProxyIp)((Iterator)localObject1).next();
          paramAppRuntime.add(new EndPoint(((ProxyIpManager.ProxyIp)localObject2).ip, ((ProxyIpManager.ProxyIp)localObject2).port, 1));
        }
        int i = 0;
        localObject1 = this.mCfg.mIpList.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (((String)localObject2).startsWith("APN_"))
          {
            i = 1;
            ((ArrayList)this.mCfg.mIpList.get(localObject2)).addAll(0, paramAppRuntime);
          }
        }
        if (i == 0)
        {
          localObject1 = getCurrentKey(BaseApplication.getContext()).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (((String)localObject2).startsWith("APN_")) {
              this.mCfg.mIpList.put(localObject2, paramAppRuntime);
            }
          }
        }
        ConfigManager.access$602(ConfigManager.this, 3);
      } while (!QLog.isColorLevel());
      QLog.d("PROXY_IP", 2, "[TCP] add " + paramAppRuntime.size() + " proxy ip to List success!");
    }
    
    public void deleteProxyIp()
    {
      if (QLog.isColorLevel()) {
        QLog.d("PROXY_IP", 2, "[TCP] clear proxy ip !");
      }
      Iterator localIterator1 = this.mCfg.mIpList.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Object localObject = (String)localIterator1.next();
        if (((String)localObject).startsWith("APN_"))
        {
          localObject = (ArrayList)this.mCfg.mIpList.get(localObject);
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = ((ArrayList)localObject).iterator();
          while (localIterator2.hasNext())
          {
            EndPoint localEndPoint = (EndPoint)localIterator2.next();
            if (localEndPoint.isPorxyIp()) {
              localArrayList.add(localEndPoint);
            }
          }
          ((ArrayList)localObject).removeAll(localArrayList);
        }
      }
    }
    
    public boolean fail(String paramString)
    {
      for (;;)
      {
        Object localObject;
        boolean bool1;
        try
        {
          if ((this.mCfg == null) || (this.mCfg.mIpList == null) || (this.mCfg.mIpList.isEmpty()))
          {
            ConfigManager.log("IpContainer.fail() found due to mCfg == null || mCfg.mIpList == null || mCfg.mIpList.isEmpty()");
            bool2 = false;
            return bool2;
          }
          localObject = new ArrayList();
          bool1 = false;
          Iterator localIterator = this.mCfg.mIpList.keySet().iterator();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ArrayList localArrayList = (ArrayList)this.mCfg.mIpList.get(str);
            bool2 = bool1;
            if (findNRemove(localArrayList, paramString))
            {
              bool2 = true;
              ConfigManager.log("IpContainer.fail() remove ip " + paramString + " in " + str + " which has " + (localArrayList.size() + 1) + " IPs");
            }
            bool1 = bool2;
            if (!localArrayList.isEmpty()) {
              continue;
            }
            ((ArrayList)localObject).add(str);
            bool1 = bool2;
            continue;
          }
          paramString = ((ArrayList)localObject).iterator();
        }
        finally {}
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          ConfigManager.log("IpContainer.fail() " + (String)localObject + " is empty, remove it");
          this.mCfg.mIpList.remove(localObject);
        }
        boolean bool2 = bool1;
        if (!bool1)
        {
          ConfigManager.log("IpContainer.fail() found NONE");
          bool2 = bool1;
        }
      }
    }
    
    public EndPoint get(Context paramContext)
    {
      for (;;)
      {
        Object localObject;
        try
        {
          if (isEmpty(paramContext))
          {
            ConfigManager.log("IpContainer.get() FAIL to find IP, due to IP List is EMPTY.");
            paramContext = null;
            return paramContext;
          }
          localObject = find(paramContext);
          if (((Result)localObject).found)
          {
            paramContext = (EndPoint)((Result)localObject).epList.get(0);
            ConfigManager.log("IpContainer.get() found IP= " + paramContext.toString() + " with key= " + (String)((Result)localObject).keyList.get(0));
            continue;
          }
          l = -1L;
        }
        finally {}
        long l;
        paramContext = null;
        Iterator localIterator = this.mCfg.mIpList.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (ArrayList)((Map.Entry)localIterator.next()).getValue();
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            localObject = (EndPoint)((ArrayList)localObject).get(0);
            if ((localObject != null) && (((EndPoint)localObject).timestampe > l))
            {
              l = ((EndPoint)localObject).timestampe;
              paramContext = (Context)localObject;
            }
          }
        }
        if (paramContext == null)
        {
          ConfigManager.log("IpContainer.get() FAIL to find IP from RECENT added record.");
          paramContext = null;
        }
        else
        {
          ConfigManager.log("IpContainer.get() found IP from RECENT added record, ip=" + paramContext.toString());
        }
      }
    }
    
    public ArrayList<HwNetSegConf> getNetSegConf(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return this.mCfg.mSegConf;
      case 0: 
        return this.mCfg.mSegConf;
      }
      return this.mCfg.mShortVideoSegConf;
    }
    
    public ArrayList<HwNetSegConf> getNetSegConf(Context paramContext)
    {
      return getNetSegConf(0);
    }
    
    public boolean isEmpty(Context paramContext)
    {
      if ((this.mCfg == null) || (this.mCfg.mIpList == null)) {
        return true;
      }
      return this.mCfg.mIpList.isEmpty();
    }
    
    public void onConnFailed(EndPoint paramEndPoint)
    {
      if ((paramEndPoint == null) || ("".equalsIgnoreCase(paramEndPoint.keyOfAPN))) {
        return;
      }
      ConfigManager.this.getOrCreateIpLearnerByKey(paramEndPoint.keyOfAPN).onIpConnFail(paramEndPoint.host, paramEndPoint.port);
    }
    
    public void onConnSuccess(EndPoint paramEndPoint)
    {
      if ((paramEndPoint == null) || ("".equalsIgnoreCase(paramEndPoint.keyOfAPN))) {
        return;
      }
      ConfigManager.this.getOrCreateIpLearnerByKey(paramEndPoint.keyOfAPN).onIpConnSucc(paramEndPoint.host, paramEndPoint.port, paramEndPoint.isSameIsp);
    }
    
    private class Result
    {
      public ArrayList<EndPoint> epList;
      public boolean found;
      public ArrayList<String> keyList;
      
      private Result() {}
    }
  }
  
  private class PersistentConfig
  {
    public ConcurrentHashMap<String, ArrayList<EndPoint>> mIpList;
    public ArrayList<HwNetSegConf> mSegConf;
    public ArrayList<HwNetSegConf> mShortVideoSegConf;
    
    private PersistentConfig() {}
  }
  
  private static abstract interface SrvAddrStatus
  {
    public static final int ERROR = 7;
    public static final int HC_DOMAIN = 5;
    public static final int HC_IP = 6;
    public static final int INIT = 2;
    public static final int NONE = 0;
    public static final int PRE = 1;
    public static final int PUSH_IP = 3;
    public static final int PUSH_SSOGET = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.ConfigManager
 * JD-Core Version:    0.7.0.1
 */