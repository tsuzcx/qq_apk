package com.tencent.taveffect.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.taveffect.core.RGBTextureFilter;
import com.tencent.taveffect.core.TAVTextureInfo;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Scanner;

public class TAVGLUtils
{
  private static final String TAG = "TAVGLUtils";
  private static RGBTextureFilter rgbTextureFilter;
  
  public static void checkEglError(String paramString)
  {
    int i = 0;
    String str = "";
    for (;;)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": EGL error: 0x");
      localStringBuilder.append(Integer.toHexString(j));
      Log.e("TAVGLUtils", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString);
      localStringBuilder.append(": EGL error: 0x");
      localStringBuilder.append(Integer.toHexString(j));
      str = localStringBuilder.toString();
      i = 1;
    }
    if (i != 0)
    {
      paramString = new StringBuilder();
      paramString.append("EGL error encountered (see log): ");
      paramString.append(str);
      new RuntimeException(paramString.toString()).printStackTrace();
    }
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    paramInputStream = new Scanner(paramInputStream).useDelimiter("\\A");
    if (paramInputStream.hasNext()) {
      return paramInputStream.next();
    }
    return "";
  }
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 * (1.0F - paramFloat3) + paramFloat2 * paramFloat3;
  }
  
  /* Error */
  public static String loadShaderCode(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: invokevirtual 93	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   8: aload_1
    //   9: invokevirtual 99	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_0
    //   13: aload_0
    //   14: astore_2
    //   15: aload_0
    //   16: astore_3
    //   17: aload_0
    //   18: invokestatic 101	com/tencent/taveffect/utils/TAVGLUtils:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   21: astore_1
    //   22: aload_0
    //   23: ifnull +14 -> 37
    //   26: aload_0
    //   27: invokevirtual 106	java/io/InputStream:close	()V
    //   30: aload_1
    //   31: areturn
    //   32: astore_0
    //   33: aload_0
    //   34: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   37: aload_1
    //   38: areturn
    //   39: astore_0
    //   40: goto +29 -> 69
    //   43: astore_0
    //   44: aload_3
    //   45: astore_2
    //   46: aload_0
    //   47: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   50: aload_3
    //   51: ifnull +15 -> 66
    //   54: aload_3
    //   55: invokevirtual 106	java/io/InputStream:close	()V
    //   58: goto +8 -> 66
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   66: ldc 19
    //   68: areturn
    //   69: aload_2
    //   70: ifnull +15 -> 85
    //   73: aload_2
    //   74: invokevirtual 106	java/io/InputStream:close	()V
    //   77: goto +8 -> 85
    //   80: astore_1
    //   81: aload_1
    //   82: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramContext	android.content.Context
    //   0	87	1	paramString	String
    //   3	71	2	localContext1	android.content.Context
    //   1	54	3	localContext2	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   26	30	32	java/io/IOException
    //   4	13	39	finally
    //   17	22	39	finally
    //   46	50	39	finally
    //   4	13	43	java/lang/Exception
    //   17	22	43	java/lang/Exception
    //   54	58	61	java/io/IOException
    //   73	77	80	java/io/IOException
  }
  
  public static Bitmap saveBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2 * paramInt3 * 4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.rewind();
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_4444);
    localByteBuffer.rewind();
    localBitmap.copyPixelsFromBuffer(localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, 0);
    return localBitmap;
  }
  
  public static Bitmap saveBitmap(TAVTextureInfo paramTAVTextureInfo)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramTAVTextureInfo.textureID, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramTAVTextureInfo.width * paramTAVTextureInfo.height * 4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.rewind();
    GLES20.glReadPixels(0, 0, paramTAVTextureInfo.width, paramTAVTextureInfo.height, 6408, 5121, localByteBuffer);
    paramTAVTextureInfo = Bitmap.createBitmap(paramTAVTextureInfo.width, paramTAVTextureInfo.height, Bitmap.Config.ARGB_4444);
    localByteBuffer.rewind();
    paramTAVTextureInfo.copyPixelsFromBuffer(localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    return paramTAVTextureInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.taveffect.utils.TAVGLUtils
 * JD-Core Version:    0.7.0.1
 */