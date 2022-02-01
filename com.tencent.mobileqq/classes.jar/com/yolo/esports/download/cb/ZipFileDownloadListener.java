package com.yolo.esports.download.cb;

import com.yolo.esports.download.zip.ZipFileDownInfo;

public abstract interface ZipFileDownloadListener
  extends DownloadTaskListener
{
  public abstract void a(ZipFileDownInfo paramZipFileDownInfo, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.cb.ZipFileDownloadListener
 * JD-Core Version:    0.7.0.1
 */