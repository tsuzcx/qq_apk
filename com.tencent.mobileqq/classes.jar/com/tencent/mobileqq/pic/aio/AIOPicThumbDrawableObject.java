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
  BasePicItemBuilder.DrawURL jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL;
  ChatThumbView jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView;
  MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  int[] jdField_a_of_type_ArrayOfInt;
  
  private AIOPicThumbDrawableObject(AIOPicThumbDrawableObject.Builder paramBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramBuilder.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = paramBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView;
    this.jdField_a_of_type_ArrayOfInt = paramBuilder.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL = paramBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL;
  }
  
  private URLDrawable a(File paramFile)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    int i2 = localResources.getDisplayMetrics().densityDpi;
    float f1 = i2 / 160.0F;
    URL localURL = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL.jdField_a_of_type_JavaNetURL;
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL.jdField_a_of_type_Boolean;
    boolean bool2 = ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType);
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
    paramFile = ((IPicAIO)QRoute.api(IPicAIO.class)).getThumbWidthHeightDP(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, bool2);
    int m = paramFile.mMinWidth;
    int k = paramFile.mMinHeight;
    int i1 = paramFile.mMaxWidth;
    int n = paramFile.mMaxHeight;
    float f3 = f1 * 12.0F;
    if ((j >= m) && (i >= k))
    {
      if ((j < i1) && (i < n))
      {
        f1 = f3;
        k = i;
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
    paramFile = this.jdField_a_of_type_ArrayOfInt;
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
    localChatThumbView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView;
    if (localChatThumbView != null) {
      localChatThumbView.jdField_a_of_type_Boolean = true;
    }
    return paramFile;
  }
  
  private URLDrawable b()
  {
    float f = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi / 160.0F;
    URLDrawable localURLDrawable = URLDrawableHelper.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL.jdField_a_of_type_JavaNetURL, 0, 0, null, null, true, f * 12.0F);
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if (arrayOfInt != null)
    {
      arrayOfInt[0] = localURLDrawable.getIntrinsicWidth();
      this.jdField_a_of_type_ArrayOfInt[1] = localURLDrawable.getIntrinsicHeight();
    }
    return localURLDrawable;
  }
  
  private URLDrawable c()
  {
    Resources localResources = BaseApplication.getContext().getResources();
    int i2 = localResources.getDisplayMetrics().densityDpi;
    URL localURL = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL.jdField_a_of_type_JavaNetURL;
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL.jdField_a_of_type_Boolean;
    boolean bool2 = ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType);
    Object localObject = ((IPicAIO)QRoute.api(IPicAIO.class)).getThumbWidthHeightDP(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, bool2);
    int k = ((ThumbWidthHeightDP)localObject).mMinWidth;
    int j = ((ThumbWidthHeightDP)localObject).mMinHeight;
    int i = ((ThumbWidthHeightDP)localObject).mMaxWidth;
    int m = ((ThumbWidthHeightDP)localObject).mMaxHeight;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbWidth;
    int n = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.thumbHeight;
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
    localURLDrawableOptions.mGifRoundCorner = 12.0F;
    localURLDrawableOptions.mImgType = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL = new BasePicItemBuilder.DrawURL(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$DrawURL.jdField_a_of_type_JavaNetURL.toString();
    ChatThumbView localChatThumbView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView;
    if (localChatThumbView != null) {
      localChatThumbView.jdField_a_of_type_Boolean = false;
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
    ((URLDrawable)localObject).setTag(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    if ((((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable)) {
      ((URLDrawable)localObject).getCurrDrawable().mutate();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.aio.AIOPicThumbDrawableObject
 * JD-Core Version:    0.7.0.1
 */