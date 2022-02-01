import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class sef
  extends TransProcessorHandler
{
  sef(see paramsee) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24) || (localFileMsg.commandId != 10)) {}
    while ((localFileMsg.uniseq != this.a.a.mUniseq) || (localFileMsg.fileMd5.equals(see.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mVideoTransProcessorHandler transfer=" + localFileMsg.transferedSize + ", total=" + localFileMsg.fileSize);
      see.a(this.a, (float)localFileMsg.transferedSize * 100.0F / (float)localFileMsg.fileSize);
      return;
    case 1003: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
      see.a(this.a, localFileMsg.fileMd5);
      see.b(this.a, localFileMsg.fileUrl);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler mImageMd5=" + see.a(this.a) + ", mImageUrl=" + see.b(this.a));
      see.a(this.a, 0, see.b(this.a), see.a(this.a), null, null, null);
      return;
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
    see.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sef
 * JD-Core Version:    0.7.0.1
 */