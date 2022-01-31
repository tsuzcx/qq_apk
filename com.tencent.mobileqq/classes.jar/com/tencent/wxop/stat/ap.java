package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.e;
import com.tencent.wxop.stat.event.i;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

class ap
  implements Runnable
{
  private Context a = null;
  private Map<String, Integer> b = null;
  private StatSpecifyReportedInfo c = null;
  
  public ap(Context paramContext, Map<String, Integer> paramMap, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    this.a = paramContext;
    this.c = paramStatSpecifyReportedInfo;
    if (paramMap != null) {
      this.b = paramMap;
    }
  }
  
  private NetworkMonitor a(String paramString, int paramInt)
  {
    NetworkMonitor localNetworkMonitor = new NetworkMonitor();
    Socket localSocket = new Socket();
    int i = 0;
    for (;;)
    {
      try
      {
        localNetworkMonitor.setDomain(paramString);
        localNetworkMonitor.setPort(paramInt);
        long l = System.currentTimeMillis();
        paramString = new InetSocketAddress(paramString, paramInt);
        localSocket.connect(paramString, 30000);
        localNetworkMonitor.setMillisecondsConsume(System.currentTimeMillis() - l);
        localNetworkMonitor.setRemoteIp(paramString.getAddress().getHostAddress());
        localSocket.close();
      }
      catch (IOException paramString)
      {
        paramString = paramString;
        paramInt = -1;
        StatServiceImpl.f().e(paramString);
        try
        {
          localSocket.close();
        }
        catch (Throwable paramString)
        {
          StatServiceImpl.f().e(paramString);
        }
        continue;
      }
      finally {}
      try
      {
        localSocket.close();
        paramInt = i;
      }
      catch (Throwable paramString)
      {
        StatServiceImpl.f().e(paramString);
        paramInt = i;
      }
    }
    localNetworkMonitor.setStatusCode(paramInt);
    return localNetworkMonitor;
    try
    {
      localSocket.close();
      throw paramString;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        StatServiceImpl.f().e(localThrowable);
      }
    }
  }
  
  private Map<String, Integer> a()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = StatConfig.a("__MTA_TEST_SPEED__", null);
    if ((localObject == null) || (((String)localObject).trim().length() == 0)) {}
    for (;;)
    {
      return localHashMap;
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = localObject[i].split(",");
        String str;
        if ((arrayOfString != null) && (arrayOfString.length == 2))
        {
          str = arrayOfString[0];
          if ((str == null) || (str.trim().length() == 0)) {}
        }
        try
        {
          int k = Integer.valueOf(arrayOfString[1]).intValue();
          localHashMap.put(str, Integer.valueOf(k));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            StatServiceImpl.f().e(localNumberFormatException);
          }
        }
        i += 1;
      }
    }
  }
  
  public void run()
  {
    Object localObject;
    for (;;)
    {
      Map.Entry localEntry;
      String str;
      try
      {
        if (this.b == null) {
          this.b = a();
        }
        if ((this.b == null) || (this.b.size() == 0))
        {
          StatServiceImpl.f().i("empty domain list.");
          return;
        }
        JSONArray localJSONArray = new JSONArray();
        localObject = this.b.entrySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject).next();
        str = (String)localEntry.getKey();
        if ((str == null) || (str.length() == 0))
        {
          StatServiceImpl.f().w("empty domain name.");
          continue;
        }
        if ((Integer)localEntry.getValue() != null) {
          break label167;
        }
      }
      catch (Throwable localThrowable)
      {
        StatServiceImpl.f().e(localThrowable);
        return;
      }
      StatServiceImpl.f().w("port is null for " + str);
      continue;
      label167:
      localThrowable.put(a((String)localEntry.getKey(), ((Integer)localEntry.getValue()).intValue()).toJSONObject());
    }
    if (localThrowable.length() != 0)
    {
      localObject = new i(this.a, StatServiceImpl.a(this.a, false, this.c), this.c);
      ((i)localObject).a(localThrowable.toString());
      new aq((e)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.ap
 * JD-Core Version:    0.7.0.1
 */