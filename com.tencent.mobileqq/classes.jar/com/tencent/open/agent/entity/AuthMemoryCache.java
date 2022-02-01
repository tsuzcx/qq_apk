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
  private Set<String> a = new CopyOnWriteArraySet();
  private ConcurrentHashMap<String, GetVirtualListResult> b = new ConcurrentHashMap();
  private ConcurrentHashMap<String, AccountInfo> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<Permission>> d = new ConcurrentHashMap();
  private ConcurrentHashMap<String, AppInfoResponse> e = new ConcurrentHashMap();
  private ConcurrentHashMap<String, preAuth.PreAuthResponse> f = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> g = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Bundle> h = new ConcurrentHashMap();
  
  public static AuthMemoryCache a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof AbstractOpenSdkAppInterface)) {
      return ((AbstractOpenSdkAppInterface)localAppRuntime).a();
    }
    return new AuthMemoryCache();
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addForce540Account uin=");
    localStringBuilder.append(AuthorityUtil.a(paramString));
    SSOLog.a("AuthMemoryCache", new Object[] { localStringBuilder.toString() });
    this.a.add(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.g.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null)) {
      this.h.put(paramString, paramBundle);
    }
  }
  
  public void a(String paramString, AppInfoResponse paramAppInfoResponse)
  {
    SSOLog.a("AuthMemoryCache", new Object[] { "putPreAuthAppInfo=", paramAppInfoResponse });
    this.e.put(paramString, paramAppInfoResponse);
  }
  
  public void a(String paramString, AccountInfo paramAccountInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramAccountInfo != null)) {
      this.c.put(paramString, paramAccountInfo);
    }
  }
  
  public void a(String paramString, GetVirtualListResult paramGetVirtualListResult)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramGetVirtualListResult != null)) {
      this.b.put(paramString, paramGetVirtualListResult);
    }
  }
  
  public void a(String paramString, preAuth.PreAuthResponse paramPreAuthResponse)
  {
    this.f.put(paramString, paramPreAuthResponse);
  }
  
  public void a(String paramString, List<Permission> paramList)
  {
    this.d.put(paramString, paramList);
  }
  
  public boolean b(String paramString)
  {
    boolean bool = this.a.contains(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isForceTo540 uin=");
    localStringBuilder.append(AuthorityUtil.a(paramString));
    localStringBuilder.append(", force540=");
    localStringBuilder.append(bool);
    SSOLog.a("AuthMemoryCache", new Object[] { localStringBuilder.toString() });
    return bool;
  }
  
  public GetVirtualListResult c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (GetVirtualListResult)this.b.get(paramString);
  }
  
  public AccountInfo d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (AccountInfo)this.c.get(paramString);
  }
  
  public List<Permission> e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (List)this.d.get(paramString);
  }
  
  public AppInfoResponse f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (AppInfoResponse)this.e.get(paramString);
  }
  
  public preAuth.PreAuthResponse g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (preAuth.PreAuthResponse)this.f.get(paramString);
  }
  
  public long h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    paramString = (Long)this.g.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public Bundle i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (Bundle)this.h.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.entity.AuthMemoryCache
 * JD-Core Version:    0.7.0.1
 */