package com.tencent.richmediabrowser.core;

import android.app.Activity;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.model.pic.PictureModel;
import com.tencent.richmediabrowser.model.video.VideoModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.pic.PictureView;
import com.tencent.richmediabrowser.view.video.VideoView;

public class MVPFactory
{
  public static final String TAG = "MVPFactory";
  
  public BrowserBaseModel createModel(int paramInt, BasePresenter paramBasePresenter)
  {
    IMvpFactory localIMvpFactory;
    switch (paramInt)
    {
    default: 
      localIMvpFactory = RichMediaBrowserManager.getInstance().getMvpFactory();
      if (localIMvpFactory == null) {
        throw new IllegalStateException("createModel fail, type is error = " + paramInt);
      }
      break;
    case 1: 
      return new PictureModel(paramBasePresenter);
    case 2: 
      return new VideoModel(paramBasePresenter);
    }
    return localIMvpFactory.createModel(paramInt, paramBasePresenter);
  }
  
  public BasePresenter createPresenter(int paramInt)
  {
    IMvpFactory localIMvpFactory;
    switch (paramInt)
    {
    default: 
      localIMvpFactory = RichMediaBrowserManager.getInstance().getMvpFactory();
      if (localIMvpFactory == null) {
        throw new IllegalStateException("createPresenter fail, type is error = " + paramInt);
      }
      break;
    case 1: 
      return new PicturePresenter();
    case 2: 
      return new VideoPresenter();
    }
    return localIMvpFactory.createPresenter(paramInt);
  }
  
  public BrowserBaseView createView(Activity paramActivity, int paramInt, BasePresenter paramBasePresenter)
  {
    IMvpFactory localIMvpFactory;
    switch (paramInt)
    {
    default: 
      localIMvpFactory = RichMediaBrowserManager.getInstance().getMvpFactory();
      if (localIMvpFactory == null) {
        throw new IllegalStateException("createView fail, type is error = " + paramInt);
      }
      break;
    case 1: 
      if ((paramBasePresenter instanceof PicturePresenter)) {
        return new PictureView(paramActivity, (PicturePresenter)paramBasePresenter);
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("MVPFactory", 4, "createView type is PIC, presenter is error!");
      return null;
    case 2: 
      if ((paramBasePresenter instanceof VideoPresenter)) {
        return new VideoView(paramActivity, (VideoPresenter)paramBasePresenter);
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("MVPFactory", 4, "createView type is VIDEO, presenter is error!");
      return null;
    }
    return localIMvpFactory.createView(paramActivity, paramInt, paramBasePresenter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.MVPFactory
 * JD-Core Version:    0.7.0.1
 */