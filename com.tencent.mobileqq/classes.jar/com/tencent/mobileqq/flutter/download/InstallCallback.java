package com.tencent.mobileqq.flutter.download;

public abstract interface InstallCallback
{
  public abstract void onProgress(int paramInt);
  
  public abstract void onResult(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.download.InstallCallback
 * JD-Core Version:    0.7.0.1
 */