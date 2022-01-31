package com.tencent.mobileqq.transfile.dns;

import aixg;
import aixh;
import aixi;
import aixj;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.servlet.IPDomainGetServlet;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.RichMediaUtil;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.mobileqq.mobroute.DomainIp.DomainServerList;
import tencent.im.mobileqq.mobroute.DomainIp.DomainiplistInfo;
import tencent.im.mobileqq.mobroute.DomainIp.NameRspBody;
import tencent.im.mobileqq.mobroute.DomainIp.SubCmd_name_Rsp;

public class InnerDns
  extends QIPCModule
{
  public static volatile InnerDns a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aixi(this);
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  private volatile boolean c;
  
  private InnerDns()
  {
    super("InnerDnsModule");
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label105;
      }
      localObject = a(BaseApplicationImpl.getApplication().getSharedPreferences("sp_inner_dns", 0).getString("sp_domain", null));
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap((Map)localObject);
      return;
      bool = false;
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    return;
    label105:
    QIPCClientHelper.getInstance().getClient().connect(new aixg(this));
    QIPCClientHelper.getInstance().getClient().addListener(new aixh(this));
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.innerdns.domainAddressDataUpdateAction");
    try
    {
      BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject, "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static InnerDns a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTransfileDnsInnerDns == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTransfileDnsInnerDns == null) {
        jdField_a_of_type_ComTencentMobileqqTransfileDnsInnerDns = new InnerDns();
      }
      return jdField_a_of_type_ComTencentMobileqqTransfileDnsInnerDns;
    }
    finally {}
  }
  
  private String a()
  {
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    String str2 = String.valueOf(NetworkUtil.a(localContext));
    String str1 = str2;
    if (!StringUtil.a(str2))
    {
      str1 = str2;
      if (str2.equals(Integer.valueOf(1))) {
        str1 = PttIpSaver.a(localContext);
      }
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    if (StringUtil.a(paramString)) {
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
  
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!StringUtil.a(paramString2))
    {
      str = paramString1;
      if (!StringUtil.a(paramString1)) {
        str = RichMediaUtil.a(paramString1, "http://" + paramString2 + "/");
      }
    }
    return str;
  }
  
  public static String a(HashMap paramHashMap)
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
        localJSONObject.put("domain_map", DomainData.a((HashMap)localObject));
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
  
  private ArrayList a(ArrayList paramArrayList)
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
          if (((IpData)((Iterator)localObject).next()).b <= 0) {
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
        if (this.jdField_a_of_type_JavaUtilRandom.nextInt() % 10 == 0)
        {
          Collections.shuffle(paramArrayList);
          localObject = paramArrayList;
        }
      }
    }
  }
  
  public static HashMap a(String paramString)
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
          localObject = DomainData.a(((JSONObject)localObject).getString("domain_map"));
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
  
  private boolean a(byte[] paramArrayOfByte)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        localObject1 = new DomainIp.NameRspBody();
        if (paramArrayOfByte != null) {
          ((DomainIp.NameRspBody)localObject1).mergeFrom(paramArrayOfByte);
        }
        paramArrayOfByte = (DomainIp.SubCmd_name_Rsp)((DomainIp.NameRspBody)localObject1).SubCmd_name_Rsp.get();
        if (paramArrayOfByte == null) {
          break label428;
        }
        paramArrayOfByte = paramArrayOfByte.iplistInfo.get();
        if (paramArrayOfByte != null) {
          continue;
        }
        bool = false;
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        DomainIp.DomainServerList localDomainServerList;
        IpData localIpData;
        paramArrayOfByte.printStackTrace();
        bool = false;
        continue;
        if (((ArrayList)localObject2).size() <= 0) {
          continue;
        }
        localHashMap.put(localObject1, new DomainData((String)localObject1, (ArrayList)localObject2));
        continue;
      }
      if (bool) {
        paramArrayOfByte = a();
      }
      try
      {
        if (!StringUtil.a(paramArrayOfByte))
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap.size() >= 3) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramArrayOfByte))) {
            this.jdField_a_of_type_JavaUtilHashMap.clear();
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(paramArrayOfByte, localHashMap);
        }
        if (this.jdField_a_of_type_Boolean) {
          BaseApplicationImpl.getApplication().getSharedPreferences("sp_inner_dns", 0).edit().putString("sp_domain", a(this.jdField_a_of_type_JavaUtilHashMap)).commit();
        }
        return bool;
      }
      finally {}
      paramArrayOfByte = paramArrayOfByte.iterator();
      if (paramArrayOfByte.hasNext())
      {
        localObject2 = (DomainIp.DomainiplistInfo)paramArrayOfByte.next();
        localObject1 = ((DomainIp.DomainiplistInfo)localObject2).string_dname.get();
        if ((!StringUtil.a((String)localObject1)) && (((DomainIp.DomainiplistInfo)localObject2).int32_result.get() == 0))
        {
          localObject3 = ((DomainIp.DomainiplistInfo)localObject2).ServerList_data.get();
          if (localObject3 != null)
          {
            localObject2 = new ArrayList();
            localObject3 = ((List)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localDomainServerList = (DomainIp.DomainServerList)((Iterator)localObject3).next();
              localIpData = new IpData();
              localIpData.jdField_a_of_type_JavaLangString = localDomainServerList.string_IP.get();
              localIpData.jdField_a_of_type_Int = localDomainServerList.uint32_Port.get();
              ((ArrayList)localObject2).add(localIpData);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("InnerDns", 2, "onDomainServerListUpdate:" + (String)localObject1 + " " + localIpData.jdField_a_of_type_JavaLangString + " " + localIpData.jdField_a_of_type_Int);
              continue;
            }
            label428:
            paramArrayOfByte = null;
            continue;
          }
        }
      }
      boolean bool = true;
    }
  }
  
  public static InnerDns b()
  {
    return jdField_a_of_type_ComTencentMobileqqTransfileDnsInnerDns;
  }
  
  public static String b(String paramString, int paramInt)
  {
    String str = a(paramString);
    return a(paramString, a().a(str, paramInt));
  }
  
  private void c()
  {
    if (this.b)
    {
      ThreadManager.postImmediately(new aixj(this), null, false);
      return;
    }
    QLog.e("InnerDns", 1, "syncAddressData fail, ipc is not connected.");
  }
  
  public String a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true);
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    ArrayList localArrayList = a(paramString, paramInt, paramBoolean);
    paramString = localObject;
    if (localArrayList != null)
    {
      paramString = localObject;
      if (localArrayList.size() > 0) {
        paramString = (String)localArrayList.get(0);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "reqDns after dns:" + paramString);
    }
    return paramString;
  }
  
  public ArrayList a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true);
  }
  
  public ArrayList a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "reqDns, process:" + BaseApplicationImpl.sProcessId + " domain:" + paramString + " busiType:" + paramInt + " ServerProcName:" + this.jdField_a_of_type_JavaLangString);
    }
    if (StringUtil.a(paramString))
    {
      paramString = null;
      return paramString;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    boolean bool = true;
    Object localObject;
    if ((this.jdField_a_of_type_Boolean) || ((this.jdField_a_of_type_JavaUtilHashMap != null) && (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))) {
      localObject = a();
    }
    label446:
    label455:
    label583:
    label594:
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
          break label455;
        }
        localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        if (!((HashMap)localObject).containsKey(paramString)) {
          break label446;
        }
        localObject = a(((DomainData)((HashMap)localObject).get(paramString)).a);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          if (((IpData)((ArrayList)localObject).get(0)).b <= 0) {
            break label580;
          }
          i = 1;
          break label583;
          localObject = new HashMap();
          ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject).put("domain", paramString);
          ((HashMap)localObject).put("businessType", String.valueOf(paramInt));
          StatisticCollector.a(BaseApplication.getContext()).a(null, "actDnsReq", paramBoolean, BaseApplicationImpl.sProcessId, 0L, (HashMap)localObject, "");
          paramString = localArrayList;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("InnerDns", 2, "reqDnsForIpList succeeded:" + paramBoolean + " retList=" + localArrayList + " error=" + i);
          return localArrayList;
        }
        i = 1;
      }
      finally {}
      Iterator localIterator = ((ArrayList)localObject).iterator();
      if (localIterator.hasNext())
      {
        IpData localIpData = (IpData)localIterator.next();
        localObject = localIpData.jdField_a_of_type_JavaLangString;
        if (localIpData.jdField_a_of_type_Int != 80)
        {
          localObject = (String)localObject + ":" + localIpData.jdField_a_of_type_Int;
          localArrayList.add(localObject);
          continue;
          paramBoolean = false;
          i = 50;
          break label594;
          b();
          paramBoolean = false;
          i = 60;
          continue;
          if ((this.b) && (paramBoolean))
          {
            localObject = new Bundle();
            ((Bundle)localObject).putString("domain", paramString);
            ((Bundle)localObject).putInt("businessType", paramInt);
            localObject = QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reqDomain2IpList", (Bundle)localObject);
            if (((EIPCResult)localObject).isSuccess())
            {
              localArrayList = ((EIPCResult)localObject).data.getStringArrayList("ip");
              paramBoolean = bool;
            }
            for (;;)
            {
              break;
              paramBoolean = false;
              i = 20;
            }
          }
          i = 10;
          paramBoolean = false;
        }
        else {}
      }
      else
      {
        paramBoolean = true;
        i = 0;
        break label594;
        i = 0;
        if (i != 0)
        {
          paramBoolean = false;
          i = 30;
        }
      }
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/tencent/mobileqq/transfile/dns/InnerDns:jdField_a_of_type_Boolean	Z
    //   4: ifeq +43 -> 47
    //   7: ldc 2
    //   9: monitorenter
    //   10: invokestatic 47	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   13: ldc 49
    //   15: iconst_0
    //   16: invokevirtual 53	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   19: invokeinterface 338 1 0
    //   24: ldc 55
    //   26: aload_0
    //   27: getfield 71	com/tencent/mobileqq/transfile/dns/InnerDns:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   30: invokestatic 339	com/tencent/mobileqq/transfile/dns/InnerDns:a	(Ljava/util/HashMap;)Ljava/lang/String;
    //   33: invokeinterface 345 3 0
    //   38: invokeinterface 348 1 0
    //   43: pop
    //   44: ldc 2
    //   46: monitorexit
    //   47: invokestatic 47	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   50: aload_0
    //   51: getfield 35	com/tencent/mobileqq/transfile/dns/InnerDns:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   54: invokevirtual 530	com/tencent/common/app/BaseApplicationImpl:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   57: return
    //   58: astore_1
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual 115	java/lang/Exception:printStackTrace	()V
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
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onReceivePush:" + BaseApplicationImpl.sProcessId);
    }
    this.c = false;
    if (!this.jdField_a_of_type_Boolean) {}
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
        if (a(paramFromServiceMsg))
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
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    boolean bool = false;
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "reportBadIp domian: " + paramString1 + " ip:" + paramString2 + " busiType:" + paramInt + " ServerProcName:" + this.jdField_a_of_type_JavaLangString);
    }
    Object localObject;
    if ((StringUtil.a(paramString1)) || (StringUtil.a(paramString2)) || (paramString1.equals(paramString2)))
    {
      bool = false;
      i = 40;
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "reportBadIp succeeded:" + bool + " error=" + i);
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("domain", paramString1);
      ((HashMap)localObject).put("ip", paramString2);
      ((HashMap)localObject).put("businessType", String.valueOf(paramInt));
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actDnsBadIp", bool, BaseApplicationImpl.sProcessId, 0L, (HashMap)localObject, "");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = a();
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
        try
        {
          localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          if (((HashMap)localObject).containsKey(paramString1))
          {
            localObject = (DomainData)((HashMap)localObject).get(paramString1);
            if (((DomainData)localObject).a != null)
            {
              localObject = ((DomainData)localObject).a.iterator();
              while (((Iterator)localObject).hasNext())
              {
                IpData localIpData = (IpData)((Iterator)localObject).next();
                if (paramString2.equals(localIpData.jdField_a_of_type_JavaLangString)) {
                  localIpData.b += 1;
                }
              }
            }
          }
        }
        finally {}
      }
      for (bool = true;; bool = false)
      {
        break;
        i = 60;
      }
    }
    if (this.b)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("domain", paramString1);
      ((Bundle)localObject).putString("ip", paramString2);
      ((Bundle)localObject).putInt("businessType", paramInt);
      if (QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reportBadIp", (Bundle)localObject).isSuccess()) {
        break label462;
      }
      i = 20;
    }
    for (;;)
    {
      break;
      bool = false;
      i = 10;
      break;
      label462:
      i = 0;
      bool = true;
    }
  }
  
  public void b()
  {
    if ((BaseApplicationImpl.sProcessId == 1) && (!this.c))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localQQAppInterface.startServlet(new NewIntent(localQQAppInterface.getApp(), IPDomainGetServlet.class));
      this.c = true;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Bundle localBundle = new Bundle();
    if ("reqDomain2IpList".equals(paramString)) {
      localBundle.putStringArrayList("ip", a(paramBundle.getString("domain"), paramBundle.getInt("businessType")));
    }
    for (;;)
    {
      return EIPCResult.createSuccessResult(localBundle);
      if ("reportBadIp".equals(paramString)) {
        a(paramBundle.getString("domain"), paramBundle.getString("ip"), paramBundle.getInt("businessType"));
      } else if ("syncAddressData".equals(paramString)) {
        localBundle.putString("addressData", a(this.jdField_a_of_type_JavaUtilHashMap));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.dns.InnerDns
 * JD-Core Version:    0.7.0.1
 */