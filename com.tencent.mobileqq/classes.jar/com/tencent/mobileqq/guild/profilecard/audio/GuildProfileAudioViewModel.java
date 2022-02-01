package com.tencent.mobileqq.guild.profilecard.audio;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.audio.AudioRoom;
import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.profilecard.main.ShowToastModel;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientArchiveInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSmobaArchiveTemplateInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;

public class GuildProfileAudioViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  public static ViewModelProvider.Factory a = new GuildProfileAudioViewModel.1();
  private GuildBaseProfileData b;
  private MutableLiveData<GuildAudioChannelData> c = new MutableLiveData();
  private MutableLiveData<Integer> d = new SingleLiveEvent();
  private MediatorLiveData<GuildAudioProfileDisplayData> e = new MediatorLiveData();
  private SingleLiveEvent<Boolean> f = new SingleLiveEvent();
  private SingleLiveEvent<ShowToastModel> g = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> h = new SingleLiveEvent();
  private GPServiceObserver i = new GuildProfileAudioViewModel.2(this);
  private final AudioRoomObserver j = new GuildProfileAudioViewModel.3(this);
  
  public GuildProfileAudioViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  private void a(IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    if (paramIGProUserProfileInfo != null)
    {
      boolean bool1 = bool3;
      if (paramIGProUserProfileInfo.n() != null)
      {
        bool1 = bool3;
        if (paramIGProUserProfileInfo.n().a() > 0) {
          bool1 = false;
        }
      }
      paramIGProUserProfileInfo = paramIGProUserProfileInfo.o();
      bool2 = bool1;
      if (paramIGProUserProfileInfo != null)
      {
        bool2 = bool1;
        if (paramIGProUserProfileInfo.size() > 0)
        {
          int m = paramIGProUserProfileInfo.size();
          int k = 0;
          while (k < m)
          {
            bool2 = bool1;
            if (((IGProClientArchiveInfo)paramIGProUserProfileInfo.get(k)).b() != null)
            {
              bool2 = bool1;
              if (((IGProClientArchiveInfo)paramIGProUserProfileInfo.get(k)).b().a() > 0) {
                bool2 = false;
              }
            }
            k += 1;
            bool1 = bool2;
          }
          bool2 = bool1;
        }
      }
    }
    this.h.setValue(Boolean.valueOf(bool2));
  }
  
  private void k()
  {
    IGPSService localIGPSService = (IGPSService)((QQGuildInfoRepository)this.z).a().getRuntimeService(IGPSService.class, "");
    localIGPSService.refreshGuildUserProfileInfo(this.b.a(), this.b.c());
    localIGPSService.addObserver(this.i);
    ((QQGuildInfoRepository)this.z).a().addObserver(this.j);
  }
  
  public void a()
  {
    ((QQGuildInfoRepository)this.z).b(this.i);
    ((QQGuildInfoRepository)this.z).a().removeObserver(this.j);
    this.e.removeSource(this.d);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    ((QQGuildInfoRepository)this.z).a(paramAppInterface);
    k();
    this.e.removeSource(this.d);
    this.e.addSource(this.d, new GuildProfileAudioViewModel.4(this));
  }
  
  public void a(GuildBaseProfileData paramGuildBaseProfileData)
  {
    this.b = paramGuildBaseProfileData;
  }
  
  public void a(GuildAudioChannelData paramGuildAudioChannelData)
  {
    if (paramGuildAudioChannelData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("GuildProfileAudioViewModel", 1, "setChannelData channelData is null!");
      }
      return;
    }
    this.c.setValue(paramGuildAudioChannelData);
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClickKickOutChannel guildId[");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append("], channelId[");
      localStringBuilder.append(((GuildAudioChannelData)this.c.getValue()).a());
      localStringBuilder.append("], tinyId[");
      localStringBuilder.append(((GuildAudioChannelData)this.c.getValue()).d());
      localStringBuilder.append("]");
      QLog.i("GuildProfileAudioViewModel", 2, localStringBuilder.toString());
    }
    ((IGPSService)((QQGuildInfoRepository)this.z).a().getRuntimeService(IGPSService.class, "")).kickAudioChannelUsers(this.b.a(), ((GuildAudioChannelData)this.c.getValue()).a(), new ArrayList(Collections.singletonList(((GuildAudioChannelData)this.c.getValue()).d())), new GuildProfileAudioViewModel.5(this));
  }
  
  public void c()
  {
    AudioRoom.b().a(this.b.a(), ((GuildAudioChannelData)this.c.getValue()).a(), this.b.c(), ((GuildAudioChannelData)this.c.getValue()).g() ^ true, new GuildProfileAudioViewModel.6(this));
  }
  
  public void d()
  {
    AudioRoom.b().a(this.b.c(), ((GuildAudioChannelData)this.c.getValue()).f() ^ true, new GuildProfileAudioViewModel.7(this));
  }
  
  public MutableLiveData<GuildAudioChannelData> e()
  {
    return this.c;
  }
  
  public SingleLiveEvent<Boolean> f()
  {
    return this.f;
  }
  
  public SingleLiveEvent<Boolean> g()
  {
    return this.h;
  }
  
  public SingleLiveEvent<ShowToastModel> h()
  {
    return this.g;
  }
  
  public MediatorLiveData<GuildAudioProfileDisplayData> i()
  {
    return this.e;
  }
  
  public GuildBaseProfileData j()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.audio.GuildProfileAudioViewModel
 * JD-Core Version:    0.7.0.1
 */