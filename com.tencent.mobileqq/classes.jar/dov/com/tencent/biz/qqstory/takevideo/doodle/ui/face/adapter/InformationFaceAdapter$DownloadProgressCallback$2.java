package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import anvx;
import bpba;
import bpbo;
import bpbq;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  public InformationFaceAdapter$DownloadProgressCallback$2(bpbq parambpbq, boolean paramBoolean, bpba parambpba) {}
  
  public void run()
  {
    bpbq.a(this.jdField_a_of_type_Bpbq).setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      bpbo.a(this.jdField_a_of_type_Bpbq.a, bpbq.a(this.jdField_a_of_type_Bpbq), this.jdField_a_of_type_Bpba);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bpbq.a();
      return;
      QQToast.a(bpbq.a(this.jdField_a_of_type_Bpbq).getContext(), 0, anvx.a(2131705241), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */