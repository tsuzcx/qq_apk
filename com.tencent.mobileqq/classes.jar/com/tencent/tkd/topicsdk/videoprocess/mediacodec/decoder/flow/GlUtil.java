package com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.flow;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.tkd.topicsdk.framework.TLog;

public class GlUtil
{
  public static int a(int paramInt)
  {
    return a(paramInt, null, 9729, 9729, 33071, 33071);
  }
  
  public static int a(int paramInt, Bitmap paramBitmap)
  {
    return a(paramInt, paramBitmap, 9729, 9729, 33071, 33071);
  }
  
  public static int a(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    a("glGenTextures");
    GLES20.glBindTexture(paramInt1, arrayOfInt[0]);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glBindTexture ");
    localStringBuilder.append(arrayOfInt[0]);
    a(localStringBuilder.toString());
    GLES20.glTexParameterf(paramInt1, 10241, paramInt2);
    GLES20.glTexParameterf(paramInt1, 10240, paramInt3);
    GLES20.glTexParameteri(paramInt1, 10242, paramInt4);
    GLES20.glTexParameteri(paramInt1, 10243, paramInt5);
    if (paramBitmap != null) {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    a("glTexParameter");
    return arrayOfInt[0];
  }
  
  /* Error */
  public static String a(com.tencent.tkd.topicsdk.framework.AppContext paramAppContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 70	com/tencent/tkd/topicsdk/framework/AppContext:a	()Landroid/content/Context;
    //   4: invokevirtual 76	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: iload_1
    //   8: invokevirtual 82	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   11: astore 4
    //   13: new 84	java/io/InputStreamReader
    //   16: dup
    //   17: aload 4
    //   19: invokespecial 87	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: astore_2
    //   23: new 89	java/io/BufferedReader
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 92	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_0
    //   32: new 32	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   39: astore_3
    //   40: aload_0
    //   41: invokevirtual 95	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 5
    //   46: aload 5
    //   48: ifnull +20 -> 68
    //   51: aload_3
    //   52: aload 5
    //   54: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_3
    //   59: bipush 10
    //   61: invokevirtual 98	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: goto -25 -> 40
    //   68: aload 4
    //   70: invokevirtual 103	java/io/InputStream:close	()V
    //   73: goto +15 -> 88
    //   76: astore 4
    //   78: ldc 105
    //   80: aload 4
    //   82: invokevirtual 106	java/io/IOException:toString	()Ljava/lang/String;
    //   85: invokestatic 112	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokevirtual 113	java/io/InputStreamReader:close	()V
    //   92: goto +13 -> 105
    //   95: astore_2
    //   96: ldc 105
    //   98: aload_2
    //   99: invokevirtual 106	java/io/IOException:toString	()Ljava/lang/String;
    //   102: invokestatic 112	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: invokevirtual 114	java/io/BufferedReader:close	()V
    //   109: goto +13 -> 122
    //   112: astore_0
    //   113: ldc 105
    //   115: aload_0
    //   116: invokevirtual 106	java/io/IOException:toString	()Ljava/lang/String;
    //   119: invokestatic 112	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_3
    //   123: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: areturn
    //   127: astore_3
    //   128: aload 4
    //   130: invokevirtual 103	java/io/InputStream:close	()V
    //   133: goto +15 -> 148
    //   136: astore 4
    //   138: ldc 105
    //   140: aload 4
    //   142: invokevirtual 106	java/io/IOException:toString	()Ljava/lang/String;
    //   145: invokestatic 112	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_2
    //   149: invokevirtual 113	java/io/InputStreamReader:close	()V
    //   152: goto +13 -> 165
    //   155: astore_2
    //   156: ldc 105
    //   158: aload_2
    //   159: invokevirtual 106	java/io/IOException:toString	()Ljava/lang/String;
    //   162: invokestatic 112	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_0
    //   166: invokevirtual 114	java/io/BufferedReader:close	()V
    //   169: goto +13 -> 182
    //   172: astore_0
    //   173: ldc 105
    //   175: aload_0
    //   176: invokevirtual 106	java/io/IOException:toString	()Ljava/lang/String;
    //   179: invokestatic 112	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_3
    //   183: athrow
    //   184: aload 4
    //   186: invokevirtual 103	java/io/InputStream:close	()V
    //   189: goto +13 -> 202
    //   192: astore_3
    //   193: ldc 105
    //   195: aload_3
    //   196: invokevirtual 106	java/io/IOException:toString	()Ljava/lang/String;
    //   199: invokestatic 112	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload_2
    //   203: invokevirtual 113	java/io/InputStreamReader:close	()V
    //   206: goto +13 -> 219
    //   209: astore_2
    //   210: ldc 105
    //   212: aload_2
    //   213: invokevirtual 106	java/io/IOException:toString	()Ljava/lang/String;
    //   216: invokestatic 112	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: invokevirtual 114	java/io/BufferedReader:close	()V
    //   223: aconst_null
    //   224: areturn
    //   225: astore_0
    //   226: ldc 105
    //   228: aload_0
    //   229: invokevirtual 106	java/io/IOException:toString	()Ljava/lang/String;
    //   232: invokestatic 112	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_3
    //   238: goto -54 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramAppContext	com.tencent.tkd.topicsdk.framework.AppContext
    //   0	241	1	paramInt	int
    //   22	67	2	localInputStreamReader	java.io.InputStreamReader
    //   95	54	2	localIOException1	java.io.IOException
    //   155	48	2	localIOException2	java.io.IOException
    //   209	4	2	localIOException3	java.io.IOException
    //   39	84	3	localStringBuilder	StringBuilder
    //   127	56	3	localObject	Object
    //   192	4	3	localIOException4	java.io.IOException
    //   237	1	3	localIOException5	java.io.IOException
    //   11	58	4	localInputStream	java.io.InputStream
    //   76	53	4	localIOException6	java.io.IOException
    //   136	49	4	localIOException7	java.io.IOException
    //   44	9	5	str	String
    // Exception table:
    //   from	to	target	type
    //   68	73	76	java/io/IOException
    //   88	92	95	java/io/IOException
    //   105	109	112	java/io/IOException
    //   40	46	127	finally
    //   51	65	127	finally
    //   128	133	136	java/io/IOException
    //   148	152	155	java/io/IOException
    //   165	169	172	java/io/IOException
    //   184	189	192	java/io/IOException
    //   202	206	209	java/io/IOException
    //   219	223	225	java/io/IOException
    //   40	46	237	java/io/IOException
    //   51	65	237	java/io/IOException
  }
  
  public static void a(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    a("glDeleteTextures");
  }
  
  public static void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError 0x");
      localStringBuilder.append(Integer.toHexString(i));
      TLog.d("FlowEdit_GlUtil", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.flow.GlUtil
 * JD-Core Version:    0.7.0.1
 */