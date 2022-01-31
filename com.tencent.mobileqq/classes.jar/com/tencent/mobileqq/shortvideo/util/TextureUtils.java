package com.tencent.mobileqq.shortvideo.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.os.Environment;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

public class TextureUtils
{
  public static String fileFolder = Environment.getExternalStorageDirectory() + "/testBitmap/";
  
  public static Bitmap convertFrameToBitmap(Frame paramFrame)
  {
    return convertTexToBitmap(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public static Bitmap convertTexToBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    ByteBuffer localByteBuffer = readTextureToByteBuffer(paramInt1, paramInt2, paramInt3);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(localByteBuffer);
    return localBitmap;
  }
  
  public static ByteBuffer readTextureToByteBuffer(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static boolean saveFrameToFile(Frame paramFrame, String paramString)
  {
    if (!FileUtils.fileExists(fileFolder)) {}
    for (;;)
    {
      return false;
      paramFrame = convertTexToBitmap(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      paramString = new File(fileFolder, paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      try
      {
        paramString = new FileOutputStream(paramString);
        paramFrame.compress(Bitmap.CompressFormat.JPEG, 20, paramString);
        paramString.flush();
        paramString.close();
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return false;
      }
      finally
      {
        if (!paramFrame.isRecycled()) {
          paramFrame.recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.TextureUtils
 * JD-Core Version:    0.7.0.1
 */