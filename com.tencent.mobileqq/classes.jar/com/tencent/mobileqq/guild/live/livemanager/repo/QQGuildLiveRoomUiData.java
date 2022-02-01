package com.tencent.mobileqq.guild.live.livemanager.repo;

import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.live.widget.GuildLiveJoinRoomMsgAnimView;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.guild.util.livedata.BetterLiveData;
import com.tencent.mobileqq.guild.util.livedata.NoRepeatValueLiveData;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;

public class QQGuildLiveRoomUiData
{
  private static final QQGuildLiveRoomUiData a = new QQGuildLiveRoomUiData();
  private final NoRepeatValueLiveData<Boolean> b;
  private final NoRepeatValueLiveData<Boolean> c;
  private final NoRepeatValueLiveData<View> d;
  private final NoRepeatValueLiveData<Boolean> e;
  private final NoRepeatValueLiveData<Integer> f;
  private final BetterLiveData<IGProGuildInfo> g;
  private final BetterLiveData<IGProChannelInfo> h;
  private final NoRepeatValueLiveData<Boolean> i;
  private final NoRepeatValueLiveData<Boolean> j;
  private final NoRepeatValueLiveData<GuildLiveJoinRoomMsgAnimView> k;
  private final SingleLiveEvent<GiftMessage> l;
  private final SingleLiveEvent<String> m;
  private final NoRepeatValueLiveData<Boolean> n;
  private final BetterLiveData<LiveChannelRoomInfo> o;
  
  public QQGuildLiveRoomUiData()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    this.b = new NoRepeatValueLiveData(localBoolean);
    this.c = new NoRepeatValueLiveData(localBoolean);
    this.d = new NoRepeatValueLiveData(null);
    this.e = new NoRepeatValueLiveData(Boolean.valueOf(true));
    this.f = new NoRepeatValueLiveData(Integer.valueOf(0));
    this.g = new BetterLiveData();
    this.h = new BetterLiveData();
    this.i = new NoRepeatValueLiveData(localBoolean);
    this.j = new NoRepeatValueLiveData();
    this.k = new NoRepeatValueLiveData();
    this.l = new SingleLiveEvent();
    this.m = new SingleLiveEvent();
    this.n = new NoRepeatValueLiveData(localBoolean);
    this.o = new BetterLiveData();
  }
  
  public static QQGuildLiveRoomUiData a()
  {
    return a;
  }
  
  public void a(int paramInt)
  {
    this.f.setValue(Integer.valueOf(paramInt));
  }
  
  public void a(View paramView)
  {
    this.d.setValue(paramView);
  }
  
  public void a(LiveChannelRoomInfo paramLiveChannelRoomInfo)
  {
    this.o.setValue(paramLiveChannelRoomInfo);
  }
  
  public void a(GuildLiveJoinRoomMsgAnimView paramGuildLiveJoinRoomMsgAnimView)
  {
    this.k.setValue(paramGuildLiveJoinRoomMsgAnimView);
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo)
  {
    this.h.setValue(paramIGProChannelInfo);
  }
  
  public void a(IGProGuildInfo paramIGProGuildInfo)
  {
    this.g.setValue(paramIGProGuildInfo);
  }
  
  public void a(GiftMessage paramGiftMessage)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      UiThreadUtil.a(new QQGuildLiveRoomUiData.1(this, paramGiftMessage));
      return;
    }
    this.l.setValue(paramGiftMessage);
  }
  
  public void a(Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoIsLand isLand:");
    localStringBuilder.append(paramBoolean);
    QLog.i("QGL.QQGuildLiveRoomUiData", 1, localStringBuilder.toString());
    this.e.setValue(paramBoolean);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateRoomLogo posterUrl:");
    localStringBuilder.append(paramString);
    QLog.i("QGL.QQGuildLiveRoomUiData", 1, localStringBuilder.toString());
    this.m.setValue(paramString);
  }
  
  public void a(@NonNull String paramString, boolean paramBoolean)
  {
    GuildLiveJoinRoomMsgAnimView localGuildLiveJoinRoomMsgAnimView = (GuildLiveJoinRoomMsgAnimView)this.k.getValue();
    if (localGuildLiveJoinRoomMsgAnimView != null) {
      localGuildLiveJoinRoomMsgAnimView.a(paramString, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public LiveData<Boolean> b()
  {
    return this.b;
  }
  
  public void b(Boolean paramBoolean)
  {
    this.c.setValue(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    this.j.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public LiveData<Boolean> c()
  {
    return this.c;
  }
  
  public void c(Boolean paramBoolean)
  {
    this.b.setValue(paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    this.n.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public LiveData<View> d()
  {
    return this.d;
  }
  
  public LiveData<Boolean> e()
  {
    return this.e;
  }
  
  public LiveData<Integer> f()
  {
    return this.f;
  }
  
  public LiveData<IGProChannelInfo> g()
  {
    return this.h;
  }
  
  public LiveData<Boolean> h()
  {
    return this.i;
  }
  
  public LiveData<? extends View> i()
  {
    return this.k;
  }
  
  public LiveData<String> j()
  {
    return this.m;
  }
  
  public LiveData<GiftMessage> k()
  {
    return this.l;
  }
  
  public LiveData<Boolean> l()
  {
    return this.j;
  }
  
  public LiveData<Boolean> m()
  {
    return this.n;
  }
  
  public LiveData<LiveChannelRoomInfo> n()
  {
    return this.o;
  }
  
  public void o()
  {
    QQGuildLiveRoomUiData localQQGuildLiveRoomUiData = a();
    Boolean localBoolean = Boolean.valueOf(false);
    localQQGuildLiveRoomUiData.b(localBoolean);
    localQQGuildLiveRoomUiData.a(0);
    localQQGuildLiveRoomUiData.a(null);
    localQQGuildLiveRoomUiData.a(Boolean.valueOf(true));
    localQQGuildLiveRoomUiData.c(localBoolean);
    localQQGuildLiveRoomUiData.a(null);
    localQQGuildLiveRoomUiData.c(false);
    localQQGuildLiveRoomUiData.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData
 * JD-Core Version:    0.7.0.1
 */