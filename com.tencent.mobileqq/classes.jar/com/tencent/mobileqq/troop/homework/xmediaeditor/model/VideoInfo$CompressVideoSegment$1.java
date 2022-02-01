package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem.VideoViewHolder;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

class VideoInfo$CompressVideoSegment$1
  implements Runnable
{
  VideoInfo$CompressVideoSegment$1(VideoInfo.CompressVideoSegment paramCompressVideoSegment, VideoInfo paramVideoInfo, XMediaEditor paramXMediaEditor) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.e = 10;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.g = -2147483647;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.c);
    if ((localObject instanceof VideoItem.VideoViewHolder))
    {
      localObject = (VideoItem.VideoViewHolder)localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.d.equals(((VideoItem.VideoViewHolder)localObject).a.getTag()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        ((VideoItem)((XMediaEditorAdapter)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((ImageItem.ImageViewHolder)localObject, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment.1
 * JD-Core Version:    0.7.0.1
 */