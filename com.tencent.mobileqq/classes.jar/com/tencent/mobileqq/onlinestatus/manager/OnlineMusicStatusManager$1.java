package com.tencent.mobileqq.onlinestatus.manager;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.music.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.together.api.IQQPlayerServiceApi;
import com.tencent.qphone.base.util.QLog;

class OnlineMusicStatusManager$1
  implements QQPlayerCallback
{
  OnlineMusicStatusManager$1(OnlineMusicStatusManager paramOnlineMusicStatusManager) {}
  
  public String getToken()
  {
    return OnlineMusicStatusManager.class.getName();
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    Object localObject = ((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).getQQPlayerServiceToken();
    QLog.d("OnlineMusicStatusManager", 1, new Object[] { "onPlayStateChanged, playState:", Integer.valueOf(paramInt), " token:", localObject });
    if ((localObject != null) && ((((String)localObject).startsWith("music_gene_")) || (((String)localObject).startsWith("aio_"))))
    {
      if (((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isPlayStatePlaying(paramInt))
      {
        OnlineMusicStatusManager.a(this.a).removeMessages(1);
        OnlineMusicStatusManager.a(this.a).sendEmptyMessageDelayed(3, 3000L);
        return;
      }
      if (((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isPlayStateCompletion(paramInt))
      {
        OnlineMusicStatusManager.a(this.a).sendEmptyMessageDelayed(1, 3000L);
        return;
      }
      if ((!((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isPlayStateStop(paramInt)) && (!((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isPlayStateError(paramInt)))
      {
        if (((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isPlayStatePause(paramInt))
        {
          OnlineMusicStatusManager.a(this.a).removeCallbacksAndMessages(null);
          localObject = OnlineMusicStatusManager.a(this.a).obtainMessage(3, 1, 0);
          OnlineMusicStatusManager.a(this.a).sendMessage((Message)localObject);
        }
      }
      else
      {
        OnlineMusicStatusManager.a(this.a).removeCallbacksAndMessages(null);
        OnlineMusicStatusManager.a(this.a).sendEmptyMessage(1);
        if (((IQQPlayerServiceApi)QRoute.api(IQQPlayerServiceApi.class)).isStateStop(paramInt)) {
          this.a.a = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager.1
 * JD-Core Version:    0.7.0.1
 */