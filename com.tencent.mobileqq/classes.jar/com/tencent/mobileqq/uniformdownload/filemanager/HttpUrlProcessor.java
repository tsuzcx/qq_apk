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
  private String jdField_a_of_type_JavaLangString;
  private Iterator<String> jdField_a_of_type_JavaUtilIterator;
  private List<String> jdField_a_of_type_JavaUtilList;
  private ProxyIpManager.ProxyIp jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp;
  private boolean jdField_a_of_type_Boolean;
  private Iterator<ProxyIpManager.ProxyIp> jdField_b_of_type_JavaUtilIterator;
  private List<ProxyIpManager.ProxyIp> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  
  public HttpUrlProcessor(AppRuntime paramAppRuntime, String paramString)
  {
    int i = 0;
    this.jdField_b_of_type_Boolean = false;
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
      this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    a(paramAppRuntime);
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    this.jdField_b_of_type_JavaUtilList = ((ProxyIpManager)paramAppRuntime.getManager(3)).getProxyIp(5);
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("HttpUrlProcessor", 4, "HttpUrlProcessor: getProxyIp return null, so new empty ProxyList");
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    a();
  }
  
  public String a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      if (!this.jdField_a_of_type_JavaUtilIterator.hasNext()) {
        if (this.jdField_b_of_type_JavaUtilIterator.hasNext())
        {
          this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp = ((ProxyIpManager.ProxyIp)this.jdField_b_of_type_JavaUtilIterator.next());
          this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        }
        else if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        }
        else
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("HttpUrlProcessor", 4, "getNextUrl: no proxy no host, so return null");
          }
          return null;
        }
      }
      Object localObject2 = (String)this.jdField_a_of_type_JavaUtilIterator.next();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("waterLog- getNextUrl: host[");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("]");
      QLog.e("HttpUrlProcessor", 4, ((StringBuilder)localObject1).toString());
      if (this.jdField_a_of_type_Boolean)
      {
        int i = ((String)localObject2).indexOf(":");
        Object localObject3;
        if (i > 0)
        {
          localObject3 = ((String)localObject2).substring(0, i);
          localObject1 = ((String)localObject2).substring(i + 1);
          localObject2 = localObject3;
        }
        else if (this.jdField_b_of_type_Boolean)
        {
          localObject1 = "443";
        }
        else
        {
          localObject1 = "80";
        }
        if (this.jdField_b_of_type_Boolean)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("https://");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp.ip);
          ((StringBuilder)localObject3).append(":");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp.port);
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
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
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp.ip);
          ((StringBuilder)localObject3).append(":");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp.port);
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject3).append("&bHost=");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("&bPort=");
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject3).toString();
        }
      }
      else if (this.jdField_b_of_type_Boolean)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("https://");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("http://");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
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
  
  public void a()
  {
    this.jdField_b_of_type_JavaUtilIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    if (this.jdField_b_of_type_JavaUtilIterator.hasNext())
    {
      this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp = ((ProxyIpManager.ProxyIp)this.jdField_b_of_type_JavaUtilIterator.next());
      this.jdField_a_of_type_Boolean = true;
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      this.jdField_a_of_type_JavaUtilIterator = localList.iterator();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.filemanager.HttpUrlProcessor
 * JD-Core Version:    0.7.0.1
 */