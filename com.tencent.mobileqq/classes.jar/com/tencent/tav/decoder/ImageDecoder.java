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
import java.nio.ByteBuffer;

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
  
  private void checkThread()
  {
    if (this.threadId != Thread.currentThread().getId()) {
      Logger.e("ImageDecoder", "Thread wrong!! ", new RuntimeException());
    }
  }
  
  /* Error */
  private TextureInfo createTexture()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   6: ifnull +22 -> 28
    //   9: aload_0
    //   10: getfield 86	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   13: invokevirtual 92	com/tencent/tav/coremedia/TextureInfo:isReleased	()Z
    //   16: ifne +12 -> 28
    //   19: aload_0
    //   20: getfield 86	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: getfield 94	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   32: ifnonnull +30 -> 62
    //   35: aload_0
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 96	com/tencent/tav/decoder/ImageDecoder:sourceImagePath	Ljava/lang/String;
    //   41: aload_0
    //   42: getfield 98	com/tencent/tav/decoder/ImageDecoder:displaySize	Lcom/tencent/tav/coremedia/CGSize;
    //   45: invokespecial 102	com/tencent/tav/decoder/ImageDecoder:decodeBitmap	(Ljava/lang/String;Lcom/tencent/tav/coremedia/CGSize;)Landroid/graphics/Bitmap;
    //   48: putfield 94	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 96	com/tencent/tav/decoder/ImageDecoder:sourceImagePath	Ljava/lang/String;
    //   56: invokestatic 106	com/tencent/tav/decoder/ImageDecoder:readImagePreferRotation	(Ljava/lang/String;)I
    //   59: putfield 44	com/tencent/tav/decoder/ImageDecoder:preferRotation	I
    //   62: aload_0
    //   63: getfield 94	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   66: ifnull +97 -> 163
    //   69: aload_0
    //   70: invokestatic 67	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   73: invokevirtual 71	java/lang/Thread:getId	()J
    //   76: putfield 60	com/tencent/tav/decoder/ImageDecoder:threadId	J
    //   79: aload_0
    //   80: invokespecial 110	com/tencent/tav/decoder/ImageDecoder:getImageTextureMatrix	()Landroid/graphics/Matrix;
    //   83: astore_1
    //   84: aload_0
    //   85: new 88	com/tencent/tav/coremedia/TextureInfo
    //   88: dup
    //   89: sipush 3553
    //   92: invokestatic 115	com/tencent/tav/decoder/RenderContext:createTexture	(I)I
    //   95: sipush 3553
    //   98: aload_0
    //   99: getfield 94	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   102: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   105: aload_0
    //   106: getfield 94	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   109: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   112: aload_1
    //   113: aload_0
    //   114: getfield 44	com/tencent/tav/decoder/ImageDecoder:preferRotation	I
    //   117: invokespecial 127	com/tencent/tav/coremedia/TextureInfo:<init>	(IIIILandroid/graphics/Matrix;I)V
    //   120: putfield 86	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   123: sipush 3553
    //   126: aload_0
    //   127: getfield 86	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   130: getfield 130	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   133: invokestatic 136	android/opengl/GLES20:glBindTexture	(II)V
    //   136: sipush 3553
    //   139: iconst_0
    //   140: aload_0
    //   141: getfield 94	com/tencent/tav/decoder/ImageDecoder:bitmap	Landroid/graphics/Bitmap;
    //   144: iconst_0
    //   145: invokestatic 142	android/opengl/GLUtils:texImage2D	(IILandroid/graphics/Bitmap;I)V
    //   148: sipush 3553
    //   151: iconst_0
    //   152: invokestatic 136	android/opengl/GLES20:glBindTexture	(II)V
    //   155: aload_0
    //   156: getfield 86	com/tencent/tav/decoder/ImageDecoder:textureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   159: astore_1
    //   160: goto -136 -> 24
    //   163: aconst_null
    //   164: astore_1
    //   165: goto -141 -> 24
    //   168: astore_1
    //   169: aload_0
    //   170: monitorexit
    //   171: aload_1
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	ImageDecoder
    //   23	142	1	localObject1	Object
    //   168	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	168	finally
    //   28	62	168	finally
    //   62	160	168	finally
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
  
  public void init(String paramString, CGSize paramCGSize, IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    this.sourceImagePath = paramString;
    this.displaySize = paramCGSize;
  }
  
  public boolean isLastFrameValid()
  {
    return true;
  }
  
  public CMTime nextFrameTime(CMTime paramCMTime)
  {
    return paramCMTime.add(this.frameDuration);
  }
  
  public ByteBuffer outputBuffer()
  {
    return null;
  }
  
  public Surface outputSurface()
  {
    return null;
  }
  
  public CMTime readSample()
  {
    return readSample(this.currentDecoderTime.add(this.frameDuration));
  }
  
  /* Error */
  public CMTime readSample(CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_0
    //   4: getfield 218	com/tencent/tav/decoder/ImageDecoder:timeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   7: invokevirtual 223	com/tencent/tav/coremedia/CMTimeRange:getDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   10: invokevirtual 227	com/tencent/tav/coremedia/CMTime:bigThan	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   13: ifeq +11 -> 24
    //   16: getstatic 232	com/tencent/tav/decoder/IDecoder:SAMPLE_TIME_FINISH	Lcom/tencent/tav/coremedia/CMTime;
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: invokespecial 234	com/tencent/tav/decoder/ImageDecoder:createTexture	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   28: pop
    //   29: goto -9 -> 20
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	ImageDecoder
    //   0	37	1	paramCMTime	CMTime
    // Exception table:
    //   from	to	target	type
    //   2	20	32	finally
    //   24	29	32	finally
  }
  
  public void release() {}
  
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
  
  public void switchFrame() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.ImageDecoder
 * JD-Core Version:    0.7.0.1
 */