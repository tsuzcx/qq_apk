package com.tencent.mobileqq.qqslideshow.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowActionListener;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowViewController;
import com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.qqslideshow.ISlideShowController;
import com.tencent.sveffects.SvEffectSdkInitor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlideShowControllerImpl
  implements ISlideShowController
{
  public SlideShowViewController photoListController;
  public SlideShowViewController photoPreviewController;
  
  public List<SlideItemInfo> getPhotoList()
  {
    return SlideShowPhotoListManager.a().a();
  }
  
  public List<SlideItemInfo> getTemp()
  {
    return SlideShowPhotoListManager.a().c();
  }
  
  public void initPhotoListController(Activity paramActivity, View paramView, SlideShowActionListener paramSlideShowActionListener, boolean paramBoolean)
  {
    SvEffectSdkInitor.a();
    this.photoListController = new SlideShowViewController(paramActivity, paramView, paramSlideShowActionListener);
    SlideShowPhotoListManager.a().a(this.photoListController);
    SlideShowPhotoListManager.a().a(paramActivity);
    if (paramBoolean)
    {
      paramActivity = (TransitionHandler)QQStoryContext.a().getBusinessHandler(PeakAppInterface.b);
      if (paramActivity != null) {
        paramActivity.a();
      }
    }
  }
  
  public void initPhotoPreviewController(Activity paramActivity, View paramView, SlideShowActionListener paramSlideShowActionListener)
  {
    SvEffectSdkInitor.a();
    this.photoPreviewController = new SlideShowViewController(paramActivity, paramView, paramSlideShowActionListener);
    SlideShowPhotoListManager.a().a(this.photoPreviewController);
    SlideShowPhotoListManager.a().a(paramActivity);
  }
  
  public void onClipFinish(Intent paramIntent, Map<String, LocalMediaInfo> paramMap)
  {
    SlideShowPhotoListManager.a().a(paramIntent, paramMap);
  }
  
  public void onItemsSelectChanged(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    SlideShowPhotoListManager.a().a(paramList, paramHashMap);
  }
  
  public void onItemsSelectChanged(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap, boolean paramBoolean)
  {
    SlideShowPhotoListManager.a().a(paramList, paramHashMap, paramBoolean);
  }
  
  public void onPhotoListDestroy()
  {
    SlideShowPhotoListManager.a().d();
    this.photoListController = null;
  }
  
  public void onPhotoPreviewDestroy()
  {
    SlideShowPhotoListManager.a().d();
    this.photoPreviewController = null;
  }
  
  public void onResume()
  {
    SlideShowPhotoListManager.a().b();
  }
  
  public void setData(List<SlideItemInfo> paramList)
  {
    SlideShowPhotoListManager.a().a(paramList);
  }
  
  public void setPhotoListController()
  {
    SlideShowPhotoListManager.a().a(this.photoListController);
  }
  
  public void setPhotoPreviewController()
  {
    SlideShowPhotoListManager.a().a(this.photoPreviewController);
  }
  
  public void setTemp(List<SlideItemInfo> paramList)
  {
    SlideShowPhotoListManager.a().b(paramList);
  }
  
  public void updatePhotoPreviewSelectUI(int paramInt)
  {
    SlideShowViewController localSlideShowViewController = this.photoPreviewController;
    if (localSlideShowViewController != null) {
      localSlideShowViewController.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqslideshow.impl.SlideShowControllerImpl
 * JD-Core Version:    0.7.0.1
 */