package com.tencent.taveffect.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.taveffect.core.RGBTextureFilter;
import com.tencent.taveffect.core.TAVTextureInfo;
import java.io.IOException;
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
      Log.e("TAVGLUtils", paramString + ": EGL error: 0x" + Integer.toHexString(j));
      str = str + paramString + ": EGL error: 0x" + Integer.toHexString(j);
      i = 1;
    }
    if (i != 0) {
      new RuntimeException("EGL error encountered (see log): " + str).printStackTrace();
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
    return (1.0F - paramFloat3) * paramFloat1 + paramFloat2 * paramFloat3;
  }
  
  public static String loadShaderCode(Context paramContext, String paramString)
  {
    localObject = null;
    Context localContext = null;
    try
    {
      paramContext = paramContext.getAssets().open(paramString);
      localContext = paramContext;
      localObject = paramContext;
      paramString = convertStreamToString(paramContext);
      if (paramContext != null) {}
      try
      {
        paramContext.close();
        return paramString;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return paramString;
      }
      try
      {
        ((InputStream)localObject).close();
        throw paramContext;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (Exception paramContext)
    {
      localObject = localContext;
      paramContext.printStackTrace();
      if (localContext != null) {}
      try
      {
        localContext.close();
        return "";
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    finally
    {
      if (localObject == null) {}
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.taveffect.utils.TAVGLUtils
 * JD-Core Version:    0.7.0.1
 */