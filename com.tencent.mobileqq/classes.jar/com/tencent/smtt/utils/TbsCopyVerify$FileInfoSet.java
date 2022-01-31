package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class TbsCopyVerify$FileInfoSet
{
  private Map<String, TbsCopyVerify.FileInfo> mFileMap = new HashMap();
  
  TbsCopyVerify$FileInfoSet(TbsCopyVerify paramTbsCopyVerify, File paramFile)
  {
    this.mFileMap.clear();
    generateFileInfo(paramFile);
  }
  
  private void generateFileInfo(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if ((paramFile != null) || (Build.VERSION.SDK_INT < 26)) {}
    }
    while (!paramFile.isFile()) {
      for (;;)
      {
        return;
        int i = 0;
        while (i < paramFile.length)
        {
          generateFileInfo(paramFile[i]);
          i += 1;
        }
      }
    }
    generateFileInfo(paramFile.getName(), paramFile.length(), paramFile.lastModified());
  }
  
  private void generateFileInfo(String paramString, long paramLong1, long paramLong2)
  {
    if ((paramString != null) && (paramString.length() > 0) && (paramLong1 > 0L) && (paramLong2 > 0L))
    {
      TbsCopyVerify.FileInfo localFileInfo = new TbsCopyVerify.FileInfo(this.this$0, paramString, paramLong1, paramLong2);
      if (!this.mFileMap.containsKey(paramString)) {
        this.mFileMap.put(paramString, localFileInfo);
      }
    }
  }
  
  Map<String, TbsCopyVerify.FileInfo> get()
  {
    return this.mFileMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsCopyVerify.FileInfoSet
 * JD-Core Version:    0.7.0.1
 */