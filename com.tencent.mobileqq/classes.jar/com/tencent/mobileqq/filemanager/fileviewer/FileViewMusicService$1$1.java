package com.tencent.mobileqq.filemanager.fileviewer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class FileViewMusicService$1$1
  implements MediaPlayer.OnPreparedListener
{
  FileViewMusicService$1$1(FileViewMusicService.1 param1, MediaPlayer paramMediaPlayer) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService$1.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService.1.1
 * JD-Core Version:    0.7.0.1
 */