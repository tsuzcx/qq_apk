package com.tencent.mobileqq.nearby.picbrowser;

import android.app.Activity;
import com.tencent.common.galleryactivity.AbstractAnimationManager;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.picbrowser.PicBrowserModel;

class NearbyProfilePicBrowserActivity$CustomGalleryManager
  extends GalleryManager
{
  NearbyProfilePicBrowserActivity$CustomGalleryManager(NearbyProfilePicBrowserActivity paramNearbyProfilePicBrowserActivity) {}
  
  public AbstractAnimationManager a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return super.a(paramActivity, paramAbstractImageListModel);
  }
  
  public AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return new NearbyProfilePicBrowserGalleryScene((PicBrowserActivity)paramActivity, paramAbstractImageListModel);
  }
  
  public AbstractImageListModel a(Activity paramActivity)
  {
    paramActivity = this.a;
    paramActivity = new PicBrowserModel(paramActivity, NearbyProfilePicBrowserActivity.access$000(paramActivity));
    paramActivity.a(NearbyProfilePicBrowserActivity.access$100(this.a));
    return paramActivity;
  }
  
  public AbstractImageListScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity.CustomGalleryManager
 * JD-Core Version:    0.7.0.1
 */