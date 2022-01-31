import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.FileUploadController.FileUploadListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

public class lyp
  extends TransProcessorHandler
{
  public lyp(VideoUploadController paramVideoUploadController) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.jdField_b_of_type_Int != 24) || (localFileMsg.c != 54)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((VideoUploadController.a(this.a) != null) && (VideoUploadController.a(this.a).jdField_a_of_type_Long != localFileMsg.jdField_b_of_type_Long));
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1001: 
          VideoUploadController.a(this.a, System.currentTimeMillis());
        }
      } while (this.a.a == null);
      this.a.a.a();
      return;
    } while (this.a.a == null);
    this.a.a.a((float)localFileMsg.e * 100.0F / (float)localFileMsg.jdField_a_of_type_Long);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finished!");
    }
    paramMessage = new bigFileUpload.BigFileExtRsp();
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom(localFileMsg.jdField_a_of_type_ArrayOfByte);
        i = paramMessage.int32_retcode.get();
        if (QLog.isColorLevel()) {
          QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.errorCode:" + i);
        }
        if (i != 0) {
          continue;
        }
        VideoUploadController.a(this.a, localFileMsg.f);
        if (paramMessage.bytes_download_url.has()) {
          VideoUploadController.b(this.a, paramMessage.bytes_download_url.get().toStringUtf8());
        }
        if (paramMessage.bytes_file_name.has()) {
          VideoUploadController.c(this.a, paramMessage.bytes_file_name.get().toStringUtf8());
        }
        if ((TextUtils.isEmpty(VideoUploadController.c(this.a))) || (TextUtils.isEmpty(VideoUploadController.d(this.a)))) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(VideoUploadController.e(this.a));
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
        VideoUploadController.a(this.a, 1004, null, null, null);
        VideoUploadController.a(this.a, null);
        return;
      }
      if (i == 0) {
        continue;
      }
      VideoUploadController.a(this.a, 0, VideoUploadController.e(this.a), VideoUploadController.c(this.a), VideoUploadController.d(this.a));
      return;
      if ((QLog.isColorLevel()) && (paramMessage.bytes_msg.has())) {
        QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler rsp.error info:" + paramMessage.bytes_msg.get().toStringUtf8());
      }
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send error:" + localFileMsg.g);
    }
    VideoUploadController.a(this.a, 1004, null, null, null);
    VideoUploadController.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyp
 * JD-Core Version:    0.7.0.1
 */