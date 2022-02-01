package com.tencent.mobileqq.qqguildsdk.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.ChannelMsgNode;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildInitInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildMemberCountInfos;
import com.tencent.mobileqq.qqguildsdk.data.ILiveChannelMemberInfo;
import com.tencent.mobileqq.qqguildsdk.data.MemberNickNameInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppInfo;
import com.tencent.mobileqq.qqguildsdk.manager.AppChannelMgr;
import com.tencent.mobileqq.qqguildsdk.manager.AudioChannelMgr;
import com.tencent.mobileqq.qqguildsdk.manager.ChannelListMgr;
import com.tencent.mobileqq.qqguildsdk.manager.GuildGuestMgr;
import com.tencent.mobileqq.qqguildsdk.manager.GuildListMgr;
import com.tencent.mobileqq.qqguildsdk.manager.UserListMgr;
import com.tencent.mobileqq.qqguildsdk.manager.VisibleMemberMgr;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.util.GProUtil;
import com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadGuildAndChnListCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadSimpleProfilesCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public abstract class GPSManagerEngine
  extends GProSdkWrapperImpl
{
  private String b;
  private GuildListMgr c;
  private GuildGuestMgr d;
  private ChannelListMgr e;
  private UserListMgr f;
  private VisibleMemberMgr g;
  private AudioChannelMgr h;
  private AppChannelMgr i;
  private boolean j = true;
  private long k = 0L;
  
  public GPSManagerEngine(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
    this.b = paramAppRuntime.getCurrentUin();
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("current uin： ");
    paramAppRuntime.append(this.b);
    GProLog.b("【gpro_sdk】", true, "sdk service init", paramAppRuntime.toString());
  }
  
  @NotNull
  private ILoadSimpleProfilesCallback a()
  {
    return new GPSManagerEngine.1(this);
  }
  
  private void c(String paramString, GProGuildInfo paramGProGuildInfo, HashMap<String, GProChannelInfo> paramHashMap, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    b().a(paramString, paramGProGuildInfo);
    d().a(paramString, paramHashMap, paramCategoryChannelSortInfo, paramList);
    a(1, "addGuildAndChannelList", null);
  }
  
  private void f(List<GuildMsgNode> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GuildMsgNode localGuildMsgNode = (GuildMsgNode)paramList.next();
        if ((localGuildMsgNode != null) && (!GProUtil.a(localGuildMsgNode.a())) && (localGuildMsgNode.a().length() > 1))
        {
          if (b().e(localGuildMsgNode.a())) {
            j(localGuildMsgNode.a());
          } else {
            b().b(localGuildMsgNode.a());
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("saveMsgNodes：");
          ((StringBuilder)localObject).append(localGuildMsgNode.toString());
          GProLog.a("【gpro_sdk】", false, "msg push", ((StringBuilder)localObject).toString());
          b().a(localGuildMsgNode);
          if ((localGuildMsgNode.d() != null) && (localGuildMsgNode.d().size() != 0))
          {
            localObject = localGuildMsgNode.d().iterator();
            while (((Iterator)localObject).hasNext())
            {
              ChannelMsgNode localChannelMsgNode = (ChannelMsgNode)((Iterator)localObject).next();
              if ((!GProUtil.a(localChannelMsgNode.a())) && (localChannelMsgNode.a().length() > 1))
              {
                if (!d().h(localChannelMsgNode.a())) {
                  b().b(localGuildMsgNode.a());
                }
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("saveMsgNodes：");
                localStringBuilder.append(localChannelMsgNode.toString());
                GProLog.a("【gpro_sdk】", false, "msg push", localStringBuilder.toString());
                d().a(localGuildMsgNode.a(), localChannelMsgNode);
                if ((!GProUtil.a(localChannelMsgNode.f())) && (!TextUtils.isEmpty(localChannelMsgNode.g()))) {
                  e().a(localChannelMsgNode.f(), localChannelMsgNode.g());
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, GProChannelInfo paramGProChannelInfo)
  {
    if (paramInt == 0)
    {
      d().a(paramGProChannelInfo);
      a(5, "doOnChannelInfoUpdated", paramGProChannelInfo.getChannelUin());
    }
  }
  
  public void a(int paramInt, GProGuildInfo paramGProGuildInfo, boolean paramBoolean)
  {
    String str = paramGProGuildInfo.getGuildID();
    if (paramInt != 0)
    {
      if ((paramInt == 10003) || (paramInt == 10005))
      {
        paramGProGuildInfo = new StringBuilder();
        paramGProGuildInfo.append("guildId: ");
        paramGProGuildInfo.append(str);
        GProLog.b("【gpro_sdk】", true, "system notify", "doOnGuildInfoUpdated", "error", paramInt, "guild not exist or not member for this guild", paramGProGuildInfo.toString());
        d(str, true);
        a(18, "doOnGuildInfoUpdated", str);
      }
      b().d(paramInt, str);
      return;
    }
    b().a(str, paramGProGuildInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId: ");
    localStringBuilder.append(paramGProGuildInfo.getGuildID());
    localStringBuilder.append(", fetchChannelList : ");
    localStringBuilder.append(paramBoolean);
    GProLog.a("【gpro_sdk】", false, "system notify", "doOnGuildInfoUpdated", "", localStringBuilder.toString());
    if (paramBoolean)
    {
      b().f(str);
      return;
    }
    b().d(paramInt, str);
    a(4, "doOnGuildInfoUpdated", str);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      a(3, "doOnUserListFetchFinish", paramString);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, GProUserProfileInfo paramGProUserProfileInfo)
  {
    a(16, "doOnRefreshGuildUserProfileInfo", paramInt, paramString1, paramString2, paramString3, paramGProUserProfileInfo);
    paramString1 = e().d(paramString3);
    if ((paramString1 != null) && (!paramString1.c().equals(paramGProUserProfileInfo.b())) && (e().a(paramString3, paramGProUserProfileInfo.m()))) {
      a(15, "doOnRefreshGuildUserProfileInfo", paramString3, paramString1);
    }
    paramString1 = e().b(paramString3);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(paramGProUserProfileInfo.c())) && (e().a(paramString3, paramString1))) {
      a(14, "doOnRefreshGuildUserProfileInfo", paramString3, paramString1);
    }
  }
  
  public void a(int paramInt, String paramString, HashMap<String, GProChannelInfo> paramHashMap, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    if (paramInt != 0)
    {
      b().c(paramInt, paramString);
      return;
    }
    d().a(paramString, paramHashMap, paramCategoryChannelSortInfo, paramList);
    b().c(paramInt, paramString);
    a(2, "doOnChannelListUpdated", paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList, ArrayList<GProGuildInfo> paramArrayList1)
  {
    if ((paramInt == 0) && (paramBoolean))
    {
      b().a(paramArrayList, paramArrayList1);
      if (b().a())
      {
        b().a(paramArrayList1);
        return;
      }
      a(1, "doOnGuildListUpdated", null);
      a(19, "doOnGuildListUpdated", b().c());
    }
  }
  
  public void a(GProChannelInfo paramGProChannelInfo, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    d().a(paramGProChannelInfo, paramCategoryChannelSortInfo, paramList);
  }
  
  public void a(IGuildMemberCountInfos paramIGuildMemberCountInfos)
  {
    a(40, "doOnMemberCountUpdate", paramIGuildMemberCountInfos);
  }
  
  public void a(String paramString)
  {
    d(paramString, true);
    c().d(paramString);
    a(11, "doOnPushDestroyGuild", paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    a(null, paramInt);
  }
  
  public void a(String paramString, GProGuildInfo paramGProGuildInfo, HashMap<String, GProChannelInfo> paramHashMap, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    c(paramString, paramGProGuildInfo, paramHashMap, paramCategoryChannelSortInfo, paramList);
    a(7, "doOnPushCreateGuild", paramGProGuildInfo);
  }
  
  public void a(String paramString, GuildInitInfo paramGuildInitInfo)
  {
    d().c(paramString, paramGuildInitInfo);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString2.equals(m()))
    {
      d(paramString1, true);
      a(9, "doOnPushQuitGuild", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (paramString2.equals(m()))
    {
      d(paramString1, true);
      a(10, "doOnPushKickOffGuild", paramString1, Integer.valueOf(paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    f().d(paramString1, paramString2);
    a(73, "doOnChannelVisibleChanged", paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    paramString2 = new GuildUserAvatar(paramString1, paramString2, paramInt, paramLong);
    e().c(paramString1);
    if (e().a(paramString1, paramString2)) {
      a(15, "doOnGetGuildUserAvatarUrl", paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, GProUserInfo paramGProUserInfo)
  {
    g().a(paramString2, paramGProUserInfo);
    a(32, "doOnPushAudioChannelUserEnter", paramString1, paramString2, paramGProUserInfo);
  }
  
  public void a(String paramString1, String paramString2, GuildInitInfo paramGuildInitInfo)
  {
    b(paramString2, paramGuildInitInfo);
  }
  
  public void a(String paramString1, String paramString2, IGProClientIdentityInfo paramIGProClientIdentityInfo)
  {
    e().e(paramString1, paramString2);
    if (e().a(paramString1, paramString2, paramIGProClientIdentityInfo)) {
      a(42, "doOnGuildMemberClientIdentityUpdate", paramString1, paramString2, paramIGProClientIdentityInfo);
    }
  }
  
  public void a(String paramString1, String paramString2, IGProClientIdentityInfo paramIGProClientIdentityInfo, long paramLong)
  {
    if (e().a(paramString1, paramString2, paramIGProClientIdentityInfo)) {
      super.a(paramString1, paramString2, paramIGProClientIdentityInfo, paramLong);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    e().b(paramString1, paramString2);
    if (e().a(paramString1, paramString2, paramString3))
    {
      if (paramString2.equals(m())) {
        e().c(paramString1, paramString3);
      }
      a(41, "doOnGuildMemberNameUpdate", paramString1, paramString2, paramString3);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(47, "doOnSelfBannedSpeakChange", paramString1, paramString2, paramString3, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    g().a(paramString2, paramString4);
    a(35, "doOnPushKickOutAudioChannel", paramString1, paramString2, paramString3, new Object[] { paramString4, Integer.valueOf(paramInt), paramString5 });
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (e().a(paramString1, paramString2, paramString4)) {
      super.a(paramString1, paramString2, paramString3, paramString4, paramLong);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    if (paramInt == 1)
    {
      ChannelListMgr localChannelListMgr = d();
      localChannelListMgr.a(paramString2, GProConvert.a(paramString3));
      localChannelListMgr.b(paramString2, paramString4);
      localChannelListMgr.b(paramString2, GProConvert.a(paramString5));
    }
    a(44, "doOnLiveRoomStatusChange", paramString1, paramString2, paramString3, paramString4, paramString5, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList)
  {
    f().a(paramString1, paramString2, paramList);
    a(71, "doOnJoinChannel", paramString1, paramString2, paramList);
  }
  
  public void a(String paramString1, String paramString2, List<ILiveChannelMemberInfo> paramList, int paramInt)
  {
    a(45, "doOnSwitchLiveRoom", paramString1, paramString2, paramList, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("selfTinyId: ");
    localStringBuilder.append(m());
    GProLog.b("【gpro_sdk】", false, "system notify", "doOnPushAdminChanged", "change cache", localStringBuilder.toString());
    if (paramString2.equals(m()))
    {
      b().b(paramString1, paramBoolean);
      a(4, "doOnPushAdminChanged", paramString1);
    }
    a(13, "doOnPushAdminChanged", paramString1, paramString2, Boolean.valueOf(paramBoolean));
  }
  
  public void a(String paramString, List<MemberNickNameInfo> paramList)
  {
    a(62, "doOnBatchGuildMemberNameUpdate", paramString, paramList);
  }
  
  public abstract void a(String paramString, boolean paramBoolean, IFetchGuildInfoCallback paramIFetchGuildInfoCallback);
  
  public void a(ArrayList<String> paramArrayList, String paramString)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      b(paramString, (String)localIterator.next());
    }
    a(17, "doOnPushChannelDestroy", paramString, paramArrayList);
    a(2, "doOnPushChannelDestroy", paramString);
  }
  
  public void a(List<GuildUserAvatar> paramList)
  {
    a(61, "doOnBatchGetUserAvatarUrl", paramList);
  }
  
  public void a(List<GuildMsgNode> paramList, int paramInt)
  {
    try
    {
      if (!this.j)
      {
        f(paramList);
        return;
      }
      a(paramList, paramInt, j());
      a(a());
      this.j = false;
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if ((!paramBoolean) && (l - this.k < 60000L))
    {
      GProLog.a("cache", false, "refreshGuildList ", "cache--no need to refresh(time<30s)");
      return;
    }
    super.a(paramBoolean);
    this.k = l;
  }
  
  public IGProChannelInfo b(String paramString, int paramInt)
  {
    return d().a(paramString, paramInt);
  }
  
  protected GuildListMgr b()
  {
    if (this.c == null) {
      this.c = new GuildListMgr(this);
    }
    return this.c;
  }
  
  public String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" tinyId : ");
    localStringBuilder.append(paramString);
    GProLog.a("【gpro_sdk】", false, "sdk interface", "getGuildUsersNick", "ui", localStringBuilder.toString());
    return e().b(paramString);
  }
  
  public Map<String, String> b(String paramString, List<String> paramList)
  {
    return e().a(paramString, paramList);
  }
  
  public void b(String paramString, GProGuildInfo paramGProGuildInfo, HashMap<String, GProChannelInfo> paramHashMap, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    c(paramString, paramGProGuildInfo, paramHashMap, paramCategoryChannelSortInfo, paramList);
    c().d(paramString);
    a(43, "doOnPushJoinGuild", paramGProGuildInfo);
  }
  
  public void b(String paramString, GuildInitInfo paramGuildInitInfo)
  {
    d().b(paramString, paramGuildInitInfo);
  }
  
  protected void b(String paramString1, String paramString2)
  {
    d().d(paramString2);
    g().a(paramString2);
    h().b(paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    d().c(paramString2, paramInt);
    d().d(paramString2, paramInt);
    a(5, "doOnPushMsgRecvTypeChanged", paramString1, paramString2, Integer.valueOf(paramInt));
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    g().a(paramString2, paramString3);
    a(33, "doOnPushAudioChannelUserExit", paramString1, paramString2, paramString3);
  }
  
  public void b(String paramString1, String paramString2, List<String> paramList)
  {
    f().b(paramString1, paramString2, paramList);
    a(72, "doOnLeaveChannel", paramString1, paramString2, paramList);
  }
  
  public void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(37, "doOnPushUserMuteSeatInGuild", paramString1, paramString2, Boolean.valueOf(paramBoolean));
  }
  
  public void b(List<MemberNickNameInfo> paramList)
  {
    a(60, "doOnBatchGuildUserNickUpdate", paramList);
  }
  
  public GuildUserAvatar c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" tinyId : ");
    localStringBuilder.append(paramString);
    GProLog.a("【gpro_sdk】", false, "sdk interface", "getGuildUsersAvatarUrl", "ui", localStringBuilder.toString());
    return e().d(paramString);
  }
  
  public IGProChannelInfo c(String paramString, int paramInt)
  {
    return d().b(paramString, paramInt);
  }
  
  protected GuildGuestMgr c()
  {
    if (this.d == null) {
      this.d = new GuildGuestMgr();
    }
    return this.d;
  }
  
  public List<IAppChnnPreInfo> c(String paramString, List<String> paramList)
  {
    return h().a(paramString, paramList);
  }
  
  public Map<String, IGProClientIdentityInfo> c(String paramString1, String paramString2, List<String> paramList)
  {
    return e().a(paramString1, paramString2, paramList);
  }
  
  public Map<String, String> c(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" tinyIdList : ");
    localStringBuilder.append(paramList);
    GProLog.a("【gpro_sdk】", false, "sdk interface", "getGuildUsersNicks", "ui", localStringBuilder.toString());
    return e().b(paramList);
  }
  
  public void c(String paramString1, String paramString2)
  {
    e().a(paramString1);
    if (e().a(paramString1, paramString2)) {
      a(14, "doOnGuildUserNickUpdate", paramString1, paramString2);
    }
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    a(46, "doOnLiveChannelAnchorIdentityChange", paramString1, paramString2, Integer.valueOf(paramInt));
  }
  
  public void c(String paramString1, String paramString2, String paramString3)
  {
    a(34, "doOnPushAudioChannelUserPlatSwitch", paramString1, paramString2, paramString3);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    a(36, "doOnSetUserVoicelessToMe", paramString, Boolean.valueOf(paramBoolean));
  }
  
  public IGProChannelInfo d(String paramString, int paramInt)
  {
    return d().e(paramString, paramInt);
  }
  
  public IGProClientIdentityInfo d(String paramString1, String paramString2, String paramString3)
  {
    return e().b(paramString1, paramString2, paramString3);
  }
  
  public IGProGuildInfo d(String paramString1, String paramString2)
  {
    return b().a(paramString1, paramString2);
  }
  
  protected ChannelListMgr d()
  {
    if (this.e == null) {
      this.e = new ChannelListMgr(this);
    }
    return this.e;
  }
  
  public Map<String, GuildUserAvatar> d(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tinyIdList : ");
    localStringBuilder.append(paramList);
    GProLog.a("【gpro_sdk】", false, "sdk interface", "getGuildUsersAvatarUrls", "ui", localStringBuilder.toString());
    return e().c(paramList);
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    if (g(paramString) == null) {
      return;
    }
    b().g(paramString);
    d().a(paramString);
    e().e(paramString);
    h().b(paramString);
    e().g(paramString);
    if (paramBoolean) {
      a(1, "removeAllCacheForGuild", null);
    }
  }
  
  public boolean d(String paramString)
  {
    return b().e(paramString);
  }
  
  public IGProChannelInfo e(String paramString1, String paramString2)
  {
    return d().a(paramString1, paramString2);
  }
  
  public IGProGuildInfo e(String paramString, boolean paramBoolean)
  {
    return b().a(paramString, paramBoolean);
  }
  
  protected UserListMgr e()
  {
    if (this.f == null) {
      this.f = new UserListMgr(this);
    }
    return this.f;
  }
  
  public String e(String paramString)
  {
    return d().g(paramString);
  }
  
  public String e(String paramString, int paramInt)
  {
    IGProGuildInfo localIGProGuildInfo2 = g(paramString);
    IGProGuildInfo localIGProGuildInfo1 = localIGProGuildInfo2;
    if (localIGProGuildInfo2 == null)
    {
      localIGProGuildInfo2 = o(paramString);
      localIGProGuildInfo1 = localIGProGuildInfo2;
      if (localIGProGuildInfo2 == null) {
        localIGProGuildInfo1 = c().c(paramString);
      }
    }
    if (localIGProGuildInfo1 != null) {
      return localIGProGuildInfo1.getAvatarUrl(paramInt);
    }
    return "";
  }
  
  public void e(List<GuildMsgNode> paramList)
  {
    a(paramList, 1);
  }
  
  public IGProChannelInfo f(String paramString1, String paramString2)
  {
    return c().a(paramString1, paramString2);
  }
  
  protected VisibleMemberMgr f()
  {
    if (this.g == null) {
      this.g = new VisibleMemberMgr(this);
    }
    return this.g;
  }
  
  @NotNull
  public List<IGProChannelInfo> f(String paramString)
  {
    return d().f(paramString);
  }
  
  public IGProGuildInfo g(String paramString)
  {
    return b().d(paramString);
  }
  
  protected AudioChannelMgr g()
  {
    if (this.h == null) {
      this.h = new AudioChannelMgr(this);
    }
    return this.h;
  }
  
  public String g(String paramString1, String paramString2)
  {
    return e().d(paramString1, paramString2);
  }
  
  public IGProChannelInfo h(String paramString)
  {
    return d().e(paramString);
  }
  
  public IAppChnnPreInfo h(String paramString1, String paramString2)
  {
    return h().a(paramString1, paramString2);
  }
  
  protected AppChannelMgr h()
  {
    if (this.i == null) {
      this.i = new AppChannelMgr();
    }
    return this.i;
  }
  
  public String i()
  {
    return this.b;
  }
  
  public void i(String paramString)
  {
    d(paramString, true);
  }
  
  protected ILoadGuildAndChnListCallback j()
  {
    return new GPSManagerEngine.2(this);
  }
  
  public void j(String paramString)
  {
    f(paramString, false);
  }
  
  public IAudioChannelMemberInfos k(String paramString)
  {
    return g().b(paramString);
  }
  
  public List<IGProGuildInfo> k()
  {
    return b().b();
  }
  
  public List<IAppInfo> l()
  {
    return h().a();
  }
  
  public List<ICategoryInfo> l(String paramString)
  {
    return d().b(paramString);
  }
  
  public List<String> m(String paramString)
  {
    return d().i(paramString);
  }
  
  public List<ICategoryInfo> n(String paramString)
  {
    return c().a(paramString);
  }
  
  public IGProGuildInfo o(String paramString)
  {
    return c().b(paramString);
  }
  
  public String p(String paramString)
  {
    return e().f(paramString);
  }
  
  public List<IAppChnnPreInfo> q(String paramString)
  {
    return h().a(paramString);
  }
  
  public String r(String paramString)
  {
    IGProGuildInfo localIGProGuildInfo2 = g(paramString);
    IGProGuildInfo localIGProGuildInfo1 = localIGProGuildInfo2;
    if (localIGProGuildInfo2 == null)
    {
      localIGProGuildInfo2 = o(paramString);
      localIGProGuildInfo1 = localIGProGuildInfo2;
      if (localIGProGuildInfo2 == null) {
        localIGProGuildInfo1 = c().c(paramString);
      }
    }
    if (localIGProGuildInfo1 != null) {
      return localIGProGuildInfo1.getGuildName();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine
 * JD-Core Version:    0.7.0.1
 */