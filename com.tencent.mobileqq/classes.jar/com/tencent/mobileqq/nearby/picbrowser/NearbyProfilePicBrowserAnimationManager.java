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
  private AbstractImageListModel b;
  
  public NearbyProfilePicBrowserAnimationManager(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = paramAbstractImageListModel;
  }
  
  private Drawable a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, GalleryImage paramGalleryImage, boolean paramBoolean)
  {
    if (paramGalleryImage == null) {}
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = paramGalleryImage.getAnimationDrawable();
      paramRect1 = paramGalleryImage.getThumbRect();
    } while ((paramRect1 == null) || (localDrawable == null) || (!paramGalleryImage.needAnimation(paramBoolean)));
    int i = this.jdField_a_of_type_AndroidViewView.getWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    int k = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    paramRect2.set(0, 0, k, m);
    paramRect3.set(paramRect1);
    if ((paramGalleryImage instanceof AIORichMediaInfo)) {}
    for (paramRect2 = ((AIORichMediaInfo)paramGalleryImage).a;; paramRect2 = null)
    {
      if ((!VersionUtils.e()) && ((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable))) {}
      for (paramRect1 = AnimationUtils.a(k, m, i, j, false, paramRect2);; paramRect1 = null)
      {
        if (paramRect1 == null) {
          paramRect1 = AnimationUtils.a(k, m, i, j, paramRect2);
        }
        for (;;)
        {
          paramRect4.set(paramRect1);
          return localDrawable;
        }
      }
    }
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (a()) {
      bool1 = true;
    }
    Rect localRect1;
    Rect localRect2;
    GalleryImage localGalleryImage;
    Rect localRect3;
    Rect localRect4;
    Drawable localDrawable;
    do
    {
      do
      {
        do
        {
          return bool1;
          if (this.jdField_a_of_type_AndroidViewView == null) {
            b();
          }
          localRect1 = new Rect();
          localRect2 = new Rect();
          localGalleryImage = this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a();
          bool1 = bool3;
        } while (localGalleryImage == null);
        localRect3 = localGalleryImage.getStartSrcRect();
        localRect4 = new Rect();
        localDrawable = a(null, localRect4, localRect1, localRect2, localGalleryImage, true);
        bool1 = bool3;
      } while (localRect4.right == -1);
      bool1 = bool3;
    } while (localRect4.bottom == -1);
    this.jdField_a_of_type_Boolean = true;
    if (localDrawable != null)
    {
      bool1 = bool2;
      this.jdField_b_of_type_Boolean = bool1;
      if (this.jdField_b_of_type_Boolean) {
        break label158;
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      bool1 = false;
      break;
      label158:
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localGalleryImage.isImgCenterCropMode;
      if (localRect3 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect1, localRect2, localGalleryImage.getCutValue(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect3, localRect4, localRect1, localRect2, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public boolean c()
  {
    if (a()) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      b();
    }
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    GalleryImage localGalleryImage = this.jdField_b_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a();
    Rect localRect1 = null;
    if (localGalleryImage != null) {
      localRect1 = localGalleryImage.getStartSrcRect();
    }
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(localRect1, localRect4, localRect2, localRect3, localGalleryImage, false);
    if ((localRect4.right == -1) || (localRect4.bottom == -1)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = true;
    boolean bool;
    if (localDrawable != null)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label147;
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      bool = false;
      break;
      label147:
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localGalleryImage.isImgCenterCropMode;
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localGalleryImage.getCutValue(), localGalleryImage.getStartX(), localGalleryImage.getStartY(), this.jdField_a_of_type_Long);
      if (localRect1 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localGalleryImage.getCutValue(), localGalleryImage.getStartX(), localGalleryImage.getStartY(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.b(localDrawable, localRect1, localRect4, localRect2, localRect3, this.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserAnimationManager
 * JD-Core Version:    0.7.0.1
 */