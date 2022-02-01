package com.tencent.qqmini.sdk.launcher.shell;

public abstract interface IMiniAppFileManager
{
  public abstract String getAbsolutePath(String paramString);
  
  public abstract String getTmpPath(String paramString);
  
  public abstract String getWxFilePath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager
 * JD-Core Version:    0.7.0.1
 */