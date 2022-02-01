import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class sem
  extends TransProcessorHandler
{
  sem(sel paramsel) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24) || (localFileMsg.commandId != 54)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((sel.a(this.a) == null) || (sel.a(this.a).mUniseq != localFileMsg.uniseq));
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1001: 
          sel.a(this.a, System.currentTimeMillis());
        }
      } while (this.a.a == null);
      this.a.a.a();
      return;
    } while (this.a.a == null);
    this.a.a.a((float)localFileMsg.transferedSize * 100.0F / (float)localFileMsg.fileSize);
    return;
    this.a.a(localFileMsg);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send error:" + localFileMsg.errorCode);
    }
    sel.a(this.a, 1004, null, null, null);
    sel.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sem
 * JD-Core Version:    0.7.0.1
 */