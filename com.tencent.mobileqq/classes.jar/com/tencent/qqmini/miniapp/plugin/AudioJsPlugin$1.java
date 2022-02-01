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
    Object localObject = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    if (localObject != null) {
      AudioJsPlugin.access$902(this.this$0, ((MusicPlayerProxy)localObject).getCurrentSong());
    }
    AudioJsPlugin.access$500(this.this$0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlaySongChanged title:");
    ((StringBuilder)localObject).append(paramSongInfo.title);
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(paramSongInfo.url);
    QMLog.i("AudioJsPlugin", ((StringBuilder)localObject).toString());
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    MusicPlayerProxy localMusicPlayerProxy = (MusicPlayerProxy)ProxyManager.get(MusicPlayerProxy.class);
    AudioJsPlugin.access$002(this.this$0, paramInt);
    switch (AudioJsPlugin.access$000(this.this$0))
    {
    default: 
      return;
    case 8: 
      AudioJsPlugin.access$800(this.this$0, "ended");
      return;
    case 5: 
    case 6: 
    case 7: 
      AudioJsPlugin.access$600(this.this$0);
      return;
    case 4: 
      AudioJsPlugin.access$500(this.this$0);
      return;
    case 3: 
      AudioJsPlugin.access$300(this.this$0);
      AudioJsPlugin.access$402(this.this$0, Math.max(localMusicPlayerProxy.getCurrentSongPosition(), 0));
      return;
    case 2: 
      AudioJsPlugin.access$100(this.this$0);
      AudioJsPlugin.access$200(this.this$0);
      return;
    }
    AudioJsPlugin.access$700(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */