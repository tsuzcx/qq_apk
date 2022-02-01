package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import bqpr;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class InformationFaceAdapter$DownloadProgressCallback$1
  implements Runnable
{
  public InformationFaceAdapter$DownloadProgressCallback$1(bqpr parambqpr, int paramInt) {}
  
  public void run()
  {
    bqpr.a(this.jdField_a_of_type_Bqpr).setVisibility(0);
    bqpr.a(this.jdField_a_of_type_Bqpr).setProgress(this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "progress:" + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.1
 * JD-Core Version:    0.7.0.1
 */