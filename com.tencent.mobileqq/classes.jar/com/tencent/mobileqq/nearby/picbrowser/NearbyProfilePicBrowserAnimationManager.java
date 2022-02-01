package com.tencent.mobileqq.nearby.picbrowser;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AnimationManager;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.util.VersionUtils;

public class NearbyProfilePicBrowserAnimationManager
  extends AnimationManager
{
  private AbstractImageListModel m;
  
  public NearbyProfilePicBrowserAnimationManager(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.m = paramAbstractImageListModel;
  }
  
  private Drawable a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, GalleryImage paramGalleryImage, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramGalleryImage == null) {
      return null;
    }
    Drawable localDrawable = paramGalleryImage.getAnimationDrawable();
    paramRect1 = paramGalleryImage.getThumbRect();
    if ((paramRect1 != null) && (localDrawable != null))
    {
      if (!paramGalleryImage.needAnimation(paramBoolean)) {
        return null;
      }
      int i = this.g.getWidth();
      int j = this.g.getHeight();
      int k = localDrawable.getIntrinsicWidth();
      int n = localDrawable.getIntrinsicHeight();
      paramRect2.set(0, 0, k, n);
      paramRect3.set(paramRect1);
      if ((paramGalleryImage instanceof AIORichMediaInfo)) {
        paramRect2 = ((AIORichMediaInfo)paramGalleryImage).a;
      } else {
        paramRect2 = null;
      }
      paramRect1 = localObject;
      if (!VersionUtils.e())
      {
        paramRect1 = localObject;
        if ((localDrawable instanceof URLDrawable))
        {
          paramRect1 = localObject;
          if ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable)) {
            paramRect1 = AnimationUtils.a(k, n, i, j, false, paramRect2);
          }
        }
      }
      paramRect3 = paramRect1;
      if (paramRect1 == null) {
        paramRect3 = AnimationUtils.a(k, n, i, j, paramRect2);
      }
      paramRect4.set(paramRect3);
      return localDrawable;
    }
    return null;
  }
  
  public boolean b()
  {
    boolean bool2 = a();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (this.g == null) {
      f();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    GalleryImage localGalleryImage = this.m.d();
    if (localGalleryImage == null) {
      return false;
    }
    Rect localRect3 = localGalleryImage.getStartSrcRect();
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(null, localRect4, localRect1, localRect2, localGalleryImage, true);
    if (localRect4.right != -1)
    {
      if (localRect4.bottom == -1) {
        return false;
      }
      this.b = true;
      if (localDrawable == null) {
        bool1 = false;
      }
      this.d = bool1;
      if (!this.d)
      {
        this.h.setVisibility(4);
      }
      else
      {
        this.h.setVisibility(0);
        this.h.setAnimationListener(this);
        this.h.a = localGalleryImage.isImgCenterCropMode;
        if (localRect3 == null) {
          this.h.a(localDrawable, localRect1, localRect2, localGalleryImage.getCutValue(), this.c);
        } else {
          this.h.a(localDrawable, localRect3, localRect4, localRect1, localRect2, this.c);
        }
      }
      return this.d;
    }
    return false;
  }
  
  public boolean c()
  {
    boolean bool2 = a();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (this.g == null) {
      f();
    }
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    GalleryImage localGalleryImage = this.m.d();
    Rect localRect1 = null;
    if (localGalleryImage != null) {
      localRect1 = localGalleryImage.getStartSrcRect();
    }
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(localRect1, localRect4, localRect2, localRect3, localGalleryImage, false);
    if (localRect4.right != -1)
    {
      if (localRect4.bottom == -1) {
        return false;
      }
      this.b = true;
      if (localDrawable == null) {
        bool1 = false;
      }
      this.d = bool1;
      if (!this.d)
      {
        this.h.setVisibility(4);
      }
      else
      {
        this.h.setVisibility(0);
        this.h.setAnimationListener(this);
        this.h.a = localGalleryImage.isImgCenterCropMode;
        this.h.a(localDrawable, localRect2, localRect3, localGalleryImage.getCutValue(), localGalleryImage.getStartX(), localGalleryImage.getStartY(), this.c);
        if (localRect1 == null) {
          this.h.a(localDrawable, localRect2, localRect3, localGalleryImage.getCutValue(), localGalleryImage.getStartX(), localGalleryImage.getStartY(), this.c);
        } else {
          this.h.b(localDrawable, localRect1, localRect4, localRect2, localRect3, this.c);
        }
      }
      return this.d;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserAnimationManager
 * JD-Core Version:    0.7.0.1
 */