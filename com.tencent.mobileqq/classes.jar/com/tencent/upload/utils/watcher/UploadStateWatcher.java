package com.tencent.upload.utils.watcher;

public class UploadStateWatcher
{
  private static volatile UploadStateWatcher sInstance;
  
  public UploadStateWatcher getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new UploadStateWatcher();
      }
      return sInstance;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.utils.watcher.UploadStateWatcher
 * JD-Core Version:    0.7.0.1
 */