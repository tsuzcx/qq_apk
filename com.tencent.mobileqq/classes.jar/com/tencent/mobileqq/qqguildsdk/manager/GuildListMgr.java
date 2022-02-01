package com.tencent.mobileqq.qqguildsdk.manager;

import android.text.TextUtils;
import com.tencent.gprosdk.GProGuild;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.search.model.ISearchResultModel;
import com.tencent.mobileqq.qqguildsdk.search.model.SearchResultModel;
import com.tencent.mobileqq.qqguildsdk.search.selector.GuildSearchEngine;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.util.GProUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class GuildListMgr
{
  private GPSManagerEngine a;
  private GuildSearchEngine b;
  private Map<String, GProGuildInfo> c = new ConcurrentHashMap();
  private byte[] d = new byte[0];
  private Map<String, IFetchGuildInfoCallback> e = new ConcurrentHashMap();
  private Set<String> f = new ConcurrentSkipListSet();
  private Map<String, Long> g = new ConcurrentHashMap();
  private boolean h = true;
  private Set<String> i = new ConcurrentSkipListSet();
  private Map<String, Long> j = new ConcurrentHashMap();
  
  public GuildListMgr(GPSManagerEngine paramGPSManagerEngine)
  {
    this.a = paramGPSManagerEngine;
  }
  
  private GProGuildInfo b(GuildMsgNode paramGuildMsgNode)
  {
    GProGuildInfo localGProGuildInfo = new GProGuildInfo(paramGuildMsgNode);
    this.c.put(paramGuildMsgNode.a(), localGProGuildInfo);
    return localGProGuildInfo;
  }
  
  private GProGuildInfo b(String paramString, GProGuildInfo paramGProGuildInfo)
  {
    this.c.put(paramString, paramGProGuildInfo);
    return paramGProGuildInfo;
  }
  
  private GuildSearchEngine e()
  {
    if (this.b == null) {
      this.b = new GuildListMgr.1(this);
    }
    return this.b;
  }
  
  private Iterable<Map.Entry<String, GProGuildInfo>> f()
  {
    return this.c.entrySet();
  }
  
  private void h(String paramString)
  {
    StringBuilder localStringBuilder;
    if (!this.j.containsKey(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId: ");
      localStringBuilder.append(paramString);
      GProLog.a("GuildListMgr", false, "cache", "refreshGuildWithTimeLimit ", "mGuildRefreshTimeMap not have ", localStringBuilder.toString());
      this.a.f(paramString, true);
      return;
    }
    if (System.currentTimeMillis() - ((Long)this.j.get(paramString)).longValue() < 60000L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId: ");
      localStringBuilder.append(paramString);
      GProLog.a("GuildListMgr", false, "cache", "refreshGuildWithTimeLimit ", "cache--no need to refresh(time<30s)", localStringBuilder.toString());
      return;
    }
    this.a.f(paramString, false);
  }
  
  public IGProGuildInfo a(GuildMsgNode paramGuildMsgNode)
  {
    if (e(paramGuildMsgNode.a()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId ：");
      localStringBuilder.append(paramGuildMsgNode.a());
      GProLog.a("GuildListMgr", false, "msg push", "fetchGuildInfo ", "该站点信息已存在，reflash", localStringBuilder.toString());
      return ((GProGuildInfo)this.c.get(paramGuildMsgNode.a())).reflash(paramGuildMsgNode);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(paramGuildMsgNode.a());
    GProLog.a("GuildListMgr", false, "cache", "fetchGuildInfo ", "cache没有该站点信息，存入", localStringBuilder.toString());
    return b(paramGuildMsgNode);
  }
  
  public IGProGuildInfo a(String paramString, GProGuildInfo paramGProGuildInfo)
  {
    long l = System.currentTimeMillis();
    this.j.put(paramString, Long.valueOf(l));
    if (e(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId ：");
      localStringBuilder.append(paramString);
      GProLog.a("GuildListMgr", false, "cache", "fetchGuildInfo ", "该站点信息已存在，reflash", localStringBuilder.toString());
      return ((GProGuildInfo)this.c.get(paramString)).reflash(paramGProGuildInfo.getGuild());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(paramString);
    GProLog.a("GuildListMgr", false, "cache", "fetchGuildInfo ", "cache没有该站点信息，存入", localStringBuilder.toString());
    return b(paramString, paramGProGuildInfo);
  }
  
  public IGProGuildInfo a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramString1 = d(paramString1);
    if (paramString1 != null) {
      paramString1.setGuildName(paramString2);
    }
    return paramString1;
  }
  
  public IGProGuildInfo a(String paramString, boolean paramBoolean)
  {
    paramString = d(paramString);
    if (paramString != null) {
      paramString.setTop(paramBoolean);
    }
    return paramString;
  }
  
  public List<ISearchResultModel<IGProGuildInfo>> a(String paramString, ArrayList<GProGuild> paramArrayList)
  {
    Object localObject1 = new HashMap();
    paramArrayList = paramArrayList.iterator();
    Object localObject2;
    while (paramArrayList.hasNext())
    {
      localObject2 = (GProGuild)paramArrayList.next();
      long l = ((GProGuild)localObject2).getShowNumber();
      if (!((Map)localObject1).containsKey(Long.valueOf(l))) {
        ((Map)localObject1).put(Long.valueOf(l), new ArrayList());
      }
      ((List)((Map)localObject1).get(Long.valueOf(l))).add(new GProGuildInfo((GProGuild)localObject2));
    }
    paramArrayList = new ArrayList();
    if (((Map)localObject1).size() > 0)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        SearchResultModel localSearchResultModel = new SearchResultModel(paramString);
        localSearchResultModel.a((List)((Map.Entry)localObject2).getValue());
        paramArrayList.add(localSearchResultModel);
      }
    }
    return paramArrayList;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.f.contains(paramString))
    {
      this.f.remove(paramString);
      if (paramInt == 0) {
        this.a.a(4, "deleteChangeWithChannel", paramString);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.h)
    {
      this.i.remove(paramString);
      if (this.i.size() == 0)
      {
        if (c().size() > 0)
        {
          this.a.a(1, "deleteFirstLoadGuildId", null);
          this.a.a(19, "deleteFirstLoadGuildId", c());
        }
        this.h = false;
      }
    }
  }
  
  public void a(String paramString, int paramInt, ISearchSink<IGProGuildInfo> paramISearchSink, boolean paramBoolean)
  {
    e().a(paramString, paramInt, paramISearchSink, paramBoolean);
  }
  
  public void a(String paramString, IFetchGuildInfoCallback paramIFetchGuildInfoCallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramIFetchGuildInfoCallback != null)) {
      this.e.put(paramString, paramIFetchGuildInfoCallback);
    }
  }
  
  public void a(ArrayList<GProGuildInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    this.c.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      GProGuildInfo localGProGuildInfo = (GProGuildInfo)paramArrayList.next();
      b(localGProGuildInfo.getGuildID(), localGProGuildInfo);
    }
  }
  
  public void a(ArrayList<String> paramArrayList, ArrayList<GProGuildInfo> paramArrayList1)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.a.d(str, false);
    }
    b(paramArrayList1);
    e().a(true);
  }
  
  public void a(List<GProGuildInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GProGuildInfo localGProGuildInfo = (GProGuildInfo)paramList.next();
      this.i.add(localGProGuildInfo.getGuildID());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public List<IGProGuildInfo> b()
  {
    d();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = f().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (this.a.d((String)localEntry.getKey())) {
        localArrayList.add(localEntry.getValue());
      }
    }
    return localArrayList;
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.e.containsKey(paramString))
    {
      ((IFetchGuildInfoCallback)this.e.get(paramString)).a(paramInt, "", d(paramString));
      this.e.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    GProUtil.a(this.g);
    if (this.g.containsKey(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId ：");
      localStringBuilder.append(paramString);
      GProLog.b("GuildListMgr", false, "msg push", "addFetchIdForMsg", "guild fetching", localStringBuilder.toString());
      return;
    }
    this.g.put(paramString, Long.valueOf(System.currentTimeMillis()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(paramString);
    GProLog.a("GuildListMgr", false, "msg push", "addFetchIdForMsg", "guild start fetch", localStringBuilder.toString());
    this.a.a(paramString, true, null);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(ArrayList<GProGuildInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      GProGuildInfo localGProGuildInfo = (GProGuildInfo)paramArrayList.next();
      a(localGProGuildInfo.getGuildID(), localGProGuildInfo);
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString1 = d(paramString1);
    if (paramString1 == null) {
      return false;
    }
    paramString1.setProfile(paramString2);
    return true;
  }
  
  public List<String> c()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = f().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (this.a.d((String)localEntry.getKey())) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public void c(int paramInt, String paramString)
  {
    d(paramInt, paramString);
    a(paramString);
    a(paramInt, paramString);
  }
  
  public void c(String paramString)
  {
    if (this.g.containsKey(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId ：");
      localStringBuilder.append(paramString);
      GProLog.b("GuildListMgr", false, "msg push", "deleteRecords", "delete guild fetch record", localStringBuilder.toString());
      this.g.remove(paramString);
    }
  }
  
  public GProGuildInfo d(String paramString)
  {
    if (!e(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGuildInfo with error guildId：");
      localStringBuilder.append(paramString);
      GProLog.b("GuildListMgr", false, "sdk interface", localStringBuilder.toString());
      return null;
    }
    h(paramString);
    return (GProGuildInfo)this.c.get(paramString);
  }
  
  public void d()
  {
    this.a.a(false);
  }
  
  public void d(int paramInt, String paramString)
  {
    b(paramInt, paramString);
    c(paramString);
  }
  
  public boolean e(String paramString)
  {
    return (!GProUtil.a(paramString)) && (this.c.containsKey(paramString));
  }
  
  public void f(String paramString)
  {
    this.f.add(paramString);
  }
  
  public void g(String paramString)
  {
    if (e(paramString)) {
      this.c.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.GuildListMgr
 * JD-Core Version:    0.7.0.1
 */