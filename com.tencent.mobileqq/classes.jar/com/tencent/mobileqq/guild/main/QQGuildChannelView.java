package com.tencent.mobileqq.guild.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.audio.AudioRoom;
import com.tencent.mobileqq.guild.audio.data.AudioRoomError;
import com.tencent.mobileqq.guild.client.GuildAppChannelOpenApiImpl;
import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.guild.main.data.QQChannelItemData;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelApp;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelLive;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelText;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelVoice;
import com.tencent.mobileqq.guild.main.data.QQGuildEmptyPlaceHolderData;
import com.tencent.mobileqq.guild.main.item.QQGuildLiveChannelBuilder;
import com.tencent.mobileqq.guild.main.item.QQGuildLiveChannelBuilder.ChannelHolder;
import com.tencent.mobileqq.guild.main.item.QQGuildVoiceChannelBuilder;
import com.tencent.mobileqq.guild.main.item.QQGuildVoiceChannelBuilder.ChannelHolder;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import com.tencent.mobileqq.guild.mainframe.container.GuildContainerController;
import com.tencent.mobileqq.guild.mainframe.container.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.helper.ChannelListViewHelper.IAutoCollapseHandler;
import com.tencent.mobileqq.guild.mainframe.helper.ChannelSelectHelper;
import com.tencent.mobileqq.guild.mainframe.ui.GuildDragTextView;
import com.tencent.mobileqq.guild.message.GuildMessageManager;
import com.tencent.mobileqq.guild.message.base.AbsGuildMessageManagerCallback;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.navigatebar.BaseAioNavigateBarManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.RecyclerListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.app.AppRuntime;

public class QQGuildChannelView
  extends RelativeLayout
  implements View.OnClickListener, QQGuildChannelAdapterNew.OnItemSelectListener
{
  public AbsListView.RecyclerListener a = new QQGuildChannelView.1(this);
  private final ChannelListViewHelper.IAutoCollapseHandler b;
  private QQGuildChannelAdapterNew c;
  private SwipPinnedHeaderExpandableListViewEx d;
  @Nullable
  private IGProGuildInfo e;
  private String f = "";
  private DragFrameLayout g;
  private View h;
  private FacadeArgsData i;
  private GuildMainViewContext j;
  private final List<String> k = new ArrayList();
  private final List<String> l = new ArrayList();
  private final List<String> m = new ArrayList();
  private long n = 0L;
  private QQGuildChannelView.OnListViewScroll o;
  private QQGuildObserver p = new QQGuildChannelView.2(this);
  private GPServiceObserver q = new QQGuildChannelView.7(this);
  private final Observer r = new QQGuildChannelView.10(this);
  
  public QQGuildChannelView(GuildMainViewContext paramGuildMainViewContext, QQGuildChannelView.ConstructParams paramConstructParams)
  {
    super(paramGuildMainViewContext.b());
    QLog.d("QQGuildChannelView", 4, "new QQGuildChannelView");
    this.j = paramGuildMainViewContext;
    this.h = paramConstructParams.a;
    this.i = paramConstructParams.b;
    this.o = paramConstructParams.c;
    this.b = QQGuildChannelView.ConstructParams.a(paramConstructParams);
    i();
    a(this.i);
    e();
  }
  
  private QQGuildChannelText a(IGProChannelInfo paramIGProChannelInfo)
  {
    QQGuildChannelText localQQGuildChannelText = new QQGuildChannelText(paramIGProChannelInfo.getGuildId(), paramIGProChannelInfo);
    Pair localPair = ((IGuildUnreadCntService)this.j.a().getRuntimeService(IGuildUnreadCntService.class, "")).getChannelUnreadCntToShow(paramIGProChannelInfo);
    long l1 = ((Long)localPair.first).longValue();
    boolean bool = true;
    if (l1 > 0L) {
      localQQGuildChannelText.a(1, ((Long)localPair.first).longValue());
    } else {
      localQQGuildChannelText.a(2, ((Long)localPair.second).longValue());
    }
    paramIGProChannelInfo = GuildMessageManager.c().a((AppInterface)this.j.a()).b(paramIGProChannelInfo.getChannelUin(), 23);
    if ((paramIGProChannelInfo == null) || (paramIGProChannelInfo.isEmpty())) {
      bool = false;
    }
    localQQGuildChannelText.a(bool);
    return localQQGuildChannelText;
  }
  
  private IGProChannelInfo a(FacadeArgsData paramFacadeArgsData, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramFacadeArgsData.b)))
    {
      if (paramFacadeArgsData.a == 1) {
        return ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).getChannelInfo(paramString);
      }
      if (paramFacadeArgsData.a == 0) {
        return ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).getChannelInfoForGuest(paramFacadeArgsData.b, paramString);
      }
    }
    return null;
  }
  
  private IGProChannelInfo a(StringBuilder paramStringBuilder, List<List<QQChannelItemData>> paramList, HashMap<Integer, ICategoryInfo> paramHashMap, String paramString)
  {
    List localList1 = ((IGuildAdapterService)this.j.a().getRuntimeService(IGuildAdapterService.class, "")).getCategoryInfoList(paramString, this.i.a);
    if (localList1 == null) {
      return null;
    }
    IGPSService localIGPSService = (IGPSService)this.j.a().getRuntimeService(IGPSService.class, "");
    paramString = null;
    int i1 = 0;
    while (i1 < localList1.size())
    {
      ArrayList localArrayList = new ArrayList();
      ICategoryInfo localICategoryInfo = (ICategoryInfo)localList1.get(i1);
      List localList2 = localICategoryInfo.c();
      int i2 = 0;
      while ((localList2 != null) && (i2 < localList2.size()))
      {
        IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)localList2.get(i2);
        if ((localIGProChannelInfo.getType() == 2) && (QQGuildUtil.d()))
        {
          localObject = b(localIGProChannelInfo);
          ((QQGuildChannelVoice)localObject).a(localIGPSService.getAudioChannelSimpleInfo(localIGProChannelInfo.getChannelUin()));
          ((QQGuildChannelVoice)localObject).a = localICategoryInfo.a();
          localArrayList.add(localObject);
          this.k.add(localIGProChannelInfo.getChannelUin());
          localObject = paramString;
          if (paramString != null) {
            break label494;
          }
        }
        else if ((localIGProChannelInfo.getType() == 5) && (QQGuildUtil.e(localIGProChannelInfo.getGuildId())))
        {
          localObject = c(localIGProChannelInfo);
          ((QQGuildChannelLive)localObject).a = localICategoryInfo.a();
          localArrayList.add(localObject);
          this.l.add(localIGProChannelInfo.getChannelUin());
          localObject = paramString;
          if (paramString != null) {
            break label494;
          }
        }
        else if (localIGProChannelInfo.getType() == 1)
        {
          localObject = a(localIGProChannelInfo);
          ((QQChannelItemData)localObject).a = localICategoryInfo.a();
          localArrayList.add(localObject);
          localObject = paramString;
          if (paramString != null) {
            break label494;
          }
        }
        else
        {
          if (localIGProChannelInfo.getType() == 3)
          {
            localObject = paramString;
            break label494;
          }
          localObject = paramString;
          if (localIGProChannelInfo.getType() != 6) {
            break label494;
          }
          localObject = d(localIGProChannelInfo);
          ((QQGuildChannelApp)localObject).a(localIGPSService.getAppChnnPreInfo(localIGProChannelInfo.getGuildId(), localIGProChannelInfo.getChannelUin()));
          ((QQGuildChannelApp)localObject).a = localICategoryInfo.a();
          localArrayList.add(localObject);
          this.m.add(localIGProChannelInfo.getChannelUin());
          localObject = paramString;
          if (paramString != null) {
            break label494;
          }
        }
        Object localObject = localIGProChannelInfo;
        label494:
        i2 += 1;
        paramString = (String)localObject;
      }
      if (localArrayList.isEmpty())
      {
        if (!TextUtils.isEmpty(localICategoryInfo.a())) {
          while (!QQGuildUtil.a(this.e)) {}
        }
      }
      else
      {
        paramList.add(localArrayList);
        paramHashMap.put(Integer.valueOf(paramList.size() - 1), localICategoryInfo);
      }
      i1 += 1;
    }
    paramStringBuilder.append(",categoryInfos size:");
    paramStringBuilder.append(localList1.size());
    return paramString;
  }
  
  private void a(int paramInt1, String paramString, List<ILiveRoomInfo> paramList, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleLiveChannelInfoUpdate: errCode[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("] errMsg[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("QQGuildChannelView.refresh", 1, localStringBuilder.toString());
    }
    if (paramInt1 != 0) {
      return;
    }
    if (paramList == null)
    {
      QLog.i("QQGuildChannelView.refresh", 1, "handleLiveChannelInfoUpdate: error. channelUinList is null");
      return;
    }
    this.n = (paramInt2 * 1000);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("handleLiveChannelInfoUpdate: lastLimit[");
      paramString.append(this.n);
      paramString.append("]");
      QLog.i("QQGuildChannelView.refresh", 1, paramString.toString());
    }
    paramString = this.c.e();
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      Iterator localIterator1 = paramString.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((List)localIterator1.next()).iterator();
        while (localIterator2.hasNext())
        {
          paramString = (QQChannelItemData)localIterator2.next();
          if ((paramString instanceof QQGuildChannelLive))
          {
            QQGuildChannelLive localQQGuildChannelLive = (QQGuildChannelLive)paramString;
            localStringBuilder = null;
            Iterator localIterator3 = paramList.iterator();
            do
            {
              paramString = localStringBuilder;
              if (!localIterator3.hasNext()) {
                break;
              }
              paramString = (ILiveRoomInfo)localIterator3.next();
            } while (!paramString.getQueryId().equals(localQQGuildChannelLive.b()));
            if (paramString != null) {
              localQQGuildChannelLive.a(paramString);
            } else {
              localQQGuildChannelLive.f();
            }
          }
        }
      }
      this.c.notifyDataSetChanged();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQGuildChannelView.refresh", 1, "handleLiveChannelInfoUpdate: error. channelList is null");
    }
  }
  
  private void a(int paramInt, List<IAudioChannelMemberInfos> paramList)
  {
    if (this.e == null) {
      return;
    }
    if (paramInt == 0)
    {
      if (paramList == null) {
        return;
      }
      List localList = this.c.e();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        IAudioChannelMemberInfos localIAudioChannelMemberInfos = (IAudioChannelMemberInfos)paramList.next();
        Iterator localIterator1 = localList.iterator();
        while (localIterator1.hasNext())
        {
          Iterator localIterator2 = ((List)localIterator1.next()).iterator();
          while (localIterator2.hasNext())
          {
            Object localObject = (QQChannelItemData)localIterator2.next();
            if ((localObject instanceof QQGuildChannelVoice))
            {
              localObject = (QQGuildChannelVoice)localObject;
              if (TextUtils.equals(localIAudioChannelMemberInfos.b(), ((QQGuildChannelVoice)localObject).b())) {
                ((QQGuildChannelVoice)localObject).a(localIAudioChannelMemberInfos);
              }
            }
          }
        }
      }
      this.c.notifyDataSetChanged();
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (GuildDragTextView)paramView.findViewById(2131449124);
    if (paramView == null) {
      return;
    }
    GuildMainViewContext localGuildMainViewContext = this.j;
    if (localGuildMainViewContext != null) {
      localGuildMainViewContext.f().b(paramView.getGestureListener());
    }
  }
  
  private void a(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleAppChnnPreInfoListUpdated guildId=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("QQGuildChannelView.refresh", 1, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = this.e;
      if (localObject1 != null)
      {
        if (!paramString.equals(((IGProGuildInfo)localObject1).getGuildID())) {
          return;
        }
        localObject1 = (IGPSService)this.j.a().getRuntimeService(IGPSService.class, "");
        Object localObject2 = ((IGPSService)localObject1).getAppChnnPreInfos(paramString);
        AppTroopItemShowManager.a().a((List)localObject2);
        localObject2 = this.c.e();
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Iterator localIterator = ((List)((Iterator)localObject2).next()).iterator();
            while (localIterator.hasNext())
            {
              Object localObject3 = (QQChannelItemData)localIterator.next();
              if ((localObject3 instanceof QQGuildChannelApp))
              {
                localObject3 = (QQGuildChannelApp)localObject3;
                ((QQGuildChannelApp)localObject3).a(((IGPSService)localObject1).getAppChnnPreInfo(paramString, ((QQGuildChannelApp)localObject3).a().getChannelUin()));
              }
            }
          }
          paramString = this.c.f();
          if ((paramString != null) && (paramString.a().getType() == 6)) {
            q();
          }
          this.c.notifyDataSetChanged();
          return;
        }
        QLog.e("QQGuildChannelView", 1, "handleAppChnnPreInfoListUpdated: itemDataList is empty");
      }
    }
  }
  
  private void a(String paramString, GuildUserAvatar paramGuildUserAvatar)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramGuildUserAvatar != null))
    {
      if (this.d.getVisibility() != 0) {
        return;
      }
      boolean bool = QLog.isColorLevel();
      int i1 = 0;
      if (bool) {
        QLog.d("QQGuildChannelView", 2, new Object[] { "updateItemAvatar id:", paramString, ",url:", paramGuildUserAvatar.c() });
      }
      if (this.d.getVisibility() == 0) {
        while (i1 < this.d.getChildCount())
        {
          Object localObject = this.d.getChildAt(i1);
          if (localObject != null)
          {
            localObject = ((View)localObject).getTag();
            if (localObject != null) {
              if ((localObject instanceof QQGuildVoiceChannelBuilder.ChannelHolder))
              {
                localObject = (QQGuildVoiceChannelBuilder.ChannelHolder)localObject;
                QQGuildVoiceChannelBuilder.a((AppInterface)this.j.a(), (QQGuildVoiceChannelBuilder.ChannelHolder)localObject, paramString, paramGuildUserAvatar);
              }
              else if ((localObject instanceof QQGuildLiveChannelBuilder.ChannelHolder))
              {
                localObject = (QQGuildLiveChannelBuilder.ChannelHolder)localObject;
                QQGuildLiveChannelBuilder.a((AppInterface)this.j.a(), (QQGuildLiveChannelBuilder.ChannelHolder)localObject, paramString, paramGuildUserAvatar);
              }
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void a(String paramString, @NonNull IAudioChannelMemberInfos paramIAudioChannelMemberInfos)
  {
    AudioRoom localAudioRoom = AudioRoom.b();
    if ((localAudioRoom != null) && (localAudioRoom.d())) {
      return;
    }
    if (((localAudioRoom == null) || (!localAudioRoom.a(paramIAudioChannelMemberInfos.b()))) && (paramIAudioChannelMemberInfos.a(((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).getSelfTinyId())))
    {
      QLog.i("QQGuildChannelView", 1, "checkNeedAutoExitRoom remove self suc.");
      AudioRoomError.a(2);
      d(paramString, paramIAudioChannelMemberInfos.b());
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (this.d.getVisibility() != 0) {
        return;
      }
      boolean bool = QLog.isColorLevel();
      int i1 = 0;
      if (bool) {
        QLog.d("QQGuildChannelView", 2, new Object[] { "updateItemNick id:", paramString1, ",nickName:", paramString2 });
      }
      if (this.d.getVisibility() == 0) {
        while (i1 < this.d.getChildCount())
        {
          Object localObject = this.d.getChildAt(i1);
          if (localObject != null)
          {
            localObject = ((View)localObject).getTag();
            if ((localObject != null) && ((localObject instanceof QQGuildLiveChannelBuilder.ChannelHolder))) {
              QQGuildLiveChannelBuilder.a((QQGuildLiveChannelBuilder.ChannelHolder)localObject, paramString1, paramString2);
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#handleLiveRoomStatusChange mGuildInfo is null and guildId is:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" channelId is: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.w("QQGuildChannelView", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (!TextUtils.equals(((IGProGuildInfo)localObject).getGuildID(), paramString1)) {
      return;
    }
    if (paramInt == 2)
    {
      paramString1 = b(paramString1, paramString2);
      if (paramString1 == null)
      {
        QLog.i("QQGuildChannelView", 1, "handleLiveRoomStatusChange: channelItemData is null");
        return;
      }
      ((QQGuildChannelLive)paramString1).a(null);
      this.c.notifyDataSetChanged();
      return;
    }
    if (paramInt == 1) {
      d();
    }
  }
  
  private void a(String paramString, List<String> paramList)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("QQGuildChannelView", 1, "handleAudioChannelInfoUpdate: error. guildId is null");
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      List localList = this.c.e();
      if ((localList != null) && (!localList.isEmpty()))
      {
        IGPSService localIGPSService = (IGPSService)this.j.a().getRuntimeService(IGPSService.class, "");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          IAudioChannelMemberInfos localIAudioChannelMemberInfos = localIGPSService.getAudioChannelSimpleInfo(str);
          if (localIAudioChannelMemberInfos != null)
          {
            Iterator localIterator1 = localList.iterator();
            while (localIterator1.hasNext())
            {
              Iterator localIterator2 = ((List)localIterator1.next()).iterator();
              while (localIterator2.hasNext())
              {
                Object localObject = (QQChannelItemData)localIterator2.next();
                if ((localObject instanceof QQGuildChannelVoice))
                {
                  localObject = (QQGuildChannelVoice)localObject;
                  if (str.equals(((QQGuildChannelVoice)localObject).b()))
                  {
                    a(paramString, localIAudioChannelMemberInfos);
                    ((QQGuildChannelVoice)localObject).a(localIAudioChannelMemberInfos);
                  }
                }
              }
            }
          }
        }
        this.c.notifyDataSetChanged();
        return;
      }
      QLog.i("QQGuildChannelView", 1, "handleAudioChannelInfoUpdate: error. channelList is null");
      return;
    }
    QLog.i("QQGuildChannelView", 1, "handleAudioChannelInfoUpdate: error. channelUinList is null");
  }
  
  private void a(List<List<QQChannelItemData>> paramList)
  {
    if (paramList.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new QQGuildEmptyPlaceHolderData());
      paramList.add(localArrayList);
    }
  }
  
  private boolean a(boolean paramBoolean, String paramString, QQGuildChannelApp paramQQGuildChannelApp)
  {
    if (((IGuildTempApi)QRoute.api(IGuildTempApi.class)).isChatFragmentShowing(this.j.b()))
    {
      QLog.w("QQGuildChannelView", 1, "open text channel but other aio is open!!");
      return false;
    }
    paramQQGuildChannelApp = new LaunchGuildChatPieParam().a(this.i.b).b(paramString).a(QQGuildChannelAdapterNew.a(this.i)).a(paramBoolean).c(paramBoolean ^ true).b(paramBoolean ^ true).b(1).b();
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildChannelView", 1, new Object[] { "openTextChatFragment ", paramQQGuildChannelApp });
    }
    paramString = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).getMainFragment(this.j.b());
    paramQQGuildChannelApp = ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(this.j.b(), paramQQGuildChannelApp);
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).openGuildAttachContainer(paramString, GuildAttachContainerController.c, paramQQGuildChannelApp);
    return true;
  }
  
  private QQChannelItemData b(@NonNull String paramString1, @NonNull String paramString2)
  {
    Object localObject = this.c.e();
    String str = null;
    paramString1 = null;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      str = paramString1;
      if (((Iterator)localObject).hasNext())
      {
        Iterator localIterator = ((List)((Iterator)localObject).next()).iterator();
        for (str = paramString1;; str = paramString1) {
          do
          {
            paramString1 = str;
            if (!localIterator.hasNext()) {
              break;
            }
            paramString1 = (QQChannelItemData)localIterator.next();
          } while ((paramString1.a() == null) || (!TextUtils.equals(paramString1.a().getChannelUin(), paramString2)));
        }
      }
    }
    else
    {
      QLog.i("QQGuildChannelView", 1, "findTargetChannelItemData: channelItemList is null");
    }
    return str;
  }
  
  private QQGuildChannelVoice b(IGProChannelInfo paramIGProChannelInfo)
  {
    return new QQGuildChannelVoice(paramIGProChannelInfo.getGuildId(), paramIGProChannelInfo);
  }
  
  private QQGuildChannelLive c(IGProChannelInfo paramIGProChannelInfo)
  {
    QQGuildChannelLive localQQGuildChannelLive = new QQGuildChannelLive(paramIGProChannelInfo.getGuildId(), paramIGProChannelInfo);
    paramIGProChannelInfo = ((IGuildUnreadCntService)this.j.a().getRuntimeService(IGuildUnreadCntService.class, "")).getChannelUnreadCntToShow(paramIGProChannelInfo);
    if (((Long)paramIGProChannelInfo.first).longValue() > 0L)
    {
      localQQGuildChannelLive.a(1, ((Long)paramIGProChannelInfo.first).longValue());
      return localQQGuildChannelLive;
    }
    localQQGuildChannelLive.a(2, ((Long)paramIGProChannelInfo.second).longValue());
    return localQQGuildChannelLive;
  }
  
  private void c(@NonNull String paramString1, @NonNull String paramString2)
  {
    Iterator localIterator = ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).getChannelList(paramString1).iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)localIterator.next();
      if (TextUtils.equals(localIGProChannelInfo.getChannelUin(), paramString2)) {
        localObject = localIGProChannelInfo;
      }
    }
    if (localObject == null)
    {
      QLog.i("QQGuildChannelView", 1, "updateTargetChannelItemInfo: error. channelInfo is null");
      return;
    }
    paramString1 = b(paramString1, paramString2);
    if (paramString1 == null)
    {
      QLog.i("QQGuildChannelView", 1, "updateTargetChannelItemInfo: channelItemData is null");
      return;
    }
    paramString1.a(localObject);
    this.c.notifyDataSetChanged();
  }
  
  private QQGuildChannelApp d(IGProChannelInfo paramIGProChannelInfo)
  {
    return new QQGuildChannelApp(paramIGProChannelInfo.getGuildId(), paramIGProChannelInfo);
  }
  
  private void d(String paramString1, String paramString2)
  {
    ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).exitAudioChannel(paramString1, paramString2, new QQGuildChannelView.11(this));
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject1 = this.i;
    if (localObject1 == null) {
      return;
    }
    if ((((FacadeArgsData)localObject1).d != null) && (this.i.d.getInt("guild_jumpleftbar_from", GuildMainFrameConstants.C) == GuildMainFrameConstants.D)) {
      return;
    }
    ChannelSelectHelper localChannelSelectHelper = (ChannelSelectHelper)this.j.a(GuildMainFrameConstants.f);
    Object localObject2 = localChannelSelectHelper.b(this.i.b);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localChannelSelectHelper.a(this.i.b);
    }
    localObject2 = a(this.i, (String)localObject1);
    int i1 = 0;
    if (localObject2 != null) {
      i1 = ((IGProChannelInfo)localObject2).getType();
    }
    if ((i1 != 1) && (i1 != 4))
    {
      if (i1 != 5)
      {
        if (i1 != 6)
        {
          p();
          return;
        }
        localObject1 = (QQGuildChannelApp)b(this.i.b, (String)localObject1);
        if ((((QQGuildChannelApp)localObject1).c().e() != 2) && (((QQGuildChannelApp)localObject1).c().e() != 3))
        {
          localObject2 = QQGuildChannelAdapterNew.a(this.i);
          if (!GuildAppChannelOpenApiImpl.a(this.j.b(), (QQGuildChannelApp)localObject1, paramBoolean, (Bundle)localObject2)) {
            p();
          }
        }
        else
        {
          p();
        }
      }
      return;
    }
    if (!a(paramBoolean, (String)localObject1, null)) {
      p();
    }
  }
  
  private QQChannelItemData e(IGProChannelInfo paramIGProChannelInfo)
  {
    if ((paramIGProChannelInfo.getType() == 2) && (QQGuildUtil.d())) {
      return b(paramIGProChannelInfo);
    }
    if ((paramIGProChannelInfo.getType() == 5) && (QQGuildUtil.e(paramIGProChannelInfo.getGuildId()))) {
      return c(paramIGProChannelInfo);
    }
    if (paramIGProChannelInfo.getType() == 1) {
      return a(paramIGProChannelInfo);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateItemDataChannelInfo: why update type[");
    localStringBuilder.append(paramIGProChannelInfo.getType());
    localStringBuilder.append("], channelId: ");
    localStringBuilder.append(paramIGProChannelInfo.getChannelUin());
    QLog.i("QQGuildChannelView", 1, localStringBuilder.toString());
    return null;
  }
  
  private void i()
  {
    LayoutInflater.from(getContext()).inflate(2131625126, this, true);
    this.g = ((DragFrameLayout)findViewById(2131432151));
    k();
  }
  
  private void j()
  {
    ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).fetchLiveSecurityTips(new QQGuildChannelView.4(this));
  }
  
  private void k()
  {
    this.d = ((SwipPinnedHeaderExpandableListViewEx)findViewById(2131434566));
    this.d.setSelector(2131168376);
    this.d.setNeedCheckSpringback(true);
    this.d.setGroupIndicator(null);
    this.d.setDivider(null);
    this.d.setVerticalScrollBarEnabled(false);
    SwipPinnedHeaderExpandableListViewEx localSwipPinnedHeaderExpandableListViewEx = this.d;
    localSwipPinnedHeaderExpandableListViewEx.mForContacts = true;
    View localView = this.h;
    if (localView != null) {
      localSwipPinnedHeaderExpandableListViewEx.addHeaderView(localView);
    }
    this.c = new QQGuildChannelAdapterNew(this.j, this.i);
    this.c.a(this.g);
    this.c.a(this.d);
    this.c.a(this);
    this.d.setRecyclerListener(this.a);
    this.d.setAdapter(this.c);
    this.d.setClipToPadding(false);
    localSwipPinnedHeaderExpandableListViewEx = this.d;
    localSwipPinnedHeaderExpandableListViewEx.setPadding(localSwipPinnedHeaderExpandableListViewEx.getPaddingLeft(), this.d.getPaddingTop(), this.d.getPaddingRight(), ScreenUtil.dip2px(81.0F));
    this.d.addOnScrollListener(new QQGuildChannelView.5(this));
    this.d.setOnListViewScroll(this.o);
    this.d.setSmoothScrollbarEnabled(true);
    this.d.setTouchHandler(this.b);
    l();
  }
  
  private void l()
  {
    if (this.b == null) {
      return;
    }
    AbsListView.OnScrollListener localOnScrollListener = this.d.getOnScrollListener();
    this.d.setOnScrollListener(new QQGuildChannelView.6(this, localOnScrollListener));
  }
  
  private boolean m()
  {
    FacadeArgsData localFacadeArgsData = this.i;
    return (localFacadeArgsData != null) && (localFacadeArgsData.a == 0);
  }
  
  private void n()
  {
    if (this.e != null)
    {
      if (this.i == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fetchAudioChannelUserListForGuest guildId:");
        localStringBuilder.append(this.e.getGuildID());
        QLog.i("QQGuildChannelView", 1, localStringBuilder.toString());
      }
      ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).fetchAudioChannelUserListForGuest(this.e.getGuildID(), this.k, new QQGuildChannelView.8(this));
    }
  }
  
  private void o()
  {
    if (this.e != null)
    {
      if (this.i == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshAllAppChnnPreInfoForGuest guildId:");
        localStringBuilder.append(this.e.getGuildID());
        QLog.i("QQGuildChannelView", 1, localStringBuilder.toString());
      }
      ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).tryRrefreshAllAppChnnPreInfoForGuest(this.e.getGuildID(), this.m, true);
    }
  }
  
  private void p()
  {
    QLog.d("QQGuildChannelView", 1, "changeToEmptyContent");
    GuildAttachContainerController localGuildAttachContainerController = this.j.e();
    if (localGuildAttachContainerController.i()) {
      localGuildAttachContainerController.d(true);
    }
    localGuildAttachContainerController.a(GuildAttachContainerController.b, null);
  }
  
  private void q()
  {
    Object localObject1 = (ChannelSelectHelper)this.j.a(GuildMainFrameConstants.f);
    Object localObject2 = this.e;
    if (localObject2 != null) {
      localObject1 = ((ChannelSelectHelper)localObject1).a(((IGProGuildInfo)localObject2).getGuildID());
    } else {
      localObject1 = null;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.c.a((String)localObject1) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGuildChannelView", 1, new Object[] { "updateSelectedChannel keep channelId=", localObject1 });
      }
      this.c.b((String)localObject1);
      this.c.notifyDataSetChanged();
      d(true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildChannelView", 1, new Object[] { "updateSelectedChannel oldSelId=", localObject1 });
    }
    localObject1 = this.c.f();
    if ((localObject1 != null) && (((QQChannelItemData)localObject1).a().getType() != 6))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateSelectedChannel to=");
        ((StringBuilder)localObject2).append(((QQChannelItemData)localObject1).a());
        QLog.d("QQGuildChannelView", 1, ((StringBuilder)localObject2).toString());
      }
      this.c.b(((QQChannelItemData)localObject1).a().getChannelUin());
      this.c.notifyDataSetChanged();
    }
    else
    {
      QLog.d("QQGuildChannelView", 1, "updateSelectedChannel to null");
      this.c.b(null);
      this.c.notifyDataSetChanged();
    }
    d(false);
  }
  
  private void r()
  {
    if ((!TextUtils.isEmpty(this.f)) && (this.e == null)) {}
  }
  
  private void s()
  {
    if (this.e == null) {
      return;
    }
    VideoReport.addToDetectionWhitelist(this.j.b());
    VideoReport.setPageId(this, "pg_sgrp_channel");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this, this.e.getGuildID(), null);
  }
  
  private void setData(String paramString)
  {
    Object localObject = this.j.a();
    String str = "";
    this.e = ((IGuildAdapterService)((AppRuntime)localObject).getRuntimeService(IGuildAdapterService.class, "")).getGuildInfo(paramString, this.i.a);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setData guildId=");
      ((StringBuilder)localObject).append(paramString);
      if (this.e == null)
      {
        paramString = str;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("info.userType=");
        paramString.append(this.e.getUserType());
        paramString = paramString.toString();
      }
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQGuildChannelView", 4, ((StringBuilder)localObject).toString());
    }
    if (this.e != null)
    {
      setVisibility(0);
      return;
    }
    setVisibility(8);
    QLog.e("QQGuildChannelView", 1, "error setData null guildInfo");
  }
  
  private void t() {}
  
  public void a()
  {
    SwipPinnedHeaderExpandableListViewEx localSwipPinnedHeaderExpandableListViewEx = this.d;
    if (localSwipPinnedHeaderExpandableListViewEx != null)
    {
      localSwipPinnedHeaderExpandableListViewEx.setSelectionFromTop(0, 0);
      QLog.d("QQGuildChannelView", 4, "resetListView");
    }
  }
  
  public void a(QQChannelItemData paramQQChannelItemData)
  {
    ChannelSelectHelper localChannelSelectHelper = (ChannelSelectHelper)this.j.a(GuildMainFrameConstants.f);
    IGProGuildInfo localIGProGuildInfo = this.e;
    if ((localIGProGuildInfo != null) && (localChannelSelectHelper != null))
    {
      if ((paramQQChannelItemData instanceof QQGuildChannelText))
      {
        localChannelSelectHelper.a(localIGProGuildInfo.getGuildID(), ((QQGuildChannelText)paramQQChannelItemData).a().getChannelUin());
        return;
      }
      if ((paramQQChannelItemData instanceof QQGuildChannelVoice))
      {
        localChannelSelectHelper.a(localIGProGuildInfo.getGuildID(), ((QQGuildChannelVoice)paramQQChannelItemData).a().getChannelUin());
        return;
      }
      if ((paramQQChannelItemData instanceof QQGuildChannelApp)) {
        localChannelSelectHelper.a(localIGProGuildInfo.getGuildID(), ((QQGuildChannelApp)paramQQChannelItemData).a().getChannelUin());
      }
    }
  }
  
  public void a(FacadeArgsData paramFacadeArgsData)
  {
    FacadeArgsData localFacadeArgsData = this.i;
    if ((localFacadeArgsData != null) && ((paramFacadeArgsData == null) || (!TextUtils.equals(localFacadeArgsData.b, paramFacadeArgsData.b))) && (this.j.e().i()))
    {
      QLog.w("QQGuildChannelView", 2, "updateUI changeChannel backgroud!");
      this.j.e().d(true);
    }
    this.i = paramFacadeArgsData;
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildChannelView", 2, "updateUI");
    }
    if ((this.e == null) || (!TextUtils.equals(this.i.b, this.e.getGuildID())))
    {
      setData(this.i.b);
      b();
    }
    c();
    if (this.e != null)
    {
      s();
      t();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.e != null) && (this.i != null))
    {
      if (!QQGuildUtil.d()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryRrefreshAllAudioChannelSimpleInfo guildId:");
        localStringBuilder.append(this.e.getGuildID());
        QLog.i("QQGuildChannelView.refresh", 1, localStringBuilder.toString());
      }
      ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).tryRrefreshAllAudioChannelSimpleInfo(this.e.getGuildID(), paramBoolean);
    }
  }
  
  public void b()
  {
    String str = this.i.b;
    ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).fetchIsLiveChannelOpen(str, new QQGuildChannelView.3(this, str));
    j();
  }
  
  public void b(boolean paramBoolean)
  {
    if (m())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQGuildChannelView", 1, "not need tryRrefreshAllAppChnnPreInfo while current status in guest");
      }
      return;
    }
    if (this.e != null)
    {
      if (this.i == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQGuildChannelView.refresh", 1, String.format("tryRrefreshAllAppChnnPreInfo guildId:%s, bForce:%b", new Object[] { this.e.getGuildID(), Boolean.valueOf(paramBoolean) }));
      }
      ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).tryRrefreshAllAppChnnPreInfo(this.e.getGuildID(), paramBoolean);
    }
  }
  
  public void c()
  {
    if (this.j.d().j() != 1)
    {
      QLog.w("QQGuildChannelView", 1, "refreshChannelData facadeFragment is hide");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mGuildInfo:");
    localStringBuilder.append(this.e);
    this.c.a(this.e, this.i);
    this.k.clear();
    this.l.clear();
    this.m.clear();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject = this.e;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((IGProGuildInfo)localObject).getGuildID();
    }
    a(localStringBuilder, localArrayList, localHashMap, (String)localObject);
    int i1 = localArrayList.size();
    a(localArrayList);
    this.c.a(localArrayList, localHashMap);
    if (i1 > 0)
    {
      i1 = 0;
      while (i1 < localArrayList.size())
      {
        if (((IQQGuildService)this.j.a().getRuntimeService(IQQGuildService.class, "")).isCategoryCollapse((String)localObject, ((ICategoryInfo)localHashMap.get(Integer.valueOf(i1))).a())) {
          this.d.collapseGroup(i1);
        } else {
          this.d.expandGroup(i1);
        }
        i1 += 1;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshChannelData:");
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    QLog.i("QQGuildChannelView", 1, ((StringBuilder)localObject).toString());
    if (!this.k.isEmpty()) {
      if (m()) {
        n();
      } else {
        a(true);
      }
    }
    if (!this.l.isEmpty()) {
      d();
    }
    if ((!this.m.isEmpty()) && (m())) {
      o();
    }
    q();
  }
  
  public void c(boolean paramBoolean)
  {
    e();
  }
  
  public void d()
  {
    if ((this.e != null) && (this.i != null))
    {
      Object localObject = this.l;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("refreshAllLiveChannelInfo guildId:");
          ((StringBuilder)localObject).append(this.e.getGuildID());
          QLog.i("QQGuildChannelView.refresh", 1, ((StringBuilder)localObject).toString());
        }
        ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).fetchLiveRoomInfoByChannelIds(this.e.getGuildID(), this.l, new QQGuildChannelView.9(this));
      }
    }
  }
  
  public void e()
  {
    if (this.j.a() != null)
    {
      QLog.d("QQGuildChannelView", 1, "addObserver");
      ((AppInterface)this.j.a()).addObserver(this.p);
      ((IGuildUnreadCntService)this.j.a().getRuntimeService(IGuildUnreadCntService.class, "")).addObserver(this.r);
      ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).addObserver(this.q);
    }
  }
  
  public void f()
  {
    if (this.j.a() != null)
    {
      QLog.d("QQGuildChannelView", 1, "removeObserver");
      ((AppInterface)this.j.a()).removeObserver(this.p);
      ((IGuildUnreadCntService)this.j.a().getRuntimeService(IGuildUnreadCntService.class, "")).deleteObserver(this.r);
      ((IGPSService)this.j.a().getRuntimeService(IGPSService.class, "")).deleteObserver(this.q);
    }
  }
  
  public void g()
  {
    this.e = null;
    f();
  }
  
  public long getLastServerLiveRefreshLimit()
  {
    return this.n;
  }
  
  public void h()
  {
    QLog.d("QQGuildChannelView", 1, "onDestroy");
    this.e = null;
    f();
  }
  
  public void onClick(View paramView) {}
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0) {
      r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelView
 * JD-Core Version:    0.7.0.1
 */