package com.tencent.mobileqq.campuscircle;

import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryScene;

public class CampusCirclePicBrowserGalleryScene
  extends PicBrowserGalleryScene
{
  public CampusCirclePicBrowserGalleryScene(PicBrowserActivity paramPicBrowserActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    super(paramPicBrowserActivity, paramAbstractImageListModel);
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.a).inflate(2130970271, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCirclePicBrowserGalleryScene
 * JD-Core Version:    0.7.0.1
 */