package com.tencent.mobileqq.guild.profilecard.manage;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "onResult"}, k=3, mv={1, 1, 16})
final class GuildProfileLiveManageComponent$setMuteInLive$1
  implements IResultCallback
{
  GuildProfileLiveManageComponent$setMuteInLive$1(GuildProfileLiveManageComponent paramGuildProfileLiveManageComponent) {}
  
  public final void onResult(int paramInt, String paramString)
  {
    String str = GuildProfileLiveManageComponent.access$getTAG$p(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLiveChannelBannedUser: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" opreator: ");
    localStringBuilder.append(GuildProfileLiveManageComponent.access$getOperatorType$p(this.a));
    QLog.d(str, 4, localStringBuilder.toString());
    if (paramInt == 0)
    {
      paramString = GuildProfileLiveManageComponent.access$isMute$p(this.a);
      paramInt = GuildProfileLiveManageComponent.access$getOperatorType$p(this.a);
      boolean bool = true;
      if (paramInt != 1) {
        bool = false;
      }
      paramString.postValue(Boolean.valueOf(bool));
      return;
    }
    GuildLiveToast.a(2131890548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileLiveManageComponent.setMuteInLive.1
 * JD-Core Version:    0.7.0.1
 */