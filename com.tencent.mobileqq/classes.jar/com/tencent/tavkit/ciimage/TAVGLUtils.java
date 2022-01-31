package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.os.Environment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jetbrains.annotations.NotNull;

public class TAVGLUtils
{
  private static final String TAG = "TAVGLUtils";
  private static final String TAV_DEBUG_IMAGE_DIR = Environment.getExternalStorageDirectory().getPath() + "/TAV调试图片";
  
  private static TextureInfo checkTextureInfo(TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo.textureType == 3553) {
      return paramTextureInfo;
    }
    TextureInfo localTextureInfo = new TextureInfo(RenderContext.createTexture(3553), 3553, paramTextureInfo.width, paramTextureInfo.height, null, 0);
    TextureFilter localTextureFilter = new TextureFilter();
    localTextureFilter.setOutputTextureInfo(localTextureInfo);
    localTextureFilter.applyFilter(paramTextureInfo, null, paramTextureInfo.getTextureMatrix(), 1.0F, null);
    return localTextureInfo;
  }
  
  @NotNull
  public static File newDebugImageFile(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = Long.toHexString(System.currentTimeMillis()) + "_id=" + paramInt1 + "_" + paramInt2 + "_" + paramInt3 + ".png";
    File localFile = new File(TAV_DEBUG_IMAGE_DIR);
    if ((!localFile.exists()) && (!localFile.mkdir())) {
      throw new RuntimeException("mkdir return false, path = " + localFile.getAbsolutePath());
    }
    return new File(TAV_DEBUG_IMAGE_DIR, str);
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
    Object localObject = checkTextureInfo(paramTextureInfo);
    paramTextureInfo = new int[1];
    GLES20.glGenFramebuffers(1, paramTextureInfo, 0);
    GLES20.glBindFramebuffer(36160, paramTextureInfo[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, ((TextureInfo)localObject).textureID, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(((TextureInfo)localObject).width * ((TextureInfo)localObject).height * 4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.rewind();
    GLES20.glReadPixels(0, 0, ((TextureInfo)localObject).width, ((TextureInfo)localObject).height, 6408, 5121, localByteBuffer);
    localObject = Bitmap.createBitmap(((TextureInfo)localObject).width, ((TextureInfo)localObject).height, Bitmap.Config.ARGB_4444);
    localByteBuffer.rewind();
    ((Bitmap)localObject).copyPixelsFromBuffer(localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, paramTextureInfo, 0);
    return localObject;
  }
  
  public static Bitmap saveBitmap(CIImage paramCIImage)
  {
    TextureInfo localTextureInfo = CIContext.newTextureInfo(paramCIImage.getSize().width, paramCIImage.getSize().height);
    CIImageFilter localCIImageFilter = new CIImageFilter();
    localCIImageFilter.setOutputTextureInfo(localTextureInfo);
    paramCIImage.draw(localCIImageFilter);
    return saveBitmap(localTextureInfo);
  }
  
  public static void saveBitmapToFile(Bitmap paramBitmap)
  {
    saveBitmapToFile(paramBitmap, newDebugImageFile(0, paramBitmap.getWidth(), paramBitmap.getHeight()));
  }
  
  public static void saveBitmapToFile(Bitmap paramBitmap, File paramFile)
  {
    if (!paramFile.createNewFile()) {
      throw new RuntimeException("createNewFile return false, path = " + paramFile.getAbsolutePath());
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 0, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(paramBitmap);
    paramFile.flush();
    paramFile.close();
  }
  
  public static void saveBitmapToFile(TextureInfo paramTextureInfo)
  {
    saveBitmapToFile(paramTextureInfo, newDebugImageFile(paramTextureInfo.textureID, paramTextureInfo.width, paramTextureInfo.height));
  }
  
  public static void saveBitmapToFile(TextureInfo paramTextureInfo, File paramFile)
  {
    saveBitmapToFile(saveBitmap(paramTextureInfo), paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.TAVGLUtils
 * JD-Core Version:    0.7.0.1
 */