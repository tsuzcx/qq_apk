import android.os.Message;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.FileUploadController.FileUploadListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.ImageUploadController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

public class lzk
  extends TransProcessorHandler
{
  public lzk(ImageUploadController paramImageUploadController) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.b != 24) || (localFileMsg.c != 10)) {}
    while (localFileMsg.f.equals(ImageUploadController.a(this.a))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1001: 
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener != null) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener.a();
      }
      ImageUploadController.a(this.a, System.currentTimeMillis());
      return;
    case 1003: 
      ImageUploadController.b(this.a, System.currentTimeMillis());
      PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(ImageUploadController.a(this.a)), String.valueOf(ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.a(this.a) - ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.c(this.a) - ImageUploadController.d(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
      }
      ImageUploadController.a(this.a, localFileMsg.f);
      ImageUploadController.b(this.a, localFileMsg.i);
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler mImageMd5=" + ImageUploadController.a(this.a) + ", mImageUrl=" + ImageUploadController.b(this.a));
      }
      ImageUploadController.a(this.a, 0, ImageUploadController.b(this.a), ImageUploadController.a(this.a), null);
      return;
    }
    ImageUploadController.b(this.a, System.currentTimeMillis());
    PublicAccountReportUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(ImageUploadController.a(this.a)), String.valueOf(ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.a(this.a) - ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.c(this.a) - ImageUploadController.d(this.a)));
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send error:" + localFileMsg.g);
    }
    ImageUploadController.a(this.a, 1004, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzk
 * JD-Core Version:    0.7.0.1
 */