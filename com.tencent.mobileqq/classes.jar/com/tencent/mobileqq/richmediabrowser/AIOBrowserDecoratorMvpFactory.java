package com.tencent.mobileqq.richmediabrowser;

import android.content.Context;
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
import com.tencent.richmediabrowser.api.decorator.IDecoratorModel;
import com.tencent.richmediabrowser.api.decorator.IDecoratorPresenter;
import com.tencent.richmediabrowser.api.decorator.IDecoratorView;
import com.tencent.richmediabrowser.core.IDecoratorMvpFactory;

public class AIOBrowserDecoratorMvpFactory
  implements IDecoratorMvpFactory
{
  public IDecoratorModel a(int paramInt, IDecoratorPresenter paramIDecoratorPresenter)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 103: 
      return new AIOFileVideoModel();
    case 102: 
      return new AIOFilePictureModel();
    case 101: 
      return new AIOVideoModel();
    }
    return new AIOPictureModel();
  }
  
  public IDecoratorPresenter a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 103: 
      return new AIOFileVideoPresenter();
    case 102: 
      return new AIOFilePicturePresenter();
    case 101: 
      return new AIOVideoPresenter();
    }
    return new AIOPicturePresenter();
  }
  
  public IDecoratorView a(Context paramContext, int paramInt, IDecoratorPresenter paramIDecoratorPresenter)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 103: 
      if ((paramIDecoratorPresenter instanceof AIOFileVideoPresenter)) {
        return new AIOFileVideoView(paramContext, (AIOFileVideoPresenter)paramIDecoratorPresenter);
      }
      break;
    case 102: 
      if ((paramIDecoratorPresenter instanceof AIOFilePicturePresenter)) {
        return new AIOFilePictureView(paramContext, (AIOFilePicturePresenter)paramIDecoratorPresenter);
      }
      break;
    case 101: 
      if ((paramIDecoratorPresenter instanceof AIOVideoPresenter)) {
        return new AIOVideoView(paramContext, (AIOVideoPresenter)paramIDecoratorPresenter);
      }
      break;
    case 100: 
      if ((paramIDecoratorPresenter instanceof AIOPicturePresenter)) {
        return new AIOPictureView(paramContext, (AIOPicturePresenter)paramIDecoratorPresenter);
      }
      break;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOBrowserDecoratorMvpFactory
 * JD-Core Version:    0.7.0.1
 */