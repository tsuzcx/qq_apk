package com.tencent.tav.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;

public class ImageDecoder
  implements IVideoDecoder
{
  public static final CGSize IMAGE_DECODE_SIZE = new CGSize(720.0F, 1280.0F);
  private static final String TAG = "ImageDecoder";
  private Bitmap bitmap;
  private CMTime currentDecoderTime = CMTime.CMTimeInvalid;
  private CGSize displaySize;
  private CMTime frameDuration = new CMTime(1L, 30);
  private int preferRotation = 0;
  private String sourceImagePath;
  private TextureInfo textureInfo;
  private long threadId = -1L;
  private CMTimeRange timeRange;
  
  public ImageDecoder(IVideoDecoder.Params paramParams)
  {
    this.sourceImagePath = paramParams.filePath;
    this.displaySize = paramParams.outputSize;
  }
  
  private void checkThread()
  {
    if ((this.threadId != -1L) && (this.threadId != Thread.currentThread().getId())) {
      Logger.e("ImageDecoder", "线程不对，注意EGL相关的泄露问题！threadId = " + this.threadId + ", Thread.currentThread() name = " + Thread.currentThread().getName(), new RuntimeException());
    }
  }
  
  /* Error */
  private TextureInfo createTexture()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   6: ifnull +22 -> 28
    //   9: aload_0
    //   10: getfield 118	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   13: invokevirtual 124	com/tencent/tav/coremedia/TextureInfo:isReleased	()Z
    //   16: ifne +12 -> 28
    //   19: aload_0
    //   20: getfield 118	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: getfield 126	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   32: ifnonnull +41 -> 73
    //   35: aload_0
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 68	com/tencent/tav/decoder/ImageDecoder:sourceImagePath	Ljava/lang/String;
    //   41: aload_0
    //   42: getfield 73	com/tencent/tav/decoder/ImageDecoder:displaySize	Lcom/tencent/tav/coremedia/CGSize;
    //   45: invokespecial 130	com/tencent/tav/decoder/ImageDecoder:decodeBitmap	(Ljava/lang/String;Lcom/tencent/tav/coremedia/CGSize;)Landroid/graphics/Bitmap;
    //   48: putfield 126	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 126	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   56: invokestatic 136	com/tencent/tav/decoder/TAVImageFactory:fixSupportImageConfig	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   59: putfield 126	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 68	com/tencent/tav/decoder/ImageDecoder:sourceImagePath	Ljava/lang/String;
    //   67: invokestatic 140	com/tencent/tav/decoder/ImageDecoder:readImagePreferRotation	(Ljava/lang/String;)I
    //   70: putfield 45	com/tencent/tav/decoder/ImageDecoder:preferRotation	I
    //   73: aload_0
    //   74: getfield 126	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   77: ifnull +97 -> 174
    //   80: aload_0
    //   81: invokestatic 80	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   84: invokevirtual 84	java/lang/Thread:getId	()J
    //   87: putfield 61	com/tencent/tav/decoder/ImageDecoder:threadId	J
    //   90: aload_0
    //   91: invokespecial 144	com/tencent/tav/decoder/ImageDecoder:getImageTextureMatrix	()Landroid/graphics/Matrix;
    //   94: astore_1
    //   95: aload_0
    //   96: new 120	com/tencent/tav/coremedia/TextureInfo
    //   99: dup
    //   100: sipush 3553
    //   103: invokestatic 149	com/tencent/tav/decoder/RenderContext:createTexture	(I)I
    //   106: sipush 3553
    //   109: aload_0
    //   110: getfield 126	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   113: invokevirtual 155	android/graphics/Bitmap:getWidth	()I
    //   116: aload_0
    //   117: getfield 126	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   120: invokevirtual 158	android/graphics/Bitmap:getHeight	()I
    //   123: aload_1
    //   124: aload_0
    //   125: getfield 45	com/tencent/tav/decoder/ImageDecoder:preferRotation	I
    //   128: invokespecial 161	com/tencent/tav/coremedia/TextureInfo:<init>	(IIIILandroid/graphics/Matrix;I)V
    //   131: putfield 118	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   134: sipush 3553
    //   137: aload_0
    //   138: getfield 118	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   141: getfield 164	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   144: invokestatic 170	android/opengl/GLES20:glBindTexture	(II)V
    //   147: sipush 3553
    //   150: iconst_0
    //   151: aload_0
    //   152: getfield 126	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   155: iconst_0
    //   156: invokestatic 176	android/opengl/GLUtils:texImage2D	(IILandroid/graphics/Bitmap;I)V
    //   159: sipush 3553
    //   162: iconst_0
    //   163: invokestatic 170	android/opengl/GLES20:glBindTexture	(II)V
    //   166: aload_0
    //   167: getfield 118	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   170: astore_1
    //   171: goto -147 -> 24
    //   174: ldc 12
    //   176: new 86	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   183: ldc 178
    //   185: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_0
    //   189: getfield 68	com/tencent/tav/decoder/ImageDecoder:sourceImagePath	Ljava/lang/String;
    //   192: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: new 107	java/lang/RuntimeException
    //   201: dup
    //   202: ldc 180
    //   204: invokespecial 183	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   207: invokestatic 114	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: aconst_null
    //   211: astore_1
    //   212: goto -188 -> 24
    //   215: astore_1
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_1
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	ImageDecoder
    //   23	189	1	localObject1	Object
    //   215	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	215	finally
    //   28	73	215	finally
    //   73	171	215	finally
    //   174	210	215	finally
  }
  
  private Bitmap decodeBitmap(String paramString, CGSize paramCGSize)
  {
    int i = 1;
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    localOptions1.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions1);
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    if (paramCGSize != null) {
      i = (int)(localOptions1.outWidth / paramCGSize.width);
    }
    localOptions2.inSampleSize = i;
    return BitmapFactory.decodeFile(paramString, localOptions2);
  }
  
  public static CGSize getDefaultOutputImageSize(String paramString)
  {
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    localOptions1.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions1);
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    localOptions2.inSampleSize = ((int)(localOptions1.outWidth / IMAGE_DECODE_SIZE.width));
    localOptions2.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions2);
    int i = localOptions2.outWidth;
    int j = localOptions2.outHeight;
    if (readImagePreferRotation(paramString) % 2 == 1) {
      return new CGSize(j, i);
    }
    return new CGSize(i, j);
  }
  
  @NonNull
  private Matrix getImageTextureMatrix()
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
    return localMatrix;
  }
  
  private static int readImagePreferRotation(String paramString)
  {
    int i = 1;
    try
    {
      int j = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (j)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        i = 0;
      case 8: 
        return i;
      case 6: 
        return 3;
      }
      return 2;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public String getSourcePath()
  {
    return this.sourceImagePath;
  }
  
  public TextureInfo getTextureInfo()
  {
    return this.textureInfo;
  }
  
  public boolean hasTrack()
  {
    return this.sourceImagePath != null;
  }
  
  public boolean isLastFrameValid()
  {
    return true;
  }
  
  public Surface outputSurface()
  {
    return null;
  }
  
  /* Error */
  public com.tencent.tav.coremedia.CMSampleState readSample(CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 246	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   6: aload_0
    //   7: getfield 248	com/tencent/tav/decoder/ImageDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   10: invokevirtual 254	com/tencent/tav/coremedia/CMTimeRange:getDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   13: invokevirtual 246	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   16: lcmp
    //   17: iflt +14 -> 31
    //   20: ldc2_w 58
    //   23: invokestatic 260	com/tencent/tav/coremedia/CMSampleState:fromError	(J)Lcom/tencent/tav/coremedia/CMSampleState;
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: areturn
    //   31: aload_0
    //   32: invokespecial 262	com/tencent/tav/decoder/ImageDecoder:createTexture	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   35: pop
    //   36: new 256	com/tencent/tav/coremedia/CMSampleState
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 265	com/tencent/tav/coremedia/CMSampleState:<init>	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   44: astore_1
    //   45: goto -18 -> 27
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	ImageDecoder
    //   0	53	1	paramCMTime	CMTime
    // Exception table:
    //   from	to	target	type
    //   2	27	48	finally
    //   31	45	48	finally
  }
  
  public void release(boolean paramBoolean)
  {
    try
    {
      checkThread();
      if (this.textureInfo != null)
      {
        this.textureInfo.release();
        this.textureInfo = null;
      }
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        this.bitmap.recycle();
        this.bitmap = null;
      }
      return;
    }
    finally {}
  }
  
  public void seekTo(CMTime paramCMTime) {}
  
  public void seekTo(CMTime paramCMTime, boolean paramBoolean) {}
  
  public void start(@Nullable CMTimeRange paramCMTimeRange)
  {
    start(paramCMTimeRange, CMTime.CMTimeZero);
  }
  
  public void start(CMTimeRange paramCMTimeRange, CMTime paramCMTime)
  {
    if (paramCMTimeRange == null)
    {
      this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.frameDuration);
      return;
    }
    this.timeRange = new CMTimeRange(paramCMTimeRange.getStart(), paramCMTimeRange.getDuration());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.ImageDecoder
 * JD-Core Version:    0.7.0.1
 */