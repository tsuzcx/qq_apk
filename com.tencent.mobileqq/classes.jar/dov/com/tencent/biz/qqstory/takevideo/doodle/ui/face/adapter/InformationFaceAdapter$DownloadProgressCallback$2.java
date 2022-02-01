package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;

class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  InformationFaceAdapter$DownloadProgressCallback$2(InformationFaceAdapter.DownloadProgressCallback paramDownloadProgressCallback, boolean paramBoolean, InfomationFacePackage.Item paramItem) {}
  
  public void run()
  {
    InformationFaceAdapter.DownloadProgressCallback.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback).setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      InformationFaceAdapter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback.a, InformationFaceAdapter.DownloadProgressCallback.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceInfomationFacePackage$Item);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback.a();
      return;
      QQToast.a(InformationFaceAdapter.DownloadProgressCallback.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback).getContext(), 0, HardCodeUtil.a(2131705784), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */