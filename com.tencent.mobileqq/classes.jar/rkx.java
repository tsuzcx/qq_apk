import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;

class rkx
  extends beyf
{
  rkx(rkw paramrkw) {}
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if ((localbete == null) || (localbete.jdField_b_of_type_Int != 24) || (localbete.c != 54)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((rkw.a(this.a) == null) || (rkw.a(this.a).jdField_a_of_type_Long != localbete.jdField_b_of_type_Long));
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1001: 
          rkw.a(this.a, System.currentTimeMillis());
        }
      } while (this.a.a == null);
      this.a.a.a();
      return;
    } while (this.a.a == null);
    this.a.a.a((float)localbete.e * 100.0F / (float)localbete.jdField_a_of_type_Long);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finished!");
    }
    paramMessage = new bigFileUpload.BigFileExtRsp();
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom(localbete.jdField_a_of_type_ArrayOfByte);
        i = paramMessage.int32_retcode.get();
        if (QLog.isColorLevel()) {
          QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.errorCode:" + i);
        }
        if (i != 0) {
          continue;
        }
        rkw.a(this.a, localbete.f);
        if (paramMessage.bytes_download_url.has()) {
          rkw.b(this.a, paramMessage.bytes_download_url.get().toStringUtf8());
        }
        if (paramMessage.bytes_file_name.has()) {
          rkw.c(this.a, paramMessage.bytes_file_name.get().toStringUtf8());
        }
        if ((TextUtils.isEmpty(rkw.c(this.a))) || (TextUtils.isEmpty(rkw.d(this.a)))) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(rkw.e(this.a));
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
        rkw.a(this.a, 1004, null, null, null);
        rkw.a(this.a, null);
        return;
      }
      if (i == 0) {
        continue;
      }
      rkw.a(this.a, 0, rkw.e(this.a), rkw.c(this.a), rkw.d(this.a));
      return;
      if ((QLog.isColorLevel()) && (paramMessage.bytes_msg.has())) {
        QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.error info:" + paramMessage.bytes_msg.get().toStringUtf8());
      }
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send error:" + localbete.g);
    }
    rkw.a(this.a, 1004, null, null, null);
    rkw.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkx
 * JD-Core Version:    0.7.0.1
 */