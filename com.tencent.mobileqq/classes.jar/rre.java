import android.os.Message;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class rre
  extends TransProcessorHandler
{
  rre(rrd paramrrd) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24) || (localFileMsg.commandId != 54)) {}
    while ((rrd.a(this.a) == null) || (localFileMsg.uniseq != rrd.a(this.a))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1001: 
      paramMessage = new JSONObject();
      try
      {
        paramMessage.put("uniseq", rrd.a(this.a));
        paramMessage.put("localPath", rrd.a(this.a));
        rrd.a(this.a).a(paramMessage.toString());
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "uploadListener.onStart, e=" + QLog.getStackTraceString(localException));
        }
      }
    case 1002: 
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.RIJUgcVideoUploader", 2, "mVideoTransProcessorHandler transfer=" + localException.transferedSize + ", total=" + localException.fileSize);
      }
      rrd.a(this.a).a((float)localException.transferedSize * 100.0F / (float)localException.fileSize);
      return;
    case 1003: 
      QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler send finished!");
      paramMessage = new bigFileUpload.BigFileExtRsp();
      for (;;)
      {
        try
        {
          paramMessage.mergeFrom(localException.bdhExtendInfo);
          int i = paramMessage.int32_retcode.get();
          QLog.d("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler rsp.errorCode:" + i);
          if (i != 0) {
            continue;
          }
          if (!paramMessage.bytes_download_url.has()) {
            continue;
          }
          paramMessage = paramMessage.bytes_download_url.get().toStringUtf8();
          rrd.a(this.a).a(paramMessage);
        }
        catch (Exception paramMessage)
        {
          QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "upload success but parse exception, e=" + QLog.getStackTraceString(paramMessage));
          continue;
          QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler rsp.error info:" + paramMessage.bytes_msg.get().toStringUtf8());
          rrd.a(this.a).a(localException.errorCode, paramMessage.bytes_msg.get().toStringUtf8());
          continue;
        }
        rrd.a(this.a);
        return;
        rrd.a(this.a).a(-1, "not has download url");
      }
    }
    QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler send error:" + localException.errorCode);
    rrd.a(this.a).a(localException.errorCode, "");
    rrd.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rre
 * JD-Core Version:    0.7.0.1
 */