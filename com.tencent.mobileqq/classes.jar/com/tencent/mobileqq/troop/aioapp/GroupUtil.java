package com.tencent.mobileqq.troop.aioapp;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;

public final class GroupUtil
{
  public static long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  /* Error */
  @android.support.annotation.Nullable
  public static Object a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 29	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 32	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_3
    //   15: new 34	java/io/ObjectInputStream
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 37	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 41	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   30: astore_2
    //   31: aload_1
    //   32: invokestatic 44	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/Closeable;)V
    //   35: aload_3
    //   36: invokestatic 44	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/Closeable;)V
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_1
    //   45: astore_0
    //   46: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +14 -> 63
    //   52: aload_1
    //   53: astore_0
    //   54: ldc 52
    //   56: iconst_2
    //   57: ldc 54
    //   59: aload_2
    //   60: invokestatic 58	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   63: aload_1
    //   64: invokestatic 44	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/Closeable;)V
    //   67: aload_3
    //   68: invokestatic 44	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/Closeable;)V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_2
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: astore_0
    //   78: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +14 -> 95
    //   84: aload_1
    //   85: astore_0
    //   86: ldc 52
    //   88: iconst_2
    //   89: ldc 54
    //   91: aload_2
    //   92: invokestatic 58	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_1
    //   96: invokestatic 44	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/Closeable;)V
    //   99: aload_3
    //   100: invokestatic 44	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/Closeable;)V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_2
    //   108: aload_0
    //   109: astore_1
    //   110: aload_2
    //   111: invokestatic 44	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/Closeable;)V
    //   114: aload_3
    //   115: invokestatic 44	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/Closeable;)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: aload_0
    //   122: astore_2
    //   123: goto -13 -> 110
    //   126: astore_2
    //   127: goto -51 -> 76
    //   130: astore_2
    //   131: goto -87 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramArrayOfByte	byte[]
    //   23	96	1	localObject1	Object
    //   120	1	1	localObject2	Object
    //   30	10	2	localObject3	Object
    //   41	19	2	localIOException1	IOException
    //   73	19	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   107	16	2	localObject4	Object
    //   126	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   130	1	2	localIOException2	IOException
    //   14	101	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   15	24	41	java/io/IOException
    //   15	24	73	java/lang/ClassNotFoundException
    //   15	24	105	finally
    //   26	31	120	finally
    //   46	52	120	finally
    //   54	63	120	finally
    //   78	84	120	finally
    //   86	95	120	finally
    //   26	31	126	java/lang/ClassNotFoundException
    //   26	31	130	java/io/IOException
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  public static void a(ObjectOutputStream paramObjectOutputStream)
  {
    if (paramObjectOutputStream != null) {}
    try
    {
      paramObjectOutputStream.close();
      return;
    }
    catch (IOException paramObjectOutputStream)
    {
      paramObjectOutputStream.printStackTrace();
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManagerV2.executeOnSubThread(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    new Handler(ThreadManagerV2.getSubThreadLooper()).postDelayed(paramRunnable, paramLong);
  }
  
  public static boolean a(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() <= 0);
  }
  
  /* Error */
  @android.support.annotation.Nullable
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 112	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush 1024
    //   13: invokespecial 115	java/io/ByteArrayOutputStream:<init>	(I)V
    //   16: astore 4
    //   18: new 68	java/io/ObjectOutputStream
    //   21: dup
    //   22: aload 4
    //   24: invokespecial 118	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: aload_0
    //   32: invokevirtual 122	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   35: aload_2
    //   36: astore_1
    //   37: aload_2
    //   38: invokevirtual 125	java/io/ObjectOutputStream:flush	()V
    //   41: aload_2
    //   42: astore_1
    //   43: aload 4
    //   45: invokevirtual 129	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: astore_0
    //   49: aload_2
    //   50: invokestatic 131	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/ObjectOutputStream;)V
    //   53: aload 4
    //   55: invokestatic 44	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/Closeable;)V
    //   58: aload_0
    //   59: areturn
    //   60: astore_3
    //   61: aconst_null
    //   62: astore_0
    //   63: aload_0
    //   64: astore_1
    //   65: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +14 -> 82
    //   71: aload_0
    //   72: astore_1
    //   73: ldc 52
    //   75: iconst_2
    //   76: ldc 133
    //   78: aload_3
    //   79: invokestatic 58	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_0
    //   83: invokestatic 131	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/ObjectOutputStream;)V
    //   86: aload 4
    //   88: invokestatic 44	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/Closeable;)V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: invokestatic 131	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/ObjectOutputStream;)V
    //   100: aload 4
    //   102: invokestatic 44	com/tencent/mobileqq/troop/aioapp/GroupUtil:a	(Ljava/io/Closeable;)V
    //   105: aload_0
    //   106: athrow
    //   107: astore_0
    //   108: goto -12 -> 96
    //   111: astore_3
    //   112: aload_2
    //   113: astore_0
    //   114: goto -51 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramObject	Object
    //   29	68	1	localObject	Object
    //   27	86	2	localObjectOutputStream	ObjectOutputStream
    //   60	19	3	localIOException1	IOException
    //   111	1	3	localIOException2	IOException
    //   16	85	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   18	28	60	java/io/IOException
    //   18	28	93	finally
    //   30	35	107	finally
    //   37	41	107	finally
    //   43	49	107	finally
    //   65	71	107	finally
    //   73	82	107	finally
    //   30	35	111	java/io/IOException
    //   37	41	111	java/io/IOException
    //   43	49	111	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.GroupUtil
 * JD-Core Version:    0.7.0.1
 */