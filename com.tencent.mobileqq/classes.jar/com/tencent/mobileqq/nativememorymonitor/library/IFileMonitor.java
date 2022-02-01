package com.tencent.mobileqq.nativememorymonitor.library;

public abstract interface IFileMonitor
{
  public abstract void onFileRemove(String paramString);
  
  public abstract void onFileRename(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nativememorymonitor.library.IFileMonitor
 * JD-Core Version:    0.7.0.1
 */