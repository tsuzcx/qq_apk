import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class rrx
  extends TransProcessorHandler
{
  rrx(rrw paramrrw) {}
  
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
        } while ((rrw.a(this.a) == null) || (rrw.a(this.a).mUniseq != localFileMsg.uniseq));
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1001: 
          rrw.a(this.a, System.currentTimeMillis());
        }
      } while (this.a.a == null);
      this.a.a.a();
      return;
    } while (this.a.a == null);
    this.a.a.a((float)localFileMsg.transferedSize * 100.0F / (float)localFileMsg.fileSize);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finished!");
    }
    paramMessage = new bigFileUpload.BigFileExtRsp();
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom(localFileMsg.bdhExtendInfo);
        i = paramMessage.int32_retcode.get();
        if (QLog.isColorLevel()) {
          QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.errorCode:" + i);
        }
        if (i != 0) {
          continue;
        }
        rrw.a(this.a, localFileMsg.fileMd5);
        if (paramMessage.bytes_download_url.has()) {
          rrw.b(this.a, paramMessage.bytes_download_url.get().toStringUtf8());
        }
        if (paramMessage.bytes_file_name.has()) {
          rrw.c(this.a, paramMessage.bytes_file_name.get().toStringUtf8());
        }
        if ((TextUtils.isEmpty(rrw.c(this.a))) || (TextUtils.isEmpty(rrw.d(this.a)))) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(rrw.e(this.a));
        if (bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramMessage)
      {
        int i = 0;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finish with error!");
        rrw.a(this.a, 1004, null, null, null);
        rrw.a(this.a, null);
        return;
      }
      if (i == 0) {
        continue;
      }
      rrw.a(this.a, 0, rrw.e(this.a), rrw.c(this.a), rrw.d(this.a));
      return;
      if ((QLog.isColorLevel()) && (paramMessage.bytes_msg.has())) {
        QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.error info:" + paramMessage.bytes_msg.get().toStringUtf8());
      }
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send error:" + localFileMsg.errorCode);
    }
    rrw.a(this.a, 1004, null, null, null);
    rrw.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrx
 * JD-Core Version:    0.7.0.1
 */