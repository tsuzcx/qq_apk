package com.tencent.mobileqq.guild.live.viewmodel;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveRoomCommMgr;
import com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.audience.QQGuildLiveAudienceRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildLiveGiftMsgModel;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.guild.util.livedata.BetterLiveData;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.guild.util.livedata.NoRepeatValueLiveData;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig.Builder;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQGuildLiveRoomVM
  extends QQGuildLiveBaseViewModel
{
  private final SingleLiveEvent<Boolean> a = new SingleLiveEvent();
  private final Observer<Boolean> b = new QQGuildLiveRoomVM.1(this);
  private final NoRepeatValueLiveData<String> c = new NoRepeatValueLiveData();
  private final NoRepeatValueLiveData<Boolean> d = new NoRepeatValueLiveData(Boolean.valueOf(false));
  private final BetterLiveData<QQGuildLiveGiftMsgModel> e = new BetterLiveData();
  private QQGuildLiveRoomVmData f;
  private boolean g = false;
  private LiveData<Boolean> h;
  private long i;
  private final Observer<Boolean> j = new QQGuildLiveRoomVM.2(this);
  private LiveData<Boolean> k;
  private boolean l = true;
  private String m;
  private String n;
  private String o;
  private String p;
  private final Observer<Boolean> q = new QQGuildLiveRoomVM.3(this);
  private IQQGiftSDK r;
  
  private void a(long paramLong)
  {
    QQGuildLiveAudienceRoomMgr.a().a(paramLong);
  }
  
  private void a(IGProChannelInfo paramIGProChannelInfo)
  {
    if (paramIGProChannelInfo == null)
    {
      QLog.i("QGL.QQGuildLiveRoomVM", 1, "updateShowTitleName info==null.");
      return;
    }
    String str2 = paramIGProChannelInfo.getLiveRoomName();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramIGProChannelInfo.getChannelName();
    }
    this.c.setValue(str1);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.i("QGL.QQGuildLiveRoomVM", 1, "tryResumeAnchorRoom suc.");
      return;
    }
    QLog.i("QGL.QQGuildLiveRoomVM", 1, "tryResumeAnchorRoom fail.");
    this.a.postValue(Boolean.valueOf(true));
  }
  
  private void j()
  {
    QLog.i("QGL.QQGuildLiveRoomVM", 1, "tryResumeAnchorRoom.");
    this.k = QQGuildLiveAnchorRoomMgr.a().a(this.i, this.p);
    this.k.observeForever(this.b);
  }
  
  private void k()
  {
    if (((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().b(), Boolean.valueOf(false))).booleanValue()) {
      return;
    }
    if (!q()) {
      return;
    }
    long l1 = QQGuildLiveStartParamsCache.a().getRoomId();
    long l2 = QQGuildLiveAudienceRoomMgr.a().f();
    if (l1 != l2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exitLastLiveRoomIfNeed, willEnterRoomId=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", currentRoomId=");
      localStringBuilder.append(l2);
      QLog.i("QGL.QQGuildLiveRoomVM", 1, localStringBuilder.toString());
      QQGuildLiveAudienceRoomMgr.a().b();
    }
  }
  
  private void l()
  {
    this.r = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(10002);
    QQGiftSDKConfig localQQGiftSDKConfig = QQGiftSDKConfig.a().a(10002).a("fe3d11dca6de4cd592a484a3affb1b62").a();
    this.r.a(a(), localQQGiftSDKConfig);
  }
  
  private void m()
  {
    this.c.addSource(QQGuildLiveRoomUiData.a().g(), new QQGuildLiveRoomVM.4(this));
  }
  
  private void n()
  {
    this.c.removeSource(QQGuildLiveRoomUiData.a().g());
  }
  
  private void o()
  {
    if (QQGuildLiveStartParamsCache.a().roomIdIsValid())
    {
      this.i = QQGuildLiveStartParamsCache.a().getRoomId();
      this.p = QQGuildLiveStartParamsCache.a().getLiveRoomProgramId();
      if (q())
      {
        QLog.i("QGL.QQGuildLiveRoomVM", 1, "checkIsInLiveRoom = true, ignore.");
        return;
      }
      if (p())
      {
        QLog.i("QGL.QQGuildLiveRoomVM", 1, "checkParamAnchorIdIsSelf = true.");
        this.h.observeForever(this.q);
        return;
      }
      this.h.observeForever(this.j);
    }
  }
  
  private boolean p()
  {
    IGProChannelInfo localIGProChannelInfo = QQGuildLiveStartParamsCache.a().getChannelInfo();
    if ((localIGProChannelInfo != null) && (localIGProChannelInfo.getLiveAnchorTinyId() > 0L)) {
      return TextUtils.equals(String.valueOf(localIGProChannelInfo.getLiveAnchorTinyId()), this.m);
    }
    return false;
  }
  
  private boolean q()
  {
    return QQGuildLiveRoomUiData.a().c().getValue() == Boolean.TRUE;
  }
  
  private void r()
  {
    QQGuildLiveEventHelper.a().a(this.m, this.o, this.n);
  }
  
  private void s()
  {
    QQGuildLiveRoomStartParams localQQGuildLiveRoomStartParams = QQGuildLiveStartParamsCache.a();
    this.o = localQQGuildLiveRoomStartParams.getGuildInfo().getGuildID();
    this.n = localQQGuildLiveRoomStartParams.getChannelInfo().getChannelUin();
    this.m = ((IGPSService)a().getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    this.c.setValue(localQQGuildLiveRoomStartParams.getChannelInfo().getChannelName());
    QQGuildLiveRoomUiData.a().a(localQQGuildLiveRoomStartParams.getGuildInfo());
    QQGuildLiveRoomUiData.a().a(localQQGuildLiveRoomStartParams.getChannelInfo());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSelfAllowStartLive:");
    localStringBuilder.append(localQQGuildLiveRoomStartParams.getAllowStartLive());
    QLog.i("QGL.QQGuildLiveRoomVM", 1, localStringBuilder.toString());
    QQGuildLiveRoomUiData.a().a(localQQGuildLiveRoomStartParams.getAllowStartLive());
    if (((Integer)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().f(), Integer.valueOf(0))).intValue() == 0) {
      QQGuildLiveRoomUiData.a().a(QQGuildLiveStartParamsCache.a().getViewerNumWhenInit());
    }
  }
  
  private void t()
  {
    LiveData localLiveData = this.h;
    if (localLiveData != null)
    {
      localLiveData.removeObserver(this.j);
      this.h.removeObserver(this.q);
    }
    localLiveData = this.k;
    if (localLiveData != null)
    {
      localLiveData.removeObserver(this.b);
      this.k = null;
    }
    n();
    u();
    this.g = false;
  }
  
  private void u()
  {
    ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).destroySDKImpl(10002);
    this.r = null;
  }
  
  private void v()
  {
    t();
    QQGuildLiveEventHelper.a().c();
    b();
  }
  
  public void a(GiftAnimData paramGiftAnimData)
  {
    if (paramGiftAnimData != null)
    {
      IQQGiftSDK localIQQGiftSDK = this.r;
      if (localIQQGiftSDK != null) {
        this.f.a(localIQQGiftSDK, paramGiftAnimData);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    paramIntent = paramIntent.getSerializableExtra("arg_start_params");
    if ((paramIntent instanceof QQGuildLiveRoomStartParams))
    {
      paramIntent = (QQGuildLiveRoomStartParams)paramIntent;
      if (TextUtils.equals(paramIntent.getChannelInfo().getChannelUin(), this.n))
      {
        QLog.i("QGL.QQGuildLiveRoomVM", 1, "handleOnNewIntent, equals channelId, ignore");
        return false;
      }
      QQGuildLiveStartParamsCache.a(paramIntent);
      v();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.g) {
      return;
    }
    this.g = true;
    this.f = new QQGuildLiveRoomVmData(a());
    k();
    this.h = QQGuildLiveRoomCommMgr.a().a(a());
    s();
    r();
    o();
    l();
    m();
  }
  
  public void b(GiftAnimData paramGiftAnimData)
  {
    if ((paramGiftAnimData != null) && (this.r != null)) {
      this.f.a(paramGiftAnimData, this.e);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.d.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public void c()
  {
    this.f.a(this.r);
  }
  
  public IQQGiftSDK d()
  {
    return this.r;
  }
  
  public LiveData<Boolean> e()
  {
    return this.a;
  }
  
  public LiveData<String> f()
  {
    return this.c;
  }
  
  public LiveData<Boolean> g()
  {
    return this.d;
  }
  
  public LiveData<QQGuildLiveGiftMsgModel> h()
  {
    return this.e;
  }
  
  public void i()
  {
    t();
    if (this.l) {
      QQGuildLiveRoomCommMgr.a().e();
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVM
 * JD-Core Version:    0.7.0.1
 */