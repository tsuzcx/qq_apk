package com.tencent.open.component.cache;

import android.os.Environment;
import java.io.File;

class CacheManager$InnerEnvironment
{
  protected static final File a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Android");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("data");
    jdField_a_of_type_JavaIoFile = new File(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.component.cache.CacheManager.InnerEnvironment
 * JD-Core Version:    0.7.0.1
 */