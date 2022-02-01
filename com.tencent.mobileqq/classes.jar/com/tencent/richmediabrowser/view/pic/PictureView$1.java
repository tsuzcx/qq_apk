package com.tencent.richmediabrowser.view.pic;

import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.pic.PictureData;

class PictureView$1
  implements IGalleryImageListener
{
  PictureView$1(PictureView paramPictureView, RichMediaBrowserInfo paramRichMediaBrowserInfo, PictureData paramPictureData, URLDrawable paramURLDrawable) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      PictureView.access$000(this.this$0, this.val$browserInfo, this.val$data.filePath, this.val$fd, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.pic.PictureView.1
 * JD-Core Version:    0.7.0.1
 */