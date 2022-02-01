package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

class ImageInfo$UploadMediaSegment$MediaUploadCallback$2
  implements Runnable
{
  ImageInfo$UploadMediaSegment$MediaUploadCallback$2(ImageInfo.UploadMediaSegment.MediaUploadCallback paramMediaUploadCallback, int paramInt) {}
  
  public void run()
  {
    ImageInfo.UploadMediaSegment.b(this.b.a).l = this.a;
    Object localObject = (XMediaEditor)ImageInfo.UploadMediaSegment.c(this.b.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(ImageInfo.UploadMediaSegment.b(this.b.a).g);
      if ((localObject instanceof ImageItem.ImageViewHolder))
      {
        localObject = (ImageItem.ImageViewHolder)localObject;
        if (ImageInfo.UploadMediaSegment.b(this.b.a).e.equals(((ImageItem.ImageViewHolder)localObject).g.getTag()))
        {
          ((ImageItem.ImageViewHolder)localObject).g.setVisibility(0);
          ((ImageItem.ImageViewHolder)localObject).g.setDrawStatus(1);
          ((ImageItem.ImageViewHolder)localObject).g.setAnimProgress(ImageInfo.UploadMediaSegment.b(this.b.a).l, ImageInfo.UploadMediaSegment.b(this.b.a).e);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */