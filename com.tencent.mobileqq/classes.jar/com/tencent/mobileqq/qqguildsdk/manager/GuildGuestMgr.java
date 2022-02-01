package com.tencent.mobileqq.qqguildsdk.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.CategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildInitInfo;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class GuildGuestMgr
{
  private Map<String, GProGuildInfo> a = new ConcurrentHashMap();
  private Map<String, Vector<CategoryInfo>> b = new ConcurrentHashMap();
  private Map<String, Map<String, IGProChannelInfo>> c = new ConcurrentHashMap();
  private Vector<String> d = new Vector();
  private Map<String, GProGuildInfo> e = new ConcurrentHashMap();
  private Vector<String> f = new Vector();
  
  private void a()
  {
    if ((this.d.size() > 0) && (this.a.size() > 20)) {
      f((String)this.d.remove(0));
    }
  }
  
  private void a(String paramString, Vector<CategoryInfo> paramVector)
  {
    if (paramVector != null)
    {
      if (paramVector.size() == 0) {
        return;
      }
      if (!this.c.containsKey(paramString)) {
        this.c.put(paramString, new ConcurrentHashMap());
      }
      paramString = (Map)this.c.get(paramString);
      paramVector = paramVector.iterator();
      while (paramVector.hasNext())
      {
        Object localObject = ((CategoryInfo)paramVector.next()).c();
        if ((localObject != null) && (((List)localObject).size() != 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)((Iterator)localObject).next();
            paramString.put(localIGProChannelInfo.getChannelUin(), localIGProChannelInfo);
          }
        }
      }
    }
  }
  
  private Vector<CategoryInfo> e(String paramString)
  {
    if (!this.b.containsKey(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId : ");
      localStringBuilder.append(paramString);
      GProLog.b("GuildGuestMgr", true, "cache", "getChannelCategoryMap ", "do not find ChannelCategoryMap", localStringBuilder.toString());
      return new Vector();
    }
    return (Vector)this.b.get(paramString);
  }
  
  private void f(String paramString)
  {
    this.a.remove(paramString);
    this.c.remove(paramString);
    this.b.remove(paramString);
  }
  
  private void g(String paramString)
  {
    this.d.remove(paramString);
    this.d.add(paramString);
  }
  
  public IGProChannelInfo a(String paramString1, String paramString2)
  {
    if (!this.c.containsKey(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId : ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", channelUin:");
      localStringBuilder.append(paramString2);
      GProLog.b("GuildGuestMgr", true, "cache", "getChannelCategoryForGuest ", "do not find ChannelInfo", localStringBuilder.toString());
      return null;
    }
    return (IGProChannelInfo)((Map)this.c.get(paramString1)).get(paramString2);
  }
  
  public List<ICategoryInfo> a(String paramString)
  {
    return GProConvert.a(e(paramString));
  }
  
  public void a(String paramString, GProGuildInfo paramGProGuildInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramGProGuildInfo == null) {
        return;
      }
      if ((!this.e.containsKey(paramString)) && (this.e.size() > 100) && (this.f.size() > 0))
      {
        String str = (String)this.f.remove(0);
        this.e.remove(str);
      }
      this.e.put(paramString, paramGProGuildInfo);
      this.f.remove(paramString);
      this.f.add(paramString);
    }
  }
  
  public void a(String paramString, GProGuildInfo paramGProGuildInfo, GuildInitInfo paramGuildInitInfo)
  {
    if (paramGProGuildInfo == null) {
      return;
    }
    if (paramGProGuildInfo.isMember())
    {
      paramGProGuildInfo = new StringBuilder();
      paramGProGuildInfo.append("guildId : ");
      paramGProGuildInfo.append(paramString);
      GProLog.b("GuildGuestMgr", true, "cache", "fetchGuestGuild ", "the user is the member of this guild, not guest", paramGProGuildInfo.toString());
      return;
    }
    paramGuildInitInfo = GProConvert.a(paramGuildInitInfo);
    if (paramGuildInitInfo == null) {
      return;
    }
    a();
    this.b.put(paramString, paramGuildInitInfo);
    a(paramString, paramGuildInitInfo);
    this.a.put(paramString, paramGProGuildInfo);
    g(paramString);
  }
  
  public IGProGuildInfo b(String paramString)
  {
    if (!this.a.containsKey(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId : ");
      localStringBuilder.append(paramString);
      GProLog.b("GuildGuestMgr", true, "cache", "getGuildInfoForGuest ", "do not find GProGuildInfo", localStringBuilder.toString());
      return null;
    }
    return (IGProGuildInfo)this.a.get(paramString);
  }
  
  public IGProGuildInfo c(String paramString)
  {
    return (IGProGuildInfo)this.e.get(paramString);
  }
  
  public void d(String paramString)
  {
    if (this.d.contains(paramString))
    {
      f(paramString);
      this.d.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.GuildGuestMgr
 * JD-Core Version:    0.7.0.1
 */