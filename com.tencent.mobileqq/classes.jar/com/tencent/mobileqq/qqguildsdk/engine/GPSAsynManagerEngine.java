package com.tencent.mobileqq.qqguildsdk.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.callback.ICreateChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchAudioChannelUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchChannelListForGuestCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuestGuildCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAudioChannelMemberInfosListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetChannelCategoryCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetInvisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberCountCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IKickChannelMemberCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelAdminMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelNameCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelTalkPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildTopCallback;
import com.tencent.mobileqq.qqguildsdk.data.AppChnnPreFetchInfo;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.ChannelCreateInfo;
import com.tencent.mobileqq.qqguildsdk.data.FocusChannelReqInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.manager.AppChannelMgr;
import com.tencent.mobileqq.qqguildsdk.manager.ChannelListMgr;
import com.tencent.mobileqq.qqguildsdk.manager.GuildListMgr;
import com.tencent.mobileqq.qqguildsdk.manager.UserListMgr;
import com.tencent.mobileqq.qqguildsdk.manager.VisibleMemberMgr;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class GPSAsynManagerEngine
  extends GPSManagerEngine
{
  private Map<String, Long> b = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Runnable> c = new ConcurrentHashMap();
  private String d = "MEMBER_CURRENT_TASK";
  private GPSAsynManagerEngine.MemberSearchThread e;
  
  public GPSAsynManagerEngine(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void a(String paramString, List<String> paramList, IGetUserInfoCallback paramIGetUserInfoCallback, List<IGProUserInfo> paramList1)
  {
    b(paramString, paramList, new GPSAsynManagerEngine.2(this, paramString, paramIGetUserInfoCallback, paramList1, paramList));
  }
  
  private void a(String paramString, List<String> paramList, IGetUserInfoCallback paramIGetUserInfoCallback, List<IGProUserInfo> paramList1, boolean paramBoolean)
  {
    a(paramString, paramList, new GPSAsynManagerEngine.1(this, paramList1, paramList, paramIGetUserInfoCallback, paramString, paramBoolean));
  }
  
  private boolean a(FocusChannelReqInfo paramFocusChannelReqInfo, long paramLong)
  {
    paramFocusChannelReqInfo = paramFocusChannelReqInfo.toString();
    if ((this.b.containsKey(paramFocusChannelReqInfo)) && (paramLong <= ((Long)this.b.get(paramFocusChannelReqInfo)).longValue()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("this guild/channel List has set withid 5s: ");
      localStringBuilder.append(paramFocusChannelReqInfo);
      GProLog.a("【gpro_sdk】", false, "sdk interface", "setFocusChannel", "isAllowToSet", localStringBuilder.toString());
      return false;
    }
    this.b.put(paramFocusChannelReqInfo, Long.valueOf(paramLong + 5000L));
    return true;
  }
  
  protected Runnable a(String paramString1, String paramString2, int paramInt, ISearchSink<IGProUserInfo> paramISearchSink)
  {
    return new GPSAsynManagerEngine.9(this, paramString1, paramString2, paramInt, paramISearchSink);
  }
  
  public void a()
  {
    a(new GPSAsynManagerEngine.37(this));
  }
  
  public void a(String paramString1, long paramLong, String paramString2, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    a(paramString1, paramLong, paramString2, new GPSAsynManagerEngine.28(this, paramString1, paramIGetChannelCategoryCallback));
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    a(paramString, paramLong, paramBoolean, new GPSAsynManagerEngine.27(this, paramString, paramIGetChannelCategoryCallback));
  }
  
  public void a(String paramString, IFetchChannelListForGuestCallback paramIFetchChannelListForGuestCallback)
  {
    a(paramString, new GPSAsynManagerEngine.36(this, paramIFetchChannelListForGuestCallback));
  }
  
  public void a(String paramString, IFetchGuestGuildCallback paramIFetchGuestGuildCallback)
  {
    a(paramString, new GPSAsynManagerEngine.34(this, paramString, paramIFetchGuestGuildCallback));
  }
  
  public void a(String paramString, IFetchGuildInfoCallback paramIFetchGuildInfoCallback)
  {
    a(paramString, new GPSAsynManagerEngine.35(this, paramString, paramIFetchGuildInfoCallback));
  }
  
  public void a(String paramString, IResultCallback paramIResultCallback)
  {
    super.a(paramString, new GPSAsynManagerEngine.6(this, paramString, paramIResultCallback));
  }
  
  public void a(String paramString, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    super.a(paramString, new GPSAsynManagerEngine.5(this, paramString, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString, ISearchSink<IGProGuildInfo> paramISearchSink)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("keyWord ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    GProLog.a("【gpro_sdk】", false, "sdk interface", "searchGuildByName", "ui-local guild", (String)localObject, i);
    b().a(paramString, 1, paramISearchSink, false);
  }
  
  public void a(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, ArrayList<CategoryChannelSortInfo> paramArrayList, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    a(paramString, paramCategoryChannelSortInfo, paramArrayList, new GPSAsynManagerEngine.30(this, paramString, paramIGetChannelCategoryCallback));
  }
  
  public void a(String paramString, ChannelCreateInfo paramChannelCreateInfo, long paramLong, ICreateChannelCallback paramICreateChannelCallback)
  {
    a(paramString, paramChannelCreateInfo, paramLong, new GPSAsynManagerEngine.7(this, paramString, paramICreateChannelCallback));
  }
  
  public void a(String paramString1, GuildSourceId paramGuildSourceId, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    super.a(paramString1, paramGuildSourceId, paramString2, new GPSAsynManagerEngine.3(this, paramString1, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString1, GuildSourceId paramGuildSourceId, String paramString2, GuildSourceInfo paramGuildSourceInfo, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    super.a(paramString1, paramGuildSourceId, paramString2, paramGuildSourceInfo, new GPSAsynManagerEngine.4(this, paramString1, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    super.a(paramString1, paramString2, paramInt, new GPSAsynManagerEngine.12(this, paramString2, paramInt, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, ISetChannelAdminMsgNotifyTypeCallback paramISetChannelAdminMsgNotifyTypeCallback)
  {
    super.a(paramString1, paramString2, paramInt, new GPSAsynManagerEngine.14(this, paramString2, paramInt, paramISetChannelAdminMsgNotifyTypeCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, ISetChannelMsgNotifyTypeCallback paramISetChannelMsgNotifyTypeCallback)
  {
    super.a(paramString1, paramString2, paramInt, new GPSAsynManagerEngine.15(this, paramString2, paramInt, paramString1, paramISetChannelMsgNotifyTypeCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, ISetChannelTalkPermissionCallback paramISetChannelTalkPermissionCallback)
  {
    super.a(paramString1, paramString2, paramInt, new GPSAsynManagerEngine.11(this, paramString2, paramInt, paramISetChannelTalkPermissionCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, @Nullable List<String> paramList, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    f().d(paramString1, paramString2);
    super.a(paramString1, paramString2, paramInt, paramList, new GPSAsynManagerEngine.16(this, paramString2, paramInt, paramIResultWithSecurityCallback));
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, int paramInt, boolean paramBoolean, @NonNull IGetInvisibleMemberListCallback paramIGetInvisibleMemberListCallback)
  {
    f().a(paramString1, paramString2, paramInt, paramBoolean, paramIGetInvisibleMemberListCallback);
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, int paramInt, boolean paramBoolean, @NonNull IGetVisibleMemberListCallback paramIGetVisibleMemberListCallback)
  {
    f().a(paramString1, paramString2, paramInt, paramBoolean, paramIGetVisibleMemberListCallback);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    a(paramString1, paramString2, paramLong, new GPSAsynManagerEngine.25(this, paramString1, paramIGetChannelCategoryCallback));
  }
  
  public void a(String paramString1, String paramString2, IFetchAudioChannelUserListCallback paramIFetchAudioChannelUserListCallback)
  {
    a(paramString1, paramString2, new GPSAsynManagerEngine.22(this, paramString2, paramString1, paramIFetchAudioChannelUserListCallback));
  }
  
  public void a(String paramString1, String paramString2, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    a(paramString1, paramString2, new GPSAsynManagerEngine.26(this, paramString1, paramIGetChannelCategoryCallback));
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull IGetVisibleMemberCountCallback paramIGetVisibleMemberCountCallback)
  {
    f().a(paramString1, paramString2, paramIGetVisibleMemberCountCallback);
  }
  
  public void a(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    super.a(paramString1, paramString2, new GPSAsynManagerEngine.8(this, paramString1, paramString2, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString1, String paramString2, ISearchSink<IGProUserInfo> paramISearchSink)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， key ： ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    GProLog.a("【gpro_sdk】", false, "sdk interface", "searchGuildUser", "ui-svr user", (String)localObject, i);
    e().a(paramString1, paramString2, paramISearchSink, 1);
  }
  
  public void a(String paramString1, String paramString2, ISetGuildInfoCallback paramISetGuildInfoCallback)
  {
    super.a(paramString1, paramString2, new GPSAsynManagerEngine.18(this, paramString1, paramString2, paramISetGuildInfoCallback));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ISetChannelNameCallback paramISetChannelNameCallback)
  {
    super.a(paramString1, paramString2, paramString3, new GPSAsynManagerEngine.13(this, paramString2, paramString3, paramISetChannelNameCallback));
  }
  
  public void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, IKickChannelMemberCallback paramIKickChannelMemberCallback)
  {
    super.a(paramString1, paramString2, paramArrayList, new GPSAsynManagerEngine.23(this, paramString2, paramIKickChannelMemberCallback));
  }
  
  public void a(String paramString1, String paramString2, @Nullable List<String> paramList1, @Nullable List<String> paramList2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    f().d(paramString1, paramString2);
    super.a(paramString1, paramString2, paramList1, paramList2, new GPSAsynManagerEngine.17(this, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    super.a(paramString1, paramString2, paramBoolean, new GPSAsynManagerEngine.19(this, paramString1, paramString2, paramBoolean, paramIResultWithSecurityCallback));
  }
  
  public void a(String paramString, ArrayList<Long> paramArrayList, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    a(paramString, paramArrayList, new GPSAsynManagerEngine.29(this, paramString, paramIGetChannelCategoryCallback));
  }
  
  public void a(String paramString, List<String> paramList, IGetAudioChannelMemberInfosListCallback paramIGetAudioChannelMemberInfosListCallback)
  {
    a(paramString, paramList, true, new GPSAsynManagerEngine.31(this, paramIGetAudioChannelMemberInfosListCallback, paramString));
  }
  
  public void a(String paramString, List<String> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new AppChnnPreFetchInfo(paramString, (String)localIterator.next(), ""));
    }
    if (localArrayList.size() == 0)
    {
      GProLog.b("【gpro_sdk】", false, "sdk callback", "tryRrefreshAllAppChnnPreInfoForGuest", "no need to fetch", "");
      return;
    }
    a(localArrayList, paramBoolean, new GPSAsynManagerEngine.39(this, paramList, localArrayList, paramString));
  }
  
  public void a(String paramString, List<String> paramList, boolean paramBoolean, IGetUserInfoCallback paramIGetUserInfoCallback)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      a(paramString, paramList, paramIGetUserInfoCallback, localArrayList);
      return;
    }
    a(paramString, paramList, paramIGetUserInfoCallback, localArrayList, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = d().h(paramString, 2);
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      a(paramString, (List)localObject, paramBoolean, new GPSAsynManagerEngine.21(this, paramString));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" tryRrefreshAllAudioChannelSimpleInfo fail. no any audioChannelId");
    GProLog.d("【gpro_sdk】", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(String paramString, boolean paramBoolean, IFetchGuildInfoCallback paramIFetchGuildInfoCallback)
  {
    if (paramIFetchGuildInfoCallback != null) {
      b().a(paramString, paramIFetchGuildInfoCallback);
    }
    f(paramString, paramBoolean);
  }
  
  public void a(String paramString, boolean paramBoolean, ISetGuildTopCallback paramISetGuildTopCallback)
  {
    super.a(paramString, paramBoolean, new GPSAsynManagerEngine.10(this, paramString, paramBoolean, paramISetGuildTopCallback));
  }
  
  public void a(List<FocusChannelReqInfo> paramList, IResultCallback paramIResultCallback)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FocusChannelReqInfo localFocusChannelReqInfo = (FocusChannelReqInfo)paramList.next();
      if (a(localFocusChannelReqInfo, l)) {
        localArrayList.add(localFocusChannelReqInfo);
      }
    }
    super.a(localArrayList, paramIResultCallback);
  }
  
  public boolean a(IGProSecurityResult paramIGProSecurityResult)
  {
    return (paramIGProSecurityResult == null) || ((int)paramIGProSecurityResult.a() == 0) || ((int)paramIGProSecurityResult.a() == 4);
  }
  
  public void b(String paramString, ISearchSink<IGProGuildInfo> paramISearchSink)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("keyWord ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    GProLog.a("【gpro_sdk】", false, "sdk interface", "searchGuildByShowNumber", "ui-local guild", (String)localObject, i);
    b().a(paramString, 2, paramISearchSink, false);
  }
  
  public void b(String paramString1, String paramString2, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    super.b(paramString1, paramString2, paramInt, new GPSAsynManagerEngine.24(this, paramString2, paramInt, paramIResultWithSecurityCallback));
  }
  
  public void b(String paramString1, String paramString2, int paramInt, ISearchSink<IGProUserInfo> paramISearchSink)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("， key ： ");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    GProLog.a("【gpro_sdk】", false, "sdk interface", "searchGuildUserByGuildNickname", "ui-svr user", (String)localObject, i);
    this.c.put(this.d, a(paramString1, paramString2, paramInt, paramISearchSink));
    paramString1 = this.e;
    if ((paramString1 == null) || (!paramString1.isAlive()))
    {
      this.e = new GPSAsynManagerEngine.MemberSearchThread(this);
      this.e.start();
    }
  }
  
  public void b(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    super.b(paramString1, paramString2, new GPSAsynManagerEngine.20(this, paramString2, paramIResultWithSecurityCallback));
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    List localList = d().h(paramString, 6);
    if (localList.size() == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("guildId: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("channelIds:");
      ((StringBuilder)localObject).append(localList);
      GProLog.b("【gpro_sdk】", false, "sdk callback", "tryRrefreshAllAppChnnPreInfo", "channelIds is null", ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = h().a(paramString, localList, paramBoolean);
    if (((List)localObject).size() == 0)
    {
      GProLog.b("【gpro_sdk】", false, "sdk callback", "tryRrefreshAllAppChnnPreInfo", "no need to fetch", "");
      return;
    }
    a((List)localObject, paramBoolean, new GPSAsynManagerEngine.38(this, localList, (List)localObject, paramString));
  }
  
  public void c(String paramString, ISearchSink<IGProGuildInfo> paramISearchSink)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("keyWord ：");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i = a;
    a = i + 1;
    GProLog.a("【gpro_sdk】", false, "sdk interface", "searchSrvGuildByShowNumber", "ui-svr guild", (String)localObject, i);
    b().a(paramString, 2, paramISearchSink, true);
  }
  
  public void c(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    super.c(paramString1, paramString2, new GPSAsynManagerEngine.32(this, paramString1, paramString2, paramIResultWithSecurityCallback));
  }
  
  public void d(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    super.d(paramString1, paramString2, new GPSAsynManagerEngine.33(this, paramString1, paramString2, paramIResultWithSecurityCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine
 * JD-Core Version:    0.7.0.1
 */