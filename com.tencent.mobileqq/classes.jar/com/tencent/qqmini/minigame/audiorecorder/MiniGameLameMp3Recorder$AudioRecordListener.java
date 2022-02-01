package com.tencent.qqmini.minigame.audiorecorder;

public abstract interface MiniGameLameMp3Recorder$AudioRecordListener
{
  public abstract void onRecordError(String paramString);
  
  public abstract void onRecordFrame(byte[] paramArrayOfByte, boolean paramBoolean);
  
  public abstract void onRecordPause();
  
  public abstract void onRecordResume();
  
  public abstract void onRecordStart();
  
  public abstract void onRecordStop(String paramString, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder.AudioRecordListener
 * JD-Core Version:    0.7.0.1
 */