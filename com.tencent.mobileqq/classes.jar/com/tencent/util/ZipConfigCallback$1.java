package com.tencent.util;

import com.tencent.biz.common.util.ZipUtils.UnzipCallback;
import java.io.File;

class ZipConfigCallback$1
  implements ZipUtils.UnzipCallback
{
  ZipConfigCallback$1(ZipConfigCallback paramZipConfigCallback) {}
  
  public void onFileUnzip(File paramFile, String paramString)
  {
    ZipReporter.a(paramFile, ZipReporter.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.ZipConfigCallback.1
 * JD-Core Version:    0.7.0.1
 */