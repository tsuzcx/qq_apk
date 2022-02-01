package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import anzj;
import bqpa;
import bqpp;
import bqpr;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  public InformationFaceAdapter$DownloadProgressCallback$2(bqpr parambqpr, boolean paramBoolean, bqpa parambqpa) {}
  
  public void run()
  {
    bqpr.a(this.jdField_a_of_type_Bqpr).setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      bqpp.a(this.jdField_a_of_type_Bqpr.a, bqpr.a(this.jdField_a_of_type_Bqpr), this.jdField_a_of_type_Bqpa);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bqpr.a();
      return;
      QQToast.a(bqpr.a(this.jdField_a_of_type_Bqpr).getContext(), 0, anzj.a(2131704660), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */