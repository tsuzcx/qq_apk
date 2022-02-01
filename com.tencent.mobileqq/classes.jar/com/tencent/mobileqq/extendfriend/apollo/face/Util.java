package com.tencent.mobileqq.extendfriend.apollo.face;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.app.face.FaceDrawableImpl;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Util
  implements IConst
{
  @NotNull
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      return 2130845222;
    case 8: 
      return 2130845217;
    }
    return 2130845221;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 << 4 | paramInt2;
  }
  
  @Nullable
  private static Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap1 = null;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get(paramString);
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null) {
      localBitmap2 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), paramInt);
    }
    if ((localBitmap2 != null) && (GlobalImageCache.a != null)) {
      GlobalImageCache.a.put(paramString, localBitmap2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("extend.apollo.Util", 2, "getBitmapWithCache, bitmap=" + localBitmap2);
    }
    return localBitmap2;
  }
  
  public static Drawable a(int paramInt)
  {
    int i = a(paramInt);
    Bitmap localBitmap = a("static://Apollo_Face-" + paramInt + "-shape", i);
    if (localBitmap == null) {
      return URLDrawableHelper.TRANSPARENT;
    }
    return new BitmapDrawable(localBitmap);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, String paramString)
  {
    return a(paramAppInterface, paramString, 0, 0, 6, null);
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("extend.apollo.Util", 2, "getFaceDrawable fail, uin=" + paramString + ", type=" + 116 + ",appIntf=" + paramAppInterface);
      }
      return null;
    }
    if (!(paramAppInterface instanceof QQAppInterface)) {
      return null;
    }
    int i = a(paramInt1, paramInt2);
    if (paramInt3 == 0) {}
    for (paramInt1 = b(paramInt1, paramInt2);; paramInt1 = paramInt3)
    {
      Drawable localDrawable = a(paramInt1);
      return new FaceDrawableImpl(paramAppInterface, 116, 200, paramString, (byte)1, paramInt1, i, false, localDrawable, localDrawable, paramOnLoadingStateChangeListener, false);
    }
  }
  
  public static FaceDrawable a(AppInterface paramAppInterface, String paramString, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener)
  {
    return a(paramAppInterface, paramString, 1, 2, 8, paramOnLoadingStateChangeListener);
  }
  
  public static int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = new int[paramArrayOfInt1.length * paramArrayOfInt2.length];
    int m = paramArrayOfInt1.length;
    int j = 0;
    int i = 0;
    while (j < m)
    {
      int n = paramArrayOfInt1[j];
      int i1 = paramArrayOfInt2.length;
      int k = 0;
      while (k < i1)
      {
        arrayOfInt[i] = a(n, paramArrayOfInt2[k]);
        i += 1;
        k += 1;
      }
      j += 1;
    }
    return arrayOfInt;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 2) && (paramInt1 == 1)) {
      return 8;
    }
    if (paramInt1 == 1) {
      return 7;
    }
    return 6;
  }
  
  public static FaceDrawable b(AppInterface paramAppInterface, String paramString)
  {
    return a(paramAppInterface, paramString, 1, 2, 7, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.apollo.face.Util
 * JD-Core Version:    0.7.0.1
 */