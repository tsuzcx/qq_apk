package com.tencent.mobileqq.transfile.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import bahl;
import bcvg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.ipv6.IpStrategy;
import com.tencent.mobileqq.transfile.ipv6.IpStrategyFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Lcom.tencent.mobileqq.transfile.dns.DomainData;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.mobileqq.configpush.DomainIp.NameRspBody;
import tencent.im.mobileqq.configpush.DomainIp.ServerList;
import tencent.im.mobileqq.configpush.DomainIp.SubCmd_name_Rsp;
import tencent.im.mobileqq.configpush.DomainIp.iplistInfo;

public class InnerDns
  extends QIPCModule
{
  private static final String ACTION_REPORT_BAD_IP = "reportBadIp";
  private static final String ACTION_REQ_DOMAIN_TO_IP_LIST = "reqDomain2IpList";
  private static final String ACTION_REQ_SYNC_DATA = "syncAddressData";
  private static final String ADDRESS_DATA = "addressData";
  private static final String BROADCAST_ACTION_DOMAIN_ADDRESS_DATA_UPDATE = "com.tencent.innerdns.domainAddressDataUpdateAction";
  private static final String BUSINESS_TYPE = "businessType";
  public static final int C2C_PIC_DOWNLOAD = 1004;
  public static final int CFT_DOMAIN = 1011;
  public static final int CMSHOW_GTIMG_DOMAIN = 1015;
  private static final String DOMAIN = "domain";
  public static final String DOMAIN_ARRAY = "domain_map";
  public static final int FACE_DOWNLOAD = 1003;
  public static final int FILE_TRANSFER = 1019;
  public static final int GROUP_PIC_DOWNLOAD = 1000;
  public static final int HTTP_DOWNLOADER = 1010;
  private static final int INPUT_INVALID = 40;
  private static final String IP = "ip";
  private static final int IPC_EXCEPTION = 20;
  private static final int IP_LIST_INVALID = 30;
  private static final String IP_TYPE = "ipType";
  public static final int KANDIAN_HTML_PRELOAD = 1008;
  public static final int KANDIAN_IMAGE_PRELOAD = 1009;
  public static final int KANDIAN_THIRD_VIDEO = 1006;
  public static final int MAX_IP_DATA_SIZE = 3;
  public static final String NAME = "InnerDnsModule";
  public static final int NEARBY_IMG_DOWNLOAD = 1001;
  public static final String NET_IDENTIFIER = "net_identifier";
  public static final int NOW_DOMAIN = 1017;
  private static final int NO_DOMAIN_FOUND = 50;
  private static final int NO_NET_FOUND = 60;
  public static final int OLD_HTTP_ENGINE = 1002;
  public static final int OPEN_CGI_VISIT = 1007;
  private static final int OTHER_PROCESS_BIND = 10;
  private static final int RESULT_OK = 0;
  public static final int SCRIBBLE_DOMAIN = 1018;
  public static final int SHORT_VIDEO_DOWNLOAD = 1005;
  public static final String SP_DOMAIN = "sp_domain";
  public static final String SP_INNER_DNS = "sp_inner_dns";
  public static final int STORY_VIDEO_DOWNLOAD = 1012;
  public static final String TAG = "InnerDns";
  public static final int VAS_DOWNLOAD_DOMAIN = 1016;
  public static final int VAS_QUICKUPDATE = 1014;
  public static final int WEBVIEW_SONIC = 1013;
  public static volatile InnerDns mInstance;
  private boolean mConnected;
  private BroadcastReceiver mIPCBroadcastReceiver = new InnerDns.3(this);
  private volatile boolean mIsRequestingIPDomaining;
  private final boolean mMainProcess;
  private HashMap<String, HashMap<String, DomainData>> mNetMap;
  private Random mRandom = new Random();
  private String mServerProcName;
  
  private InnerDns()
  {
    super("InnerDnsModule");
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      this.mMainProcess = bool;
      if (!this.mMainProcess) {
        break label105;
      }
      localObject = unParse(BaseApplicationImpl.getApplication().getSharedPreferences("sp_inner_dns", 0).getString("sp_domain", null));
      if (localObject == null) {
        break;
      }
      this.mNetMap = new HashMap((Map)localObject);
      return;
      bool = false;
    }
    this.mNetMap = new HashMap();
    return;
    label105:
    QIPCClientHelper.getInstance().getClient().connect(new InnerDns.1(this));
    QIPCClientHelper.getInstance().getClient().addListener(new InnerDns.2(this));
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.innerdns.domainAddressDataUpdateAction");
    try
    {
      BaseApplicationImpl.getApplication().registerReceiver(this.mIPCBroadcastReceiver, (IntentFilter)localObject, "com.tencent.msg.permission.pushnotify", null);
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
      DomainIp.ServerList localServerList = (DomainIp.ServerList)paramList.next();
      IpData localIpData = new IpData();
      localIpData.mIp = localServerList.string_IP.get();
      localIpData.mPort = localServerList.uint32_Port.get();
      localIpData.mType = paramInt;
      paramDomainData.mIpList.add(localIpData);
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "onDomainServerListUpdate type=" + paramInt + " d:" + paramString + " " + localIpData.mIp + " " + localIpData.mPort);
      }
    }
  }
  
  @NotNull
  private static DomainData getDomainData(HashMap<String, DomainData> paramHashMap, String paramString)
  {
    if ((paramHashMap.containsKey(paramString)) && (paramHashMap.get(paramString) != null))
    {
      paramHashMap = (DomainData)paramHashMap.get(paramString);
      if (paramHashMap.mIpList == null) {
        paramHashMap.mIpList = new ArrayList();
      }
      return paramHashMap;
    }
    return new DomainData(paramString, new ArrayList());
  }
  
  public static String getHostFromUrl(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public static InnerDns getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new InnerDns();
      }
      return mInstance;
    }
    finally {}
  }
  
  private ArrayList<IpData> getIpDataListIPC(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((this.mConnected) && (paramBoolean))
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("domain", paramString);
      ((Bundle)localObject).putInt("businessType", paramInt);
      localObject = QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reqDomain2IpList", (Bundle)localObject);
      if (((EIPCResult)localObject).isSuccess()) {
        return ((EIPCResult)localObject).data.getParcelableArrayList("ip");
      }
    }
    for (int i = 20;; i = 10)
    {
      reportInnerDns(paramString, paramInt, i, false);
      return null;
    }
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
          if (((HashMap)localObject).containsKey(paramString))
          {
            localObject = sortIp(((DomainData)((HashMap)localObject).get(paramString)).mIpList);
            if ((localObject != null) && (((ArrayList)localObject).size() > 0))
            {
              return localObject;
              reportInnerDns(paramString, paramInt, i, false);
              return null;
            }
          }
          else
          {
            i = 50;
            continue;
          }
        }
        else
        {
          getIPDomain();
          i = 60;
          continue;
        }
        int i = 30;
      }
      finally {}
    }
  }
  
  private String getNetIdentifier()
  {
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    String str2 = String.valueOf(NetworkUtil.getSystemNetwork(localContext));
    String str1 = str2;
    if (!StringUtil.isEmpty(str2))
    {
      str1 = str2;
      if (str2.equals(String.valueOf(1))) {
        str1 = bahl.a(localContext);
      }
    }
    return str1;
  }
  
  public static int getPortFromUrl(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
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
    }
    catch (Throwable paramHashMap)
    {
      paramHashMap.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "parse failed");
      }
      return null;
    }
    return paramHashMap;
  }
  
  public static InnerDns queryInstance()
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
    Object localObject2;
    if (!StringUtil.isEmpty(paramString2))
    {
      localObject1 = paramString1;
      if (!StringUtil.isEmpty(paramString1))
      {
        localObject2 = null;
        localObject1 = paramString1;
        if (paramString1 != null)
        {
          if (!paramString1.startsWith("http://")) {
            break label71;
          }
          localObject1 = "http://" + paramString2 + "/";
        }
      }
    }
    for (;;)
    {
      localObject1 = RichMediaUtil.replaceIp(paramString1, (String)localObject1);
      return localObject1;
      label71:
      localObject1 = localObject2;
      if (paramString1.startsWith("https://")) {
        localObject1 = "https://" + paramString2 + "/";
      }
    }
  }
  
  private void reportInnerDns(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt2));
    localHashMap.put("domain", paramString);
    localHashMap.put("businessType", String.valueOf(paramInt1));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actDnsReq", paramBoolean, BaseApplicationImpl.sProcessId, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "reqDnsForIpList succeeded:" + paramBoolean + " error=" + paramInt2);
    }
  }
  
  private ArrayList<IpData> sortIp(ArrayList<IpData> paramArrayList)
  {
    if (paramArrayList != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        int i = paramArrayList.size();
        if (i == 0)
        {
          localObject = null;
          return localObject;
        }
        localObject = paramArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (((IpData)((Iterator)localObject).next()).mFailedCount <= 0) {
            continue;
          }
          ((Iterator)localObject).remove();
          continue;
        }
        localObject = paramArrayList;
      }
      finally {}
      if (paramArrayList.size() > 1)
      {
        localObject = paramArrayList;
        if (this.mRandom.nextInt() % 10 == 0)
        {
          Collections.shuffle(paramArrayList);
          localObject = paramArrayList;
        }
      }
    }
  }
  
  private void syncAddressData()
  {
    if (this.mConnected)
    {
      ThreadManager.postImmediately(new InnerDns.4(this), null, false);
      return;
    }
    QLog.e("InnerDns", 1, "syncAddressData fail, ipc is not connected.");
  }
  
  public static HashMap<String, HashMap<String, DomainData>> unParse(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
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
      }
    } while (!QLog.isColorLevel());
    QLog.d("InnerDns", 2, "unParse failed");
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
    for (;;)
    {
      paramHashMap = (HashMap<String, DomainData>)localObject1;
      if (!paramList.hasNext()) {
        break;
      }
      Object localObject2 = (DomainIp.iplistInfo)paramList.next();
      paramHashMap = ((DomainIp.iplistInfo)localObject2).string_dname.get();
      if ((!StringUtil.isEmpty(paramHashMap)) && (((DomainIp.iplistInfo)localObject2).int32_result.get() == 0))
      {
        int i = ((DomainIp.iplistInfo)localObject2).uint32_type.get();
        if ((i != 1) && (i != 28))
        {
          if (QLog.isColorLevel()) {
            QLog.d("InnerDns", 2, "onDomainServerListUpdate unexpected type=" + i);
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
  }
  
  private boolean updateDomainServerList(byte[] paramArrayOfByte)
  {
    List localList = null;
    HashMap localHashMap = new HashMap();
    Object localObject = localHashMap;
    for (;;)
    {
      try
      {
        DomainIp.NameRspBody localNameRspBody = new DomainIp.NameRspBody();
        if (paramArrayOfByte != null)
        {
          localObject = localHashMap;
          localNameRspBody.mergeFrom(paramArrayOfByte);
        }
        localObject = localHashMap;
        paramArrayOfByte = (DomainIp.SubCmd_name_Rsp)localNameRspBody.SubCmd_name_Rsp.get();
        if (paramArrayOfByte == null) {
          break label243;
        }
        localObject = localHashMap;
        localList = paramArrayOfByte.iplistInfo.get();
        localObject = localHashMap;
        paramArrayOfByte = paramArrayOfByte.iplistInfoV6.get();
        if ((localList != null) || (paramArrayOfByte != null)) {
          continue;
        }
        paramArrayOfByte = localHashMap;
        bool = false;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = (byte[])localObject;
        boolean bool = false;
        continue;
      }
      if (bool) {
        localObject = getNetIdentifier();
      }
      try
      {
        if (!StringUtil.isEmpty((String)localObject))
        {
          if ((this.mNetMap.size() >= 3) && (!this.mNetMap.containsKey(localObject))) {
            this.mNetMap.clear();
          }
          this.mNetMap.put(localObject, paramArrayOfByte);
        }
        if (this.mMainProcess) {
          BaseApplicationImpl.getApplication().getSharedPreferences("sp_inner_dns", 0).edit().putString("sp_domain", parse(this.mNetMap)).commit();
        }
        return bool;
      }
      finally {}
      localObject = localHashMap;
      localHashMap = updateDomainMap(localList, localHashMap);
      localObject = localHashMap;
      paramArrayOfByte = updateDomainMap(paramArrayOfByte, localHashMap);
      bool = true;
      continue;
      label243:
      paramArrayOfByte = null;
    }
  }
  
  public void getIPDomain()
  {
    if ((BaseApplicationImpl.sProcessId == 1) && (!this.mIsRequestingIPDomaining))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localQQAppInterface.startServlet(new NewIntent(localQQAppInterface.getApp(), bcvg.class));
      this.mIsRequestingIPDomaining = true;
    }
  }
  
  /* Error */
  public void onAppDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 148	com/tencent/mobileqq/transfile/dns/InnerDns:mMainProcess	Z
    //   4: ifeq +43 -> 47
    //   7: ldc 2
    //   9: monitorenter
    //   10: invokestatic 152	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   13: ldc 96
    //   15: iconst_0
    //   16: invokevirtual 156	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   19: invokeinterface 646 1 0
    //   24: ldc 93
    //   26: aload_0
    //   27: getfield 173	com/tencent/mobileqq/transfile/dns/InnerDns:mNetMap	Ljava/util/HashMap;
    //   30: invokestatic 647	com/tencent/mobileqq/transfile/dns/InnerDns:parse	(Ljava/util/HashMap;)Ljava/lang/String;
    //   33: invokeinterface 652 3 0
    //   38: invokeinterface 655 1 0
    //   43: pop
    //   44: ldc 2
    //   46: monitorexit
    //   47: invokestatic 152	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   50: aload_0
    //   51: getfield 141	com/tencent/mobileqq/transfile/dns/InnerDns:mIPCBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   54: invokevirtual 684	com/tencent/common/app/BaseApplicationImpl:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   57: return
    //   58: astore_1
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   69: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	InnerDns
    //   58	5	1	localObject	Object
    //   64	2	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   10	47	58	finally
    //   59	62	58	finally
    //   47	57	64	java/lang/Exception
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Bundle localBundle = new Bundle();
    if ("reqDomain2IpList".equals(paramString)) {
      localBundle.putParcelableArrayList("ip", getIpDataListLocal(paramBundle.getString("domain"), paramBundle.getInt("businessType")));
    }
    for (;;)
    {
      return EIPCResult.createSuccessResult(localBundle);
      if ("reportBadIp".equals(paramString)) {
        reportBadIp(paramBundle.getString("domain"), paramBundle.getString("ip"), paramBundle.getInt("businessType"));
      } else if ("syncAddressData".equals(paramString)) {
        localBundle.putString("addressData", parse(this.mNetMap));
      }
    }
  }
  
  public void onReceivePush(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onReceivePush:" + BaseApplicationImpl.sProcessId);
    }
    this.mIsRequestingIPDomaining = false;
    if (!this.mMainProcess) {}
    Object localObject1;
    do
    {
      return;
      Object localObject2 = null;
      localObject1 = localObject2;
      try
      {
        ByteBuffer localByteBuffer = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject1 = localObject2;
        paramFromServiceMsg = new byte[localByteBuffer.getInt() - 4];
        localObject1 = paramFromServiceMsg;
        localByteBuffer.get(paramFromServiceMsg);
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          QLog.e("InnerDns", 1, "decode failed:" + paramFromServiceMsg.getMessage());
          paramFromServiceMsg = (FromServiceMsg)localObject1;
        }
      }
      try
      {
        if (updateDomainServerList(paramFromServiceMsg))
        {
          paramFromServiceMsg = new Intent();
          paramFromServiceMsg.setAction("com.tencent.innerdns.domainAddressDataUpdateAction");
          BaseApplicationImpl.getApplication().sendBroadcast(paramFromServiceMsg, "com.tencent.msg.permission.pushnotify");
          return;
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.e("InnerDns", 1, "onReceivePush sendBroadcast fail:" + paramFromServiceMsg.getMessage());
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("InnerDns", 2, "decode failed.");
  }
  
  public void reportBadIp(String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "reportBadIp domian: " + paramString1 + " ip:" + paramString2 + " busiType:" + paramInt + " ServerProcName:" + this.mServerProcName);
    }
    paramString2 = paramString2.replaceAll("\\[(.*)\\]", "$1");
    int i;
    boolean bool1;
    if ((StringUtil.isEmpty(paramString1)) || (StringUtil.isEmpty(paramString2)) || (paramString1.equals(paramString2)))
    {
      i = 40;
      bool1 = false;
    }
    label464:
    label474:
    label477:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "reportBadIp succeeded:" + bool1 + " error=" + i);
      }
      Object localObject = new HashMap();
      ((HashMap)localObject).put("domain", paramString1);
      ((HashMap)localObject).put("ip", paramString2);
      ((HashMap)localObject).put("businessType", String.valueOf(paramInt));
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actDnsBadIp", bool1, BaseApplicationImpl.sProcessId, 0L, (HashMap)localObject, "");
      return;
      localObject = getNetIdentifier();
      if ((this.mNetMap != null) && (this.mNetMap.containsKey(localObject)))
      {
        try
        {
          localObject = (HashMap)this.mNetMap.get(localObject);
          if (((HashMap)localObject).containsKey(paramString1))
          {
            localObject = (DomainData)((HashMap)localObject).get(paramString1);
            if (((DomainData)localObject).mIpList != null)
            {
              localObject = ((DomainData)localObject).mIpList.iterator();
              while (((Iterator)localObject).hasNext())
              {
                IpData localIpData = (IpData)((Iterator)localObject).next();
                if (paramString2.equals(localIpData.mIp)) {
                  localIpData.mFailedCount += 1;
                }
              }
            }
          }
        }
        finally {}
        bool1 = true;
        i = 0;
        label375:
        if (this.mMainProcess) {
          break label477;
        }
        if (!this.mConnected) {
          break label464;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("domain", paramString1);
        ((Bundle)localObject).putString("ip", paramString2);
        ((Bundle)localObject).putInt("businessType", paramInt);
        if (QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reportBadIp", (Bundle)localObject).isSuccess()) {
          break label474;
        }
        i = 20;
        bool1 = bool2;
      }
      for (;;)
      {
        break;
        i = 60;
        bool1 = false;
        break label375;
        i = 10;
        bool1 = false;
        break;
      }
    }
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
    if ((paramString != null) && (paramString.size() > 0)) {}
    for (paramString = (String)paramString.get(0);; paramString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "reqDns after dns:" + paramString);
      }
      return paramString;
    }
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
    ArrayList localArrayList;
    IpData localIpData;
    String str;
    if (paramString != null)
    {
      localArrayList = new ArrayList();
      Iterator localIterator = paramString.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localIpData = (IpData)localIterator.next();
          if (localIpData.mType == paramInt2)
          {
            str = localIpData.mIp;
            if ((localIpData.mType == 1) && (localIpData.mPort != 80) && (paramBoolean2)) {
              paramString = str + ":" + localIpData.mPort;
            }
          }
        }
      }
    }
    for (;;)
    {
      localArrayList.add(paramString);
      break;
      paramString = str;
      if (localIpData.mType == 28)
      {
        str = "[" + str + "]";
        paramString = str;
        if (localIpData.mPort != 80)
        {
          paramString = str;
          if (paramBoolean2)
          {
            paramString = str + ":" + localIpData.mPort;
            continue;
            return localArrayList;
            return null;
          }
        }
      }
    }
  }
  
  public ArrayList<IpData> reqIpDataList(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "reqDns, p:" + BaseApplicationImpl.sProcessId + " d:" + paramString + " b:" + paramInt + "N:" + this.mServerProcName);
    }
    if (StringUtil.isEmpty(paramString)) {
      return null;
    }
    if ((this.mMainProcess) || ((this.mNetMap != null) && (!this.mNetMap.isEmpty()))) {
      return getIpDataListLocal(paramString, paramInt);
    }
    return getIpDataListIPC(paramString, paramInt, paramBoolean);
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
          if (paramInt2 == 28) {}
          for (boolean bool = true;; bool = false)
          {
            localServerAddr.isIpv6 = bool;
            paramString.add(localServerAddr);
            break;
          }
        }
      }
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.InnerDns
 * JD-Core Version:    0.7.0.1
 */