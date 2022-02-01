package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class TPLoadLibFromApk
{
  private static Context mContext = null;
  private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap();
  
  private static void extractAllLibraries(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    List localList1 = generateAbiList();
    File localFile = paramContext.getDir("recover_lib", 0);
    paramContext = new ZipFile(paramContext.getApplicationInfo().sourceDir);
    for (;;)
    {
      HashSet localHashSet;
      Pattern localPattern;
      try
      {
        localHashSet = new HashSet();
        localPattern = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
        Enumeration localEnumeration = paramContext.entries();
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        localObject = (ZipEntry)localEnumeration.nextElement();
        String str = ((ZipEntry)localObject).getName();
        if ((!TextUtils.isEmpty(str)) && (str.contains("../"))) {
          throw new Exception("contain ../, throw err");
        }
      }
      finally
      {
        paramContext.close();
      }
      Object localObject = localPattern.matcher(((ZipEntry)localObject).getName());
      if (((Matcher)localObject).matches())
      {
        localObject = ((Matcher)localObject).group(1);
        if (!localHashSet.contains(localObject))
        {
          extractLibrary(paramContext, (String)localObject, localList2, new File(localFile, "lib" + (String)localObject + ".so"));
          localHashSet.add(localObject);
        }
      }
    }
    paramContext.close();
  }
  
  private static boolean extractLibrary(ZipFile paramZipFile, String paramString, List<String> paramList, File paramFile)
  {
    if (paramFile.isFile()) {
      return true;
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      paramList = (String)paramList.next();
      paramString = paramZipFile.getEntry("lib/" + paramList + "/lib" + paramString + ".so");
      if (paramString == null) {
        return false;
      }
      paramList = paramString.getName();
      if ((!TextUtils.isEmpty(paramList)) && (paramList.contains("../"))) {
        return false;
      }
      paramZipFile = paramZipFile.getInputStream(paramString);
      paramString = new FileOutputStream(paramFile);
      paramList = new byte[2048];
      try
      {
        for (;;)
        {
          int i = paramZipFile.read(paramList, 0, paramList.length);
          if (i == -1) {
            break;
          }
          paramString.write(paramList, 0, i);
        }
        paramZipFile.close();
      }
      finally
      {
        paramZipFile.close();
        paramString.close();
      }
      paramString.close();
      try
      {
        paramFile.setReadOnly();
        return true;
      }
      catch (Throwable paramZipFile)
      {
        return false;
      }
    }
    return false;
  }
  
  public static String find(String paramString, Context paramContext)
  {
    Object localObject3;
    if (paramContext == null) {
      localObject3 = null;
    }
    for (;;)
    {
      return localObject3;
      try
      {
        Object localObject1 = TPLoadLibFromApk.class.getClassLoader();
        localObject3 = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class });
        ((Method)localObject3).setAccessible(true);
        localObject1 = (String)((Method)localObject3).invoke(localObject1, new Object[] { paramString });
        localObject3 = localObject1;
        if (localObject1 != null) {
          continue;
        }
        paramString = new File(paramContext.getDir("recover_lib", 0), "lib" + paramString + ".so");
        localObject3 = localObject1;
        if (!paramString.canRead()) {
          continue;
        }
        return paramString.getAbsolutePath();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
  
  private static List<String> generateAbiList()
  {
    ArrayList localArrayList = new ArrayList(3);
    Object localObject = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
    String str = (String)((Method)localObject).invoke(null, new Object[] { "ro.product.cpu.abi" });
    if ((str != null) && (str.length() > 0)) {
      localArrayList.add(str);
    }
    localObject = (String)((Method)localObject).invoke(null, new Object[] { "ro.product.cpu.abi2" });
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localArrayList.add(localObject);
    }
    localArrayList.add("armeabi");
    return localArrayList;
  }
  
  public static boolean load(String paramString, ClassLoader paramClassLoader, Context arg2)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramClassLoader == null)) {
      return false;
    }
    mContext = ???;
    for (;;)
    {
      synchronized (mLoadedLibs)
      {
        localObject1 = (WeakReference)mLoadedLibs.get(paramString);
        if (localObject1 == null) {
          break label354;
        }
        localObject1 = (ClassLoader)((WeakReference)localObject1).get();
        if (localObject1 != null)
        {
          if (localObject1 == paramClassLoader)
          {
            TPNativeLog.printLog(2, "callerClassLoader has already load ! name=" + paramString);
            return true;
          }
          throw new UnsatisfiedLinkError("Library '" + paramString + "' was loaded by a different ClassLoader.");
        }
      }
      if (??? == null) {
        try
        {
          TPNativeLog.printLog(2, "context is null,load by System.loadLibrary,name= " + paramString);
          reflectSystemLoadLibrary(paramString, paramClassLoader);
          synchronized (mLoadedLibs)
          {
            mLoadedLibs.put(paramString, new WeakReference(paramClassLoader));
            return true;
          }
          localObject1 = new File(???.getDir("recover_lib", 0), "lib" + paramString + ".so");
        }
        catch (InvocationTargetException paramClassLoader)
        {
          throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError("Failed loading library: " + paramString).initCause(paramClassLoader.getCause()));
        }
        catch (Exception paramClassLoader)
        {
          throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError("Failed loading library: " + paramString).initCause(paramClassLoader));
        }
      }
      try
      {
        ??? = loadFromRecovery(paramString, paramClassLoader, ???, (File)localObject1);
        if (??? == null) {
          return true;
        }
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      try
      {
        boolean bool = loadFromApk(paramString, paramClassLoader, ???, (File)localObject1, (UnsatisfiedLinkError)???);
        return bool;
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      label354:
      Object localObject1 = null;
    }
  }
  
  /* Error */
  private static boolean loadFromApk(String paramString, ClassLoader paramClassLoader, Context arg2, File paramFile, UnsatisfiedLinkError paramUnsatisfiedLinkError)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 47	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   4: getfield 53	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   7: astore 6
    //   9: new 43	java/util/zip/ZipFile
    //   12: dup
    //   13: aload 6
    //   15: invokespecial 56	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   18: astore 5
    //   20: aload 5
    //   22: astore_2
    //   23: iconst_2
    //   24: new 128	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 324
    //   34: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 326
    //   44: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload 6
    //   49: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 282	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   58: aload 5
    //   60: astore_2
    //   61: aload 5
    //   63: aload_0
    //   64: invokestatic 33	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:generateAbiList	()Ljava/util/List;
    //   67: aload_3
    //   68: invokestatic 147	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:extractLibrary	(Ljava/util/zip/ZipFile;Ljava/lang/String;Ljava/util/List;Ljava/io/File;)Z
    //   71: ifne +67 -> 138
    //   74: aload 5
    //   76: astore_2
    //   77: new 328	java/lang/RuntimeException
    //   80: dup
    //   81: new 128	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 330
    //   91: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 331	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   104: athrow
    //   105: astore_0
    //   106: aload 5
    //   108: astore_2
    //   109: new 284	java/lang/UnsatisfiedLinkError
    //   112: dup
    //   113: ldc_w 333
    //   116: invokespecial 289	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   119: aload_0
    //   120: invokevirtual 312	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   123: checkcast 284	java/lang/UnsatisfiedLinkError
    //   126: athrow
    //   127: astore_0
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 108	java/util/zip/ZipFile:close	()V
    //   136: aload_0
    //   137: athrow
    //   138: aload 5
    //   140: ifnull +8 -> 148
    //   143: aload 5
    //   145: invokevirtual 108	java/util/zip/ZipFile:close	()V
    //   148: iconst_2
    //   149: new 128	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 335
    //   159: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 282	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   172: aload_3
    //   173: invokevirtual 235	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   176: aload_1
    //   177: invokestatic 338	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   180: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   183: astore_2
    //   184: aload_2
    //   185: monitorenter
    //   186: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   189: aload_0
    //   190: new 272	java/lang/ref/WeakReference
    //   193: dup
    //   194: aload_1
    //   195: invokespecial 298	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   198: invokevirtual 302	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: pop
    //   202: aload_2
    //   203: monitorexit
    //   204: iconst_1
    //   205: ireturn
    //   206: astore_1
    //   207: aload_2
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    //   211: astore_1
    //   212: aload 4
    //   214: ifnonnull +41 -> 255
    //   217: new 284	java/lang/UnsatisfiedLinkError
    //   220: dup
    //   221: new 128	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 340
    //   231: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_0
    //   235: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokespecial 289	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   244: aload_1
    //   245: invokevirtual 308	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   248: invokevirtual 312	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   251: checkcast 284	java/lang/UnsatisfiedLinkError
    //   254: athrow
    //   255: aload 4
    //   257: athrow
    //   258: astore_0
    //   259: aload 4
    //   261: ifnonnull +21 -> 282
    //   264: new 284	java/lang/UnsatisfiedLinkError
    //   267: dup
    //   268: ldc_w 333
    //   271: invokespecial 289	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   274: aload_0
    //   275: invokevirtual 312	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   278: checkcast 284	java/lang/UnsatisfiedLinkError
    //   281: athrow
    //   282: aload 4
    //   284: athrow
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_2
    //   288: goto -160 -> 128
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_2
    //   294: goto -185 -> 109
    //   297: astore_0
    //   298: iconst_0
    //   299: ireturn
    //   300: astore_0
    //   301: iconst_0
    //   302: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramString	String
    //   0	303	1	paramClassLoader	ClassLoader
    //   0	303	3	paramFile	File
    //   0	303	4	paramUnsatisfiedLinkError	UnsatisfiedLinkError
    //   18	126	5	localZipFile	ZipFile
    //   7	41	6	str	String
    // Exception table:
    //   from	to	target	type
    //   23	58	105	java/lang/Exception
    //   61	74	105	java/lang/Exception
    //   77	105	105	java/lang/Exception
    //   23	58	127	finally
    //   61	74	127	finally
    //   77	105	127	finally
    //   109	127	127	finally
    //   186	204	206	finally
    //   207	209	206	finally
    //   148	186	211	java/lang/reflect/InvocationTargetException
    //   209	211	211	java/lang/reflect/InvocationTargetException
    //   148	186	258	java/lang/Exception
    //   209	211	258	java/lang/Exception
    //   0	20	285	finally
    //   0	20	291	java/lang/Exception
    //   143	148	297	java/io/IOException
    //   132	136	300	java/io/IOException
  }
  
  /* Error */
  private static UnsatisfiedLinkError loadFromRecovery(String paramString, ClassLoader paramClassLoader, Context arg2, File arg3)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 155	java/io/File:isFile	()Z
    //   4: ifeq +368 -> 372
    //   7: iconst_2
    //   8: new 128	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 342
    //   18: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 344
    //   28: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_3
    //   32: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 282	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   41: aload_3
    //   42: invokevirtual 235	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: aload_1
    //   46: invokestatic 338	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   49: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   52: astore_2
    //   53: aload_2
    //   54: monitorenter
    //   55: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   58: aload_0
    //   59: new 272	java/lang/ref/WeakReference
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 298	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   67: invokevirtual 302	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: aload_2
    //   72: monitorexit
    //   73: aconst_null
    //   74: areturn
    //   75: astore 4
    //   77: aload_2
    //   78: monitorexit
    //   79: aload 4
    //   81: athrow
    //   82: astore_2
    //   83: iconst_2
    //   84: new 128	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 349
    //   94: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 282	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   107: aload_3
    //   108: invokevirtual 352	java/io/File:delete	()Z
    //   111: pop
    //   112: aload_0
    //   113: aload_1
    //   114: invokestatic 295	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:reflectSystemLoadLibrary	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   117: iconst_2
    //   118: new 128	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 354
    //   128: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 282	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   141: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   144: astore_3
    //   145: aload_3
    //   146: monitorenter
    //   147: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   150: aload_0
    //   151: new 272	java/lang/ref/WeakReference
    //   154: dup
    //   155: aload_1
    //   156: invokespecial 298	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   159: invokevirtual 302	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   162: pop
    //   163: aload_3
    //   164: monitorexit
    //   165: aconst_null
    //   166: areturn
    //   167: astore_2
    //   168: aload_2
    //   169: invokevirtual 308	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   172: instanceof 284
    //   175: ifeq +14 -> 189
    //   178: aload_2
    //   179: invokevirtual 308	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   182: checkcast 284	java/lang/UnsatisfiedLinkError
    //   185: astore_2
    //   186: goto -103 -> 83
    //   189: new 284	java/lang/UnsatisfiedLinkError
    //   192: dup
    //   193: new 128	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 340
    //   203: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokespecial 289	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   216: aload_2
    //   217: invokevirtual 308	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   220: invokevirtual 312	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   223: checkcast 284	java/lang/UnsatisfiedLinkError
    //   226: athrow
    //   227: astore_1
    //   228: new 284	java/lang/UnsatisfiedLinkError
    //   231: dup
    //   232: new 128	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   239: ldc_w 340
    //   242: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_0
    //   246: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokespecial 289	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   255: aload_1
    //   256: invokevirtual 312	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   259: checkcast 284	java/lang/UnsatisfiedLinkError
    //   262: athrow
    //   263: astore_1
    //   264: aload_3
    //   265: monitorexit
    //   266: aload_1
    //   267: athrow
    //   268: astore_0
    //   269: aload_2
    //   270: ifnull +107 -> 377
    //   273: aload_2
    //   274: areturn
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 308	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   280: instanceof 284
    //   283: ifeq +15 -> 298
    //   286: aload_2
    //   287: ifnonnull -14 -> 273
    //   290: aload_1
    //   291: invokevirtual 308	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   294: checkcast 284	java/lang/UnsatisfiedLinkError
    //   297: areturn
    //   298: new 284	java/lang/UnsatisfiedLinkError
    //   301: dup
    //   302: new 128	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 340
    //   312: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokespecial 289	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   325: aload_1
    //   326: invokevirtual 308	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   329: invokevirtual 312	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   332: checkcast 284	java/lang/UnsatisfiedLinkError
    //   335: athrow
    //   336: astore_1
    //   337: new 284	java/lang/UnsatisfiedLinkError
    //   340: dup
    //   341: new 128	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   348: ldc_w 340
    //   351: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_0
    //   355: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokespecial 289	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   364: aload_1
    //   365: invokevirtual 312	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   368: checkcast 284	java/lang/UnsatisfiedLinkError
    //   371: athrow
    //   372: aconst_null
    //   373: astore_2
    //   374: goto -262 -> 112
    //   377: aload_0
    //   378: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramString	String
    //   0	379	1	paramClassLoader	ClassLoader
    //   75	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	73	75	finally
    //   77	79	75	finally
    //   7	55	82	java/lang/UnsatisfiedLinkError
    //   79	82	82	java/lang/UnsatisfiedLinkError
    //   7	55	167	java/lang/reflect/InvocationTargetException
    //   79	82	167	java/lang/reflect/InvocationTargetException
    //   7	55	227	java/lang/Throwable
    //   79	82	227	java/lang/Throwable
    //   147	165	263	finally
    //   264	266	263	finally
    //   112	147	268	java/lang/UnsatisfiedLinkError
    //   266	268	268	java/lang/UnsatisfiedLinkError
    //   112	147	275	java/lang/reflect/InvocationTargetException
    //   266	268	275	java/lang/reflect/InvocationTargetException
    //   112	147	336	java/lang/Throwable
    //   266	268	336	java/lang/Throwable
  }
  
  private static void reflectSystemLoad(String paramString, ClassLoader paramClassLoader)
  {
    Runtime localRuntime = Runtime.getRuntime();
    Method localMethod = localRuntime.getClass().getDeclaredMethod("load", new Class[] { String.class, ClassLoader.class });
    localMethod.setAccessible(true);
    localMethod.invoke(localRuntime, new Object[] { paramString, paramClassLoader });
  }
  
  private static void reflectSystemLoadLibrary(String paramString, ClassLoader paramClassLoader)
  {
    Runtime localRuntime = Runtime.getRuntime();
    Method localMethod = localRuntime.getClass().getDeclaredMethod("loadLibrary", new Class[] { String.class, ClassLoader.class });
    localMethod.setAccessible(true);
    localMethod.invoke(localRuntime, new Object[] { paramString, paramClassLoader });
  }
  
  public static void setupBrokenLibraryHandler()
  {
    Thread.setDefaultUncaughtExceptionHandler(new TPLoadLibFromApk.LibraryBrokenHandler(Thread.getDefaultUncaughtExceptionHandler()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPLoadLibFromApk
 * JD-Core Version:    0.7.0.1
 */