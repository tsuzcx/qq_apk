package com.tencent.mobileqq.guild.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.lifecycle.MutableLiveData;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.avbiz.IModule.FocusChangeListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.audio.data.AudioRoomError;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.data.NotifyUIData;
import com.tencent.mobileqq.guild.audio.data.TRTCUserInfoList;
import com.tencent.mobileqq.guild.audio.data.UserInfo;
import com.tencent.mobileqq.guild.audio.data.UserInfoList;
import com.tencent.mobileqq.guild.audio.widget.QQGuildAudioChanelFloatingWrapper;
import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.guild.util.GuildAVPriorityManager;
import com.tencent.mobileqq.guild.window.GuildFloatWindowManager;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AudioRoom
  extends BusinessHandler
  implements IModule.FocusChangeListener, AudioRouter.AudioRouterChangeListener, IAudioRoomHandler, ITRTCAudioRoom.ITRTCAudioRoomListener
{
  private static AudioRoom a;
  private static boolean c = false;
  private BaseQQAppInterface b;
  private final ITRTCAudioRoom d = TRTCAudioRoomLocal.f();
  private LocalUserInfo e = new LocalUserInfo();
  private UserInfoList f = new UserInfoList();
  private LocalUserInfo g = new LocalUserInfo();
  private UserInfoList h = new UserInfoList();
  private TRTCUserInfoList i = new TRTCUserInfoList();
  private final AudioRouter j = new AudioRouter(this);
  private Timer k;
  private TimerTask l;
  private Timer m;
  private TimerTask n;
  private boolean o = false;
  private PhoneStatusMonitor p = null;
  private BroadcastReceiver q = new AudioRoom.1(this);
  private QQGuildObserver r = new AudioRoom.2(this);
  private GPServiceObserver s = new AudioRoom.3(this);
  
  protected AudioRoom(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    a(this.e.a, this.e.b, paramInt1, paramString1, paramInt2, paramString2);
  }
  
  private void a(int paramInt, String paramString, IAudioChannelMemberInfos paramIAudioChannelMemberInfos)
  {
    if (paramInt != 0)
    {
      paramIAudioChannelMemberInfos = new StringBuilder();
      paramIAudioChannelMemberInfos.append("in room onFetchAudioChannelUserList failed or channelMemberInfos null as result:");
      paramIAudioChannelMemberInfos.append(paramInt);
      paramIAudioChannelMemberInfos.append(", errMsg:");
      paramIAudioChannelMemberInfos.append(paramString);
      QLog.e("AudioRoom", 1, paramIAudioChannelMemberInfos.toString());
      b(1, AudioRoomError.a(1, paramInt, paramString), paramInt, paramString);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("in room onFetchAudioChannelUserList tid:");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.e("AudioRoom", 1, ((StringBuilder)localObject).toString());
    if (paramIAudioChannelMemberInfos == null)
    {
      this.h.a.clear();
    }
    else
    {
      paramIAudioChannelMemberInfos = paramIAudioChannelMemberInfos.d();
      UserInfo.a(paramIAudioChannelMemberInfos, this.h.a);
      this.h.a(this.i);
      this.g.a(paramIAudioChannelMemberInfos);
      paramIAudioChannelMemberInfos = this.h.a(this.g.h);
      if (paramIAudioChannelMemberInfos != null) {
        paramIAudioChannelMemberInfos.a(this.g);
      }
    }
    paramIAudioChannelMemberInfos = this.h.a.iterator();
    while (paramIAudioChannelMemberInfos.hasNext())
    {
      localObject = (UserInfo)paramIAudioChannelMemberInfos.next();
      if (((UserInfo)localObject).o) {
        this.d.a(((UserInfo)localObject).h, true);
      }
    }
    paramIAudioChannelMemberInfos = new StringBuilder();
    paramIAudioChannelMemberInfos.append("in room onFetchAudioChannelUserList result:");
    paramIAudioChannelMemberInfos.append(paramInt);
    paramIAudioChannelMemberInfos.append(", errMsg:");
    paramIAudioChannelMemberInfos.append(paramString);
    paramIAudioChannelMemberInfos.append(", userInfos:");
    paramIAudioChannelMemberInfos.append(this.h.a);
    QLog.i("AudioRoom", 1, paramIAudioChannelMemberInfos.toString());
    b("onFetchAudioChannelUserList", true);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    try
    {
      if (!c) {
        a = null;
      }
      if (a == null)
      {
        a = (AudioRoom)paramBaseQQAppInterface.getBusinessHandler(AudioRoom.class.getName());
        a.b = paramBaseQQAppInterface;
        a.a();
        a.h();
        c = true;
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitRoomAndPreviewByGuild guild=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", reason=");
    localStringBuilder.append(paramString2);
    QLog.i("AudioRoom", 1, localStringBuilder.toString());
    if (this.e.a.equals(paramString1)) {
      h(paramString2);
    }
    if (this.g.a.equals(paramString1))
    {
      m();
      i(paramString2);
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4)
  {
    NotifyUIData localNotifyUIData = new NotifyUIData();
    localNotifyUIData.a(1, paramString1);
    localNotifyUIData.a(2, paramString2);
    localNotifyUIData.a(6, Integer.valueOf(paramInt1));
    localNotifyUIData.a(7, paramString3);
    localNotifyUIData.a(8, Integer.valueOf(paramInt2));
    localNotifyUIData.a(9, paramString4);
    notifyUI(3, true, localNotifyUIData);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitPreviewAndNotifyByChannel guild=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", channelId=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", reason=");
    localStringBuilder.append(paramString3);
    QLog.i("AudioRoom", 1, localStringBuilder.toString());
    if ((this.e.a.equals(paramString1)) && (this.e.b.equals(paramString2))) {
      h(paramString3);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    this.g.b();
    LocalUserInfo localLocalUserInfo = this.g;
    localLocalUserInfo.h = paramString3;
    localLocalUserInfo.c = true;
    localLocalUserInfo.e = paramInt1;
    localLocalUserInfo.a = paramString1;
    localLocalUserInfo.b = paramString2;
    localLocalUserInfo.p = paramBoolean1;
    localLocalUserInfo.m = (paramBoolean2 ^ true);
    localLocalUserInfo.k = paramInt2;
    this.h.a.clear();
    this.e.b();
    this.f.a.clear();
    this.i.b();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, LocalUserInfo paramLocalUserInfo, UserInfoList paramUserInfoList)
  {
    a(paramString1, paramString2, paramString3, paramLocalUserInfo, paramUserInfoList, false);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, LocalUserInfo paramLocalUserInfo, UserInfoList paramUserInfoList, boolean paramBoolean)
  {
    NotifyUIData localNotifyUIData = new NotifyUIData();
    localNotifyUIData.a(1, paramString2);
    localNotifyUIData.a(2, paramString3);
    localNotifyUIData.a(3, paramLocalUserInfo.a());
    localNotifyUIData.a(4, paramUserInfoList.a());
    localNotifyUIData.a(10, paramString1);
    notifyUI(1, true, localNotifyUIData, paramBoolean);
  }
  
  public static AudioRoom b()
  {
    try
    {
      AudioRoom localAudioRoom = a;
      return localAudioRoom;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    a(this.g.a, this.g.b, paramInt1, paramString1, paramInt2, paramString2);
  }
  
  private void b(IGProChannelInfo paramIGProChannelInfo, AudioRoom.IEnterRoomCallback paramIEnterRoomCallback)
  {
    i();
    QLog.i("AudioRoom", 1, "enterRoom 1");
    this.d.a(this.b.getApplicationContext(), new AudioRoom.7(this, paramIEnterRoomCallback, paramIGProChannelInfo));
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitRoomAndNotifyByChannel guild=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", channelId=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", reason=");
    localStringBuilder.append(paramString3);
    QLog.i("AudioRoom", 1, localStringBuilder.toString());
    if ((c()) && (this.g.a.equals(paramString1)) && (this.g.b.equals(paramString2)))
    {
      m();
      i(paramString3);
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    a(paramString, this.g.a, this.g.b, this.g, this.h, paramBoolean);
  }
  
  private void c(String paramString1, String paramString2, String paramString3)
  {
    NotifyUIData localNotifyUIData = new NotifyUIData();
    localNotifyUIData.a(1, paramString1);
    localNotifyUIData.a(2, paramString2);
    localNotifyUIData.a(5, paramString3);
    notifyUI(2, true, localNotifyUIData);
  }
  
  private void d(String paramString)
  {
    m();
    i(paramString);
  }
  
  private void e(String paramString)
  {
    h(paramString);
    m();
    i(paramString);
  }
  
  private void f(String paramString)
  {
    a(paramString, this.e.a, this.e.b, this.e, this.f);
  }
  
  private void g(String paramString)
  {
    b(paramString, false);
  }
  
  private void h()
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
    this.b.getApplicationContext().registerReceiver(this.q, localIntentFilter);
  }
  
  private void h(String paramString)
  {
    c(this.e.a, this.e.b, paramString);
  }
  
  private void i()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      ((TimerTask)localObject).cancel();
      this.l = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.k = null;
    }
  }
  
  private void i(String paramString)
  {
    c(this.g.a, this.g.b, paramString);
  }
  
  private void j()
  {
    ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).fetchAudioChannelUserList(this.e.a, this.e.b, new AudioRoom.6(this));
  }
  
  private void k()
  {
    QLog.i("AudioRoom", 1, "exitAudioChannel");
    ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).exitAudioChannel(this.g.a, this.g.b, new AudioRoom.9(this));
  }
  
  private void l()
  {
    QLog.i("AudioRoom", 1, "exitTrtcRoom");
    this.d.a(new AudioRoom.10(this));
  }
  
  private void m()
  {
    QLog.i("AudioRoom", 1, "internalExitRoom");
    if (!c()) {
      return;
    }
    GuildAVPriorityManager.a("频道通话");
    this.p = null;
    this.j.b();
    l();
    k();
    n();
    this.g.c = false;
  }
  
  private void n()
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      ((TimerTask)localObject).cancel();
      this.n = null;
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.m = null;
    }
  }
  
  private void o()
  {
    if (this.p == null) {
      this.b.runOnUiThread(new AudioRoom.16(this));
    }
  }
  
  public void a()
  {
    this.b.addObserver(this.r);
    ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).addObserver(this.s);
  }
  
  public void a(int paramInt)
  {
    if (!c())
    {
      QLog.w("AudioRoom", 1, "setAudioRoute when not in room!");
      return;
    }
    if ((QLog.isColorLevel()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAudioRoute[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("AudioRoom", 2, localStringBuilder.toString());
    }
    this.j.a(paramInt);
    if (paramInt == 0)
    {
      this.d.e();
      return;
    }
    if (paramInt == 1) {
      this.d.d();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pushOnTRTCExitRoom reason:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg:");
    localStringBuilder.append(paramString);
    QLog.w("AudioRoom", 1, localStringBuilder.toString());
  }
  
  public void a(AudioRoom.IExitRoomCallback paramIExitRoomCallback)
  {
    QLog.i("AudioRoom", 1, "exitRoom");
    if (!c()) {
      return;
    }
    if (GuildFloatWindowManager.a.b(QQGuildAudioChanelFloatingWrapper.class.getName())) {
      GuildFloatWindowUtils.a();
    } else {
      AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.DISMISS);
    }
    GuildAVPriorityManager.a("频道通话");
    this.j.b();
    this.g.c = false;
    this.d.a(new AudioRoom.11(this));
    ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).exitAudioChannel(this.g.a, this.g.b, new AudioRoom.12(this, paramIExitRoomCallback));
    n();
    i("");
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo)
  {
    if (paramIGProChannelInfo == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deInit guildid:");
    localStringBuilder.append(paramIGProChannelInfo.getGuildId());
    localStringBuilder.append(", channelid:");
    localStringBuilder.append(paramIGProChannelInfo.getChannelUin());
    QLog.i("AudioRoom", 1, localStringBuilder.toString());
    if ((this.e.a.equals(paramIGProChannelInfo.getGuildId())) && (this.e.b.equals(paramIGProChannelInfo.getChannelUin()))) {
      i();
    }
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo, AudioRoom.IEnterRoomCallback paramIEnterRoomCallback)
  {
    QLog.i("AudioRoom", 1, "enterRoom 0");
    if (!GuildAVPriorityManager.a(this.b, "频道通话", this))
    {
      paramIEnterRoomCallback.a(false, null);
      return;
    }
    if (c())
    {
      QLog.w("AudioRoom", 1, "enterRoom exitroom first");
      a(new AudioRoom.8(this, paramIGProChannelInfo, paramIEnterRoomCallback));
      return;
    }
    b(paramIGProChannelInfo, paramIEnterRoomCallback);
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo, AudioRoom.IInitCallback paramIInitCallback, boolean paramBoolean)
  {
    String str1 = paramIGProChannelInfo.getGuildId();
    String str2 = paramIGProChannelInfo.getChannelUin();
    this.e.e = paramIGProChannelInfo.getChannelMemberMax();
    if (!c())
    {
      a(str1, str2, paramIInitCallback, paramBoolean);
      return;
    }
    if (this.g.b.equals(str2))
    {
      paramIInitCallback.a(true, "", this.g, this.h);
      return;
    }
    a(str1, str2, paramIInitCallback, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, AudioRoom.IInitCallback paramIInitCallback, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("previewUserData 0:");
    ((StringBuilder)localObject).append(this.e.b);
    ((StringBuilder)localObject).append(", enterRoom : ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("AudioRoom", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      paramIInitCallback.a(false, "", this.e, this.f);
      return;
    }
    this.e.b();
    localObject = this.e;
    ((LocalUserInfo)localObject).a = paramString1;
    ((LocalUserInfo)localObject).b = paramString2;
    this.f.a.clear();
    paramIInitCallback.a(true, "", this.e, this.f);
    paramString2 = ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).fetchUserInfo(paramString1, new ArrayList(Arrays.asList(new String[] { paramString2 })), false, new AudioRoom.4(this));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, IResultCallback paramIResultCallback)
  {
    ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).setUserMuteSeatInGuild(paramString1, paramString2, paramString3, paramBoolean, new AudioRoom.15(this, paramString1, paramString2, paramString3, paramBoolean, paramIResultCallback));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!c())
    {
      QLog.w("AudioRoom", 1, "pushOnTRTCAudioAvailable when not in room!");
      return;
    }
    this.i.a(paramString, paramBoolean);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onTRTCAudioAvailable userId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", available:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", tid:");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.i("AudioRoom", 1, ((StringBuilder)localObject).toString());
    if ((this.g.c) && (this.g.h.equals(paramString))) {
      this.g.m = paramBoolean;
    }
    localObject = this.h.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UserInfo localUserInfo = (UserInfo)((Iterator)localObject).next();
      if (localUserInfo.h.equals(paramString))
      {
        QLog.i("AudioRoom", 1, "onTRTCAudioAvailable 2");
        localUserInfo.m = paramBoolean;
      }
    }
    g("pushOnTRTCAudioAvailable");
  }
  
  public void a(String paramString, boolean paramBoolean, IResultCallback paramIResultCallback)
  {
    ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).setUserVoicelessToMe(paramString, paramBoolean, new AudioRoom.14(this, paramString, paramBoolean, paramIResultCallback));
  }
  
  public void a(ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    if (!c())
    {
      QLog.w("AudioRoom", 1, "pushOnTRTCUserVoiceVolume ignore when out room!");
      return;
    }
    this.i.a(paramArrayList);
    Iterator localIterator1 = this.h.a.iterator();
    while (localIterator1.hasNext())
    {
      UserInfo localUserInfo = (UserInfo)localIterator1.next();
      Iterator localIterator2 = paramArrayList.iterator();
      while (localIterator2.hasNext())
      {
        ITRTCAudioRoom.TRTCVolumeInfo localTRTCVolumeInfo = (ITRTCAudioRoom.TRTCVolumeInfo)localIterator2.next();
        if (localUserInfo.h.equals(localTRTCVolumeInfo.a))
        {
          localUserInfo.n = localTRTCVolumeInfo.b;
          if (localUserInfo.h.equals(this.g.h)) {
            this.g.n = localUserInfo.n;
          }
          paramInt = 1;
          break label149;
        }
      }
      paramInt = 0;
      label149:
      if (paramInt == 0) {
        localUserInfo.n = 0;
      }
    }
    g("pushOnTRTCUserVoiceVolume");
  }
  
  public void a(boolean paramBoolean)
  {
    if (!c())
    {
      QLog.i("AudioRoom", 1, "setMicrophone when not in room!");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMicrophone[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("AudioRoom", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.d.b();
      return;
    }
    this.d.c();
  }
  
  public boolean a(String paramString)
  {
    return (this.g.c) && (this.g.b.equals(paramString));
  }
  
  public void b(int paramInt)
  {
    this.g.d = paramInt;
    g("onAudioRouterChange");
  }
  
  public void b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pushOnTRTCError: errCode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] errMsg[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.w("AudioRoom", 1, localStringBuilder.toString());
    a(null);
    AudioRoomError.a(0);
    b(3, AudioRoomError.a(3, paramInt, paramString), paramInt, paramString);
  }
  
  public void b(String paramString)
  {
    if (!c())
    {
      QLog.w("AudioRoom", 1, "pushOnTRTCAnchorEnter when not in room!");
      return;
    }
    this.i.a(paramString);
  }
  
  public void c(String paramString)
  {
    if (!c())
    {
      QLog.w("AudioRoom", 1, "pushOnTRTCAnchorExit when not in room!");
      return;
    }
    this.i.b(paramString);
  }
  
  public boolean c()
  {
    return this.g.c;
  }
  
  public boolean d()
  {
    return this.o;
  }
  
  public boolean e()
  {
    return this.g.m;
  }
  
  public void f()
  {
    i();
    if (this.k == null) {
      this.k = new Timer();
    }
    if (this.l == null) {
      this.l = new AudioRoom.5(this);
    }
    this.k.schedule(this.l, 0L, 10000L);
  }
  
  public void g()
  {
    n();
    if (this.m == null) {
      this.m = new Timer();
    }
    if (this.n == null) {
      this.n = new AudioRoom.13(this);
    }
    this.m.schedule(this.n, 0L, 5000L);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return AudioRoomObserver.class;
  }
  
  public void onFocusGain() {}
  
  public void onFocusLoss()
  {
    QLog.w("AudioRoom", 1, "onFocusLoss");
    if ("音视频通话".equals(AVBizModuleFactory.getModuleByName("频道通话").getFocusBusiness().get(Long.valueOf(1L)))) {
      a(null);
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom
 * JD-Core Version:    0.7.0.1
 */