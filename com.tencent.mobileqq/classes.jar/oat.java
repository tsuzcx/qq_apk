import android.os.Message;
import com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;

public class oat
  extends TransProcessorHandler
{
  public oat(CommonPicUploadFragment paramCommonPicUploadFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.b != 24) || (localFileMsg.c != CommonPicUploadFragment.a(this.a, CommonPicUploadFragment.a(this.a)))) {}
    do
    {
      do
      {
        return;
      } while (localFileMsg.f.equals(CommonPicUploadFragment.b(this.a)));
      switch (paramMessage.what)
      {
      case 1004: 
      default: 
        return;
      case 1003: 
        if (QLog.isColorLevel()) {
          QLog.d("CommonPicUploadFragment", 2, "mPicTransProcessorHandler send finished!" + CommonPicUploadFragment.a(this.a));
        }
        break;
      }
    } while (CommonPicUploadFragment.a(this.a));
    paramMessage = new Bdh_extinfo.UploadPicExtInfo();
    try
    {
      paramMessage.mergeFrom(localFileMsg.a, 0, localFileMsg.a.length);
      CommonPicUploadFragment.a(this.a, true);
      CommonPicUploadFragment.b(this.a, localFileMsg.f);
      CommonPicUploadFragment.c(this.a, paramMessage.bytes_file_resid.get().toStringUtf8());
      CommonPicUploadFragment.d(this.a, paramMessage.bytes_download_url.get().toStringUtf8());
      if (QLog.isColorLevel()) {
        QLog.d("CommonPicUploadFragment", 2, "mPicTransProcessorHandler mUuid=" + CommonPicUploadFragment.c(this.a) + ", mPicMd5=" + CommonPicUploadFragment.b(this.a) + ", mPicUrl=" + CommonPicUploadFragment.d(this.a));
      }
      CommonPicUploadFragment.a(this.a).sendEmptyMessage(1005);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CommonPicUploadFragment", 2, "mPicTransProcessorHandler send error:" + localFileMsg.g);
    }
    CommonPicUploadFragment.a(this.a).sendEmptyMessage(1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oat
 * JD-Core Version:    0.7.0.1
 */