package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.IInformationPasterResDownloaderCallback;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;

class InformationFaceAdapter$DownloadProgressCallback
  implements QIMInformationPasterManager.IInformationPasterResDownloaderCallback
{
  private QIMCommonLoadingView jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  
  InformationFaceAdapter$DownloadProgressCallback(InformationFaceAdapter paramInformationFaceAdapter, QIMCommonLoadingView paramQIMCommonLoadingView, ImageView paramImageView)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = paramQIMCommonLoadingView;
    this.jdField_a_of_type_JavaLangBoolean = ((Boolean)paramImageView.getTag(2131378891));
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = null;
    this.jdField_a_of_type_JavaLangBoolean = null;
  }
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    paramInt = (int)paramFloat;
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.post(new InformationFaceAdapter.DownloadProgressCallback.1(this, paramInt));
  }
  
  public void a(boolean paramBoolean, String paramString, InfomationFacePackage.Item paramItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "isSuccess:" + paramBoolean);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.post(new InformationFaceAdapter.DownloadProgressCallback.2(this, paramBoolean, paramItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback
 * JD-Core Version:    0.7.0.1
 */