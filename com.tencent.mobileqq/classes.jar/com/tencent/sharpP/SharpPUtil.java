package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.util.Log;

public final class SharpPUtil
{
  private static final String SHARPP_TAG = "SHARPP";
  public static final String TAG = "SharpPUtil";
  public static final String soLibName = "libSharpPDec.so";
  
  public static Bitmap decodeSharpPByFilePath(String paramString)
  {
    SharpPDecoder localSharpPDecoder = new SharpPDecoder();
    int i = localSharpPDecoder.parseHeader(paramString);
    if (i != 0) {
      Log.d("SharpPUtil", "status: " + i);
    }
    do
    {
      return null;
      i = localSharpPDecoder.getSharpPType();
    } while ((3 == i) || (4 == i));
    try
    {
      paramString = localSharpPDecoder.decodeSharpP2PNG2(paramString, 4, 1000);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      Log.e("SharpPUtil", "sharpP so link error, missing native method.");
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static boolean isSharpPFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: bipush 6
    //   2: newarray byte
    //   4: astore_3
    //   5: new 73	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: aload_1
    //   17: aload_3
    //   18: invokevirtual 80	java/io/FileInputStream:read	([B)I
    //   21: pop
    //   22: aload_1
    //   23: ifnull +7 -> 30
    //   26: aload_1
    //   27: invokevirtual 83	java/io/FileInputStream:close	()V
    //   30: new 85	java/lang/String
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 88	java/lang/String:<init>	([B)V
    //   38: astore_0
    //   39: ldc 11
    //   41: new 32	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 90
    //   47: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 51	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   60: pop
    //   61: aload_0
    //   62: ldc 8
    //   64: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ireturn
    //   68: astore_2
    //   69: aconst_null
    //   70: astore_1
    //   71: aload_1
    //   72: astore_0
    //   73: ldc 11
    //   75: new 32	java/lang/StringBuilder
    //   78: dup
    //   79: ldc 99
    //   81: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload_2
    //   85: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   88: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 51	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   97: pop
    //   98: aload_1
    //   99: ifnull -69 -> 30
    //   102: aload_1
    //   103: invokevirtual 83	java/io/FileInputStream:close	()V
    //   106: goto -76 -> 30
    //   109: astore_0
    //   110: ldc 11
    //   112: new 32	java/lang/StringBuilder
    //   115: dup
    //   116: ldc 104
    //   118: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   121: aload_0
    //   122: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   125: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 51	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   134: pop
    //   135: goto -105 -> 30
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_0
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 83	java/io/FileInputStream:close	()V
    //   149: aload_1
    //   150: athrow
    //   151: astore_0
    //   152: ldc 11
    //   154: new 32	java/lang/StringBuilder
    //   157: dup
    //   158: ldc 104
    //   160: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload_0
    //   164: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   167: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 51	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   176: pop
    //   177: goto -28 -> 149
    //   180: astore_0
    //   181: ldc 11
    //   183: new 32	java/lang/StringBuilder
    //   186: dup
    //   187: ldc 104
    //   189: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   192: aload_0
    //   193: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   196: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 51	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   205: pop
    //   206: goto -176 -> 30
    //   209: astore_1
    //   210: goto -69 -> 141
    //   213: astore_2
    //   214: goto -143 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramFile	java.io.File
    //   13	90	1	localFileInputStream	java.io.FileInputStream
    //   138	12	1	localObject1	Object
    //   209	1	1	localObject2	Object
    //   68	17	2	localIOException1	java.io.IOException
    //   213	1	2	localIOException2	java.io.IOException
    //   4	31	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   5	14	68	java/io/IOException
    //   102	106	109	java/io/IOException
    //   5	14	138	finally
    //   145	149	151	java/io/IOException
    //   26	30	180	java/io/IOException
    //   16	22	209	finally
    //   73	98	209	finally
    //   16	22	213	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sharpP.SharpPUtil
 * JD-Core Version:    0.7.0.1
 */