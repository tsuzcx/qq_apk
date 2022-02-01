package com.tencent.mobileqq.guild.mainframe.helper;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.config.QQGuildGrayUserTypeConfig;
import com.tencent.mobileqq.guild.live.QQGuildLiveLauncher;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;
import com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildVoiceChannelWindow;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildLeftBarController;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildListController;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildCreateItemBuilder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildDiscoverItemBuilder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildInboxItemBuilder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildJoinItemBuilder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBaseBuilder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildBaseLeftItemData;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildCreateMFData;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildDiscoverMFData;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildInBoxMFData;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildJoinMFData;
import com.tencent.mobileqq.guild.message.guest.IGuildGuestHandler;
import com.tencent.mobileqq.guild.source.QQGuildJumpSource;
import com.tencent.mobileqq.guild.util.QQGuildSPUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchChannelListForGuestCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuestGuildCallback;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class GuildLeftItemViewExtHelper
  extends GuildMainViewLifeCycle
{
  private GuildJoinItemBuilder b = null;
  private Handler c = new GuildLeftItemViewExtHelper.1(this);
  private JoinGuildVoiceChannelWindow d;
  
  public GuildLeftItemViewExtHelper(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  private IGProChannelInfo a(JoinGuildParam paramJoinGuildParam, boolean paramBoolean)
  {
    Iterator localIterator = null;
    Object localObject2 = null;
    if (paramJoinGuildParam == null) {
      return null;
    }
    if (TextUtils.isEmpty(paramJoinGuildParam.channelId)) {
      return null;
    }
    Object localObject1 = (IGPSService)this.a.a().getRuntimeService(IGPSService.class, "");
    if (paramBoolean)
    {
      Object localObject3 = ((IGPSService)localObject1).getChannelCategoryListForGuest(paramJoinGuildParam.guildId);
      localObject1 = localIterator;
      if (localObject3 != null)
      {
        localObject1 = localIterator;
        if (((List)localObject3).size() > 0)
        {
          localIterator = ((List)localObject3).iterator();
          for (;;)
          {
            localObject1 = localObject2;
            if (!localIterator.hasNext()) {
              return localObject1;
            }
            localObject1 = ((ICategoryInfo)localIterator.next()).c();
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject3 = ((List)localObject1).iterator();
              if (((Iterator)localObject3).hasNext())
              {
                localObject1 = (IGProChannelInfo)((Iterator)localObject3).next();
                if (!((IGProChannelInfo)localObject1).getChannelUin().equals(paramJoinGuildParam.channelId)) {
                  break;
                }
                QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "getTargetChannelInfoFromCache: get channelInfo from cache, channelInfo=", localObject1 });
                localObject2 = localObject1;
              }
            }
          }
        }
      }
    }
    else
    {
      paramJoinGuildParam = ((IGPSService)localObject1).getChannelInfo(paramJoinGuildParam.channelId);
      QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "getTargetChannelInfoFromCache: guild joined, channelInfo=", paramJoinGuildParam });
      localObject1 = paramJoinGuildParam;
      if (paramJoinGuildParam == null)
      {
        QLog.e("GuildLeftItemViewExtHelper", 1, "getTargetChannelInfoFromCache: guild joined, channelInfo null");
        localObject1 = paramJoinGuildParam;
      }
    }
    return localObject1;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 246617)
    {
      QQGuildJumpSource.a("discover");
      QQGuildJumpSource.b("recommend");
      return;
    }
    if (paramInt == 246619)
    {
      QQGuildJumpSource.a("notice");
      QQGuildJumpSource.b("notice_pgrp");
      return;
    }
    if (paramInt == 246615)
    {
      QQGuildJumpSource.a("outside");
      QQGuildJumpSource.b("sdk");
    }
  }
  
  private void a(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage,msg.what:");
      localStringBuilder.append(paramMessage.what);
      QLog.d("GuildLeftItemViewExtHelper", 2, localStringBuilder.toString());
    }
    if (paramMessage.what == 100) {
      i();
    }
  }
  
  private void a(JoinGuildParam paramJoinGuildParam, IFetchChannelListForGuestCallback paramIFetchChannelListForGuestCallback)
  {
    if (paramJoinGuildParam == null) {
      return;
    }
    if (TextUtils.isEmpty(paramJoinGuildParam.channelId)) {
      return;
    }
    IGuildGuestHandler localIGuildGuestHandler = (IGuildGuestHandler)((AppInterface)this.a.a()).getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildGuestHandlerName());
    if (localIGuildGuestHandler != null) {
      localIGuildGuestHandler.a(paramJoinGuildParam.guildId);
    }
    ((IGPSService)this.a.a().getRuntimeService(IGPSService.class, "")).fetchChannelListForGuest(paramJoinGuildParam.guildId, paramIFetchChannelListForGuestCallback);
  }
  
  private void a(JoinGuildParam paramJoinGuildParam, IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo)
  {
    QQGuildLiveRoomStartParams localQQGuildLiveRoomStartParams = new QQGuildLiveRoomStartParams();
    localQQGuildLiveRoomStartParams.setGuildInfo(paramIGProGuildInfo);
    localQQGuildLiveRoomStartParams.setChannelInfo(paramIGProChannelInfo);
    if (paramJoinGuildParam != null)
    {
      paramIGProGuildInfo = new Bundle();
      paramIGProGuildInfo.putString("guild_id", paramJoinGuildParam.guildId);
      paramIGProGuildInfo.putInt("guild_extra_join_from", paramJoinGuildParam.from);
      paramIGProGuildInfo.putString("guild_extra_join_sig", paramJoinGuildParam.joinSignature);
      paramJoinGuildParam = paramIGProGuildInfo;
    }
    else
    {
      paramJoinGuildParam = null;
    }
    QQGuildLiveLauncher.a(localQQGuildLiveRoomStartParams, paramJoinGuildParam, false, null);
  }
  
  private void a(JoinGuildParam paramJoinGuildParam, boolean paramBoolean, int paramInt, String paramString, List<ICategoryInfo> paramList)
  {
    QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "handleFetchChannelListForGuestResult, result=", Integer.valueOf(paramInt), ", errMsg=", paramString });
    if (paramInt != 0) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramString = paramList.iterator();
      IGProChannelInfo localIGProChannelInfo;
      do
      {
        while (!paramList.hasNext())
        {
          do
          {
            if (!paramString.hasNext()) {
              break;
            }
            paramList = ((ICategoryInfo)paramString.next()).c();
          } while ((paramList == null) || (paramList.size() <= 0));
          paramList = paramList.iterator();
        }
        localIGProChannelInfo = (IGProChannelInfo)paramList.next();
      } while (!localIGProChannelInfo.getChannelUin().equals(paramJoinGuildParam.channelId));
      QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "handleFetchChannelListForGuestResult, get channelInfo from net, channelInfo=", localIGProChannelInfo });
      if (localIGProChannelInfo.getType() == 2)
      {
        b(paramJoinGuildParam, paramBoolean, localIGProChannelInfo);
        return;
      }
      if (localIGProChannelInfo.getType() == 5) {
        a(paramJoinGuildParam, paramBoolean, localIGProChannelInfo);
      }
      return;
      b(2131890601);
      return;
    }
    QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "handleFetchChannelListForGuestResult, result=", Integer.valueOf(paramInt), ", errMsg=", paramString });
  }
  
  private void a(JoinGuildParam paramJoinGuildParam, boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo)
  {
    if ((paramJoinGuildParam != null) && (paramIGProChannelInfo != null))
    {
      if (paramIGProChannelInfo.getType() != 5)
      {
        QLog.e("GuildLeftItemViewExtHelper", 1, "checkJoinLiveChannel: this not a live channel.");
        return;
      }
      if (!paramBoolean)
      {
        IGProGuildInfo localIGProGuildInfo = c(paramJoinGuildParam, paramBoolean);
        if (localIGProGuildInfo != null) {
          a(paramJoinGuildParam, localIGProGuildInfo, paramIGProChannelInfo);
        }
        return;
      }
      a(paramJoinGuildParam.guildId, new GuildLeftItemViewExtHelper.3(this, paramJoinGuildParam, paramBoolean));
      return;
    }
    QLog.e("GuildLeftItemViewExtHelper", 1, "checkJoinLiveChannel: invalid param");
  }
  
  private void a(GuildJoinMFData paramGuildJoinMFData)
  {
    if (paramGuildJoinMFData != null)
    {
      if (this.b == null) {
        return;
      }
      if ((paramGuildJoinMFData.b.equals(this.b.d.b)) && (TextUtils.isEmpty(paramGuildJoinMFData.g)) && (!TextUtils.isEmpty(((GuildJoinMFData)this.b.d).g)))
      {
        paramGuildJoinMFData.g = ((GuildJoinMFData)this.b.d).g;
        paramGuildJoinMFData.h = ((GuildJoinMFData)this.b.d).h;
      }
    }
  }
  
  private void a(IAudioChannelMemberInfos paramIAudioChannelMemberInfos, JoinGuildParam paramJoinGuildParam, IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean)
  {
    if ((paramIAudioChannelMemberInfos != null) && (paramJoinGuildParam != null) && (paramIGProGuildInfo != null) && (paramIGProChannelInfo != null))
    {
      QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "showJoinVoiceChannelWindow, isNeedJoinGuild=", Boolean.valueOf(paramBoolean) });
      Object localObject = (IGPSService)this.a.a().getRuntimeService(IGPSService.class, "");
      paramIAudioChannelMemberInfos = paramIAudioChannelMemberInfos.d();
      localObject = ((IGPSService)localObject).getSelfTinyId();
      if ((paramIAudioChannelMemberInfos != null) && (paramIAudioChannelMemberInfos.size() > 0))
      {
        paramIAudioChannelMemberInfos = paramIAudioChannelMemberInfos.iterator();
        while (paramIAudioChannelMemberInfos.hasNext()) {
          if (TextUtils.equals(((IGProUserInfo)paramIAudioChannelMemberInfos.next()).a(), (CharSequence)localObject))
          {
            bool = true;
            break label139;
          }
        }
      }
      boolean bool = false;
      label139:
      QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "showJoinVoiceChannelWindow, isJoin=", Boolean.valueOf(bool) });
      if (!bool)
      {
        ThreadManager.getUIHandler().post(new GuildLeftItemViewExtHelper.7(this, paramJoinGuildParam, paramIGProGuildInfo, paramIGProChannelInfo, paramBoolean));
        return;
      }
      QLog.d("GuildLeftItemViewExtHelper", 1, "showJoinVoiceChannelWindow, joined, jump to aio");
      ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchAudioChatPie(BaseApplication.getContext(), paramIGProGuildInfo, paramIGProChannelInfo, true);
      return;
    }
    QLog.e("GuildLeftItemViewExtHelper", 1, "showJoinVoiceChannelWindow, invalid param");
  }
  
  private void a(String paramString, IFetchGuestGuildCallback paramIFetchGuestGuildCallback)
  {
    ((IGPSService)this.a.a().getRuntimeService(IGPSService.class, "")).fetchGuestGuild(paramString, paramIFetchGuestGuildCallback);
  }
  
  private void a(List<GuildListItemBaseBuilder> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (GuildListItemBaseBuilder)paramList.get(i);
      if ((localObject != null) && (((GuildListItemBaseBuilder)localObject).d != null))
      {
        localObject = ((GuildListItemBaseBuilder)localObject).d;
        int j = paramList.size();
        boolean bool = true;
        if (i != j - 1) {
          bool = false;
        }
        ((GuildBaseLeftItemData)localObject).d = bool;
      }
      i += 1;
    }
  }
  
  private void b(int paramInt)
  {
    if (this.a != null)
    {
      if (this.a.b() == null) {
        return;
      }
      QBaseActivity localQBaseActivity = this.a.b();
      String str = localQBaseActivity.getString(paramInt);
      DialogUtil.a(localQBaseActivity, 230).setMessage(str).setPositiveButton(2131890597, new GuildLeftItemViewExtHelper.8(this)).show();
    }
  }
  
  private void b(JoinGuildParam paramJoinGuildParam, boolean paramBoolean)
  {
    QLog.d("GuildLeftItemViewExtHelper", 1, new Object[] { "checkJoinTargetChannel, isGuest=", Boolean.valueOf(paramBoolean) });
    if ((!TextUtils.isEmpty(paramJoinGuildParam.channelId)) && (!paramJoinGuildParam.channelId.equals("0")))
    {
      IGProChannelInfo localIGProChannelInfo = a(paramJoinGuildParam, paramBoolean);
      if (localIGProChannelInfo != null)
      {
        if (localIGProChannelInfo.getType() == 2)
        {
          b(paramJoinGuildParam, paramBoolean, localIGProChannelInfo);
          return;
        }
        if (localIGProChannelInfo.getType() == 5)
        {
          a(paramJoinGuildParam, paramBoolean, localIGProChannelInfo);
          return;
        }
        paramJoinGuildParam = new StringBuilder();
        paramJoinGuildParam.append("checkJoinTargetChannel, can not handle type[");
        paramJoinGuildParam.append(localIGProChannelInfo.getType());
        paramJoinGuildParam.append("]");
        QLog.d("GuildLeftItemViewExtHelper", 1, paramJoinGuildParam.toString());
        return;
      }
      if (paramBoolean)
      {
        a(paramJoinGuildParam, new GuildLeftItemViewExtHelper.2(this, paramJoinGuildParam));
        return;
      }
      QLog.e("GuildLeftItemViewExtHelper", 1, "checkJoinTargetChannel: channelInfo null");
      b(2131890601);
      return;
    }
    QLog.d("GuildLeftItemViewExtHelper", 1, "checkJoinTargetChannel: channelId is empty.");
  }
  
  private void b(JoinGuildParam paramJoinGuildParam, boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo)
  {
    if ((paramJoinGuildParam != null) && (paramIGProChannelInfo != null))
    {
      IGPSService localIGPSService = (IGPSService)this.a.a().getRuntimeService(IGPSService.class, "");
      QLog.d("GuildLeftItemViewExtHelper", 1, "checkJoinVoiceChannel");
      if (paramIGProChannelInfo.getType() == 2)
      {
        if (paramBoolean)
        {
          localIGProGuildInfo = localIGPSService.getGuildInfoForGuest(paramJoinGuildParam.guildId);
          if (localIGProGuildInfo != null)
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramJoinGuildParam.channelId);
            localIGPSService.fetchAudioChannelUserListForGuest(paramJoinGuildParam.guildId, localArrayList, new GuildLeftItemViewExtHelper.4(this, paramJoinGuildParam, localIGProGuildInfo, paramIGProChannelInfo, paramBoolean));
            return;
          }
          localIGPSService.fetchGuildInfoForGuest(paramJoinGuildParam.guildId, new GuildLeftItemViewExtHelper.5(this, paramJoinGuildParam, localIGPSService, paramIGProChannelInfo, paramBoolean));
          return;
        }
        IGProGuildInfo localIGProGuildInfo = localIGPSService.getGuildInfo(paramJoinGuildParam.guildId);
        if (localIGProGuildInfo != null)
        {
          localIGPSService.fetchAudioChannelUserList(paramJoinGuildParam.guildId, paramJoinGuildParam.channelId, new GuildLeftItemViewExtHelper.6(this, localIGProGuildInfo, paramIGProChannelInfo));
          return;
        }
        QLog.e("GuildLeftItemViewExtHelper", 1, "checkJoinVoiceChannel, guild null");
      }
      return;
    }
    QLog.e("GuildLeftItemViewExtHelper", 1, "checkJoinVoiceChannel, invalid param");
  }
  
  private IGProGuildInfo c(JoinGuildParam paramJoinGuildParam, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTargetGuildInfoFromCache： guildId[");
    ((StringBuilder)localObject).append(paramJoinGuildParam.guildId);
    ((StringBuilder)localObject).append("] isGuest[");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    QLog.e("GuildLeftItemViewExtHelper", 1, ((StringBuilder)localObject).toString());
    localObject = (IGPSService)this.a.a().getRuntimeService(IGPSService.class, "");
    if (paramBoolean) {
      paramJoinGuildParam = ((IGPSService)localObject).getGuildInfoForGuest(paramJoinGuildParam.guildId);
    } else {
      paramJoinGuildParam = ((IGPSService)localObject).getGuildInfo(paramJoinGuildParam.guildId);
    }
    if (paramJoinGuildParam == null) {
      QLog.e("GuildLeftItemViewExtHelper", 1, "getTargetGuildInfoFromCache： can not find guildInfo.");
    }
    return paramJoinGuildParam;
  }
  
  private void m()
  {
    this.b = null;
    this.c.removeMessages(100);
    if (QLog.isColorLevel()) {
      QLog.d("GuildLeftItemViewExtHelper", 2, "setJoinGuildNull");
    }
  }
  
  public void a(JoinGuildParam paramJoinGuildParam)
  {
    if (paramJoinGuildParam != null)
    {
      if (TextUtils.isEmpty(paramJoinGuildParam.guildId)) {
        return;
      }
      boolean bool3 = a(paramJoinGuildParam.guildId);
      Object localObject1;
      Object localObject2;
      if (bool3)
      {
        a(paramJoinGuildParam.from);
        localObject1 = new GuildJoinMFData(paramJoinGuildParam.guildId);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramJoinGuildParam.from == 246617)
        {
          bool1 = bool2;
          if (this.b == null) {
            bool1 = true;
          }
        }
        ((GuildJoinMFData)localObject1).f = paramJoinGuildParam;
        a((GuildJoinMFData)localObject1);
        this.b = new GuildJoinItemBuilder(this.a, (GuildBaseLeftItemData)localObject1);
        this.a.c().i().a(2);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("addJoinItem", bool1);
        this.a.a(((GuildJoinMFData)localObject1).a, ((GuildJoinMFData)localObject1).b, (Bundle)localObject2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setJoinGuild needjoin joinGuildParam=");
        ((StringBuilder)localObject1).append(paramJoinGuildParam.toString());
        QLog.i("GuildLeftItemViewExtHelper", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject1 = paramJoinGuildParam.guildId;
        this.a.b(1, (String)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setJoinGuild hasJoin guildId:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("GuildLeftItemViewExtHelper", 1, ((StringBuilder)localObject2).toString());
      }
      b(paramJoinGuildParam, bool3);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((this.b != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.b.d.b)))
    {
      if ((((GuildJoinMFData)this.b.d).g != null) && (((GuildJoinMFData)this.b.d).g.equals(paramString2))) {
        return;
      }
      this.b.a(paramString2, paramString3);
      this.a.a(0, paramString1);
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = ((IGPSService)this.a.a().getRuntimeService(IGPSService.class, "")).getGuildList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IGProGuildInfo localIGProGuildInfo = (IGProGuildInfo)((Iterator)localObject).next();
        if ((localIGProGuildInfo != null) && (paramString.equals(localIGProGuildInfo.getGuildID()))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      m();
    }
  }
  
  public void i()
  {
    m();
    this.a.c().i().a(2);
  }
  
  public void j()
  {
    if (this.b == null) {
      return;
    }
    boolean bool2 = false;
    Object localObject = ((GuildLeftBarSelHelper)this.a.a(GuildMainFrameConstants.b)).i();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (this.b.d.equals(new GuildBaseLeftItemData(((GuildLeftBarSelHelper.SelItem)localObject).a, ((GuildLeftBarSelHelper.SelItem)localObject).b))) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelChange:bJoinGuildSel:");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("GuildLeftItemViewExtHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (bool1)
    {
      this.c.removeMessages(100);
      return;
    }
    if (!this.c.hasMessages(100)) {
      this.c.sendEmptyMessageDelayed(100, 300000L);
    }
  }
  
  public ArrayList<GuildListItemBaseBuilder> k()
  {
    ArrayList localArrayList = new ArrayList();
    GuildCreateMFData localGuildCreateMFData = new GuildCreateMFData("");
    localArrayList.add(new GuildCreateItemBuilder(this.a, localGuildCreateMFData));
    return localArrayList;
  }
  
  public ArrayList<GuildListItemBaseBuilder> l()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.b;
    if (localObject != null) {
      if (a(((GuildJoinItemBuilder)localObject).d.b)) {
        localArrayList.add(this.b);
      } else {
        m();
      }
    }
    if (QQGuildGrayUserTypeConfig.a().d())
    {
      localObject = new GuildDiscoverMFData("");
      localArrayList.add(new GuildDiscoverItemBuilder(this.a, (GuildBaseLeftItemData)localObject));
    }
    if (QQGuildSPUtils.c())
    {
      localObject = new GuildInBoxMFData("");
      localArrayList.add(new GuildInboxItemBuilder(this.a, (GuildBaseLeftItemData)localObject));
    }
    Collections.sort(localArrayList, GuildListItemBaseBuilder.e);
    a(localArrayList);
    if (QLog.isDebugVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGuildListTitleBuilder ");
      ((StringBuilder)localObject).append(localArrayList.size());
      QLog.d("GuildLeftItemViewExtHelper", 1, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper
 * JD-Core Version:    0.7.0.1
 */