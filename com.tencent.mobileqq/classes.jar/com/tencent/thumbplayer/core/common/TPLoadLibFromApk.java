package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
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
    }
    try
    {
      paramFile.setReadOnly();
      label174:
      return true;
      return false;
    }
    catch (Throwable paramZipFile)
    {
      break label174;
    }
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
  
  /* Error */
  public static boolean load(String paramString, ClassLoader paramClassLoader, Context arg2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +14 -> 15
    //   4: aload_0
    //   5: invokevirtual 257	java/lang/String:length	()I
    //   8: ifeq +7 -> 15
    //   11: aload_1
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_2
    //   18: putstatic 20	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mContext	Landroid/content/Context;
    //   21: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   24: astore 4
    //   26: aload 4
    //   28: monitorenter
    //   29: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   32: aload_0
    //   33: invokevirtual 274	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 276	java/lang/ref/WeakReference
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +973 -> 1014
    //   44: aload_3
    //   45: invokevirtual 278	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   48: checkcast 213	java/lang/ClassLoader
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +77 -> 130
    //   56: aload_3
    //   57: aload_1
    //   58: if_acmpne +32 -> 90
    //   61: iconst_2
    //   62: new 128	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 280
    //   72: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 286	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   85: aload 4
    //   87: monitorexit
    //   88: iconst_1
    //   89: ireturn
    //   90: new 269	java/lang/UnsatisfiedLinkError
    //   93: dup
    //   94: new 128	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 288
    //   104: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc_w 290
    //   114: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 291	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   123: athrow
    //   124: astore_0
    //   125: aload 4
    //   127: monitorexit
    //   128: aload_0
    //   129: athrow
    //   130: aload 4
    //   132: monitorexit
    //   133: aload_2
    //   134: ifnonnull +138 -> 272
    //   137: iconst_2
    //   138: new 128	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 293
    //   148: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 286	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   161: aload_0
    //   162: aload_1
    //   163: invokestatic 297	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:reflectSystemLoadLibrary	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   166: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   169: astore_2
    //   170: aload_2
    //   171: monitorenter
    //   172: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   175: aload_0
    //   176: new 276	java/lang/ref/WeakReference
    //   179: dup
    //   180: aload_1
    //   181: invokespecial 300	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   184: invokevirtual 304	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: aload_2
    //   189: monitorexit
    //   190: iconst_1
    //   191: ireturn
    //   192: astore_1
    //   193: aload_2
    //   194: monitorexit
    //   195: aload_1
    //   196: athrow
    //   197: astore_1
    //   198: new 269	java/lang/UnsatisfiedLinkError
    //   201: dup
    //   202: new 128	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 306
    //   212: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_0
    //   216: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokespecial 291	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   225: aload_1
    //   226: invokevirtual 310	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   229: invokevirtual 314	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   232: checkcast 269	java/lang/UnsatisfiedLinkError
    //   235: athrow
    //   236: astore_1
    //   237: new 269	java/lang/UnsatisfiedLinkError
    //   240: dup
    //   241: new 128	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 306
    //   251: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokespecial 291	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   264: aload_1
    //   265: invokevirtual 314	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   268: checkcast 269	java/lang/UnsatisfiedLinkError
    //   271: athrow
    //   272: new 126	java/io/File
    //   275: dup
    //   276: aload_2
    //   277: ldc 35
    //   279: iconst_0
    //   280: invokevirtual 41	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   283: new 128	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   290: ldc 131
    //   292: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_0
    //   296: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc 137
    //   301: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokespecial 143	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   310: astore 5
    //   312: aload 5
    //   314: invokevirtual 155	java/io/File:isFile	()Z
    //   317: ifeq +692 -> 1009
    //   320: iconst_2
    //   321: new 128	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   328: ldc_w 316
    //   331: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_0
    //   335: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: ldc_w 318
    //   341: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload 5
    //   346: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 286	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   355: aload 5
    //   357: invokevirtual 235	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   360: aload_1
    //   361: invokestatic 324	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   364: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   367: astore_3
    //   368: aload_3
    //   369: monitorenter
    //   370: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   373: aload_0
    //   374: new 276	java/lang/ref/WeakReference
    //   377: dup
    //   378: aload_1
    //   379: invokespecial 300	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   382: invokevirtual 304	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   385: pop
    //   386: aload_3
    //   387: monitorexit
    //   388: iconst_1
    //   389: ireturn
    //   390: astore 4
    //   392: aload_3
    //   393: monitorexit
    //   394: aload 4
    //   396: athrow
    //   397: astore_3
    //   398: iconst_2
    //   399: new 128	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   406: ldc_w 326
    //   409: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_0
    //   413: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 286	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   422: aload 5
    //   424: invokevirtual 329	java/io/File:delete	()Z
    //   427: pop
    //   428: aload_0
    //   429: aload_1
    //   430: invokestatic 297	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:reflectSystemLoadLibrary	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   433: iconst_2
    //   434: new 128	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   441: ldc_w 331
    //   444: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_0
    //   448: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 286	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   457: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   460: astore 4
    //   462: aload 4
    //   464: monitorenter
    //   465: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   468: aload_0
    //   469: new 276	java/lang/ref/WeakReference
    //   472: dup
    //   473: aload_1
    //   474: invokespecial 300	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   477: invokevirtual 304	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   480: pop
    //   481: aload 4
    //   483: monitorexit
    //   484: iconst_1
    //   485: ireturn
    //   486: astore_3
    //   487: aload_3
    //   488: invokevirtual 310	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   491: instanceof 269
    //   494: ifeq +14 -> 508
    //   497: aload_3
    //   498: invokevirtual 310	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   501: checkcast 269	java/lang/UnsatisfiedLinkError
    //   504: astore_3
    //   505: goto -107 -> 398
    //   508: new 269	java/lang/UnsatisfiedLinkError
    //   511: dup
    //   512: new 128	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   519: ldc_w 333
    //   522: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: aload_0
    //   526: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokespecial 291	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   535: aload_3
    //   536: invokevirtual 310	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   539: invokevirtual 314	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   542: checkcast 269	java/lang/UnsatisfiedLinkError
    //   545: athrow
    //   546: astore_1
    //   547: new 269	java/lang/UnsatisfiedLinkError
    //   550: dup
    //   551: new 128	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   558: ldc_w 333
    //   561: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_0
    //   565: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokespecial 291	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   574: aload_1
    //   575: invokevirtual 314	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   578: checkcast 269	java/lang/UnsatisfiedLinkError
    //   581: athrow
    //   582: astore 6
    //   584: aload 4
    //   586: monitorexit
    //   587: aload 6
    //   589: athrow
    //   590: astore 4
    //   592: aload_3
    //   593: ifnonnull +413 -> 1006
    //   596: aload 4
    //   598: astore_3
    //   599: aload_2
    //   600: invokevirtual 47	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   603: getfield 53	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   606: astore 6
    //   608: new 43	java/util/zip/ZipFile
    //   611: dup
    //   612: aload 6
    //   614: invokespecial 56	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   617: astore 4
    //   619: aload 4
    //   621: astore_2
    //   622: iconst_2
    //   623: new 128	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   630: ldc_w 335
    //   633: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_0
    //   637: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: ldc_w 337
    //   643: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload 6
    //   648: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: invokestatic 286	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   657: aload 4
    //   659: astore_2
    //   660: aload 4
    //   662: aload_0
    //   663: invokestatic 33	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:generateAbiList	()Ljava/util/List;
    //   666: aload 5
    //   668: invokestatic 147	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:extractLibrary	(Ljava/util/zip/ZipFile;Ljava/lang/String;Ljava/util/List;Ljava/io/File;)Z
    //   671: ifne +171 -> 842
    //   674: aload 4
    //   676: astore_2
    //   677: new 339	java/lang/RuntimeException
    //   680: dup
    //   681: new 128	java/lang/StringBuilder
    //   684: dup
    //   685: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   688: ldc_w 341
    //   691: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload_0
    //   695: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokespecial 342	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   704: athrow
    //   705: astore_0
    //   706: aload 4
    //   708: astore_2
    //   709: new 269	java/lang/UnsatisfiedLinkError
    //   712: dup
    //   713: ldc_w 344
    //   716: invokespecial 291	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   719: aload_0
    //   720: invokevirtual 314	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   723: checkcast 269	java/lang/UnsatisfiedLinkError
    //   726: athrow
    //   727: astore_0
    //   728: aload_2
    //   729: ifnull +7 -> 736
    //   732: aload_2
    //   733: invokevirtual 108	java/util/zip/ZipFile:close	()V
    //   736: aload_0
    //   737: athrow
    //   738: astore 4
    //   740: aload 4
    //   742: invokevirtual 310	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   745: instanceof 269
    //   748: ifeq +19 -> 767
    //   751: aload_3
    //   752: ifnonnull +254 -> 1006
    //   755: aload 4
    //   757: invokevirtual 310	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   760: checkcast 269	java/lang/UnsatisfiedLinkError
    //   763: astore_3
    //   764: goto -165 -> 599
    //   767: new 269	java/lang/UnsatisfiedLinkError
    //   770: dup
    //   771: new 128	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   778: ldc_w 333
    //   781: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: aload_0
    //   785: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: invokespecial 291	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   794: aload 4
    //   796: invokevirtual 310	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   799: invokevirtual 314	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   802: checkcast 269	java/lang/UnsatisfiedLinkError
    //   805: athrow
    //   806: astore_1
    //   807: new 269	java/lang/UnsatisfiedLinkError
    //   810: dup
    //   811: new 128	java/lang/StringBuilder
    //   814: dup
    //   815: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   818: ldc_w 333
    //   821: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: aload_0
    //   825: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokespecial 291	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   834: aload_1
    //   835: invokevirtual 314	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   838: checkcast 269	java/lang/UnsatisfiedLinkError
    //   841: athrow
    //   842: aload 4
    //   844: ifnull +8 -> 852
    //   847: aload 4
    //   849: invokevirtual 108	java/util/zip/ZipFile:close	()V
    //   852: iconst_2
    //   853: new 128	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   860: ldc_w 346
    //   863: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload_0
    //   867: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 286	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   876: aload 5
    //   878: invokevirtual 235	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   881: aload_1
    //   882: invokestatic 324	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   885: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   888: astore_2
    //   889: aload_2
    //   890: monitorenter
    //   891: getstatic 18	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   894: aload_0
    //   895: new 276	java/lang/ref/WeakReference
    //   898: dup
    //   899: aload_1
    //   900: invokespecial 300	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   903: invokevirtual 304	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   906: pop
    //   907: aload_2
    //   908: monitorexit
    //   909: iconst_1
    //   910: ireturn
    //   911: astore_1
    //   912: aload_2
    //   913: monitorexit
    //   914: aload_1
    //   915: athrow
    //   916: astore_1
    //   917: aload_3
    //   918: ifnonnull +41 -> 959
    //   921: new 269	java/lang/UnsatisfiedLinkError
    //   924: dup
    //   925: new 128	java/lang/StringBuilder
    //   928: dup
    //   929: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   932: ldc_w 333
    //   935: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload_0
    //   939: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   945: invokespecial 291	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   948: aload_1
    //   949: invokevirtual 310	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   952: invokevirtual 314	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   955: checkcast 269	java/lang/UnsatisfiedLinkError
    //   958: athrow
    //   959: aload_3
    //   960: athrow
    //   961: astore_0
    //   962: aload_3
    //   963: ifnonnull +21 -> 984
    //   966: new 269	java/lang/UnsatisfiedLinkError
    //   969: dup
    //   970: ldc_w 344
    //   973: invokespecial 291	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   976: aload_0
    //   977: invokevirtual 314	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   980: checkcast 269	java/lang/UnsatisfiedLinkError
    //   983: athrow
    //   984: aload_3
    //   985: athrow
    //   986: astore_2
    //   987: goto -135 -> 852
    //   990: astore_1
    //   991: goto -255 -> 736
    //   994: astore_0
    //   995: aconst_null
    //   996: astore_2
    //   997: goto -269 -> 728
    //   1000: astore_0
    //   1001: aconst_null
    //   1002: astore_2
    //   1003: goto -294 -> 709
    //   1006: goto -407 -> 599
    //   1009: aconst_null
    //   1010: astore_3
    //   1011: goto -583 -> 428
    //   1014: aconst_null
    //   1015: astore_3
    //   1016: goto -964 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1019	0	paramString	String
    //   0	1019	1	paramClassLoader	ClassLoader
    //   39	354	3	localObject1	Object
    //   397	1	3	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   486	12	3	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   504	512	3	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   24	107	4	localHashMap1	HashMap
    //   390	5	4	localObject2	Object
    //   460	125	4	localHashMap2	HashMap
    //   590	7	4	localUnsatisfiedLinkError3	java.lang.UnsatisfiedLinkError
    //   617	90	4	localZipFile	ZipFile
    //   738	110	4	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   310	567	5	localFile	File
    //   582	6	6	localObject3	Object
    //   606	41	6	str	String
    // Exception table:
    //   from	to	target	type
    //   29	40	124	finally
    //   44	52	124	finally
    //   61	88	124	finally
    //   90	124	124	finally
    //   125	128	124	finally
    //   130	133	124	finally
    //   172	190	192	finally
    //   193	195	192	finally
    //   137	172	197	java/lang/reflect/InvocationTargetException
    //   195	197	197	java/lang/reflect/InvocationTargetException
    //   137	172	236	java/lang/Exception
    //   195	197	236	java/lang/Exception
    //   370	388	390	finally
    //   392	394	390	finally
    //   320	370	397	java/lang/UnsatisfiedLinkError
    //   394	397	397	java/lang/UnsatisfiedLinkError
    //   320	370	486	java/lang/reflect/InvocationTargetException
    //   394	397	486	java/lang/reflect/InvocationTargetException
    //   320	370	546	java/lang/Throwable
    //   394	397	546	java/lang/Throwable
    //   465	484	582	finally
    //   584	587	582	finally
    //   428	465	590	java/lang/UnsatisfiedLinkError
    //   587	590	590	java/lang/UnsatisfiedLinkError
    //   622	657	705	java/lang/Exception
    //   660	674	705	java/lang/Exception
    //   677	705	705	java/lang/Exception
    //   622	657	727	finally
    //   660	674	727	finally
    //   677	705	727	finally
    //   709	727	727	finally
    //   428	465	738	java/lang/reflect/InvocationTargetException
    //   587	590	738	java/lang/reflect/InvocationTargetException
    //   428	465	806	java/lang/Throwable
    //   587	590	806	java/lang/Throwable
    //   891	909	911	finally
    //   912	914	911	finally
    //   852	891	916	java/lang/reflect/InvocationTargetException
    //   914	916	916	java/lang/reflect/InvocationTargetException
    //   852	891	961	java/lang/Exception
    //   914	916	961	java/lang/Exception
    //   847	852	986	java/io/IOException
    //   732	736	990	java/io/IOException
    //   599	619	994	finally
    //   599	619	1000	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPLoadLibFromApk
 * JD-Core Version:    0.7.0.1
 */