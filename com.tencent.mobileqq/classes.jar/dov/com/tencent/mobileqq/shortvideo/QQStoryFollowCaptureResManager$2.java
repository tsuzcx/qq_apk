package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

final class QQStoryFollowCaptureResManager$2
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQStoryFollowCaptureResManager.a(), 2, "onResp resultcode: " + paramNetResp.mHttpCode + " threadid=" + Thread.currentThread().getId());
    }
    if ((paramNetResp.mHttpCode == 200) && (QQStoryFollowCaptureResManager.a(this.jdField_a_of_type_JavaLangString, this.b))) {
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager$TemplateDownloadCallback != null) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager$TemplateDownloadCallback.a();
      }
    }
    while (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager$TemplateDownloadCallback == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager$TemplateDownloadCallback.b();
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager$TemplateDownloadCallback != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQQStoryFollowCaptureResManager$TemplateDownloadCallback.a(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QQStoryFollowCaptureResManager.2
 * JD-Core Version:    0.7.0.1
 */