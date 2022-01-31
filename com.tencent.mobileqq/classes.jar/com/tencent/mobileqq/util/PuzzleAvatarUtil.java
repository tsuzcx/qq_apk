package com.tencent.mobileqq.util;

import akax;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PuzzleAvatarUtil
{
  @Nullable
  public static Bitmap a(int paramInt, Bitmap.Config paramConfig, Bitmap[] paramArrayOfBitmap)
  {
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length <= 0)) {
      throw new IllegalArgumentException("bitmapArray should not be null or empty");
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfBitmap.length);
    int j = paramArrayOfBitmap.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        localObject = paramArrayOfBitmap[i];
        if (localObject != null)
        {
          localArrayList.add(localObject);
          if (localArrayList.size() < 6) {}
        }
      }
      else
      {
        j = localArrayList.size();
        if (j > 0) {
          break;
        }
        throw new IllegalArgumentException("can not find any bitmap from bitmapArray");
      }
      i += 1;
    }
    paramArrayOfBitmap = paramConfig;
    if (paramConfig == null) {
      paramArrayOfBitmap = Bitmap.Config.RGB_565;
    }
    Object localObject = new akax[j];
    i = 0;
    while (i < j)
    {
      localObject[i] = new akax(null);
      i += 1;
    }
    float f = paramInt / 100.0F;
    i = 0;
    RectF localRectF;
    Rect localRect;
    Paint localPaint1;
    Canvas localCanvas;
    Paint localPaint2;
    label295:
    Bitmap localBitmap;
    int k;
    int m;
    if (j == 1)
    {
      localObject[0].jdField_a_of_type_Int = 0;
      localObject[0].b = 0;
      i = paramInt;
      localRectF = new RectF();
      localRect = new Rect();
      localPaint1 = new Paint();
      localPaint1.setAntiAlias(true);
      localPaint1.setDither(true);
      localPaint1.setFilterBitmap(true);
      paramArrayOfBitmap = Bitmap.createBitmap(paramInt, paramInt, paramArrayOfBitmap);
      paramConfig = null;
      localCanvas = new Canvas(paramArrayOfBitmap);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint2 = new Paint();
      localPaint2.setAntiAlias(true);
      localPaint2.setDither(true);
      localPaint2.setFilterBitmap(true);
      localPaint2.setColor(0);
      paramInt = 0;
      if (paramInt >= j) {
        break label1172;
      }
      localBitmap = (Bitmap)localArrayList.get(paramInt);
      k = i / 2;
      m = i * 3 / 40;
      localRectF.set(localObject[paramInt].jdField_a_of_type_Int, localObject[paramInt].b, localObject[paramInt].jdField_a_of_type_Int + i, localObject[paramInt].b + i);
      localRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      if ((paramInt != 1) || (j < 3)) {
        break label1134;
      }
      localPaint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      localCanvas.drawCircle(localObject[paramInt].jdField_a_of_type_Int + k, localObject[paramInt].b + k, m + k, localPaint2);
      paramConfig = Bitmap.createBitmap(paramArrayOfBitmap);
      localPaint2.setXfermode(null);
    }
    for (;;)
    {
      localPaint1.setShader(a(localRectF, localBitmap));
      localCanvas.drawCircle(localObject[paramInt].jdField_a_of_type_Int + k, localObject[paramInt].b + k, k, localPaint1);
      paramInt += 1;
      break label295;
      if (j == 2)
      {
        i = (int)(60.0F * f + 0.5F);
        localObject[0].jdField_a_of_type_Int = 0;
        localObject[0].b = 0;
        localObject[1].jdField_a_of_type_Int = (paramInt - i);
        localObject[1].b = (paramInt - i);
        break;
      }
      if (j == 3)
      {
        i = (int)(52.0F * f + 0.5F);
        localObject[0].jdField_a_of_type_Int = ((paramInt - i) / 2);
        localObject[0].b = ((int)(2.0F * f));
        localObject[1].jdField_a_of_type_Int = (paramInt - i);
        localObject[1].b = (paramInt - i - (int)(2.0F * f));
        localObject[2].jdField_a_of_type_Int = 0;
        localObject[2].b = (paramInt - i - (int)(f * 2.0F));
        break;
      }
      if (j == 4)
      {
        i = (int)(52.0F * f + 0.5F);
        localObject[0].jdField_a_of_type_Int = (paramInt - i);
        localObject[0].b = 0;
        localObject[1].jdField_a_of_type_Int = (paramInt - i);
        localObject[1].b = (paramInt - i);
        localObject[2].jdField_a_of_type_Int = 0;
        localObject[2].b = (paramInt - i);
        localObject[3].jdField_a_of_type_Int = 0;
        localObject[3].b = 0;
        break;
      }
      if (j == 5)
      {
        i = (int)(40.0F * f + 0.5F);
        localObject[0].jdField_a_of_type_Int = (paramInt - i);
        localObject[0].b = ((int)(24.0F * f + 0.5F));
        localObject[1].jdField_a_of_type_Int = (paramInt - i - (int)(12.0F * f + 0.5F));
        localObject[1].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[2].jdField_a_of_type_Int = ((int)(12.0F * f + 0.5F));
        localObject[2].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[3].jdField_a_of_type_Int = 0;
        localObject[3].b = ((int)(24.0F * f + 0.5F));
        localObject[4].jdField_a_of_type_Int = ((int)(30.0F * f + 0.5F));
        localObject[4].b = ((int)(f * 2.0F + 0.5F));
        break;
      }
      if (j >= 6)
      {
        i = (int)(36.0F * f + 0.5F);
        localObject[0].b = ((int)(2.0F * f + 0.5F));
        localObject[0].jdField_a_of_type_Int = (paramInt - i - (int)(15.0F * f + 0.5F));
        localObject[1].b = ((int)(32.0F * f + 0.5F));
        localObject[1].jdField_a_of_type_Int = (paramInt - i);
        localObject[2].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[2].jdField_a_of_type_Int = (paramInt - i - (int)(15.0F * f + 0.5F));
        localObject[3].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[3].jdField_a_of_type_Int = ((int)(15.0F * f + 0.5F));
        localObject[4].b = ((int)(32.0F * f + 0.5F));
        localObject[4].jdField_a_of_type_Int = 0;
        localObject[5].b = ((int)(2.0F * f + 0.5F));
        localObject[5].jdField_a_of_type_Int = ((int)(f * 15.0F + 0.5F));
      }
      break;
      label1134:
      localCanvas.drawCircle(localObject[paramInt].jdField_a_of_type_Int + k, localObject[paramInt].b + k, m + k, localPaint2);
    }
    label1172:
    if (paramConfig != null)
    {
      localRectF.set(0.0F, 0.0F, paramConfig.getWidth(), paramConfig.getHeight());
      localRect.set(0, 0, paramConfig.getWidth(), paramConfig.getHeight());
      localPaint1.setShader(null);
      localCanvas.drawBitmap(paramConfig, localRect, localRectF, localPaint1);
    }
    return paramArrayOfBitmap;
  }
  
  public static Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap, Bitmap paramBitmap, float paramFloat)
  {
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length <= 0)) {
      return null;
    }
    Bitmap[] arrayOfBitmap = new Bitmap[paramArrayOfBitmap.length];
    int j = 0;
    int i = 0;
    while (i < paramArrayOfBitmap.length)
    {
      k = j;
      if (paramArrayOfBitmap[i] != null)
      {
        arrayOfBitmap[j] = paramArrayOfBitmap[i];
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    if (j < 1) {
      return null;
    }
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    float f = paramInt / 100.0F;
    int k = 0;
    RectF localRectF = new RectF();
    Rect localRect = new Rect();
    akax[] arrayOfakax = new akax[j];
    i = 0;
    while (i < j)
    {
      arrayOfakax[i] = new akax(null);
      i += 1;
    }
    Bitmap localBitmap2 = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    localCanvas.drawARGB(0, 0, 0, 0);
    if (j == 1)
    {
      arrayOfakax[0].jdField_a_of_type_Float = 0.0F;
      arrayOfakax[0].jdField_a_of_type_Int = 0;
      arrayOfakax[0].b = 0;
      arrayOfakax[0].jdField_a_of_type_Boolean = true;
      i = 0;
      label243:
      if ((i >= j) || (j > 6)) {
        break label1248;
      }
      Bitmap localBitmap1 = arrayOfBitmap[i];
      paramArrayOfBitmap = localBitmap1;
      if (!arrayOfakax[i].jdField_a_of_type_Boolean) {
        paramArrayOfBitmap = a(localBitmap1, paramBitmap, arrayOfakax[i].jdField_a_of_type_Float, paramFloat);
      }
      if (paramArrayOfBitmap == null) {
        break label1231;
      }
      localRectF.set(arrayOfakax[i].jdField_a_of_type_Int, arrayOfakax[i].b, arrayOfakax[i].jdField_a_of_type_Int + paramInt, arrayOfakax[i].b + paramInt);
      localRect.set(0, 0, paramArrayOfBitmap.getWidth(), paramArrayOfBitmap.getHeight());
      localCanvas.drawBitmap(paramArrayOfBitmap, localRect, localRectF, localPaint);
    }
    for (;;)
    {
      i += 1;
      break label243;
      if (j == 2)
      {
        i = (int)(60.0F * f + 0.5F);
        arrayOfakax[0].jdField_a_of_type_Float = 0.0F;
        arrayOfakax[0].jdField_a_of_type_Int = 0;
        arrayOfakax[0].b = 0;
        arrayOfakax[1].jdField_a_of_type_Float = 0.0F;
        arrayOfakax[1].jdField_a_of_type_Int = (paramInt - i);
        arrayOfakax[1].b = (paramInt - i);
        arrayOfakax[1].jdField_a_of_type_Boolean = true;
        paramInt = i;
        break;
      }
      if (j == 3)
      {
        i = (int)(52.0F * f + 0.5F);
        arrayOfakax[0].jdField_a_of_type_Float = 75.0F;
        arrayOfakax[0].jdField_a_of_type_Int = ((paramInt - i) / 2);
        arrayOfakax[0].b = ((int)(2.0F * f));
        arrayOfakax[1].jdField_a_of_type_Float = -165.0F;
        arrayOfakax[1].jdField_a_of_type_Int = (paramInt - i);
        arrayOfakax[1].b = (paramInt - i - (int)(2.0F * f));
        arrayOfakax[2].jdField_a_of_type_Float = -45.0F;
        arrayOfakax[2].jdField_a_of_type_Int = 0;
        arrayOfakax[2].b = (paramInt - i - (int)(f * 2.0F));
        paramInt = i;
        break;
      }
      if (j == 4)
      {
        i = (int)(52.0F * f + 0.5F);
        arrayOfakax[0].jdField_a_of_type_Float = 135.0F;
        arrayOfakax[0].jdField_a_of_type_Int = (paramInt - i);
        arrayOfakax[0].b = 0;
        arrayOfakax[1].jdField_a_of_type_Float = -135.0F;
        arrayOfakax[1].jdField_a_of_type_Int = (paramInt - i);
        arrayOfakax[1].b = (paramInt - i);
        arrayOfakax[2].jdField_a_of_type_Float = -45.0F;
        arrayOfakax[2].jdField_a_of_type_Int = 0;
        arrayOfakax[2].b = (paramInt - i);
        arrayOfakax[3].jdField_a_of_type_Float = 45.0F;
        arrayOfakax[3].jdField_a_of_type_Int = 0;
        arrayOfakax[3].b = 0;
        paramInt = i;
        break;
      }
      if (j == 5)
      {
        i = (int)(40.0F * f + 0.5F);
        arrayOfakax[0].jdField_a_of_type_Float = 170.0F;
        arrayOfakax[0].jdField_a_of_type_Int = (paramInt - i);
        arrayOfakax[0].b = ((int)(24.0F * f + 0.5F));
        arrayOfakax[1].jdField_a_of_type_Float = -115.0F;
        arrayOfakax[1].jdField_a_of_type_Int = (paramInt - i - (int)(12.0F * f + 0.5F));
        arrayOfakax[1].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        arrayOfakax[2].jdField_a_of_type_Float = -40.0F;
        arrayOfakax[2].jdField_a_of_type_Int = ((int)(12.0F * f + 0.5F));
        arrayOfakax[2].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        arrayOfakax[3].jdField_a_of_type_Float = 25.0F;
        arrayOfakax[3].jdField_a_of_type_Int = 0;
        arrayOfakax[3].b = ((int)(24.0F * f + 0.5F));
        arrayOfakax[4].jdField_a_of_type_Float = 100.0F;
        arrayOfakax[4].jdField_a_of_type_Int = ((int)(30.0F * f + 0.5F));
        arrayOfakax[4].b = ((int)(f * 2.0F + 0.5F));
        paramInt = i;
        break;
      }
      i = k;
      if (j >= 6)
      {
        i = (int)(36.0F * f + 0.5F);
        arrayOfakax[0].jdField_a_of_type_Float = 135.0F;
        arrayOfakax[0].b = ((int)(2.0F * f + 0.5F));
        arrayOfakax[0].jdField_a_of_type_Int = (paramInt - i - (int)(15.0F * f + 0.5F));
        arrayOfakax[1].jdField_a_of_type_Float = 200.0F;
        arrayOfakax[1].b = ((int)(32.0F * f + 0.5F));
        arrayOfakax[1].jdField_a_of_type_Int = (paramInt - i);
        arrayOfakax[2].jdField_a_of_type_Float = -110.0F;
        arrayOfakax[2].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        arrayOfakax[2].jdField_a_of_type_Int = (paramInt - i - (int)(15.0F * f + 0.5F));
        arrayOfakax[3].jdField_a_of_type_Float = -45.0F;
        arrayOfakax[3].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        arrayOfakax[3].jdField_a_of_type_Int = ((int)(15.0F * f + 0.5F));
        arrayOfakax[4].jdField_a_of_type_Float = 20.0F;
        arrayOfakax[4].b = ((int)(32.0F * f + 0.5F));
        arrayOfakax[4].jdField_a_of_type_Int = 0;
        arrayOfakax[5].jdField_a_of_type_Float = 75.0F;
        arrayOfakax[5].b = ((int)(2.0F * f + 0.5F));
        arrayOfakax[5].jdField_a_of_type_Int = ((int)(f * 15.0F + 0.5F));
      }
      paramInt = i;
      break;
      label1231:
      if (QLog.isColorLevel()) {
        QLog.i("spliceAvatar", 2, " === circle is null === ");
      }
    }
    label1248:
    return localBitmap2;
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
    paramFloat2 = j / i;
    Object localObject = new Matrix();
    if (paramFloat1 != 0.0F) {
      ((Matrix)localObject).setRotate(paramFloat1, paramBitmap2.getWidth() / 2.0F, paramBitmap2.getHeight() / 2.0F);
    }
    ((Matrix)localObject).postScale(paramFloat2, paramFloat2);
    localCanvas.drawBitmap(paramBitmap2, (Matrix)localObject, localPaint);
    paramBitmap2 = new Rect(0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight());
    localObject = new RectF(0.0F, 0.0F, j, j);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap1, paramBitmap2, (RectF)localObject, localPaint);
    return localBitmap;
  }
  
  public static BitmapShader a(RectF paramRectF, @NonNull Bitmap paramBitmap)
  {
    float f1 = 0.0F;
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    paramBitmap = new Matrix();
    float f3;
    float f2;
    if (paramRectF.width() / paramRectF.height() < j / i)
    {
      f3 = paramRectF.height() / i;
      f2 = (paramRectF.width() - j * f3) * 0.5F;
    }
    for (;;)
    {
      paramBitmap.setScale(f3, f3);
      paramBitmap.postTranslate((int)(f2 + 0.5F) + paramRectF.left, (int)(f1 + 0.5F) + paramRectF.top);
      localBitmapShader.setLocalMatrix(paramBitmap);
      return localBitmapShader;
      f3 = paramRectF.width() / j;
      f1 = paramRectF.height();
      float f4 = i;
      f2 = 0.0F;
      f1 = (f1 - f4 * f3) * 0.5F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.PuzzleAvatarUtil
 * JD-Core Version:    0.7.0.1
 */