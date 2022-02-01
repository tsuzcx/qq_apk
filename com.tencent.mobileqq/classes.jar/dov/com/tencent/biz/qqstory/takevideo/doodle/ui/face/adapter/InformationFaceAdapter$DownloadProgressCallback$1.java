package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import bnly;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class InformationFaceAdapter$DownloadProgressCallback$1
  implements Runnable
{
  public InformationFaceAdapter$DownloadProgressCallback$1(bnly parambnly, int paramInt) {}
  
  public void run()
  {
    bnly.a(this.jdField_a_of_type_Bnly).setVisibility(0);
    bnly.a(this.jdField_a_of_type_Bnly).setProgress(this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "progress:" + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.1
 * JD-Core Version:    0.7.0.1
 */