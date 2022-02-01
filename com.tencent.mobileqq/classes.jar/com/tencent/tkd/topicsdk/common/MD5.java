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
    //   1: astore_3
    //   2: ldc 19
    //   4: invokestatic 25	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   7: astore 4
    //   9: aload_0
    //   10: ifnonnull +28 -> 38
    //   13: ldc 27
    //   15: astore_2
    //   16: iconst_0
    //   17: ifeq +11 -> 28
    //   20: new 29	java/lang/NullPointerException
    //   23: dup
    //   24: invokespecial 30	java/lang/NullPointerException:<init>	()V
    //   27: athrow
    //   28: aload_2
    //   29: areturn
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 33	java/io/IOException:printStackTrace	()V
    //   35: ldc 27
    //   37: areturn
    //   38: aload_0
    //   39: invokevirtual 39	java/io/File:exists	()Z
    //   42: ifne +26 -> 68
    //   45: ldc 27
    //   47: astore_2
    //   48: iconst_0
    //   49: ifeq -21 -> 28
    //   52: new 29	java/lang/NullPointerException
    //   55: dup
    //   56: invokespecial 30	java/lang/NullPointerException:<init>	()V
    //   59: athrow
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 33	java/io/IOException:printStackTrace	()V
    //   65: ldc 27
    //   67: areturn
    //   68: new 41	java/io/RandomAccessFile
    //   71: dup
    //   72: aload_0
    //   73: ldc 43
    //   75: invokespecial 46	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   78: astore_0
    //   79: aload_0
    //   80: astore_2
    //   81: ldc 47
    //   83: newarray byte
    //   85: astore_3
    //   86: aload_0
    //   87: astore_2
    //   88: aload_0
    //   89: aload_3
    //   90: invokevirtual 51	java/io/RandomAccessFile:read	([B)I
    //   93: istore_1
    //   94: iload_1
    //   95: iconst_m1
    //   96: if_icmpeq +32 -> 128
    //   99: aload_0
    //   100: astore_2
    //   101: aload 4
    //   103: aload_3
    //   104: iconst_0
    //   105: iload_1
    //   106: invokevirtual 55	java/security/MessageDigest:update	([BII)V
    //   109: goto -23 -> 86
    //   112: astore_2
    //   113: aload_2
    //   114: invokevirtual 56	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   117: aload_0
    //   118: ifnull +7 -> 125
    //   121: aload_0
    //   122: invokevirtual 59	java/io/RandomAccessFile:close	()V
    //   125: ldc 27
    //   127: areturn
    //   128: aload_0
    //   129: astore_2
    //   130: new 61	java/math/BigInteger
    //   133: dup
    //   134: iconst_1
    //   135: aload 4
    //   137: invokevirtual 65	java/security/MessageDigest:digest	()[B
    //   140: invokespecial 68	java/math/BigInteger:<init>	(I[B)V
    //   143: bipush 16
    //   145: invokevirtual 72	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   148: astore_3
    //   149: aload_0
    //   150: astore_2
    //   151: aload_3
    //   152: invokevirtual 78	java/lang/String:length	()I
    //   155: bipush 32
    //   157: if_icmpge +28 -> 185
    //   160: aload_0
    //   161: astore_2
    //   162: new 80	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   169: ldc 83
    //   171: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_3
    //   175: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: astore_3
    //   182: goto -33 -> 149
    //   185: aload_3
    //   186: astore_2
    //   187: aload_0
    //   188: ifnull -160 -> 28
    //   191: aload_0
    //   192: invokevirtual 59	java/io/RandomAccessFile:close	()V
    //   195: aload_3
    //   196: areturn
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 33	java/io/IOException:printStackTrace	()V
    //   202: aload_3
    //   203: areturn
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 33	java/io/IOException:printStackTrace	()V
    //   209: goto -84 -> 125
    //   212: astore_3
    //   213: aconst_null
    //   214: astore_0
    //   215: aload_0
    //   216: astore_2
    //   217: aload_3
    //   218: invokevirtual 91	java/io/FileNotFoundException:printStackTrace	()V
    //   221: aload_0
    //   222: ifnull -97 -> 125
    //   225: aload_0
    //   226: invokevirtual 59	java/io/RandomAccessFile:close	()V
    //   229: goto -104 -> 125
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual 33	java/io/IOException:printStackTrace	()V
    //   237: goto -112 -> 125
    //   240: astore_3
    //   241: aconst_null
    //   242: astore_0
    //   243: aload_0
    //   244: astore_2
    //   245: aload_3
    //   246: invokevirtual 33	java/io/IOException:printStackTrace	()V
    //   249: aload_0
    //   250: ifnull -125 -> 125
    //   253: aload_0
    //   254: invokevirtual 59	java/io/RandomAccessFile:close	()V
    //   257: goto -132 -> 125
    //   260: astore_0
    //   261: aload_0
    //   262: invokevirtual 33	java/io/IOException:printStackTrace	()V
    //   265: goto -140 -> 125
    //   268: astore_0
    //   269: aconst_null
    //   270: astore_2
    //   271: aload_2
    //   272: ifnull +7 -> 279
    //   275: aload_2
    //   276: invokevirtual 59	java/io/RandomAccessFile:close	()V
    //   279: aload_0
    //   280: athrow
    //   281: astore_2
    //   282: aload_2
    //   283: invokevirtual 33	java/io/IOException:printStackTrace	()V
    //   286: goto -7 -> 279
    //   289: astore_0
    //   290: goto -19 -> 271
    //   293: astore_3
    //   294: aload_0
    //   295: astore_2
    //   296: aload_3
    //   297: astore_0
    //   298: goto -27 -> 271
    //   301: astore_3
    //   302: goto -59 -> 243
    //   305: astore_3
    //   306: goto -91 -> 215
    //   309: astore_2
    //   310: aload_3
    //   311: astore_0
    //   312: goto -199 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	paramFile	java.io.File
    //   93	13	1	i	int
    //   15	86	2	localObject1	Object
    //   112	2	2	localNoSuchAlgorithmException1	NoSuchAlgorithmException
    //   129	147	2	localObject2	Object
    //   281	2	2	localIOException1	java.io.IOException
    //   295	1	2	localFile	java.io.File
    //   309	1	2	localNoSuchAlgorithmException2	NoSuchAlgorithmException
    //   1	202	3	localObject3	Object
    //   212	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   240	6	3	localIOException2	java.io.IOException
    //   293	4	3	localObject4	Object
    //   301	1	3	localIOException3	java.io.IOException
    //   305	6	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   7	129	4	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   20	28	30	java/io/IOException
    //   52	60	60	java/io/IOException
    //   81	86	112	java/security/NoSuchAlgorithmException
    //   88	94	112	java/security/NoSuchAlgorithmException
    //   101	109	112	java/security/NoSuchAlgorithmException
    //   130	149	112	java/security/NoSuchAlgorithmException
    //   151	160	112	java/security/NoSuchAlgorithmException
    //   162	182	112	java/security/NoSuchAlgorithmException
    //   191	195	197	java/io/IOException
    //   121	125	204	java/io/IOException
    //   2	9	212	java/io/FileNotFoundException
    //   38	45	212	java/io/FileNotFoundException
    //   68	79	212	java/io/FileNotFoundException
    //   225	229	232	java/io/IOException
    //   2	9	240	java/io/IOException
    //   38	45	240	java/io/IOException
    //   68	79	240	java/io/IOException
    //   253	257	260	java/io/IOException
    //   2	9	268	finally
    //   38	45	268	finally
    //   68	79	268	finally
    //   275	279	281	java/io/IOException
    //   81	86	289	finally
    //   88	94	289	finally
    //   101	109	289	finally
    //   130	149	289	finally
    //   151	160	289	finally
    //   162	182	289	finally
    //   217	221	289	finally
    //   245	249	289	finally
    //   113	117	293	finally
    //   81	86	301	java/io/IOException
    //   88	94	301	java/io/IOException
    //   101	109	301	java/io/IOException
    //   130	149	301	java/io/IOException
    //   151	160	301	java/io/IOException
    //   162	182	301	java/io/IOException
    //   81	86	305	java/io/FileNotFoundException
    //   88	94	305	java/io/FileNotFoundException
    //   101	109	305	java/io/FileNotFoundException
    //   130	149	305	java/io/FileNotFoundException
    //   151	160	305	java/io/FileNotFoundException
    //   162	182	305	java/io/FileNotFoundException
    //   2	9	309	java/security/NoSuchAlgorithmException
    //   38	45	309	java/security/NoSuchAlgorithmException
    //   68	79	309	java/security/NoSuchAlgorithmException
  }
  
  public static String a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    for (;;)
    {
      return localObject;
      try
      {
        byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
        int j = arrayOfByte.length;
        int i = 0;
        paramString = "";
        for (;;)
        {
          localObject = paramString;
          if (i >= j) {
            break;
          }
          String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
          localObject = str;
          if (str.length() == 1) {
            localObject = "0" + str;
          }
          paramString = paramString + (String)localObject;
          i += 1;
        }
        return "";
      }
      catch (NoSuchAlgorithmException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.MD5
 * JD-Core Version:    0.7.0.1
 */