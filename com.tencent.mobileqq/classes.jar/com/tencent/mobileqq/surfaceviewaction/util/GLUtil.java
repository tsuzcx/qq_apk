package com.tencent.mobileqq.surfaceviewaction.util;

import android.opengl.GLES20;

public class GLUtil
{
  public static int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt != 0)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glShaderSource(paramInt, paramString);
      GLES20.glCompileShader(paramInt);
      GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
      if (arrayOfInt[0] != 0) {
        return paramInt;
      }
      GLES20.glDeleteShader(paramInt);
      paramString = new StringBuilder();
      paramString.append("Error compile shader: ");
      paramString.append(GLES20.glGetShaderInfoLog(paramInt));
      throw new RuntimeException(paramString.toString());
    }
    throw new RuntimeException("Error create shader.");
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = a(35633, paramString1);
    int j = a(35632, paramString2);
    int k = GLES20.glCreateProgram();
    if (k != 0)
    {
      GLES20.glAttachShader(k, i);
      GLES20.glAttachShader(k, j);
      GLES20.glLinkProgram(k);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(k, 35714, paramString1, 0);
      if (paramString1[0] != 0)
      {
        GLES20.glDeleteShader(i);
        GLES20.glDeleteShader(j);
        return k;
      }
      GLES20.glDeleteProgram(k);
      paramString1 = new StringBuilder();
      paramString1.append("Error linking program: ");
      paramString1.append(GLES20.glGetProgramInfoLog(k));
      throw new RuntimeException(paramString1.toString());
    }
    throw new RuntimeException("Error create program.");
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 94	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 100	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   8: invokevirtual 106	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   11: aload_1
    //   12: invokevirtual 112	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   15: invokespecial 115	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   18: astore_1
    //   19: aload_1
    //   20: astore_0
    //   21: new 117	java/io/BufferedReader
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 120	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore_2
    //   30: aload_1
    //   31: astore_0
    //   32: new 35	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   39: astore_3
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: invokevirtual 123	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore 4
    //   48: aload 4
    //   50: ifnull +24 -> 74
    //   53: aload_1
    //   54: astore_0
    //   55: aload_3
    //   56: aload 4
    //   58: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_1
    //   63: astore_0
    //   64: aload_3
    //   65: bipush 10
    //   67: invokevirtual 126	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: goto -31 -> 40
    //   74: aload_1
    //   75: astore_0
    //   76: aload_3
    //   77: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual 129	java/io/InputStreamReader:close	()V
    //   85: aload_2
    //   86: areturn
    //   87: astore_2
    //   88: goto +12 -> 100
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_0
    //   94: goto +23 -> 117
    //   97: astore_2
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_1
    //   101: astore_0
    //   102: aload_2
    //   103: invokevirtual 132	java/lang/Exception:printStackTrace	()V
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 129	java/io/InputStreamReader:close	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_1
    //   117: aload_0
    //   118: ifnull +7 -> 125
    //   121: aload_0
    //   122: invokevirtual 129	java/io/InputStreamReader:close	()V
    //   125: goto +5 -> 130
    //   128: aload_1
    //   129: athrow
    //   130: goto -2 -> 128
    //   133: astore_0
    //   134: aload_2
    //   135: areturn
    //   136: astore_0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: goto -15 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramContext	android.content.Context
    //   0	143	1	paramString	String
    //   29	57	2	localObject	Object
    //   87	1	2	localException1	java.lang.Exception
    //   97	38	2	localException2	java.lang.Exception
    //   39	38	3	localStringBuilder	StringBuilder
    //   46	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   21	30	87	java/lang/Exception
    //   32	40	87	java/lang/Exception
    //   42	48	87	java/lang/Exception
    //   55	62	87	java/lang/Exception
    //   64	71	87	java/lang/Exception
    //   76	81	87	java/lang/Exception
    //   0	19	91	finally
    //   0	19	97	java/lang/Exception
    //   21	30	116	finally
    //   32	40	116	finally
    //   42	48	116	finally
    //   55	62	116	finally
    //   64	71	116	finally
    //   76	81	116	finally
    //   102	106	116	finally
    //   81	85	133	java/io/IOException
    //   110	114	136	java/io/IOException
    //   121	125	139	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.util.GLUtil
 * JD-Core Version:    0.7.0.1
 */