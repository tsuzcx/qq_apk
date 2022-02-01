import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class sed
  extends TransProcessorHandler
{
  sed(sec paramsec) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24) || (localFileMsg.commandId != 10)) {}
    while ((localFileMsg.uniseq != this.a.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mUniseq) || (TextUtils.equals(localFileMsg.fileMd5, sec.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1001: 
      if (this.a.jdField_a_of_type_Seb != null) {
        this.a.jdField_a_of_type_Seb.a();
      }
      sec.a(this.a, System.currentTimeMillis());
      return;
    case 1003: 
      sec.b(this.a, System.currentTimeMillis());
      olh.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(sec.a(this.a)), String.valueOf(sec.b(this.a)), String.valueOf(sec.a(this.a) - sec.b(this.a)), String.valueOf(sec.c(this.a) - sec.d(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
      }
      sec.a(this.a, localFileMsg.fileMd5);
      sec.b(this.a, localFileMsg.fileUrl);
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler mImageMd5=" + sec.a(this.a) + ", mImageUrl=" + sec.b(this.a));
      }
      sec.a(this.a, 0, sec.b(this.a), sec.a(this.a), null);
      return;
    }
    sec.b(this.a, System.currentTimeMillis());
    olh.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(sec.a(this.a)), String.valueOf(sec.b(this.a)), String.valueOf(sec.a(this.a) - sec.b(this.a)), String.valueOf(sec.c(this.a) - sec.d(this.a)));
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send error:" + localFileMsg.errorCode);
    }
    sec.a(this.a, 1004, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sed
 * JD-Core Version:    0.7.0.1
 */