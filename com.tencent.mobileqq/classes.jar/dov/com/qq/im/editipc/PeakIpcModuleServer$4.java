package dov.com.qq.im.editipc;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import dov.com.qq.im.ae.util.AEQLog;

class PeakIpcModuleServer$4
  extends TransProcessorHandler
{
  PeakIpcModuleServer$4(PeakIpcModuleServer paramPeakIpcModuleServer, ITransFileController paramITransFileController, String paramString) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24)) {}
    while (localFileMsg.commandId != 82) {
      return;
    }
    Bundle localBundle = new Bundle();
    AEQLog.a("PeakIpcModuleServer", "uploadVideo--transProcessorHandler--handleMessage: what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    case 1006: 
    case 1007: 
    default: 
      return;
    case 1002: 
      localBundle.putInt("key_upload_ark_video_progress", (int)(1.0D * localFileMsg.transferedSize / localFileMsg.fileSize * 100.0D));
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", this.jdField_a_of_type_JavaLangString, "action_upload_ark_video_progress_update", localBundle, null);
      return;
    case 1003: 
    case 1008: 
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.removeHandle(this);
      paramMessage = new Bdh_extinfo.UploadPicExtInfo();
      for (;;)
      {
        try
        {
          paramMessage.mergeFrom(localFileMsg.bdhExtendInfo);
          paramMessage = paramMessage.bytes_download_url.get().toStringUtf8();
          AEQLog.a("PeakIpcModuleServer", "uploadVideo--transProcessorHandler--parse downUrl error:", localInvalidProtocolBufferMicroException1);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          try
          {
            AEQLog.b("PeakIpcModuleServer", "uploadVideo--transProcessorHandler--handleMessage: videoDownloadUrl=" + paramMessage);
            if (TextUtils.isEmpty(paramMessage)) {
              break;
            }
            localBundle.putString("key_upload_ark_video_download_url", paramMessage);
            QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", this.jdField_a_of_type_JavaLangString, "action_upload_ark_video_success", localBundle, null);
            return;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            break label250;
          }
          localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
          paramMessage = null;
        }
      }
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", this.jdField_a_of_type_JavaLangString, "action_upload_ark_video_fail", localBundle, null);
      return;
    case 1005: 
      label250:
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.removeHandle(this);
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", this.jdField_a_of_type_JavaLangString, "action_upload_ark_video_fail", localBundle, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.removeHandle(this);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", this.jdField_a_of_type_JavaLangString, "action_upload_ark_video_cancel", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleServer.4
 * JD-Core Version:    0.7.0.1
 */