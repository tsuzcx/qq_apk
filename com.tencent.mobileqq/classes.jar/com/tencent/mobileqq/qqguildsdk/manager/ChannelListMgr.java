package com.tencent.mobileqq.qqguildsdk.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.CategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.ChannelMsgNode;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildInitInfo;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

public class ChannelListMgr
{
  private GPSManagerEngine a;
  private Map<String, GProChannelInfo> b = new ConcurrentHashMap();
  private Map<String, Vector<CategoryInfo>> c = new ConcurrentHashMap();
  private Map<String, Long> d = new ConcurrentHashMap();
  private boolean e = true;
  
  public ChannelListMgr(GPSManagerEngine paramGPSManagerEngine)
  {
    this.a = paramGPSManagerEngine;
  }
  
  private CategoryInfo a(CategoryChannelSortInfo paramCategoryChannelSortInfo, List<String> paramList, boolean paramBoolean)
  {
    if ((paramCategoryChannelSortInfo != null) && (paramCategoryChannelSortInfo.a(paramBoolean)))
    {
      CategoryInfo localCategoryInfo = new CategoryInfo(paramCategoryChannelSortInfo.a(), paramCategoryChannelSortInfo.b());
      if (paramCategoryChannelSortInfo.e())
      {
        paramCategoryChannelSortInfo = paramCategoryChannelSortInfo.c().iterator();
        while (paramCategoryChannelSortInfo.hasNext())
        {
          String str = (String)paramCategoryChannelSortInfo.next();
          if (h(str))
          {
            GProChannelInfo localGProChannelInfo = (GProChannelInfo)this.b.get(str);
            if (localGProChannelInfo != null)
            {
              if (paramList != null) {
                paramList.add(str);
              }
              localGProChannelInfo.setCategory(localCategoryInfo.b(), localCategoryInfo.a());
              localCategoryInfo.a(localGProChannelInfo);
            }
          }
        }
      }
      return localCategoryInfo;
    }
    return null;
  }
  
  private GProChannelInfo a(String paramString, GProChannelInfo paramGProChannelInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("putChannel ");
    localStringBuilder.append(paramString);
    GProLog.a("ChannelListMgr", true, "cache", localStringBuilder.toString());
    return (GProChannelInfo)this.b.put(paramString, paramGProChannelInfo);
  }
  
  private void a(Map<String, GuildInitInfo> paramMap)
  {
    if ((paramMap == null) && (paramMap.size() == 0)) {
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      a((String)localEntry.getKey(), (GuildInitInfo)localEntry.getValue());
    }
  }
  
  private GProChannelInfo b(String paramString, ChannelMsgNode paramChannelMsgNode)
  {
    if (paramChannelMsgNode == null) {
      return null;
    }
    paramChannelMsgNode = new GProChannelInfo(paramString, paramChannelMsgNode);
    paramChannelMsgNode.setCategory(0L, "");
    a(paramChannelMsgNode.getChannelUin(), paramChannelMsgNode);
    if (!j(paramString)) {
      this.c.put(paramString, CategoryInfo.a("", 0L));
    }
    ((CategoryInfo)((Vector)this.c.get(paramString)).get(0)).a(paramChannelMsgNode);
    return paramChannelMsgNode;
  }
  
  private void c(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    if (!this.d.containsKey(localObject))
    {
      this.a.c(paramString1, paramString2, true);
      return;
    }
    if (System.currentTimeMillis() - ((Long)this.d.get(localObject)).longValue() < 60000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("guildId ：");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("， channelId ：");
      ((StringBuilder)localObject).append(paramString2);
      GProLog.a("ChannelListMgr", false, "cache", "refreshChannelWIthTimeLimit ", "cache--no need to refresh(time<30s)", ((StringBuilder)localObject).toString());
      return;
    }
    this.a.c(paramString1, paramString2, false);
  }
  
  private List<String> h(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Vector localVector = CategoryInfo.d();
    paramCategoryChannelSortInfo = a(paramCategoryChannelSortInfo, localArrayList, false);
    if (paramCategoryChannelSortInfo != null) {
      localVector.add(paramCategoryChannelSortInfo);
    } else {
      localVector.add(new CategoryInfo("", 0L));
    }
    paramCategoryChannelSortInfo = paramList.iterator();
    while (paramCategoryChannelSortInfo.hasNext())
    {
      paramList = a((CategoryChannelSortInfo)paramCategoryChannelSortInfo.next(), localArrayList, true);
      if (paramList != null) {
        localVector.add(paramList);
      }
    }
    this.c.put(paramString, localVector);
    return localArrayList;
  }
  
  private boolean j(String paramString)
  {
    return this.c.containsKey(paramString);
  }
  
  public IGProChannelInfo a(GProChannelInfo paramGProChannelInfo)
  {
    if (paramGProChannelInfo == null) {
      return null;
    }
    Object localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramGProChannelInfo.getGuildId());
    localStringBuilder.append(paramGProChannelInfo.getChannelUin());
    ((Map)localObject).put(localStringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
    if (h(paramGProChannelInfo.getChannelUin()))
    {
      localObject = (GProChannelInfo)this.b.get(paramGProChannelInfo.getChannelUin());
      if (paramGProChannelInfo.getMyMsgNotify() != ((GProChannelInfo)localObject).getMyMsgNotify())
      {
        ((GProChannelInfo)localObject).setMyMsgNotify(paramGProChannelInfo.getMyMsgNotify());
        this.a.a(12, "fetchChannelInfo", paramGProChannelInfo.getGuildId(), paramGProChannelInfo.getChannelUin(), Integer.valueOf(paramGProChannelInfo.getMyMsgNotify()));
      }
      if (paramGProChannelInfo.getFinalMsgNotify() != ((GProChannelInfo)localObject).getFinalMsgNotify())
      {
        ((GProChannelInfo)localObject).setFinalMsgNotify(paramGProChannelInfo.getFinalMsgNotify());
        this.a.a(12, "fetchChannelInfo", paramGProChannelInfo.getGuildId(), paramGProChannelInfo.getChannelUin(), Integer.valueOf(paramGProChannelInfo.getFinalMsgNotify()));
      }
      ((GProChannelInfo)localObject).reflash(paramGProChannelInfo.getChannel());
      return paramGProChannelInfo;
    }
    a(paramGProChannelInfo.getChannelUin(), paramGProChannelInfo);
    return paramGProChannelInfo;
  }
  
  public IGProChannelInfo a(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if (paramString != null) {
      paramString.setTalkPermission(paramInt);
    }
    return paramString;
  }
  
  public IGProChannelInfo a(String paramString, long paramLong)
  {
    paramString = e(paramString);
    if (paramString != null) {
      paramString.setLiveRoomId(paramLong);
    }
    return paramString;
  }
  
  public IGProChannelInfo a(String paramString, ChannelMsgNode paramChannelMsgNode)
  {
    if (h(paramChannelMsgNode.a()))
    {
      GProChannelInfo localGProChannelInfo = (GProChannelInfo)this.b.get(paramChannelMsgNode.a());
      if ((paramChannelMsgNode.d() != -1000) && (paramChannelMsgNode.d() != localGProChannelInfo.getMyMsgNotify()))
      {
        localGProChannelInfo.setMyMsgNotify(paramChannelMsgNode.d());
        this.a.a(12, "fetchChannelInfo", paramString, paramChannelMsgNode.a(), Integer.valueOf(paramChannelMsgNode.d()));
      }
      if ((paramChannelMsgNode.e() != -1000) && (paramChannelMsgNode.e() != localGProChannelInfo.getFinalMsgNotify()))
      {
        localGProChannelInfo.setFinalMsgNotify(paramChannelMsgNode.e());
        this.a.a(12, "fetchChannelInfo", paramString, paramChannelMsgNode.a(), Integer.valueOf(paramChannelMsgNode.e()));
      }
      return ((GProChannelInfo)this.b.get(paramChannelMsgNode.a())).reflash(paramChannelMsgNode);
    }
    return b(paramString, paramChannelMsgNode);
  }
  
  public IGProChannelInfo a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = e(paramString1);
      if (paramString1 != null) {
        paramString1.setName(paramString2);
      }
      return paramString1;
    }
    return null;
  }
  
  public void a()
  {
    this.b.clear();
    this.c.clear();
    this.d.clear();
  }
  
  public void a(GProChannelInfo paramGProChannelInfo, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    String str = "";
    if (paramGProChannelInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("guildId ：");
      ((StringBuilder)localObject).append(paramGProChannelInfo.getGuildId());
      ((StringBuilder)localObject).append(", channelId:");
      ((StringBuilder)localObject).append(paramGProChannelInfo.getChannelUin());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    GProLog.a("ChannelListMgr", false, "cache", "fetchChannelInfoWithSort", "new id", (String)localObject);
    IGProChannelInfo localIGProChannelInfo = a(paramGProChannelInfo);
    Object localObject = str;
    if (localIGProChannelInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("guildId ：");
      ((StringBuilder)localObject).append(localIGProChannelInfo.getGuildId());
      ((StringBuilder)localObject).append(", channelId:");
      ((StringBuilder)localObject).append(localIGProChannelInfo.getChannelUin());
      localObject = ((StringBuilder)localObject).toString();
    }
    GProLog.a("ChannelListMgr", false, "cache", "fetchChannelInfoWithSort", "return info： ", (String)localObject);
    g(paramGProChannelInfo.getGuildId(), paramCategoryChannelSortInfo, paramList);
  }
  
  public void a(String paramString)
  {
    if (j(paramString))
    {
      Iterator localIterator = f(paramString).iterator();
      while (localIterator.hasNext())
      {
        IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)localIterator.next();
        this.b.remove(localIGProChannelInfo.getChannelUin());
      }
      this.c.remove(paramString);
    }
  }
  
  public void a(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    g(paramString, paramCategoryChannelSortInfo, paramList);
  }
  
  public void a(String paramString, GuildInitInfo paramGuildInitInfo)
  {
    a(paramString, paramGuildInitInfo.a(), paramGuildInitInfo.b(), paramGuildInitInfo.c());
  }
  
  public void a(String paramString, Map<String, GProChannelInfo> paramMap, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    if ((paramMap != null) && (paramMap.size() != 0))
    {
      CategoryChannelSortInfo localCategoryChannelSortInfo = paramCategoryChannelSortInfo;
      if (paramCategoryChannelSortInfo == null) {
        localCategoryChannelSortInfo = new CategoryChannelSortInfo("", 0L);
      }
      paramCategoryChannelSortInfo = paramList;
      if (paramList == null) {
        paramCategoryChannelSortInfo = new ArrayList();
      }
      paramList = new StringBuilder();
      paramList.append("guildId ：");
      paramList.append(paramString);
      paramList.append("， uncategorizedChannels size：");
      paramList.append(localCategoryChannelSortInfo.c().size());
      paramList.append(", categoryList size:");
      paramList.append(paramCategoryChannelSortInfo.size());
      GProLog.a("ChannelListMgr", false, "cache", "fetchChannelListWithSort ", "show categery", paramList.toString());
      if ((!localCategoryChannelSortInfo.e()) && (paramCategoryChannelSortInfo.size() == 0))
      {
        paramList = paramMap.entrySet().iterator();
        while (paramList.hasNext()) {
          localCategoryChannelSortInfo.a((String)((Map.Entry)paramList.next()).getKey());
        }
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext()) {
        a((GProChannelInfo)((Map.Entry)paramMap.next()).getValue());
      }
      paramMap = f(paramString);
      paramCategoryChannelSortInfo = h(paramString, localCategoryChannelSortInfo, paramCategoryChannelSortInfo);
      paramMap = paramMap.iterator();
      while (paramMap.hasNext())
      {
        paramList = (IGProChannelInfo)paramMap.next();
        if (!paramCategoryChannelSortInfo.contains(paramList.getChannelUin())) {
          d(paramList.getChannelUin());
        }
      }
      if (f(paramString).size() == 0)
      {
        paramMap = new StringBuilder();
        paramMap.append("guildId ：");
        paramMap.append(paramString);
        GProLog.b("ChannelListMgr", true, "cache", "fetchChannelList ", "sdk-cache delete invalid guild", paramMap.toString());
        this.a.a(18, "fetchChannelListWithSort", paramString);
      }
      return;
    }
    paramMap = new StringBuilder();
    paramMap.append("guildId ：");
    paramMap.append(paramString);
    GProLog.b("ChannelListMgr", true, "cache", "fetchChannelListWithSort ", "channelMap is null", paramMap.toString());
  }
  
  public void a(HashMap<String, GuildInitInfo> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    a();
    a(paramHashMap);
  }
  
  public IGProChannelInfo b(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if (paramString != null) {
      paramString.setBannedSpeak(paramInt);
    }
    return paramString;
  }
  
  public IGProChannelInfo b(String paramString, long paramLong)
  {
    paramString = e(paramString);
    if (paramString != null) {
      paramString.setLiveAnchorTinyId(paramLong);
    }
    return paramString;
  }
  
  public IGProChannelInfo b(String paramString1, String paramString2)
  {
    paramString1 = e(paramString1);
    if (paramString1 != null) {
      paramString1.setLiveRoomName(paramString2);
    }
    return paramString1;
  }
  
  public List<ICategoryInfo> b(String paramString)
  {
    return GProConvert.a((Vector)this.c.get(paramString));
  }
  
  public void b(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    g(paramString, paramCategoryChannelSortInfo, paramList);
  }
  
  public void b(String paramString, GuildInitInfo paramGuildInitInfo)
  {
    if (paramGuildInitInfo == null) {
      return;
    }
    HashMap localHashMap = paramGuildInitInfo.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (GProChannelInfo)localHashMap.get(paramString);
      a(paramString, paramGuildInitInfo.b(), paramGuildInitInfo.c());
      this.a.a(6, "fetchChannelInfoWithSort", paramString);
    }
  }
  
  public IGProChannelInfo c(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if (paramString != null) {
      paramString.setMyMsgNotify(paramInt);
    }
    return paramString;
  }
  
  public Vector<CategoryInfo> c(String paramString)
  {
    if (!j(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId : ");
      localStringBuilder.append(paramString);
      GProLog.b("ChannelListMgr", true, "cache", "getChannelCategoryMap ", "do not find ChannelCategoryMap", localStringBuilder.toString());
      return new Vector();
    }
    return (Vector)this.c.get(paramString);
  }
  
  public void c(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    g(paramString, paramCategoryChannelSortInfo, paramList);
  }
  
  public void c(String paramString, GuildInitInfo paramGuildInitInfo)
  {
    if (paramGuildInitInfo == null) {
      return;
    }
    g(paramString, paramGuildInitInfo.b(), paramGuildInitInfo.c());
  }
  
  public GProChannelInfo d(String paramString)
  {
    paramString = (GProChannelInfo)this.b.remove(paramString);
    if (paramString == null)
    {
      GProLog.b("ChannelListMgr", true, "cache", "removeChannel info is null");
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeChannel ");
    ((StringBuilder)localObject).append(paramString.getChannelUin());
    ((StringBuilder)localObject).append("from category:");
    ((StringBuilder)localObject).append(paramString.getCategoryId());
    ((StringBuilder)localObject).append("，info.getGuildId() ：");
    ((StringBuilder)localObject).append(paramString.getGuildId());
    GProLog.a("ChannelListMgr", true, "cache", ((StringBuilder)localObject).toString());
    if (this.c.containsKey(paramString.getGuildId()))
    {
      localObject = (Vector)this.c.get(paramString.getGuildId());
      if (localObject != null)
      {
        localObject = ((Vector)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          CategoryInfo localCategoryInfo = (CategoryInfo)((Iterator)localObject).next();
          if (localCategoryInfo != null) {
            localCategoryInfo.b(paramString);
          }
        }
      }
      GProLog.b("ChannelListMgr", true, "cache", "removeChannel map is null or size = 0 ");
      return paramString;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeChannel do not have this guild ");
    ((StringBuilder)localObject).append(paramString.getGuildId());
    GProLog.b("ChannelListMgr", true, "cache", ((StringBuilder)localObject).toString());
    return paramString;
  }
  
  public IGProChannelInfo d(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if (paramString != null) {
      paramString.setFinalMsgNotify(paramInt);
    }
    return paramString;
  }
  
  public void d(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    g(paramString, paramCategoryChannelSortInfo, paramList);
  }
  
  public GProChannelInfo e(String paramString)
  {
    if (h(paramString))
    {
      localObject = (GProChannelInfo)this.b.get(paramString);
      if (localObject != null)
      {
        c(((GProChannelInfo)localObject).getGuildId(), paramString);
        return localObject;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChannelInfo with error channelUin：");
      localStringBuilder.append(paramString);
      GProLog.b("ChannelListMgr", true, "sdk interface", localStringBuilder.toString());
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getChannelInfo not have the channel：");
    ((StringBuilder)localObject).append(paramString);
    GProLog.b("ChannelListMgr", true, "sdk interface", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public IGProChannelInfo e(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if (paramString != null) {
      paramString.setMsgNotify(paramInt);
    }
    return paramString;
  }
  
  public void e(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    g(paramString, paramCategoryChannelSortInfo, paramList);
  }
  
  @NotNull
  public List<IGProChannelInfo> f(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = b(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        localArrayList.addAll(((ICategoryInfo)paramString.next()).c());
      }
    }
    return localArrayList;
  }
  
  public void f(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    g(paramString, paramCategoryChannelSortInfo, paramList);
  }
  
  public boolean f(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if ((paramString != null) && (paramString.getChannelMemberMax() != paramInt))
    {
      paramString.setChannelMemberMax(paramInt);
      return true;
    }
    return false;
  }
  
  public IGProChannelInfo g(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if (paramString != null) {
      paramString.setVisibleType(paramInt);
    }
    return paramString;
  }
  
  public String g(String paramString)
  {
    Object localObject = e(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGuildIdOf with error channelUin：");
      ((StringBuilder)localObject).append(paramString);
      GProLog.b("ChannelListMgr", true, "sdk interface", ((StringBuilder)localObject).toString());
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGuildIdOf with outMap channelUin：");
    localStringBuilder.append(paramString);
    GProLog.b("ChannelListMgr", true, "sdk interface", localStringBuilder.toString());
    return ((GProChannelInfo)localObject).getGuildId();
  }
  
  public void g(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    Object localObject = paramCategoryChannelSortInfo;
    if (paramCategoryChannelSortInfo == null) {
      localObject = new CategoryChannelSortInfo("", 0L);
    }
    paramCategoryChannelSortInfo = paramList;
    if (paramList == null) {
      paramCategoryChannelSortInfo = new ArrayList();
    }
    paramList = new StringBuilder();
    paramList.append("guildId ：");
    paramList.append(paramString);
    paramList.append("， uncategorizedChannels size：");
    paramList.append(((CategoryChannelSortInfo)localObject).c().size());
    paramList.append("，categoryList size:");
    paramList.append(paramCategoryChannelSortInfo.size());
    GProLog.a("ChannelListMgr", false, "cache", "refreshCategoryMap ", "sort categery result", paramList.toString());
    if ((((CategoryChannelSortInfo)localObject).c().size() == 0) && (paramCategoryChannelSortInfo.size() == 0))
    {
      GProLog.b("ChannelListMgr", true, "cache", "refreshCategoryMap ", "sort categery result", " is null!");
      return;
    }
    paramList = CategoryInfo.d();
    localObject = a((CategoryChannelSortInfo)localObject, null, false);
    if (localObject != null) {
      paramList.add(localObject);
    } else {
      paramList.add(new CategoryInfo("", 0L));
    }
    paramCategoryChannelSortInfo = paramCategoryChannelSortInfo.iterator();
    while (paramCategoryChannelSortInfo.hasNext())
    {
      localObject = a((CategoryChannelSortInfo)paramCategoryChannelSortInfo.next(), null, true);
      if (localObject != null) {
        paramList.add(localObject);
      }
    }
    this.c.put(paramString, paramList);
    this.a.a(2, "refreshCategoryMap", paramString);
  }
  
  public List<String> h(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (!j(paramString)) {
      return localArrayList;
    }
    paramString = ((Vector)this.c.get(paramString)).iterator();
    while (paramString.hasNext())
    {
      Iterator localIterator = ((ICategoryInfo)paramString.next()).c().iterator();
      while (localIterator.hasNext())
      {
        IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)localIterator.next();
        if (localIGProChannelInfo.getType() == paramInt) {
          localArrayList.add(localIGProChannelInfo.getChannelUin());
        }
      }
    }
    return localArrayList;
  }
  
  public boolean h(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public List<String> i(String paramString)
  {
    return GProConvert.b(c(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.ChannelListMgr
 * JD-Core Version:    0.7.0.1
 */