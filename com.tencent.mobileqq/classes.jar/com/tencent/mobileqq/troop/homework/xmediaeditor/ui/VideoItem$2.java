package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class VideoItem$2
  extends SimpleObserver<VideoInfo>
{
  VideoItem$2(VideoItem paramVideoItem, VideoInfo paramVideoInfo) {}
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(paramVideoInfo.c), ", old status=", Integer.valueOf(paramVideoInfo.f) });
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiVideoItem.b.remove(paramVideoInfo);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiVideoItem.a(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.c), ", old status=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.f) });
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.f = 2;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiVideoItem.b.remove(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiVideoItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiVideoItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.c);
      if ((localObject instanceof VideoItem.VideoViewHolder))
      {
        localObject = (VideoItem.VideoViewHolder)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.d.equals(((VideoItem.VideoViewHolder)localObject).a.getTag())) {
          ((VideoItem)((XMediaEditorAdapter)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiVideoItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((ImageItem.ImageViewHolder)localObject, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      TroopReportor.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.a), "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.d.equals(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiVideoItem.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiVideoItem.a(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem.2
 * JD-Core Version:    0.7.0.1
 */