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
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  DynamicAvatarDownloadManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
  DynamicAvatarManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager;
  WeakReference<URLImageView> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  public WeakReference<PicBrowserImage.OnLoadListener> b;
  int c = 0;
  
  public GalleryItemVideo(Context paramContext, PicInfo paramPicInfo)
  {
    super(paramContext, paramPicInfo);
    this.jdField_b_of_type_Int = 0;
    paramContext = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager = ((DynamicAvatarManager)paramContext.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER));
    } else if ((paramContext instanceof INearbyAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager = ((DynamicAvatarManager)paramContext.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER));
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this);
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
    this.jdField_a_of_type_Int = paramInt;
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo == null) {
      return localURLImageView;
    }
    if (QLog.isColorLevel())
    {
      paramHandler = new StringBuilder();
      paramHandler.append("getView pos:");
      paramHandler.append(paramInt);
      QLog.i("GalleryItemVideo", 2, paramHandler.toString());
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localURLImageView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramOnLoadListener);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    paramHandler = a(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.a);
    int i;
    if (paramHandler != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      paramHandler = a(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.b);
      if (paramHandler != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.b)) {
          paramHandler = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.b.replaceFirst("http", "nearbyimage"), (URLDrawable.URLDrawableOptions)localObject);
        } else {
          paramHandler = URLDrawableHelper.TRANSPARENT;
        }
      }
    }
    boolean bool1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.e))
    {
      localObject = new File(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.e);
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
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d))
      {
        bool1 = DynamicAvatarDownloadManager.b(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d);
        bool2 = bool1;
        if (bool1)
        {
          localURLImageView.setImageDrawable(URLDrawable.getDrawable(DynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d), a(paramHandler)));
          bool2 = bool1;
        }
      }
    }
    if (!bool2)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d))
      {
        this.c = 0;
        localURLImageView.setImageDrawable(paramHandler);
        paramHandler = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d)) {
          this.jdField_b_of_type_Int = 0;
        }
        paramOnLoadListener.a(paramInt, this.jdField_b_of_type_Int);
      }
      else
      {
        localURLImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024));
        this.c = 2;
        paramOnLoadListener.a(paramInt, false);
      }
      if (QLog.isColorLevel())
      {
        paramHandler = new StringBuilder();
        paramHandler.append("fileNotExsits progress:");
        paramHandler.append(this.jdField_b_of_type_Int);
        paramHandler.append(" url:");
        paramHandler.append(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d);
        QLog.i("GalleryItemVideo", 2, paramHandler.toString());
        return localURLImageView;
      }
    }
    else
    {
      this.jdField_b_of_type_Int = 0;
      this.c = 1;
      paramOnLoadListener.a(paramInt, true);
    }
    return localURLImageView;
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preload:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.i("GalleryItemVideo", 2, localStringBuilder.toString());
      }
      if (!DynamicAvatarDownloadManager.b(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d)) {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d);
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
      int i = this.c;
      boolean bool2 = true;
      if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateProgressOnSelected:");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          QLog.i("GalleryItemVideo", 2, ((StringBuilder)localObject).toString());
        }
        i = this.jdField_b_of_type_Int;
        if (i > 0) {
          paramOnLoadListener.b(paramInt, i / 100);
        }
      }
      else
      {
        i = this.c;
        boolean bool1 = bool2;
        if (i != 1) {
          if (i == 4) {
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
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d))
    {
      this.jdField_b_of_type_Int = paramInt;
      paramString = this.jdField_b_of_type_JavaLangRefWeakReference;
      if ((paramString != null) && (paramString.get() != null)) {
        ((PicBrowserImage.OnLoadListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).b(this.jdField_a_of_type_Int, paramInt);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d))
    {
      int j = 1;
      int i;
      if (paramBoolean1) {
        i = 1;
      } else {
        i = 2;
      }
      this.c = i;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onDownloadFinish pos:");
        paramString.append(this.jdField_a_of_type_Int);
        paramString.append(" suc:");
        paramString.append(paramBoolean1);
        QLog.i("GalleryItemVideo", 2, paramString.toString());
      }
      paramString = this.jdField_b_of_type_JavaLangRefWeakReference;
      if (paramString != null)
      {
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          return;
        }
        Object localObject = (PicBrowserImage.OnLoadListener)paramString.get();
        paramString = (URLImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          ((PicBrowserImage.OnLoadListener)localObject).a(this.jdField_a_of_type_Int, paramBoolean1);
          ((PicBrowserImage.OnLoadListener)localObject).a(this.jdField_a_of_type_Int);
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
          if ((paramBoolean1) && (DynamicAvatarDownloadManager.b(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d)))
          {
            localObject = URLDrawable.getDrawable(DynamicAvatarDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.d), a(paramString.getDrawable()));
            this.jdField_a_of_type_AndroidOsHandler.post(new GalleryItemVideo.1(this, paramString, (URLDrawable)localObject));
            i = j;
          }
          else
          {
            i = 0;
          }
          if (i == 0)
          {
            localObject = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024);
            this.jdField_a_of_type_AndroidOsHandler.post(new GalleryItemVideo.2(this, paramString, (Drawable)localObject));
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.i("GalleryItemVideo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
    this.jdField_a_of_type_Boolean = true;
    b();
    super.c();
  }
  
  public Drawable getAnimationDrawable()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo == null) {
      return null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    Object localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.a);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.b);
      localObject1 = localObject2;
      if (localObject2 == null) {
        try
        {
          localObject1 = new URL(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicInfo.b);
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
      this.d = getCutValue((Rect)localObject2, (Drawable)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAnimationDrawable ,cutValue = ");
        ((StringBuilder)localObject2).append(this.d);
        QLog.d("GalleryItemVideo", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.GalleryItemVideo
 * JD-Core Version:    0.7.0.1
 */