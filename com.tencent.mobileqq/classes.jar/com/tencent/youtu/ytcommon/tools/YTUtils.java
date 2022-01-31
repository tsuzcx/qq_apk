package com.tencent.youtu.ytcommon.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Map;

public class YTUtils
{
  private static final String TAG = "ToolUtils";
  private static Map<String, String> mLoadedLibrary = new HashMap();
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static void loadLibrary(String paramString)
  {
    if (mLoadedLibrary.get(paramString) == null)
    {
      YTLogger.i("ToolUtils", "[YTUtils.loadLibrary] " + System.getProperty("java.library.path"));
      System.loadLibrary(paramString);
      mLoadedLibrary.put(paramString, "loaded");
    }
  }
  
  public static void prepareMatrix(Matrix paramMatrix, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    YTLogger.e("ToolUtils", "prepareMatrix viewWidth=" + paramInt2 + ",viewHeight=" + paramInt3 + ",displayOrientation=" + paramInt1);
    if (paramBoolean) {}
    for (float f = -1.0F;; f = 1.0F)
    {
      paramMatrix.setScale(f, 1.0F);
      paramMatrix.postRotate(paramInt1);
      paramMatrix.postScale(paramInt2 / 2000.0F, paramInt3 / 2000.0F);
      paramMatrix.postTranslate(paramInt2 / 2.0F, paramInt3 / 2.0F);
      return;
    }
  }
  
  public static Rect trans2ScreenRect(Context paramContext, int paramInt1, int paramInt2, Rect paramRect)
  {
    long l = System.currentTimeMillis();
    YTLogger.e("ToolUtils", "trans2ScreenRect srcRect=" + paramRect.toString());
    paramContext = paramContext.getResources().getDisplayMetrics();
    YTLogger.e("ToolUtils", "trans2ScreenRect dm.widthPixels=" + paramContext.widthPixels);
    YTLogger.e("ToolUtils", "trans2ScreenRect dm.heightPixels=" + paramContext.heightPixels);
    YTLogger.e("ToolUtils", "trans2ScreenRect previewWidth=" + paramInt1);
    YTLogger.e("ToolUtils", "trans2ScreenRect previewHeight=" + paramInt2);
    int i = paramContext.widthPixels;
    int k = paramContext.heightPixels;
    double d = paramInt1 * 1.0F / paramInt2;
    boolean bool;
    int j;
    label183:
    label192:
    label214:
    label219:
    float f2;
    float f1;
    float f3;
    if (i > k)
    {
      bool = true;
      if (!bool) {
        break label738;
      }
      j = i;
      if (!bool) {
        break label745;
      }
      i = k;
      if (j >= i * d) {
        break label748;
      }
      j = (int)(i * d);
      if (!bool) {
        break label760;
      }
      YTLogger.d("ToolUtils", "trans2ScreenRect aspectRatio=" + d);
      YTLogger.d("ToolUtils", "trans2ScreenRect widthLonger=" + bool);
      YTLogger.e("ToolUtils", "trans2ScreenRect screenWidth=" + j);
      YTLogger.e("ToolUtils", "trans2ScreenRect screenHeight=" + i);
      f2 = 0.0F;
      f1 = 0.0F;
      if (paramInt2 * i <= j * paramInt1) {
        break label775;
      }
      f3 = i * 1.0F / paramInt1;
      f2 = (j - paramInt2 * f3) * 0.5F;
    }
    for (;;)
    {
      Rect localRect = new Rect();
      localRect.set((int)(paramRect.left * f3 - f2), (int)(paramRect.top * f3 - f1), (int)(paramRect.right * f3), (int)(paramRect.bottom * f3));
      YTLogger.d("ToolUtils", "scale=" + f3);
      YTLogger.d("ToolUtils", "dx=" + f2);
      YTLogger.d("ToolUtils", "dy=" + f1);
      YTLogger.d("ToolUtils", "screenWidth=" + j);
      YTLogger.d("ToolUtils", "screenHeight=" + i);
      YTLogger.d("ToolUtils", "dWidth=" + paramInt2);
      YTLogger.d("ToolUtils", "dHeight=" + paramInt1);
      YTLogger.d("ToolUtils", "dst=" + localRect.toString());
      paramInt1 = (j - paramContext.widthPixels) / 2;
      paramInt2 = (i - paramContext.heightPixels) / 2;
      paramRect.set((int)(paramRect.left * f3 - paramInt1), (int)(paramRect.top * f3 - paramInt2), (int)(paramRect.right * f3 - paramInt1), (int)(f3 * paramRect.bottom - paramInt2));
      YTLogger.d("ToolUtils", "target=" + paramRect.toString() + ",time=" + (System.currentTimeMillis() - l));
      return paramRect;
      bool = false;
      break;
      label738:
      j = k;
      break label183;
      label745:
      break label192;
      label748:
      i = (int)(j / d);
      break label214;
      label760:
      k = i;
      i = j;
      j = k;
      break label219;
      label775:
      f3 = j * 1.0F / paramInt2;
      f1 = (i - paramInt1 * f3) * 0.5F;
    }
  }
  
  public static Rect trans2ScreenRectForYT(Context paramContext, int paramInt1, int paramInt2, Rect paramRect)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    YTLogger.e("ToolUtils", "trans2ScreenRectForYT dm.widthPixels=" + paramContext.widthPixels);
    YTLogger.e("ToolUtils", "trans2ScreenRectForYT dm.heightPixels=" + paramContext.heightPixels);
    YTLogger.e("ToolUtils", "trans2ScreenRectForYT previewHeight=" + paramInt2);
    float f = paramContext.widthPixels * 1.0F / paramInt2;
    paramRect.set((int)(paramRect.left * f), (int)(paramRect.top * f), (int)((paramRect.left + paramRect.width()) * f), (int)(f * (paramRect.top + paramRect.height())));
    return paramRect;
  }
  
  public static Rect translateToMeteringAreaCoordinate(int paramInt1, int paramInt2, Rect paramRect)
  {
    Rect localRect = new Rect();
    Matrix localMatrix1 = new Matrix();
    prepareMatrix(localMatrix1, true, 90, paramInt1, paramInt2);
    localMatrix1.postRotate(0.0F);
    paramRect = new RectF(paramRect.left * 1.0F, paramRect.top * 1.0F, paramRect.right * 1.0F, paramRect.bottom * 1.0F);
    YTLogger.e("ToolUtils", "translationToMeteringAreaCoordinate old rectF.left=" + paramRect.left + ",rectF.top=" + paramRect.top + ",rectF.right=" + paramRect.right + ",rectF.bottom=" + paramRect.bottom);
    Matrix localMatrix2 = new Matrix();
    localMatrix1.invert(localMatrix2);
    localMatrix2.mapRect(paramRect);
    YTLogger.e("ToolUtils", "translationToMeteringAreaCoordinate new rectF.left=" + paramRect.left + ",rectF.top=" + paramRect.top + ",rectF.right=" + paramRect.right + ",rectF.bottom=" + paramRect.bottom);
    localRect.set(Math.round(paramRect.left), Math.round(paramRect.top), Math.round(paramRect.right), Math.round(paramRect.bottom));
    return localRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTUtils
 * JD-Core Version:    0.7.0.1
 */