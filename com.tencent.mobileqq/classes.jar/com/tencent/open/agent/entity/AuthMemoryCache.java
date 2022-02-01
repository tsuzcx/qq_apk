package com.tencent.open.agent.entity;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AuthMemoryCache
{
  private Set<String> jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<String, GetVirtualListResult> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, AccountInfo> b = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<Permission>> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, AppInfoResponse> d = new ConcurrentHashMap();
  private ConcurrentHashMap<String, preAuth.PreAuthResponse> e = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> f = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Bundle> g = new ConcurrentHashMap();
  
  public static AuthMemoryCache a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof AbstractOpenSdkAppInterface)) {
      return ((AbstractOpenSdkAppInterface)localAppRuntime).a();
    }
    return new AuthMemoryCache();
  }
  
  public long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    paramString = (Long)this.f.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public Bundle a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (Bundle)this.g.get(paramString);
  }
  
  public AppInfoResponse a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (AppInfoResponse)this.d.get(paramString);
  }
  
  public AccountInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (AccountInfo)this.b.get(paramString);
  }
  
  public GetVirtualListResult a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (GetVirtualListResult)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public preAuth.PreAuthResponse a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (preAuth.PreAuthResponse)this.e.get(paramString);
  }
  
  public List<Permission> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (List)this.c.get(paramString);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addForce540Account uin=");
    localStringBuilder.append(AuthorityUtil.a(paramString));
    SSOLog.a("AuthMemoryCache", new Object[] { localStringBuilder.toString() });
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.f.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null)) {
      this.g.put(paramString, paramBundle);
    }
  }
  
  public void a(String paramString, AppInfoResponse paramAppInfoResponse)
  {
    SSOLog.a("AuthMemoryCache", new Object[] { "putPreAuthAppInfo=", paramAppInfoResponse });
    this.d.put(paramString, paramAppInfoResponse);
  }
  
  public void a(String paramString, AccountInfo paramAccountInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramAccountInfo != null)) {
      this.b.put(paramString, paramAccountInfo);
    }
  }
  
  public void a(String paramString, GetVirtualListResult paramGetVirtualListResult)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramGetVirtualListResult != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramGetVirtualListResult);
    }
  }
  
  public void a(String paramString, preAuth.PreAuthResponse paramPreAuthResponse)
  {
    this.e.put(paramString, paramPreAuthResponse);
  }
  
  public void a(String paramString, List<Permission> paramList)
  {
    this.c.put(paramString, paramList);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isForceTo540 uin=");
    localStringBuilder.append(AuthorityUtil.a(paramString));
    localStringBuilder.append(", force540=");
    localStringBuilder.append(bool);
    SSOLog.a("AuthMemoryCache", new Object[] { localStringBuilder.toString() });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.entity.AuthMemoryCache
 * JD-Core Version:    0.7.0.1
 */