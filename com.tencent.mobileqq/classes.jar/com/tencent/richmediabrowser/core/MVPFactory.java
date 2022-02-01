package com.tencent.richmediabrowser.core;

import android.content.Context;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.pic.PictureModel;
import com.tencent.richmediabrowser.model.video.VideoModel;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import com.tencent.richmediabrowser.view.pic.PictureView;
import com.tencent.richmediabrowser.view.video.VideoView;

public class MVPFactory
{
  public static final String TAG = "MVPFactory";
  private MainBrowserPresenter mainBrowserPresenter;
  
  public MVPFactory(MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.mainBrowserPresenter = paramMainBrowserPresenter;
  }
  
  public IBaseModelBuilder createModel(int paramInt, IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        IMvpFactory localIMvpFactory = this.mainBrowserPresenter.getParamsBuilder().a;
        if (localIMvpFactory != null) {
          return localIMvpFactory.createModel(paramInt, paramIBasePresenterBuilder);
        }
        paramIBasePresenterBuilder = new StringBuilder();
        paramIBasePresenterBuilder.append("createModel fail, type is error = ");
        paramIBasePresenterBuilder.append(paramInt);
        throw new IllegalStateException(paramIBasePresenterBuilder.toString());
      }
      return new VideoModel(paramIBasePresenterBuilder);
    }
    return new PictureModel(paramIBasePresenterBuilder);
  }
  
  public IBasePresenterBuilder createPresenter(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        Object localObject = this.mainBrowserPresenter.getParamsBuilder().a;
        if (localObject != null) {
          return ((IMvpFactory)localObject).createPresenter(paramInt);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("createPresenter fail, type is error = ");
        ((StringBuilder)localObject).append(paramInt);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      return new VideoPresenter();
    }
    return new PicturePresenter();
  }
  
  public IBaseViewBuilder createView(Context paramContext, int paramInt, IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        IMvpFactory localIMvpFactory = this.mainBrowserPresenter.getParamsBuilder().a;
        if (localIMvpFactory != null) {
          return localIMvpFactory.createView(paramContext, paramInt, paramIBasePresenterBuilder);
        }
        paramContext = new StringBuilder();
        paramContext.append("createView fail, type is error = ");
        paramContext.append(paramInt);
        throw new IllegalStateException(paramContext.toString());
      }
      if ((paramIBasePresenterBuilder instanceof VideoPresenter)) {
        return new VideoView(paramContext, (VideoPresenter)paramIBasePresenterBuilder);
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("MVPFactory", 4, "createView type is VIDEO, presenter is error!");
      return null;
    }
    if ((paramIBasePresenterBuilder instanceof PicturePresenter)) {
      return new PictureView(paramContext, (PicturePresenter)paramIBasePresenterBuilder);
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("MVPFactory", 4, "createView type is PIC, presenter is error!");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.MVPFactory
 * JD-Core Version:    0.7.0.1
 */