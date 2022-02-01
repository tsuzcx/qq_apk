package de.robv.android.xposed;

import android.annotation.SuppressLint;
import android.util.Log;
import com.android.internal.os.RuntimeInit;
import com.android.internal.os.ZygoteInit;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class XposedBridge
{
  public static final ClassLoader BOOTCLASSLOADER = ;
  static long BOOT_START_TIME = 0L;
  private static final Object[] EMPTY_ARRAY;
  private static final int RUNTIME_ART = 2;
  private static final int RUNTIME_DALVIK = 1;
  public static final String TAG = "Xposed";
  @Deprecated
  public static int XPOSED_BRIDGE_VERSION;
  static boolean disableHooks;
  static boolean isZygote = true;
  private static int runtime = 0;
  private static final Map<Member, XposedBridge.CopyOnWriteSortedSet<XC_MethodHook>> sHookedMethodCallbacks;
  static final XposedBridge.CopyOnWriteSortedSet<XC_InitPackageResources> sInitPackageResourcesCallbacks = new XposedBridge.CopyOnWriteSortedSet();
  static final XposedBridge.CopyOnWriteSortedSet<XC_LoadPackage> sLoadedPackageCallbacks;
  
  static
  {
    disableHooks = false;
    EMPTY_ARRAY = new Object[0];
    sHookedMethodCallbacks = new HashMap();
    sLoadedPackageCallbacks = new XposedBridge.CopyOnWriteSortedSet();
  }
  
  static Object cloneToSubclass(Object paramObject, Class<?> paramClass)
  {
    if (paramObject == null) {
      return null;
    }
    if (!paramObject.getClass().isAssignableFrom(paramClass)) {
      throw new ClassCastException(paramClass + " doesn't extend " + paramObject.getClass());
    }
    return cloneToSubclassNative(paramObject, paramClass);
  }
  
  private static native Object cloneToSubclassNative(Object paramObject, Class<?> paramClass);
  
  static native void closeFilesBeforeForkNative();
  
  static native void dumpObjectNative(Object paramObject);
  
  @SuppressLint({"SetWorldReadable"})
  private static File ensureSuperDexFile(String paramString, Class<?> paramClass1, Class<?> paramClass2)
  {
    removeFinalFlagNative(paramClass1);
    paramString = DexCreator.ensure(paramString, paramClass1, paramClass2);
    paramString.setReadable(true, false);
    return paramString;
  }
  
  private static native int getRuntime();
  
  static native String getStartClassName();
  
  public static native int getXposedVersion();
  
  private static native boolean hadInitErrors();
  
  private static Object handleHookedMethod(Member paramMember, int paramInt, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    XposedBridge.AdditionalHookInfo localAdditionalHookInfo = (XposedBridge.AdditionalHookInfo)paramObject1;
    if (disableHooks) {
      try
      {
        paramMember = invokeOriginalMethodNative(paramMember, paramInt, localAdditionalHookInfo.parameterTypes, localAdditionalHookInfo.returnType, paramObject2, paramArrayOfObject);
        return paramMember;
      }
      catch (InvocationTargetException paramMember)
      {
        throw paramMember.getCause();
      }
    }
    paramObject1 = localAdditionalHookInfo.callbacks.getSnapshot();
    int j = paramObject1.length;
    if (j == 0) {
      try
      {
        paramMember = invokeOriginalMethodNative(paramMember, paramInt, localAdditionalHookInfo.parameterTypes, localAdditionalHookInfo.returnType, paramObject2, paramArrayOfObject);
        return paramMember;
      }
      catch (InvocationTargetException paramMember)
      {
        throw paramMember.getCause();
      }
    }
    XC_MethodHook.MethodHookParam localMethodHookParam = new XC_MethodHook.MethodHookParam();
    localMethodHookParam.method = paramMember;
    localMethodHookParam.thisObject = paramObject2;
    localMethodHookParam.args = paramArrayOfObject;
    int i = 0;
    label313:
    for (;;)
    {
      try
      {
        ((XC_MethodHook)paramObject1[i]).beforeHookedMethod(localMethodHookParam);
        if (!localMethodHookParam.returnEarly) {
          continue;
        }
        i += 1;
      }
      catch (Throwable paramMember)
      {
        try
        {
          localMethodHookParam.setResult(invokeOriginalMethodNative(paramMember, paramInt, localAdditionalHookInfo.parameterTypes, localAdditionalHookInfo.returnType, localMethodHookParam.thisObject, localMethodHookParam.args));
          paramInt = i - 1;
          paramMember = localMethodHookParam.getResult();
          paramObject2 = localMethodHookParam.getThrowable();
        }
        catch (InvocationTargetException paramMember)
        {
          try
          {
            ((XC_MethodHook)paramObject1[paramInt]).afterHookedMethod(localMethodHookParam);
            paramInt -= 1;
            if (paramInt >= 0) {
              continue;
            }
            if (localMethodHookParam.hasThrowable())
            {
              throw localMethodHookParam.getThrowable();
              paramObject2 = paramObject2;
              log(paramObject2);
              localMethodHookParam.setResult(null);
              localMethodHookParam.returnEarly = false;
              i += 1;
              if (i < j) {
                break label313;
              }
              continue;
              paramMember = paramMember;
              localMethodHookParam.setThrowable(paramMember.getCause());
            }
          }
          catch (Throwable paramArrayOfObject)
          {
            log(paramArrayOfObject);
            if (paramObject2 == null)
            {
              localMethodHookParam.setResult(paramMember);
              continue;
            }
            localMethodHookParam.setThrowable(paramObject2);
            continue;
          }
        }
        return localMethodHookParam.getResult();
        continue;
      }
      if (localMethodHookParam.returnEarly) {}
    }
  }
  
  public static Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> paramClass, XC_MethodHook paramXC_MethodHook)
  {
    HashSet localHashSet = new HashSet();
    paramClass = paramClass.getDeclaredConstructors();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(hookMethod(paramClass[i], paramXC_MethodHook));
      i += 1;
    }
    return localHashSet;
  }
  
  public static Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> paramClass, String paramString, XC_MethodHook paramXC_MethodHook)
  {
    HashSet localHashSet = new HashSet();
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Member localMember = paramClass[i];
      if (localMember.getName().equals(paramString)) {
        localHashSet.add(hookMethod(localMember, paramXC_MethodHook));
      }
      i += 1;
    }
    return localHashSet;
  }
  
  public static void hookInitPackageResources(XC_InitPackageResources paramXC_InitPackageResources)
  {
    synchronized (sInitPackageResourcesCallbacks)
    {
      sInitPackageResourcesCallbacks.add(paramXC_InitPackageResources);
      return;
    }
  }
  
  public static void hookLoadPackage(XC_LoadPackage paramXC_LoadPackage)
  {
    synchronized (sLoadedPackageCallbacks)
    {
      sLoadedPackageCallbacks.add(paramXC_LoadPackage);
      return;
    }
  }
  
  public static XC_MethodHook.Unhook hookMethod(Member paramMember, XC_MethodHook paramXC_MethodHook)
  {
    return (XC_MethodHook.Unhook)XposedHelpers.callStaticMethod(XposedHelpers.findClass("me.weishu.exposed.ExposedBridge", XposedBridge.class.getClassLoader()), "hookMethod", new Object[] { paramMember, paramXC_MethodHook });
  }
  
  private static synchronized native void hookMethodNative(Member paramMember, Class<?> paramClass, int paramInt, Object paramObject);
  
  /* Error */
  private static void initXResources()
  {
    // Byte code:
    //   0: invokestatic 287	android/content/res/Resources:getSystem	()Landroid/content/res/Resources;
    //   3: astore_0
    //   4: ldc_w 289
    //   7: aload_0
    //   8: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   11: ldc_w 283
    //   14: invokestatic 291	de/robv/android/xposed/XposedBridge:ensureSuperDexFile	(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;)Ljava/io/File;
    //   17: astore_2
    //   18: aload_0
    //   19: aload_0
    //   20: ldc_w 293
    //   23: ldc_w 295
    //   26: ldc_w 297
    //   29: invokevirtual 301	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   32: invokevirtual 305	android/content/res/Resources:obtainTypedArray	(I)Landroid/content/res/TypedArray;
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 310	android/content/res/TypedArray:recycle	()V
    //   45: invokestatic 315	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   48: invokevirtual 318	java/lang/Runtime:gc	()V
    //   51: ldc_w 320
    //   54: aload_0
    //   55: ldc_w 307
    //   58: invokestatic 291	de/robv/android/xposed/XposedBridge:ensureSuperDexFile	(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;)Ljava/io/File;
    //   61: astore_0
    //   62: ldc 2
    //   64: invokevirtual 263	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   67: astore_1
    //   68: aload_1
    //   69: ldc_w 322
    //   72: new 324	dalvik/system/PathClassLoader
    //   75: dup
    //   76: new 87	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   83: aload_2
    //   84: invokevirtual 327	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   87: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: getstatic 330	java/io/File:pathSeparator	Ljava/lang/String;
    //   93: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: invokevirtual 327	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   100: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload_1
    //   107: invokevirtual 333	java/lang/ClassLoader:getParent	()Ljava/lang/ClassLoader;
    //   110: invokespecial 336	dalvik/system/PathClassLoader:<init>	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   113: invokestatic 340	de/robv/android/xposed/XposedHelpers:setObjectField	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    //   116: return
    //   117: astore_1
    //   118: ldc_w 307
    //   121: astore_0
    //   122: aload_1
    //   123: invokestatic 213	de/robv/android/xposed/XposedBridge:log	(Ljava/lang/Throwable;)V
    //   126: goto -81 -> 45
    //   129: astore_1
    //   130: goto -8 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	119	0	localObject1	Object
    //   35	72	1	localObject2	Object
    //   117	6	1	localNotFoundException1	android.content.res.Resources.NotFoundException
    //   129	1	1	localNotFoundException2	android.content.res.Resources.NotFoundException
    //   17	67	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   18	41	117	android/content/res/Resources$NotFoundException
    //   41	45	129	android/content/res/Resources$NotFoundException
  }
  
  static native boolean initXResourcesNative();
  
  static native void invalidateCallersNative(Member[] paramArrayOfMember);
  
  public static Object invokeOriginalMethod(Member paramMember, Object paramObject, Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = EMPTY_ARRAY;
    }
    return XposedHelpers.callStaticMethod(XposedHelpers.findClass("me.weishu.exposed.ExposedBridge", XposedBridge.class.getClassLoader()), "invokeOriginalMethod", new Object[] { paramMember, paramObject, arrayOfObject });
  }
  
  private static native Object invokeOriginalMethodNative(Member paramMember, int paramInt, Class<?>[] paramArrayOfClass, Class<?> paramClass, Object paramObject, Object[] paramArrayOfObject);
  
  /* Error */
  public static void log(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 352	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: ldc 21
    //   18: aload_0
    //   19: invokestatic 358	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   22: pop
    //   23: goto -11 -> 12
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	paramString	String
    //   7	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	26	finally
    //   16	23	26	finally
  }
  
  public static void log(Throwable paramThrowable)
  {
    try
    {
      Log.e("Xposed", Log.getStackTraceString(paramThrowable));
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  protected static void main(String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        if (hadInitErrors()) {
          continue;
        }
        initXResources();
        SELinuxHelper.initOnce();
        SELinuxHelper.initForProcess(null);
        runtime = getRuntime();
        XPOSED_BRIDGE_VERSION = getXposedVersion();
        if (isZygote)
        {
          XposedInit.hookResources();
          XposedInit.initForZygote();
        }
        XposedInit.loadModules();
      }
      catch (Throwable localThrowable)
      {
        Log.e("Xposed", "Errors during Xposed initialization", localThrowable);
        disableHooks = true;
        continue;
        RuntimeInit.main(paramArrayOfString);
      }
      if (!isZygote) {
        continue;
      }
      ZygoteInit.main(paramArrayOfString);
      return;
      Log.e("Xposed", "Not initializing Xposed because of previous errors");
    }
  }
  
  private static native void removeFinalFlagNative(Class<?> paramClass);
  
  static native void reopenFilesAfterForkNative();
  
  static void setObjectClass(Object paramObject, Class<?> paramClass)
  {
    if (paramClass.isAssignableFrom(paramObject.getClass())) {
      throw new IllegalArgumentException("Cannot transfer object from " + paramObject.getClass() + " to " + paramClass);
    }
    setObjectClassNative(paramObject, paramClass);
  }
  
  private static native void setObjectClassNative(Object paramObject, Class<?> paramClass);
  
  static native boolean startsSystemServer();
  
  @Deprecated
  public static void unhookMethod(Member paramMember, XC_MethodHook paramXC_MethodHook)
  {
    synchronized (sHookedMethodCallbacks)
    {
      paramMember = (XposedBridge.CopyOnWriteSortedSet)sHookedMethodCallbacks.get(paramMember);
      if (paramMember == null) {
        return;
      }
      paramMember.remove(paramXC_MethodHook);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedBridge
 * JD-Core Version:    0.7.0.1
 */