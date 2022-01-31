package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import alud;
import bmvz;
import bmwo;
import bmwq;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  public InformationFaceAdapter$DownloadProgressCallback$2(bmwq parambmwq, boolean paramBoolean, bmvz parambmvz) {}
  
  public void run()
  {
    bmwq.a(this.jdField_a_of_type_Bmwq).setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      bmwo.a(this.jdField_a_of_type_Bmwq.a, bmwq.a(this.jdField_a_of_type_Bmwq), this.jdField_a_of_type_Bmvz);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmwq.a();
      return;
      QQToast.a(bmwq.a(this.jdField_a_of_type_Bmwq).getContext(), 0, alud.a(2131706152), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */