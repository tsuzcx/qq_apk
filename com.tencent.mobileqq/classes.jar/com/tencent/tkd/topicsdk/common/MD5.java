package com.tencent.tkd.topicsdk.common;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  /* Error */
  public static String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_3
    //   12: astore_2
    //   13: ldc 19
    //   15: invokestatic 25	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   18: astore 7
    //   20: aload_0
    //   21: ifnonnull +6 -> 27
    //   24: ldc 27
    //   26: areturn
    //   27: aload_3
    //   28: astore_2
    //   29: aload_0
    //   30: invokevirtual 33	java/io/File:exists	()Z
    //   33: ifne +6 -> 39
    //   36: ldc 27
    //   38: areturn
    //   39: aload_3
    //   40: astore_2
    //   41: new 35	java/io/RandomAccessFile
    //   44: dup
    //   45: aload_0
    //   46: ldc 37
    //   48: invokespecial 40	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore_0
    //   52: ldc 41
    //   54: newarray byte
    //   56: astore_2
    //   57: aload_0
    //   58: aload_2
    //   59: invokevirtual 45	java/io/RandomAccessFile:read	([B)I
    //   62: istore_1
    //   63: iload_1
    //   64: iconst_m1
    //   65: if_icmpeq +14 -> 79
    //   68: aload 7
    //   70: aload_2
    //   71: iconst_0
    //   72: iload_1
    //   73: invokevirtual 49	java/security/MessageDigest:update	([BII)V
    //   76: goto -19 -> 57
    //   79: new 51	java/math/BigInteger
    //   82: dup
    //   83: iconst_1
    //   84: aload 7
    //   86: invokevirtual 55	java/security/MessageDigest:digest	()[B
    //   89: invokespecial 58	java/math/BigInteger:<init>	(I[B)V
    //   92: bipush 16
    //   94: invokevirtual 62	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   97: astore_2
    //   98: aload_2
    //   99: invokevirtual 68	java/lang/String:length	()I
    //   102: bipush 32
    //   104: if_icmpge +32 -> 136
    //   107: new 70	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   114: astore_3
    //   115: aload_3
    //   116: ldc 73
    //   118: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_3
    //   123: aload_2
    //   124: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_3
    //   129: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore_2
    //   133: goto -35 -> 98
    //   136: aload_0
    //   137: invokevirtual 83	java/io/RandomAccessFile:close	()V
    //   140: aload_2
    //   141: areturn
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   147: aload_2
    //   148: areturn
    //   149: astore_2
    //   150: goto +94 -> 244
    //   153: astore_3
    //   154: goto +23 -> 177
    //   157: astore_3
    //   158: goto +40 -> 198
    //   161: astore_3
    //   162: goto +57 -> 219
    //   165: astore_3
    //   166: aload_2
    //   167: astore_0
    //   168: aload_3
    //   169: astore_2
    //   170: goto +74 -> 244
    //   173: astore_3
    //   174: aload 4
    //   176: astore_0
    //   177: aload_0
    //   178: astore_2
    //   179: aload_3
    //   180: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   183: aload_0
    //   184: ifnull +57 -> 241
    //   187: aload_0
    //   188: invokevirtual 83	java/io/RandomAccessFile:close	()V
    //   191: ldc 27
    //   193: areturn
    //   194: astore_3
    //   195: aload 5
    //   197: astore_0
    //   198: aload_0
    //   199: astore_2
    //   200: aload_3
    //   201: invokevirtual 87	java/io/FileNotFoundException:printStackTrace	()V
    //   204: aload_0
    //   205: ifnull +36 -> 241
    //   208: aload_0
    //   209: invokevirtual 83	java/io/RandomAccessFile:close	()V
    //   212: ldc 27
    //   214: areturn
    //   215: astore_3
    //   216: aload 6
    //   218: astore_0
    //   219: aload_0
    //   220: astore_2
    //   221: aload_3
    //   222: invokevirtual 88	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   225: aload_0
    //   226: ifnull +15 -> 241
    //   229: aload_0
    //   230: invokevirtual 83	java/io/RandomAccessFile:close	()V
    //   233: ldc 27
    //   235: areturn
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   241: ldc 27
    //   243: areturn
    //   244: aload_0
    //   245: ifnull +15 -> 260
    //   248: aload_0
    //   249: invokevirtual 83	java/io/RandomAccessFile:close	()V
    //   252: goto +8 -> 260
    //   255: astore_0
    //   256: aload_0
    //   257: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   260: goto +5 -> 265
    //   263: aload_2
    //   264: athrow
    //   265: goto -2 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	paramFile	java.io.File
    //   62	11	1	i	int
    //   12	136	2	localObject1	Object
    //   149	18	2	localObject2	Object
    //   169	95	2	localObject3	Object
    //   10	119	3	localStringBuilder	StringBuilder
    //   153	1	3	localIOException1	java.io.IOException
    //   157	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   161	1	3	localNoSuchAlgorithmException1	NoSuchAlgorithmException
    //   165	4	3	localObject4	Object
    //   173	7	3	localIOException2	java.io.IOException
    //   194	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   215	7	3	localNoSuchAlgorithmException2	NoSuchAlgorithmException
    //   1	174	4	localObject5	Object
    //   4	192	5	localObject6	Object
    //   7	210	6	localObject7	Object
    //   18	67	7	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   136	140	142	java/io/IOException
    //   52	57	149	finally
    //   57	63	149	finally
    //   68	76	149	finally
    //   79	98	149	finally
    //   98	133	149	finally
    //   52	57	153	java/io/IOException
    //   57	63	153	java/io/IOException
    //   68	76	153	java/io/IOException
    //   79	98	153	java/io/IOException
    //   98	133	153	java/io/IOException
    //   52	57	157	java/io/FileNotFoundException
    //   57	63	157	java/io/FileNotFoundException
    //   68	76	157	java/io/FileNotFoundException
    //   79	98	157	java/io/FileNotFoundException
    //   98	133	157	java/io/FileNotFoundException
    //   52	57	161	java/security/NoSuchAlgorithmException
    //   57	63	161	java/security/NoSuchAlgorithmException
    //   68	76	161	java/security/NoSuchAlgorithmException
    //   79	98	161	java/security/NoSuchAlgorithmException
    //   98	133	161	java/security/NoSuchAlgorithmException
    //   13	20	165	finally
    //   29	36	165	finally
    //   41	52	165	finally
    //   179	183	165	finally
    //   200	204	165	finally
    //   221	225	165	finally
    //   13	20	173	java/io/IOException
    //   29	36	173	java/io/IOException
    //   41	52	173	java/io/IOException
    //   13	20	194	java/io/FileNotFoundException
    //   29	36	194	java/io/FileNotFoundException
    //   41	52	194	java/io/FileNotFoundException
    //   13	20	215	java/security/NoSuchAlgorithmException
    //   29	36	215	java/security/NoSuchAlgorithmException
    //   41	52	215	java/security/NoSuchAlgorithmException
    //   187	191	236	java/io/IOException
    //   208	212	236	java/io/IOException
    //   229	233	236	java/io/IOException
    //   248	252	255	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      int j = arrayOfByte.length;
      int i = 0;
      paramString = "";
      while (i < j)
      {
        Object localObject2 = Integer.toHexString(arrayOfByte[i] & 0xFF);
        Object localObject1 = localObject2;
        if (((String)localObject2).length() == 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("0");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append((String)localObject1);
        paramString = ((StringBuilder)localObject2).toString();
        i += 1;
      }
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.MD5
 * JD-Core Version:    0.7.0.1
 */