package com.tencent.richmediabrowser.model.pic;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.richmediabrowser.core.IBaseModelBuilder;
import com.tencent.richmediabrowser.core.IBasePresenterBuilder;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;
import java.io.File;

public class PictureModel
  implements IBaseModelBuilder
{
  private PicturePresenter picturePresenter;
  
  public PictureModel(IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    if ((paramIBasePresenterBuilder instanceof PicturePresenter)) {
      this.picturePresenter = ((PicturePresenter)paramIBasePresenterBuilder);
    }
  }
  
  public void buildComplete() {}
  
  public void buildModel() {}
  
  public void buildParams(Intent paramIntent) {}
  
  public boolean isPictureExisit(PictureData paramPictureData)
  {
    if ((paramPictureData != null) && (!TextUtils.isEmpty(paramPictureData.filePath))) {
      return new File(paramPictureData.filePath).exists();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.pic.PictureModel
 * JD-Core Version:    0.7.0.1
 */