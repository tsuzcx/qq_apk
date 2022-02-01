package com.tencent.mobileqq.filebrowser;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class FileViewMusicService$1$1
  implements MediaPlayer.OnPreparedListener
{
  FileViewMusicService$1$1(FileViewMusicService.1 param1, MediaPlayer paramMediaPlayer) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    int i = this.a.getDuration();
    this.a.stop();
    this.a.release();
    this.b.b.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileViewMusicService.1.1
 * JD-Core Version:    0.7.0.1
 */