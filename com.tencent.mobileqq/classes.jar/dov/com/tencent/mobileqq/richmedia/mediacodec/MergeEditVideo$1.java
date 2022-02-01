package dov.com.tencent.mobileqq.richmedia.mediacodec;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder;
import dov.com.tencent.mobileqq.shortvideo.filter.QQEncodeFilterRender;

class MergeEditVideo$1
  implements HWEncodeListener
{
  MergeEditVideo$1(MergeEditVideo paramMergeEditVideo, QQEncodeFilterRender paramQQEncodeFilterRender, EncodeConfig paramEncodeConfig, PublishVideoEntry paramPublishVideoEntry, Mp4ReEncoder paramMp4ReEncoder) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    SLog.c("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = ", ???);
    if (paramInt > 10000) {
      synchronized (MergeEditVideo.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecMergeEditVideo))
      {
        MergeEditVideo.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecMergeEditVideo, true);
        MergeEditVideo.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecMergeEditVideo).notifyAll();
        return;
      }
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    synchronized (MergeEditVideo.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecMergeEditVideo))
    {
      MergeEditVideo.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecMergeEditVideo, true);
      MergeEditVideo.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecMergeEditVideo).notifyAll();
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender != null) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender.a();
      }
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder.a();
      QLog.w("MergeEditVideo", 1, "mergeVideo cancel!");
    }
  }
  
  public void onEncodeStart()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.a, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.b);
    }
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.1
 * JD-Core Version:    0.7.0.1
 */