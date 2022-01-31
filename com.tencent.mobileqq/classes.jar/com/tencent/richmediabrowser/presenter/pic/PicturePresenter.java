package com.tencent.richmediabrowser.presenter.pic;

import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.BaseView;
import com.tencent.richmediabrowser.view.pic.PictureView;

public class PicturePresenter
  extends BrowserBasePresenter
{
  private static final String TAG = "PicturePresenter";
  public PictureView pictureView;
  
  public void notifyProgress(String paramString, int paramInt)
  {
    super.notifyProgress(paramString, paramInt);
    if (this.pictureView != null) {
      this.pictureView.updateUI();
    }
  }
  
  public void notifyResult(String paramString, int paramInt)
  {
    super.notifyResult(paramString, paramInt);
    BrowserLogHelper.getInstance().getGalleryLog().d("PicturePresenter", 4, "notifyResult id = " + paramString + " ,resutlt = " + paramInt);
    if (this.pictureView != null) {
      this.pictureView.updateUI();
    }
  }
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    super.setGalleryModel(paramBrowserBaseModel);
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    super.setGalleryView(paramBaseView);
    if ((paramBaseView instanceof PictureView)) {
      this.pictureView = ((PictureView)paramBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.pic.PicturePresenter
 * JD-Core Version:    0.7.0.1
 */