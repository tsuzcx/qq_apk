package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class FileViewMusicService$2
  extends BroadcastReceiver
{
  FileViewMusicService$2(FileViewMusicService paramFileViewMusicService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.media.AUDIO_BECOMING_NOISY")) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService.2
 * JD-Core Version:    0.7.0.1
 */