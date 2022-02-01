package com.tencent.mobileqq.soload.util;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class LoadLibraryUtil$Api23
{
  private static void b(ClassLoader paramClassLoader, File paramFile)
  {
    Object localObject2 = ReflectUtil.a(paramClassLoader, "pathList").get(paramClassLoader);
    Object localObject1 = (List)ReflectUtil.a(localObject2, "nativeLibraryDirectories").get(localObject2);
    paramClassLoader = (ClassLoader)localObject1;
    if (localObject1 == null) {
      paramClassLoader = new ArrayList(2);
    }
    localObject1 = paramClassLoader.iterator();
    while (((Iterator)localObject1).hasNext()) {
      if ((paramFile.equals((File)((Iterator)localObject1).next())) || (paramFile.equals(LoadLibraryUtil.a())))
      {
        ((Iterator)localObject1).remove();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("dq libDirIt.remove() ");
        ((StringBuilder)localObject1).append(paramFile.getAbsolutePath());
        QLog.d("SoLoadWidget.LoadLibraryUtil", 2, ((StringBuilder)localObject1).toString());
      }
    }
    paramClassLoader.add(0, paramFile);
    localObject1 = (List)ReflectUtil.a(localObject2, "systemNativeLibraryDirectories").get(localObject2);
    paramFile = (File)localObject1;
    if (localObject1 == null) {
      paramFile = new ArrayList(2);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("systemLibDirs,size=");
      ((StringBuilder)localObject1).append(paramFile.size());
      QLog.d("SoLoadWidget.LoadLibraryUtil", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = ReflectUtil.a(localObject2, "makePathElements", new Class[] { List.class, File.class, List.class });
    ArrayList localArrayList = new ArrayList();
    paramClassLoader.addAll(paramFile);
    paramClassLoader = (Object[])((Method)localObject1).invoke(localObject2, new Object[] { paramClassLoader, null, localArrayList });
    paramFile = ReflectUtil.a(localObject2, "nativeLibraryPathElements");
    paramFile.setAccessible(true);
    paramFile.set(localObject2, paramClassLoader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.LoadLibraryUtil.Api23
 * JD-Core Version:    0.7.0.1
 */