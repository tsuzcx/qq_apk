package com.tencent.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;

public class BitmapUtil
{
  public static Bitmap a(Bitmap paramBitmap)
  {
    Paint localPaint = new Paint();
    localPaint.setMaskFilter(new BlurMaskFilter(1.0F, BlurMaskFilter.Blur.NORMAL));
    int[] arrayOfInt = new int[2];
    Bitmap localBitmap1 = paramBitmap.extractAlpha(localPaint, arrayOfInt);
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas();
    localCanvas.setBitmap(localBitmap2);
    localCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, localPaint);
    localCanvas.drawBitmap(paramBitmap, -arrayOfInt[0], -arrayOfInt[1], null);
    localBitmap1.recycle();
    return localBitmap2;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBitmap1 == null) {
      return null;
    }
    if (paramBitmap2 == null) {
      return paramBitmap1;
    }
    int i;
    if (paramInt3 == 0)
    {
      i = paramBitmap1.getWidth();
      paramInt3 = paramBitmap1.getHeight() + paramBitmap2.getHeight();
    }
    else
    {
      i = Math.max(paramBitmap1.getWidth(), paramBitmap2.getWidth());
      paramInt3 = Math.max(paramBitmap1.getHeight(), paramBitmap2.getHeight());
    }
    Bitmap localBitmap = Bitmap.createBitmap(i, paramInt3, paramBitmap1.getConfig());
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, new Matrix(), null);
    localCanvas.drawBitmap(paramBitmap2, paramInt1, paramInt2, null);
    return localBitmap;
  }
  
  public static Bitmap a(View paramView)
  {
    a(paramView);
    Object localObject2 = null;
    try
    {
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      Object localObject1 = localObject2;
      if (i != 0)
      {
        localObject1 = localObject2;
        if (j != 0)
        {
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          paramView.draw(new Canvas((Bitmap)localObject1));
        }
      }
      return localObject1;
    }
    catch (Exception|OutOfMemoryError paramView) {}
    return null;
  }
  
  public static StateListDrawable a(Resources paramResources, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Object localObject = null;
    if (paramBitmap1 != null)
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramResources, paramBitmap1);
      paramBitmap1 = localObject;
      if (paramBitmap2 != null) {
        paramBitmap1 = new BitmapDrawable(paramResources, paramBitmap2);
      }
      if (paramBitmap1 != null) {
        localStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramBitmap1);
      }
      localStateListDrawable.addState(new int[] { 16842908 }, localBitmapDrawable);
      localStateListDrawable.addState(new int[0], localBitmapDrawable);
      return localStateListDrawable;
    }
    return null;
  }
  
  private static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView.destroyDrawingCache();
      paramView.invalidate();
      int i = 0;
      for (;;)
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        if (i >= localViewGroup.getChildCount()) {
          break;
        }
        a(localViewGroup.getChildAt(i));
        i += 1;
      }
    }
    paramView.destroyDrawingCache();
    paramView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */