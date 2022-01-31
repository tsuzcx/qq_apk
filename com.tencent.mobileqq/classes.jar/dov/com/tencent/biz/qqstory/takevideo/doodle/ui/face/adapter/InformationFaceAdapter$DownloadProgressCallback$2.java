package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import ajya;
import bcql;
import bkgd;
import bkgs;
import bkgu;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  public InformationFaceAdapter$DownloadProgressCallback$2(bkgu parambkgu, boolean paramBoolean, bkgd parambkgd) {}
  
  public void run()
  {
    bkgu.a(this.jdField_a_of_type_Bkgu).setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      bkgs.a(this.jdField_a_of_type_Bkgu.a, bkgu.a(this.jdField_a_of_type_Bkgu), bkgu.a(this.jdField_a_of_type_Bkgu), this.jdField_a_of_type_Bkgd);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkgu.a();
      return;
      bcql.a(bkgu.a(this.jdField_a_of_type_Bkgu).getContext(), 0, ajya.a(2131705768), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */