package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import anni;
import bpnf;
import bpnu;
import bpnw;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  public InformationFaceAdapter$DownloadProgressCallback$2(bpnw parambpnw, boolean paramBoolean, bpnf parambpnf) {}
  
  public void run()
  {
    bpnw.a(this.jdField_a_of_type_Bpnw).setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      bpnu.a(this.jdField_a_of_type_Bpnw.a, bpnw.a(this.jdField_a_of_type_Bpnw), this.jdField_a_of_type_Bpnf);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bpnw.a();
      return;
      QQToast.a(bpnw.a(this.jdField_a_of_type_Bpnw).getContext(), 0, anni.a(2131704553), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */