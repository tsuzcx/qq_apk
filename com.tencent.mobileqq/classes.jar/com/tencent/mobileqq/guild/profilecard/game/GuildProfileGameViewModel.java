package com.tencent.mobileqq.guild.profilecard.game;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.setting.QQGuildInfoRepository;
import com.tencent.mobileqq.guild.widget.GloryOfKingUtils;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientArchiveInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GuildProfileGameViewModel
  extends BaseViewModel<QQGuildInfoRepository>
{
  public static ViewModelProvider.Factory a = new GuildProfileGameViewModel.1();
  private GuildBaseProfileData b;
  private GPServiceObserver c;
  private MutableLiveData<GuildProfileGameingData> d = new MutableLiveData();
  private MutableLiveData<GuildProfileGameGloryKingData> e = new MutableLiveData();
  
  public GuildProfileGameViewModel(QQGuildInfoRepository paramQQGuildInfoRepository)
  {
    super(paramQQGuildInfoRepository);
  }
  
  private void a(IGProClientPresenceInfo paramIGProClientPresenceInfo)
  {
    if (paramIGProClientPresenceInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("GuildProfileGameViewModel", 1, "IGProClientPresenceInfo is null");
      }
      this.d.setValue(null);
      return;
    }
    int i = paramIGProClientPresenceInfo.a();
    if (i <= 0)
    {
      if (QLog.isColorLevel())
      {
        paramIGProClientPresenceInfo = new StringBuilder();
        paramIGProClientPresenceInfo.append("clientId invalid : ");
        paramIGProClientPresenceInfo.append(i);
        QLog.w("GuildProfileGameViewModel", 1, paramIGProClientPresenceInfo.toString());
      }
      this.d.setValue(null);
      return;
    }
    i = 0;
    GuildProfileGameingData localGuildProfileGameingData = new GuildProfileGameingData();
    Object localObject = paramIGProClientPresenceInfo.c();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localGuildProfileGameingData.a((String)localObject);
      i = 1;
    }
    localObject = paramIGProClientPresenceInfo.b();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localGuildProfileGameingData.b((String)localObject);
      i = 1;
    }
    localObject = new StringBuilder();
    c(paramIGProClientPresenceInfo, (StringBuilder)localObject);
    b(paramIGProClientPresenceInfo, (StringBuilder)localObject);
    a(paramIGProClientPresenceInfo, (StringBuilder)localObject);
    if (((StringBuilder)localObject).length() > 0)
    {
      localGuildProfileGameingData.c(((StringBuilder)localObject).toString());
      i = 1;
    }
    if (i != 0) {
      this.d.setValue(localGuildProfileGameingData);
    }
  }
  
  private void a(IGProClientPresenceInfo paramIGProClientPresenceInfo, StringBuilder paramStringBuilder)
  {
    paramIGProClientPresenceInfo = paramIGProClientPresenceInfo.h();
    if (TextUtils.isEmpty(paramIGProClientPresenceInfo)) {
      return;
    }
    if (paramStringBuilder.length() > 0) {
      paramStringBuilder.append(" | ");
    }
    paramStringBuilder.append(paramIGProClientPresenceInfo);
  }
  
  private void a(ArrayList<IGProClientArchiveInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Object localObject1 = ((QQGuildInfoRepository)this.z).a();
      if (localObject1 == null)
      {
        QLog.w("GuildProfileGameViewModel", 2, "appInterface is null");
        return;
      }
      int j = paramArrayList.size();
      localObject1 = ((AppInterface)localObject1).getApp().getResources();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = (IGProClientArchiveInfo)paramArrayList.get(i);
        if (((IGProClientArchiveInfo)localObject2).a() == 1)
        {
          localObject2 = GloryOfKingUtils.a(((IGProClientArchiveInfo)localObject2).b(), (Resources)localObject1);
          if (localObject2 != null) {
            this.e.setValue(localObject2);
          }
        }
        i += 1;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("GuildProfileGameViewModel", 1, "ArrayList<IGProClientArchiveInfo> is null");
    }
    this.e.setValue(null);
  }
  
  private void b(IGProClientPresenceInfo paramIGProClientPresenceInfo, StringBuilder paramStringBuilder)
  {
    String str = paramIGProClientPresenceInfo.e();
    if (!TextUtils.isEmpty(str))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.append(" | ");
      }
      paramStringBuilder.append(str);
    }
    long l1 = paramIGProClientPresenceInfo.f();
    long l2 = paramIGProClientPresenceInfo.g();
    if ((l1 > 0L) && (l2 > 0L) && (l1 <= l2))
    {
      paramStringBuilder.append("(");
      paramStringBuilder.append(l1);
      paramStringBuilder.append("/");
      paramStringBuilder.append(l2);
      paramStringBuilder.append(")");
    }
  }
  
  private void c(IGProClientPresenceInfo paramIGProClientPresenceInfo, StringBuilder paramStringBuilder)
  {
    String str = paramIGProClientPresenceInfo.d();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    paramStringBuilder.append(str);
    long l1 = paramIGProClientPresenceInfo.i() * 1000L;
    long l2 = System.currentTimeMillis();
    if (l1 > 0L)
    {
      if (l2 < l1) {
        return;
      }
      long l3 = (l2 - l1) / 1000L / 60L;
      if (QLog.isColorLevel()) {
        QLog.i("GuildProfileGameViewModel", 1, String.format("minutes is : %s, startTime: %s, curTime: %s", new Object[] { Long.valueOf(l3), TimeFormatterUtils.f(l1), TimeFormatterUtils.f(l2) }));
      }
      if (l3 >= 0L)
      {
        paramStringBuilder.append(l3);
        paramStringBuilder.append("分钟");
      }
    }
  }
  
  private void d()
  {
    AppInterface localAppInterface = ((QQGuildInfoRepository)this.z).a();
    if (localAppInterface == null)
    {
      QLog.w("GuildProfileGameViewModel", 2, "app in null!");
      return;
    }
    this.c = new GuildProfileGameViewModel.3(this);
    ((QQGuildInfoRepository)this.z).a(this.c);
    ((IGPSService)localAppInterface.getRuntimeService(IGPSService.class, "")).refreshGuildUserProfileInfo(this.b.a(), this.b.c());
  }
  
  public void a()
  {
    ((QQGuildInfoRepository)this.z).b(this.c);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    ((QQGuildInfoRepository)this.z).a(paramAppInterface);
    ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).loadGProUserProfileInfo(this.b.a(), this.b.c(), new GuildProfileGameViewModel.2(this));
  }
  
  public void a(GuildBaseProfileData paramGuildBaseProfileData)
  {
    this.b = paramGuildBaseProfileData;
  }
  
  public MutableLiveData<GuildProfileGameingData> b()
  {
    return this.d;
  }
  
  public MutableLiveData<GuildProfileGameGloryKingData> c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.game.GuildProfileGameViewModel
 * JD-Core Version:    0.7.0.1
 */