package com.tencent.mobileqq.richmediabrowser;

import android.app.Activity;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureModel;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoModel;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureModel;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOFileVideoPresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOPicturePresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter;
import com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;
import com.tencent.mobileqq.richmediabrowser.view.AIOPictureView;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView;
import com.tencent.richmediabrowser.core.IMvpFactory;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;

public class AIOBrowserMvpFactory
  implements IMvpFactory
{
  public BrowserBaseModel createModel(int paramInt, BasePresenter paramBasePresenter)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new AIOPictureModel();
    case 101: 
      return new AIOVideoModel();
    case 102: 
      return new AIOFilePictureModel();
    }
    return new AIOFileVideoModel();
  }
  
  public BasePresenter createPresenter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new AIOPicturePresenter();
    case 101: 
      return new AIOVideoPresenter();
    case 102: 
      return new AIOFilePicturePresenter();
    }
    return new AIOFileVideoPresenter();
  }
  
  public BrowserBaseView createView(Activity paramActivity, int paramInt, BasePresenter paramBasePresenter)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
          } while (!(paramBasePresenter instanceof AIOPicturePresenter));
          return new AIOPictureView(paramActivity, (AIOPicturePresenter)paramBasePresenter);
        } while (!(paramBasePresenter instanceof AIOVideoPresenter));
        return new AIOVideoView(paramActivity, (AIOVideoPresenter)paramBasePresenter);
      } while (!(paramBasePresenter instanceof AIOFilePicturePresenter));
      return new AIOFilePictureView(paramActivity, (AIOFilePicturePresenter)paramBasePresenter);
    } while (!(paramBasePresenter instanceof AIOFileVideoPresenter));
    return new AIOFileVideoView(paramActivity, (AIOFileVideoPresenter)paramBasePresenter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOBrowserMvpFactory
 * JD-Core Version:    0.7.0.1
 */