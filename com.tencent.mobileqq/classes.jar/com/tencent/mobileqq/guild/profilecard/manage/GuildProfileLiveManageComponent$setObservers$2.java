package com.tencent.mobileqq.guild.profilecard.manage;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/profilecard/manage/GuildProfileLiveManageComponent$setObservers$2", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "onUserProfileInfoUpdate", "", "result", "", "errMsg", "", "guildId", "tinyId", "info", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserProfileInfo;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildProfileLiveManageComponent$setObservers$2
  extends GPServiceObserver
{
  protected void a(int paramInt, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "errMsg");
    Intrinsics.checkParameterIsNotNull(paramString2, "guildId");
    Intrinsics.checkParameterIsNotNull(paramString3, "tinyId");
    Intrinsics.checkParameterIsNotNull(paramIGProUserProfileInfo, "info");
    paramString1 = GuildProfileLiveManageComponent.access$getTAG$p(this.a);
    paramString2 = new StringBuilder();
    paramString2.append("onUserProfileInfoUpdate result: ");
    paramString2.append(paramInt);
    QLog.i(paramString1, 1, paramString2.toString());
    if ((paramInt == 0) && (Intrinsics.areEqual(paramString3, GuildProfileLiveManageComponent.access$getUserData$p(this.a).c()))) {
      GuildProfileLiveManageComponent.access$getUserDstType$p(this.a).postValue(Integer.valueOf(paramIGProUserProfileInfo.j()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileLiveManageComponent.setObservers.2
 * JD-Core Version:    0.7.0.1
 */