package com.tencent.mobileqq.msf.core.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ag;
import com.tencent.mobileqq.msf.core.b.a;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.serverconfig.g;
import com.tencent.msf.service.protocol.serverconfig.i;
import com.tencent.msf.service.protocol.serverconfig.j;
import com.tencent.msf.service.protocol.serverconfig.k;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class c
{
  private static final byte[] B = { -16, 68, 31, 95, -12, 45, -91, -113, -36, -9, -108, -102, -70, 98, -44, 17 };
  private static final String[] C = { "socket://msfxg.3g.qq.com:8080#46000_46002_46007_46001_46003:0:1", "socket://113.96.12.224:80#46003:0:1", "socket://183.232.94.44:14000#46000_46002_46007:0:1", "socket://120.232.18.27:8080#46000_46002_46007:0:1", "socket://157.255.13.77:443#46001:0:1", "socket://203.205.255.224:8080#46000_46002_46007_46001_46003:0:1" };
  private static final String[] D = { "socket://120.232.18.27:14000#46000_46002_46007:0:1", "socket://msfxg.3g.qq.com:80#46000_46002_46007:0:1", "socket://111.30.178.75:443#46000_46002_46007:0:1", "socket://36.155.240.38:8080#46000_46002_46007:0:1", "socket://183.232.94.44:8080#46000_46002_46007:0:1", "socket://111.30.138.152:443#46000_46002_46007:0:1", "socket://117.144.244.33:443#46000_46002_46007:0:1", "socket://111.30.138.152:443#46000_46002_46007:0:1" };
  private static final String[] E = { "socket://163.177.89.195:14000#46001:0:1", "socket://msfxg.3g.qq.com:80#46001:0:1", "socket://157.255.13.77:8080#46001:0:1", "socket://221.198.69.96:8080#46001:0:1", "socket://153.3.149.61:14000#46001:0:1", "socket://111.206.25.142:443#46001:0:1", "socket://140.207.123.177:8080#46001:0:1" };
  private static final String[] F = { "socket://113.96.12.224:14000#46003:0:1", "socket://msfxg.3g.qq.com:80#46003:0:1", "socket://183.3.235.162:443#46003:0:1", "socket://42.81.169.100:8080#46003:0:1", "socket://114.221.144.89:443#46003:0:1", "socket://123.150.76.143:80#46003:0:1", "socket://61.129.6.101:14000#46003:0:1" };
  private static final String[] G = { "socket://203.205.255.224:443#46000_46002_46007_46001_46003:0:1", "socket://msfxg.3g.qq.com:80#46000_46002_46007_46001_46003:0:1", "socket://203.205.255.221:443#46000_46002_46007_46001_46003:0:1", "socket://183.3.235.162:8080#46000_46002_46007_46001_46003:0:1", "socket://163.177.89.195:8080#46000_46002_46007_46001_46003:0:1", "socket://183.232.94.44:443#46000_46002_46007_46001_46003:0:1" };
  private static final String[] H = { "socket://msfwifi.3g.qq.com:8080#00000:0:1", "socket://14.215.138.110:8080#00000:0:1", "socket://113.96.12.224:8080#00000:0:1", "socket://157.255.13.77:14000#00000:0:1", "socket://120.232.18.27:443#00000:0:1", "socket://183.3.235.162:14000#00000:0:1", "socket://163.177.89.195:443#00000:0:1", "socket://183.232.94.44:80#00000:0:1", "socket://203.205.255.224:8080#00000:0:1", "socket://203.205.255.221:8080#00000:0:1" };
  private static final String[] I = { "http://msfhttp.3g.qq.com:80#00000:0:1" };
  private static final String[] J = { "quic://58.251.106.174:443#00000:0:1" };
  private static final String[] K = { "socket://msfwifiv6.3g.qq.com:8080#00000:0:1", "socket://[240e:ff:f101:10::109]:14000" };
  private static final String[] L = { "socket://msfxgv6.3g.qq.com:8080#00000:0:1", "socket://[240e:ff:f101:10::109]:14000" };
  public static final String a = "MSF.C.SsoListManager";
  public static final String b = "sso";
  public static final String c = "Socket";
  public static final String d = "Http";
  public static final String e = "Quic";
  public static final String f = "Wifi";
  public static final String g = "Mobile";
  public static final String h = "Ipv4";
  public static final String i = "Ipv6";
  public static final int j = 1;
  public static final int k = 2;
  public static long l = 0L;
  public static long m = 0L;
  private static final String o = "policyId";
  private static final String p = "DualConnTime";
  private static final String q = "__loginSdk_ssoWifilist";
  private static final String r = "__loginSdk_ssoMobilelist";
  private static final String s = "__loginSdk_ssoHttpWifilist";
  private static final String t = "__loginSdk_ssoHttpMobilelist";
  private static final String u = "__loginSdk_ssoQuicHttpList";
  private static final String v = "wifiused";
  private static final String w = "wifiname";
  private static final String x = "wifitime";
  private static final String y = "wifiUsedCount";
  private static final int z = 10;
  private boolean A = false;
  private ConcurrentHashMap M = new ConcurrentHashMap();
  private ConcurrentHashMap N = new ConcurrentHashMap();
  private ConcurrentHashMap O = new ConcurrentHashMap();
  private LinkedBlockingDeque P = new LinkedBlockingDeque(1000);
  private Handler Q = null;
  private Thread R = null;
  MsfCore n;
  
  public c(MsfCore paramMsfCore)
  {
    this.n = paramMsfCore;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      return "Ipv6";
    }
    return "Ipv4";
  }
  
  private CopyOnWriteArrayList a(String[] paramArrayOfString)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localCopyOnWriteArrayList.add(com.tencent.mobileqq.msf.core.d.a(paramArrayOfString[i1]));
      i1 += 1;
    }
    return localCopyOnWriteArrayList;
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, com.tencent.msf.service.protocol.serverconfig.f paramf)
  {
    if (this.Q == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("logUploadHandle");
      localHandlerThread.start();
      this.Q = new Handler(localHandlerThread.getLooper());
    }
    this.Q.post(new d(this, paramf, paramFromServiceMsg));
  }
  
  private void a(String paramString)
  {
    label701:
    label704:
    label707:
    label710:
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        long l1;
        Object localObject1;
        Object localObject2;
        if (this.O.containsKey(paramString))
        {
          l1 = System.currentTimeMillis();
          this.O.put(paramString, Long.valueOf(l1));
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.SsoListManager", 2, "find ssid: " + paramString + " update time = " + l1);
          }
          paramString = BaseApplication.getContext().getSharedPreferences("wifiused", 0).edit();
          paramString.putInt("wifiUsedCount", this.O.size());
          localObject1 = this.O.entrySet().iterator();
          int i1 = 0;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            if (localObject2 == null) {
              break label701;
            }
            l1 = ((Long)((Map.Entry)localObject2).getValue()).longValue();
            localObject2 = (String)((Map.Entry)localObject2).getKey();
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label701;
            }
            paramString.putString("wifiname" + i1, (String)localObject2);
            paramString.putLong("wifitime" + i1, l1);
            i1 += 1;
            break label707;
          }
        }
        else
        {
          if (this.O.size() >= 10)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.SsoListManager", 2, "too much ssid need to delete one find Least Recently Used now...");
            }
            l1 = System.currentTimeMillis();
            localObject1 = null;
            localObject2 = this.O.entrySet().iterator();
            if (((Iterator)localObject2).hasNext())
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
              if (localEntry == null) {
                break label704;
              }
              long l2 = ((Long)localEntry.getValue()).longValue();
              if (l2 >= l1) {
                break label704;
              }
              localObject1 = (String)localEntry.getKey();
              l1 = l2;
              break label710;
            }
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.SsoListManager", 2, "Least Recently Used ssid find delete now: " + (String)localObject1);
              }
              this.O.remove(localObject1);
              MsfStore.getNativeConfigStore().n_removeConfig("__loginSdk_ssoWifilist_" + (String)localObject1);
              MsfStore.getNativeConfigStore().n_removeConfig(c.a.a("Socket", "Wifi", "Ipv4").a() + (String)localObject1);
              MsfStore.getNativeConfigStore().n_removeConfig(c.a.a("Http", "Wifi", "Ipv4").a() + (String)localObject1);
              MsfStore.getNativeConfigStore().n_removeConfig(c.a.a("Quic", "Wifi", "Ipv4").a() + (String)localObject1);
              MsfStore.getNativeConfigStore().n_removeConfig(c.a.a("Socket", "Wifi", "Ipv6").a() + (String)localObject1);
              MsfStore.getNativeConfigStore().n_removeConfig(c.a.a("Http", "Wifi", "Ipv6").a() + (String)localObject1);
              MsfStore.getNativeConfigStore().n_removeConfig(c.a.a("Quic", "Wifi", "Ipv6").a() + (String)localObject1);
            }
          }
          this.O.put(paramString, Long.valueOf(System.currentTimeMillis()));
          continue;
        }
        paramString.commit();
      }
      finally {}
      continue;
      break label707;
      break label710;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    c.a locala = c.a.a("Socket", "Wifi", "Ipv4");
    String str = locala.a() + paramString;
    if (TextUtils.isEmpty(paramString)) {}
    for (Object localObject = "__loginSdk_ssoWifilist";; localObject = "__loginSdk_ssoWifilist_" + paramString)
    {
      a(locala, str, (String)localObject, paramBoolean);
      localObject = c.a.a("Http", "Wifi", "Ipv4");
      a((c.a)localObject, ((c.a)localObject).a() + paramString, "__loginSdk_ssoHttpWifilist", paramBoolean);
      localObject = c.a.a("Quic", "Wifi", "Ipv4");
      a((c.a)localObject, ((c.a)localObject).a() + paramString, "__loginSdk_ssoQuicHttpList", paramBoolean);
      localObject = c.a.a("Socket", "Wifi", "Ipv6");
      boolean bool = this.A;
      this.A = (a((c.a)localObject, ((c.a)localObject).a() + paramString, null, paramBoolean) | bool);
      localObject = c.a.a("Http", "Wifi", "Ipv6");
      bool = this.A;
      this.A = (a((c.a)localObject, ((c.a)localObject).a() + paramString, null, paramBoolean) | bool);
      localObject = c.a.a("Quic", "Wifi", "Ipv6");
      bool = this.A;
      this.A = (a((c.a)localObject, ((c.a)localObject).a() + paramString, null, paramBoolean) | bool);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.SsoListManager", 2, "loadWifiSsoListMapFromStore mCurSsoListMap=" + this.N.size());
      }
      return;
    }
  }
  
  private boolean a(c.a parama, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = null;
    String str = MsfStore.getNativeConfigStore().getConfig(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.SsoListManager", 2, "loadSsoListMapFromStore ssoTypeKey=" + parama + ", storeKey=" + paramString1 + ", oldStoreKey=" + paramString2 + ", isChange=" + paramBoolean);
    }
    if (TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = MsfStore.getNativeConfigStore().getConfig(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "loadSsoListMapFromStore oldSsoListStr=" + paramString2);
        }
        localObject = b(paramString2);
      }
      if ((!paramBoolean) || (this.M.get(parama) == null) || (((CopyOnWriteArrayList)this.M.get(parama)).size() <= 0)) {
        break label350;
      }
      paramString2 = (String)localObject;
      if (localObject == null) {
        paramString2 = new ArrayList();
      }
      if (!paramString2.isEmpty()) {
        break label347;
      }
      paramString2.addAll((Collection)this.M.get(parama));
    }
    for (;;)
    {
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        this.N.put(parama, new CopyOnWriteArrayList(paramString2));
      }
      for (boolean bool = true;; bool = false)
      {
        if (paramBoolean)
        {
          parama = new StringBuffer();
          if (paramString2 != null)
          {
            paramString2 = paramString2.iterator();
            for (;;)
            {
              if (paramString2.hasNext())
              {
                localObject = (com.tencent.mobileqq.msf.core.d)paramString2.next();
                parama.append(((com.tencent.mobileqq.msf.core.d)localObject).toString() + ";");
                continue;
                paramString2 = b(str);
                paramBoolean = false;
                break;
              }
            }
          }
          MsfStore.getNativeConfigStore().n_setConfig(paramString1, parama.toString());
        }
        return bool;
      }
      label347:
      continue;
      label350:
      paramString2 = (String)localObject;
    }
  }
  
  private boolean a(c.a parama, String paramString1, ArrayList paramArrayList, boolean paramBoolean, String paramString2)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("updateSsoListAndStore ssoTypeKey=").append(parama.toString()).append(", keyPostfix=").append(paramString1).append(", ssoList size=");
          if (paramArrayList == null)
          {
            localObject1 = "null";
            QLog.d("MSF.C.SsoListManager", 2, localObject1 + ", isPush=" + paramBoolean);
          }
        }
        else
        {
          if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
            continue;
          }
          this.N.put(parama, new CopyOnWriteArrayList(paramArrayList));
          bool1 = true;
          boolean bool2 = TextUtils.isEmpty(paramString1);
          if (!bool2) {
            continue;
          }
          return bool1;
        }
        localObject1 = Integer.valueOf(paramArrayList.size());
        continue;
        this.N.remove(parama);
        boolean bool1 = false;
        continue;
        localObject1 = new StringBuffer();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          localObject2 = (com.tencent.mobileqq.msf.core.d)paramArrayList.next();
          ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject2).toString() + ";");
          continue;
        }
        paramString1 = parama.a() + paramString1;
      }
      finally {}
      MsfStore.getNativeConfigStore().n_setConfig(paramString1, ((StringBuffer)localObject1).toString());
      if (!TextUtils.isEmpty(paramString2)) {
        MsfStore.getNativeConfigStore().n_setConfig("policyId" + paramString1, paramString2);
      }
      if (QLog.isColorLevel()) {
        if (paramBoolean) {
          QLog.d("MSF.C.SsoListManager", 2, "save push sso for " + parama.toString() + " " + ((StringBuffer)localObject1).toString());
        } else {
          QLog.d("MSF.C.SsoListManager", 2, "save http get sso for " + parama.toString() + " " + ((StringBuffer)localObject1).toString());
        }
      }
    }
  }
  
  private boolean a(com.tencent.mobileqq.msf.core.d paramd, c.a parama)
  {
    parama = (CopyOnWriteArrayList)this.N.get(parama);
    if ((parama != null) && (parama.remove(paramd)))
    {
      parama.add(paramd);
      QLog.d("MSF.C.SsoListManager", 1, " set " + paramd + " at ssoList last.");
      return true;
    }
    QLog.d("MSF.C.SsoListManager", 1, " not found " + paramd + " at ssoList.");
    return false;
  }
  
  private boolean a(List paramList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        Object localObject = (k)paramList.next();
        if ("Ipv6".equals(paramString3)) {}
        for (int i1 = 2;; i1 = 1)
        {
          localObject = com.tencent.mobileqq.msf.core.d.a((k)localObject, paramString2, i1);
          if ((localObject == null) || (!((com.tencent.mobileqq.msf.core.d)localObject).k())) {
            break;
          }
          if ("Quic".equals(paramString1)) {
            ((com.tencent.mobileqq.msf.core.d)localObject).b("quic");
          }
          localArrayList.add(localObject);
          break;
        }
      }
    }
    return a(c.a.a(paramString1, paramString2, paramString3), paramString4, localArrayList, true, paramString5);
  }
  
  private ArrayList b(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject;
      try
      {
        localArrayList = new ArrayList();
        if (TextUtils.isEmpty(paramString)) {
          break label189;
        }
        paramString = paramString.split(";");
        int i2 = paramString.length;
        if (i1 >= i2) {
          break label189;
        }
        localObject = paramString[i1];
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label194;
        }
        localObject = com.tencent.mobileqq.msf.core.d.a((String)localObject);
        if ((localObject != null) && (((com.tencent.mobileqq.msf.core.d)localObject).k()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.SsoListManager", 2, "add valid endpoint=" + ((com.tencent.mobileqq.msf.core.d)localObject).toString());
          }
          ((com.tencent.mobileqq.msf.core.d)localObject).a(false);
          localArrayList.add(localObject);
        }
        else if (localObject == null)
        {
          if (!QLog.isColorLevel()) {
            break label194;
          }
          QLog.d("MSF.C.SsoListManager", 2, "found invalid endpoint: null");
        }
      }
      finally {}
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.SsoListManager", 2, "found invalid endpoint: " + ((com.tencent.mobileqq.msf.core.d)localObject).toString());
        break label194;
        label189:
        return localArrayList;
      }
      label194:
      i1 += 1;
    }
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, com.tencent.msf.service.protocol.serverconfig.f paramf)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), "ConfigPushSvc.PushResp");
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setServantName("QQService.ConfigPushSvc.MainServant");
    localUniPacket.setFuncName("PushResp");
    g localg = new g();
    localg.b = paramf.c;
    localg.a = paramf.a;
    if (paramf.a == 3) {
      localg.c = paramf.b;
    }
    localUniPacket.put("PushResp", localg);
    localToServiceMsg.putWupBuffer(localUniPacket.encode());
    localToServiceMsg.setAppId(this.n.getMsfAppid());
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
    try
    {
      this.n.sendSsoMsg(localToServiceMsg);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("MSF.C.SsoListManager", 2, "send push sso resp error " + paramFromServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    c.a locala = c.a.a("Socket", "Mobile", "Ipv4");
    String str = locala.a() + paramString;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = "__loginSdk_ssoMobilelist";
      a(locala, str, (String)localObject, paramBoolean);
      locala = c.a.a("Http", "Mobile", "Ipv4");
      str = locala.a() + paramString;
      if (!TextUtils.isEmpty(paramString)) {
        break label379;
      }
    }
    label379:
    for (Object localObject = "__loginSdk_ssoHttpMobilelist";; localObject = "__loginSdk_ssoHttpMobilelist_" + paramString)
    {
      a(locala, str, (String)localObject, paramBoolean);
      localObject = c.a.a("Quic", "Mobile", "Ipv4");
      a((c.a)localObject, ((c.a)localObject).a() + paramString, "__loginSdk_ssoQuicHttpList", paramBoolean);
      localObject = c.a.a("Socket", "Mobile", "Ipv6");
      boolean bool = this.A;
      this.A = (a((c.a)localObject, ((c.a)localObject).a() + paramString, null, paramBoolean) | bool);
      localObject = c.a.a("Http", "Mobile", "Ipv6");
      bool = this.A;
      this.A = (a((c.a)localObject, ((c.a)localObject).a() + paramString, null, paramBoolean) | bool);
      localObject = c.a.a("Quic", "Mobile", "Ipv6");
      bool = this.A;
      this.A = (a((c.a)localObject, ((c.a)localObject).a() + paramString, null, paramBoolean) | bool);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.SsoListManager", 2, "loadMobileSsoListMapFromStore mCurSsoListMap=" + this.N.size());
      }
      return;
      localObject = "__loginSdk_ssoMobilelist_" + paramString;
      break;
    }
  }
  
  private boolean b(List paramList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        Object localObject = (i)paramList.next();
        if ("Ipv6".equals(paramString3)) {}
        for (int i1 = 2;; i1 = 1)
        {
          localObject = com.tencent.mobileqq.msf.core.d.a((i)localObject, paramString2, i1);
          if ((localObject == null) || (!((com.tencent.mobileqq.msf.core.d)localObject).k())) {
            break;
          }
          if ("Quic".equals(paramString1)) {
            ((com.tencent.mobileqq.msf.core.d)localObject).b("quic");
          }
          localArrayList.add(localObject);
          break;
        }
      }
    }
    return a(c.a.a(paramString1, paramString2, paramString3), paramString4, localArrayList, false, paramString5);
  }
  
  private void h()
  {
    int i1 = 1;
    this.M.clear();
    Object localObject = t.e();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.SsoListManager", 2, "getIMSI " + (String)localObject);
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = null;
    if (localObject == null)
    {
      if (i1 == 0) {
        break label520;
      }
      localCopyOnWriteArrayList = a(C);
    }
    label520:
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.SsoListManager", 2, "init default mobile sso list result:");
        localObject = localCopyOnWriteArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            QLog.d("MSF.C.SsoListManager", 2, ((com.tencent.mobileqq.msf.core.d)((Iterator)localObject).next()).a());
            continue;
            if ((((String)localObject).startsWith("460")) || (((String)localObject).startsWith("461")))
            {
              if ((((String)localObject).startsWith("46000")) || (((String)localObject).startsWith("46002")) || (((String)localObject).startsWith("46007")))
              {
                localCopyOnWriteArrayList = a(D);
                i1 = 0;
                break;
              }
              if (((String)localObject).startsWith("46001"))
              {
                localCopyOnWriteArrayList = a(E);
                i1 = 0;
                break;
              }
              if (!((String)localObject).startsWith("46003")) {
                break;
              }
              localCopyOnWriteArrayList = a(F);
              i1 = 0;
              break;
            }
            localCopyOnWriteArrayList = a(G);
            i1 = 0;
            break;
          }
        }
      }
      this.M.put(c.a.a("Socket", "Mobile", "Ipv4"), localCopyOnWriteArrayList);
      localCopyOnWriteArrayList = a(H);
      this.M.put(c.a.a("Socket", "Wifi", "Ipv4"), localCopyOnWriteArrayList);
      localCopyOnWriteArrayList = a(I);
      this.M.put(c.a.a("Http", "Mobile", "Ipv4"), localCopyOnWriteArrayList);
      this.M.put(c.a.a("Http", "Wifi", "Ipv4"), localCopyOnWriteArrayList);
      localCopyOnWriteArrayList = a(J);
      this.M.put(c.a.a("Quic", "Mobile", "Ipv4"), localCopyOnWriteArrayList);
      this.M.put(c.a.a("Quic", "Wifi", "Ipv4"), localCopyOnWriteArrayList);
      localCopyOnWriteArrayList = a(K);
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.SsoListManager", 2, "init default mobile WIFI sso list result: ");
        localObject = localCopyOnWriteArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("MSF.C.SsoListManager", 2, ((com.tencent.mobileqq.msf.core.d)((Iterator)localObject).next()).a());
        }
      }
      this.M.put(c.a.a("Socket", "Wifi", "Ipv6"), localCopyOnWriteArrayList);
      localCopyOnWriteArrayList = a(L);
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.SsoListManager", 2, "init default mobile IPV6 sso list result: ");
        localObject = localCopyOnWriteArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("MSF.C.SsoListManager", 2, ((com.tencent.mobileqq.msf.core.d)((Iterator)localObject).next()).a());
        }
      }
      this.M.put(c.a.a("Socket", "Mobile", "Ipv6"), localCopyOnWriteArrayList);
      return;
    }
  }
  
  private void i()
  {
    try
    {
      this.A = false;
      String str1 = NetConnInfoCenter.getCurrentSSID(true);
      if (!TextUtils.isEmpty(str1)) {
        a(str1, false);
      }
      String str2 = NetConnInfoCenter.getCurrentAPN(true);
      if (!TextUtils.isEmpty(str2)) {
        b(str2, false);
      }
      QLog.d("MSF.C.SsoListManager", 2, "loadAllSsoListMapFromStore strSSID = " + str1 + ", strApn" + str2);
      return;
    }
    finally {}
  }
  
  private void j()
  {
    int i1 = 0;
    try
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("wifiused", 0);
      int i2 = localSharedPreferences.getInt("wifiUsedCount", 0);
      while (i1 < i2)
      {
        String str = localSharedPreferences.getString("wifiname" + i1, "");
        long l1 = localSharedPreferences.getLong("wifitime" + i1, 0L);
        if ((!TextUtils.isEmpty(str)) && (l1 > 0L))
        {
          this.O.put(str, Long.valueOf(l1));
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.SsoListManager", 2, "get a ssid " + str + " time = " + l1);
          }
        }
        i1 += 1;
      }
      return;
    }
    finally {}
  }
  
  public long a(String paramString1, String paramString2)
  {
    long l2 = 0L;
    String str;
    long l1;
    if (NetConnInfoCenter.isWifiConn())
    {
      str = NetConnInfoCenter.getCurrentSSID();
      l1 = l2;
      if (TextUtils.isEmpty(str)) {}
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(MsfStore.getNativeConfigStore().getConfig("DualConnTime" + c.a.a(paramString1, "Wifi", paramString2) + str));
        return l1;
      }
      catch (NumberFormatException paramString1) {}
      l1 = l2;
      if (NetConnInfoCenter.isMobileConn())
      {
        str = NetConnInfoCenter.getCurrentAPN();
        l1 = l2;
        if (!TextUtils.isEmpty(str)) {
          try
          {
            l1 = Long.parseLong(MsfStore.getNativeConfigStore().getConfig("DualConnTime" + c.a.a(paramString1, "Mobile", paramString2) + str));
            return l1;
          }
          catch (NumberFormatException paramString1)
          {
            return 0L;
          }
        }
      }
    }
    return 0L;
  }
  
  public CopyOnWriteArrayList a(c.a parama, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(" getAvailableSsoList ssoTypeKey = ").append(parama).append(", curr size ");
    if (this.N.get(parama) == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(((CopyOnWriteArrayList)this.N.get(parama)).size()))
    {
      QLog.d("MSF.C.SsoListManager", 1, localObject);
      if ((this.N.containsKey(parama)) && (this.N.get(parama) != null) && (((CopyOnWriteArrayList)this.N.get(parama)).size() > 0)) {
        break label133;
      }
      if (!paramBoolean) {
        break;
      }
      return (CopyOnWriteArrayList)this.M.get(parama);
    }
    return null;
    label133:
    return (CopyOnWriteArrayList)this.N.get(parama);
  }
  
  public void a()
  {
    h();
    j();
    i();
    a(NetConnInfoCenter.getCurrentSSID());
    a.a(a.j);
  }
  
  public void a(int paramInt, String paramString1, long paramLong, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    paramString1 = new f(this, paramBoolean2, paramString1, paramInt, paramLong, paramBoolean1, paramString2);
    paramString1.setName("checkSsoByHttpThread");
    paramString1.start();
  }
  
  public void a(com.tencent.mobileqq.msf.core.d paramd)
  {
    for (;;)
    {
      try
      {
        if (NetConnInfoCenter.isWifiConn())
        {
          if (!a(paramd, c.a.a("Socket", "Wifi", "Ipv4"))) {
            a(paramd, c.a.a("Socket", "Mobile", "Ipv4"));
          }
          return;
        }
        if (NetConnInfoCenter.isMobileConn())
        {
          if (a(paramd, c.a.a("Socket", "Mobile", "Ipv4"))) {
            continue;
          }
          a(paramd, c.a.a("Socket", "Wifi", "Ipv4"));
          continue;
        }
        a(paramd, c.a.a("Socket", "Wifi", "Ipv4"));
      }
      finally {}
      a(paramd, c.a.a("Socket", "Mobile", "Ipv4"));
    }
  }
  
  public void a(com.tencent.msf.service.protocol.serverconfig.f paramf)
  {
    if ((paramf.b == null) || (paramf.b.length <= 0)) {
      return;
    }
    Object localObject = new JceInputStream(paramf.b);
    paramf = new j();
    paramf.readFrom((JceInputStream)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.SsoListManager", 2, "recv ssoList Push nettype=" + paramf.m + ", he_threshold=" + paramf.n + ", policy_id=" + paramf.o);
    }
    boolean bool1;
    boolean bool2;
    if (NetConnInfoCenter.isWifiConn())
    {
      localObject = NetConnInfoCenter.getCurrentSSID();
      a(paramf.b, "Socket", "Wifi", "Ipv4", (String)localObject, paramf.o);
      a(paramf.h, "Http", "Wifi", "Ipv4", (String)localObject, paramf.o);
      a(paramf.i, "Quic", "Wifi", "Ipv4", (String)localObject, paramf.o);
      if ((paramf.m & 0x1) != 1) {
        break label492;
      }
      bool1 = a(paramf.j, "Socket", "Wifi", "Ipv6", (String)localObject, paramf.o);
      bool2 = a(paramf.k, "Http", "Wifi", "Ipv6", (String)localObject, paramf.o);
      bool1 = a(paramf.l, "Quic", "Wifi", "Ipv6", (String)localObject, paramf.o) | false | bool1 | bool2;
    }
    for (;;)
    {
      label257:
      this.A = bool1;
      localObject = this.n.delayIpRace;
      if ((paramf.n >= -1000) && (paramf.n <= 1000)) {}
      for (long l1 = paramf.n;; l1 = 100L)
      {
        ((AtomicLong)localObject).set(l1);
        if (paramf.c != 1) {
          break;
        }
        QLog.w("MSF.C.SsoListManager", 1, "set sso reconnect is true.");
        this.n.isReconnectSso.set(true);
        return;
        localObject = NetConnInfoCenter.getCurrentAPN();
        a(paramf.a, "Socket", "Mobile", "Ipv4", (String)localObject, paramf.o);
        a(paramf.g, "Http", "Mobile", "Ipv4", (String)localObject, paramf.o);
        a(paramf.i, "Quic", "Mobile", "Ipv4", (String)localObject, paramf.o);
        if ((paramf.m & 0x2) != 2) {
          break label492;
        }
        bool1 = a(paramf.j, "Socket", "Mobile", "Ipv6", (String)localObject, paramf.o);
        bool2 = a(paramf.k, "Http", "Mobile", "Ipv6", (String)localObject, paramf.o);
        bool1 = a(paramf.l, "Quic", "Mobile", "Ipv6", (String)localObject, paramf.o) | false | bool1 | bool2;
        break label257;
      }
      label492:
      bool1 = false;
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    for (;;)
    {
      try
      {
        localObject = new UniPacket(true);
        ((UniPacket)localObject).setEncodeName("utf-8");
        ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
        localObject = (com.tencent.msf.service.protocol.serverconfig.f)((UniPacket)localObject).getByClass("PushReq", new com.tencent.msf.service.protocol.serverconfig.f());
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SsoListManager", 2, "onRecvSsoPush req.type: " + ((com.tencent.msf.service.protocol.serverconfig.f)localObject).a);
        }
        if (((com.tencent.msf.service.protocol.serverconfig.f)localObject).a != 1) {
          continue;
        }
        a((com.tencent.msf.service.protocol.serverconfig.f)localObject);
      }
      catch (Exception paramFromServiceMsg)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("MSF.C.SsoListManager", 2, "onRecvSsoPush error " + paramFromServiceMsg, paramFromServiceMsg);
        return;
        if (((com.tencent.msf.service.protocol.serverconfig.f)localObject).a != 3) {
          continue;
        }
        a(paramFromServiceMsg, (com.tencent.msf.service.protocol.serverconfig.f)localObject);
        continue;
      }
      b(paramFromServiceMsg, (com.tencent.msf.service.protocol.serverconfig.f)localObject);
      return;
      if (((com.tencent.msf.service.protocol.serverconfig.f)localObject).a != 2) {
        continue;
      }
      MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
      paramFromServiceMsg.setMsfCommand(MsfCommand.onRecvConfigPush);
      this.n.addRespToQuque(null, paramFromServiceMsg);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    String str1 = a(this.n.sender.b.d(paramInt).j());
    String str2;
    if (!TextUtils.isEmpty(str1))
    {
      if (!NetConnInfoCenter.isWifiConn()) {
        break label91;
      }
      str2 = NetConnInfoCenter.getCurrentSSID();
      if (!TextUtils.isEmpty(str2)) {
        MsfStore.getNativeConfigStore().n_setConfig("DualConnTime" + c.a.a(paramString, "Wifi", str1) + str2, String.valueOf(paramLong));
      }
    }
    label91:
    do
    {
      do
      {
        return;
      } while (!NetConnInfoCenter.isMobileConn());
      str2 = NetConnInfoCenter.getCurrentAPN();
    } while (TextUtils.isEmpty(str2));
    MsfStore.getNativeConfigStore().n_setConfig("DualConnTime" + c.a.a(paramString, "Mobile", str1) + str2, String.valueOf(paramLong));
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 795	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCurrentAPN	()Ljava/lang/String;
    //   5: astore_2
    //   6: aload_2
    //   7: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_2
    //   20: iconst_1
    //   21: invokespecial 758	com/tencent/mobileqq/msf/core/a/c:b	(Ljava/lang/String;Z)V
    //   24: goto -9 -> 15
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	c
    //   10	2	1	bool	boolean
    //   5	15	2	str	String
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	27	finally
    //   18	24	27	finally
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 786	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCurrentSSID	()Ljava/lang/String;
    //   5: astore_2
    //   6: aload_2
    //   7: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_2
    //   20: iconst_1
    //   21: invokespecial 753	com/tencent/mobileqq/msf/core/a/c:a	(Ljava/lang/String;Z)V
    //   24: aload_0
    //   25: aload_2
    //   26: invokespecial 808	com/tencent/mobileqq/msf/core/a/c:a	(Ljava/lang/String;)V
    //   29: goto -14 -> 15
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	c
    //   10	2	1	bool	boolean
    //   5	21	2	str	String
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	32	finally
    //   18	29	32	finally
  }
  
  public boolean d()
  {
    return this.A;
  }
  
  public void e()
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, "Socket", "Mobile", "Ipv6", "", "");
    a(localArrayList, "Http", "Mobile", "Ipv6", "", "");
    a(localArrayList, "Quic", "Mobile", "Ipv6", "", "");
    a(localArrayList, "Socket", "Wifi", "Ipv6", "", "");
    a(localArrayList, "Http", "Wifi", "Ipv6", "", "");
    a(localArrayList, "Quic", "Wifi", "Ipv6", "", "");
  }
  
  public String f()
  {
    Object localObject2 = null;
    com.tencent.mobileqq.msf.core.d locald = this.n.sender.b.l().b();
    Object localObject1 = localObject2;
    String str1;
    String str2;
    if (locald != null)
    {
      str1 = a(locald.d());
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str1))
      {
        if (!NetConnInfoCenter.isWifiConn()) {
          break label108;
        }
        str2 = NetConnInfoCenter.getCurrentSSID();
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str2)) {
          localObject1 = MsfStore.getNativeConfigStore().getConfig("policyId" + c.a.a(locald.b(), "Wifi", str1) + str2);
        }
      }
    }
    label108:
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (!NetConnInfoCenter.isMobileConn());
      str2 = NetConnInfoCenter.getCurrentAPN();
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(str2));
    return MsfStore.getNativeConfigStore().getConfig("policyId" + c.a.a(locald.b(), "Mobile", str1) + str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.c
 * JD-Core Version:    0.7.0.1
 */