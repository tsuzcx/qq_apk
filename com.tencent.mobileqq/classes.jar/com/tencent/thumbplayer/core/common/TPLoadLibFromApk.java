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
    List localList = generateAbiList();
    File localFile = paramContext.getDir("recover_lib", 0);
    paramContext = new ZipFile(paramContext.getApplicationInfo().sourceDir);
    try
    {
      HashSet localHashSet = new HashSet();
      Pattern localPattern = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
      Enumeration localEnumeration = paramContext.entries();
      while (localEnumeration.hasMoreElements())
      {
        Object localObject2 = (ZipEntry)localEnumeration.nextElement();
        Object localObject3 = ((ZipEntry)localObject2).getName();
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).contains("../"))) {
          throw new Exception("contain ../, throw err");
        }
        localObject2 = localPattern.matcher(((ZipEntry)localObject2).getName());
        if (((Matcher)localObject2).matches())
        {
          localObject2 = ((Matcher)localObject2).group(1);
          if (!localHashSet.contains(localObject2))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("lib");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(".so");
            extractLibrary(paramContext, (String)localObject2, localList, new File(localFile, ((StringBuilder)localObject3).toString()));
            localHashSet.add(localObject2);
          }
        }
      }
      paramContext.close();
      return;
    }
    finally
    {
      paramContext.close();
    }
    for (;;)
    {
      throw localObject1;
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lib/");
      localStringBuilder.append(paramList);
      localStringBuilder.append("/lib");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".so");
      paramString = paramZipFile.getEntry(localStringBuilder.toString());
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
        paramString.close();
        return false;
      }
      finally
      {
        try
        {
          paramFile.setReadOnly();
          return true;
        }
        catch (Throwable paramZipFile) {}
        paramList = finally;
        paramZipFile.close();
        paramString.close();
      }
    }
    return false;
  }
  
  public static String find(String paramString, Context paramContext)
  {
    Object localObject1 = null;
    if (paramContext == null) {
      return null;
    }
    try
    {
      localObject2 = TPLoadLibFromApk.class.getClassLoader();
      Method localMethod = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class });
      localMethod.setAccessible(true);
      localObject2 = (String)localMethod.invoke(localObject2, new Object[] { paramString });
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label58:
      break label58;
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramContext = paramContext.getDir("recover_lib", 0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("lib");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(".so");
      paramString = new File(paramContext, ((StringBuilder)localObject2).toString());
      localObject2 = localObject1;
      if (paramString.canRead()) {
        localObject2 = paramString.getAbsolutePath();
      }
    }
    return localObject2;
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
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramClassLoader == null) {
        return false;
      }
      mContext = ???;
      Object localObject2 = mLoadedLibs;
      Object localObject1 = null;
      try
      {
        WeakReference localWeakReference = (WeakReference)mLoadedLibs.get(paramString);
        if (localWeakReference != null) {
          localObject1 = (ClassLoader)localWeakReference.get();
        }
        if (localObject1 != null)
        {
          if (localObject1 == paramClassLoader)
          {
            paramClassLoader = new StringBuilder();
            paramClassLoader.append("callerClassLoader has already load ! name=");
            paramClassLoader.append(paramString);
            TPNativeLog.printLog(2, paramClassLoader.toString());
            return true;
          }
          paramClassLoader = new StringBuilder();
          paramClassLoader.append("Library '");
          paramClassLoader.append(paramString);
          paramClassLoader.append("' was loaded by a different ClassLoader.");
          throw new UnsatisfiedLinkError(paramClassLoader.toString());
        }
        if (??? == null) {
          try
          {
            ??? = new StringBuilder();
            ???.append("context is null,load by System.loadLibrary,name= ");
            ???.append(paramString);
            TPNativeLog.printLog(2, ???.toString());
            reflectSystemLoadLibrary(paramString, paramClassLoader);
            synchronized (mLoadedLibs)
            {
              mLoadedLibs.put(paramString, new WeakReference(paramClassLoader));
              return true;
            }
            localObject1 = ???.getDir("recover_lib", 0);
          }
          catch (Exception paramClassLoader)
          {
            ??? = new StringBuilder();
            ???.append("Failed loading library: ");
            ???.append(paramString);
            throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError(???.toString()).initCause(paramClassLoader));
          }
          catch (InvocationTargetException paramClassLoader)
          {
            ??? = new StringBuilder();
            ???.append("Failed loading library: ");
            ???.append(paramString);
            throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError(???.toString()).initCause(paramClassLoader.getCause()));
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("lib");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(".so");
        localObject1 = new File((File)localObject1, ((StringBuilder)localObject2).toString());
        try
        {
          localObject2 = loadFromRecovery(paramString, paramClassLoader, ???, (File)localObject1);
          if (localObject2 == null) {
            return true;
          }
          try
          {
            boolean bool = loadFromApk(paramString, paramClassLoader, ???, (File)localObject1, (UnsatisfiedLinkError)localObject2);
            return bool;
          }
          catch (Throwable paramString)
          {
            throw paramString;
          }
          paramString = finally;
        }
        catch (Throwable paramString)
        {
          throw paramString;
        }
        return false;
      }
      finally {}
    }
  }
  
  /* Error */
  private static boolean loadFromApk(String paramString, ClassLoader paramClassLoader, Context paramContext, File paramFile, UnsatisfiedLinkError paramUnsatisfiedLinkError)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aload 8
    //   8: astore 6
    //   10: aload_2
    //   11: invokevirtual 47	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   14: getfield 53	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   17: astore 9
    //   19: aload 8
    //   21: astore 6
    //   23: new 43	java/util/zip/ZipFile
    //   26: dup
    //   27: aload 9
    //   29: invokespecial 56	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   32: astore_2
    //   33: new 123	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   40: astore 6
    //   42: aload 6
    //   44: ldc_w 324
    //   47: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 6
    //   53: aload_0
    //   54: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 6
    //   60: ldc_w 326
    //   63: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 6
    //   69: aload 9
    //   71: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: iconst_2
    //   76: aload 6
    //   78: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 282	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   84: aload_2
    //   85: aload_0
    //   86: invokestatic 33	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:generateAbiList	()Ljava/util/List;
    //   89: aload_3
    //   90: invokestatic 144	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:extractLibrary	(Ljava/util/zip/ZipFile;Ljava/lang/String;Ljava/util/List;Ljava/io/File;)Z
    //   93: istore 5
    //   95: iload 5
    //   97: ifeq +156 -> 253
    //   100: aload_2
    //   101: invokevirtual 150	java/util/zip/ZipFile:close	()V
    //   104: new 123	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   111: astore_2
    //   112: aload_2
    //   113: ldc_w 328
    //   116: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_2
    //   121: aload_0
    //   122: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: iconst_2
    //   127: aload_2
    //   128: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 282	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   134: aload_3
    //   135: invokevirtual 235	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   138: aload_1
    //   139: invokestatic 331	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   142: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   145: astore_2
    //   146: aload_2
    //   147: monitorenter
    //   148: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   151: aload_0
    //   152: new 272	java/lang/ref/WeakReference
    //   155: dup
    //   156: aload_1
    //   157: invokespecial 298	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   160: invokevirtual 302	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: aload_2
    //   165: monitorexit
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_1
    //   169: aload_2
    //   170: monitorexit
    //   171: aload_1
    //   172: athrow
    //   173: astore_0
    //   174: aload 4
    //   176: ifnonnull +21 -> 197
    //   179: new 288	java/lang/UnsatisfiedLinkError
    //   182: dup
    //   183: ldc_w 333
    //   186: invokespecial 289	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   189: aload_0
    //   190: invokevirtual 308	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   193: checkcast 288	java/lang/UnsatisfiedLinkError
    //   196: athrow
    //   197: aload 4
    //   199: athrow
    //   200: astore_1
    //   201: aload 4
    //   203: ifnonnull +47 -> 250
    //   206: new 123	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   213: astore_2
    //   214: aload_2
    //   215: ldc_w 335
    //   218: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_2
    //   223: aload_0
    //   224: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: new 288	java/lang/UnsatisfiedLinkError
    //   231: dup
    //   232: aload_2
    //   233: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokespecial 289	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   239: aload_1
    //   240: invokevirtual 312	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   243: invokevirtual 308	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   246: checkcast 288	java/lang/UnsatisfiedLinkError
    //   249: athrow
    //   250: aload 4
    //   252: athrow
    //   253: new 123	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   260: astore_1
    //   261: aload_1
    //   262: ldc_w 337
    //   265: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_1
    //   270: aload_0
    //   271: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: new 339	java/lang/RuntimeException
    //   278: dup
    //   279: aload_1
    //   280: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokespecial 340	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   286: athrow
    //   287: astore_0
    //   288: goto +40 -> 328
    //   291: astore_0
    //   292: aload_2
    //   293: astore 6
    //   295: goto +15 -> 310
    //   298: astore_0
    //   299: aload 6
    //   301: astore_2
    //   302: goto +26 -> 328
    //   305: astore_0
    //   306: aload 7
    //   308: astore 6
    //   310: new 288	java/lang/UnsatisfiedLinkError
    //   313: dup
    //   314: ldc_w 333
    //   317: invokespecial 289	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   320: aload_0
    //   321: invokevirtual 308	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   324: checkcast 288	java/lang/UnsatisfiedLinkError
    //   327: athrow
    //   328: aload_2
    //   329: ifnull +10 -> 339
    //   332: aload_2
    //   333: invokevirtual 150	java/util/zip/ZipFile:close	()V
    //   336: goto +3 -> 339
    //   339: aload_0
    //   340: athrow
    //   341: astore_0
    //   342: iconst_0
    //   343: ireturn
    //   344: astore_0
    //   345: iconst_0
    //   346: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramString	String
    //   0	347	1	paramClassLoader	ClassLoader
    //   0	347	2	paramContext	Context
    //   0	347	3	paramFile	File
    //   0	347	4	paramUnsatisfiedLinkError	UnsatisfiedLinkError
    //   93	3	5	bool	boolean
    //   8	301	6	localObject1	Object
    //   1	306	7	localObject2	Object
    //   4	16	8	localObject3	Object
    //   17	53	9	str	String
    // Exception table:
    //   from	to	target	type
    //   148	166	168	finally
    //   169	171	168	finally
    //   104	148	173	java/lang/Exception
    //   171	173	173	java/lang/Exception
    //   104	148	200	java/lang/reflect/InvocationTargetException
    //   171	173	200	java/lang/reflect/InvocationTargetException
    //   33	95	287	finally
    //   253	287	287	finally
    //   33	95	291	java/lang/Exception
    //   253	287	291	java/lang/Exception
    //   10	19	298	finally
    //   23	33	298	finally
    //   310	328	298	finally
    //   10	19	305	java/lang/Exception
    //   23	33	305	java/lang/Exception
    //   100	104	341	java/io/IOException
    //   332	336	344	java/io/IOException
  }
  
  private static UnsatisfiedLinkError loadFromRecovery(String paramString, ClassLoader paramClassLoader, Context arg2, File arg3)
  {
    if (???.isFile()) {
      try
      {
        ??? = new StringBuilder();
        ???.append("load by recover_lib,name= ");
        ???.append(paramString);
        ???.append("recoverfile=");
        ???.append(???);
        TPNativeLog.printLog(2, ???.toString());
        reflectSystemLoad(???.getAbsolutePath(), paramClassLoader);
        synchronized (mLoadedLibs)
        {
          mLoadedLibs.put(paramString, new WeakReference(paramClassLoader));
          return null;
        }
        StringBuilder localStringBuilder;
        ??? = null;
      }
      catch (Throwable paramClassLoader)
      {
        ??? = new StringBuilder();
        ???.append("Failed recovering native library: ");
        ???.append(paramString);
        throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError(???.toString()).initCause(paramClassLoader));
      }
      catch (InvocationTargetException ???)
      {
        if ((???.getCause() instanceof UnsatisfiedLinkError))
        {
          ??? = (UnsatisfiedLinkError)???.getCause();
        }
        else
        {
          paramClassLoader = new StringBuilder();
          paramClassLoader.append("Failed recovering native library: ");
          paramClassLoader.append(paramString);
          throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError(paramClassLoader.toString()).initCause(???.getCause()));
        }
      }
      catch (UnsatisfiedLinkError ???)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("load by recover_lib failed!,name= ");
        localStringBuilder.append(paramString);
        TPNativeLog.printLog(2, localStringBuilder.toString());
        ???.delete();
      }
    }
    try
    {
      reflectSystemLoadLibrary(paramString, paramClassLoader);
      ??? = new StringBuilder();
      ???.append("load by reflectSystemLoadLibrary,name= ");
      ???.append(paramString);
      TPNativeLog.printLog(2, ???.toString());
      synchronized (mLoadedLibs)
      {
        mLoadedLibs.put(paramString, new WeakReference(paramClassLoader));
        return null;
      }
      return paramString;
    }
    catch (Throwable paramClassLoader)
    {
      ??? = new StringBuilder();
      ???.append("Failed recovering native library: ");
      ???.append(paramString);
      throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError(???.toString()).initCause(paramClassLoader));
    }
    catch (InvocationTargetException paramClassLoader)
    {
      if ((paramClassLoader.getCause() instanceof UnsatisfiedLinkError))
      {
        paramString = ???;
        if (??? == null) {
          return (UnsatisfiedLinkError)paramClassLoader.getCause();
        }
      }
      else
      {
        ??? = new StringBuilder();
        ???.append("Failed recovering native library: ");
        ???.append(paramString);
        throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError(???.toString()).initCause(paramClassLoader.getCause()));
      }
    }
    catch (UnsatisfiedLinkError paramClassLoader)
    {
      paramString = ???;
      if (??? == null) {
        paramString = paramClassLoader;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPLoadLibFromApk
 * JD-Core Version:    0.7.0.1
 */