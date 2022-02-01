package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class PuzzleAvatarUtil
{
  @Nullable
  public static Bitmap a(int paramInt, Bitmap.Config paramConfig, Bitmap[] paramArrayOfBitmap)
  {
    if ((paramArrayOfBitmap != null) && (paramArrayOfBitmap.length > 0))
    {
      Object localObject2 = new ArrayList(paramArrayOfBitmap.length);
      int j = paramArrayOfBitmap.length;
      int i = 0;
      Object localObject1;
      while (i < j)
      {
        localObject1 = paramArrayOfBitmap[i];
        if (localObject1 != null)
        {
          ((ArrayList)localObject2).add(localObject1);
          if (((ArrayList)localObject2).size() >= 6) {
            break;
          }
        }
        i += 1;
      }
      j = ((ArrayList)localObject2).size();
      if (j > 0)
      {
        if (paramConfig == null) {
          paramConfig = Bitmap.Config.RGB_565;
        }
        PuzzleAvatarUtil.PuzzleParams[] arrayOfPuzzleParams = new PuzzleAvatarUtil.PuzzleParams[j];
        i = 0;
        while (i < j)
        {
          arrayOfPuzzleParams[i] = new PuzzleAvatarUtil.PuzzleParams(null);
          i += 1;
        }
        float f = paramInt / 100.0F;
        int k;
        int m;
        if (j == 1)
        {
          arrayOfPuzzleParams[0].a = 0;
          arrayOfPuzzleParams[0].b = 0;
          i = paramInt;
        }
        else if (j == 2)
        {
          i = (int)(f * 60.0F + 0.5F);
          arrayOfPuzzleParams[0].a = 0;
          arrayOfPuzzleParams[0].b = 0;
          paramArrayOfBitmap = arrayOfPuzzleParams[1];
          k = paramInt - i;
          paramArrayOfBitmap.a = k;
          arrayOfPuzzleParams[1].b = k;
        }
        else if (j == 3)
        {
          i = (int)(52.0F * f + 0.5F);
          paramArrayOfBitmap = arrayOfPuzzleParams[0];
          k = paramInt - i;
          paramArrayOfBitmap.a = (k / 2);
          paramArrayOfBitmap = arrayOfPuzzleParams[0];
          m = (int)(f * 2.0F);
          paramArrayOfBitmap.b = m;
          arrayOfPuzzleParams[1].a = k;
          paramArrayOfBitmap = arrayOfPuzzleParams[1];
          k -= m;
          paramArrayOfBitmap.b = k;
          arrayOfPuzzleParams[2].a = 0;
          arrayOfPuzzleParams[2].b = k;
        }
        else if (j == 4)
        {
          i = (int)(f * 52.0F + 0.5F);
          paramArrayOfBitmap = arrayOfPuzzleParams[0];
          k = paramInt - i;
          paramArrayOfBitmap.a = k;
          arrayOfPuzzleParams[0].b = 0;
          arrayOfPuzzleParams[1].a = k;
          arrayOfPuzzleParams[1].b = k;
          arrayOfPuzzleParams[2].a = 0;
          arrayOfPuzzleParams[2].b = k;
          arrayOfPuzzleParams[3].a = 0;
          arrayOfPuzzleParams[3].b = 0;
        }
        else
        {
          int i1;
          int n;
          if (j == 5)
          {
            i = (int)(40.0F * f + 0.5F);
            paramArrayOfBitmap = arrayOfPuzzleParams[0];
            i1 = paramInt - i;
            paramArrayOfBitmap.a = i1;
            paramArrayOfBitmap = arrayOfPuzzleParams[0];
            k = (int)(24.0F * f + 0.5F);
            paramArrayOfBitmap.b = k;
            paramArrayOfBitmap = arrayOfPuzzleParams[1];
            m = (int)(12.0F * f + 0.5F);
            paramArrayOfBitmap.a = (i1 - m);
            paramArrayOfBitmap = arrayOfPuzzleParams[1];
            n = (int)(2.0F * f + 0.5F);
            i1 -= n;
            paramArrayOfBitmap.b = i1;
            arrayOfPuzzleParams[2].a = m;
            arrayOfPuzzleParams[2].b = i1;
            arrayOfPuzzleParams[3].a = 0;
            arrayOfPuzzleParams[3].b = k;
            arrayOfPuzzleParams[4].a = ((int)(f * 30.0F + 0.5F));
            arrayOfPuzzleParams[4].b = n;
          }
          else if (j >= 6)
          {
            i = (int)(36.0F * f + 0.5F);
            paramArrayOfBitmap = arrayOfPuzzleParams[0];
            k = (int)(2.0F * f + 0.5F);
            paramArrayOfBitmap.b = k;
            paramArrayOfBitmap = arrayOfPuzzleParams[0];
            int i2 = paramInt - i;
            m = (int)(15.0F * f + 0.5F);
            n = i2 - m;
            paramArrayOfBitmap.a = n;
            paramArrayOfBitmap = arrayOfPuzzleParams[1];
            i1 = (int)(f * 32.0F + 0.5F);
            paramArrayOfBitmap.b = i1;
            arrayOfPuzzleParams[1].a = i2;
            paramArrayOfBitmap = arrayOfPuzzleParams[2];
            i2 -= k;
            paramArrayOfBitmap.b = i2;
            arrayOfPuzzleParams[2].a = n;
            arrayOfPuzzleParams[3].b = i2;
            arrayOfPuzzleParams[3].a = m;
            arrayOfPuzzleParams[4].b = i1;
            arrayOfPuzzleParams[4].a = 0;
            arrayOfPuzzleParams[5].b = k;
            arrayOfPuzzleParams[5].a = m;
          }
          else
          {
            i = 0;
          }
        }
        RectF localRectF = new RectF();
        Rect localRect = new Rect();
        localObject1 = new Paint();
        ((Paint)localObject1).setAntiAlias(true);
        ((Paint)localObject1).setDither(true);
        ((Paint)localObject1).setFilterBitmap(true);
        Bitmap localBitmap = Bitmap.createBitmap(paramInt, paramInt, paramConfig);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawARGB(0, 0, 0, 0);
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localPaint.setDither(true);
        localPaint.setFilterBitmap(true);
        localPaint.setColor(0);
        paramInt = 0;
        paramConfig = null;
        paramArrayOfBitmap = (Bitmap[])localObject2;
        while (paramInt < j)
        {
          localObject2 = (Bitmap)paramArrayOfBitmap.get(paramInt);
          k = i / 2;
          m = i * 3 / 40;
          localRectF.set(arrayOfPuzzleParams[paramInt].a, arrayOfPuzzleParams[paramInt].b, arrayOfPuzzleParams[paramInt].a + i, arrayOfPuzzleParams[paramInt].b + i);
          localRect.set(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
          if ((paramInt == 1) && (j >= 3))
          {
            localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            localCanvas.drawCircle(arrayOfPuzzleParams[paramInt].a + k, arrayOfPuzzleParams[paramInt].b + k, m + k, localPaint);
            paramConfig = Bitmap.createBitmap(localBitmap);
            localPaint.setXfermode(null);
          }
          else
          {
            localCanvas.drawCircle(arrayOfPuzzleParams[paramInt].a + k, arrayOfPuzzleParams[paramInt].b + k, m + k, localPaint);
          }
          ((Paint)localObject1).setShader(a(localRectF, (Bitmap)localObject2));
          localCanvas.drawCircle(arrayOfPuzzleParams[paramInt].a + k, arrayOfPuzzleParams[paramInt].b + k, k, (Paint)localObject1);
          paramInt += 1;
        }
        if (paramConfig != null)
        {
          localRectF.set(0.0F, 0.0F, paramConfig.getWidth(), paramConfig.getHeight());
          localRect.set(0, 0, paramConfig.getWidth(), paramConfig.getHeight());
          ((Paint)localObject1).setShader(null);
          localCanvas.drawBitmap(paramConfig, localRect, localRectF, (Paint)localObject1);
        }
        return localBitmap;
      }
      throw new IllegalArgumentException("can not find any bitmap from bitmapArray");
    }
    paramConfig = new IllegalArgumentException("bitmapArray should not be null or empty");
    for (;;)
    {
      throw paramConfig;
    }
  }
  
  public static Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    if (paramArrayOfBitmap != null)
    {
      if (paramArrayOfBitmap.length <= 0) {
        return null;
      }
      Bitmap[] arrayOfBitmap = new Bitmap[paramArrayOfBitmap.length];
      int j = 0;
      int k;
      for (int i = 0; j < paramArrayOfBitmap.length; i = k)
      {
        k = i;
        if (paramArrayOfBitmap[j] != null)
        {
          arrayOfBitmap[i] = paramArrayOfBitmap[j];
          k = i + 1;
        }
        j += 1;
      }
      if (i < 1) {
        return null;
      }
      if (i == 1) {
        return paramArrayOfBitmap[0];
      }
      paramArrayOfBitmap = new PuzzleAvatarUtil.PuzzleParams[i];
      j = 0;
      while (j < i)
      {
        paramArrayOfBitmap[j] = new PuzzleAvatarUtil.PuzzleParams(null);
        j += 1;
      }
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      RectF localRectF = new RectF();
      Rect localRect = new Rect();
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap1);
      localCanvas.drawARGB(0, 0, 0, 0);
      Bitmap localBitmap2;
      if (i == 2)
      {
        paramArrayOfBitmap[0].a = 0;
        paramArrayOfBitmap[0].b = 0;
        localBitmap2 = paramArrayOfBitmap[0];
        j = paramInt / 2;
        localBitmap2.c = (j - 1);
        paramArrayOfBitmap[0].d = paramInt;
        paramArrayOfBitmap[0].e = 1;
        paramArrayOfBitmap[1].a = (j + 1);
        paramArrayOfBitmap[1].b = 0;
        paramArrayOfBitmap[1].c = paramInt;
        paramArrayOfBitmap[1].d = paramInt;
        paramArrayOfBitmap[1].e = 1;
      }
      else if (i == 3)
      {
        paramArrayOfBitmap[0].a = 0;
        paramArrayOfBitmap[0].b = 0;
        localBitmap2 = paramArrayOfBitmap[0];
        k = paramInt / 2;
        j = k - 1;
        localBitmap2.c = j;
        paramArrayOfBitmap[0].d = paramInt;
        paramArrayOfBitmap[0].e = 1;
        localBitmap2 = paramArrayOfBitmap[1];
        k += 1;
        localBitmap2.a = k;
        paramArrayOfBitmap[1].b = 0;
        paramArrayOfBitmap[1].c = paramInt;
        paramArrayOfBitmap[1].d = j;
        paramArrayOfBitmap[1].e = 2;
        paramArrayOfBitmap[2].a = k;
        paramArrayOfBitmap[2].b = k;
        paramArrayOfBitmap[2].c = paramInt;
        paramArrayOfBitmap[2].d = paramInt;
        paramArrayOfBitmap[2].e = 2;
      }
      else if (i >= 4)
      {
        paramArrayOfBitmap[0].a = 0;
        paramArrayOfBitmap[0].b = 0;
        localBitmap2 = paramArrayOfBitmap[0];
        k = paramInt / 2;
        j = k - 1;
        localBitmap2.c = j;
        paramArrayOfBitmap[0].d = j;
        paramArrayOfBitmap[0].e = 2;
        localBitmap2 = paramArrayOfBitmap[1];
        k += 1;
        localBitmap2.a = k;
        paramArrayOfBitmap[1].b = 0;
        paramArrayOfBitmap[1].c = paramInt;
        paramArrayOfBitmap[1].d = j;
        paramArrayOfBitmap[1].e = 2;
        paramArrayOfBitmap[2].a = k;
        paramArrayOfBitmap[2].b = k;
        paramArrayOfBitmap[2].c = paramInt;
        paramArrayOfBitmap[2].d = paramInt;
        paramArrayOfBitmap[2].e = 2;
        paramArrayOfBitmap[3].a = 0;
        paramArrayOfBitmap[3].b = k;
        paramArrayOfBitmap[3].c = j;
        paramArrayOfBitmap[3].d = paramInt;
        paramArrayOfBitmap[3].e = 2;
      }
      paramInt = 0;
      while ((paramInt < i) && (paramInt < 4))
      {
        k = arrayOfBitmap[paramInt].getWidth();
        j = arrayOfBitmap[paramInt].getHeight();
        if (paramArrayOfBitmap[paramInt].e == 1)
        {
          k /= 4;
          localRect.set(k, 0, k * 3, j);
        }
        else
        {
          localRect.set(0, 0, k, j);
        }
        localRectF.set(paramArrayOfBitmap[paramInt].a, paramArrayOfBitmap[paramInt].b, paramArrayOfBitmap[paramInt].c, paramArrayOfBitmap[paramInt].d);
        localCanvas.drawBitmap(arrayOfBitmap[paramInt], localRect, localRectF, localPaint);
        paramInt += 1;
      }
      return localBitmap1;
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, float paramFloat1, float paramFloat2)
  {
    float f = paramFloat2;
    if (paramFloat2 < 1.5F) {
      f = 1.5F;
    }
    int j = Math.max(paramBitmap1.getWidth(), paramBitmap1.getHeight());
    int i = Math.max(paramBitmap2.getWidth(), paramBitmap2.getHeight());
    j = (int)(Math.max(j, i) * f);
    Bitmap localBitmap = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    localPaint.setDither(true);
    paramFloat2 = j;
    f = paramFloat2 / i;
    Object localObject = new Matrix();
    if (paramFloat1 != 0.0F) {
      ((Matrix)localObject).setRotate(paramFloat1, paramBitmap2.getWidth() / 2.0F, paramBitmap2.getHeight() / 2.0F);
    }
    ((Matrix)localObject).postScale(f, f);
    localCanvas.drawBitmap(paramBitmap2, (Matrix)localObject, localPaint);
    paramBitmap2 = new Rect(0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight());
    localObject = new RectF(0.0F, 0.0F, paramFloat2, paramFloat2);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap1, paramBitmap2, (RectF)localObject, localPaint);
    return localBitmap;
  }
  
  public static BitmapShader a(RectF paramRectF, @NonNull Bitmap paramBitmap)
  {
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    paramBitmap = new Matrix();
    float f1 = paramRectF.width() / paramRectF.height();
    float f3 = j / i;
    float f2 = 0.0F;
    if (f1 < f3)
    {
      f1 = paramRectF.height() / i;
      f3 = (paramRectF.width() - j * f1) * 0.5F;
    }
    else
    {
      f1 = paramRectF.width() / j;
      f2 = (paramRectF.height() - i * f1) * 0.5F;
      f3 = 0.0F;
    }
    paramBitmap.setScale(f1, f1);
    paramBitmap.postTranslate((int)(f3 + 0.5F) + paramRectF.left, (int)(f2 + 0.5F) + paramRectF.top);
    localBitmapShader.setLocalMatrix(paramBitmap);
    return localBitmapShader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.PuzzleAvatarUtil
 * JD-Core Version:    0.7.0.1
 */