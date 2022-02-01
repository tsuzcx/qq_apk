package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jetbrains.annotations.NotNull;

public class TAVGLUtils
{
  private static final String TAG = "TAVGLUtils";
  private static final String TAV_DEBUG_IMAGE_DIR = "/sdcard/tavkit_demo/TAV调试图片";
  
  private static TextureInfo checkTextureInfo(TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo.textureType == 3553) {
      return paramTextureInfo;
    }
    TextureInfo localTextureInfo = new TextureInfo(RenderContext.createTexture(3553), 3553, paramTextureInfo.width, paramTextureInfo.height, null, 0);
    Renderer localRenderer = new Renderer();
    localRenderer.setOutputTextureInfo(localTextureInfo);
    localRenderer.render(paramTextureInfo, null, paramTextureInfo.getTextureMatrix(), 1.0F, null);
    return localTextureInfo;
  }
  
  @NotNull
  private static String getTimeTag()
  {
    return Long.toHexString(System.currentTimeMillis());
  }
  
  @NotNull
  private static File newDebugImageFile(int paramInt1, int paramInt2, int paramInt3)
  {
    return newDebugImageFile(getTimeTag(), paramInt1, paramInt2, paramInt3);
  }
  
  private static File newDebugImageFile(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_id=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    paramString = new File("/sdcard/tavkit_demo/TAV调试图片");
    if ((!paramString.exists()) && (!paramString.mkdir()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mkdir return false, path = ");
      ((StringBuilder)localObject).append(paramString.getAbsolutePath());
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    return new File("/sdcard/tavkit_demo/TAV调试图片", (String)localObject);
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
    RendererWrapper localRendererWrapper = new RendererWrapper();
    localRendererWrapper.setOutputTextureInfo(localTextureInfo);
    paramCIImage.drawTo(localRendererWrapper);
    return saveBitmap(localTextureInfo);
  }
  
  public static String saveBitmapToFile(Bitmap paramBitmap)
  {
    return saveBitmapToFile(paramBitmap, newDebugImageFile(0, paramBitmap.getWidth(), paramBitmap.getHeight()));
  }
  
  public static String saveBitmapToFile(Bitmap paramBitmap, File paramFile)
  {
    if (paramFile.createNewFile())
    {
      Object localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 0, (OutputStream)localObject);
      paramBitmap = ((ByteArrayOutputStream)localObject).toByteArray();
      localObject = new FileOutputStream(paramFile);
      ((FileOutputStream)localObject).write(paramBitmap);
      ((FileOutputStream)localObject).flush();
      ((FileOutputStream)localObject).close();
      return paramFile.getAbsolutePath();
    }
    paramBitmap = new StringBuilder();
    paramBitmap.append("createNewFile return false, path = ");
    paramBitmap.append(paramFile.getAbsolutePath());
    throw new RuntimeException(paramBitmap.toString());
  }
  
  public static String saveBitmapToFile(TextureInfo paramTextureInfo)
  {
    return saveBitmapToFile(paramTextureInfo, getTimeTag());
  }
  
  public static String saveBitmapToFile(TextureInfo paramTextureInfo, File paramFile)
  {
    return saveBitmapToFile(saveBitmap(paramTextureInfo), paramFile);
  }
  
  public static String saveBitmapToFile(TextureInfo paramTextureInfo, String paramString)
  {
    return saveBitmapToFile(paramTextureInfo, newDebugImageFile(paramString, paramTextureInfo.textureID, paramTextureInfo.width, paramTextureInfo.height));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.TAVGLUtils
 * JD-Core Version:    0.7.0.1
 */