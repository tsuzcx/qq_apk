package com.tencent.mobileqq.flutter.download;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;

public class QFlutterDownloader$DownloadConfig<T extends XmlData>
{
  public final Class<T> a;
  public final String b;
  public final int c;
  public final String d;
  public boolean e = true;
  public final int f;
  
  public QFlutterDownloader$DownloadConfig(@NonNull Class<T> paramClass, @NonNull String paramString1, int paramInt1, @NonNull String paramString2, int paramInt2)
  {
    this.a = paramClass;
    this.b = paramString1;
    this.c = paramInt1;
    this.d = paramString2;
    this.f = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.download.QFlutterDownloader.DownloadConfig
 * JD-Core Version:    0.7.0.1
 */