package com.tencent.mobileqq.editor.composite.step;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.filter.QQEncodeFilterRender;
import com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.qphone.base.util.QLog;

class MergeEditVideo$1
  implements HWEncodeListener
{
  MergeEditVideo$1(MergeEditVideo paramMergeEditVideo, QQEncodeFilterRender paramQQEncodeFilterRender, EncodeConfig paramEncodeConfig, PublishVideoEntry paramPublishVideoEntry, Mp4ReEncoder paramMp4ReEncoder) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("encode error errorCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" Exception = ");
    SLog.c("MergeEditVideo", localStringBuilder.toString(), ???);
    if (paramInt > 10000) {
      synchronized (MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMergeEditVideo))
      {
        MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMergeEditVideo, true);
        MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMergeEditVideo).notifyAll();
        return;
      }
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    synchronized (MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMergeEditVideo))
    {
      MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMergeEditVideo, true);
      MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMergeEditVideo).notifyAll();
      ??? = this.jdField_a_of_type_ComTencentMobileqqFilterQQEncodeFilterRender;
      if (??? != null) {
        ???.a();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.isCancel)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder.a();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
  
  public void onEncodeStart()
  {
    QQEncodeFilterRender localQQEncodeFilterRender = this.jdField_a_of_type_ComTencentMobileqqFilterQQEncodeFilterRender;
    if (localQQEncodeFilterRender != null) {
      localQQEncodeFilterRender.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.a, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.b);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.MergeEditVideo.1
 * JD-Core Version:    0.7.0.1
 */