package com.tencent.mobileqq.guild.profilecard.main;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientArchiveInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSmobaArchiveTemplateInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.remind.TimeHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GuildProfileHeaderViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  public static ViewModelProvider.Factory a = new GuildProfileHeaderViewModel.1();
  private GuildBaseProfileData b;
  private GPServiceObserver c;
  private MutableLiveData<GuildHeaderData> d = new MutableLiveData();
  private SingleLiveEvent<Boolean> e = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> f = new SingleLiveEvent();
  
  public GuildProfileHeaderViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  private int a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 > 0L))
    {
      if (QLog.isColorLevel())
      {
        String str1 = TimeHelper.d(paramLong1);
        String str2 = TimeHelper.d(paramLong2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("date: ");
        localStringBuilder.append(str1);
        localStringBuilder.append(" - date2: ");
        localStringBuilder.append(str2);
        QLog.i("GuildProfileHeaderViewModel", 1, localStringBuilder.toString());
      }
      return (int)(Math.abs(paramLong1 - paramLong2) / 1000L / 60L / 60L / 24L);
    }
    return -1;
  }
  
  private void a(IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    GuildHeaderData localGuildHeaderData = (GuildHeaderData)this.d.getValue();
    if (this.d.getValue() == null) {
      localGuildHeaderData = new GuildHeaderData();
    }
    localGuildHeaderData.b(QQGuildUtil.a(paramIGProUserProfileInfo));
    localGuildHeaderData.a(paramIGProUserProfileInfo.f());
    localGuildHeaderData.a(paramIGProUserProfileInfo.d());
    localGuildHeaderData.c(paramIGProUserProfileInfo.i());
    if (((QQGuildInfoRepository)this.z).a() != null)
    {
      Object localObject = (IGPSService)((QQGuildInfoRepository)this.z).a().getRuntimeService(IGPSService.class, "");
      localObject = ((IGPSService)localObject).getFullAvatarUrl(((IGPSService)localObject).getGuildUsersAvatarUrl(paramIGProUserProfileInfo.a()), 0);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localGuildHeaderData.a((String)localObject);
      }
    }
    if (paramIGProUserProfileInfo.k() > 0L) {
      localGuildHeaderData.a(a(paramIGProUserProfileInfo.k() * 1000L, NetConnInfoCenter.getServerTimeMillis()));
    } else if (paramIGProUserProfileInfo.k() == 0L) {
      localGuildHeaderData.a(-1L);
    }
    this.d.setValue(localGuildHeaderData);
  }
  
  private void b(IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    boolean bool3 = false;
    boolean bool2;
    if (paramIGProUserProfileInfo != null)
    {
      boolean bool1;
      if ((paramIGProUserProfileInfo.n() != null) && (paramIGProUserProfileInfo.n().a() > 0)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      bool2 = bool1;
      if (paramIGProUserProfileInfo.o() != null)
      {
        bool2 = bool1;
        if (!paramIGProUserProfileInfo.o().isEmpty())
        {
          j = paramIGProUserProfileInfo.o().size();
          i = 0;
          while (i < j)
          {
            localObject1 = (IGProClientArchiveInfo)paramIGProUserProfileInfo.o().get(i);
            bool2 = bool1;
            if (((IGProClientArchiveInfo)localObject1).a() == 1)
            {
              bool2 = bool1;
              if (((IGProClientArchiveInfo)localObject1).b() != null)
              {
                bool2 = bool1;
                if (((IGProClientArchiveInfo)localObject1).b().a() > 0) {
                  bool2 = false;
                }
              }
            }
            i += 1;
            bool1 = bool2;
          }
          bool2 = bool1;
        }
      }
      paramIGProUserProfileInfo = d();
      Object localObject2 = paramIGProUserProfileInfo.d();
      int i = paramIGProUserProfileInfo.g();
      Object localObject1 = paramIGProUserProfileInfo.c();
      int j = paramIGProUserProfileInfo.h();
      if (((String)localObject2).equals(localObject1)) {}
      do
      {
        do
        {
          bool1 = false;
          break;
        } while (((i == 1) || (i == 2)) && (j == 0));
        bool1 = bool2;
        if (i != 2) {
          break;
        }
        bool1 = bool2;
      } while (j == 1);
      i = paramIGProUserProfileInfo.e();
      if (i == 1)
      {
        bool2 = bool3;
      }
      else
      {
        if (i == 2)
        {
          localObject2 = QQGuildLiveRoomUiData.a().g().getValue();
          paramIGProUserProfileInfo = "";
          if (localObject2 != null)
          {
            paramIGProUserProfileInfo = new StringBuilder();
            paramIGProUserProfileInfo.append(((IGProChannelInfo)QQGuildLiveRoomUiData.a().g().getValue()).getLiveAnchorTinyId());
            paramIGProUserProfileInfo.append("");
            paramIGProUserProfileInfo = paramIGProUserProfileInfo.toString();
          }
          bool2 = bool3;
          if (!QQGuildLiveStartParamsCache.a().roomIdIsValid()) {
            break label366;
          }
          if (paramIGProUserProfileInfo == localObject1)
          {
            bool2 = bool3;
            break label366;
          }
        }
        bool2 = bool1;
      }
    }
    else
    {
      bool2 = true;
    }
    label366:
    this.f.setValue(Boolean.valueOf(bool2));
  }
  
  private void e()
  {
    ((IGPSService)((QQGuildInfoRepository)this.z).a().getRuntimeService(IGPSService.class, "")).loadGProUserProfileInfo(this.b.a(), this.b.c(), new -..Lambda.GuildProfileHeaderViewModel.DgKzK9rXyIA-9wJjeqGzVF68c90(this));
  }
  
  private void f()
  {
    AppInterface localAppInterface = ((QQGuildInfoRepository)this.z).a();
    if (localAppInterface == null)
    {
      QLog.w("GuildProfileHeaderViewModel", 2, "appInterface is null!");
      return;
    }
    this.c = new GuildProfileHeaderViewModel.2(this);
    ((QQGuildInfoRepository)this.z).a(this.c);
    ((IGPSService)localAppInterface.getRuntimeService(IGPSService.class, "")).refreshGuildUserProfileInfo(this.b.a(), this.b.c());
  }
  
  public void a()
  {
    if (this.c != null) {
      ((QQGuildInfoRepository)this.z).b(this.c);
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    ((QQGuildInfoRepository)this.z).a(paramAppInterface);
    e();
  }
  
  public void a(GuildBaseProfileData paramGuildBaseProfileData)
  {
    this.b = paramGuildBaseProfileData;
  }
  
  public MutableLiveData<GuildHeaderData> b()
  {
    return this.d;
  }
  
  public SingleLiveEvent<Boolean> c()
  {
    return this.f;
  }
  
  public GuildBaseProfileData d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.main.GuildProfileHeaderViewModel
 * JD-Core Version:    0.7.0.1
 */