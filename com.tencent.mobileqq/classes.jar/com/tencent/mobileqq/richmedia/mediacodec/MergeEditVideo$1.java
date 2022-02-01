package com.tencent.mobileqq.richmedia.mediacodec;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.qphone.base.util.QLog;

class MergeEditVideo$1
  implements HWEncodeListener
{
  MergeEditVideo$1(MergeEditVideo paramMergeEditVideo, int[] paramArrayOfInt) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    String str;
    if (??? != null) {
      str = ???.getMessage();
    }
    for (;;)
    {
      StoryReportor.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { "", str });
      SLog.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + ???);
      MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo, paramInt);
      synchronized (MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo))
      {
        MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo, true);
        MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo).notifyAll();
        return;
        str = "UNKNOWN ERROR";
      }
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    StoryReportor.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { ??? });
    synchronized (MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo))
    {
      MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo, true);
      MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo).notifyAll();
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart()
  {
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.1
 * JD-Core Version:    0.7.0.1
 */