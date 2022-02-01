package com.tencent.mobileqq.picbrowser;

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
  
  public AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return new PicBrowserGalleryScene((PicBrowserActivity)paramActivity, paramAbstractImageListModel);
  }
  
  public AbstractImageListModel a(Activity paramActivity)
  {
    paramActivity = this.a;
    paramActivity = new PicBrowserModel(paramActivity, paramActivity.mPicInfos);
    paramActivity.b(this.a.mIndex);
    return paramActivity;
  }
  
  public AbstractImageListScene b(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return null;
  }
  
  public AbstractAnimationManager c(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return super.c(paramActivity, paramAbstractImageListModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */