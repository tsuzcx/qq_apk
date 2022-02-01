package com.tencent.mobileqq.listentogether;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.player.Const;
import com.tencent.mobileqq.listentogether.player.IStateChangeCallback;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.onlinestatus.music.OnlineMusicStatusManager;
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
    QLog.d("ListenTogether.Manager", 1, new Object[] { "onPlayStateChanged: " + Const.a(paramInt), " songId:", paramString, " curSongID:", QQMusicPlayService.a().a() });
    HashMap localHashMap = new HashMap();
    if (paramInt == 8)
    {
      ListenTogetherManager.a(this.a);
      if (paramInt != 2) {
        break label302;
      }
      if (ListenTogetherManager.a(this.a).c())
      {
        ListenTogetherManager.a(this.a).n();
        ListenTogetherManager.a(this.a).p();
      }
      ListenTogetherManager.a(this.a).removeCallbacks(ListenTogetherManager.a(this.a));
      ListenTogetherManager.b(this.a).a(ListenTogetherManager.b(this.a));
      ListenTogetherManager.a(this.a).postDelayed(ListenTogetherManager.b(this.a), ListenTogetherManager.a(this.a));
      localHashMap.put("status", String.valueOf(paramInt));
      label190:
      if (paramInt != 2) {
        break label381;
      }
      ListenTogetherManager.a(this.a).removeMessages(1001);
      ListenTogetherManager.a(this.a).sendEmptyMessageDelayed(1001, ListenTogetherDPC.a().a);
    }
    for (;;)
    {
      ListenTogetherManager.a(this.a, paramString, paramInt);
      if (!localHashMap.isEmpty()) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "listen_together_player_status", true, 0L, 0L, localHashMap, "");
      }
      if (QQMusicPlayService.a() != null) {
        OnlineMusicStatusManager.a().a(paramInt);
      }
      return;
      if ((paramInt != 5) && (paramInt != 7)) {
        break;
      }
      localHashMap.put("status", String.valueOf(paramInt));
      break;
      label302:
      if ((paramInt != 4) && (paramInt != 5) && (paramInt != 7)) {
        break label190;
      }
      ListenTogetherManager.a(this.a).removeCallbacks(ListenTogetherManager.b(this.a));
      ListenTogetherManager.a(this.a).a(ListenTogetherManager.b(this.a));
      ListenTogetherManager.a(this.a).postDelayed(ListenTogetherManager.a(this.a), ListenTogetherManager.a(this.a));
      break label190;
      label381:
      ListenTogetherManager.a(this.a).removeMessages(1001);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("ListenTogether.Manager", 1, "onNetChanged: " + paramBoolean);
    if (paramBoolean) {
      ListenTogetherManager.b(this.a);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ListenTogether.Manager", 1, "onFocusChanged: " + paramBoolean1 + " isTransient:" + paramBoolean2);
    ListenTogetherManager.a(this.a, paramBoolean1);
    if (paramBoolean1)
    {
      ListenTogetherManager.a(this.a).removeCallbacks(ListenTogetherManager.a(this.a));
      ListenTogetherManager.a(this.a).postDelayed(ListenTogetherManager.a(this.a), ListenTogetherManager.a(this.a));
      ListenTogetherManager.b(this.a).a(ListenTogetherManager.b(this.a));
      ListenTogetherManager.a(this.a).postDelayed(ListenTogetherManager.b(this.a), ListenTogetherManager.a(this.a));
      ListenTogetherManager.a(this.a, 0L);
      return;
    }
    ListenTogetherManager.a(this.a).removeCallbacks(ListenTogetherManager.a(this.a));
    ListenTogetherManager.a(this.a).removeCallbacks(ListenTogetherManager.b(this.a));
    ListenTogetherManager.a(this.a).a(ListenTogetherManager.b(this.a));
    ListenTogetherManager.a(this.a).postDelayed(ListenTogetherManager.a(this.a), ListenTogetherManager.a(this.a));
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