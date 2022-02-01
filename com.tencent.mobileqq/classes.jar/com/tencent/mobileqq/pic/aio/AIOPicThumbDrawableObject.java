package com.tencent.mobileqq.pic.aio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.DrawURL;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;

public class AIOPicThumbDrawableObject
{
  MessageForPic a;
  ChatThumbView b;
  int[] c;
  BasePicItemBuilder.DrawURL d;
  
  private AIOPicThumbDrawableObject(AIOPicThumbDrawableObject.Builder paramBuilder)
  {
    this.a = paramBuilder.a;
    this.b = paramBuilder.b;
    this.c = paramBuilder.c;
    this.d = paramBuilder.d;
  }
  
  private URLDrawable a(File paramFile)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    int i2 = localResources.getDisplayMetrics().densityDpi;
    float f1 = i2 / 160.0F;
    URL localURL = this.d.a;
    boolean bool1 = this.d.b;
    boolean bool2 = ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(this.a.imageType);
    if (bool1) {
      try
      {
        Rect localRect = NativeGifImage.getImageSize(paramFile, false);
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
    }
    ChatThumbView localChatThumbView = null;
    if (localChatThumbView != null)
    {
      j = localChatThumbView.width();
      i = localChatThumbView.height();
    }
    else
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      try
      {
        ImageUtil.a(paramFile.getAbsolutePath(), localOptions);
      }
      catch (Throwable localThrowable2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOPicDrawableObject", 2, "getThumbDrawable", localThrowable2);
        }
      }
      j = localOptions.outWidth;
      i = localOptions.outHeight;
      k = URLDrawableHelper.getExifRotation(paramFile.getAbsolutePath());
      if ((k != 90) && (k != 270)) {
        break label219;
      }
      j = localOptions.outHeight;
      i = localOptions.outWidth;
    }
    label219:
    paramFile = ((IPicAIO)QRoute.api(IPicAIO.class)).getThumbWidthHeightDP(this.a, bool2);
    int m = paramFile.mMinWidth;
    int k = paramFile.mMinHeight;
    int i1 = paramFile.mMaxWidth;
    int n = paramFile.mMaxHeight;
    float f3 = URLDrawableHelper.getRoundCorner() * f1;
    if ((j >= m) && (i >= k))
    {
      if ((j < i1) && (i < n))
      {
        k = i;
        f1 = f3;
      }
      else
      {
        if (j > i)
        {
          f1 = i1;
          f2 = j;
        }
        else
        {
          f1 = n;
          f2 = i;
        }
        float f4 = f1 / f2;
        if (j > i)
        {
          f1 = k;
          f2 = i;
        }
        else
        {
          f1 = m;
          f2 = j;
        }
        f1 = Math.max(f4, f1 / f2);
        j = (int)(j * f1 + 0.5F);
        k = (int)(i * f1 + 0.5F);
        f1 = f3;
      }
    }
    else
    {
      if (j < i)
      {
        f1 = m / j;
        j = (int)(i * f1 + 0.5F);
        i = j;
        if (j > n) {
          i = n;
        }
        k = i;
        i = m;
      }
      else
      {
        f1 = k / i;
        i = (int)(j * f1 + 0.5F);
        if (i > i1) {
          i = i1;
        }
      }
      f1 = f3 * f1;
      j = i;
    }
    int i = (j * i2 + 80) / 160;
    int j = (k * i2 + 80) / 160;
    float f2 = f1;
    if (localChatThumbView != null)
    {
      if (localChatThumbView.width() < i) {
        f2 = localChatThumbView.width();
      }
      for (f3 = i;; f3 = j)
      {
        f2 = f1 * (f2 / f3);
        break;
        f2 = f1;
        if (localChatThumbView.height() >= j) {
          break;
        }
        f2 = localChatThumbView.height();
      }
    }
    if (QLog.isColorLevel())
    {
      paramFile = new StringBuilder();
      paramFile.append("getThumbDrawable,roundCornor:");
      paramFile.append(f2);
      paramFile.append("  w:");
      paramFile.append(i);
      paramFile.append(" h:");
      paramFile.append(j);
      QLog.d("AIOPicDrawableObject", 2, paramFile.toString());
    }
    paramFile = this.c;
    if (paramFile != null)
    {
      paramFile[0] = i;
      paramFile[1] = j;
    }
    paramFile = URLDrawableHelper.getLoadingDrawable();
    if ((URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable)) {
      paramFile = new BitmapDrawableWithMargin(localResources, ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), i, j, -921103);
    } else if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable)) {
      paramFile = new BitmapDrawableWithMargin(localResources, ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), i, j, -921103);
    }
    paramFile = URLDrawableHelper.getDrawable(localURL, i, j, paramFile, URLDrawableHelper.getFailedDrawable(), true, f2);
    paramFile.setProgressDrawable(new PhotoProgressDrawable(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
    paramFile.setIgnorePause(true);
    paramFile.setFadeInImage(true);
    localChatThumbView = this.b;
    if (localChatThumbView != null) {
      localChatThumbView.b = true;
    }
    return paramFile;
  }
  
  private URLDrawable b()
  {
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi / 160.0F;
    float f2 = URLDrawableHelper.getRoundCorner();
    URLDrawable localURLDrawable = URLDrawableHelper.getDrawable(this.d.a, 0, 0, null, null, true, f2 * f1);
    int[] arrayOfInt = this.c;
    if (arrayOfInt != null)
    {
      arrayOfInt[0] = localURLDrawable.getIntrinsicWidth();
      this.c[1] = localURLDrawable.getIntrinsicHeight();
    }
    return localURLDrawable;
  }
  
  private URLDrawable c()
  {
    Resources localResources = BaseApplication.getContext().getResources();
    int i2 = localResources.getDisplayMetrics().densityDpi;
    URL localURL = this.d.a;
    boolean bool1 = this.d.b;
    boolean bool2 = ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(this.a.imageType);
    Object localObject = ((IPicAIO)QRoute.api(IPicAIO.class)).getThumbWidthHeightDP(this.a, bool2);
    int k = ((ThumbWidthHeightDP)localObject).mMinWidth;
    int j = ((ThumbWidthHeightDP)localObject).mMinHeight;
    int i = ((ThumbWidthHeightDP)localObject).mMaxWidth;
    int m = ((ThumbWidthHeightDP)localObject).mMaxHeight;
    int i1 = this.a.thumbWidth;
    int n = this.a.thumbHeight;
    if ((i1 > 0) && (n > 0))
    {
      if ((i1 >= k) && (n >= j))
      {
        if ((i1 < i) && (n < m))
        {
          i = i1;
          j = n;
        }
        else
        {
          float f2;
          if (i1 > n)
          {
            f1 = i;
            f2 = i1;
          }
          else
          {
            f1 = m;
            f2 = n;
          }
          float f3 = f1 / f2;
          if (i1 > n)
          {
            f1 = j;
            f2 = n;
          }
          else
          {
            f1 = k;
            f2 = i1;
          }
          f1 = Math.max(f3, f1 / f2);
          i = (int)(i1 * f1 + 0.5F);
          j = (int)(n * f1 + 0.5F);
        }
      }
      else if (i1 < n)
      {
        f1 = k / i1;
        n = (int)(n * f1 + 0.5F);
        i = k;
        j = n;
        if (n > m)
        {
          j = m;
          i = k;
        }
      }
      else
      {
        f1 = j / n;
        k = (int)(i1 * f1 + 0.5F);
        if (k <= i) {
          i = k;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MessageForPic without width/height of thumb, width = ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", height = ");
        ((StringBuilder)localObject).append(n);
        QLog.d("AIOPicDrawableObject", 2, ((StringBuilder)localObject).toString());
      }
      i = 99;
      j = 99;
    }
    float f1 = i2 / 160.0F;
    i = (int)(i * f1 + 0.5F);
    j = (int)(j * f1 + 0.5F);
    localObject = null;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = j;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
    localURLDrawableOptions.mPlayGifImage = bool1;
    localURLDrawableOptions.mGifRoundCorner = URLDrawableHelper.getRoundCorner();
    localURLDrawableOptions.mImgType = this.a.imageType;
    int[] arrayOfInt = this.c;
    if (arrayOfInt != null)
    {
      arrayOfInt[0] = i;
      arrayOfInt[1] = j;
    }
    if ((URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable)) {
      localObject = new BitmapDrawableWithMargin(localResources, ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), i, j, -921103);
    } else if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable)) {
      localObject = new BitmapDrawableWithMargin(localResources, ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), i, j, -921103);
    }
    if (localObject != null) {
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    }
    localObject = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
    ((URLDrawable)localObject).setAutoDownload(true);
    ((URLDrawable)localObject).setProgressDrawable(new PhotoProgressDrawable(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
    return localObject;
  }
  
  public URLDrawable a()
  {
    if (this.d == null) {
      this.d = new BasePicItemBuilder.DrawURL(this.a);
    }
    Object localObject = this.d.a.toString();
    ChatThumbView localChatThumbView = this.b;
    if (localChatThumbView != null) {
      localChatThumbView.b = false;
    }
    if (GlobalImageCache.a.get(localObject) != null)
    {
      localObject = b();
    }
    else
    {
      localObject = AbsDownloader.getFile((String)localObject);
      if (localObject != null) {
        localObject = a((File)localObject);
      } else {
        localObject = c();
      }
    }
    ((URLDrawable)localObject).setTag(this.a);
    if ((((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable)) {
      ((URLDrawable)localObject).getCurrDrawable().mutate();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.aio.AIOPicThumbDrawableObject
 * JD-Core Version:    0.7.0.1
 */