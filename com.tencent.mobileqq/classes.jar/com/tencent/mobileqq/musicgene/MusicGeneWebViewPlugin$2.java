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
      MusicGeneWebViewPlugin.b(localMusicGeneWebViewPlugin, MusicGeneWebViewPlugin.b(localMusicGeneWebViewPlugin).i());
    }
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (MusicGeneWebViewPlugin.b(this.a) != null)
    {
      paramSongInfo = this.a;
      MusicGeneWebViewPlugin.a(paramSongInfo, MusicGeneWebViewPlugin.b(paramSongInfo).k());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin.2
 * JD-Core Version:    0.7.0.1
 */