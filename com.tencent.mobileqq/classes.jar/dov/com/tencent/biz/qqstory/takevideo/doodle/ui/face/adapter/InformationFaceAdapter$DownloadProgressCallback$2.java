package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import alpo;
import bmrn;
import bmsc;
import bmse;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  public InformationFaceAdapter$DownloadProgressCallback$2(bmse parambmse, boolean paramBoolean, bmrn parambmrn) {}
  
  public void run()
  {
    bmse.a(this.jdField_a_of_type_Bmse).setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      bmsc.a(this.jdField_a_of_type_Bmse.a, bmse.a(this.jdField_a_of_type_Bmse), this.jdField_a_of_type_Bmrn);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmse.a();
      return;
      QQToast.a(bmse.a(this.jdField_a_of_type_Bmse).getContext(), 0, alpo.a(2131706140), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */