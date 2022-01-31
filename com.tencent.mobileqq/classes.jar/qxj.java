import android.os.Message;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class qxj
  extends baua
{
  qxj(qxi paramqxi) {}
  
  public void handleMessage(Message paramMessage)
  {
    baoj localbaoj = (baoj)paramMessage.obj;
    if ((localbaoj == null) || (localbaoj.jdField_b_of_type_Int != 24) || (localbaoj.c != 54)) {}
    while ((qxi.a(this.a) == null) || (localbaoj.jdField_b_of_type_Long != qxi.a(this.a))) {
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
        paramMessage.put("uniseq", qxi.a(this.a));
        paramMessage.put("localPath", qxi.a(this.a));
        qxi.a(this.a).a(paramMessage.toString());
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
        QLog.d("RIJUGC.RIJUgcVideoUploader", 2, "mVideoTransProcessorHandler transfer=" + localException.e + ", total=" + localException.jdField_a_of_type_Long);
      }
      qxi.a(this.a).a((float)localException.e * 100.0F / (float)localException.jdField_a_of_type_Long);
      return;
    case 1003: 
      QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler send finished!");
      paramMessage = new bigFileUpload.BigFileExtRsp();
      for (;;)
      {
        try
        {
          paramMessage.mergeFrom(localException.jdField_a_of_type_ArrayOfByte);
          int i = paramMessage.int32_retcode.get();
          QLog.d("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler rsp.errorCode:" + i);
          if (i != 0) {
            continue;
          }
          if (!paramMessage.bytes_download_url.has()) {
            continue;
          }
          paramMessage = paramMessage.bytes_download_url.get().toStringUtf8();
          qxi.a(this.a).a(paramMessage);
        }
        catch (Exception paramMessage)
        {
          QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "upload success but parse exception, e=" + QLog.getStackTraceString(paramMessage));
          continue;
          QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler rsp.error info:" + paramMessage.bytes_msg.get().toStringUtf8());
          qxi.a(this.a).a(localException.g, paramMessage.bytes_msg.get().toStringUtf8());
          continue;
        }
        qxi.a(this.a);
        return;
        qxi.a(this.a).a(-1, "not has download url");
      }
    }
    QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler send error:" + localException.g);
    qxi.a(this.a).a(localException.g, "");
    qxi.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qxj
 * JD-Core Version:    0.7.0.1
 */