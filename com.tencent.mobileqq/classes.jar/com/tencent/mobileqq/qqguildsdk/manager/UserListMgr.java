package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.gprosdk.GProGuildUserSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.GProUserSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.manager.cachemgr.AvatarUrlDynamicCacheMgr;
import com.tencent.mobileqq.qqguildsdk.manager.cachemgr.MemberClientIdentityDynamicCacheMgr;
import com.tencent.mobileqq.qqguildsdk.manager.cachemgr.MemberNameDynamicCacheMgr;
import com.tencent.mobileqq.qqguildsdk.manager.cachemgr.NickDynamicCacheMgr;
import com.tencent.mobileqq.qqguildsdk.search.selector.GuildUserSearchUseCase;
import com.tencent.mobileqq.qqguildsdk.search.selector.GuildUserSearchUseCase.AsyncSearchOption;
import com.tencent.mobileqq.qqguildsdk.search.selector.UserSearchEngine;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class UserListMgr
{
  private static long a = 10000L;
  private GPSManagerEngine b;
  private UserSearchEngine c;
  private Map<String, GProUserSimpleProfile> d = new ConcurrentHashMap();
  private Vector<String> e = new Vector();
  private final NickDynamicCacheMgr f;
  private final AvatarUrlDynamicCacheMgr g;
  private final Map<String, MemberNameDynamicCacheMgr> h = new ConcurrentHashMap();
  private final Map<String, MemberClientIdentityDynamicCacheMgr> i = new ConcurrentHashMap();
  
  public UserListMgr(GPSManagerEngine paramGPSManagerEngine)
  {
    this.b = paramGPSManagerEngine;
    this.f = new NickDynamicCacheMgr(paramGPSManagerEngine, this.d, this.e);
    this.g = new AvatarUrlDynamicCacheMgr(paramGPSManagerEngine, this.d, this.e);
  }
  
  private void a(String paramString1, String paramString2, ISearchSink<IGProUserInfo> paramISearchSink)
  {
    GuildUserSearchUseCase.a(paramString2, new GuildUserSearchUseCase.AsyncSearchOption(new UserListMgr.2(this, paramString1), new UserListMgr.3(this)), paramISearchSink);
  }
  
  private UserSearchEngine b()
  {
    if (this.c == null) {
      this.c = new UserListMgr.1(this);
    }
    return this.c;
  }
  
  private void h(String paramString)
  {
    if (!this.h.containsKey(paramString)) {
      this.h.put(paramString, new MemberNameDynamicCacheMgr(this.b, paramString));
    }
  }
  
  private void i(String paramString)
  {
    if (!this.i.containsKey(paramString)) {
      this.i.put(paramString, new MemberClientIdentityDynamicCacheMgr(this.b, paramString));
    }
  }
  
  public Map<String, IGProClientIdentityInfo> a(String paramString1, String paramString2, List<String> paramList)
  {
    i(paramString1);
    return ((MemberClientIdentityDynamicCacheMgr)this.i.get(paramString1)).a(paramList, paramString2);
  }
  
  public Map<String, String> a(String paramString, List<String> paramList)
  {
    h(paramString);
    return ((MemberNameDynamicCacheMgr)this.h.get(paramString)).c(paramList);
  }
  
  public void a(String paramString)
  {
    this.f.d(paramString);
  }
  
  public void a(String paramString1, String paramString2, ISearchSink paramISearchSink, int paramInt)
  {
    if (paramInt == 4)
    {
      a(paramString1, paramString2, paramISearchSink);
      return;
    }
    b().a(paramString1, paramString2, paramISearchSink, paramInt);
  }
  
  public void a(List<GProGuildUserSimpleProfile> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GProGuildUserSimpleProfile localGProGuildUserSimpleProfile = (GProGuildUserSimpleProfile)paramList.next();
      String str = GProConvert.a(localGProGuildUserSimpleProfile.getTinyId());
      if (this.d.containsKey(str)) {
        ((GProUserSimpleProfile)this.d.get(str)).a(localGProGuildUserSimpleProfile);
      } else {
        this.d.put(str, new GProUserSimpleProfile(localGProGuildUserSimpleProfile));
      }
    }
  }
  
  public boolean a(String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    return this.g.a(paramString, paramGuildUserAvatar);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return this.f.a(paramString1, paramString2);
  }
  
  public boolean a(String paramString1, String paramString2, IGProClientIdentityInfo paramIGProClientIdentityInfo)
  {
    i(paramString1);
    return ((MemberClientIdentityDynamicCacheMgr)this.i.get(paramString1)).a(paramString2, paramIGProClientIdentityInfo);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    h(paramString1);
    return ((MemberNameDynamicCacheMgr)this.h.get(paramString1)).d(paramString2, paramString3);
  }
  
  public IGProClientIdentityInfo b(String paramString1, String paramString2, String paramString3)
  {
    i(paramString1);
    return ((MemberClientIdentityDynamicCacheMgr)this.i.get(paramString1)).b(paramString3, paramString2);
  }
  
  public String b(String paramString)
  {
    return this.f.b(paramString);
  }
  
  public Map<String, String> b(List<String> paramList)
  {
    return this.f.b(paramList);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (this.h.containsKey(paramString1)) {
      ((MemberNameDynamicCacheMgr)this.h.get(paramString1)).d(paramString2);
    }
  }
  
  public Map<String, GuildUserAvatar> c(List<String> paramList)
  {
    return this.g.b(paramList);
  }
  
  public void c(String paramString)
  {
    this.g.d(paramString);
  }
  
  public void c(String paramString1, String paramString2)
  {
    h(paramString1);
    ((MemberNameDynamicCacheMgr)this.h.get(paramString1)).b(paramString2);
  }
  
  public GuildUserAvatar d(String paramString)
  {
    return this.g.b(paramString);
  }
  
  public String d(String paramString1, String paramString2)
  {
    h(paramString1);
    return (String)((MemberNameDynamicCacheMgr)this.h.get(paramString1)).c(paramString2);
  }
  
  public void e(String paramString)
  {
    if (this.h.containsKey(paramString)) {
      this.h.remove(paramString);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    if (this.i.containsKey(paramString1)) {
      ((MemberClientIdentityDynamicCacheMgr)this.i.get(paramString1)).a(paramString2);
    }
  }
  
  public String f(String paramString)
  {
    h(paramString);
    return ((MemberNameDynamicCacheMgr)this.h.get(paramString)).a();
  }
  
  public void g(String paramString)
  {
    if (this.i.containsKey(paramString)) {
      this.i.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.UserListMgr
 * JD-Core Version:    0.7.0.1
 */