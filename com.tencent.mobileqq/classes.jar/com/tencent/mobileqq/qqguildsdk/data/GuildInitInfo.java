package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProGuildInit;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class GuildInitInfo
{
  HashMap<String, GProChannelInfo> a;
  CategoryChannelSortInfo b;
  List<CategoryChannelSortInfo> c;
  
  public GuildInitInfo(GProGuildInit paramGProGuildInit)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GuildInitInfo guildID :");
    ((StringBuilder)localObject).append(paramGProGuildInit.getGuildId());
    GProLog.a("GuildInitInfo", true, "system convert", ((StringBuilder)localObject).toString());
    this.a = GProConvert.a(paramGProGuildInit.getChannelMap());
    this.b = GProConvert.a(paramGProGuildInit.getUncategorizedChannels());
    this.c = GProConvert.f(paramGProGuildInit.getCategoryList());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GuildInitInfo mUncategorizedChannels :");
    ((StringBuilder)localObject).append(this.b.c().size());
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(this.b);
    GProLog.a("GuildInitInfo", false, "system convert", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GuildInitInfo mCategoryList :");
    ((StringBuilder)localObject).append(this.c.size());
    GProLog.a("GuildInitInfo", false, "system convert", ((StringBuilder)localObject).toString());
    int i;
    if (this.b.c().size() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (i != 0)
    {
      localObject = this.c.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        CategoryChannelSortInfo localCategoryChannelSortInfo = (CategoryChannelSortInfo)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GuildInitInfo CategoryChannelSortInfo :");
        localStringBuilder.append(localCategoryChannelSortInfo.a());
        localStringBuilder.append(": ");
        localStringBuilder.append(localCategoryChannelSortInfo.c().size());
        GProLog.a("GuildInitInfo", true, "system convert", localStringBuilder.toString());
        if ((localCategoryChannelSortInfo.a(true)) && (localCategoryChannelSortInfo.e())) {
          i = 0;
        }
      }
    }
    if (j != 0)
    {
      GProLog.b("GuildInitInfo", true, "system convert", "GuildInitInfo ", "is null, need to add mock category", paramGProGuildInit.toString());
      paramGProGuildInit = this.a.entrySet().iterator();
      while (paramGProGuildInit.hasNext())
      {
        localObject = (Map.Entry)paramGProGuildInit.next();
        this.b.a((String)((Map.Entry)localObject).getKey());
      }
      GProLog.b("GuildInitInfo", true, "system convert", "GuildInitInfo ", "mock mUncategorizedChannels size ", this.b.c().size());
    }
  }
  
  public HashMap<String, GProChannelInfo> a()
  {
    return this.a;
  }
  
  public CategoryChannelSortInfo b()
  {
    return this.b;
  }
  
  public List<CategoryChannelSortInfo> c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    HashMap localHashMap = this.a;
    boolean bool = true;
    if (localHashMap != null)
    {
      if (localHashMap.size() == 0) {
        return true;
      }
      if (this.b == null) {
        this.b = new CategoryChannelSortInfo("", 0L);
      }
      if (this.c == null) {
        this.c = new ArrayList();
      }
      if ((this.b.c().size() == 0) && (this.c.size() == 0)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GuildInitInfo
 * JD-Core Version:    0.7.0.1
 */