package com.tencent.xweb.skia_canvas;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SkiaCanvasView
  implements VSyncRenderer.PresentCallback
{
  private static final String TAG = "SkiaCanvasView";
  private final SkiaCanvasApp mApp;
  private volatile boolean mIsForeground;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private final String mTag;
  private final long mViewID;
  
  public SkiaCanvasView(@NonNull SkiaCanvasApp paramSkiaCanvasApp, SurfaceTexture paramSurfaceTexture, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SkiaCanvasView created ");
    localStringBuilder.append(this);
    Log.d("SkiaCanvasView", localStringBuilder.toString());
    this.mApp = paramSkiaCanvasApp;
    this.mTag = paramString;
    this.mViewID = paramLong;
    checkAndPost(new SkiaCanvasView.1(this, paramSurfaceTexture));
  }
  
  private void checkAndPost(Runnable paramRunnable)
  {
    this.mApp.checkAndPostOnWorkingThread(paramRunnable);
  }
  
  private native void nativeCreateCanvas(String paramString, long paramLong, Surface paramSurface);
  
  private native void nativeDoPresent(long paramLong);
  
  private native void nativeRemoveCanvas(long paramLong);
  
  private native void nativeSwapSurface(long paramLong, Surface paramSurface);
  
  private native boolean nativeUpdateBitmap(long paramLong, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private void notifyTextureSizeChanged(int paramInt1, int paramInt2)
  {
    if (this.mApp.isRunOnWorkingThread())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyTextureSizeChanged called with ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" / ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" this: ");
      localStringBuilder.append(this);
      Log.d("SkiaCanvasView", localStringBuilder.toString());
      this.mSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
      return;
    }
    throw new IllegalStateException("notifyTextureSizeChanged must be called on js thread.");
  }
  
  public static String version()
  {
    return "c39d6bd49fe0bd05eb2046ec30380d3b719a9078/1.0";
  }
  
  public void doPresent()
  {
    if (this.mIsForeground)
    {
      nativeDoPresent(this.mViewID);
      VSyncRenderer.getInstance().triggerNextVSync();
    }
  }
  
  public long getId()
  {
    return this.mViewID;
  }
  
  @Nullable
  public Bitmap getSnapshot(Rect paramRect)
  {
    if (this.mApp.isRunOnWorkingThread())
    {
      if (paramRect.width() > 0)
      {
        if (paramRect.height() <= 0) {
          return null;
        }
        Bitmap localBitmap = Bitmap.createBitmap(paramRect.width(), paramRect.height(), Bitmap.Config.ARGB_8888);
        if (nativeUpdateBitmap(this.mViewID, localBitmap, paramRect.left, paramRect.top, paramRect.width(), paramRect.height())) {
          return localBitmap;
        }
      }
      return null;
    }
    throw new IllegalStateException("getSnapshot must be called on js thread.");
  }
  
  public void notifyVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean != this.mIsForeground)
    {
      this.mIsForeground = paramBoolean;
      if (paramBoolean) {
        checkAndPost(new SkiaCanvasView.2(this));
      }
    }
  }
  
  public void recycle()
  {
    checkAndPost(new SkiaCanvasView.3(this));
  }
  
  public void swapSurface(SurfaceTexture paramSurfaceTexture)
  {
    checkAndPost(new SkiaCanvasView.4(this, paramSurfaceTexture));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasView
 * JD-Core Version:    0.7.0.1
 */