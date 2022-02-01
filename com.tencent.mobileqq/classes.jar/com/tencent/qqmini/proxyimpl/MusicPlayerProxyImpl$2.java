package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;

class MusicPlayerProxyImpl$2
  extends IQQPlayerCallback.Stub
{
  MusicPlayerProxyImpl$2(MusicPlayerProxyImpl paramMusicPlayerProxyImpl) {}
  
  public void a(int paramInt)
  {
    if (MusicPlayerProxyImpl.a(this.a) != null)
    {
      if ((MusicPlayerProxyImpl.a(this.a).r() != null) && (!MusicPlayerProxyImpl.a(this.a).r().equals(MusicPlayerProxyImpl.c(this.a)))) {
        return;
      }
      if (MusicPlayerProxyImpl.d(this.a) != null) {
        MusicPlayerProxyImpl.d(this.a).onPlayStateChanged(paramInt);
      }
    }
  }
  
  public void a(com.tencent.mobileqq.music.SongInfo paramSongInfo)
  {
    if (MusicPlayerProxyImpl.d(this.a) != null)
    {
      com.tencent.qqmini.sdk.launcher.core.model.SongInfo localSongInfo = new com.tencent.qqmini.sdk.launcher.core.model.SongInfo();
      localSongInfo.album = paramSongInfo.i;
      localSongInfo.coverUrl = paramSongInfo.g;
      localSongInfo.detailUrl = paramSongInfo.h;
      localSongInfo.duration = paramSongInfo.p;
      localSongInfo.fromMini = paramSongInfo.n;
      localSongInfo.id = paramSongInfo.a;
      localSongInfo.mid = paramSongInfo.b;
      localSongInfo.singer = paramSongInfo.j;
      localSongInfo.singerId = paramSongInfo.k;
      localSongInfo.startTime = paramSongInfo.l;
      localSongInfo.summary = paramSongInfo.f;
      localSongInfo.title = paramSongInfo.e;
      localSongInfo.type = paramSongInfo.m;
      localSongInfo.uin = paramSongInfo.c;
      localSongInfo.url = paramSongInfo.d;
      MusicPlayerProxyImpl.d(this.a).onPlaySongChanged(localSongInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MusicPlayerProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */