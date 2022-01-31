package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import ajyc;
import bcpw;
import bkfm;
import bkgb;
import bkgd;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  public InformationFaceAdapter$DownloadProgressCallback$2(bkgd parambkgd, boolean paramBoolean, bkfm parambkfm) {}
  
  public void run()
  {
    bkgd.a(this.jdField_a_of_type_Bkgd).setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      bkgb.a(this.jdField_a_of_type_Bkgd.a, bkgd.a(this.jdField_a_of_type_Bkgd), bkgd.a(this.jdField_a_of_type_Bkgd), this.jdField_a_of_type_Bkfm);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkgd.a();
      return;
      bcpw.a(bkgd.a(this.jdField_a_of_type_Bkgd).getContext(), 0, ajyc.a(2131705757), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */