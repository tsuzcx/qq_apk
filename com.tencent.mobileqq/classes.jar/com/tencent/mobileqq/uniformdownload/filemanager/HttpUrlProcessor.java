package com.tencent.mobileqq.uniformdownload.filemanager;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class HttpUrlProcessor
{
  private List<String> a;
  private String b;
  private Iterator<String> c;
  private List<ProxyIpManager.ProxyIp> d;
  private Iterator<ProxyIpManager.ProxyIp> e;
  private ProxyIpManager.ProxyIp f;
  private boolean g;
  private boolean h;
  
  public HttpUrlProcessor(AppRuntime paramAppRuntime, String paramString)
  {
    int i = 0;
    this.h = false;
    int j = paramString.indexOf("://");
    if (j != -1) {
      i = j + 3;
    }
    j = paramString.substring(i).indexOf("/") + i;
    Object localObject = null;
    String str = null;
    if ((-1 == j) && (-1 == j))
    {
      paramString = null;
    }
    else
    {
      int k = paramString.indexOf("&bHost=");
      if (-1 == k)
      {
        localObject = str;
      }
      else
      {
        int m = paramString.indexOf("&bPort=", k);
        if (-1 == m)
        {
          localObject = str;
        }
        else
        {
          localObject = paramString.substring(k + 7, m);
          str = paramString.substring(m + 7);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(":");
          localStringBuilder.append(str);
          localObject = localStringBuilder.toString();
        }
      }
      if (localObject == null)
      {
        localObject = paramString.substring(i, j);
        paramString = paramString.substring(j);
      }
      else
      {
        paramString = paramString.substring(j, k);
      }
    }
    if ((localObject != null) && (paramString != null))
    {
      this.a = new ArrayList(1);
      this.a.add(localObject);
      this.c = this.a.iterator();
      this.b = paramString;
    }
    a(paramAppRuntime);
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    this.d = ((ProxyIpManager)paramAppRuntime.getManager(3)).getProxyIp(5);
    if (this.d == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("HttpUrlProcessor", 4, "HttpUrlProcessor: getProxyIp return null, so new empty ProxyList");
      }
      this.d = new ArrayList();
    }
    a();
  }
  
  public void a()
  {
    this.e = this.d.iterator();
    if (this.e.hasNext())
    {
      this.f = ((ProxyIpManager.ProxyIp)this.e.next());
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
  
  public String b()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      if (!this.c.hasNext()) {
        if (this.e.hasNext())
        {
          this.f = ((ProxyIpManager.ProxyIp)this.e.next());
          this.c = this.a.iterator();
        }
        else if (this.g)
        {
          this.g = false;
          this.c = this.a.iterator();
        }
        else
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("HttpUrlProcessor", 4, "getNextUrl: no proxy no host, so return null");
          }
          return null;
        }
      }
      Object localObject2 = (String)this.c.next();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("waterLog- getNextUrl: host[");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("]");
      QLog.e("HttpUrlProcessor", 4, ((StringBuilder)localObject1).toString());
      if (this.g)
      {
        int i = ((String)localObject2).indexOf(":");
        Object localObject3;
        if (i > 0)
        {
          localObject3 = ((String)localObject2).substring(0, i);
          localObject1 = ((String)localObject2).substring(i + 1);
          localObject2 = localObject3;
        }
        else if (this.h)
        {
          localObject1 = "443";
        }
        else
        {
          localObject1 = "80";
        }
        if (this.h)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("https://");
          ((StringBuilder)localObject3).append(this.f.ip);
          ((StringBuilder)localObject3).append(":");
          ((StringBuilder)localObject3).append(this.f.port);
          ((StringBuilder)localObject3).append(this.b);
          ((StringBuilder)localObject3).append("&bHost=");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("&bPort=");
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject3).toString();
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("http://");
          ((StringBuilder)localObject3).append(this.f.ip);
          ((StringBuilder)localObject3).append(":");
          ((StringBuilder)localObject3).append(this.f.port);
          ((StringBuilder)localObject3).append(this.b);
          ((StringBuilder)localObject3).append("&bHost=");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("&bPort=");
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject3).toString();
        }
      }
      else if (this.h)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("https://");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(this.b);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("http://");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(this.b);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getNextUrl: url:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("HttpUrlProcessor", 4, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("HttpUrlProcessor", 4, "getNextUrl: no host, so return null");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.filemanager.HttpUrlProcessor
 * JD-Core Version:    0.7.0.1
 */