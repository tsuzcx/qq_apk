package com.tencent.tav.player;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import com.tencent.tav.coremedia.TextureInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jetbrains.annotations.NotNull;

public class TAVGLUtils
{
  public static final String OUT_SAVE_DIR = "/sdcard/tavkit_demo/";
  public static final String OUT_SAVE_EXPORT_DIR = "/sdcard/tavkit_demo/export/";
  public static final String OUT_SAVE_VIDEOS_DIR = "/sdcard/tavkit_demo/videos/";
  private static final String TAV_DEBUG_IMAGE_DIR = "/sdcard/tavkit_demo//TAV调试图片";
  
  @NotNull
  public static File newDebugImageFile(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Long.toHexString(System.currentTimeMillis()));
    ((StringBuilder)localObject1).append("_id=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt3);
    ((StringBuilder)localObject1).append(".png");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = new File("/sdcard/tavkit_demo//TAV调试图片");
    if ((!((File)localObject1).exists()) && (!((File)localObject1).mkdir()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mkdir return false, path = ");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      throw new RuntimeException(((StringBuilder)localObject2).toString());
    }
    return new File("/sdcard/tavkit_demo//TAV调试图片", (String)localObject2);
  }
  
  public static void readPixelBuffer(TextureInfo paramTextureInfo, ByteBuffer paramByteBuffer)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, paramTextureInfo.textureType, paramTextureInfo.textureID, 0);
    GLES20.glReadPixels(0, 0, paramTextureInfo.width, paramTextureInfo.height, 6408, 5121, paramByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
  }
  
  public static Bitmap saveBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    return saveBitmap(paramInt1, 3553, paramInt2, paramInt3);
  }
  
  public static Bitmap saveBitmap(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return saveBitmap(new TextureInfo(paramInt1, paramInt2, paramInt3, paramInt4, 0));
  }
  
  public static Bitmap saveBitmap(TextureInfo paramTextureInfo)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramTextureInfo.width * paramTextureInfo.height * 4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.rewind();
    readPixelBuffer(paramTextureInfo, localByteBuffer);
    return saveBitmap(localByteBuffer, paramTextureInfo.width, paramTextureInfo.height);
  }
  
  @NotNull
  private static Bitmap saveBitmap(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
    paramByteBuffer.rewind();
    localBitmap.copyPixelsFromBuffer(paramByteBuffer);
    return localBitmap;
  }
  
  public static void saveBitmapToFile(Bitmap paramBitmap)
  {
    saveBitmapToFile(paramBitmap, newDebugImageFile(0, paramBitmap.getWidth(), paramBitmap.getHeight()));
  }
  
  public static void saveBitmapToFile(Bitmap paramBitmap, File paramFile)
  {
    if (paramFile.createNewFile())
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 0, localByteArrayOutputStream);
      paramBitmap = localByteArrayOutputStream.toByteArray();
      paramFile = new FileOutputStream(paramFile);
      paramFile.write(paramBitmap);
      paramFile.flush();
      paramFile.close();
      return;
    }
    paramBitmap = new StringBuilder();
    paramBitmap.append("createNewFile return false, path = ");
    paramBitmap.append(paramFile.getAbsolutePath());
    throw new RuntimeException(paramBitmap.toString());
  }
  
  public static void saveBitmapToFile(TextureInfo paramTextureInfo)
  {
    saveBitmapToFile(paramTextureInfo, newDebugImageFile(paramTextureInfo.textureID, paramTextureInfo.width, paramTextureInfo.height));
  }
  
  public static void saveBitmapToFile(TextureInfo paramTextureInfo, File paramFile)
  {
    saveBitmapToFile(saveBitmap(paramTextureInfo), paramFile);
  }
  
  public static void saveBitmapToFile(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    saveBitmapToFile(saveBitmap(paramByteBuffer, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.player.TAVGLUtils
 * JD-Core Version:    0.7.0.1
 */