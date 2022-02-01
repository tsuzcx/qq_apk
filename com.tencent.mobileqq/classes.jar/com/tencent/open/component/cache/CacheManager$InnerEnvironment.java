package com.tencent.open.component.cache;

import android.os.Environment;
import java.io.File;

class CacheManager$InnerEnvironment
{
  public static String a = Environment.getExternalStorageDirectory().getAbsolutePath();
  protected static final File b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Android");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("data");
    b = new File(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.component.cache.CacheManager.InnerEnvironment
 * JD-Core Version:    0.7.0.1
 */