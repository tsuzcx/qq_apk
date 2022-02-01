package com.tencent.mobileqq.listentogether;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.player.Const;
import com.tencent.mobileqq.listentogether.player.IStateChangeCallback;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ListenTogetherManager$3
  implements IStateChangeCallback
{
  ListenTogetherManager$3(ListenTogetherManager paramListenTogetherManager) {}
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayStateChanged: ");
    ((StringBuilder)localObject).append(Const.a(paramInt));
    QLog.d("ListenTogether.Manager", 1, new Object[] { ((StringBuilder)localObject).toString(), " songId:", paramString, " curSongID:", QQMusicPlayService.f().a() });
    localObject = new HashMap();
    if (paramInt == 8) {
      ListenTogetherManager.c(this.a);
    } else if ((paramInt == 5) || (paramInt == 7)) {
      ((HashMap)localObject).put("status", String.valueOf(paramInt));
    }
    if (paramInt == 2)
    {
      if (ListenTogetherManager.d(this.a).r())
      {
        ListenTogetherManager.d(this.a).q();
        ListenTogetherManager.d(this.a).t();
      }
      ListenTogetherManager.f(this.a).removeCallbacks(ListenTogetherManager.e(this.a));
      ListenTogetherManager.h(this.a).a(ListenTogetherManager.g(this.a));
      ListenTogetherManager.f(this.a).postDelayed(ListenTogetherManager.h(this.a), ListenTogetherManager.i(this.a));
      ((HashMap)localObject).put("status", String.valueOf(paramInt));
    }
    else if ((paramInt == 4) || (paramInt == 5) || (paramInt == 7))
    {
      ListenTogetherManager.f(this.a).removeCallbacks(ListenTogetherManager.h(this.a));
      ListenTogetherManager.e(this.a).a(ListenTogetherManager.g(this.a));
      ListenTogetherManager.f(this.a).postDelayed(ListenTogetherManager.e(this.a), ListenTogetherManager.i(this.a));
    }
    if (paramInt == 2)
    {
      ListenTogetherManager.f(this.a).removeMessages(1001);
      ListenTogetherManager.f(this.a).sendEmptyMessageDelayed(1001, ListenTogetherDPC.a().d);
    }
    else
    {
      ListenTogetherManager.f(this.a).removeMessages(1001);
    }
    ListenTogetherManager.a(this.a, paramString, paramInt);
    if (!((HashMap)localObject).isEmpty()) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "listen_together_player_status", true, 0L, 0L, (HashMap)localObject, "");
    }
    if (QQMusicPlayService.f() != null)
    {
      paramString = (IOnlineMusicStatusManager)((IOnlineStatusManagerService)ListenTogetherManager.j(this.a).getRuntimeService(IOnlineStatusManagerService.class)).getManager(IOnlineMusicStatusManager.class);
      if (paramString != null) {
        paramString.b(paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetChanged: ");
    localStringBuilder.append(paramBoolean);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    if (paramBoolean) {
      ListenTogetherManager.k(this.a);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFocusChanged: ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" isTransient:");
    localStringBuilder.append(paramBoolean2);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    ListenTogetherManager.a(this.a, paramBoolean1);
    if (paramBoolean1)
    {
      ListenTogetherManager.f(this.a).removeCallbacks(ListenTogetherManager.e(this.a));
      ListenTogetherManager.f(this.a).postDelayed(ListenTogetherManager.l(this.a), ListenTogetherManager.i(this.a));
      ListenTogetherManager.h(this.a).a(ListenTogetherManager.g(this.a));
      ListenTogetherManager.f(this.a).postDelayed(ListenTogetherManager.h(this.a), ListenTogetherManager.i(this.a));
      ListenTogetherManager.a(this.a, 0L);
      return;
    }
    ListenTogetherManager.f(this.a).removeCallbacks(ListenTogetherManager.l(this.a));
    ListenTogetherManager.f(this.a).removeCallbacks(ListenTogetherManager.h(this.a));
    ListenTogetherManager.e(this.a).a(ListenTogetherManager.g(this.a));
    ListenTogetherManager.f(this.a).postDelayed(ListenTogetherManager.e(this.a), ListenTogetherManager.i(this.a));
    if (paramBoolean2)
    {
      ListenTogetherManager.a(this.a, 0L);
      return;
    }
    ListenTogetherManager.a(this.a, SystemClock.elapsedRealtime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.3
 * JD-Core Version:    0.7.0.1
 */