import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;

class qiv
  extends aywb
{
  qiv(qiu paramqiu) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqo localayqo = (ayqo)paramMessage.obj;
    if ((localayqo == null) || (localayqo.jdField_b_of_type_Int != 24) || (localayqo.c != 54)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((qiu.a(this.a) == null) || (qiu.a(this.a).jdField_a_of_type_Long != localayqo.jdField_b_of_type_Long));
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1001: 
          qiu.a(this.a, System.currentTimeMillis());
        }
      } while (this.a.a == null);
      this.a.a.a();
      return;
    } while (this.a.a == null);
    this.a.a.a((float)localayqo.e * 100.0F / (float)localayqo.jdField_a_of_type_Long);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finished!");
    }
    paramMessage = new bigFileUpload.BigFileExtRsp();
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom(localayqo.jdField_a_of_type_ArrayOfByte);
        i = paramMessage.int32_retcode.get();
        if (QLog.isColorLevel()) {
          QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.errorCode:" + i);
        }
        if (i != 0) {
          continue;
        }
        qiu.a(this.a, localayqo.f);
        if (paramMessage.bytes_download_url.has()) {
          qiu.b(this.a, paramMessage.bytes_download_url.get().toStringUtf8());
        }
        if (paramMessage.bytes_file_name.has()) {
          qiu.c(this.a, paramMessage.bytes_file_name.get().toStringUtf8());
        }
        if ((TextUtils.isEmpty(qiu.c(this.a))) || (TextUtils.isEmpty(qiu.d(this.a)))) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(qiu.e(this.a));
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
        qiu.a(this.a, 1004, null, null, null);
        qiu.a(this.a, null);
        return;
      }
      if (i == 0) {
        continue;
      }
      qiu.a(this.a, 0, qiu.e(this.a), qiu.c(this.a), qiu.d(this.a));
      return;
      if ((QLog.isColorLevel()) && (paramMessage.bytes_msg.has())) {
        QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.error info:" + paramMessage.bytes_msg.get().toStringUtf8());
      }
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send error:" + localayqo.g);
    }
    qiu.a(this.a, 1004, null, null, null);
    qiu.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qiv
 * JD-Core Version:    0.7.0.1
 */