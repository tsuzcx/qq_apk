package com.tencent.mobileqq.uftransfer.common.transfer.urlprovider;

import android.text.TextUtils;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class UFTHttpUrlProcessor
{
  private List<String> a;
  private String b;
  private Iterator<String> c;
  private List<UFTHttpUrlProcessor.FileHttpProxyIp> d;
  private Iterator<UFTHttpUrlProcessor.FileHttpProxyIp> e;
  private UFTHttpUrlProcessor.FileHttpProxyIp f;
  private boolean g;
  private boolean h;
  private String i;
  
  public UFTHttpUrlProcessor(AppRuntime paramAppRuntime, List<String> paramList, String paramString, boolean paramBoolean)
  {
    int j = 0;
    this.h = false;
    this.i = " ";
    this.a = paramList;
    this.b = paramString;
    paramList = this.a;
    if (paramList != null) {
      this.c = paramList.iterator();
    }
    this.h = paramBoolean;
    a(paramAppRuntime);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("init urlProcessor. hostNum:");
    paramList = this.a;
    if (paramList != null) {
      j = paramList.size();
    }
    paramAppRuntime.append(j);
    paramAppRuntime.append(" proxyIps:");
    paramAppRuntime.append(this.i);
    paramAppRuntime.append(" params:");
    paramAppRuntime.append(this.b);
    paramAppRuntime.append(" isHttps:");
    paramAppRuntime.append(paramBoolean);
    UFTLog.b("[UFTTransfer] UFTHttpUrlProcessor", 1, paramAppRuntime.toString());
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    this.d = UFTDependFeatureApi.a(paramAppRuntime);
    if (this.d == null)
    {
      this.d = new ArrayList();
    }
    else
    {
      this.i = "";
      int j = 0;
      while (j < this.d.size())
      {
        paramAppRuntime = (UFTHttpUrlProcessor.FileHttpProxyIp)this.d.get(j);
        if (paramAppRuntime != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.i);
          localStringBuilder.append(paramAppRuntime.toString());
          this.i = localStringBuilder.toString();
        }
        j += 1;
      }
    }
    b();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str2 = null;
    String str1;
    label222:
    do
    {
      for (;;)
      {
        try
        {
          j = paramString.indexOf("://");
          if (j != -1) {
            break label222;
          }
          j = 0;
          str1 = paramString.substring(j);
          if (TextUtils.isEmpty(str1)) {
            return false;
          }
          int m = str1.indexOf("/");
          int k = m;
          if (-1 == m) {
            k = str1.length() - 1;
          }
          m = paramString.indexOf("&bHost=");
          if (-1 != m)
          {
            int n = paramString.indexOf("&bPort=", m);
            if (-1 != n)
            {
              str1 = paramString.substring(m + 7, n);
              str2 = paramString.substring(n + 7);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(str1);
              localStringBuilder.append(":");
              localStringBuilder.append(str2);
              str2 = localStringBuilder.toString();
            }
          }
          str1 = str2;
          if (str2 != null) {
            break;
          }
          str1 = paramString.substring(j, k + j);
        }
        catch (Exception paramString)
        {
          boolean bool;
          return false;
        }
        int j = str1.lastIndexOf(":");
        paramString = str1;
        if (j >= 0) {
          paramString = str1.substring(0, j);
        }
        bool = b(paramString);
        return bool;
        j += 3;
      }
    } while (str1 != null);
    return false;
  }
  
  private void b()
  {
    this.e = this.d.iterator();
    if (this.e.hasNext())
    {
      this.f = ((UFTHttpUrlProcessor.FileHttpProxyIp)this.e.next());
      this.g = true;
    }
    else
    {
      this.g = false;
    }
    List localList = this.a;
    if (localList != null) {
      this.c = localList.iterator();
    }
  }
  
  public static boolean b(String paramString)
  {
    return (d(paramString)) || (c(paramString));
  }
  
  public static boolean c(String paramString)
  {
    return IPAddressUtil.isIPv6LiteralAddress(paramString);
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.length() >= 7)
    {
      if (paramString.length() > 15) {
        return false;
      }
      String[] arrayOfString = paramString.split("\\.");
      if (arrayOfString != null)
      {
        if (arrayOfString.length != 4) {
          return false;
        }
        return IPAddressUtil.isIPv4LiteralAddress(paramString);
      }
    }
    return false;
  }
  
  public String a()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = this.c;
      if (localObject1 != null)
      {
        if (!((Iterator)localObject1).hasNext()) {
          if (this.e.hasNext())
          {
            this.f = ((UFTHttpUrlProcessor.FileHttpProxyIp)this.e.next());
            this.c = this.a.iterator();
          }
          else if (this.g)
          {
            this.g = false;
            this.c = this.a.iterator();
          }
          else
          {
            UFTLog.b("[UFTTransfer] UFTHttpUrlProcessor", 1, "getNextUrl: no proxy no host, so return null");
            return null;
          }
        }
        String str = (String)this.c.next();
        if (this.g)
        {
          int j = str.lastIndexOf(":");
          Object localObject3;
          if (j > 0)
          {
            localObject1 = str.substring(0, j);
            localObject2 = str.substring(j + 1);
          }
          else
          {
            if (this.h) {
              localObject1 = "443";
            } else {
              localObject1 = "80";
            }
            localObject3 = str;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
          if (this.h)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("https://");
            ((StringBuilder)localObject3).append(this.f.a);
            ((StringBuilder)localObject3).append(":");
            ((StringBuilder)localObject3).append(this.f.b);
            ((StringBuilder)localObject3).append(this.b);
            ((StringBuilder)localObject3).append("&bHost=");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append("&bPort=");
            ((StringBuilder)localObject3).append((String)localObject2);
            localObject1 = ((StringBuilder)localObject3).toString();
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("http://");
            ((StringBuilder)localObject3).append(this.f.a);
            ((StringBuilder)localObject3).append(":");
            ((StringBuilder)localObject3).append(this.f.b);
            ((StringBuilder)localObject3).append(this.b);
            ((StringBuilder)localObject3).append("&bHost=");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append("&bPort=");
            ((StringBuilder)localObject3).append((String)localObject2);
            localObject1 = ((StringBuilder)localObject3).toString();
          }
        }
        else if (this.h)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("https://");
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(this.b);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("http://");
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(this.b);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getNextUrl: url:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" host:");
        ((StringBuilder)localObject2).append(str);
        UFTLog.b("[UFTTransfer] UFTHttpUrlProcessor", 1, ((StringBuilder)localObject2).toString());
        return localObject1;
      }
    }
    UFTLog.d("[UFTTransfer] UFTHttpUrlProcessor", 1, "getNextUrl: no host, so return null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTHttpUrlProcessor
 * JD-Core Version:    0.7.0.1
 */