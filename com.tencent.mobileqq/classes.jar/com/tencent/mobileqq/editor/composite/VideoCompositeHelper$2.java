package com.tencent.mobileqq.editor.composite;

import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.ConvertListener;
import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.RetCode;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;

class VideoCompositeHelper$2
  implements VideoStoryPicToVideo.ConvertListener
{
  VideoCompositeHelper$2(VideoCompositeHelper paramVideoCompositeHelper, VideoStoryPicToVideo.RetCode paramRetCode, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(VideoStoryPicToVideo.RetCode paramRetCode)
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo$RetCode.a(0);
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoRangeEnd = 60000;
    VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper, "convertImageToVideo ");
  }
  
  public void b(VideoStoryPicToVideo.RetCode paramRetCode)
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo$RetCode.a(paramRetCode.a());
    VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper, "convertImageToVideo ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeHelper.2
 * JD-Core Version:    0.7.0.1
 */