package com.tencent.mobileqq.shortvideo.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.os.Environment;
import com.tencent.aekit.openrender.internal.Frame;
import java.nio.ByteBuffer;

public class TextureUtils
{
  public static String fileFolder;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/testBitmap/");
    fileFolder = localStringBuilder.toString();
  }
  
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
  
  /* Error */
  public static boolean saveFrameToFile(Frame paramFrame, String paramString)
  {
    // Byte code:
    //   0: getstatic 34	com/tencent/mobileqq/shortvideo/util/TextureUtils:fileFolder	Ljava/lang/String;
    //   3: invokestatic 121	com/tencent/mobileqq/activity/richmedia/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   6: ifne +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_0
    //   12: invokevirtual 44	com/tencent/aekit/openrender/internal/Frame:getTextureId	()I
    //   15: aload_0
    //   16: getfield 48	com/tencent/aekit/openrender/internal/Frame:width	I
    //   19: aload_0
    //   20: getfield 51	com/tencent/aekit/openrender/internal/Frame:height	I
    //   23: invokestatic 55	com/tencent/mobileqq/shortvideo/util/TextureUtils:convertTexToBitmap	(III)Landroid/graphics/Bitmap;
    //   26: astore_0
    //   27: new 123	java/io/File
    //   30: dup
    //   31: getstatic 34	com/tencent/mobileqq/shortvideo/util/TextureUtils:fileFolder	Ljava/lang/String;
    //   34: aload_1
    //   35: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 130	java/io/File:exists	()Z
    //   43: ifeq +8 -> 51
    //   46: aload_1
    //   47: invokevirtual 133	java/io/File:delete	()Z
    //   50: pop
    //   51: new 135	java/io/FileOutputStream
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 138	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   59: astore_1
    //   60: aload_0
    //   61: getstatic 144	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   64: bipush 20
    //   66: aload_1
    //   67: invokevirtual 148	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   70: pop
    //   71: aload_1
    //   72: invokevirtual 151	java/io/FileOutputStream:flush	()V
    //   75: aload_1
    //   76: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   79: aload_0
    //   80: invokevirtual 157	android/graphics/Bitmap:isRecycled	()Z
    //   83: ifne +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 160	android/graphics/Bitmap:recycle	()V
    //   90: iconst_1
    //   91: ireturn
    //   92: astore_1
    //   93: goto +21 -> 114
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   101: aload_0
    //   102: invokevirtual 157	android/graphics/Bitmap:isRecycled	()Z
    //   105: ifne +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 160	android/graphics/Bitmap:recycle	()V
    //   112: iconst_0
    //   113: ireturn
    //   114: aload_0
    //   115: invokevirtual 157	android/graphics/Bitmap:isRecycled	()Z
    //   118: ifne +7 -> 125
    //   121: aload_0
    //   122: invokevirtual 160	android/graphics/Bitmap:recycle	()V
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramFrame	Frame
    //   0	127	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   51	79	92	finally
    //   97	101	92	finally
    //   51	79	96	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.TextureUtils
 * JD-Core Version:    0.7.0.1
 */