package com.tencent.mobileqq.tts.data;

public class TtsDataSource
{
  public static IFileCacheDataSource a()
  {
    return new TtsFileCache();
  }
  
  public static INetUrlDataSource b()
  {
    return new TtsNetDataSource();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tts.data.TtsDataSource
 * JD-Core Version:    0.7.0.1
 */