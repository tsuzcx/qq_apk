import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;

class qyc
  extends baua
{
  qyc(qyb paramqyb) {}
  
  public void handleMessage(Message paramMessage)
  {
    baoj localbaoj = (baoj)paramMessage.obj;
    if ((localbaoj == null) || (localbaoj.jdField_b_of_type_Int != 24) || (localbaoj.c != 54)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((qyb.a(this.a) == null) || (qyb.a(this.a).jdField_a_of_type_Long != localbaoj.jdField_b_of_type_Long));
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1001: 
          qyb.a(this.a, System.currentTimeMillis());
        }
      } while (this.a.a == null);
      this.a.a.a();
      return;
    } while (this.a.a == null);
    this.a.a.a((float)localbaoj.e * 100.0F / (float)localbaoj.jdField_a_of_type_Long);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finished!");
    }
    paramMessage = new bigFileUpload.BigFileExtRsp();
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom(localbaoj.jdField_a_of_type_ArrayOfByte);
        i = paramMessage.int32_retcode.get();
        if (QLog.isColorLevel()) {
          QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.errorCode:" + i);
        }
        if (i != 0) {
          continue;
        }
        qyb.a(this.a, localbaoj.f);
        if (paramMessage.bytes_download_url.has()) {
          qyb.b(this.a, paramMessage.bytes_download_url.get().toStringUtf8());
        }
        if (paramMessage.bytes_file_name.has()) {
          qyb.c(this.a, paramMessage.bytes_file_name.get().toStringUtf8());
        }
        if ((TextUtils.isEmpty(qyb.c(this.a))) || (TextUtils.isEmpty(qyb.d(this.a)))) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(qyb.e(this.a));
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
        qyb.a(this.a, 1004, null, null, null);
        qyb.a(this.a, null);
        return;
      }
      if (i == 0) {
        continue;
      }
      qyb.a(this.a, 0, qyb.e(this.a), qyb.c(this.a), qyb.d(this.a));
      return;
      if ((QLog.isColorLevel()) && (paramMessage.bytes_msg.has())) {
        QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.error info:" + paramMessage.bytes_msg.get().toStringUtf8());
      }
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send error:" + localbaoj.g);
    }
    qyb.a(this.a, 1004, null, null, null);
    qyb.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qyc
 * JD-Core Version:    0.7.0.1
 */