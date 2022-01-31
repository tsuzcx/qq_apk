package me.ele.uetool.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import java.nio.ByteBuffer;

@RequiresApi(api=21)
public class ImageCapture
{
  private boolean isCapturing;
  private Bitmap mBitmap;
  private ImageReader mImageReader;
  private MediaProjection mMediaProjection;
  private MediaProjectionManager mMediaProjectionManager;
  
  public void capture()
  {
    if (this.isCapturing) {}
    Image localImage;
    do
    {
      return;
      this.isCapturing = true;
      localImage = this.mImageReader.acquireLatestImage();
    } while (localImage == null);
    int i = localImage.getWidth();
    int j = localImage.getHeight();
    Object localObject = localImage.getPlanes();
    ByteBuffer localByteBuffer = localObject[0].getBuffer();
    int k = localObject[0].getPixelStride();
    localObject = Bitmap.createBitmap((localObject[0].getRowStride() - k * i) / k + i, j, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).copyPixelsFromBuffer(localByteBuffer);
    this.mBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, 0, i, j);
    localImage.close();
    this.isCapturing = false;
  }
  
  public void destroy()
  {
    this.mImageReader.close();
    this.mMediaProjection.stop();
    this.mMediaProjectionManager = null;
    this.mMediaProjection = null;
    this.mImageReader = null;
    if (this.mBitmap != null)
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
  }
  
  public Bitmap getPartBitmap(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = 0;
    if (this.mBitmap == null) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = i;
    if (i + paramInt3 > this.mBitmap.getWidth()) {
      j = this.mBitmap.getWidth() - paramInt3;
    }
    if (paramInt2 < 0) {}
    for (paramInt1 = k;; paramInt1 = paramInt2)
    {
      paramInt2 = paramInt1;
      if (paramInt1 + paramInt4 > this.mBitmap.getHeight()) {
        paramInt2 = this.mBitmap.getHeight() - paramInt4;
      }
      return Bitmap.createBitmap(this.mBitmap, j, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void init(Context paramContext, Bundle paramBundle)
  {
    this.mMediaProjectionManager = ((MediaProjectionManager)paramContext.getSystemService("media_projection"));
    if (this.mMediaProjectionManager != null)
    {
      paramContext = new Intent();
      paramContext.putExtras(paramBundle);
      this.mMediaProjection = this.mMediaProjectionManager.getMediaProjection(-1, paramContext);
    }
    int i = Util.getWidth();
    int j = Util.getRealHeightPixels();
    int k = Util.getDensityDpi();
    this.mImageReader = ImageReader.newInstance(i, j, 1, 2);
    this.mMediaProjection.createVirtualDisplay("ScreenCapture", i, j, k, 16, this.mImageReader.getSurface(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.util.ImageCapture
 * JD-Core Version:    0.7.0.1
 */