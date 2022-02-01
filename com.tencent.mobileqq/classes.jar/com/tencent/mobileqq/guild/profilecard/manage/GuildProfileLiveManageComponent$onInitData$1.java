package com.tencent.mobileqq.guild.profilecard.manage;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.callback.ICheckUserBannedSpeakInChannelCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "bannedSpeak", "onCheckCallback"}, k=3, mv={1, 1, 16})
final class GuildProfileLiveManageComponent$onInitData$1
  implements ICheckUserBannedSpeakInChannelCallback
{
  GuildProfileLiveManageComponent$onInitData$1(GuildProfileLiveManageComponent paramGuildProfileLiveManageComponent) {}
  
  public final void a(int paramInt1, String paramString, int paramInt2)
  {
    String str = GuildProfileLiveManageComponent.access$getTAG$p(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkUserBannedSpeakInChannel:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" err:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ban:");
    localStringBuilder.append(paramInt2);
    QLog.d(str, 2, localStringBuilder.toString());
    if (paramInt1 == 0)
    {
      paramString = GuildProfileLiveManageComponent.access$isMute$p(this.a);
      boolean bool;
      if (paramInt2 == 2) {
        bool = true;
      } else {
        bool = false;
      }
      paramString.postValue(Boolean.valueOf(bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.manage.GuildProfileLiveManageComponent.onInitData.1
 * JD-Core Version:    0.7.0.1
 */