package com.tencent.mobileqq.utils;

public class WupUtil
{
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 15	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_4
    //   7: iadd
    //   8: invokespecial 18	java/io/ByteArrayOutputStream:<init>	(I)V
    //   11: astore_1
    //   12: new 20	java/io/DataOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 23	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_2
    //   21: aload_2
    //   22: aload_0
    //   23: arraylength
    //   24: iconst_4
    //   25: iadd
    //   26: invokevirtual 26	java/io/DataOutputStream:writeInt	(I)V
    //   29: aload_2
    //   30: aload_0
    //   31: invokevirtual 30	java/io/DataOutputStream:write	([B)V
    //   34: aload_1
    //   35: invokevirtual 34	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: astore_0
    //   39: aload_1
    //   40: invokevirtual 37	java/io/ByteArrayOutputStream:close	()V
    //   43: aload_2
    //   44: invokevirtual 38	java/io/DataOutputStream:close	()V
    //   47: aload_0
    //   48: areturn
    //   49: astore_0
    //   50: goto +18 -> 68
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 41	java/lang/Exception:printStackTrace	()V
    //   58: aload_1
    //   59: invokevirtual 37	java/io/ByteArrayOutputStream:close	()V
    //   62: aload_2
    //   63: invokevirtual 38	java/io/DataOutputStream:close	()V
    //   66: aconst_null
    //   67: areturn
    //   68: aload_1
    //   69: invokevirtual 37	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_2
    //   73: invokevirtual 38	java/io/DataOutputStream:close	()V
    //   76: aload_0
    //   77: athrow
    //   78: astore_1
    //   79: aload_0
    //   80: areturn
    //   81: astore_0
    //   82: goto -16 -> 66
    //   85: astore_1
    //   86: goto -10 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramArrayOfByte	byte[]
    //   11	58	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   78	1	1	localException1	java.lang.Exception
    //   85	1	1	localException2	java.lang.Exception
    //   20	53	2	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   21	39	49	finally
    //   54	58	49	finally
    //   21	39	53	java/lang/Exception
    //   39	47	78	java/lang/Exception
    //   58	66	81	java/lang/Exception
    //   68	76	85	java/lang/Exception
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 44	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 46	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_2
    //   9: new 48	java/io/DataInputStream
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 51	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_3
    //   18: aconst_null
    //   19: astore_0
    //   20: aload_3
    //   21: invokevirtual 55	java/io/DataInputStream:readInt	()I
    //   24: iconst_4
    //   25: isub
    //   26: newarray byte
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 59	java/io/DataInputStream:read	([B)I
    //   36: pop
    //   37: aload_2
    //   38: invokevirtual 60	java/io/ByteArrayInputStream:close	()V
    //   41: aload_3
    //   42: invokevirtual 61	java/io/DataInputStream:close	()V
    //   45: aload_1
    //   46: areturn
    //   47: astore_0
    //   48: goto +18 -> 66
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 41	java/lang/Exception:printStackTrace	()V
    //   56: aload_2
    //   57: invokevirtual 60	java/io/ByteArrayInputStream:close	()V
    //   60: aload_3
    //   61: invokevirtual 61	java/io/DataInputStream:close	()V
    //   64: aload_0
    //   65: areturn
    //   66: aload_2
    //   67: invokevirtual 60	java/io/ByteArrayInputStream:close	()V
    //   70: aload_3
    //   71: invokevirtual 61	java/io/DataInputStream:close	()V
    //   74: aload_0
    //   75: athrow
    //   76: astore_0
    //   77: aload_1
    //   78: areturn
    //   79: astore_1
    //   80: aload_0
    //   81: areturn
    //   82: astore_1
    //   83: goto -9 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramArrayOfByte	byte[]
    //   28	18	1	arrayOfByte	byte[]
    //   51	27	1	localException1	java.lang.Exception
    //   79	1	1	localException2	java.lang.Exception
    //   82	1	1	localException3	java.lang.Exception
    //   8	59	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   17	54	3	localDataInputStream	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   20	29	47	finally
    //   31	37	47	finally
    //   52	56	47	finally
    //   20	29	51	java/lang/Exception
    //   31	37	51	java/lang/Exception
    //   37	45	76	java/lang/Exception
    //   56	64	79	java/lang/Exception
    //   66	74	82	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.WupUtil
 * JD-Core Version:    0.7.0.1
 */