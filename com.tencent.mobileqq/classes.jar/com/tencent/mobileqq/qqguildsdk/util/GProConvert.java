package com.tencent.mobileqq.qqguildsdk.util;

import com.tencent.gprosdk.GProAccountCondition;
import com.tencent.gprosdk.GProAppChnnPreFetchInfo;
import com.tencent.gprosdk.GProAppChnnPreInfo;
import com.tencent.gprosdk.GProAppInfo;
import com.tencent.gprosdk.GProAvatarInfo;
import com.tencent.gprosdk.GProCategoryChannelIdList;
import com.tencent.gprosdk.GProChannel;
import com.tencent.gprosdk.GProChannelCreateInfo;
import com.tencent.gprosdk.GProChannelMemberInfos;
import com.tencent.gprosdk.GProChannelPresenceInfo;
import com.tencent.gprosdk.GProChannelPresenceItemInfo;
import com.tencent.gprosdk.GProClientAccount;
import com.tencent.gprosdk.GProClientArchive;
import com.tencent.gprosdk.GProClientIdentity;
import com.tencent.gprosdk.GProClientInfo;
import com.tencent.gprosdk.GProEnterChannelPermission;
import com.tencent.gprosdk.GProFocusChannelReqInfo;
import com.tencent.gprosdk.GProGuild;
import com.tencent.gprosdk.GProGuildIdentity;
import com.tencent.gprosdk.GProGuildInit;
import com.tencent.gprosdk.GProGuildMemberCountInfo;
import com.tencent.gprosdk.GProJoinCondition;
import com.tencent.gprosdk.GProLiveRoomInfo;
import com.tencent.gprosdk.GProMember;
import com.tencent.gprosdk.GProMemberNickNameInfo;
import com.tencent.gprosdk.GProMsgRouttingHead;
import com.tencent.gprosdk.GProRole;
import com.tencent.gprosdk.GProSourceId;
import com.tencent.gprosdk.GProSourceInfo;
import com.tencent.gprosdk.GProUser;
import com.tencent.mobileqq.qqguildsdk.data.AppChnnPreFetchInfo;
import com.tencent.mobileqq.qqguildsdk.data.AppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.CategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.ChannelCreateInfo;
import com.tencent.mobileqq.qqguildsdk.data.ChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.ClientInfo;
import com.tencent.mobileqq.qqguildsdk.data.EnterChannelPermission;
import com.tencent.mobileqq.qqguildsdk.data.FocusChannelReqInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProClientAccountInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProClientArchiveInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildInitInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IClientInfo;
import com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientAccountInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientArchiveInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildMemberCountInfos;
import com.tencent.mobileqq.qqguildsdk.data.ILiveChannelMemberInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.LiveChannelMemberInfo;
import com.tencent.mobileqq.qqguildsdk.data.LiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.MemberNickNameInfo;
import com.tencent.mobileqq.qqguildsdk.data.MsgRouttingHead;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAccountCondition;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IBaseChnnPreItemInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IChannelPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IJoinCondition;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.ITextChannelPreInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

public class GProConvert
{
  public static long a(String paramString)
  {
    if (GProUtil.a(paramString)) {
      return 0L;
    }
    return Long.valueOf(paramString).longValue();
  }
  
  private static GProAppChnnPreFetchInfo a(AppChnnPreFetchInfo paramAppChnnPreFetchInfo)
  {
    if (paramAppChnnPreFetchInfo != null) {
      return new GProAppChnnPreFetchInfo(a(paramAppChnnPreFetchInfo.a()), a(paramAppChnnPreFetchInfo.b()), paramAppChnnPreFetchInfo.c());
    }
    return null;
  }
  
  public static GProCategoryChannelIdList a(CategoryChannelSortInfo paramCategoryChannelSortInfo)
  {
    if (paramCategoryChannelSortInfo != null) {
      return new GProCategoryChannelIdList(paramCategoryChannelSortInfo.a(), paramCategoryChannelSortInfo.b(), a(paramCategoryChannelSortInfo.c()));
    }
    return null;
  }
  
  public static GProChannelCreateInfo a(ChannelCreateInfo paramChannelCreateInfo)
  {
    int i = paramChannelCreateInfo.j();
    ArrayList localArrayList = a(paramChannelCreateInfo.k());
    return new GProChannelCreateInfo(paramChannelCreateInfo.b(), paramChannelCreateInfo.a(), paramChannelCreateInfo.c(), paramChannelCreateInfo.d(), paramChannelCreateInfo.i(), i, localArrayList);
  }
  
  public static GProClientIdentity a(IGProClientIdentityInfo paramIGProClientIdentityInfo)
  {
    if (paramIGProClientIdentityInfo != null) {
      return new GProClientIdentity(b(paramIGProClientIdentityInfo.a()), paramIGProClientIdentityInfo.b());
    }
    return null;
  }
  
  public static GProGuildIdentity a(GuildIdentityInfo paramGuildIdentityInfo)
  {
    return new GProGuildIdentity(paramGuildIdentityInfo.a(), paramGuildIdentityInfo.b(), paramGuildIdentityInfo.c());
  }
  
  public static GProMsgRouttingHead a(MsgRouttingHead paramMsgRouttingHead)
  {
    return new GProMsgRouttingHead(a(paramMsgRouttingHead.a()), a(paramMsgRouttingHead.b()), a(paramMsgRouttingHead.c()), a(paramMsgRouttingHead.d()), a(paramMsgRouttingHead.e()));
  }
  
  public static GProSourceId a(GuildSourceId paramGuildSourceId)
  {
    if (paramGuildSourceId != null) {
      return new GProSourceId(paramGuildSourceId.a(), paramGuildSourceId.b(), paramGuildSourceId.c());
    }
    return new GProSourceId("", "", 0);
  }
  
  public static GProSourceInfo a(GuildSourceInfo paramGuildSourceInfo)
  {
    if (paramGuildSourceInfo != null) {
      return new GProSourceInfo(paramGuildSourceInfo.a(), paramGuildSourceInfo.b(), paramGuildSourceInfo.c(), paramGuildSourceInfo.d());
    }
    return new GProSourceInfo(0L, "", "", "");
  }
  
  public static CategoryChannelSortInfo a(GProCategoryChannelIdList paramGProCategoryChannelIdList)
  {
    if (paramGProCategoryChannelIdList == null) {
      return new CategoryChannelSortInfo("", 0L, new ArrayList());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProCategoryChannelIdList ");
    localStringBuilder.append(paramGProCategoryChannelIdList.getName());
    localStringBuilder.append(", id: ");
    localStringBuilder.append(paramGProCategoryChannelIdList.getCategoryId());
    GProLog.a("GProConvert", false, "system convert", localStringBuilder.toString());
    return new CategoryChannelSortInfo(paramGProCategoryChannelIdList.getName(), paramGProCategoryChannelIdList.getCategoryId(), b(paramGProCategoryChannelIdList.getChannelList()));
  }
  
  private static CategoryInfo a(HashMap<String, GProChannelInfo> paramHashMap, CategoryChannelSortInfo paramCategoryChannelSortInfo, boolean paramBoolean)
  {
    if ((paramCategoryChannelSortInfo != null) && (paramCategoryChannelSortInfo.a(paramBoolean)))
    {
      CategoryInfo localCategoryInfo = new CategoryInfo(paramCategoryChannelSortInfo.a(), paramCategoryChannelSortInfo.b());
      if (paramCategoryChannelSortInfo.e())
      {
        paramCategoryChannelSortInfo = paramCategoryChannelSortInfo.c().iterator();
        while (paramCategoryChannelSortInfo.hasNext())
        {
          Object localObject = (String)paramCategoryChannelSortInfo.next();
          if (paramHashMap.containsKey(localObject))
          {
            localObject = (GProChannelInfo)paramHashMap.get(localObject);
            if (localObject != null)
            {
              ((GProChannelInfo)localObject).setCategory(localCategoryInfo.b(), localCategoryInfo.a());
              localCategoryInfo.a((GProChannelInfo)localObject);
            }
          }
        }
      }
      return localCategoryInfo;
    }
    return null;
  }
  
  public static GuildInitInfo a(GProGuildInit paramGProGuildInit)
  {
    if (paramGProGuildInit != null) {
      return new GuildInitInfo(paramGProGuildInit);
    }
    return null;
  }
  
  public static GuildUserAvatar a(GProAvatarInfo paramGProAvatarInfo)
  {
    if (paramGProAvatarInfo != null) {
      return new GuildUserAvatar(a(paramGProAvatarInfo.getTinyId()), paramGProAvatarInfo.getUrl(), paramGProAvatarInfo.getUrlFlag(), paramGProAvatarInfo.getUrlTs());
    }
    return null;
  }
  
  public static IEnterChannelPermission a(GProEnterChannelPermission paramGProEnterChannelPermission)
  {
    return new EnterChannelPermission(paramGProEnterChannelPermission);
  }
  
  public static IGProClientIdentityInfo a(GProClientIdentity paramGProClientIdentity)
  {
    if (paramGProClientIdentity != null) {
      return new GProClientIdentityInfo(paramGProClientIdentity);
    }
    return null;
  }
  
  public static IGuildMemberCountInfos a(GProGuildMemberCountInfo paramGProGuildMemberCountInfo)
  {
    if (paramGProGuildMemberCountInfo == null) {
      return null;
    }
    return new GProConvert.1(paramGProGuildMemberCountInfo);
  }
  
  public static IAppInfo a(GProAppInfo paramGProAppInfo)
  {
    return new GProConvert.2(paramGProAppInfo);
  }
  
  private static IBaseChnnPreItemInfo a(int paramInt, GProChannelPresenceItemInfo paramGProChannelPresenceItemInfo)
  {
    if (paramInt != 1) {
      return a(paramGProChannelPresenceItemInfo);
    }
    return b(paramGProChannelPresenceItemInfo);
  }
  
  private static IBaseChnnPreItemInfo a(GProChannelPresenceItemInfo paramGProChannelPresenceItemInfo)
  {
    return new GProConvert.4(paramGProChannelPresenceItemInfo);
  }
  
  public static IChannelPreInfo a(GProChannelPresenceInfo paramGProChannelPresenceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramGProChannelPresenceInfo.getItemList().iterator();
    while (localIterator.hasNext())
    {
      GProChannelPresenceItemInfo localGProChannelPresenceItemInfo = (GProChannelPresenceItemInfo)localIterator.next();
      localArrayList.add(a(paramGProChannelPresenceInfo.getTemplateId(), localGProChannelPresenceItemInfo));
    }
    return new GProConvert.3(paramGProChannelPresenceInfo, localArrayList);
  }
  
  public static IJoinCondition a(GProJoinCondition paramGProJoinCondition)
  {
    if (paramGProJoinCondition != null) {
      return new GProConvert.6(paramGProJoinCondition);
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    return Integer.toString(paramInt);
  }
  
  public static String a(long paramLong)
  {
    return Long.toString(paramLong);
  }
  
  public static ArrayList<IGProClientArchiveInfo> a(ArrayList<GProClientArchive> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(new GProClientArchiveInfo((GProClientArchive)paramArrayList.next()));
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<Long> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!GProUtil.a(str)) {
          localArrayList.add(Long.valueOf(str));
        }
      }
    }
    return localArrayList;
  }
  
  public static HashMap<String, GProChannelInfo> a(HashMap<Long, GProChannel> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localHashMap.put(a(((Long)localEntry.getKey()).longValue()), new GProChannelInfo((GProChannel)localEntry.getValue()));
      }
    }
    return localHashMap;
  }
  
  public static List<ChannelMemberInfos> a(String paramString, List<GProChannelMemberInfos> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new ChannelMemberInfos(paramString, (GProChannelMemberInfos)paramList.next()));
      }
    }
    return localArrayList;
  }
  
  public static List<ICategoryInfo> a(Vector<CategoryInfo> paramVector)
  {
    if (paramVector != null) {
      return new ArrayList(paramVector);
    }
    return new ArrayList();
  }
  
  public static Vector<CategoryInfo> a(GuildInitInfo paramGuildInitInfo)
  {
    if ((paramGuildInitInfo != null) && (!paramGuildInitInfo.d()))
    {
      HashMap localHashMap = paramGuildInitInfo.a();
      Vector localVector = CategoryInfo.d();
      CategoryInfo localCategoryInfo = a(localHashMap, paramGuildInitInfo.b(), false);
      if (localCategoryInfo != null) {
        localVector.add(localCategoryInfo);
      }
      paramGuildInitInfo = paramGuildInitInfo.c().iterator();
      while (paramGuildInitInfo.hasNext())
      {
        localCategoryInfo = a(localHashMap, (CategoryChannelSortInfo)paramGuildInitInfo.next(), true);
        if (localCategoryInfo != null) {
          localVector.add(localCategoryInfo);
        }
      }
      return localVector;
    }
    GProLog.b("GProConvert", true, "cache", "convert2CategoryMap initInfo is null");
    return null;
  }
  
  public static int b(String paramString)
  {
    if (GProUtil.a(paramString)) {
      return 0;
    }
    return Integer.valueOf(paramString).intValue();
  }
  
  private static IAccountCondition b(GProAccountCondition paramGProAccountCondition)
  {
    if (paramGProAccountCondition != null) {
      return new GProConvert.7(paramGProAccountCondition);
    }
    return null;
  }
  
  private static ITextChannelPreInfo b(GProChannelPresenceItemInfo paramGProChannelPresenceItemInfo)
  {
    return new GProConvert.5(paramGProChannelPresenceItemInfo);
  }
  
  public static ArrayList<IGProClientAccountInfo> b(ArrayList<GProClientAccount> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(new GProClientAccountInfo((GProClientAccount)paramArrayList.next()));
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<String> b(List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a(((Long)paramList.next()).longValue()));
      }
    }
    return localArrayList;
  }
  
  public static List<String> b(Vector<CategoryInfo> paramVector)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramVector != null) && (paramVector.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("map size : ");
      localStringBuilder.append(paramVector.size());
      GProLog.b("GProConvert", true, "cache", "convert2CategoryName ", "category", localStringBuilder.toString());
      paramVector = paramVector.iterator();
      while (paramVector.hasNext()) {
        localArrayList.add(((CategoryInfo)paramVector.next()).a());
      }
    }
    paramVector = new StringBuilder();
    paramVector.append("nameList : ");
    paramVector.append(localArrayList);
    GProLog.b("GProConvert", true, "cache", "convert2CategoryName ", "category", paramVector.toString());
    return localArrayList;
  }
  
  public static ArrayList<Long> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString != null) {
      localArrayList.add(Long.valueOf(paramString));
    }
    return localArrayList;
  }
  
  public static List<IGProRoleInfo> c(ArrayList<GProRole> paramArrayList)
  {
    return new ArrayList(d(paramArrayList));
  }
  
  public static List<IGProUserInfo> c(List<GProUser> paramList)
  {
    return new ArrayList(d(paramList));
  }
  
  public static List<GProRoleInfo> d(ArrayList<GProRole> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(new GProRoleInfo((GProRole)paramArrayList.next()));
      }
    }
    return localArrayList;
  }
  
  public static List<GProUserInfo> d(List<GProUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new GProUserInfo((GProUser)paramList.next()));
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<GProGuildInfo> e(List<GProGuild> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new GProGuildInfo((GProGuild)paramList.next()));
      }
    }
    return localArrayList;
  }
  
  public static List<IClientInfo> e(ArrayList<GProClientInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(new ClientInfo((GProClientInfo)paramArrayList.next()));
      }
    }
    return localArrayList;
  }
  
  public static HashMap<String, GuildInitInfo> f(ArrayList<GProGuildInit> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GProGuildInit localGProGuildInit = (GProGuildInit)paramArrayList.next();
        localHashMap.put(a(localGProGuildInit.getGuildId()), new GuildInitInfo(localGProGuildInit));
      }
    }
    return localHashMap;
  }
  
  public static List<CategoryChannelSortInfo> f(List<GProCategoryChannelIdList> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GProCategoryChannelIdList localGProCategoryChannelIdList = (GProCategoryChannelIdList)paramList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GProCategoryChannelIdList ");
        localStringBuilder.append(localGProCategoryChannelIdList.getName());
        localStringBuilder.append(", id: ");
        localStringBuilder.append(localGProCategoryChannelIdList.getCategoryId());
        GProLog.a("GProConvert", false, "system convert", localStringBuilder.toString());
        localArrayList.add(new CategoryChannelSortInfo(localGProCategoryChannelIdList.getName(), localGProCategoryChannelIdList.getCategoryId(), b(localGProCategoryChannelIdList.getChannelList())));
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<GProCategoryChannelIdList> g(List<CategoryChannelSortInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CategoryChannelSortInfo localCategoryChannelSortInfo = (CategoryChannelSortInfo)paramList.next();
        localArrayList.add(new GProCategoryChannelIdList(localCategoryChannelSortInfo.a(), localCategoryChannelSortInfo.b(), a(localCategoryChannelSortInfo.c())));
      }
    }
    return localArrayList;
  }
  
  public static List<IAppInfo> g(ArrayList<GProAppInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(a((GProAppInfo)paramArrayList.next()));
      }
    }
    return localArrayList;
  }
  
  public static List<AppChnnPreInfo> h(ArrayList<GProAppChnnPreInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(new AppChnnPreInfo((GProAppChnnPreInfo)paramArrayList.next()));
    }
    return localArrayList;
  }
  
  public static List<ILiveRoomInfo> h(List<GProLiveRoomInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new LiveRoomInfo((GProLiveRoomInfo)paramList.next()));
      }
    }
    return localArrayList;
  }
  
  public static List<GuildUserAvatar> i(ArrayList<GProAvatarInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(a((GProAvatarInfo)paramArrayList.next()));
      }
    }
    return localArrayList;
  }
  
  public static List<ILiveChannelMemberInfo> i(List<GProMember> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new LiveChannelMemberInfo((GProMember)paramList.next()));
    }
    return localArrayList;
  }
  
  public static ArrayList<GProFocusChannelReqInfo> j(List<FocusChannelReqInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FocusChannelReqInfo localFocusChannelReqInfo = (FocusChannelReqInfo)paramList.next();
        localArrayList.add(new GProFocusChannelReqInfo(a(localFocusChannelReqInfo.a()), a(localFocusChannelReqInfo.b())));
      }
    }
    return localArrayList;
  }
  
  public static List<MemberNickNameInfo> j(ArrayList<GProMemberNickNameInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GProMemberNickNameInfo localGProMemberNickNameInfo = (GProMemberNickNameInfo)paramArrayList.next();
        localArrayList.add(new MemberNickNameInfo(a(localGProMemberNickNameInfo.getTinyId()), localGProMemberNickNameInfo.getName()));
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<GProAppChnnPreFetchInfo> k(List<AppChnnPreFetchInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((AppChnnPreFetchInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public static List<IChannelPreInfo> l(List<GProChannelPresenceInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((GProChannelPresenceInfo)paramList.next()));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.util.GProConvert
 * JD-Core Version:    0.7.0.1
 */