package com.tencent.mobileqq.qfix;

import android.app.Application;
import android.content.Context;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AndroidNClassLoader
  extends PathClassLoader
{
  static ArrayList oldDexFiles = new ArrayList();
  PathClassLoader originClassLoader;
  
  private AndroidNClassLoader(String paramString, PathClassLoader paramPathClassLoader)
  {
    super(paramString, paramPathClassLoader.getParent());
    this.originClassLoader = paramPathClassLoader;
  }
  
  private static AndroidNClassLoader createAndroidNClassLoader(PathClassLoader paramPathClassLoader)
  {
    AndroidNClassLoader localAndroidNClassLoader = new AndroidNClassLoader("", paramPathClassLoader);
    paramPathClassLoader = ShareReflectUtil.findField(paramPathClassLoader, "pathList").get(paramPathClassLoader);
    ShareReflectUtil.findField(paramPathClassLoader, "definingContext").set(paramPathClassLoader, localAndroidNClassLoader);
    ShareReflectUtil.findField(localAndroidNClassLoader, "pathList").set(localAndroidNClassLoader, paramPathClassLoader);
    ArrayList localArrayList = new ArrayList();
    Field localField = ShareReflectUtil.findField(paramPathClassLoader, "dexElements");
    Object[] arrayOfObject = (Object[])localField.get(paramPathClassLoader);
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      localObject = (DexFile)ShareReflectUtil.findField(localObject, "dexFile").get(localObject);
      localArrayList.add(new File(((DexFile)localObject).getName()));
      oldDexFiles.add(localObject);
      i += 1;
    }
    localField.set(paramPathClassLoader, (Object[])ShareReflectUtil.findMethod(paramPathClassLoader, "makePathElements", new Class[] { List.class, File.class, List.class }).invoke(paramPathClassLoader, new Object[] { localArrayList, null, new ArrayList() }));
    return localAndroidNClassLoader;
  }
  
  public static AndroidNClassLoader inject(PathClassLoader paramPathClassLoader, Application paramApplication)
  {
    paramPathClassLoader = createAndroidNClassLoader(paramPathClassLoader);
    reflectPackageInfoClassloader(paramApplication, paramPathClassLoader);
    return paramPathClassLoader;
  }
  
  private static void reflectPackageInfoClassloader(Application paramApplication, ClassLoader paramClassLoader)
  {
    paramApplication = (Context)ShareReflectUtil.findField(paramApplication, "mBase").get(paramApplication);
    paramApplication = ShareReflectUtil.findField(paramApplication, "mPackageInfo").get(paramApplication);
    Field localField = ShareReflectUtil.findField(paramApplication, "mClassLoader");
    Thread.currentThread().setContextClassLoader(paramClassLoader);
    localField.set(paramApplication, paramClassLoader);
  }
  
  public Class findClass(String paramString)
  {
    Class localClass1;
    if ((paramString != null) && ((paramString.startsWith("com.tencent.mobileqq.qfix.")) || (paramString.startsWith("com.tencent.common.app.QFixApplicationImpl")))) {
      localClass1 = this.originClassLoader.loadClass(paramString);
    } else {
      localClass1 = null;
    }
    Class localClass2 = localClass1;
    if (localClass1 == null) {
      localClass2 = super.findClass(paramString);
    }
    return localClass2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.AndroidNClassLoader
 * JD-Core Version:    0.7.0.1
 */