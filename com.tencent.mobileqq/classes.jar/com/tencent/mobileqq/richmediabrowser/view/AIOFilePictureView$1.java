package com.tencent.mobileqq.richmediabrowser.view;

import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.view.pic.PictureView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;

class AIOFilePictureView$1
  implements FMDialogUtil.FMDialogInterface
{
  AIOFilePictureView$1(AIOFilePictureView paramAIOFilePictureView, AIOFilePictureData paramAIOFilePictureData) {}
  
  public void a()
  {
    try
    {
      this.b.a();
      AIOFilePictureView.a(this.b).a(this.a.a, this.a.b, 20);
      if (this.b.l.imageView != null)
      {
        this.b.l.imageView.setDoubleTapEnable(true);
        this.b.l.imageView.setScaleEnable(true);
      }
      this.b.h();
      this.b.k.g().b();
      return;
    }
    catch (Exception localException)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showFlowDialog exception = ");
      localStringBuilder.append(localException.getMessage());
      localIBrowserLog.d("AIOGalleryFilePicView", 4, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    this.b.a();
    this.b.g(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.1
 * JD-Core Version:    0.7.0.1
 */