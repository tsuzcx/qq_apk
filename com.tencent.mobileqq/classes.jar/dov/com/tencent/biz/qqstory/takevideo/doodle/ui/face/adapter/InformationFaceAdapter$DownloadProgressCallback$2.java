package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import amtj;
import bnli;
import bnlw;
import bnly;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  public InformationFaceAdapter$DownloadProgressCallback$2(bnly parambnly, boolean paramBoolean, bnli parambnli) {}
  
  public void run()
  {
    bnly.a(this.jdField_a_of_type_Bnly).setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      bnlw.a(this.jdField_a_of_type_Bnly.a, bnly.a(this.jdField_a_of_type_Bnly), this.jdField_a_of_type_Bnli);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnly.a();
      return;
      QQToast.a(bnly.a(this.jdField_a_of_type_Bnly).getContext(), 0, amtj.a(2131704890), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */