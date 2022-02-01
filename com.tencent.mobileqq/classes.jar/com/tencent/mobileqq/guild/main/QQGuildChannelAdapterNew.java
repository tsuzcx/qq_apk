package com.tencent.mobileqq.guild.main;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.client.ClientAuthorizationHelper;
import com.tencent.mobileqq.guild.client.GuildAppChannelOpenApiImpl;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveLauncher;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.main.data.QQChannelItemData;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelApp;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelGuide;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelLive;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelText;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelVoice;
import com.tencent.mobileqq.guild.main.data.QQGuildEmptyPlaceHolderData;
import com.tencent.mobileqq.guild.main.item.QQGuildChannelItemBuilder;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import com.tencent.mobileqq.guild.mainframe.container.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.container.facade.FacadeJoinInfo;
import com.tencent.mobileqq.guild.mainframe.helper.ChannelSelectHelper;
import com.tencent.mobileqq.guild.mainframe.ui.GuildDragTextView;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.guild.util.GuildFastClickUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAccountCondition;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IJoinCondition;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class QQGuildChannelAdapterNew
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
  implements View.OnClickListener, IChannelListControl
{
  protected DragFrameLayout a;
  private GuildMainViewContext b;
  private QQGuildChannelItemBuilderFactory c;
  private final List<List<QQChannelItemData>> d = new ArrayList();
  private IGProGuildInfo e;
  private SwipPinnedHeaderExpandableListView f;
  private HashMap<Integer, ICategoryInfo> g;
  private QQGuildChannelAdapterNew.OnItemSelectListener h;
  private FacadeArgsData i;
  private QQProgressDialog j;
  
  public QQGuildChannelAdapterNew(GuildMainViewContext paramGuildMainViewContext, FacadeArgsData paramFacadeArgsData)
  {
    this.b = paramGuildMainViewContext;
    this.i = paramFacadeArgsData;
    this.c = new QQGuildChannelItemBuilderFactory(this);
  }
  
  public static Bundle a(FacadeArgsData paramFacadeArgsData)
  {
    if (paramFacadeArgsData.c != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("guild_id", paramFacadeArgsData.b);
      localBundle.putInt("guild_extra_join_from", paramFacadeArgsData.c.a);
      localBundle.putString("guild_extra_join_sig", paramFacadeArgsData.c.b);
      return localBundle;
    }
    return null;
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
    GuildMainViewContext localGuildMainViewContext = this.b;
    if (localGuildMainViewContext != null) {
      localGuildMainViewContext.f().a(paramView.getGestureListener());
    }
  }
  
  private void a(View paramView, QQChannelItemData paramQQChannelItemData)
  {
    d(paramView, paramQQChannelItemData);
    if (i())
    {
      paramView = (QQGuildChannelVoice)paramQQChannelItemData;
      b(paramView.a().getChannelUin());
      ThreadManager.getUIHandler().postDelayed(new QQGuildChannelAdapterNew.2(this, paramView), 200L);
      paramView = this.h;
      if (paramView != null) {
        paramView.a(paramQQChannelItemData);
      }
    }
    else
    {
      QQToast.makeText(this.b.b(), 2131890494, 0).show();
    }
  }
  
  private void a(View paramView, QQGuildChannelApp paramQQGuildChannelApp)
  {
    d(paramView, paramQQGuildChannelApp);
    if (h())
    {
      QQToast.makeText(this.b.b(), 2131890492, 0).show();
      return;
    }
    b(paramQQGuildChannelApp.a().getChannelUin());
    paramView = this.h;
    if (paramView != null) {
      paramView.a(paramQQGuildChannelApp);
    }
    if (paramQQGuildChannelApp.c() == null)
    {
      QLog.e("QQGuildChannelAdapterNew", 1, "ChnnPreInfo not get yet");
      return;
    }
    if (StringUtil.isEmpty(paramQQGuildChannelApp.c().d()))
    {
      QLog.e("QQGuildChannelAdapterNew", 1, String.format("jumpUrl is empty: (guildId, channelId)=(%s, %s)", new Object[] { paramQQGuildChannelApp.b(), paramQQGuildChannelApp.a().getChannelUin() }));
      return;
    }
    paramView = paramQQGuildChannelApp.c().d();
    int k = paramQQGuildChannelApp.c().e();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Jumping to url: ");
      localStringBuilder.append(paramView);
      QLog.d("QQGuildChannelAdapterNew", 2, localStringBuilder.toString());
    }
    if (k == 2)
    {
      QQGuildUtil.a(this.b.b(), paramView);
      return;
    }
    if (k == 1)
    {
      paramView = new GuildClientParams().b((int)paramQQGuildChannelApp.c().c()).a(a(this.i)).d(d().getGuildID()).e(paramQQGuildChannelApp.a().getChannelUin()).f(paramQQGuildChannelApp.a().getChannelName()).j(paramView).e();
      GuildAppChannelOpenApiImpl.a(this.b.b(), paramView);
      return;
    }
    if (k == 3)
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.b.b(), paramView, 5002, null);
      return;
    }
    QQGuildUtil.c(this.b.b().getString(2131917763));
  }
  
  private void a(View paramView, QQGuildChannelText paramQQGuildChannelText)
  {
    if ((paramQQGuildChannelText != null) && (paramQQGuildChannelText.a() != null))
    {
      paramQQGuildChannelText = paramQQGuildChannelText.a();
      VideoReport.setElementId(paramView, "em_sgrp_drawer_channel");
      VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
      VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_NONE);
      VideoReport.setElementReuseIdentifier(paramView, paramQQGuildChannelText.getChannelUin());
      return;
    }
    VideoReport.setElementId(paramView, "em_sgrp_drawer_create_channel");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_NONE);
    VideoReport.setElementReuseIdentifier(paramView, "add");
  }
  
  private boolean a(QQChannelItemData paramQQChannelItemData1, QQChannelItemData paramQQChannelItemData2)
  {
    paramQQChannelItemData1 = paramQQChannelItemData1.a();
    paramQQChannelItemData2 = paramQQChannelItemData2.a();
    if ((paramQQChannelItemData1 != null) && (paramQQChannelItemData2 != null)) {
      return TextUtils.equals(paramQQChannelItemData1.getChannelUin(), paramQQChannelItemData2.getChannelUin());
    }
    return false;
  }
  
  private String b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return "";
          }
          return "应用频道";
        }
        return "直播频道";
      }
      return "语音频道";
    }
    return "文本频道";
  }
  
  private void b(View paramView, QQChannelItemData paramQQChannelItemData)
  {
    if (GuildFastClickUtil.a("QQGuildChannelAdapterNew_liveChannelClick")) {
      return;
    }
    d(paramView, paramQQChannelItemData);
    c(paramQQChannelItemData.a().getChannelUin());
    paramView = (QQGuildChannelLive)paramQQChannelItemData;
    paramQQChannelItemData = new QQGuildLiveRoomStartParams();
    paramQQChannelItemData.setGuildInfo(this.e);
    paramQQChannelItemData.setChannelInfo(paramView.a());
    paramQQChannelItemData.setLiveChannelRoomInfo(LiveChannelRoomInfo.parseFrom(paramView.d()));
    QQGuildLiveLauncher.a(paramQQChannelItemData, a(this.i), false, null);
  }
  
  private void b(String paramString, QQGuildChannelApp paramQQGuildChannelApp)
  {
    if ((paramQQGuildChannelApp.c() != null) && (paramQQGuildChannelApp.c().k() != null))
    {
      if (paramQQGuildChannelApp.c().k().a() == null) {
        return;
      }
      a(this.i).putBoolean("disableReuse", true);
      paramString = new GuildClientParams().b((int)paramQQGuildChannelApp.c().c()).a(a(this.i)).d(d().getGuildID()).e(paramQQGuildChannelApp.a().getChannelUin()).f(paramQQGuildChannelApp.a().getChannelName()).g(String.valueOf(paramQQGuildChannelApp.c().k().a().a())).j(paramString).a(3).e();
      if (paramQQGuildChannelApp.c().k().a().b())
      {
        ClientAuthorizationHelper.a(this.b.b(), paramString);
        return;
      }
      GuildAppChannelOpenApiImpl.a(this.b.b(), paramString);
    }
  }
  
  private void c(View paramView, QQChannelItemData paramQQChannelItemData)
  {
    d(paramView, paramQQChannelItemData);
    b(paramQQChannelItemData.a().getChannelUin());
    paramView = new LaunchGuildChatPieParam().a(this.e.getGuildID()).b(((QQGuildChannelText)paramQQChannelItemData).a().getChannelUin()).a(a(this.i)).b(false).c(false).b(3).b();
    ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(this.b.b(), paramView);
    paramView = this.h;
    if (paramView != null) {
      paramView.a(paramQQChannelItemData);
    }
  }
  
  private void d(View paramView, QQChannelItemData paramQQChannelItemData)
  {
    QQGuildUtil.a(paramView, "em_sgrp_channel", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    HashMap localHashMap = new HashMap();
    if ((paramQQChannelItemData != null) && (paramQQChannelItemData.a() != null))
    {
      localHashMap.put("sgrp_sub_channel_id", paramQQChannelItemData.a().getChannelUin());
      boolean bool = paramQQChannelItemData instanceof QQGuildChannelText;
      int m = 1;
      Object localObject;
      int k;
      if (bool)
      {
        localObject = (QQGuildChannelText)paramQQChannelItemData;
        k = m;
        if (((QQGuildChannelText)localObject).b() == null) {
          break label180;
        }
        k = m;
        if (((QQGuildChannelText)localObject).b().a <= 0L) {
          break label180;
        }
        if (((QQGuildChannelText)localObject).b().b != 1) {}
      }
      for (;;)
      {
        k = 3;
        break;
        do
        {
          k = 2;
          break;
          k = m;
          if (!(paramQQChannelItemData instanceof QQGuildChannelLive)) {
            break;
          }
          localObject = (QQGuildChannelLive)paramQQChannelItemData;
          k = m;
          if (((QQGuildChannelLive)localObject).e() == null) {
            break;
          }
          k = m;
          if (((QQGuildChannelLive)localObject).e().a <= 0L) {
            break;
          }
        } while (((QQGuildChannelLive)localObject).e().b != 1);
      }
      label180:
      localHashMap.put("sgrp_sub_channel_alert", Integer.valueOf(k));
      localHashMap.put("sgrp_sub_channel_type", b(paramQQChannelItemData.a().getType()));
    }
    VideoReport.reportEvent("clck", paramView, localHashMap);
  }
  
  private boolean h()
  {
    FacadeArgsData localFacadeArgsData = this.i;
    boolean bool = true;
    if (localFacadeArgsData != null)
    {
      if (localFacadeArgsData.a != 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean i()
  {
    FacadeArgsData localFacadeArgsData = this.i;
    return (localFacadeArgsData != null) && (localFacadeArgsData.a == 1);
  }
  
  public QQChannelItemData a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.d.size())
    {
      List localList = (List)this.d.get(paramInt1);
      if ((localList != null) && (localList.size() > paramInt2)) {
        return (QQChannelItemData)localList.get(paramInt2);
      }
    }
    return null;
  }
  
  public QQChannelItemData a(String paramString)
  {
    QQChannelItemData localQQChannelItemData;
    do
    {
      do
      {
        Iterator localIterator1 = this.d.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((List)localIterator1.next()).iterator();
        }
        localQQChannelItemData = (QQChannelItemData)localIterator2.next();
      } while ((localQQChannelItemData instanceof QQGuildEmptyPlaceHolderData));
      if (localQQChannelItemData.a() == null) {
        return null;
      }
    } while (!TextUtils.equals(localQQChannelItemData.a().getChannelUin(), paramString));
    return localQQChannelItemData;
    return null;
  }
  
  public String a()
  {
    ChannelSelectHelper localChannelSelectHelper = (ChannelSelectHelper)this.b.a(GuildMainFrameConstants.f);
    if (localChannelSelectHelper != null)
    {
      IGProGuildInfo localIGProGuildInfo = this.e;
      if (localIGProGuildInfo != null) {
        return localChannelSelectHelper.a(localIGProGuildInfo.getGuildID());
      }
    }
    return null;
  }
  
  public List<QQChannelItemData> a(int paramInt)
  {
    if (paramInt < this.d.size()) {
      return (List)this.d.get(paramInt);
    }
    return null;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.a = paramDragFrameLayout;
    this.a.a(this, true);
  }
  
  public void a(QQGuildChannelAdapterNew.OnItemSelectListener paramOnItemSelectListener)
  {
    this.h = paramOnItemSelectListener;
  }
  
  public void a(QQChannelItemData paramQQChannelItemData)
  {
    if (paramQQChannelItemData == null) {
      return;
    }
    int k = 0;
    while (k < this.d.size())
    {
      Iterator localIterator = ((List)this.d.get(k)).iterator();
      while (localIterator.hasNext())
      {
        QQChannelItemData localQQChannelItemData = (QQChannelItemData)localIterator.next();
        if (a(localQQChannelItemData, paramQQChannelItemData))
        {
          localQQChannelItemData.a(paramQQChannelItemData);
          notifyDataSetChanged();
          return;
        }
      }
      k += 1;
    }
  }
  
  public void a(IGProGuildInfo paramIGProGuildInfo, FacadeArgsData paramFacadeArgsData)
  {
    this.e = paramIGProGuildInfo;
    this.i = paramFacadeArgsData;
  }
  
  public void a(SwipPinnedHeaderExpandableListView paramSwipPinnedHeaderExpandableListView)
  {
    this.f = paramSwipPinnedHeaderExpandableListView;
  }
  
  public void a(String paramString, QQGuildChannelApp paramQQGuildChannelApp)
  {
    if (h())
    {
      QQToast.makeText(this.b.b(), 2131890492, 0).show();
      return;
    }
    if (paramQQGuildChannelApp.c().e() == 2)
    {
      QQGuildUtil.a(this.b.b(), paramString);
      return;
    }
    if (paramQQGuildChannelApp.c().e() == 1)
    {
      b(paramString, paramQQGuildChannelApp);
      return;
    }
    if (paramQQGuildChannelApp.c().e() == 3)
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.b.b(), paramString, 5002, null);
      return;
    }
    QQGuildUtil.c(this.b.b().getString(2131917763));
  }
  
  public void a(List<List<QQChannelItemData>> paramList, HashMap<Integer, ICategoryInfo> paramHashMap)
  {
    this.d.clear();
    this.d.addAll(paramList);
    this.g = paramHashMap;
    notifyDataSetChanged();
  }
  
  public AppInterface b()
  {
    return (AppInterface)this.b.a();
  }
  
  public void b(String paramString)
  {
    ChannelSelectHelper localChannelSelectHelper = (ChannelSelectHelper)this.b.a(GuildMainFrameConstants.f);
    if (localChannelSelectHelper != null)
    {
      IGProGuildInfo localIGProGuildInfo = this.e;
      if (localIGProGuildInfo != null) {
        localChannelSelectHelper.a(localIGProGuildInfo.getGuildID(), paramString);
      }
    }
  }
  
  public void c(String paramString)
  {
    ChannelSelectHelper localChannelSelectHelper = (ChannelSelectHelper)this.b.a(GuildMainFrameConstants.f);
    if (localChannelSelectHelper != null)
    {
      IGProGuildInfo localIGProGuildInfo = this.e;
      if (localIGProGuildInfo != null) {
        localChannelSelectHelper.b(localIGProGuildInfo.getGuildID(), paramString);
      }
    }
  }
  
  public void configHeaderView(View paramView, int paramInt) {}
  
  public IGProGuildInfo d()
  {
    return this.e;
  }
  
  public List<List<QQChannelItemData>> e()
  {
    return this.d;
  }
  
  public QQChannelItemData f()
  {
    QQChannelItemData localQQChannelItemData;
    do
    {
      Iterator localIterator1 = this.d.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((List)localIterator1.next()).iterator();
      }
      localQQChannelItemData = (QQChannelItemData)localIterator2.next();
    } while (((localQQChannelItemData instanceof QQGuildEmptyPlaceHolderData)) || (localQQChannelItemData.a() == null) || (localQQChannelItemData.a().getType() == 5));
    return localQQChannelItemData;
    return null;
  }
  
  public DragFrameLayout g()
  {
    return this.a;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    QQChannelItemData localQQChannelItemData = a(paramInt1, paramInt2);
    return this.c.b(localQQChannelItemData);
  }
  
  public int getChildTypeCount()
  {
    return this.c.a();
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    QQChannelItemData localQQChannelItemData = a(paramInt1, paramInt2);
    QQGuildChannelItemBuilder localQQGuildChannelItemBuilder = this.c.a(localQQChannelItemData);
    paramView = localQQGuildChannelItemBuilder.a(paramInt2, localQQChannelItemData, paramView, paramViewGroup, this.b.b(), this);
    paramView.setTag(2131434556, localQQChannelItemData);
    if ((localQQChannelItemData instanceof QQGuildChannelText))
    {
      a(paramView);
      a(paramView, (QQGuildChannelText)localQQChannelItemData);
    }
    else if (((localQQChannelItemData instanceof QQGuildChannelGuide)) && (((QQGuildChannelGuide)localQQChannelItemData).d() == -1))
    {
      a(paramView, null);
    }
    localQQGuildChannelItemBuilder.a(paramView, paramInt2, localQQChannelItemData, this.b.b());
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (paramInt < this.d.size())
    {
      List localList = (List)this.d.get(paramInt);
      if (localList != null) {
        return localList.size();
      }
    }
    return 0;
  }
  
  public int getGroupCount()
  {
    return this.d.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public int getGroupType(int paramInt)
  {
    Object localObject = a(paramInt);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (QQChannelItemData)((List)localObject).get(0);
      if ((localObject instanceof QQGuildEmptyPlaceHolderData)) {
        return 2;
      }
      if (TextUtils.isEmpty(((QQChannelItemData)localObject).a)) {
        return 1;
      }
    }
    return super.getGroupType(paramInt);
  }
  
  public int getGroupTypeCount()
  {
    return 3;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    int k = getGroupType(paramInt);
    if (k == 2)
    {
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.b.b()).inflate(2131625038, null);
        paramView = new QQGuildChannelAdapterNew.EmptyPlaceHolderViewHolder(null);
        QQGuildChannelAdapterNew.EmptyPlaceHolderViewHolder.a(paramView, paramViewGroup.findViewById(2131437169));
        paramViewGroup.setTag(paramView);
      }
      else
      {
        localObject = (QQGuildChannelAdapterNew.EmptyPlaceHolderViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
      localObject = new TranslateAnimation(-50.0F, DisplayUtil.a(paramViewGroup.getContext()).a - DisplayUtil.a(paramViewGroup.getContext(), 136.0F), 0.0F, 0.0F);
      ((TranslateAnimation)localObject).setDuration(1600L);
      ((TranslateAnimation)localObject).setRepeatCount(-1);
      ((TranslateAnimation)localObject).setRepeatMode(1);
      QQGuildChannelAdapterNew.EmptyPlaceHolderViewHolder.a(paramView).startAnimation((Animation)localObject);
      return paramViewGroup;
    }
    if (k == 1)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = new View(this.b.b());
      }
      paramViewGroup.setBackgroundColor(-65536);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
      return paramViewGroup;
    }
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b.b()).inflate(2131625127, null);
      paramViewGroup = new QQGuildChannelAdapterNew.GroupHolder();
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131434546));
      paramViewGroup.a = ((CheckBox)paramView.findViewById(2131436369));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131434549));
      paramView.setTag(paramViewGroup);
      QQGuildUtil.a(paramViewGroup.c, "em_sgrp_create_channel", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    }
    else
    {
      paramViewGroup = (QQGuildChannelAdapterNew.GroupHolder)paramView.getTag();
    }
    if (paramInt == 0) {
      k = 0;
    } else {
      k = ViewUtils.dpToPx(8.0F);
    }
    paramView.setPadding(0, k, 0, ViewUtils.dpToPx(4.0F));
    Object localObject = this.g;
    long l;
    if ((localObject != null) && (((HashMap)localObject).get(Integer.valueOf(paramInt)) != null))
    {
      localObject = ((ICategoryInfo)this.g.get(Integer.valueOf(paramInt))).a();
      l = ((ICategoryInfo)this.g.get(Integer.valueOf(paramInt))).b();
      paramViewGroup.b.setText((CharSequence)localObject);
    }
    else
    {
      localObject = null;
      l = 0L;
    }
    if (QQGuildUtil.a(this.e))
    {
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setOnClickListener(new QQGuildChannelAdapterNew.3(this, (String)localObject, l));
    }
    else
    {
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.c.setOnClickListener(null);
    }
    boolean bool = paramViewGroup.a.isChecked();
    paramViewGroup.a.setChecked(paramBoolean);
    if (bool != paramBoolean)
    {
      if (bool) {
        localObject = ObjectAnimator.ofFloat(paramViewGroup.a, "rotation", new float[] { 0.0F, -90.0F });
      } else {
        localObject = ObjectAnimator.ofFloat(paramViewGroup.a, "rotation", new float[] { -90.0F, 0.0F });
      }
      ((ObjectAnimator)localObject).setDuration(0L);
      ((ObjectAnimator)localObject).setInterpolator(new LinearInterpolator());
      ((ObjectAnimator)localObject).start();
    }
    paramView.setOnClickListener(new QQGuildChannelAdapterNew.4(this, paramView, paramViewGroup, paramInt));
    QQGuildUtil.a(paramView, "em_sgrp_block", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 0;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((DragFrameLayout)localObject).getMode() == -1) && (paramDragFrameLayout.getDragView() != null) && (paramDragFrameLayout.getDragView().getId() == 2131449124))
    {
      paramDragFrameLayout = paramDragFrameLayout.getDragView().getTag();
      if (((paramDragFrameLayout instanceof QQGuildChannelText)) || ((paramDragFrameLayout instanceof QQGuildChannelLive)))
      {
        localObject = (QQChannelItemData)paramDragFrameLayout;
        paramDragFrameLayout = ((QQChannelItemData)localObject).a().getGuildId();
        localObject = ((QQChannelItemData)localObject).a().getChannelUin();
        IGuildMsgReadedService localIGuildMsgReadedService = (IGuildMsgReadedService)b().getRuntimeService(IGuildMsgReadedService.class, "");
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        localIGuildMsgReadedService.setChannelMsgReaded(paramDragFrameLayout, localArrayList, 5);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(2131434556);
    if ((localObject instanceof QQChannelItemData))
    {
      localObject = (QQChannelItemData)localObject;
      if ((localObject instanceof QQGuildChannelText)) {
        c(paramView, (QQChannelItemData)localObject);
      } else if ((localObject instanceof QQGuildChannelVoice)) {
        a(paramView, (QQChannelItemData)localObject);
      } else if ((localObject instanceof QQGuildChannelLive)) {
        b(paramView, (QQChannelItemData)localObject);
      } else if ((localObject instanceof QQGuildChannelApp)) {
        a(paramView, (QQGuildChannelApp)localObject);
      }
      if (((localObject instanceof QQGuildChannelGuide)) && (((QQGuildChannelGuide)localObject).d() == -1))
      {
        ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openCreateGuildChannel(this.b.b(), b(), this.e.getGuildID(), "main_setting", "", 0L);
        d(paramView, null);
      }
      notifyDataSetChanged();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelAdapterNew
 * JD-Core Version:    0.7.0.1
 */