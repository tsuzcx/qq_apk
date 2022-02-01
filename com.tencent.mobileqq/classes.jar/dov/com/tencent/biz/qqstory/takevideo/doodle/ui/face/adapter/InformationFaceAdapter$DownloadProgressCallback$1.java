package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

class InformationFaceAdapter$DownloadProgressCallback$1
  implements Runnable
{
  InformationFaceAdapter$DownloadProgressCallback$1(InformationFaceAdapter.DownloadProgressCallback paramDownloadProgressCallback, int paramInt) {}
  
  public void run()
  {
    InformationFaceAdapter.DownloadProgressCallback.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback).setVisibility(0);
    InformationFaceAdapter.DownloadProgressCallback.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback).setProgress(this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "progress:" + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.1
 * JD-Core Version:    0.7.0.1
 */