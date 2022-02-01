package com.tencent.mobileqq.guild.live.livemanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import com.tencent.avbiz.IModule.FocusChangeListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.audience.QQGuildLiveAudienceRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildEndLiveModel;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.live.widget.GuildLiveJoinRoomMsgAnimView;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveChannelMemberInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.NetworkState.NetworkStateListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGuildLiveEventHelper
  implements IModule.FocusChangeListener
{
  private static final QQGuildLiveEventHelper b = new QQGuildLiveEventHelper();
  boolean a;
  private final List<LiveRoomEventListener> c = new ArrayList();
  private boolean d = false;
  private String e;
  private String f;
  private String g;
  private boolean h;
  private AppRuntime i;
  private long j;
  private String k;
  private final BroadcastReceiver l = new QQGuildLiveEventHelper.1(this);
  private boolean m = true;
  private final NetworkState.NetworkStateListener n = new QQGuildLiveEventHelper.2(this);
  private String o;
  private final GPServiceObserver p = new QQGuildLiveEventHelper.3(this);
  private final QQGuildObserver q = new QQGuildLiveEventHelper.4(this);
  
  public static QQGuildLiveEventHelper a()
  {
    return b;
  }
  
  private void a(LiveChannelRoomInfo paramLiveChannelRoomInfo)
  {
    QQGuildLiveStartParamsCache.a().setLiveChannelRoomInfo(paramLiveChannelRoomInfo);
    QQGuildLiveRoomUiData.a().a(paramLiveChannelRoomInfo);
  }
  
  private void a(IGProChannelInfo paramIGProChannelInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateChannelInfo, update cache. channelInfo=");
    localStringBuilder.append(paramIGProChannelInfo);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
    QQGuildLiveStartParamsCache.a().setChannelInfo(paramIGProChannelInfo);
    QQGuildLiveRoomUiData.a().a(paramIGProChannelInfo);
    b(paramIGProChannelInfo);
  }
  
  private void a(IGProGuildInfo paramIGProGuildInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateChannelInfo, update cache. guildInfo=");
    localStringBuilder.append(paramIGProGuildInfo);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
    QQGuildLiveStartParamsCache.a().setGuildInfo(paramIGProGuildInfo);
    QQGuildLiveRoomUiData.a().a(paramIGProGuildInfo);
    p();
  }
  
  private void a(IGProGuildInfo paramIGProGuildInfo, List<ICategoryInfo> paramList)
  {
    a(paramIGProGuildInfo);
    if (paramList == null) {
      return;
    }
    IGProChannelInfo localIGProChannelInfo;
    do
    {
      paramIGProGuildInfo = paramList.iterator();
      while (!paramList.hasNext())
      {
        if (!paramIGProGuildInfo.hasNext()) {
          break;
        }
        paramList = ((ICategoryInfo)paramIGProGuildInfo.next()).c();
        if (paramList == null) {
          return;
        }
        paramList = paramList.iterator();
      }
      localIGProChannelInfo = (IGProChannelInfo)paramList.next();
    } while ((localIGProChannelInfo == null) || (!c(localIGProChannelInfo.getChannelUin())));
    a(localIGProChannelInfo);
  }
  
  private void a(@NonNull ILiveRoomInfo paramILiveRoomInfo)
  {
    Object localObject1 = paramILiveRoomInfo.getRoomIcons();
    if ((localObject1 != null) && (((HashMap)localObject1).containsKey("1:1")))
    {
      localObject2 = (String)((HashMap)localObject1).get("1:1");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleLiveRoomPoster from Map = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("QGL.QQGuildLiveEventHelper", 1, ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject2 = "";
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = this.k;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleLiveRoomPoster from mLastAnchorHeadUrl = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("QGL.QQGuildLiveEventHelper", 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (paramILiveRoomInfo.getAnchorInfo() != null)
      {
        localObject2 = paramILiveRoomInfo.getAnchorInfo().getAnchorIcon();
        paramILiveRoomInfo = new StringBuilder();
        paramILiveRoomInfo.append("handleLiveRoomPoster from getAnchorIcon = ");
        paramILiveRoomInfo.append((String)localObject2);
        QLog.i("QGL.QQGuildLiveEventHelper", 1, paramILiveRoomInfo.toString());
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      QQGuildLiveRoomUiData.a().a((String)localObject2);
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (a(paramString1, paramString2))
    {
      if (paramInt == 1)
      {
        this.h = true;
        o();
        return;
      }
      if (paramInt == 2)
      {
        this.h = false;
        o();
        i();
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (!a(paramString1, paramString2))
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "channel not equal, ignore");
      return;
    }
    l();
    if (e(paramString4))
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "TinyId is self, ignore");
      return;
    }
    if (paramInt == 2)
    {
      this.o = null;
      m();
      return;
    }
    if (paramInt == 1)
    {
      this.o = paramString3;
      if (!a(new ArrayList(this.c))) {
        f(paramString3);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, List<ILiveChannelMemberInfo> paramList, int paramInt)
  {
    if ((TextUtils.equals(paramString1, this.f)) && (TextUtils.equals(paramString2, this.g)))
    {
      if (paramInt != 1) {
        return;
      }
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (ILiveChannelMemberInfo)paramString1.next();
        if (paramString2 == null) {
          return;
        }
        if (e(paramString2.a())) {
          return;
        }
        if (!TextUtils.isEmpty(paramString2.b())) {
          QQGuildLiveRoomUiData.a().a(paramString2.b(), false);
        }
      }
    }
  }
  
  private void a(List<LiveRoomEventListener> paramList, @NonNull QQGuildEndLiveModel paramQQGuildEndLiveModel)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LiveRoomEventListener localLiveRoomEventListener = (LiveRoomEventListener)paramList.next();
      if (localLiveRoomEventListener != null) {
        localLiveRoomEventListener.a(paramQQGuildEndLiveModel);
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return (TextUtils.equals(paramString1, this.f)) && (TextUtils.equals(paramString2, this.g));
  }
  
  private boolean a(List<LiveRoomEventListener> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LiveRoomEventListener localLiveRoomEventListener = (LiveRoomEventListener)paramList.next();
      if ((localLiveRoomEventListener != null) && (localLiveRoomEventListener.e())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(List<ILiveRoomInfo> paramList, String paramString)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ILiveRoomInfo localILiveRoomInfo = (ILiveRoomInfo)paramList.next();
        if ((TextUtils.equals(localILiveRoomInfo.getQueryId(), paramString)) && (!TextUtils.isEmpty(localILiveRoomInfo.getRoomId()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(IGProChannelInfo paramIGProChannelInfo)
  {
    long l1 = paramIGProChannelInfo.getLiveRoomId();
    if (l1 > 0L) {
      this.j = l1;
    }
  }
  
  private void b(List<LiveRoomEventListener> paramList, @Nullable String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LiveRoomEventListener localLiveRoomEventListener = (LiveRoomEventListener)paramList.next();
      if (localLiveRoomEventListener != null) {
        localLiveRoomEventListener.a(paramString);
      }
    }
  }
  
  private boolean b(String paramString)
  {
    return TextUtils.equals(paramString, this.f);
  }
  
  private boolean b(String paramString1, String paramString2, String paramString3)
  {
    return (e(paramString1)) && (b(paramString2)) && (c(paramString3));
  }
  
  private boolean c(String paramString)
  {
    return TextUtils.equals(paramString, this.g);
  }
  
  private boolean c(List<String> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (TextUtils.equals((String)paramList.next(), paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private void d(@Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitLiveRoomPageAndDestroySDK. dialogTip=");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, ((StringBuilder)localObject).toString());
    localObject = new ArrayList(this.c);
    QQGuildLiveRoomCommMgr.a().e();
    b((List)localObject, paramString);
  }
  
  private boolean e(String paramString)
  {
    return TextUtils.equals(paramString, this.e);
  }
  
  private void f(String paramString)
  {
    try
    {
      long l1 = Long.parseLong(paramString);
      paramString = new StringBuilder();
      paramString.append("autoEnterLiveRoom start, roomId=");
      paramString.append(l1);
      QLog.i("QGL.QQGuildLiveEventHelper", 1, paramString.toString());
      if (QQGuildLiveRoomCommMgr.a().b())
      {
        QQGuildLiveAudienceRoomMgr.a().a(l1);
        return;
      }
      this.a = false;
      paramString = QQGuildLiveRoomCommMgr.a().d();
      paramString.observeForever(new QQGuildLiveEventHelper.8(this, paramString, l1));
      this.a = true;
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "autoEnterLiveRoom start initLiveSDK.");
      QQGuildLiveRoomCommMgr.a().a(d());
      return;
    }
    catch (NumberFormatException paramString)
    {
      label106:
      break label106;
    }
    QLog.i("QGL.QQGuildLiveEventHelper", 1, "autoEnterLiveRoom parse roomId exception.");
  }
  
  private void g()
  {
    a(((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).getChannelInfo(this.g));
  }
  
  private void h()
  {
    a(((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).getGuildInfo(this.f));
  }
  
  private void i()
  {
    LiveData localLiveData = QQGuildLiveRoomUiData.a().h();
    Boolean localBoolean = Boolean.valueOf(false);
    boolean bool1 = ((Boolean)LiveDataExtKt.a(localLiveData, localBoolean)).booleanValue();
    boolean bool2 = ((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().b(), localBoolean)).booleanValue();
    if ((!bool1) && (bool2))
    {
      GuildLiveToast.b(2131890408);
      m();
    }
  }
  
  private void j()
  {
    QLog.i("QGL.QQGuildLiveEventHelper", 1, "checkLiveStateWhenNetRestore.");
    if (!this.d) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.g);
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).fetchLiveRoomInfoByChannelIds(this.f, localArrayList, new QQGuildLiveEventHelper.5(this));
  }
  
  private void k()
  {
    if (!this.d)
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchChannelInfo.");
      return;
    }
    IGProChannelInfo localIGProChannelInfo = ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).getChannelInfo(this.g);
    if (localIGProChannelInfo != null)
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchChannelInfo suc.");
      QQGuildLiveRoomUiData.a().a(localIGProChannelInfo);
    }
  }
  
  private void l()
  {
    if (!this.d)
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchLiveRoomInfo.");
      return;
    }
    IGPSService localIGPSService = (IGPSService)this.i.getRuntimeService(IGPSService.class, "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.g);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchLiveRoomInfo start.");
    localIGPSService.fetchLiveRoomInfoByChannelIds(this.f, localArrayList, new QQGuildLiveEventHelper.7(this));
  }
  
  private void m()
  {
    QLog.i("QGL.QQGuildLiveEventHelper", 1, "autoExitLiveRoomIfNeed.");
    LiveData localLiveData = QQGuildLiveRoomUiData.a().c();
    Boolean localBoolean = Boolean.valueOf(false);
    if (((Boolean)LiveDataExtKt.a(localLiveData, localBoolean)).booleanValue())
    {
      if (((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().b(), localBoolean)).booleanValue())
      {
        QQGuildLiveAnchorRoomMgr.a().a(true);
        return;
      }
      QQGuildLiveAudienceRoomMgr.a().c();
    }
  }
  
  private void n()
  {
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).fetchLiveChannelAnchorList(this.f, this.g, new QQGuildLiveEventHelper.9(this));
  }
  
  private void o()
  {
    Object localObject = QQGuildLiveRoomUiData.a().l();
    boolean bool1 = false;
    boolean bool2 = ((Boolean)LiveDataExtKt.a((LiveData)localObject, Boolean.valueOf(false))).booleanValue();
    if ((bool2) || (this.h)) {
      bool1 = true;
    }
    QQGuildLiveStartParamsCache.a().setAllowStartLive(bool1);
    QQGuildLiveRoomUiData.a().a(bool1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("haveStartLivePermission:");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" isAdmin:");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(" inAnchorList:");
    ((StringBuilder)localObject).append(this.h);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, ((StringBuilder)localObject).toString());
  }
  
  private void p()
  {
    boolean bool = QQGuildUtil.a(QQGuildLiveStartParamsCache.a().getGuildInfo());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("querySelfIsAdmin isGuildManager=");
    localStringBuilder.append(bool);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
    QQGuildLiveRoomUiData.a().b(bool);
  }
  
  private void q()
  {
    QQGuildLiveRoomUiData.a().a(new GuildLiveJoinRoomMsgAnimView(BaseApplication.getContext()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.e);
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).fetchUserInfo(this.f, localArrayList, false, new QQGuildLiveEventHelper.10(this));
  }
  
  private void r()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqq.intent.action.EXIT_");
    localStringBuilder.append(BaseApplication.getContext().getPackageName());
    localIntentFilter.addAction(localStringBuilder.toString());
    localIntentFilter.addAction("com.tencent.mobileqq.kickedLogin.otherDevice");
    s().registerReceiver(this.l, localIntentFilter);
  }
  
  private Context s()
  {
    return BaseApplication.getContext().getApplicationContext();
  }
  
  private void t()
  {
    s().unregisterReceiver(this.l);
  }
  
  public void a(@NonNull LiveRoomEventListener paramLiveRoomEventListener)
  {
    this.c.add(paramLiveRoomEventListener);
  }
  
  void a(@NonNull QQGuildEndLiveModel paramQQGuildEndLiveModel)
  {
    a(new ArrayList(this.c), paramQQGuildEndLiveModel);
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((b(paramString1, paramString2, paramString3)) && (this.d))
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "init. params is equals and inited, ignore");
      return;
    }
    c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init. channelId=");
    localStringBuilder.append(paramString3);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
    this.d = true;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.i = d();
    r();
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).addObserver(this.p);
    paramString1 = this.i;
    if ((paramString1 instanceof BaseQQAppInterface)) {
      ((BaseQQAppInterface)paramString1).addObserver(this.q);
    }
    b(QQGuildLiveStartParamsCache.a().getChannelInfo());
    NetworkState.addListener(this.n);
    q();
    p();
    n();
    l();
  }
  
  public void b()
  {
    if (this.d)
    {
      if (this.j <= 0L) {
        return;
      }
      IGPSService localIGPSService = (IGPSService)this.i.getRuntimeService(IGPSService.class, "");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(this.j));
      localIGPSService.fetchLiveRoomInfoByRoomIds(localArrayList, new QQGuildLiveEventHelper.6(this));
    }
  }
  
  public void b(LiveRoomEventListener paramLiveRoomEventListener)
  {
    this.c.remove(paramLiveRoomEventListener);
  }
  
  public void c()
  {
    if (!this.d) {
      return;
    }
    QLog.i("QGL.QQGuildLiveEventHelper", 1, "destroy.");
    t();
    ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).deleteObserver(this.p);
    AppRuntime localAppRuntime = this.i;
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      ((BaseQQAppInterface)localAppRuntime).removeObserver(this.q);
    }
    NetworkState.removeListener(this.n);
    this.i = null;
    this.d = false;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = false;
    this.c.clear();
    this.k = null;
    this.j = 0L;
    QQGuildLiveRoomUiData.a().a(null);
    QQGuildLiveRoomUiData.a().b(false);
  }
  
  public AppRuntime d()
  {
    return MobileQQ.sMobileQQ.peekAppRuntime();
  }
  
  public void e()
  {
    QLog.i("QGL.QQGuildLiveEventHelper", 1, "notifyEnterAudienceRoomIfCan.");
    if (!TextUtils.isEmpty(this.o)) {
      f(this.o);
    }
  }
  
  public void f()
  {
    if (!this.d)
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "refreshGuildInfoWhenRoomClosedIfGuest, mInited = false, ignore.");
      return;
    }
    IGProGuildInfo localIGProGuildInfo = QQGuildLiveStartParamsCache.a().getGuildInfo();
    if ((localIGProGuildInfo != null) && (!localIGProGuildInfo.isMember()))
    {
      QLog.i("QGL.QQGuildLiveEventHelper", 1, "refreshGuildInfoWhenRoomClosedIfGuest start.");
      ((IGPSService)this.i.getRuntimeService(IGPSService.class, "")).fetchGuestGuild(localIGProGuildInfo.getGuildID(), new QQGuildLiveEventHelper.11(this));
      a(null);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshGuildInfoWhenRoomClosedIfGuest, guildInfo = ");
    localStringBuilder.append(localIGProGuildInfo);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, localStringBuilder.toString());
  }
  
  public void onFocusGain()
  {
    QLog.i("QGL.QQGuildLiveEventHelper", 1, "AVFocus onFocusGain.");
  }
  
  public void onFocusLoss()
  {
    QLog.i("QGL.QQGuildLiveEventHelper", 1, "AVFocus onFocusLoss.");
    d(HardCodeUtil.a(2131890412));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper
 * JD-Core Version:    0.7.0.1
 */