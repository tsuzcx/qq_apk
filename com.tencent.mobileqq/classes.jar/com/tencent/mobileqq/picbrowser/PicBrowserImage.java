package com.tencent.mobileqq.picbrowser;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class PicBrowserImage
  extends GalleryImage
{
  protected Context j;
  public PicInfo k;
  int l;
  
  public PicBrowserImage(Context paramContext, PicInfo paramPicInfo)
  {
    this.j = paramContext;
    this.k = paramPicInfo;
  }
  
  public View a(int paramInt, Handler paramHandler, PicBrowserImage.OnLoadListener paramOnLoadListener)
  {
    URLImageView localURLImageView = new URLImageView(this.j);
    Object localObject1 = this.k;
    if (localObject1 == null) {
      return localURLImageView;
    }
    boolean bool1 = TextUtils.isEmpty(((PicInfo)localObject1).d);
    File localFile = null;
    Object localObject2 = null;
    URLDrawable localURLDrawable = null;
    if (!bool1)
    {
      localObject1 = URLDrawable.getDrawable(new File(this.k.d), null);
    }
    else if (!TextUtils.isEmpty(this.k.c))
    {
      localObject3 = this.k.c.replaceFirst("http", "nearbyimage");
      if (AbsDownloader.hasFile((String)localObject3))
      {
        localObject1 = URLDrawable.getDrawable((String)localObject3, null);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("PicBrowserGalleryAdapter getView loadingDrawble is: ");
          localStringBuilder.append((String)localObject3);
          QLog.i("PicBrowser", 2, localStringBuilder.toString());
        }
      }
      else
      {
        localObject1 = URLDrawableHelperConstants.a;
      }
    }
    else
    {
      localObject1 = URLDrawableHelperConstants.a;
    }
    Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.j.getResources().getDisplayMetrics().widthPixels;
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.j.getResources().getDisplayMetrics().heightPixels;
    boolean bool2 = true;
    ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
    localObject1 = this.k;
    ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = localObject1;
    if (!TextUtils.isEmpty(((PicInfo)localObject1).d))
    {
      localObject2 = localURLDrawable;
      try
      {
        localFile = new File(this.k.d);
        localObject2 = localURLDrawable;
        localObject1 = localFile.toURL();
        localObject2 = localURLDrawable;
        localURLDrawable = URLDrawable.getDrawable(new URL("nearbylocalimage", ((URL)localObject1).getAuthority(), ((URL)localObject1).getFile()), (URLDrawable.URLDrawableOptions)localObject3);
        localObject2 = localURLDrawable;
        localURLImageView.setImageDrawable(localURLDrawable);
        localObject2 = localURLDrawable;
        localObject1 = localURLDrawable;
        if (!localFile.exists()) {
          break label542;
        }
        localObject2 = localURLDrawable;
        bool1 = localFile.isFile();
        localObject1 = localURLDrawable;
        if (!bool1) {
          break label542;
        }
        bool1 = true;
        localObject1 = localURLDrawable;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        localObject1 = localObject2;
        if (!QLog.isDevelopLevel()) {
          break label542;
        }
      }
      localMalformedURLException1.printStackTrace();
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.k.b))
      {
        localObject2 = localFile;
        try
        {
          localObject1 = NearbyImgDownloader.convertURL(this.k.b);
          localObject2 = localFile;
          this.k.b = ((URL)localObject1).toString();
          localObject2 = localFile;
          localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
          localObject2 = localObject1;
          ((URLDrawable)localObject1).setDownloadListener(new ImgDownloadListener(this.j, "actNearbyPicBrowser"));
          localObject2 = localObject1;
          localURLImageView.setImageDrawable((Drawable)localObject1);
          localObject2 = localObject1;
          bool1 = AbsDownloader.hasFile(this.k.b);
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          localObject1 = localObject2;
          if (QLog.isDevelopLevel())
          {
            localMalformedURLException2.printStackTrace();
            localObject1 = localObject2;
          }
        }
      }
    }
    label542:
    bool1 = false;
    if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 2) && (((URLDrawable)localObject1).getStatus() != 4))
    {
      localURLImageView.setURLDrawableDownListener(new PicBrowserImage.2(this, paramOnLoadListener, paramInt));
      long l1;
      if (bool1) {
        l1 = 1000L;
      } else {
        l1 = 300L;
      }
      paramHandler.postDelayed(new PicBrowserImage.3(this, (URLDrawable)localObject1, paramOnLoadListener, paramInt), l1);
      return localURLImageView;
    }
    if (localObject1 == null)
    {
      paramOnLoadListener.a(paramInt, false);
      return localURLImageView;
    }
    if (((URLDrawable)localObject1).getStatus() == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramOnLoadListener.a(paramInt, bool1);
    return localURLImageView;
  }
  
  public void a()
  {
    Object localObject = this.k;
    if (localObject != null) {
      localObject = ((PicInfo)localObject).b;
    }
    try
    {
      localObject = NearbyImgDownloader.convertURL((String)localObject);
      if (localObject != null)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mExtraInfo = this.k;
        localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
        ((URLDrawable)localObject).setDownloadListener(new ImgDownloadListener(this.j));
        ThreadManager.postImmediately(new PicBrowserImage.1(this, (URLDrawable)localObject), null, true);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(View paramView, int paramInt, PicBrowserImage.OnLoadListener paramOnLoadListener)
  {
    paramView = (URLImageView)paramView;
    URLDrawable localURLDrawable = (URLDrawable)paramView.getDrawable();
    if (localURLDrawable == null) {
      return;
    }
    int i = localURLDrawable.getStatus();
    boolean bool = true;
    if ((i != 1) && (localURLDrawable.getStatus() != 2))
    {
      i = localURLDrawable.getProgress();
      if (i > 0) {
        paramOnLoadListener.b(paramInt, i / 100);
      }
    }
    else
    {
      if (localURLDrawable.getStatus() != 1) {
        bool = false;
      }
      paramOnLoadListener.a(paramInt, bool);
    }
    paramView.setMinimumHeight(10);
    paramView.setMinimumWidth(10);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void c() {}
  
  public Drawable getAnimationDrawable()
  {
    if (this.k == null) {
      return null;
    }
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
    Object localObject2 = this.k;
    ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
    if (!TextUtils.isEmpty(((PicInfo)localObject2).d))
    {
      try
      {
        localObject1 = URLDrawable.getDrawable(new File(this.k.d).toURL(), (URLDrawable.URLDrawableOptions)localObject1);
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        if (!QLog.isDevelopLevel()) {
          break label207;
        }
      }
      localMalformedURLException1.printStackTrace();
    }
    else if (!TextUtils.isEmpty(this.k.c))
    {
      try
      {
        localObject2 = new URL(this.k.c);
        localObject2 = new URL("nearbyimage", ((URL)localObject2).getAuthority(), ((URL)localObject2).getFile());
        URLDrawable localURLDrawable;
        if (AbsDownloader.hasFile(((URL)localObject2).toString()))
        {
          localURLDrawable = URLDrawable.getDrawable((URL)localObject2, localMalformedURLException1);
        }
        else
        {
          localObject2 = new URL(this.k.b);
          localURLDrawable = URLDrawable.getDrawable(new URL("nearbyimage", ((URL)localObject2).getAuthority(), ((URL)localObject2).getFile()), localURLDrawable);
        }
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        if (QLog.isDevelopLevel()) {
          localMalformedURLException2.printStackTrace();
        }
      }
    }
    label207:
    Drawable localDrawable = null;
    localObject2 = getThumbRect();
    if ((localDrawable != null) && (localObject2 != null))
    {
      this.l = getCutValue((Rect)localObject2, localDrawable);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAnimationDrawable ,cutValue = ");
        ((StringBuilder)localObject2).append(this.l);
        QLog.d("PicBrowser", 2, ((StringBuilder)localObject2).toString());
      }
      return localDrawable;
    }
    return null;
  }
  
  public int getCutValue()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserImage
 * JD-Core Version:    0.7.0.1
 */