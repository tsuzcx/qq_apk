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
    if (i != 0)
    {
      paramString = new StringBuilder();
      paramString.append("status: ");
      paramString.append(i);
      Log.d("SharpPUtil", paramString.toString());
      return null;
    }
    i = localSharpPDecoder.getSharpPType();
    if ((3 != i) && (4 != i)) {
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
    }
    return null;
  }
  
  /* Error */
  public static boolean isSharpPFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: bipush 6
    //   2: newarray byte
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_1
    //   10: new 74	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: astore_0
    //   19: aload_0
    //   20: aload 4
    //   22: invokevirtual 81	java/io/FileInputStream:read	([B)I
    //   25: pop
    //   26: aload_0
    //   27: invokevirtual 84	java/io/FileInputStream:close	()V
    //   30: goto +125 -> 155
    //   33: astore_1
    //   34: new 32	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   41: astore_0
    //   42: aload_0
    //   43: ldc 86
    //   45: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   54: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 11
    //   60: aload_0
    //   61: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 52	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   67: pop
    //   68: goto +87 -> 155
    //   71: astore_2
    //   72: aload_0
    //   73: astore_1
    //   74: aload_2
    //   75: astore_0
    //   76: goto +127 -> 203
    //   79: astore_2
    //   80: goto +10 -> 90
    //   83: astore_0
    //   84: goto +119 -> 203
    //   87: astore_2
    //   88: aload_3
    //   89: astore_0
    //   90: aload_0
    //   91: astore_1
    //   92: new 32	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   99: astore_3
    //   100: aload_0
    //   101: astore_1
    //   102: aload_3
    //   103: ldc 91
    //   105: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_0
    //   110: astore_1
    //   111: aload_3
    //   112: aload_2
    //   113: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   116: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_0
    //   121: astore_1
    //   122: ldc 11
    //   124: aload_3
    //   125: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 52	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: aload_0
    //   133: ifnull +22 -> 155
    //   136: aload_0
    //   137: invokevirtual 84	java/io/FileInputStream:close	()V
    //   140: goto +15 -> 155
    //   143: astore_1
    //   144: new 32	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   151: astore_0
    //   152: goto -110 -> 42
    //   155: new 93	java/lang/String
    //   158: dup
    //   159: aload 4
    //   161: invokespecial 96	java/lang/String:<init>	([B)V
    //   164: astore_0
    //   165: new 32	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   172: astore_1
    //   173: aload_1
    //   174: ldc 98
    //   176: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_1
    //   181: aload_0
    //   182: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: ldc 11
    //   188: aload_1
    //   189: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 52	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   195: pop
    //   196: aload_0
    //   197: ldc 8
    //   199: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ireturn
    //   203: aload_1
    //   204: ifnull +45 -> 249
    //   207: aload_1
    //   208: invokevirtual 84	java/io/FileInputStream:close	()V
    //   211: goto +38 -> 249
    //   214: astore_1
    //   215: new 32	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   222: astore_2
    //   223: aload_2
    //   224: ldc 86
    //   226: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_2
    //   231: aload_1
    //   232: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   235: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: ldc 11
    //   241: aload_2
    //   242: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 52	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   248: pop
    //   249: goto +5 -> 254
    //   252: aload_0
    //   253: athrow
    //   254: goto -2 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramFile	java.io.File
    //   9	1	1	localObject1	Object
    //   33	18	1	localIOException1	java.io.IOException
    //   73	49	1	localFile	java.io.File
    //   143	1	1	localIOException2	java.io.IOException
    //   172	36	1	localStringBuilder1	StringBuilder
    //   214	18	1	localIOException3	java.io.IOException
    //   71	4	2	localObject2	Object
    //   79	1	2	localIOException4	java.io.IOException
    //   87	26	2	localIOException5	java.io.IOException
    //   222	20	2	localStringBuilder2	StringBuilder
    //   7	118	3	localStringBuilder3	StringBuilder
    //   4	156	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	30	33	java/io/IOException
    //   19	26	71	finally
    //   19	26	79	java/io/IOException
    //   10	19	83	finally
    //   92	100	83	finally
    //   102	109	83	finally
    //   111	120	83	finally
    //   122	132	83	finally
    //   10	19	87	java/io/IOException
    //   136	140	143	java/io/IOException
    //   207	211	214	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sharpP.SharpPUtil
 * JD-Core Version:    0.7.0.1
 */