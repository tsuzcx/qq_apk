import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;

class pxa
  extends axvs
{
  pxa(pwz parampwz) {}
  
  public void handleMessage(Message paramMessage)
  {
    axqf localaxqf = (axqf)paramMessage.obj;
    if ((localaxqf == null) || (localaxqf.jdField_b_of_type_Int != 24) || (localaxqf.c != 54)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((pwz.a(this.a) == null) || (pwz.a(this.a).jdField_a_of_type_Long != localaxqf.jdField_b_of_type_Long));
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1001: 
          pwz.a(this.a, System.currentTimeMillis());
        }
      } while (this.a.a == null);
      this.a.a.a();
      return;
    } while (this.a.a == null);
    this.a.a.a((float)localaxqf.e * 100.0F / (float)localaxqf.jdField_a_of_type_Long);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finished!");
    }
    paramMessage = new bigFileUpload.BigFileExtRsp();
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom(localaxqf.jdField_a_of_type_ArrayOfByte);
        i = paramMessage.int32_retcode.get();
        if (QLog.isColorLevel()) {
          QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.errorCode:" + i);
        }
        if (i != 0) {
          continue;
        }
        pwz.a(this.a, localaxqf.f);
        if (paramMessage.bytes_download_url.has()) {
          pwz.b(this.a, paramMessage.bytes_download_url.get().toStringUtf8());
        }
        if (paramMessage.bytes_file_name.has()) {
          pwz.c(this.a, paramMessage.bytes_file_name.get().toStringUtf8());
        }
        if ((TextUtils.isEmpty(pwz.c(this.a))) || (TextUtils.isEmpty(pwz.d(this.a)))) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(pwz.e(this.a));
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
        pwz.a(this.a, 1004, null, null, null);
        pwz.a(this.a, null);
        return;
      }
      if (i == 0) {
        continue;
      }
      pwz.a(this.a, 0, pwz.e(this.a), pwz.c(this.a), pwz.d(this.a));
      return;
      if ((QLog.isColorLevel()) && (paramMessage.bytes_msg.has())) {
        QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.error info:" + paramMessage.bytes_msg.get().toStringUtf8());
      }
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send error:" + localaxqf.g);
    }
    pwz.a(this.a, 1004, null, null, null);
    pwz.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pxa
 * JD-Core Version:    0.7.0.1
 */