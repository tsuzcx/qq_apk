package com.tencent.mobileqq.mini.audiorecorder;

public abstract interface LameMp3Recorder$AudioRecordListener
{
  public abstract void onRecordFrame(byte[] paramArrayOfByte, boolean paramBoolean);
  
  public abstract void onRecordPause();
  
  public abstract void onRecordResume();
  
  public abstract void onRecordStart();
  
  public abstract void onRecordStop(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onRecordUpdate(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder.AudioRecordListener
 * JD-Core Version:    0.7.0.1
 */