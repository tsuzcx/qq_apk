package com.tencent.qqmini.sdk.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class QzoneModuleInjector
{
  private static final String CLASS_LOADER_ALIYUN = "dalvik.system.LexClassLoader";
  private static final String CLASS_LOADER_BASE_DEX = "dalvik.system.BaseDexClassLoader";
  private static final String TAG = "QzoneModuleInjector";
  
  private static Object appendArray(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    int i = 0;
    Object localObject = paramObject1.getClass().getComponentType();
    int k = Array.getLength(paramObject1);
    int j = k + 1;
    localObject = Array.newInstance((Class)localObject, j);
    if (paramBoolean)
    {
      Array.set(localObject, 0, paramObject2);
      i = 1;
      while (i < j)
      {
        Array.set(localObject, i, Array.get(paramObject1, i - 1));
        i += 1;
      }
    }
    if (i < j)
    {
      if (i < k) {
        Array.set(localObject, i, Array.get(paramObject1, i));
      }
      for (;;)
      {
        i += 1;
        break;
        Array.set(localObject, i, paramObject2);
      }
    }
    return localObject;
  }
  
  private static Object combineArray(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject = paramObject2.getClass().getComponentType();
      int j = Array.getLength(paramObject2);
      int k = Array.getLength(paramObject1) + j;
      localObject = Array.newInstance((Class)localObject, k);
      int i = 0;
      if (i < k)
      {
        if (i < j) {
          Array.set(localObject, i, Array.get(paramObject2, i));
        }
        for (;;)
        {
          i += 1;
          break;
          Array.set(localObject, i, Array.get(paramObject1, i - j));
        }
      }
      return localObject;
      localObject = paramObject1;
      paramObject1 = paramObject2;
      paramObject2 = localObject;
    }
  }
  
  private static Object getDexElements(Object paramObject)
  {
    return getField(paramObject, paramObject.getClass(), "dexElements");
  }
  
  private static Object getField(Object paramObject, Class<?> paramClass, String paramString)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    return paramClass.get(paramObject);
  }
  
  private static Object getPathList(Object paramObject)
  {
    return getField(paramObject, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
  }
  
  private static boolean hasBaseDexClassLoader()
  {
    try
    {
      Class.forName("dalvik.system.BaseDexClassLoader");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  public static boolean inject(Context paramContext, ClassLoader paramClassLoader, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null) {}
    while (!new File(paramString1).exists()) {
      return false;
    }
    Object localObject;
    if (isAliyunOs())
    {
      if ((paramClassLoader instanceof PathClassLoader)) {}
      for (localObject = PathClassLoader.class;; localObject = DexClassLoader.class)
      {
        injectInAliyunOs(paramContext, paramClassLoader, (Class)localObject, paramString1, paramString2, paramBoolean);
        return true;
      }
    }
    if (!hasBaseDexClassLoader()) {
      if ((paramClassLoader instanceof PathClassLoader))
      {
        localObject = PathClassLoader.class;
        injectBelowApiLevel14(paramContext, paramClassLoader, (Class)localObject, paramString1, paramString2, paramBoolean);
      }
    }
    for (;;)
    {
      return true;
      localObject = DexClassLoader.class;
      break;
      injectAboveEqualApiLevel14(paramContext, paramClassLoader, paramString1, paramString2, paramBoolean);
    }
  }
  
  private static void injectAboveEqualApiLevel14(Context paramContext, ClassLoader paramClassLoader, String paramString1, String paramString2, boolean paramBoolean)
  {
    QMLog.d("QzoneModuleInjector", "injectAboveEqualApiLevel14, libPathL:" + paramString1);
    paramContext = new DexClassLoader(paramString1, paramContext.getDir("dex", 0).getAbsolutePath(), paramString1, paramContext.getClassLoader());
    paramContext = combineArray(getDexElements(getPathList(paramClassLoader)), getDexElements(getPathList(paramContext)), paramBoolean);
    paramString1 = getPathList(paramClassLoader);
    setField(paramString1, paramString1.getClass(), "dexElements", paramContext);
    if (!TextUtils.isEmpty(paramString2)) {
      paramClassLoader.loadClass(paramString2);
    }
  }
  
  private static void injectBelowApiLevel14(Context paramContext, ClassLoader paramClassLoader, Class paramClass, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = new DexClassLoader(paramString1, paramContext.getDir("dex", 0).getAbsolutePath(), paramString1, paramContext.getClassLoader());
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.loadClass(paramString2);
    }
    if ((paramClassLoader instanceof PathClassLoader)) {
      setField(paramClassLoader, paramClass, "mPaths", appendArray(getField(paramClassLoader, paramClass, "mPaths"), getField(paramContext, DexClassLoader.class, "mRawDexPath"), paramBoolean));
    }
    setField(paramClassLoader, paramClass, "mFiles", combineArray(getField(paramClassLoader, paramClass, "mFiles"), getField(paramContext, DexClassLoader.class, "mFiles"), paramBoolean));
    setField(paramClassLoader, paramClass, "mZips", combineArray(getField(paramClassLoader, paramClass, "mZips"), getField(paramContext, DexClassLoader.class, "mZips"), paramBoolean));
    setField(paramClassLoader, paramClass, "mDexs", combineArray(getField(paramClassLoader, paramClass, "mDexs"), getField(paramContext, DexClassLoader.class, "mDexs"), paramBoolean));
    if (!TextUtils.isEmpty(paramString2)) {
      paramClassLoader.loadClass(paramString2);
    }
  }
  
  private static void injectInAliyunOs(Context paramContext, ClassLoader paramClassLoader, Class paramClass, String paramString1, String paramString2, boolean paramBoolean)
  {
    new DexClassLoader(paramString1, paramContext.getDir("dex", 0).getAbsolutePath(), paramString1, paramClassLoader);
    String str = new File(paramString1).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
    Class localClass = Class.forName("dalvik.system.LexClassLoader");
    paramContext = localClass.getConstructor(new Class[] { String.class, String.class, String.class, ClassLoader.class }).newInstance(new Object[] { paramContext.getDir("dex", 0).getAbsolutePath() + File.separator + str, paramContext.getDir("dex", 0).getAbsolutePath(), paramString1, paramClassLoader });
    if (!TextUtils.isEmpty(paramString2)) {
      localClass.getMethod("loadClass", new Class[] { String.class }).invoke(paramContext, new Object[] { paramString2 });
    }
    if ((paramClassLoader instanceof PathClassLoader)) {
      setField(paramClassLoader, paramClass, "mPaths", appendArray(getField(paramClassLoader, paramClass, "mPaths"), getField(paramContext, localClass, "mRawDexPath"), paramBoolean));
    }
    setField(paramClassLoader, paramClass, "mFiles", combineArray(getField(paramClassLoader, paramClass, "mFiles"), getField(paramContext, localClass, "mFiles"), paramBoolean));
    setField(paramClassLoader, paramClass, "mZips", combineArray(getField(paramClassLoader, paramClass, "mZips"), getField(paramContext, localClass, "mZips"), paramBoolean));
    setField(paramClassLoader, paramClass, "mLexs", combineArray(getField(paramClassLoader, paramClass, "mLexs"), getField(paramContext, localClass, "mDexs"), paramBoolean));
  }
  
  private static boolean isAliyunOs()
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  private static Object removeElementFromArray(Object paramObject, int paramInt)
  {
    Object localObject = paramObject.getClass().getComponentType();
    int m = Array.getLength(paramObject);
    if ((paramInt < 0) || (paramInt >= m)) {
      return paramObject;
    }
    localObject = Array.newInstance((Class)localObject, m - 1);
    int j = 0;
    int i = 0;
    if (j < m)
    {
      if (j == paramInt) {
        break label82;
      }
      int k = i + 1;
      Array.set(localObject, i, Array.get(paramObject, j));
      i = k;
    }
    label82:
    for (;;)
    {
      j += 1;
      break;
      return localObject;
    }
  }
  
  private static void setField(Object paramObject1, Class<?> paramClass, String paramString, Object paramObject2)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
  
  @SuppressLint({"NewApi"})
  private static String unloadDexAboveEqualApiLevel14(ClassLoader paramClassLoader, int paramInt)
  {
    try
    {
      Object localObject = removeElementFromArray(getDexElements(getPathList(paramClassLoader)), paramInt);
      paramClassLoader = getPathList(paramClassLoader);
      setField(paramClassLoader, paramClassLoader.getClass(), "dexElements", localObject);
      return "Success";
    }
    catch (Throwable paramClassLoader) {}
    return "unloadDexAboveEqualApiLevel14 error: " + Log.getStackTraceString(null);
  }
  
  @TargetApi(14)
  private static String unloadDexBelowApiLevel14(ClassLoader paramClassLoader, Class paramClass, int paramInt)
  {
    try
    {
      if ((paramClassLoader instanceof PathClassLoader)) {
        setField(paramClassLoader, paramClass, "mPaths", removeElementFromArray(getField(paramClassLoader, paramClass, "mPaths"), paramInt));
      }
      setField(paramClassLoader, PathClassLoader.class, "mFiles", removeElementFromArray(getField(paramClassLoader, paramClass, "mFiles"), paramInt));
      setField(paramClassLoader, PathClassLoader.class, "mZips", removeElementFromArray(getField(paramClassLoader, paramClass, "mZips"), paramInt));
      setField(paramClassLoader, PathClassLoader.class, "mDexs", removeElementFromArray(getField(paramClassLoader, paramClass, "mDexs"), paramInt));
      return "Success";
    }
    catch (Throwable paramClassLoader)
    {
      paramClassLoader.printStackTrace();
    }
    return "unloadDexBelowApiLevel14 error: " + Log.getStackTraceString(paramClassLoader);
  }
  
  public static String unloadDexElement(ClassLoader paramClassLoader, int paramInt)
  {
    Object localObject;
    if (isAliyunOs())
    {
      if ((paramClassLoader instanceof PathClassLoader)) {}
      for (localObject = PathClassLoader.class;; localObject = DexClassLoader.class) {
        return unloadDexInAliyunOs(paramClassLoader, (Class)localObject, 0);
      }
    }
    if (!hasBaseDexClassLoader()) {
      try
      {
        if ((paramClassLoader instanceof PathClassLoader)) {}
        for (localObject = PathClassLoader.class;; localObject = DexClassLoader.class) {
          return unloadDexBelowApiLevel14(paramClassLoader, (Class)localObject, 0);
        }
        return unloadDexAboveEqualApiLevel14(paramClassLoader, 0);
      }
      catch (Throwable paramClassLoader)
      {
        Log.e("QzoneModuleInjector", "fail to inject", paramClassLoader);
        return "";
      }
    }
  }
  
  private static String unloadDexInAliyunOs(ClassLoader paramClassLoader, Class paramClass, int paramInt)
  {
    try
    {
      if ((paramClassLoader instanceof PathClassLoader)) {
        setField(paramClassLoader, paramClass, "mPaths", removeElementFromArray(getField(paramClassLoader, paramClass, "mPaths"), paramInt));
      }
      setField(paramClassLoader, PathClassLoader.class, "mFiles", removeElementFromArray(getField(paramClassLoader, paramClass, "mFiles"), paramInt));
      setField(paramClassLoader, PathClassLoader.class, "mZips", removeElementFromArray(getField(paramClassLoader, paramClass, "mZips"), paramInt));
      setField(paramClassLoader, PathClassLoader.class, "mLexs", removeElementFromArray(getField(paramClassLoader, paramClass, "mLexs"), paramInt));
      return "Success";
    }
    catch (Throwable paramClassLoader)
    {
      paramClassLoader.printStackTrace();
    }
    return "unloadDexInAliyunOs error: " + Log.getStackTraceString(paramClassLoader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.QzoneModuleInjector
 * JD-Core Version:    0.7.0.1
 */