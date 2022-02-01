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
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.o;
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
import com.tencent.qphone.base.util.log.a.a;
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

public class c
{
  private static final String B = "https://configsvr.sparta.html5.qq.com/configsvr/";
  private static final byte[] C = { -16, 68, 31, 95, -12, 45, -91, -113, -36, -9, -108, -102, -70, 98, -44, 17 };
  private static final String[] D = { "socket://msfxg.3g.qq.com:8080#46000_46002_46007_46001_46003:0:1", "socket://113.96.12.224:80#46003:0:1", "socket://183.232.94.44:14000#46000_46002_46007:0:1", "socket://120.232.18.27:8080#46000_46002_46007:0:1", "socket://157.255.13.77:443#46001:0:1", "socket://203.205.255.224:8080#46000_46002_46007_46001_46003:0:1" };
  private static final String[] E = { "socket://120.232.18.27:14000#46000_46002_46007:0:1", "socket://msfxg.3g.qq.com:80#46000_46002_46007:0:1", "socket://111.30.178.75:443#46000_46002_46007:0:1", "socket://36.155.240.38:8080#46000_46002_46007:0:1", "socket://183.232.94.44:8080#46000_46002_46007:0:1", "socket://111.30.138.152:443#46000_46002_46007:0:1", "socket://117.144.244.33:443#46000_46002_46007:0:1", "socket://111.30.138.152:443#46000_46002_46007:0:1" };
  private static final String[] F = { "socket://163.177.89.195:14000#46001:0:1", "socket://msfxg.3g.qq.com:80#46001:0:1", "socket://157.255.13.77:8080#46001:0:1", "socket://221.198.69.96:8080#46001:0:1", "socket://153.3.149.61:14000#46001:0:1", "socket://111.206.25.142:443#46001:0:1", "socket://153.3.50.58:8080#46001:0:1" };
  private static final String[] G = { "socket://113.96.12.224:14000#46003:0:1", "socket://msfxg.3g.qq.com:80#46003:0:1", "socket://183.3.235.162:443#46003:0:1", "socket://42.81.169.100:8080#46003:0:1", "socket://114.221.144.89:443#46003:0:1", "socket://123.150.76.143:80#46003:0:1", "socket://61.129.6.101:14000#46003:0:1" };
  private static final String[] H = { "socket://203.205.255.224:443#46000_46002_46007_46001_46003:0:1", "socket://msfxg.3g.qq.com:80#46000_46002_46007_46001_46003:0:1", "socket://203.205.255.221:443#46000_46002_46007_46001_46003:0:1", "socket://183.3.235.162:8080#46000_46002_46007_46001_46003:0:1", "socket://163.177.89.195:8080#46000_46002_46007_46001_46003:0:1", "socket://183.232.94.44:443#46000_46002_46007_46001_46003:0:1" };
  private static final String[] I = { "socket://msfwifi.3g.qq.com:8080#00000:0:1", "socket://14.215.138.110:8080#00000:0:1", "socket://113.96.12.224:8080#00000:0:1", "socket://157.255.13.77:14000#00000:0:1", "socket://120.232.18.27:443#00000:0:1", "socket://183.3.235.162:14000#00000:0:1", "socket://163.177.89.195:443#00000:0:1", "socket://183.232.94.44:80#00000:0:1", "socket://203.205.255.224:8080#00000:0:1", "socket://203.205.255.221:8080#00000:0:1" };
  private static final String[] J = { "https://msfhttp.3g.qq.com:80#00000:0:1" };
  private static final String[] K = { "quic://58.251.106.174:443#00000:0:1" };
  private static final String[] L = { "socket://msfwifiv6.3g.qq.com:8080#00000:0:1", "socket://[240e:ff:f101:10::109]:14000" };
  private static final String[] M = { "socket://msfxgv6.3g.qq.com:8080#00000:0:1", "socket://[240e:ff:f101:10::109]:14000" };
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
  private ConcurrentHashMap N = new ConcurrentHashMap();
  private ConcurrentHashMap O = new ConcurrentHashMap();
  private ConcurrentHashMap P = new ConcurrentHashMap();
  private LinkedBlockingDeque Q = new LinkedBlockingDeque(1000);
  private Handler R = null;
  private Thread S = null;
  MsfCore n;
  
  public c(MsfCore paramMsfCore)
  {
    this.n = paramMsfCore;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
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
    if (this.R == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("logUploadHandle");
      localHandlerThread.start();
      this.R = new Handler(localHandlerThread.getLooper());
    }
    this.R.post(new d(this, paramf, paramFromServiceMsg));
  }
  
  private void a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      long l1;
      Object localObject2;
      Object localObject3;
      if (this.P.containsKey(paramString))
      {
        l1 = System.currentTimeMillis();
        this.P.put(paramString, Long.valueOf(l1));
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("find ssid: ");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(" update time = ");
          ((StringBuilder)localObject1).append(l1);
          QLog.d("MSF.C.SsoListManager", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        if (this.P.size() >= 10)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.SsoListManager", 2, "too much ssid need to delete one find Least Recently Used now...");
          }
          l1 = System.currentTimeMillis();
          localObject1 = null;
          localObject2 = this.P.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              long l2 = ((Long)((Map.Entry)localObject3).getValue()).longValue();
              if (l2 < l1)
              {
                localObject1 = (String)((Map.Entry)localObject3).getKey();
                l1 = l2;
              }
            }
          }
          if (localObject1 != null)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Least Recently Used ssid find delete now: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("MSF.C.SsoListManager", 2, ((StringBuilder)localObject2).toString());
            }
            this.P.remove(localObject1);
            localObject2 = MsfStore.getNativeConfigStore();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("__loginSdk_ssoWifilist_");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((NativeConfigStore)localObject2).n_removeConfig(((StringBuilder)localObject3).toString());
            localObject2 = MsfStore.getNativeConfigStore();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(c.a.a("Socket", "Wifi", "Ipv4").a());
            ((StringBuilder)localObject3).append((String)localObject1);
            ((NativeConfigStore)localObject2).n_removeConfig(((StringBuilder)localObject3).toString());
            localObject2 = MsfStore.getNativeConfigStore();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(c.a.a("Http", "Wifi", "Ipv4").a());
            ((StringBuilder)localObject3).append((String)localObject1);
            ((NativeConfigStore)localObject2).n_removeConfig(((StringBuilder)localObject3).toString());
            localObject2 = MsfStore.getNativeConfigStore();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(c.a.a("Quic", "Wifi", "Ipv4").a());
            ((StringBuilder)localObject3).append((String)localObject1);
            ((NativeConfigStore)localObject2).n_removeConfig(((StringBuilder)localObject3).toString());
            localObject2 = MsfStore.getNativeConfigStore();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(c.a.a("Socket", "Wifi", "Ipv6").a());
            ((StringBuilder)localObject3).append((String)localObject1);
            ((NativeConfigStore)localObject2).n_removeConfig(((StringBuilder)localObject3).toString());
            localObject2 = MsfStore.getNativeConfigStore();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(c.a.a("Http", "Wifi", "Ipv6").a());
            ((StringBuilder)localObject3).append((String)localObject1);
            ((NativeConfigStore)localObject2).n_removeConfig(((StringBuilder)localObject3).toString());
            localObject2 = MsfStore.getNativeConfigStore();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(c.a.a("Quic", "Wifi", "Ipv6").a());
            ((StringBuilder)localObject3).append((String)localObject1);
            ((NativeConfigStore)localObject2).n_removeConfig(((StringBuilder)localObject3).toString());
          }
        }
        this.P.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      paramString = BaseApplication.getContext();
      int i1 = 0;
      paramString = paramString.getSharedPreferences("wifiused", 0).edit();
      paramString.putInt("wifiUsedCount", this.P.size());
      Object localObject1 = this.P.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          l1 = ((Long)((Map.Entry)localObject2).getValue()).longValue();
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("wifiname");
            ((StringBuilder)localObject3).append(i1);
            paramString.putString(((StringBuilder)localObject3).toString(), (String)localObject2);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("wifitime");
            ((StringBuilder)localObject2).append(i1);
            paramString.putLong(((StringBuilder)localObject2).toString(), l1);
            i1 += 1;
          }
        }
      }
      paramString.commit();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject2 = c.a.a("Socket", "Wifi", "Ipv4");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((c.a)localObject2).a());
    ((StringBuilder)localObject1).append(paramString);
    String str = ((StringBuilder)localObject1).toString();
    if (TextUtils.isEmpty(paramString))
    {
      localObject1 = "__loginSdk_ssoWifilist";
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("__loginSdk_ssoWifilist_");
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    a((c.a)localObject2, str, (String)localObject1, paramBoolean);
    localObject1 = c.a.a("Http", "Wifi", "Ipv4");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((c.a)localObject1).a());
    ((StringBuilder)localObject2).append(paramString);
    a((c.a)localObject1, ((StringBuilder)localObject2).toString(), "__loginSdk_ssoHttpWifilist", paramBoolean);
    localObject1 = c.a.a("Quic", "Wifi", "Ipv4");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((c.a)localObject1).a());
    ((StringBuilder)localObject2).append(paramString);
    a((c.a)localObject1, ((StringBuilder)localObject2).toString(), "__loginSdk_ssoQuicHttpList", paramBoolean);
    localObject1 = c.a.a("Socket", "Wifi", "Ipv6");
    boolean bool = this.A;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((c.a)localObject1).a());
    ((StringBuilder)localObject2).append(paramString);
    this.A = (a((c.a)localObject1, ((StringBuilder)localObject2).toString(), null, paramBoolean) | bool);
    localObject1 = c.a.a("Http", "Wifi", "Ipv6");
    bool = this.A;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((c.a)localObject1).a());
    ((StringBuilder)localObject2).append(paramString);
    this.A = (a((c.a)localObject1, ((StringBuilder)localObject2).toString(), null, paramBoolean) | bool);
    localObject1 = c.a.a("Quic", "Wifi", "Ipv6");
    bool = this.A;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((c.a)localObject1).a());
    ((StringBuilder)localObject2).append(paramString);
    this.A = (a((c.a)localObject1, ((StringBuilder)localObject2).toString(), null, paramBoolean) | bool);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("loadWifiSsoListMapFromStore mCurSsoListMap=");
      paramString.append(this.O.size());
      QLog.d("MSF.C.SsoListManager", 2, paramString.toString());
    }
  }
  
  private boolean a(c.a parama, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = MsfStore.getNativeConfigStore().getConfig(paramString1);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadSsoListMapFromStore ssoTypeKey=");
      ((StringBuilder)localObject2).append(parama);
      ((StringBuilder)localObject2).append(", storeKey=");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", oldStoreKey=");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(", isChange=");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d("MSF.C.SsoListManager", 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1);
    boolean bool2 = false;
    if (bool1)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = MsfStore.getNativeConfigStore().getConfig(paramString2);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("loadSsoListMapFromStore oldSsoListStr=");
          ((StringBuilder)localObject1).append(paramString2);
          QLog.d("MSF.C.SsoListManager", 2, ((StringBuilder)localObject1).toString());
        }
        paramString2 = b(paramString2);
      }
      else
      {
        paramString2 = null;
      }
      localObject1 = paramString2;
      bool1 = paramBoolean;
      if (paramBoolean)
      {
        localObject1 = paramString2;
        bool1 = paramBoolean;
        if (this.N.get(parama) != null)
        {
          localObject1 = paramString2;
          bool1 = paramBoolean;
          if (((CopyOnWriteArrayList)this.N.get(parama)).size() > 0)
          {
            localObject2 = paramString2;
            if (paramString2 == null) {
              localObject2 = new ArrayList();
            }
            localObject1 = localObject2;
            bool1 = paramBoolean;
            if (((ArrayList)localObject2).isEmpty())
            {
              ((ArrayList)localObject2).addAll((Collection)this.N.get(parama));
              localObject1 = localObject2;
              bool1 = paramBoolean;
            }
          }
        }
      }
    }
    else
    {
      localObject1 = b((String)localObject1);
      bool1 = false;
    }
    paramBoolean = bool2;
    if (localObject1 != null)
    {
      paramBoolean = bool2;
      if (!((ArrayList)localObject1).isEmpty())
      {
        this.O.put(parama, new CopyOnWriteArrayList((Collection)localObject1));
        paramBoolean = true;
      }
    }
    if (bool1)
    {
      parama = new StringBuffer();
      if (localObject1 != null)
      {
        paramString2 = ((ArrayList)localObject1).iterator();
        while (paramString2.hasNext())
        {
          localObject1 = (com.tencent.mobileqq.msf.core.d)paramString2.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((com.tencent.mobileqq.msf.core.d)localObject1).toString());
          ((StringBuilder)localObject2).append(";");
          parama.append(((StringBuilder)localObject2).toString());
        }
      }
      MsfStore.getNativeConfigStore().n_setConfig(paramString1, parama.toString());
    }
    return paramBoolean;
  }
  
  private boolean a(c.a parama, String paramString1, ArrayList paramArrayList, boolean paramBoolean, String paramString2)
  {
    try
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateSsoListAndStore ssoTypeKey=");
        ((StringBuilder)localObject2).append(parama.toString());
        ((StringBuilder)localObject2).append(", keyPostfix=");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(", ssoList size=");
        if (paramArrayList == null) {
          localObject1 = "null";
        } else {
          localObject1 = Integer.valueOf(paramArrayList.size());
        }
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(", isPush=");
        ((StringBuilder)localObject2).append(paramBoolean);
        QLog.d("MSF.C.SsoListManager", 2, ((StringBuilder)localObject2).toString());
      }
      boolean bool1;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.O.put(parama, new CopyOnWriteArrayList(paramArrayList));
        bool1 = true;
      }
      else
      {
        this.O.remove(parama);
        bool1 = false;
      }
      boolean bool2 = TextUtils.isEmpty(paramString1);
      if (bool2) {
        return bool1;
      }
      Object localObject1 = new StringBuffer();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (com.tencent.mobileqq.msf.core.d)paramArrayList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((com.tencent.mobileqq.msf.core.d)localObject2).toString());
        localStringBuilder.append(";");
        ((StringBuffer)localObject1).append(localStringBuilder.toString());
      }
      paramArrayList = new StringBuilder();
      paramArrayList.append(parama.a());
      paramArrayList.append(paramString1);
      paramString1 = paramArrayList.toString();
      MsfStore.getNativeConfigStore().n_setConfig(paramString1, ((StringBuffer)localObject1).toString());
      if (!TextUtils.isEmpty(paramString2))
      {
        paramArrayList = MsfStore.getNativeConfigStore();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("policyId");
        ((StringBuilder)localObject2).append(paramString1);
        paramArrayList.n_setConfig(((StringBuilder)localObject2).toString(), paramString2);
      }
      if (QLog.isColorLevel()) {
        if (paramBoolean)
        {
          paramString1 = new StringBuilder();
          paramString1.append("save push sso for ");
          paramString1.append(parama.toString());
          paramString1.append(" ");
          paramString1.append(((StringBuffer)localObject1).toString());
          QLog.d("MSF.C.SsoListManager", 2, paramString1.toString());
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append("save http get sso for ");
          paramString1.append(parama.toString());
          paramString1.append(" ");
          paramString1.append(((StringBuffer)localObject1).toString());
          QLog.d("MSF.C.SsoListManager", 2, paramString1.toString());
        }
      }
      return bool1;
    }
    finally {}
    for (;;)
    {
      throw parama;
    }
  }
  
  private boolean a(com.tencent.mobileqq.msf.core.d paramd, c.a parama)
  {
    parama = (CopyOnWriteArrayList)this.O.get(parama);
    if ((parama != null) && (parama.remove(paramd)))
    {
      parama.add(paramd);
      parama = new StringBuilder();
      parama.append(" set ");
      parama.append(paramd);
      parama.append(" at ssoList last.");
      QLog.d("MSF.C.SsoListManager", 1, parama.toString());
      return true;
    }
    parama = new StringBuilder();
    parama.append(" not found ");
    parama.append(paramd);
    parama.append(" at ssoList.");
    QLog.d("MSF.C.SsoListManager", 1, parama.toString());
    return false;
  }
  
  private boolean a(List paramList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (k)paramList.next();
        int i1;
        if ("Ipv6".equals(paramString3)) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        localObject = com.tencent.mobileqq.msf.core.d.a((k)localObject, paramString2, i1);
        if ((localObject != null) && (((com.tencent.mobileqq.msf.core.d)localObject).k()))
        {
          if ("Quic".equals(paramString1)) {
            ((com.tencent.mobileqq.msf.core.d)localObject).b("quic");
          }
          localArrayList.add(localObject);
        }
      }
    }
    return a(c.a.a(paramString1, paramString2, paramString3), paramString4, localArrayList, true, paramString5);
  }
  
  private ArrayList b(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split(";");
        int i2 = paramString.length;
        int i1 = 0;
        while (i1 < i2)
        {
          Object localObject = paramString[i1];
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = com.tencent.mobileqq.msf.core.d.a((String)localObject);
            StringBuilder localStringBuilder;
            if ((localObject != null) && (((com.tencent.mobileqq.msf.core.d)localObject).k()))
            {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("add valid endpoint=");
                localStringBuilder.append(((com.tencent.mobileqq.msf.core.d)localObject).toString());
                QLog.d("MSF.C.SsoListManager", 2, localStringBuilder.toString());
              }
              ((com.tencent.mobileqq.msf.core.d)localObject).a(false);
              localArrayList.add(localObject);
            }
            else if (localObject == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.SsoListManager", 2, "found invalid endpoint: null");
              }
            }
            else if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("found invalid endpoint: ");
              localStringBuilder.append(((com.tencent.mobileqq.msf.core.d)localObject).toString());
              QLog.d("MSF.C.SsoListManager", 2, localStringBuilder.toString());
            }
          }
          i1 += 1;
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramString;
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
      if (QLog.isColorLevel())
      {
        paramf = new StringBuilder();
        paramf.append("send push sso resp error ");
        paramf.append(paramFromServiceMsg);
        QLog.i("MSF.C.SsoListManager", 2, paramf.toString(), paramFromServiceMsg);
      }
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    Object localObject2 = c.a.a("Socket", "Mobile", "Ipv4");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((c.a)localObject2).a());
    ((StringBuilder)localObject1).append(paramString);
    String str = ((StringBuilder)localObject1).toString();
    if (TextUtils.isEmpty(paramString))
    {
      localObject1 = "__loginSdk_ssoMobilelist";
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("__loginSdk_ssoMobilelist_");
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    a((c.a)localObject2, str, (String)localObject1, paramBoolean);
    localObject2 = c.a.a("Http", "Mobile", "Ipv4");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((c.a)localObject2).a());
    ((StringBuilder)localObject1).append(paramString);
    str = ((StringBuilder)localObject1).toString();
    if (TextUtils.isEmpty(paramString))
    {
      localObject1 = "__loginSdk_ssoHttpMobilelist";
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("__loginSdk_ssoHttpMobilelist_");
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    a((c.a)localObject2, str, (String)localObject1, paramBoolean);
    localObject1 = c.a.a("Quic", "Mobile", "Ipv4");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((c.a)localObject1).a());
    ((StringBuilder)localObject2).append(paramString);
    a((c.a)localObject1, ((StringBuilder)localObject2).toString(), "__loginSdk_ssoQuicHttpList", paramBoolean);
    localObject1 = c.a.a("Socket", "Mobile", "Ipv6");
    boolean bool = this.A;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((c.a)localObject1).a());
    ((StringBuilder)localObject2).append(paramString);
    this.A = (a((c.a)localObject1, ((StringBuilder)localObject2).toString(), null, paramBoolean) | bool);
    localObject1 = c.a.a("Http", "Mobile", "Ipv6");
    bool = this.A;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((c.a)localObject1).a());
    ((StringBuilder)localObject2).append(paramString);
    this.A = (a((c.a)localObject1, ((StringBuilder)localObject2).toString(), null, paramBoolean) | bool);
    localObject1 = c.a.a("Quic", "Mobile", "Ipv6");
    bool = this.A;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((c.a)localObject1).a());
    ((StringBuilder)localObject2).append(paramString);
    this.A = (a((c.a)localObject1, ((StringBuilder)localObject2).toString(), null, paramBoolean) | bool);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("loadMobileSsoListMapFromStore mCurSsoListMap=");
      paramString.append(this.O.size());
      QLog.d("MSF.C.SsoListManager", 2, paramString.toString());
    }
  }
  
  private boolean b(List paramList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (i)paramList.next();
        int i1;
        if ("Ipv6".equals(paramString3)) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        localObject = com.tencent.mobileqq.msf.core.d.a((i)localObject, paramString2, i1);
        if ((localObject != null) && (((com.tencent.mobileqq.msf.core.d)localObject).k()))
        {
          if ("Quic".equals(paramString1)) {
            ((com.tencent.mobileqq.msf.core.d)localObject).b("quic");
          }
          localArrayList.add(localObject);
        }
      }
    }
    return a(c.a.a(paramString1, paramString2, paramString3), paramString4, localArrayList, false, paramString5);
  }
  
  private void h()
  {
    this.N.clear();
    Object localObject2 = o.e();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getIMSI ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("MSF.C.SsoListManager", 2, ((StringBuilder)localObject1).toString());
    }
    int i1 = 0;
    Object localObject1 = null;
    if ((localObject2 != null) && (localObject2 != ""))
    {
      if ((!((String)localObject2).startsWith("460")) && (!((String)localObject2).startsWith("461")))
      {
        localObject1 = a(H);
        break label189;
      }
      if ((!((String)localObject2).startsWith("46000")) && (!((String)localObject2).startsWith("46002")) && (!((String)localObject2).startsWith("46007")))
      {
        if (((String)localObject2).startsWith("46001"))
        {
          localObject1 = a(F);
          break label189;
        }
        if (((String)localObject2).startsWith("46003"))
        {
          localObject1 = a(G);
          break label189;
        }
      }
      else
      {
        localObject1 = a(E);
        break label189;
      }
    }
    i1 = 1;
    label189:
    if (i1 != 0) {
      localObject1 = a(D);
    }
    if (QLog.isColorLevel())
    {
      QLog.d("MSF.C.SsoListManager", 2, "init default mobile sso list result:");
      localObject2 = ((CopyOnWriteArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        QLog.d("MSF.C.SsoListManager", 2, ((com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next()).a());
      }
    }
    this.N.put(c.a.a("Socket", "Mobile", "Ipv4"), localObject1);
    localObject1 = a(I);
    this.N.put(c.a.a("Socket", "Wifi", "Ipv4"), localObject1);
    localObject1 = a(J);
    this.N.put(c.a.a("Http", "Mobile", "Ipv4"), localObject1);
    this.N.put(c.a.a("Http", "Wifi", "Ipv4"), localObject1);
    localObject1 = a(K);
    this.N.put(c.a.a("Quic", "Mobile", "Ipv4"), localObject1);
    this.N.put(c.a.a("Quic", "Wifi", "Ipv4"), localObject1);
    localObject1 = a(L);
    if (QLog.isColorLevel())
    {
      QLog.d("MSF.C.SsoListManager", 2, "init default mobile WIFI sso list result: ");
      localObject2 = ((CopyOnWriteArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        QLog.d("MSF.C.SsoListManager", 2, ((com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next()).a());
      }
    }
    this.N.put(c.a.a("Socket", "Wifi", "Ipv6"), localObject1);
    localObject1 = a(M);
    if (QLog.isColorLevel())
    {
      QLog.d("MSF.C.SsoListManager", 2, "init default mobile IPV6 sso list result: ");
      localObject2 = ((CopyOnWriteArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        QLog.d("MSF.C.SsoListManager", 2, ((com.tencent.mobileqq.msf.core.d)((Iterator)localObject2).next()).a());
      }
    }
    this.N.put(c.a.a("Socket", "Mobile", "Ipv6"), localObject1);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadAllSsoListMapFromStore strSSID = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", strApn");
      localStringBuilder.append(str2);
      QLog.d("MSF.C.SsoListManager", 2, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  private void j()
  {
    try
    {
      Object localObject1 = BaseApplication.getContext();
      int i1 = 0;
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences("wifiused", 0);
      int i2 = ((SharedPreferences)localObject1).getInt("wifiUsedCount", 0);
      while (i1 < i2)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("wifiname");
        ((StringBuilder)localObject3).append(i1);
        localObject3 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject3).toString(), "");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("wifitime");
        localStringBuilder.append(i1);
        long l1 = ((SharedPreferences)localObject1).getLong(localStringBuilder.toString(), 0L);
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (l1 > 0L))
        {
          this.P.put(localObject3, Long.valueOf(l1));
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("get a ssid ");
            localStringBuilder.append((String)localObject3);
            localStringBuilder.append(" time = ");
            localStringBuilder.append(l1);
            QLog.d("MSF.C.SsoListManager", 2, localStringBuilder.toString());
          }
        }
        i1 += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public long a(String paramString1, String paramString2)
  {
    boolean bool = NetConnInfoCenter.isWifiConn();
    long l2 = 0L;
    String str;
    if (bool)
    {
      str = NetConnInfoCenter.getCurrentSSID();
      l1 = l2;
      if (TextUtils.isEmpty(str)) {
        break label174;
      }
    }
    NativeConfigStore localNativeConfigStore;
    StringBuilder localStringBuilder;
    try
    {
      localNativeConfigStore = MsfStore.getNativeConfigStore();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DualConnTime");
      localStringBuilder.append(c.a.a(paramString1, "Wifi", paramString2));
      localStringBuilder.append(str);
      l1 = Long.parseLong(localNativeConfigStore.getConfig(localStringBuilder.toString()));
      return l1;
    }
    catch (NumberFormatException paramString1) {}
    long l1 = l2;
    if (NetConnInfoCenter.isMobileConn())
    {
      str = NetConnInfoCenter.getCurrentAPN();
      l1 = l2;
      if (!TextUtils.isEmpty(str))
      {
        localNativeConfigStore = MsfStore.getNativeConfigStore();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DualConnTime");
        localStringBuilder.append(c.a.a(paramString1, "Mobile", paramString2));
        localStringBuilder.append(str);
        l1 = Long.parseLong(localNativeConfigStore.getConfig(localStringBuilder.toString()));
      }
    }
    label174:
    return l1;
    return 0L;
  }
  
  public CopyOnWriteArrayList a(c.a parama, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" getAvailableSsoList ssoTypeKey = ");
    localStringBuilder.append(parama);
    localStringBuilder.append(", curr size ");
    Object localObject;
    if (this.O.get(parama) == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(((CopyOnWriteArrayList)this.O.get(parama)).size());
    }
    localStringBuilder.append(localObject);
    QLog.d("MSF.C.SsoListManager", 1, localStringBuilder.toString());
    if ((this.O.containsKey(parama)) && (this.O.get(parama) != null) && (((CopyOnWriteArrayList)this.O.get(parama)).size() > 0)) {
      return (CopyOnWriteArrayList)this.O.get(parama);
    }
    if (paramBoolean) {
      return (CopyOnWriteArrayList)this.N.get(parama);
    }
    return null;
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
    try
    {
      if (NetConnInfoCenter.isWifiConn())
      {
        if (!a(paramd, c.a.a("Socket", "Wifi", "Ipv4"))) {
          a(paramd, c.a.a("Socket", "Mobile", "Ipv4"));
        }
      }
      else if (NetConnInfoCenter.isMobileConn())
      {
        if (!a(paramd, c.a.a("Socket", "Mobile", "Ipv4"))) {
          a(paramd, c.a.a("Socket", "Wifi", "Ipv4"));
        }
      }
      else
      {
        a(paramd, c.a.a("Socket", "Wifi", "Ipv4"));
        a(paramd, c.a.a("Socket", "Mobile", "Ipv4"));
      }
      return;
    }
    finally {}
  }
  
  public void a(com.tencent.msf.service.protocol.serverconfig.f paramf)
  {
    if (paramf.b != null)
    {
      if (paramf.b.length <= 0) {
        return;
      }
      boolean bool2 = false;
      Object localObject = new JceInputStream(paramf.b);
      paramf = new j();
      paramf.readFrom((JceInputStream)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recv ssoList Push nettype=");
        ((StringBuilder)localObject).append(paramf.m);
        ((StringBuilder)localObject).append(", he_threshold=");
        ((StringBuilder)localObject).append(paramf.n);
        ((StringBuilder)localObject).append(", policy_id=");
        ((StringBuilder)localObject).append(paramf.o);
        QLog.d("MSF.C.SsoListManager", 2, ((StringBuilder)localObject).toString());
      }
      boolean bool1;
      if (NetConnInfoCenter.isWifiConn())
      {
        localObject = NetConnInfoCenter.getCurrentSSID();
        a(paramf.b, "Socket", "Wifi", "Ipv4", (String)localObject, paramf.o);
        a(paramf.h, "Http", "Wifi", "Ipv4", (String)localObject, paramf.o);
        a(paramf.i, "Quic", "Wifi", "Ipv4", (String)localObject, paramf.o);
        if ((paramf.m & 0x1) != 1) {
          break label427;
        }
        bool1 = false | a(paramf.j, "Socket", "Wifi", "Ipv6", (String)localObject, paramf.o) | a(paramf.k, "Http", "Wifi", "Ipv6", (String)localObject, paramf.o);
        bool2 = a(paramf.l, "Quic", "Wifi", "Ipv6", (String)localObject, paramf.o);
      }
      else
      {
        localObject = NetConnInfoCenter.getCurrentAPN();
        a(paramf.a, "Socket", "Mobile", "Ipv4", (String)localObject, paramf.o);
        a(paramf.g, "Http", "Mobile", "Ipv4", (String)localObject, paramf.o);
        a(paramf.i, "Quic", "Mobile", "Ipv4", (String)localObject, paramf.o);
        if ((paramf.m & 0x2) != 2) {
          break label427;
        }
        bool1 = false | a(paramf.j, "Socket", "Mobile", "Ipv6", (String)localObject, paramf.o) | a(paramf.k, "Http", "Mobile", "Ipv6", (String)localObject, paramf.o);
        bool2 = a(paramf.l, "Quic", "Mobile", "Ipv6", (String)localObject, paramf.o);
      }
      bool2 = bool1 | bool2;
      label427:
      this.A = bool2;
      this.n.setDelayIpRace(paramf.n);
      if (paramf.c == 1)
      {
        QLog.w("MSF.C.SsoListManager", 1, "set sso reconnect is true.");
        this.n.isReconnectSso.set(true);
      }
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      localObject = new UniPacket(true);
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
      localObject = (com.tencent.msf.service.protocol.serverconfig.f)((UniPacket)localObject).getByClass("PushReq", new com.tencent.msf.service.protocol.serverconfig.f());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRecvSsoPush req.type: ");
        localStringBuilder.append(((com.tencent.msf.service.protocol.serverconfig.f)localObject).a);
        QLog.d("MSF.C.SsoListManager", 2, localStringBuilder.toString());
      }
      if (((com.tencent.msf.service.protocol.serverconfig.f)localObject).a == 1)
      {
        a((com.tencent.msf.service.protocol.serverconfig.f)localObject);
      }
      else if (((com.tencent.msf.service.protocol.serverconfig.f)localObject).a == 2)
      {
        MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
        paramFromServiceMsg.setMsfCommand(MsfCommand.onRecvConfigPush);
        this.n.addRespToQuque(null, paramFromServiceMsg);
      }
      else if (((com.tencent.msf.service.protocol.serverconfig.f)localObject).a == 3)
      {
        a(paramFromServiceMsg, (com.tencent.msf.service.protocol.serverconfig.f)localObject);
      }
      b(paramFromServiceMsg, (com.tencent.msf.service.protocol.serverconfig.f)localObject);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRecvSsoPush error ");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        QLog.i("MSF.C.SsoListManager", 2, ((StringBuilder)localObject).toString(), paramFromServiceMsg);
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    String str1 = a(this.n.sender.b.d(paramInt).j());
    if (!TextUtils.isEmpty(str1))
    {
      String str2;
      NativeConfigStore localNativeConfigStore;
      StringBuilder localStringBuilder;
      if (NetConnInfoCenter.isWifiConn())
      {
        str2 = NetConnInfoCenter.getCurrentSSID();
        if (!TextUtils.isEmpty(str2))
        {
          localNativeConfigStore = MsfStore.getNativeConfigStore();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DualConnTime");
          localStringBuilder.append(c.a.a(paramString, "Wifi", str1));
          localStringBuilder.append(str2);
          localNativeConfigStore.n_setConfig(localStringBuilder.toString(), String.valueOf(paramLong));
        }
      }
      else if (NetConnInfoCenter.isMobileConn())
      {
        str2 = NetConnInfoCenter.getCurrentAPN();
        if (!TextUtils.isEmpty(str2))
        {
          localNativeConfigStore = MsfStore.getNativeConfigStore();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DualConnTime");
          localStringBuilder.append(c.a.a(paramString, "Mobile", str1));
          localStringBuilder.append(str2);
          localNativeConfigStore.n_setConfig(localStringBuilder.toString(), String.valueOf(paramLong));
        }
      }
    }
  }
  
  public void b()
  {
    try
    {
      String str = NetConnInfoCenter.getCurrentAPN();
      boolean bool = TextUtils.isEmpty(str);
      if (bool) {
        return;
      }
      b(str, true);
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      String str = NetConnInfoCenter.getCurrentSSID();
      boolean bool = TextUtils.isEmpty(str);
      if (bool) {
        return;
      }
      a(str, true);
      a(str);
      return;
    }
    finally {}
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
    com.tencent.mobileqq.msf.core.d locald = this.n.sender.b.l().b();
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (locald != null)
    {
      String str1 = a(locald.d());
      localObject = localStringBuilder;
      if (!TextUtils.isEmpty(str1))
      {
        String str2;
        if (NetConnInfoCenter.isWifiConn())
        {
          str2 = NetConnInfoCenter.getCurrentSSID();
          localObject = localStringBuilder;
          if (!TextUtils.isEmpty(str2))
          {
            localObject = MsfStore.getNativeConfigStore();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("policyId");
            localStringBuilder.append(c.a.a(locald.b(), "Wifi", str1));
            localStringBuilder.append(str2);
            return ((NativeConfigStore)localObject).getConfig(localStringBuilder.toString());
          }
        }
        else
        {
          localObject = localStringBuilder;
          if (NetConnInfoCenter.isMobileConn())
          {
            str2 = NetConnInfoCenter.getCurrentAPN();
            localObject = localStringBuilder;
            if (!TextUtils.isEmpty(str2))
            {
              localObject = MsfStore.getNativeConfigStore();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("policyId");
              localStringBuilder.append(c.a.a(locald.b(), "Mobile", str1));
              localStringBuilder.append(str2);
              localObject = ((NativeConfigStore)localObject).getConfig(localStringBuilder.toString());
            }
          }
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.c
 * JD-Core Version:    0.7.0.1
 */