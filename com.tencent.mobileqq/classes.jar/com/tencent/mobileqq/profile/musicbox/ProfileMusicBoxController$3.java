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
      if ((!ProfileMusicBoxController.a(this.a)) && (paramObject.mMusicList.containsKey(ProfileMusicBoxController.a(this.a).g)))
      {
        ProfileMusicBoxController.a(this.a).b = ((MusicInfo)paramObject.mMusicList.get(ProfileMusicBoxController.a(this.a).g)).sSongUrl;
        this.a.a(BaseApplicationImpl.getContext(), ProfileMusicBoxController.a(this.a));
        return;
      }
      SongInfo[] arrayOfSongInfo = QQPlayerService.a();
      if (arrayOfSongInfo != null)
      {
        paramInt = 0;
        while (paramInt < arrayOfSongInfo.length)
        {
          if (paramObject.mMusicList.containsKey(arrayOfSongInfo[paramInt].g))
          {
            arrayOfSongInfo[paramInt].b = ((MusicInfo)paramObject.mMusicList.get(arrayOfSongInfo[paramInt].g)).sSongUrl;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("requestMusicSongUrl mid:");
              localStringBuilder.append(arrayOfSongInfo[paramInt].g);
              localStringBuilder.append(" url:");
              localStringBuilder.append(arrayOfSongInfo[paramInt].b);
              QLog.d("ProfileMusicBoxController", 2, localStringBuilder.toString());
            }
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController.3
 * JD-Core Version:    0.7.0.1
 */