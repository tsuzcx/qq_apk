package com.tencent.smtt.utils;

import java.io.InputStream;
import java.util.zip.ZipEntry;

public abstract interface FileUtil$IterateHandler
{
  public abstract boolean handleEntry(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.FileUtil.IterateHandler
 * JD-Core Version:    0.7.0.1
 */