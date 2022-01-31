package com.tencent.mobileqq.theme;

import android.os.Bundle;

public abstract interface ThemeDownloader$ThemeDownloadListener
{
  public abstract void onDownloadCallback(Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3, ThemeDownloader paramThemeDownloader);
  
  public abstract void onDownloadProgress(Bundle paramBundle, int paramInt, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeDownloader.ThemeDownloadListener
 * JD-Core Version:    0.7.0.1
 */