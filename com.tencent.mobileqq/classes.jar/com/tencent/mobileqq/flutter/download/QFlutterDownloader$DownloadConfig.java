package com.tencent.mobileqq.flutter.download;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;

public class QFlutterDownloader$DownloadConfig<T extends XmlData>
{
  public final int a;
  public final Class<T> a;
  public final String a;
  public boolean a;
  public final int b;
  public final String b;
  
  public QFlutterDownloader$DownloadConfig(@NonNull Class<T> paramClass, @NonNull String paramString1, int paramInt1, @NonNull String paramString2, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.download.QFlutterDownloader.DownloadConfig
 * JD-Core Version:    0.7.0.1
 */