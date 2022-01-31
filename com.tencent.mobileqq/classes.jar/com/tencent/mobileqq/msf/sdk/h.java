package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;

public class h
{
  static ConcurrentHashMap a = new ConcurrentHashMap();
  
  public static int a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (paramToServiceMsg.getServiceName().equals(MsfServiceSdk.get().getMsfServiceName())) {
      return MsfServiceSdk.get().sendMsg(paramToServiceMsg);
    }
    if (!a.containsKey(paramToServiceMsg.getServiceName())) {
      a.putIfAbsent(paramToServiceMsg.getServiceName(), new p(paramToServiceMsg.getServiceName()));
    }
    return ((IMsfProxy)a.get(paramToServiceMsg.getServiceName())).sendMsg(paramToServiceMsg);
  }
  
  public static IMsfProxy a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new p(paramString);
    }
    return new k(paramString);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.equals(MsfServiceSdk.get().getMsfServiceName()))
    {
      MsfServiceSdk.get().initMsfService();
      return;
    }
    if (!a.containsKey(paramString)) {
      a.putIfAbsent(paramString, new p(paramString));
    }
    ((IMsfProxy)a.get(paramString)).initMsfService();
  }
  
  public static void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.equals(MsfServiceSdk.get().getMsfServiceName()))
    {
      MsfServiceSdk.get().initMsfService();
      return;
    }
    if (!a.containsKey(paramString)) {
      a.putIfAbsent(paramString, new p(paramString));
    }
    ((IMsfProxy)a.get(paramString)).initMsfService();
  }
  
  public static void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.equals(MsfServiceSdk.get().getMsfServiceName()))
    {
      MsfServiceSdk.get().initMsfService();
      return;
    }
    if (!a.containsKey(paramString)) {
      a.putIfAbsent(paramString, new p(paramString));
    }
    ((IMsfProxy)a.get(paramString)).initMsfService();
  }
  
  public static boolean d(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      if (paramString.equals(MsfServiceSdk.get().getMsfServiceName()))
      {
        MsfServiceSdk.get().unbindMsfService();
        return true;
      }
    } while (!a.containsKey(paramString));
    ((IMsfProxy)a.get(paramString)).unbindMsfService();
    return true;
  }
  
  public static boolean e(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      if (paramString.equals(MsfServiceSdk.get().getMsfServiceName()))
      {
        MsfServiceSdk.get().stopMsfService();
        return true;
      }
    } while (!a.containsKey(paramString));
    ((IMsfProxy)a.get(paramString)).stopMsfService();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.h
 * JD-Core Version:    0.7.0.1
 */