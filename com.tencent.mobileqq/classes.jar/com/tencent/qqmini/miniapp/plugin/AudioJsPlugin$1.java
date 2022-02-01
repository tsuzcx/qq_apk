package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.SongInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AudioJsPlugin$1
  implements MusicPlayerProxy.MusicPlayerListener
{
  AudioJsPlugin$1(AudioJsPlugin paramAudioJsPlugin) {}
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    if (localMusicPlayerProxy != null) {
      AudioJsPlugin.access$902(this.this$0, localMusicPlayerProxy.getCurrentSong());
    }
    AudioJsPlugin.access$500(this.this$0);
    QMLog.i("AudioJsPlugin", "onPlaySongChanged title:" + paramSongInfo.title + " url:" + paramSongInfo.url);
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    AudioJsPlugin.access$002(this.this$0, paramInt);
    switch (AudioJsPlugin.access$000(this.this$0))
    {
    default: 
      return;
    case 2: 
      AudioJsPlugin.access$100(this.this$0);
      AudioJsPlugin.access$200(this.this$0);
      return;
    case 3: 
      AudioJsPlugin.access$300(this.this$0);
      AudioJsPlugin.access$402(this.this$0, Math.max(localMusicPlayerProxy.getCurrentSongPosition(), 0));
      return;
    case 4: 
      AudioJsPlugin.access$500(this.this$0);
      return;
    case 5: 
    case 6: 
    case 7: 
      AudioJsPlugin.access$600(this.this$0);
      return;
    case 1: 
      AudioJsPlugin.access$700(this.this$0);
      return;
    }
    AudioJsPlugin.access$800(this.this$0, "ended");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */