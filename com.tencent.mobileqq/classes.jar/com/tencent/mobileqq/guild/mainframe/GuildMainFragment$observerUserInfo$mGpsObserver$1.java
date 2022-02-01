package com.tencent.mobileqq.guild.mainframe;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/mainframe/GuildMainFragment$observerUserInfo$mGpsObserver$1", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "onUserNickUpdate", "", "id", "", "nickName", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildMainFragment$observerUserInfo$mGpsObserver$1
  extends GPServiceObserver
{
  GuildMainFragment$observerUserInfo$mGpsObserver$1(String paramString) {}
  
  protected void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if ((Intrinsics.areEqual(this.b, paramString1)) && (paramString2 != null))
    {
      paramString1 = ((IQQGuildAvatarApi)GuildMainFragment.a(this.a).getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable((AppRuntime)GuildMainFragment.a(this.a), this.b);
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setSelectMember(this.b, paramString2, paramString1);
      ((IGPSService)GuildMainFragment.a(this.a).getRuntimeService(IGPSService.class, "")).deleteObserver((GPServiceObserver)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.GuildMainFragment.observerUserInfo.mGpsObserver.1
 * JD-Core Version:    0.7.0.1
 */