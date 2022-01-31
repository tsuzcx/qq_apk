package com.tencent.qapmsdk.socket.model;

import android.text.TextUtils;
import com.tencent.qapmsdk.dns.model.DnsInfo;
import java.util.concurrent.ConcurrentHashMap;

public class SocketTracer
{
  private static final ConcurrentHashMap<String, SocketInfo> socketMap = new ConcurrentHashMap();
  
  public static void addSocketInfoToMap(String paramString, SocketInfo paramSocketInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramSocketInfo != null))
    {
      paramSocketInfo.dnsTime = DnsInfo.getDnsElapse(paramSocketInfo.host);
      if (socketMap.get(paramString) == null) {
        socketMap.put(paramString, paramSocketInfo);
      }
    }
  }
  
  public static SocketInfo getSocketInfoFromMap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (socketMap.get(paramString) == null) {
      return (SocketInfo)socketMap.get(paramString + "/");
    }
    return (SocketInfo)socketMap.get(paramString);
  }
  
  public static void removeSocketInfoFromMap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((SocketInfo)socketMap.get(paramString) == null) {
      return;
    }
    socketMap.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.model.SocketTracer
 * JD-Core Version:    0.7.0.1
 */