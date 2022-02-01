package com.tencent.mobileqq.msf.core.net.c;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.msf.service.protocol.push.a.b;
import com.tencent.msf.service.protocol.push.a.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class k
{
  static final String a = "MSF.C.QualityTestManager";
  public static d b;
  public static b c;
  public static MsfCore d;
  public static String e = "";
  public static ArrayList f = new ArrayList();
  public static ArrayList g = new ArrayList();
  static int h = 1;
  static int i = 0;
  
  private static String a(ArrayList paramArrayList)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return "";
      }
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = (ArrayList)localObject2;
      for (;;)
      {
        localObject1 = paramArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Long)localIterator.next();
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramArrayList);
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(";");
          paramArrayList = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramArrayList);
          ((StringBuilder)localObject1).append("-1;");
          paramArrayList = ((StringBuilder)localObject1).toString();
        }
      }
    }
    return localObject1;
  }
  
  public static void a()
  {
    b = null;
    c = null;
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg)
  {
    int j;
    try
    {
      if (paramFromServiceMsg.isSuccess()) {
        if (b == null)
        {
          localObject = new UniPacket(true);
          ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
          paramFromServiceMsg = ((UniPacket)localObject).getFuncName();
          if (paramFromServiceMsg.equals("QualityTest"))
          {
            b = (d)((UniPacket)localObject).getByClass("QualityTest", new d());
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("Quality getted, start now ");
            paramFromServiceMsg.append(b.a);
            QLog.d("MSF.C.QualityTestManager", 1, paramFromServiceMsg.toString());
            j = b.z;
            if (j == 1) {
              if ((NetConnInfoCenter.isWifiConn()) && (NetConnInfoCenter.getWifiStrength() >= 10)) {
                paramFromServiceMsg = b;
              }
            }
          }
        }
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      localObject = "MSF.C.QualityTestManager";
    }
    try
    {
      if ((paramFromServiceMsg.m & 0xFF) == 1L)
      {
        e = "WiFi";
        if (b.a == 5)
        {
          new Thread(new f(b, c, f.b.e, h, i)).start();
          return;
        }
        if (b.a != 6) {
          break label1732;
        }
        new Thread(new f(b, c, f.b.d, h, i)).start();
        return;
        if (j >= 2) {
          break label1731;
        }
        if (b.a == 1)
        {
          new Thread(new f(b, c, f.b.a, 2, j)).start();
          break label1737;
        }
        if (b.a == 2)
        {
          new Thread(new f(b, c, f.b.b, 2, j)).start();
          break label1737;
        }
        if (b.a == 3)
        {
          new Thread(new f(b, c, f.b.c, 2, j)).start();
          break label1737;
        }
        a();
        return;
      }
      e = "WiFi";
      if (b.a == 1)
      {
        new Thread(new f(b, c, f.b.a, h, i)).start();
        return;
      }
      if (b.a == 2)
      {
        new Thread(new f(b, c, f.b.b, h, i)).start();
        return;
      }
      if (b.a == 3)
      {
        new Thread(new f(b, c, f.b.c, h, i)).start();
        return;
      }
      if (b.a == 5)
      {
        new Thread(new f(b, c, f.b.e, h, i)).start();
        return;
      }
      if (b.a == 6)
      {
        new Thread(new f(b, c, f.b.d, h, i)).start();
        return;
      }
      a();
      return;
    }
    catch (Throwable paramFromServiceMsg)
    {
      for (;;)
      {
        localObject = "MSF.C.QualityTestManager";
      }
    }
    e = "NotWiFi";
    if (b.a == 1)
    {
      new Thread(new f(b, c, f.b.a, h, i)).start();
      return;
    }
    if (b.a == 2)
    {
      new Thread(new f(b, c, f.b.b, h, i)).start();
      return;
    }
    if (b.a == 3)
    {
      new Thread(new f(b, c, f.b.c, h, i)).start();
      return;
    }
    if (b.a == 5)
    {
      new Thread(new f(b, c, f.b.e, h, i)).start();
      return;
    }
    if (b.a == 6)
    {
      new Thread(new f(b, c, f.b.d, h, i)).start();
      return;
    }
    a();
    return;
    if ((NetConnInfoCenter.isWifiConn()) && (NetConnInfoCenter.getWifiStrength() >= 10)) {
      if ((b.m & 0xFF) == 1L)
      {
        e = "WiFi";
        if (b.a == 5)
        {
          new Thread(new c(b, c, c.b.e, h, i)).start();
          return;
        }
        if (b.a != 6) {
          break label1744;
        }
        new Thread(new c(b, c, c.b.d, h, i)).start();
        return;
      }
    }
    for (;;)
    {
      if (j < 2)
      {
        if (b.a == 1)
        {
          new Thread(new c(b, c, c.b.a, 2, j)).start();
        }
        else if (b.a == 2)
        {
          new Thread(new c(b, c, c.b.b, 2, j)).start();
        }
        else if (b.a == 3)
        {
          new Thread(new c(b, c, c.b.c, 2, j)).start();
        }
        else
        {
          a();
          return;
          e = "WiFi";
          if (b.a == 1)
          {
            new Thread(new c(b, c, c.b.a, h, i)).start();
            return;
          }
          if (b.a == 2)
          {
            new Thread(new c(b, c, c.b.b, h, i)).start();
            return;
          }
          if (b.a == 3)
          {
            new Thread(new c(b, c, c.b.c, h, i)).start();
            return;
          }
          if (b.a == 5)
          {
            new Thread(new c(b, c, c.b.e, h, i)).start();
            return;
          }
          if (b.a == 6)
          {
            new Thread(new c(b, c, c.b.d, h, i)).start();
            return;
          }
          a();
          return;
          e = "NotWiFi";
          if (b.a == 1)
          {
            new Thread(new c(b, c, c.b.a, h, i)).start();
            return;
          }
          if (b.a == 2)
          {
            new Thread(new c(b, c, c.b.b, h, i)).start();
            return;
          }
          if (b.a == 3)
          {
            new Thread(new c(b, c, c.b.c, h, i)).start();
            return;
          }
          if (b.a == 5)
          {
            new Thread(new c(b, c, c.b.e, h, i)).start();
            return;
          }
          if (b.a == 6)
          {
            new Thread(new c(b, c, c.b.d, h, i)).start();
            return;
          }
          a();
          return;
          if (!paramFromServiceMsg.equals("MtuTest")) {
            break label1756;
          }
          c = (b)((UniPacket)localObject).getByClass("MtuTest", new b());
          try
          {
            QLog.d("MSF.C.QualityTestManager", 1, "MtuTest getted, start now");
            if (c.a == 1)
            {
              new Thread(new c(b, c, c.b.a, h, i)).start();
              return;
            }
            if (c.a == 2)
            {
              new Thread(new c(b, c, c.b.b, h, i)).start();
              return;
            }
            if (c.a == 3)
            {
              new Thread(new c(b, c, c.b.c, h, i)).start();
              return;
            }
            a();
            return;
          }
          catch (Throwable paramFromServiceMsg)
          {
            localObject = "MSF.C.QualityTestManager";
            paramFromServiceMsg = paramFromServiceMsg;
          }
          QLog.d("MSF.C.QualityTestManager", 1, "QualityManager getted too frequently drop now");
          return;
          QLog.d("MSF.C.QualityTestManager", 1, "QualityManager getted, return fail do nothing");
          return;
          QLog.d((String)localObject, 1, "QualityManager error, ", paramFromServiceMsg);
        }
      }
      else
      {
        label1731:
        return;
        label1732:
        j = 0;
        break;
        label1737:
        j += 1;
        break;
        label1744:
        j = 0;
        continue;
      }
      j += 1;
    }
    label1756:
  }
  
  public static void a(boolean paramBoolean, d paramd, b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    if (d.getStatReporter() != null)
    {
      HashMap localHashMap = new HashMap();
      int j;
      if (paramd != null)
      {
        localHashMap.put("TestType", "QualityTest");
        paramb = new StringBuilder();
        paramb.append("");
        paramb.append(paramd.a);
        localHashMap.put("ProtoType", paramb.toString());
        paramb = new StringBuilder();
        paramb.append("");
        if (paramd.b != null) {
          j = paramd.b.size();
        } else {
          j = -1;
        }
        paramb.append(j);
        localHashMap.put("IpNum", paramb.toString());
        paramb = new StringBuilder();
        paramb.append("");
        paramb.append(paramd.c);
        localHashMap.put("PkgNum", paramb.toString());
        paramb = new StringBuilder();
        paramb.append("");
        if (paramd.e != null) {
          j = paramd.e.length;
        } else {
          j = -1;
        }
        paramb.append(j);
        localHashMap.put("PkgDataSize", paramb.toString());
        paramb = new StringBuilder();
        paramb.append("");
        paramb.append(paramd.f);
        localHashMap.put("RepeatTimes", paramb.toString());
        paramb = new StringBuilder();
        paramb.append("");
        if (paramd.g != null) {
          j = paramd.g.length;
        } else {
          j = -1;
        }
        paramb.append(j);
        localHashMap.put("HeadDataSize", paramb.toString());
        paramd = new StringBuilder();
        paramd.append("");
        paramd.append(paramInt1);
        localHashMap.put("testPacketRecved", paramd.toString());
        paramd = new StringBuilder();
        paramd.append("");
        paramd.append(paramInt2);
        localHashMap.put("testPacketSend", paramd.toString());
        localHashMap.put("network_type", String.valueOf(paramInt3));
      }
      else if (paramb != null)
      {
        localHashMap.put("TestType", "MtuTest");
        paramd = new StringBuilder();
        paramd.append("");
        paramd.append(paramb.a);
        localHashMap.put("ProtoType", paramd.toString());
        paramd = new StringBuilder();
        paramd.append("");
        if (paramb.b != null) {
          j = paramb.b.size();
        } else {
          j = -1;
        }
        paramd.append(j);
        localHashMap.put("IpNum", paramd.toString());
        paramd = new StringBuilder();
        paramd.append("");
        paramd.append(paramb.g);
        localHashMap.put("PkgNum", paramd.toString());
        localHashMap.put("PkgDataSize", b(paramb.c));
        localHashMap.put("RepeatTimes", a(paramb.d));
        localHashMap.put("HeadDataSize", b(paramb.e));
        paramd = new StringBuilder();
        paramd.append("");
        paramd.append(paramInt1);
        localHashMap.put("testPacketRecved", paramd.toString());
        paramd = new StringBuilder();
        paramd.append("");
        paramd.append(paramInt2);
        localHashMap.put("testPacketSend", paramd.toString());
        localHashMap.put("network_type", String.valueOf(paramInt3));
      }
      paramd = d.getStatReporter();
      long l = paramInt1 + paramInt2;
      paramd.a("evt_net_test_result", paramBoolean, 0L, l, localHashMap, false, false);
      d.getStatReporter().a("dim_Msf_NetTestResult", paramBoolean, 0L, l, localHashMap, false, false);
    }
  }
  
  private static String b(ArrayList paramArrayList)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return "";
      }
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = (ArrayList)localObject2;
      for (;;)
      {
        localObject1 = paramArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (byte[])localIterator.next();
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramArrayList);
          ((StringBuilder)localObject2).append(localObject1.length);
          ((StringBuilder)localObject2).append(";");
          paramArrayList = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramArrayList);
          ((StringBuilder)localObject1).append("-1;");
          paramArrayList = ((StringBuilder)localObject1).toString();
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.k
 * JD-Core Version:    0.7.0.1
 */