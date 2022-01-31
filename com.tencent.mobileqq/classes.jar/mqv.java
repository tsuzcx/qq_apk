import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;

public class mqv
{
  private static volatile DexClassLoader a;
  
  public static DexClassLoader a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = a(BaseApplicationImpl.getContext(), "libqav_utils.so");
      }
      return a;
    }
    finally {}
  }
  
  public static DexClassLoader a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    File localFile;
    do
    {
      return null;
      paramString = a(paramContext, paramString);
      localFile = paramContext.getDir("temp", 0);
    } while (TextUtils.isEmpty(paramString));
    try
    {
      paramContext = new DexClassLoader(paramString, localFile.getAbsolutePath(), null, paramContext.getClassLoader());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClassLoaderUtil", 2, "", paramContext);
        }
        paramContext = null;
      }
    }
  }
  
  public static Object a(DexClassLoader paramDexClassLoader, Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString)) && (paramObject != null)) {
      try
      {
        paramDexClassLoader = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
        paramDexClassLoader.setAccessible(true);
        paramDexClassLoader = paramDexClassLoader.invoke(paramObject, paramArrayOfObject);
        return paramDexClassLoader;
      }
      catch (Exception paramDexClassLoader)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ClassLoaderUtil", 1, "invokeMethodInDex, Exception, methodName[" + paramString + "]", paramDexClassLoader);
        }
      }
    }
    return null;
  }
  
  public static Object a(DexClassLoader paramDexClassLoader, String paramString)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        paramDexClassLoader = paramDexClassLoader.loadClass(paramString).newInstance();
        return paramDexClassLoader;
      }
      catch (Exception paramDexClassLoader)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClassLoaderUtil", 2, "", paramDexClassLoader);
        }
      }
    }
    return null;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 96	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: invokevirtual 126	android/content/Context:getFilesDir	()Ljava/io/File;
    //   17: invokevirtual 129	java/io/File:getParent	()Ljava/lang/String;
    //   20: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 131
    //   25: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 6
    //   37: aload_0
    //   38: invokevirtual 126	android/content/Context:getFilesDir	()Ljava/io/File;
    //   41: invokevirtual 52	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   44: astore_0
    //   45: new 96	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   52: aload_0
    //   53: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: getstatic 135	java/io/File:separator	Ljava/lang/String;
    //   59: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore_3
    //   70: new 48	java/io/File
    //   73: dup
    //   74: aload_3
    //   75: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 141	java/io/File:exists	()Z
    //   83: ifeq +8 -> 91
    //   86: aload_0
    //   87: invokevirtual 144	java/io/File:delete	()Z
    //   90: pop
    //   91: new 146	java/io/BufferedInputStream
    //   94: dup
    //   95: new 148	java/io/FileInputStream
    //   98: dup
    //   99: new 48	java/io/File
    //   102: dup
    //   103: aload 6
    //   105: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: invokespecial 151	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   111: invokespecial 154	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   114: astore_1
    //   115: aload_0
    //   116: invokevirtual 157	java/io/File:createNewFile	()Z
    //   119: pop
    //   120: new 159	java/io/BufferedOutputStream
    //   123: dup
    //   124: new 161	java/io/FileOutputStream
    //   127: dup
    //   128: aload_0
    //   129: invokespecial 162	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: invokespecial 165	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   135: astore_0
    //   136: sipush 1024
    //   139: newarray byte
    //   141: astore 4
    //   143: aload_1
    //   144: aload 4
    //   146: iconst_0
    //   147: aload 4
    //   149: arraylength
    //   150: invokevirtual 169	java/io/BufferedInputStream:read	([BII)I
    //   153: istore_2
    //   154: iload_2
    //   155: iconst_m1
    //   156: if_icmpeq +63 -> 219
    //   159: aload_0
    //   160: aload 4
    //   162: iconst_0
    //   163: iload_2
    //   164: invokevirtual 173	java/io/BufferedOutputStream:write	([BII)V
    //   167: goto -24 -> 143
    //   170: astore 5
    //   172: aload_0
    //   173: astore 4
    //   175: aload_1
    //   176: astore_0
    //   177: aload 5
    //   179: astore_1
    //   180: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +12 -> 195
    //   186: ldc 67
    //   188: iconst_2
    //   189: ldc 69
    //   191: aload_1
    //   192: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   195: aload_0
    //   196: ifnull +7 -> 203
    //   199: aload_0
    //   200: invokevirtual 176	java/io/BufferedInputStream:close	()V
    //   203: aload_3
    //   204: astore_1
    //   205: aload 4
    //   207: ifnull +10 -> 217
    //   210: aload 4
    //   212: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   215: aload_3
    //   216: astore_1
    //   217: aload_1
    //   218: areturn
    //   219: aload_1
    //   220: ifnull +7 -> 227
    //   223: aload_1
    //   224: invokevirtual 176	java/io/BufferedInputStream:close	()V
    //   227: aload_3
    //   228: astore_1
    //   229: aload_0
    //   230: ifnull -13 -> 217
    //   233: aload_0
    //   234: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   237: aload_3
    //   238: areturn
    //   239: astore_0
    //   240: aload_3
    //   241: astore_1
    //   242: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq -28 -> 217
    //   248: ldc 67
    //   250: iconst_2
    //   251: ldc 69
    //   253: aload_0
    //   254: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   257: aload_3
    //   258: areturn
    //   259: astore_1
    //   260: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq -36 -> 227
    //   266: ldc 67
    //   268: iconst_2
    //   269: ldc 69
    //   271: aload_1
    //   272: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   275: goto -48 -> 227
    //   278: astore_0
    //   279: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq -79 -> 203
    //   285: ldc 67
    //   287: iconst_2
    //   288: ldc 69
    //   290: aload_0
    //   291: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   294: goto -91 -> 203
    //   297: astore_0
    //   298: aload_3
    //   299: astore_1
    //   300: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -86 -> 217
    //   306: ldc 67
    //   308: iconst_2
    //   309: ldc 69
    //   311: aload_0
    //   312: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   315: aload_3
    //   316: areturn
    //   317: astore_0
    //   318: aconst_null
    //   319: astore_1
    //   320: aload 5
    //   322: astore 4
    //   324: aload_1
    //   325: ifnull +7 -> 332
    //   328: aload_1
    //   329: invokevirtual 176	java/io/BufferedInputStream:close	()V
    //   332: aload 4
    //   334: ifnull +8 -> 342
    //   337: aload 4
    //   339: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   342: aload_0
    //   343: athrow
    //   344: astore_1
    //   345: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq -16 -> 332
    //   351: ldc 67
    //   353: iconst_2
    //   354: ldc 69
    //   356: aload_1
    //   357: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   360: goto -28 -> 332
    //   363: astore_1
    //   364: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq -25 -> 342
    //   370: ldc 67
    //   372: iconst_2
    //   373: ldc 69
    //   375: aload_1
    //   376: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   379: goto -37 -> 342
    //   382: astore_0
    //   383: aload 5
    //   385: astore 4
    //   387: goto -63 -> 324
    //   390: astore_3
    //   391: aload_0
    //   392: astore 4
    //   394: aload_3
    //   395: astore_0
    //   396: goto -72 -> 324
    //   399: astore_3
    //   400: aload_0
    //   401: astore_1
    //   402: aload_3
    //   403: astore_0
    //   404: goto -80 -> 324
    //   407: astore_1
    //   408: aconst_null
    //   409: astore_0
    //   410: aconst_null
    //   411: astore_3
    //   412: goto -232 -> 180
    //   415: astore_1
    //   416: aconst_null
    //   417: astore_0
    //   418: goto -238 -> 180
    //   421: astore 5
    //   423: aload_1
    //   424: astore_0
    //   425: aload 5
    //   427: astore_1
    //   428: goto -248 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	paramContext	Context
    //   0	431	1	paramString	String
    //   153	11	2	i	int
    //   69	247	3	str1	String
    //   390	5	3	localObject1	Object
    //   399	4	3	localObject2	Object
    //   411	1	3	localObject3	Object
    //   4	389	4	localObject4	Object
    //   1	1	5	localObject5	Object
    //   170	214	5	localException1	Exception
    //   421	5	5	localException2	Exception
    //   35	69	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   136	143	170	java/lang/Exception
    //   143	154	170	java/lang/Exception
    //   159	167	170	java/lang/Exception
    //   233	237	239	java/io/IOException
    //   223	227	259	java/io/IOException
    //   199	203	278	java/io/IOException
    //   210	215	297	java/io/IOException
    //   6	70	317	finally
    //   70	91	317	finally
    //   91	115	317	finally
    //   328	332	344	java/io/IOException
    //   337	342	363	java/io/IOException
    //   115	136	382	finally
    //   136	143	390	finally
    //   143	154	390	finally
    //   159	167	390	finally
    //   180	195	399	finally
    //   6	70	407	java/lang/Exception
    //   70	91	415	java/lang/Exception
    //   91	115	415	java/lang/Exception
    //   115	136	421	java/lang/Exception
  }
  
  public static boolean a(DexClassLoader paramDexClassLoader, Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString)) && (paramObject != null))
    {
      paramDexClassLoader = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
      paramDexClassLoader.setAccessible(true);
      paramArrayOfObject2[0] = paramDexClassLoader.invoke(paramObject, paramArrayOfObject1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mqv
 * JD-Core Version:    0.7.0.1
 */