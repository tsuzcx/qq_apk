package com.tencent.tav.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;
import java.util.HashMap;

public class ImageDecoder
  implements IVideoDecoder
{
  public static String EXTRA_INFO_KEY_DECODE_SIZE = "extra_info_key_decode_size";
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
    readExtraDecodeSize(paramParams);
    this.displaySize = paramParams.outputSize;
  }
  
  private void checkThread()
  {
    long l = this.threadId;
    if ((l != -1L) && (l != Thread.currentThread().getId()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("线程不对，注意EGL相关的泄露问题！threadId = ");
      localStringBuilder.append(this.threadId);
      localStringBuilder.append(", Thread.currentThread() name = ");
      localStringBuilder.append(Thread.currentThread().getName());
      Logger.e("ImageDecoder", localStringBuilder.toString(), new RuntimeException());
    }
  }
  
  private TextureInfo createTexture()
  {
    try
    {
      if ((this.textureInfo != null) && (!this.textureInfo.isReleased()))
      {
        localObject1 = this.textureInfo;
        return localObject1;
      }
      if (this.bitmap == null)
      {
        this.bitmap = decodeBitmap(this.sourceImagePath, this.displaySize);
        this.bitmap = TAVImageFactory.fixSupportImageConfig(this.bitmap);
        this.preferRotation = readImagePreferRotation(this.sourceImagePath);
      }
      if (this.bitmap != null)
      {
        this.threadId = Thread.currentThread().getId();
        localObject1 = getImageTextureMatrix();
        this.textureInfo = new TextureInfo(RenderContext.createTexture(3553), 3553, this.bitmap.getWidth(), this.bitmap.getHeight(), (Matrix)localObject1, this.preferRotation);
        GLES20.glBindTexture(3553, this.textureInfo.textureID);
        GLUtils.texImage2D(3553, 0, this.bitmap, 0);
        GLES20.glBindTexture(3553, 0);
        localObject1 = this.textureInfo;
        return localObject1;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createTexture: bitmap is null! path = ");
      ((StringBuilder)localObject1).append(this.sourceImagePath);
      Logger.e("ImageDecoder", ((StringBuilder)localObject1).toString(), new RuntimeException("堆栈"));
      return null;
    }
    finally {}
  }
  
  private Bitmap decodeBitmap(String paramString, CGSize paramCGSize)
  {
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    int i = 1;
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
  
  private void readExtraDecodeSize(IVideoDecoder.Params paramParams)
  {
    if (paramParams.extraInfo == null) {
      return;
    }
    Object localObject = paramParams.extraInfo.get(EXTRA_INFO_KEY_DECODE_SIZE);
    if ((localObject instanceof CGSize)) {
      paramParams.outputSize = ((CGSize)localObject);
    }
  }
  
  private static int readImagePreferRotation(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      if (i != 3)
      {
        if (i != 6)
        {
          if (i != 8) {
            return 0;
          }
          return 1;
        }
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
  
  public CMSampleState readSample(CMTime paramCMTime)
  {
    try
    {
      if (paramCMTime.getTimeUs() >= this.timeRange.getDuration().getTimeUs())
      {
        paramCMTime = CMSampleState.fromError(-1L);
        return paramCMTime;
      }
      createTexture();
      paramCMTime = new CMSampleState(paramCMTime);
      return paramCMTime;
    }
    finally {}
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