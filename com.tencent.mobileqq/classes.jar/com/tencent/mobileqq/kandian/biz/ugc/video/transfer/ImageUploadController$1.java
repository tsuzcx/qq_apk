package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class ImageUploadController$1
  extends TransProcessorHandler
{
  ImageUploadController$1(ImageUploadController paramImageUploadController) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg != null) && (localFileMsg.fileType == 24))
    {
      if (localFileMsg.commandId != 10) {
        return;
      }
      if (localFileMsg.uniseq != this.a.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mUniseq) {
        return;
      }
      if (TextUtils.equals(localFileMsg.fileMd5, ImageUploadController.a(this.a))) {
        return;
      }
      int i = paramMessage.what;
      if (i != 1001)
      {
        if (i != 1003)
        {
          if (i != 1005) {
            return;
          }
          ImageUploadController.b(this.a, System.currentTimeMillis());
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(ImageUploadController.a(this.a)), String.valueOf(ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.a(this.a) - ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.c(this.a) - ImageUploadController.d(this.a)));
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("mPicTransProcessorHandler send error:");
            paramMessage.append(localFileMsg.errorCode);
            QLog.d("ImageUploadController", 2, paramMessage.toString());
          }
          ImageUploadController.a(this.a, 1004, null, null, null);
          return;
        }
        ImageUploadController.b(this.a, System.currentTimeMillis());
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(ImageUploadController.a(this.a)), String.valueOf(ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.a(this.a) - ImageUploadController.b(this.a)), String.valueOf(ImageUploadController.c(this.a) - ImageUploadController.d(this.a)));
        if (QLog.isColorLevel()) {
          QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
        }
        ImageUploadController.a(this.a, localFileMsg.fileMd5);
        ImageUploadController.b(this.a, localFileMsg.fileUrl);
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("mPicTransProcessorHandler mImageMd5=");
          paramMessage.append(ImageUploadController.a(this.a));
          paramMessage.append(", mImageUrl=");
          paramMessage.append(ImageUploadController.b(this.a));
          QLog.d("ImageUploadController", 2, paramMessage.toString());
        }
        paramMessage = this.a;
        ImageUploadController.a(paramMessage, 0, ImageUploadController.b(paramMessage), ImageUploadController.a(this.a), null);
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoTransferFileUploadController$FileUploadListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoTransferFileUploadController$FileUploadListener.a();
      }
      ImageUploadController.a(this.a, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.ImageUploadController.1
 * JD-Core Version:    0.7.0.1
 */