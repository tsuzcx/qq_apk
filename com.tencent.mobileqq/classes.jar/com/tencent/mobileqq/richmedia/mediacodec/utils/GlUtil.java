package com.tencent.mobileqq.richmedia.mediacodec.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class GlUtil
{
  public static final int NO_TEXTURE = -1;
  private static final int SIZEOF_FLOAT = 4;
  private static final String TAG = "GlUtil";
  
  public static Bitmap captureFrame(int paramInt1, int paramInt2, int paramInt3)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
    Object localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    GLES20.glBindFramebuffer(36160, localObject[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, (int[])localObject, 0);
    localObject[0] = 0;
    localByteBuffer.position(0);
    localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).copyPixelsFromBuffer(localByteBuffer);
    return localObject;
  }
  
  public static Bitmap captureFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject2 = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
    Object localObject1 = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject1, 0);
    GLES20.glBindFramebuffer(36160, localObject1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, (Buffer)localObject2);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, (int[])localObject1, 0);
    localObject1[0] = 0;
    ((ByteBuffer)localObject2).position(0);
    localObject1 = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject1).copyPixelsFromBuffer((Buffer)localObject2);
    localObject2 = new Matrix();
    ((Matrix)localObject2).postRotate(paramInt4);
    ((Matrix)localObject2).postScale(1.0F, -1.0F);
    localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, paramInt2, paramInt3, (Matrix)localObject2, true);
    ((Bitmap)localObject1).recycle();
    return localObject2;
  }
  
  public static void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError 0x");
      localStringBuilder.append(Integer.toHexString(i));
      Log.e("GlUtil", localStringBuilder.toString());
    }
  }
  
  public static int createComputeProgram(String paramString)
  {
    int i = loadShader(37305, paramString);
    if (i == 0) {
      return 0;
    }
    int j = GLES20.glCreateProgram();
    checkGlError("createComputeProgram");
    if (j == 0) {
      Log.e("GlUtil", "Could not create ComputeProgram");
    }
    GLES20.glAttachShader(j, i);
    checkGlError("glAttachShader");
    GLES20.glLinkProgram(j);
    paramString = new int[1];
    GLES20.glGetProgramiv(j, 35714, paramString, 0);
    if (paramString[0] != 1)
    {
      Log.e("GlUtil", "Could not link ComputeProgram: ");
      Log.e("GlUtil", GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
      return 0;
    }
    return j;
  }
  
  public static FloatBuffer createFloatBuffer(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static FloatBuffer createFloatBuffer(float[] paramArrayOfFloat, ByteOrder paramByteOrder)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    localByteBuffer.order(paramByteOrder);
    paramByteOrder = localByteBuffer.asFloatBuffer();
    paramByteOrder.put(paramArrayOfFloat);
    paramByteOrder.position(0);
    return paramByteOrder;
  }
  
  public static IntBuffer createIntBuffer(int[] paramArrayOfInt)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfInt.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asIntBuffer();
    ((IntBuffer)localObject).put(paramArrayOfInt);
    ((IntBuffer)localObject).position(0);
    return localObject;
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0) {
      return 0;
    }
    int j = loadShader(35632, paramString2);
    if (j == 0) {
      return 0;
    }
    int k = GLES20.glCreateProgram();
    checkGlError("glCreateProgram");
    if (k == 0) {
      Log.e("GlUtil", "Could not create program");
    }
    GLES20.glAttachShader(k, i);
    checkGlError("glAttachShader");
    GLES20.glAttachShader(k, j);
    checkGlError("glAttachShader");
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("GlUtil", "Could not link program: ");
      Log.e("GlUtil", GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  public static int createTexture(int paramInt)
  {
    return createTexture(paramInt, null, 9729, 9729, 33071, 33071);
  }
  
  public static int createTexture(int paramInt, Bitmap paramBitmap)
  {
    return createTexture(paramInt, paramBitmap, 9729, 9729, 33071, 33071);
  }
  
  public static int createTexture(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    checkGlError("glGenTextures");
    GLES20.glBindTexture(paramInt1, arrayOfInt[0]);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glBindTexture ");
    localStringBuilder.append(arrayOfInt[0]);
    checkGlError(localStringBuilder.toString());
    GLES20.glTexParameterf(paramInt1, 10241, paramInt2);
    GLES20.glTexParameterf(paramInt1, 10240, paramInt3);
    GLES20.glTexParameteri(paramInt1, 10242, paramInt4);
    GLES20.glTexParameteri(paramInt1, 10243, paramInt5);
    if (paramBitmap != null) {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    checkGlError("glTexParameter");
    return arrayOfInt[0];
  }
  
  @TargetApi(18)
  public static int createTextureAllocate(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = createTexture(3553);
    if (paramBoolean) {
      GLES31.glTexStorage2D(3553, 1, 32856, paramInt1, paramInt2);
    } else {
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    }
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    return i;
  }
  
  public static void deleteTexture(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    checkGlError("glDeleteTextures");
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    int j = GLES20.glCreateShader(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glCreateShader type=");
    localStringBuilder.append(paramInt);
    checkGlError(localStringBuilder.toString());
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    int i = j;
    if (paramString[0] == 0)
    {
      paramString = new StringBuilder();
      paramString.append("Could not compile shader ");
      paramString.append(paramInt);
      paramString.append(":");
      Log.e("GlUtil", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(" ");
      paramString.append(GLES20.glGetShaderInfoLog(j));
      Log.e("GlUtil", paramString.toString());
      GLES20.glDeleteShader(j);
      i = 0;
    }
    return i;
  }
  
  /* Error */
  public static String readTextFromRawResource(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: new 96	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_0
    //   13: invokevirtual 297	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   16: iload_1
    //   17: invokevirtual 303	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   20: astore_3
    //   21: new 305	java/io/InputStreamReader
    //   24: dup
    //   25: aload_3
    //   26: invokespecial 308	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   29: astore_2
    //   30: new 310	java/io/BufferedReader
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 313	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual 316	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +22 -> 69
    //   50: aload 5
    //   52: aload 4
    //   54: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 5
    //   60: bipush 10
    //   62: invokevirtual 319	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: goto -27 -> 39
    //   69: aload_0
    //   70: invokevirtual 322	java/io/BufferedReader:close	()V
    //   73: goto +8 -> 81
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   81: aload_2
    //   82: invokevirtual 326	java/io/InputStreamReader:close	()V
    //   85: goto +8 -> 93
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   93: aload_3
    //   94: ifnull +15 -> 109
    //   97: aload_3
    //   98: invokevirtual 329	java/io/InputStream:close	()V
    //   101: goto +8 -> 109
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   109: aload 5
    //   111: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: areturn
    //   115: astore 5
    //   117: aload_0
    //   118: astore 4
    //   120: aload 5
    //   122: astore_0
    //   123: goto +59 -> 182
    //   126: aload_0
    //   127: invokevirtual 322	java/io/BufferedReader:close	()V
    //   130: goto +8 -> 138
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   138: aload_2
    //   139: invokevirtual 326	java/io/InputStreamReader:close	()V
    //   142: goto +8 -> 150
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   150: aload_3
    //   151: ifnull +14 -> 165
    //   154: aload_3
    //   155: invokevirtual 329	java/io/InputStream:close	()V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   165: aconst_null
    //   166: areturn
    //   167: astore_0
    //   168: goto +14 -> 182
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_2
    //   174: goto +8 -> 182
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_3
    //   181: astore_2
    //   182: aload 4
    //   184: ifnull +18 -> 202
    //   187: aload 4
    //   189: invokevirtual 322	java/io/BufferedReader:close	()V
    //   192: goto +10 -> 202
    //   195: astore 4
    //   197: aload 4
    //   199: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   202: aload_2
    //   203: ifnull +15 -> 218
    //   206: aload_2
    //   207: invokevirtual 326	java/io/InputStreamReader:close	()V
    //   210: goto +8 -> 218
    //   213: astore_2
    //   214: aload_2
    //   215: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   218: aload_3
    //   219: ifnull +15 -> 234
    //   222: aload_3
    //   223: invokevirtual 329	java/io/InputStream:close	()V
    //   226: goto +8 -> 234
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   234: goto +5 -> 239
    //   237: aload_0
    //   238: athrow
    //   239: goto -2 -> 237
    //   242: astore 4
    //   244: goto -118 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramContext	android.content.Context
    //   0	247	1	paramInt	int
    //   29	178	2	localObject1	Object
    //   213	2	2	localIOException1	java.io.IOException
    //   229	2	2	localIOException2	java.io.IOException
    //   20	203	3	localInputStream	java.io.InputStream
    //   10	178	4	localObject2	Object
    //   195	3	4	localIOException3	java.io.IOException
    //   242	1	4	localIOException4	java.io.IOException
    //   7	103	5	localStringBuilder	StringBuilder
    //   115	6	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   69	73	76	java/io/IOException
    //   81	85	88	java/io/IOException
    //   97	101	104	java/io/IOException
    //   39	45	115	finally
    //   50	66	115	finally
    //   126	130	133	java/io/IOException
    //   138	142	145	java/io/IOException
    //   154	158	160	java/io/IOException
    //   30	39	167	finally
    //   21	30	171	finally
    //   12	21	177	finally
    //   187	192	195	java/io/IOException
    //   206	210	213	java/io/IOException
    //   222	226	229	java/io/IOException
    //   39	45	242	java/io/IOException
    //   50	66	242	java/io/IOException
  }
  
  public static byte[] saveTextureToRgbaBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[paramInt2 * paramInt3 * 4];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    arrayOfInt[0] = 0;
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil
 * JD-Core Version:    0.7.0.1
 */