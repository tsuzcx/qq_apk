import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class rrq
  extends TransProcessorHandler
{
  rrq(rrp paramrrp) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24) || (localFileMsg.commandId != 10)) {}
    while ((localFileMsg.uniseq != this.a.a.mUniseq) || (localFileMsg.fileMd5.equals(rrp.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mVideoTransProcessorHandler transfer=" + localFileMsg.transferedSize + ", total=" + localFileMsg.fileSize);
      rrp.a(this.a, (float)localFileMsg.transferedSize * 100.0F / (float)localFileMsg.fileSize);
      return;
    case 1003: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
      rrp.a(this.a, localFileMsg.fileMd5);
      rrp.b(this.a, localFileMsg.fileUrl);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler mImageMd5=" + rrp.a(this.a) + ", mImageUrl=" + rrp.b(this.a));
      rrp.a(this.a, 0, rrp.b(this.a), rrp.a(this.a), null, null, null);
      return;
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
    rrp.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrq
 * JD-Core Version:    0.7.0.1
 */