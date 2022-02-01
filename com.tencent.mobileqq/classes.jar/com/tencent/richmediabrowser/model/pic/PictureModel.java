package com.tencent.richmediabrowser.model.pic;

import android.graphics.drawable.Drawable;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;
import java.io.File;

public class PictureModel
  extends BrowserBaseModel
{
  private PicturePresenter picturePresenter;
  
  public PictureModel(BasePresenter paramBasePresenter)
  {
    if ((paramBasePresenter instanceof PicturePresenter)) {
      this.picturePresenter = ((PicturePresenter)paramBasePresenter);
    }
  }
  
  public Drawable getAnimationDrawable(PictureData paramPictureData)
  {
    return null;
  }
  
  public File getCacheFile(PictureData paramPictureData, int paramInt)
  {
    return null;
  }
  
  public int getCacheFileType(PictureData paramPictureData, String paramString)
  {
    return 0;
  }
  
  public String getURL(PictureData paramPictureData, int paramInt)
  {
    return null;
  }
  
  public boolean hasFile(PictureData paramPictureData, int paramInt)
  {
    return false;
  }
  
  public void imageDownloaded(PictureData paramPictureData, int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.pic.PictureModel
 * JD-Core Version:    0.7.0.1
 */