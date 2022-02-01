package com.tencent.mobileqq.troop.troopapps;

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
    //   14: astore 4
    //   16: new 34	java/io/ObjectInputStream
    //   19: dup
    //   20: aload 4
    //   22: invokespecial 37	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: aload_1
    //   29: invokevirtual 41	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_2
    //   33: aload_1
    //   34: invokestatic 44	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/Closeable;)V
    //   37: aload 4
    //   39: invokestatic 44	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/Closeable;)V
    //   42: aload_2
    //   43: areturn
    //   44: astore_3
    //   45: goto +16 -> 61
    //   48: astore_3
    //   49: goto +38 -> 87
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_0
    //   55: goto +67 -> 122
    //   58: astore_3
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_1
    //   62: astore_2
    //   63: aload_1
    //   64: astore_0
    //   65: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +42 -> 110
    //   71: aload_1
    //   72: astore_0
    //   73: ldc 52
    //   75: iconst_2
    //   76: ldc 54
    //   78: aload_3
    //   79: invokestatic 58	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_1
    //   83: astore_2
    //   84: goto +26 -> 110
    //   87: aload_1
    //   88: astore_2
    //   89: aload_1
    //   90: astore_0
    //   91: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +16 -> 110
    //   97: aload_1
    //   98: astore_0
    //   99: ldc 52
    //   101: iconst_2
    //   102: ldc 54
    //   104: aload_3
    //   105: invokestatic 58	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_1
    //   109: astore_2
    //   110: aload_2
    //   111: invokestatic 44	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/Closeable;)V
    //   114: aload 4
    //   116: invokestatic 44	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/Closeable;)V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_1
    //   122: aload_0
    //   123: invokestatic 44	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/Closeable;)V
    //   126: aload 4
    //   128: invokestatic 44	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/Closeable;)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_3
    //   134: aconst_null
    //   135: astore_1
    //   136: goto -49 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramArrayOfByte	byte[]
    //   25	9	1	localObjectInputStream	java.io.ObjectInputStream
    //   52	1	1	localObject1	Object
    //   60	49	1	localObject2	Object
    //   121	11	1	localObject3	Object
    //   135	1	1	localObject4	Object
    //   32	79	2	localObject5	Object
    //   44	1	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   48	1	3	localIOException1	IOException
    //   58	47	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   133	1	3	localIOException2	IOException
    //   14	113	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   28	33	44	java/lang/ClassNotFoundException
    //   28	33	48	java/io/IOException
    //   16	26	52	finally
    //   16	26	58	java/lang/ClassNotFoundException
    //   28	33	121	finally
    //   65	71	121	finally
    //   73	82	121	finally
    //   91	97	121	finally
    //   99	108	121	finally
    //   16	26	133	java/io/IOException
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
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
  }
  
  public static void a(ObjectOutputStream paramObjectOutputStream)
  {
    if (paramObjectOutputStream != null) {
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
    //   16: astore_3
    //   17: new 68	java/io/ObjectOutputStream
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 118	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: aload_0
    //   30: invokevirtual 122	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 125	java/io/ObjectOutputStream:flush	()V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_3
    //   42: invokevirtual 129	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   45: astore_0
    //   46: aload_2
    //   47: invokestatic 131	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/ObjectOutputStream;)V
    //   50: aload_3
    //   51: invokestatic 44	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/Closeable;)V
    //   54: aload_0
    //   55: areturn
    //   56: astore_1
    //   57: aload_2
    //   58: astore_0
    //   59: aload_1
    //   60: astore_2
    //   61: goto +12 -> 73
    //   64: astore_0
    //   65: aconst_null
    //   66: astore_1
    //   67: goto +36 -> 103
    //   70: astore_2
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: astore_1
    //   75: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +14 -> 92
    //   81: aload_0
    //   82: astore_1
    //   83: ldc 52
    //   85: iconst_2
    //   86: ldc 133
    //   88: aload_2
    //   89: invokestatic 58	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: invokestatic 131	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/ObjectOutputStream;)V
    //   96: aload_3
    //   97: invokestatic 44	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/Closeable;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: aload_1
    //   104: invokestatic 131	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/ObjectOutputStream;)V
    //   107: aload_3
    //   108: invokestatic 44	com/tencent/mobileqq/troop/troopapps/GroupUtil:a	(Ljava/io/Closeable;)V
    //   111: aload_0
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramObject	Object
    //   27	14	1	localObject1	Object
    //   56	4	1	localIOException1	IOException
    //   66	38	1	localObject2	Object
    //   25	36	2	localObject3	Object
    //   70	19	2	localIOException2	IOException
    //   16	92	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   28	33	56	java/io/IOException
    //   35	39	56	java/io/IOException
    //   41	46	56	java/io/IOException
    //   17	26	64	finally
    //   17	26	70	java/io/IOException
    //   28	33	102	finally
    //   35	39	102	finally
    //   41	46	102	finally
    //   75	81	102	finally
    //   83	92	102	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.GroupUtil
 * JD-Core Version:    0.7.0.1
 */