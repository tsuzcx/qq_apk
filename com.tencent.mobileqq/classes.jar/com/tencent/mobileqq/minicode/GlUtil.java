package com.tencent.mobileqq.minicode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.opengl.Matrix;
import android.util.Log;
import bblu;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;

public class GlUtil
{
  public static final String TAG = "GlUtil";
  
  public static void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      Log.e("GlUtil", paramString + ": glError 0x" + Integer.toHexString(i));
    }
  }
  
  public static Bitmap convertTexToBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    ByteBuffer localByteBuffer = readTextureToByteBuffer(paramInt1, paramInt2, paramInt3);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(localByteBuffer);
    return localBitmap;
  }
  
  @TargetApi(18)
  public static int createTexture31(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[1];
    GLES31.glGenTextures(1, arrayOfInt, 0);
    GLES31.glBindTexture(3553, arrayOfInt[0]);
    GLES31.glTexStorage2D(3553, 1, 32856, paramInt1, paramInt2);
    GLES31.glTexParameteri(3553, 10242, 33071);
    GLES31.glTexParameteri(3553, 10243, 33071);
    GLES31.glTexParameteri(3553, 10241, 9728);
    GLES31.glTexParameteri(3553, 10240, 9728);
    checkGlError("glTexParameter");
    return arrayOfInt[0];
  }
  
  public static int createTexture31FromBmp(Bitmap paramBitmap)
  {
    int i = bblu.a(3553, paramBitmap);
    TextureRender localTextureRender = new TextureRender();
    paramBitmap = new RenderBuffer(paramBitmap.getHeight(), paramBitmap.getWidth(), 33987, true);
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    paramBitmap.bind();
    localTextureRender.drawTexture(3553, i, null, arrayOfFloat);
    paramBitmap.unbind();
    return paramBitmap.getTexId();
  }
  
  private static ByteBuffer readTextureToByteBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = new int[1];
    GLES20.glGetIntegerv(36006, arrayOfInt2, 0);
    GLES20.glGenFramebuffers(1, arrayOfInt1, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    GLES20.glFinish();
    GLES20.glBindFramebuffer(36160, arrayOfInt2[0]);
    GLES20.glDeleteFramebuffers(1, arrayOfInt1, 0);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.GlUtil
 * JD-Core Version:    0.7.0.1
 */