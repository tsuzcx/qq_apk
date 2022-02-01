package org.apache.commons.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class SerializationUtils
{
  public static Object clone(Serializable paramSerializable)
  {
    return deserialize(serialize(paramSerializable));
  }
  
  /* Error */
  public static Object deserialize(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +88 -> 89
    //   4: aconst_null
    //   5: astore_2
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_1
    //   10: new 26	java/io/ObjectInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 29	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 33	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   23: astore_1
    //   24: aload_0
    //   25: invokevirtual 36	java/io/ObjectInputStream:close	()V
    //   28: aload_1
    //   29: areturn
    //   30: astore_2
    //   31: aload_0
    //   32: astore_1
    //   33: aload_2
    //   34: astore_0
    //   35: goto +44 -> 79
    //   38: astore_2
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: astore_0
    //   43: goto +18 -> 61
    //   46: astore_2
    //   47: aload_0
    //   48: astore_1
    //   49: aload_2
    //   50: astore_0
    //   51: goto +19 -> 70
    //   54: astore_0
    //   55: goto +24 -> 79
    //   58: astore_0
    //   59: aload_2
    //   60: astore_1
    //   61: new 38	org/apache/commons/lang/SerializationException
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 41	org/apache/commons/lang/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   69: athrow
    //   70: new 38	org/apache/commons/lang/SerializationException
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 41	org/apache/commons/lang/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 36	java/io/ObjectInputStream:close	()V
    //   87: aload_0
    //   88: athrow
    //   89: new 43	java/lang/IllegalArgumentException
    //   92: dup
    //   93: ldc 45
    //   95: invokespecial 48	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   98: athrow
    //   99: astore_0
    //   100: aload_1
    //   101: areturn
    //   102: astore_1
    //   103: goto -16 -> 87
    //   106: astore_0
    //   107: aload_3
    //   108: astore_1
    //   109: goto -39 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramInputStream	java.io.InputStream
    //   9	92	1	localObject1	Object
    //   102	1	1	localIOException1	java.io.IOException
    //   108	1	1	localObject2	Object
    //   5	1	2	localObject3	Object
    //   30	4	2	localObject4	Object
    //   38	4	2	localIOException2	java.io.IOException
    //   46	14	2	localClassNotFoundException	java.lang.ClassNotFoundException
    //   7	101	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   19	24	30	finally
    //   19	24	38	java/io/IOException
    //   19	24	46	java/lang/ClassNotFoundException
    //   10	19	54	finally
    //   61	70	54	finally
    //   70	79	54	finally
    //   10	19	58	java/io/IOException
    //   24	28	99	java/io/IOException
    //   83	87	102	java/io/IOException
    //   10	19	106	java/lang/ClassNotFoundException
  }
  
  public static Object deserialize(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return deserialize(new ByteArrayInputStream(paramArrayOfByte));
    }
    throw new IllegalArgumentException("The byte[] must not be null");
  }
  
  /* Error */
  public static void serialize(Serializable paramSerializable, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +64 -> 65
    //   4: aconst_null
    //   5: astore_3
    //   6: aconst_null
    //   7: astore_2
    //   8: new 60	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 63	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_1
    //   17: aload_1
    //   18: aload_0
    //   19: invokevirtual 67	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   22: aload_1
    //   23: invokevirtual 68	java/io/ObjectOutputStream:close	()V
    //   26: return
    //   27: astore_0
    //   28: aload_1
    //   29: astore_2
    //   30: goto +25 -> 55
    //   33: astore_0
    //   34: aload_1
    //   35: astore_2
    //   36: goto +10 -> 46
    //   39: astore_0
    //   40: goto +15 -> 55
    //   43: astore_0
    //   44: aload_3
    //   45: astore_2
    //   46: new 38	org/apache/commons/lang/SerializationException
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 41	org/apache/commons/lang/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   54: athrow
    //   55: aload_2
    //   56: ifnull +7 -> 63
    //   59: aload_2
    //   60: invokevirtual 68	java/io/ObjectOutputStream:close	()V
    //   63: aload_0
    //   64: athrow
    //   65: new 43	java/lang/IllegalArgumentException
    //   68: dup
    //   69: ldc 70
    //   71: invokespecial 48	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: astore_0
    //   76: return
    //   77: astore_1
    //   78: goto -15 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramSerializable	Serializable
    //   0	81	1	paramOutputStream	java.io.OutputStream
    //   7	53	2	localObject1	Object
    //   5	40	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	22	27	finally
    //   17	22	33	java/io/IOException
    //   8	17	39	finally
    //   46	55	39	finally
    //   8	17	43	java/io/IOException
    //   22	26	75	java/io/IOException
    //   59	63	77	java/io/IOException
  }
  
  public static byte[] serialize(Serializable paramSerializable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(512);
    serialize(paramSerializable, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.SerializationUtils
 * JD-Core Version:    0.7.0.1
 */