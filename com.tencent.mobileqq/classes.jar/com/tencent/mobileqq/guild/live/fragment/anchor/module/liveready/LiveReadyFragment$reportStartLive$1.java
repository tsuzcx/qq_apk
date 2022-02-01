package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper;
import com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "errMsg", "", "onResult"}, k=3, mv={1, 1, 16})
final class LiveReadyFragment$reportStartLive$1
  implements IResultCallback
{
  LiveReadyFragment$reportStartLive$1(LiveReadyFragment paramLiveReadyFragment) {}
  
  public final void onResult(int paramInt, @Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportBeginBroadcast: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", errMsg");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    Boolean localBoolean = Boolean.valueOf(true);
    QLog.d("QGL.LiveReadyFragment", 1, (String)localObject);
    if (paramInt == 0)
    {
      QQGuildLiveRoomUiData.a().c(localBoolean);
      QQGuildLiveRoomUiData.a().b(localBoolean);
      QQGuildLiveRoomUiData.a().a(QQGuildLiveAnchorRoomMgr.a().d());
    }
    else
    {
      QQGuildLiveRoomUiData.a().c(Boolean.valueOf(false));
      LiveReadyFragment.d(this.a).a(false);
      if (paramInt == 22002)
      {
        if (paramString != null) {
          GuildLiveToast.a(2131890415);
        }
        QQGuildLiveEventHelper.a().e();
      }
    }
    paramString = this.a.getActivity();
    if (paramString != null) {
      paramString.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyFragment.reportStartLive.1
 * JD-Core Version:    0.7.0.1
 */