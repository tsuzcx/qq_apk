package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ai
{
  private static final String a = "WeakNetworkStat";
  private static ai.a b;
  private static final ConcurrentHashMap c = new ConcurrentHashMap(100);
  private static final ConcurrentLinkedQueue d = new ConcurrentLinkedQueue();
  private static final int e = 100;
  private static final long f = 3600000L;
  private static final int g = 1000;
  private static Handler h = new aj(q.a().getLooper());
  
  public static void a(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
  {
    paramMsfCore = b;
    if ((paramMsfCore == null) || (TextUtils.isEmpty(paramMsfCore.a)) || (!b.a.equals(paramToServiceMsg.getUin())))
    {
      b = new ai.a(null);
      b.a = paramToServiceMsg.getUin();
      b.b = paramToServiceMsg.getRequestSsoSeq();
      b.c = SystemClock.elapsedRealtime();
      b.e = new StringBuilder();
      b.i = new StringBuilder();
    }
    if (!h.hasMessages(1000)) {
      h.sendEmptyMessageDelayed(1000, 3600000L);
    }
  }
  
  private static void a(ai.a parama, boolean paramBoolean, long paramLong)
  {
    if ((parama != null) && (parama.e.length() > 0))
    {
      if (paramLong == -1L)
      {
        parama.d = (SystemClock.elapsedRealtime() - parama.c);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("report infologin start timestamp:");
          ((StringBuilder)localObject).append(parama.c);
          QLog.d("WeakNetworkStat", 2, ((StringBuilder)localObject).toString());
        }
        parama.d = (paramLong - parama.c);
      }
      Object localObject = new HashMap();
      ((HashMap)localObject).put("uin", parama.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.b);
      ((HashMap)localObject).put("ssoSeq", localStringBuilder.toString());
      ((HashMap)localObject).put("closeConnReason", parama.e.toString());
      ((HashMap)localObject).put("infoVersion", "6.2.0");
      if (MsfService.core.getStatReporter() != null) {
        MsfService.core.getStatReporter().a("dim.Msf.WEAKNET_INFOLOGIN4", paramBoolean, parama.d, 0L, (Map)localObject, false, false);
      }
    }
  }
  
  private static void a(ai.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((parama != null) && ((parama.e.length() > 0) || (paramBoolean2)))
    {
      parama.d = (SystemClock.elapsedRealtime() - parama.c);
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", parama.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.b);
      localHashMap.put("ssoSeq", localStringBuilder.toString());
      localHashMap.put("closeConnReason", parama.e.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.f);
      localHashMap.put("msgSeq", localStringBuilder.toString());
      localHashMap.put("fromUin", parama.g);
      localHashMap.put("toUin", parama.h);
      localHashMap.put("sendFailReason", parama.i.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramBoolean2);
      localHashMap.put("quickSend", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.j);
      localHashMap.put("quickSuccTime", localStringBuilder.toString());
      if (MsfService.core.getStatReporter() != null) {
        MsfService.core.getStatReporter().a("dim.Msf.WEAKNET_SENDCHATMSG4", paramBoolean1, parama.d, 0L, localHashMap, false, false);
      }
    }
  }
  
  public static void a(a parama)
  {
    Object localObject1 = b;
    if (localObject1 != null) {
      if (((ai.a)localObject1).e.length() < 100)
      {
        localObject1 = b.e;
        ((StringBuilder)localObject1).append(parama.ordinal());
        ((StringBuilder)localObject1).append(",");
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("WeakNetworkStat", 2, "onCloseConn, fail to append closeConnQueue by max size limit.");
      }
    }
    localObject1 = c;
    Object localObject2;
    if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).size() > 0))
    {
      localObject1 = c.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ai.a)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (((ai.a)localObject2).e.length() < 100)
        {
          localObject2 = ((ai.a)localObject2).e;
          ((StringBuilder)localObject2).append(parama.ordinal());
          ((StringBuilder)localObject2).append(",");
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("WeakNetworkStat", 2, "onCloseConn, fail to append closeConnQueue by max size limit.");
        }
      }
    }
    localObject1 = d;
    if ((localObject1 != null) && (((ConcurrentLinkedQueue)localObject1).size() > 0))
    {
      long l = SystemClock.elapsedRealtime();
      localObject1 = d.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ai.a)((Iterator)localObject1).next();
        if ((l - ((ai.a)localObject2).j <= 10000L) && (parama == a.A))
        {
          localObject2 = ((ai.a)localObject2).e;
          ((StringBuilder)localObject2).append(parama.ordinal());
          ((StringBuilder)localObject2).append(",");
        }
      }
    }
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg)
  {
    ai.a locala = b;
    if ((locala != null) && (!TextUtils.isEmpty(locala.a)) && (b.a.equals(paramFromServiceMsg.getUin())) && (b.c > 0L))
    {
      a(b, true, -1L);
      b = null;
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (paramToServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(paramFromServiceMsg.getUin())) && (!"0".equals(paramFromServiceMsg.getUin())) && ("MessageSvc.PbSendMsg".equals(paramFromServiceMsg.getServiceCmd())))
        {
          int i = -1;
          boolean bool1 = false;
          long l = -1L;
          if (paramToServiceMsg.getAttributes().containsKey("msgtype")) {
            i = ((Integer)paramToServiceMsg.getAttributes().get("msgtype")).intValue();
          }
          if (paramToServiceMsg.getAttributes().containsKey("resend_by_user")) {
            bool1 = ((Boolean)paramToServiceMsg.getAttributes().get("resend_by_user")).booleanValue();
          }
          if (paramToServiceMsg.getAttributes().containsKey("retryIndex")) {
            ((Integer)paramToServiceMsg.getAttributes().get("retryIndex")).intValue();
          }
          if (paramToServiceMsg.getAttributes().containsKey("msgSeq")) {
            l = ((Long)paramToServiceMsg.getAttributes().get("msgSeq")).longValue();
          }
          boolean bool2 = paramToServiceMsg.getAttributes().containsKey("fromUin");
          String str2 = null;
          if (!bool2) {
            break label526;
          }
          str1 = (String)paramToServiceMsg.getAttributes().get("fromUin");
          if (paramToServiceMsg.getAttributes().containsKey("uin")) {
            str2 = (String)paramToServiceMsg.getAttributes().get("uin");
          }
          if ((i == -1000) && (!bool1) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
          {
            paramToServiceMsg = c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str1);
            localStringBuilder.append(str2);
            localStringBuilder.append(l);
            if (paramToServiceMsg.containsKey(localStringBuilder.toString()))
            {
              if (paramFromServiceMsg.isSuccess())
              {
                paramToServiceMsg = c;
                paramFromServiceMsg = new StringBuilder();
                paramFromServiceMsg.append(str1);
                paramFromServiceMsg.append(str2);
                paramFromServiceMsg.append(l);
                paramToServiceMsg = (ai.a)paramToServiceMsg.remove(paramFromServiceMsg.toString());
                if ((paramBoolean) && (paramToServiceMsg.e.length() <= 0))
                {
                  paramToServiceMsg.j = SystemClock.elapsedRealtime();
                  d.offer(paramToServiceMsg);
                }
                else
                {
                  a(paramToServiceMsg, true, paramBoolean);
                }
              }
              else
              {
                paramToServiceMsg = c;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(str1);
                localStringBuilder.append(str2);
                localStringBuilder.append(l);
                paramToServiceMsg = (ai.a)paramToServiceMsg.get(localStringBuilder.toString());
                if ((paramToServiceMsg != null) && (paramToServiceMsg.i != null) && (paramToServiceMsg.i.length() < 100))
                {
                  paramToServiceMsg = paramToServiceMsg.i;
                  paramToServiceMsg.append(paramFromServiceMsg.getBusinessFailCode());
                  paramToServiceMsg.append(",");
                }
              }
              return;
            }
          }
          return;
        }
      }
      finally {}
      return;
      label526:
      String str1 = null;
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    Object localObject = b;
    if ((localObject != null) && (!TextUtils.isEmpty(((ai.a)localObject).a)) && (b.a.equals(paramString)) && (b.c > 0L))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start to report info login uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", timeEnd:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("WeakNetworkStat", 1, ((StringBuilder)localObject).toString());
      a(b, true, paramLong);
      b = null;
    }
  }
  
  public static void b(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
  {
    if ((!TextUtils.isEmpty(paramToServiceMsg.getUin())) && (!"0".equals(paramToServiceMsg.getUin())) && (!c.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))))
    {
      if (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd())) {
        return;
      }
      boolean bool1 = false;
      long l = -1L;
      boolean bool2 = paramToServiceMsg.getAttributes().containsKey("msgtype");
      int j = -1;
      int i;
      if (bool2) {
        i = ((Integer)paramToServiceMsg.getAttributes().get("msgtype")).intValue();
      } else {
        i = -1;
      }
      if (paramToServiceMsg.getAttributes().containsKey("resend_by_user")) {
        bool1 = ((Boolean)paramToServiceMsg.getAttributes().get("resend_by_user")).booleanValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("retryIndex")) {
        j = ((Integer)paramToServiceMsg.getAttributes().get("retryIndex")).intValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("msgSeq")) {
        l = ((Long)paramToServiceMsg.getAttributes().get("msgSeq")).longValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("fromUin")) {
        paramMsfCore = (String)paramToServiceMsg.getAttributes().get("fromUin");
      } else {
        paramMsfCore = null;
      }
      String str;
      if (paramToServiceMsg.getAttributes().containsKey("uin")) {
        str = (String)paramToServiceMsg.getAttributes().get("uin");
      } else {
        str = null;
      }
      if ((i == -1000) && (!bool1) && (j <= 0) && (!TextUtils.isEmpty(paramMsfCore)))
      {
        if (TextUtils.isEmpty(str)) {
          return;
        }
        ai.a locala = new ai.a(null);
        locala.a = paramToServiceMsg.getUin();
        locala.b = paramToServiceMsg.getRequestSsoSeq();
        locala.c = SystemClock.elapsedRealtime();
        locala.e = new StringBuilder();
        locala.f = l;
        locala.g = paramMsfCore;
        locala.h = str;
        locala.i = new StringBuilder();
        paramToServiceMsg = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMsfCore);
        localStringBuilder.append(str);
        localStringBuilder.append(l);
        paramToServiceMsg.put(localStringBuilder.toString(), locala);
      }
    }
  }
  
  private static void c()
  {
    if ((b != null) && (SystemClock.elapsedRealtime() - b.c >= 3600000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WeakNetworkStat", 2, "clean, clean infoLoginItem by interval check.");
      }
      a(b, false, -1L);
      b = null;
    }
    Object localObject1 = c;
    Object localObject2;
    if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).size() > 0))
    {
      localObject1 = c.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        ai.a locala = (ai.a)((Map.Entry)localObject2).getValue();
        if (SystemClock.elapsedRealtime() - locala.c >= 3600000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WeakNetworkStat", 2, "clean, clean SendMsgItem by interval check.");
          }
          a(locala, false, false);
          c.remove(((Map.Entry)localObject2).getKey());
        }
      }
    }
    localObject1 = d;
    if ((localObject1 != null) && (((ConcurrentLinkedQueue)localObject1).size() > 0))
    {
      long l = SystemClock.elapsedRealtime();
      localObject1 = d.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ai.a)((Iterator)localObject1).next();
        if (l - ((ai.a)localObject2).c >= 3600000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WeakNetworkStat", 2, "clean, clean QuickSendedMsg by interval check.");
          }
          a((ai.a)localObject2, true, true);
          d.remove(localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ai
 * JD-Core Version:    0.7.0.1
 */