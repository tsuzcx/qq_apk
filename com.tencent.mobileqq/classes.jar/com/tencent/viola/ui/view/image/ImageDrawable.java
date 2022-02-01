package com.tencent.viola.ui.view.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView.ScaleType;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;

public class ImageDrawable
  extends PaintDrawable
{
  private int bitmapHeight;
  private int bitmapWidth;
  private Bitmap mBitmap;
  private float[] radii = new float[8];
  private float radius;
  
  public static void blurImage(Drawable paramDrawable, ImageView.ScaleType paramScaleType, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageDrawable.OnImageDrawableListener paramOnImageDrawableListener)
  {
    if ((paramDrawable == null) || (paramInt1 < 0) || (paramInt2 < 0)) {
      return;
    }
    if (isMainThread())
    {
      ViolaSDKManager.getInstance().postOnThreadPool(new ImageDrawable.3(paramDrawable, paramScaleType, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramOnImageDrawableListener));
      return;
    }
    internalBlurImage(paramDrawable, paramScaleType, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramOnImageDrawableListener);
  }
  
  private static ImageDrawable createFromBitmap(Bitmap paramBitmap, ImageView.ScaleType paramScaleType, int paramInt1, int paramInt2)
  {
    ImageDrawable localImageDrawable = new ImageDrawable();
    localImageDrawable.bitmapWidth = paramBitmap.getWidth();
    localImageDrawable.bitmapHeight = paramBitmap.getHeight();
    localImageDrawable.setBitmap(paramBitmap);
    paramBitmap = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    updateShaderAndSize(paramScaleType, paramInt1, paramInt2, localImageDrawable, paramBitmap);
    localImageDrawable.getPaint().setShader(paramBitmap);
    return localImageDrawable;
  }
  
  private static ImageDrawable createFromDrawable(Drawable paramDrawable, ImageView.ScaleType paramScaleType, int paramInt1, int paramInt2)
  {
    if (paramDrawable == null) {}
    do
    {
      return null;
      localObject = drawableToBitmap(paramDrawable, paramInt1, paramInt2, paramScaleType);
    } while (localObject == null);
    paramDrawable = new ImageDrawable();
    paramDrawable.bitmapWidth = ((Bitmap)localObject).getWidth();
    paramDrawable.bitmapHeight = ((Bitmap)localObject).getHeight();
    paramDrawable.setBitmap((Bitmap)localObject);
    Object localObject = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    updateShaderAndSize(paramScaleType, paramInt1, paramInt2, paramDrawable, (BitmapShader)localObject);
    paramDrawable.getPaint().setShader((Shader)localObject);
    return paramDrawable;
  }
  
  public static void createImageDrawableForRound(Drawable paramDrawable, ImageView.ScaleType paramScaleType, int paramInt1, int paramInt2, String paramString, ImageDrawable.OnImageDrawableListener paramOnImageDrawableListener)
  {
    if ((paramDrawable == null) || (paramInt1 < 0) || (paramInt2 < 0)) {
      return;
    }
    if (isMainThread())
    {
      ViolaSDKManager.getInstance().postOnThreadPool(new ImageDrawable.1(paramDrawable, paramScaleType, paramInt1, paramInt2, paramString, paramOnImageDrawableListener));
      return;
    }
    internalCreateImageDrawableForRound(paramDrawable, paramScaleType, paramInt1, paramInt2, paramString, paramOnImageDrawableListener);
  }
  
  public static void createRoundImageAndBlur(Drawable paramDrawable, ImageView.ScaleType paramScaleType, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageDrawable.OnImageDrawableListener paramOnImageDrawableListener)
  {
    if ((paramDrawable == null) || (paramInt2 < 0) || (paramInt3 < 0)) {
      return;
    }
    if (isMainThread())
    {
      ViolaSDKManager.getInstance().postOnThreadPool(new ImageDrawable.5(paramDrawable, paramScaleType, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramOnImageDrawableListener));
      return;
    }
    internalRoundImageAndBlur(paramDrawable, paramScaleType, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramOnImageDrawableListener);
  }
  
  private static Bitmap createScaleBitmapForBlur(Drawable paramDrawable, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, int paramInt3)
  {
    int i = 40;
    paramDrawable = drawableToBitmap(paramDrawable, paramInt1, paramInt2, paramScaleType);
    if ((paramDrawable != null) && (paramInt1 != 0) && (paramInt2 != 0))
    {
      int j = paramInt1 / paramInt3;
      paramInt2 /= paramInt3;
      paramInt1 = j;
      if (j == 0) {
        paramInt1 = 40;
      }
      if (paramInt2 != 0) {
        break label63;
      }
      paramInt2 = i;
    }
    label63:
    for (;;)
    {
      return Bitmap.createScaledBitmap(paramDrawable, paramInt1, paramInt2, false);
      return null;
    }
  }
  
  @NonNull
  private static Matrix createShaderMatrix(@NonNull ImageView.ScaleType paramScaleType, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2;
    float f3;
    float f1;
    Matrix localMatrix;
    if (paramInt3 * paramInt2 > paramInt4 * paramInt1)
    {
      f2 = paramInt2 / paramInt4;
      f3 = paramInt1;
      float f4 = paramInt3;
      f1 = f2;
      f2 = (f3 - f4 * f2) * 0.5F;
      f4 = 0.0F;
      f3 = f1;
      f1 = f4;
      localMatrix = new Matrix();
      if (paramScaleType != ImageView.ScaleType.FIT_XY) {
        break label116;
      }
      localMatrix.setScale(paramInt1 / paramInt3, paramInt2 / paramInt4);
    }
    label116:
    do
    {
      return localMatrix;
      f3 = paramInt1 / paramInt3;
      f1 = (paramInt2 - paramInt4 * f3) * 0.5F;
      f2 = 0.0F;
      break;
      if (paramScaleType == ImageView.ScaleType.FIT_CENTER)
      {
        localMatrix.setRectToRect(new RectF(0.0F, 0.0F, paramInt3, paramInt4), new RectF(0.0F, 0.0F, paramInt1, paramInt2), Matrix.ScaleToFit.CENTER);
        return localMatrix;
      }
    } while (paramScaleType != ImageView.ScaleType.CENTER_CROP);
    localMatrix.setScale(f3, f3);
    localMatrix.postTranslate(f2 + 0.5F, f1 + 0.5F);
    return localMatrix;
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    int i = paramInt1;
    int j = paramInt2;
    try
    {
      if (paramDrawable.getIntrinsicHeight() > 0)
      {
        i = paramInt1;
        j = paramInt2;
        if (paramDrawable.getIntrinsicWidth() > 0)
        {
          if (paramScaleType != ImageView.ScaleType.CENTER_CROP) {
            break label94;
          }
          i = paramDrawable.getIntrinsicWidth();
          j = paramDrawable.getIntrinsicHeight();
        }
      }
      if (paramDrawable.getOpacity() != -1) {}
      for (paramScaleType = Bitmap.Config.ARGB_8888;; paramScaleType = Bitmap.Config.RGB_565)
      {
        paramScaleType = Bitmap.createBitmap(i, j, paramScaleType);
        Canvas localCanvas = new Canvas(paramScaleType);
        paramDrawable.setBounds(0, 0, i, j);
        paramDrawable.draw(localCanvas);
        return paramScaleType;
        label94:
        int k = paramInt1;
        if (paramInt1 > paramDrawable.getIntrinsicWidth()) {
          k = paramDrawable.getIntrinsicWidth();
        }
        i = k;
        j = paramInt2;
        if (paramInt2 <= paramDrawable.getIntrinsicHeight()) {
          break;
        }
        j = paramDrawable.getIntrinsicHeight();
        i = k;
        break;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable) {}
  }
  
  private static void internalBlurImage(Drawable paramDrawable, ImageView.ScaleType paramScaleType, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageDrawable.OnImageDrawableListener paramOnImageDrawableListener)
  {
    try
    {
      paramScaleType = createScaleBitmapForBlur(paramDrawable, paramInt1, paramInt2, paramScaleType, paramInt4);
      if (paramScaleType != null)
      {
        ViolaUtils.fastblur(paramScaleType, paramInt3);
        ViolaSDKManager.getInstance().postOnUiThread(new ImageDrawable.4(paramOnImageDrawableListener, paramScaleType, paramString));
      }
      return;
    }
    catch (Throwable paramScaleType)
    {
      do
      {
        ViolaLogUtils.e("ImageDrawable", paramScaleType.getMessage());
      } while (paramOnImageDrawableListener == null);
      paramOnImageDrawableListener.getDrawable(paramDrawable, paramString);
    }
  }
  
  private static void internalCreateImageDrawableForRound(Drawable paramDrawable, ImageView.ScaleType paramScaleType, int paramInt1, int paramInt2, String paramString, ImageDrawable.OnImageDrawableListener paramOnImageDrawableListener)
  {
    paramDrawable = createFromDrawable(paramDrawable, paramScaleType, paramInt1, paramInt2);
    ViolaSDKManager.getInstance().postOnUiThread(new ImageDrawable.2(paramOnImageDrawableListener, paramDrawable, paramString));
  }
  
  private static void internalRoundImageAndBlur(Drawable paramDrawable, ImageView.ScaleType paramScaleType, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageDrawable.OnImageDrawableListener paramOnImageDrawableListener)
  {
    ImageDrawable localImageDrawable = null;
    try
    {
      Bitmap localBitmap = createScaleBitmapForBlur(paramDrawable, paramInt2, paramInt3, paramScaleType, paramInt4);
      if (localBitmap != null)
      {
        ViolaUtils.fastblur(localBitmap, paramInt1);
        localImageDrawable = createFromBitmap(localBitmap, paramScaleType, paramInt2, paramInt3);
      }
      ViolaSDKManager.getInstance().postOnUiThread(new ImageDrawable.6(paramOnImageDrawableListener, localImageDrawable, paramString));
      return;
    }
    catch (Throwable paramScaleType)
    {
      if (paramOnImageDrawableListener != null) {
        paramOnImageDrawableListener.getDrawable(paramDrawable, paramString);
      }
      ViolaLogUtils.e("ImageDrawable", paramScaleType.getMessage());
    }
  }
  
  public static boolean isMainThread()
  {
    return Thread.currentThread() == Looper.getMainLooper().getThread();
  }
  
  private static void updateShaderAndSize(@NonNull ImageView.ScaleType paramScaleType, int paramInt1, int paramInt2, ImageDrawable paramImageDrawable, BitmapShader paramBitmapShader)
  {
    Matrix localMatrix = createShaderMatrix(paramScaleType, paramInt1, paramInt2, paramImageDrawable.bitmapWidth, paramImageDrawable.bitmapHeight);
    Object localObject = localMatrix;
    if (paramScaleType == ImageView.ScaleType.FIT_CENTER)
    {
      localObject = new RectF(0.0F, 0.0F, paramImageDrawable.bitmapWidth, paramImageDrawable.bitmapHeight);
      RectF localRectF = new RectF();
      localMatrix.mapRect(localRectF, (RectF)localObject);
      paramInt1 = (int)localRectF.width();
      paramInt2 = (int)localRectF.height();
      localObject = createShaderMatrix(paramScaleType, paramInt1, paramInt2, paramImageDrawable.bitmapWidth, paramImageDrawable.bitmapHeight);
    }
    paramImageDrawable.setIntrinsicWidth(paramInt1);
    paramImageDrawable.setIntrinsicHeight(paramInt2);
    paramBitmapShader.setLocalMatrix((Matrix)localObject);
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public int getBitmapHeight()
  {
    return this.bitmapHeight;
  }
  
  public int getBitmapWidth()
  {
    return this.bitmapWidth;
  }
  
  @Nullable
  public float[] getCornerRadii()
  {
    return this.radii;
  }
  
  public float getCornerRadius()
  {
    return this.radius;
  }
  
  protected void onDraw(Shape paramShape, Canvas paramCanvas, Paint paramPaint)
  {
    if (Build.VERSION.SDK_INT == 21) {
      paramPaint.setAntiAlias(false);
    }
    super.onDraw(paramShape, paramCanvas, paramPaint);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }
  
  public void setCornerRadii(float[] paramArrayOfFloat)
  {
    this.radii = paramArrayOfFloat;
    super.setCornerRadii(paramArrayOfFloat);
  }
  
  public void setCornerRadius(float paramFloat)
  {
    this.radius = paramFloat;
    super.setCornerRadius(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.image.ImageDrawable
 * JD-Core Version:    0.7.0.1
 */