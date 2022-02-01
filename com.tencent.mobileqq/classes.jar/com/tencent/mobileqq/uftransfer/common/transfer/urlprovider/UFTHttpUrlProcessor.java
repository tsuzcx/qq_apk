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
  private UFTHttpUrlProcessor.FileHttpProxyIp jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTHttpUrlProcessor$FileHttpProxyIp;
  private String jdField_a_of_type_JavaLangString;
  private Iterator<String> jdField_a_of_type_JavaUtilIterator;
  private List<String> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private Iterator<UFTHttpUrlProcessor.FileHttpProxyIp> jdField_b_of_type_JavaUtilIterator;
  private List<UFTHttpUrlProcessor.FileHttpProxyIp> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  
  public UFTHttpUrlProcessor(AppRuntime paramAppRuntime, List<String> paramList, String paramString, boolean paramBoolean)
  {
    int i = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = " ";
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramList = this.jdField_a_of_type_JavaUtilList;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilIterator = paramList.iterator();
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    a(paramAppRuntime);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("init urlProcessor. hostNum:");
    paramList = this.jdField_a_of_type_JavaUtilList;
    if (paramList != null) {
      i = paramList.size();
    }
    paramAppRuntime.append(i);
    paramAppRuntime.append(" proxyIps:");
    paramAppRuntime.append(this.jdField_b_of_type_JavaLangString);
    paramAppRuntime.append(" params:");
    paramAppRuntime.append(this.jdField_a_of_type_JavaLangString);
    paramAppRuntime.append(" isHttps:");
    paramAppRuntime.append(paramBoolean);
    UFTLog.b("[UFTTransfer] UFTHttpUrlProcessor", 1, paramAppRuntime.toString());
  }
  
  private void a()
  {
    this.jdField_b_of_type_JavaUtilIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    if (this.jdField_b_of_type_JavaUtilIterator.hasNext())
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTHttpUrlProcessor$FileHttpProxyIp = ((UFTHttpUrlProcessor.FileHttpProxyIp)this.jdField_b_of_type_JavaUtilIterator.next());
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
  
  private void a(AppRuntime paramAppRuntime)
  {
    this.jdField_b_of_type_JavaUtilList = UFTDependFeatureApi.a(paramAppRuntime);
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    else
    {
      this.jdField_b_of_type_JavaLangString = "";
      int i = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        paramAppRuntime = (UFTHttpUrlProcessor.FileHttpProxyIp)this.jdField_b_of_type_JavaUtilList.get(i);
        if (paramAppRuntime != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
          localStringBuilder.append(paramAppRuntime.toString());
          this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
        }
        i += 1;
      }
    }
    a();
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
          i = paramString.indexOf("://");
          if (i != -1) {
            break label222;
          }
          i = 0;
          str1 = paramString.substring(i);
          if (TextUtils.isEmpty(str1)) {
            return false;
          }
          int k = str1.indexOf("/");
          int j = k;
          if (-1 == k) {
            j = str1.length() - 1;
          }
          k = paramString.indexOf("&bHost=");
          if (-1 != k)
          {
            int m = paramString.indexOf("&bPort=", k);
            if (-1 != m)
            {
              str1 = paramString.substring(k + 7, m);
              str2 = paramString.substring(m + 7);
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
          str1 = paramString.substring(i, j + i);
        }
        catch (Exception paramString)
        {
          boolean bool;
          return false;
        }
        int i = str1.lastIndexOf(":");
        paramString = str1;
        if (i >= 0) {
          paramString = str1.substring(0, i);
        }
        bool = b(paramString);
        return bool;
        i += 3;
      }
    } while (str1 != null);
    return false;
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
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilIterator;
      if (localObject1 != null)
      {
        if (!((Iterator)localObject1).hasNext()) {
          if (this.jdField_b_of_type_JavaUtilIterator.hasNext())
          {
            this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTHttpUrlProcessor$FileHttpProxyIp = ((UFTHttpUrlProcessor.FileHttpProxyIp)this.jdField_b_of_type_JavaUtilIterator.next());
            this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          }
          else if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          }
          else
          {
            UFTLog.b("[UFTTransfer] UFTHttpUrlProcessor", 1, "getNextUrl: no proxy no host, so return null");
            return null;
          }
        }
        String str = (String)this.jdField_a_of_type_JavaUtilIterator.next();
        if (this.jdField_a_of_type_Boolean)
        {
          int i = str.lastIndexOf(":");
          Object localObject3;
          if (i > 0)
          {
            localObject1 = str.substring(0, i);
            localObject2 = str.substring(i + 1);
          }
          else
          {
            if (this.jdField_b_of_type_Boolean) {
              localObject1 = "443";
            } else {
              localObject1 = "80";
            }
            localObject3 = str;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
          if (this.jdField_b_of_type_Boolean)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("https://");
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTHttpUrlProcessor$FileHttpProxyIp.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject3).append(":");
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTHttpUrlProcessor$FileHttpProxyIp.jdField_a_of_type_Int);
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
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
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTHttpUrlProcessor$FileHttpProxyIp.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject3).append(":");
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTHttpUrlProcessor$FileHttpProxyIp.jdField_a_of_type_Int);
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject3).append("&bHost=");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append("&bPort=");
            ((StringBuilder)localObject3).append((String)localObject2);
            localObject1 = ((StringBuilder)localObject3).toString();
          }
        }
        else if (this.jdField_b_of_type_Boolean)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("https://");
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("http://");
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTHttpUrlProcessor
 * JD-Core Version:    0.7.0.1
 */