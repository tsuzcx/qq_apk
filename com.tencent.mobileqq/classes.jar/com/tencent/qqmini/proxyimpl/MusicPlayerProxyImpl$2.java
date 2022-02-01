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
    if ((MusicPlayerProxyImpl.a(this.a) == null) || ((MusicPlayerProxyImpl.a(this.a).a() != null) && (!MusicPlayerProxyImpl.a(this.a).a().equals(MusicPlayerProxyImpl.a(this.a))))) {}
    while (MusicPlayerProxyImpl.a(this.a) == null) {
      return;
    }
    MusicPlayerProxyImpl.a(this.a).onPlayStateChanged(paramInt);
  }
  
  public void a(com.tencent.mobileqq.music.SongInfo paramSongInfo)
  {
    if (MusicPlayerProxyImpl.a(this.a) != null)
    {
      com.tencent.qqmini.sdk.launcher.core.model.SongInfo localSongInfo = new com.tencent.qqmini.sdk.launcher.core.model.SongInfo();
      localSongInfo.album = paramSongInfo.g;
      localSongInfo.coverUrl = paramSongInfo.e;
      localSongInfo.detailUrl = paramSongInfo.f;
      localSongInfo.duration = paramSongInfo.jdField_d_of_type_Long;
      localSongInfo.fromMini = paramSongInfo.jdField_a_of_type_Boolean;
      localSongInfo.id = paramSongInfo.jdField_a_of_type_Long;
      localSongInfo.mid = paramSongInfo.jdField_a_of_type_JavaLangString;
      localSongInfo.singer = paramSongInfo.h;
      localSongInfo.singerId = paramSongInfo.jdField_c_of_type_Long;
      localSongInfo.startTime = paramSongInfo.jdField_a_of_type_Int;
      localSongInfo.summary = paramSongInfo.jdField_d_of_type_JavaLangString;
      localSongInfo.title = paramSongInfo.jdField_c_of_type_JavaLangString;
      localSongInfo.type = paramSongInfo.jdField_b_of_type_Int;
      localSongInfo.uin = paramSongInfo.jdField_b_of_type_Long;
      localSongInfo.url = paramSongInfo.jdField_b_of_type_JavaLangString;
      MusicPlayerProxyImpl.a(this.a).onPlaySongChanged(localSongInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MusicPlayerProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */