package com.tencent.qqinterface;

import android.os.Bundle;

public abstract interface DownloadCallback
{
  public abstract void onProgress(Bundle paramBundle);
  
  public abstract void onResult(Bundle paramBundle);
  
  public abstract void onStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qqinterface.DownloadCallback
 * JD-Core Version:    0.7.0.1
 */