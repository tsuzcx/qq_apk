package com.tencent.mobileqq.vas.gldrawable;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GLDrawableLoaderImpl
  implements GLDrawableProxy.GLDrawableLoader
{
  private int jdField_a_of_type_Int = 0;
  private final GLDrawableLoaderImpl.MyReporter jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableLoaderImpl$MyReporter = new GLDrawableLoaderImpl.MyReporter();
  private final GLDrawableProxy.LoaderCallback jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableProxy$LoaderCallback = new GLDrawableLoaderImpl.1(this);
  private final List<GLDrawableProxy.LoaderCallback> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = true;
  
  private String a(File paramFile1, File paramFile2, String paramString)
  {
    String str1 = paramFile1.getAbsolutePath();
    String str2 = paramFile2.getAbsolutePath() + "_temp";
    long l = IOUtil.getCRC32Value(paramFile1);
    if (l == -1L) {
      return "file not exists";
    }
    if (a(paramFile2, paramString, l))
    {
      GLDrawableDownloadHelper.a();
      return "sucess";
    }
    try
    {
      if (new File(str2).exists()) {
        FileUtils.a(str2, false);
      }
      FileUtils.d(str1, new File(str2, paramString).getAbsolutePath());
      FileUtils.a(str1, str2, false, Pattern.compile(".*\\.so$"));
      if (paramFile2.exists()) {
        FileUtils.a(paramFile2.getAbsolutePath(), false);
      }
      QLog.d("GLDrawable", 1, "unzip succ..." + new File(str1).length() + "..." + MD5Utils.encodeFileHexStr(str1));
      if ((FileUtils.c(str2, paramFile2.getAbsolutePath())) && (a(paramFile2, paramString, l))) {
        return "sucess";
      }
      throw new IOException("unzip file error");
    }
    catch (Exception paramFile1) {}
    try
    {
      if (paramFile2.exists()) {
        FileUtils.a(paramFile2.getAbsolutePath(), false);
      }
      QLog.e("GLDrawable", 1, new Object[] { "unzip error, libDir=" + paramFile2, " zipPath=" + str1, paramFile1 });
      return "unzip " + paramFile1.getMessage();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("GLDrawable", 1, new Object[] { "unzip error, libDir=" + paramFile2, " zipPath=" + str1, paramString });
      }
    }
  }
  
  /* Error */
  private void a(Context paramContext, GLDrawableProxy.LoaderCallback paramLoaderCallback)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 21	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Boolean	Z
    //   12: istore 6
    //   14: iload 6
    //   16: ifeq +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: new 51	java/io/File
    //   25: dup
    //   26: aload_1
    //   27: invokestatic 168	com/tencent/mobileqq/vas/gldrawable/GLDrawableDownloadHelper:a	(Landroid/content/Context;)Ljava/lang/String;
    //   30: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 8
    //   35: aload_1
    //   36: invokestatic 173	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	(Landroid/content/Context;)Ljava/io/File;
    //   39: astore 7
    //   41: aload_0
    //   42: aload 8
    //   44: aload 7
    //   46: ldc 175
    //   48: invokespecial 177	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:a	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 8
    //   53: ldc 86
    //   55: aload 8
    //   57: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifne +88 -> 148
    //   63: aload_0
    //   64: getfield 44	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableLoaderImpl$MyReporter	Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl$MyReporter;
    //   67: ldc 185
    //   69: ldc 187
    //   71: aload 8
    //   73: ldc2_w 74
    //   76: invokevirtual 190	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl$MyReporter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   79: invokestatic 192	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	()Z
    //   82: ifne +369 -> 451
    //   85: aload_0
    //   86: getfield 25	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Int	I
    //   89: istore_3
    //   90: aload_0
    //   91: iload_3
    //   92: iconst_1
    //   93: iadd
    //   94: putfield 25	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Int	I
    //   97: iload_3
    //   98: iconst_3
    //   99: if_icmple +6 -> 105
    //   102: goto +349 -> 451
    //   105: aload_0
    //   106: iload 4
    //   108: putfield 21	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Boolean	Z
    //   111: invokestatic 192	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	()Z
    //   114: ifeq +21 -> 135
    //   117: aload_2
    //   118: ifnull -99 -> 19
    //   121: aload_2
    //   122: invokeinterface 195 1 0
    //   127: goto -108 -> 19
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    //   135: aload_2
    //   136: ifnull -117 -> 19
    //   139: aload_2
    //   140: invokeinterface 197 1 0
    //   145: goto -126 -> 19
    //   148: new 51	java/io/File
    //   151: dup
    //   152: aload 7
    //   154: ldc 175
    //   156: invokespecial 200	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   159: astore 8
    //   161: aload_0
    //   162: invokespecial 202	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:d	()Z
    //   165: ifne +221 -> 386
    //   168: aload_0
    //   169: invokespecial 204	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:c	()Z
    //   172: ifne +147 -> 319
    //   175: new 51	java/io/File
    //   178: dup
    //   179: aload 7
    //   181: ldc 206
    //   183: invokespecial 200	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   186: astore 7
    //   188: invokestatic 209	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	()Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableProxy;
    //   191: aload_1
    //   192: aload 8
    //   194: aload 7
    //   196: invokevirtual 212	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	(Landroid/content/Context;Ljava/io/File;Ljava/io/File;)V
    //   199: invokestatic 192	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	()Z
    //   202: ifne +47 -> 249
    //   205: ldc 214
    //   207: iconst_2
    //   208: anewarray 216	kotlin/Pair
    //   211: dup
    //   212: iconst_0
    //   213: new 216	kotlin/Pair
    //   216: dup
    //   217: ldc 218
    //   219: getstatic 223	android/os/Build$VERSION:SDK_INT	I
    //   222: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   225: invokespecial 230	kotlin/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: new 216	kotlin/Pair
    //   234: dup
    //   235: ldc 232
    //   237: aload 7
    //   239: invokevirtual 235	java/io/File:getName	()Ljava/lang/String;
    //   242: invokespecial 230	kotlin/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   245: aastore
    //   246: invokestatic 240	com/tencent/mobileqq/vas/VasStatisticCollector:a	(Ljava/lang/String;[Lkotlin/Pair;)V
    //   249: invokestatic 244	com/tencent/qqperf/tools/DeviceInfoUtils:b	()Z
    //   252: ifeq +12 -> 264
    //   255: invokestatic 209	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	()Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableProxy;
    //   258: bipush 20
    //   260: invokevirtual 247	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	(I)Z
    //   263: pop
    //   264: invokestatic 192	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	()Z
    //   267: ifne +190 -> 457
    //   270: aload_0
    //   271: getfield 25	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Int	I
    //   274: istore_3
    //   275: aload_0
    //   276: iload_3
    //   277: iconst_1
    //   278: iadd
    //   279: putfield 25	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Int	I
    //   282: iload 5
    //   284: istore 4
    //   286: iload_3
    //   287: iconst_3
    //   288: if_icmple +6 -> 294
    //   291: goto +166 -> 457
    //   294: aload_0
    //   295: iload 4
    //   297: putfield 21	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Boolean	Z
    //   300: invokestatic 192	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	()Z
    //   303: ifeq +122 -> 425
    //   306: aload_2
    //   307: ifnull -288 -> 19
    //   310: aload_2
    //   311: invokeinterface 195 1 0
    //   316: goto -297 -> 19
    //   319: new 51	java/io/File
    //   322: dup
    //   323: aload 7
    //   325: ldc 249
    //   327: invokespecial 200	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   330: astore 7
    //   332: goto -144 -> 188
    //   335: astore_1
    //   336: invokestatic 192	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	()Z
    //   339: ifne +124 -> 463
    //   342: aload_0
    //   343: getfield 25	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Int	I
    //   346: istore_3
    //   347: aload_0
    //   348: iload_3
    //   349: iconst_1
    //   350: iadd
    //   351: putfield 25	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Int	I
    //   354: iload_3
    //   355: iconst_3
    //   356: if_icmple +113 -> 469
    //   359: goto +104 -> 463
    //   362: aload_0
    //   363: iload 4
    //   365: putfield 21	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Boolean	Z
    //   368: invokestatic 192	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	()Z
    //   371: ifeq +67 -> 438
    //   374: aload_2
    //   375: ifnull +9 -> 384
    //   378: aload_2
    //   379: invokeinterface 195 1 0
    //   384: aload_1
    //   385: athrow
    //   386: aload_0
    //   387: invokespecial 204	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:c	()Z
    //   390: ifne +19 -> 409
    //   393: new 51	java/io/File
    //   396: dup
    //   397: aload 7
    //   399: ldc 251
    //   401: invokespecial 200	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   404: astore 7
    //   406: goto -218 -> 188
    //   409: new 51	java/io/File
    //   412: dup
    //   413: aload 7
    //   415: ldc 253
    //   417: invokespecial 200	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   420: astore 7
    //   422: goto -234 -> 188
    //   425: aload_2
    //   426: ifnull -407 -> 19
    //   429: aload_2
    //   430: invokeinterface 197 1 0
    //   435: goto -416 -> 19
    //   438: aload_2
    //   439: ifnull -55 -> 384
    //   442: aload_2
    //   443: invokeinterface 197 1 0
    //   448: goto -64 -> 384
    //   451: iconst_1
    //   452: istore 4
    //   454: goto -349 -> 105
    //   457: iconst_1
    //   458: istore 4
    //   460: goto -166 -> 294
    //   463: iconst_1
    //   464: istore 4
    //   466: goto -104 -> 362
    //   469: iconst_0
    //   470: istore 4
    //   472: goto -110 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	GLDrawableLoaderImpl
    //   0	475	1	paramContext	Context
    //   0	475	2	paramLoaderCallback	GLDrawableProxy.LoaderCallback
    //   89	268	3	i	int
    //   4	467	4	bool1	boolean
    //   1	282	5	bool2	boolean
    //   12	3	6	bool3	boolean
    //   39	382	7	localFile	File
    //   33	160	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	14	130	finally
    //   22	41	130	finally
    //   79	97	130	finally
    //   105	117	130	finally
    //   121	127	130	finally
    //   139	145	130	finally
    //   264	282	130	finally
    //   294	306	130	finally
    //   310	316	130	finally
    //   336	354	130	finally
    //   362	374	130	finally
    //   378	384	130	finally
    //   384	386	130	finally
    //   429	435	130	finally
    //   442	448	130	finally
    //   41	79	335	finally
    //   148	188	335	finally
    //   188	249	335	finally
    //   249	264	335	finally
    //   319	332	335	finally
    //   386	406	335	finally
    //   409	422	335	finally
  }
  
  private void a(Context paramContext, String paramString, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    try
    {
      if (GLDrawableDownloadHelper.a(paramContext))
      {
        paramRunnable1.run();
        return;
      }
      GLDrawableDownloadHelper.a();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("GLDrawable", 1, "", paramContext);
      }
    }
    paramRunnable2.run();
  }
  
  private boolean a(File paramFile, String paramString, long paramLong)
  {
    boolean bool = true;
    long l = IOUtil.getCRC32Value(new File(paramFile, paramString));
    if (l == -1L) {
      return false;
    }
    int i;
    if (l == paramLong)
    {
      i = 1;
      if ((i == 0) || (!new File(paramFile, "/lib/armeabi-v7a").exists()) || (!new File(paramFile, "/lib/arm64-v8a").exists()) || (!new File(paramFile, "/lib/x86").exists()) || (!new File(paramFile, "/lib/x86_64").exists())) {
        break label116;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label116:
      bool = false;
    }
  }
  
  private void b(GLDrawableProxy.LoaderCallback paramLoaderCallback)
  {
    if (paramLoaderCallback == null) {
      return;
    }
    if (GLDrawableProxy.a())
    {
      paramLoaderCallback.a();
      return;
    }
    paramLoaderCallback.b();
  }
  
  private void c(GLDrawableProxy.LoaderCallback paramLoaderCallback)
  {
    if (!QVipSDKProcessor.c().a()) {
      return;
    }
    GLDrawableProxy.a(this.jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableLoaderImpl$MyReporter);
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    GLDrawableLoaderImpl.5 local5 = new GLDrawableLoaderImpl.5(this, localBaseApplicationImpl, paramLoaderCallback);
    paramLoaderCallback = new GLDrawableLoaderImpl.6(this, paramLoaderCallback);
    a(localBaseApplicationImpl, GLDrawableDownloadHelper.a(localBaseApplicationImpl), local5, paramLoaderCallback);
  }
  
  private boolean c()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return Process.is64Bit();
    }
    try
    {
      if (Build.VERSION.SDK_INT < 21) {
        return false;
      }
      Object localObject1 = Class.forName("dalvik.system.VMRuntime");
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getRuntime", new Class[0]);
      if (localObject2 == null) {
        return false;
      }
      localObject2 = ((Method)localObject2).invoke(null, new Object[0]);
      if (localObject2 == null) {
        return false;
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod("is64Bit", new Class[0]);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Method)localObject1).invoke(localObject2, new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GLDrawable", 1, localThrowable, new Object[0]);
    }
    return false;
  }
  
  private boolean d()
  {
    boolean bool1 = VideoEnvironment.isX86Platform();
    Object localObject = Build.CPU_ABI;
    if ((localObject != null) && (!"".equals(localObject)) && ("x86".equalsIgnoreCase((String)localObject))) {
      return true;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = Build.SUPPORTED_ABIS;
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          CharSequence localCharSequence = localObject[i];
          bool2 = bool1;
          if (!TextUtils.isEmpty(localCharSequence))
          {
            bool2 = bool1;
            if (localCharSequence.toLowerCase().contains("x86")) {
              bool2 = true;
            }
          }
          i += 1;
          bool1 = bool2;
        }
      }
    }
    return bool2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.b = true;
    ThreadManagerV2.executeOnSubThread(new GLDrawableLoaderImpl.3(this));
  }
  
  /* Error */
  public void a(GLDrawableProxy.LoaderCallback paramLoaderCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield 23	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:b	Z
    //   13: invokestatic 384	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   16: invokestatic 387	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   19: if_acmpne +3 -> 22
    //   22: aload_0
    //   23: getfield 21	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Boolean	Z
    //   26: ifne +15 -> 41
    //   29: invokestatic 192	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	()Z
    //   32: ifne +9 -> 41
    //   35: invokestatic 388	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:b	()Z
    //   38: ifeq +14 -> 52
    //   41: aload_0
    //   42: aload_1
    //   43: invokespecial 390	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:b	(Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableProxy$LoaderCallback;)V
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 23	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:b	Z
    //   51: return
    //   52: ldc 2
    //   54: monitorenter
    //   55: aload_0
    //   56: getfield 21	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:jdField_a_of_type_Boolean	Z
    //   59: ifne +15 -> 74
    //   62: invokestatic 192	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:a	()Z
    //   65: ifne +9 -> 74
    //   68: invokestatic 388	com/tencent/mobileqq/vas/gldrawable/GLDrawableProxy:b	()Z
    //   71: ifeq +17 -> 88
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 390	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:b	(Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableProxy$LoaderCallback;)V
    //   79: ldc 2
    //   81: monitorexit
    //   82: aload_0
    //   83: iconst_0
    //   84: putfield 23	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:b	Z
    //   87: return
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 392	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:c	(Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableProxy$LoaderCallback;)V
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 23	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:b	Z
    //   101: return
    //   102: astore_1
    //   103: ldc 2
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: iconst_0
    //   111: putfield 23	com/tencent/mobileqq/vas/gldrawable/GLDrawableLoaderImpl:b	Z
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	GLDrawableLoaderImpl
    //   0	116	1	paramLoaderCallback	GLDrawableProxy.LoaderCallback
    // Exception table:
    //   from	to	target	type
    //   55	74	102	finally
    //   74	82	102	finally
    //   88	96	102	finally
    //   103	106	102	finally
    //   13	22	108	finally
    //   22	41	108	finally
    //   41	46	108	finally
    //   52	55	108	finally
    //   106	108	108	finally
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    a(BaseApplicationImpl.getApplication(), new GLDrawableLoaderImpl.4(this));
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl
 * JD-Core Version:    0.7.0.1
 */