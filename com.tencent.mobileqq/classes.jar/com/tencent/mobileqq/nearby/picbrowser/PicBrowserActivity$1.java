package com.tencent.mobileqq.nearby.picbrowser;

import android.app.Activity;
import com.tencent.common.galleryactivity.AbstractAnimationManager;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.GalleryManager;

class PicBrowserActivity$1
  extends GalleryManager
{
  PicBrowserActivity$1(PicBrowserActivity paramPicBrowserActivity) {}
  
  public AbstractAnimationManager a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return super.a(paramActivity, paramAbstractImageListModel);
  }
  
  public AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return new PicBrowserGalleryScene((PicBrowserActivity)paramActivity, paramAbstractImageListModel);
  }
  
  public AbstractImageListModel a(Activity paramActivity)
  {
    paramActivity = new PicBrowserModel(this.a, this.a.jdField_b_of_type_JavaUtilArrayList);
    paramActivity.a(this.a.jdField_b_of_type_Int);
    return paramActivity;
  }
  
  public AbstractImageListScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */