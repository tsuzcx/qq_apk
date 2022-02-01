package com.tencent.richmediabrowser.view.pic;

import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;

class PictureView$1
  implements IGalleryImageListener
{
  PictureView$1(PictureView paramPictureView, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dealLocalImage onLoadSuccessed, isSuccess = ");
    localStringBuilder.append(paramBoolean);
    localIBrowserLog.d("AIOPictureView", 4, localStringBuilder.toString());
    PictureView.access$000(this.this$0).onLoadFinish(paramInt, true);
    if (paramBoolean)
    {
      PictureView.access$100(this.this$0, this.val$image, this.val$filePath, this.val$fd, paramInt);
      return;
    }
    PictureView.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.pic.PictureView.1
 * JD-Core Version:    0.7.0.1
 */