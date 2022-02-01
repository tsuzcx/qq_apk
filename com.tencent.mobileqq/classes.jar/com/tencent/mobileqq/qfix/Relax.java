package com.tencent.mobileqq.qfix;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Relax
{
  public static final int APPLY_ERROR_GET_METHODS_BYTES = 4;
  public static final int APPLY_ERROR_INJECT = 5;
  public static final int APPLY_ERROR_PATCH_BOUNDARY = 3;
  public static final int APPLY_ERROR_PREPARE = 1;
  public static final int APPLY_ERROR_REMOVE_PATCH_CLASSES = 2;
  public static final int APPLY_SUCCESS = 0;
  
  static
  {
    System.currentTimeMillis();
  }
  
  private static long a(ClassLoader paramClassLoader)
  {
    if (!a()) {}
    try
    {
      Field localField = ClassLoader.class.getDeclaredField("classTable");
      localField.setAccessible(true);
      long l = localField.getLong(paramClassLoader);
      return l;
    }
    catch (Exception paramClassLoader)
    {
      label27:
      break label27;
    }
    return 0L;
  }
  
  @SuppressLint({"PrivateApi"})
  private static boolean a()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return true;
    }
    try
    {
      Class.forName("android.se.omapi.Channel");
      return true;
    }
    finally
    {
      label18:
      break label18;
    }
    return false;
  }
  
  /* Error */
  private static byte[] a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 76	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 77	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore 4
    //   11: new 79	java/io/BufferedInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 82	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_2
    //   20: aload_2
    //   21: astore_0
    //   22: sipush 4000
    //   25: newarray byte
    //   27: astore_3
    //   28: aload_2
    //   29: astore_0
    //   30: aload_2
    //   31: aload_3
    //   32: iconst_0
    //   33: aload_3
    //   34: arraylength
    //   35: invokevirtual 86	java/io/BufferedInputStream:read	([BII)I
    //   38: istore_1
    //   39: iload_1
    //   40: iconst_m1
    //   41: if_icmpeq +16 -> 57
    //   44: aload_2
    //   45: astore_0
    //   46: aload 4
    //   48: aload_3
    //   49: iconst_0
    //   50: iload_1
    //   51: invokevirtual 90	java/io/ByteArrayOutputStream:write	([BII)V
    //   54: goto -26 -> 28
    //   57: aload_2
    //   58: astore_0
    //   59: aload 4
    //   61: iconst_0
    //   62: invokevirtual 93	java/io/ByteArrayOutputStream:write	(I)V
    //   65: aload_2
    //   66: astore_0
    //   67: aload 4
    //   69: invokevirtual 97	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   72: astore_3
    //   73: aload_2
    //   74: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   77: aload_3
    //   78: areturn
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   84: aload_3
    //   85: areturn
    //   86: astore_3
    //   87: goto +12 -> 99
    //   90: astore_0
    //   91: aload_3
    //   92: astore_2
    //   93: goto +34 -> 127
    //   96: astore_3
    //   97: aconst_null
    //   98: astore_2
    //   99: aload_2
    //   100: astore_0
    //   101: aload_3
    //   102: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   105: aload_2
    //   106: ifnull +14 -> 120
    //   109: aload_2
    //   110: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_3
    //   123: aload_0
    //   124: astore_2
    //   125: aload_3
    //   126: astore_0
    //   127: aload_2
    //   128: ifnull +15 -> 143
    //   131: aload_2
    //   132: invokevirtual 100	java/io/BufferedInputStream:close	()V
    //   135: goto +8 -> 143
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   143: goto +5 -> 148
    //   146: aload_0
    //   147: athrow
    //   148: goto -2 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramInputStream	InputStream
    //   38	13	1	i	int
    //   19	113	2	localObject1	Object
    //   138	2	2	localIOException1	java.io.IOException
    //   1	84	3	arrayOfByte	byte[]
    //   86	6	3	localIOException2	java.io.IOException
    //   96	6	3	localIOException3	java.io.IOException
    //   122	4	3	localObject2	Object
    //   9	59	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   73	77	79	java/io/IOException
    //   22	28	86	java/io/IOException
    //   30	39	86	java/io/IOException
    //   46	54	86	java/io/IOException
    //   59	65	86	java/io/IOException
    //   67	73	86	java/io/IOException
    //   2	20	90	finally
    //   2	20	96	java/io/IOException
    //   109	113	115	java/io/IOException
    //   22	28	122	finally
    //   30	39	122	finally
    //   46	54	122	finally
    //   59	65	122	finally
    //   67	73	122	finally
    //   101	105	122	finally
    //   131	135	138	java/io/IOException
  }
  
  public static int apply(InputStream paramInputStream1, InputStream paramInputStream2, InputStream paramInputStream3, boolean paramBoolean1, File paramFile1, File paramFile2, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      System.loadLibrary("relax");
    }
    try
    {
      ClassLoader localClassLoader = Relax.class.getClassLoader();
      if (paramBoolean2)
      {
        paramBoolean1 = inject(localClassLoader, paramFile1, paramFile2);
        if (!paramBoolean1) {
          return 5;
        }
      }
      paramBoolean1 = b(localClassLoader);
      if (!paramBoolean1) {
        return 1;
      }
      if ((paramInputStream1 != null) && (paramInputStream2 != null))
      {
        paramBoolean1 = remove(localClassLoader, a(paramInputStream1), a(paramInputStream2));
        if (!paramBoolean1) {
          return 2;
        }
      }
      paramInputStream1 = a(paramInputStream3);
      if (paramInputStream1 == null) {
        return 4;
      }
      paramBoolean1 = relax(paramInputStream1);
      if (!paramBoolean1) {
        return 3;
      }
      return 0;
    }
    finally
    {
      release();
    }
  }
  
  private static boolean b(ClassLoader paramClassLoader)
  {
    try
    {
      Method localMethod = Relax.c.class.getDeclaredMethod("a", new Class[0]);
      boolean bool = init(localMethod, Relax.c.class.getDeclaredMethod("b", new Class[0]), paramClassLoader, a(paramClassLoader), a());
      return bool;
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      paramClassLoader.printStackTrace();
    }
    return false;
  }
  
  private static native boolean init(Method paramMethod1, Method paramMethod2, ClassLoader paramClassLoader, long paramLong, boolean paramBoolean);
  
  private static native boolean inject(ClassLoader paramClassLoader, File paramFile1, File paramFile2);
  
  private static native boolean relax(byte[] paramArrayOfByte);
  
  private static native void release();
  
  private static native boolean remove(ClassLoader paramClassLoader, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.Relax
 * JD-Core Version:    0.7.0.1
 */