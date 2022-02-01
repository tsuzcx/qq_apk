package com.tencent.mobileqq.musicgene;

import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import java.util.HashMap;

class MusicPlayerActivity$3
  extends IQQPlayerCallback.Stub
{
  MusicPlayerActivity$3(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void a(int paramInt)
  {
    Message.obtain(MusicPlayerActivity.b(this.a), 50, paramInt, 0).sendToTarget();
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (paramSongInfo != null)
    {
      Object localObject = MusicPlayerActivity.a(this.a, paramSongInfo);
      if (MusicPlayerActivity.b().containsKey(localObject))
      {
        localObject = (MusicPlayerActivity.SimpleSongInfo)MusicPlayerActivity.b().get(localObject);
        MusicPlayerActivity localMusicPlayerActivity = this.a;
        paramSongInfo = MusicPlayerActivity.a(localMusicPlayerActivity, MusicPlayerActivity.a(localMusicPlayerActivity), paramSongInfo, ((MusicPlayerActivity.SimpleSongInfo)localObject).a);
        MusicPlayerActivity.a(this.a, (MusicPlayerActivity.SimpleSongInfo)localObject, paramSongInfo);
        return;
      }
      if (!MusicPlayerActivity.a().containsKey(localObject))
      {
        localObject = MusicPlayerActivity.a(this.a);
        int i;
        if (localObject != null) {
          i = ((IQQPlayerService)localObject).i();
        } else {
          i = 0;
        }
        localObject = this.a;
        localObject = MusicPlayerActivity.a((MusicPlayerActivity)localObject, MusicPlayerActivity.a((MusicPlayerActivity)localObject), paramSongInfo, -1L);
        MusicPlayerActivity.a(this.a, paramSongInfo.e, paramSongInfo.j, paramSongInfo.g, (String)localObject, false, false);
        MusicPlayerActivity.c(this.a).a(this.a.app.getLongAccountUin(), paramSongInfo.e, paramSongInfo.j, paramSongInfo.i, String.valueOf(paramSongInfo.a), paramSongInfo.f, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.3
 * JD-Core Version:    0.7.0.1
 */