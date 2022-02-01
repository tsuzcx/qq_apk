import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class rro
  extends TransProcessorHandler
{
  rro(rrn paramrrn) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24) || (localFileMsg.commandId != 10)) {}
    while ((localFileMsg.uniseq != this.a.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mUniseq) || (TextUtils.equals(localFileMsg.fileMd5, rrn.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1001: 
      if (this.a.jdField_a_of_type_Rrm != null) {
        this.a.jdField_a_of_type_Rrm.a();
      }
      rrn.a(this.a, System.currentTimeMillis());
      return;
    case 1003: 
      rrn.b(this.a, System.currentTimeMillis());
      odq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(rrn.a(this.a)), String.valueOf(rrn.b(this.a)), String.valueOf(rrn.a(this.a) - rrn.b(this.a)), String.valueOf(rrn.c(this.a) - rrn.d(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
      }
      rrn.a(this.a, localFileMsg.fileMd5);
      rrn.b(this.a, localFileMsg.fileUrl);
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler mImageMd5=" + rrn.a(this.a) + ", mImageUrl=" + rrn.b(this.a));
      }
      rrn.a(this.a, 0, rrn.b(this.a), rrn.a(this.a), null);
      return;
    }
    rrn.b(this.a, System.currentTimeMillis());
    odq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(rrn.a(this.a)), String.valueOf(rrn.b(this.a)), String.valueOf(rrn.a(this.a) - rrn.b(this.a)), String.valueOf(rrn.c(this.a) - rrn.d(this.a)));
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send error:" + localFileMsg.errorCode);
    }
    rrn.a(this.a, 1004, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rro
 * JD-Core Version:    0.7.0.1
 */