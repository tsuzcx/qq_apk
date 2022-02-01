package com.tencent.mobileqq.filebrowser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class FileViewMusicService$2
  extends BroadcastReceiver
{
  FileViewMusicService$2(FileViewMusicService paramFileViewMusicService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction())) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileViewMusicService.2
 * JD-Core Version:    0.7.0.1
 */