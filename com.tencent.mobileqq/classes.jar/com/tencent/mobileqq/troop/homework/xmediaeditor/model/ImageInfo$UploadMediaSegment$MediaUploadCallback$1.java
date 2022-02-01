package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem.VideoViewHolder;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

class ImageInfo$UploadMediaSegment$MediaUploadCallback$1
  implements Runnable
{
  ImageInfo$UploadMediaSegment$MediaUploadCallback$1(ImageInfo.UploadMediaSegment.MediaUploadCallback paramMediaUploadCallback, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment$MediaUploadCallback.a).e = 95;
    ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment$MediaUploadCallback.a).f = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment$MediaUploadCallback.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment$MediaUploadCallback.a).c);
      if ((localObject instanceof VideoItem.VideoViewHolder))
      {
        localObject = (VideoItem.VideoViewHolder)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.d.equals(((VideoItem.VideoViewHolder)localObject).a.getTag())) {
          ((VideoItem)((XMediaEditorAdapter)localXMediaEditor.getAdapter()).a.a(2)).a((ImageItem.ImageViewHolder)localObject, ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment$MediaUploadCallback.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */