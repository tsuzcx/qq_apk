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
    ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment$MediaUploadCallback.a).e = this.jdField_a_of_type_Int;
    Object localObject = (XMediaEditor)ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment$MediaUploadCallback.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment$MediaUploadCallback.a).c);
      if ((localObject instanceof ImageItem.ImageViewHolder))
      {
        localObject = (ImageItem.ImageViewHolder)localObject;
        if (ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment$MediaUploadCallback.a).d.equals(((ImageItem.ImageViewHolder)localObject).a.getTag()))
        {
          ((ImageItem.ImageViewHolder)localObject).a.setVisibility(0);
          ((ImageItem.ImageViewHolder)localObject).a.setDrawStatus(1);
          ((ImageItem.ImageViewHolder)localObject).a.setAnimProgress(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment$MediaUploadCallback.a).e, ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment$MediaUploadCallback.a).d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */