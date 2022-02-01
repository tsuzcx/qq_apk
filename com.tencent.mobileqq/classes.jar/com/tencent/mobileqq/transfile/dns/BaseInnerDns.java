package com.tencent.mobileqq.transfile.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.servlet.IPDomainGetServlet;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.ipv6.IpStrategy;
import com.tencent.mobileqq.transfile.ipv6.IpStrategyFactory;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.mobileqq.configpush.DomainIp.NameRspBody;
import tencent.im.mobileqq.configpush.DomainIp.ServerList;
import tencent.im.mobileqq.configpush.DomainIp.SubCmd_name_Rsp;
import tencent.im.mobileqq.configpush.DomainIp.iplistInfo;

public class BaseInnerDns
  extends QIPCModule
{
  private static final String ACTION_REPORT_BAD_IP = "reportBadIp";
  private static final String ACTION_REQ_DOMAIN_TO_IP_LIST = "reqDomain2IpList";
  private static final String ACTION_REQ_SYNC_DATA = "syncAddressData";
  private static final String ADDRESS_DATA = "addressData";
  private static final String BROADCAST_ACTION_DOMAIN_ADDRESS_DATA_UPDATE = "com.tencent.innerdns.domainAddressDataUpdateAction";
  private static final String BUSINESS_TYPE = "businessType";
  private static final String DOMAIN = "domain";
  public static final String DOMAIN_ARRAY = "domain_map";
  private static final int INPUT_INVALID = 40;
  private static final String IP = "ip";
  private static final int IPC_EXCEPTION = 20;
  private static final int IP_LIST_INVALID = 30;
  private static final String IP_TYPE = "ipType";
  public static final int MAX_IP_DATA_SIZE = 3;
  public static final String NAME = "InnerDnsModule";
  public static final String NET_IDENTIFIER = "net_identifier";
  private static final int NO_DOMAIN_FOUND = 50;
  private static final int NO_NET_FOUND = 60;
  public static final int OLD_HTTP_ENGINE = 1002;
  private static final int OTHER_PROCESS_BIND = 10;
  private static final int RESULT_OK = 0;
  public static final String SP_DOMAIN = "sp_domain";
  public static final String SP_INNER_DNS = "sp_inner_dns";
  public static final String TAG = "InnerDns";
  public static volatile BaseInnerDns mInstance;
  private boolean mConnected = false;
  private BroadcastReceiver mIPCBroadcastReceiver = new BaseInnerDns.3(this);
  private volatile boolean mIsRequestingIPDomaining;
  private final boolean mMainProcess;
  private HashMap<String, HashMap<String, DomainData>> mNetMap;
  private Random mRandom = new Random();
  private String mServerProcName;
  
  BaseInnerDns()
  {
    super("InnerDnsModule");
    int i = MobileQQ.sProcessId;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.mMainProcess = bool;
    if (this.mMainProcess)
    {
      localObject = unParse(getMobileQQ().getSharedPreferences("sp_inner_dns", 0).getString("sp_domain", null));
      if (localObject != null)
      {
        this.mNetMap = new HashMap((Map)localObject);
        return;
      }
      this.mNetMap = new HashMap();
      return;
    }
    QIPCClientHelper.getInstance().getClient().connect(new BaseInnerDns.1(this));
    QIPCClientHelper.getInstance().getClient().addListener(new BaseInnerDns.2(this));
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.innerdns.domainAddressDataUpdateAction");
    try
    {
      getMobileQQ().registerReceiver(this.mIPCBroadcastReceiver, (IntentFilter)localObject, "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void addIpToDomainData(String paramString, int paramInt, List<DomainIp.ServerList> paramList, DomainData paramDomainData)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DomainIp.ServerList)paramList.next();
      IpData localIpData = new IpData();
      localIpData.mIp = ((DomainIp.ServerList)localObject).string_IP.get();
      localIpData.mPort = ((DomainIp.ServerList)localObject).uint32_Port.get();
      localIpData.mType = paramInt;
      paramDomainData.mIpList.add(localIpData);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDomainServerListUpdate type=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" d:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(localIpData.mIp);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(localIpData.mPort);
        QLog.d("InnerDns", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @NotNull
  private static DomainData getDomainData(HashMap<String, DomainData> paramHashMap, String paramString)
  {
    if ((paramHashMap.containsKey(paramString)) && (paramHashMap.get(paramString) != null))
    {
      paramString = (DomainData)paramHashMap.get(paramString);
      paramHashMap = paramString;
      if (paramString.mIpList == null)
      {
        paramString.mIpList = new ArrayList();
        return paramString;
      }
    }
    else
    {
      paramHashMap = new DomainData(paramString, new ArrayList());
    }
    return paramHashMap;
  }
  
  public static String getHostFromUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static BaseInnerDns getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new BaseInnerDns();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  private ArrayList<IpData> getIpDataListIPC(String paramString, int paramInt, boolean paramBoolean)
  {
    int i;
    if ((this.mConnected) && (paramBoolean))
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("domain", paramString);
      ((Bundle)localObject).putInt("businessType", paramInt);
      localObject = QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reqDomain2IpList", (Bundle)localObject);
      if (((EIPCResult)localObject).isSuccess()) {
        return ((EIPCResult)localObject).data.getParcelableArrayList("ip");
      }
      i = 20;
    }
    else
    {
      i = 10;
    }
    reportInnerDns(paramString, paramInt, i, false);
    return null;
  }
  
  private ArrayList<IpData> getIpDataListLocal(String paramString, int paramInt)
  {
    Object localObject = getNetIdentifier();
    for (;;)
    {
      try
      {
        if (this.mNetMap.containsKey(localObject))
        {
          localObject = (HashMap)this.mNetMap.get(localObject);
          if (!((HashMap)localObject).containsKey(paramString)) {
            break label113;
          }
          localObject = sortIp(((DomainData)((HashMap)localObject).get(paramString)).mIpList);
          if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
            return localObject;
          }
        }
        else
        {
          getIPDomain();
          i = 60;
          reportInnerDns(paramString, paramInt, i, false);
          return null;
        }
      }
      finally {}
      int i = 30;
      continue;
      label113:
      i = 50;
    }
  }
  
  private MobileQQ getMobileQQ()
  {
    return MobileQQ.sMobileQQ;
  }
  
  private String getNetIdentifier()
  {
    Context localContext = getRuntime().getApplicationContext();
    String str2 = String.valueOf(NetworkUtil.getSystemNetwork(localContext));
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.equals(String.valueOf(1))) {
        str1 = DeviceInfoUtil.b(localContext);
      }
    }
    return str1;
  }
  
  public static int getPortFromUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      int i = new URL(paramString).getPort();
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private AppRuntime getRuntime()
  {
    return getMobileQQ().peekAppRuntime();
  }
  
  public static String parse(HashMap<String, HashMap<String, DomainData>> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      JSONArray localJSONArray = new JSONArray();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (HashMap)((Map.Entry)localObject).getValue();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("net_identifier", str);
        localJSONObject.put("domain_map", DomainData.parse((HashMap)localObject));
        localJSONArray.put(localJSONObject);
      }
      paramHashMap = localJSONArray.toString();
      return paramHashMap;
    }
    catch (Throwable paramHashMap)
    {
      paramHashMap.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "parse failed");
      }
    }
    return null;
  }
  
  public static BaseInnerDns queryInstance()
  {
    return mInstance;
  }
  
  public static String replaceDomainWithIp(String paramString, int paramInt)
  {
    String str = getHostFromUrl(paramString);
    return replaceDomainWithIp(paramString, getInstance().reqDns(str, paramInt));
  }
  
  public static String replaceDomainWithIp(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject1 = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        Object localObject2 = null;
        localObject1 = paramString1;
        if (paramString1 != null)
        {
          if (paramString1.startsWith("http://"))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("http://");
            ((StringBuilder)localObject1).append(paramString2);
            ((StringBuilder)localObject1).append("/");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = localObject2;
            if (paramString1.startsWith("https://"))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("https://");
              ((StringBuilder)localObject1).append(paramString2);
              ((StringBuilder)localObject1).append("/");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
          localObject1 = TransFileUtil.replaceIp(paramString1, (String)localObject1);
        }
      }
    }
    return localObject1;
  }
  
  private void reportInnerDns(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt2));
    localHashMap.put("domain", paramString);
    localHashMap.put("businessType", String.valueOf(paramInt1));
    StatisticCollector.getInstance(getMobileQQ().getApplicationContext()).collectPerformance(null, "actDnsReq", paramBoolean, MobileQQ.sProcessId, 0L, localHashMap, "");
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("reqDnsForIpList succeeded:");
      paramString.append(paramBoolean);
      paramString.append(" error=");
      paramString.append(paramInt2);
      QLog.d("InnerDns", 2, paramString.toString());
    }
  }
  
  private ArrayList<IpData> sortIp(ArrayList<IpData> paramArrayList)
  {
    if (paramArrayList != null) {
      try
      {
        if (paramArrayList.size() != 0)
        {
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext()) {
            if (((IpData)localIterator.next()).mFailedCount > 0) {
              localIterator.remove();
            }
          }
          if ((paramArrayList.size() > 1) && (this.mRandom.nextInt() % 10 == 0)) {
            Collections.shuffle(paramArrayList);
          }
          return paramArrayList;
        }
      }
      finally {}
    }
    return null;
  }
  
  private void syncAddressData()
  {
    if (this.mConnected)
    {
      ThreadManager.postImmediately(new BaseInnerDns.4(this), null, false);
      return;
    }
    QLog.e("InnerDns", 1, "syncAddressData fail, ipc is not connected.");
  }
  
  public static HashMap<String, HashMap<String, DomainData>> unParse(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject = paramString.getJSONObject(i);
        String str = ((JSONObject)localObject).getString("net_identifier");
        localObject = DomainData.unParse(((JSONObject)localObject).getString("domain_map"));
        if (localObject != null) {
          localHashMap.put(str, localObject);
        }
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "unParse failed");
      }
    }
    return null;
  }
  
  private static HashMap<String, DomainData> updateDomainMap(List<DomainIp.iplistInfo> paramList, HashMap<String, DomainData> paramHashMap)
  {
    if (paramList == null) {
      return paramHashMap;
    }
    Object localObject1 = paramHashMap;
    if (paramHashMap == null) {
      localObject1 = new HashMap();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (DomainIp.iplistInfo)paramList.next();
      paramHashMap = ((DomainIp.iplistInfo)localObject2).string_dname.get();
      if ((!TextUtils.isEmpty(paramHashMap)) && (((DomainIp.iplistInfo)localObject2).int32_result.get() == 0))
      {
        int i = ((DomainIp.iplistInfo)localObject2).uint32_type.get();
        if ((i != 1) && (i != 28))
        {
          if (QLog.isColorLevel())
          {
            paramHashMap = new StringBuilder();
            paramHashMap.append("onDomainServerListUpdate unexpected type=");
            paramHashMap.append(i);
            QLog.d("InnerDns", 2, paramHashMap.toString());
          }
        }
        else
        {
          localObject2 = ((DomainIp.iplistInfo)localObject2).ServerList_data.get();
          if (localObject2 != null)
          {
            DomainData localDomainData = getDomainData((HashMap)localObject1, paramHashMap);
            addIpToDomainData(paramHashMap, i, (List)localObject2, localDomainData);
            if (localDomainData.mIpList.size() > 0) {
              ((HashMap)localObject1).put(paramHashMap, localDomainData);
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  private boolean updateDomainServerList(byte[] paramArrayOfByte)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = localHashMap;
    Object localObject2;
    try
    {
      localObject2 = new DomainIp.NameRspBody();
      if (paramArrayOfByte != null)
      {
        localObject1 = localHashMap;
        ((DomainIp.NameRspBody)localObject2).mergeFrom(paramArrayOfByte);
      }
      localObject1 = localHashMap;
      paramArrayOfByte = (DomainIp.SubCmd_name_Rsp)((DomainIp.NameRspBody)localObject2).SubCmd_name_Rsp.get();
      localObject2 = null;
      if (paramArrayOfByte == null) {
        break label232;
      }
      localObject1 = localHashMap;
      localObject2 = paramArrayOfByte.iplistInfo.get();
      localObject1 = localHashMap;
      paramArrayOfByte = paramArrayOfByte.iplistInfoV6.get();
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    localObject1 = localHashMap;
    localHashMap = updateDomainMap((List)localObject2, localHashMap);
    localObject1 = localHashMap;
    paramArrayOfByte = updateDomainMap(paramArrayOfByte, localHashMap);
    boolean bool = true;
    localObject1 = paramArrayOfByte;
    for (;;)
    {
      bool = false;
      if (bool)
      {
        paramArrayOfByte = getNetIdentifier();
        try
        {
          if (!TextUtils.isEmpty(paramArrayOfByte))
          {
            if ((this.mNetMap.size() >= 3) && (!this.mNetMap.containsKey(paramArrayOfByte))) {
              this.mNetMap.clear();
            }
            this.mNetMap.put(paramArrayOfByte, localObject1);
          }
          if (this.mMainProcess) {
            getMobileQQ().getSharedPreferences("sp_inner_dns", 0).edit().putString("sp_domain", parse(this.mNetMap)).commit();
          }
          return bool;
        }
        finally {}
      }
      return bool;
      label232:
      paramArrayOfByte = null;
      if ((localObject2 != null) || (paramArrayOfByte != null)) {
        break;
      }
      localObject1 = localHashMap;
    }
  }
  
  public void getIPDomain()
  {
    if ((MobileQQ.sProcessId == 1) && (!this.mIsRequestingIPDomaining))
    {
      AppRuntime localAppRuntime = getRuntime();
      localAppRuntime.startServlet(new NewIntent(localAppRuntime.getApplicationContext(), IPDomainGetServlet.class));
      this.mIsRequestingIPDomaining = true;
    }
  }
  
  public void onAppDestroy()
  {
    if (this.mMainProcess) {
      try
      {
        getMobileQQ().getSharedPreferences("sp_inner_dns", 0).edit().putString("sp_domain", parse(this.mNetMap)).commit();
      }
      finally {}
    }
    try
    {
      getMobileQQ().unregisterReceiver(this.mIPCBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", params = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("InnerDns", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    if ("reqDomain2IpList".equals(paramString)) {
      ((Bundle)localObject).putParcelableArrayList("ip", getIpDataListLocal(paramBundle.getString("domain"), paramBundle.getInt("businessType")));
    } else if ("reportBadIp".equals(paramString)) {
      reportBadIp(paramBundle.getString("domain"), paramBundle.getString("ip"), paramBundle.getInt("businessType"));
    } else if ("syncAddressData".equals(paramString)) {
      ((Bundle)localObject).putString("addressData", parse(this.mNetMap));
    }
    return EIPCResult.createSuccessResult((Bundle)localObject);
  }
  
  public void onReceivePush(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceivePush:");
      ((StringBuilder)localObject).append(MobileQQ.sProcessId);
      QLog.d("InnerDns", 2, ((StringBuilder)localObject).toString());
    }
    this.mIsRequestingIPDomaining = false;
    if (!this.mMainProcess) {
      return;
    }
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      localObject = localStringBuilder;
      paramFromServiceMsg = new byte[localByteBuffer.getInt() - 4];
      localObject = paramFromServiceMsg;
      localByteBuffer.get(paramFromServiceMsg);
    }
    catch (Exception paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decode failed:");
      localStringBuilder.append(paramFromServiceMsg.getMessage());
      QLog.e("InnerDns", 1, localStringBuilder.toString());
      paramFromServiceMsg = (FromServiceMsg)localObject;
    }
    try
    {
      if (updateDomainServerList(paramFromServiceMsg))
      {
        paramFromServiceMsg = new Intent();
        paramFromServiceMsg.setAction("com.tencent.innerdns.domainAddressDataUpdateAction");
        getMobileQQ().sendBroadcast(paramFromServiceMsg, "com.tencent.msg.permission.pushnotify");
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("InnerDns", 2, "decode failed.");
        return;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceivePush sendBroadcast fail:");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getMessage());
      QLog.e("InnerDns", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void reportBadIp(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportBadIp domian: ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" ip:");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" busiType:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" ServerProcName:");
      ((StringBuilder)localObject1).append(this.mServerProcName);
      QLog.d("InnerDns", 2, ((StringBuilder)localObject1).toString());
    }
    paramString2 = paramString2.replaceAll("\\[(.*)\\]", "$1");
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    int i;
    if ((!bool1) && (!TextUtils.isEmpty(paramString2)) && (!paramString1.equals(paramString2)))
    {
      localObject1 = getNetIdentifier();
      Object localObject2 = this.mNetMap;
      bool1 = true;
      if ((localObject2 != null) && (((HashMap)localObject2).containsKey(localObject1)))
      {
        try
        {
          localObject1 = (HashMap)this.mNetMap.get(localObject1);
          if (((HashMap)localObject1).containsKey(paramString1))
          {
            localObject1 = (DomainData)((HashMap)localObject1).get(paramString1);
            if (((DomainData)localObject1).mIpList != null)
            {
              localObject1 = ((DomainData)localObject1).mIpList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (IpData)((Iterator)localObject1).next();
                if (paramString2.equals(((IpData)localObject2).mIp)) {
                  ((IpData)localObject2).mFailedCount += 1;
                }
              }
            }
          }
          i = 0;
        }
        finally {}
      }
      else
      {
        i = 60;
        bool1 = false;
      }
      if (!this.mMainProcess)
      {
        if (this.mConnected)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("domain", paramString1);
          ((Bundle)localObject1).putString("ip", paramString2);
          ((Bundle)localObject1).putInt("businessType", paramInt);
          if (!QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reportBadIp", (Bundle)localObject1).isSuccess())
          {
            i = 20;
            bool1 = bool2;
          }
          break label391;
        }
        i = 10;
      }
      else
      {
        break label391;
      }
    }
    else
    {
      i = 40;
    }
    bool1 = false;
    label391:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportBadIp succeeded:");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(" error=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("InnerDns", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("domain", paramString1);
    ((HashMap)localObject1).put("ip", paramString2);
    ((HashMap)localObject1).put("businessType", String.valueOf(paramInt));
    ((HashMap)localObject1).put("param_FailCode", String.valueOf(i));
    StatisticCollector.getInstance(getMobileQQ().getApplicationContext()).collectPerformance(null, "actDnsBadIp", bool1, MobileQQ.sProcessId, 0L, (HashMap)localObject1, "");
  }
  
  public String reqDns(String paramString, int paramInt)
  {
    return reqDns(paramString, paramInt, true);
  }
  
  public String reqDns(String paramString, int paramInt, boolean paramBoolean)
  {
    if (IpStrategyFactory.createIpv6Flag()) {
      return reqDns(paramString, paramInt, paramBoolean, 28);
    }
    return reqDns(paramString, paramInt, paramBoolean, 1);
  }
  
  public String reqDns(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramString = reqDnsForIpList(paramString, paramInt1, paramBoolean, paramInt2, true);
    if ((paramString != null) && (paramString.size() > 0)) {
      paramString = (String)paramString.get(0);
    } else {
      paramString = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reqDns after dns:");
      localStringBuilder.append(paramString);
      QLog.d("InnerDns", 2, localStringBuilder.toString());
    }
    return paramString;
  }
  
  public ArrayList<String> reqDnsForIpList(String paramString, int paramInt)
  {
    ArrayList localArrayList = reqDnsForIpList(paramString, paramInt, true, 1, true);
    paramString = reqDnsForIpList(paramString, paramInt, true, 28, true);
    return IpStrategyFactory.createDownStrategy().selectIpList(paramString, localArrayList, NetConnInfoCenter.getActiveNetIpFamily(true));
  }
  
  public ArrayList<String> reqDnsForIpList(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return reqDnsForIpList(paramString, paramInt1, paramBoolean, paramInt2, true);
  }
  
  public ArrayList<String> reqDnsForIpList(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    paramString = reqIpDataList(paramString, paramInt1, paramBoolean1);
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        IpData localIpData = (IpData)localIterator.next();
        if (localIpData.mType == paramInt2)
        {
          String str = localIpData.mIp;
          if ((localIpData.mType == 1) && (localIpData.mPort != 80) && (paramBoolean2))
          {
            paramString = new StringBuilder();
            paramString.append(str);
            paramString.append(":");
            paramString.append(localIpData.mPort);
            paramString = paramString.toString();
          }
          else
          {
            paramString = str;
            if (localIpData.mType == 28)
            {
              paramString = new StringBuilder();
              paramString.append("[");
              paramString.append(str);
              paramString.append("]");
              str = paramString.toString();
              paramString = str;
              if (localIpData.mPort != 80)
              {
                paramString = str;
                if (paramBoolean2)
                {
                  paramString = new StringBuilder();
                  paramString.append(str);
                  paramString.append(":");
                  paramString.append(localIpData.mPort);
                  paramString = paramString.toString();
                }
              }
            }
          }
          localArrayList.add(paramString);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public ArrayList<IpData> reqIpDataList(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqDns, p:");
      ((StringBuilder)localObject).append(MobileQQ.sProcessId);
      ((StringBuilder)localObject).append(" d:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" b:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("N:");
      ((StringBuilder)localObject).append(this.mServerProcName);
      QLog.d("InnerDns", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!this.mMainProcess)
    {
      localObject = this.mNetMap;
      if ((localObject == null) || (((HashMap)localObject).isEmpty())) {
        return getIpDataListIPC(paramString, paramInt, paramBoolean);
      }
    }
    return getIpDataListLocal(paramString, paramInt);
  }
  
  public ArrayList<ServerAddr> reqSerAddrList(String paramString, int paramInt)
  {
    ArrayList localArrayList = reqSerAddrList(paramString, paramInt, 1);
    paramString = reqSerAddrList(paramString, paramInt, 28);
    return IpStrategyFactory.createDownStrategy().selectIpList(paramString, localArrayList, NetConnInfoCenter.getActiveNetIpFamily(true));
  }
  
  public ArrayList<ServerAddr> reqSerAddrList(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = reqIpDataList(paramString, paramInt1, true);
    if (localObject != null)
    {
      paramString = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IpData localIpData = (IpData)((Iterator)localObject).next();
        if (localIpData.mType == paramInt2)
        {
          ServerAddr localServerAddr = new ServerAddr();
          localServerAddr.mIp = localIpData.mIp;
          localServerAddr.port = localIpData.mPort;
          boolean bool;
          if (paramInt2 == 28) {
            bool = true;
          } else {
            bool = false;
          }
          localServerAddr.isIpv6 = bool;
          paramString.add(localServerAddr);
        }
      }
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.BaseInnerDns
 * JD-Core Version:    0.7.0.1
 */