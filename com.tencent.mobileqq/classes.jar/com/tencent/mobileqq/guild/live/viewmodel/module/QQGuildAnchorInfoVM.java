package com.tencent.mobileqq.guild.live.viewmodel.module;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveBaseViewModel;
import com.tencent.mobileqq.guild.util.livedata.BetterLiveData;
import com.tencent.mobileqq.guild.util.livedata.NoRepeatValueLiveData;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class QQGuildAnchorInfoVM
  extends QQGuildLiveBaseViewModel
{
  private final BetterLiveData<Drawable> a = new BetterLiveData();
  private final NoRepeatValueLiveData<String> b = new NoRepeatValueLiveData();
  private final BetterLiveData<String> c = new BetterLiveData();
  private String d;
  private boolean e;
  private final GPServiceObserver f = new QQGuildAnchorInfoVM.1(this);
  
  private IGProUserInfo a(List<IGProUserInfo> paramList, String paramString)
  {
    if (paramList == null) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
      if (TextUtils.equals(localIGProUserInfo.a(), paramString)) {
        return localIGProUserInfo;
      }
    }
    return null;
  }
  
  private void a(String paramString)
  {
    this.c.setValue(paramString);
  }
  
  private void b(String paramString)
  {
    IQQGuildAvatarApi localIQQGuildAvatarApi = (IQQGuildAvatarApi)a().getRuntimeService(IQQGuildAvatarApi.class, "");
    Object localObject = (IGPSService)a().getRuntimeService(IGPSService.class, "");
    GuildUserAvatar localGuildUserAvatar = ((IGPSService)localObject).getGuildUsersAvatarUrl(paramString);
    if (localGuildUserAvatar == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getGuildUsersAvatarUrl == null, id:");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("QGL.QQGuildAnchorInfoVM", 1, ((StringBuilder)localObject).toString());
      }
      return;
    }
    paramString = localIQQGuildAvatarApi.getAvatarDrawable(((IGPSService)localObject).getFullAvatarUrl(localGuildUserAvatar, 0), 0, true);
    this.a.setValue(paramString);
    paramString = ((IGPSService)localObject).getFullAvatarUrl(localGuildUserAvatar, 2);
    this.b.setValue(paramString);
    QQGuildLiveEventHelper.a().a(paramString);
  }
  
  private void f()
  {
    h();
    LiveChannelRoomInfo localLiveChannelRoomInfo = QQGuildLiveStartParamsCache.a().getLiveChannelRoomInfo();
    if (this.e)
    {
      if (localLiveChannelRoomInfo != null) {
        a(localLiveChannelRoomInfo.getAnchorNick());
      }
    }
    else {
      a(QQGuildLiveStartParamsCache.a().getChannelInfo().getGuildId(), this.d);
    }
  }
  
  private void g()
  {
    LiveChannelRoomInfo localLiveChannelRoomInfo = QQGuildLiveStartParamsCache.a().getLiveChannelRoomInfo();
    if ((localLiveChannelRoomInfo != null) && (!TextUtils.isEmpty(localLiveChannelRoomInfo.getAnchorNick()))) {
      a(localLiveChannelRoomInfo.getAnchorNick());
    }
  }
  
  private void h()
  {
    Object localObject = QQGuildLiveStartParamsCache.a().getGuildInfo().getGuildID();
    localObject = ((IGPSService)a().getRuntimeService(IGPSService.class, "")).getGuildInfoForGuest((String)localObject);
    boolean bool;
    if ((localObject != null) && (!((IGProGuildInfo)localObject).isMember())) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mSelfIsGuest = ");
      ((StringBuilder)localObject).append(this.e);
      QLog.i("QGL.QQGuildAnchorInfoVM", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo)
  {
    if ((paramIGProChannelInfo != null) && (paramIGProChannelInfo.getLiveAnchorTinyId() > 0L))
    {
      String str = String.valueOf(paramIGProChannelInfo.getLiveAnchorTinyId());
      if (TextUtils.equals(str, this.d))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QGL.QQGuildAnchorInfoVM", 1, "updateAllInfo == false, equals anchorId, ignore.");
        }
        return;
      }
      this.d = str;
      b(str);
      if (this.e)
      {
        QLog.i("QGL.QQGuildAnchorInfoVM", 1, "self is guest, needn't query channel name.");
        return;
      }
      a(paramIGProChannelInfo.getGuildId(), str);
      return;
    }
    this.a.setValue(null);
    this.b.setValue("http://down.qq.com/innovate/guild/guild_live_channel/live_channel_room_bg.png");
    this.c.setValue(null);
    this.d = null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    ((IGPSService)a().getRuntimeService(IGPSService.class, "")).fetchUserInfo(paramString1, localArrayList, true, new QQGuildAnchorInfoVM.4(this, paramString2));
  }
  
  public LiveData<String> b()
  {
    return this.c;
  }
  
  public LiveData<Drawable> c()
  {
    return this.a;
  }
  
  public LiveData<String> d()
  {
    return this.b;
  }
  
  public void e()
  {
    g();
    h();
    this.c.addSource(QQGuildLiveRoomUiData.a().n(), new QQGuildAnchorInfoVM.2(this));
    this.c.addSource(QQGuildLiveRoomUiData.a().g(), new QQGuildAnchorInfoVM.3(this));
    ((IGPSService)a().getRuntimeService(IGPSService.class, "")).addObserver(this.f);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.c.removeSource(QQGuildLiveRoomUiData.a().n());
    this.c.removeSource(QQGuildLiveRoomUiData.a().g());
    ((IGPSService)a().getRuntimeService(IGPSService.class, "")).deleteObserver(this.f);
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.module.QQGuildAnchorInfoVM
 * JD-Core Version:    0.7.0.1
 */