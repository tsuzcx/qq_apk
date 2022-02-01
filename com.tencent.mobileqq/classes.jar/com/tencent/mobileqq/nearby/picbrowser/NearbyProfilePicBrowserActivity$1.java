package com.tencent.mobileqq.nearby.picbrowser;

import android.app.Activity;
import com.tencent.common.galleryactivity.AbstractAnimationManager;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.picbrowser.PicBrowserGalleryScene;
import com.tencent.mobileqq.picbrowser.PicBrowserModel;

class NearbyProfilePicBrowserActivity$1
  extends GalleryManager
{
  NearbyProfilePicBrowserActivity$1(NearbyProfilePicBrowserActivity paramNearbyProfilePicBrowserActivity) {}
  
  public AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return new PicBrowserGalleryScene((PicBrowserActivity)paramActivity, paramAbstractImageListModel);
  }
  
  public AbstractImageListModel a(Activity paramActivity)
  {
    paramActivity = this.a;
    paramActivity = new PicBrowserModel(paramActivity, NearbyProfilePicBrowserActivity.access$200(paramActivity));
    paramActivity.b(NearbyProfilePicBrowserActivity.access$300(this.a));
    return paramActivity;
  }
  
  public AbstractImageListScene b(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return null;
  }
  
  public AbstractAnimationManager c(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return new NearbyProfilePicBrowserAnimationManager(paramActivity, paramAbstractImageListModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */