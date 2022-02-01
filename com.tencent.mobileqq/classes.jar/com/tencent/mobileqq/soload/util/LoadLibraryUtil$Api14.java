package com.tencent.mobileqq.soload.util;

import java.io.File;
import java.lang.reflect.Field;

final class LoadLibraryUtil$Api14
{
  private static void b(ClassLoader paramClassLoader, File paramFile)
  {
    ReflectUtil.a(ReflectUtil.a(paramClassLoader, "pathList").get(paramClassLoader), "nativeLibraryDirectories", new File[] { paramFile });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.LoadLibraryUtil.Api14
 * JD-Core Version:    0.7.0.1
 */