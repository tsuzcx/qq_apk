package com.tencent.mobileqq.mini.audiorecorder;

public abstract interface LameMp3Recorder$AudioPlayerListener
{
  public abstract void onPlayFinish();
  
  public abstract void onPlayPause();
  
  public abstract void onPlayResume();
  
  public abstract void onPlayStart();
  
  public abstract void onPlayStop();
  
  public abstract void onPlayUpdate(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder.AudioPlayerListener
 * JD-Core Version:    0.7.0.1
 */