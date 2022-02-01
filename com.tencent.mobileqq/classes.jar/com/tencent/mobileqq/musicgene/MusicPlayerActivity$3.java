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
    Message.obtain(MusicPlayerActivity.a(this.a), 50, paramInt, 0).sendToTarget();
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (paramSongInfo != null)
    {
      localObject = MusicPlayerActivity.a(this.a, paramSongInfo);
      if (!MusicPlayerActivity.b().containsKey(localObject)) {
        break label64;
      }
      localObject = (MusicPlayerActivity.SimpleSongInfo)MusicPlayerActivity.b().get(localObject);
      paramSongInfo = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramSongInfo, ((MusicPlayerActivity.SimpleSongInfo)localObject).a);
      MusicPlayerActivity.a(this.a, (MusicPlayerActivity.SimpleSongInfo)localObject, paramSongInfo);
    }
    label64:
    while (MusicPlayerActivity.a().containsKey(localObject)) {
      return;
    }
    Object localObject = MusicPlayerActivity.a(this.a);
    if (localObject != null) {}
    for (int i = ((IQQPlayerService)localObject).c();; i = 0)
    {
      localObject = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramSongInfo, -1L);
      MusicPlayerActivity.a(this.a, paramSongInfo.c, paramSongInfo.h, paramSongInfo.e, (String)localObject, false, false);
      MusicPlayerActivity.a(this.a).a(this.a.app.getLongAccountUin(), paramSongInfo.c, paramSongInfo.h, paramSongInfo.g, String.valueOf(paramSongInfo.a), paramSongInfo.d, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.3
 * JD-Core Version:    0.7.0.1
 */