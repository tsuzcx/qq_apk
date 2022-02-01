package com.tencent.mobileqq.musicgene;

import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.SongInfo;

class MusicGeneWebViewPlugin$2
  extends IQQPlayerCallback.Stub
{
  MusicGeneWebViewPlugin$2(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin) {}
  
  public void a(int paramInt)
  {
    MusicGeneWebViewPlugin.a(this.a, paramInt);
    if (paramInt == 2)
    {
      MusicGeneWebViewPlugin localMusicGeneWebViewPlugin = this.a;
      MusicGeneWebViewPlugin.a(localMusicGeneWebViewPlugin, MusicGeneWebViewPlugin.a(localMusicGeneWebViewPlugin).c());
    }
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (MusicGeneWebViewPlugin.a(this.a) != null)
    {
      paramSongInfo = this.a;
      MusicGeneWebViewPlugin.a(paramSongInfo, MusicGeneWebViewPlugin.a(paramSongInfo).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin.2
 * JD-Core Version:    0.7.0.1
 */