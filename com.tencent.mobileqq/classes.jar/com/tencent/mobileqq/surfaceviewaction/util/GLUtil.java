package com.tencent.mobileqq.surfaceviewaction.util;

import android.opengl.GLES20;

public class GLUtil
{
  public static int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt == 0) {
      throw new RuntimeException("Error create shader.");
    }
    int[] arrayOfInt = new int[1];
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      GLES20.glDeleteShader(paramInt);
      throw new RuntimeException("Error compile shader: " + GLES20.glGetShaderInfoLog(paramInt));
    }
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = a(35633, paramString1);
    int j = a(35632, paramString2);
    int k = GLES20.glCreateProgram();
    if (k == 0) {
      throw new RuntimeException("Error create program.");
    }
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] == 0)
    {
      GLES20.glDeleteProgram(k);
      throw new RuntimeException("Error linking program: " + GLES20.glGetProgramInfoLog(k));
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    return k;
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 94	java/io/InputStreamReader
    //   5: dup
    //   6: aload_0
    //   7: invokevirtual 100	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   10: invokevirtual 106	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_1
    //   14: invokevirtual 112	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: invokespecial 115	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_0
    //   23: new 117	java/io/BufferedReader
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 120	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_2
    //   32: aload_1
    //   33: astore_0
    //   34: new 42	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   41: astore 4
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: invokevirtual 123	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +47 -> 100
    //   56: aload_1
    //   57: astore_0
    //   58: aload 4
    //   60: aload 5
    //   62: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: astore_0
    //   68: aload 4
    //   70: bipush 10
    //   72: invokevirtual 126	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: goto -33 -> 43
    //   79: astore_2
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   86: aload_3
    //   87: astore_0
    //   88: aload_1
    //   89: ifnull +9 -> 98
    //   92: aload_1
    //   93: invokevirtual 132	java/io/InputStreamReader:close	()V
    //   96: aload_3
    //   97: astore_0
    //   98: aload_0
    //   99: areturn
    //   100: aload_1
    //   101: astore_0
    //   102: aload 4
    //   104: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: astore_0
    //   110: aload_1
    //   111: ifnull -13 -> 98
    //   114: aload_1
    //   115: invokevirtual 132	java/io/InputStreamReader:close	()V
    //   118: aload_2
    //   119: areturn
    //   120: astore_0
    //   121: aload_2
    //   122: areturn
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 132	java/io/InputStreamReader:close	()V
    //   134: aload_1
    //   135: athrow
    //   136: astore_0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: goto -6 -> 134
    //   143: astore_1
    //   144: goto -18 -> 126
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -70 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramContext	android.content.Context
    //   0	153	1	paramString	String
    //   31	15	2	localBufferedReader	java.io.BufferedReader
    //   79	4	2	localException1	java.lang.Exception
    //   107	15	2	str1	String
    //   147	1	2	localException2	java.lang.Exception
    //   1	96	3	localObject	Object
    //   41	62	4	localStringBuilder	java.lang.StringBuilder
    //   49	12	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   23	32	79	java/lang/Exception
    //   34	43	79	java/lang/Exception
    //   45	51	79	java/lang/Exception
    //   58	66	79	java/lang/Exception
    //   68	76	79	java/lang/Exception
    //   102	108	79	java/lang/Exception
    //   114	118	120	java/io/IOException
    //   2	21	123	finally
    //   92	96	136	java/io/IOException
    //   130	134	139	java/io/IOException
    //   23	32	143	finally
    //   34	43	143	finally
    //   45	51	143	finally
    //   58	66	143	finally
    //   68	76	143	finally
    //   82	86	143	finally
    //   102	108	143	finally
    //   2	21	147	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.util.GLUtil
 * JD-Core Version:    0.7.0.1
 */