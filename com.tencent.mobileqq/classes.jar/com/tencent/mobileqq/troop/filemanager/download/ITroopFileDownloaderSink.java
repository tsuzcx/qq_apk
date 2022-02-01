package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;

public abstract interface ITroopFileDownloaderSink
{
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(String paramString);
  
  public abstract void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void b(String paramString);
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.ITroopFileDownloaderSink
 * JD-Core Version:    0.7.0.1
 */