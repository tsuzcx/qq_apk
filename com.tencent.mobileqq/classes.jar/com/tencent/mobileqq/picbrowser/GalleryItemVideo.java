package com.tencent.mobileqq.picbrowser;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class GalleryItemVideo
  extends PicBrowserImage
  implements DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback
{
  WeakReference<URLImageView> a;
  public WeakReference<PicBrowserImage.OnLoadListener> b;
  int c;
  int d = 0;
  int e = 0;
  DynamicAvatarManager f;
  DynamicAvatarDownloadManager g;
  boolean h = false;
  Handler i = new Handler(Looper.getMainLooper());
  
  public GalleryItemVideo(Context paramContext, PicInfo paramPicInfo)
  {
    super(paramContext, paramPicInfo);
    paramContext = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface)) {
      this.f = ((DynamicAvatarManager)paramContext.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER));
    } else if ((paramContext instanceof INearbyAppInterface)) {
      this.f = ((DynamicAvatarManager)paramContext.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER));
    }
    this.g = this.f.e();
    this.g.a(this);
  }
  
  @NonNull
  private URLDrawable.URLDrawableOptions a(Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mUseMemoryCache = false;
    localURLDrawableOptions.mMemoryCacheKeySuffix = "GalleryItemVideo";
    paramDrawable = new VideoDrawable.VideoDrawableParams();
    paramDrawable.mPlayVideoFrame = true;
    paramDrawable.mPlayAudioFrame = true;
    paramDrawable.mEnableAntiAlias = true;
    paramDrawable.mEnableFilter = true;
    localURLDrawableOptions.mUseMemoryCache = false;
    localURLDrawableOptions.mExtraInfo = paramDrawable;
    return localURLDrawableOptions;
  }
  
  private URLDrawable a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bool)
    {
      String str = paramString.replaceFirst("http", "nearbyimage");
      localObject1 = localObject2;
      if (AbsDownloader.hasFile(str))
      {
        paramString = URLDrawable.getDrawable(str, null);
        localObject1 = paramString;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("PicBrowserGalleryAdapter getView loadingDrawble is: ");
          ((StringBuilder)localObject1).append(str);
          QLog.i("GalleryItemVideo", 2, ((StringBuilder)localObject1).toString());
          localObject1 = paramString;
        }
      }
    }
    return localObject1;
  }
  
  public View a(int paramInt, Handler paramHandler, PicBrowserImage.OnLoadListener paramOnLoadListener)
  {
    this.c = paramInt;
    URLImageView localURLImageView = new URLImageView(this.j);
    if (this.k == null) {
      return localURLImageView;
    }
    if (QLog.isColorLevel())
    {
      paramHandler = new StringBuilder();
      paramHandler.append("getView pos:");
      paramHandler.append(paramInt);
      QLog.i("GalleryItemVideo", 2, paramHandler.toString());
    }
    this.a = new WeakReference(localURLImageView);
    this.b = new WeakReference(paramOnLoadListener);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    paramHandler = a(this.k.b);
    int j;
    if (paramHandler != null) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0)
    {
      paramHandler = a(this.k.c);
      if (paramHandler != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j == 0) {
        if (!TextUtils.isEmpty(this.k.c)) {
          paramHandler = URLDrawable.getDrawable(this.k.c.replaceFirst("http", "nearbyimage"), (URLDrawable.URLDrawableOptions)localObject);
        } else {
          paramHandler = URLDrawableHelper.TRANSPARENT;
        }
      }
    }
    boolean bool1;
    if (!TextUtils.isEmpty(this.k.f))
    {
      localObject = new File(this.k.f);
      bool2 = ((File)localObject).exists();
      bool1 = bool2;
      if (bool2)
      {
        localURLImageView.setImageDrawable(URLDrawable.getDrawable((File)localObject, a(paramHandler)));
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(this.k.e))
      {
        bool1 = DynamicAvatarDownloadManager.e(this.k.e);
        bool2 = bool1;
        if (bool1)
        {
          localURLImageView.setImageDrawable(URLDrawable.getDrawable(DynamicAvatarDownloadManager.d(this.k.e), a(paramHandler)));
          bool2 = bool1;
        }
      }
    }
    if (!bool2)
    {
      if (!TextUtils.isEmpty(this.k.e))
      {
        this.e = 0;
        localURLImageView.setImageDrawable(paramHandler);
        paramHandler = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (this.g.a(this.k.e)) {
          this.d = 0;
        }
        paramOnLoadListener.a(paramInt, this.d);
      }
      else
      {
        localURLImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066));
        this.e = 2;
        paramOnLoadListener.a(paramInt, false);
      }
      if (QLog.isColorLevel())
      {
        paramHandler = new StringBuilder();
        paramHandler.append("fileNotExsits progress:");
        paramHandler.append(this.d);
        paramHandler.append(" url:");
        paramHandler.append(this.k.e);
        QLog.i("GalleryItemVideo", 2, paramHandler.toString());
        return localURLImageView;
      }
    }
    else
    {
      this.d = 0;
      this.e = 1;
      paramOnLoadListener.a(paramInt, true);
    }
    return localURLImageView;
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.k.e))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preload:");
        localStringBuilder.append(this.c);
        QLog.i("GalleryItemVideo", 2, localStringBuilder.toString());
      }
      if (!DynamicAvatarDownloadManager.e(this.k.e)) {
        this.g.a(this.k.e);
      }
    }
  }
  
  public void a(View paramView, int paramInt, PicBrowserImage.OnLoadListener paramOnLoadListener)
  {
    paramView = (URLImageView)paramView;
    Object localObject = paramView.getDrawable();
    if (localObject != null)
    {
      if (!(localObject instanceof URLDrawable)) {
        return;
      }
      int j = this.e;
      boolean bool2 = true;
      if ((j != 1) && (j != 2) && (j != 3) && (j != 4))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateProgressOnSelected:");
          ((StringBuilder)localObject).append(this.d);
          QLog.i("GalleryItemVideo", 2, ((StringBuilder)localObject).toString());
        }
        j = this.d;
        if (j > 0) {
          paramOnLoadListener.b(paramInt, j / 100);
        }
      }
      else
      {
        j = this.e;
        boolean bool1 = bool2;
        if (j != 1) {
          if (j == 4) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        paramOnLoadListener.a(paramInt, bool1);
      }
      paramView.setMinimumHeight(10);
      paramView.setMinimumWidth(10);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString.equals(this.k.e))
    {
      this.d = paramInt;
      paramString = this.b;
      if ((paramString != null) && (paramString.get() != null)) {
        ((PicBrowserImage.OnLoadListener)this.b.get()).b(this.c, paramInt);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString.equals(this.k.e))
    {
      int k = 1;
      int j;
      if (paramBoolean1) {
        j = 1;
      } else {
        j = 2;
      }
      this.e = j;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onDownloadFinish pos:");
        paramString.append(this.c);
        paramString.append(" suc:");
        paramString.append(paramBoolean1);
        QLog.i("GalleryItemVideo", 2, paramString.toString());
      }
      paramString = this.b;
      if (paramString != null)
      {
        if (this.a == null) {
          return;
        }
        Object localObject = (PicBrowserImage.OnLoadListener)paramString.get();
        paramString = (URLImageView)this.a.get();
        if (localObject != null)
        {
          ((PicBrowserImage.OnLoadListener)localObject).a(this.c, paramBoolean1);
          ((PicBrowserImage.OnLoadListener)localObject).a(this.c);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDownloadFinish onloadli=null:");
          if (localObject == null) {
            paramBoolean2 = true;
          } else {
            paramBoolean2 = false;
          }
          localStringBuilder.append(paramBoolean2);
          QLog.i("GalleryItemVideo", 2, localStringBuilder.toString());
        }
        if (paramString != null)
        {
          if ((paramBoolean1) && (DynamicAvatarDownloadManager.e(this.k.e)))
          {
            localObject = URLDrawable.getDrawable(DynamicAvatarDownloadManager.d(this.k.e), a(paramString.getDrawable()));
            this.i.post(new GalleryItemVideo.1(this, paramString, (URLDrawable)localObject));
            j = k;
          }
          else
          {
            j = 0;
          }
          if (j == 0)
          {
            localObject = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066);
            this.i.post(new GalleryItemVideo.2(this, paramString, (Drawable)localObject));
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pause audio:");
      ((StringBuilder)localObject).append(this.c);
      QLog.i("GalleryItemVideo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (URLImageView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        localObject = ((URLImageView)localObject).getDrawable();
        if ((localObject != null) && ((localObject instanceof URLDrawable)))
        {
          localObject = (URLDrawable)localObject;
          if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable)) {
            ((VideoDrawable)((URLDrawable)localObject).getCurrDrawable()).stopAudio();
          }
        }
      }
    }
  }
  
  public void c()
  {
    this.h = true;
    b();
    super.c();
  }
  
  public Drawable getAnimationDrawable()
  {
    if (this.k == null) {
      return null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    Object localObject2 = a(this.k.b);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = a(this.k.c);
      localObject1 = localObject2;
      if (localObject2 == null) {
        try
        {
          localObject1 = new URL(this.k.c);
          localObject1 = URLDrawable.getDrawable(new URL("nearbyimage", ((URL)localObject1).getAuthority(), ((URL)localObject1).getFile()), localURLDrawableOptions);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localObject1 = localObject2;
          if (QLog.isDevelopLevel())
          {
            localMalformedURLException.printStackTrace();
            localObject1 = localObject2;
          }
        }
      }
    }
    localObject2 = getThumbRect();
    if ((localObject1 != null) && (localObject2 != null))
    {
      this.l = getCutValue((Rect)localObject2, (Drawable)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAnimationDrawable ,cutValue = ");
        ((StringBuilder)localObject2).append(this.l);
        QLog.d("GalleryItemVideo", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.GalleryItemVideo
 * JD-Core Version:    0.7.0.1
 */