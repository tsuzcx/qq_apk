package com.tencent.mobileqq.profile.musicbox;

import VIP.GetQzoneMusicInfoRsp;
import VIP.MusicInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ProfileMusicBoxController$3
  implements BusinessObserver
{
  ProfileMusicBoxController$3(ProfileMusicBoxController paramProfileMusicBoxController) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetQzoneMusicInfoRsp)))
    {
      paramObject = (GetQzoneMusicInfoRsp)paramObject;
      if ((!ProfileMusicBoxController.d(this.a)) && (paramObject.mMusicList.containsKey(ProfileMusicBoxController.e(this.a).i)))
      {
        ProfileMusicBoxController.e(this.a).d = ((MusicInfo)paramObject.mMusicList.get(ProfileMusicBoxController.e(this.a).i)).sSongUrl;
        this.a.a(BaseApplicationImpl.getContext(), ProfileMusicBoxController.e(this.a));
        return;
      }
      SongInfo[] arrayOfSongInfo = QQPlayerService.e();
      if (arrayOfSongInfo != null)
      {
        paramInt = 0;
        while (paramInt < arrayOfSongInfo.length)
        {
          if (paramObject.mMusicList.containsKey(arrayOfSongInfo[paramInt].i))
          {
            arrayOfSongInfo[paramInt].d = ((MusicInfo)paramObject.mMusicList.get(arrayOfSongInfo[paramInt].i)).sSongUrl;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("requestMusicSongUrl mid:");
              localStringBuilder.append(arrayOfSongInfo[paramInt].i);
              localStringBuilder.append(" url:");
              localStringBuilder.append(arrayOfSongInfo[paramInt].d);
              QLog.d("ProfileMusicBoxController", 2, localStringBuilder.toString());
            }
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController.3
 * JD-Core Version:    0.7.0.1
 */