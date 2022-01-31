import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;

class qiy
  extends ayvz
{
  qiy(qix paramqix) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqm localayqm = (ayqm)paramMessage.obj;
    if ((localayqm == null) || (localayqm.jdField_b_of_type_Int != 24) || (localayqm.c != 54)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((qix.a(this.a) == null) || (qix.a(this.a).jdField_a_of_type_Long != localayqm.jdField_b_of_type_Long));
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1001: 
          qix.a(this.a, System.currentTimeMillis());
        }
      } while (this.a.a == null);
      this.a.a.a();
      return;
    } while (this.a.a == null);
    this.a.a.a((float)localayqm.e * 100.0F / (float)localayqm.jdField_a_of_type_Long);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finished!");
    }
    paramMessage = new bigFileUpload.BigFileExtRsp();
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom(localayqm.jdField_a_of_type_ArrayOfByte);
        i = paramMessage.int32_retcode.get();
        if (QLog.isColorLevel()) {
          QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.errorCode:" + i);
        }
        if (i != 0) {
          continue;
        }
        qix.a(this.a, localayqm.f);
        if (paramMessage.bytes_download_url.has()) {
          qix.b(this.a, paramMessage.bytes_download_url.get().toStringUtf8());
        }
        if (paramMessage.bytes_file_name.has()) {
          qix.c(this.a, paramMessage.bytes_file_name.get().toStringUtf8());
        }
        if ((TextUtils.isEmpty(qix.c(this.a))) || (TextUtils.isEmpty(qix.d(this.a)))) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(qix.e(this.a));
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
        qix.a(this.a, 1004, null, null, null);
        qix.a(this.a, null);
        return;
      }
      if (i == 0) {
        continue;
      }
      qix.a(this.a, 0, qix.e(this.a), qix.c(this.a), qix.d(this.a));
      return;
      if ((QLog.isColorLevel()) && (paramMessage.bytes_msg.has())) {
        QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.error info:" + paramMessage.bytes_msg.get().toStringUtf8());
      }
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send error:" + localayqm.g);
    }
    qix.a(this.a, 1004, null, null, null);
    qix.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qiy
 * JD-Core Version:    0.7.0.1
 */